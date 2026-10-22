package com.ss.texturerender.effect;

import android.opengl.GLES20;
import android.os.Bundle;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.VideoSurfaceTexture;

/* JADX INFO: loaded from: classes40.dex */
public class GLSelectiveGaussianBlurFilter3 extends AbsEffect {
    private GLSelectiveGaussianBlurFilter m2DFilter;
    private GLSelectiveGaussianBlurFilterOpt m2DFilterOpt;
    private int mCount;
    private boolean mDisableOpt;
    private GLSelectiveGaussianBlurFilterOptMerge mGLSelectiveGaussianBlurFilterOptMerge;
    private int mGauBlurControlNum;
    private boolean mGauBlurHaveSucessful;
    private VideoSurfaceTexture mLastSurfaceTexture;
    private GLSelectiveGaussianBlurFilter mOesFilter;
    protected int mProcessStage;
    private int mRenderPasses;
    private int mRepeatType;
    protected float mSigma;
    protected int mSurfaceHeight;
    protected int mSurfaceWidth;

    @Override // com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        GLSelectiveGaussianBlurFilter r100 = this.mOesFilter;
        if (r100 == null) goto L5;
        r100.release();
        this.mOesFilter = null;
    L5:
        GLSelectiveGaussianBlurFilter r101 = this.m2DFilter;
        if (r101 == null) goto L8;
        r101.release();
        this.m2DFilter = null;
    L8:
        GLSelectiveGaussianBlurFilterOpt r102 = this.m2DFilterOpt;
        if (r102 == null) goto L11;
        r102.release();
        this.m2DFilterOpt = null;
    L11:
        GLSelectiveGaussianBlurFilterOptMerge r103 = this.mGLSelectiveGaussianBlurFilterOptMerge;
        if (r103 == null) goto L14;
        r103.release();
        this.mGLSelectiveGaussianBlurFilterOptMerge = null;
    L14:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "release");
        return super.release();
    }

    public GLSelectiveGaussianBlurFilter3(int r100) {
        super(r100, 15);
        this.mDisableOpt = false;
        this.m2DFilterOpt = null;
        this.mGLSelectiveGaussianBlurFilterOptMerge = null;
        this.mOesFilter = null;
        this.m2DFilter = null;
        this.mRenderPasses = 2;
        this.mRepeatType = 2;
        this.mSigma = 2.0f;
        this.mProcessStage = 0;
        this.mSurfaceHeight = -1;
        this.mSurfaceWidth = -1;
        this.mLastSurfaceTexture = null;
        this.mEffectType = 15;
        this.mOrder = 4;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "new");
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public int init(Bundle r100) {
        if (this.m2DFilterOpt != null) goto L5;
    L8:
        super.init(r100);
        this.mSigma = r100.getFloat(TextureRenderKeys.KEY_IS_STRENGTH_FLOAT, -1.0f);
        int r101 = r100.getInt(TextureRenderKeys.KEY_IS_TEXTURE_REPEAT_TYPE, 2);
        this.mRepeatType = r101;
        if (this.mSigma > 1.0f) goto L11;
    L13:
        int r102 = 1;
    L14:
        this.mRenderPasses = r102;
        boolean r103 = r100.getBoolean(TextureRenderKeys.KEY_IS_SELSCT_GAUSSBLUR_DISABLE_OPT, false);
        this.mDisableOpt = r103;
        int r104 = 3553;
        if (r103 == false) goto L26;
        this.mIsSupportOes = 1;
        int r105 = r100.getInt(TextureRenderKeys.KEY_IS_TEXTURE_TYPE);
        GLSelectiveGaussianBlurFilter r106 = this.mOesFilter;
        if (r106 == null) goto L20;
        r106.release();
        this.mOesFilter = null;
    L20:
        if (r105 != 36197) goto L22;
        this.mOesFilter = new GLSelectiveGaussianBlurFilter(this.mTexType);
        r100.putInt(TextureRenderKeys.KEY_IS_TEXTURE_TYPE, 36197);
        this.mOesFilter.init(r100);
        this.mOesFilter.setParentRender(this.mParentRender);
        GLSelectiveGaussianBlurFilter r107 = this.mOesFilter;
        r107.mEnableSecondPass = false;
        r107.setOption(20006, 0);
    L22:
        GLSelectiveGaussianBlurFilter r108 = this.m2DFilter;
        if (r108 == null) goto L25;
        r108.release();
    L25:
        this.m2DFilter = new GLSelectiveGaussianBlurFilter(this.mTexType);
        r100.putInt(TextureRenderKeys.KEY_IS_TEXTURE_TYPE, 3553);
        this.m2DFilter.init(r100);
        GLSelectiveGaussianBlurFilter r109 = this.m2DFilter;
        r109.mEnableSecondPass = false;
        r109.setParentRender(this.mParentRender);
        this.m2DFilter.setOption(20006, 0);
        r104 = r105;
    L33:
        this.mInTextureTarget = r104;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "init,texFormat:" + this.mInTextureTarget);
        return 0;
    L26:
        GLSelectiveGaussianBlurFilterOpt r110 = this.m2DFilterOpt;
        if (r110 == null) goto L29;
        r110.release();
    L29:
        this.m2DFilterOpt = new GLSelectiveGaussianBlurFilterOpt(this.mTexType);
        r100.putInt(TextureRenderKeys.KEY_IS_TEXTURE_TYPE, 3553);
        this.m2DFilterOpt.init(r100);
        GLSelectiveGaussianBlurFilterOpt r111 = this.m2DFilterOpt;
        r111.mEnableSecondPass = false;
        r111.setParentRender(this.mParentRender);
        this.m2DFilterOpt.setOption(20006, 0);
        GLSelectiveGaussianBlurFilterOptMerge r112 = this.mGLSelectiveGaussianBlurFilterOptMerge;
        if (r112 == null) goto L32;
        r112.release();
        this.mGLSelectiveGaussianBlurFilterOptMerge = null;
    L32:
        GLSelectiveGaussianBlurFilterOptMerge r113 = new GLSelectiveGaussianBlurFilterOptMerge(this.mTexType);
        this.mGLSelectiveGaussianBlurFilterOptMerge = r113;
        r113.setParentRender(this.mParentRender);
        this.mGLSelectiveGaussianBlurFilterOptMerge.init(r100);
        this.mGauBlurHaveSucessful = false;
        this.mGauBlurControlNum = r100.getInt(TextureRenderKeys.KEY_IS_SELECT_GAUSSBLUR_CONTROL_NUM, 2);
        this.mCount = 0;
        goto L33
    L11:
        if (r101 == 3) goto L13;
        r102 = 2;
        goto L14
    L5:
        if (this.mGLSelectiveGaussianBlurFilterOptMerge == null) goto L8;
        this.mCount = 0;
        return 0;
    }

    private FrameBuffer getFrameBuffer(int r100, FrameBuffer r101) {
        if (this.mDisableOpt == true) goto L6;
        return r101;
    L6:
        if (r100 >= (this.mRenderPasses - 1)) goto L8;
    L11:
        return r101;
    L8:
        if (this.mRenderToScreen == false) goto L11;
        return null;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture r100, FrameBuffer r110) {
        float r101 = r100.getWidth();
        float r102 = r100.getHeight();
        int r103 = this.mSurfaceTexture.getViewportWidth();
        int r104 = this.mSurfaceTexture.getViewportHeight();
        float r105 = (r104 * 1.0f) / r103;
        float r106 = (r102 * 1.0f) / r101;
        if (this.mDisableOpt == true) goto L7;
        if (r105 >= r106) goto L7;
    L8:
        return r100;
    L7:
        if (Math.abs(r105 - r106) < 1.0E-9d) goto L8;
        VideoSurfaceTexture r107 = this.mSurfaceTexture;
        if (r107 == null) goto L12;
        r107.currentEffectProcessBegin(this.mEffectType);
    L12:
        VideoSurfaceTexture r108 = this.mSurfaceTexture;
        boolean r109 = false;
        if (r108 == this.mLastSurfaceTexture) goto L16;
        this.mCount = 0;
        this.mLastSurfaceTexture = r108;
    L16:
        if (r104 == this.mSurfaceHeight) goto L18;
    L19:
        this.mSurfaceHeight = r104;
        this.mSurfaceWidth = r103;
        this.mCount = 0;
    L21:
        if (this.mDisableOpt == false) goto L39;
        this.mProcessStage = 0;
        GLSelectiveGaussianBlurFilter r111 = this.mOesFilter;
        if (r111 == null) goto L25;
        r111.setSurfaceTexture(r108);
        GLSelectiveGaussianBlurFilter r112 = this.mOesFilter;
        int r113 = this.mProcessStage;
        r112.mProcessStage = r113;
        EffectTexture r114 = r112.process(r100, getFrameBuffer(r113, r110));
        this.mProcessStage++;
        float[] r115 = this.mOesFilter.mLayoutCoord;
    L26:
        if (r114 != null) goto L29;
        r114 = r100;
    L29:
        if (this.m2DFilter != null) goto L31;
    L72:
        this.mCount++;
        GLES20.glFinish();
        VideoSurfaceTexture r116 = this.mSurfaceTexture;
        if (r116 == null) goto L75;
        r116.currentEffectProcessEnd(this.mEffectType);
    L75:
        if (r114 == null) goto L77;
        r100 = r114;
    L81:
        if (this.mDisableOpt == true) goto L86;
        if (r109 == true) goto L86;
        return r100;
    L86:
        if (this.mRenderToScreen == false) goto L89;
        return null;
    L89:
        return r100;
    L77:
        if (this.mRenderToScreen == true) goto L81;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "gauopt ret effectTexture is null");
    L31:
        if (this.mProcessStage >= this.mRenderPasses) goto L72;
        this.m2DFilter.setSurfaceTexture(this.mSurfaceTexture);
        GLSelectiveGaussianBlurFilter r117 = this.m2DFilter;
        int r118 = this.mProcessStage;
        r117.mProcessStage = r118;
        if (r115 == null) goto L35;
        r117.mLayoutCoord = r115;
    L35:
        r114 = r117.process(r114, getFrameBuffer(r118, r110));
        this.mProcessStage++;
        r115 = this.m2DFilter.mLayoutCoord;
        if (r114 != null) goto L31;
        r114 = r100;
        goto L31
    L25:
        r114 = null;
        r115 = null;
        goto L26
    L39:
        if ((this.mCount % this.mGauBlurControlNum) != 0) goto L59;
        this.mProcessStage = 0;
        if (this.m2DFilterOpt == null) goto L59;
        EffectTexture r119 = r100;
        float[] r120 = null;
    L44:
        if (this.mProcessStage >= this.mRenderPasses) goto L54;
        this.m2DFilterOpt.setSurfaceTexture(this.mSurfaceTexture);
        GLSelectiveGaussianBlurFilterOpt r121 = this.m2DFilterOpt;
        int r122 = this.mProcessStage;
        r121.mProcessStage = r122;
        if (r120 == null) goto L48;
        r121.mLayoutCoord = r120;
    L48:
        EffectTexture r123 = r121.process(r119, getFrameBuffer(r122, r110));
        this.mProcessStage++;
        float[] r124 = this.m2DFilterOpt.mLayoutCoord;
        if (r123 != null) goto L51;
        r123 = r100;
    L51:
        if (r123 == r100) goto L52;
        r119 = r123;
        r120 = r124;
        goto L44
    L52:
        boolean r125 = true;
    L55:
        if (r125 == false) goto L57;
        this.mGauBlurHaveSucessful = false;
        goto L59
    L57:
        this.mGauBlurHaveSucessful = true;
        goto L59
    L54:
        r125 = false;
    L59:
        if (this.mGLSelectiveGaussianBlurFilterOptMerge == null) goto L71;
        GLSelectiveGaussianBlurFilterOpt r126 = this.m2DFilterOpt;
        if (r126 == null) goto L71;
        if (r126.getSecondGauBlurTexture() == null) goto L71;
        if (this.mGauBlurHaveSucessful == false) goto L71;
        this.mGLSelectiveGaussianBlurFilterOptMerge.setSurfaceTexture(this.mSurfaceTexture);
        this.mGLSelectiveGaussianBlurFilterOptMerge.setGaussianBlurTexture(this.m2DFilterOpt.getSecondGauBlurTexture());
        this.mGLSelectiveGaussianBlurFilterOptMerge.setLayoutCoord(this.m2DFilterOpt.mLayoutCoord);
        GLSelectiveGaussianBlurFilterOptMerge r127 = this.mGLSelectiveGaussianBlurFilterOptMerge;
        GLSelectiveGaussianBlurFilterOpt r128 = this.m2DFilterOpt;
        r127.mHeightFit = r128.mHeightFit;
        r127.updateSurfaceViewPortSize(r128.mSurfaceWidth, r128.mSurfaceHeight);
        if (this.mRenderToScreen == false) goto L69;
        EffectTexture r129 = this.mGLSelectiveGaussianBlurFilterOptMerge.process(r100, null);
    L70:
        r114 = r129;
        r109 = true;
        goto L72
    L69:
        r129 = this.mGLSelectiveGaussianBlurFilterOptMerge.process(r100, r110);
    L71:
        r114 = r100;
        goto L72
    L18:
        if (r103 == this.mSurfaceWidth) goto L21;
        goto L19
    }
}
