package com.ss.texturerender.effect;

import android.opengl.GLES20;
import android.os.Bundle;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.VideoSurfaceTexture;

/* JADX INFO: loaded from: classes40.dex */
public class GLLut3DFilter extends GLDefaultFilter {
    private final String fragmentShader;
    private int mLutTextureHandle;
    private int mLutTextureId;
    private float mStrength;
    private int mStrengthHandle;
    private final String vertexShader;

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "release");
        return super.release();
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int onDrawFrameAfter() {
        GLES20.glBindTexture(32879, 0);
        return 0;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int onDrawFrameBefore() {
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(32879, this.mLutTextureId);
        GLES20.glUniform1i(this.mLutTextureHandle, 1);
        GLES20.glUniform1f(this.mStrengthHandle, this.mStrength);
        return 0;
    }

    public GLLut3DFilter(int r100) {
        super(r100, 2);
        this.vertexShader = "#version 300 es\nin vec4 aPosition;\nin vec4 aTextureCoord;\nout vec2 vTextureCoord;\nvoid main() {\n  gl_Position =  aPosition;\n  vTextureCoord = aTextureCoord.xy;\n}\n";
        this.fragmentShader = "#version 300 es\nprecision mediump float;\nuniform sampler2D sTexture;\nuniform mediump sampler3D lutTexture;\nin vec2 vTextureCoord;\nuniform float strength;\nout vec4 fragColor;\nvoid main() {\n    vec4 inputTexColor = texture(sTexture, vTextureCoord);\n    highp vec3 coord = 0.96969696969f * inputTexColor.rgb + 0.01515151515f;\n    vec4 newColor = texture(lutTexture, coord);\n    fragColor = mix(inputTexColor, vec4(newColor.rgb, inputTexColor.w), strength);\n}";
        this.mStrength = 1.0f;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "new GLLut3DFilter");
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public String getStringOption(int r100) {
        if (r100 != 11000) goto L5;
        return "#version 300 es\nin vec4 aPosition;\nin vec4 aTextureCoord;\nout vec2 vTextureCoord;\nvoid main() {\n  gl_Position =  aPosition;\n  vTextureCoord = aTextureCoord.xy;\n}\n";
    L5:
        if (r100 != 11001) goto L7;
        return "#version 300 es\nprecision mediump float;\nuniform sampler2D sTexture;\nuniform mediump sampler3D lutTexture;\nin vec2 vTextureCoord;\nuniform float strength;\nout vec4 fragColor;\nvoid main() {\n    vec4 inputTexColor = texture(sTexture, vTextureCoord);\n    highp vec3 coord = 0.96969696969f * inputTexColor.rgb + 0.01515151515f;\n    vec4 newColor = texture(lutTexture, coord);\n    fragColor = mix(inputTexColor, vec4(newColor.rgb, inputTexColor.w), strength);\n}";
    L7:
        return super.getStringOption(r100);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public int init(Bundle r100) {
        if (super.init(r100) == 0) goto L9;
        VideoSurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 == null) goto L11;
        r101.notifyInitError(10, this.mEffectType, "super.init(bundle) != TR_OK");
        return -1;
    L11:
        return -1;
    L9:
        this.mStrengthHandle = GLES20.glGetUniformLocation(this.mProgram, TextureRenderKeys.KEY_IS_STRENGTH_FLOAT);
        this.mLutTextureHandle = GLES20.glGetUniformLocation(this.mProgram, "lutTexture");
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "init = " + r100);
        return 0;
    }

    public void setLutTexture(int r100) {
        if (this.mLutTextureId == r100) goto L6;
        this.mLutTextureId = r100;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "set lutTexture = " + this.mLutTextureId);
        return;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture r100, FrameBuffer r101) {
        VideoSurfaceTexture r102 = this.mSurfaceTexture;
        if (r102 == null) goto L6;
        r102.currentEffectProcessBegin(this.mEffectType);
    L6:
        if (this.mLutTextureId <= 0) goto L8;
        r100 = super.process(r100, r101);
    L11:
        VideoSurfaceTexture r103 = this.mSurfaceTexture;
        if (r103 == null) goto L14;
        r103.currentEffectProcessEnd(this.mEffectType);
    L14:
        return r100;
    L8:
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "process failed, invalid lutTexture");
        VideoSurfaceTexture r104 = this.mSurfaceTexture;
        if (r104 == null) goto L11;
        r104.notifyError(7, this.mEffectType, "invalid lutTexture");
        goto L11
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public void setOption(int r100, float r101) {
        if (r100 == 20) goto L6;
        super.setOption(r100, r101);
        return;
    L6:
        if (r101 >= 0.0f) goto L8;
    L13:
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "invalid strength = " + r101);
        return;
    L8:
        if (r101 > 1.0f) goto L13;
        if (this.mStrength == r101) goto L16;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "set strength = " + r101);
        this.mStrength = r101;
        return;
    }
}
