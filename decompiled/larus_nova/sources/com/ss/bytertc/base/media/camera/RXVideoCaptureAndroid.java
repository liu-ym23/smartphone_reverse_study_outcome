package com.ss.bytertc.base.media.camera;

import android.content.Intent;
import android.hardware.Camera;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.video.EglBase;
import com.ss.bytertc.base.media.CapturerObserver;
import com.ss.bytertc.base.media.RXNativeFunctions;
import com.ss.bytertc.base.media.SurfaceTextureHelper;
import com.ss.bytertc.base.media.VideoCapturer;
import com.ss.bytertc.base.media.screen.ScreenCapturerAndroid;

/* JADX INFO: loaded from: classes40.dex */
public class RXVideoCaptureAndroid {
    private static final String TAG = "RXVideoCaptureAndroid";
    private final int UIDeviceOrientationLandscapeLeft;
    private final int UIDeviceOrientationLandscapeRight;
    private final int UIDeviceOrientationPortrait;
    private final int UIDeviceOrientationPortraitUpsidedown;
    private EglBase cameraEglBase;
    private CapturerObserver localCapturerObserver;
    private CameraVideoCapturer.CameraEventsHandler mCameraEventsHandler;
    private int mCaptureBufferType;
    private Intent mCaptureScreenIntent;
    private int mHeight;
    private boolean mIsCaptureScreen;
    private boolean mIsFrontCamera;
    private boolean mIsVideoCaptureInited;
    private boolean mIsVideoCaptureWorking;
    private long mNativeCaptureObserver;
    private SurfaceTextureHelper mSurfaceTextureHelper;
    private VideoCapturer mVideoCapturer;
    private int mWidth;
    private EglBase.Context sharedEglGroup;

    public class BufferType {
        public static final int BYTE_BUFFER = 1;
        public static final int TEXTURE_BUFFER = 0;
        final /* synthetic */ RXVideoCaptureAndroid this$0;

        public BufferType(RXVideoCaptureAndroid r100) {
            this.this$0 = r100;
        }
    }

    private boolean isCaptureToTextureSupported() {
        return true;
    }

    public int getCameraFace() {
        if (this.mIsFrontCamera == false) goto L6;
        return 1;
    L6:
        return 0;
    }

    public float getCameraZoomMaxRatio() {
        VideoCapturer r100 = this.mVideoCapturer;
        if (r100 != null) goto L5;
        return -1.0f;
    L5:
        if (this.mIsVideoCaptureInited == true) goto L7;
        return -1.0f;
    L7:
        if (this.mIsVideoCaptureWorking == true) goto L9;
        return -1.0f;
    L9:
        return r100.getCameraZoomMaxRatio();
    }

    public int getDeviceOrientation() {
        VideoCapturer r100 = this.mVideoCapturer;
        if (r100 == null) goto L11;
        if (this.mIsVideoCaptureInited == false) goto L11;
        if (this.mIsVideoCaptureWorking == false) goto L11;
        return r100.getDeviceOrientation();
    L11:
        return getUIOrientation();
    }

    public boolean isCameraExposurePointSupported() {
        VideoCapturer r100 = this.mVideoCapturer;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (this.mIsVideoCaptureInited == true) goto L7;
        return false;
    L7:
        if (this.mIsVideoCaptureWorking == true) goto L9;
        return false;
    L9:
        return r100.isCameraExposurePointSupported();
    }

    public boolean isCameraFocusPointSupported() {
        VideoCapturer r100 = this.mVideoCapturer;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (this.mIsVideoCaptureInited == true) goto L7;
        return false;
    L7:
        if (this.mIsVideoCaptureWorking == true) goto L9;
        return false;
    L9:
        return r100.isCameraZoomSupported();
    }

    public boolean isCameraTorchSupported() {
        VideoCapturer r100 = this.mVideoCapturer;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (this.mIsVideoCaptureInited == true) goto L7;
        return false;
    L7:
        if (this.mIsVideoCaptureWorking == true) goto L9;
        return false;
    L9:
        return r100.isCameraTorchSupported();
    }

    public boolean isCameraZoomSupported() {
        VideoCapturer r100 = this.mVideoCapturer;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (this.mIsVideoCaptureInited == true) goto L7;
        return false;
    L7:
        if (this.mIsVideoCaptureWorking == true) goto L9;
        return false;
    L9:
        return r100.isCameraZoomSupported();
    }

    public void release() {
        if (this.mVideoCapturer == null) goto L5;
        stopCapture();
        this.mVideoCapturer.dispose();
        this.mVideoCapturer = null;
    L5:
        EglBase r100 = this.cameraEglBase;
        if (r100 == null) goto L8;
        r100.release();
        this.cameraEglBase = null;
    L8:
        SurfaceTextureHelper r101 = this.mSurfaceTextureHelper;
        if (r101 == null) goto L11;
        r101.dispose();
        this.mSurfaceTextureHelper = null;
    L11:
        this.mIsVideoCaptureInited = false;
        this.mIsVideoCaptureWorking = false;
        this.sharedEglGroup = null;
        this.mCaptureScreenIntent = null;
    }

    public void stopCapture() {
        RXLogging.w(TAG, "stopCapture...");
        VideoCapturer r100 = this.mVideoCapturer;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mIsVideoCaptureInited == true) goto L7;
        return;
    L7:
        if (this.mIsVideoCaptureWorking == false) goto L17;
        r100.stopCapture();     // Catch: InterruptedException -> L10
        this.mIsVideoCaptureWorking = false;     // Catch: InterruptedException -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void switchCamera() {
        VideoCapturer r100 = this.mVideoCapturer;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mIsVideoCaptureInited == true) goto L8;
        return;
    L8:
        if ((r100 instanceof CameraVideoCapturer) == false) goto L12;
        this.mIsFrontCamera = !this.mIsFrontCamera;
        ((CameraVideoCapturer) r100).switchCamera(new AnonymousClass2(this));
        return;
    }

    public void turnOffFlashLight() {
        VideoCapturer r100 = this.mVideoCapturer;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mIsVideoCaptureInited == true) goto L7;
        return;
    L7:
        if (this.mIsVideoCaptureWorking == false) goto L12;
        r100.turnOffFlashLight();
        return;
    }

    public void turnOnFlashLight() {
        VideoCapturer r100 = this.mVideoCapturer;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mIsVideoCaptureInited == true) goto L7;
        return;
    L7:
        if (this.mIsVideoCaptureWorking == false) goto L12;
        r100.turnOnFlashLight();
        return;
    }

    public static int[] getCameraSensorOrientations() {
        int r100 = Camera.getNumberOfCameras();
        if (r100 > 0) goto L6;
        RXLogging.w(TAG, "getNumberOfCameras failed on count " + r100);
        return null;
    L6:
        int[] r101 = new int[r100];
        Camera.CameraInfo r102 = new Camera.CameraInfo();
        int r103 = 0;
    L7:
        if (r103 >= r100) goto L13;
        Camera.getCameraInfo(r103, r102);     // Catch: Exception -> L10
        r101[r103] = r102.orientation;     // Catch: Exception -> L10
        r103 = r103 + 1;
    L10:
        e = move-exception;
        RXLogging.w(TAG, "getCameraInfo failed on index " + r103 + ',' + e.getMessage());
        return null;
    L13:
        return r101;
    }

    public int getUIOrientation() {
        int r100 = ((WindowManager) ContextUtils.getApplicationContext().getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay().getRotation();
        if (r100 != 1) goto L5;
        return 270;
    L5:
        if (r100 != 2) goto L7;
        return 180;
    L7:
        if (r100 == 3) goto L10;
        return 0;
    L10:
        return 90;
    }

    public static /* synthetic */ long access$000(RXVideoCaptureAndroid r100) {
        return r100.mNativeCaptureObserver;
    }

    public static boolean isFrontCamera(int r100) {
        Camera.CameraInfo r101 = new Camera.CameraInfo();
        Camera.getCameraInfo(r100, r101);     // Catch: Exception -> L8
        if (r101.facing != 1) goto L7;
        return true;
    L7:
        return false;
    L8:
        e = move-exception;
        RXLogging.w(TAG, "getCameraInfo failed on index " + r100 + ',' + e.getMessage());
        return false;
    }

    public int enableCameraAutoExposureFaceMode(boolean r100) {
        VideoCapturer r101 = this.mVideoCapturer;
        if (r101 != null) goto L5;
        return -1;
    L5:
        if (this.mIsVideoCaptureInited == true) goto L7;
        return -1;
    L7:
        if (this.mIsVideoCaptureWorking == true) goto L9;
        return -1;
    L9:
        return r101.enableCameraAutoExposureFaceMode(r100);
    }

    public int enableFollowGravity(boolean r100) {
        VideoCapturer r101 = this.mVideoCapturer;
        if (r101 != null) goto L5;
        return 0;
    L5:
        if (this.mIsVideoCaptureInited == true) goto L7;
        return 0;
    L7:
        if (this.mIsVideoCaptureWorking == true) goto L9;
        return 0;
    L9:
        return r101.enableFollowGravity(r100);
    }

    public int setCameraExposureCompensation(float r100) {
        VideoCapturer r101 = this.mVideoCapturer;
        if (r101 != null) goto L5;
        return -1;
    L5:
        if (this.mIsVideoCaptureInited == true) goto L7;
        return -1;
    L7:
        if (this.mIsVideoCaptureWorking == true) goto L9;
        return -1;
    L9:
        return r101.setCameraExposureCompensation(r100);
    }

    public int setCameraZoomRatio(float r100) {
        VideoCapturer r101 = this.mVideoCapturer;
        if (r101 != null) goto L5;
        return -1;
    L5:
        if (this.mIsVideoCaptureInited == true) goto L7;
        return -1;
    L7:
        if (this.mIsVideoCaptureWorking == true) goto L9;
        return -1;
    L9:
        return r101.setCameraZoomRatio(r100);
    }

    public static /* synthetic */ boolean access$102(RXVideoCaptureAndroid r100, boolean r101) {
        r100.mIsFrontCamera = r101;
        return r101;
    }

    public int setCameraExposurePoint(float r100, float r101) {
        VideoCapturer r102 = this.mVideoCapturer;
        if (r102 != null) goto L5;
        return -1;
    L5:
        if (this.mIsVideoCaptureInited == true) goto L7;
        return -1;
    L7:
        if (this.mIsVideoCaptureWorking == true) goto L9;
        return -1;
    L9:
        return r102.setCameraExposurePoint(r100, r101);
    }

    public float setCameraFocusPoint(float r100, float r101) {
        VideoCapturer r102 = this.mVideoCapturer;
        if (r102 != null) goto L5;
        return -1.0f;
    L5:
        if (this.mIsVideoCaptureInited == true) goto L7;
        return -1.0f;
    L7:
        if (this.mIsVideoCaptureWorking == true) goto L9;
        return -1.0f;
    L9:
        return r102.setCameraFocusPoint(r100, r101);
    }

    public RXVideoCaptureAndroid(boolean r100, long r101, EglBase.Context r102) {
        this.mVideoCapturer = null;
        this.mCameraEventsHandler = null;
        this.mIsFrontCamera = true;
        this.mIsVideoCaptureInited = false;
        this.mIsVideoCaptureWorking = false;
        this.mIsCaptureScreen = false;
        this.mWidth = 0;
        this.mHeight = 0;
        this.cameraEglBase = null;
        this.sharedEglGroup = null;
        this.mCaptureScreenIntent = null;
        this.UIDeviceOrientationPortrait = 0;
        this.UIDeviceOrientationLandscapeLeft = 90;
        this.UIDeviceOrientationPortraitUpsidedown = 180;
        this.UIDeviceOrientationLandscapeRight = 270;
        this.localCapturerObserver = new AnonymousClass1(this);
        RXLogging.w(TAG, "RXVideoCaptureAndroid Created, CaptureScreen=" + r100);
        this.mIsCaptureScreen = r100;
        this.mNativeCaptureObserver = r101;
        this.sharedEglGroup = r102;
    }

    private VideoCapturer createVideoCapturer(boolean r100, Intent r110, int r111) {
        if (r100 == true) goto L5;
        boolean r101 = true;
        if (this.mCaptureBufferType != 1) goto L9;
    L11:
        r101 = false;
    L12:
        Camera1Enumerator r102 = new Camera1Enumerator(r101, false);     // Catch: IllegalArgumentException -> L28
        String[] r112 = r102.getDeviceNames();     // Catch: IllegalArgumentException -> L28
        if (r112.length <= r111) goto L19;
        if (r111 < 0) goto L19;
        CameraVideoCapturer r103 = r102.createCapturer(r112[r111], this.mCameraEventsHandler);     // Catch: IllegalArgumentException -> L28
        if (r103 == null) goto L19;
        RXLogging.i(TAG, "createVideoCapturer, deviceUniqueId: " + r111);     // Catch: IllegalArgumentException -> L28
        return r103;
    L19:
        RXLogging.w(TAG, "enumerator camera but cannot find a match one, use default. deviceUniqueId: " + r111 + ", deviceNames: " + r112.length);     // Catch: IllegalArgumentException -> L28
        if (r112.length <= 0) goto L25;
        String r113 = r112[0];     // Catch: IllegalArgumentException -> L28
        CameraVideoCapturer r104 = r102.createCapturer(r113, this.mCameraEventsHandler);     // Catch: IllegalArgumentException -> L28
        if (r104 == null) goto L24;
        return r104;
    L24:
        RXLogging.e(TAG, "VideoCapturer first camera create null, name:" + r113);     // Catch: IllegalArgumentException -> L28
    L26:
        RXLogging.e(TAG, "cannot init VideoCapture: ");
        return null;
    L25:
        RXLogging.e(TAG, "num of camera in device is zero");     // Catch: IllegalArgumentException -> L28
        goto L26
    L9:
        if (isCaptureToTextureSupported() == false) goto L11;
    L5:
        return new ScreenCapturerAndroid(r110, new AnonymousClass3(this));
    L28:
        e = move-exception;
        RXLogging.e(TAG, "Create VideoCapture fail : " + e.getMessage());
        return null;
    }

    private void startVideoCapture(int r100, int r101, int r102) {
        RXLogging.w(TAG, String.format("startVideoCapture: width: %d, height: &d, fps: &d", new Object[]{Integer.valueOf(r100), Integer.valueOf(r101), Integer.valueOf(r102)}));
        VideoCapturer r103 = this.mVideoCapturer;
        if (r103 == null) goto L11;
        r103.startCapture(r100, r101, r102);     // Catch: IllegalArgumentException -> L6
        this.mIsVideoCaptureWorking = true;     // Catch: IllegalArgumentException -> L6
        return;
    L6:
        e = move-exception;
        RXLogging.e(TAG, "VideoCapture startCapture fail : " + e.getMessage());
        return;
    }

    public void startCapture(int r100, int r101, int r102, int r103, Intent r104, boolean r105, int r106) {
        RXLogging.w(TAG, "startCapture...");
        this.mWidth = r100;
        this.mHeight = r101;
        this.mCaptureScreenIntent = r104;
        this.mCaptureBufferType = r103;
        if (ContextCompat.checkSelfPermission(ContextUtils.getApplicationContext(), "android.permission.CAMERA") == 0) goto L6;
        RXNativeFunctions.nativeOnCapturerError(this.mNativeCaptureObserver, -100);
        return;
    L6:
        VideoCapturer r107 = this.mVideoCapturer;
        if (r107 == null) goto L9;
        r107.dispose();
        this.mVideoCapturer = null;
        this.mIsVideoCaptureInited = false;
        this.mIsVideoCaptureWorking = false;
    L9:
        this.mVideoCapturer = createVideoCapturer(this.mIsCaptureScreen, this.mCaptureScreenIntent, r106);
        if (this.cameraEglBase != null) goto L13;
        this.cameraEglBase = EglBase.CC.create(this.sharedEglGroup);
    L13:
        if (this.mVideoCapturer != null) goto L15;
        RXLogging.e(TAG, "mVideoCapturer is null...");
    L15:
        SurfaceTextureHelper r108 = SurfaceTextureHelper.create("RXLocalCapturer", this.cameraEglBase.getEglBaseContext());
        this.mSurfaceTextureHelper = r108;
        if (this.mVideoCapturer == null) goto L22;
        if (r108 == null) goto L22;
        r108.setUsedByCamera(true);
        this.mVideoCapturer.initialize(this.mSurfaceTextureHelper, ContextUtils.getApplicationContext(), this.localCapturerObserver);
        this.mIsVideoCaptureInited = true;
        VideoCapturer r109 = this.mVideoCapturer;
        if ((r109 instanceof Camera1Capturer) == false) goto L21;
        ((Camera1Capturer) r109).enableFaceAE(r105);
    L21:
        startVideoCapture(r100, r101, r102);
        return;
    L22:
        this.mIsVideoCaptureInited = false;
        this.mIsVideoCaptureWorking = false;
    }
}
