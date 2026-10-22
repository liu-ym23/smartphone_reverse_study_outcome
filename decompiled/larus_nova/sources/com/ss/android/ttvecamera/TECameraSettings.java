package com.ss.android.ttvecamera;

import android.content.Context;
import android.os.Bundle;
import com.alipay.sdk.m.u.i;
import com.bytedance.android.live.uikit.toast.CustomToast;
import com.bytedance.bpea.basics.Cert;
import com.ss.android.vesdk.VEConfigCenter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class TECameraSettings implements Cloneable {
    public static final int CAMERA_FACING_3RD = 4;
    public static final int CAMERA_FACING_BACK = 0;
    public static final int CAMERA_FACING_FRONT = 1;
    public static final int CAMERA_FACING_PICTURE_ZSL = 9;
    public static final int CAMERA_FACING_REAR_MAIN_FRONT_MAIN = 7;
    public static final int CAMERA_FACING_REAR_MAIN_REAR_TELE = 6;
    public static final int CAMERA_FACING_REAR_MAIN_REAR_WIDE = 5;
    public static final int CAMERA_FACING_SAT = 8;
    public static final int CAMERA_FACING_TELEPHOTO = 3;
    public static final int CAMERA_FACING_WIDE_ANGLE = 2;
    public static final int CAMERA_MODE_AR = 2;
    public static final int CAMERA_MODE_HDR = 3;
    public static final int CAMERA_MODE_IMAGE = 1;
    public static final int CAMERA_MODE_MULTI_CAMERA = 6;
    public static final int CAMERA_MODE_SLOW_MOTION = 5;
    public static final int CAMERA_MODE_SUPERNIGHT = 4;
    public static final int CAMERA_MODE_VIDEO = 0;
    public static final int CAMERA_TYPE_1 = 1;
    public static final int CAMERA_TYPE_2 = 2;
    public static final int CAMERA_TYPE_OGXM_V2 = 8;
    public static final int CameraCaptureYuvDisable = 0;
    public static final int CameraCaptureYuvForAll = 3;
    public static final int CameraCaptureYuvForFront = 1;
    public static final int CameraCaptureYuvForRear = 2;
    public static final int[] CameraHWLevelAndroid2VE = null;
    public static final int[] CameraHWLevelVE2Android = null;
    public static final int DYNAMIC_FRAMERATE = 0;
    public static final int DYNAMIC_FRAMERATE_WITHOUT_SELECT = 3;
    public static final int FIXED_FRAMERATE_FOR_ALL = 1;
    public static final int FIXED_FRAMERATE_FOR_REAR = 2;
    public static final int FLASH_AUTO = 3;
    public static final int FLASH_OFF = 0;
    public static final int FLASH_ON = 1;
    public static final int FLASH_RED_EYE = 4;
    public static final int FLASH_TORCH = 2;
    public static final int FLASH_UNKNOW = -1;
    public static final int FPS_120 = 120;
    public static final int FPS_480 = 480;
    public static final int FPS_60 = 60;
    public static final int FPS_90 = 90;
    public static final int FRAMERATE_FOR_USER = 4;
    public static final int FlashOnRealStrategy = 2;
    public static final int FlashOnSimulatedStrategy = 3;
    public static final int HW_CHECK_LEVEL_3 = 3;
    public static final int HW_CHECK_LEVEL_FULL = 2;
    public static final int HW_CHECK_LEVEL_LEGACY = 0;
    public static final int HW_CHECK_LEVEL_LIMITED = 1;
    public static final byte OPTION_FLAG_CaptureSizeNotEqualPreviewSize = 8;
    public static final byte OPTION_FLAG_DEFAULT = 1;
    public static final byte OPTION_FLAG_FPS_RANGE = 2;
    public static final byte OPTION_FLAG_PICTURE_SIZE = 1;
    public static final int OUTPUT_NV21IMAGE = 2;
    public static final int OUTPUT_SURFACETEXTURE = 1;
    public static final int PreAndMainStrategy = 0;
    public static final String SCENE_MODE_ACTION = "action";
    public static final String SCENE_MODE_AUTO = "auto";
    public static final String SCENE_MODE_BARCODE = "barcode";
    public static final String SCENE_MODE_BEACH = "beach";
    public static final String SCENE_MODE_CANDLELIGHT = "candlelight";
    public static final String SCENE_MODE_FIREWORKS = "fireworks";
    public static final String SCENE_MODE_HDR = "hdr";
    public static final String SCENE_MODE_LANDSCAPE = "landscape";
    public static final String SCENE_MODE_NIGHT = "night";
    public static final String SCENE_MODE_NIGHT_PORTRAIT = "night-portrait";
    public static final String SCENE_MODE_PARTY = "party";
    public static final String SCENE_MODE_PORTRAIT = "portrait";
    public static final String SCENE_MODE_SNOW = "snow";
    public static final String SCENE_MODE_SPORTS = "sports";
    public static final String SCENE_MODE_STEADYPHOTO = "steadyphoto";
    public static final String SCENE_MODE_SUNSET = "sunset";
    public static final String SCENE_MODE_THEATRE = "theatre";
    public static final int TorchFakeStrategy = 1;
    public static final String WHITE_BALANCE_AUTO = "auto";
    public static final String WHITE_BALANCE_CLOUDY_DAYLIGHT = "cloudy-daylight";
    public static final String WHITE_BALANCE_DAYLIGHT = "daylight";
    public static final String WHITE_BALANCE_FLUORESCENT = "fluorescent";
    public static final String WHITE_BALANCE_INCANDESCENT = "incandescent";
    public static final String WHITE_BALANCE_SHADE = "shade";
    public static final String WHITE_BALANCE_TWILIGHT = "twilight";
    public static final String WHITE_BALANCE_WARM_FLUORESCENT = "warm-fluorescent";
    public static final int ZSL_MODE_CAMERA1 = 1;
    public static final int ZSL_MODE_CAMERA2 = 2;
    public static final int ZSL_MODE_CAMERA2_SINGLE_PIC_STREAM = 8;
    public static final int ZSL_MODE_CAMERA2_V2 = 4;
    public static final int ZSL_MODE_NONE = 0;
    public static final String[] sCameraSceneMode = null;
    public final int CAMERA2_PREVIEWING_FAILED_COUNT;
    public ARConfig arConfig;
    public Object customCameraTag;
    public String mAWBValue;
    public boolean mBindSurfaceLifecycleToCamera;
    public int mCamera2RetryCnt;
    public int mCameraCaptureYuvStrategy;
    public ExposureCompensationInfo mCameraECInfo;
    public int mCameraFrameRateStrategy;
    public int mCameraHardwareSupportLevel;
    public boolean mCameraPreviewIndependent;
    public HashMap<TECameraPrivacyCertType, Cert> mCameraPrivacyCertMap;
    public int mCameraType;
    public float mCameraZoomLimitFactor;
    public int mCameraZslStrategy;
    public int mCameraZslStrategyFocusTimeout;
    public int mCaptureFlashStrategy;
    public boolean mCaptureHdr;
    public Context mContext;
    public int mDefaultCameraID;
    public float mDefaultZoomRatio;
    public boolean mDefaultZoomUsingZoomV2;
    public long mDynamicRangeProfile;
    public Set<Long> mDynamicRangeProfiles;
    public boolean mEnableAbortSessionCapture;
    public boolean mEnableAiNightVideo;
    public boolean mEnableBackGroundStrategy;
    public boolean mEnableCamera2DeferredSurface;
    public boolean mEnableCamera2Detect;
    public boolean mEnableCamera2SessionClose;
    public boolean mEnableCameraFpsDoubleCheckInImageMode;
    public boolean mEnableCameraProbCache;
    public boolean mEnableCameraSwitchCamera1Optmize;
    public boolean mEnableCollectCapbilities;
    public boolean mEnableFallBack;
    public boolean mEnableForceCameraCloseOpt;
    public int mEnableGcForCameraMetadataThreshold;
    public boolean mEnableHDR10BitRecord;
    public boolean mEnableHardWareFaceDetect;
    public boolean mEnableManualReleaseCaptureResult;
    public boolean mEnableMonitorGyroscope;
    public boolean mEnableMonitorRuntimeInfo;
    public boolean mEnableOpenCamera1Crs;
    public boolean mEnableOpenCamera1Opt;
    public boolean mEnablePreviewSizeChangeOptimize;
    public boolean mEnablePreviewingFallback;
    public boolean mEnableRecord60Fps;
    public boolean mEnableRecordStream;
    public boolean mEnableRefactorFocusAndMeter;
    public boolean mEnableStabilization;
    private boolean mEnableStopRepeatingBeforeCapture;
    public boolean mEnableSurfaceSharing;
    public boolean mEnableVBoost;
    public boolean mEnableWideFOV;
    public boolean mEnableZsl;
    public Bundle mExtParameters;
    public TEFrameRateRange mFPSRange;
    public int mFacing;
    public boolean mFixGetPictureSize;
    public int mFlashMode;
    public int mFocusTimeoutMS;
    public boolean mForceApplyPictureSize;
    public boolean mForceSwitchEnable;
    public int mFpsMaxLimit;
    public int mHighFPS;
    public boolean mIgnoreCameraResetTaskOnDisconnected;
    public int mImageFormat;
    public boolean mIsCameraOpenCloseSync;
    public boolean mIsForceCloseCamera;
    public boolean mIsGetMetadata;
    public boolean mIsUseHint;
    public int mMaxWidth;
    public float mMaxWidthTakePictureSizeAccuracy;
    public float mMaxZoomRatio;
    public float mMinZoomRatio;
    public int mMode;
    public boolean mOptCameraSceneFps;
    public byte mOptionFlags;
    public int mOutputType;
    public TEFrameSizei mPictureSize;
    public boolean mPreferOpenCameraByCameraId;
    public TEFrameSizei mPreviewSize;
    public TEPreviewSizeStrategy mPreviewSizeStrategy;
    public String mRecordStreamFolderPath;
    public int mRequiredCameraLevel;
    public int mRetryCnt;
    public int mRetryStartPreviewCnt;
    public int mRotation;
    public long mRuntimeInfoMonitorPeriod;
    public String mSceneMode;
    public int mStabilizationMode;
    public boolean mStartRecord;
    public String mStrCameraID;
    public String mStrCustomizedCameraID;
    public boolean mUseMaxWidthTakePicture;
    public boolean mUseSyncModeOnCamera2;
    public int mVBoostTimeoutMS;
    public String mVendorCameraID;
    public TEFrameSizei mVideoSize;
    public boolean mbDualCameraExpansionScheme;
    public int mbEnableCamCloseANROpt;
    public boolean mbEnableCamera2Zsl;
    public boolean mbEnableDynamicSwitch;
    public boolean mbEnablePreviewMetadataCallback;
    public boolean mbEnableTakePicture4VideoMode;
    public boolean mbNeedProxyCameraDevice;
    public int mfnr;

    public static final class ARConfig {
        public AugmentedFaceMode augmentedFaceMode;
        public CloudAnchorMode cloudAnchorMode;
        public DepthMode depthMode;
        public FocusMode focusMode;
        public LightEstimationMode lightEstimationMode;
        public PlaneFindingMode planeFindingMode;

        public static final enum AugmentedFaceMode extends Enum<AugmentedFaceMode> {
            private static final /* synthetic */ AugmentedFaceMode[] $VALUES = null;
            public static final AugmentedFaceMode DISABLED = null;
            public static final AugmentedFaceMode MESH3D = null;

            private static /* synthetic */ AugmentedFaceMode[] $values() {
                return new AugmentedFaceMode[]{DISABLED, MESH3D};
            }

            static {
                DISABLED = new AugmentedFaceMode("DISABLED", 0);
                MESH3D = new AugmentedFaceMode("MESH3D", 1);
                $VALUES = $values();
            }

            public static AugmentedFaceMode[] values() {
                return (AugmentedFaceMode[]) $VALUES.clone();
            }

            public static AugmentedFaceMode valueOf(String r100) {
                return (AugmentedFaceMode) r27.a.a(AugmentedFaceMode.class, r100);
            }

            private AugmentedFaceMode(String r100, int r101) {
                super(r100, r101);
            }
        }

        public static final enum CloudAnchorMode extends Enum<CloudAnchorMode> {
            private static final /* synthetic */ CloudAnchorMode[] $VALUES = null;
            public static final CloudAnchorMode DISABLED = null;
            public static final CloudAnchorMode ENABLED = null;

            private static /* synthetic */ CloudAnchorMode[] $values() {
                return new CloudAnchorMode[]{DISABLED, ENABLED};
            }

            static {
                DISABLED = new CloudAnchorMode("DISABLED", 0);
                ENABLED = new CloudAnchorMode("ENABLED", 1);
                $VALUES = $values();
            }

            public static CloudAnchorMode[] values() {
                return (CloudAnchorMode[]) $VALUES.clone();
            }

            public static CloudAnchorMode valueOf(String r100) {
                return (CloudAnchorMode) r27.a.a(CloudAnchorMode.class, r100);
            }

            private CloudAnchorMode(String r100, int r101) {
                super(r100, r101);
            }
        }

        public static final enum DepthMode extends Enum<DepthMode> {
            private static final /* synthetic */ DepthMode[] $VALUES = null;
            public static final DepthMode AUTOMATIC = null;
            public static final DepthMode DISABLED = null;

            private static /* synthetic */ DepthMode[] $values() {
                return new DepthMode[]{DISABLED, AUTOMATIC};
            }

            static {
                DISABLED = new DepthMode("DISABLED", 0);
                AUTOMATIC = new DepthMode("AUTOMATIC", 1);
                $VALUES = $values();
            }

            public static DepthMode[] values() {
                return (DepthMode[]) $VALUES.clone();
            }

            public static DepthMode valueOf(String r100) {
                return (DepthMode) r27.a.a(DepthMode.class, r100);
            }

            private DepthMode(String r100, int r101) {
                super(r100, r101);
            }
        }

        public static final enum FocusMode extends Enum<FocusMode> {
            private static final /* synthetic */ FocusMode[] $VALUES = null;
            public static final FocusMode AUTO = null;
            public static final FocusMode FIXED = null;

            private static /* synthetic */ FocusMode[] $values() {
                return new FocusMode[]{FIXED, AUTO};
            }

            static {
                FIXED = new FocusMode("FIXED", 0);
                AUTO = new FocusMode("AUTO", 1);
                $VALUES = $values();
            }

            public static FocusMode[] values() {
                return (FocusMode[]) $VALUES.clone();
            }

            public static FocusMode valueOf(String r100) {
                return (FocusMode) r27.a.a(FocusMode.class, r100);
            }

            private FocusMode(String r100, int r101) {
                super(r100, r101);
            }
        }

        public static final enum LightEstimationMode extends Enum<LightEstimationMode> {
            private static final /* synthetic */ LightEstimationMode[] $VALUES = null;
            public static final LightEstimationMode AMBIENT_INTENSITY = null;
            public static final LightEstimationMode DISABLED = null;
            public static final LightEstimationMode ENVIRONMENTAL_HDR = null;

            private static /* synthetic */ LightEstimationMode[] $values() {
                return new LightEstimationMode[]{DISABLED, AMBIENT_INTENSITY, ENVIRONMENTAL_HDR};
            }

            static {
                DISABLED = new LightEstimationMode("DISABLED", 0);
                AMBIENT_INTENSITY = new LightEstimationMode("AMBIENT_INTENSITY", 1);
                ENVIRONMENTAL_HDR = new LightEstimationMode("ENVIRONMENTAL_HDR", 2);
                $VALUES = $values();
            }

            public static LightEstimationMode[] values() {
                return (LightEstimationMode[]) $VALUES.clone();
            }

            public static LightEstimationMode valueOf(String r100) {
                return (LightEstimationMode) r27.a.a(LightEstimationMode.class, r100);
            }

            private LightEstimationMode(String r100, int r101) {
                super(r100, r101);
            }
        }

        public static final enum PlaneFindingMode extends Enum<PlaneFindingMode> {
            private static final /* synthetic */ PlaneFindingMode[] $VALUES = null;
            public static final PlaneFindingMode DISABLED = null;
            public static final PlaneFindingMode HORIZONTAL = null;
            public static final PlaneFindingMode HORIZONTAL_AND_VERTICAL = null;
            public static final PlaneFindingMode VERTICAL = null;

            private static /* synthetic */ PlaneFindingMode[] $values() {
                return new PlaneFindingMode[]{DISABLED, HORIZONTAL, VERTICAL, HORIZONTAL_AND_VERTICAL};
            }

            static {
                DISABLED = new PlaneFindingMode("DISABLED", 0);
                HORIZONTAL = new PlaneFindingMode("HORIZONTAL", 1);
                VERTICAL = new PlaneFindingMode("VERTICAL", 2);
                HORIZONTAL_AND_VERTICAL = new PlaneFindingMode("HORIZONTAL_AND_VERTICAL", 3);
                $VALUES = $values();
            }

            public static PlaneFindingMode[] values() {
                return (PlaneFindingMode[]) $VALUES.clone();
            }

            public static PlaneFindingMode valueOf(String r100) {
                return (PlaneFindingMode) r27.a.a(PlaneFindingMode.class, r100);
            }

            private PlaneFindingMode(String r100, int r101) {
                super(r100, r101);
            }
        }

        public ARConfig() {
            this.augmentedFaceMode = AugmentedFaceMode.DISABLED;
            this.cloudAnchorMode = CloudAnchorMode.DISABLED;
            this.depthMode = DepthMode.DISABLED;
            this.focusMode = FocusMode.FIXED;
            this.lightEstimationMode = LightEstimationMode.DISABLED;
            this.planeFindingMode = PlaneFindingMode.DISABLED;
        }
    }

    public interface ApertureCallback {
        void getApertureRange(float[] r100);
    }

    public interface CameraCapabilitiesForBytebenchCallback {
        void getCameraCapabilities(JSONObject r100);
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface CameraCaptureYuvStrategy {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface CameraFacing {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface CameraFrameRateStrategy {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface CameraType {
    }

    public interface CaptureBufferFrameCallback {
        void onBufferFrameArrived(int r100, int r101, int r102, byte[] r103);

        void onError(Exception r100);
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface CaptureFlashStrategy {
    }

    public static class ExposureCompensationInfo {
        public int exposure;
        public int max;
        public int min;
        public float step;

        public boolean isSupportExposureCompensation() {
            if (this.max > this.min) goto L5;
        L7:
            return false;
        L5:
            if (this.step <= 0.001f) goto L7;
            return true;
        }

        public String toString() {
            return "ExposureCompensationInfo{max = " + this.max + ", exposure = " + this.exposure + ", min = " + this.min + ", step = " + this.step + i.f25855d;
        }

        public ExposureCompensationInfo() {
            this.max = 0;
            this.exposure = 0;
            this.min = 0;
            this.step = 0.0f;
        }
    }

    public interface FOVCallback {
        void getFOV(float[] r100);
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface FPS {
    }

    public static final class Features {
        public static final String CAMERA_FACING = "facing";
        public static final String CAMERA_FOCUS_PARAMETERS = "camera_focus_parameters";
        public static final String CAMERA_HDR_10_BIT_SUPPORTED = "camera_hdr_10_bit_supported";
        public static final String CAMERA_PREVIEW_SIZE = "camera_preview_size";
        public static final String CAMERA_SENSOR_ORIENTATION = "camera_sensor_orientation";
        public static final String CAMERA_SUPPORT_FPS_RANGE = "camera_support_fps_range";
        public static final String CAMERA_TORCH_SUPPORTED = "camera_torch_supported";
        public static final String DEVICE_SHOULD_USE_SHADER_ZOOM = "device_should_use_shader_zoom";
        public static final String DEVICE_SUPPORT_AI_NIGHT_VIDEO = "device_support_ai_night_video";
        public static final String DEVICE_SUPPORT_ANTISHAKE_MODE = "device_support_antishake_mode";
        public static final String DEVICE_SUPPORT_MULTICAMERA_ZOOM = "device_support_multicamera_zoom";
        public static final String DEVICE_SUPPORT_SURPER_STABILIZATION = "support_super_stabilization";
        public static final String DEVICE_SUPPORT_WIDE_ANGLE_MODE = "device_support_wide_angle_mode";
        public static final String SUPPORT_ANTI_SHAKE = "support_anti_shake";
        public static final String SUPPORT_BODY_BEAUTY = "support_body_beauty";
        public static final String SUPPORT_FPS_120 = "support_fps_120";
        public static final String SUPPORT_FPS_480 = "support_fps_480";
        public static final String SUPPORT_FPS_60 = "support_fps_60";
        public static final String SUPPORT_LIGHT_SOFT = "support_light_soft";
        public static final String SUPPORT_PICTURE_SIZES = "support_picture_sizes";
        public static final String SUPPORT_PREVIEW_SIZES = "support_preview_sizes";
        public static final String SUPPORT_TELEPHOTO = "support_telephoto";
        public static final String SUPPORT_VIDEO_SIZES = "support_video_sizes";
        public static final String SUPPORT_WIDE_ANGLE = "support_wide_angle";
        private static final Map<String, Class> sKeyFeatureTypes = null;

        public Features() {
        }

        static {
            HashMap r100 = new HashMap();
            sKeyFeatureTypes = r100;
            r100.put(CAMERA_FACING, Integer.class);
            r100.put(DEVICE_SUPPORT_WIDE_ANGLE_MODE, Integer.class);
            r100.put(DEVICE_SUPPORT_ANTISHAKE_MODE, Integer.class);
            r100.put(DEVICE_SUPPORT_AI_NIGHT_VIDEO, Integer.class);
            r100.put(SUPPORT_LIGHT_SOFT, Boolean.class);
            r100.put(SUPPORT_WIDE_ANGLE, Boolean.class);
            r100.put(SUPPORT_TELEPHOTO, Boolean.class);
            r100.put(SUPPORT_BODY_BEAUTY, Boolean.class);
            r100.put(SUPPORT_ANTI_SHAKE, Boolean.class);
            r100.put(SUPPORT_FPS_480, Boolean.class);
            r100.put(SUPPORT_FPS_120, Boolean.class);
            r100.put(SUPPORT_FPS_60, Boolean.class);
            r100.put(SUPPORT_PREVIEW_SIZES, ArrayList.class);
            r100.put(SUPPORT_PICTURE_SIZES, ArrayList.class);
            r100.put(CAMERA_PREVIEW_SIZE, TEFrameSizei.class);
            r100.put(CAMERA_FOCUS_PARAMETERS, TEFocusParameters.class);
            r100.put(CAMERA_TORCH_SUPPORTED, Boolean.class);
            r100.put(SUPPORT_VIDEO_SIZES, ArrayList.class);
            r100.put(CAMERA_SUPPORT_FPS_RANGE, ArrayList.class);
            r100.put(DEVICE_SHOULD_USE_SHADER_ZOOM, Boolean.class);
            r100.put(DEVICE_SUPPORT_MULTICAMERA_ZOOM, Boolean.class);
        }

        public static Class getFeatureType(String r100) {
            Map<String, Class> r101 = sKeyFeatureTypes;
            if (r101.containsKey(r100) == true) goto L7;
            return null;
        L7:
            return r101.get(r100);
        }
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface FlashMode {
    }

    public interface ISOCallback {
        void getCurrentISO(int r100);
    }

    public interface ISORangeCallback {
        void getISORange(int[] r100);
    }

    public interface ManualFocusCallback {
        void getManualFocusAbility(float r100);
    }

    public static class Operation {
        public static final int SLOW_MOTION_RECORD = 1;
        public static final int UPDATE_CAMERA_ORIENTATION = 2;
        private int mType;

        public int getType() {
            return this.mType;
        }

        public Operation(int r100) {
            this.mType = r100;
        }
    }

    public static final class Parameters {
        public static final String APERTURE = "aperture";
        public static final String BODY_BEAUTY_LEVEL = "body_beauty_level";
        public static final String ENABLE_AI_NIGHT_VIDEO = "enable_ai_night_video";
        public static final String ENABLE_ANTI_SHAKE = "enable_anti_shake";
        public static final String ENABLE_BODY_BEAUTY = "enable_body_beauty";
        public static final String ENABLE_DIM_LIGHT_QUALITY = "enable_dim_light_quality";
        public static final String ENABLE_LIGHT_SOFT = "enable_light_soft";
        public static final String ENABLE_SUPER_STABILIZATION = "enable_super_Stabilization";
        public static final String ENABLE_VIDEO_HDR = "enable_video_hdr";
        public static final String ENABLE_VIDEO_STABILIZATION = "enable_video_stabilization";
        public static final String EXPOSURE_COMPENSATION = "exposure_compensation";
        public static final String FACE_DETECT = "face_detect";
        public static final String FLASH_MODE = "flash_mode";
        public static final String VIDEO_FPS = "video_fps";
        public static final String VIDEO_PATH = "video_path";
        public static final Map<String, Class> sKeySupportTypes = null;

        public Parameters() {
        }

        static {
            HashMap r100 = new HashMap();
            sKeySupportTypes = r100;
            r100.put(ENABLE_BODY_BEAUTY, Boolean.class);
            r100.put(ENABLE_LIGHT_SOFT, Boolean.class);
            r100.put(ENABLE_ANTI_SHAKE, Boolean.class);
            r100.put("video_path", String.class);
            r100.put(BODY_BEAUTY_LEVEL, Integer.class);
            r100.put(ENABLE_DIM_LIGHT_QUALITY, Boolean.class);
            r100.put(ENABLE_AI_NIGHT_VIDEO, Boolean.class);
            r100.put(ENABLE_VIDEO_STABILIZATION, Boolean.class);
            r100.put(ENABLE_SUPER_STABILIZATION, Boolean.class);
            r100.put(ENABLE_VIDEO_HDR, Boolean.class);
            r100.put(VIDEO_FPS, int[].class);
            r100.put(APERTURE, Float.class);
            r100.put(FLASH_MODE, Integer.class);
            r100.put(FACE_DETECT, Integer.class);
            r100.put(EXPOSURE_COMPENSATION, Integer.class);
        }

        public static boolean isValid(String r100, Object r101) {
            Map<String, Class> r102 = sKeySupportTypes;
            if (r102.containsKey(r100) == false) goto L8;
            if (r101 != null) goto L6;
        L7:
            return true;
        L6:
            if (r101.getClass() == r102.get(r100)) goto L7;
        L8:
            return false;
        }
    }

    public interface PictureCallback {
        public static final String ERROR_CODE_SPLIT_REGEX = "errorCode=";
        public static final int ERR_CODE_PIC_FAILED = -1000;
        public static final int ERR_CODE_PIC_INVALID_ENV = -1001;
        public static final int FORMAT_JPEG = 256;
        public static final int FORMAT_RGBA = 42;

        /* JADX INFO: renamed from: com.ss.android.ttvecamera.TECameraSettings$PictureCallback$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onShutter(PictureCallback r100) {
            }

            public static void $default$onTakenFail(PictureCallback r100, Exception r101, int r102) {
            }
        }

        void onPictureTaken(TECameraFrame r100, TECameraBase r101);

        void onShutter();

        void onTakenFail(Exception r100);

        void onTakenFail(Exception r100, int r101);
    }

    public interface SATZoomCallback {
        void onChange(int r100, float r101);
    }

    public interface ShaderZoomCallback {
        void getShaderStep(float r100);
    }

    public interface ShutterTimeCallback {
        void getShutterTimeRange(long[] r100);
    }

    public static final enum TECameraPrivacyCertType extends Enum<TECameraPrivacyCertType> {
        private static final /* synthetic */ TECameraPrivacyCertType[] $VALUES = null;
        public static final TECameraPrivacyCertType REGISTER_SENSOR = null;
        public static final TECameraPrivacyCertType UNREGISTER_SENSOR = null;

        private static /* synthetic */ TECameraPrivacyCertType[] $values() {
            return new TECameraPrivacyCertType[]{REGISTER_SENSOR, UNREGISTER_SENSOR};
        }

        static {
            REGISTER_SENSOR = new TECameraPrivacyCertType("REGISTER_SENSOR", 0);
            UNREGISTER_SENSOR = new TECameraPrivacyCertType("UNREGISTER_SENSOR", 1);
            $VALUES = $values();
        }

        public static TECameraPrivacyCertType[] values() {
            return (TECameraPrivacyCertType[]) $VALUES.clone();
        }

        public static TECameraPrivacyCertType valueOf(String r100) {
            return (TECameraPrivacyCertType) r27.a.a(TECameraPrivacyCertType.class, r100);
        }

        private TECameraPrivacyCertType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum TEPreviewSizeStrategy extends Enum<TEPreviewSizeStrategy> {
        private static final /* synthetic */ TEPreviewSizeStrategy[] $VALUES = null;
        public static final TEPreviewSizeStrategy DEFAULT = null;
        public static final TEPreviewSizeStrategy MATCH_BY_PIXELS = null;

        private static /* synthetic */ TEPreviewSizeStrategy[] $values() {
            return new TEPreviewSizeStrategy[]{DEFAULT, MATCH_BY_PIXELS};
        }

        static {
            DEFAULT = new TEPreviewSizeStrategy("DEFAULT", 0);
            MATCH_BY_PIXELS = new TEPreviewSizeStrategy("MATCH_BY_PIXELS", 1);
            $VALUES = $values();
        }

        public static TEPreviewSizeStrategy[] values() {
            return (TEPreviewSizeStrategy[]) $VALUES.clone();
        }

        public static TEPreviewSizeStrategy valueOf(String r100) {
            return (TEPreviewSizeStrategy) r27.a.a(TEPreviewSizeStrategy.class, r100);
        }

        private TEPreviewSizeStrategy(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface WhiteBalanceValue {
    }

    public interface ZoomCallback {
        boolean enableSmooth();

        void onChange(int r100, float r101, boolean r102);

        void onZoomSupport(int r100, boolean r101, boolean r102, float r103, List<Integer> r104);
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface ZslMode {
    }

    public void clean() {
        this.mContext = null;
        this.mExtParameters.clear();
    }

    static {
        sCameraSceneMode = new String[]{"auto", "portrait", "party", "sunset", "candlelight", "night", "hdr", "action", "landscape", "snow"};
        CameraHWLevelVE2Android = new int[]{2, 0, 1, 3};
        CameraHWLevelAndroid2VE = new int[]{1, 2, 0, 3};
    }

    public boolean isValid() {
        if (this.mContext != null) goto L5;
    L11:
        return false;
    L5:
        if (this.mPreviewSize.isValid() == false) goto L11;
        if (this.mPictureSize.isValid() == false) goto L11;
        if (this.mFPSRange.isValid() == false) goto L11;
        return true;
    }

    public String toString() {
        return "TECameraSettings: [mCameraType = " + this.mCameraType + ", mPreviewSize = " + this.mPreviewSize + ", mFacing = " + this.mFacing + ", mHighFPS = " + this.mHighFPS + ", mEnableStabilization = " + this.mEnableStabilization + ", mRequiredCameraLevel = " + this.mRequiredCameraLevel + ", mMaxWidth = " + this.mMaxWidth + ", mUseMaxWidthTakePicture = " + this.mUseMaxWidthTakePicture + ", mMode = " + this.mMode + ", mCameraZslStrategy = " + this.mCameraZslStrategy + ", mCameraZslStrategyFocusTimeout=" + this.mCameraZslStrategyFocusTimeout + "]";
    }

    public Object clone() {
        return (TECameraSettings) super.clone();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public boolean getEnableStopRepeatingBeforeCapture() {
        return this.mEnableStopRepeatingBeforeCapture;
    }

    public TEFrameSizei getPictureSize() {
        return this.mPictureSize;
    }

    public TEFrameSizei getPreviewSize() {
        return this.mPreviewSize;
    }

    public TECameraSettings(Context r100) {
        this.mCameraType = 1;
        this.mFPSRange = new TEFrameRateRange(7, 30);
        this.mFacing = 0;
        this.mRotation = 0;
        this.mDefaultCameraID = -1;
        this.mImageFormat = 17;
        this.mCameraZslStrategy = 0;
        this.mCameraZslStrategyFocusTimeout = 300;
        this.mbEnableCamera2Zsl = false;
        this.mEnableZsl = false;
        this.mEnableManualReleaseCaptureResult = true;
        this.mUseSyncModeOnCamera2 = false;
        this.mEnableWideFOV = false;
        this.mEnableRefactorFocusAndMeter = false;
        this.mEnableMonitorGyroscope = false;
        this.mbNeedProxyCameraDevice = false;
        this.mStartRecord = false;
        this.mEnableMonitorRuntimeInfo = false;
        this.mRuntimeInfoMonitorPeriod = 5000;
        this.mCameraZoomLimitFactor = -1.0f;
        this.mfnr = 0;
        this.mCaptureHdr = false;
        this.mPreviewSize = new TEFrameSizei(1280, 720);
        this.mPictureSize = new TEFrameSizei(TECameraUtils.CAPTURE_NORMAL, 1080);
        this.mVideoSize = new TEFrameSizei(TECameraUtils.CAPTURE_NORMAL, 1080);
        this.mOutputType = 1;
        this.mMaxWidth = 0;
        this.mRetryCnt = 0;
        this.mRetryStartPreviewCnt = 0;
        this.mCamera2RetryCnt = 1;
        this.mEnableHDR10BitRecord = false;
        this.mDynamicRangeProfile = 1;
        this.mMaxWidthTakePictureSizeAccuracy = 0.0f;
        this.mUseMaxWidthTakePicture = false;
        this.mForceApplyPictureSize = false;
        this.mbDualCameraExpansionScheme = false;
        this.mMode = 0;
        this.mCameraHardwareSupportLevel = 1;
        this.mRequiredCameraLevel = 1;
        this.mExtParameters = new Bundle();
        this.mOptionFlags = 1;
        this.mSceneMode = "auto";
        this.mStrCameraID = "0";
        this.mVendorCameraID = "0";
        this.mStrCustomizedCameraID = "-1";
        this.mCameraECInfo = new ExposureCompensationInfo();
        this.mEnableFallBack = true;
        this.mForceSwitchEnable = false;
        this.mHighFPS = 0;
        this.mCameraFrameRateStrategy = 0;
        this.mIsUseHint = false;
        this.mEnableSurfaceSharing = false;
        this.mIsCameraOpenCloseSync = false;
        this.mIsForceCloseCamera = false;
        this.mEnableVBoost = false;
        this.mVBoostTimeoutMS = 50;
        this.mEnableStabilization = false;
        this.mStabilizationMode = 0;
        this.mEnableAiNightVideo = false;
        this.mFocusTimeoutMS = CustomToast.LENGTH_SHORT;
        this.mEnableGcForCameraMetadataThreshold = 0;
        this.mFpsMaxLimit = 30;
        this.mOptCameraSceneFps = false;
        this.mEnableRecordStream = false;
        this.mEnableRecord60Fps = false;
        this.mRecordStreamFolderPath = "";
        this.mFlashMode = 0;
        this.mAWBValue = "auto";
        this.mCaptureFlashStrategy = 3;
        this.mEnablePreviewingFallback = false;
        this.mEnableBackGroundStrategy = false;
        this.mEnableOpenCamera1Opt = false;
        this.mEnableOpenCamera1Crs = false;
        this.CAMERA2_PREVIEWING_FAILED_COUNT = 15;
        this.mIgnoreCameraResetTaskOnDisconnected = false;
        this.mIsGetMetadata = false;
        this.mEnableHardWareFaceDetect = false;
        this.mEnableCamera2DeferredSurface = false;
        this.mEnableAbortSessionCapture = false;
        this.mEnableForceCameraCloseOpt = false;
        this.mEnableCamera2SessionClose = true;
        this.mBindSurfaceLifecycleToCamera = false;
        this.mCameraCaptureYuvStrategy = 0;
        this.mCameraPreviewIndependent = false;
        this.mEnableCamera2Detect = false;
        this.mMaxZoomRatio = -1.0f;
        this.mMinZoomRatio = -1.0f;
        this.mEnableCollectCapbilities = false;
        this.mEnableCameraFpsDoubleCheckInImageMode = true;
        this.mDefaultZoomRatio = 1.0f;
        this.mDefaultZoomUsingZoomV2 = true;
        this.mEnableCameraSwitchCamera1Optmize = false;
        this.mEnablePreviewSizeChangeOptimize = false;
        this.mEnableCameraProbCache = false;
        this.mEnableStopRepeatingBeforeCapture = false;
        this.mFixGetPictureSize = false;
        this.mbEnableTakePicture4VideoMode = false;
        this.mbEnableDynamicSwitch = false;
        this.mbEnableCamCloseANROpt = 0;
        this.mbEnablePreviewMetadataCallback = false;
        this.arConfig = null;
        this.mDynamicRangeProfiles = new HashSet();
        this.mCameraPrivacyCertMap = null;
        this.mPreviewSizeStrategy = TEPreviewSizeStrategy.DEFAULT;
        this.mContext = r100;
    }

    public void setEnableStopReaptingBeforeCapture(boolean r100) {
        if (r100 == false) goto L5;
        this.mEnableStopRepeatingBeforeCapture = VEConfigCenter.getInstance().getValue("ve_enable_stop_cam_repeating_before_capture", false).booleanValue();
        return;
    L5:
        this.mEnableStopRepeatingBeforeCapture = false;
    }

    public void setPictureSize(TEFrameSizei r100) {
        this.mPictureSize = r100;
    }

    public void setPreviewSize(TEFrameSizei r100) {
        this.mPreviewSize = r100;
    }

    public TECameraSettings(Context r100, int r101) {
        this.mCameraType = 1;
        this.mFPSRange = new TEFrameRateRange(7, 30);
        this.mFacing = 0;
        this.mRotation = 0;
        this.mDefaultCameraID = -1;
        this.mImageFormat = 17;
        this.mCameraZslStrategy = 0;
        this.mCameraZslStrategyFocusTimeout = 300;
        this.mbEnableCamera2Zsl = false;
        this.mEnableZsl = false;
        this.mEnableManualReleaseCaptureResult = true;
        this.mUseSyncModeOnCamera2 = false;
        this.mEnableWideFOV = false;
        this.mEnableRefactorFocusAndMeter = false;
        this.mEnableMonitorGyroscope = false;
        this.mbNeedProxyCameraDevice = false;
        this.mStartRecord = false;
        this.mEnableMonitorRuntimeInfo = false;
        this.mRuntimeInfoMonitorPeriod = 5000;
        this.mCameraZoomLimitFactor = -1.0f;
        this.mfnr = 0;
        this.mCaptureHdr = false;
        this.mPreviewSize = new TEFrameSizei(1280, 720);
        this.mPictureSize = new TEFrameSizei(TECameraUtils.CAPTURE_NORMAL, 1080);
        this.mVideoSize = new TEFrameSizei(TECameraUtils.CAPTURE_NORMAL, 1080);
        this.mOutputType = 1;
        this.mMaxWidth = 0;
        this.mRetryCnt = 0;
        this.mRetryStartPreviewCnt = 0;
        this.mCamera2RetryCnt = 1;
        this.mEnableHDR10BitRecord = false;
        this.mDynamicRangeProfile = 1;
        this.mMaxWidthTakePictureSizeAccuracy = 0.0f;
        this.mUseMaxWidthTakePicture = false;
        this.mForceApplyPictureSize = false;
        this.mbDualCameraExpansionScheme = false;
        this.mMode = 0;
        this.mCameraHardwareSupportLevel = 1;
        this.mRequiredCameraLevel = 1;
        this.mExtParameters = new Bundle();
        this.mOptionFlags = 1;
        this.mSceneMode = "auto";
        this.mStrCameraID = "0";
        this.mVendorCameraID = "0";
        this.mStrCustomizedCameraID = "-1";
        this.mCameraECInfo = new ExposureCompensationInfo();
        this.mEnableFallBack = true;
        this.mForceSwitchEnable = false;
        this.mHighFPS = 0;
        this.mCameraFrameRateStrategy = 0;
        this.mIsUseHint = false;
        this.mEnableSurfaceSharing = false;
        this.mIsCameraOpenCloseSync = false;
        this.mIsForceCloseCamera = false;
        this.mEnableVBoost = false;
        this.mVBoostTimeoutMS = 50;
        this.mEnableStabilization = false;
        this.mStabilizationMode = 0;
        this.mEnableAiNightVideo = false;
        this.mFocusTimeoutMS = CustomToast.LENGTH_SHORT;
        this.mEnableGcForCameraMetadataThreshold = 0;
        this.mFpsMaxLimit = 30;
        this.mOptCameraSceneFps = false;
        this.mEnableRecordStream = false;
        this.mEnableRecord60Fps = false;
        this.mRecordStreamFolderPath = "";
        this.mFlashMode = 0;
        this.mAWBValue = "auto";
        this.mCaptureFlashStrategy = 3;
        this.mEnablePreviewingFallback = false;
        this.mEnableBackGroundStrategy = false;
        this.mEnableOpenCamera1Opt = false;
        this.mEnableOpenCamera1Crs = false;
        this.CAMERA2_PREVIEWING_FAILED_COUNT = 15;
        this.mIgnoreCameraResetTaskOnDisconnected = false;
        this.mIsGetMetadata = false;
        this.mEnableHardWareFaceDetect = false;
        this.mEnableCamera2DeferredSurface = false;
        this.mEnableAbortSessionCapture = false;
        this.mEnableForceCameraCloseOpt = false;
        this.mEnableCamera2SessionClose = true;
        this.mBindSurfaceLifecycleToCamera = false;
        this.mCameraCaptureYuvStrategy = 0;
        this.mCameraPreviewIndependent = false;
        this.mEnableCamera2Detect = false;
        this.mMaxZoomRatio = -1.0f;
        this.mMinZoomRatio = -1.0f;
        this.mEnableCollectCapbilities = false;
        this.mEnableCameraFpsDoubleCheckInImageMode = true;
        this.mDefaultZoomRatio = 1.0f;
        this.mDefaultZoomUsingZoomV2 = true;
        this.mEnableCameraSwitchCamera1Optmize = false;
        this.mEnablePreviewSizeChangeOptimize = false;
        this.mEnableCameraProbCache = false;
        this.mEnableStopRepeatingBeforeCapture = false;
        this.mFixGetPictureSize = false;
        this.mbEnableTakePicture4VideoMode = false;
        this.mbEnableDynamicSwitch = false;
        this.mbEnableCamCloseANROpt = 0;
        this.mbEnablePreviewMetadataCallback = false;
        this.arConfig = null;
        this.mDynamicRangeProfiles = new HashSet();
        this.mCameraPrivacyCertMap = null;
        this.mPreviewSizeStrategy = TEPreviewSizeStrategy.DEFAULT;
        this.mContext = r100;
        this.mCameraType = r101;
    }

    public TECameraSettings(Context r100, int r101, int r110, int r111) {
        this.mCameraType = 1;
        this.mFPSRange = new TEFrameRateRange(7, 30);
        this.mFacing = 0;
        this.mRotation = 0;
        this.mDefaultCameraID = -1;
        this.mImageFormat = 17;
        this.mCameraZslStrategy = 0;
        this.mCameraZslStrategyFocusTimeout = 300;
        this.mbEnableCamera2Zsl = false;
        this.mEnableZsl = false;
        this.mEnableManualReleaseCaptureResult = true;
        this.mUseSyncModeOnCamera2 = false;
        this.mEnableWideFOV = false;
        this.mEnableRefactorFocusAndMeter = false;
        this.mEnableMonitorGyroscope = false;
        this.mbNeedProxyCameraDevice = false;
        this.mStartRecord = false;
        this.mEnableMonitorRuntimeInfo = false;
        this.mRuntimeInfoMonitorPeriod = 5000;
        this.mCameraZoomLimitFactor = -1.0f;
        this.mfnr = 0;
        this.mCaptureHdr = false;
        this.mPreviewSize = new TEFrameSizei(1280, 720);
        this.mPictureSize = new TEFrameSizei(TECameraUtils.CAPTURE_NORMAL, 1080);
        this.mVideoSize = new TEFrameSizei(TECameraUtils.CAPTURE_NORMAL, 1080);
        this.mOutputType = 1;
        this.mMaxWidth = 0;
        this.mRetryCnt = 0;
        this.mRetryStartPreviewCnt = 0;
        this.mCamera2RetryCnt = 1;
        this.mEnableHDR10BitRecord = false;
        this.mDynamicRangeProfile = 1;
        this.mMaxWidthTakePictureSizeAccuracy = 0.0f;
        this.mUseMaxWidthTakePicture = false;
        this.mForceApplyPictureSize = false;
        this.mbDualCameraExpansionScheme = false;
        this.mMode = 0;
        this.mCameraHardwareSupportLevel = 1;
        this.mRequiredCameraLevel = 1;
        this.mExtParameters = new Bundle();
        this.mOptionFlags = 1;
        this.mSceneMode = "auto";
        this.mStrCameraID = "0";
        this.mVendorCameraID = "0";
        this.mStrCustomizedCameraID = "-1";
        this.mCameraECInfo = new ExposureCompensationInfo();
        this.mEnableFallBack = true;
        this.mForceSwitchEnable = false;
        this.mHighFPS = 0;
        this.mCameraFrameRateStrategy = 0;
        this.mIsUseHint = false;
        this.mEnableSurfaceSharing = false;
        this.mIsCameraOpenCloseSync = false;
        this.mIsForceCloseCamera = false;
        this.mEnableVBoost = false;
        this.mVBoostTimeoutMS = 50;
        this.mEnableStabilization = false;
        this.mStabilizationMode = 0;
        this.mEnableAiNightVideo = false;
        this.mFocusTimeoutMS = CustomToast.LENGTH_SHORT;
        this.mEnableGcForCameraMetadataThreshold = 0;
        this.mFpsMaxLimit = 30;
        this.mOptCameraSceneFps = false;
        this.mEnableRecordStream = false;
        this.mEnableRecord60Fps = false;
        this.mRecordStreamFolderPath = "";
        this.mFlashMode = 0;
        this.mAWBValue = "auto";
        this.mCaptureFlashStrategy = 3;
        this.mEnablePreviewingFallback = false;
        this.mEnableBackGroundStrategy = false;
        this.mEnableOpenCamera1Opt = false;
        this.mEnableOpenCamera1Crs = false;
        this.CAMERA2_PREVIEWING_FAILED_COUNT = 15;
        this.mIgnoreCameraResetTaskOnDisconnected = false;
        this.mIsGetMetadata = false;
        this.mEnableHardWareFaceDetect = false;
        this.mEnableCamera2DeferredSurface = false;
        this.mEnableAbortSessionCapture = false;
        this.mEnableForceCameraCloseOpt = false;
        this.mEnableCamera2SessionClose = true;
        this.mBindSurfaceLifecycleToCamera = false;
        this.mCameraCaptureYuvStrategy = 0;
        this.mCameraPreviewIndependent = false;
        this.mEnableCamera2Detect = false;
        this.mMaxZoomRatio = -1.0f;
        this.mMinZoomRatio = -1.0f;
        this.mEnableCollectCapbilities = false;
        this.mEnableCameraFpsDoubleCheckInImageMode = true;
        this.mDefaultZoomRatio = 1.0f;
        this.mDefaultZoomUsingZoomV2 = true;
        this.mEnableCameraSwitchCamera1Optmize = false;
        this.mEnablePreviewSizeChangeOptimize = false;
        this.mEnableCameraProbCache = false;
        this.mEnableStopRepeatingBeforeCapture = false;
        this.mFixGetPictureSize = false;
        this.mbEnableTakePicture4VideoMode = false;
        this.mbEnableDynamicSwitch = false;
        this.mbEnableCamCloseANROpt = 0;
        this.mbEnablePreviewMetadataCallback = false;
        this.arConfig = null;
        this.mDynamicRangeProfiles = new HashSet();
        this.mCameraPrivacyCertMap = null;
        this.mPreviewSizeStrategy = TEPreviewSizeStrategy.DEFAULT;
        this.mContext = r100;
        this.mCameraType = r101;
        TEFrameSizei r102 = this.mPreviewSize;
        r102.width = r110;
        r102.height = r111;
    }

    public TECameraSettings(Context r100, int r110, int r111, int r112, int r113, int r114) {
        this(r100, r110, r111, r112, r113, r114, false);
    }

    public TECameraSettings(Context r100, int r101, int r110, int r111, int r112, int r113, boolean r114) {
        this.mCameraType = 1;
        this.mFPSRange = new TEFrameRateRange(7, 30);
        this.mFacing = 0;
        this.mRotation = 0;
        this.mDefaultCameraID = -1;
        this.mImageFormat = 17;
        this.mCameraZslStrategy = 0;
        this.mCameraZslStrategyFocusTimeout = 300;
        this.mbEnableCamera2Zsl = false;
        this.mEnableZsl = false;
        this.mEnableManualReleaseCaptureResult = true;
        this.mUseSyncModeOnCamera2 = false;
        this.mEnableWideFOV = false;
        this.mEnableRefactorFocusAndMeter = false;
        this.mEnableMonitorGyroscope = false;
        this.mbNeedProxyCameraDevice = false;
        this.mStartRecord = false;
        this.mEnableMonitorRuntimeInfo = false;
        this.mRuntimeInfoMonitorPeriod = 5000;
        this.mCameraZoomLimitFactor = -1.0f;
        this.mfnr = 0;
        this.mCaptureHdr = false;
        this.mPreviewSize = new TEFrameSizei(1280, 720);
        this.mPictureSize = new TEFrameSizei(TECameraUtils.CAPTURE_NORMAL, 1080);
        this.mVideoSize = new TEFrameSizei(TECameraUtils.CAPTURE_NORMAL, 1080);
        this.mOutputType = 1;
        this.mMaxWidth = 0;
        this.mRetryCnt = 0;
        this.mRetryStartPreviewCnt = 0;
        this.mCamera2RetryCnt = 1;
        this.mEnableHDR10BitRecord = false;
        this.mDynamicRangeProfile = 1;
        this.mMaxWidthTakePictureSizeAccuracy = 0.0f;
        this.mUseMaxWidthTakePicture = false;
        this.mForceApplyPictureSize = false;
        this.mbDualCameraExpansionScheme = false;
        this.mMode = 0;
        this.mCameraHardwareSupportLevel = 1;
        this.mRequiredCameraLevel = 1;
        this.mExtParameters = new Bundle();
        this.mOptionFlags = 1;
        this.mSceneMode = "auto";
        this.mStrCameraID = "0";
        this.mVendorCameraID = "0";
        this.mStrCustomizedCameraID = "-1";
        this.mCameraECInfo = new ExposureCompensationInfo();
        this.mEnableFallBack = true;
        this.mForceSwitchEnable = false;
        this.mHighFPS = 0;
        this.mCameraFrameRateStrategy = 0;
        this.mIsUseHint = false;
        this.mEnableSurfaceSharing = false;
        this.mIsCameraOpenCloseSync = false;
        this.mIsForceCloseCamera = false;
        this.mEnableVBoost = false;
        this.mVBoostTimeoutMS = 50;
        this.mEnableStabilization = false;
        this.mStabilizationMode = 0;
        this.mEnableAiNightVideo = false;
        this.mFocusTimeoutMS = CustomToast.LENGTH_SHORT;
        this.mEnableGcForCameraMetadataThreshold = 0;
        this.mFpsMaxLimit = 30;
        this.mOptCameraSceneFps = false;
        this.mEnableRecordStream = false;
        this.mEnableRecord60Fps = false;
        this.mRecordStreamFolderPath = "";
        this.mFlashMode = 0;
        this.mAWBValue = "auto";
        this.mCaptureFlashStrategy = 3;
        this.mEnablePreviewingFallback = false;
        this.mEnableBackGroundStrategy = false;
        this.mEnableOpenCamera1Opt = false;
        this.mEnableOpenCamera1Crs = false;
        this.CAMERA2_PREVIEWING_FAILED_COUNT = 15;
        this.mIgnoreCameraResetTaskOnDisconnected = false;
        this.mIsGetMetadata = false;
        this.mEnableHardWareFaceDetect = false;
        this.mEnableCamera2DeferredSurface = false;
        this.mEnableAbortSessionCapture = false;
        this.mEnableForceCameraCloseOpt = false;
        this.mEnableCamera2SessionClose = true;
        this.mBindSurfaceLifecycleToCamera = false;
        this.mCameraCaptureYuvStrategy = 0;
        this.mCameraPreviewIndependent = false;
        this.mEnableCamera2Detect = false;
        this.mMaxZoomRatio = -1.0f;
        this.mMinZoomRatio = -1.0f;
        this.mEnableCollectCapbilities = false;
        this.mEnableCameraFpsDoubleCheckInImageMode = true;
        this.mDefaultZoomRatio = 1.0f;
        this.mDefaultZoomUsingZoomV2 = true;
        this.mEnableCameraSwitchCamera1Optmize = false;
        this.mEnablePreviewSizeChangeOptimize = false;
        this.mEnableCameraProbCache = false;
        this.mEnableStopRepeatingBeforeCapture = false;
        this.mFixGetPictureSize = false;
        this.mbEnableTakePicture4VideoMode = false;
        this.mbEnableDynamicSwitch = false;
        this.mbEnableCamCloseANROpt = 0;
        this.mbEnablePreviewMetadataCallback = false;
        this.arConfig = null;
        this.mDynamicRangeProfiles = new HashSet();
        this.mCameraPrivacyCertMap = null;
        this.mPreviewSizeStrategy = TEPreviewSizeStrategy.DEFAULT;
        this.mContext = r100;
        this.mCameraType = r101;
        TEFrameSizei r102 = this.mPreviewSize;
        r102.width = r110;
        r102.height = r111;
        r102.width = r112;
        r102.height = r113;
        this.mEnableZsl = r114;
    }
}
