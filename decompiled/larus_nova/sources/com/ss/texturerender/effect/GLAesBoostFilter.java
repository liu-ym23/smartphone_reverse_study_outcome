package com.ss.texturerender.effect;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.bmf_mods_lite_api.exception.BmfException;
import com.ss.texturerender.TextureRenderHelper;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.TextureRenderManager;
import com.ss.texturerender.VideoSurfaceTexture;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import lc4.a;
import lc4.b;

/* JADX INFO: loaded from: classes40.dex */
public class GLAesBoostFilter extends AbsEffect {
    private static final String AES_BOOST_CLASS_NAME = "com.bytedance.bmf_mods_lite.AesBoost";
    private final int STATUS_ERROR;
    private final int STATUS_INITIALIZED;
    private final int STATUS_RELEASED;
    private final int STATUS_RUNNING;
    private a mAesBoostConfig;
    private kc4.a mAesBoostObject;
    private Bundle mAesBoostParamsBundle;
    private b mAesBoostProcessParams;
    private int mAlgType;
    private float mAlpha;
    private int mDownSample;
    private int mFadeInThreshold;
    private int mFrameCount;
    private int mGroupId;
    private final AtomicInteger mInitErrorCode;
    private int mInterval;
    private WeakReference<VideoSurfaceTexture> mLastSurfaceTextureRef;
    private int mMaxHeight;
    private int mMaxWidth;
    private boolean mNewVideo;
    private int mPoolSize;
    private float[] mSTMatrix;
    private int mSerial;
    private final ReentrantLock mSerialLock;
    private float mSimpleK;
    private final AtomicInteger mStatus;

    public static class MyAesBoostInitCallback {
        private final String TAG;
        private final WeakReference<GLAesBoostFilter> mFilterRef;
        private final int mSerial;
        private final WeakReference<VideoSurfaceTexture> mSurfaceTextureRef;
        private final int mTexType;

        public void onInitResult(int r100) {
            TextureRenderLog.i(this.mTexType, this.TAG, "onInit serial = " + this.mSerial + ", status = " + r100);
            GLAesBoostFilter r101 = this.mFilterRef.get();
            if (r101 != null) goto L6;
            TextureRenderLog.w(this.mTexType, this.TAG, "onInit but no instance");
            return;
        L6:
            ReentrantLock r102 = GLAesBoostFilter.access$100(r101);
            r102.lock();
            if (this.mSerial == GLAesBoostFilter.access$000(r101)) goto L9;
            TextureRenderLog.w(this.mTexType, this.TAG, "onInit but serial changed, from = " + this.mSerial + " to = " + GLAesBoostFilter.access$000(r101));
        L13:
            r102.unlock();
            if (r100 == 0) goto L19;
            VideoSurfaceTexture r103 = this.mSurfaceTextureRef.get();
            if (r103 == null) goto L20;
            r103.notifyInitError(r100, 28, "onInit error = " + r100);
            return;
        L20:
            return;
        L19:
            return;
        L9:
            if (r100 != 0) goto L11;
            GLAesBoostFilter.access$200(r101).set(0);
            GLAesBoostFilter.access$300(r101).compareAndSet(1, 2);
            goto L13
        L11:
            GLAesBoostFilter.access$200(r101).set(r100);
            GLAesBoostFilter.access$300(r101).compareAndSet(1, -1);
            goto L13
        }

        public MyAesBoostInitCallback(String r100, int r101, GLAesBoostFilter r102) {
            this.TAG = r100;
            this.mTexType = r101;
            this.mSerial = GLAesBoostFilter.access$000(r102);
            this.mFilterRef = new WeakReference(r102);
            this.mSurfaceTextureRef = new WeakReference(r102.mSurfaceTexture);
        }
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        if (this.mStatus.compareAndSet(1, 0) == false) goto L5;
    L10:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "release");
        kc4.a r100 = this.mAesBoostObject;
        if (r100 == null) goto L13;
        r100.Free();
        this.mAesBoostObject = null;
    L13:
        this.mLastSurfaceTextureRef = new WeakReference(null);
        this.mAlgType = 0;
        this.mMaxWidth = 0;
        this.mMaxHeight = 0;
        this.mPoolSize = 0;
        this.mDownSample = 0;
        this.mSimpleK = 0.0f;
        this.mAesBoostConfig = null;
        this.mAesBoostProcessParams = null;
        this.mInitErrorCode.set(0);
        return super.release();
    L5:
        if (this.mStatus.compareAndSet(2, 0) == true) goto L10;
        if (this.mStatus.compareAndSet(-1, 0) == true) goto L10;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "released");
        return super.release();
    }

    public GLAesBoostFilter(int r100) {
        super(r100, 28);
        this.mSTMatrix = new float[16];
        this.mNewVideo = true;
        this.mInterval = -1;
        this.mGroupId = -1;
        this.mAlpha = 1.0f;
        this.STATUS_ERROR = -1;
        this.STATUS_RELEASED = 0;
        this.STATUS_INITIALIZED = 1;
        this.STATUS_RUNNING = 2;
        this.mStatus = new AtomicInteger(0);
        this.mInitErrorCode = new AtomicInteger(0);
        this.mLastSurfaceTextureRef = new WeakReference(null);
        this.mAesBoostParamsBundle = null;
        this.mSerialLock = new ReentrantLock();
        this.mSerial = 0;
    }

    public static /* synthetic */ int access$000(GLAesBoostFilter r100) {
        return r100.mSerial;
    }

    public static /* synthetic */ ReentrantLock access$100(GLAesBoostFilter r100) {
        return r100.mSerialLock;
    }

    public static /* synthetic */ AtomicInteger access$200(GLAesBoostFilter r100) {
        return r100.mInitErrorCode;
    }

    public static /* synthetic */ AtomicInteger access$300(GLAesBoostFilter r100) {
        return r100.mStatus;
    }

    private boolean checkNeedReInit(Bundle r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        int r101 = r100.getInt(TextureRenderKeys.KEY_IS_AES_BOOST_ALG_TYPE, 0);
        int r102 = r100.getInt(TextureRenderKeys.KEY_IS_AES_BOOST_MAX_WIDTH, 0);
        int r103 = r100.getInt(TextureRenderKeys.KEY_IS_AES_BOOST_MAX_HEIGHT, 0);
        int r104 = r100.getInt(TextureRenderKeys.KEY_IS_AES_BOOST_POOL_SIZE, 2);
        if (this.mAlgType == r101) goto L8;
    L30:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "params changed");
        return true;
    L8:
        if (this.mMaxWidth != r102) goto L30;
        if (this.mMaxHeight != r103) goto L30;
        if (this.mPoolSize != r104) goto L30;
        if (this.mAesBoostConfig != null) goto L18;
        return true;
    L18:
        if (r100.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_MODEL_NAME_PREFIX, "").equals(this.mAesBoostConfig.f508415b) == true) goto L21;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "modelNamePrefix changed");
        return true;
    L21:
        int[] r105 = r100.getIntArray(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_GROUP_IDS);
        if (Arrays.equals(this.mAesBoostConfig.f508416c, r105) == true) goto L25;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "groupIds changed");
        return true;
    L25:
        int r106 = r100.getInt(TextureRenderKeys.KEY_IS_AES_BOOST_DOWN_SAMPLE, 1);
        if (this.mDownSample == r106) goto L29;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "downSample changed");
        return true;
    L29:
        return false;
    }

    private void setUseAesBoost(int r100) {
        VideoSurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 == null) goto L6;
        r101.setOption(19, this.mEffectType, r100);
        return;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public int init(Bundle r110) {
        this.mSerialLock.lock();
        if (this.mStatus.compareAndSet(0, 1) == false) goto L5;
        boolean r100 = false;
    L12:
        this.mSerial++;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "init serial = " + this.mSerial);
        this.mSerialLock.unlock();
        if (r100 == false) goto L55;
        release();
        this.mStatus.set(1);
    L55:
        this.mAesBoostObject = (kc4.a) TextureRenderHelper.getClzUsingPluginLoader(1, AES_BOOST_CLASS_NAME).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{TextureRenderManager.getManager().getContext()});     // Catch: Exception -> L52
        this.mAlgType = r110.getInt(TextureRenderKeys.KEY_IS_AES_BOOST_ALG_TYPE, 0);
        this.mMaxWidth = r110.getInt(TextureRenderKeys.KEY_IS_AES_BOOST_MAX_WIDTH, 0);
        this.mMaxHeight = r110.getInt(TextureRenderKeys.KEY_IS_AES_BOOST_MAX_HEIGHT, 0);
        this.mPoolSize = r110.getInt(TextureRenderKeys.KEY_IS_AES_BOOST_POOL_SIZE, 2);
        this.mDownSample = r110.getInt(TextureRenderKeys.KEY_IS_AES_BOOST_DOWN_SAMPLE, 1);
        r110.getString(TextureRenderKeys.KEY_IS_AES_BOOST_LICENSE_MODULE_NAME, "");
        r110.getString(TextureRenderKeys.KEY_IS_AES_BOOST_PROGRAM_CACHE_DIR, "");
        a.C6674a r101 = new a.C6674a();     // Catch: BmfException -> L49
        String r102 = r110.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_HOST, "");     // Catch: BmfException -> L49
        String r103 = r110.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_ACCESSKEY, "");     // Catch: BmfException -> L49
        if (TextUtils.isEmpty(r102) == false) goto L20;
    L22:
        String r104 = r110.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_MODEL_NAME_PREFIX, "");     // Catch: BmfException -> L49
        if (TextUtils.isEmpty(r104) == true) goto L25;
        r101.f508419b = r104;     // Catch: BmfException -> L49
    L25:
        int[] r105 = r110.getIntArray(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_GROUP_IDS);     // Catch: BmfException -> L49
        if (r105 != null) goto L28;
    L30:
        String r106 = r110.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_APP_ID, "");     // Catch: BmfException -> L49
        if (TextUtils.isEmpty(r106) == true) goto L33;
        ((HashMap) r101.f508418a).put(com.heytap.mcssdk.constant.b.f276371u, r106);     // Catch: BmfException -> L49
    L33:
        String r107 = r110.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_DEVIECEID, "");     // Catch: BmfException -> L49
        if (TextUtils.isEmpty(r107) == true) goto L36;
        ((HashMap) r101.f508418a).put("deviceId", r107);     // Catch: BmfException -> L49
    L36:
        String r108 = r110.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_APP_VERSION, "");     // Catch: BmfException -> L49
        if (TextUtils.isEmpty(r108) == true) goto L39;
        ((HashMap) r101.f508418a).put("appVersion", r108);     // Catch: BmfException -> L49
    L39:
        String r109 = r110.getString(TextureRenderKeys.KEY_IS_DOWNLOAD_MODEL_INIT_CONFIG_PLATFORMSDK_VERSION, "");     // Catch: BmfException -> L49
        if (TextUtils.isEmpty(r109) == true) goto L42;
        ((HashMap) r101.f508418a).put("platformSdkVersion", r109);     // Catch: BmfException -> L49
    L42:
        r101.f508421d = this.mDownSample;     // Catch: BmfException -> L49
        this.mAesBoostConfig = r101.a();     // Catch: BmfException -> L49
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "algType = " + this.mAlgType + ", maxWidth = " + this.mMaxWidth + ", maxHeight = " + this.mMaxHeight + ", poolSize = " + this.mPoolSize + ", config = " + this.mAesBoostConfig);     // Catch: BmfException -> L49
        new MyAesBoostInitCallback(this.LOG_TAG, this.mTexType, this);
        int r111 = this.mAesBoostObject.a();
        if (r111 >= 0) goto L47;
        setInitErrorCode(r111, "init failed");
        this.mStatus.set(-1);
        return -1;
    L47:
        setOption(r110);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "init success = " + r111);
        return 0;
    L28:
        if (r105.length < 1) goto L30;
        r101.f508420c = r105;     // Catch: BmfException -> L49
        goto L30
    L20:
        if (TextUtils.isEmpty(r103) == true) goto L22;
        ((HashMap) r101.f508418a).put("host", r102);     // Catch: BmfException -> L49
        ((HashMap) r101.f508418a).put("accessKey", r103);     // Catch: BmfException -> L49
    L49:
        e = move-exception;
        setInitErrorCode(6, "build config exp = " + e);
        this.mStatus.set(-1);
        return -1;
    L52:
        e = move-exception;
        setInitErrorCode(10, "newInstance exp = " + e);
        this.mAesBoostObject = null;
        this.mStatus.set(-1);
        return -1;
    L5:
        if (checkNeedReInit(r110) == false) goto L7;
    L10:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "reInit");
        r100 = true;
        goto L12
    L7:
        if (this.mStatus.get() == (-1)) goto L10;
        this.mSerialLock.unlock();
        return 0;
    }

    private void setErrorCode(int r100, String r101) {
        if (r100 == 0) goto L4;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "error = " + r100 + " detail = " + r101);
    L4:
        VideoSurfaceTexture r102 = this.mSurfaceTexture;
        if (r102 == null) goto L10;
        if (r100 == 0) goto L8;
        r102.notifyError(r100, this.mEffectType, r101);
        return;
    L8:
        r102.setOption(126, this.mEffectType, 0);
        return;
    }

    private void setInitErrorCode(int r100, String r101) {
        if (r100 == 0) goto L4;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "error = " + r100 + " detail = " + r101);
    L4:
        VideoSurfaceTexture r102 = this.mSurfaceTexture;
        if (r102 == null) goto L7;
        r102.notifyInitError(r100, this.mEffectType, r101);
    L7:
        this.mInitErrorCode.set(r100);
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture r210, FrameBuffer r211) {
        if (this.mSurfaceTexture != null) goto L7;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "invalid surface texture");
        return r210;
    L7:
        if (this.mStatus.get() != 2) goto L9;
        VideoSurfaceTexture r100 = this.mLastSurfaceTextureRef.get();
        int r101 = this.mTexType;
        if (r101 != 0) goto L24;
        if (r100 != null) goto L17;
    L18:
        this.mLastSurfaceTextureRef = new WeakReference(this.mSurfaceTexture);
        Bundle r102 = this.mSurfaceTexture.getBundleOption(180);
        if (r102 != null) goto L22;
        setErrorCode(11, this.mSurfaceTexture + " process failed, no params found");
        setUseAesBoost(0);
        return r210;
    L22:
        this.mInterval = r102.getInt(TextureRenderKeys.KEY_IS_AES_BOOST_INTERVAL, -1);
        this.mGroupId = r102.getInt(TextureRenderKeys.KEY_IS_AES_BOOST_GROUP_ID, -1);
        this.mFadeInThreshold = r102.getInt(TextureRenderKeys.KEY_IS_AES_BOOST_FADE_IN_THRESHOLD, 0);
        this.mNewVideo = true;
        this.mSimpleK = r102.getFloat(TextureRenderKeys.KEY_IS_AES_BOOST_SIMPLE_K, 0.0f);
        this.mFrameCount = 0;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, this.mSurfaceTexture + " set interval = " + this.mInterval + ", groupId = " + this.mGroupId + ", fadeInThreshold = " + this.mFadeInThreshold);
    L35:
        if (this.mInterval >= 0) goto L37;
    L73:
        setErrorCode(7, this.mSurfaceTexture + " process failed, invalid interval = " + this.mInterval + ", groupId = " + this.mGroupId);
        setUseAesBoost(0);
        return r210;
    L37:
        if (this.mGroupId < 0) goto L73;
        int r103 = r210.getWidth();
        int r104 = r210.getHeight();
        int r105 = r210.getTexID();
        int r106 = r210.getTexTarget();
        if (this.mAlgType != 1) goto L46;
        b r107 = this.mAesBoostProcessParams;
        if (r107 != null) goto L44;
        this.mAesBoostProcessParams = new b();
    L45:
        b r108 = this.mAesBoostProcessParams;
    L48:
        if (r106 != 36197) goto L53;
        this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
        if (r108 == null) goto L52;
        int r109 = this.mAesBoostObject.d();
    L57:
        if (r109 >= 0) goto L60;
        setErrorCode(r109, this.mSurfaceTexture + " process textureMix failed texId = " + r105 + ", texTarget = " + r106 + ", width = " + r103 + ", height = " + r104 + ", maxWidth = " + this.mMaxWidth + ", maxHeight = " + this.mMaxHeight);
        setUseAesBoost(0);
        return r210;
    L60:
        int r110 = this.mAesBoostObject.f();
        if (r110 > 0) goto L64;
        setErrorCode(r110, this.mSurfaceTexture + " process get resultMix failed");
        setUseAesBoost(0);
        return r210;
    L64:
        EffectTexture r111 = new EffectTexture(null, r110, 1, 1, 32879, null);
        r111.setUsage(EffectTexture.TextureUsage.LUT_3D);
        int r112 = this.mFadeInThreshold;
        if (r112 <= 0) goto L67;
        this.mAlpha = Math.min((1.0f / r112) * this.mSurfaceTexture.getFrameCountReceived(), 1.0f);
    L68:
        r111.setAlpha(this.mAlpha);
        if ((this.mFrameCount % 100) != 0) goto L71;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, this.mSurfaceTexture + " process success texId = " + r110 + ", texTarget = " + r106 + ", newVideo = " + this.mNewVideo + ", interval = " + this.mInterval + ", groupId = " + this.mGroupId + ", simpleK = " + this.mSimpleK);
    L71:
        this.mFrameCount++;
        this.mNewVideo = false;
        setErrorCode(0, "");
        setUseAesBoost(1);
        return r111;
    L67:
        this.mAlpha = 1.0f;
        goto L68
    L52:
        r109 = this.mAesBoostObject.b();
        goto L57
    L53:
        if (r108 == null) goto L55;
        r109 = this.mAesBoostObject.c();
        goto L57
    L55:
        r109 = this.mAesBoostObject.e();
        goto L57
    L44:
        r107.getClass();
        this.mAesBoostProcessParams.getClass();
        this.mAesBoostProcessParams.getClass();
        goto L45
    L46:
        r108 = null;
        goto L48
    L17:
        if (r100 != this.mSurfaceTexture) goto L18;
    L24:
        if (r101 != 1) goto L35;
        VideoSurfaceTexture r113 = this.mSurfaceTexture;
        if (r113 == null) goto L35;
        Bundle r114 = r113.getBundleOption(180);
        if (r114 != null) goto L32;
        setErrorCode(11, this.mSurfaceTexture + " process failed, no params found");
        setUseAesBoost(0);
        return r210;
    L32:
        if (this.mAesBoostParamsBundle == r114) goto L35;
        this.mInterval = r114.getInt(TextureRenderKeys.KEY_IS_AES_BOOST_INTERVAL, -1);
        this.mGroupId = r114.getInt(TextureRenderKeys.KEY_IS_AES_BOOST_GROUP_ID, -1);
        this.mFadeInThreshold = r114.getInt(TextureRenderKeys.KEY_IS_AES_BOOST_FADE_IN_THRESHOLD, 0);
        this.mNewVideo = true;
        this.mSimpleK = r114.getFloat(TextureRenderKeys.KEY_IS_AES_BOOST_SIMPLE_K, 0.0f);
        this.mFrameCount = 0;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, this.mSurfaceTexture + " set interval = " + this.mInterval + ", groupId = " + this.mGroupId + ", fadeInThreshold = " + this.mFadeInThreshold + ", newVideo = " + this.mNewVideo);
        this.mAesBoostParamsBundle = r114;
        goto L35
    L9:
        if (this.mStatus.get() != (-1)) goto L11;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, this.mSurfaceTexture + " process failed, init error = " + this.mInitErrorCode.get());
    L11:
        setUseAesBoost(0);
        return r210;
    }
}
