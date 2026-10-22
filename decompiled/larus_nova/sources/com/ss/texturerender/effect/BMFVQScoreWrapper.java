package com.ss.texturerender.effect;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.os.Bundle;
import android.text.TextUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.TextureRenderer;
import com.ss.texturerender.VideoSurface;
import com.ss.texturerender.VideoSurfaceTexture;
import com.ss.texturerender.base.EGLRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public class BMFVQScoreWrapper extends AbsEffect {
    private final int OPENCL;
    private final int OPENGL;
    private final String VQSCORE_MODEL_NAME_LIVE;
    private final String VQSCORE_MODEL_NAME_OMNILITE;
    private final String defaultAccessKey;
    private final int defaultConcurrencyLimit;
    private final String defaultPlatformSdkVersion;
    private EGLRuntime eglRuntime;
    private int mAlgorithmType;
    private int mBackEnd;
    private String mCachePath;
    private int mConcurrencyLimit;
    private int mForwardType;
    private boolean mInited;
    private long mSequenceId;
    private volatile EGLConfig mSharedEglConfig;
    private volatile EGLContext mSharedEglContext;
    private boolean mSupportVQSCoreAfterEffect;
    private boolean mUseShareEglContextAsyncInit;
    private String mVQScoreModelName;
    private BMFVQScoreProxy mVQScoreProxy;

    public interface BMFVQScoreProxy {
        void downloadModel(Map<String, String> r100);

        int init(int r100, int r101, int r102, String r103, int r104);

        int process(long r100, EffectTexture r101, VideoSurface.VQScoreCallback r102);

        void release();
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture r100, FrameBuffer r101) {
        return null;
    }

    private int _init() {
        BMFVQScoreProxy r100 = this.mVQScoreProxy;
        if (r100 != null) goto L5;
        int r101 = -1;
    L6:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "vqscore init result: " + r101);
        if (r101 != 0) goto L11;
        this.mInited = true;
        TextureRenderer r102 = this.mParentRender;
        if (r102 == null) goto L11;
        r102.setVQSCoreInitResult(true);
    L11:
        if (r101 == 0) goto L15;
        VideoSurfaceTexture r103 = this.mSurfaceTexture;
        if (r103 == null) goto L15;
        r103.notifyInitError(15, this.mEffectType, "vqscore init fail, ret: " + r101);
    L15:
        return r101;
    L5:
        r101 = r100.init(this.mAlgorithmType, this.mBackEnd, this.mForwardType, this.mCachePath, this.mConcurrencyLimit);
        goto L6
    }

    private void _preInit() {
        if (this.mVQScoreProxy == null) goto L6;
        return;
    L6:
        if (TextUtils.equals(this.mVQScoreModelName, "vqscore_omni_lite") == false) goto L8;
        this.mVQScoreProxy = new BMFVQScoreOmniLite(this.mTexType, this.LOG_TAG, this.mSurfaceTexture, this.mEffectType);
        return;
    L8:
        this.mVQScoreProxy = new BMFVQScoreLive(this.mTexType, this.LOG_TAG, this.mSurfaceTexture, this.mEffectType);
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        BMFVQScoreProxy r100 = this.mVQScoreProxy;
        if (r100 == null) goto L6;
        r100.release();
        this.mVQScoreProxy = null;
    L6:
        return super.release();
    }

    public BMFVQScoreWrapper(int r100) {
        this(r100, false);
    }

    public static /* synthetic */ EGLRuntime access$000(BMFVQScoreWrapper r100) {
        return r100.eglRuntime;
    }

    public static /* synthetic */ int access$100(BMFVQScoreWrapper r100) {
        return r100._init();
    }

    public void downloadModel(Bundle r110) {
        if (this.mInited == false) goto L5;
        return;
    L5:
        String r100 = r110.getString("access_key");
        if (TextUtils.isEmpty(r100) == false) goto L8;
        r100 = "142710f02c3a11e8b42429f14557854a";
    L8:
        String r101 = r110.getString("sdk_version");
        if (TextUtils.isEmpty(r101) == false) goto L11;
        r101 = "11.0.0";
    L11:
        String r102 = r110.getString("host", "");
        if (TextUtils.isEmpty(r102) == false) goto L17;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "vqscore host is null");
        VideoSurfaceTexture r111 = this.mSurfaceTexture;
        if (r111 == null) goto L30;
        r111.notifyError(19, this.mEffectType, "vqscore host is null");
        return;
    L30:
        return;
    L17:
        this.mCachePath = r110.getString("cache_dir", "");
        this.mConcurrencyLimit = r110.getInt(TextureRenderKeys.KEY_IS_BMF_VQSCORE_CONCURRENCY_LIMIT, 2);
        if (r110.getInt(TextureRenderKeys.KEY_IS_BMF_VQSCORE_ENABLE_POSTEFFECT) != 1) goto L20;
        boolean r103 = true;
    L21:
        this.mSupportVQSCoreAfterEffect = r103;
        this.mBackEnd = r110.getInt(TextureRenderKeys.KEY_IS_BMF_VQSCORE_BACKEND, 2);
        this.mAlgorithmType = r110.getInt(TextureRenderKeys.KEY_IS_BMF_VQSCORE_ALGTYPE, 0);
        String r104 = r110.getString(TextureRenderKeys.KEY_IS_BMF_VQSCORE_DOWNLOAD_SOURCE, "");
        this.mForwardType = r110.getInt(TextureRenderKeys.KEY_IS_BMF_VQSCORE_FORWARED_TYPE, 1);
        this.mVQScoreModelName = r110.getString(TextureRenderKeys.KEY_IS_BMF_VQSCORE_MODEL_NAME, "vqscore_live");
        HashMap r112 = new HashMap();
        r112.put("accessKey", r100);
        r112.put("platformSdkVersion", r101);
        r112.put("host", r102);
        r112.put("deviceId", "");
        r112.put("modelName", this.mVQScoreModelName);
        if (TextUtils.isEmpty(r104) == true) goto L24;
        r112.put("downloadSource", r104);
    L24:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "vqscore download params: " + r112);
        _preInit();
        BMFVQScoreProxy r105 = this.mVQScoreProxy;
        if (r105 != null) goto L28;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "vqscore download quit because mVQScoreProxy==null");
        return;
    L28:
        r105.downloadModel(r112);
        return;
    L20:
        r103 = false;
        goto L21
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public int init(Bundle r100) {
        if (this.mInited == true) goto L17;
        if (r100 != null) goto L6;
        return -1;
    L6:
        if (r100.getInt("action") == 151) goto L9;
        return -1;
    L9:
        if (this.mUseShareEglContextAsyncInit == false) goto L16;
        if (this.eglRuntime != null) goto L13;
        this.eglRuntime = new EGLRuntime(this.mTexType, null, this.mSharedEglContext, this.mSharedEglConfig);
    L13:
        final WeakReference r101 = new WeakReference(this);
        ThreadMethodProxy.start(new PthreadThreadV2(new AnonymousClass1(this, r101), "BMFVQScoreWrapper"));
        return 0;
    L16:
        return _init();
    L17:
        return -1;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public void setEGLShareContext(EGLContext r100) {
        this.mSharedEglContext = r100;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public void setShareEGLShareConfig(EGLConfig r100) {
        this.mSharedEglConfig = r100;
    }

    public BMFVQScoreWrapper(int r100, boolean r101) {
        super(r100, 16);
        this.mInited = false;
        this.mCachePath = "";
        this.defaultConcurrencyLimit = 2;
        this.mConcurrencyLimit = -1;
        this.defaultAccessKey = "142710f02c3a11e8b42429f14557854a";
        this.defaultPlatformSdkVersion = "11.0.0";
        this.OPENCL = 2;
        this.OPENGL = 3;
        this.mSequenceId = 0;
        this.mSupportVQSCoreAfterEffect = false;
        this.mBackEnd = 2;
        this.mAlgorithmType = 0;
        this.mForwardType = 1;
        this.VQSCORE_MODEL_NAME_LIVE = "vqscore_live";
        this.VQSCORE_MODEL_NAME_OMNILITE = "vqscore_omni_lite";
        this.mVQScoreModelName = "vqscore_live";
        this.mUseShareEglContextAsyncInit = false;
        this.eglRuntime = null;
        this.mSharedEglContext = EGL14.EGL_NO_CONTEXT;
        this.mSharedEglConfig = null;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "new BMFVQScoreWrapper, useShareEglContextAsyncInit: " + r101);
        this.mIsSupportOes = 1;
        this.mUseShareEglContextAsyncInit = r101;
        this.mVQScoreProxy = null;
    }

    public static /* synthetic */ EGLRuntime access$002(BMFVQScoreWrapper r100, EGLRuntime r101) {
        r100.eglRuntime = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$202(BMFVQScoreWrapper r100, boolean r101) {
        r100.mInited = r101;
        return r101;
    }

    public void processVqscore(EffectTexture r110, VideoSurface.VQScoreCallback r111, boolean r112) {
        if (this.mInited == false) goto L27;
        if (r111 == null) goto L28;
        if (r110 == null) goto L29;
        if (r112 == false) goto L11;
        if (this.mSupportVQSCoreAfterEffect == true) goto L11;
        return;
    L11:
        if (this.mSupportVQSCoreAfterEffect == false) goto L17;
        if (r112 == true) goto L17;
        long r100 = this.mSequenceId;
        if ((r100 % 2) != 0) goto L16;
        this.mSequenceId = r100 + 1;
    L18:
        BMFVQScoreProxy r113 = this.mVQScoreProxy;
        if (r113 != null) goto L21;
        int r114 = -1;
    L22:
        VideoSurfaceTexture r115 = this.mSurfaceTexture;
        if (r115 == null) goto L30;
        if (r114 == 0) goto L31;
        r115.notifyError(16, this.mEffectType, "vqscore process fail, ret: " + r114);
        return;
    L31:
        return;
    L30:
        return;
    L21:
        r114 = r113.process(this.mSequenceId, r110, r111);
        goto L22
    L16:
        this.mSequenceId = r100 + 2;
    L17:
        this.mSequenceId++;
        goto L18
    L29:
        return;
    L28:
        return;
    }
}
