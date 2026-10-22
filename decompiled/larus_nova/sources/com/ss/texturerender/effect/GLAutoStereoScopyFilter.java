package com.ss.texturerender.effect;

import android.opengl.GLES20;
import android.os.Bundle;
import com.ss.texturerender.TexGLUtils;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.VideoSurfaceTexture;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes40.dex */
public class GLAutoStereoScopyFilter extends GLDefaultFilter {
    private final String fragmentShader;
    private float[] mAlphaTextureVerticesData;
    private int mOffsetsHandle;
    private float[] mSTMatrix;
    private int mSTMatrixHandle;
    private int mVideoNums;
    private final String oesFragmentShader;
    private final String oesVertexShader;
    private final String vertexShader;

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture r100, FrameBuffer r101) {
        return r100;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public void initParam() {
        FloatBuffer r100 = ByteBuffer.allocateDirect(this.mAlphaTextureVerticesData.length * this.FLOAT_SIZE_BYTES).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mTextureVertices = r100;
        r100.put(this.mAlphaTextureVerticesData).position(0);
        FloatBuffer r101 = ByteBuffer.allocateDirect(GLDefaultFilter.mTriangleVerticesData.length * this.FLOAT_SIZE_BYTES).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mTriangleVertices = r101;
        r101.put(GLDefaultFilter.mTriangleVerticesData).position(0);
    }

    public GLAutoStereoScopyFilter(int r100) {
        super(r100, 22);
        this.vertexShader = "#version 300 es\nin vec4 aPosition;\nin vec4 aTextureCoord;\nout vec2 vTextureCoord;\nvoid main() {\n  gl_Position = aPosition;\n  vTextureCoord = aTextureCoord.xy;\n}";
        this.oesVertexShader = "#version 300 es\nuniform mat4 uSTMatrix;\nin vec4 aPosition;\nin vec4 aTextureCoord;\nout vec2 vTextureCoord;\nvoid main() {\n  gl_Position = aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}";
        this.fragmentShader = "#version 300 es\nprecision mediump float;\nin vec2 vTextureCoord;\nuniform sampler2D sTexture;\nlayout(location = 0) out vec4 outColor0;\nlayout(location = 1) out vec4 outColor1;\nuniform ivec2 offsets;\nvoid main() {\n    ivec2 texSize = textureSize(sTexture, 0);\n    ivec2 leftTexCoord = ivec2(int(vTextureCoord.x * float(texSize.x)), int(vTextureCoord.y * float(texSize.y)));\n    vec4 oriColor = texelFetch(sTexture, leftTexCoord, 0);\n    vec4 alphaColor = texelFetch(sTexture, leftTexCoord + ivec2(offsets.x, 0), 0);\n    outColor0 = vec4(oriColor.rgb, alphaColor.r);\n    outColor1 = texelFetch(sTexture, leftTexCoord + ivec2(offsets.y, 0), 0);\n}";
        this.oesFragmentShader = "#version 300 es\n#extension GL_OES_EGL_image_external_essl3 : require\nprecision mediump float;\nin vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nlayout(location = 0) out vec4 outColor0;\nlayout(location = 1) out vec4 outColor1;\nuniform ivec2 offsets;\nvoid main() {\n    ivec2 texSize = textureSize(sTexture, 0);\n    ivec2 leftTexCoord = ivec2(int(vTextureCoord.x * float(texSize.x)), int(vTextureCoord.y * float(texSize.y)));\n    vec4 oriColor = texelFetch(sTexture, leftTexCoord, 0);\n    vec4 alphaColor = texelFetch(sTexture, leftTexCoord + ivec2(offsets.x,0), 0);\n    outColor0 = vec4(oriColor.rgb, alphaColor.r);\n    outColor1 = texelFetch(sTexture, leftTexCoord + ivec2(offsets.y, 0), 0);\n}";
        this.mSTMatrix = new float[16];
        this.mVideoNums = 3;
        this.mOrder = 100;
        this.mIsSupportOes = 1;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "new GLAutoStereoScopyFilter");
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public String getStringOption(int r100) {
        if (r100 == 11000) goto L14;
        if (r100 == 11001) goto L9;
        return super.getStringOption(r100);
    L9:
        if (this.mInTextureTarget != 36197) goto L11;
        return "#version 300 es\n#extension GL_OES_EGL_image_external_essl3 : require\nprecision mediump float;\nin vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nlayout(location = 0) out vec4 outColor0;\nlayout(location = 1) out vec4 outColor1;\nuniform ivec2 offsets;\nvoid main() {\n    ivec2 texSize = textureSize(sTexture, 0);\n    ivec2 leftTexCoord = ivec2(int(vTextureCoord.x * float(texSize.x)), int(vTextureCoord.y * float(texSize.y)));\n    vec4 oriColor = texelFetch(sTexture, leftTexCoord, 0);\n    vec4 alphaColor = texelFetch(sTexture, leftTexCoord + ivec2(offsets.x,0), 0);\n    outColor0 = vec4(oriColor.rgb, alphaColor.r);\n    outColor1 = texelFetch(sTexture, leftTexCoord + ivec2(offsets.y, 0), 0);\n}";
    L11:
        return "#version 300 es\nprecision mediump float;\nin vec2 vTextureCoord;\nuniform sampler2D sTexture;\nlayout(location = 0) out vec4 outColor0;\nlayout(location = 1) out vec4 outColor1;\nuniform ivec2 offsets;\nvoid main() {\n    ivec2 texSize = textureSize(sTexture, 0);\n    ivec2 leftTexCoord = ivec2(int(vTextureCoord.x * float(texSize.x)), int(vTextureCoord.y * float(texSize.y)));\n    vec4 oriColor = texelFetch(sTexture, leftTexCoord, 0);\n    vec4 alphaColor = texelFetch(sTexture, leftTexCoord + ivec2(offsets.x, 0), 0);\n    outColor0 = vec4(oriColor.rgb, alphaColor.r);\n    outColor1 = texelFetch(sTexture, leftTexCoord + ivec2(offsets.y, 0), 0);\n}";
    L14:
        if (this.mInTextureTarget != 36197) goto L16;
        return "#version 300 es\nuniform mat4 uSTMatrix;\nin vec4 aPosition;\nin vec4 aTextureCoord;\nout vec2 vTextureCoord;\nvoid main() {\n  gl_Position = aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}";
    L16:
        return "#version 300 es\nin vec4 aPosition;\nin vec4 aTextureCoord;\nout vec2 vTextureCoord;\nvoid main() {\n  gl_Position = aPosition;\n  vTextureCoord = aTextureCoord.xy;\n}";
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public int init(Bundle r100) {
        int r101 = r100.getInt(TextureRenderKeys.KEY_IS_TEXTURE_TYPE);
        if (r101 == this.mInTextureTarget) goto L5;
    L8:
        int r102 = this.mProgram;
        if (r102 <= 0) goto L11;
        GLES20.glDeleteProgram(r102);
        this.mProgram = 0;
    L11:
        this.mInTextureTarget = r101;
        int r103 = r100.getInt(TextureRenderKeys.KEY_IS_VIDEO_NUMS, 3);
        this.mVideoNums = r103;
        this.mAlphaTextureVerticesData = new float[]{0.0f, 0.0f, 1.0f / r103, 0.0f, 0.0f, 1.0f, 1.0f / r103, 1.0f};
        int r104 = super.init(r100);
        if (this.mInTextureTarget != 36197) goto L14;
        this.mSTMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uSTMatrix");
    L14:
        this.mOffsetsHandle = GLES20.glGetUniformLocation(this.mProgram, "offsets");
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "init texTarget:" + this.mInTextureTarget);
        return r104;
    L5:
        if (this.mProgram <= 0) goto L8;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "inited");
        return 0;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public EffectTexture[] processWithMRT(EffectTexture r110, FrameBuffer r111) {
        VideoSurfaceTexture r100 = this.mSurfaceTexture;
        if (r100 == null) goto L8;
        if (r100.getIntOption(126, this.mEffectType) != (-1)) goto L8;
        this.mSurfaceTexture.setOption(126, this.mEffectType, 0);
    L8:
        if (r110.getTexTarget() == this.mInTextureTarget) goto L14;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "error, texture miss match, accept:" + this.mInTextureTarget + ",in:" + r110.getTexTarget());
        VideoSurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 == null) goto L12;
        r101.notifyError(12, this.mEffectType, "error, texture miss match, accept:" + this.mInTextureTarget + ",in:" + r110.getTexTarget());
    L12:
        return null;
    L14:
        if (this.mProgram != 0) goto L19;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "program error,don't process,filter:" + this.mEffectType);
        VideoSurfaceTexture r102 = this.mSurfaceTexture;
        if (r102 == null) goto L18;
        r102.notifyError(13, this.mEffectType, "program error,don't process,filter:" + this.mEffectType);
    L18:
        return null;
    L19:
        int r103 = TexGLUtils.checkGLError(this.mTexType, "filter process start,type:" + this.mEffectType);
        if (r103 == 0) goto L25;
        this.mGLError = -1;
        VideoSurfaceTexture r104 = this.mSurfaceTexture;
        if (r104 == null) goto L24;
        r104.notifyError(r103, this.mEffectType, "");
    L24:
        return null;
    L25:
        VideoSurfaceTexture r105 = this.mSurfaceTexture;
        if (r105 == null) goto L28;
        r105.currentEffectProcessBegin(this.mEffectType);
    L28:
        updateRenderParam(r110, r111);
        if (r111 != null) goto L31;
        EffectTexture r106 = null;
        EffectTexture r107 = null;
    L44:
        GLES20.glUseProgram(this.mProgram);
        if (this.mNeedClear == false) goto L47;
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
    L47:
        GLES20.glViewport(this.mViewPortX, this.mViewPortY, this.mViewPortWidth, this.mViewPortHeight);
        this.mTriangleVertices.position(this.TRIANGLE_VERTICES_DATA_POS_OFFSET);
        GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, this.TRIANGLE_VERTICES_DATA_STRIDE_BYTES, this.mTriangleVertices);
        GLES20.glEnableVertexAttribArray(this.maPositionHandle);
        this.mTextureVertices.position(this.TRIANGLE_VERTICES_DATA_UV_OFFSET);
        GLES20.glVertexAttribPointer(this.maTextureHandle, 2, 5126, false, this.TEXTURE_VERTICES_DATA_STRIDE_BYTES, this.mTextureVertices);
        GLES20.glEnableVertexAttribArray(this.maTextureHandle);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mInTextureTarget, r110.getTexID());
        GLES20.glUniform1i(this.mInputTextureHandle, 0);
        if (this.mInTextureTarget != 36197) goto L50;
        this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
        GLES20.glUniformMatrix4fv(this.mSTMatrixHandle, 1, false, this.mSTMatrix, 0);
    L50:
        int r108 = this.mOffsetsHandle;
        int r112 = this.mOutTexWidth;
        if (this.mVideoNums != 2) goto L53;
        int r113 = 0;
    L54:
        GLES20.glUniform2i(r108, r112, r113);
        int r109 = TexGLUtils.checkGLError(this.mTexType, "filter glDrawArrays before,type:" + this.mEffectType);
        if (r109 != 0) goto L57;
        GLES20.glDrawArrays(5, 0, 4);
        this.mGLError = 0;
    L60:
        GLES20.glBindTexture(this.mInTextureTarget, 0);
        GLES20.glDisableVertexAttribArray(this.maPositionHandle);
        GLES20.glDisableVertexAttribArray(this.maTextureHandle);
        if (this.mIsCallGLfinish != 1) goto L63;
        GLES20.glFinish();
    L63:
        if (r111 == null) goto L65;
        r111.unbindTexture2Ds(FrameBuffer.GL_COLOR_ATTACHMENTS);
    L65:
        VideoSurfaceTexture r114 = this.mSurfaceTexture;
        if (r114 == null) goto L68;
        r114.currentEffectProcessEnd(this.mEffectType);
    L68:
        int r115 = TexGLUtils.checkGLError(this.mTexType, "filter glDrawArrays after,type:" + this.mEffectType);
        if (this.mGLError != 0) goto L76;
        if (r115 != 0) goto L76;
        VideoSurfaceTexture r116 = this.mSurfaceTexture;
        if (r116 == null) goto L74;
        r116.setOption(19, this.mEffectType, 1);
    L74:
        r110.giveBack();
        return new EffectTexture[]{r107, r106};
    L76:
        VideoSurfaceTexture r117 = this.mSurfaceTexture;
        if (r117 == null) goto L79;
        r117.notifyError(r115, this.mEffectType, "filter glDrawArrays after,type:" + this.mEffectType);
    L79:
        if (r107 == null) goto L81;
        r107.giveBack();
    L81:
        if (r106 == null) goto L83;
        r106.giveBack();
    L83:
        this.mGLError = -1;
        return null;
    L57:
        this.mGLError = -1;
        VideoSurfaceTexture r118 = this.mSurfaceTexture;
        if (r118 == null) goto L60;
        r118.notifyError(r109, this.mEffectType, "filter glDrawArrays before,type:" + this.mEffectType);
        goto L60
    L53:
        r113 = r112 * 2;
        goto L54
    L31:
        if (this.mOutTexWidth != 0) goto L33;
    L34:
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "error width or height, w:" + this.mOutTexWidth + " h:" + this.mOutTexHeight);
        VideoSurfaceTexture r119 = this.mSurfaceTexture;
        if (r119 == null) goto L37;
        r119.notifyError(14, this.mEffectType, "error width or height, w:" + this.mOutTexWidth + " h:" + this.mOutTexHeight);
    L37:
        this.mOutTexRect = r110.getRect();
        r106 = genTexture();
        r107 = genTexture();
        if (r106 == null) goto L42;
        if (r107 == null) goto L42;
        r111.bindTexture2Ds(new int[]{r106.getTexID(), r107.getTexID()}, FrameBuffer.GL_COLOR_ATTACHMENTS);
    L42:
        return null;
    L33:
        if (this.mOutTexHeight != 0) goto L37;
        goto L34
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int updateRenderParam(EffectTexture r100, FrameBuffer r101) {
        this.mOutTexWidth = r100.getWidth() / this.mVideoNums;
        int r102 = r100.getHeight();
        this.mOutTexHeight = r102;
        this.mViewPortWidth = this.mOutTexWidth;
        this.mViewPortHeight = r102;
        this.mViewPortY = 0;
        this.mViewPortX = 0;
        return 0;
    }
}
