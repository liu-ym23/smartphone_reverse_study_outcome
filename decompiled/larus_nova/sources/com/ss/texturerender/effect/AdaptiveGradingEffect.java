package com.ss.texturerender.effect;

import android.os.Bundle;
import com.ss.texturerender.AdaptiveGradingWrapper;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;

/* JADX INFO: loaded from: classes40.dex */
public class AdaptiveGradingEffect extends AbsEffect {
    private static final int PROCESS_NEED_BMF_COMPUTE = -2;
    private static final int PROCESS_NO_NEED_PROCESS = -1;
    private AdaptiveGradingWrapper mAdaptiveGradingWrappers;
    private float mDstBrightness;
    private float mDstContrast;
    private float mDstSaturation;
    private long mGopTimeMs;
    private boolean mIsNewFrame;
    private int mMaxHeight;
    private int mMaxWidth;
    private float mSrcBrightness;
    private float mSrcContrast;
    private float mSrcSaturation;
    private float[] mStMatrix;
    private long mStartPlayTime;

    @Override // com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        this.mAdaptiveGradingWrappers.free();
        this.mAdaptiveGradingWrappers = null;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "release");
        return super.release();
    }

    public AdaptiveGradingEffect(int r100) {
        super(r100, 14);
        this.mGopTimeMs = 2000;
        this.mStartPlayTime = 0;
        this.mOrder = 6;
        this.mAdaptiveGradingWrappers = new AdaptiveGradingWrapper(r100);
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public int init(Bundle r110) {
        int r100 = super.init(r110);
        if (r100 >= 0) goto L5;
        return r100;
    L5:
        float[] r101 = new float[2];
        float[] r102 = new float[2];
        float[] r103 = new float[2];
        if (r110 == null) goto L8;
        this.mMaxWidth = r110.getInt(TextureRenderKeys.KEY_IS_MAX_WIDTH);
        this.mMaxHeight = r110.getInt(TextureRenderKeys.KEY_IS_MAX_HEIGHT);
        String r104 = r110.getString(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_CACHE_FILE);
        this.mGopTimeMs = r110.getLong(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_GOP_TIME_MS);
        r101 = r110.getFloatArray(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_BRIGHTNESS_THRESHOLD);
        r102 = r110.getFloatArray(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_CONTRAST_THRESHOLD);
        float[] r105 = r110.getFloatArray(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_SATURATION_THRESHOLD);
        String r106 = r104;
    L9:
        float[] r107 = r101;
        float[] r108 = r102;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "AdaptiveGrading width=" + this.mMaxWidth + "::height=" + this.mMaxHeight);
        if (this.mAdaptiveGradingWrappers.init(this.mMaxWidth, this.mMaxHeight, r106, r107, r108, r105) == false) goto L12;
        return 0;
    L12:
        return -1;
    L8:
        r106 = "";
        r105 = r103;
        goto L9
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public void setOption(Bundle r100) {
        super.setOption(r100);
        if (r100 != null) goto L12;
        return;
    L12:
        this.mDstBrightness = getBundleValue(r100, TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_DST_BRIGHTNESS, this.mDstBrightness);     // Catch: Exception -> L9
        this.mDstContrast = getBundleValue(r100, TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_DST_CONTRAST, this.mDstContrast);     // Catch: Exception -> L9
        this.mDstSaturation = getBundleValue(r100, TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_DST_SATURATION, this.mDstSaturation);     // Catch: Exception -> L9
        this.mSrcSaturation = getBundleValue(r100, TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_SRC_SATURATION, this.mSrcSaturation);     // Catch: Exception -> L9
        this.mSrcContrast = getBundleValue(r100, TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_SRC_CONTRAST, this.mSrcContrast);     // Catch: Exception -> L9
        this.mSrcBrightness = getBundleValue(r100, TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_SRC_BRIGHTNESS, this.mSrcBrightness);     // Catch: Exception -> L9
        boolean r101 = r100.getBoolean(TextureRenderKeys.KEY_IS_ADAPTIVE_GRADING_IS_NEW_FRAME);     // Catch: Exception -> L9
        this.mIsNewFrame = r101;     // Catch: Exception -> L9
        if (r101 == false) goto L14;
        this.mStartPlayTime = 0;     // Catch: Exception -> L9
        this.mSrcBrightness = 0.0f;     // Catch: Exception -> L9
        this.mSrcContrast = 0.0f;     // Catch: Exception -> L9
        this.mSrcSaturation = 0.0f;     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "AdaptiveGrading ex=" + e);
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture r210, FrameBuffer r211) {
        if (this.mSurfaceTexture != null) goto L5;
    L41:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "process mAdaptiveGradingWrappers null");
        return r210;
    L5:
        if (this.mAdaptiveGradingWrappers == null) goto L41;
        if (r210 == null) goto L41;
        float r100 = this.mSrcBrightness;
        if (r100 != (-1.0f)) goto L17;
        if (this.mSrcContrast != (-1.0f)) goto L17;
        if (this.mSrcSaturation != (-1.0f)) goto L17;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "process no need");
        return r210;
    L17:
        if (r100 != 0.0f) goto L27;
        if (this.mSrcContrast != 0.0f) goto L27;
        if (this.mSrcSaturation != 0.0f) goto L27;
        if ((System.currentTimeMillis() - this.mStartPlayTime) <= this.mGopTimeMs) goto L25;
        this.mSrcBrightness = -2.0f;
        this.mSrcContrast = -2.0f;
        this.mSrcSaturation = -2.0f;
        goto L27
    L25:
        return r210;
    L27:
        if (r210.getTexTarget() == 36197) goto L29;
        EffectTexture r101 = new EffectTexture(null, this.mAdaptiveGradingWrappers.process(r210.getTexID(), r210.getWidth(), r210.getHeight(), this.mSrcBrightness, this.mDstBrightness, this.mSrcContrast, this.mDstContrast, this.mSrcSaturation, this.mDstSaturation, this.mIsNewFrame), r210.getWidth(), r210.getHeight(), 3553, r210.getRect());
        r210.giveBack();
    L38:
        if (this.mIsNewFrame == false) goto L40;
        this.mStartPlayTime = System.currentTimeMillis();
        this.mIsNewFrame = false;
    L40:
        return r101;
    L29:
        if (this.mStMatrix != null) goto L31;
        this.mStMatrix = new float[16];
    L31:
        this.mSurfaceTexture.getTransformMatrix(this.mStMatrix);
        int r102 = this.mAdaptiveGradingWrappers.processOES(r210.getTexID(), r210.getWidth(), r210.getHeight(), this.mStMatrix, this.mSrcBrightness, this.mDstBrightness, this.mSrcContrast, this.mDstContrast, this.mSrcSaturation, this.mDstSaturation, this.mIsNewFrame);
        if (r102 != r210.getTexID()) goto L34;
        int r212 = r210.getTexTarget();
    L35:
        r101 = new EffectTexture(null, r102, r210.getWidth(), r210.getHeight(), r212, r210.getRect());
        goto L38
    L34:
        r212 = 3553;
        goto L35
    }

    private float getBundleValue(Bundle r100, String r101, float r102) {
        float r103 = r100.getFloat(r101);
        if (r103 != 0.0f) goto L5;
        return r102;
    L5:
        return r103;
    }
}
