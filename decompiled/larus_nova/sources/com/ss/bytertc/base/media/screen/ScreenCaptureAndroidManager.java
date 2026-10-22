package com.ss.bytertc.base.media.screen;

import android.content.Context;
import android.content.Intent;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.VideoFrame;
import com.ss.bytertc.base.media.CapturerObserver;
import com.ss.bytertc.base.media.SurfaceTextureHelper;
import com.ss.bytertc.base.media.VideoCapturer;
import com.ss.bytertc.base.media.VideoSink;
import com.ss.bytertc.base.media.camera.CameraSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes40.dex */
public class ScreenCaptureAndroidManager implements VideoCapturer, VideoSink {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int DEFAULT_MIN_FRAME_RATE = 4;
    private static final int DISPLAY_FLAGS = 11;
    private static final String TAG = "ScreenCapture";
    private static final int VIRTUAL_DISPLAY_DPI = 400;
    private static final String VIRTUAL_DISPLAY_NAME = "RTCScreenCapture";
    private CapturerObserver capturerObserver;
    private int frameRate;
    private int height;
    private boolean isDisposed;
    private boolean isSurfaceDispose;
    private Context mContext;
    private DeviceOrientation mCurrentOrientation;
    private Display mDisplay;
    private boolean mEnableDoOrientation;
    private int mFrameIndex;
    private Map<Integer, CountDownLatch> mLocks;
    private boolean mPicoCapture2DTexture;
    private boolean mPicoCreateMediaProjection;
    private boolean mPicoNotCheckOrientation;
    private int mPicoVirtualDisplayDpi;
    private int mPicoVirtualDisplayFlag;
    private String mPicoVirtualDisplayName;
    private EglBase.Context mSharedContext;
    private Map<Integer, VideoFrame> mVideoFrames;
    private MediaProjection mediaProjection;
    private MediaProjection.Callback mediaProjectionCallback;
    private MediaProjectionManager mediaProjectionManager;
    private Intent mediaProjectionPermissionResultData;
    private long numCapturedFrames;
    private SurfaceTextureHelper surfaceTextureHelper;
    private VirtualDisplay virtualDisplay;
    private int width;

    public static final enum DeviceOrientation extends Enum<DeviceOrientation> {
        private static final /* synthetic */ DeviceOrientation[] $VALUES = null;
        public static final DeviceOrientation LANDSCAPE = null;
        public static final DeviceOrientation PORTRAIT = null;

        static {
            DeviceOrientation r100 = new DeviceOrientation("PORTRAIT", 0);
            PORTRAIT = r100;
            DeviceOrientation r101 = new DeviceOrientation("LANDSCAPE", 1);
            LANDSCAPE = r101;
            $VALUES = new DeviceOrientation[]{r100, r101};
        }

        public static DeviceOrientation[] values() {
            return (DeviceOrientation[]) $VALUES.clone();
        }

        public static DeviceOrientation valueOf(String r100) {
            return (DeviceOrientation) r27.a.a(DeviceOrientation.class, r100);
        }

        private DeviceOrientation(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class HOLDER {
        private static final ScreenCaptureAndroidManager INSTANCE = null;

        private HOLDER() {
        }

        static {
            INSTANCE = new ScreenCaptureAndroidManager(null);
        }

        public static /* synthetic */ ScreenCaptureAndroidManager access$100() {
            return INSTANCE;
        }
    }

    private boolean updateVirtualDisplayConfig() {
        RXLogging.w(TAG, String.format("[ScreenCapture] updateVirtualDisplayConfig width=%d, height=%d", new Object[]{Integer.valueOf(this.width), Integer.valueOf(this.height)}));
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 34) goto L7;
        RXLogging.w(TAG, String.format("[ScreenCapture] recreate virtual display for android version:%d", new Object[]{Integer.valueOf(r100)}));
        return false;
    L7:
        if (this.mediaProjection != null) goto L11;
        RXLogging.e(TAG, "updateVirtualDisplayConfig failed, mediaProjection is null");
        return false;
    L11:
        if (this.virtualDisplay != null) goto L14;
        RXLogging.e(TAG, "updateVirtualDisplayConfig failed, virtualDisplay is null");
        return false;
    L14:
        SurfaceTextureHelper r101 = this.surfaceTextureHelper;
        if (r101 == null) goto L18;
        r101.stopListening();
        this.surfaceTextureHelper.dispose();
        this.surfaceTextureHelper = null;
    L18:
        if (this.mPicoVirtualDisplayName == null) goto L20;
        int r102 = this.mPicoVirtualDisplayDpi;
    L21:
        this.virtualDisplay.setSurface(null);
        this.virtualDisplay.resize(this.width, this.height, r102);
        SurfaceTextureHelper r103 = SurfaceTextureHelper.create("RXLocalCapturer", this.mSharedContext, false, this.mPicoCapture2DTexture);
        this.surfaceTextureHelper = r103;
        if (r103 != null) goto L28;
        CapturerObserver r104 = this.capturerObserver;
        if (r104 == null) goto L27;
        r104.onCapturerError("surfaceTextureHelper is null.");
    L27:
        throw new RuntimeException("surfaceTextureHelper is null.");
    L28:
        r103.setTextureSize(this.width, this.height);
        this.surfaceTextureHelper.setMinFps(this.frameRate);
        this.virtualDisplay.setSurface(new Surface(this.surfaceTextureHelper.getSurfaceTexture()));
        this.surfaceTextureHelper.startListening(this);
        return true;
    L20:
        r102 = 400;
        goto L21
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void dispose() {
        monitor-enter(this);
        this.isDisposed = true;     // Catch: Throwable -> L11
        if (this.isSurfaceDispose == false) goto L9;
        SurfaceTextureHelper r100 = this.surfaceTextureHelper;     // Catch: Throwable -> L11
        if (r100 == null) goto L9;
        r100.dispose();     // Catch: Throwable -> L11
        this.surfaceTextureHelper = null;     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int enableCameraAutoExposureFaceMode(boolean r100) {
        return -1;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int enableFollowGravity(boolean r100) {
        return -1;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public float getCameraZoomMaxRatio() {
        return 1.0f;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public boolean isCameraExposurePointSupported() {
        return false;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public boolean isCameraFocusPointSupported() {
        return false;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public boolean isCameraTorchSupported() {
        return false;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public boolean isCameraZoomSupported() {
        return false;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public boolean isScreencast() {
        return true;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int setCameraExposureCompensation(float r100) {
        return -1;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int setCameraExposurePoint(float r100, float r101) {
        return -1;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int setCameraFocusPoint(float r100, float r101) {
        return -1;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int setCameraZoomRatio(float r100) {
        return 0;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void stopCapture() {
        monitor-enter(this);
        checkNotDisposed();     // Catch: Throwable -> L6
        ThreadUtils.invokeAtFrontUninterruptibly(this.surfaceTextureHelper.getHandler(), new AnonymousClass1(this));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void turnOffFlashLight() {
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void turnOnFlashLight() {
    }

    private void checkNotDisposed() {
        if (this.isDisposed == true) goto L6;
        return;
    L6:
        throw new RuntimeException("capturer is disposed.");
    }

    private void createVirtualDisplay() {
        if (updateVirtualDisplayConfig() == false) goto L7;
        RXLogging.w(TAG, String.format("[ScreenCapture] call updateVirtualDisplayConfig success, width=%d, height=%d", new Object[]{Integer.valueOf(this.width), Integer.valueOf(this.height)}));
        return;
    L7:
        if (this.mediaProjection != null) goto L11;
        RXLogging.e(TAG, "createVirtualDisplay failed, mediaProjection is null");
        return;
    L11:
        if (this.virtualDisplay == null) goto L13;
        RXLogging.e(TAG, "[ScreenCapture] release current virtualdisplay");
        this.virtualDisplay.release();
        this.virtualDisplay = null;
    L13:
        this.surfaceTextureHelper.setTextureSize(this.width, this.height);
        RXLogging.w(TAG, String.format("[ScreenCapture] call |createVirtualDisplay|,  width=%d, height=%d", new Object[]{Integer.valueOf(this.width), Integer.valueOf(this.height)}));     // Catch: SecurityException -> L24
        String r100 = this.mPicoVirtualDisplayName;     // Catch: SecurityException -> L24
        if (r100 == null) goto L17;
        this.virtualDisplay = this.mediaProjection.createVirtualDisplay(r100, this.width, this.height, this.mPicoVirtualDisplayDpi, this.mPicoVirtualDisplayFlag, new Surface(this.surfaceTextureHelper.getSurfaceTexture()), null, null);     // Catch: SecurityException -> L24
    L19:
        if (this.virtualDisplay != null) goto L30;
        CapturerObserver r101 = this.capturerObserver;     // Catch: SecurityException -> L24
        if (r101 == null) goto L31;
        r101.onCapturerError("create virtual display failed.");     // Catch: SecurityException -> L24
        return;
    L31:
        return;
    L30:
        return;
    L17:
        this.virtualDisplay = this.mediaProjection.createVirtualDisplay(VIRTUAL_DISPLAY_NAME, this.width, this.height, 400, 11, new Surface(this.surfaceTextureHelper.getSurfaceTexture()), null, null);     // Catch: SecurityException -> L24
    L24:
        this.virtualDisplay = null;
        CapturerObserver r102 = this.capturerObserver;
        if (r102 == null) goto L32;
        r102.onCapturerError("create virtual display failed.");
        return;
    }

    private int getDeviceRotation() {
        int r100 = this.mDisplay.getRotation();
        if (r100 != 0) goto L5;
        return 0;
    L5:
        if (r100 != 1) goto L7;
        return 90;
    L7:
        if (r100 != 2) goto L9;
        return 180;
    L9:
        if (r100 == 3) goto L11;
        return 0;
    L11:
        return 270;
    }

    private DeviceOrientation getDisplayOrientation() {
        if (this.mContext.getResources().getConfiguration().orientation != 1) goto L7;
        return DeviceOrientation.PORTRAIT;
    L7:
        return DeviceOrientation.LANDSCAPE;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public void disableDoOrientation() {
        RXLogging.w(TAG, "[ScreenCapture] call |disableDoOrientation|");
        this.mEnableDoOrientation = false;
    }

    private ScreenCaptureAndroidManager() {
        this.mFrameIndex = 0;
        this.mEnableDoOrientation = true;
        this.mPicoNotCheckOrientation = false;
        this.mPicoCreateMediaProjection = false;
        this.mPicoVirtualDisplayName = VIRTUAL_DISPLAY_NAME;
        this.mPicoVirtualDisplayDpi = 400;
        this.mPicoVirtualDisplayFlag = 11;
        this.mPicoCapture2DTexture = false;
        this.mVideoFrames = new HashMap();
        this.mLocks = new HashMap();
    }

    public static ScreenCaptureAndroidManager INSTANCE() {
        return HOLDER.access$100();
    }

    private boolean maybeDoRotation() {
        int r100 = getDeviceRotation();
        DeviceOrientation r101 = getDeviceOrientation(r100);
        DeviceOrientation r102 = getDisplayOrientation();
        if (r102 != this.mCurrentOrientation) goto L5;
        return false;
    L5:
        this.mCurrentOrientation = r102;
        if (this.mEnableDoOrientation == true) goto L9;
        RXLogging.w(TAG, "[ScreenCapture] DoRotation is disabled, ignore the request");
        return false;
    L9:
        RXLogging.w(TAG, String.format("[ScreenCapture] call |maybeDoRotation| and orientation != mCurrentOrientation, rotation:%d, orientation:%s, orientation1:%s", new Object[]{Integer.valueOf(r100), r102.toString(), r101.toString()}));
        rotateCaptureOrientation(r102);
        return true;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public int getDeviceOrientation() {
        return CameraSession.CC.getDeviceUIOrientation(ContextUtils.getApplicationContext());
    }

    static {
    }

    public MediaProjection getMediaProjection() {
        return this.mediaProjection;
    }

    public long getNumCapturedFrames() {
        return this.numCapturedFrames;
    }

    public /* synthetic */ ScreenCaptureAndroidManager(AnonymousClass1 r100) {
        this();
    }

    public static /* synthetic */ SurfaceTextureHelper access$200(ScreenCaptureAndroidManager r100) {
        return r100.surfaceTextureHelper;
    }

    public static /* synthetic */ CapturerObserver access$300(ScreenCaptureAndroidManager r100) {
        return r100.capturerObserver;
    }

    public static /* synthetic */ VirtualDisplay access$400(ScreenCaptureAndroidManager r100) {
        return r100.virtualDisplay;
    }

    public static /* synthetic */ MediaProjection access$500(ScreenCaptureAndroidManager r100) {
        return r100.mediaProjection;
    }

    public static /* synthetic */ MediaProjection.Callback access$600(ScreenCaptureAndroidManager r100) {
        return r100.mediaProjectionCallback;
    }

    public static /* synthetic */ void access$800(ScreenCaptureAndroidManager r100) {
        r100.createVirtualDisplay();
    }

    private DeviceOrientation getDeviceOrientation(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 90) goto L12;
        if (r100 == 180) goto L14;
        if (r100 == 270) goto L12;
        return DeviceOrientation.LANDSCAPE;
    L12:
        return DeviceOrientation.LANDSCAPE;
    L14:
        return DeviceOrientation.PORTRAIT;
    }

    private void rotateCaptureOrientation(DeviceOrientation r100) {
        if (r100 != DeviceOrientation.LANDSCAPE) goto L7;
        if (this.width >= this.height) goto L7;
    L10:
        RXLogging.w(TAG, String.format("[ScreenCapture] call |rotateCaptureOrientation| before(orientation:%s, width:%d, height:%d)", new Object[]{r100.toString(), Integer.valueOf(this.width), Integer.valueOf(this.height)}));
        int r101 = this.width;
        int r102 = this.height;
        this.height = r101;
        this.width = r101 + (r102 - r101);
        RXLogging.w(TAG, String.format("[ScreenCapture] call |rotateCaptureOrientation| after(orientation:%s, width:%d, height:%d)", new Object[]{r100.toString(), Integer.valueOf(this.width), Integer.valueOf(this.height)}));
        return;
    L7:
        if (r100 == DeviceOrientation.PORTRAIT) goto L9;
        return;
    L9:
        if (this.height < this.width) goto L10;
    }

    public int addFrame(VideoFrame r100) {
        int r101 = this.mFrameIndex;
        this.mVideoFrames.put(Integer.valueOf(r101), r100);
        this.mFrameIndex++;
        return r101;
    }

    public synchronized void dispose(int r100) {
        monitor-enter(this);
        CountDownLatch r101 = this.mLocks.remove(Integer.valueOf(r100));     // Catch: Throwable -> L9
        if (r101 == null) goto L6;
        r101.countDown();     // Catch: Throwable -> L9
    L6:
        dispose();     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.base.media.VideoSink
    public void onFrame(VideoFrame r100) {
        if (this.mPicoNotCheckOrientation == false) goto L5;
    L8:
        this.numCapturedFrames++;
        this.capturerObserver.onFrameCaptured(r100);
        return;
    L5:
        if (maybeDoRotation() == false) goto L8;
        createVirtualDisplay();
    }

    public VideoFrame removeFrame(int r100) {
        if (this.mVideoFrames.containsKey(Integer.valueOf(r100)) == true) goto L5;
        return null;
    L5:
        return this.mVideoFrames.remove(Integer.valueOf(r100));
    }

    public static /* synthetic */ VirtualDisplay access$402(ScreenCaptureAndroidManager r100, VirtualDisplay r101) {
        r100.virtualDisplay = r101;
        return r101;
    }

    public static /* synthetic */ MediaProjection access$502(ScreenCaptureAndroidManager r100, MediaProjection r101) {
        r100.mediaProjection = r101;
        return r101;
    }

    public static /* synthetic */ DeviceOrientation access$702(ScreenCaptureAndroidManager r100, DeviceOrientation r101) {
        r100.mCurrentOrientation = r101;
        return r101;
    }

    public void addLock(int r100, CountDownLatch r101) {
        this.mLocks.put(Integer.valueOf(r100), r101);
    }

    public void setData(Intent r100, MediaProjection.Callback r101) {
        this.isDisposed = false;
        this.mediaProjectionPermissionResultData = r100;
        this.mediaProjectionCallback = r101;
        this.mPicoNotCheckOrientation = r100.getBooleanExtra(RXScreenCaptureService.KEY_PICO_NOT_CHECK_ORIENTATION, false);
        this.mPicoCreateMediaProjection = r100.getBooleanExtra(RXScreenCaptureService.KEY_PICO_CREATE_MEDIA_PROJECTION, false);
        this.mPicoVirtualDisplayName = r100.getStringExtra(RXScreenCaptureService.KEY_PICO_VIRTUAL_DISPLAY_NAME);
        this.mPicoVirtualDisplayDpi = r100.getIntExtra(RXScreenCaptureService.KEY_PICO_VIRTUAL_DISPLAY_DPI, 400);
        this.mPicoVirtualDisplayFlag = r100.getIntExtra(RXScreenCaptureService.KEY_PICO_VIRTUAL_DISPLAY_FLAG, 11);
        this.mPicoCapture2DTexture = r100.getBooleanExtra(RXScreenCaptureService.KEY_PICO_NEED_CAPTURE_2D_TEXTURE, false);
    }

    private static MediaProjection com_ss_bytertc_base_media_screen_ScreenCaptureAndroidManager_android_media_projection_MediaProjectionManager_getMediaProjection(MediaProjectionManager r110, int r111, Intent r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {Integer.valueOf(r111), r210};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(102101);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(102101, "android/media/projection/MediaProjectionManager", "getMediaProjection", r110, r101, "android.media.projection.MediaProjection", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (MediaProjection) r107.f474983b;
    L21:
        return r110.getMediaProjection(r111, r210);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void changeCaptureFormat(int r100, int r101, int r102) {
        monitor-enter(this);
        checkNotDisposed();     // Catch: Throwable -> L29
        DisplayMetrics r103 = new DisplayMetrics();     // Catch: Throwable -> L29
        this.mDisplay.getRealMetrics(r103);     // Catch: Throwable -> L29
        if (r100 > 0) goto L7;
        r100 = r103.widthPixels;     // Catch: Throwable -> L29
    L7:
        if (r101 > 0) goto L11;
        r101 = r103.heightPixels;     // Catch: Throwable -> L29
    L11:
        if (r100 == this.width) goto L13;
    L17:
        this.width = r100;     // Catch: Throwable -> L29
        this.height = r101;     // Catch: Throwable -> L29
        if (this.virtualDisplay != null) goto L21;
        monitor-exit(this);
        return;
    L21:
        SurfaceTextureHelper r104 = this.surfaceTextureHelper;     // Catch: Throwable -> L29
        if (r104 != null) goto L26;
        RXLogging.w(TAG, "[ScreenCapture] changeCaptureFormat ignored: surfaceTextureHelper is null");     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L26:
        ThreadUtils.invokeAtFrontUninterruptibly(r104.getHandler(), new AnonymousClass2(this));     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L13:
        if (r101 != this.height) goto L17;
        RXLogging.w(TAG, "[ScreenCapture] call |changeCaptureFormat|, width & height are same as previous, ignore the request");     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L29:
        th = move-exception;
        throw th;
    }

    public synchronized void initialize(EglBase.Context r100, Context r101, CapturerObserver r102) {
        monitor-enter(this);
        checkNotDisposed();     // Catch: Throwable -> L14
        if (r102 == null) goto L13;
        this.capturerObserver = r102;     // Catch: Throwable -> L14
        SurfaceTextureHelper r103 = SurfaceTextureHelper.create("RXLocalCapturer", r100, false, this.mPicoCapture2DTexture);     // Catch: Throwable -> L14
        this.surfaceTextureHelper = r103;     // Catch: Throwable -> L14
        this.isSurfaceDispose = true;     // Catch: Throwable -> L14
        this.mCurrentOrientation = null;     // Catch: Throwable -> L14
        if (r103 == null) goto L10;
        this.frameRate = 4;     // Catch: Throwable -> L14
        this.mSharedContext = r100;     // Catch: Throwable -> L14
        this.mContext = r101;     // Catch: Throwable -> L14
        this.mediaProjectionManager = (MediaProjectionManager) r101.getSystemService("media_projection");     // Catch: Throwable -> L14
        this.mDisplay = ((WindowManager) r101.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L10:
        r102.onCapturerError("surfaceTextureHelper is null.");     // Catch: Throwable -> L14
        throw new RuntimeException("surfaceTextureHelper is null.");     // Catch: Throwable -> L14
    L13:
        throw new RuntimeException("capturerObserver not set.");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void startCapture(int r100, int r101, int r102) {
        monitor-enter(this);
        startCapture(r100, r101, r102, 4);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void initialize(SurfaceTextureHelper r100, Context r101, CapturerObserver r102) {
        monitor-enter(this);
        checkNotDisposed();     // Catch: Throwable -> L14
        if (r102 == null) goto L13;
        this.capturerObserver = r102;     // Catch: Throwable -> L14
        if (r100 == null) goto L10;
        this.surfaceTextureHelper = r100;     // Catch: Throwable -> L14
        this.isSurfaceDispose = false;     // Catch: Throwable -> L14
        this.mCurrentOrientation = null;     // Catch: Throwable -> L14
        this.frameRate = 4;     // Catch: Throwable -> L14
        this.mContext = r101;     // Catch: Throwable -> L14
        this.mediaProjectionManager = (MediaProjectionManager) r101.getSystemService("media_projection");     // Catch: Throwable -> L14
        this.mDisplay = ((WindowManager) r101.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L10:
        r102.onCapturerError("surfaceTextureHelper not set.");     // Catch: Throwable -> L14
        throw new RuntimeException("surfaceTextureHelper not set.");     // Catch: Throwable -> L14
    L13:
        throw new RuntimeException("capturerObserver not set.");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.base.media.VideoCapturer
    public synchronized void startCapture(int r100, int r101, int r102, int r110) {
        monitor-enter(this);
        checkNotDisposed();     // Catch: Throwable -> L34
        RXLogging.w(TAG, String.format("[ScreenCapture] call |startCapture|,  width=%d, height=%d", new Object[]{Integer.valueOf(r100), Integer.valueOf(r101)}));     // Catch: Throwable -> L34
        if (r100 <= 0) goto L7;
        if (r101 <= 0) goto L7;
        this.width = r100;     // Catch: Throwable -> L34
        this.height = r101;     // Catch: Throwable -> L34
    L8:
        maybeDoRotation();     // Catch: Throwable -> L34
        this.mediaProjection = com_ss_bytertc_base_media_screen_ScreenCaptureAndroidManager_android_media_projection_MediaProjectionManager_getMediaProjection(this.mediaProjectionManager, -1, this.mediaProjectionPermissionResultData);     // Catch: Exception -> L12 Throwable -> L34
    L14:
        if (this.mediaProjection == null) goto L16;
    L20:
        MediaProjection r103 = this.mediaProjection;     // Catch: Throwable -> L34
        if (r103 != null) goto L27;
        CapturerObserver r104 = this.capturerObserver;     // Catch: Throwable -> L34
        if (r104 == null) goto L25;
        r104.onCapturerError("no permission to capture the screen video.");     // Catch: Throwable -> L34
    L25:
        monitor-exit(this);
        return;
    L27:
        r103.registerCallback(this.mediaProjectionCallback, this.surfaceTextureHelper.getHandler());     // Catch: Throwable -> L34
        createVirtualDisplay();     // Catch: Throwable -> L34
        this.capturerObserver.onCapturerStarted(true);     // Catch: Throwable -> L34
        SurfaceTextureHelper r105 = this.surfaceTextureHelper;     // Catch: Throwable -> L34
        if (r110 > 0) goto L31;
        r110 = 4;
    L31:
        r105.setMinFps(r110);     // Catch: Throwable -> L34
        this.surfaceTextureHelper.startListening(this);     // Catch: Throwable -> L34
        monitor-exit(this);
        return;
    L16:
        if (this.mPicoCreateMediaProjection == false) goto L20;
        this.mediaProjection = (MediaProjection) MediaProjectionManager.class.getMethod(RXScreenCaptureService.METHOD_PICO_CREATE_MEDIA_PROJECTION, new Class[0]).invoke(this.mediaProjectionManager, new Object[0]);     // Catch: Exception -> L19 Throwable -> L34
    L19:
        this.mediaProjection = null;     // Catch: Throwable -> L34
    L12:
        this.mediaProjection = null;     // Catch: Throwable -> L34
    L7:
        DisplayMetrics r106 = new DisplayMetrics();     // Catch: Throwable -> L34
        this.mDisplay.getRealMetrics(r106);     // Catch: Throwable -> L34
        int r107 = r106.widthPixels;     // Catch: Throwable -> L34
        this.width = r107;     // Catch: Throwable -> L34
        this.height = r106.heightPixels;     // Catch: Throwable -> L34
        RXLogging.w(TAG, String.format("[ScreenCapture] call |startCapture| , get screen real size, width=%d, height=%d", new Object[]{Integer.valueOf(r107), Integer.valueOf(r106.heightPixels)}));     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    }

    public synchronized void startCapture(int r100, int r101, int r102, int r110, MediaProjection r111) {
        monitor-enter(this);
        checkNotDisposed();     // Catch: Throwable -> L22
        RXLogging.w(TAG, String.format("[ScreenCapture] call |startCapture|,  width=%d, height=%d", new Object[]{Integer.valueOf(r100), Integer.valueOf(r101)}));     // Catch: Throwable -> L22
        if (r100 <= 0) goto L7;
        if (r101 <= 0) goto L7;
        this.width = r100;     // Catch: Throwable -> L22
        this.height = r101;     // Catch: Throwable -> L22
    L8:
        maybeDoRotation();     // Catch: Throwable -> L22
        this.mediaProjection = r111;     // Catch: Throwable -> L22
        if (r111 != null) goto L15;
        CapturerObserver r103 = this.capturerObserver;     // Catch: Throwable -> L22
        if (r103 == null) goto L13;
        r103.onCapturerError("no permission to capture the screen video.");     // Catch: Throwable -> L22
    L13:
        monitor-exit(this);
        return;
    L15:
        r111.registerCallback(this.mediaProjectionCallback, this.surfaceTextureHelper.getHandler());     // Catch: Throwable -> L22
        createVirtualDisplay();     // Catch: Throwable -> L22
        this.capturerObserver.onCapturerStarted(true);     // Catch: Throwable -> L22
        if (r110 > 0) goto L19;
        r110 = 4;
    L19:
        this.frameRate = r110;     // Catch: Throwable -> L22
        this.surfaceTextureHelper.setMinFps(r110);     // Catch: Throwable -> L22
        this.surfaceTextureHelper.startListening(this);     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L7:
        DisplayMetrics r104 = new DisplayMetrics();     // Catch: Throwable -> L22
        this.mDisplay.getRealMetrics(r104);     // Catch: Throwable -> L22
        int r105 = r104.widthPixels;     // Catch: Throwable -> L22
        this.width = r105;     // Catch: Throwable -> L22
        this.height = r104.heightPixels;     // Catch: Throwable -> L22
        RXLogging.w(TAG, String.format("[ScreenCapture] call |startCapture with MediaProjection| , get screen real size, width=%d, height=%d", new Object[]{Integer.valueOf(r105), Integer.valueOf(r104.heightPixels)}));     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }
}
