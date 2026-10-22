package com.ss.texturerender;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.hardware.HardwareBuffer;
import android.media.ImageReader;
import android.opengl.EGLContext;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.Surface;
import com.ss.texturerender.effect.PicoTextureObj;
import com.ss.texturerender.effect.vr.director.picodirector.PicoQuaternion;
import com.ss.texturerender.math.Quaternion;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes40.dex */
public class VideoSurface extends Surface implements VideoSurfaceTexture.TextureDrawCallback, VideoSurfaceTexture.TextureErrorCallback, Handler.Callback {
    public static final int ERROR_SR_EXE_FAIL = 2;
    public static final int ERROR_SR_INIT_FAIL = 1;
    private static final int MSG_EFFECT_ERROR = 4097;
    private static final int MSG_HEADPOSE_UPDATE = 4098;
    private static final int MSG_SR_STATE_CHANGE = 4099;
    private static final int MSG_TEXTURE_UPDATE = 4096;
    public static final int OPERATE_ADD = 1;
    public static final int OPERATE_RELEASE = 2;
    public static final int OPERATE_RELEASE_ALL = 3;
    public static final int OPERATE_UPDATE = 4;
    public static final int SUPER_RES_CLOSE = 0;
    public static final int SUPER_RES_NN_ALG = 2;
    public static final int SUPER_RES_OPEN = 1;
    public static final int SUPER_RES_STAT_1_5 = 4;
    public static final int SUPER_RES_STAT_ALG_R = 0;
    public static final int SUPER_RES_STAT_ALG_V = 1;
    public static final int SUPER_RES_STAT_BMF_BACKEND_AUTO = 0;
    public static final int SUPER_RES_STAT_BMF_BACKEND_CPU = 1;
    public static final int SUPER_RES_STAT_BMF_BACKEND_DSP = 4;
    public static final int SUPER_RES_STAT_BMF_BACKEND_OPENCL = 2;
    public static final int SUPER_RES_STAT_BMF_BACKEND_OPENGL = 3;
    public static final int SUPER_RES_STAT_BMF_PACKAGE_SR_GUARD_MAX = 99999;
    public static final int SUPER_RES_STAT_BMF_PACKAGE_SR_GUARD_MIN = 10000;
    public static final int SUPER_RES_STAT_BMF_PACKAGE_SR_HP_V2_2 = 10202;
    public static final int SUPER_RES_STAT_BMF_PACKAGE_SR_HP_V3_6 = 10306;
    public static final int SUPER_RES_STAT_BMF_PACKAGE_SR_HP_V4_1 = 10401;
    public static final int SUPER_RES_STAT_BMF_PACKAGE_SR_LL_V2_1 = 20201;
    public static final int SUPER_RES_STAT_BMF_PACKAGE_SR_LL_V2_4 = 20204;
    public static final int SUPER_RES_STAT_BMF_SRV1 = 8;
    public static final int SUPER_RES_STAT_BMF_SRV1_COMPOUND_OPT = 13;
    public static final int SUPER_RES_STAT_BMF_SRV1_COMPOUND_YUV = 12;
    public static final int SUPER_RES_STAT_BMF_SRV1_OPT = 10;
    public static final int SUPER_RES_STAT_BMF_SRV1_OPT_YUV = 11;
    public static final int SUPER_RES_STAT_BMF_SRV2 = 9;
    public static final int SUPER_RES_STAT_BMF_SRV3_4_OPT_OES = 17;
    public static final int SUPER_RES_STAT_BMF_SR_HP_V3_5 = 20;
    public static final int SUPER_RES_STAT_BMF_SR_HP_V3_5_OVERSHOOT_REDUCTION = 29;
    public static final int SUPER_RES_STAT_BMF_SR_HP_V3_6 = 22;
    public static final int SUPER_RES_STAT_BMF_SR_HP_V3_6_OVERSHOOT_REDUCTION = 30;
    public static final int SUPER_RES_STAT_BMF_SR_HP_V4_1 = 18;
    public static final int SUPER_RES_STAT_BMF_SR_HP_V4_2 = 21;
    public static final int SUPER_RES_STAT_BMF_SR_HP_V6_1 = 19;
    public static final int SUPER_RES_STAT_BMF_SR_HP_V6_2 = 23;
    public static final int SUPER_RES_STAT_BMF_SR_HP_V6_2_OVERSHOOT_REDUCTION = 31;
    public static final int SUPER_RES_STAT_BMF_SR_HP_V6_3 = 26;
    public static final int SUPER_RES_STAT_BMF_SR_HP_V6_3_OVERSHOOT_REDUCTION = 32;
    public static final int SUPER_RES_STAT_BMF_SR_LL_V2_1 = 24;
    public static final int SUPER_RES_STAT_BMF_SR_LL_V2_2 = 25;
    public static final int SUPER_RES_STAT_BMF_SR_LL_V2_2_OVERSHOOT_REDUCTION = 35;
    public static final int SUPER_RES_STAT_BMF_SR_LL_V2_3 = 27;
    public static final int SUPER_RES_STAT_BMF_SR_LL_V2_3_OVERSHOOT_REDUCTION = 33;
    public static final int SUPER_RES_STAT_BMF_SR_LL_V2_4 = 28;
    public static final int SUPER_RES_STAT_BMF_SR_LL_V2_4_OVERSHOOT_REDUCTION = 34;
    public static final int SUPER_RES_STAT_BMF_SR_LL_V4_1_OVERSHOOT_REDUCTION = 36;
    public static final int SUPER_RES_STAT_BMF_SR_OVERSHOOT_REDUCTION_GUARD_MAX = 36;
    public static final int SUPER_RES_STAT_BMF_SR_OVERSHOOT_REDUCTION_GUARD_MIN = 29;
    public static final int SUPER_RES_STAT_BMF_V1 = 5;
    public static final int SUPER_RES_STAT_BMF_V1_OPT = 7;
    public static final int SUPER_RES_STAT_BMF_V2 = 6;
    public static final int SUPER_SCALE_TYPE_1_1 = 4;
    public static final int SUPER_SCALE_TYPE_1_2 = 8;
    public static final int SUPER_SCALE_TYPE_1_3 = 16;
    public static final int SUPER_SCALE_TYPE_1_4 = 32;
    public static final int SUPER_SCALE_TYPE_1_5 = 1;
    public static final int SUPER_SCALE_TYPE_2_0 = 0;
    public static final int SUPER_SCALE_TYPE_2_0_NEW = 2;
    private final String TAG;
    private boolean mCallbackDirectly;
    private RenderCheckDispatcher mCheckDispatcher;
    private OnDrawFrameListener mDrawFrameListener;
    private boolean mEnableNoRenderCheck;
    private ArrayList<OnErrorListenerExt> mErrorListenerExts;
    private ArrayList<OnErrorListener> mErrorListeners;
    private OnExtraSurfaceDrawListener mExtraSurfaceDrawFrameListener;
    private Object mHandlerObject;
    private boolean mHasGLContextAttached;
    private OnHeadposeChangedListener mHeadposeChangedListener;
    private Bundle mMsgObjectBundle;
    private Handler mNotifyHandler;
    private OnDrawFrameAbsListener mOnDrawFrameAbsListener;
    private OnSetSurfaceListener mOnSetSurfaceListener;
    private float mQuatW;
    private float mQuatX;
    private float mQuatY;
    private float mQuatZ;
    private ReentrantLock mReleaseTextureLock;
    private FrameRenderChecker mRenderChecker;
    private int mRenderDevice;
    protected int mSurfaceHeight;
    private VideoSurfaceTexture mSurfaceTexture;
    private VideoSurfaceTexturePicoInterface mSurfaceTexturePicoListener;
    protected int mSurfaceWidth;
    private int mTexType;
    private TextureRenderer mTextureRender;

    public interface FrameRenderCallback extends Serializable {
        int onBytebufferCallbck(int r100, ByteBuffer r101, int r102, int r103, long r104);

        int onTextureCallback(int r100, int r101, int r102, EGLContext r103, int r104, int r105, long r106);
    }

    public interface NotifyUIAnimationState extends Serializable {
        void onAnimationState(int r100);
    }

    public static abstract class OnDrawFrameAbsListener {
        public OnDrawFrameAbsListener() {
        }

        public void onSRStateChanged(int r100, int r101) {
        }
    }

    public interface OnDrawFrameListener {
        void onDraw(long r100);
    }

    public interface OnErrorListener {
        void onError(int r100);
    }

    public static class OnErrorListenerExt {
        public OnErrorListenerExt() {
        }

        public void onError(int r100, int r101, String r102) {
            TextureRenderLog.i(-1, "VideoSurface", "OnErrorListenerExt (default impl) onError reason=" + r100 + " type=" + r101 + " msg=" + r102);
        }
    }

    public interface OnExtraSurfaceDrawListener {
        void onExtraSurfaceDraw(Surface r100, long r101);
    }

    public interface OnHeadposeChangedListener {
        void onHeadposeChanged(Quaternion r100);
    }

    public interface OnNoRenderListener {
        void onNoRenderEnd(int r100);

        void onNoRenderStart(int r100);
    }

    public interface OnSetSurfaceListener {
        int onSetSurface(VideoSurface r100, Surface r101);
    }

    public interface SaveFrameCallback extends Serializable {
        int onFrame(ByteBuffer r100, int r101, int r102);
    }

    public interface VQScoreCallback extends Serializable {
        int onProcessScore(float r100, long r101, long r102);
    }

    private synchronized void releaseTexture() {
        monitor-enter(this);
        TextureRenderManager r100 = TextureRenderManager.getManager();     // Catch: Throwable -> L19
        if (r100 != null) goto L6;
    L14:
        VideoSurfaceTexture r101 = this.mSurfaceTexture;     // Catch: Throwable -> L19
        if (r101 == null) goto L17;
        r101.releaseOffScreenSurface(false);     // Catch: Throwable -> L19
        this.mSurfaceTexture = null;     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);
        return;
    L6:
        if (r100.isAsyncRelaseSurfaceTexture() == false) goto L14;
        if (this.mTexType != 0) goto L14;
        this.mReleaseTextureLock.lock();     // Catch: Throwable -> L19
        VideoSurfaceTexture r102 = this.mSurfaceTexture;     // Catch: Throwable -> L19
        if (r102 == null) goto L12;
        r102.releaseOffScreenSurface(false);     // Catch: Throwable -> L19
        this.mSurfaceTexture = null;     // Catch: Throwable -> L19
    L13:
        this.mReleaseTextureLock.unlock();     // Catch: Throwable -> L19
        goto L17
    L12:
        TextureRenderLog.i(this.mTexType, this.TAG, "release is null");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public int detachGLContext() {
        this.mHasGLContextAttached = false;
        TextureRenderer r100 = this.mTextureRender;
        if (r100 == null) goto L6;
        r100.handleDetachGLContext();
        this.mTextureRender = null;
        return 0;
    L6:
        return -1;
    }

    public Bitmap saveFrame() {
        return saveFrame(null, null);
    }

    public int attachGLContext() {
        VideoSurfaceTexture r100 = this.mSurfaceTexture;
        if (r100 != null) goto L5;
        return -1;
    L5:
        TextureRenderer r101 = r100.getTextureRender();
        this.mTextureRender = r101;
        if (r101 == null) goto L9;
        this.mHasGLContextAttached = true;
        return r101.handleAttachGLContext();
    L9:
        return -1;
    }

    public Map<String, Object> getAllEvents() {
        VideoSurfaceTexture r100 = this.mSurfaceTexture;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getAllEvents();
    }

    public VideoSurface getExtraVideoSurface() {
        VideoSurfaceTexture r100 = this.mSurfaceTexture;
        if (r100 == null) goto L8;
        VideoSurfaceTexture r101 = r100.getExtraVideoSurfaceTexture();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getOffScreenSurface();
    L8:
        return null;
    }

    public int[] getFovResult() {
        VideoSurfaceTexturePicoInterface r100 = this.mSurfaceTexturePicoListener;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getFovResult();
    }

    public ImageReader.OnImageAvailableListener getFrameProducer() {
        VideoSurfaceTexture r100 = this.mSurfaceTexture;
        if (r100 != null) goto L7;
        return null;
    L7:
        return (ImageReader.OnImageAvailableListener) r100.getFrameProducer();
    }

    public Surface getRenderSurface() {
        VideoSurfaceTexture r100 = this.mSurfaceTexture;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getRenderSurface();
    }

    public Handler getRenderhandler() {
        VideoSurfaceTexture r100 = this.mSurfaceTexture;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getRenderHandler();
    }

    public boolean isUpdateFrame() {
        VideoSurfaceTexture r100 = this.mSurfaceTexture;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isUpdateFrame();
    }

    public void playerRenderStart() {
        VideoSurfaceTexture r100 = this.mSurfaceTexture;
        if (r100 == null) goto L6;
        r100.playerRenderStart();
        return;
    }

    public void preRender() {
        VideoSurfaceTexture r100 = this.mSurfaceTexture;
        if (r100 == null) goto L6;
        r100.preRender();
        return;
    }

    public Map<String, Integer> querySRAndRenderState() {
        VideoSurfaceTexture r100 = this.mSurfaceTexture;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.querySRAndRenderState();
    }

    @Override // android.view.Surface
    public void release() {
        TextureRenderLog.i(this.mTexType, this.TAG, "release");
        super.release();
        this.mRenderChecker.stop();
        releaseTexture();
        Object r100 = this.mHandlerObject;
        monitor-enter(r100);
        this.mDrawFrameListener = null;     // Catch: Throwable -> L13
        this.mNotifyHandler = null;     // Catch: Throwable -> L13
        this.mOnDrawFrameAbsListener = null;     // Catch: Throwable -> L13
        ArrayList<OnErrorListener> r101 = this.mErrorListeners;     // Catch: Throwable -> L13
        if (r101 == null) goto L8;
        r101.clear();     // Catch: Throwable -> L13
    L8:
        ArrayList<OnErrorListenerExt> r102 = this.mErrorListenerExts;     // Catch: Throwable -> L13
        if (r102 == null) goto L11;
        r102.clear();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r100);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // android.view.Surface
    public void finalize() throws Throwable {
        releaseTexture();
        super.finalize();
    }

    public VideoSurface(VideoSurfaceTexture r100) {
        super(r100);
        this.mSurfaceTexturePicoListener = null;
        this.mOnDrawFrameAbsListener = null;
        this.mErrorListeners = null;
        this.mErrorListenerExts = null;
        this.mTexType = -1;
        this.mQuatX = 0.0f;
        this.mQuatY = 0.0f;
        this.mQuatZ = 0.0f;
        this.mQuatW = 1.0f;
        this.mRenderDevice = -1;
        this.mSurfaceWidth = 0;
        this.mSurfaceHeight = 0;
        this.mCallbackDirectly = false;
        this.TAG = TextureRenderLog.getLogTag(this);
        init(r100, false);
        this.mReleaseTextureLock = new ReentrantLock();
    }

    public int drawImage(Bitmap r100) {
        if (r100 != null) goto L4;
    L10:
        TextureRenderLog.e(this.mTexType, this.TAG, "drawImage error");
        return -1;
    L4:
        if (r100.isRecycled() == true) goto L10;
        VideoSurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 == null) goto L10;
        r101.setDefaultBufferSize(r100.getWidth(), r100.getHeight());
        updateTexDimension(r100.getWidth(), r100.getHeight());
        Canvas r102 = lockCanvas(null);
        r102.drawBitmap(r100, 0.0f, 0.0f, null);
        unlockCanvasAndPost(r102);
        return 0;
    }

    public float getFloatOption(int r100) {
        switch(r100) {
            case 112: goto L12;
            case 113: goto L10;
            case 114: goto L8;
            case 115: goto L6;
            default: goto L4;
        };
    L4:
        return getFloatOption(r100, -1);
    L6:
        return this.mQuatW;
    L8:
        return this.mQuatZ;
    L10:
        return this.mQuatY;
    L12:
        return this.mQuatX;
    }

    public int getIntOption(int r100) {
        if (r100 == 133) goto L7;
        return getIntOption(r100, -1);
    L7:
        return this.mRenderDevice;
    }

    public long getLongOption(int r100) {
        return getLongOption(r100, -1);
    }

    public Object getOption(Bundle r100) {
        VideoSurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.getOption(r100);
    }

    public String getStringOption(int r100) {
        return getStringOption(r100, -1);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r110) {
        switch(r110.what) {
            case 4096: goto L37;
            case 4097: goto L22;
            case 4098: goto L14;
            case 4099: goto L5;
            default: goto L68;
        };
    L5:
        OnDrawFrameAbsListener r100 = this.mOnDrawFrameAbsListener;
        if (r100 != null) goto L8;
        return true;
    L8:
        if (this.mSurfaceTexture == null) goto L69;
        int r101 = r110.arg1;
        int r111 = r110.arg2;
        if (r100 == null) goto L57;
        r100.onSRStateChanged(r101, r111);
        return true;
    L57:
        return true;
    L69:
        return true;
    L68:
        return true;
    L14:
        if (this.mHeadposeChangedListener != null) goto L16;
        return true;
    L16:
        if (this.mSurfaceTexture == null) goto L70;
        Bundle r112 = r110.getData();
        this.mQuatX = r112.getFloat(VideoSurfaceTexture.KEY_QUATERNION_X);
        this.mQuatY = r112.getFloat(VideoSurfaceTexture.KEY_QUATERNION_Y);
        this.mQuatZ = r112.getFloat(VideoSurfaceTexture.KEY_QUATERNION_Z);
        float r113 = r112.getFloat(VideoSurfaceTexture.KEY_QUATERNION_W);
        this.mQuatW = r113;
        OnHeadposeChangedListener r102 = this.mHeadposeChangedListener;
        if (r102 == null) goto L60;
        r102.onHeadposeChanged(new Quaternion(this.mQuatX, this.mQuatY, this.mQuatZ, r113));
        return true;
    L60:
        return true;
    L70:
        return true;
    L22:
        if (this.mSurfaceTexture == null) goto L71;
        int r103 = r110.arg1;
        int r104 = r110.arg2;
        String r114 = r110.obj.toString();
        ArrayList<OnErrorListener> r105 = this.mErrorListeners;
        if (r105 == null) goto L30;
        Iterator<OnErrorListener> r106 = r105.iterator();
    L28:
        if (r106.hasNext() == false) goto L30;
        r106.next().onError(r103);
    L30:
        ArrayList<OnErrorListenerExt> r107 = this.mErrorListenerExts;
        if (r107 == null) goto L62;
        Iterator<OnErrorListenerExt> r108 = r107.iterator();
    L34:
        if (r108.hasNext() == false) goto L73;
        r108.next().onError(r103, r104, r114);
        goto L34
    L73:
        return true;
    L62:
        return true;
    L71:
        return true;
    L37:
        if (this.mDrawFrameListener == null) goto L63;
        VideoSurfaceTexture r109 = this.mSurfaceTexture;
        if (r109 == null) goto L72;
        int r115 = r110.arg1;
        int r116 = r109.getSerial();
        if (r115 == r116) goto L44;
        TextureRenderLog.i(this.mTexType, this.TAG, "serial change :" + r115 + ", " + r116);
        return true;
    L44:
        Bundle r117 = r110.getData();
        long r118 = r117.getLong(VideoSurfaceTexture.KEY_TIME);
        if (r117.getParcelable("surface") != null) goto L49;
        this.mQuatX = r117.getFloat(VideoSurfaceTexture.KEY_QUATERNION_X);
        this.mQuatY = r117.getFloat(VideoSurfaceTexture.KEY_QUATERNION_Y);
        this.mQuatZ = r117.getFloat(VideoSurfaceTexture.KEY_QUATERNION_Z);
        this.mQuatW = r117.getFloat(VideoSurfaceTexture.KEY_QUATERNION_W);
        OnDrawFrameListener r119 = this.mDrawFrameListener;
        if (r119 == null) goto L65;
        r119.onDraw(r118);
        return true;
    L65:
        return true;
    L49:
        Surface r120 = (Surface) r117.getParcelable("surface");
        OnExtraSurfaceDrawListener r121 = this.mExtraSurfaceDrawFrameListener;
        if (r121 == null) goto L67;
        r121.onExtraSurfaceDraw(r120, r118);
        return true;
    L67:
        return true;
    L72:
        return true;
    L63:
        return true;
    }

    public void ignoreSRResolutionCheck(boolean r100) {
        VideoSurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 == null) goto L6;
        r101.ignoreSRResolutionCheck(r100);
        return;
    }

    public boolean onTouchEvent(MotionEvent r100) {
        VideoSurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.onTouchEvent(r100);
    }

    public void pause(boolean r100) {
        VideoSurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 == null) goto L6;
        r101.pause(r100, true);
        return;
    }

    public void resetSurface(Surface r100) {
        VideoSurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 == null) goto L6;
        r101.resetSurface(r100);
        return;
    }

    public void setCallbackDirectly(boolean r100) {
        this.mCallbackDirectly = r100;
    }

    public void setEffect(Bundle r100) {
        VideoSurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 == null) goto L6;
        r101.setEffect(r100);
        return;
    }

    public void setFrameRenderChecker(RenderCheckDispatcher r100) {
        if (r100 == null) goto L4;
        r100.setEnabled(this.mEnableNoRenderCheck);
    L4:
        this.mCheckDispatcher = r100;
        this.mRenderChecker.setCheckDispatcher(r100);
    }

    public void setIsPicoVRScene(boolean r100) {
        VideoSurfaceTexturePicoInterface r101 = this.mSurfaceTexturePicoListener;
        if (r101 == null) goto L6;
        r101.setIsPicoVRScene(r100);
        return;
    }

    public void setLooper(Looper r100) {
        if (r100 == null) goto L5;
        this.mNotifyHandler = new Handler(r100, this);
        return;
    }

    public void setNoRenderListener(OnNoRenderListener r100) {
        this.mRenderChecker.setListener(r100);
    }

    public void setOnDrawFrameAbsListener(OnDrawFrameAbsListener r100) {
        this.mOnDrawFrameAbsListener = r100;
    }

    public void setOnDrawFrameListener(OnDrawFrameListener r100) {
        this.mDrawFrameListener = r100;
    }

    public void setOnErrorListener(OnErrorListener r100) {
        if (this.mErrorListeners != null) goto L6;
        this.mErrorListeners = new ArrayList();
    L6:
        if (this.mErrorListeners.contains(r100) == true) goto L9;
        this.mErrorListeners.add(r100);
        return;
    }

    public void setOnErrorListenerExt(OnErrorListenerExt r100) {
        if (this.mErrorListenerExts != null) goto L6;
        this.mErrorListenerExts = new ArrayList();
    L6:
        if (this.mErrorListenerExts.contains(r100) == true) goto L9;
        this.mErrorListenerExts.add(r100);
        return;
    }

    public void setOnExtraSurfaceDrawListener(OnExtraSurfaceDrawListener r100) {
        this.mExtraSurfaceDrawFrameListener = r100;
    }

    public void setOnHeadposeChangedListener(OnHeadposeChangedListener r100) {
        this.mHeadposeChangedListener = r100;
    }

    public void setOnSetSurfaceListener(OnSetSurfaceListener r100) {
        this.mOnSetSurfaceListener = r100;
    }

    public void setSuperResolutionMode(int r100) {
        VideoSurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 == null) goto L6;
        r101.setSuperResolutionMode(r100);
        return;
    }

    public void updatePicoTextureObjMap(HashMap<Integer, PicoTextureObj> r100) {
        VideoSurfaceTexturePicoInterface r101 = this.mSurfaceTexturePicoListener;
        if (r101 == null) goto L6;
        r101.updatePicoTextureObj(r100);
        return;
    }

    public void updateRenderSurface(Surface r100) {
        OnSetSurfaceListener r101 = this.mOnSetSurfaceListener;
        if (r101 != null) goto L5;
    L7:
        VideoSurfaceTexture r102 = this.mSurfaceTexture;
        if (r102 == null) goto L11;
        r102.updateSurface(r100);
        return;
    L11:
        return;
    L5:
        if (r101.onSetSurface(this, r100) <= 0) goto L7;
    }

    public VideoSurface(VideoSurfaceTexture r100, boolean r101) {
        super(r100);
        this.mSurfaceTexturePicoListener = null;
        this.mOnDrawFrameAbsListener = null;
        this.mErrorListeners = null;
        this.mErrorListenerExts = null;
        this.mTexType = -1;
        this.mQuatX = 0.0f;
        this.mQuatY = 0.0f;
        this.mQuatZ = 0.0f;
        this.mQuatW = 1.0f;
        this.mRenderDevice = -1;
        this.mSurfaceWidth = 0;
        this.mSurfaceHeight = 0;
        this.mCallbackDirectly = false;
        this.TAG = TextureRenderLog.getLogTag(this);
        init(r100, r101);
        this.mReleaseTextureLock = new ReentrantLock();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init(VideoSurfaceTexture r100, boolean r101) {
        this.mSurfaceTexture = r100;
        if (r101 == false) goto L5;
        this.mSurfaceTexturePicoListener = (VideoSurfaceTexturePicoInterface) r100;
    L5:
        if (r100 == 0) goto L8;
        this.mTexType = r100.texType();
    L8:
        if (Looper.myLooper() == null) goto L10;
        this.mNotifyHandler = new Handler(this);
    L11:
        this.mHandlerObject = new Object();
        this.mMsgObjectBundle = new Bundle();
        this.mRenderChecker = new FrameRenderChecker(this.mCheckDispatcher, r100);
        return;
    L10:
        this.mNotifyHandler = new Handler(Looper.getMainLooper(), this);
        goto L11
    }

    public int drawFrame(HardwareBuffer r100, int[] r101) {
        VideoSurfaceTexture r102 = this.mSurfaceTexture;
        if (r102 != null) goto L6;
        return -1;
    L6:
        TextureRenderer r103 = this.mTextureRender;
        if (r103 != null) goto L9;
    L12:
        r102.onFrameAvailable(r100, r101);
        return 0;
    L9:
        if (this.mHasGLContextAttached == false) goto L12;
        return r103.handleHardwareBufferDirectly(r102, r100, r101);
    }

    public float getFloatOption(int r100, int r101) {
        VideoSurfaceTexture r102 = this.mSurfaceTexture;
        if (r102 != null) goto L5;
        return 0.0f;
    L5:
        return r102.getFloatOption(r100, r101);
    }

    public int getIntOption(int r100, int r101) {
        VideoSurfaceTexture r102 = this.mSurfaceTexture;
        if (r102 != null) goto L5;
        return -1;
    L5:
        return r102.getIntOption(r100, r101);
    }

    public long getLongOption(int r100, int r101) {
        VideoSurfaceTexture r102 = this.mSurfaceTexture;
        if (r102 != null) goto L5;
        return -1;
    L5:
        return r102.getLongOption(r100, r101);
    }

    public String getStringOption(int r100, int r101) {
        if (r100 == 119) goto L10;
        VideoSurfaceTexture r102 = this.mSurfaceTexture;
        if (r102 != null) goto L7;
        return "";
    L7:
        return r102.getStringOption(r100, r101);
    L10:
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.ss.texturerender.VideoSurfaceTexture.TextureDrawCallback
    public void onSRStateChange(int r100, int r101) {
        if (this.mOnDrawFrameAbsListener != null) goto L5;
        return;
    L5:
        Object r102 = this.mHandlerObject;
        monitor-enter(r102);
        Message r103 = this.mNotifyHandler.obtainMessage(4099);     // Catch: Throwable -> L13
        r103.arg1 = r100;     // Catch: Throwable -> L13
        r103.arg2 = r101;     // Catch: Throwable -> L13
        if (this.mCallbackDirectly == false) goto L10;
        handleMessage(r103);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r102);     // Catch: Throwable -> L13
        return;
    L10:
        r103.sendToTarget();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.texturerender.VideoSurfaceTexture.TextureDrawCallback
    public void onTextureUpdate(int r100, long r101) {
        if (this.mDrawFrameListener != null) goto L5;
        return;
    L5:
        Object r102 = this.mHandlerObject;
        monitor-enter(r102);
        Message r103 = this.mNotifyHandler.obtainMessage(4096);     // Catch: Throwable -> L13
        this.mMsgObjectBundle.putLong(VideoSurfaceTexture.KEY_TIME, r101);     // Catch: Throwable -> L13
        r103.arg1 = r100;     // Catch: Throwable -> L13
        r103.setData(this.mMsgObjectBundle);     // Catch: Throwable -> L13
        if (this.mCallbackDirectly == false) goto L10;
        handleMessage(r103);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r102);     // Catch: Throwable -> L13
        return;
    L10:
        r103.sendToTarget();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public Bitmap saveFrame(Bundle r100, SaveFrameCallback r101) {
        VideoSurfaceTexture r102 = this.mSurfaceTexture;
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.saveFrame(r100, r101);
    }

    public void setDefaultSize(int r100, int r101) {
        VideoSurfaceTexture r102 = this.mSurfaceTexture;
        if (r102 == null) goto L6;
        r102.setDefaultBufferSize(r100, r101);
        return;
    }

    public void setExtraRenderSurface(Surface r100, int r101) {
        VideoSurfaceTexture r102 = this.mSurfaceTexture;
        if (r102 == null) goto L6;
        r102.setExtraSurface(r100, r101);
        return;
    }

    public void setFloatOption(int r100, float r101) {
        VideoSurfaceTexture r102 = this.mSurfaceTexture;
        if (r102 == null) goto L6;
        r102.setOption(r100, r101);
        return;
    }

    public void setIntOption(int r100, int r101) {
        boolean r102 = true;
        if (r100 != 1) goto L5;
        VideoSurfaceTexture r103 = this.mSurfaceTexture;
        if (r103 == null) goto L37;
        r103.updateVideoState(r101);
        return;
    L37:
        return;
    L5:
        if (r100 == 133) goto L23;
        if (r100 != 33) goto L9;
        if (r101 != 1) goto L21;
        this.mRenderChecker.start();
        return;
    L21:
        this.mRenderChecker.stop();
        return;
    L9:
        if (r100 == 34) goto L13;
        VideoSurfaceTexture r104 = this.mSurfaceTexture;
        if (r104 == null) goto L29;
        r104.setOption(r100, r101);
        return;
    L29:
        return;
    L13:
        if (r101 == 1) goto L16;
        r102 = false;
    L16:
        this.mEnableNoRenderCheck = r102;
        RenderCheckDispatcher r105 = this.mCheckDispatcher;
        if (r105 == null) goto L31;
        r105.setEnabled(r102);
        return;
    L31:
        return;
    L23:
        if (this.mRenderDevice == 1) goto L35;
        this.mRenderDevice = r101;
        TextureRenderLog.i(this.mTexType, this.TAG, "render device:" + this.mRenderDevice);
        return;
    }

    public void setObjectOption(int r100, Object r101) {
        VideoSurfaceTexture r102 = this.mSurfaceTexture;
        if (r102 == null) goto L6;
        r102.setOption(r100, r101);
        return;
    }

    public void setSurfaceDimensions(int r100, int r101) {
        this.mSurfaceWidth = r100;
        this.mSurfaceHeight = r101;
        VideoSurfaceTexture r102 = this.mSurfaceTexture;
        if (r102 == null) goto L5;
        r102.mNeedCheckGeome = true;
    L5:
        TextureRenderLog.d(this.mTexType, this.TAG, "setSurfaceDimensions,W:" + r100 + ",H:" + r101);
    }

    public boolean supportProcessResolution(int r100, int r101) {
        VideoSurfaceTexture r102 = this.mSurfaceTexture;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.supportProcessResolution(r100, r101);
    }

    public void updateTexDimension(int r100, int r101) {
        VideoSurfaceTexture r102 = this.mSurfaceTexture;
        if (r102 == null) goto L6;
        r102.updateTexDimension(r100, r101);
        r102.mNeedCheckGeome = true;
        return;
    }

    public void frameMetaCallback(long r100, long r101, Map<Integer, String> r110) {
        VideoSurfaceTexture r102 = this.mSurfaceTexture;
        if (r102 == null) goto L6;
        r102.frameMetaCallback(r100, r101, r110);
        return;
    }

    @Override // com.ss.texturerender.VideoSurfaceTexture.TextureErrorCallback
    public void onTextureRenderError(int r100, int r101, String r102) {
        ArrayList<OnErrorListener> r103 = this.mErrorListeners;
        if (r103 != null) goto L5;
    L6:
        ArrayList<OnErrorListenerExt> r104 = this.mErrorListenerExts;
        if (r104 != null) goto L9;
        return;
    L9:
        if (r104.isEmpty() == true) goto L25;
    L11:
        Object r105 = this.mHandlerObject;
        monitor-enter(r105);
        Message r106 = this.mNotifyHandler.obtainMessage(4097, r100, r101, r102);     // Catch: Throwable -> L19
        if (this.mCallbackDirectly == false) goto L16;
        handleMessage(r106);     // Catch: Throwable -> L19
    L17:
        monitor-exit(r105);     // Catch: Throwable -> L19
        return;
    L16:
        r106.sendToTarget();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    L25:
        return;
    L5:
        if (r103.isEmpty() == false) goto L11;
        goto L6
    }

    @Override // com.ss.texturerender.VideoSurfaceTexture.TextureDrawCallback
    public void onTextureUpdate(int r100, Surface r101, long r102) {
        if (this.mDrawFrameListener != null) goto L5;
        return;
    L5:
        Object r103 = this.mHandlerObject;
        monitor-enter(r103);
        Message r104 = this.mNotifyHandler.obtainMessage(4096);     // Catch: Throwable -> L13
        Bundle r105 = new Bundle();     // Catch: Throwable -> L13
        r105.putLong(VideoSurfaceTexture.KEY_TIME, r102);     // Catch: Throwable -> L13
        r105.putParcelable("surface", r101);     // Catch: Throwable -> L13
        r104.arg1 = r100;     // Catch: Throwable -> L13
        r104.setData(r105);     // Catch: Throwable -> L13
        if (this.mCallbackDirectly == false) goto L10;
        handleMessage(r104);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r103);     // Catch: Throwable -> L13
        return;
    L10:
        r104.sendToTarget();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public void setSuperResolutionInitConfig(int r100, String r110, String r111, String r112) {
        VideoSurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 == null) goto L6;
        r101.setSuperResolutionConfig(r100, r110, r111, r112, 0, 0, null);
        return;
    }

    public void updateVRQuaternion(float r100, float r101, float r102, float r103) {
        PicoQuaternion.updateVRCameraForaward(r100, r101, r102, r103);
    }

    public void onHeadposeChanged(int r100, float r101, float r102, float r103, float r104) {
        if (this.mHeadposeChangedListener != null) goto L5;
        return;
    L5:
        Object r105 = this.mHandlerObject;
        monitor-enter(r105);
        Message r106 = this.mNotifyHandler.obtainMessage(4098);     // Catch: Throwable -> L13
        this.mMsgObjectBundle.putFloat(VideoSurfaceTexture.KEY_QUATERNION_X, r101);     // Catch: Throwable -> L13
        this.mMsgObjectBundle.putFloat(VideoSurfaceTexture.KEY_QUATERNION_Y, r102);     // Catch: Throwable -> L13
        this.mMsgObjectBundle.putFloat(VideoSurfaceTexture.KEY_QUATERNION_Z, r103);     // Catch: Throwable -> L13
        this.mMsgObjectBundle.putFloat(VideoSurfaceTexture.KEY_QUATERNION_W, r104);     // Catch: Throwable -> L13
        r106.arg1 = r100;     // Catch: Throwable -> L13
        r106.setData(this.mMsgObjectBundle);     // Catch: Throwable -> L13
        if (this.mCallbackDirectly == false) goto L10;
        handleMessage(r106);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r105);     // Catch: Throwable -> L13
        return;
    L10:
        r106.sendToTarget();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.texturerender.VideoSurfaceTexture.TextureDrawCallback
    public void onTextureUpdate(int r100, float r101, float r102, float r103, float r104) {
        if (this.mDrawFrameListener != null) goto L5;
        return;
    L5:
        Object r105 = this.mHandlerObject;
        monitor-enter(r105);
        Message r106 = this.mNotifyHandler.obtainMessage(4096);     // Catch: Throwable -> L13
        this.mMsgObjectBundle.putFloat(VideoSurfaceTexture.KEY_QUATERNION_X, r101);     // Catch: Throwable -> L13
        this.mMsgObjectBundle.putFloat(VideoSurfaceTexture.KEY_QUATERNION_Y, r102);     // Catch: Throwable -> L13
        this.mMsgObjectBundle.putFloat(VideoSurfaceTexture.KEY_QUATERNION_Z, r103);     // Catch: Throwable -> L13
        this.mMsgObjectBundle.putFloat(VideoSurfaceTexture.KEY_QUATERNION_W, r104);     // Catch: Throwable -> L13
        r106.arg1 = r100;     // Catch: Throwable -> L13
        r106.setData(this.mMsgObjectBundle);     // Catch: Throwable -> L13
        if (this.mCallbackDirectly == false) goto L10;
        handleMessage(r106);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r105);     // Catch: Throwable -> L13
        return;
    L10:
        r106.sendToTarget();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public void updateVRQuaternion(float r100, float r101, float r102, float r103, int r104) {
        PicoQuaternion.updateVRQuaternion(r100, r101, r102, r103, r104);
    }

    public void setSuperResolutionInitConfig(int r100, String r110, String r111, String r112, int r113, int r114) {
        VideoSurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 == null) goto L6;
        r101.setSuperResolutionConfig(r100, r110, r111, r112, r113, r114, null);
        return;
    }

    public void setSuperResolutionInitConfig(int r100, String r110, String r111, String r112, int r113, int r114, String r115) {
        VideoSurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 == null) goto L6;
        r101.setSuperResolutionConfig(r100, r110, r111, r112, r113, r114, r115);
        return;
    }

    public void updateVRQuaternion(float r100, float r101, float r102, float r103, int r104, int[] r105, int r106) {
        PicoQuaternion.updateVRQuaternion(r100, r101, r102, r103, r104);
        PicoQuaternion.updateVRSubIndex(r105, r106);
    }
}
