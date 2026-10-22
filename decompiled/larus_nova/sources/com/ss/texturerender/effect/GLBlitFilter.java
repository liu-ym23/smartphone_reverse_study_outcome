package com.ss.texturerender.effect;

import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Bundle;
import com.ss.texturerender.TexGLUtils;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.TextureRenderer;
import com.ss.texturerender.VideoSurfaceTexture;

/* JADX INFO: loaded from: classes40.dex */
public class GLBlitFilter extends GLDefaultFilter {
    protected int mFrameBufferTarget;
    protected int mGLError;
    protected int mIsCallGLfinish;
    protected int mLayoutMode;
    protected boolean mNeedClear;
    protected int mOutTexHeight;
    protected int mOutTexWidth;
    protected int mProcessSuccess;
    protected FrameBuffer mReadFrameBuffer;
    protected int mSrcx0;
    protected int mSrcx1;
    protected int mSrcy0;
    protected int mSrcy1;
    protected int mViewPortHeight;
    protected int mViewPortWidth;
    protected int mViewPortX;
    protected int mViewPortY;

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public EffectTexture genTexture() {
        TextureRenderer r100 = this.mParentRender;
        if (r100 != null) goto L5;
    L13:
        return null;
    L5:
        if (r100.getEffectTextureManager() == null) goto L13;
        if (this.mSurfaceTexture == null) goto L12;
        return this.mParentRender.getEffectTextureManager().genTexture(this.mOutTexWidth, this.mOutTexHeight, this.mSurfaceTexture.getIntOption(130), null);
    L12:
        return this.mParentRender.getEffectTextureManager().genTexture(this.mOutTexWidth, this.mOutTexHeight, null);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        FrameBuffer r100 = this.mReadFrameBuffer;
        if (r100 == null) goto L6;
        r100.release();
        this.mReadFrameBuffer = null;
    L6:
        return super.release();
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public void resetCropParams() {
        Bundle r100 = new Bundle();
        r100.putInt("action", 21);
        r100.putInt("effect_type", 11);
        r100.putFloat("width", 1.0f);
        r100.putFloat("height", 1.0f);
        r100.putFloat("x", 0.0f);
        r100.putFloat("y", 0.0f);
        setOption(r100);
    }

    public GLBlitFilter(int r100) {
        this(r100, 25);
    }

    public void glblitAfter(FrameBuffer r100) {
        GLES20.glFramebufferTexture2D(36008, 36064, 3553, 0, 0);
        GLES30.glBindFramebuffer(36008, 0);
        GLES30.glBindFramebuffer(36009, 0);
        if (r100 == null) goto L5;
        r100.unbindTexture();
        return;
    L5:
        GLES30.glBindFramebuffer(36160, 0);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public int init(Bundle r100) {
        VideoSurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 == null) goto L8;
        if (r101.getIntOption(126, this.mEffectType) != (-1)) goto L8;
        this.mSurfaceTexture.setOption(126, this.mEffectType, 0);
    L8:
        if (this.mReadFrameBuffer != null) goto L10;
        this.mReadFrameBuffer = new FrameBuffer();
    L10:
        return 0;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public void setOption(Bundle r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = r100.getInt("action", -1);
        if (r100.getInt("effect_type", -1) == 11) goto L7;
        return;
    L7:
        if (r101 != 21) goto L9;
    L12:
        float r102 = r100.getFloat("width", 1.0f);
        float r103 = r100.getFloat("height", 1.0f);
        float r104 = 0.0f;
        float r105 = r100.getFloat("x", 0.0f);
        float r106 = r100.getFloat("y", 0.0f);
        if (r105 <= 1.0f) goto L15;
        return;
    L15:
        if (r105 >= 0.0f) goto L17;
        return;
    L17:
        if (r106 <= 1.0f) goto L19;
        return;
    L19:
        if (r106 >= 0.0f) goto L21;
        return;
    L21:
        if (r102 > 0.0f) goto L23;
        return;
    L23:
        if (r103 > 0.0f) goto L25;
        return;
    L25:
        if (r106 == this.mCropYNormalize) goto L27;
    L33:
        this.mCropWidthNormalize = r102;
        this.mCropHeightNormalize = r103;
        this.mCropXNormalize = r105;
        this.mCropYNormalize = r106;
        if (r105 >= 0.0f) goto L36;
        r105 = 0.0f;
    L36:
        this.mCropXNormalize = r105;
        if (r106 < 0.0f) goto L40;
        r104 = r106;
    L40:
        this.mCropYNormalize = r104;
        if ((r105 + r102) <= 1.0f) goto L43;
        r102 = 1.0f - r105;
    L43:
        this.mCropWidthNormalize = r102;
        if ((r104 + r103) <= 1.0f) goto L46;
        r103 = 1.0f - r104;
    L46:
        this.mCropHeightNormalize = r103;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "param set success, bundle:" + r100);
        return;
    L27:
        if (r105 != this.mCropXNormalize) goto L33;
        if (r102 != this.mCropWidthNormalize) goto L33;
        if (r103 != this.mCropHeightNormalize) goto L33;
        return;
    L9:
        if (r101 == 28) goto L12;
        if (r101 == 35) goto L12;
    }

    public GLBlitFilter(int r100, int r101) {
        super(r100, r101);
        this.mReadFrameBuffer = null;
        this.mViewPortX = 0;
        this.mViewPortY = 0;
        this.mViewPortWidth = -1;
        this.mViewPortHeight = -1;
        this.mNeedClear = true;
        this.mIsCallGLfinish = 1;
        this.mGLError = 0;
        this.mLayoutMode = 1;
        this.mSrcx0 = 0;
        this.mSrcx1 = 0;
        this.mSrcy0 = 0;
        this.mSrcy1 = 0;
        this.mProcessSuccess = Integer.MIN_VALUE;
        this.mInTextureTarget = 3553;
        this.mOrder = -1;
        this.mFrameBufferTarget = 36160;
    }

    public int glBlitProcess(FrameBuffer r110, EffectTexture r111) {
        if (r110 == null) goto L5;
        GLES30.glBindFramebuffer(36009, r110.getFboId());
        GLES30.glDrawBuffers(1, new int[]{36064}, 0);
    L6:
        GLES30.glBindFramebuffer(36008, this.mReadFrameBuffer.getFboId());
        GLES20.glFramebufferTexture2D(36008, 36064, 3553, r111.getTexID(), 0);
        if (GLES20.glCheckFramebufferStatus(36008) == 36053) goto L10;
        return -1;
    L10:
        GLES30.glReadBuffer(36064);
        int r100 = this.mSrcx0;
        int r101 = this.mSrcy0;
        int r102 = this.mSrcx1;
        int r103 = this.mSrcy1;
        int r104 = this.mViewPortX;
        int r112 = this.mViewPortY;
        GLES30.glBlitFramebuffer(r100, r101, r102, r103, r104, r112, r104 + this.mViewPortWidth, r112 + this.mViewPortHeight, 16384, 9729);
        if (this.mProcessSuccess == 0) goto L13;
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "gl blit success");
        this.mProcessSuccess = 0;
    L13:
        return 0;
    L5:
        GLES30.glBindFramebuffer(36160, 0);
        GLES30.glBindFramebuffer(36009, 0);
        GLES30.glDrawBuffers(1, new int[]{1029}, 0);
        goto L6
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture r110, FrameBuffer r111) {
        if (r110 != null) goto L4;
    L96:
        return r110;
    L4:
        if (this.mReadFrameBuffer == null) goto L96;
        VideoSurfaceTexture r100 = this.mSurfaceTexture;
        int r101 = 0;
        if (r100 == null) goto L12;
        if (r100.getIntOption(126, this.mEffectType) != (-1)) goto L12;
        this.mSurfaceTexture.setOption(126, this.mEffectType, 0);
    L12:
        if (r110.getTexTarget() == this.mInTextureTarget) goto L17;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "error, texture miss match, accept:" + this.mInTextureTarget + ",in:" + r110.getTexTarget());
        VideoSurfaceTexture r112 = this.mSurfaceTexture;
        if (r112 == null) goto L16;
        r112.notifyError(12, this.mEffectType, "error, texture miss match, accept:" + this.mInTextureTarget + ",in:" + r110.getTexTarget());
    L16:
        return r110;
    L17:
        int r102 = TexGLUtils.checkGLError(this.mTexType, "filter process start,type:" + this.mEffectType);
        if (r102 == 0) goto L23;
        this.mGLError = -1;
        VideoSurfaceTexture r113 = this.mSurfaceTexture;
        if (r113 == null) goto L22;
        r113.notifyError(r102, this.mEffectType, "");
    L22:
        return r110;
    L23:
        VideoSurfaceTexture r103 = this.mSurfaceTexture;
        if (r103 == null) goto L26;
        r103.currentEffectProcessBegin(this.mEffectType);
    L26:
        updateDefaultRenderParam(r110, r111);
        if (r111 != null) goto L29;
        EffectTexture r104 = null;
    L43:
        Boolean r105 = Boolean.valueOf(this.mNeedClear);
        VideoSurfaceTexture r106 = this.mSurfaceTexture;
        if (r106 == null) goto L49;
        if (r106.getIntOption(179) == 0) goto L49;
        r105 = Boolean.FALSE;
    L49:
        if (this.mNeedClear == true) goto L51;
    L53:
        int r107 = TexGLUtils.checkGLError(this.mTexType, "filter glDrawArrays before,type:" + this.mEffectType);
        if (r107 != 0) goto L56;
        this.mGLError = glBlitProcess(r111, r110);
    L59:
        int r108 = this.mIsCallGLfinish;
        VideoSurfaceTexture r109 = this.mSurfaceTexture;
        if (r109 != null) goto L62;
    L64:
        r101 = r108;
    L65:
        VideoSurfaceTexture r114 = this.mSurfaceTexture;
        if (r114 == null) goto L71;
        if (r114.getLastComeFrameType() != 3) goto L71;
        r101 = 1;
    L71:
        if (this.mIsCallGLfinish != 1) goto L74;
        if (r101 != 1) goto L74;
        GLES20.glFinish();
    L74:
        glblitAfter(r111);
        VideoSurfaceTexture r115 = this.mSurfaceTexture;
        if (r115 == null) goto L77;
        r115.currentEffectProcessEnd(this.mEffectType);
    L77:
        int r116 = TexGLUtils.checkGLError(this.mTexType, "filter glDrawArrays after,type:" + this.mEffectType);
        if (this.mGLError != 0) goto L87;
        if (r116 != 0) goto L87;
        VideoSurfaceTexture r117 = this.mSurfaceTexture;
        if (r117 == null) goto L85;
        r117.setOption(19, this.mEffectType, 1);
        if (this.mTrackEvent == false) goto L85;
        this.mSurfaceTexture.getEventLogger().setViewPort(this.mViewPortX, this.mViewPortY, this.mViewPortWidth, this.mViewPortHeight);
        this.mSurfaceTexture.getEventLogger().setTexSize(r110.getWidth(), r110.getHeight());
        this.mSurfaceTexture.getEventLogger().setUseGLBlit(1);
    L85:
        r110.giveBack();
        return r104;
    L87:
        VideoSurfaceTexture r118 = this.mSurfaceTexture;
        if (r118 == null) goto L90;
        r118.notifyError(r116, this.mEffectType, "filter glDrawArrays after,type:" + this.mEffectType);
    L90:
        if (r104 == null) goto L92;
        r104.giveBack();
    L92:
        if (r111 != null) goto L95;
        r110.giveBack();
        this.mGLError = -1;
        return null;
    L95:
        this.mGLError = -1;
        goto L96
    L62:
        if (r109.getIntOption(183) == 0) goto L64;
    L56:
        this.mGLError = -1;
        VideoSurfaceTexture r119 = this.mSurfaceTexture;
        if (r119 == null) goto L59;
        r119.notifyError(r107, this.mEffectType, "filter glDrawArrays before,type:" + this.mEffectType);
        goto L59
    L51:
        if (r105.booleanValue() == false) goto L53;
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        goto L53
    L29:
        if (r111.mFrameBufferTarget == this.mFrameBufferTarget) goto L32;
        return r110;
    L32:
        if (this.mOutTexWidth != 0) goto L34;
    L35:
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "error width or height, w:" + this.mOutTexWidth + " h:" + this.mOutTexHeight);
        VideoSurfaceTexture r120 = this.mSurfaceTexture;
        if (r120 == null) goto L38;
        r120.notifyError(14, this.mEffectType, "error width or height, w:" + this.mOutTexWidth + " h:" + this.mOutTexHeight);
    L38:
        r104 = genTexture();
        if (r104 != null) goto L41;
        return r110;
    L41:
        r111.bindTexture(r104.getTexID());
        goto L43
    L34:
        if (this.mOutTexHeight != 0) goto L38;
        goto L35
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public void setOption(int r100, int r101) {
        if (r100 == 26) goto L19;
        if (r100 == 20006) goto L17;
        switch(r100) {
            case 10006: goto L16;
            case 10007: goto L15;
            case 10008: goto L14;
            case 10009: goto L13;
            case 10010: goto L8;
            default: goto L7;
        };
    L7:
        super.setOption(r100, r101);
        return;
    L8:
        boolean r102 = true;
        if (r101 == 1) goto L12;
        r102 = false;
    L12:
        this.mNeedClear = r102;
        return;
    L13:
        this.mViewPortY = r101;
        return;
    L14:
        this.mViewPortX = r101;
        return;
    L15:
        this.mViewPortHeight = r101;
        return;
    L16:
        this.mViewPortWidth = r101;
        return;
    L17:
        this.mIsCallGLfinish = r101;
        return;
    L19:
        if (this.mLayoutMode == r101) goto L29;
        this.mLayoutMode = r101;
        return;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int updateDefaultRenderParam(EffectTexture r110, FrameBuffer r111) {
        int r100 = Math.round(r110.getWidth());
        int r112 = Math.round(r110.getHeight());
        if (r111 == null) goto L5;
        this.mOutTexWidth = r100;
        this.mOutTexHeight = r112;
        this.mViewPortWidth = r100;
        this.mViewPortHeight = r112;
        this.mViewPortY = 0;
        this.mViewPortX = 0;
    L44:
        return 0;
    L5:
        int r113 = this.mViewPortWidth;
        int r101 = this.mViewPortHeight;
        float r102 = r112;
        float r103 = r100;
        float r104 = (r102 * 1.0f) / r103;
        float r105 = r101 * 1.0f;
        float r106 = r113;
        float r107 = r105 / r106;
        this.mViewPortY = 0;
        this.mViewPortX = 0;
        this.mSrcy0 = 0;
        this.mSrcx0 = 0;
        this.mSrcx1 = r100;
        this.mSrcy1 = r112;
        int r114 = this.mLayoutMode;
        if (r114 != 0) goto L21;
        this.mSrcy0 = 0;
        this.mSrcx0 = 0;
        this.mSrcx1 = r100;
        this.mSrcy1 = r112;
        float r115 = this.mCropXNormalize;
        if (r115 <= 0.0f) goto L10;
    L15:
        int r108 = (int) (r115 * r103);
        this.mSrcx0 = r108;
        this.mSrcy0 = (int) (this.mCropYNormalize * r102);
        int r109 = (int) (this.mCropWidthNormalize * r103);
        int r116 = (int) (this.mCropHeightNormalize * r102);
        this.mSrcx1 = Math.min(r108 + r109, r100);
        int r117 = Math.min(this.mSrcy0 + r116, r112);
        this.mSrcy1 = r117;
        r104 = ((r117 - this.mSrcy0) * 1.0f) / (this.mSrcx1 - this.mSrcx0);
    L17:
        if (r107 <= r104) goto L19;
        this.mViewPortWidth = r113;
        int r118 = (int) ((r106 * 1.0f) * r104);
        this.mViewPortHeight = r118;
        this.mViewPortX = 0;
        this.mViewPortY = (int) ((r101 - r118) * this.mLayoutAspectRatio);
        goto L44
    L19:
        int r119 = (int) (r105 / r104);
        this.mViewPortWidth = r119;
        this.mViewPortHeight = r101;
        this.mViewPortX = (int) ((r113 - r119) * this.mLayoutAspectRatio);
        this.mViewPortY = 0;
        goto L44
    L10:
        if (this.mCropYNormalize > 0.0f) goto L15;
        if (this.mCropWidthNormalize < 1.0f) goto L15;
        if (this.mCropHeightNormalize >= 1.0f) goto L17;
    L21:
        if (r114 != 2) goto L35;
        this.mViewPortWidth = r113;
        this.mViewPortHeight = r101;
        this.mViewPortY = 0;
        this.mViewPortX = 0;
        float r120 = this.mCropXNormalize;
        if (r120 <= 0.0f) goto L25;
    L30:
        int r121 = (int) (r120 * r103);
        this.mSrcx0 = r121;
        this.mSrcy0 = (int) (this.mCropYNormalize * r102);
        int r122 = (int) (this.mCropWidthNormalize * r103);
        int r123 = (int) (this.mCropHeightNormalize * r102);
        this.mSrcx1 = Math.min(r121 + r122, r100);
        int r124 = Math.min(this.mSrcy0 + r123, r112);
        this.mSrcy1 = r124;
        r100 = this.mSrcx1 - this.mSrcx0;
        r112 = r124 - this.mSrcy0;
        r104 = (r112 * 1.0f) / r100;
    L32:
        if (r107 <= r104) goto L34;
        int r125 = (int) ((r112 * 1.0f) / r107);
        int r126 = this.mSrcx0 + ((int) ((((double) (r100 - r125)) * 1.0d) * ((double) this.mLayoutAspectRatio)));
        this.mSrcx0 = r126;
        this.mSrcx1 = r126 + r125;
        goto L44
    L34:
        int r127 = (int) (r107 * r100);
        int r128 = this.mSrcy0 + ((int) ((((double) (r112 - r127)) * 1.0d) * ((double) this.mLayoutAspectRatio)));
        this.mSrcy0 = r128;
        this.mSrcy1 = r128 + r127;
        goto L44
    L25:
        if (this.mCropYNormalize > 0.0f) goto L30;
        if (this.mCropWidthNormalize < 1.0f) goto L30;
        if (this.mCropHeightNormalize >= 1.0f) goto L32;
    L35:
        this.mViewPortWidth = r113;
        this.mViewPortHeight = r101;
        this.mViewPortY = 0;
        this.mViewPortX = 0;
        this.mSrcy0 = 0;
        this.mSrcx0 = 0;
        this.mSrcx1 = r100;
        this.mSrcy1 = r112;
        float r129 = this.mCropXNormalize;
        if (r129 <= 0.0f) goto L38;
    L43:
        int r130 = (int) (r129 * r103);
        this.mSrcx0 = r130;
        this.mSrcy0 = (int) (this.mCropYNormalize * r102);
        int r131 = (int) (this.mCropWidthNormalize * r103);
        int r132 = (int) (this.mCropHeightNormalize * r102);
        this.mSrcx1 = Math.min(r130 + r131, r100);
        this.mSrcy1 = Math.min(this.mSrcy0 + r132, r112);
        goto L44
    L38:
        if (this.mCropYNormalize > 0.0f) goto L43;
        if (this.mCropWidthNormalize < 1.0f) goto L43;
        if (this.mCropHeightNormalize >= 1.0f) goto L44;
        goto L43
    }
}
