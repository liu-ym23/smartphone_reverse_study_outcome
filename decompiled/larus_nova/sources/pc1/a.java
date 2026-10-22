package pc1;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class a {

    @SerializedName("videoCapture")
    public C7176a videoCapture;

    /* JADX INFO: renamed from: pc1.a$a, reason: collision with other inner class name */
    public static class C7176a {

        @SerializedName("cameraFaceAEStrategy")
        public int cameraFaceAEStrategy;

        @SerializedName("cameraFrameFormat")
        public int cameraFrameFormat;

        @SerializedName("cameraFrameRateStrategy")
        public int cameraFrameRateStrategy;

        @SerializedName("camera_log_level")
        public int cameraLogLevel;

        @SerializedName("cameraMode")
        public int cameraMode;

        @SerializedName("camera_open_retry_cnt")
        public int cameraOpenRetryCount;

        @SerializedName("camera_retry_start_preview_cnt")
        public int cameraRetryStartPreviewCount;

        @SerializedName("cameraType")
        public int cameraType;

        @SerializedName("videoCaptureDevice")
        public int device;

        @SerializedName("enableCallBackStop")
        public boolean enableCallBackStop;

        @SerializedName("enablePreviewTemplate")
        public boolean enableCameraPreviewTemplate;

        @SerializedName("enableCameraStabilization")
        public boolean enableCameraStabilization;

        @SerializedName("enableFallback")
        public boolean enableFallback;

        @SerializedName("enableFrontFacingVideoContinueFocus")
        public boolean enableFrontCameraContinueFocus;

        @SerializedName("enableOpenCamera1Opt")
        public boolean enableOpenCamera1Opt;

        @SerializedName("enableRetryOnceOpenCamera")
        public boolean enableRetryOnceOpenCamera;

        @SerializedName("enableWideAngle")
        public boolean enableWideAngle;

        @SerializedName("enableWideFov")
        public boolean enableWideFov;

        @SerializedName("fixFpsRangeCompareBug")
        public boolean fixFpsRangeCompareBug;

        @SerializedName("videoCaptureFps")
        public int fps;

        @SerializedName("videoCaptureHeight")
        public int height;

        @SerializedName("is_camera_open_close_sync")
        public boolean isCameraOpenCloseSync;

        @SerializedName("isForceCloseCamera")
        public boolean isForceCloseCamera;

        @SerializedName("is_use_hint")
        public boolean isUseHint;

        @SerializedName("videoCaptureMinFps")
        public int minFps;

        @SerializedName("need_oes_to_2d")
        public boolean needOesTo2D;

        @SerializedName("requiredCameraLevel")
        public int requiredCameraLevel;

        @SerializedName("resetFpsRange")
        public boolean resetFpsRange;

        @SerializedName("textureMinFilter")
        public String textureMinFilter;

        @SerializedName("try_delive_frame_with_time")
        public boolean tryDeliverFrameWithTime;

        @SerializedName("useCamera2API")
        public boolean useCamera2Api;

        @SerializedName("using_self_define_timestamp")
        public boolean usingSelfDefineTimeStamp;

        @SerializedName("videoCaptureWidth")
        public int width;

        public C7176a() {
            this.device = 4;
            this.width = 720;
            this.height = 1280;
            this.fps = 30;
            this.enableRetryOnceOpenCamera = false;
            this.minFps = 0;
            this.cameraFrameRateStrategy = 0;
            this.useCamera2Api = false;
            this.cameraType = 0;
            this.enableCameraStabilization = false;
            this.cameraOpenRetryCount = 0;
            this.cameraRetryStartPreviewCount = 0;
            this.resetFpsRange = false;
            this.fixFpsRangeCompareBug = true;
            this.enableWideFov = true;
            this.enableFallback = false;
            this.isForceCloseCamera = false;
            this.isUseHint = false;
            this.cameraFrameFormat = 0;
            this.cameraLogLevel = 0;
            this.isCameraOpenCloseSync = false;
            this.cameraFaceAEStrategy = 0;
            this.enableWideAngle = false;
            this.enableOpenCamera1Opt = false;
            this.requiredCameraLevel = -1;
            this.cameraMode = -1;
            this.enableFrontCameraContinueFocus = true;
            this.enableCameraPreviewTemplate = false;
            this.enableCallBackStop = true;
            this.needOesTo2D = false;
            this.tryDeliverFrameWithTime = false;
            this.usingSelfDefineTimeStamp = false;
        }
    }

    public a() {
        this.videoCapture = new C7176a();
    }
}
