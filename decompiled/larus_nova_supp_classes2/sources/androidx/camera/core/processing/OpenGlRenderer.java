package androidx.camera.core.processing;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.Logger;
import androidx.camera.core.processing.util.GLUtils;
import androidx.camera.core.processing.util.GraphicDeviceInfo;
import androidx.camera.core.processing.util.OutputSurface;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class OpenGlRenderer {
    private static final String TAG = "OpenGlRenderer";
    protected GLUtils.InputFormat mCurrentInputformat;
    protected GLUtils.Program2D mCurrentProgram;
    protected Surface mCurrentSurface;
    protected EGLConfig mEglConfig;
    protected EGLContext mEglContext;
    protected EGLDisplay mEglDisplay;
    private int mExternalTextureId;
    protected Thread mGlThread;
    protected final AtomicBoolean mInitialized;
    protected final Map<Surface, OutputSurface> mOutputSurfaceMap;
    protected Map<GLUtils.InputFormat, GLUtils.Program2D> mProgramHandles;
    protected int[] mSurfaceAttrib;
    protected EGLSurface mTempSurface;

    private void createTempSurface() {
        EGLDisplay r0 = this.mEglDisplay;
        EGLConfig r1 = this.mEglConfig;
        Objects.requireNonNull(r1);
        this.mTempSurface = GLUtils.createPBufferSurface(r0, r1, 1, 1);
    }

    private void releaseInternal() {
        Iterator<GLUtils.Program2D> r0 = this.mProgramHandles.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().delete();
        goto L4
    L6:
        this.mProgramHandles = Collections.emptyMap();
        this.mCurrentProgram = null;
        if (Objects.equals(this.mEglDisplay, EGL14.EGL_NO_DISPLAY) == true) goto L23;
        EGLDisplay r1 = this.mEglDisplay;
        EGLSurface r2 = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(r1, r2, r2, EGL14.EGL_NO_CONTEXT);
        Iterator<OutputSurface> r3 = this.mOutputSurfaceMap.values().iterator();
    L10:
        if (r3.hasNext() == false) goto L16;
        OutputSurface r4 = r3.next();
        if (Objects.equals(r4.getEglSurface(), EGL14.EGL_NO_SURFACE) == true) goto L10;
        if (EGL14.eglDestroySurface(this.mEglDisplay, r4.getEglSurface()) == true) goto L10;
        GLUtils.checkEglErrorOrLog("eglDestroySurface");
        goto L10
    L16:
        this.mOutputSurfaceMap.clear();
        if (Objects.equals(this.mTempSurface, EGL14.EGL_NO_SURFACE) == true) goto L20;
        EGL14.eglDestroySurface(this.mEglDisplay, this.mTempSurface);
        this.mTempSurface = EGL14.EGL_NO_SURFACE;
    L20:
        if (Objects.equals(this.mEglContext, EGL14.EGL_NO_CONTEXT) == true) goto L22;
        EGL14.eglDestroyContext(this.mEglDisplay, this.mEglContext);
        this.mEglContext = EGL14.EGL_NO_CONTEXT;
    L22:
        EGL14.eglReleaseThread();
        EGL14.eglTerminate(this.mEglDisplay);
        this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
    L23:
        this.mEglConfig = null;
        this.mExternalTextureId = -1;
        this.mCurrentInputformat = GLUtils.InputFormat.UNKNOWN;
        this.mCurrentSurface = null;
        this.mGlThread = null;
    }

    public int getTextureName() {
        GLUtils.checkInitializedOrThrow(this.mInitialized, true);
        GLUtils.checkGlThreadOrThrow(this.mGlThread);
        return this.mExternalTextureId;
    }

    public void release() {
        if (this.mInitialized.getAndSet(false) == true) goto L5;
        return;
    L5:
        GLUtils.checkGlThreadOrThrow(this.mGlThread);
        releaseInternal();
    }

    public OpenGlRenderer() {
        this.mInitialized = new AtomicBoolean(false);
        this.mOutputSurfaceMap = new HashMap();
        this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEglContext = EGL14.EGL_NO_CONTEXT;
        this.mSurfaceAttrib = GLUtils.EMPTY_ATTRIBS;
        this.mTempSurface = EGL14.EGL_NO_SURFACE;
        this.mProgramHandles = Collections.emptyMap();
        this.mCurrentProgram = null;
        this.mCurrentInputformat = GLUtils.InputFormat.UNKNOWN;
        this.mExternalTextureId = -1;
    }

    private void activateExternalTexture(int r2) {
        GLES20.glActiveTexture(33984);
        GLUtils.checkGlErrorOrThrow("glActiveTexture");
        GLES20.glBindTexture(36197, r2);
        GLUtils.checkGlErrorOrThrow("glBindTexture");
    }

    private Pair<String, String> getExtensionsBeforeInitialized(DynamicRange r5) {
        GLUtils.checkInitializedOrThrow(this.mInitialized, false);
        createEglContext(r5, null);     // Catch: Throwable -> L13 IllegalStateException -> L15
        createTempSurface();     // Catch: Throwable -> L13 IllegalStateException -> L15
        makeCurrent(this.mTempSurface);     // Catch: Throwable -> L13 IllegalStateException -> L15
        String r6 = GLES20.glGetString(7939);     // Catch: Throwable -> L13 IllegalStateException -> L15
        String r2 = EGL14.eglQueryString(this.mEglDisplay, 12373);     // Catch: Throwable -> L13 IllegalStateException -> L15
        if (r6 != null) goto L7;
        r6 = "";
    L7:
        if (r2 != null) goto L10;
        r2 = "";
    L10:
        Pair<String, String> r3 = new Pair(r6, r2);     // Catch: Throwable -> L13 IllegalStateException -> L15
        releaseInternal();
        return r3;
    L13:
        th = move-exception;
        releaseInternal();
        throw th;
    L15:
        e = move-exception;
        Logger.w(TAG, "Failed to get GL or EGL extensions: " + e.getMessage(), e);     // Catch: Throwable -> L13
        Pair<String, String> r7 = new Pair("", "");     // Catch: Throwable -> L13
        releaseInternal();
        return r7;
    }

    public OutputSurface createOutputSurfaceInternal(Surface r4) {
        EGLDisplay r0 = this.mEglDisplay;     // Catch: Throwable -> L5 IllegalStateException -> L7
        EGLConfig r1 = this.mEglConfig;     // Catch: Throwable -> L5 IllegalStateException -> L7
        Objects.requireNonNull(r1);     // Catch: Throwable -> L5 IllegalStateException -> L7
        EGLConfig r2 = r1;     // Catch: Throwable -> L5 IllegalStateException -> L7
        EGLSurface r5 = GLUtils.createWindowSurface(r0, r1, r4, this.mSurfaceAttrib);     // Catch: Throwable -> L5 IllegalStateException -> L7
        Size r3 = GLUtils.getSurfaceSize(this.mEglDisplay, r5);
        return OutputSurface.of(r5, r3.getWidth(), r3.getHeight());
    L5:
        e = move-exception;
        Logger.w(TAG, "Failed to create EGL surface: " + e.getMessage(), e);
        return null;
    }

    public OutputSurface getOutSurfaceOrThrow(Surface r3) {
        Preconditions.checkState(this.mOutputSurfaceMap.containsKey(r3), "The surface is not registered.");
        OutputSurface r4 = this.mOutputSurfaceMap.get(r3);
        Objects.requireNonNull(r4);
        return r4;
    }

    public GraphicDeviceInfo init(DynamicRange r2) {
        return init(r2, Collections.emptyMap());
    }

    public void makeCurrent(EGLSurface r3) {
        Preconditions.checkNotNull(this.mEglDisplay);
        Preconditions.checkNotNull(this.mEglContext);
        if (EGL14.eglMakeCurrent(this.mEglDisplay, r3, r3, this.mEglContext) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("eglMakeCurrent failed");
    }

    public void registerOutputSurface(Surface r3) {
        GLUtils.checkInitializedOrThrow(this.mInitialized, true);
        GLUtils.checkGlThreadOrThrow(this.mGlThread);
        if (this.mOutputSurfaceMap.containsKey(r3) == true) goto L6;
        this.mOutputSurfaceMap.put(r3, GLUtils.NO_OUTPUT_SURFACE);
        return;
    }

    public void setInputFormat(GLUtils.InputFormat r3) {
        GLUtils.checkInitializedOrThrow(this.mInitialized, true);
        GLUtils.checkGlThreadOrThrow(this.mGlThread);
        if (this.mCurrentInputformat == r3) goto L6;
        this.mCurrentInputformat = r3;
        useAndConfigureProgramWithTexture(this.mExternalTextureId);
        return;
    }

    public void unregisterOutputSurface(Surface r3) {
        GLUtils.checkInitializedOrThrow(this.mInitialized, true);
        GLUtils.checkGlThreadOrThrow(this.mGlThread);
        removeOutputSurfaceInternal(r3, true);
    }

    public void useAndConfigureProgramWithTexture(int r3) {
        GLUtils.Program2D r0 = this.mProgramHandles.get(this.mCurrentInputformat);
        if (r0 == null) goto L10;
        if (this.mCurrentProgram == r0) goto L7;
        this.mCurrentProgram = r0;
        r0.use();
        Objects.toString(this.mCurrentInputformat);
        Objects.toString(this.mCurrentProgram);
    L7:
        activateExternalTexture(r3);
        return;
    L10:
        throw new IllegalStateException("Unable to configure program for input format: " + this.mCurrentInputformat);
    }

    private void createEglContext(DynamicRange r21, GraphicDeviceInfo.Builder r22) {
        EGLDisplay r3 = EGL14.eglGetDisplay(0);
        this.mEglDisplay = r3;
        if (Objects.equals(r3, EGL14.EGL_NO_DISPLAY) == true) goto L37;
        int[] r4 = new int[2];
        if (EGL14.eglInitialize(this.mEglDisplay, r4, 0, r4, 1) == false) goto L34;
        if (r22 == null) goto L9;
        r22.setEglVersion(r4[0] + "." + r4[1]);
    L9:
        if (r21.is10BitHdr() == false) goto L11;
        int r1 = 10;
    L13:
        if (r21.is10BitHdr() == false) goto L15;
        int r7 = 2;
    L17:
        if (r21.is10BitHdr() == false) goto L19;
        int r8 = 64;
    L21:
        if (r21.is10BitHdr() == false) goto L23;
        int r10 = -1;
    L24:
        int r11 = 3;
        int[] r13 = {12324, r1, 12323, r1, 12322, r1, 12321, r7, 12325, 0, 12326, 0, 12352, r8, 12610, r10, 12339, 5, 12344};
        EGLConfig[] r2 = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.mEglDisplay, r13, 0, r2, 0, 1, new int[1], 0) == false) goto L33;
        EGLConfig r5 = r2[0];
        int[] r6 = new int[3];
        r6[0] = 12440;
        if (r21.is10BitHdr() == true) goto L30;
        r11 = 2;
    L30:
        r6[1] = r11;
        r6[2] = 12344;
        EGLContext r9 = EGL14.eglCreateContext(this.mEglDisplay, r5, EGL14.EGL_NO_CONTEXT, r6, 0);
        GLUtils.checkEglErrorOrThrow("eglCreateContext");
        this.mEglConfig = r5;
        this.mEglContext = r9;
        EGL14.eglQueryContext(this.mEglDisplay, r9, 12440, new int[1], 0);
        return;
    L33:
        throw new IllegalStateException("Unable to find a suitable EGLConfig");
    L23:
        r10 = 1;
        goto L24
    L19:
        r8 = 4;
        goto L21
    L15:
        r7 = 8;
        goto L17
    L11:
        r1 = 8;
        goto L13
    L34:
        this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
        throw new IllegalStateException("Unable to initialize EGL14");
    L37:
        throw new IllegalStateException("Unable to get EGL14 display");
    }

    public GraphicDeviceInfo init(DynamicRange r5, Map<GLUtils.InputFormat, ShaderProvider> r6) {
        GLUtils.checkInitializedOrThrow(this.mInitialized, false);
        GraphicDeviceInfo.Builder r0 = GraphicDeviceInfo.builder();
    L14:
        e = move-exception;
        releaseInternal();
        throw e;
    L4:
        if (r5.is10BitHdr() == false) goto L9;
        Pair<String, String> r1 = getExtensionsBeforeInitialized(r5);     // Catch: IllegalArgumentException -> L12 Throwable -> L14
        String r2 = (String) Preconditions.checkNotNull((String) r1.first);     // Catch: IllegalArgumentException -> L12 Throwable -> L14
        String r3 = (String) Preconditions.checkNotNull((String) r1.second);     // Catch: IllegalArgumentException -> L12 Throwable -> L14
        if (r2.contains("GL_EXT_YUV_target") == true) goto L8;
        Logger.w(TAG, "Device does not support GL_EXT_YUV_target. Fallback to SDR.");     // Catch: IllegalArgumentException -> L12 Throwable -> L14
        r5 = DynamicRange.SDR;     // Catch: IllegalArgumentException -> L12 Throwable -> L14
    L8:
        this.mSurfaceAttrib = GLUtils.chooseSurfaceAttrib(r3, r5);     // Catch: IllegalArgumentException -> L12 Throwable -> L14
        r0.setGlExtensions(r2);     // Catch: IllegalArgumentException -> L12 Throwable -> L14
        r0.setEglExtensions(r3);     // Catch: IllegalArgumentException -> L12 Throwable -> L14
    L9:
        createEglContext(r5, r0);     // Catch: IllegalArgumentException -> L12 Throwable -> L14
        createTempSurface();     // Catch: IllegalArgumentException -> L12 Throwable -> L14
        makeCurrent(this.mTempSurface);     // Catch: IllegalArgumentException -> L12 Throwable -> L14
        r0.setGlVersion(GLUtils.getGlVersionNumber());     // Catch: IllegalArgumentException -> L12 Throwable -> L14
        this.mProgramHandles = GLUtils.createPrograms(r5, r6);     // Catch: IllegalArgumentException -> L12 Throwable -> L14
        int r7 = GLUtils.createTexture();     // Catch: IllegalArgumentException -> L12 Throwable -> L14
        this.mExternalTextureId = r7;     // Catch: IllegalArgumentException -> L12 Throwable -> L14
        useAndConfigureProgramWithTexture(r7);     // Catch: IllegalArgumentException -> L12 Throwable -> L14
        this.mGlThread = ThreadMethodProxy.currentThread();
        this.mInitialized.set(true);
        return r0.build();
    }

    public void removeOutputSurfaceInternal(Surface r2, boolean r3) {
        if (this.mCurrentSurface != r2) goto L5;
        this.mCurrentSurface = null;
        makeCurrent(this.mTempSurface);
    L5:
        if (r3 == false) goto L7;
        OutputSurface r4 = this.mOutputSurfaceMap.remove(r2);
    L8:
        if (r4 != null) goto L10;
        return;
    L10:
        if (r4 == GLUtils.NO_OUTPUT_SURFACE) goto L19;
        EGL14.eglDestroySurface(this.mEglDisplay, r4.getEglSurface());     // Catch: RuntimeException -> L13
        return;
    L13:
        e = move-exception;
        Logger.w(TAG, "Failed to destroy EGL surface: " + e.getMessage(), e);
        return;
    L19:
        return;
    L7:
        r4 = this.mOutputSurfaceMap.put(r2, GLUtils.NO_OUTPUT_SURFACE);
        goto L8
    }

    public Bitmap snapshot(Size r4, float[] r5) {
        ByteBuffer r0 = ByteBuffer.allocateDirect((r4.getWidth() * r4.getHeight()) * 4);
        snapshot(r0, r4, r5);
        Bitmap r6 = Bitmap.createBitmap(r4.getWidth(), r4.getHeight(), Bitmap.Config.ARGB_8888);
        r0.rewind();
        ImageProcessingUtil.copyByteBufferToBitmap(r6, r0, r4.getWidth() * 4);
        return r6;
    }

    private void snapshot(ByteBuffer r17, Size r18, float[] r19) {
        if (r17.capacity() != ((r18.getWidth() * r18.getHeight()) * 4)) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1, "ByteBuffer capacity is not equal to width * height * 4.");
        Preconditions.checkArgument(r17.isDirect(), "ByteBuffer is not direct.");
        int r2 = GLUtils.generateTexture();
        GLES20.glActiveTexture(33985);
        GLUtils.checkGlErrorOrThrow("glActiveTexture");
        GLES20.glBindTexture(3553, r2);
        GLUtils.checkGlErrorOrThrow("glBindTexture");
        GLES20.glTexImage2D(3553, 0, 6407, r18.getWidth(), r18.getHeight(), 0, 6407, 5121, null);
        GLUtils.checkGlErrorOrThrow("glTexImage2D");
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        int r7 = GLUtils.generateFbo();
        GLES20.glBindFramebuffer(36160, r7);
        GLUtils.checkGlErrorOrThrow("glBindFramebuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, r2, 0);
        GLUtils.checkGlErrorOrThrow("glFramebufferTexture2D");
        GLES20.glActiveTexture(33984);
        GLUtils.checkGlErrorOrThrow("glActiveTexture");
        GLES20.glBindTexture(36197, this.mExternalTextureId);
        GLUtils.checkGlErrorOrThrow("glBindTexture");
        this.mCurrentSurface = null;
        GLES20.glViewport(0, 0, r18.getWidth(), r18.getHeight());
        GLES20.glScissor(0, 0, r18.getWidth(), r18.getHeight());
        GLUtils.Program2D r3 = (GLUtils.Program2D) Preconditions.checkNotNull(this.mCurrentProgram);
        if ((r3 instanceof GLUtils.SamplerShaderProgram) == false) goto L9;
        ((GLUtils.SamplerShaderProgram) r3).updateTextureMatrix(r19);
    L9:
        GLES20.glDrawArrays(5, 0, 4);
        GLUtils.checkGlErrorOrThrow("glDrawArrays");
        GLES20.glReadPixels(0, 0, r18.getWidth(), r18.getHeight(), 6408, 5121, r17);
        GLUtils.checkGlErrorOrThrow("glReadPixels");
        GLES20.glBindFramebuffer(36160, 0);
        GLUtils.deleteTexture(r2);
        GLUtils.deleteFbo(r7);
        activateExternalTexture(this.mExternalTextureId);
        return;
    L5:
        r1 = false;
        goto L6
    }

    public void render(long r5, float[] r7, Surface r8) {
        GLUtils.checkInitializedOrThrow(this.mInitialized, true);
        GLUtils.checkGlThreadOrThrow(this.mGlThread);
        OutputSurface r0 = getOutSurfaceOrThrow(r8);
        if (r0 != GLUtils.NO_OUTPUT_SURFACE) goto L9;
        r0 = createOutputSurfaceInternal(r8);
        if (r0 != null) goto L7;
        return;
    L7:
        this.mOutputSurfaceMap.put(r8, r0);
    L9:
        if (r8 == this.mCurrentSurface) goto L11;
        makeCurrent(r0.getEglSurface());
        this.mCurrentSurface = r8;
        GLES20.glViewport(0, 0, r0.getWidth(), r0.getHeight());
        GLES20.glScissor(0, 0, r0.getWidth(), r0.getHeight());
    L11:
        GLUtils.Program2D r1 = (GLUtils.Program2D) Preconditions.checkNotNull(this.mCurrentProgram);
        if ((r1 instanceof GLUtils.SamplerShaderProgram) == false) goto L14;
        ((GLUtils.SamplerShaderProgram) r1).updateTextureMatrix(r7);
    L14:
        GLES20.glDrawArrays(5, 0, 4);
        GLUtils.checkGlErrorOrThrow("glDrawArrays");
        EGLExt.eglPresentationTimeANDROID(this.mEglDisplay, r0.getEglSurface(), r5);
        if (EGL14.eglSwapBuffers(this.mEglDisplay, r0.getEglSurface()) == true) goto L18;
        Logger.w(TAG, "Failed to swap buffers with EGL error: 0x" + Integer.toHexString(EGL14.eglGetError()));
        removeOutputSurfaceInternal(r8, false);
        return;
    }
}
