package androidx.camera.core.processing.concurrent;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLExt;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.Matrix;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.LayoutSettings;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.processing.OpenGlRenderer;
import androidx.camera.core.processing.ShaderProvider;
import androidx.camera.core.processing.util.GLUtils;
import androidx.camera.core.processing.util.GraphicDeviceInfo;
import androidx.camera.core.processing.util.OutputSurface;
import androidx.compose.material3.MenuKt;
import androidx.core.util.Preconditions;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class DualOpenGlRenderer extends OpenGlRenderer {
    private static final String TAG = "DualOpenGlRenderer";
    private int mPrimaryExternalTextureId;
    private final LayoutSettings mPrimaryLayoutSettings;
    private int mSecondaryExternalTextureId;
    private final LayoutSettings mSecondaryLayoutSettings;

    @Override // androidx.camera.core.processing.OpenGlRenderer
    public void release() {
        super.release();
        this.mPrimaryExternalTextureId = -1;
        this.mSecondaryExternalTextureId = -1;
    }

    public int getTextureName(boolean r3) {
        GLUtils.checkInitializedOrThrow(this.mInitialized, true);
        GLUtils.checkGlThreadOrThrow(this.mGlThread);
        if (r3 == false) goto L6;
        return this.mPrimaryExternalTextureId;
    L6:
        return this.mSecondaryExternalTextureId;
    }

    public DualOpenGlRenderer(LayoutSettings r2, LayoutSettings r3) {
        this.mPrimaryExternalTextureId = -1;
        this.mSecondaryExternalTextureId = -1;
        this.mPrimaryLayoutSettings = r2;
        this.mSecondaryLayoutSettings = r3;
    }

    @Override // androidx.camera.core.processing.OpenGlRenderer
    public GraphicDeviceInfo init(DynamicRange r1, Map<GLUtils.InputFormat, ShaderProvider> r2) {
        GraphicDeviceInfo r3 = super.init(r1, r2);
        this.mPrimaryExternalTextureId = GLUtils.createTexture();
        this.mSecondaryExternalTextureId = GLUtils.createTexture();
        return r3;
    }

    private static float[] getTransformMatrix(Size r7, Size r8, LayoutSettings r9) {
        float[] r2 = GLUtils.create4x4IdentityMatrix();
        float[] r4 = GLUtils.create4x4IdentityMatrix();
        float[] r6 = GLUtils.create4x4IdentityMatrix();
        Matrix.scaleM(r2, 0, r7.getWidth() / r8.getWidth(), r7.getHeight() / r8.getHeight(), 1.0f);
        Matrix.translateM(r4, 0, r9.getOffsetX() / r9.getWidth(), r9.getOffsetY() / r9.getHeight(), MenuKt.ClosedAlphaTarget);
        Matrix.multiplyMM(r6, 0, r2, 0, r4, 0);
        return r6;
    }

    public void render(long r10, Surface r12, SurfaceOutput r13, SurfaceTexture r14, SurfaceTexture r15) {
        GLUtils.checkInitializedOrThrow(this.mInitialized, true);
        GLUtils.checkGlThreadOrThrow(this.mGlThread);
        OutputSurface r0 = getOutSurfaceOrThrow(r12);
        if (r0 != GLUtils.NO_OUTPUT_SURFACE) goto L9;
        r0 = createOutputSurfaceInternal(r12);
        if (r0 != null) goto L7;
        return;
    L7:
        this.mOutputSurfaceMap.put(r12, r0);
    L9:
        if (r12 == this.mCurrentSurface) goto L11;
        makeCurrent(r0.getEglSurface());
        this.mCurrentSurface = r12;
    L11:
        GLES30.glClearColor(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 1.0f);
        GLES30.glClear(16384);
        OutputSurface r3 = r0;
        renderInternal(r3, r13, r14, this.mPrimaryLayoutSettings, this.mPrimaryExternalTextureId, true);
        renderInternal(r3, r13, r15, this.mSecondaryLayoutSettings, this.mSecondaryExternalTextureId, true);
        EGLExt.eglPresentationTimeANDROID(this.mEglDisplay, r0.getEglSurface(), r10);
        if (EGL14.eglSwapBuffers(this.mEglDisplay, r0.getEglSurface()) == true) goto L15;
        Logger.w(TAG, "Failed to swap buffers with EGL error: 0x" + Integer.toHexString(EGL14.eglGetError()));
        removeOutputSurfaceInternal(r12, false);
        return;
    }

    private void renderInternal(OutputSurface r3, SurfaceOutput r4, SurfaceTexture r5, LayoutSettings r6, int r7, boolean r8) {
        useAndConfigureProgramWithTexture(r7);
        GLES20.glViewport(0, 0, r3.getWidth(), r3.getHeight());
        GLES20.glScissor(0, 0, r3.getWidth(), r3.getHeight());
        float[] r0 = new float[16];
        r5.getTransformMatrix(r0);
        float[] r9 = new float[16];
        r4.updateTransformMatrix(r9, r0, r8);
        GLUtils.Program2D r10 = (GLUtils.Program2D) Preconditions.checkNotNull(this.mCurrentProgram);
        if ((r10 instanceof GLUtils.SamplerShaderProgram) == false) goto L5;
        ((GLUtils.SamplerShaderProgram) r10).updateTextureMatrix(r9);
    L5:
        r10.updateTransformMatrix(getTransformMatrix(new Size((int) (r3.getWidth() * r6.getWidth()), (int) (r3.getHeight() * r6.getHeight())), new Size(r3.getWidth(), r3.getHeight()), r6));
        r10.updateAlpha(r6.getAlpha());
        GLES20.glEnable(3042);
        GLES20.glBlendFuncSeparate(770, 771, 1, 771);
        GLES20.glDrawArrays(5, 0, 4);
        GLUtils.checkGlErrorOrThrow("glDrawArrays");
        GLES20.glDisable(3042);
    }
}
