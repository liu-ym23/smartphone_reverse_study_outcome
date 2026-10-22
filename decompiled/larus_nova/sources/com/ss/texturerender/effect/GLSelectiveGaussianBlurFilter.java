package com.ss.texturerender.effect;

import android.opengl.GLES20;
import android.os.Bundle;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;

/* JADX INFO: loaded from: classes40.dex */
public class GLSelectiveGaussianBlurFilter extends GLGaussianBlurFilter {
    private static final String oesFragmentShaderMainFunc = "// return 1 if v inside the box, return 0 otherwise\nfloat insideBox(vec2 v, vec2 bottomLeft, vec2 topRight) {\n    vec2 s = step(bottomLeft, v) - step(topRight, v);\n    return s.x * s.y;\n}\n//pointer to box edge distance\nfloat pointToBoxDistance(vec2 v, vec2 bottomLeft, vec2 topRight, float edge) {\n    vec2 distance = smoothstep(0.0, blurAreaParam.x, abs(v - (bottomLeft + topRight) / 2.0) - (topRight - bottomLeft) / 2.0);\n    return sqrt(distance.x * distance.x + distance.y * distance.y);\n}\n\nvoid main() {\n    vec2 stage1Coord = vec2((vTextureCoord.x - layoutCoord.x) / layoutCoord.z, (vTextureCoord.y - layoutCoord.y) / layoutCoord.w);\n    vec2 resetCoord = (1.0 - processStage) * stage1Coord + processStage * vTextureCoord;\n    vec2 oriBoxBottomLeft = vec2(layoutCoord.x, layoutCoord.y);\n    vec2 oriBoxTopRight = vec2(layoutCoord.x+layoutCoord.z, layoutCoord.y+layoutCoord.w);\n    if (insideBox(vTextureCoord, oriBoxBottomLeft, oriBoxTopRight) > 0.5) {\n        gl_FragColor = texture2D(sTexture, resetCoord);\n        return;\n    } else {\n        float scale = blurAreaParam.y * (1.0 - processStage) + processStage * 1.0;\n        if (resetCoord.y <= 0.0 || resetCoord.y >= 1.0) {\n            resetCoord.x = (resetCoord.x - 0.5) * scale + 0.5;\n            if (resetCoord.y < 0.0) {\n                resetCoord.y = resetCoord.y * scale;\n                if (repeadMode == 1) {\n                    resetCoord.y = 1.0 + resetCoord.y;\n                } else if (repeadMode == 2) {\n                    resetCoord.y = -resetCoord.y;\n                }\n            } else {\n                resetCoord.y = (resetCoord.y-1.0)*scale+1.0;\n                if (repeadMode == 1) {\n                    resetCoord.y = resetCoord.y - 1.0;\n                } else if (repeadMode == 2) {\n                    resetCoord.y = 2.0 - resetCoord.y;\n                }\n            }\n        } else {\n            if (resetCoord.x < 0.0) {\n                resetCoord.x = resetCoord.x * scale;\n            } else {\n                resetCoord.x = (resetCoord.x-1.0)*scale+1.0;\n            }\n            resetCoord.y = (resetCoord.y - 0.5) * scale + 0.5;\n        }\n        vec4 oriColor = texture2D(sTexture, resetCoord);\n        float edgeCoeff = pointToBoxDistance(vTextureCoord, oriBoxBottomLeft, oriBoxTopRight, blurAreaParam.x);\n        gl_FragColor = gaussianBlurKernel(oriColor, resetCoord, edgeCoeff);\n    }\n}";
    private final String fragmentShaderEmptyFunc;
    private final String fragmentShaderGaussianFunc;
    private final String fragmentShaderMainFunc;
    private final String fragmentShaderParam;
    private int mBlurAreaParamLoc;
    private float mDisplayHeight;
    private float mDisplayWidth;
    private float mDisplayX;
    private float mDisplayY;
    private float mEdgeSize;
    protected boolean mEnableSecondPass;
    private float mGaussinScale;
    protected int mInTexHeight;
    protected int mInTexWidth;
    protected float[] mLayoutCoord;
    private int mLayoutCoordLoc;
    private int mProcessStageLoc;
    protected int mRepeatLoc;
    private int mRepeatType;
    private float[] mSTMatrix;
    protected int mSurfaceHeight;
    protected int mSurfaceWidth;
    protected int mUsedProcessStage;
    private int muSTMatrixHandle;
    private final String oesFragmentShader;
    private final String oesVertexShader;

    @Override // com.ss.texturerender.effect.GLGaussianBlurFilter, com.ss.texturerender.effect.GLDefaultFilter
    public int onDrawFrameBefore() {
        if (this.mInTextureTarget == 36197) goto L5;
        int r100 = this.mRepeatType;
        if (r100 != 2) goto L10;
        GLES20.glTexParameteri(3553, 10242, 33648);
        GLES20.glTexParameteri(3553, 10243, 33648);
    L14:
        if (this.mDisplayX < 0.0f) goto L16;
    L19:
        int r101 = this.mProcessStageLoc;
        if (r101 < 0) goto L25;
        int r102 = this.mUsedProcessStage;
        int r103 = this.mProcessStage;
        if (r102 == r103) goto L25;
        GLES20.glUniform1f(r101, r103);
        this.mUsedProcessStage = this.mProcessStage;
    L25:
        return super.onDrawFrameBefore();
    L16:
        if (this.mProcessStage != 0) goto L18;
        updateLayoutCoord((this.mSurfaceHeight * 1.0f) / this.mSurfaceWidth, (this.mInTexHeight * 1.0f) / this.mInTexWidth, 0, this.mLayoutAspectRatio, this.mLayoutCoord);
    L18:
        int r104 = this.mLayoutCoordLoc;
        float[] r105 = this.mLayoutCoord;
        GLES20.glUniform4f(r104, r105[0], r105[1], r105[2], r105[3]);
        goto L19
    L10:
        if (r100 != 3) goto L12;
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        goto L14
    L12:
        GLES20.glTexParameteri(3553, 10242, 10497);
        GLES20.glTexParameteri(3553, 10243, 10497);
        goto L14
    L5:
        if (this.muSTMatrixHandle < 0) goto L14;
        this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
        GLES20.glUniformMatrix4fv(this.muSTMatrixHandle, 1, false, this.mSTMatrix, 0);
        goto L14
    }

    public GLSelectiveGaussianBlurFilter(int r100) {
        super(r100);
        this.oesVertexShader = "uniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
        this.oesFragmentShader = "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float gaussianAlpha;\nuniform vec4 layoutCoord;//x,y,w,h\nuniform float processStage;//0:stage1;1:stage2\nuniform vec2 blurAreaParam;//x:blur edge size;y:blur area scale\nuniform int repeadMode;//1:normal;2:mirror;3:clamp to edge;\n";
        this.fragmentShaderParam = "precision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float gaussianAlpha;\nuniform vec4 layoutCoord;//x,y,w,h\nuniform float processStage;//0:stage1;1:stage2\nuniform vec2 blurAreaParam;//x:blur edge size;y:blur area scale\n";
        this.fragmentShaderMainFunc = "// return 1 if v inside the box, return 0 otherwise\nfloat insideBox(vec2 v, vec2 bottomLeft, vec2 topRight) {\n    vec2 s = step(bottomLeft, v) - step(topRight, v);\n    return s.x * s.y;\n}\n//pointer to box edge distance\nfloat pointToBoxDistance(vec2 v, vec2 bottomLeft, vec2 topRight, float edge) {\n    vec2 distance = smoothstep(0.0, blurAreaParam.x, abs(v - (bottomLeft + topRight) / 2.0) - (topRight - bottomLeft) / 2.0);\n    return sqrt(distance.x * distance.x + distance.y * distance.y);\n}\n\nvoid main() {\n    vec2 stage1Coord = vec2((vTextureCoord.x - layoutCoord.x) / layoutCoord.z, (vTextureCoord.y - layoutCoord.y) / layoutCoord.w);\n    vec2 resetCoord = (1.0 - processStage) * stage1Coord + processStage * vTextureCoord;\n    vec2 oriBoxBottomLeft = vec2(layoutCoord.x, layoutCoord.y);\n    vec2 oriBoxTopRight = vec2(layoutCoord.x+layoutCoord.z, layoutCoord.y+layoutCoord.w);\n    if (insideBox(vTextureCoord, oriBoxBottomLeft, oriBoxTopRight) > 0.5) {\n        gl_FragColor = texture2D(sTexture, resetCoord);\n        return;\n    } else {\n        float scale = blurAreaParam.y * (1.0 - processStage) + processStage * 1.0;\n        if (resetCoord.y <= 0.0 || resetCoord.y >= 1.0) {\n            resetCoord.x = (resetCoord.x - 0.5) * scale + 0.5;\n            if (resetCoord.y < 0.0) {\n                resetCoord.y = resetCoord.y * scale;\n            } else {\n                resetCoord.y = (resetCoord.y-1.0)*scale+1.0;\n            }\n        } else {\n            if (resetCoord.x < 0.0) {\n                resetCoord.x = resetCoord.x * scale;\n            } else {\n                resetCoord.x = (resetCoord.x-1.0)*scale+1.0;\n            }\n            resetCoord.y = (resetCoord.y - 0.5) * scale + 0.5;\n        }\n        vec4 oriColor = texture2D(sTexture, resetCoord);\n        float edgeCoeff = pointToBoxDistance(vTextureCoord, oriBoxBottomLeft, oriBoxTopRight, blurAreaParam.x);\n        gl_FragColor = gaussianBlurKernel(oriColor, resetCoord, edgeCoeff);\n    }\n}\n";
        this.fragmentShaderGaussianFunc = "uniform float gaussianWeights[44];\nuniform int radius;\nuniform vec2 texelOffset;\nvec4 gaussianBlurKernel(vec4 oriColor, vec2 texCoord, float edgeCoeff) {\n    int curRadius = int(float(radius) * edgeCoeff);\n    vec4 sum = oriColor * gaussianWeights[0];\n    for (int i = curRadius + 1; i <= radius; i++) {\n        sum += 2.0 * oriColor * gaussianWeights[i];\n    }\n    for (int i = 1; i <= curRadius; i++) {\n        vec2 stepOffset = vec2(texelOffset.x * float(i), texelOffset.y * float(i));\n        sum += texture2D(sTexture, texCoord + stepOffset) * gaussianWeights[i];\n        sum += texture2D(sTexture, texCoord - stepOffset) * gaussianWeights[i];\n    }\n    return sum;\n}\n";
        this.fragmentShaderEmptyFunc = "vec4 gaussianBlurKernel(vec4 oriColor, vec2 texCoord) {\n    return oriColor;\n}\n";
        this.mEdgeSize = 0.0f;
        this.mDisplayX = -1.0f;
        this.mLayoutCoord = null;
        this.mLayoutCoordLoc = -1;
        this.mRepeatType = 2;
        this.mProcessStageLoc = -1;
        this.mGaussinScale = 1.0f;
        this.mBlurAreaParamLoc = -1;
        this.mSTMatrix = new float[16];
        this.mEnableSecondPass = false;
        this.mRepeatLoc = -1;
        this.mInTexHeight = -1;
        this.mInTexWidth = -1;
        this.mSurfaceHeight = -1;
        this.mSurfaceWidth = -1;
        this.mUsedProcessStage = -1;
        this.mEffectType = 15;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "new GLSelectiveGaussianBlurFilter");
    }

    @Override // com.ss.texturerender.effect.GLGaussianBlurFilter, com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public String getStringOption(int r100) {
        if (r100 == 11000) goto L21;
        if (r100 != 11001) goto L25;
        if (this.mInTextureTarget != 36197) goto L10;
        String r101 = "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float gaussianAlpha;\nuniform vec4 layoutCoord;//x,y,w,h\nuniform float processStage;//0:stage1;1:stage2\nuniform vec2 blurAreaParam;//x:blur edge size;y:blur area scale\nuniform int repeadMode;//1:normal;2:mirror;3:clamp to edge;\n";
        String r102 = oesFragmentShaderMainFunc;
    L12:
        if (this.mSigma == 1.0f) goto L19;
        if (this.mRepeatType == 3) goto L19;
        return r101 + "uniform float gaussianWeights[44];\nuniform int radius;\nuniform vec2 texelOffset;\nvec4 gaussianBlurKernel(vec4 oriColor, vec2 texCoord, float edgeCoeff) {\n    int curRadius = int(float(radius) * edgeCoeff);\n    vec4 sum = oriColor * gaussianWeights[0];\n    for (int i = curRadius + 1; i <= radius; i++) {\n        sum += 2.0 * oriColor * gaussianWeights[i];\n    }\n    for (int i = 1; i <= curRadius; i++) {\n        vec2 stepOffset = vec2(texelOffset.x * float(i), texelOffset.y * float(i));\n        sum += texture2D(sTexture, texCoord + stepOffset) * gaussianWeights[i];\n        sum += texture2D(sTexture, texCoord - stepOffset) * gaussianWeights[i];\n    }\n    return sum;\n}\n" + r102;
    L19:
        return r101 + "vec4 gaussianBlurKernel(vec4 oriColor, vec2 texCoord) {\n    return oriColor;\n}\n" + r102;
    L10:
        r101 = "precision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float gaussianAlpha;\nuniform vec4 layoutCoord;//x,y,w,h\nuniform float processStage;//0:stage1;1:stage2\nuniform vec2 blurAreaParam;//x:blur edge size;y:blur area scale\n";
        r102 = "// return 1 if v inside the box, return 0 otherwise\nfloat insideBox(vec2 v, vec2 bottomLeft, vec2 topRight) {\n    vec2 s = step(bottomLeft, v) - step(topRight, v);\n    return s.x * s.y;\n}\n//pointer to box edge distance\nfloat pointToBoxDistance(vec2 v, vec2 bottomLeft, vec2 topRight, float edge) {\n    vec2 distance = smoothstep(0.0, blurAreaParam.x, abs(v - (bottomLeft + topRight) / 2.0) - (topRight - bottomLeft) / 2.0);\n    return sqrt(distance.x * distance.x + distance.y * distance.y);\n}\n\nvoid main() {\n    vec2 stage1Coord = vec2((vTextureCoord.x - layoutCoord.x) / layoutCoord.z, (vTextureCoord.y - layoutCoord.y) / layoutCoord.w);\n    vec2 resetCoord = (1.0 - processStage) * stage1Coord + processStage * vTextureCoord;\n    vec2 oriBoxBottomLeft = vec2(layoutCoord.x, layoutCoord.y);\n    vec2 oriBoxTopRight = vec2(layoutCoord.x+layoutCoord.z, layoutCoord.y+layoutCoord.w);\n    if (insideBox(vTextureCoord, oriBoxBottomLeft, oriBoxTopRight) > 0.5) {\n        gl_FragColor = texture2D(sTexture, resetCoord);\n        return;\n    } else {\n        float scale = blurAreaParam.y * (1.0 - processStage) + processStage * 1.0;\n        if (resetCoord.y <= 0.0 || resetCoord.y >= 1.0) {\n            resetCoord.x = (resetCoord.x - 0.5) * scale + 0.5;\n            if (resetCoord.y < 0.0) {\n                resetCoord.y = resetCoord.y * scale;\n            } else {\n                resetCoord.y = (resetCoord.y-1.0)*scale+1.0;\n            }\n        } else {\n            if (resetCoord.x < 0.0) {\n                resetCoord.x = resetCoord.x * scale;\n            } else {\n                resetCoord.x = (resetCoord.x-1.0)*scale+1.0;\n            }\n            resetCoord.y = (resetCoord.y - 0.5) * scale + 0.5;\n        }\n        vec4 oriColor = texture2D(sTexture, resetCoord);\n        float edgeCoeff = pointToBoxDistance(vTextureCoord, oriBoxBottomLeft, oriBoxTopRight, blurAreaParam.x);\n        gl_FragColor = gaussianBlurKernel(oriColor, resetCoord, edgeCoeff);\n    }\n}\n";
    L25:
        return super.getStringOption(r100);
    L21:
        if (this.mInTextureTarget != 36197) goto L25;
        return "uniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
    }

    @Override // com.ss.texturerender.effect.GLGaussianBlurFilter, com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public int init(Bundle r100) {
        this.mInTextureTarget = r100.getInt(TextureRenderKeys.KEY_IS_TEXTURE_TYPE);
        this.mSigma = r100.getFloat(TextureRenderKeys.KEY_IS_STRENGTH_FLOAT, -1.0f);
        this.mRepeatType = r100.getInt(TextureRenderKeys.KEY_IS_TEXTURE_REPEAT_TYPE, 2);
        this.mEdgeSize = r100.getFloat(TextureRenderKeys.KEY_IS_EDGE_SIZE, 0.0f);
        if (r100.containsKey("x") == false) goto L5;
        this.mDisplayX = r100.getFloat("x", 0.0f);
        this.mDisplayY = r100.getFloat("y", 0.0f);
        this.mDisplayWidth = r100.getFloat("width", 1.0f);
        this.mDisplayHeight = r100.getFloat("height", 1.0f);
    L8:
        this.mGaussinScale = 1.0f / r100.getFloat("scale", 1.0f);
        int r101 = super.init(r100);
        if (r101 != 0) goto L11;
        this.mLayoutCoordLoc = GLES20.glGetUniformLocation(this.mProgram, "layoutCoord");
        this.mProcessStageLoc = GLES20.glGetUniformLocation(this.mProgram, "processStage");
        this.mBlurAreaParamLoc = GLES20.glGetUniformLocation(this.mProgram, "blurAreaParam");
    L11:
        this.muSTMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uSTMatrix");
        this.mRepeatLoc = GLES20.glGetUniformLocation(this.mProgram, "repeadMode");
        GLES20.glUseProgram(this.mProgram);
        int r102 = this.mRepeatLoc;
        if (r102 >= 0) goto L14;
    L16:
        int r103 = this.mBlurAreaParamLoc;
        if (r103 < 0) goto L19;
        GLES20.glUniform2f(r103, this.mEdgeSize, this.mGaussinScale);
    L19:
        float r104 = this.mDisplayX;
        if (r104 < 0.0f) goto L22;
        GLES20.glUniform4f(this.mLayoutCoordLoc, r104, this.mDisplayY, this.mDisplayWidth, this.mDisplayHeight);
    L22:
        return r101;
    L14:
        if (this.mInTextureTarget != 36197) goto L16;
        GLES20.glUniform1i(r102, this.mRepeatType);
        goto L16
    L5:
        this.mLayoutAspectRatio = r100.getFloat(TextureRenderKeys.KEY_IS_ASPECT_RATIO, 0.5f);
        if (this.mLayoutCoord != null) goto L8;
        this.mLayoutCoord = new float[4];
        goto L8
    }

    @Override // com.ss.texturerender.effect.GLGaussianBlurFilter, com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture r100, FrameBuffer r110) {
        this.mInTexWidth = r100.getWidth();
        this.mInTexHeight = r100.getHeight();
        this.mSurfaceWidth = this.mSurfaceTexture.getViewportWidth();
        this.mSurfaceHeight = this.mSurfaceTexture.getViewportHeight();
        return processWithTwoPass(r100, r110, this.mEnableSecondPass, this.mRenderToScreen, true, false);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int updateRenderParam(EffectTexture r100, FrameBuffer r101) {
        if (r101 != null) goto L5;
        this.mViewPortWidth = this.mSurfaceWidth;
        this.mViewPortHeight = this.mSurfaceHeight;
        this.mViewPortY = 0;
        this.mViewPortX = 0;
    L10:
        return 0;
    L5:
        float r102 = (this.mSurfaceHeight * 1.0f) / this.mSurfaceWidth;
        if (r102 <= ((r100.getHeight() * 1.0f) / r100.getWidth())) goto L8;
        int r103 = Math.min(this.mSurfaceWidth, r100.getWidth());
        this.mOutTexWidth = r103;
        this.mOutTexHeight = (int) ((r103 * r102) + 0.5f);
    L9:
        this.mViewPortWidth = this.mOutTexWidth;
        this.mViewPortHeight = this.mOutTexHeight;
        this.mViewPortY = 0;
        this.mViewPortX = 0;
        goto L10
    L8:
        int r104 = Math.min(this.mSurfaceHeight, r100.getHeight());
        this.mOutTexHeight = r104;
        this.mOutTexWidth = (int) ((r104 / r102) + 0.5f);
        goto L9
    }

    private void updateLayoutCoord(float r100, float r101, int r102, float r110, float[] r111) {
        if (r102 == 0) goto L4;
        return;
    L4:
        if (r100 <= r101) goto L6;
        float r103 = r101 / r100;
        r111[0] = 0.0f;
        r111[1] = (1.0f - r103) * r110;
        r111[2] = 1.0f;
        r111[3] = r103;
        return;
    L6:
        float r104 = r100 / r101;
        r111[0] = (1.0f - r104) * r110;
        r111[1] = 0.0f;
        r111[2] = r104;
        r111[3] = 1.0f;
    }
}
