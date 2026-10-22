package com.ss.texturerender.effect;

import android.opengl.GLES20;
import android.os.Bundle;
import androidx.camera.core.processing.util.GLUtils;
import com.ss.texturerender.ShaderHelper;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.VideoSurfaceTexture;

/* JADX INFO: loaded from: classes40.dex */
public class GLOesTo2DFilter extends GLDefaultFilter {
    private int mGLMajorVersion;
    private int mGLMinorVersion;
    private int mInTexHeight;
    private int mInTexWidth;
    private int mProgram300;
    private int[] mProgram300Handles;
    private int[] mProgramHandles;
    private float[] mSTMatrix;
    private boolean mUseProgram300;
    private int muSTMatrixHandle;
    private final String oesFragmentShader;
    private final String oesFragmentShader300;
    private final String oesVertexShader;
    private final String oesVertexShader300;

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int onDrawFrameAfter() {
        if (this.mUseProgram300 == false) goto L7;
        int[] r100 = this.mProgramHandles;
        if (r100 == null) goto L7;
        this.mProgram = r100[0];
        this.muSTMatrixHandle = r100[1];
        this.maPositionHandle = r100[2];
        this.maTextureHandle = r100[3];
        this.mInputTextureHandle = r100[4];
    L7:
        this.mUseProgram300 = false;
        return 0;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int onDrawFrameBefore() {
        this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
        GLES20.glUniformMatrix4fv(this.muSTMatrixHandle, 1, false, this.mSTMatrix, 0);
        if (this.mUseProgram300 == false) goto L7;
        int[] r100 = this.mProgram300Handles;
        if (r100 == null) goto L7;
        GLES20.glUniform1i(r100[5], this.mInTexWidth);
        GLES20.glUniform1i(this.mProgram300Handles[6], this.mInTexHeight);
    L7:
        return 0;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        if (this.mProgram300 <= 0) goto L5;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "delete program300, filter:" + this.mEffectType);
        GLES20.glDeleteProgram(this.mProgram300);
    L5:
        this.mProgram300 = 0;
        return super.release();
    }

    public GLOesTo2DFilter(int r100) {
        super(r100, 3);
        this.oesVertexShader = "uniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
        this.oesFragmentShader = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
        this.oesVertexShader300 = "#version 300 es\nuniform mat4 uSTMatrix;\nin vec4 aPosition;\nin vec4 aTextureCoord;\nout vec2 vTextureCoord;\nvoid main() {\n  gl_Position = aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
        this.oesFragmentShader300 = "#version 300 es\n#extension GL_OES_EGL_image_external_essl3 : enable\nprecision highp float;\nin vec2 vTextureCoord;\nuniform int uImageWidth;\nuniform int uImageHeight;\nuniform samplerExternalOES sTexture;\nout vec4 fragColor;\nvoid main() {\n  highp int x = int(vTextureCoord.x * float(uImageWidth));\n  highp int y = int(vTextureCoord.y * float(uImageHeight));\n  fragColor = texelFetch(sTexture, ivec2(x, y), 0);\n}\n";
        this.mGLMajorVersion = 2;
        this.mGLMinorVersion = 0;
        this.mSTMatrix = new float[16];
        this.mUseProgram300 = false;
        this.mProgram300 = 0;
        this.mProgram300Handles = null;
        this.mProgramHandles = null;
        this.mInTexWidth = -1;
        this.mInTexHeight = -1;
        this.mInTextureTarget = 36197;
        this.mOrder = 100;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "new GLOesTo2DFilter");
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public String getStringOption(int r100) {
        if (r100 != 11000) goto L5;
        return "uniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
    L5:
        if (r100 != 11001) goto L7;
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    L7:
        return super.getStringOption(r100);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public int init(Bundle r110) {
        if (r110 == null) goto L6;
        this.mGLMajorVersion = r110.getInt(TextureRenderKeys.KEY_IS_GL_MAJOR_VERSION, 2);
        this.mGLMinorVersion = r110.getInt(TextureRenderKeys.KEY_IS_GL_MINOR_VERSION, 0);
    L6:
        if (super.init(r110) == 0) goto L11;
        VideoSurfaceTexture r111 = this.mSurfaceTexture;
        if (r111 == null) goto L10;
        r111.notifyInitError(10, this.mEffectType, "super.init(bundle) != TR_OK");
    L10:
        return -1;
    L11:
        int r100 = GLES20.glGetUniformLocation(this.mProgram, "uSTMatrix");
        this.muSTMatrixHandle = r100;
        this.mProgramHandles = new int[]{this.mProgram, r100, this.maPositionHandle, this.maTextureHandle, this.mInputTextureHandle};
        if (this.mGLMajorVersion < 3) goto L28;
        int r101 = ShaderHelper.compileShader(35633, "#version 300 es\nuniform mat4 uSTMatrix;\nin vec4 aPosition;\nin vec4 aTextureCoord;\nout vec2 vTextureCoord;\nvoid main() {\n  gl_Position = aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n");
        int r102 = ShaderHelper.compileShader(35632, "#version 300 es\n#extension GL_OES_EGL_image_external_essl3 : enable\nprecision highp float;\nin vec2 vTextureCoord;\nuniform int uImageWidth;\nuniform int uImageHeight;\nuniform samplerExternalOES sTexture;\nout vec4 fragColor;\nvoid main() {\n  highp int x = int(vTextureCoord.x * float(uImageWidth));\n  highp int y = int(vTextureCoord.y * float(uImageHeight));\n  fragColor = texelFetch(sTexture, ivec2(x, y), 0);\n}\n");
        if (r101 == 0) goto L24;
        if (r102 == 0) goto L24;
        int r103 = ShaderHelper.createAndLinkProgram(r101, r102, null);
        this.mProgram300 = r103;
        if (r103 != 0) goto L23;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "create program300 error, filter:" + this.mEffectType);
        this.mGLError = -1;
        VideoSurfaceTexture r112 = this.mSurfaceTexture;
        if (r112 == null) goto L22;
        r112.notifyInitError(9, this.mEffectType, "create program300 error");
    L22:
        return -1;
    L23:
        this.mProgram300Handles = new int[]{this.mProgram300, GLES20.glGetUniformLocation(r103, "uSTMatrix"), GLES20.glGetAttribLocation(this.mProgram300, "aPosition"), GLES20.glGetAttribLocation(this.mProgram300, "aTextureCoord"), GLES20.glGetUniformLocation(this.mProgram300, GLUtils.VAR_TEXTURE), GLES20.glGetUniformLocation(this.mProgram300, "uImageWidth"), GLES20.glGetUniformLocation(this.mProgram300, "uImageHeight")};
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "create program300  success, filter:" + this.mEffectType);
    L24:
        this.mGLError = -1;
        VideoSurfaceTexture r113 = this.mSurfaceTexture;
        if (r113 == null) goto L27;
        r113.notifyInitError(8, this.mEffectType, "compile shader300 error");
    L27:
        return -1;
    L28:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "init");
        setOption(r110);
        return 0;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int onPrepareDrawFrame(EffectTexture r100) {
        int[] r101 = this.mProgramHandles;
        if (r101 != null) goto L6;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "check program failed, filter:" + this.mEffectType);
        return -1;
    L6:
        this.mUseProgram300 = false;
        if (this.mDoClip == true) goto L9;
    L20:
        this.mProgram = r101[0];
        this.muSTMatrixHandle = r101[1];
        this.maPositionHandle = r101[2];
        this.maTextureHandle = r101[3];
        this.mInputTextureHandle = r101[4];
        this.mInTexWidth = r100.getWidth();
        this.mInTexHeight = r100.getHeight();
        return 0;
    L9:
        if (r100.getRect() == null) goto L20;
        if (this.mProgram300 == 0) goto L18;
        r101 = this.mProgram300Handles;
        if (r101 == null) goto L18;
        this.mUseProgram300 = true;
        VideoSurfaceTexture r102 = this.mSurfaceTexture;
        if (r102 == null) goto L20;
        r102.getEventLogger().setUseTexelFetch(1);
    L18:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "switch program300 failed, filter:" + this.mEffectType);
        this.mGLError = -1;
        return -1;
    }
}
