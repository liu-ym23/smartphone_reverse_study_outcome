package pc1;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class c {

    @SerializedName("BgPushWithAdaptedResolution")
    public boolean bgPushWithAdaptedResolution;

    @SerializedName("cameraSwitchInternal")
    public boolean cameraSwitchInternal;

    @SerializedName("cap_adapted_height")
    public int capAdaptedHeight;

    @SerializedName("cap_adapted_quirks")
    public int capAdaptedQuirks;

    @SerializedName("cap_adapted_width")
    public int capAdaptedWidth;

    @SerializedName("disableUpdateVideoCapture")
    public boolean disableUpdateVideoCapture;

    @SerializedName("enableChooseBestCaptureResolution")
    public boolean enableChooseBestCaptureResolution;

    @SerializedName("forceAlignTo16")
    public boolean forceAlignTo16;

    @SerializedName("fps")
    public int fps;

    @SerializedName("gamma_correction")
    public boolean gammaCorrectionOnExternVideoCapture;

    @SerializedName("height")
    public int height;

    @SerializedName("oneKeyProcess")
    public a oneKeyProcess;

    @SerializedName("restartCameraWhenChangeResolution")
    public boolean restartCameraWhenChangeResolution;

    @SerializedName("video_adapter_crop_mode")
    public int videoAdapterCropMode;

    @SerializedName("videoAlgorithm")
    public int videoAlgorithm;

    @SerializedName("width")
    public int width;

    public static class a {

        @SerializedName("algParams")
        public String algParams;

        @SerializedName("cvdetectFrames")
        public int cvdetectFrames;

        @SerializedName("enableAfs")
        public boolean enableAfs;

        @SerializedName("enableAlgoConfig")
        public boolean enableAlgoConfig;

        @SerializedName("enableAsyncProcess")
        public boolean enableAsyncProcess;

        @SerializedName("enableDayScene")
        public boolean enableDayScene;

        @SerializedName("enableDenoise")
        public boolean enableDenoise;

        @SerializedName("enableHDR")
        public boolean enableHDR;

        @SerializedName("enableHdrV2")
        public boolean enableHdrV2;

        @SerializedName("enableNightScene")
        public boolean enableNightScene;

        @SerializedName("enableOneKeyProcess")
        public boolean enableOneKeyProcess;

        @SerializedName("isFirstFrame")
        public boolean isFirstFrame;

        public a() {
            this.enableOneKeyProcess = false;
            this.enableHDR = true;
            this.enableDenoise = true;
            this.enableAfs = false;
            this.enableHdrV2 = true;
            this.enableAsyncProcess = true;
            this.enableDayScene = true;
            this.enableNightScene = true;
            this.cvdetectFrames = 3;
            this.algParams = "luminance_target_string=175,155\n    & contrast_factor_float=0.3f\n    & saturation_factor_float=0.3f\n    & amount_float=2.f\n    & ratio_float=0.02f\n    & noise_factor_float=1.f\n    & current_pixel_weight_float=0.5f\n    & hdr_version_int=2\n    & luma_trigger_float=37.8\n    & over_trigger_float=-1\n    & under_trigger_float=-1\n    & asf_scene_mode_int=5\"";
            this.isFirstFrame = false;
            this.enableAlgoConfig = true;
        }
    }

    public c() {
        this.width = 0;
        this.height = 0;
        this.bgPushWithAdaptedResolution = true;
        this.videoAlgorithm = Integer.MAX_VALUE;
        this.disableUpdateVideoCapture = true;
        this.enableChooseBestCaptureResolution = false;
        this.restartCameraWhenChangeResolution = true;
        this.gammaCorrectionOnExternVideoCapture = false;
        this.cameraSwitchInternal = true;
        this.fps = 25;
        this.capAdaptedWidth = 0;
        this.capAdaptedHeight = 0;
        this.forceAlignTo16 = true;
        this.videoAdapterCropMode = 0;
        this.capAdaptedQuirks = 1;
        this.oneKeyProcess = new a();
    }
}
