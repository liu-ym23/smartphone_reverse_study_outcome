package com.ss.texturerender;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.hardware.HardwareBuffer;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.Surface;
import androidx.camera.video.AudioStats;
import com.alipay.sdk.m.u.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.texturerender.base.EGLRuntime;
import com.ss.texturerender.effect.AbsEffect;
import com.ss.texturerender.effect.EffectConfig;
import com.ss.texturerender.effect.EffectTexture;
import com.ss.texturerender.effect.EffectTextureManager;
import com.ss.texturerender.effect.HardwareBuffer2GLCopyFilter;
import com.ss.texturerender.effect.PureColorDetector;
import com.ss.texturerender.math.ColorConversion;
import com.ss.texturerender.math.Quaternion;
import com.ss.texturerender.overlay.FrameTimeQueue;
import com.ss.texturerender.producer.IFrameProducer;
import com.ss.texturerender.producer.ImageReaderProducer;
import com.ss.texturerender.touch.TouchHelper;
import com.ss.texturerender.vsync.IVsyncCallback;
import com.ss.texturerender.vsync.IVsyncHelper;
import com.ss.texturerender.vsync.VsyncHelperFactory;
import com.ss.ttm.player.MediaPlayer;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes40.dex */
public class VideoSurfaceTexture extends SurfaceTexture implements Serializable, TextureRenderer.OnTextureFocusLossListener, IVsyncCallback {
    public static final int ERROR_SR_EXE_FAIL = 2;
    public static final int ERROR_SR_INIT_FAIL = 1;
    private static final long FORCE_EXIPRE_TIME_MS = 120000;
    public static final String KEY_QUATERNION_W = "quaternion_w";
    public static final String KEY_QUATERNION_X = "quaternion_x";
    public static final String KEY_QUATERNION_Y = "quaternion_y";
    public static final String KEY_QUATERNION_Z = "quaternion_z";
    public static final String KEY_SURFACE = "surface";
    public static final String KEY_TEXTURE = "texture";
    public static final String KEY_TIME = "timeStamp";
    private static final int MAX_DROP_COUNT = 5;
    protected static final int SUPER_RES_CLOSE = 0;
    protected static final int SUPER_RES_OPEN = 1;
    protected static final long TIME_UNSET = -9223372036854775807L;
    public static final int checkGeomeMaxCount = 10;
    private static int[] resHeightTab;
    private static int[] resWdithTab;
    private final String TAG;
    protected double mAccumulatedPlayingTime;
    private Bundle mAesBoostParamsBundle;
    private int mBeginSRThreshold;
    private int mBitDepth;
    private Bundle mBrightnessBalanceParamsBundle;
    private int mCheckGeomeCount;
    protected EffectConfig mConfig;
    private Looper mCreateLooper;
    private int mCurrentEffectProcessDepth;
    private double mCurrentEffectStartTime;
    private int mDataSpace;
    private int mDoMirrorFirst;
    protected int mDropCount;
    private EGLRuntime mEGLRuntime;
    private double mEffectChainAccumulatedTime;
    private float mEffectChainAverageTime;
    private int mEffectChainFrameCount;
    private double mEffectChainStartTime;
    protected EffectTexture mEffectTexture;
    private EGLConfig mEglConfig;
    private EGLContext mEglContext;
    private EGLDisplay mEglDisplay;
    private volatile EGLSurface mEglSurface;
    private int mEnableExtraSurfaceRenderCallback;
    private int mEnableGlBlitToSceenForHardWareBuffer;
    public int mEnableGlBlitToScreen;
    private int mEnableNativeWindow;
    private int mEnableResetCropParamsInRender;
    private int mEnableUseEglDummySurface;
    private final TextureRenderEventLogger mEventLogger;
    private ConcurrentHashMap<Surface, Bundle> mExtraRenderCropParamsBundleMap;
    private int mExtraSurfaceMakeCurrent;
    private HashMap<Surface, EGLSurface> mExtraSurfaceMap;
    protected float mFPS;
    private boolean mFirstFrameRendered;
    private int mForbidReuseVideoSurfaceTexture;
    private VideoSurface.SaveFrameCallback mFrameCallback;
    private Bundle mFrameCallbackBundle;
    private int mFrameCallbackInRenderThread;
    private int mFrameCount;
    private int mFrameCountReceived;
    private List<FrameMetaData> mFrameMetaData;
    private IFrameProducer mFrameProducer;
    public boolean mFrameReady;
    private int mFreezeDirector;
    private int mGlBlitSkipGLFinish;
    private int mHDRType;
    private HardwareBuffer mHardwareBuffer;
    private final Object mHardwareBufferObject;
    private int mHardwareBufferRenderDirectly;
    private EffectTexture mHardwareBufferTexture;
    private HardwareBuffer2GLCopyFilter mHardwareBufferTextureFilter;
    Quaternion mHeadPose;
    public int mHeadposeCallbackIntegral;
    protected long mIdleTimeStamp;
    private boolean mIgnoreSRResCheck;
    private boolean mIsMakeCurrent;
    public volatile int mIsMirrorHorizontal;
    public volatile int mIsMirrorVertical;
    private boolean mIsPaused;
    private boolean mIsPreRender;
    protected volatile boolean mIsRelease;
    public volatile int mIsUsingNewTTPlayerView;
    private volatile int mLastComeFrameType;
    protected double mLastFrameTime;
    public volatile int mLayoutMode;
    public volatile float mLayoutRatio;
    private ReentrantLock mLock;
    private Bundle mMainRenderCropParamsBundle;
    private NativeWindow mNativeWindow;
    public boolean mNeedCheckGeome;
    private int mNeedCheckMakeCurrent;
    private int mNotKeepLastParams;
    private long mObjectId;
    protected volatile VideoSurface mOffScreenSurface;
    private MyOnFrameAvailableListener mOnFrameAvailableListener;
    private int mOpenVQScore;
    private CopyOnWriteArrayList<Bundle> mParamList;
    private HashMap<Integer, Double> mPerEffectAccumulatedTime;
    private HashMap<Integer, Float> mPerEffectAverageTime;
    private HashMap<Integer, Integer> mPerEffectFrameCount;
    private PureColorDetector.Params mPureColorDetectorParams;
    private int mRGBBitsFromEGLConfig;
    private int[] mRect;
    public volatile boolean mReleaseOffScreenSurfaceFinish;
    private Handler mRenderHandler;
    private Bundle mRenderMsgBundle;
    private Surface mRenderSurface;
    public volatile int mRenderWhenSizeChange;
    private Bundle mRoiSRParamsBundle;
    public volatile int mRotationType;
    private Bundle mSRParamsBundle;
    private float mSRProcessAverageCostTime;
    private Bundle mSRProcessParamter;
    private int mSRProcessScaleType;
    private volatile float mSRProcessSuccessRate;
    private Bundle mSaveFrameBundle;
    private int mSaveFrameCount;
    private int mSerial;
    private float mSharpenCostTime;
    private float mSharpenSuccessRate;
    private int mSkipFiliterCallGlClear;
    private int mSkipFilterCallGlFinish;
    private long mStartPlayTimeNanos;
    private int mState;
    private List<Integer> mStaticMetadata;
    private volatile int mSuperOpen;
    private Message mSyncMsg;
    private int mSyncSetVsync;
    private int mSyncUpdateSurface;
    private int mTexHeight;
    protected int mTexType;
    private int mTexWidth;
    private ITexture mTextureId;
    private LinkedList<EffectTexture> mTextureQueue;
    protected TextureRenderer mTextureRenderer;
    private long mTid;
    private TouchHelper mTouchHelper;
    private HashMap<Integer, Integer> mTrackingErrorCode;
    private HashMap<Integer, String> mTrackingErrorMsg;
    private Surface mUpdateSurface;
    private long mUpdateSurfaceTime;
    private HashMap<Integer, Integer> mUsingEffect;
    private boolean mUsingSRDirectDraw;
    private boolean mUsingSharpenDirectDraw;
    private Bundle mVQScoreBundle;
    private float mVQScoreProcessAverageCostTime;
    private float mVQScoreProcessSuccessRate;
    private volatile int mViewportHeight;
    private volatile int mViewportWidth;
    protected IVsyncHelper mVsyncHelper;

    public static class FrameMetaData {
        private Map<Integer, String> mFrameMetaData;
        private long mMasterClockDiff;
        private long mPts;
        private long mReleaseNanoTime;

        public String getStringifiedTileInfo() {
            Map<Integer, String> r100 = this.mFrameMetaData;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.get(74);
        }

        public long getReleaseNanoTime() {
            return this.mReleaseNanoTime;
        }

        public FrameMetaData(long r100, long r101, long r102, Map<Integer, String> r103) {
            this.mPts = r100;
            this.mReleaseNanoTime = r101;
            this.mMasterClockDiff = r102;
            this.mFrameMetaData = r103;
        }
    }

    public static class MyOnFrameAvailableListener implements SurfaceTexture.OnFrameAvailableListener, IFrameAvailableListener {
        private final String TAG;
        private boolean mIsEnable;
        private final WeakReference<VideoSurfaceTexture> mRef;

        public void disable() {
            this.mIsEnable = false;
        }

        @Override // com.ss.texturerender.IFrameAvailableListener
        public void onFrameAvailable() {
            onAvailable(2);
        }

        public MyOnFrameAvailableListener(VideoSurfaceTexture r100) {
            this.mIsEnable = true;
            this.TAG = VideoSurfaceTexture.access$000(r100);
            this.mRef = new WeakReference(r100);
            this.mIsEnable = true;
        }

        public void onAvailable(int r100) {
            VideoSurfaceTexture r101 = this.mRef.get();
            if (r101 != null) goto L5;
            return;
        L5:
            r101.onFrameAvailable(this.mIsEnable, r100);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture r100) {
            onAvailable(1);
        }
    }

    public interface TextureDrawCallback {
        void onSRStateChange(int r100, int r101);

        void onTextureUpdate(int r100, float r101, float r102, float r103, float r104);

        void onTextureUpdate(int r100, long r101);

        void onTextureUpdate(int r100, Surface r101, long r102);
    }

    public interface TextureErrorCallback {
        void onTextureRenderError(int r100, int r101, String r102);
    }

    static {
        resWdithTab = new int[]{480, 540, 544, 576, 576, 576};
        resHeightTab = new int[]{864, 960, 960, 1024, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, 1016};
    }

    public synchronized VideoSurface getOffScreenSurface() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsRelease == false) goto L9;
        monitor-exit(this);
        return null;
    L9:
        if (this.mOffScreenSurface != null) goto L11;
        this.mOffScreenSurface = new VideoSurface(this);     // Catch: Throwable -> L14
    L11:
        this.mIdleTimeStamp = -9223372036854775807L;     // Catch: Throwable -> L14
        VideoSurface r100 = this.mOffScreenSurface;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r100;
    }

    public void handleUpdateVideoStateForStop() {
        this.mDropCount = 0;
        IVsyncHelper r100 = this.mVsyncHelper;
        if (r100 == null) goto L5;
        r100.removeObserver(this);
    L5:
        this.mFreezeDirector = 0;
    }

    @Override // com.ss.texturerender.TextureRenderer.OnTextureFocusLossListener
    public void onFocusLoss() {
        this.mIsMakeCurrent = false;
    }

    public void preRender() {
        this.mIsPreRender = true;
    }

    public synchronized void releaseAllExtraSurface_l() {
        monitor-enter(this);
        Handler r100 = this.mRenderHandler;     // Catch: Throwable -> L8
        if (r100 == null) goto L6;
        Message r101 = r100.obtainMessage(25);     // Catch: Throwable -> L8
        r101.arg1 = 3;     // Catch: Throwable -> L8
        Bundle r102 = new Bundle();     // Catch: Throwable -> L8
        r102.putSerializable(KEY_TEXTURE, this);     // Catch: Throwable -> L8
        r101.setData(r102);     // Catch: Throwable -> L8
        this.mRenderHandler.sendMessage(r101);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized void releaseInternal() {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsRelease == false) goto L27;
    L21:
        monitor-exit(this);
        return;
    L27:
        lock();     // Catch: Throwable -> L18
        TextureRenderLog.i(this.mTexType, this.TAG, "release internal");     // Catch: Throwable -> L18
        this.mIsRelease = true;     // Catch: Throwable -> L18
        this.mTextureId.decRef();     // Catch: Throwable -> L18
        this.mEffectTexture = null;     // Catch: Throwable -> L18
        IFrameProducer r100 = this.mFrameProducer;     // Catch: Throwable -> L18
        if (r100 == null) goto L8;
        r100.release();     // Catch: Throwable -> L18
        this.mFrameProducer = null;     // Catch: Throwable -> L18
    L8:
        this.mRenderHandler = null;     // Catch: Throwable -> L18
        this.mCreateLooper = null;     // Catch: Throwable -> L18
        EffectTextureManager r101 = this.mTextureRenderer.getEffectTextureManager();     // Catch: Throwable -> L18
    L10:
        if (this.mTextureQueue.size() <= 0) goto L16;
        EffectTexture r102 = this.mTextureQueue.poll();     // Catch: Throwable -> L18
        if (r101 == null) goto L14;
        r101.onTextureReturn(r102);     // Catch: Throwable -> L18
    L15:
        TextureRenderLog.i(this.mTexType, this.TAG, "return fbotex:" + r102.getTexID());     // Catch: Throwable -> L18
        goto L10
    L14:
        TexGLUtils.deleteTexture(r102.getTexID());     // Catch: Throwable -> L18
        goto L15
    L16:
        TextureRenderLog.i(this.mTexType, this.TAG, "release internal done");     // Catch: Throwable -> L18
        unlock();     // Catch: Throwable -> L23
        goto L21
    L18:
        th = move-exception;
        unlock();     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    }

    public void releaseOther() {
    }

    private void releaseHardwareBufferTexture() {
        final HardwareBuffer2GLCopyFilter r100 = this.mHardwareBufferTextureFilter;
        if (r100 != null) goto L15;
    L12:
        this.mHardwareBufferTexture = null;
        return;
    L15:
        Handler r101 = this.mRenderHandler;     // Catch: Exception -> L9
        if (r101 == null) goto L7;
        r101.post(new AnonymousClass1(this, r100));     // Catch: Exception -> L9
    L14:
    L11:
        this.mHardwareBufferTextureFilter = null;
        goto L12
    L7:
        TextureRenderLog.e(this.mTexType, this.TAG, "releaseHardwareBufferTexture failed");     // Catch: Exception -> L9
    L9:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.TAG, "releaseHardwareBufferTexture exp = " + e);
        goto L11
    }

    public void checkGeometry() {
        NativeWindow r100 = this.mNativeWindow;
        if (this.mEnableNativeWindow != 1) goto L82;
        if (r100 == null) goto L83;
        int r101 = this.mCheckGeomeCount;
        if (r101 >= 10) goto L8;
    L9:
        this.mCheckGeomeCount = r101 + 1;
        boolean r102 = false;
        this.mNeedCheckGeome = false;
        VideoSurface r103 = this.mOffScreenSurface;
        int r104 = this.mTexWidth;
        int r105 = this.mTexHeight;
        float r106 = 0.0f;
        if (r103 == null) goto L29;
        int r107 = r103.mSurfaceWidth;
        int r108 = r103.mSurfaceHeight;
        boolean r110 = this.mTextureRenderer.mEffectConfig.getEffectOpen(5);
        boolean r111 = this.mConfig.isOpenSR();
        if (r110 == false) goto L19;
        if (r111 == false) goto L19;
        Bundle r112 = new Bundle();
        r112.putInt("effect_type", 5);
        r112.putInt("action", 175);
        Object r113 = this.mTextureRenderer.getOption(r112);
        if (r113 == null) goto L19;
        Float r114 = (Float) r113;
        if (r114.floatValue() <= 0.0f) goto L19;
        r104 = (int) (r104 * r114.floatValue());
        r105 = (int) (r105 * r114.floatValue());
    L19:
        boolean r115 = this.mTextureRenderer.mEffectConfig.getEffectOpen(15);
        boolean r116 = this.mConfig.getEffectOpen(15);
        boolean r117 = this.mTextureRenderer.mEffectConfig.getEffectOpen(22);
        boolean r118 = this.mConfig.getEffectOpen(22);
        if (r115 == false) goto L22;
        if (r116 == false) goto L22;
    L28:
        r105 = r108;
        r104 = r107;
    L30:
        if (r107 <= 0) goto L33;
        if (r104 <= 0) goto L33;
        float r119 = r108 / r107;
        r106 = r105 / r104;
    L35:
        if (Math.abs(r106 - r119) < 0.01d) goto L38;
    L40:
        r108 = r105;
    L41:
        if (r104 <= 0) goto L48;
        if (r108 <= 0) goto L48;
        if (getViewportWidth() == r104) goto L46;
    L47:
        boolean r109 = true;
    L49:
        int r120 = r100.getSurfaceFormat();
        if (r120 > 0) goto L52;
    L63:
        int r121 = 1;
    L64:
        boolean r122 = this.mTextureRenderer.mEffectConfig.getEffectOpen(8);
        boolean r123 = this.mConfig.getEffectOpen(8);
        if (r122 == false) goto L68;
        if (r123 == false) goto L68;
        TextureRenderLog.d(this.mTexType, this.TAG, "can not setBuffersGeometry when use vr");
    L69:
        if (r102 == false) goto L85;
        if (r104 > 0) goto L72;
        int r124 = getViewportWidth();
    L73:
        if (r108 > 0) goto L75;
        int r125 = getViewportHeight();
    L76:
        if (r124 <= 0) goto L86;
        if (r125 <= 0) goto L87;
        createEGLWindowSurface(true);
        NativeWindow r126 = this.mNativeWindow;
        if (r126 == null) goto L88;
        r126.setBuffersGeometry(r124, r125, r121);
        TextureRenderLog.i(this.mTexType, this.TAG, "setBuffersGeometry,oriW:" + this.mViewportWidth + ",oriH:" + this.mViewportHeight + ",oriFmt:" + r120 + ",newW:" + r104 + ",newH:" + r108 + ",newFmt:" + r121);
        this.mEventLogger.setSurfaceHWC(1);
        this.mEventLogger.setSurfaceSize(r124, r125);
        return;
    L88:
        return;
    L87:
        return;
    L86:
        return;
    L75:
        r125 = r108;
        goto L76
    L72:
        r124 = r104;
        goto L73
    L85:
        return;
    L68:
        r102 = r109;
        goto L69
    L52:
        if (this.mRGBBitsFromEGLConfig > 24) goto L58;
        if (r120 == 1) goto L62;
        if (r120 == 2) goto L62;
        if (r120 == 3) goto L62;
        r109 = true;
    L62:
        r121 = r120;
        goto L64
    L58:
        if (r120 == 22) goto L62;
        r121 = 43;
        if (r120 == 43) goto L62;
        r109 = true;
        goto L64
    L46:
        if (getViewportHeight() != r108) goto L47;
    L48:
        r109 = false;
        goto L49
    L38:
        if ((r104 * r105) <= (r107 * r108)) goto L40;
        r104 = r107;
    L33:
        r119 = 0.0f;
    L22:
        if (r117 == false) goto L25;
        if (r118 == true) goto L28;
    L25:
        if (this.mLayoutMode == 0) goto L28;
        if (this.mLayoutMode != 2) goto L30;
    L29:
        r108 = 0;
        r107 = 0;
        goto L30
    L8:
        if (this.mNeedCheckGeome == true) goto L9;
        return;
    L83:
        return;
    }

    @Override // android.graphics.SurfaceTexture
    public void finalize() throws Throwable {
        TextureRenderLog.i(this.mTexType, this.TAG, "finalize");
        releaseInternal();
        super.finalize();
    }

    public Map<String, Object> getAllEvents() {
        this.mEventLogger.setSurfaceTextureDataSpace(this.mDataSpace);
        this.mEventLogger.setSurfaceTextureSize(this.mTexWidth, this.mTexHeight);
        this.mEventLogger.setHardwareBufferRect(getRect());
        this.mEventLogger.setSourceType(this.mLastComeFrameType);
        this.mEventLogger.setOnFrameReceived(this.mFrameCountReceived);
        this.mEventLogger.setSaveFrameCount(this.mSaveFrameCount);
        this.mEventLogger.setEffectConfigSetting(this.mConfig.getEffectConfigMap());
        this.mEventLogger.setEffectConfigUsing(this.mUsingEffect);
        return this.mEventLogger.getAllEvents(this.mTexType);
    }

    public EffectTexture getEffectTexture() {
        if (this.mIsRelease == false) goto L6;
        return null;
    L6:
        if (this.mLastComeFrameType != 1) goto L17;
        EffectTexture r100 = this.mEffectTexture;
        if (r100 != null) goto L10;
    L13:
        this.mEffectTexture = new EffectTexture(null, this.mTextureId.lock(), this.mTexWidth, this.mTexHeight, 36197, null);
        this.mTextureId.unlock();
    L15:
        return this.mEffectTexture;
    L10:
        if (this.mTexHeight != r100.getHeight()) goto L13;
        if (this.mTexWidth == this.mEffectTexture.getWidth()) goto L15;
    L17:
        if (this.mLastComeFrameType != 2) goto L23;
        IFrameProducer r101 = this.mFrameProducer;
        if (r101 != null) goto L21;
    L36:
        return null;
    L21:
        return r101.getEffectTexture();
    L23:
        if (this.mLastComeFrameType != 3) goto L33;
        HardwareBuffer r102 = this.mHardwareBuffer;
        if (r102 == null) goto L36;
        if (Build.VERSION.SDK_INT < 29) goto L36;
        return new EffectTexture(null, r102, r102.getWidth(), this.mHardwareBuffer.getHeight(), this.mHardwareBuffer.getFormat(), 3);
    L30:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.TAG, "getEffectTexture exp = " + e);
        goto L36
    L33:
        if (this.mLastComeFrameType != 4) goto L36;
        return this.mHardwareBufferTexture;
    }

    public VideoSurfaceTexture getExtraVideoSurfaceTexture() {
        TextureRenderer r100 = this.mTextureRenderer;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getExtraVideoSurfaceTexture();
    }

    public IFrameProducer getFrameProducer() {
        if (this.mFrameProducer != null) goto L8;
        if (Build.VERSION.SDK_INT < 28) goto L8;
        ImageReaderProducer r100 = new ImageReaderProducer(this.mTexType);
        this.mFrameProducer = r100;
        r100.setOnFrameAvailableListener(this.mOnFrameAvailableListener, this.mRenderHandler);
    L8:
        return this.mFrameProducer;
    }

    public int[] getRect() {
        if (this.mLastComeFrameType == 3) goto L10;
        if (this.mLastComeFrameType == 4) goto L10;
        return null;
    L10:
        return this.mRect;
    }

    public Bundle getSaveFrameBundle() {
        Bundle r100 = this.mSaveFrameBundle;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mSaveFrameBundle.isEmpty() == true) goto L7;
        Bundle r101 = this.mSaveFrameBundle.deepCopy();     // Catch: Throwable -> L10
        this.mSaveFrameBundle = new Bundle();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    L7:
        r101 = null;
        goto L8
    }

    public int getSurfaceRealHeight() {
        VideoSurface r100 = this.mOffScreenSurface;
        if (r100 == null) goto L8;
        int r101 = r100.mSurfaceHeight;
        if (r101 <= 0) goto L8;
        return r101;
    L8:
        return getConsumerHeight(this.mEglSurface);
    }

    public int getSurfaceRealWidth() {
        VideoSurface r100 = this.mOffScreenSurface;
        if (r100 == null) goto L8;
        int r101 = r100.mSurfaceWidth;
        if (r101 <= 0) goto L8;
        return r101;
    L8:
        return getConsumerWidth(this.mEglSurface);
    }

    @Override // android.graphics.SurfaceTexture
    public long getTimestamp() {
        if (this.mLastComeFrameType != 3) goto L7;
        return System.nanoTime();
    L7:
        if (this.mLastComeFrameType == 4) goto L9;
        IFrameProducer r100 = this.mFrameProducer;
        if (r100 == null) goto L17;
        if (this.mLastComeFrameType != 2) goto L17;
        return r100.getTimestamp();
    L17:
        return super.getTimestamp();
    L9:
        return System.nanoTime();
    }

    public int getViewportHeight() {
        int r100 = getConsumerHeight(this.mEglSurface);
        if (this.mViewportHeight == r100) goto L6;
        this.mViewportHeight = r100;
    L6:
        return this.mViewportHeight;
    }

    public int getViewportWidth() {
        int r100 = getConsumerWidth(this.mEglSurface);
        if (this.mViewportWidth == r100) goto L6;
        this.mViewportWidth = r100;
    L6:
        return this.mViewportWidth;
    }

    public boolean isAlive() {
        TextureRenderLog.i(this.mTexType, this.TAG, "is alive = " + this.mOffScreenSurface + ", eglsur = " + this.mEglSurface + ", updateSurface = " + this.mUpdateSurface + "mReleaseOffScreenFinish = " + this.mReleaseOffScreenSurfaceFinish);
        TextureRenderManager r100 = TextureRenderManager.getManager();
        if (r100 != null) goto L5;
    L18:
        TextureRenderLog.i(this.mTexType, this.TAG, "old alive");
        if (this.mOffScreenSurface == null) goto L21;
    L22:
        return true;
    L21:
        if (this.mEglSurface != EGL14.EGL_NO_SURFACE) goto L22;
        return false;
    L5:
        if (r100.isAsyncRelaseSurfaceTexture() == false) goto L18;
        int r101 = this.mTexType;
        if (r101 != 0) goto L18;
        TextureRenderLog.i(r101, this.TAG, "new alive");
        if (this.mOffScreenSurface == null) goto L11;
    L16:
        return true;
    L11:
        if (this.mEglSurface != EGL14.EGL_NO_SURFACE) goto L16;
        if (this.mUpdateSurface != null) goto L16;
        if (this.mReleaseOffScreenSurfaceFinish == false) goto L16;
        return false;
    }

    public boolean isCurrentObject() {
        EGLRuntime r100 = this.mEGLRuntime;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isCurrentObject(this.mObjectId) == false) goto L7;
        return true;
    }

    public boolean isMakeCurrent() {
        if (this.mIsMakeCurrent == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mEglSurface == EGL14.EGL_NO_SURFACE) goto L7;
        return true;
    }

    public void lock() {
        this.mLock.lock();
    }

    public boolean makeCurrent() {
        if (makeCurrent(this.mEglSurface) == false) goto L13;
        this.mIsMakeCurrent = true;
        EGLRuntime r100 = this.mEGLRuntime;
        if (r100 == null) goto L11;
        r100.setDrawingObjectId(this.mObjectId);
        TextureRenderEventLogger r101 = this.mEventLogger;
        if (this.mEGLRuntime.getGLMajorVersion() < 3) goto L9;
        int r102 = 1;
    L10:
        r101.setUseGL3(r102);
        this.mEventLogger.setEGLContextBitDepth(this.mRGBBitsFromEGLConfig);
        goto L11
    L9:
        r102 = 0;
    L11:
        this.mExtraSurfaceMakeCurrent = 0;
        return true;
    L13:
        return false;
    }

    public boolean needDrop() {
        long r100 = this.mStartPlayTimeNanos;
        if (r100 <= 0) goto L11;
        if (r100 <= getTimestamp()) goto L11;
        int r101 = this.mDropCount;
        if (r101 >= 5) goto L11;
        this.mDropCount = r101 + 1;
        TextureRenderLog.i(this.mTexType, this.TAG, "previous play period,drop count:" + this.mDropCount);
        return true;
    L11:
        if (this.mIsPaused == false) goto L14;
        TextureRenderLog.i(this.mTexType, this.TAG, "is paused");
        return true;
    L14:
        return false;
    }

    @Override // com.ss.texturerender.vsync.IVsyncCallback
    public void notifyVsync() {
        boolean r100 = false;
        if (this.mLastComeFrameType != 0) goto L5;
        sendRenderMsg(0, false);
        return;
    L5:
        if (this.mSyncSetVsync == 1) goto L7;
    L9:
        sendRenderMsg(1, r100);
        return;
    L7:
        if (DeviceManager.isVRDevice() == false) goto L9;
        r100 = true;
        goto L9
    }

    public Map<String, Integer> querySRAndRenderState() {
        int r100 = this.mUsingEffect.get(5).intValue();
        int r101 = this.mFrameCountReceived;
        HashMap r102 = new HashMap();
        r102.put(TextureRenderKeys.KEY_IS_SR_STATE_QUERY, Integer.valueOf(r100));
        r102.put(TextureRenderKeys.KEY_IS_RENDER_FRAME_INDEX_QUERY, Integer.valueOf(r101));
        return r102;
    }

    @Override // android.graphics.SurfaceTexture
    public void release() {
        TextureRenderLog.i(this.mTexType, this.TAG, "release");
        releaseInternal();
        super.release();
    }

    public void releaseAllExtraSurface() {
        Iterator<Map.Entry<Surface, EGLSurface>> r100 = this.mExtraSurfaceMap.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Map.Entry<Surface, EGLSurface> r101 = r100.next();
        if (r101.getValue() == EGL14.EGL_NO_SURFACE) goto L10;
        if (r101.getValue() == null) goto L10;
        EGL14.eglDestroySurface(this.mEglDisplay, r101.getValue());
        TextureRenderLog.i(this.mTexType, this.TAG, "releaseAllExtraSurface sf:" + this + ", eglSurface:" + r101.getValue());
    L10:
        r100.remove();
        goto L4
    }

    public void resetFlag() {
        this.mUsingEffect.clear();
    }

    public void unlock() {
        this.mLock.unlock();
    }

    public void updateAllExtraSurface() {
        if (this.mExtraSurfaceMap.isEmpty() == false) goto L5;
        return;
    L5:
        TextureRenderLog.i(this.mTexType, this.TAG, "updateAllExtraSurface begin sf:" + this + ", mExtraSurfaceMap size:" + this.mExtraSurfaceMap.size());
        Iterator r100 = new ArrayList(this.mExtraSurfaceMap.keySet()).iterator();
    L7:
        if (r100.hasNext() == false) goto L14;
        Surface r101 = (Surface) r100.next();
        EGLSurface r102 = this.mExtraSurfaceMap.get(r101);
        if (r102 == null) goto L13;
        if (r102 == EGL14.EGL_NO_SURFACE) goto L13;
        EGL14.eglDestroySurface(this.mEglDisplay, r102);
    L13:
        this.mExtraSurfaceMap.put(r101, createEGLWindowSurface(r101));
        goto L7
    L14:
        TextureRenderLog.i(this.mTexType, this.TAG, "updateAllExtraSurface end sf:" + this + ", mExtraSurfaceMap size:" + this.mExtraSurfaceMap.size());
    }

    @Override // android.graphics.SurfaceTexture
    public void updateTexImage() {
        if (this.mLastComeFrameType != 3) goto L6;
        return;
    L6:
        if (this.mLastComeFrameType != 4) goto L8;
        return;
    L8:
        IFrameProducer r100 = this.mFrameProducer;
        if (r100 != null) goto L11;
    L13:
        super.updateTexImage();
        return;
    L11:
        if (this.mLastComeFrameType != 2) goto L13;
        r100.updateImage();
    }

    public boolean couldForceRelease() {
        if ((SystemClock.elapsedRealtime() - this.mIdleTimeStamp) <= 120000) goto L5;
        return true;
    L5:
        return false;
    }

    public void effectChainBegin() {
        this.mEffectChainStartTime = SystemClock.elapsedRealtime();
        this.mCurrentEffectProcessDepth = 0;
    }

    public void effectChainEnd() {
        double r100 = SystemClock.elapsedRealtime() - this.mEffectChainStartTime;
        if (this.mCurrentEffectStartTime != AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        return;
    L5:
        double r101 = this.mEffectChainAccumulatedTime + r100;
        this.mEffectChainAccumulatedTime = r101;
        int r102 = this.mEffectChainFrameCount + 1;
        this.mEffectChainFrameCount = r102;
        if (r102 <= 0) goto L9;
        this.mEffectChainAverageTime = (float) (r101 / ((double) r102));
        return;
    }

    public void playerRenderStart() {
        TextureRenderManager r100 = TextureRenderManager.getManager();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isAsyncRelaseSurfaceTexture() == true) goto L7;
        return;
    L7:
        if (this.mTexType != 0) goto L14;
        IVsyncHelper r101 = this.mVsyncHelper;
        if (r101 == null) goto L15;
        r101.addObserver(this);
        return;
    L15:
        return;
    }

    public boolean render() {
        HashMap<Surface, EGLSurface> r100 = getExtraRealSurfaces();
        if (r100.size() <= 0) goto L6;
        makeCurrent();
    L6:
        if (eglSwapBuffer(this.mEglSurface, true) == true) goto L8;
        return false;
    L8:
        notifyRenderFrame(this.mSerial);
        Iterator<Map.Entry<Surface, EGLSurface>> r101 = r100.entrySet().iterator();
    L10:
        if (r101.hasNext() == false) goto L12;
        EGLSurface r102 = r101.next().getValue();
        makeCurrent(r102);
        eglSwapBuffer(r102, false);
        this.mExtraSurfaceMakeCurrent = 1;
        goto L10
    L12:
        return true;
    }

    public EffectConfig getEffectConfig() {
        return this.mConfig;
    }

    public int getEnableUseEglDummySurface() {
        return this.mEnableUseEglDummySurface;
    }

    public TextureRenderEventLogger getEventLogger() {
        return this.mEventLogger;
    }

    public HashMap<Surface, EGLSurface> getExtraRealSurfaces() {
        return this.mExtraSurfaceMap;
    }

    public Bundle getFrameCallbackBundle() {
        return this.mFrameCallbackBundle;
    }

    public int getFrameCountReceived() {
        return this.mFrameCountReceived;
    }

    public int getLastComeFrameType() {
        return this.mLastComeFrameType;
    }

    public long getOjbectId() {
        return this.mObjectId;
    }

    public CopyOnWriteArrayList<Bundle> getParamList() {
        return this.mParamList;
    }

    public PureColorDetector.Params getPureColorDetectorParams() {
        return this.mPureColorDetectorParams;
    }

    public Handler getRenderHandler() {
        return this.mRenderHandler;
    }

    public Surface getRenderSurface() {
        return this.mRenderSurface;
    }

    public int getSerial() {
        return this.mSerial;
    }

    public int getState() {
        return this.mState;
    }

    public long getSurfaceUpdateTime() {
        return this.mUpdateSurfaceTime;
    }

    public int getTexHeight() {
        return this.mTexHeight;
    }

    public ITexture getTexId() {
        return this.mTextureId;
    }

    public int getTexWidth() {
        return this.mTexWidth;
    }

    public TextureRenderer getTextureRender() {
        return this.mTextureRenderer;
    }

    public Surface getUpdateSurface() {
        return this.mUpdateSurface;
    }

    public int getUseSr() {
        return this.mSuperOpen;
    }

    public boolean isPreRender() {
        return this.mIsPreRender;
    }

    public boolean isRelease() {
        return this.mIsRelease;
    }

    public boolean isUpdateFrame() {
        return this.mFrameReady;
    }

    public int texType() {
        return this.mTexType;
    }

    public String toString() {
        return this.TAG;
    }

    private void _trySetupHDR2SDRFilter(int r100) {
        if (r100 != 2) goto L5;
    L4:
        boolean r101 = true;
    L12:
        Bundle r102 = new Bundle();
        r102.putInt("effect_type", 4);
        if (r101 == false) goto L15;
        r102.putInt("action", 21);
        r102.putInt("hdr_type", r100);
        r102.putInt(TextureRenderKeys.KEY_IS_USE_EFFECT, 1);
    L16:
        TextureRenderLog.d(this.mTexType, this.TAG, "tryHDR2SDR,need:" + r101 + ",type:" + r100);
        setEffect(r102);
        return;
    L15:
        r102.putInt("action", 19);
        r102.putInt(TextureRenderKeys.KEY_IS_INT_VALUE, 0);
        goto L16
    L5:
        if (r100 != 1) goto L11;
        EGLRuntime r103 = this.mEGLRuntime;
        if (r103 == null) goto L11;
        if (r103.isSupportBt2020PQ() <= 0) goto L4;
    L11:
        r101 = false;
        goto L12
    }

    private void _tryUpdateEGLSurface(int r100) {
        Handler r101 = this.mRenderHandler;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.mRenderMsgBundle != null) goto L10;
        return;
    L10:
        Message r102 = r101.obtainMessage(4);     // Catch: Exception -> L9
        this.mRenderMsgBundle.putSerializable(KEY_TEXTURE, this);     // Catch: Exception -> L9
        r102.setData(this.mRenderMsgBundle);     // Catch: Exception -> L9
        r102.arg1 = r100;     // Catch: Exception -> L9
        this.mRenderHandler.sendMessage(r102);     // Catch: Exception -> L9
        return;
    }

    public static /* synthetic */ String access$000(VideoSurfaceTexture r100) {
        return r100.TAG;
    }

    private boolean checkRecreateEGLSurface(int r100) {
        if (r100 == 7) goto L5;
    L23:
        return false;
    L5:
        if (this.mEglSurface == EGL14.EGL_NO_SURFACE) goto L23;
        int[] r101 = new int[1];
        boolean r102 = EGL14.eglQuerySurface(this.mEglDisplay, this.mEglSurface, 12445, r101, 0);
        TextureRenderLog.d(this.mTexType, this.TAG, "colorspace:" + r101[0] + ",mHDRType:" + this.mHDRType + ",ret:" + r102);
        if (r102 == false) goto L23;
        int r103 = r101[0];
        if (r103 == 13120) goto L11;
    L12:
        if (r103 == 13120) goto L23;
        if (this.mHDRType != 1) goto L23;
    L15:
        if (r103 == 13120) goto L22;
        EGLRuntime r104 = this.mEGLRuntime;
        if (r104 != null) goto L19;
        return false;
    L19:
        if (r104.isSupportBt2020PQ() <= 0) goto L25;
        return true;
    L25:
        return false;
    L22:
        return true;
    L11:
        if (this.mHDRType != 1) goto L15;
        goto L12
    }

    private void internalConstruct(Handler r100) {
        this.mObjectId = new Random().nextLong();
        this.mRenderHandler = r100;
        this.mLock = new ReentrantLock();
        this.mCreateLooper = Looper.myLooper();
        this.mRenderMsgBundle = new Bundle();
        this.mEglSurface = EGL14.EGL_NO_SURFACE;
        this.mSuperOpen = 0;
        MyOnFrameAvailableListener r101 = new MyOnFrameAvailableListener(this);
        this.mOnFrameAvailableListener = r101;
        if (this.mFrameCallbackInRenderThread != 1) goto L5;
        setOnFrameAvailableListener(r101, this.mRenderHandler);
    L6:
        IFrameProducer r102 = this.mFrameProducer;
        if (r102 == null) goto L9;
        r102.setOnFrameAvailableListener(this.mOnFrameAvailableListener, this.mRenderHandler);
    L9:
        TextureRenderLog.i(this.mTexType, this.TAG, "gen a texture :" + this.mObjectId + ", thread id " + ThreadMethodProxy.currentThread().getId() + ", looper = " + looperToString(this.mCreateLooper));
        return;
    L5:
        setOnFrameAvailableListener(r101);
        goto L6
    }

    private String looperToString(Looper r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Thread r101 = ThreadMethodProxy.getLooperThread(r100);
        if (r101 == null) goto L10;
        return "Looper (" + r101.getName() + ", tid " + r101.getId() + ") {" + Integer.toHexString(System.identityHashCode(r100)) + i.f25855d;
    L10:
        return "Looper {" + Integer.toHexString(System.identityHashCode(r100)) + i.f25855d;
    }

    public void bindEGLEnv(EGLRuntime r100) {
        if (r100 == null) goto L6;
        this.mEGLRuntime = r100;
        this.mEglContext = r100.eglContext;
        EGLDisplay r101 = r100.eglDisplay;
        this.mEglDisplay = r101;
        EGLConfig r102 = r100.eglConfig;
        this.mEglConfig = r102;
        int[] r103 = new int[1];
        int[] r104 = new int[1];
        int[] r105 = new int[1];
        EGL14.eglGetConfigAttrib(r101, r102, 12324, r103, 0);
        EGL14.eglGetConfigAttrib(this.mEglDisplay, this.mEglConfig, 12323, r104, 0);
        EGL14.eglGetConfigAttrib(this.mEglDisplay, this.mEglConfig, 12322, r105, 0);
        this.mRGBBitsFromEGLConfig = (r103[0] + r104[0]) + r105[0];
        TextureRenderLog.d(this.mTexType, this.TAG, "bindEGLEnv rgbbits = " + this.mRGBBitsFromEGLConfig + " runtime = " + r100);
        return;
    L6:
        throw new RuntimeException(this.TAG + " no egl env for texture bind");
    }

    public boolean canReuse(Looper r100) {
        boolean r101 = false;
    L12:
        TextureRenderLog.i(this.mTexType, this.TAG, "canReuse ret = false looper =" + looperToString(r100) + ", mlooper = " + looperToString(this.mCreateLooper) + ", mForbidReuseVideoSurfaceTexture = " + this.mForbidReuseVideoSurfaceTexture);
        return false;
    L10:
        TextureRenderLog.i(this.mTexType, this.TAG, "canReuse ret = false looper =" + looperToString(r100) + ", mlooper = " + looperToString(this.mCreateLooper) + ", mForbidReuseVideoSurfaceTexture = " + this.mForbidReuseVideoSurfaceTexture);
        return false;
    L4:
        if (r100 != this.mCreateLooper) goto L8;
        if (this.mForbidReuseVideoSurfaceTexture > 0) goto L8;
        r101 = true;
        goto L8
    L8:
        TextureRenderLog.i(this.mTexType, this.TAG, "canReuse ret = " + r101 + " looper =" + looperToString(r100) + ", mlooper = " + looperToString(this.mCreateLooper) + ", mForbidReuseVideoSurfaceTexture = " + this.mForbidReuseVideoSurfaceTexture);
        return r101;
    }

    public EGLSurface createEGLWindowSurface(Surface r110) {
        EGLSurface r100 = EGL14.EGL_NO_SURFACE;
        if (r110 != null) goto L5;
        return r100;
    L5:
        if (r110.isValid() == false) goto L35;
        this.mEventLogger.setSurfaceValid(1);
        String r101 = EGL14.eglQueryString(this.mEglDisplay, 12373);
        if (this.mHDRType != 1) goto L13;
        EGLRuntime r102 = this.mEGLRuntime;
        if (r102 == null) goto L13;
        if (r102.isSupportBt2020PQ() <= 0) goto L13;
        int[] r103 = {12445, TextureRenderKeys.EGL_GL_COLORSPACE_BT2020_PQ_EXT, 12344};
        boolean r104 = true;
    L33:
        TextureRenderLog.i(this.mTexType, this.TAG, "create window surface from " + r110 + ",attr:" + Arrays.toString(r103));     // Catch: Exception -> L31
        EGLSurface r111 = EGL14.eglCreateWindowSurface(this.mEglDisplay, this.mEglConfig, r110, r103, 0);     // Catch: Exception -> L31
        if (r111 != EGL14.EGL_NO_SURFACE) goto L19;
        int r105 = EGL14.eglGetError();     // Catch: Exception -> L31
        notifyError(r105, 0, "");     // Catch: Exception -> L31
        TextureRenderLog.e(this.mTexType, this.TAG, "create window surface failed:" + GLUtils.getEGLErrorString(r105));     // Catch: Exception -> L31
        this.mEventLogger.setEGLSurfaceError(r105);     // Catch: Exception -> L31
        return r111;
    L19:
        List<Integer> r106 = this.mStaticMetadata;     // Catch: Exception -> L31
        if (r106 != null) goto L22;
    L29:
        this.mEventLogger.setEGLSurfaceError(0);     // Catch: Exception -> L31
        return r111;
    L22:
        if (r106.size() < 10) goto L29;
        if (r104 == false) goto L29;
        if (TextUtils.isEmpty(r101) == true) goto L29;
        if (r101.contains("EGL_EXT_surface_SMPTE2086_metadata") == false) goto L29;
        EGL14.eglSurfaceAttrib(this.mEglDisplay, r111, TextureRenderKeys.EGL_SMPTE2086_DISPLAY_PRIMARY_RX_EXT, ((Integer) ListProtector.get(this.mStaticMetadata, 0)).intValue());     // Catch: Exception -> L31
        EGL14.eglSurfaceAttrib(this.mEglDisplay, r111, TextureRenderKeys.EGL_SMPTE2086_DISPLAY_PRIMARY_RY_EXT, ((Integer) ListProtector.get(this.mStaticMetadata, 1)).intValue());     // Catch: Exception -> L31
        EGL14.eglSurfaceAttrib(this.mEglDisplay, r111, TextureRenderKeys.EGL_SMPTE2086_DISPLAY_PRIMARY_GX_EXT, ((Integer) ListProtector.get(this.mStaticMetadata, 2)).intValue());     // Catch: Exception -> L31
        EGL14.eglSurfaceAttrib(this.mEglDisplay, r111, TextureRenderKeys.EGL_SMPTE2086_DISPLAY_PRIMARY_GY_EXT, ((Integer) ListProtector.get(this.mStaticMetadata, 3)).intValue());     // Catch: Exception -> L31
        EGL14.eglSurfaceAttrib(this.mEglDisplay, r111, TextureRenderKeys.EGL_SMPTE2086_DISPLAY_PRIMARY_BX_EXT, ((Integer) ListProtector.get(this.mStaticMetadata, 4)).intValue());     // Catch: Exception -> L31
        EGL14.eglSurfaceAttrib(this.mEglDisplay, r111, TextureRenderKeys.EGL_SMPTE2086_DISPLAY_PRIMARY_BY_EXT, ((Integer) ListProtector.get(this.mStaticMetadata, 5)).intValue());     // Catch: Exception -> L31
        EGL14.eglSurfaceAttrib(this.mEglDisplay, r111, TextureRenderKeys.EGL_SMPTE2086_WHITE_POINT_X_EXT, ((Integer) ListProtector.get(this.mStaticMetadata, 6)).intValue());     // Catch: Exception -> L31
        EGL14.eglSurfaceAttrib(this.mEglDisplay, r111, TextureRenderKeys.EGL_SMPTE2086_WHITE_POINT_Y_EXT, ((Integer) ListProtector.get(this.mStaticMetadata, 7)).intValue());     // Catch: Exception -> L31
        EGL14.eglSurfaceAttrib(this.mEglDisplay, r111, TextureRenderKeys.EGL_SMPTE2086_MAX_LUMINANCE_EXT, ((Integer) ListProtector.get(this.mStaticMetadata, 8)).intValue());     // Catch: Exception -> L31
        EGL14.eglSurfaceAttrib(this.mEglDisplay, r111, TextureRenderKeys.EGL_SMPTE2086_MIN_LUMINANCE_EXT, ((Integer) ListProtector.get(this.mStaticMetadata, 9)).intValue());     // Catch: Exception -> L31
    L31:
        notifyError(5, 0, "");
        TextureRenderLog.e(this.mTexType, this.TAG, "createEGLWindowSurface exception failed");
        return EGL14.EGL_NO_SURFACE;
    L13:
        r103 = new int[]{12344};
        r104 = false;
        goto L33
    L35:
        return r100;
    }

    public void currentEffectProcessBegin(int r100) {
        if (this.mCurrentEffectProcessDepth != 0) goto L5;
        this.mCurrentEffectStartTime = SystemClock.elapsedRealtime();
    L5:
        this.mCurrentEffectProcessDepth++;
    }

    public void currentEffectProcessEnd(int r100) {
        int r101 = this.mCurrentEffectProcessDepth - 1;
        this.mCurrentEffectProcessDepth = r101;
        if (r101 == 0) goto L5;
        return;
    L5:
        if (this.mCurrentEffectStartTime != AudioStats.AUDIO_AMPLITUDE_NONE) goto L7;
        return;
    L7:
        double r102 = SystemClock.elapsedRealtime() - this.mCurrentEffectStartTime;
        HashMap<Integer, Double> r103 = this.mPerEffectAccumulatedTime;
        if (r103 != null) goto L10;
        return;
    L10:
        if (this.mPerEffectFrameCount != null) goto L12;
        return;
    L12:
        if (this.mPerEffectAverageTime != null) goto L15;
        return;
    L15:
        if (r103.containsKey(Integer.valueOf(r100)) == true) goto L17;
        this.mPerEffectAccumulatedTime.put(Integer.valueOf(r100), Double.valueOf(r102));
        this.mPerEffectFrameCount.put(Integer.valueOf(r100), 1);
        this.mPerEffectAverageTime.put(Integer.valueOf(r100), Float.valueOf((float) r102));
        return;
    L17:
        Double r104 = this.mPerEffectAccumulatedTime.get(Integer.valueOf(r100));
        Integer r105 = this.mPerEffectFrameCount.get(Integer.valueOf(r100));
        if (r104 == null) goto L29;
        if (r105 == null) goto L32;
        double r106 = r104.doubleValue() + r102;
        int r107 = r105.intValue() + 1;
        this.mPerEffectAccumulatedTime.put(Integer.valueOf(r100), Double.valueOf(r106));
        this.mPerEffectFrameCount.put(Integer.valueOf(r100), Integer.valueOf(r107));
        if (r107 <= 0) goto L30;
        this.mPerEffectAverageTime.put(Integer.valueOf(r100), Float.valueOf((float) (r106 / ((double) r107))));
        return;
    L30:
        return;
    L32:
        return;
    }

    public Bundle getBundleOption(int r100) {
        if (r100 == 170) goto L19;
        if (r100 == 180) goto L17;
        if (r100 == 184) goto L15;
        if (r100 == 188) goto L13;
        return null;
    L13:
        return this.mSRParamsBundle;
    L15:
        return this.mBrightnessBalanceParamsBundle;
    L17:
        return this.mAesBoostParamsBundle;
    L19:
        return this.mSRProcessParamter;
    }

    public int getConsumerHeight(EGLSurface r100) {
        if (r100 != EGL14.EGL_NO_SURFACE) goto L6;
        return -1;
    L6:
        int[] r101 = new int[1];
        EGL14.eglQuerySurface(this.mEglDisplay, r100, 12374, r101, 0);
        return r101[0];
    }

    public int getConsumerWidth(EGLSurface r100) {
        if (r100 != EGL14.EGL_NO_SURFACE) goto L6;
        return -1;
    L6:
        int[] r101 = new int[1];
        EGL14.eglQuerySurface(this.mEglDisplay, r100, 12375, r101, 0);
        return r101[0];
    }

    public float getFloatOption(int r100) {
        return getFloatOption(r100, -1);
    }

    public int getIntOption(int r100) {
        if (r100 == 121) goto L66;
        if (r100 == 130) goto L64;
        if (r100 == 137) goto L62;
        if (r100 == 141) goto L60;
        if (r100 == 144) goto L58;
        if (r100 == 152) goto L56;
        if (r100 == 171) goto L54;
        if (r100 == 176) goto L52;
        if (r100 == 189) goto L50;
        if (r100 == 202) goto L48;
        if (r100 == 146) goto L46;
        if (r100 == 147) goto L44;
        if (r100 == 178) goto L42;
        if (r100 == 179) goto L40;
        switch(r100) {
            case 181: goto L38;
            case 182: goto L36;
            case 183: goto L34;
            default: goto L32;
        };
    L32:
        return getIntOption(r100, -1);
    L34:
        return this.mGlBlitSkipGLFinish;
    L36:
        return this.mEnableGlBlitToSceenForHardWareBuffer;
    L38:
        return this.mBeginSRThreshold;
    L40:
        return this.mSkipFiliterCallGlClear;
    L42:
        return this.mSkipFilterCallGlFinish;
    L44:
        return this.mSRProcessScaleType;
    L46:
        return this.mDoMirrorFirst;
    L48:
        return this.mNeedCheckMakeCurrent;
    L50:
        return this.mHardwareBufferRenderDirectly;
    L52:
        return this.mEnableGlBlitToScreen;
    L54:
        return this.mEnableResetCropParamsInRender;
    L56:
        return this.mOpenVQScore;
    L58:
        return this.mNotKeepLastParams;
    L60:
        return this.mEnableExtraSurfaceRenderCallback;
    L62:
        return this.mFreezeDirector;
    L64:
        return this.mBitDepth;
    L66:
        return this.mFrameCount;
    }

    public Bundle getOption(int r100) {
        if (r100 == 130) goto L11;
        if (r100 == 153) goto L9;
        return null;
    L9:
        return this.mVQScoreBundle;
    L11:
        return this.mRoiSRParamsBundle;
    }

    public String getStringOption(int r100) {
        return getStringOption(r100, -1);
    }

    @Override // android.graphics.SurfaceTexture
    public void getTransformMatrix(float[] r100) {
        if (this.mLastComeFrameType != 3) goto L7;
        Matrix.setIdentityM(r100, 0);
        r100[5] = -1.0f;
        r100[13] = 1.0f;
        return;
    L7:
        if (this.mLastComeFrameType != 4) goto L10;
        Matrix.setIdentityM(r100, 0);
        r100[5] = -1.0f;
        r100[13] = 1.0f;
        return;
    L10:
        IFrameProducer r101 = this.mFrameProducer;
        if (r101 != null) goto L13;
    L15:
        super.getTransformMatrix(r100);
        return;
    L13:
        if (this.mLastComeFrameType != 2) goto L15;
        r101.getTransformMatrix(r100);
    }

    public ColorConversion getYUV2RGBMatrix(EffectTexture r110) {
        if (isRelease() == true) goto L40;
        if (r110 == null) goto L40;
        if (r110.getTexTarget() != 36197) goto L40;
        if (this.mDataSpace < 0) goto L40;
        int r111 = r110.getFormat();
        boolean r100 = false;
        if (r111 <= 0) goto L18;
        if (r111 == 35) goto L17;
        if (r111 == 39) goto L17;
        if (r111 == 40) goto L17;
        if (r111 == 17) goto L17;
        if (r111 == 842094169) goto L17;
    L37:
        if (r100 == false) goto L40;
        return ColorConversion.getFromDataspace(this.mDataSpace, this.mBitDepth);
    L17:
        r100 = true;
        goto L37
    L18:
        VideoSurface r112 = this.mOffScreenSurface;
        int r101 = -1;
        if (r112 == null) goto L21;
        int r102 = r112.getIntOption(133);
    L23:
        if (r102 == 4) goto L17;
        if (r112 == null) goto L27;
        r101 = NativeWindow.getFormat(r112);
    L27:
        if (r101 == 35) goto L17;
        if (r101 == 39) goto L17;
        if (r101 == 40) goto L17;
        if (r101 == 16) goto L17;
        if (r101 == 17) goto L17;
        if (r101 == 20) goto L17;
        if (r101 != 842094169) goto L37;
    L21:
        r102 = -1;
    L40:
        return null;
    }

    public boolean handleSurfaceChange(Message r100) {
        if (this.mEGLRuntime != null) goto L5;
        return false;
    L5:
        int r101 = r100.arg1;
        this.mLock.lock();
        if (r101 == 7) goto L8;
        Surface r102 = this.mRenderSurface;
        Surface r103 = this.mUpdateSurface;
        if (r102 != r103) goto L22;
        if (r103 == null) goto L22;
        if (r103.toString().contains("SurfaceTexture") == false) goto L22;
        TextureRenderLog.i(this.mTexType, this.TAG, "surface change the same surface hashcode");
        ReentrantLock r104 = this.mLock;
        if (r104 == null) goto L21;
        r104.unlock();
    L21:
        return false;
    L22:
        this.mRenderSurface = this.mUpdateSurface;
        this.mOnFrameAvailableListener.disable();
        MyOnFrameAvailableListener r105 = new MyOnFrameAvailableListener(this);
        this.mOnFrameAvailableListener = r105;
        if (this.mFrameCallbackInRenderThread != 1) goto L25;
        setOnFrameAvailableListener(r105, this.mRenderHandler);
    L26:
        IFrameProducer r106 = this.mFrameProducer;
        if (r106 == null) goto L29;
        r106.setOnFrameAvailableListener(this.mOnFrameAvailableListener, this.mRenderHandler);
    L29:
        this.mLock.unlock();
        if (this.mEGLRuntime.getDrawingObjectId() != 0) goto L32;
    L34:
        boolean r107 = false;
    L35:
        boolean r108 = createEGLWindowSurface(r107);
        if (r108 == true) goto L38;
        return r108;
    L38:
        this.mSerial++;
        TextureRenderLog.i(this.mTexType, this.TAG, "update surface done serial = " + this.mSerial + ", update time = " + this.mUpdateSurfaceTime);
        if (this.mEglSurface == EGL14.EGL_NO_SURFACE) goto L42;
        return true;
    L42:
        return false;
    L32:
        if (this.mEGLRuntime.isCurrentObject(this.mObjectId) == false) goto L34;
        r107 = true;
        goto L35
    L25:
        setOnFrameAvailableListener(r105);
        goto L26
    L8:
        if (checkRecreateEGLSurface(r101) == true) goto L22;
        TextureRenderLog.d(this.mTexType, this.TAG, "don't recreateEGLSurface for HDR");
        ReentrantLock r109 = this.mLock;
        if (r109 == null) goto L12;
        r109.unlock();
    L12:
        return false;
    }

    public void handleUpdateVideoState(int r110) {
        int r100 = this.mState;
        this.mState = r110;
        if (r110 == 1) goto L10;
        if (r110 != 2) goto L6;
        TextureRenderLog.i(this.mTexType, this.TAG, "TEXTURE_STATE_PAUSING startPlayTime = " + this.mStartPlayTimeNanos + " oldState = " + r100);
        return;
    L6:
        if (r110 != 3) goto L23;
        handleUpdateVideoStateForStop();
        this.mDropCount = 0;
        TextureRenderLog.i(this.mTexType, this.TAG, "TEXTURE_STATE_STOP startPlayTime = " + this.mStartPlayTimeNanos + " oldState = " + r100);
        return;
    L23:
        return;
    L10:
        this.mLastFrameTime = SystemClock.elapsedRealtime();
        if (this.mStartPlayTimeNanos > 0) goto L13;
        this.mStartPlayTimeNanos = System.nanoTime();
    L13:
        IVsyncHelper r111 = this.mVsyncHelper;
        if (r111 == null) goto L16;
        r111.addObserver(this);
    L16:
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L19;
        this.mLastComeFrameType = 0;
    L19:
        TextureRenderLog.i(this.mTexType, this.TAG, "TEXTURE_STATE_PLAYING startPlayTime = " + this.mStartPlayTimeNanos + " oldState = " + r100);
    }

    public void ignoreSRResolutionCheck(boolean r100) {
        this.mIgnoreSRResCheck = r100;
        TextureRenderLog.i(this.mTexType, this.TAG, "ignoreSRResolutionCheck:" + r100);
    }

    public void initExtraSurface(Surface r100) {
        TextureRenderLog.i(this.mTexType, this.TAG, "initExtraSurface begin sf:" + this + ", surface:" + r100 + ", mExtraSurfaceMap size:" + this.mExtraSurfaceMap.size());
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mExtraSurfaceMap.containsKey(r100) == true) goto L10;
        EGLSurface r101 = createEGLWindowSurface(r100);
        this.mExtraSurfaceMap.put(r100, r101);
        TextureRenderLog.i(this.mTexType, this.TAG, "initExtraSurface end sf:" + this + ", eglSurface:" + r101 + ", mExtraSurfaceMap size:" + this.mExtraSurfaceMap.size());
        return;
    }

    public boolean makeCurrent(EGLSurface r100) {
        if (r100 != EGL14.EGL_NO_SURFACE) goto L6;
        TextureRenderLog.e(this.mTexType, this.TAG, "no surface for make current");
        return false;
    L6:
        TextureRenderLog.i(this.mTexType, this.TAG, "make current again");
        GLES20.glFinish();
        if (EGL14.eglMakeCurrent(this.mEglDisplay, r100, r100, this.mEglContext) == true) goto L10;
        int r101 = EGL14.eglGetError();
        notifyError(r101, 0, "");
        TextureRenderLog.e(this.mTexType, this.TAG, "make current failed:" + r100 + " error = " + GLUtils.getEGLErrorString(r101));
        return false;
    L10:
        TextureRenderLog.i(this.mTexType, this.TAG, "make current done = " + this.mOffScreenSurface + " eglSurface = " + r100);
        return true;
    }

    public void notifyExtraSurfaceRender(Surface r100) {
        if (this.mOffScreenSurface == null) goto L9;
        this.mOffScreenSurface.onTextureUpdate(this.mSerial, r100, getTimestamp());     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    public void notifyRenderFrame(int r100) {
        if (r100 == this.mSerial) goto L15;
        return;
    L15:
        if (this.mOffScreenSurface == null) goto L17;
        this.mOffScreenSurface.onTextureUpdate(r100, getTimestamp());     // Catch: Exception -> L14
        if (this.mHeadPose == null) goto L11;
        this.mOffScreenSurface.onTextureUpdate(r100, (float) this.mHeadPose.getX0(), (float) this.mHeadPose.getX1(), (float) this.mHeadPose.getX2(), (float) this.mHeadPose.getX3());     // Catch: Exception -> L14
    L11:
        if (this.mFirstFrameRendered == true) goto L18;
        TextureRenderLog.i(this.mTexType, this.TAG, "first frame rendered");     // Catch: Exception -> L14
        this.mFirstFrameRendered = true;     // Catch: Exception -> L14
        this.mEventLogger.setFirstFrameRendered(1);     // Catch: Exception -> L14
        return;
    L18:
        return;
    L17:
        return;
    }

    public void onHeadposeChanged(Quaternion r100) {
        VideoSurface r101 = getOffScreenSurface();
        if (r101 == null) goto L6;
        r101.onHeadposeChanged(this.mSerial, (float) r100.getX0(), (float) r100.getX1(), (float) r100.getX2(), (float) r100.getX3());
        return;
    }

    public boolean onTouchEvent(MotionEvent r100) {
        TouchHelper r101 = this.mTouchHelper;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.onTouchEvent(r100);
    }

    public void registerTouchListener(GestureDetector.SimpleOnGestureListener r100) {
        if (this.mTouchHelper != null) goto L5;
        this.mTouchHelper = new TouchHelper(TextureRenderManager.getManager().getContext());
    L5:
        this.mTouchHelper.register(r100);
    }

    public void release(boolean r100) {
        TextureRenderLog.i(this.mTexType, this.TAG, "release glthread = " + r100);
        releaseOffScreenSurface(r100);
        release();
    }

    public void releaseExtraSurface(Surface r100) {
        TextureRenderLog.i(this.mTexType, this.TAG, "releaseExtraSurface begin sf:" + this + ", surface:" + r100 + ", mExtraSurfaceMap size:" + this.mExtraSurfaceMap.size());
        EGLSurface r101 = this.mExtraSurfaceMap.get(r100);
        if (r101 != null) goto L5;
    L8:
        TextureRenderLog.i(this.mTexType, this.TAG, "releaseExtraSurface end sf:" + this + ", eglSurface:" + r101 + ", mExtraSurfaceMap size:" + this.mExtraSurfaceMap.size());
        return;
    L5:
        if (r101 == EGL14.EGL_NO_SURFACE) goto L7;
        EGL14.eglDestroySurface(this.mEglDisplay, r101);
    L7:
        this.mExtraSurfaceMap.remove(r100);
        goto L8
    }

    public void releaseOffScreenSurface(boolean r100) {
        this.mOffScreenSurface = null;
        IFrameProducer r101 = this.mFrameProducer;
        if (r101 == null) goto L5;
        r101.release();
    L5:
        this.mFrameProducer = null;
        if (r100 == false) goto L13;
        this.mLock.lock();
        this.mUpdateSurface = null;
        this.mLock.unlock();
        if (this.mEglSurface == EGL14.EGL_NO_SURFACE) goto L12;
        EGL14.eglDestroySurface(this.mEglDisplay, this.mEglSurface);
        this.mEglSurface = EGL14.EGL_NO_SURFACE;
        this.mIsMakeCurrent = false;
        NativeWindow r102 = this.mNativeWindow;
        if (r102 == null) goto L12;
        r102.releaseWindow();
        this.mNativeWindow = null;
    L12:
        releaseAllExtraSurface();
    L15:
        if ((this.mTexType & 4) <= 0) goto L24;
        Message r103 = this.mSyncMsg;
        monitor-enter(r103);
        Message r104 = this.mSyncMsg;     // Catch: Throwable -> L21
        r104.arg1 = Integer.MIN_VALUE;     // Catch: Throwable -> L21
        r104.notify();     // Catch: Throwable -> L21
        TextureRenderLog.i(this.mTexType, this.TAG, "releaseOffScreenSurface mSyncMsg.notify");     // Catch: Throwable -> L21
        monitor-exit(r103);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    L24:
        this.mIdleTimeStamp = SystemClock.elapsedRealtime();
        if (this.mLastComeFrameType != 3) goto L27;
    L30:
        Object r105 = this.mHardwareBufferObject;
        monitor-enter(r105);
        this.mState = 3;     // Catch: Throwable -> L94
        this.mHardwareBuffer = null;     // Catch: Throwable -> L94
        releaseHardwareBufferTexture();     // Catch: Throwable -> L94
        monitor-exit(r105);     // Catch: Throwable -> L94
        this.mLastComeFrameType = 0;
    L35:
        IVsyncHelper r106 = this.mVsyncHelper;
        if (r106 == null) goto L38;
        r106.setEnable(false);
    L38:
        CopyOnWriteArrayList<Bundle> r107 = this.mParamList;
        if (r107 == null) goto L41;
        r107.clear();
        this.mParamList = null;
    L41:
        ConcurrentHashMap<Surface, Bundle> r108 = this.mExtraRenderCropParamsBundleMap;
        if (r108 == null) goto L44;
    L45:
        if (r108 == null) goto L47;
        r108.clear();
        this.mExtraRenderCropParamsBundleMap = null;
        TextureRenderLog.i(this.mTexType, this.TAG, "clear extra render crop params bundle map");
    L47:
        this.mMainRenderCropParamsBundle = null;
        Handler r109 = this.mRenderHandler;
        if (r109 != null) goto L99;
        Message r110 = new Message();
        r110.what = 40;
        r110.obj = this;
        this.mTextureRenderer.handleTextureRenderMsg(r110);
    L53:
        TextureRenderManager r111 = TextureRenderManager.getManager();
        if (r111 == null) goto L66;
        if (r111.isAsyncRelaseSurfaceTexture() == false) goto L66;
        if (this.mTexType != 0) goto L66;
        Handler r112 = this.mRenderHandler;
        if (r112 != null) goto L97;
        Message r113 = new Message();
        r113.what = 43;
        r113.obj = this;
        this.mTextureRenderer.handleTextureRenderMsg(r113);
        goto L66
    L97:
        Message r114 = r112.obtainMessage(43);     // Catch: Exception -> L63
        r114.obj = this;     // Catch: Exception -> L63
        this.mRenderHandler.sendMessageAtFrontOfQueue(r114);     // Catch: Exception -> L63
    L66:
        if (this.mLastComeFrameType == 0) goto L68;
        sendRenderMsg(0, false);
        this.mLastComeFrameType = 0;
    L68:
        this.mFrameCount = 0;
        this.mAccumulatedPlayingTime = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mLastFrameTime = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mFPS = 0.0f;
        this.mCurrentEffectStartTime = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mCurrentEffectProcessDepth = 0;
        HashMap<Integer, Integer> r115 = this.mPerEffectFrameCount;
        if (r115 == null) goto L71;
        r115.clear();
    L71:
        HashMap<Integer, Double> r116 = this.mPerEffectAccumulatedTime;
        if (r116 == null) goto L74;
        r116.clear();
    L74:
        HashMap<Integer, Float> r117 = this.mPerEffectAverageTime;
        if (r117 == null) goto L77;
        r117.clear();
    L77:
        this.mEffectChainStartTime = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mEffectChainAccumulatedTime = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mEffectChainFrameCount = 0;
        this.mEffectChainAverageTime = 0.0f;
        HashMap<Integer, Integer> r118 = this.mTrackingErrorCode;
        if (r118 == null) goto L80;
        r118.clear();
    L80:
        HashMap<Integer, String> r119 = this.mTrackingErrorMsg;
        if (r119 == null) goto L83;
        r119.clear();
    L83:
        releaseOther();
        this.mConfig.reset();
        this.mIgnoreSRResCheck = false;
        this.mRoiSRParamsBundle = null;
        this.mStaticMetadata = null;
        this.mFreezeDirector = 0;
        this.mOpenVQScore = 0;
        this.mVQScoreBundle = null;
        this.mEnableResetCropParamsInRender = 0;
        this.mEnableNativeWindow = 0;
        this.mNeedCheckGeome = false;
        this.mCheckGeomeCount = 0;
        this.mSharpenSuccessRate = Float.MIN_VALUE;
        this.mSharpenCostTime = Float.MIN_VALUE;
        this.mSRProcessSuccessRate = Float.MIN_VALUE;
        this.mSRProcessAverageCostTime = Float.MIN_VALUE;
        this.mEnableGlBlitToScreen = 0;
        this.mSkipFiliterCallGlClear = 0;
        this.mSkipFilterCallGlFinish = 0;
        this.mBeginSRThreshold = 0;
        resetFlag();
        if (r111 != null) goto L86;
    L92:
        this.mFrameCountReceived = 0;
        this.mSaveFrameCount = 0;
        this.mFirstFrameRendered = false;
        this.mReleaseOffScreenSurfaceFinish = true;
        TextureRenderLog.i(this.mTexType, this.TAG, "release offscreen surface done = " + this.mIdleTimeStamp);
        return;
    L86:
        if (r111.isAsyncRelaseSurfaceTexture() == false) goto L92;
        if (this.mTexType != 0) goto L92;
        IVsyncHelper r120 = this.mVsyncHelper;
        if (r120 == null) goto L92;
        r120.removeObserver(this);
        this.mVsyncHelper.setEnable(false);
        this.mVsyncHelper = null;
        goto L92
    L99:
        Message r121 = r109.obtainMessage(40);     // Catch: Exception -> L51
        r121.obj = this;     // Catch: Exception -> L51
        this.mRenderHandler.sendMessageAtFrontOfQueue(r121);     // Catch: Exception -> L51
        goto L53
    L44:
        if (this.mMainRenderCropParamsBundle == null) goto L53;
    L94:
        th = move-exception;
        throw th;
    L27:
        if (this.mLastComeFrameType == 4) goto L30;
        this.mState = 3;
        goto L35
    L13:
        updateSurface(null);
        releaseAllExtraSurface_l();
        goto L15
    }

    public void resetSurface(Surface r100) {
        TextureRenderLog.i(this.mTexType, this.TAG, "resetSurface = " + r100);
        if (r100 != null) goto L5;
        return;
    L5:
        Handler r101 = this.mRenderHandler;
        if (r101 == null) goto L8;
        Message r102 = r101.obtainMessage(44);
        r102.arg1 = 2;
        Bundle r103 = new Bundle();
        r103.putSerializable(KEY_TEXTURE, this);
        r103.putParcelable("surface", r100);
        r102.setData(r103);
        this.mRenderHandler.sendMessageAtFrontOfQueue(r102);
    L8:
        TextureRenderLog.i(this.mTexType, this.TAG, "resetSurface end");
    }

    public synchronized void setEffect(Bundle r110) {
        monitor-enter(this);
        if (r110 != null) goto L123;
        monitor-exit(this);
        return;
    L123:
        TextureRenderLog.i(this.mTexType, this.TAG, "setEffect bundle:" + getBundleString(r110, "setEffect"));     // Catch: Throwable -> L116
        int r100 = r110.getInt("action");     // Catch: Throwable -> L116
        int r101 = r110.getInt("effect_type");     // Catch: Throwable -> L116
        boolean r102 = false;
        if (r100 != 0) goto L10;
        if (r101 == 1) goto L61;
    L67:
        if (r102 == false) goto L75;
        Handler r103 = this.mRenderHandler;     // Catch: Throwable -> L116
        if (r103 != null) goto L121;
        Message r104 = new Message();     // Catch: Throwable -> L116
        r104.what = 36;     // Catch: Throwable -> L116
        r104.obj = this;     // Catch: Throwable -> L116
        r104.setData(r110);     // Catch: Throwable -> L116
        this.mTextureRenderer.handleTextureRenderMsg(r104);     // Catch: Throwable -> L116
        goto L75
    L121:
        Message r105 = r103.obtainMessage(36);     // Catch: Exception -> L72 Throwable -> L116
        r105.obj = this;     // Catch: Exception -> L72 Throwable -> L116
        r105.setData(r110);     // Catch: Exception -> L72 Throwable -> L116
        this.mRenderHandler.sendMessageAtFrontOfQueue(r105);     // Catch: Exception -> L72 Throwable -> L116
    L75:
        if (r100 != 21) goto L90;
        this.mSRProcessSuccessRate = 0.0f;     // Catch: Throwable -> L116
        this.mSRProcessAverageCostTime = 0.0f;     // Catch: Throwable -> L116
        if (r110.containsKey(TextureRenderKeys.KEY_IS_PROCESS_CONFIG_BUNDLE) == false) goto L81;
        Bundle r111 = r110.getBundle(TextureRenderKeys.KEY_IS_PROCESS_CONFIG_BUNDLE);     // Catch: Throwable -> L116
        this.mSRProcessParamter = r111;     // Catch: Throwable -> L116
        if (r111 == null) goto L81;
        TextureRenderLog.i(this.mTexType, this.TAG, "sr process params: " + getBundleString(this.mSRProcessParamter, "setEffect"));     // Catch: Throwable -> L116
    L81:
        if (r101 != 28) goto L84;
        this.mAesBoostParamsBundle = r110;     // Catch: Throwable -> L116
        TextureRenderLog.i(this.mTexType, this.TAG, "aes boost params: " + getBundleString(this.mAesBoostParamsBundle, "setEffect"));     // Catch: Throwable -> L116
    L84:
        if (r101 != 30) goto L87;
        this.mBrightnessBalanceParamsBundle = r110;     // Catch: Throwable -> L116
        TextureRenderLog.i(this.mTexType, this.TAG, "brightness balance params: " + getBundleString(this.mBrightnessBalanceParamsBundle, "setEffect"));     // Catch: Throwable -> L116
    L87:
        if (r101 != 5) goto L90;
        this.mSRParamsBundle = r110;     // Catch: Throwable -> L116
        TextureRenderLog.i(this.mTexType, this.TAG, "sr params: " + getBundleString(this.mSRParamsBundle, "setEffect"));     // Catch: Throwable -> L116
    L90:
        if (r100 == 21) goto L94;
        if (r100 == 28) goto L94;
        if (r100 == 35) goto L94;
    L114:
        monitor-exit(this);
        return;
    L94:
        if (r101 != 11) goto L114;
        if (this.mParamList != null) goto L99;
        this.mParamList = new CopyOnWriteArrayList();     // Catch: Throwable -> L116
    L99:
        if (this.mConfig != null) goto L101;
    L103:
        removeParamBundle(r100, r101);     // Catch: Throwable -> L116
        this.mParamList.add(new Bundle(r110));     // Catch: Throwable -> L116
        if (r100 != 21) goto L106;
        this.mMainRenderCropParamsBundle = r110;     // Catch: Throwable -> L116
        TextureRenderLog.i(this.mTexType, this.TAG, "set main render crop params: " + getBundleString(this.mMainRenderCropParamsBundle, "setEffect"));     // Catch: Throwable -> L116
    L106:
        if (r100 != 35) goto L114;
        Surface r106 = (Surface) r110.getParcelable("surface");     // Catch: Throwable -> L116
        if (r106 != null) goto L110;
    L113:
        TextureRenderLog.i(this.mTexType, this.TAG, "set extra render crop params: " + getBundleString(r110, "setEffect"));     // Catch: Throwable -> L116
        goto L114
    L110:
        if (this.mExtraRenderCropParamsBundleMap != null) goto L112;
        this.mExtraRenderCropParamsBundleMap = new ConcurrentHashMap();     // Catch: Throwable -> L116
    L112:
        this.mExtraRenderCropParamsBundleMap.put(r106, r110);     // Catch: Throwable -> L116
        goto L113
    L101:
        if (r110.containsKey(TextureRenderKeys.KEY_IS_USE_EFFECT) == false) goto L103;
        this.mConfig.setEffectOpen(r101, r110.getInt(TextureRenderKeys.KEY_IS_USE_EFFECT));     // Catch: Throwable -> L116
    L61:
        r102 = true;
        goto L67
    L10:
        if (r100 != 19) goto L12;
        setEffectOpen(r101, r110.getInt(TextureRenderKeys.KEY_IS_INT_VALUE), null);     // Catch: Throwable -> L116
        goto L67
    L12:
        if (r100 == 27) goto L63;
        if (r100 != 36) goto L15;
        this.mRoiSRParamsBundle = r110;     // Catch: Throwable -> L116
        goto L67
    L15:
        if (r100 == 134) goto L61;
        if (r100 != 147) goto L19;
        setOption(147, r110.getInt("scale_type", 0));     // Catch: Throwable -> L116
        goto L67
    L19:
        if (r100 != 152) goto L21;
        int r112 = r110.getInt(TextureRenderKeys.KEY_IS_INT_VALUE, 0);     // Catch: Throwable -> L116
        this.mOpenVQScore = r112;     // Catch: Throwable -> L116
        if (r112 != 1) goto L58;
        this.mVQScoreBundle = r110;     // Catch: Throwable -> L116
        goto L67
    L58:
        if (r112 != 0) goto L67;
        this.mVQScoreBundle = null;     // Catch: Throwable -> L116
        goto L67
    L21:
        if (r100 != 170) goto L23;
        this.mSRProcessParamter = r110.getBundle(TextureRenderKeys.KEY_IS_PROCESS_CONFIG_BUNDLE);     // Catch: Throwable -> L116
        goto L67
    L23:
        if (r100 == 177) goto L50;
        if (r100 == 191) goto L61;
        if (r100 != 142) goto L29;
        int r113 = r110.getInt(TextureRenderKeys.KEY_IS_INT_VALUE, 0);     // Catch: Throwable -> L116
        if (r113 != 1) goto L47;
        this.mFrameCallbackBundle = r110;     // Catch: Throwable -> L116
        goto L67
    L47:
        if (r113 != 0) goto L67;
        this.mFrameCallbackBundle = null;     // Catch: Throwable -> L116
        goto L67
    L29:
        if (r100 == 143) goto L43;
        switch(r100) {
            case 29: goto L42;
            case 30: goto L37;
            case 31: goto L32;
            default: goto L61;
        };     // Catch: Throwable -> L116
    L32:
        this.mIsMirrorVertical = r110.getInt(TextureRenderKeys.KEY_IS_INT_VALUE, 0);     // Catch: Throwable -> L116
        if (this.mNotKeepLastParams != 1) goto L67;
        if (this.mIsMirrorHorizontal != 1) goto L67;
        this.mIsMirrorHorizontal = 0;     // Catch: Throwable -> L116
        goto L67
    L37:
        this.mIsMirrorHorizontal = r110.getInt(TextureRenderKeys.KEY_IS_INT_VALUE, 0);     // Catch: Throwable -> L116
        if (this.mNotKeepLastParams != 1) goto L67;
        if (this.mIsMirrorVertical != 1) goto L67;
        this.mIsMirrorVertical = 0;     // Catch: Throwable -> L116
        goto L67
    L42:
        this.mRotationType = r110.getInt(TextureRenderKeys.KEY_IS_INT_VALUE, 0);     // Catch: Throwable -> L116
        goto L67
    L43:
        this.mEnableUseEglDummySurface = r110.getInt(TextureRenderKeys.KEY_IS_INT_VALUE, 0);     // Catch: Throwable -> L116
        goto L67
    L50:
        if (this.mRenderHandler == null) goto L67;
        this.mPureColorDetectorParams = new PureColorDetector.Params(r110);     // Catch: Exception -> L53 Throwable -> L116
        Message r114 = this.mRenderHandler.obtainMessage(36);     // Catch: Exception -> L53 Throwable -> L116
        r114.obj = this;     // Catch: Exception -> L53 Throwable -> L116
        r114.setData(r110);     // Catch: Exception -> L53 Throwable -> L116
        this.mRenderHandler.sendMessage(r114);     // Catch: Exception -> L53 Throwable -> L116
        goto L67
    L63:
        this.mLayoutRatio = r110.getFloat(TextureRenderKeys.KEY_IS_FLOAT_VALUE, 0.5f);     // Catch: Throwable -> L116
    L116:
        th = move-exception;
        throw th;
    }

    public void setFrameRenderChecker(RenderCheckDispatcher r100) {
        if (this.mOffScreenSurface == null) goto L6;
        this.mOffScreenSurface.setFrameRenderChecker(r100);
        return;
    }

    public int setHeadPose(Quaternion r100) {
        this.mHeadPose = r100;
        return 1;
    }

    public synchronized void setSuperResolutionMode(int r100) {
        monitor-enter(this);
        TextureRenderLog.i(this.mTexType, this.TAG, "set sr = " + r100);     // Catch: Throwable -> L7
        this.mSuperOpen = r100;     // Catch: Throwable -> L7
        setEffectOpen(5, r100, null);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unRegisterTouchListener(GestureDetector.SimpleOnGestureListener r100) {
        TouchHelper r101 = this.mTouchHelper;
        if (r101 == null) goto L6;
        r101.unregister(r100);
        return;
    }

    public synchronized void updateSurface(Surface r100) {
        monitor-enter(this);
        TextureRenderLog.i(this.mTexType, this.TAG, "update Surface = " + r100 + ", " + this.mUpdateSurface);     // Catch: Throwable -> L47
        if (r100 != this.mUpdateSurface) goto L12;
        if (r100 == null) goto L12;
        if (r100.toString().contains("SurfaceTexture") == false) goto L12;
        TextureRenderLog.i(this.mTexType, this.TAG, "prevent the same surface???");     // Catch: Throwable -> L47
        monitor-exit(this);
        return;
    L12:
        this.mLock.lock();     // Catch: Throwable -> L47
        TextureRenderManager r101 = TextureRenderManager.getManager();     // Catch: Throwable -> L47
        if (r101 != null) goto L15;
    L24:
        this.mUpdateSurface = r100;     // Catch: Throwable -> L47
        this.mLock.unlock();     // Catch: Throwable -> L47
        if (r101 != null) goto L27;
    L29:
        int r102 = 100;
    L30:
        Handler r103 = this.mRenderHandler;     // Catch: Throwable -> L47
        if (r103 == null) goto L44;
        Message r104 = r103.obtainMessage(4);     // Catch: Throwable -> L47
        this.mRenderMsgBundle.putSerializable(KEY_TEXTURE, this);     // Catch: Throwable -> L47
        r104.setData(this.mRenderMsgBundle);     // Catch: Throwable -> L47
        if (this.mSyncUpdateSurface == 1) goto L35;
        this.mRenderHandler.sendMessageAtFrontOfQueue(r104);     // Catch: Throwable -> L47
        goto L44
    L35:
        Object r105 = new Object();     // Catch: Throwable -> L47
        r104.obj = r105;     // Catch: Throwable -> L47
        monitor-enter(r105);     // Catch: Throwable -> L47
        this.mRenderHandler.sendMessageAtFrontOfQueue(r104);     // Catch: Throwable -> L41
        TextureRenderLog.i(this.mTexType, this.TAG, "update surface wait");     // Catch: Exception -> L50 Throwable -> L41
        r105.wait(r102);     // Catch: Exception -> L50 Throwable -> L41
    L39:
        monitor-exit(r105);     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;     // Catch: Throwable -> L47
    L44:
        TextureRenderLog.i(this.mTexType, this.TAG, "update Surface end");     // Catch: Throwable -> L47
        monitor-exit(this);
        return;
    L27:
        if (this.mTexType != 0) goto L29;
        r102 = r101.getUpdateSurfaceWaitTimeOut();     // Catch: Throwable -> L47
        goto L30
    L15:
        if (r101.isAsyncRelaseSurfaceTexture() == false) goto L24;
        if (this.mTexType != 0) goto L24;
        if (this.mUpdateSurface != null) goto L24;
        if (r100 != null) goto L24;
        this.mLock.unlock();     // Catch: Throwable -> L47
        monitor-exit(this);
        return;
    L47:
        th = move-exception;
        throw th;
    }

    public synchronized void updateVideoState(int r100) {
        monitor-enter(this);
        Handler r101 = this.mRenderHandler;     // Catch: Throwable -> L8
        if (r101 == null) goto L6;
        Message r102 = r101.obtainMessage(26);     // Catch: Throwable -> L8
        r102.obj = this;     // Catch: Throwable -> L8
        r102.arg1 = r100;     // Catch: Throwable -> L8
        this.mRenderHandler.sendMessage(r102);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean createEGLWindowSurface(boolean r100) {
        EGLRuntime r101 = this.mEGLRuntime;
        if (r101 != null) goto L5;
        return false;
    L5:
        EGLSurface r102 = r101.eglDummySurface;
        if (this.mEglSurface == EGL14.EGL_NO_SURFACE) goto L15;
        TextureRenderLog.i(this.mTexType, this.TAG, "destory previous surface = " + this.mEglSurface);
        if (r100 == false) goto L10;
        TextureRenderLog.i(this.mTexType, this.TAG, "make current to dummy surface");
        EGL14.eglMakeCurrent(this.mEglDisplay, r102, r102, this.mEglContext);
        this.mEGLRuntime.setDrawingObjectId(0);
    L10:
        EGL14.eglDestroySurface(this.mEglDisplay, this.mEglSurface);
        this.mEglSurface = EGL14.EGL_NO_SURFACE;
        this.mIsMakeCurrent = false;
        NativeWindow r103 = this.mNativeWindow;
        if (r103 == null) goto L13;
        r103.releaseWindow();
        this.mNativeWindow = null;
    L13:
        TextureRenderLog.i(this.mTexType, this.TAG, "destory previous surface done = " + this.mEglSurface);
    L15:
        if (this.mEnableUseEglDummySurface != 1) goto L22;
        if (r100 == false) goto L22;
        if (r102 == EGL14.EGL_NO_SURFACE) goto L22;
        if (this.mRenderSurface != null) goto L22;
        this.mEglSurface = r102;
    L23:
        TextureRenderLog.i(this.mTexType, this.TAG, "createEGLWindowSurface eglSurface = " + this.mEglSurface);
        if (this.mEglSurface != EGL14.EGL_NO_SURFACE) goto L54;
        return false;
    L54:
        makeCurrent();     // Catch: Exception -> L52
        if (this.mRenderSurface == null) goto L29;
        int r104 = getViewportWidth();     // Catch: Exception -> L52
        int r105 = getViewportHeight();     // Catch: Exception -> L52
    L31:
        if (this.mEnableNativeWindow > 0) goto L33;
    L49:
        this.mEventLogger.setSurfaceHWC(0);     // Catch: Exception -> L52
        this.mEventLogger.setSurfaceSize(getConsumerWidth(this.mEglSurface), getConsumerHeight(this.mEglSurface));     // Catch: Exception -> L52
    L50:
        this.mUpdateSurfaceTime = System.nanoTime();
        return true;
    L33:
        if (this.mRenderSurface == null) goto L49;
        NativeWindow r106 = this.mNativeWindow;     // Catch: Exception -> L52
        if (r106 == null) goto L37;
        r106.releaseWindow();     // Catch: Exception -> L52
    L37:
        this.mNativeWindow = new NativeWindow(this.mTexType, this.mRenderSurface);     // Catch: Exception -> L52
        VideoSurface r107 = this.mOffScreenSurface;     // Catch: Exception -> L52
        if (r107 == null) goto L40;
        int r108 = r107.mSurfaceWidth;     // Catch: Exception -> L52
        int r109 = r107.mSurfaceHeight;     // Catch: Exception -> L52
    L42:
        if (this.mFrameCountReceived > 0) goto L46;
        if (r108 <= 0) goto L46;
        if (r109 <= 0) goto L46;
        r105 = r109;
        r104 = r108;
    L46:
        if (r104 <= 0) goto L50;
        if (r105 <= 0) goto L50;
        this.mNativeWindow.setBuffersGeometry(r104, r105, 1);     // Catch: Exception -> L52
        this.mEventLogger.setSurfaceHWC(1);     // Catch: Exception -> L52
        this.mEventLogger.setSurfaceSize(r104, r105);     // Catch: Exception -> L52
        goto L50
    L40:
        r109 = 0;
        r108 = 0;
        goto L42
    L29:
        r104 = 0;
        r105 = 0;
    L52:
        TextureRenderLog.e(this.mTexType, this.TAG, "makeCurrent exception failed");
        return false;
    L22:
        this.mEglSurface = createEGLWindowSurface(this.mRenderSurface);
        goto L23
    }

    public Object getOption(Bundle r100) {
        TextureRenderer r101 = this.mTextureRenderer;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getOption(r100);
    }

    public void registerTouchListener(ScaleGestureDetector.OnScaleGestureListener r100) {
        if (this.mTouchHelper != null) goto L5;
        this.mTouchHelper = new TouchHelper(TextureRenderManager.getManager().getContext());
    L5:
        this.mTouchHelper.register(r100);
    }

    public void unRegisterTouchListener(ScaleGestureDetector.OnScaleGestureListener r100) {
        TouchHelper r101 = this.mTouchHelper;
        if (r101 == null) goto L6;
        r101.unregister(r100);
        return;
    }

    private String getBundleString(Bundle r100, String r101) {
        return r100.toString();
    L4:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.TAG, r101 + e.toString());
        return "bundle modified";
    }

    private void removeParamBundle(int r100, int r101) {
        Iterator<Bundle> r102 = this.mParamList.iterator();
    L4:
        if (r102.hasNext() == false) goto L17;
        Bundle r103 = r102.next();
        if (r103.getInt("action") != r100) goto L4;
        if (r103.getInt("effect_type") != r101) goto L4;
        this.mParamList.remove(r103);
        return;
    }

    public boolean eglSwapBuffer(EGLSurface r100, boolean r101) {
        int r102 = getViewportHeight();
        int r103 = getViewportWidth();
        if (EGL14.eglSwapBuffers(this.mEglDisplay, r100) == true) goto L11;
        int r104 = EGL14.eglGetError();
        if (r104 != 12301) goto L8;
        if (r101 == false) goto L8;
        createEGLWindowSurface(true);
    L8:
        notifyError(r104, 0, "");
        TextureRenderLog.e(this.mTexType, this.TAG, "swap buffer failed:" + GLUtils.getEGLErrorString(r104));
        return false;
    L11:
        if (this.mRenderWhenSizeChange > 0) goto L13;
    L19:
        return true;
    L13:
        if (this.mLayoutMode == 1) goto L19;
        if (r103 == getViewportWidth()) goto L17;
    L18:
        TextureRenderLog.e(this.mTexType, this.TAG, "re render size change after eglSwapBuffer");
        sendRenderMsg(1, false);
        goto L19
    L17:
        if (r102 == getViewportHeight()) goto L19;
        goto L18
    }

    public Bundle getCropParamsBundle(boolean r100, Surface r101) {
        if (r100 == false) goto L4;
        ConcurrentHashMap<Surface, Bundle> r102 = this.mExtraRenderCropParamsBundleMap;
        if (r102 == null) goto L10;
        if (r101 != null) goto L9;
        return null;
    L9:
        return r102.get(r101);
    L10:
        return null;
    L4:
        return this.mMainRenderCropParamsBundle;
    }

    public float getFloatOption(int r100, int r101) {
        if (r100 == 120) goto L45;
        if (r100 == 131) goto L43;
        if (r100 == 132) goto L41;
        if (r100 == 154) goto L39;
        if (r100 == 155) goto L37;
        if (r100 == 172) goto L35;
        if (r100 == 173) goto L33;
        switch(r100) {
            case 122: goto L31;
            case 123: goto L28;
            case 124: goto L21;
            case 125: goto L20;
            default: goto L18;
        };
    L18:
        return 0.0f;
    L21:
        HashMap<Integer, Float> r102 = this.mPerEffectAverageTime;
        if (r102 == null) goto L27;
        Float r103 = r102.get(Integer.valueOf(r101));
        if (r103 == null) goto L27;
        return r103.floatValue();
    L27:
        return 0.0f;
    L28:
        double r104 = this.mLastFrameTime;
    L30:
        return (float) r104;
    L31:
        r104 = this.mAccumulatedPlayingTime;
        goto L30
    L20:
        return this.mEffectChainAverageTime;
    L33:
        return this.mSharpenCostTime;
    L35:
        return this.mSharpenSuccessRate;
    L37:
        return this.mVQScoreProcessAverageCostTime;
    L39:
        return this.mVQScoreProcessSuccessRate;
    L41:
        return this.mSRProcessAverageCostTime;
    L43:
        return this.mSRProcessSuccessRate;
    L45:
        return this.mFPS;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LinkedList<FrameMetaData> getFrameMetaData(long r100, long r101) {
        LinkedList<FrameMetaData> r102 = new LinkedList();
        if (this.mFrameMetaData == null) goto L23;
        int r103 = 0;
        int r104 = 0;
    L6:
        if (r104 >= this.mFrameMetaData.size()) goto L12;
        if (Math.abs(((FrameMetaData) ListProtector.get(this.mFrameMetaData, r104)).getReleaseNanoTime() - r100) > r101) goto L10;
        r102.addLast(ListProtector.get(this.mFrameMetaData, r104));
    L10:
        r104 = r104 + 1;
        goto L6
    L12:
        if (this.mFrameMetaData.size() <= 10) goto L20;
    L14:
        if (r103 >= this.mFrameMetaData.size()) goto L20;
        if (Math.abs(((FrameMetaData) ListProtector.get(this.mFrameMetaData, r103)).getReleaseNanoTime() - r100) > r101) goto L17;
        r103 = r103 + 1;
        goto L14
    L17:
        TextureRenderLog.i(this.mTexType, this.TAG, "FrameMetaData size large than 10, remove: " + r103);
        ListProtector.remove(this.mFrameMetaData, r103);
    L20:
        if (r102.isEmpty() == false) goto L22;
        TextureRenderLog.i(this.mTexType, this.TAG, "getFrameMetaData failed for cached metadate out of sync releaseNanoTime " + r100);
    L22:
        return r102;
    L23:
        return null;
    }

    public int getIntOption(int r100, int r101) {
        switch(r100) {
            case 6: goto L67;
            case 8: goto L65;
            case 10: goto L58;
            case 15: goto L67;
            case 16: goto L57;
            case 18: goto L50;
            case 19: goto L67;
            case 23: goto L44;
            case 37: goto L38;
            case 39: goto L37;
            case 40: goto L35;
            case 41: goto L33;
            case 42: goto L67;
            case 126: goto L25;
            case 135: goto L24;
            case 137: goto L22;
            case 163: goto L20;
            case 169: goto L18;
            case 185: goto L16;
            case 186: goto L14;
            case 201: goto L12;
            case 203: goto L5;
            default: goto L4;
        };
    L4:
        return -1;
    L5:
        EGLRuntime r102 = this.mEGLRuntime;
        if (r102 != null) goto L8;
        return 0;
    L8:
        if (r102.isSupportBt2020PQ() <= 0) goto L77;
        return 1;
    L77:
        return 0;
    L25:
        HashMap<Integer, Integer> r103 = this.mTrackingErrorCode;
        if (r103 == null) goto L31;
        Integer r104 = r103.get(Integer.valueOf(r101));
        if (r104 == null) goto L31;
        return r104.intValue();
    L31:
        return -1;
    L38:
        EGLRuntime r105 = this.mEGLRuntime;
        if (r105 != null) goto L41;
        return 0;
    L41:
        if (r105.getGLMajorVersion() < 3) goto L79;
        return 1;
    L79:
        return 0;
    L44:
        TextureRenderer r106 = this.mTextureRenderer;
        if (r106 != null) goto L47;
        return 0;
    L47:
        if (r106.getEffectConfig().getEffectOpen(r101) == false) goto L81;
        return 1;
    L81:
        return 0;
    L50:
        TextureRenderer r107 = this.mTextureRenderer;
        if (r107 != null) goto L53;
        return 0;
    L53:
        if (r107.getEffectConfig().isOpenSharpen() == false) goto L83;
        return 1;
    L83:
        return 0;
    L58:
        TextureRenderer r108 = this.mTextureRenderer;
        if (r108 != null) goto L61;
        return 0;
    L61:
        if (r108.getEffectConfig().isOpenSR() == false) goto L85;
        return 1;
    L85:
        return 0;
    L12:
        return this.mExtraSurfaceMakeCurrent;
    L14:
        return this.mViewportHeight;
    L16:
        return this.mViewportWidth;
    L18:
        return this.mDataSpace;
    L20:
        return this.mConfig.getEffectOpen(21) ? 1 : 0;
    L22:
        return this.mFreezeDirector;
    L24:
        return this.mHeadposeCallbackIntegral;
    L33:
        return this.mIsUsingNewTTPlayerView;
    L35:
        return this.mUsingSharpenDirectDraw ? 1 : 0;
    L37:
        return this.mUsingSRDirectDraw ? 1 : 0;
    L57:
        return this.mConfig.getEffectOpen(1) ? 1 : 0;
    L65:
        return this.mHDRType;
    L67:
        if (r100 != 6) goto L70;
        r101 = 5;
    L72:
        Integer r109 = this.mUsingEffect.get(Integer.valueOf(r101));
        if (r109 != null) goto L75;
        return 0;
    L75:
        return r109.intValue();
    L70:
        if (r100 != 15) goto L72;
        r101 = 1;
        goto L72
    }

    public long getLongOption(int r100, int r101) {
        if (r100 == 162) goto L7;
        return -1;
    L7:
        return getTimestamp();
    }

    public String getStringOption(int r100, int r101) {
        if (r100 == 127) goto L5;
        return "";
    L5:
        HashMap<Integer, String> r102 = this.mTrackingErrorMsg;
        if (r102 == null) goto L10;
        String r103 = r102.get(Integer.valueOf(r101));
        if (r103 == null) goto L10;
        return r103;
    L10:
        return "";
    }

    public void onFrameAvailable(boolean r100, int r101) {
        this.mLastComeFrameType = r101;
        this.mFrameReady = true;
        this.mFrameCountReceived++;
        if (r100 == false) goto L11;
        IVsyncHelper r102 = this.mVsyncHelper;
        if (r102 != null) goto L7;
    L10:
        sendRenderMsg(1, false);
        return;
    L7:
        if (r102.isWorking() == false) goto L10;
        if (this.mConfig.getEffectOpen(8) == false) goto L10;
        return;
    L11:
        sendRenderMsg(0, false);
    }

    public synchronized void pause(boolean r100, boolean r101) {
        monitor-enter(this);
        if (r101 == false) goto L13;
        if (r100 == true) goto L13;
    L16:
        th = move-exception;
        throw th;
    L7:
        if (this.mRenderHandler == null) goto L13;
        if (this.mIsPaused == false) goto L11;
    L12:
        TextureRenderLog.i(this.mTexType, this.TAG, "need active , post a resume msg");     // Catch: Throwable -> L16
        Message r102 = this.mRenderHandler.obtainMessage(10);     // Catch: Throwable -> L16
        r102.obj = this;     // Catch: Throwable -> L16
        this.mIsPreRender = false;     // Catch: Throwable -> L16
        this.mRenderHandler.sendMessageAtFrontOfQueue(r102);     // Catch: Throwable -> L16
        goto L13
    L11:
        if (this.mIsPreRender == true) goto L12;
    L13:
        this.mIsPaused = r100;     // Catch: Throwable -> L16
        TextureRenderLog.i(this.mTexType, this.TAG, "paused = " + this.mIsPaused);     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    public Bitmap saveFrame(Bundle r100, VideoSurface.SaveFrameCallback r101) {
        Handler r102 = this.mRenderHandler;
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r101 == null) goto L21;
        Bundle r103 = this.mSaveFrameBundle;
        monitor-enter(r103);
    L18:
        th = move-exception;
        throw th;
    L10:
        if (this.mSaveFrameBundle.isEmpty() == true) goto L12;
        this.mSaveFrameBundle.clear();     // Catch: Throwable -> L18
    L12:
        this.mSaveFrameBundle.putAll(r100);     // Catch: Throwable -> L18
        this.mSaveFrameBundle.putSerializable("callback", r101);     // Catch: Throwable -> L18
        monitor-exit(r103);     // Catch: Throwable -> L18
        if (this.mState == 1) goto L17;
        sendRenderMsg(1, false);
        this.mSaveFrameCount++;
    L17:
        return null;
    L21:
        Message r104 = r102.obtainMessage(14);
        this.mRenderMsgBundle.putSerializable(KEY_TEXTURE, this);
        r104.setData(this.mRenderMsgBundle);
        Message r105 = new Message();
        r104.obj = r105;
        monitor-enter(r105);     // Catch: InterruptedException -> L35
        this.mRenderHandler.sendMessageAtFrontOfQueue(r104);     // Catch: Throwable -> L32
        r105.wait(500);     // Catch: Throwable -> L32
        this.mSaveFrameCount++;     // Catch: Throwable -> L32
        monitor-exit(r105);     // Catch: Throwable -> L32
    L26:
        if (r105.obj == null) goto L28;
    L30:
        TextureRenderLog.i(this.mTexType, this.TAG, "save frame done = " + r105.obj);
        return (Bitmap) r105.obj;
    L28:
        if (this.mRenderHandler.hasMessages(14) == false) goto L30;
        TextureRenderLog.i(this.mTexType, this.TAG, "render thread is busy");
    L32:
        th = move-exception;
        throw th;     // Catch: InterruptedException -> L35
    L35:
        return null;
    }

    public void sendRenderMsg(int r100, boolean r110) {
        if (this.mLastComeFrameType != 3) goto L5;
        return;
    L5:
        if (this.mLastComeFrameType == 4) goto L34;
        Handler r101 = this.mRenderHandler;
        if (r101 != null) goto L31;
        return;
    L31:
        Message r102 = r101.obtainMessage(2);     // Catch: Exception -> L26
        r102.obj = this;     // Catch: Exception -> L26
        r102.arg1 = r100;     // Catch: Exception -> L26
        if (r110 == false) goto L13;
        int r103 = 1;
    L14:
        r102.arg2 = r103;     // Catch: Exception -> L26
        if (this.mSaveFrameBundle.isEmpty() == true) goto L24;
        Bundle r104 = this.mSaveFrameBundle;     // Catch: Exception -> L26
        monitor-enter(r104);     // Catch: Exception -> L26
        r102.setData(this.mSaveFrameBundle);     // Catch: Throwable -> L21
        this.mSaveFrameBundle = new Bundle();     // Catch: Throwable -> L21
        monitor-exit(r104);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;     // Catch: Exception -> L26
    L24:
        sendMsg(r102, false, r110, 100);     // Catch: Exception -> L26
        return;
    L13:
        r103 = 0;
    L26:
        e = move-exception;
        TextureRenderLog.i(this.mTexType, this.TAG, e.toString());
        return;
    }

    public void sendSetOptionMsg(int r100, int r101) {
        Handler r102 = this.mRenderHandler;
        if (r102 != null) goto L18;
        return;
    L18:
        Message r103 = r102.obtainMessage(34);     // Catch: Exception -> L16
        r103.obj = this;     // Catch: Exception -> L16
        r103.arg1 = r100;     // Catch: Exception -> L16
        r103.arg2 = r101;     // Catch: Exception -> L16
        if (r100 != 128) goto L9;
    L14:
        this.mRenderHandler.sendMessageAtFrontOfQueue(r103);     // Catch: Exception -> L16
    L17:
        return;
    L9:
        if (r100 == 139) goto L14;
        if (r100 == 129) goto L14;
        r103.sendToTarget();     // Catch: Exception -> L16
    }

    public synchronized void setExtraSurface(Surface r100, int r101) {
        monitor-enter(this);
        TextureRenderLog.i(this.mTexType, this.TAG, "setExtraSurface = " + r100 + ", opera:" + r101);     // Catch: Throwable -> L10
        Handler r102 = this.mRenderHandler;     // Catch: Throwable -> L10
        if (r102 == null) goto L7;
        Message r103 = r102.obtainMessage(25);     // Catch: Throwable -> L10
        r103.arg1 = r101;     // Catch: Throwable -> L10
        Bundle r104 = new Bundle();     // Catch: Throwable -> L10
        r104.putSerializable(KEY_TEXTURE, this);     // Catch: Throwable -> L10
        r104.putParcelable("surface", r100);     // Catch: Throwable -> L10
        r103.setData(r104);     // Catch: Throwable -> L10
        this.mRenderHandler.sendMessage(r103);     // Catch: Throwable -> L10
    L7:
        TextureRenderLog.i(this.mTexType, this.TAG, "setExtraSurface end");     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized void setOption(int r210, int r211) {
        monitor-enter(this);
        if (r210 == 2) goto L182;
        if (r210 != 3) goto L9;
        TextureRenderLog.i(this.mTexType, this.TAG, "set TEXTURE_OPTION_SET_OVERLAY_SYNC");     // Catch: Throwable -> L179
        Handler r100 = this.mRenderHandler;     // Catch: Throwable -> L179
        if (r100 == null) goto L193;
        Message r101 = r100.obtainMessage(31);     // Catch: Throwable -> L179
        r101.obj = this;     // Catch: Throwable -> L179
        r101.arg1 = r211;     // Catch: Throwable -> L179
        r101.sendToTarget();     // Catch: Throwable -> L179
    L193:
        boolean r110 = false;
    L194:
        if (r110 == false) goto L196;
        sendSetOptionMsg(r210, r211);     // Catch: Throwable -> L179
    L196:
        monitor-exit(this);
        return;
    L9:
        if (r210 != 5) goto L11;
        this.mTexType = r211;     // Catch: Throwable -> L179
        this.mConfig.setTexType(r211);     // Catch: Throwable -> L179
        goto L193
    L11:
        if (r210 != 6) goto L13;
        Integer r102 = this.mUsingEffect.get(5);     // Catch: Throwable -> L179
        if (r102 == null) goto L169;
        int r103 = r102.intValue();     // Catch: Throwable -> L179
    L170:
        this.mUsingEffect.put(5, Integer.valueOf(r211));     // Catch: Throwable -> L179
        VideoSurface r104 = this.mOffScreenSurface;     // Catch: Throwable -> L179
        if (r104 == null) goto L193;
        if (r103 == r211) goto L193;
        r104.onSRStateChange(r211, this.mFrameCountReceived);     // Catch: Throwable -> L179
        goto L193
    L169:
        r103 = 0;
        goto L170
    L13:
        if (r210 != 8) goto L15;
        this.mHDRType = r211;     // Catch: Throwable -> L179
        _tryUpdateEGLSurface(7);     // Catch: Throwable -> L179
        _trySetupHDR2SDRFilter(r211);     // Catch: Throwable -> L179
        goto L193
    L15:
        if (r210 != 9) goto L17;
        this.mSyncUpdateSurface = r211;     // Catch: Throwable -> L179
        goto L193
    L17:
        if (r210 != 15) goto L19;
        this.mUsingEffect.put(1, Integer.valueOf(r211));     // Catch: Throwable -> L179
        goto L193
    L19:
        if (r210 != 16) goto L21;
        setEffectOpen(1, r211, null);     // Catch: Throwable -> L179
        goto L193
    L21:
        if (r210 != 25) goto L23;
        int r105 = 0;
    L160:
        if (r105 >= r211) goto L193;
        sendRenderMsg(1, false);     // Catch: Throwable -> L179
        r105 = r105 + 1;     // Catch: Throwable -> L179
        goto L160
    L23:
        if (r210 != 26) goto L25;
        this.mLayoutMode = r211;     // Catch: Throwable -> L179
        goto L193
    L25:
        if (r210 != 106) goto L27;
        IVsyncHelper r106 = this.mVsyncHelper;     // Catch: Throwable -> L179
        if (r106 != null) goto L154;
    L35:
        r110 = true;
        goto L194
    L154:
        if (r211 != 1) goto L156;
        r106.removeObserver(this);     // Catch: Throwable -> L179
        goto L35
    L156:
        r106.addObserver(this);     // Catch: Throwable -> L179
        goto L35
    L27:
        if (r210 != 107) goto L29;
        IVsyncHelper r107 = this.mVsyncHelper;     // Catch: Throwable -> L179
        if (r107 == null) goto L150;
        r107.update();     // Catch: Throwable -> L179
        goto L193
    L150:
        TextureRenderLog.d(this.mTexType, this.TAG, "vsyncHelper is null");     // Catch: Throwable -> L179
        goto L193
    L29:
        if (r210 != 116) goto L31;
        this.mForbidReuseVideoSurfaceTexture = r211;     // Catch: Throwable -> L179
        goto L193
    L31:
        if (r210 == 117) goto L142;
        switch(r210) {
            case 29: goto L141;
            case 30: goto L140;
            case 31: goto L139;
            default: goto L33;
        };
    L33:
        switch(r210) {
            case 39: goto L135;
            case 40: goto L130;
            case 41: goto L128;
            case 42: goto L110;
            case 110: goto L108;
            case 121: goto L107;
            case 130: goto L106;
            case 135: goto L105;
            case 137: goto L104;
            case 141: goto L103;
            case 149: goto L100;
            case 150: goto L97;
            case 151: goto L91;
            case 152: goto L87;
            case 169: goto L84;
            case 171: goto L81;
            case 176: goto L78;
            case 178: goto L75;
            case 179: goto L72;
            case 181: goto L69;
            case 182: goto L66;
            case 183: goto L63;
            case 187: goto L56;
            case 189: goto L53;
            case 200: goto L50;
            case 202: goto L47;
            default: goto L34;
        };
    L34:
        switch(r210) {
            case 144: goto L46;
            case 145: goto L38;
            case 146: goto L37;
            case 147: goto L36;
            default: goto L35;
        };
    L36:
        this.mSRProcessScaleType = r211;     // Catch: Throwable -> L179
        TextureRenderLog.i(this.mTexType, this.TAG, "set process scale type " + this.mSRProcessScaleType);     // Catch: Throwable -> L179
        goto L193
    L37:
        this.mDoMirrorFirst = r211;     // Catch: Throwable -> L179
        goto L193
    L38:
        TextureRenderLog.i(this.mTexType, this.TAG, " set TEXTURE_OPTION_INT_RESET_ROTATION_MIRROR_PARAMS: " + r211);     // Catch: Throwable -> L179
        Handler r108 = this.mRenderHandler;     // Catch: Throwable -> L179
        if (r108 == null) goto L193;
        if (r211 != 1) goto L193;
        Message r109 = r108.obtainMessage(42);     // Catch: Exception -> L200 Throwable -> L179
        r109.obj = this;     // Catch: Exception -> L200 Throwable -> L179
        this.mRenderHandler.sendMessage(r109);     // Catch: Exception -> L200 Throwable -> L179
    L45:
        this.mRotationType = 0;     // Catch: Throwable -> L179
        this.mIsMirrorHorizontal = 0;     // Catch: Throwable -> L179
        this.mIsMirrorVertical = 0;     // Catch: Throwable -> L179
        this.mLayoutMode = 1;     // Catch: Throwable -> L179
        this.mFrameCallbackBundle = null;     // Catch: Throwable -> L179
        goto L193
    L46:
        this.mNotKeepLastParams = r211;     // Catch: Throwable -> L179
        goto L193
    L47:
        TextureRenderLog.d(this.mTexType, this.TAG, "TEXTURE_OPTION_INT_NEED_CHECK_MAKE_CURRENT:" + r211);     // Catch: Throwable -> L179
        this.mNeedCheckMakeCurrent = r211;     // Catch: Throwable -> L179
        monitor-exit(this);
        return;
    L50:
        this.mRenderWhenSizeChange = r211;     // Catch: Throwable -> L179
        monitor-exit(this);
        return;
    L53:
        TextureRenderLog.d(this.mTexType, this.TAG, "TEXTURE_OPTION_INT_HARDWARE_BUFFER_RENDER_DIRECTLY:" + r211);     // Catch: Throwable -> L179
        this.mHardwareBufferRenderDirectly = r211;     // Catch: Throwable -> L179
        monitor-exit(this);
        return;
    L56:
        TextureRenderLog.d(this.mTexType, this.TAG, "TEXTURE_OPTION_INT_ENABLE_TRACK_EVENTS:" + r211);     // Catch: Throwable -> L179
        TextureRenderEventLogger r111 = this.mEventLogger;     // Catch: Throwable -> L179
        if (r211 != 1) goto L59;
        boolean r112 = true;
    L60:
        r111.setEnable(r112);     // Catch: Throwable -> L179
        monitor-exit(this);
        return;
    L59:
        r112 = false;
        goto L60
    L63:
        TextureRenderLog.d(this.mTexType, this.TAG, "TEXTURE_OPTION_INT_GL_BLIIT_SKIP_CALL_GLFINISH:" + r211);     // Catch: Throwable -> L179
        this.mGlBlitSkipGLFinish = r211;     // Catch: Throwable -> L179
        monitor-exit(this);
        return;
    L66:
        TextureRenderLog.d(this.mTexType, this.TAG, "TEXTURE_OPTION_INT_ENABLE_GLBLIT_SCREEN_HARDWAREBUFFER:" + r211);     // Catch: Throwable -> L179
        this.mEnableGlBlitToSceenForHardWareBuffer = r211;     // Catch: Throwable -> L179
        monitor-exit(this);
        return;
    L69:
        TextureRenderLog.d(this.mTexType, this.TAG, "TEXTURE_OPTION_INT_BEGINE_SR_THRESHOLD:" + r211);     // Catch: Throwable -> L179
        this.mBeginSRThreshold = r211;     // Catch: Throwable -> L179
        monitor-exit(this);
        return;
    L72:
        TextureRenderLog.d(this.mTexType, this.TAG, "TEXTURE_OPTION_INT_SKIP_CALL_GLCLEAR:" + r211);     // Catch: Throwable -> L179
        this.mSkipFiliterCallGlClear = r211;     // Catch: Throwable -> L179
        monitor-exit(this);
        return;
    L75:
        TextureRenderLog.d(this.mTexType, this.TAG, "TEXTURE_OPTION_INT_SKIP_CALL_GLFINISH:" + r211);     // Catch: Throwable -> L179
        this.mSkipFilterCallGlFinish = r211;     // Catch: Throwable -> L179
        monitor-exit(this);
        return;
    L78:
        TextureRenderLog.d(this.mTexType, this.TAG, "TEXTURE_OPTION_INT_ENABLE_GLBLIT:" + r211);     // Catch: Throwable -> L179
        this.mEnableGlBlitToScreen = r211;     // Catch: Throwable -> L179
        monitor-exit(this);
        return;
    L81:
        TextureRenderLog.d(this.mTexType, this.TAG, "TEXTURE_OPTION_INT_RESET_CROP_PARAMS:" + r211);     // Catch: Throwable -> L179
        this.mEnableResetCropParamsInRender = r211;     // Catch: Throwable -> L179
        monitor-exit(this);
        return;
    L84:
        TextureRenderLog.d(this.mTexType, this.TAG, "TEXTURE_OPTION_INT_DATASPACE:" + r211);     // Catch: Throwable -> L179
        this.mDataSpace = r211;     // Catch: Throwable -> L179
        monitor-exit(this);
        return;
    L87:
        this.mOpenVQScore = r211;     // Catch: Throwable -> L179
        monitor-exit(this);
        return;
    L97:
        this.mEnableNativeWindow = r211;     // Catch: Throwable -> L179
        monitor-exit(this);
        return;
    L100:
        this.mFrameCallbackInRenderThread = r211;     // Catch: Throwable -> L179
        monitor-exit(this);
        return;
    L103:
        this.mEnableExtraSurfaceRenderCallback = r211;     // Catch: Throwable -> L179
        goto L193
    L104:
        this.mFreezeDirector = r211;     // Catch: Throwable -> L179
        goto L35
    L105:
        this.mHeadposeCallbackIntegral = r211;     // Catch: Throwable -> L179
        goto L193
    L106:
        this.mBitDepth = r211;     // Catch: Throwable -> L179
        goto L193
    L107:
        this.mFrameCount = r211;     // Catch: Throwable -> L179
        goto L193
    L108:
        this.mSyncSetVsync = r211;     // Catch: Throwable -> L179
        goto L193
    L128:
        this.mIsUsingNewTTPlayerView = r211;     // Catch: Throwable -> L179
        goto L193
    L91:
        if (this.mRenderHandler != null) goto L93;
    L95:
        monitor-exit(this);
        return;
    L93:
        if (r211 != (-1)) goto L95;
        Bundle r113 = new Bundle();     // Catch: Exception -> L201 Throwable -> L179
        r113.putInt("action", 151);     // Catch: Exception -> L201 Throwable -> L179
        Message r114 = this.mRenderHandler.obtainMessage(36);     // Catch: Exception -> L201 Throwable -> L179
        r114.obj = this;     // Catch: Exception -> L201 Throwable -> L179
        r114.setData(r113);     // Catch: Exception -> L201 Throwable -> L179
        this.mRenderHandler.sendMessage(r114);     // Catch: Exception -> L201 Throwable -> L179
        goto L95
    L110:
        if (r211 != 1) goto L116;
        if (this.mHDRType == 1) goto L114;
        TextureRenderLog.i(this.mTexType, this.TAG, "sdr2hdr drType switch into PQ");     // Catch: Throwable -> L179
        this.mHDRType = 1;     // Catch: Throwable -> L179
        _tryUpdateEGLSurface(7);     // Catch: Throwable -> L179
    L118:
        boolean r115 = true;
    L121:
        if (r115 == false) goto L127;
        HashMap<Surface, EGLSurface> r116 = this.mExtraSurfaceMap;     // Catch: Throwable -> L179
        if (r116 == null) goto L127;
        if (r116.isEmpty() == true) goto L127;
        setExtraSurface(null, 4);     // Catch: Throwable -> L179
    L127:
        setEffectOpen(31, r211, null);     // Catch: Throwable -> L179
        setOption(19, 31, r211);     // Catch: Throwable -> L179
        goto L193
    L114:
        TextureRenderLog.d(this.mTexType, this.TAG, "sdr2hdr already in PQ");     // Catch: Throwable -> L179
    L120:
        r115 = false;
        goto L121
    L116:
        if (this.mHDRType == 0) goto L119;
        TextureRenderLog.i(this.mTexType, this.TAG, "sdr2hdr drType switch into default");     // Catch: Throwable -> L179
        this.mHDRType = 0;     // Catch: Throwable -> L179
        _tryUpdateEGLSurface(7);     // Catch: Throwable -> L179
        goto L118
    L119:
        TextureRenderLog.d(this.mTexType, this.TAG, "sdr2hdr already in default");     // Catch: Throwable -> L179
        goto L120
    L130:
        if (r211 != 1) goto L132;
        boolean r117 = true;
    L133:
        this.mUsingSharpenDirectDraw = r117;     // Catch: Throwable -> L179
        goto L193
    L132:
        r117 = false;
        goto L133
    L135:
        if (r211 != 1) goto L137;
        boolean r118 = true;
    L138:
        this.mUsingSRDirectDraw = r118;     // Catch: Throwable -> L179
        goto L193
    L137:
        r118 = false;
        goto L138
    L139:
        this.mIsMirrorVertical = r211;     // Catch: Throwable -> L179
        goto L193
    L140:
        this.mIsMirrorHorizontal = r211;     // Catch: Throwable -> L179
        goto L193
    L141:
        this.mRotationType = r211;     // Catch: Throwable -> L179
        goto L193
    L142:
        TextureRenderLog.i(this.mTexType, this.TAG, "set TEXTURE_OPTION_INT_FORBID_REUSE_TEXTURE: " + r211);     // Catch: Throwable -> L179
        lock();     // Catch: Throwable -> L179
        ITexture r119 = this.mTextureId;     // Catch: Throwable -> L179
        if (r119 == null) goto L145;
        ((Texture) r119).setForbidTextureReuse(r211);     // Catch: Throwable -> L179
    L145:
        unlock();     // Catch: Throwable -> L179
        goto L193
    L182:
        if (r211 == 1) goto L185;
        monitor-exit(this);
        return;
    L185:
        Handler r120 = this.mRenderHandler;     // Catch: Throwable -> L179
        if (r120 != null) goto L207;
        monitor-exit(this);
        return;
    L207:
        Message r121 = r120.obtainMessage(33);     // Catch: Throwable -> L179 Exception -> L192
        r121.obj = this;     // Catch: Throwable -> L179 Exception -> L192
        this.mRenderHandler.sendMessageAtFrontOfQueue(r121);     // Catch: Throwable -> L179 Exception -> L192
    L179:
        th = move-exception;
        throw th;
    }

    public boolean supportProcessResolution(int r100, int r101) {
        if (this.mIgnoreSRResCheck == false) goto L5;
        return true;
    L5:
        int r102 = 0;
    L6:
        int[] r103 = resWdithTab;
        if (r102 >= r103.length) goto L14;
        if (r103[r102] != r100) goto L13;
        if (resHeightTab[r102] != r101) goto L13;
        return true;
    L13:
        r102 = r102 + 1;
        goto L6
    L14:
        TextureRenderLog.e(this.mTexType, this.TAG, "sr not support resolution width:" + r100 + ",height:" + r101);
        return false;
    }

    public int updateHardwareBuffer(HardwareBuffer r100, int[] r101) {
        Object r102 = this.mHardwareBufferObject;
        monitor-enter(r102);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (this.mState != 3) goto L10;
        TextureRenderLog.i(this.mTexType, this.TAG, "skip updateHardwareBuffer");     // Catch: Throwable -> L26
        monitor-exit(r102);     // Catch: Throwable -> L26
        return -1;
    L10:
        this.mLastComeFrameType = 3;     // Catch: Throwable -> L26
        this.mHardwareBuffer = r100;     // Catch: Throwable -> L26
        if (r101 != null) goto L13;
    L20:
        this.mRect = null;     // Catch: Throwable -> L26
    L21:
        this.mFrameReady = true;     // Catch: Throwable -> L26
        int r103 = this.mFrameCountReceived + 1;     // Catch: Throwable -> L26
        this.mFrameCountReceived = r103;     // Catch: Throwable -> L26
        if ((r103 % 10) != 1) goto L24;
        TextureRenderLog.i(this.mTexType, this.TAG, "updateHardwareBuffer count = " + this.mFrameCountReceived);     // Catch: Throwable -> L26
    L24:
        monitor-exit(r102);     // Catch: Throwable -> L26
        return 0;
    L13:
        if (r101.length <= 0) goto L20;
        int[] r104 = this.mRect;     // Catch: Throwable -> L26
        if (r104 != null) goto L17;
    L18:
        this.mRect = new int[r101.length];     // Catch: Throwable -> L26
    L19:
        System.arraycopy(r101, 0, this.mRect, 0, r101.length);     // Catch: Throwable -> L26
        goto L21
    L17:
        if (r104.length == r101.length) goto L19;
        goto L18
    }

    public int updateHardwareBufferTexture(HardwareBuffer r100, int[] r101) {
        Object r102 = this.mHardwareBufferObject;
        monitor-enter(r102);
    L39:
        th = move-exception;
        throw th;
    L5:
        if (this.mState != 3) goto L9;
        TextureRenderLog.i(this.mTexType, this.TAG, "skip updateHardwareBufferTexture");     // Catch: Throwable -> L39
        monitor-exit(r102);     // Catch: Throwable -> L39
        return -1;
    L9:
        this.mLastComeFrameType = 4;     // Catch: Throwable -> L39
        if (this.mHardwareBufferTextureFilter != null) goto L17;
        HardwareBuffer2GLCopyFilter r103 = new HardwareBuffer2GLCopyFilter(this.mTexType);     // Catch: Throwable -> L39
        if (r103.init(null) == 0) goto L16;
        TextureRenderLog.e(this.mTexType, this.TAG, "updateHardwareBufferTexture but no filter");     // Catch: Throwable -> L39
        r103.release();     // Catch: Throwable -> L39
        monitor-exit(r102);     // Catch: Throwable -> L39
        return -1;
    L16:
        this.mHardwareBufferTextureFilter = r103;     // Catch: Throwable -> L39
    L17:
        this.mHardwareBufferTextureFilter.setSurfaceTexture(this);     // Catch: Throwable -> L39
        EffectTexture r104 = this.mHardwareBufferTextureFilter.process(r100, r101);     // Catch: Throwable -> L39
        this.mHardwareBufferTexture = r104;     // Catch: Throwable -> L39
        if (r104 != null) goto L23;
        TextureRenderLog.e(this.mTexType, this.TAG, "updateHardwareBufferTexture failed");     // Catch: Throwable -> L39
        monitor-exit(r102);     // Catch: Throwable -> L39
        return -1;
    L23:
        if (r104.getRect() == null) goto L33;
        if (r101 == null) goto L33;
        if (r101.length <= 0) goto L33;
        int[] r105 = this.mRect;     // Catch: Throwable -> L39
        if (r105 != null) goto L30;
    L31:
        this.mRect = new int[r101.length];     // Catch: Throwable -> L39
    L32:
        System.arraycopy(r101, 0, this.mRect, 0, r101.length);     // Catch: Throwable -> L39
    L34:
        this.mFrameReady = true;     // Catch: Throwable -> L39
        int r106 = this.mFrameCountReceived + 1;     // Catch: Throwable -> L39
        this.mFrameCountReceived = r106;     // Catch: Throwable -> L39
        if ((r106 % 10) != 1) goto L37;
        TextureRenderLog.i(this.mTexType, this.TAG, "updateHardwareBufferTexture count = " + this.mFrameCountReceived);     // Catch: Throwable -> L39
    L37:
        monitor-exit(r102);     // Catch: Throwable -> L39
        return 0;
    L30:
        if (r105.length == r101.length) goto L32;
    L33:
        this.mRect = null;     // Catch: Throwable -> L39
        goto L34
    }

    public void updateTexDimension(int r100, int r101) {
        TextureRenderLog.i(this.mTexType, this.TAG, "update tex dimension : " + r100 + ", " + r101);
        super.setDefaultBufferSize(r100, r101);
        IFrameProducer r102 = this.mFrameProducer;
        if (r102 == null) goto L5;
        r102.updateTexDimension(r100, r101);
    L5:
        this.mTexWidth = r100;
        this.mTexHeight = r101;
    }

    public void onFrameAvailable(HardwareBuffer r100, int[] r101) {
        Object r102 = this.mHardwareBufferObject;
        monitor-enter(r102);
        updateHardwareBuffer(r100, r101);     // Catch: Throwable -> L10
        TextureRenderer r103 = this.mTextureRenderer;     // Catch: Throwable -> L10
        if (r103 == null) goto L7;
        r103.handleHardwareBufferAvailable(this);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r102);     // Catch: Throwable -> L10
        return;
    L7:
        TextureRenderLog.e(this.mTexType, this.TAG, "handleHardwareBufferAvailable failed");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void setOption(int r100, Object r101) {
        if (r100 == 118) goto L19;
        if (r100 != 136) goto L7;
        this.mStaticMetadata = (List) r101;
        return;
    L7:
        if (r100 == 190) goto L10;
        return;
    L10:
        if ((r101 instanceof AbsEffect) == false) goto L16;
        ArrayList r102 = new ArrayList();
        r102.add(this);
        r102.add(r101);
        Message r103 = this.mRenderHandler.obtainMessage(45);     // Catch: Exception -> L14
        r103.obj = r102;     // Catch: Exception -> L14
        this.mRenderHandler.sendMessageAtFrontOfQueue(r103);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        TextureRenderLog.e(this.mTexType, this.TAG, "set ext effect exp:" + e);
        return;
    L16:
        TextureRenderLog.w(this.mTexType, this.TAG, "invalid ext effect");
        return;
    L19:
        if (this.mRenderHandler != null) goto L38;
        return;
    L38:
        Object r104 = new Object();     // Catch: Exception -> L34
        ArrayList r105 = new ArrayList();     // Catch: Exception -> L34
        r105.add(r104);     // Catch: Exception -> L34
        r105.add(r101);     // Catch: Exception -> L34
        Message r106 = this.mRenderHandler.obtainMessage(41);     // Catch: Exception -> L34
        r106.obj = r105;     // Catch: Exception -> L34
        r106.arg1 = 118;     // Catch: Exception -> L34
        monitor-enter(r104);     // Catch: Exception -> L34
        this.mRenderHandler.sendMessageAtFrontOfQueue(r106);     // Catch: Throwable -> L30
        r104.wait(1000);     // Catch: InterruptedException -> L28 Throwable -> L30
        TextureRenderLog.i(this.mTexType, this.TAG, "update background texture OK");     // Catch: InterruptedException -> L28 Throwable -> L30
        monitor-exit(r104);     // Catch: Throwable -> L30
        return;
    L29:
        throw new RuntimeException(this.TAG + " update background texture timeout");     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;     // Catch: Exception -> L34
    }

    public synchronized void setOption(int r100, float r101) {
        monitor-enter(this);
        if (r100 == 4) goto L42;
        if (r100 != 27) goto L8;
        this.mLayoutRatio = r101;     // Catch: Throwable -> L46
    L53:
        goto L44
    L8:
        if (r100 != 120) goto L10;
        this.mFPS = r101;     // Catch: Throwable -> L46
        goto L53
    L10:
        if (r100 != 122) goto L12;
        this.mAccumulatedPlayingTime = r101;     // Catch: Throwable -> L46
        goto L53
    L12:
        if (r100 != 123) goto L14;
        this.mLastFrameTime = r101;     // Catch: Throwable -> L46
        goto L53
    L14:
        if (r100 != 131) goto L16;
        this.mSRProcessSuccessRate = r101;     // Catch: Throwable -> L46
        goto L53
    L16:
        if (r100 != 132) goto L18;
        this.mSRProcessAverageCostTime = r101;     // Catch: Throwable -> L46
        goto L53
    L18:
        if (r100 != 154) goto L20;
        this.mVQScoreProcessSuccessRate = r101;     // Catch: Throwable -> L46
        goto L53
    L20:
        if (r100 != 155) goto L22;
        this.mVQScoreProcessAverageCostTime = r101;     // Catch: Throwable -> L46
        goto L53
    L22:
        if (r100 != 172) goto L24;
        this.mSharpenSuccessRate = r101;     // Catch: Throwable -> L46
        goto L53
    L24:
        if (r100 == 173) goto L32;
        Handler r102 = this.mRenderHandler;     // Catch: Throwable -> L46
        if (r102 != null) goto L30;
        monitor-exit(this);
        return;
    L30:
        Message r103 = r102.obtainMessage(35);     // Catch: Exception -> L49 Throwable -> L46
        r103.obj = this;     // Catch: Exception -> L49 Throwable -> L46
        r103.arg1 = r100;     // Catch: Exception -> L49 Throwable -> L46
        Bundle r104 = new Bundle();     // Catch: Exception -> L49 Throwable -> L46
        r104.putFloat(TextureRenderKeys.KEY_IS_FLOAT_VALUE, r101);     // Catch: Exception -> L49 Throwable -> L46
        r103.setData(r104);     // Catch: Exception -> L49 Throwable -> L46
        r103.sendToTarget();     // Catch: Exception -> L49 Throwable -> L46
    L50:
    L32:
        this.mSharpenCostTime = r101;     // Catch: Throwable -> L46
        goto L53
    L42:
        TextureRenderLog.i(this.mTexType, this.TAG, "set TEXTURE_OPTION_SET_OVERLAY_RATIO ratio:" + r101);     // Catch: Throwable -> L46
        Message r105 = this.mRenderHandler.obtainMessage(27);     // Catch: Exception -> L49 Throwable -> L46
        r105.obj = this;     // Catch: Exception -> L49 Throwable -> L46
        Bundle r106 = new Bundle();     // Catch: Exception -> L49 Throwable -> L46
        r106.putFloat(TextureRenderKeys.OVERLAY_RATIO, r101);     // Catch: Exception -> L49 Throwable -> L46
        r105.setData(r106);     // Catch: Exception -> L49 Throwable -> L46
        r105.sendToTarget();     // Catch: Exception -> L49 Throwable -> L46
    L46:
        th = move-exception;
        throw th;
    L44:
        monitor-exit(this);
    }

    public VideoSurfaceTexture(ITexture r100, Handler r101, TextureRenderer r110) {
        super(r100.lock());
        this.mIsRelease = false;
        this.mIsPaused = false;
        this.mIsMakeCurrent = false;
        this.mEglSurface = EGL14.EGL_NO_SURFACE;
        this.mViewportWidth = 0;
        this.mViewportHeight = 0;
        this.mRenderSurface = null;
        this.mUpdateSurface = null;
        this.mOffScreenSurface = null;
        this.mReleaseOffScreenSurfaceFinish = false;
        this.mSerial = 0;
        this.mIsPreRender = false;
        this.mIgnoreSRResCheck = false;
        this.mStartPlayTimeNanos = -1;
        this.mDropCount = 0;
        this.mSyncMsg = new Message();
        this.mTexType = -1;
        this.mSyncUpdateSurface = 0;
        this.mConfig = new EffectConfig(-1);
        this.mTextureQueue = new LinkedList();
        this.mUsingEffect = new HashMap();
        this.mSaveFrameCount = 0;
        this.mSaveFrameBundle = new Bundle();
        this.mState = 3;
        this.mFrameMetaData = new ArrayList();
        this.mFrameReady = false;
        this.mFrameCount = 0;
        this.mAccumulatedPlayingTime = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mLastFrameTime = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mFPS = 0.0f;
        this.mCurrentEffectStartTime = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mCurrentEffectProcessDepth = 0;
        this.mPerEffectFrameCount = new HashMap();
        this.mPerEffectAccumulatedTime = new HashMap();
        this.mPerEffectAverageTime = new HashMap();
        this.mEffectChainStartTime = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mEffectChainAccumulatedTime = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mEffectChainFrameCount = 0;
        this.mEffectChainAverageTime = 0.0f;
        this.mTrackingErrorCode = new HashMap();
        this.mTrackingErrorMsg = new HashMap();
        this.mSRProcessSuccessRate = Float.MIN_VALUE;
        this.mSRProcessAverageCostTime = Float.MIN_VALUE;
        this.mSharpenCostTime = Float.MIN_VALUE;
        this.mSharpenSuccessRate = Float.MIN_VALUE;
        this.mStaticMetadata = null;
        this.mFreezeDirector = 0;
        this.mEnableExtraSurfaceRenderCallback = 0;
        this.mFrameCallback = null;
        this.mFrameCallbackBundle = null;
        this.mEnableUseEglDummySurface = 0;
        this.mNotKeepLastParams = 0;
        this.mDoMirrorFirst = 0;
        this.mNativeWindow = null;
        this.mEnableNativeWindow = 0;
        this.mSRProcessScaleType = -1;
        this.mLayoutMode = 1;
        this.mLayoutRatio = 0.5f;
        this.mRotationType = 0;
        this.mIsMirrorHorizontal = 0;
        this.mIsMirrorVertical = 0;
        this.mRenderWhenSizeChange = 0;
        this.mIsUsingNewTTPlayerView = 0;
        this.mExtraRenderCropParamsBundleMap = null;
        this.mMainRenderCropParamsBundle = null;
        this.mSyncSetVsync = 0;
        this.mForbidReuseVideoSurfaceTexture = 0;
        this.mHDRType = 0;
        this.mBitDepth = 8;
        this.mRoiSRParamsBundle = null;
        this.mHeadposeCallbackIntegral = 1;
        this.mFrameCallbackInRenderThread = 0;
        this.mVQScoreProcessSuccessRate = -1.0f;
        this.mVQScoreProcessAverageCostTime = -1.0f;
        this.mOpenVQScore = 0;
        this.mVQScoreBundle = null;
        this.mEffectTexture = null;
        this.mFrameProducer = null;
        this.mHardwareBufferObject = new Object();
        this.mHardwareBufferRenderDirectly = 0;
        this.mHardwareBuffer = null;
        this.mHardwareBufferTexture = null;
        this.mHardwareBufferTextureFilter = null;
        this.mRect = null;
        this.mLastComeFrameType = 0;
        this.mDataSpace = -1;
        this.mSRProcessParamter = null;
        this.mSRParamsBundle = null;
        this.mEnableResetCropParamsInRender = 0;
        this.mCheckGeomeCount = 0;
        this.mNeedCheckGeome = false;
        this.mEnableGlBlitToScreen = 0;
        this.mFrameCountReceived = 0;
        this.mFirstFrameRendered = false;
        this.mUsingSRDirectDraw = false;
        this.mUsingSharpenDirectDraw = false;
        this.mSkipFilterCallGlFinish = 0;
        this.mSkipFiliterCallGlClear = 0;
        this.mAesBoostParamsBundle = null;
        this.mBeginSRThreshold = 0;
        this.mEnableGlBlitToSceenForHardWareBuffer = 0;
        this.mGlBlitSkipGLFinish = 0;
        this.mBrightnessBalanceParamsBundle = null;
        this.mExtraSurfaceMakeCurrent = 0;
        this.mNeedCheckMakeCurrent = 0;
        String r102 = TextureRenderLog.getLogTag(this);
        this.TAG = r102;
        this.mEventLogger = new TextureRenderEventLogger(r102);
        r100.addRef();
        this.mTextureId = r100;
        r100.unlock();
        internalConstruct(r101);
        this.mExtraSurfaceMap = new HashMap();
        this.mTextureRenderer = r110;
    }

    public void frameMetaCallback(long r110, long r111, Map<Integer, String> r210) {
        TextureRenderLog.i(this.mTexType, this.TAG, "frameMetaCallback this:" + this + " pts:" + r110 + " mRenderHandler:" + this.mRenderHandler);
        if (this.mRenderHandler != null) goto L5;
        return;
    L5:
        long r112 = SystemClock.elapsedRealtime();
        if (getIntOption(19, 18) != 1) goto L9;
        TextureRenderLog.i(this.mTexType, this.TAG, "frameMetaCallback tile info: " + r210.get(74));
        this.mFrameMetaData.add(new FrameMetaData(r110, r111, r112, r210));
    L9:
        if ((this.mTexType & 4) != 0) goto L12;
        return;
    L12:
        if (this.mOffScreenSurface != null) goto L41;
        TextureRenderLog.i(this.mTexType, this.TAG, "mOffScreenSurface null,return this:" + this);
        return;
    L41:
        Message r100 = this.mRenderHandler.obtainMessage(32);     // Catch: Exception -> L38
        Bundle r101 = new Bundle();     // Catch: Exception -> L38
        r101.putSerializable(TextureRenderKeys.OVERLAY_UPDATE_FRAME_TIME, new FrameTimeQueue.FrameTime(r110, r111));     // Catch: Exception -> L38
        String r102 = null;
        if (r210 == null) goto L18;
        String r103 = r210.get(46);     // Catch: Exception -> L38
    L19:
        r101.putString(TextureRenderKeys.OVERLAY_MASTER_CLOCK, r103);     // Catch: Exception -> L38
        if (r210 == null) goto L22;
        r102 = r210.get(74);     // Catch: Exception -> L38
    L22:
        r101.putString(TextureRenderKeys.FOV_TILE_INFO, r102);     // Catch: Exception -> L38
        r101.putLong(TextureRenderKeys.OVERLAY_MASTER_CLOCK_DIFF, r112);     // Catch: Exception -> L38
        r101.putSerializable(KEY_TEXTURE, this);     // Catch: Exception -> L38
        r100.setData(r101);     // Catch: Exception -> L38
        Message r104 = this.mSyncMsg;     // Catch: Exception -> L38
        r100.obj = r104;     // Catch: Exception -> L38
        monitor-enter(r104);     // Catch: Exception -> L38
        r100.sendToTarget();     // Catch: Throwable -> L35
        this.mSyncMsg.wait();     // Catch: InterruptedException -> L31 Throwable -> L35
        Message r105 = this.mSyncMsg;     // Catch: InterruptedException -> L31 Throwable -> L35
        int r106 = r105.arg1;     // Catch: InterruptedException -> L31 Throwable -> L35
        if (r106 != Integer.MIN_VALUE) goto L28;
    L33:
        monitor-exit(r104);     // Catch: Throwable -> L35
    L46:
        return;
    L28:
        if (r106 == r110) goto L33;
        r105.wait();     // Catch: InterruptedException -> L31 Throwable -> L35
    L31:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;     // Catch: Exception -> L38
    L18:
        r103 = null;
    L38:
        e = move-exception;
        e.printStackTrace();
    }

    public void notifyError(int r100, int r101, String r102) {
        HashMap<Integer, Integer> r103 = this.mTrackingErrorCode;     // Catch: Exception -> L16
        if (r103 != null) goto L5;
    L11:
        this.mOffScreenSurface.onTextureRenderError(r100, r101, r102);     // Catch: Exception -> L16
        if (r101 != 0) goto L14;
        this.mEventLogger.setErrorCode(r100);     // Catch: Exception -> L16
        return;
    L14:
        this.mEventLogger.setEffectProcessError(r101, r100);     // Catch: Exception -> L16
        return;
    L5:
        if (this.mTrackingErrorMsg == null) goto L11;
        Integer r104 = r103.get(Integer.valueOf(r101));     // Catch: Exception -> L16
        if (r104 != null) goto L9;
    L10:
        this.mTrackingErrorCode.put(Integer.valueOf(r101), Integer.valueOf(r100));     // Catch: Exception -> L16
        this.mTrackingErrorMsg.put(Integer.valueOf(r101), r102);     // Catch: Exception -> L16
        goto L11
    L9:
        if (r104.intValue() != 0) goto L11;
    }

    public void notifyInitError(int r100, int r101, String r102) {
        HashMap<Integer, Integer> r103 = this.mTrackingErrorCode;     // Catch: Exception -> L13
        if (r103 != null) goto L5;
    L11:
        this.mOffScreenSurface.onTextureRenderError(r100, r101, r102);     // Catch: Exception -> L13
        this.mEventLogger.setEffectInitError(r101, r100);     // Catch: Exception -> L13
        return;
    L5:
        if (this.mTrackingErrorMsg == null) goto L11;
        Integer r104 = r103.get(Integer.valueOf(r101));     // Catch: Exception -> L13
        if (r104 != null) goto L9;
    L10:
        this.mTrackingErrorCode.put(Integer.valueOf(r101), Integer.valueOf(r100));     // Catch: Exception -> L13
        this.mTrackingErrorMsg.put(Integer.valueOf(r101), r102);     // Catch: Exception -> L13
        goto L11
    L9:
        if (r104.intValue() != 0) goto L11;
    }

    public void setEffectOpen(int r100, int r101, Bundle r102) {
        this.mConfig.setEffectOpen(r100, r101);
        if (r100 != 8) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L27;
        if (r101 == 1) goto L12;
        IVsyncHelper r104 = this.mVsyncHelper;
        if (r104 == null) goto L29;
        r104.removeObserver(this);
        return;
    L29:
        return;
    L12:
        if (this.mVsyncHelper != null) goto L14;
        this.mVsyncHelper = VsyncHelperFactory.createVsyncHelper(TextureRenderManager.getManager().getContext(), this.mTexType, r102);
    L14:
        TextureRenderManager r105 = TextureRenderManager.getManager();
        if (r105 != null) goto L17;
    L21:
        this.mVsyncHelper.addObserver(this);
    L22:
        this.mVsyncHelper.setEnable(true);
        return;
    L17:
        if (r105.isAsyncRelaseSurfaceTexture() == false) goto L21;
        if (this.mTexType != 0) goto L21;
        this.mVsyncHelper.removeObserver(this);
        goto L22
    L27:
        return;
    L5:
        if (r100 == 12) goto L8;
        r103 = false;
        goto L9
    }

    public void setOption(int r100, int r101, int r102) {
        if (r100 != 19) goto L5;
        if (r101 >= 0) goto L12;
        return;
    L12:
        this.mUsingEffect.put(Integer.valueOf(r101), Integer.valueOf(r102));
        return;
    L5:
        if (r100 != 126) goto L16;
        HashMap<Integer, Integer> r103 = this.mTrackingErrorCode;
        if (r103 == null) goto L14;
        r103.put(Integer.valueOf(r101), Integer.valueOf(r102));
        return;
    L14:
        return;
    }

    public void setOption(int r100, int r101, String r102) {
        if (r100 != 127) goto L10;
        HashMap<Integer, String> r103 = this.mTrackingErrorMsg;
        if (r103 == null) goto L9;
        r103.put(Integer.valueOf(r101), r102);
        return;
    L9:
        return;
    }

    public VideoSurfaceTexture(ITexture r100, boolean r101, Handler r102, TextureRenderer r110) {
        super(r100.lock(), r101);
        this.mIsRelease = false;
        this.mIsPaused = false;
        this.mIsMakeCurrent = false;
        this.mEglSurface = EGL14.EGL_NO_SURFACE;
        this.mViewportWidth = 0;
        this.mViewportHeight = 0;
        this.mRenderSurface = null;
        this.mUpdateSurface = null;
        this.mOffScreenSurface = null;
        this.mReleaseOffScreenSurfaceFinish = false;
        this.mSerial = 0;
        this.mIsPreRender = false;
        this.mIgnoreSRResCheck = false;
        this.mStartPlayTimeNanos = -1;
        this.mDropCount = 0;
        this.mSyncMsg = new Message();
        this.mTexType = -1;
        this.mSyncUpdateSurface = 0;
        this.mConfig = new EffectConfig(-1);
        this.mTextureQueue = new LinkedList();
        this.mUsingEffect = new HashMap();
        this.mSaveFrameCount = 0;
        this.mSaveFrameBundle = new Bundle();
        this.mState = 3;
        this.mFrameMetaData = new ArrayList();
        this.mFrameReady = false;
        this.mFrameCount = 0;
        this.mAccumulatedPlayingTime = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mLastFrameTime = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mFPS = 0.0f;
        this.mCurrentEffectStartTime = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mCurrentEffectProcessDepth = 0;
        this.mPerEffectFrameCount = new HashMap();
        this.mPerEffectAccumulatedTime = new HashMap();
        this.mPerEffectAverageTime = new HashMap();
        this.mEffectChainStartTime = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mEffectChainAccumulatedTime = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mEffectChainFrameCount = 0;
        this.mEffectChainAverageTime = 0.0f;
        this.mTrackingErrorCode = new HashMap();
        this.mTrackingErrorMsg = new HashMap();
        this.mSRProcessSuccessRate = Float.MIN_VALUE;
        this.mSRProcessAverageCostTime = Float.MIN_VALUE;
        this.mSharpenCostTime = Float.MIN_VALUE;
        this.mSharpenSuccessRate = Float.MIN_VALUE;
        this.mStaticMetadata = null;
        this.mFreezeDirector = 0;
        this.mEnableExtraSurfaceRenderCallback = 0;
        this.mFrameCallback = null;
        this.mFrameCallbackBundle = null;
        this.mEnableUseEglDummySurface = 0;
        this.mNotKeepLastParams = 0;
        this.mDoMirrorFirst = 0;
        this.mNativeWindow = null;
        this.mEnableNativeWindow = 0;
        this.mSRProcessScaleType = -1;
        this.mLayoutMode = 1;
        this.mLayoutRatio = 0.5f;
        this.mRotationType = 0;
        this.mIsMirrorHorizontal = 0;
        this.mIsMirrorVertical = 0;
        this.mRenderWhenSizeChange = 0;
        this.mIsUsingNewTTPlayerView = 0;
        this.mExtraRenderCropParamsBundleMap = null;
        this.mMainRenderCropParamsBundle = null;
        this.mSyncSetVsync = 0;
        this.mForbidReuseVideoSurfaceTexture = 0;
        this.mHDRType = 0;
        this.mBitDepth = 8;
        this.mRoiSRParamsBundle = null;
        this.mHeadposeCallbackIntegral = 1;
        this.mFrameCallbackInRenderThread = 0;
        this.mVQScoreProcessSuccessRate = -1.0f;
        this.mVQScoreProcessAverageCostTime = -1.0f;
        this.mOpenVQScore = 0;
        this.mVQScoreBundle = null;
        this.mEffectTexture = null;
        this.mFrameProducer = null;
        this.mHardwareBufferObject = new Object();
        this.mHardwareBufferRenderDirectly = 0;
        this.mHardwareBuffer = null;
        this.mHardwareBufferTexture = null;
        this.mHardwareBufferTextureFilter = null;
        this.mRect = null;
        this.mLastComeFrameType = 0;
        this.mDataSpace = -1;
        this.mSRProcessParamter = null;
        this.mSRParamsBundle = null;
        this.mEnableResetCropParamsInRender = 0;
        this.mCheckGeomeCount = 0;
        this.mNeedCheckGeome = false;
        this.mEnableGlBlitToScreen = 0;
        this.mFrameCountReceived = 0;
        this.mFirstFrameRendered = false;
        this.mUsingSRDirectDraw = false;
        this.mUsingSharpenDirectDraw = false;
        this.mSkipFilterCallGlFinish = 0;
        this.mSkipFiliterCallGlClear = 0;
        this.mAesBoostParamsBundle = null;
        this.mBeginSRThreshold = 0;
        this.mEnableGlBlitToSceenForHardWareBuffer = 0;
        this.mGlBlitSkipGLFinish = 0;
        this.mBrightnessBalanceParamsBundle = null;
        this.mExtraSurfaceMakeCurrent = 0;
        this.mNeedCheckMakeCurrent = 0;
        String r103 = TextureRenderLog.getLogTag(this);
        this.TAG = r103;
        this.mEventLogger = new TextureRenderEventLogger(r103);
        r100.addRef();
        this.mTextureId = r100;
        r100.unlock();
        internalConstruct(r102);
        this.mExtraSurfaceMap = new HashMap();
        this.mTextureRenderer = r110;
    }

    public int sendMsg(Message r100, boolean r101, boolean r102, long r103) {
        Handler r104 = this.mRenderHandler;
        if (r104 != null) goto L22;
        return -1;
    L22:
        if (r102 == true) goto L8;
        if (r101 == false) goto L7;
        r104.sendMessageAtFrontOfQueue(r100);     // Catch: Exception -> L21
        return 0;
    L7:
        r104.sendMessage(r100);     // Catch: Exception -> L21
        return 0;
    L8:
        monitor-enter(this);     // Catch: Exception -> L21
        if (r101 == false) goto L11;
        this.mRenderHandler.sendMessageAtFrontOfQueue(r100);     // Catch: Throwable -> L16
    L12:
        TextureRenderLog.i(this.mTexType, this.TAG, "sendMsg, msg:" + r100);     // Catch: Throwable -> L16
        wait(r103);     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return 0;
        goto L27
    L11:
        this.mRenderHandler.sendMessage(r100);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;     // Catch: Exception -> L21
    L27:
        return -1;
    }

    public synchronized void setSuperResolutionConfig(int r100, String r101, String r102, String r103, int r104, int r110, String r111) {
        monitor-enter(this);
        Handler r105 = this.mRenderHandler;     // Catch: Throwable -> L8
        if (r105 == null) goto L6;
        Message r106 = r105.obtainMessage(12);     // Catch: Throwable -> L8
        r106.obj = this;     // Catch: Throwable -> L8
        Bundle r107 = new Bundle();     // Catch: Throwable -> L8
        r107.putInt("effect_type", 5);     // Catch: Throwable -> L8
        r107.putInt("action", 21);     // Catch: Throwable -> L8
        r107.putInt(TextureRenderKeys.KEY_SR_ALG_TYPE, r100);     // Catch: Throwable -> L8
        r107.putInt(TextureRenderKeys.KEY_SR_ALG_MAX_SIZE_WIDTH, r104);     // Catch: Throwable -> L8
        r107.putInt(TextureRenderKeys.KEY_SR_ALG_MAX_SIZE_HEIGHT, r110);     // Catch: Throwable -> L8
        r107.putString(TextureRenderKeys.KEY_KERNEL_BIN_PATH, r101);     // Catch: Throwable -> L8
        r107.putString(TextureRenderKeys.KEY_OCL_MODLE_NAME, r102);     // Catch: Throwable -> L8
        r107.putString(TextureRenderKeys.KEY_DSP_MODLE_NAME, r103);     // Catch: Throwable -> L8
        r107.putString(TextureRenderKeys.KEY_MODULE_NAME, r111);     // Catch: Throwable -> L8
        r106.setData(r107);     // Catch: Throwable -> L8
        this.mRenderHandler.sendMessageAtFrontOfQueue(r106);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
