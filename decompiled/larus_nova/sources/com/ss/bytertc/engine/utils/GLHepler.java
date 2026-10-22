package com.ss.bytertc.engine.utils;

import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Handler;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.GlShader;
import com.bytedance.realx.video.GlUtil;
import com.bytedance.realx.video.VideoFrame;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes40.dex */
public class GLHepler {
    private static final FloatBuffer DEVICE_RECTANGLE = null;
    private static final FloatBuffer TEXTURE_RECTANGLE = null;
    private final String TAG;
    private int frameBufferId;
    private Handler handler;
    private boolean mBInit;
    private EglBase mEglBase;
    private final String mFragmentShader;
    private GlShader mGlShader;
    private final String mVertorShader;
    private boolean released;
    private GlShader shader;
    private VideoFrame.TextureBuffer.Type shaderTextureType;
    private final ThreadUtils.ThreadChecker threadChecker;

    public static /* synthetic */ void a(GLHepler r100, int r101, int r102, int r103, int r104) {
        r100.lambda$deliverToTexture2D$0(r101, r102, r103, r104);
    }

    static {
        DEVICE_RECTANGLE = GlUtil.createFloatBuffer(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
        TEXTURE_RECTANGLE = GlUtil.createFloatBuffer(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});
    }

    public void release() {
        this.threadChecker.checkIsOnValidThread();
        this.released = true;
        GlShader r100 = this.shader;
        if (r100 == null) goto L6;
        r100.release();
        return;
    }

    private void initShader(VideoFrame.TextureBuffer.Type r100) {
        GlShader r101 = this.shader;
        if (r101 == null) goto L6;
        r101.release();
    L6:
        if (this.mBInit == false) goto L8;
        return;
    L8:
        this.mBInit = true;
        this.shaderTextureType = r100;
        GlShader r102 = new GlShader("attribute vec4 vPosition;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){gl_Position = vPosition;\ntextureCoordinate = inputTextureCoordinate;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 textureCoordinate;\nuniform samplerExternalOES s_texture;\nvoid main() {  gl_FragColor = texture2D( s_texture, textureCoordinate );\n}");
        this.shader = r102;
        r102.useProgram();
        GLES20.glUniform1i(this.shader.getUniformLocation("s_texture"), 0);
        GlUtil.checkNoGLES2Error("Initialize fragment shader uniform values.");
        this.shader.setVertexAttribArray("vPosition", 2, DEVICE_RECTANGLE);
        this.shader.setVertexAttribArray("inputTextureCoordinate", 2, TEXTURE_RECTANGLE);
    }

    private GLHepler(EGLContext r100, Handler r101) {
        this.TAG = "GLHepler";
        this.mBInit = false;
        this.frameBufferId = 0;
        this.mVertorShader = "attribute vec4 vPosition;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){gl_Position = vPosition;\ntextureCoordinate = inputTextureCoordinate;\n}\n";
        this.mFragmentShader = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 textureCoordinate;\nuniform samplerExternalOES s_texture;\nvoid main() {  gl_FragColor = texture2D( s_texture, textureCoordinate );\n}";
        ThreadUtils.ThreadChecker r102 = new ThreadUtils.ThreadChecker();
        this.threadChecker = r102;
        this.released = false;
        this.handler = r101;
        EglBase r103 = EglBase.CC.createEgl14(r100, EglBase.CONFIG_PIXEL_BUFFER);
        this.mEglBase = r103;
        r103.createDummyPbufferSurface();     // Catch: RuntimeException -> L6
        this.mEglBase.makeCurrent();     // Catch: RuntimeException -> L6
        int[] r104 = new int[1];
        GLES20.glGenFramebuffers(1, r104, 0);
        this.frameBufferId = r104[0];
        r102.detachThread();
        return;
    L6:
        e = move-exception;
        this.mEglBase.release();
        ThreadMethodProxy.quit(r101.getLooper());
        throw e;
    }

    public static GLHepler create(final String r100, final EGLContext r101) {
        PthreadHandlerThreadV2 r102 = new PthreadHandlerThreadV2(r100);
        ThreadMethodProxy.start(r102);
        final Handler r103 = new Handler(r102.getLooper());
        return (GLHepler) ThreadUtils.invokeAtFrontUninterruptibly(r103, new AnonymousClass1(r101, r103, r100));
    }

    public /* synthetic */ GLHepler(EGLContext r100, Handler r101, AnonymousClass1 r102) {
        this(r100, r101);
    }

    private /* synthetic */ void lambda$deliverToTexture2D$0(int r100, int r101, int r110, int r111) {
        long r102 = System.currentTimeMillis();
        this.threadChecker.checkIsOnValidThread();
        if (this.released == true) goto L10;
        if (this.mBInit == true) goto L7;
        initShader(VideoFrame.TextureBuffer.Type.OES);
        this.shader.useProgram();
        GLES20.glBindFramebuffer(36160, this.frameBufferId);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, r100, 0);
    L7:
        this.shader.useProgram();
        GLES20.glBindFramebuffer(36160, this.frameBufferId);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, r100, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, r101);
        GLES20.glViewport(0, 0, r110, r111);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(36197, 0);
        LogUtil.i("opnngl ToTexture2D", "usetime:" + (System.currentTimeMillis() - r102));
        return;
    L10:
        throw new IllegalStateException("YuvConverter.convert called on released object");
    }

    public void deliverToTexture2D(final int r100, final int r101, final int r110, final int r111, float[] r112) {
        ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new a(this, r111, r110, r100, r101));
    }
}
