package com.ss.texturerender.effect.vr;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.texturerender.DeviceManager;
import com.ss.texturerender.TexGLUtils;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.VideoSurfaceTexture;
import com.ss.texturerender.effect.AbsEffect;
import com.ss.texturerender.effect.EffectTexture;
import com.ss.texturerender.effect.FrameBuffer;
import com.ss.texturerender.effect.vr.director.IDirector;
import com.ss.texturerender.math.Quaternion;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes40.dex */
public class GLPanorama180To360Filter extends GLPanoramaFilter {
    private final String fragment180to360Shader;
    private int mBackgroundTexHandle;
    private int mBackgroundTexScaleHandle;
    private int mContentTypeOffsetHandle;
    private int mEacExpandCoefHandle;
    private int mGlBackgroundTexture;
    private int mInputBackTexSizeHandle;
    private int mInputTexOffsetHandle;
    private int mInputTexScaleHandle;
    private int mInputTexSizeHandle;
    private int mShaderTypeHandle;

    public void genBackgroundTexture() {
        int r100 = TexGLUtils.genTexture(3553);
        this.mGlBackgroundTexture = r100;
        GLES20.glBindTexture(3553, r100);
        GLES20.glTexImage2D(3553, 0, 6408, 1, 1, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
    }

    @Override // com.ss.texturerender.effect.vr.GLPanoramaFilter, com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        int r100 = this.mGlBackgroundTexture;
        if (r100 == 0) goto L6;
        TexGLUtils.deleteTexture(r100);
    L6:
        return super.release();
    }

    public GLPanorama180To360Filter(int r100) {
        super(r100, 12);
        this.fragment180to360Shader = "precision highp float;\n\n#define PI 3.14159265359\nuniform sampler2D sTexture;\nuniform sampler2D sBackground;\nuniform float sTextureSize;\nuniform float sBackTextureSize;\nuniform float scaleU;\nuniform float scaleV;\nuniform float offsetU;\nuniform float offsetT;\nuniform float expandCoef;\nuniform int shaderType;\nvarying vec2 vTextureCoord;\nvarying vec3 verPosition;\n\nvec4 vrTextureFragmentForVirtualLive() {\n    vec4 outputColor = texture2D(sBackground, vec2(vTextureCoord.x, 1.0 - vTextureCoord.y));\n    if (verPosition.z < 0.0 && abs(verPosition.z) > abs(verPosition.x) && abs(verPosition.z) > abs(verPosition.y)) {\n        vec2 st = vec2(verPosition.x / (verPosition.z * 2.0) + 0.5, verPosition.y / (verPosition.z * 2.0) + 0.5);\n        st = vec2(1.0, 1.0) - st;\n        outputColor = texture2D(sTexture, st);\n    }\n    return outputColor;\n}\n\nvec4 vrTextureFragmentFor180eac() {\n    vec4 colMain;\n    if (verPosition.z < 0.0) {\n       vec2 st;\n       float padding = 1.0/expandCoef;\n       if (abs(verPosition.z) > abs(verPosition.x) && abs(verPosition.z) > abs(verPosition.y)) {\n           st = vec2((2.0*(0.5 * (4.0/PI*atan(padding * verPosition.x / verPosition.z)) + 0.5) + 3.0)/6.0, 0.5*(4.0/PI*atan(padding * verPosition.y / verPosition.z)) + 0.5);\n           st = vec2(1.0, 1.0) - st;\n       } else if ( verPosition.x < 0.0 && abs(verPosition.x) > abs(verPosition.z) && abs(verPosition.x) > abs(verPosition.y)) {\n           st = vec2((4.0/PI*atan(padding * verPosition.z / verPosition.x))/6.0, -0.5 * (4.0/PI*atan(padding * verPosition.y / verPosition.x)) + 0.5);\n       } else if (verPosition.x > 0.0 && abs(verPosition.x) > abs(verPosition.z) && abs(verPosition.x) > abs(verPosition.y)) {\n           st = vec2((4.0/PI*atan(padding * verPosition.z / verPosition.x))/6.0 + 4.0/6.0, 0.5 * (4.0/PI*atan(padding * verPosition.y / verPosition.x)) + 0.5);\n       } else if (verPosition.y < 0.0 && abs(verPosition.y) > abs(verPosition.z) && abs(verPosition.y) > abs(verPosition.x)) {\n           st = vec2((4.0/PI*atan(padding * verPosition.z / verPosition.y))/(-6.0) + 5.0/6.0, -0.5 * (4.0/PI*atan(padding * verPosition.x / verPosition.y)) + 0.5);\n       } else if (verPosition.y > 0.0 && abs(verPosition.y) > abs(verPosition.z) && abs(verPosition.y) > abs(verPosition.x)) {\n           st = vec2((4.0/PI*atan(padding * verPosition.z / verPosition.y))/(-6.0) + 5.0/6.0, 0.5 * (4.0/PI*atan(padding * verPosition.x / verPosition.y)) + 0.5);\n       }\n       colMain = texture2D(sTexture, st);\n    }\n    float StepLeft = 1.0 - step((0.25 - sTextureSize / 2.0 + 0.5 * sBackTextureSize) / scaleU, vTextureCoord.x);\n    float StepRight = step((0.75 + sTextureSize / 2.0 - 0.5 * sBackTextureSize) / scaleU, vTextureCoord.x);\n\n    vec2 leftUV = vTextureCoord;\n    leftUV.x = (scaleU * leftUV.x  / sBackTextureSize) + 0.5;\n    \n    vec2 rightUV = vTextureCoord;\n    rightUV.x = (scaleU * (rightUV.x - 1.0 + offsetT) / sBackTextureSize) + 0.5;\n    \n    leftUV.y = scaleV * (1.0 - leftUV.y);\n    rightUV.y = scaleV * (1.0 - rightUV.y);\n\n    vec4 col = colMain * (1.0 - StepLeft) * (1.0 - StepRight) + texture2D(sBackground, leftUV) * StepLeft + texture2D(sBackground, rightUV) * StepRight;\n\n    return col;\n}\n\nvec4 vrTextureFragmentForGeneralUse() {\n    vec2 uvMain = vTextureCoord;\n    if (offsetT == 0.0  && offsetU ==  0.25) {\n       uvMain.x = (uvMain.x - offsetU) * 2.0;\n    } else {\n       uvMain.x = (uvMain.x - offsetU) * scaleU;\n    }\n    vec4 colMain = texture2D(sTexture, uvMain);\n    float StepLeft = 1.0 - step((0.25 - sTextureSize / 2.0 + 0.5 * sBackTextureSize) / scaleU, vTextureCoord.x);\n    float StepRight = step((0.75 + sTextureSize / 2.0 - 0.5 * sBackTextureSize) / scaleU, vTextureCoord.x);\n\n    vec2 leftUV = vTextureCoord;\n    leftUV.x = (scaleU * leftUV.x  / sBackTextureSize) + 0.5;\n    \n    vec2 rightUV = vTextureCoord;\n    rightUV.x = (scaleU * (rightUV.x - 1.0 + offsetT) / sBackTextureSize) + 0.5;\n    \n    leftUV.y = scaleV * (1.0 - leftUV.y);\n    rightUV.y = scaleV * (1.0 - rightUV.y);\n\n    vec4 col = colMain * (1.0 - StepLeft) * (1.0 - StepRight) + texture2D(sBackground, leftUV) * StepLeft + texture2D(sBackground, rightUV) * StepRight;\n\n    return col;\n}\n\nvoid main()\n{\n    if (shaderType == 1) {\n        gl_FragColor = vrTextureFragmentForVirtualLive();\n    } else if (shaderType == 2) {\n        gl_FragColor = vrTextureFragmentFor180eac();\n    } else {\n        gl_FragColor = vrTextureFragmentForGeneralUse();\n    }\n}\n";
        this.mGlBackgroundTexture = 0;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "new GLPanoramaFilter");
    }

    @Override // com.ss.texturerender.effect.vr.GLPanoramaFilter, com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public String getStringOption(int r100) {
        if (r100 != 11001) goto L5;
        return "precision highp float;\n\n#define PI 3.14159265359\nuniform sampler2D sTexture;\nuniform sampler2D sBackground;\nuniform float sTextureSize;\nuniform float sBackTextureSize;\nuniform float scaleU;\nuniform float scaleV;\nuniform float offsetU;\nuniform float offsetT;\nuniform float expandCoef;\nuniform int shaderType;\nvarying vec2 vTextureCoord;\nvarying vec3 verPosition;\n\nvec4 vrTextureFragmentForVirtualLive() {\n    vec4 outputColor = texture2D(sBackground, vec2(vTextureCoord.x, 1.0 - vTextureCoord.y));\n    if (verPosition.z < 0.0 && abs(verPosition.z) > abs(verPosition.x) && abs(verPosition.z) > abs(verPosition.y)) {\n        vec2 st = vec2(verPosition.x / (verPosition.z * 2.0) + 0.5, verPosition.y / (verPosition.z * 2.0) + 0.5);\n        st = vec2(1.0, 1.0) - st;\n        outputColor = texture2D(sTexture, st);\n    }\n    return outputColor;\n}\n\nvec4 vrTextureFragmentFor180eac() {\n    vec4 colMain;\n    if (verPosition.z < 0.0) {\n       vec2 st;\n       float padding = 1.0/expandCoef;\n       if (abs(verPosition.z) > abs(verPosition.x) && abs(verPosition.z) > abs(verPosition.y)) {\n           st = vec2((2.0*(0.5 * (4.0/PI*atan(padding * verPosition.x / verPosition.z)) + 0.5) + 3.0)/6.0, 0.5*(4.0/PI*atan(padding * verPosition.y / verPosition.z)) + 0.5);\n           st = vec2(1.0, 1.0) - st;\n       } else if ( verPosition.x < 0.0 && abs(verPosition.x) > abs(verPosition.z) && abs(verPosition.x) > abs(verPosition.y)) {\n           st = vec2((4.0/PI*atan(padding * verPosition.z / verPosition.x))/6.0, -0.5 * (4.0/PI*atan(padding * verPosition.y / verPosition.x)) + 0.5);\n       } else if (verPosition.x > 0.0 && abs(verPosition.x) > abs(verPosition.z) && abs(verPosition.x) > abs(verPosition.y)) {\n           st = vec2((4.0/PI*atan(padding * verPosition.z / verPosition.x))/6.0 + 4.0/6.0, 0.5 * (4.0/PI*atan(padding * verPosition.y / verPosition.x)) + 0.5);\n       } else if (verPosition.y < 0.0 && abs(verPosition.y) > abs(verPosition.z) && abs(verPosition.y) > abs(verPosition.x)) {\n           st = vec2((4.0/PI*atan(padding * verPosition.z / verPosition.y))/(-6.0) + 5.0/6.0, -0.5 * (4.0/PI*atan(padding * verPosition.x / verPosition.y)) + 0.5);\n       } else if (verPosition.y > 0.0 && abs(verPosition.y) > abs(verPosition.z) && abs(verPosition.y) > abs(verPosition.x)) {\n           st = vec2((4.0/PI*atan(padding * verPosition.z / verPosition.y))/(-6.0) + 5.0/6.0, 0.5 * (4.0/PI*atan(padding * verPosition.x / verPosition.y)) + 0.5);\n       }\n       colMain = texture2D(sTexture, st);\n    }\n    float StepLeft = 1.0 - step((0.25 - sTextureSize / 2.0 + 0.5 * sBackTextureSize) / scaleU, vTextureCoord.x);\n    float StepRight = step((0.75 + sTextureSize / 2.0 - 0.5 * sBackTextureSize) / scaleU, vTextureCoord.x);\n\n    vec2 leftUV = vTextureCoord;\n    leftUV.x = (scaleU * leftUV.x  / sBackTextureSize) + 0.5;\n    \n    vec2 rightUV = vTextureCoord;\n    rightUV.x = (scaleU * (rightUV.x - 1.0 + offsetT) / sBackTextureSize) + 0.5;\n    \n    leftUV.y = scaleV * (1.0 - leftUV.y);\n    rightUV.y = scaleV * (1.0 - rightUV.y);\n\n    vec4 col = colMain * (1.0 - StepLeft) * (1.0 - StepRight) + texture2D(sBackground, leftUV) * StepLeft + texture2D(sBackground, rightUV) * StepRight;\n\n    return col;\n}\n\nvec4 vrTextureFragmentForGeneralUse() {\n    vec2 uvMain = vTextureCoord;\n    if (offsetT == 0.0  && offsetU ==  0.25) {\n       uvMain.x = (uvMain.x - offsetU) * 2.0;\n    } else {\n       uvMain.x = (uvMain.x - offsetU) * scaleU;\n    }\n    vec4 colMain = texture2D(sTexture, uvMain);\n    float StepLeft = 1.0 - step((0.25 - sTextureSize / 2.0 + 0.5 * sBackTextureSize) / scaleU, vTextureCoord.x);\n    float StepRight = step((0.75 + sTextureSize / 2.0 - 0.5 * sBackTextureSize) / scaleU, vTextureCoord.x);\n\n    vec2 leftUV = vTextureCoord;\n    leftUV.x = (scaleU * leftUV.x  / sBackTextureSize) + 0.5;\n    \n    vec2 rightUV = vTextureCoord;\n    rightUV.x = (scaleU * (rightUV.x - 1.0 + offsetT) / sBackTextureSize) + 0.5;\n    \n    leftUV.y = scaleV * (1.0 - leftUV.y);\n    rightUV.y = scaleV * (1.0 - rightUV.y);\n\n    vec4 col = colMain * (1.0 - StepLeft) * (1.0 - StepRight) + texture2D(sBackground, leftUV) * StepLeft + texture2D(sBackground, rightUV) * StepRight;\n\n    return col;\n}\n\nvoid main()\n{\n    if (shaderType == 1) {\n        gl_FragColor = vrTextureFragmentForVirtualLive();\n    } else if (shaderType == 2) {\n        gl_FragColor = vrTextureFragmentFor180eac();\n    } else {\n        gl_FragColor = vrTextureFragmentForGeneralUse();\n    }\n}\n";
    L5:
        return super.getStringOption(r100);
    }

    @Override // com.ss.texturerender.effect.vr.GLPanoramaFilter, com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public int init(Bundle r100) {
        if (super.init(r100) == 0) goto L9;
        VideoSurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 == null) goto L11;
        r101.notifyInitError(10, this.mEffectType, "super.init(bundle) != TR_OK");
        return -1;
    L11:
        return -1;
    L9:
        this.mBackgroundTexHandle = GLES20.glGetUniformLocation(this.mProgram, "sBackground");
        this.mInputTexSizeHandle = GLES20.glGetUniformLocation(this.mProgram, "sTextureSize");
        this.mInputBackTexSizeHandle = GLES20.glGetUniformLocation(this.mProgram, "sBackTextureSize");
        this.mInputTexScaleHandle = GLES20.glGetUniformLocation(this.mProgram, "scaleU");
        this.mBackgroundTexScaleHandle = GLES20.glGetUniformLocation(this.mProgram, "scaleV");
        this.mInputTexOffsetHandle = GLES20.glGetUniformLocation(this.mProgram, "offsetU");
        this.mContentTypeOffsetHandle = GLES20.glGetUniformLocation(this.mProgram, "offsetT");
        this.mEacExpandCoefHandle = GLES20.glGetUniformLocation(this.mProgram, "expandCoef");
        this.mShaderTypeHandle = GLES20.glGetUniformLocation(this.mProgram, "shaderType");
        return 0;
    }

    public void updateBackgroundTexture(Bitmap r100) {
        if (this.mGlBackgroundTexture != 0) goto L5;
        genBackgroundTexture();
    L5:
        if (r100 == null) goto L13;
        GLES20.glBindTexture(3553, this.mGlBackgroundTexture);     // Catch: Exception -> L8
        GLUtils.texImage2D(3553, 0, r100, 0);     // Catch: Exception -> L8
        GLES20.glBindTexture(3553, 0);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.ss.texturerender.effect.vr.GLPanoramaFilter, com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture r210, FrameBuffer r211) {
        if (this.mIsProcessed == true) goto L9;
        this.mIsProcessed = true;
        GLPanoramaFilter.OrientationEventHandler r100 = this.mOrientationEventHandler;
        if (r100 == null) goto L7;
        r100.enable();
    L7:
        handleDirectModeChange();
        handleTouchScalerChange();
    L9:
        if (r210.getTexTarget() == this.mInTextureTarget) goto L15;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "error, texture miss match, accept:" + this.mInTextureTarget + ",in:" + r210.getTexTarget());
        VideoSurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 == null) goto L13;
        r101.notifyError(12, this.mEffectType, "error, texture miss match, accept:" + this.mInTextureTarget + ",in:" + r210.getTexTarget());
    L13:
        return r210;
    L15:
        if (this.mProgram != 0) goto L20;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "program error,don't process,filter:" + this.mEffectType);
        VideoSurfaceTexture r102 = this.mSurfaceTexture;
        if (r102 == null) goto L19;
        r102.notifyError(13, this.mEffectType, "program error,don't process,filter:" + this.mEffectType);
    L19:
        return r210;
    L20:
        VideoSurfaceTexture r103 = this.mSurfaceTexture;
        if (r103 == null) goto L23;
        r103.currentEffectProcessBegin(this.mEffectType);
    L23:
        GLES20.glUseProgram(this.mProgram);
        this.mViewPortWidth = this.mSurfaceTexture.getViewportWidth();
        this.mViewPortHeight = this.mSurfaceTexture.getViewportHeight();
        if (this.mVideoStyle != 1) goto L26;
        updateRenderParam(r210, r211);
    L26:
        GLES20.glBindBuffer(34962, this.mVerVBO);
        GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, this.TRIANGLE_VERTICES_DATA_STRIDE_BYTES, 0);
        GLES20.glEnableVertexAttribArray(this.maPositionHandle);
        GLES20.glBindBuffer(34962, 0);
        GLES20.glBindBuffer(34962, this.mTexVBO);
        GLES20.glVertexAttribPointer(this.maTextureHandle, 2, 5126, false, this.TEXTURE_VERTICES_DATA_STRIDE_BYTES, 0);
        GLES20.glEnableVertexAttribArray(this.maTextureHandle);
        GLES20.glBindBuffer(34962, 0);
        if (this.mSensorDirectorEnabled == true) goto L38;
        float[] r104 = this.mFreezeModelMatrix;
        if (r104 == null) goto L38;
        this.mModelMatrix = r104;
        if (this.mDidGetInitialModelMatrix == true) goto L51;
        IDirector r105 = this.mSensorDirector;
        if (r105 != null) goto L35;
    L37:
        Matrix.invertM(this.mInitialModelMatrixInvert, 0, this.mModelMatrix, 0);
        float[] r106 = this.mModelMatrix;
        Matrix.multiplyMM(r106, 0, r106, 0, this.mInitialModelMatrixInvert, 0);
        this.mFreezeModelMatrix = this.mModelMatrix;
        this.mDidGetInitialModelMatrix = true;
        goto L51
    L35:
        if (this.mDirectMode == 2) goto L37;
        r105.getView(r104, 0);
    L51:
        Matrix.setIdentityM(this.mRotateMatrix, 0);
        if (DeviceManager.isVRDevice() == true) goto L54;
    L57:
        Matrix.rotateM(this.mRotateMatrix, 0, this.mOffsetPitch + this.mTouchDirector.getDiffX(), 1.0f, 0.0f, 0.0f);
        Matrix.rotateM(this.mRotateMatrix, 0, this.mTouchDirector.getDiffY() - this.mOffsetYaw, 0.0f, 1.0f, 0.0f);
    L58:
        Matrix.rotateM(this.mRotateMatrix, 0, this.mSpaceOrientationPitch, 1.0f, 0.0f, 0.0f);
        float[] r107 = new float[16];
        Matrix.multiplyMM(r107, 0, this.mModelMatrix, 0, this.mRotateMatrix, 0);
        Matrix.invertM(r107, 0, r107, 0);
        this.mSurfaceTexture.setHeadPose(new Quaternion(r107));
        float r108 = this.mTouchScaler.getScale();
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.mProgram, "rotateMatrix"), 1, false, this.mRotateMatrix, 0);
        float r110 = (this.mSurfaceTexture.getViewportWidth() * 1.0f) / this.mSurfaceTexture.getViewportHeight();
        if (r110 <= 1.0f) goto L61;
        float r109 = r110;
    L62:
        this.mPerspecViewRatio = r109;
        if (r211 == null) goto L68;
        updateOutTexSize(r110);
        EffectTexture r111 = genTexture();
        if (r111 == null) goto L67;
        r211.bindTexture2D(r111.getTexID());
    L67:
        this.mViewPortWidth = this.mOutTexWidth;
        this.mViewPortHeight = this.mOutTexHeight;
    L70:
        if (this.mNeedClear == false) goto L72;
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
    L72:
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mInTextureTarget, r210.getTexID());
        GLES20.glUniform1i(this.mInputTextureHandle, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.mGlBackgroundTexture);
        GLES20.glUniform1i(this.mShaderTypeHandle, getShaderType());
        GLES20.glUniform1f(this.mEacExpandCoefHandle, getExpandCoef());
        GLES20.glUniform1i(this.mBackgroundTexHandle, 1);
        int r112 = this.mVideoStyle;
        if (r112 == 2) goto L75;
    L77:
        if (r112 != 2) goto L82;
        if (this.mViewSize != 180) goto L82;
        GLES20.glUniform1f(this.mInputTexSizeHandle, 0.5f);
        GLES20.glUniform1f(this.mInputTexScaleHandle, 1.0f);
        GLES20.glUniform1f(this.mInputTexOffsetHandle, 0.25f);
        GLES20.glUniform1f(this.mContentTypeOffsetHandle, 0.0f);
        GLES20.glUniform1f(this.mBackgroundTexScaleHandle, 1.0f);
    L87:
        GLES20.glUniform1f(this.mInputBackTexSizeHandle, (float) ((((double) this.mBackTextureSize) * 1.0d) / 360.0d));
        GLES20.glUniformMatrix3fv(GLES20.glGetUniformLocation(this.mProgram, "texScale"), 1, false, GLPanoramaFilter.TEXSCALE_2D, 0);
        Matrix.perspectiveM(this.mProjectionMatrix, 0, this.mPerspecView / this.mPerspecViewRatio, r110, 0.1f, 100.0f);
        Matrix.scaleM(this.mProjectionMatrix, 0, r108, r108, 1.0f);
        GLES20.glViewport(this.mViewPortX, this.mViewPortY, this.mViewPortWidth, this.mViewPortHeight);
        Matrix.setLookAtM(this.mViewMatrix, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f);
        draw(this.mIndexBuffers);
        r210.giveBack();
        GLES20.glBindTexture(this.mInTextureTarget, 0);
        GLES20.glDisableVertexAttribArray(this.maPositionHandle);
        GLES20.glDisableVertexAttribArray(this.maTextureHandle);
        this.mSurfaceTexture.setOption(19, this.mEffectType, 1);
        int r113 = TexGLUtils.checkGLError(this.mTexType, "error pano draw");
        if (r113 == 0) goto L92;
        VideoSurfaceTexture r114 = this.mSurfaceTexture;
        if (r114 == null) goto L92;
        r114.notifyError(r113, this.mEffectType, "error pano draw");
    L92:
        GLES20.glFinish();
        VideoSurfaceTexture r115 = this.mSurfaceTexture;
        if (r115 == null) goto L95;
        r115.currentEffectProcessEnd(this.mEffectType);
    L95:
        if (r211 == null) goto L98;
        r211.unbindTexture2D();
        return r111;
    L98:
        return null;
    L82:
        if (r112 != 4) goto L85;
        GLES20.glUniform1f(this.mInputTexSizeHandle, 0.5f);
        GLES20.glUniform1f(this.mInputTexScaleHandle, 2.0f);
        GLES20.glUniform1f(this.mInputTexOffsetHandle, 0.125f);
        GLES20.glUniform1f(this.mContentTypeOffsetHandle, 0.5f);
        GLES20.glUniform1f(this.mBackgroundTexScaleHandle, 1.0f);
        goto L87
    L85:
        if (r112 != 3) goto L87;
        GLES20.glUniform1f(this.mInputTexSizeHandle, 0.5f);
        GLES20.glUniform1f(this.mInputTexScaleHandle, 1.0f);
        GLES20.glUniform1f(this.mInputTexOffsetHandle, 0.0f);
        GLES20.glUniform1f(this.mContentTypeOffsetHandle, 0.0f);
        GLES20.glUniform1f(this.mBackgroundTexScaleHandle, 2.0f);
        goto L87
    L75:
        if (this.mViewSize != 360) goto L77;
        GLES20.glUniform1f(this.mInputTexSizeHandle, 0.5f);
        GLES20.glUniform1f(this.mInputTexScaleHandle, 1.0f);
        GLES20.glUniform1f(this.mInputTexOffsetHandle, 0.0f);
        GLES20.glUniform1f(this.mContentTypeOffsetHandle, 0.0f);
        GLES20.glUniform1f(this.mBackgroundTexScaleHandle, 1.0f);
        goto L87
    L68:
        r111 = null;
        goto L70
    L61:
        r109 = 1.0f;
        goto L62
    L54:
        if (this.mOffsetYaw != 0) goto L57;
        if (this.mOffsetPitch == 0) goto L58;
    L38:
        IDirector r116 = this.mSensorDirector;
        if (r116 == null) goto L44;
        if (this.mDirectMode == 2) goto L44;
        r116.getView(this.mModelMatrix, 0);
    L44:
        if (this.mDidGetInitialModelMatrix == true) goto L47;
        Matrix.invertM(this.mInitialModelMatrixInvert, 0, this.mModelMatrix, 0);
        this.mDidGetInitialModelMatrix = true;
    L47:
        if (this.mDirectMode == 2) goto L51;
        if (this.mUseInitialHeadPoseAsFront == false) goto L51;
        float[] r117 = this.mModelMatrix;
        Matrix.multiplyMM(r117, 0, r117, 0, this.mInitialModelMatrixInvert, 0);
        goto L51
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public void setOption(int r100, Object r101) {
        if (r100 == 118) goto L18;
        super.setOption(r100, r101);
        return;
    L18:
        ArrayList r102 = (ArrayList) r101;     // Catch: Exception -> L15
        Object r103 = ListProtector.get(r102, 0);     // Catch: Exception -> L15
        Object r104 = ListProtector.get(r102, 1);     // Catch: Exception -> L15
        if ((r104 instanceof Bitmap) == false) goto L8;
        updateBackgroundTexture((Bitmap) r104);     // Catch: Exception -> L15
    L8:
        monitor-enter(r103);     // Catch: Exception -> L15
        r103.notify();     // Catch: Throwable -> L12
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "update background texture done");     // Catch: Throwable -> L12
        monitor-exit(r103);     // Catch: Throwable -> L12
    L22:
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Exception -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
    }
}
