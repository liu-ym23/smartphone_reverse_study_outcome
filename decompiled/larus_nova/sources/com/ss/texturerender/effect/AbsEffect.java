package com.ss.texturerender.effect;

import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.os.Bundle;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.TextureRenderer;
import com.ss.texturerender.VideoSurfaceTexture;

/* JADX INFO: loaded from: classes40.dex */
public abstract class AbsEffect {
    public static final int MAX_ORDER = 100;
    public static final int OPTION_EFFECT_CROP_TEXTURE_COORD = 11003;
    public static final int OPTION_EFFECT_FLOATARRAY_TEXTURE_VERTICES = 13000;
    public static final int OPTION_EFFECT_FLOAT_SRCROPSIZEU = 14000;
    public static final int OPTION_EFFECT_FLOAT_SRCROPSIZEV = 14001;
    public static final int OPTION_EFFECT_INT_DO_CLIP = 10017;
    public static final int OPTION_EFFECT_INT_MAX_HEIGHT = 10002;
    public static final int OPTION_EFFECT_INT_MAX_WIDTH = 10001;
    public static final int OPTION_EFFECT_INT_NEED_CLEAR_BEFORE_DRAW = 10010;
    public static final int OPTION_EFFECT_INT_ORDER = 10011;
    public static final int OPTION_EFFECT_INT_POWER_LEVEL = 10003;
    public static final int OPTION_EFFECT_INT_RENDER_TO_SCREEN = 10015;
    public static final int OPTION_EFFECT_INT_SUPPORT_CLIP = 10016;
    public static final int OPTION_EFFECT_INT_SUPPORT_OES = 10014;
    public static final int OPTION_EFFECT_INT_TEXTURE_TARGET_IN = 10004;
    public static final int OPTION_EFFECT_INT_TRACK_EVENT = 10018;
    public static final int OPTION_EFFECT_INT_TYPE = 10005;
    public static final int OPTION_EFFECT_INT_VIEWPORT_HEIGHT = 10007;
    public static final int OPTION_EFFECT_INT_VIEWPORT_WIDTH = 10006;
    public static final int OPTION_EFFECT_INT_VIEWPORT_X = 10008;
    public static final int OPTION_EFFECT_INT_VIEWPORT_Y = 10009;
    public static final int OPTION_EFFECT_INT_VR_MODE = 10012;
    public static final int OPTION_EFFECT_NEED_DIRECT_DRAW = 11004;
    public static final int OPTION_EFFECT_STR_FRAGMENT_SHADER = 11001;
    public static final int OPTION_EFFECT_STR_VERTEX_SHADER = 11000;
    protected final String LOG_TAG;
    protected Bundle mBundle;
    protected boolean mDoClip;
    protected int mEffectType;
    protected int mInTextureTarget;
    protected int mIsSupportClip;
    protected int mIsSupportOes;
    protected AbsEffect mNext;
    protected int mOrder;
    protected TextureRenderer mParentRender;
    protected AbsEffect mPrevious;
    protected boolean mRenderToScreen;
    public VideoSurfaceTexture mSurfaceTexture;
    protected int mTexType;
    protected boolean mTrackEvent;

    public float getFloatOption(int r100) {
        return 0.0f;
    }

    public Object getOption(Bundle r100) {
        return null;
    }

    public String getStringOption(int r100) {
        return "";
    }

    public abstract EffectTexture process(EffectTexture r100, FrameBuffer r101);

    public EffectTexture[] processWithMRT(EffectTexture r100, FrameBuffer r101) {
        return null;
    }

    public void setEGLShareContext(EGLContext r100) {
    }

    public void setShareEGLShareConfig(EGLConfig r100) {
    }

    public AbsEffect release() {
        AbsEffect r100 = this.mNext;
        removeEffect();
        return r100;
    }

    public void removeEffect() {
        AbsEffect r100 = this.mPrevious;
        if (r100 == null) goto L5;
        r100.mNext = this.mNext;
    L5:
        AbsEffect r101 = this.mNext;
        if (r101 == null) goto L8;
        r101.mPrevious = r100;
    L8:
        this.mNext = null;
        this.mPrevious = null;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.LOG_TAG);
        r100.append("[");
        r100.append(this.mOrder);
        r100.append("]->");
        AbsEffect r101 = this.mNext;
        if (r101 == null) goto L5;
        String r102 = r101.toString();
    L6:
        r100.append(r102);
        return r100.toString();
    L5:
        r102 = "end";
        goto L6
    }

    public int effectType() {
        return this.mEffectType;
    }

    public Bundle getInitBundle() {
        return this.mBundle;
    }

    public AbsEffect getNextEffect() {
        return this.mNext;
    }

    public AbsEffect getPreviousEffect() {
        return this.mPrevious;
    }

    public int texType() {
        return this.mTexType;
    }

    public int getIntOption(int r100) {
        if (r100 == 10004) goto L23;
        if (r100 == 10005) goto L21;
        if (r100 == 10011) goto L19;
        if (r100 == 10014) goto L17;
        if (r100 == 10016) goto L15;
        return -1;
    L15:
        return this.mIsSupportClip;
    L17:
        return this.mIsSupportOes;
    L19:
        return this.mOrder;
    L21:
        return this.mEffectType;
    L23:
        return this.mInTextureTarget;
    }

    public int init(Bundle r100) {
        VideoSurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 != null) goto L5;
    L7:
        this.mBundle = r100;
        return 0;
    L5:
        if (r101.getIntOption(126, this.mEffectType) != (-1)) goto L7;
        this.mSurfaceTexture.setOption(126, this.mEffectType, 0);
        this.mSurfaceTexture.setOption(127, this.mEffectType, "");
        goto L7
    }

    public void insertEffect(AbsEffect r100) {
        int r101 = r100.mOrder;
        if (r101 > this.mOrder) goto L11;
        AbsEffect r102 = this.mNext;
        if (r102 != null) goto L8;
        this.mNext = r100;
        r100.mPrevious = this;
        return;
    L8:
        if (r102.mOrder < r101) goto L10;
        r102.insertEffect(r100);
        return;
    L10:
        r100.mPrevious = this;
        r100.mNext = r102;
        this.mNext.mPrevious = r100;
        this.mNext = r100;
        return;
    L11:
        AbsEffect r103 = this.mPrevious;
        if (r103 != null) goto L15;
        this.mPrevious = r100;
        r100.mNext = this;
        return;
    L15:
        if (r103.mOrder < r101) goto L17;
        r103.mNext = r100;
        r100.mPrevious = r103;
        r100.mNext = this;
        this.mPrevious = r100;
        return;
    L17:
        r103.insertEffect(r100);
    }

    public void setOption(Bundle r100) {
        AbsEffect r101 = this.mNext;
        if (r101 == null) goto L6;
        r101.setOption(r100);
        return;
    }

    public void setParentRender(TextureRenderer r100) {
        this.mParentRender = r100;
    }

    public void setSurfaceTexture(VideoSurfaceTexture r100) {
        this.mSurfaceTexture = r100;
        if (r100 == null) goto L6;
        this.mTexType = r100.texType();
        return;
    }

    public AbsEffect(int r100, int r101) {
        this.mIsSupportOes = 0;
        this.mIsSupportClip = 0;
        this.mTexType = -1;
        this.mRenderToScreen = false;
        this.mDoClip = false;
        this.mTrackEvent = false;
        this.LOG_TAG = TextureRenderLog.getLogTag(this);
        this.mEffectType = r101;
        this.mTexType = r100;
    }

    public void setOption(int r100, int r101) {
        if (r100 == 10011) goto L25;
        boolean r102 = true;
        if (r100 != 10015) goto L7;
        if (r101 > 0) goto L24;
        r102 = false;
    L24:
        this.mRenderToScreen = r102;
        return;
    L7:
        if (r100 != 10017) goto L9;
        if (r101 > 0) goto L20;
        r102 = false;
    L20:
        this.mDoClip = r102;
        return;
    L9:
        if (r100 == 10018) goto L13;
        AbsEffect r103 = this.mNext;
        if (r103 == null) goto L35;
        r103.setOption(r100, r101);
        return;
    L35:
        return;
    L13:
        if (r101 > 0) goto L16;
        r102 = false;
    L16:
        this.mTrackEvent = r102;
        return;
    L25:
        this.mOrder = r101;
        AbsEffect r104 = this.mPrevious;
        if (r104 != null) goto L28;
    L29:
        AbsEffect r105 = this.mNext;
        if (r105 != null) goto L32;
        return;
    L32:
        if (r101 >= r105.mOrder) goto L41;
    L33:
        removeEffect();
        insertEffect(this);
        return;
    L41:
        return;
    L28:
        if (r101 > r104.mOrder) goto L33;
        goto L29
    }

    public void setOption(int r100, float r101) {
        AbsEffect r102 = this.mNext;
        if (r102 == null) goto L6;
        r102.setOption(r100, r101);
        return;
    }

    public void setOption(int r100, Object r101) {
        AbsEffect r102 = this.mNext;
        if (r102 == null) goto L6;
        r102.setOption(r100, r101);
        return;
    }

    public void setOption(int r100, float[] r101) {
        AbsEffect r102 = this.mNext;
        if (r102 == null) goto L6;
        r102.setOption(r100, r101);
        return;
    }
}
