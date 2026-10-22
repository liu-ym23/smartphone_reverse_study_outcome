package com.ss.android.vesdk;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.live.uikit.toast.CustomToast;
import com.bytedance.bpea.basics.Cert;
import com.ss.android.ttvecamera.TECameraConfigKey;
import com.ss.android.ttvecamera.TECameraSettings;
import java.util.HashMap;

/* JADX INFO: loaded from: classes40.dex */
public class VECameraSettings implements Parcelable {
    public static final Parcelable.Creator<VECameraSettings> CREATOR = null;
    public static final int DEFAULT_FPS = 30;
    public static final byte OPTION_FLAG_CaptureSizeNotEqualPreviewSize = 8;
    public static final byte OPTION_FLAG_DEFAULT = 1;
    public static final byte OPTION_FLAG_FPS_RANGE = 2;
    public static final byte OPTION_FLAG_MTK_3DNR = 4;
    public static final byte OPTION_FLAG_PICTURE_SIZE = 1;
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
    public static final String TAG = null;
    public static final int ZSL_MODE_CAMERA1 = 1;
    public static final int ZSL_MODE_CAMERA2 = 2;
    public static final int ZSL_MODE_CAMERA2_V2 = 4;
    public static final int ZSL_MODE_NONE = 0;
    public static final String[] sCameraSceneMode = null;
    int[] CameraHWLevelAndroid2TE;
    int[] CameraHWLevelTE2Android;
    private Object customCameraTag;
    private boolean mBindSurfaceLifecycleToCamera;
    private int mCamera2RetryCnt;
    private boolean mCameraAntiShake;
    private int mCameraAntiShakeMode;
    private CAMERA_CAPTURE_YUV_STRATEGY mCameraCaptureYuvStrategy;
    private CAMERA_FACING_ID mCameraFacing;
    private CAMERA_FRAMERATE_STRATEGY mCameraFrameRateStrategy;
    private CAMERA_MODE_TYPE mCameraMode;
    private boolean mCameraPreviewIndependent;
    public HashMap<TECameraSettings.TECameraPrivacyCertType, Cert> mCameraPrivacyCertMap;
    private CAMERA_TYPE mCameraType;
    private float mCameraZoomLimitFactor;
    private CAMERA_CAPTURE_FLASH_STRATEGY mCaptureFlashStrategy;
    private boolean mCaptureHdr;
    private VESize mCaptureSize;
    private CAMERA_TYPE mConfigCameraType;
    private CAMERA_TYPE mDefaultCameraTypeInNewCameraStrategy;
    public float mDefaultZoomRatio;
    public boolean mDefaultZoomUsingZoomV2;
    private long mDynamicRangeProfile;
    private boolean mEnableBackGroundStrategy;
    private boolean mEnableFallback;
    private boolean mEnableForceRestartWhenCameraError;
    private int mEnableGcForCameraMetadataThreshold;
    private boolean mEnableGyroFocusAndMeter;
    private boolean mEnableHDR10BitRecord;
    private boolean mEnableManualReleaseCaptureResult;
    public boolean mEnableMonitorRuntimeInfo;
    private boolean mEnableOpenCamera1Crs;
    private boolean mEnableOpenCamera1Opt;
    private boolean mEnablePreviewTemplate;
    private boolean mEnablePreviewingFallback;
    private boolean mEnableRecord60Fps;
    private boolean mEnableRecordStream;
    private boolean mEnableRefactorFocusAndMeter;
    private boolean mEnableStopRepeatingBeforeCapture;
    private boolean mEnableSurfaceSharing;
    private boolean mEnableVBoost;
    private boolean mEnableWideFOV;
    private boolean mEnableZsl;
    private boolean mEnableZslStrategy;
    private Bundle mExtParameters;
    private FACEAE_STRATEGY mFaceAEStrategy;
    private int mFocusTimeoutMS;
    private int mFps;
    private int mFpsMaxLimit;
    private int[] mFpsRange;
    private CAMERA_HW_LEVEL mHwLevel;
    private boolean mIsCameraOpenCloseSync;
    private boolean mIsForceCloseCamera;
    private boolean mIsUseHint;
    private boolean mIsUseNewCameraTypeStrategy;
    private int mMaxWidth;
    private float mMaxWidthTakePictureSizeAccuracy;
    private boolean mOptCameraSceneFps;
    private byte mOptionFlags;
    private CAMERA_OUTPUT_MODE mOutputMode;
    private boolean mPreferOpenCameraByCameraId;
    private VESize mPreviewSize;
    private PREVIEW_SIZE_STRATEGY mPreviewSizeStrategy;
    private String mRecordStreamFolderPath;
    private int mRetryCnt;
    private int mRetryStartPreviewCnt;
    public long mRuntimeInfoMonitorPeriod;
    private String mSceneMode;
    private String mStrCameraHardwareID;
    private boolean mUseMaxWidthTakePicture;
    private boolean mUseSyncModeOnCamera2;
    private int mVBoostTimeoutMS;
    private boolean mVESetCameraTwoOutputMode;
    private boolean mbDontUseVendorCamera;
    public boolean mbDualCameraExpansionScheme;
    private boolean mbEnableCamera2ZSL;
    private boolean mbEnableDynamicSwitch;
    private boolean mbEnablePreviewMetadataCallback;
    private boolean mbEnableTakePicture4VideoMode;

    public static class Builder {
        private VECameraSettings mExportCameraSettings;

        public Builder overrideWithCloudConfig() {
            return this;
        }

        public Builder() {
            VECameraSettings r100 = new VECameraSettings(null);
            this.mExportCameraSettings = r100;
            r100.setEnableStopRepeatingBeforeCapture(true);
        }

        public VECameraSettings build() {
            return this.mExportCameraSettings;
        }

        public Builder(VECameraSettings r100) {
            this.mExportCameraSettings = r100;
        }

        public Builder bindSurfaceLifecycleToCamera(boolean r100) {
            VECameraSettings.access$1902(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder enableCameraPreviewIndependent(boolean r100) {
            VECameraSettings.access$4302(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder enableForceRestartWhenCameraError(boolean r100) {
            VECameraSettings.access$1802(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder enableFrontFacingVideoContinueFocus(boolean r100) {
            VECameraSettings.access$800(this.mExportCameraSettings).putBoolean("enableFrontFacingVideoContinueFocus", r100);
            return this;
        }

        public Builder enableGyroFocusAndMeter(boolean r100) {
            VECameraSettings.access$1702(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder enableHDR10BitRecord(boolean r100) {
            VECameraSettings.access$3602(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder enablePreviewingFallback(boolean r100) {
            VECameraSettings.access$4502(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder enableRecord60Fps(boolean r100) {
            VECameraSettings.access$3102(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder enableRecordStream(boolean r100) {
            VECameraSettings.access$3002(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder enableRefactorFocusAndMeter(boolean r100) {
            VECameraSettings.access$1602(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder enableRetryOpenCamera(boolean r100) {
            VECameraSettings r101 = this.mExportCameraSettings;
            if (r100 == false) goto L5;
            int r102 = 2;
        L6:
            VECameraSettings.access$1202(r101, r102);
            return this;
        L5:
            r102 = 0;
            goto L6
        }

        public Builder enableShutterSound(boolean r100) {
            VECameraSettings.access$800(this.mExportCameraSettings).putBoolean("enableShutterSound", r100);
            return this;
        }

        public Builder enableSwitchFlashSleepToTakeEffect(boolean r100) {
            VECameraSettings.access$800(this.mExportCameraSettings).putBoolean("enableSwitchFlashSleepToTakeEffect", r100);
            return this;
        }

        public Builder forceRunUpdateTexImg(boolean r100) {
            VECameraSettings.access$800(this.mExportCameraSettings).putBoolean("forceRunUpdateTexImg", r100);
            return this;
        }

        public Builder setCamera2RetryCnt(int r100) {
            VECameraSettings.access$3502(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setCameraAiNightVideo(boolean r100) {
            VECameraSettings.access$800(this.mExportCameraSettings).putBoolean(TECameraSettings.Parameters.ENABLE_AI_NIGHT_VIDEO, r100);
            return this;
        }

        public Builder setCameraAntiShake(boolean r100) {
            VECameraSettings.access$602(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setCameraAntiShakeMode(int r100) {
            VECameraSettings.access$702(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setCameraCaptureYuvStrategy(CAMERA_CAPTURE_YUV_STRATEGY r100) {
            if (r100 != null) goto L4;
            r100 = CAMERA_CAPTURE_YUV_STRATEGY.DISABLE;
        L4:
            VELogUtil.i(VECameraSettings.TAG, "setCameraCaptureYuvStrategy last=" + r100);
            VECameraSettings.access$2002(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setCameraFaceDetect(boolean r100) {
            VEConfigCenter r101 = VEConfigCenter.getInstance();
            if (r100 == false) goto L5;
            FACEAE_STRATEGY r102 = FACEAE_STRATEGY.ENABLE_FACEAE_FOR_ALL;
        L6:
            r101.updateValue(TECameraConfigKey.KEY_ENABLE_FACE_DETECTION, Integer.valueOf(r102.ordinal()));
            return this;
        L5:
            r102 = FACEAE_STRATEGY.DISABLE_FACEAE;
            goto L6
        }

        public Builder setCameraFacing(CAMERA_FACING_ID r100) {
            VECameraSettings.access$102(this.mExportCameraSettings, VEConfigCenter.getInstance().getValue("wide_camera_id", "-1"));
            VECameraSettings.access$202(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setCameraModeType(CAMERA_MODE_TYPE r100) {
            VECameraSettings.access$4102(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setCameraPrivacyCertMap(HashMap<TECameraSettings.TECameraPrivacyCertType, Cert> r100) {
            this.mExportCameraSettings.mCameraPrivacyCertMap = r100;
            return this;
        }

        public Builder setCameraSuperAntiShake(boolean r100) {
            VECameraSettings.access$800(this.mExportCameraSettings).putBoolean(TECameraSettings.Parameters.ENABLE_SUPER_STABILIZATION, r100);
            return this;
        }

        public Builder setCameraType(CAMERA_TYPE r100) {
            VECameraSettings.access$302(this.mExportCameraSettings, r100);
            VECameraSettings.access$402(this.mExportCameraSettings, false);
            return this;
        }

        public Builder setCameraVideoAntiShake(boolean r100) {
            VECameraSettings.access$800(this.mExportCameraSettings).putBoolean(TECameraSettings.Parameters.ENABLE_VIDEO_STABILIZATION, r100);
            return this;
        }

        public Builder setCameraVideoHDR(boolean r100) {
            VECameraSettings.access$800(this.mExportCameraSettings).putBoolean(TECameraSettings.Parameters.ENABLE_VIDEO_HDR, r100);
            return this;
        }

        public Builder setCameraZoomLimitFactor(float r100) {
            if (r100 >= 0.0f) goto L6;
            r100 = 0.0f;
        L6:
            if (r100 <= 1.0f) goto L8;
            r100 = 1.0f;
        L8:
            VECameraSettings.access$2202(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setCaptureFlashStrategy(CAMERA_CAPTURE_FLASH_STRATEGY r100) {
            VECameraSettings.access$4202(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setDefaultCameraTypeInNewCameraTypeStrategy(CAMERA_TYPE r100) {
            VECameraSettings.access$4602(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setDefaultZoomRatio(float r100) {
            this.mExportCameraSettings.mDefaultZoomRatio = r100;
            return this;
        }

        public Builder setDefaultZoomUsingZoomV2(boolean r100) {
            this.mExportCameraSettings.mDefaultZoomUsingZoomV2 = r100;
            return this;
        }

        public Builder setDontUseVendorCameraType(boolean r100) {
            VECameraSettings.access$502(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setDualCameraExtensionScheme(boolean r100) {
            this.mExportCameraSettings.mbDualCameraExpansionScheme = r100;
            return this;
        }

        public Builder setDynamicRangeProfile(long r100) {
            VECameraSettings.access$3702(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setEnableCamera2Zsl(boolean r100) {
            VECameraSettings.access$4902(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setEnableFallback(boolean r100) {
            VECameraSettings.access$1302(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setEnableMonitorRuntimeInfo(boolean r100) {
            this.mExportCameraSettings.mEnableMonitorRuntimeInfo = r100;
            return this;
        }

        public Builder setEnablePreviewMetadataCallback(boolean r100) {
            VECameraSettings.access$3402(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setEnableSurfaceSharing(boolean r100) {
            VECameraSettings.access$1002(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setEnableTakePicture4VideoMode(boolean r100) {
            return setEnableTakePicture4VideoMode(r100, false);
        }

        public Builder setEnableZsl(boolean r100) {
            VECameraSettings.access$1402(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setEnableZslStrategy(boolean r100) {
            VECameraSettings.access$4802(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setExtParameters(Bundle r100) {
            VECameraSettings.access$802(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setFps(int r100) {
            VECameraSettings.access$2402(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setFpsMaxLimit(int r100) {
            if (r100 >= 30) goto L5;
            r100 = 30;
        L5:
            VECameraSettings.access$2102(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setFpsRange(int[] r100) {
            VECameraSettings.access$2602(this.mExportCameraSettings, r100);
            VECameraSettings.access$2702(this.mExportCameraSettings, CAMERA_FRAMERATE_STRATEGY.DYNAMIC_FRAMERATE_WITHOUT_SELECT);
            return this;
        }

        public Builder setHwLevel(CAMERA_HW_LEVEL r100) {
            VECameraSettings.access$2502(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setIsUseNewCameraTypeStrategy(boolean r100) {
            VECameraSettings.access$402(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setMaxWidth(int r100) {
            VECameraSettings.access$3902(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setMaxWidthTakePictureSizeAccuracy(float r100) {
            VECameraSettings.access$1102(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setMonitorRuntimeInfoPeriod(long r100) {
            this.mExportCameraSettings.mRuntimeInfoMonitorPeriod = r100;
            return this;
        }

        public Builder setOptionFlag(byte r100) {
            VECameraSettings.access$2902(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setOutPutMode(CAMERA_OUTPUT_MODE r100) {
            VECameraSettings.access$4002(this.mExportCameraSettings, r100);
            if (VEConfigCenter.getInstance().getValue("ve_enable_titan_nv21_buffer_render_chain", false).booleanValue() == false) goto L5;
            VECameraSettings.access$4002(this.mExportCameraSettings, CAMERA_OUTPUT_MODE.FRAME);
        L5:
            return this;
        }

        public Builder setPreferOpenCameraByCameraId(boolean r100) {
            VECameraSettings.access$4402(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setPreviewSizeStrategy(PREVIEW_SIZE_STRATEGY r100) {
            VECameraSettings.access$4702(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setRecordStreamFolderPath(String r100) {
            VECameraSettings.access$3202(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setRetryCnt(int r100) {
            VECameraSettings.access$1202(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setRetryStartPreviewCnt(int r100) {
            VECameraSettings.access$3302(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setSceneMode(String r100) {
            VECameraSettings.access$2802(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setUseMaxWidthTakePicture(boolean r100) {
            VECameraSettings.access$902(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setUseSyncModeOnCamera2(boolean r100) {
            VECameraSettings.access$1502(this.mExportCameraSettings, r100);
            return this;
        }

        public Builder setCameraFacing(CAMERA_FACING_ID r100, String r101) {
            VECameraSettings.access$202(this.mExportCameraSettings, r100);
            VECameraSettings.access$102(this.mExportCameraSettings, r101);
            return this;
        }

        public Builder setCaptureSize(int r100, int r101) {
            VECameraSettings.access$3802(this.mExportCameraSettings, new VESize(r100, r101));
            return this;
        }

        public Builder setEnableTakePicture4VideoMode(boolean r100, boolean r101) {
            VECameraSettings.access$5002(this.mExportCameraSettings, r100);
            VECameraSettings.access$5102(this.mExportCameraSettings, r101);
            return this;
        }

        public Builder setPreviewSize(int r100, int r101) {
            VECameraSettings.access$2302(this.mExportCameraSettings, new VESize(r100, r101));
            return this;
        }
    }

    public static final enum CAMERA_CAPTURE_FLASH_STRATEGY extends Enum<CAMERA_CAPTURE_FLASH_STRATEGY> implements Parcelable {
        public static final Parcelable.Creator<CAMERA_CAPTURE_FLASH_STRATEGY> CREATOR = null;
        public static final CAMERA_CAPTURE_FLASH_STRATEGY FlashOnRealStrategy = null;
        public static final CAMERA_CAPTURE_FLASH_STRATEGY FlashOnSimulatedStrategy = null;
        public static final CAMERA_CAPTURE_FLASH_STRATEGY PreAndMainStrategy = null;
        public static final CAMERA_CAPTURE_FLASH_STRATEGY TorchFakeStrategy = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CAMERA_CAPTURE_FLASH_STRATEGY[] f455522a = null;

        public class a implements Parcelable.Creator<CAMERA_CAPTURE_FLASH_STRATEGY> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final CAMERA_CAPTURE_FLASH_STRATEGY createFromParcel(Parcel r100) {
                return CAMERA_CAPTURE_FLASH_STRATEGY.values()[r100.readInt()];
            }

            @Override // android.os.Parcelable.Creator
            public final CAMERA_CAPTURE_FLASH_STRATEGY[] newArray(int r100) {
                return new CAMERA_CAPTURE_FLASH_STRATEGY[r100];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CAMERA_CAPTURE_FLASH_STRATEGY r100 = new CAMERA_CAPTURE_FLASH_STRATEGY("PreAndMainStrategy", 0);
            PreAndMainStrategy = r100;
            CAMERA_CAPTURE_FLASH_STRATEGY r101 = new CAMERA_CAPTURE_FLASH_STRATEGY("TorchFakeStrategy", 1);
            TorchFakeStrategy = r101;
            CAMERA_CAPTURE_FLASH_STRATEGY r102 = new CAMERA_CAPTURE_FLASH_STRATEGY("FlashOnRealStrategy", 2);
            FlashOnRealStrategy = r102;
            CAMERA_CAPTURE_FLASH_STRATEGY r103 = new CAMERA_CAPTURE_FLASH_STRATEGY("FlashOnSimulatedStrategy", 3);
            FlashOnSimulatedStrategy = r103;
            f455522a = new CAMERA_CAPTURE_FLASH_STRATEGY[]{r100, r101, r102, r103};
            CREATOR = new a();
        }

        public static CAMERA_CAPTURE_FLASH_STRATEGY[] values() {
            return (CAMERA_CAPTURE_FLASH_STRATEGY[]) f455522a.clone();
        }

        public static CAMERA_CAPTURE_FLASH_STRATEGY valueOf(String r100) {
            return (CAMERA_CAPTURE_FLASH_STRATEGY) r27.a.a(CAMERA_CAPTURE_FLASH_STRATEGY.class, r100);
        }

        public CAMERA_CAPTURE_FLASH_STRATEGY(String r100, int r101) {
            super(r100, r101);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeInt(ordinal());
        }
    }

    public static final enum CAMERA_CAPTURE_YUV_STRATEGY extends Enum<CAMERA_CAPTURE_YUV_STRATEGY> {
        public static final CAMERA_CAPTURE_YUV_STRATEGY DISABLE = null;
        public static final CAMERA_CAPTURE_YUV_STRATEGY ENABLE_FOR_ALL = null;
        public static final CAMERA_CAPTURE_YUV_STRATEGY ENABLE_FOR_FRONT = null;
        public static final CAMERA_CAPTURE_YUV_STRATEGY ENABLE_FOR_REAR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CAMERA_CAPTURE_YUV_STRATEGY[] f455523a = null;

        static {
            CAMERA_CAPTURE_YUV_STRATEGY r100 = new CAMERA_CAPTURE_YUV_STRATEGY("DISABLE", 0);
            DISABLE = r100;
            CAMERA_CAPTURE_YUV_STRATEGY r101 = new CAMERA_CAPTURE_YUV_STRATEGY("ENABLE_FOR_FRONT", 1);
            ENABLE_FOR_FRONT = r101;
            CAMERA_CAPTURE_YUV_STRATEGY r102 = new CAMERA_CAPTURE_YUV_STRATEGY("ENABLE_FOR_REAR", 2);
            ENABLE_FOR_REAR = r102;
            CAMERA_CAPTURE_YUV_STRATEGY r103 = new CAMERA_CAPTURE_YUV_STRATEGY("ENABLE_FOR_ALL", 3);
            ENABLE_FOR_ALL = r103;
            f455523a = new CAMERA_CAPTURE_YUV_STRATEGY[]{r100, r101, r102, r103};
        }

        public static CAMERA_CAPTURE_YUV_STRATEGY[] values() {
            return (CAMERA_CAPTURE_YUV_STRATEGY[]) f455523a.clone();
        }

        public static CAMERA_CAPTURE_YUV_STRATEGY valueOf(String r100) {
            return (CAMERA_CAPTURE_YUV_STRATEGY) r27.a.a(CAMERA_CAPTURE_YUV_STRATEGY.class, r100);
        }

        public CAMERA_CAPTURE_YUV_STRATEGY(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum CAMERA_FACING_ID extends Enum<CAMERA_FACING_ID> implements Parcelable {
        private static final /* synthetic */ CAMERA_FACING_ID[] $VALUES = null;
        public static final Parcelable.Creator<CAMERA_FACING_ID> CREATOR = null;
        public static final CAMERA_FACING_ID FACING_3RD = null;
        public static final CAMERA_FACING_ID FACING_BACK = null;
        public static final CAMERA_FACING_ID FACING_FRONT = null;
        public static final CAMERA_FACING_ID FACING_REAR_MAIN_FRONT_MAIN = null;
        public static final CAMERA_FACING_ID FACING_REAR_MAIN_REAR_TELE = null;
        public static final CAMERA_FACING_ID FACING_REAR_MAIN_REAR_WIDE = null;
        public static final CAMERA_FACING_ID FACING_TELEPHOTO = null;
        public static final CAMERA_FACING_ID FACING_WIDE_ANGLE = null;

        public class a implements Parcelable.Creator<CAMERA_FACING_ID> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final CAMERA_FACING_ID createFromParcel(Parcel r100) {
                return CAMERA_FACING_ID.values()[r100.readInt()];
            }

            @Override // android.os.Parcelable.Creator
            public final CAMERA_FACING_ID[] newArray(int r100) {
                return new CAMERA_FACING_ID[r100];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        private static /* synthetic */ CAMERA_FACING_ID[] $values() {
            return new CAMERA_FACING_ID[]{FACING_BACK, FACING_FRONT, FACING_WIDE_ANGLE, FACING_TELEPHOTO, FACING_3RD, FACING_REAR_MAIN_REAR_WIDE, FACING_REAR_MAIN_REAR_TELE, FACING_REAR_MAIN_FRONT_MAIN};
        }

        static {
            FACING_BACK = new CAMERA_FACING_ID("FACING_BACK", 0);
            FACING_FRONT = new CAMERA_FACING_ID("FACING_FRONT", 1);
            FACING_WIDE_ANGLE = new CAMERA_FACING_ID("FACING_WIDE_ANGLE", 2);
            FACING_TELEPHOTO = new CAMERA_FACING_ID("FACING_TELEPHOTO", 3);
            FACING_3RD = new CAMERA_FACING_ID("FACING_3RD", 4);
            FACING_REAR_MAIN_REAR_WIDE = new CAMERA_FACING_ID("FACING_REAR_MAIN_REAR_WIDE", 5);
            FACING_REAR_MAIN_REAR_TELE = new CAMERA_FACING_ID("FACING_REAR_MAIN_REAR_TELE", 6);
            FACING_REAR_MAIN_FRONT_MAIN = new CAMERA_FACING_ID("FACING_REAR_MAIN_FRONT_MAIN", 7);
            $VALUES = $values();
            CREATOR = new a();
        }

        public static CAMERA_FACING_ID[] values() {
            return (CAMERA_FACING_ID[]) $VALUES.clone();
        }

        public boolean isBidirectional() {
            if (this != FACING_REAR_MAIN_FRONT_MAIN) goto L5;
            return true;
        L5:
            return false;
        }

        public static CAMERA_FACING_ID valueOf(String r100) {
            return (CAMERA_FACING_ID) r27.a.a(CAMERA_FACING_ID.class, r100);
        }

        private CAMERA_FACING_ID(String r100, int r101) {
            super(r100, r101);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeInt(ordinal());
        }
    }

    public static final enum CAMERA_FLASH_MODE extends Enum<CAMERA_FLASH_MODE> implements Parcelable {
        private static final /* synthetic */ CAMERA_FLASH_MODE[] $VALUES = null;
        public static final CAMERA_FLASH_MODE CAMERA_FLASH_AUTO = null;
        public static final CAMERA_FLASH_MODE CAMERA_FLASH_OFF = null;
        public static final CAMERA_FLASH_MODE CAMERA_FLASH_ON = null;
        public static final CAMERA_FLASH_MODE CAMERA_FLASH_RED_EYE = null;
        public static final CAMERA_FLASH_MODE CAMERA_FLASH_TORCH = null;
        public static final Parcelable.Creator<CAMERA_FLASH_MODE> CREATOR = null;

        public class a implements Parcelable.Creator<CAMERA_FLASH_MODE> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final CAMERA_FLASH_MODE createFromParcel(Parcel r100) {
                return CAMERA_FLASH_MODE.values()[r100.readInt()];
            }

            @Override // android.os.Parcelable.Creator
            public final CAMERA_FLASH_MODE[] newArray(int r100) {
                return new CAMERA_FLASH_MODE[r100];
            }
        }

        private static /* synthetic */ CAMERA_FLASH_MODE[] $values() {
            return new CAMERA_FLASH_MODE[]{CAMERA_FLASH_OFF, CAMERA_FLASH_ON, CAMERA_FLASH_TORCH, CAMERA_FLASH_AUTO, CAMERA_FLASH_RED_EYE};
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CAMERA_FLASH_OFF = new CAMERA_FLASH_MODE("CAMERA_FLASH_OFF", 0);
            CAMERA_FLASH_ON = new CAMERA_FLASH_MODE("CAMERA_FLASH_ON", 1);
            CAMERA_FLASH_TORCH = new CAMERA_FLASH_MODE("CAMERA_FLASH_TORCH", 2);
            CAMERA_FLASH_AUTO = new CAMERA_FLASH_MODE("CAMERA_FLASH_AUTO", 3);
            CAMERA_FLASH_RED_EYE = new CAMERA_FLASH_MODE("CAMERA_FLASH_RED_EYE", 4);
            $VALUES = $values();
            CREATOR = new a();
        }

        public static CAMERA_FLASH_MODE[] values() {
            return (CAMERA_FLASH_MODE[]) $VALUES.clone();
        }

        public static CAMERA_FLASH_MODE valueOf(String r100) {
            return (CAMERA_FLASH_MODE) r27.a.a(CAMERA_FLASH_MODE.class, r100);
        }

        private CAMERA_FLASH_MODE(String r100, int r101) {
            super(r100, r101);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeInt(ordinal());
        }
    }

    public static final enum CAMERA_FRAMERATE_STRATEGY extends Enum<CAMERA_FRAMERATE_STRATEGY> {
        public static final CAMERA_FRAMERATE_STRATEGY DYNAMIC_FRAMERATE = null;
        public static final CAMERA_FRAMERATE_STRATEGY DYNAMIC_FRAMERATE_WITHOUT_SELECT = null;
        public static final CAMERA_FRAMERATE_STRATEGY FIXED_FRAMERATE_FOR_ALL = null;
        public static final CAMERA_FRAMERATE_STRATEGY FIXED_FRAMERATE_FOR_REAR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CAMERA_FRAMERATE_STRATEGY[] f455524a = null;

        static {
            CAMERA_FRAMERATE_STRATEGY r100 = new CAMERA_FRAMERATE_STRATEGY("DYNAMIC_FRAMERATE", 0);
            DYNAMIC_FRAMERATE = r100;
            CAMERA_FRAMERATE_STRATEGY r101 = new CAMERA_FRAMERATE_STRATEGY("FIXED_FRAMERATE_FOR_ALL", 1);
            FIXED_FRAMERATE_FOR_ALL = r101;
            CAMERA_FRAMERATE_STRATEGY r102 = new CAMERA_FRAMERATE_STRATEGY("FIXED_FRAMERATE_FOR_REAR", 2);
            FIXED_FRAMERATE_FOR_REAR = r102;
            CAMERA_FRAMERATE_STRATEGY r103 = new CAMERA_FRAMERATE_STRATEGY("DYNAMIC_FRAMERATE_WITHOUT_SELECT", 3);
            DYNAMIC_FRAMERATE_WITHOUT_SELECT = r103;
            f455524a = new CAMERA_FRAMERATE_STRATEGY[]{r100, r101, r102, r103};
        }

        public static CAMERA_FRAMERATE_STRATEGY[] values() {
            return (CAMERA_FRAMERATE_STRATEGY[]) f455524a.clone();
        }

        public static CAMERA_FRAMERATE_STRATEGY valueOf(String r100) {
            return (CAMERA_FRAMERATE_STRATEGY) r27.a.a(CAMERA_FRAMERATE_STRATEGY.class, r100);
        }

        public CAMERA_FRAMERATE_STRATEGY(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum CAMERA_HW_LEVEL extends Enum<CAMERA_HW_LEVEL> implements Parcelable {
        private static final /* synthetic */ CAMERA_HW_LEVEL[] $VALUES = null;
        public static final CAMERA_HW_LEVEL CAMERA_HW_LEVEL_FULL = null;
        public static final CAMERA_HW_LEVEL CAMERA_HW_LEVEL_LEGACY = null;
        public static final CAMERA_HW_LEVEL CAMERA_HW_LEVEL_LEVEL_3 = null;
        public static final CAMERA_HW_LEVEL CAMERA_HW_LEVEL_LIMITED = null;
        public static final Parcelable.Creator<CAMERA_HW_LEVEL> CREATOR = null;

        public class a implements Parcelable.Creator<CAMERA_HW_LEVEL> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final CAMERA_HW_LEVEL createFromParcel(Parcel r100) {
                return CAMERA_HW_LEVEL.values()[r100.readInt()];
            }

            @Override // android.os.Parcelable.Creator
            public final CAMERA_HW_LEVEL[] newArray(int r100) {
                return new CAMERA_HW_LEVEL[r100];
            }
        }

        private static /* synthetic */ CAMERA_HW_LEVEL[] $values() {
            return new CAMERA_HW_LEVEL[]{CAMERA_HW_LEVEL_LEGACY, CAMERA_HW_LEVEL_LIMITED, CAMERA_HW_LEVEL_FULL, CAMERA_HW_LEVEL_LEVEL_3};
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CAMERA_HW_LEVEL_LEGACY = new CAMERA_HW_LEVEL("CAMERA_HW_LEVEL_LEGACY", 0);
            CAMERA_HW_LEVEL_LIMITED = new CAMERA_HW_LEVEL("CAMERA_HW_LEVEL_LIMITED", 1);
            CAMERA_HW_LEVEL_FULL = new CAMERA_HW_LEVEL("CAMERA_HW_LEVEL_FULL", 2);
            CAMERA_HW_LEVEL_LEVEL_3 = new CAMERA_HW_LEVEL("CAMERA_HW_LEVEL_LEVEL_3", 3);
            $VALUES = $values();
            CREATOR = new a();
        }

        public static CAMERA_HW_LEVEL[] values() {
            return (CAMERA_HW_LEVEL[]) $VALUES.clone();
        }

        public static CAMERA_HW_LEVEL valueOf(String r100) {
            return (CAMERA_HW_LEVEL) r27.a.a(CAMERA_HW_LEVEL.class, r100);
        }

        private CAMERA_HW_LEVEL(String r100, int r101) {
            super(r100, r101);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeInt(ordinal());
        }
    }

    public static final enum CAMERA_MODE_TYPE extends Enum<CAMERA_MODE_TYPE> implements Parcelable {
        public static final CAMERA_MODE_TYPE AR_MODE = null;
        public static final Parcelable.Creator<CAMERA_MODE_TYPE> CREATOR = null;
        public static final CAMERA_MODE_TYPE IMAGE_MODE = null;
        public static final CAMERA_MODE_TYPE VIDEO_MODE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CAMERA_MODE_TYPE[] f455525a = null;

        public class a implements Parcelable.Creator<CAMERA_MODE_TYPE> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final CAMERA_MODE_TYPE createFromParcel(Parcel r100) {
                return CAMERA_MODE_TYPE.values()[r100.readInt()];
            }

            @Override // android.os.Parcelable.Creator
            public final CAMERA_MODE_TYPE[] newArray(int r100) {
                return new CAMERA_MODE_TYPE[r100];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CAMERA_MODE_TYPE r100 = new CAMERA_MODE_TYPE("VIDEO_MODE", 0);
            VIDEO_MODE = r100;
            CAMERA_MODE_TYPE r101 = new CAMERA_MODE_TYPE("IMAGE_MODE", 1);
            IMAGE_MODE = r101;
            CAMERA_MODE_TYPE r102 = new CAMERA_MODE_TYPE("AR_MODE", 2);
            AR_MODE = r102;
            f455525a = new CAMERA_MODE_TYPE[]{r100, r101, r102};
            CREATOR = new a();
        }

        public static CAMERA_MODE_TYPE[] values() {
            return (CAMERA_MODE_TYPE[]) f455525a.clone();
        }

        public static CAMERA_MODE_TYPE valueOf(String r100) {
            return (CAMERA_MODE_TYPE) r27.a.a(CAMERA_MODE_TYPE.class, r100);
        }

        public CAMERA_MODE_TYPE(String r100, int r101) {
            super(r100, r101);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeInt(ordinal());
        }
    }

    public static final enum CAMERA_OUTPUT_AND_UPDATE_STRATEGY extends Enum<CAMERA_OUTPUT_AND_UPDATE_STRATEGY> {
        public static final CAMERA_OUTPUT_AND_UPDATE_STRATEGY STRATEGY_DEFAULT = null;
        public static final CAMERA_OUTPUT_AND_UPDATE_STRATEGY STRATEGY_ONETHREAD_ONEOUT = null;
        public static final CAMERA_OUTPUT_AND_UPDATE_STRATEGY STRATEGY_ONETHREAD_TWOOUT = null;
        public static final CAMERA_OUTPUT_AND_UPDATE_STRATEGY STRATEGY_TWOTHREAD_ONEOUT = null;
        public static final CAMERA_OUTPUT_AND_UPDATE_STRATEGY STRATEGY_TWOTHREAD_TWOOUT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CAMERA_OUTPUT_AND_UPDATE_STRATEGY[] f455526a = null;

        static {
            CAMERA_OUTPUT_AND_UPDATE_STRATEGY r100 = new CAMERA_OUTPUT_AND_UPDATE_STRATEGY("STRATEGY_DEFAULT", 0);
            STRATEGY_DEFAULT = r100;
            CAMERA_OUTPUT_AND_UPDATE_STRATEGY r101 = new CAMERA_OUTPUT_AND_UPDATE_STRATEGY("STRATEGY_ONETHREAD_ONEOUT", 1);
            STRATEGY_ONETHREAD_ONEOUT = r101;
            CAMERA_OUTPUT_AND_UPDATE_STRATEGY r102 = new CAMERA_OUTPUT_AND_UPDATE_STRATEGY("STRATEGY_ONETHREAD_TWOOUT", 2);
            STRATEGY_ONETHREAD_TWOOUT = r102;
            CAMERA_OUTPUT_AND_UPDATE_STRATEGY r103 = new CAMERA_OUTPUT_AND_UPDATE_STRATEGY("STRATEGY_TWOTHREAD_ONEOUT", 3);
            STRATEGY_TWOTHREAD_ONEOUT = r103;
            CAMERA_OUTPUT_AND_UPDATE_STRATEGY r104 = new CAMERA_OUTPUT_AND_UPDATE_STRATEGY("STRATEGY_TWOTHREAD_TWOOUT", 4);
            STRATEGY_TWOTHREAD_TWOOUT = r104;
            f455526a = new CAMERA_OUTPUT_AND_UPDATE_STRATEGY[]{r100, r101, r102, r103, r104};
        }

        public static CAMERA_OUTPUT_AND_UPDATE_STRATEGY[] values() {
            return (CAMERA_OUTPUT_AND_UPDATE_STRATEGY[]) f455526a.clone();
        }

        public static CAMERA_OUTPUT_AND_UPDATE_STRATEGY valueOf(String r100) {
            return (CAMERA_OUTPUT_AND_UPDATE_STRATEGY) r27.a.a(CAMERA_OUTPUT_AND_UPDATE_STRATEGY.class, r100);
        }

        public CAMERA_OUTPUT_AND_UPDATE_STRATEGY(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum CAMERA_OUTPUT_MODE extends Enum<CAMERA_OUTPUT_MODE> implements Parcelable {
        private static final /* synthetic */ CAMERA_OUTPUT_MODE[] $VALUES = null;
        public static final Parcelable.Creator<CAMERA_OUTPUT_MODE> CREATOR = null;
        public static final CAMERA_OUTPUT_MODE FRAME = null;
        public static final CAMERA_OUTPUT_MODE SURFACE = null;
        public static final CAMERA_OUTPUT_MODE SURFACE_FRAME = null;
        public static final CAMERA_OUTPUT_MODE TWO_SURFACES = null;

        public class a implements Parcelable.Creator<CAMERA_OUTPUT_MODE> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final CAMERA_OUTPUT_MODE createFromParcel(Parcel r100) {
                return CAMERA_OUTPUT_MODE.values()[r100.readInt()];
            }

            @Override // android.os.Parcelable.Creator
            public final CAMERA_OUTPUT_MODE[] newArray(int r100) {
                return new CAMERA_OUTPUT_MODE[r100];
            }
        }

        private static /* synthetic */ CAMERA_OUTPUT_MODE[] $values() {
            return new CAMERA_OUTPUT_MODE[]{SURFACE, FRAME, SURFACE_FRAME, TWO_SURFACES};
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            SURFACE = new CAMERA_OUTPUT_MODE("SURFACE", 0);
            FRAME = new CAMERA_OUTPUT_MODE("FRAME", 1);
            SURFACE_FRAME = new CAMERA_OUTPUT_MODE("SURFACE_FRAME", 2);
            TWO_SURFACES = new CAMERA_OUTPUT_MODE("TWO_SURFACES", 3);
            $VALUES = $values();
            CREATOR = new a();
        }

        public static CAMERA_OUTPUT_MODE[] values() {
            return (CAMERA_OUTPUT_MODE[]) $VALUES.clone();
        }

        public static CAMERA_OUTPUT_MODE valueOf(String r100) {
            return (CAMERA_OUTPUT_MODE) r27.a.a(CAMERA_OUTPUT_MODE.class, r100);
        }

        private CAMERA_OUTPUT_MODE(String r100, int r101) {
            super(r100, r101);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeInt(ordinal());
        }
    }

    public static final enum CAMERA_TYPE extends Enum<CAMERA_TYPE> implements Parcelable {
        private static final /* synthetic */ CAMERA_TYPE[] $VALUES = null;
        public static final Parcelable.Creator<CAMERA_TYPE> CREATOR = null;
        public static final CAMERA_TYPE NULL = null;
        public static final CAMERA_TYPE TYPE1 = null;
        public static final CAMERA_TYPE TYPE2 = null;
        public static final CAMERA_TYPE TYPE_OGXM_V2 = null;
        public final int value;

        public class a implements Parcelable.Creator<CAMERA_TYPE> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final CAMERA_TYPE createFromParcel(Parcel r100) {
                return CAMERA_TYPE.values()[r100.readInt()];
            }

            @Override // android.os.Parcelable.Creator
            public final CAMERA_TYPE[] newArray(int r100) {
                return new CAMERA_TYPE[r100];
            }
        }

        private static /* synthetic */ CAMERA_TYPE[] $values() {
            return new CAMERA_TYPE[]{NULL, TYPE1, TYPE2, TYPE_OGXM_V2};
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            NULL = new CAMERA_TYPE("NULL", 0, 0);
            TYPE1 = new CAMERA_TYPE("TYPE1", 1, 1);
            TYPE2 = new CAMERA_TYPE("TYPE2", 2, 2);
            TYPE_OGXM_V2 = new CAMERA_TYPE("TYPE_OGXM_V2", 3, 8);
            $VALUES = $values();
            CREATOR = new a();
        }

        public static CAMERA_TYPE[] values() {
            return (CAMERA_TYPE[]) $VALUES.clone();
        }

        public static CAMERA_TYPE valueOf(String r100) {
            return (CAMERA_TYPE) r27.a.a(CAMERA_TYPE.class, r100);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeInt(ordinal());
        }

        private CAMERA_TYPE(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum FACEAE_STRATEGY extends Enum<FACEAE_STRATEGY> {
        public static final FACEAE_STRATEGY DISABLE_FACEAE = null;
        public static final FACEAE_STRATEGY ENABLE_FACEAE_FOR_ALL = null;
        public static final FACEAE_STRATEGY ENABLE_FACEAE_FOR_FRONT = null;
        public static final FACEAE_STRATEGY ENABLE_FACEAE_FOR_REAR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FACEAE_STRATEGY[] f455527a = null;

        static {
            FACEAE_STRATEGY r100 = new FACEAE_STRATEGY("DISABLE_FACEAE", 0);
            DISABLE_FACEAE = r100;
            FACEAE_STRATEGY r101 = new FACEAE_STRATEGY("ENABLE_FACEAE_FOR_FRONT", 1);
            ENABLE_FACEAE_FOR_FRONT = r101;
            FACEAE_STRATEGY r102 = new FACEAE_STRATEGY("ENABLE_FACEAE_FOR_REAR", 2);
            ENABLE_FACEAE_FOR_REAR = r102;
            FACEAE_STRATEGY r103 = new FACEAE_STRATEGY("ENABLE_FACEAE_FOR_ALL", 3);
            ENABLE_FACEAE_FOR_ALL = r103;
            f455527a = new FACEAE_STRATEGY[]{r100, r101, r102, r103};
        }

        public static FACEAE_STRATEGY[] values() {
            return (FACEAE_STRATEGY[]) f455527a.clone();
        }

        public static FACEAE_STRATEGY valueOf(String r100) {
            return (FACEAE_STRATEGY) r27.a.a(FACEAE_STRATEGY.class, r100);
        }

        public FACEAE_STRATEGY(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum PREVIEW_SIZE_STRATEGY extends Enum<PREVIEW_SIZE_STRATEGY> {
        public static final PREVIEW_SIZE_STRATEGY DEFAULT = null;
        public static final PREVIEW_SIZE_STRATEGY MATCH_BY_PIXELS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PREVIEW_SIZE_STRATEGY[] f455528a = null;

        static {
            PREVIEW_SIZE_STRATEGY r100 = new PREVIEW_SIZE_STRATEGY("DEFAULT", 0);
            DEFAULT = r100;
            PREVIEW_SIZE_STRATEGY r101 = new PREVIEW_SIZE_STRATEGY("MATCH_BY_PIXELS", 1);
            MATCH_BY_PIXELS = r101;
            f455528a = new PREVIEW_SIZE_STRATEGY[]{r100, r101};
        }

        public static PREVIEW_SIZE_STRATEGY[] values() {
            return (PREVIEW_SIZE_STRATEGY[]) f455528a.clone();
        }

        public static PREVIEW_SIZE_STRATEGY valueOf(String r100) {
            return (PREVIEW_SIZE_STRATEGY) r27.a.a(PREVIEW_SIZE_STRATEGY.class, r100);
        }

        public PREVIEW_SIZE_STRATEGY(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements Parcelable.Creator<VECameraSettings> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VECameraSettings createFromParcel(Parcel r100) {
            return new VECameraSettings(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VECameraSettings[] newArray(int r100) {
            return new VECameraSettings[r100];
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f455529a;

        public b() {
            this.f455529a = 2;
        }

        public int getType() {
            return this.f455529a;
        }
    }

    public interface c {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        TAG = "VECameraSettings";
        sCameraSceneMode = new String[]{"auto", "action", "barcode", "beach", "candlelight", "fireworks", "hdr", "landscape", "night", "night-portrait", "party", "portrait", "snow", "sports", "steadyphoto", "sunset", "theatre"};
        CREATOR = new a();
    }

    public static CAMERA_OUTPUT_AND_UPDATE_STRATEGY getCameraOutputAndUpdateStrategy() {
        CAMERA_OUTPUT_AND_UPDATE_STRATEGY r100 = CAMERA_OUTPUT_AND_UPDATE_STRATEGY.STRATEGY_DEFAULT;
        int r101 = VEConfigCenter.getInstance().getValue("ve_camera_output_and_update_strategy", 0);
        if (r101 != 1) goto L6;
        r100 = CAMERA_OUTPUT_AND_UPDATE_STRATEGY.STRATEGY_ONETHREAD_ONEOUT;
    L14:
        VELogUtil.i(TAG, "ve_camera_output_and_update_strategy: " + r101 + ", enum:" + r100);
        return r100;
    L6:
        if (r101 != 2) goto L9;
        r100 = CAMERA_OUTPUT_AND_UPDATE_STRATEGY.STRATEGY_ONETHREAD_TWOOUT;
        goto L14
    L9:
        if (r101 != 3) goto L12;
        r100 = CAMERA_OUTPUT_AND_UPDATE_STRATEGY.STRATEGY_TWOTHREAD_ONEOUT;
        goto L14
    L12:
        if (r101 != 4) goto L14;
        r100 = CAMERA_OUTPUT_AND_UPDATE_STRATEGY.STRATEGY_TWOTHREAD_TWOOUT;
        goto L14
    }

    public boolean getCameraAntiShake() {
        if (this.mCameraAntiShake == true) goto L8;
        if (VEConfigCenter.getInstance().getValue("ve_camera_stabilization_mode", -1) == (-1)) goto L8;
        this.mCameraAntiShake = true;
    L8:
        return this.mCameraAntiShake;
    }

    public int getCameraAntiShakeMode() {
        if (this.mCameraAntiShakeMode != (-1)) goto L6;
        this.mCameraAntiShakeMode = VEConfigCenter.getInstance().getValue("ve_camera_stabilization_mode", -1);
    L6:
        return this.mCameraAntiShakeMode;
    }

    public CAMERA_CAPTURE_YUV_STRATEGY getCameraCaptureYuvStrategy() {
        CAMERA_CAPTURE_YUV_STRATEGY r100 = this.mCameraCaptureYuvStrategy;
        CAMERA_CAPTURE_YUV_STRATEGY r101 = CAMERA_CAPTURE_YUV_STRATEGY.DISABLE;
        boolean r102 = false;
        if (r100 != r101) goto L19;
        boolean r103 = VEConfigCenter.getInstance().getValue("ve_enable_yuv_buffer_capture_block", false).booleanValue();
        int r104 = VEConfigCenter.getInstance().getValue(TECameraConfigKey.KEY_ENABLE_YUV_BUFFER_CAPTURE, 0);
        if (r104 != 1) goto L8;
        this.mCameraCaptureYuvStrategy = CAMERA_CAPTURE_YUV_STRATEGY.ENABLE_FOR_FRONT;
    L15:
        if (this.mCameraMode != CAMERA_MODE_TYPE.VIDEO_MODE) goto L18;
        if (r103 == false) goto L18;
        this.mCameraCaptureYuvStrategy = r101;
    L18:
        r102 = r103;
        goto L19
    L8:
        if (r104 != 2) goto L11;
        this.mCameraCaptureYuvStrategy = CAMERA_CAPTURE_YUV_STRATEGY.ENABLE_FOR_REAR;
        goto L15
    L11:
        if (r104 != 3) goto L13;
        this.mCameraCaptureYuvStrategy = CAMERA_CAPTURE_YUV_STRATEGY.ENABLE_FOR_ALL;
        goto L15
    L13:
        this.mCameraCaptureYuvStrategy = r101;
    L19:
        VELogUtil.i(TAG, "getCameraCaptureYuvStrategy last=" + r100 + ", new=" + this.mCameraCaptureYuvStrategy + ", isBlock=" + r102);
        return this.mCameraCaptureYuvStrategy;
    }

    public CAMERA_FRAMERATE_STRATEGY getCameraFrameRateStrategy() {
        CAMERA_FRAMERATE_STRATEGY r100 = this.mCameraFrameRateStrategy;
        CAMERA_FRAMERATE_STRATEGY r101 = CAMERA_FRAMERATE_STRATEGY.DYNAMIC_FRAMERATE;
        if (r100 != r101) goto L15;
        Integer r102 = Integer.valueOf(VEConfigCenter.getInstance().getValue("frame_rate_strategy", 0));
        if (r102.intValue() != 1) goto L8;
        this.mCameraFrameRateStrategy = CAMERA_FRAMERATE_STRATEGY.FIXED_FRAMERATE_FOR_ALL;
        goto L15
    L8:
        if (r102.intValue() != 2) goto L11;
        this.mCameraFrameRateStrategy = CAMERA_FRAMERATE_STRATEGY.FIXED_FRAMERATE_FOR_REAR;
        goto L15
    L11:
        if (r102.intValue() != 3) goto L13;
        this.mCameraFrameRateStrategy = CAMERA_FRAMERATE_STRATEGY.DYNAMIC_FRAMERATE_WITHOUT_SELECT;
        goto L15
    L13:
        this.mCameraFrameRateStrategy = r101;
    L15:
        return this.mCameraFrameRateStrategy;
    }

    public CAMERA_TYPE getCameraType() {
        if (this.mIsUseNewCameraTypeStrategy == true) goto L7;
        return this.mCameraType;
    L7:
        if (this.mConfigCameraType != CAMERA_TYPE.NULL) goto L10;
        this.mConfigCameraType = getCameraTypeFromConfigCenter(this.mDefaultCameraTypeInNewCameraStrategy, this.mbDontUseVendorCamera);
    L10:
        return this.mConfigCameraType;
    }

    public int getCameraZslStrategy() {
        if (this.mEnableZslStrategy == true) goto L6;
        return 0;
    L6:
        if (this.mCameraMode != CAMERA_MODE_TYPE.VIDEO_MODE) goto L9;
        return 8;
    L9:
        if (VEConfigCenter.getInstance().getValue("ve_enable_camera2_single_picture_stream", false).booleanValue() == false) goto L11;
        return 8;
    L11:
        int r100 = getSupportedTakePictureZslModes();
        boolean r101 = VEConfigCenter.getInstance().getValue(TECameraConfigKey.KEY_ENABLE_CAMERA2_ZSL_CAPTURE, false).booleanValue();
        if (VEConfigCenter.getInstance().getValue("ve_enable_camera2_zsl_capture_v2", false).booleanValue() == true) goto L14;
    L16:
        if (r101 == false) goto L21;
        if ((r100 & 2) != 2) goto L21;
        return 2;
    L21:
        if (VEConfigCenter.getInstance().getValue("ve_enable_camera1_zsl_capture", false).booleanValue() == true) goto L23;
    L25:
        return 0;
    L23:
        if ((r100 & 1) != 1) goto L25;
        return 1;
    L14:
        if ((r100 & 4) != 4) goto L16;
        return 4;
    }

    public boolean getDualCameraExtensionScheme() {
        if (this.mbDualCameraExpansionScheme == true) goto L6;
        this.mbDualCameraExpansionScheme = VEConfigCenter.getInstance().getValue("ve_dual_camera_expansion_scheme", false).booleanValue();
    L6:
        return this.mbDualCameraExpansionScheme;
    }

    public boolean getEnableZsl() {
        boolean r100 = this.mEnableZsl;
        if (r100 == false) goto L5;
        return r100;
    L5:
        return VEConfigCenter.getInstance().getValue("ve_enable_camera1_zsl_capture", false).booleanValue();
    }

    public int getFpsMaxLimit() {
        if (this.mFpsMaxLimit != 30) goto L10;
        VEConfigCenter.ValuePkt r100 = VEConfigCenter.getInstance().getValue("ve_camera_fps_max");
        if (r100 == null) goto L10;
        if ((r100.getValue() instanceof Integer) == false) goto L10;
        this.mFpsMaxLimit = ((Integer) r100.getValue()).intValue();
    L10:
        return this.mFpsMaxLimit;
    }

    public int[] getFpsRange() {
        if (this.mCameraFrameRateStrategy != CAMERA_FRAMERATE_STRATEGY.DYNAMIC_FRAMERATE_WITHOUT_SELECT) goto L5;
    L9:
        VELogUtil.i(TAG, "Camera FpsRange:[" + this.mFpsRange[0] + ", " + this.mFpsRange[1] + "]");
        return this.mFpsRange;
    L5:
        if (this.mFpsRange[0] != 7) goto L9;
        int r100 = VEConfigCenter.getInstance().getValue("ve_camera_fps_range", 7);
        if (r100 == 0) goto L9;
        this.mFpsRange[0] = r100;
        goto L9
    }

    public boolean isEnableGyroFocusAndMeter() {
        if (this.mEnableGyroFocusAndMeter == false) goto L5;
    L6:
        return true;
    L5:
        if (VEConfigCenter.getInstance().getValue(TECameraConfigKey.KEY_ENABLE_CAMERA2_MONITOR_GYROSCOPE, false).booleanValue() == true) goto L6;
        return false;
    }

    public boolean isEnableRefactorFocusAndMeter() {
        if (this.mEnableRefactorFocusAndMeter == true) goto L6;
        boolean r100 = false;
        if (VEConfigCenter.getInstance().getValue(TECameraConfigKey.KEY_ENABLE_REFACTOR_CAMERA_FOCUS, false).booleanValue() == true) goto L6;
    L7:
        this.mEnableRefactorFocusAndMeter = r100;
        return r100;
    L6:
        r100 = true;
        goto L7
    }

    public boolean isOptCameraSceneFps() {
        if (this.mOptCameraSceneFps == false) goto L5;
    L6:
        return true;
    L5:
        if (VEConfigCenter.getInstance().getValue("ve_camera_scene_diff_fps_opt", false).booleanValue() == true) goto L6;
        return false;
    }

    private VECameraSettings() {
        this.CameraHWLevelTE2Android = new int[]{2, 0, 1, 3};
        this.CameraHWLevelAndroid2TE = new int[]{1, 2, 0, 3};
        this.mFps = 30;
        this.mPreviewSize = new VESize(720, 1280);
        this.mFpsRange = new int[]{7, 30};
        this.mHwLevel = CAMERA_HW_LEVEL.CAMERA_HW_LEVEL_LEGACY;
        CAMERA_TYPE r100 = CAMERA_TYPE.TYPE1;
        this.mCameraType = r100;
        this.mConfigCameraType = CAMERA_TYPE.NULL;
        this.mIsUseNewCameraTypeStrategy = false;
        this.mDefaultCameraTypeInNewCameraStrategy = CAMERA_TYPE.TYPE2;
        this.mbDontUseVendorCamera = false;
        CAMERA_FACING_ID r101 = CAMERA_FACING_ID.FACING_FRONT;
        this.mCameraFacing = r101;
        this.mStrCameraHardwareID = "-1";
        this.mSceneMode = "auto";
        this.mCameraAntiShake = false;
        this.mCameraAntiShakeMode = 0;
        this.mbDualCameraExpansionScheme = false;
        this.mbEnablePreviewMetadataCallback = false;
        this.mCameraFrameRateStrategy = CAMERA_FRAMERATE_STRATEGY.DYNAMIC_FRAMERATE;
        this.mFaceAEStrategy = FACEAE_STRATEGY.DISABLE_FACEAE;
        this.mEnableWideFOV = false;
        this.mIsUseHint = false;
        this.mEnableSurfaceSharing = false;
        this.mIsCameraOpenCloseSync = true;
        this.mIsForceCloseCamera = false;
        this.mEnableVBoost = false;
        this.mVBoostTimeoutMS = 50;
        this.mFocusTimeoutMS = CustomToast.LENGTH_SHORT;
        this.mEnableGcForCameraMetadataThreshold = 0;
        this.mFpsMaxLimit = 30;
        this.mOptCameraSceneFps = false;
        this.mCameraCaptureYuvStrategy = CAMERA_CAPTURE_YUV_STRATEGY.DISABLE;
        this.mUseMaxWidthTakePicture = false;
        this.mEnableStopRepeatingBeforeCapture = false;
        this.mMaxWidthTakePictureSizeAccuracy = 0.0f;
        this.mMaxWidth = 0;
        this.mEnablePreviewTemplate = false;
        this.mOptionFlags = 1;
        this.mCaptureSize = new VESize(-1, -1);
        this.mOutputMode = CAMERA_OUTPUT_MODE.SURFACE;
        this.mEnableFallback = true;
        this.mCameraMode = CAMERA_MODE_TYPE.VIDEO_MODE;
        this.mUseSyncModeOnCamera2 = false;
        this.mCameraZoomLimitFactor = -1.0f;
        this.mEnableZsl = false;
        this.mEnableManualReleaseCaptureResult = true;
        this.mRetryCnt = 0;
        this.mRetryStartPreviewCnt = 0;
        this.mEnableRecordStream = false;
        this.mEnableRecord60Fps = false;
        this.mRecordStreamFolderPath = "";
        this.mCamera2RetryCnt = 1;
        this.mEnableHDR10BitRecord = false;
        this.mDynamicRangeProfile = 1;
        this.mCaptureFlashStrategy = CAMERA_CAPTURE_FLASH_STRATEGY.FlashOnSimulatedStrategy;
        this.mCameraPreviewIndependent = false;
        this.mPreferOpenCameraByCameraId = false;
        this.mEnablePreviewingFallback = false;
        this.mEnableBackGroundStrategy = false;
        this.mEnableOpenCamera1Opt = false;
        this.mEnableOpenCamera1Crs = false;
        this.mEnableRefactorFocusAndMeter = false;
        this.mEnableGyroFocusAndMeter = false;
        this.mEnableForceRestartWhenCameraError = false;
        this.mBindSurfaceLifecycleToCamera = false;
        this.mEnableMonitorRuntimeInfo = false;
        this.mRuntimeInfoMonitorPeriod = 5000;
        this.mEnableZslStrategy = false;
        this.mbEnableCamera2ZSL = false;
        this.mbEnableTakePicture4VideoMode = false;
        this.mbEnableDynamicSwitch = false;
        this.mCameraPrivacyCertMap = null;
        this.mPreviewSizeStrategy = PREVIEW_SIZE_STRATEGY.DEFAULT;
        this.mVESetCameraTwoOutputMode = false;
        this.mDefaultZoomRatio = 1.0f;
        this.mDefaultZoomUsingZoomV2 = true;
        this.mCameraType = r100;
        this.mCameraFacing = r101;
        this.mFps = 30;
        VESize r102 = this.mPreviewSize;
        r102.width = 720;
        r102.height = 1280;
        this.mExtParameters = new Bundle();
        setEnableStopRepeatingBeforeCapture(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    private int getSupportedTakePictureZslModes() {
        boolean r100 = VEConfigCenter.getInstance().getValue("ve_support_camera1_zsl", false).booleanValue();
        boolean r101 = VEConfigCenter.getInstance().getValue("ve_support_camera2_zsl", false).booleanValue();
        boolean r102 = VEConfigCenter.getInstance().getValue("ve_support_camera2_zsl_v2", false).booleanValue();
        ?? r103 = r100;
        if (r101 == false) goto L5;
        r103 = (r100 ? 1 : 0) | 2;
    L5:
        if (r102 == true) goto L7;
        return r103;
    L7:
        return r103 | 4;
    }

    public boolean getCameraCaptureHdrFromCenter() {
        VEConfigCenter.ValuePkt r100 = VEConfigCenter.getInstance().getValue("ve_camera_capture_hdr");
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (r100.getValue() == null) goto L9;
        if ((r100.getValue() instanceof Boolean) == false) goto L9;
        return ((Boolean) r100.getValue()).booleanValue();
    }

    public int getCameraCaptureMFNRFromCenter() {
        VEConfigCenter.ValuePkt r100 = VEConfigCenter.getInstance().getValue("key_camera_capture_mfnr");
        if (r100 != null) goto L5;
    L9:
        return 0;
    L5:
        if (r100.getValue() == null) goto L9;
        if ((r100.getValue() instanceof Integer) == false) goto L9;
        return ((Integer) r100.getValue()).intValue();
    }

    public FACEAE_STRATEGY getCameraFaceDetect() {
        int r100 = VEConfigCenter.getInstance().getValue(TECameraConfigKey.KEY_ENABLE_FACE_DETECTION, 0);
        if (r100 != 1) goto L6;
        this.mFaceAEStrategy = FACEAE_STRATEGY.ENABLE_FACEAE_FOR_FRONT;
    L11:
        this.mExtParameters.putInt("useCameraFaceDetect", this.mFaceAEStrategy.ordinal());
        VELogUtil.i(TAG, "faceae strategy: " + r100 + ", enum:" + this.mFaceAEStrategy);
        return this.mFaceAEStrategy;
    L6:
        if (r100 != 2) goto L9;
        this.mFaceAEStrategy = FACEAE_STRATEGY.ENABLE_FACEAE_FOR_REAR;
        goto L11
    L9:
        if (r100 != 3) goto L11;
        this.mFaceAEStrategy = FACEAE_STRATEGY.ENABLE_FACEAE_FOR_ALL;
        goto L11
    }

    public boolean getCameraHdrDisableFromCenter() {
        VEConfigCenter.ValuePkt r100 = VEConfigCenter.getInstance().getValue("ve_disable_camera_hdr");
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (r100.getValue() == null) goto L9;
        if ((r100.getValue() instanceof Boolean) == false) goto L9;
        return ((Boolean) r100.getValue()).booleanValue();
    }

    public boolean getCameraNoiseReduceFromCenter() {
        VEConfigCenter.ValuePkt r100 = VEConfigCenter.getInstance().getValue("ve_enable_camera_noise_reduce");
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (r100.getValue() == null) goto L9;
        if ((r100.getValue() instanceof Boolean) == false) goto L9;
        return ((Boolean) r100.getValue()).booleanValue();
    }

    public boolean getCameraRDHWRecordDisableFromCenter() {
        VEConfigCenter.ValuePkt r100 = VEConfigCenter.getInstance().getValue("ve_camera_disable_rdhw_record");
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (r100.getValue() == null) goto L9;
        if ((r100.getValue() instanceof Boolean) == false) goto L9;
        return ((Boolean) r100.getValue()).booleanValue();
    }

    public boolean getCameraVideoModeTemplate() {
        boolean r100 = VEConfigCenter.getInstance().getValue("ve_enable_camera_preview_template", this.mEnablePreviewTemplate).booleanValue();
        this.mEnablePreviewTemplate = r100;
        this.mExtParameters.putBoolean("enablePreviewTemplate", r100);
        return this.mEnablePreviewTemplate;
    }

    public int getEnableGcForCameraMetadataThreshold() {
        int r100 = VEConfigCenter.getInstance().getValue("ve_enable_gc_for_camera_metadata", 0);
        this.mEnableGcForCameraMetadataThreshold = r100;
        return r100;
    }

    public boolean getEnableSurfaceSharing() {
        boolean r100 = VEConfigCenter.getInstance().getValue("ve_camera_enable_surface_sharing", this.mEnableSurfaceSharing).booleanValue();
        this.mEnableSurfaceSharing = r100;
        return r100;
    }

    public boolean getEnableVBoost() {
        boolean r100 = VEConfigCenter.getInstance().getValue("ve_enable_vboost_v2", this.mEnableVBoost).booleanValue();
        if (VEConfigCenter.getInstance().getValue("ve_enable_vboost", this.mEnableVBoost).booleanValue() == true) goto L7;
        if (r100 == true) goto L7;
        boolean r101 = false;
    L8:
        this.mEnableVBoost = r101;
        return r101;
    L7:
        r101 = true;
        goto L8
    }

    public int getFocusTimeout() {
        int r100 = VEConfigCenter.getInstance().getValue("ve_camera_focus_timeout", CustomToast.LENGTH_SHORT);
        this.mFocusTimeoutMS = r100;
        return r100;
    }

    public boolean getIsCameraOpenCloseSync() {
        boolean r100 = VEConfigCenter.getInstance().getValue("ve_camera_open_close_sync", this.mIsCameraOpenCloseSync).booleanValue();
        this.mIsCameraOpenCloseSync = r100;
        return r100;
    }

    public boolean getIsForceCloseCamera() {
        boolean r100 = VEConfigCenter.getInstance().getValue("ve_force_close_camera_when_timeout", this.mIsForceCloseCamera).booleanValue();
        this.mIsForceCloseCamera = r100;
        return r100;
    }

    public boolean getIsUseHint() {
        boolean r100 = VEConfigCenter.getInstance().getValue("is_use_setrecordinghint", this.mIsUseHint).booleanValue();
        this.mIsUseHint = r100;
        return r100;
    }

    public boolean getMetadataConfig() {
        VEConfigCenter.ValuePkt r100 = VEConfigCenter.getInstance().getValue("ve_enable_camera_metadata");
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (r100.getValue() == null) goto L9;
        if ((r100.getValue() instanceof Boolean) == false) goto L9;
        return ((Boolean) r100.getValue()).booleanValue();
    }

    public int getRetryCnt() {
        int r100 = VEConfigCenter.getInstance().getValue("ve_retry_count", 0);
        if (r100 == 0) goto L6;
        this.mRetryCnt = r100;
    L6:
        return this.mRetryCnt;
    }

    public int getVBoostTimeout() {
        int r100 = VEConfigCenter.getInstance().getValue("ve_vboost_timeout", 500);
        this.mVBoostTimeoutMS = r100;
        return r100;
    }

    public boolean getWideFOV() {
        this.mEnableWideFOV = VEConfigCenter.getInstance().getValue("ve_enable_wide_fov_for_samsung", this.mEnableWideFOV).booleanValue();
        VELogUtil.d(TAG, "getWideFOV: " + this.mEnableWideFOV);
        return this.mEnableWideFOV;
    }

    public int getmRetryStartPreviewCnt() {
        int r100 = VEConfigCenter.getInstance().getValue("ve_retry_start_preview_count", 0);
        if (r100 == 0) goto L6;
        this.mRetryStartPreviewCnt = r100;
    L6:
        return this.mRetryStartPreviewCnt;
    }

    public boolean isEnableCameraFpsDoubleCheckInImageMode() {
        return VEConfigCenter.getInstance().getValue("ve_enable_camera_fps_double_check_in_image_mode", true).booleanValue();
    }

    public boolean isUseMaxWidthTakePicture() {
        if (VEConfigCenter.getInstance().getValue("ve_enable_yuv_buffer_capture_compat_mode", false).booleanValue() == false) goto L6;
        this.mUseMaxWidthTakePicture = true;
        this.mMaxWidth = 4096;
    L6:
        return this.mUseMaxWidthTakePicture;
    }

    public boolean isVESetCameraTwoOutputMode() {
        CAMERA_OUTPUT_AND_UPDATE_STRATEGY r100 = getCameraOutputAndUpdateStrategy();
        if (r100 != CAMERA_OUTPUT_AND_UPDATE_STRATEGY.STRATEGY_ONETHREAD_TWOOUT) goto L5;
    L8:
        boolean r101 = true;
    L9:
        this.mVESetCameraTwoOutputMode = r101;
        return r101;
    L5:
        if (r100 == CAMERA_OUTPUT_AND_UPDATE_STRATEGY.STRATEGY_TWOTHREAD_TWOOUT) goto L8;
        r101 = false;
        if (VEConfigCenter.getInstance().getValue("ve_set_camera_two_output", false).booleanValue() == false) goto L9;
        goto L8
    }

    public CAMERA_MODE_TYPE getCamera2OutputMode() {
        return this.mCameraMode;
    }

    public int getCamera2RetryCnt() {
        return this.mCamera2RetryCnt;
    }

    public CAMERA_FACING_ID getCameraFacing() {
        return this.mCameraFacing;
    }

    public String getCameraHardwareID() {
        return this.mStrCameraHardwareID;
    }

    public HashMap<TECameraSettings.TECameraPrivacyCertType, Cert> getCameraPrivacyCertMap() {
        return this.mCameraPrivacyCertMap;
    }

    public float getCameraZoomLimitFactor() {
        return this.mCameraZoomLimitFactor;
    }

    public CAMERA_CAPTURE_FLASH_STRATEGY getCaptureFlashStrategy() {
        return this.mCaptureFlashStrategy;
    }

    public VESize getCaptureSize() {
        return this.mCaptureSize;
    }

    public Object getCustomCameraTag() {
        return this.customCameraTag;
    }

    public float getDefaultZoomRatio() {
        return this.mDefaultZoomRatio;
    }

    public boolean getDefaultZoomUsingZoomV2() {
        return this.mDefaultZoomUsingZoomV2;
    }

    public boolean getDontUseVendorCamera() {
        return this.mbDontUseVendorCamera;
    }

    public long getDynamicRangeProfile() {
        return this.mDynamicRangeProfile;
    }

    public boolean getEnableCameraZsl() {
        return this.mbEnableCamera2ZSL;
    }

    public boolean getEnableFallback() {
        return this.mEnableFallback;
    }

    public boolean getEnableHDR10BitRecord() {
        return this.mEnableHDR10BitRecord;
    }

    public boolean getEnableManualReleaseCaptureResult() {
        return this.mEnableManualReleaseCaptureResult;
    }

    public boolean getEnableRecord60Fps() {
        return this.mEnableRecord60Fps;
    }

    public boolean getEnableRecordStream() {
        return this.mEnableRecordStream;
    }

    public Bundle getExtParameters() {
        return this.mExtParameters;
    }

    public int getFps() {
        return this.mFps;
    }

    public CAMERA_HW_LEVEL getHwLevel() {
        return this.mHwLevel;
    }

    public boolean getIsUseNewCameraTypeStrategy() {
        return this.mIsUseNewCameraTypeStrategy;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public float getMaxWidthTakePictureSizeAccuracy() {
        return this.mMaxWidthTakePictureSizeAccuracy;
    }

    public long getMonitorRuntimeInfoPeriod() {
        return this.mRuntimeInfoMonitorPeriod;
    }

    public byte getOptionFlag() {
        return this.mOptionFlags;
    }

    public CAMERA_OUTPUT_MODE getOutputMode() {
        return this.mOutputMode;
    }

    public VESize getPreviewSize() {
        return this.mPreviewSize;
    }

    public PREVIEW_SIZE_STRATEGY getPreviewSizeStrategy() {
        return this.mPreviewSizeStrategy;
    }

    public String getRecordStreamFolderPath() {
        return this.mRecordStreamFolderPath;
    }

    public String getSceneMode() {
        return this.mSceneMode;
    }

    public boolean isBindSurfaceLifecycleToCamera() {
        return this.mBindSurfaceLifecycleToCamera;
    }

    public boolean isCameraPreviewIndependent() {
        return this.mCameraPreviewIndependent;
    }

    public boolean isEnableBackGroundStrategy() {
        return this.mEnableBackGroundStrategy;
    }

    public boolean isEnableDynamicSwitch() {
        return this.mbEnableDynamicSwitch;
    }

    public boolean isEnableForceRestartWhenCameraError() {
        return this.mEnableForceRestartWhenCameraError;
    }

    public boolean isEnableMonitorRuntimeInfo() {
        return this.mEnableMonitorRuntimeInfo;
    }

    public boolean isEnableOpenCamera1Crs() {
        return this.mEnableOpenCamera1Crs;
    }

    public boolean isEnableOpenCamera1Opt() {
        return this.mEnableOpenCamera1Opt;
    }

    public boolean isEnablePreviewMetadataCallback() {
        return this.mbEnablePreviewMetadataCallback;
    }

    public boolean isEnablePreviewingFallback() {
        return this.mEnablePreviewingFallback;
    }

    public boolean isEnableStopRepeatingBeforeCapture() {
        return this.mEnableStopRepeatingBeforeCapture;
    }

    public boolean isEnableTakePicture4VideoMode() {
        return this.mbEnableTakePicture4VideoMode;
    }

    public boolean isPreferOpenCameraByCameraId() {
        return this.mPreferOpenCameraByCameraId;
    }

    public boolean isSyncModeOnCamera2() {
        return this.mUseSyncModeOnCamera2;
    }

    public VECameraSettings(Parcel r100) {
        this.CameraHWLevelTE2Android = new int[]{2, 0, 1, 3};
        this.CameraHWLevelAndroid2TE = new int[]{1, 2, 0, 3};
        this.mFps = 30;
        this.mPreviewSize = new VESize(720, 1280);
        this.mFpsRange = new int[]{7, 30};
        this.mHwLevel = CAMERA_HW_LEVEL.CAMERA_HW_LEVEL_LEGACY;
        this.mCameraType = CAMERA_TYPE.TYPE1;
        this.mConfigCameraType = CAMERA_TYPE.NULL;
        boolean r101 = false;
        this.mIsUseNewCameraTypeStrategy = false;
        this.mDefaultCameraTypeInNewCameraStrategy = CAMERA_TYPE.TYPE2;
        this.mbDontUseVendorCamera = false;
        this.mCameraFacing = CAMERA_FACING_ID.FACING_FRONT;
        this.mStrCameraHardwareID = "-1";
        this.mSceneMode = "auto";
        this.mCameraAntiShake = false;
        this.mCameraAntiShakeMode = 0;
        this.mbDualCameraExpansionScheme = false;
        this.mbEnablePreviewMetadataCallback = false;
        this.mCameraFrameRateStrategy = CAMERA_FRAMERATE_STRATEGY.DYNAMIC_FRAMERATE;
        this.mFaceAEStrategy = FACEAE_STRATEGY.DISABLE_FACEAE;
        this.mEnableWideFOV = false;
        this.mIsUseHint = false;
        this.mEnableSurfaceSharing = false;
        this.mIsCameraOpenCloseSync = true;
        this.mIsForceCloseCamera = false;
        this.mEnableVBoost = false;
        this.mVBoostTimeoutMS = 50;
        this.mFocusTimeoutMS = CustomToast.LENGTH_SHORT;
        this.mEnableGcForCameraMetadataThreshold = 0;
        this.mFpsMaxLimit = 30;
        this.mOptCameraSceneFps = false;
        this.mCameraCaptureYuvStrategy = CAMERA_CAPTURE_YUV_STRATEGY.DISABLE;
        this.mUseMaxWidthTakePicture = false;
        this.mEnableStopRepeatingBeforeCapture = false;
        this.mMaxWidthTakePictureSizeAccuracy = 0.0f;
        this.mMaxWidth = 0;
        this.mEnablePreviewTemplate = false;
        this.mOptionFlags = 1;
        this.mCaptureSize = new VESize(-1, -1);
        this.mOutputMode = CAMERA_OUTPUT_MODE.SURFACE;
        this.mEnableFallback = true;
        this.mCameraMode = CAMERA_MODE_TYPE.VIDEO_MODE;
        this.mUseSyncModeOnCamera2 = false;
        this.mCameraZoomLimitFactor = -1.0f;
        this.mEnableZsl = false;
        this.mEnableManualReleaseCaptureResult = true;
        this.mRetryCnt = 0;
        this.mRetryStartPreviewCnt = 0;
        this.mEnableRecordStream = false;
        this.mEnableRecord60Fps = false;
        this.mRecordStreamFolderPath = "";
        this.mCamera2RetryCnt = 1;
        this.mEnableHDR10BitRecord = false;
        this.mDynamicRangeProfile = 1;
        this.mCaptureFlashStrategy = CAMERA_CAPTURE_FLASH_STRATEGY.FlashOnSimulatedStrategy;
        this.mCameraPreviewIndependent = false;
        this.mPreferOpenCameraByCameraId = false;
        this.mEnablePreviewingFallback = false;
        this.mEnableBackGroundStrategy = false;
        this.mEnableOpenCamera1Opt = false;
        this.mEnableOpenCamera1Crs = false;
        this.mEnableRefactorFocusAndMeter = false;
        this.mEnableGyroFocusAndMeter = false;
        this.mEnableForceRestartWhenCameraError = false;
        this.mBindSurfaceLifecycleToCamera = false;
        this.mEnableMonitorRuntimeInfo = false;
        this.mRuntimeInfoMonitorPeriod = 5000;
        this.mEnableZslStrategy = false;
        this.mbEnableCamera2ZSL = false;
        this.mbEnableTakePicture4VideoMode = false;
        this.mbEnableDynamicSwitch = false;
        CAMERA_CAPTURE_FLASH_STRATEGY r102 = null;
        this.mCameraPrivacyCertMap = null;
        this.mPreviewSizeStrategy = PREVIEW_SIZE_STRATEGY.DEFAULT;
        this.mVESetCameraTwoOutputMode = false;
        this.mDefaultZoomRatio = 1.0f;
        this.mDefaultZoomUsingZoomV2 = true;
        this.CameraHWLevelTE2Android = r100.createIntArray();
        this.CameraHWLevelAndroid2TE = r100.createIntArray();
        this.mFps = r100.readInt();
        this.mPreviewSize = (VESize) r100.readParcelable(VESize.class.getClassLoader());
        this.mFpsRange = r100.createIntArray();
        int r103 = r100.readInt();
        if (r103 != (-1)) goto L5;
        CAMERA_HW_LEVEL r104 = null;
    L6:
        this.mHwLevel = r104;
        int r105 = r100.readInt();
        if (r105 != (-1)) goto L9;
        CAMERA_TYPE r106 = null;
    L10:
        this.mCameraType = r106;
        int r107 = r100.readInt();
        if (r107 != (-1)) goto L13;
        CAMERA_TYPE r108 = null;
    L14:
        this.mConfigCameraType = r108;
        if (r100.readByte() == 0) goto L17;
        boolean r109 = true;
    L18:
        this.mIsUseNewCameraTypeStrategy = r109;
        if (r100.readByte() == 0) goto L21;
        boolean r110 = true;
    L22:
        this.mbDontUseVendorCamera = r110;
        int r111 = r100.readInt();
        if (r111 != (-1)) goto L25;
        CAMERA_FACING_ID r112 = null;
    L26:
        this.mCameraFacing = r112;
        this.mStrCameraHardwareID = r100.readString();
        this.mSceneMode = r100.readString();
        if (r100.readByte() == 0) goto L29;
        boolean r113 = true;
    L30:
        this.mCameraAntiShake = r113;
        int r114 = r100.readInt();
        if (r114 != (-1)) goto L33;
        CAMERA_FRAMERATE_STRATEGY r115 = null;
    L34:
        this.mCameraFrameRateStrategy = r115;
        if (r100.readByte() == 0) goto L37;
        boolean r116 = true;
    L38:
        this.mEnableWideFOV = r116;
        if (r100.readByte() == 0) goto L41;
        boolean r117 = true;
    L42:
        this.mIsUseHint = r117;
        if (r100.readByte() == 0) goto L45;
        boolean r118 = true;
    L46:
        this.mEnableSurfaceSharing = r118;
        if (r100.readByte() == 0) goto L49;
        boolean r119 = true;
    L50:
        this.mIsCameraOpenCloseSync = r119;
        if (r100.readByte() == 0) goto L53;
        boolean r120 = true;
    L54:
        this.mIsForceCloseCamera = r120;
        if (r100.readByte() == 0) goto L57;
        boolean r121 = true;
    L58:
        this.mEnableVBoost = r121;
        this.mVBoostTimeoutMS = r100.readInt();
        this.mFocusTimeoutMS = r100.readInt();
        if (r100.readByte() == 0) goto L61;
        boolean r122 = true;
    L62:
        this.mUseMaxWidthTakePicture = r122;
        this.mMaxWidth = r100.readInt();
        this.mOptionFlags = r100.readByte();
        this.mCaptureSize = (VESize) r100.readParcelable(VESize.class.getClassLoader());
        int r123 = r100.readInt();
        if (r123 != (-1)) goto L65;
        CAMERA_OUTPUT_MODE r124 = null;
    L66:
        this.mOutputMode = r124;
        if (r100.readByte() == 0) goto L69;
        boolean r125 = true;
    L70:
        this.mEnableFallback = r125;
        int r126 = r100.readInt();
        if (r126 != (-1)) goto L73;
        CAMERA_MODE_TYPE r127 = null;
    L74:
        this.mCameraMode = r127;
        if (r100.readByte() == 0) goto L77;
        boolean r128 = true;
    L78:
        this.mUseSyncModeOnCamera2 = r128;
        this.mCameraZoomLimitFactor = r100.readFloat();
        if (r100.readByte() == 0) goto L81;
        boolean r129 = true;
    L82:
        this.mEnableZsl = r129;
        if (r100.readByte() == 0) goto L85;
        boolean r130 = true;
    L86:
        this.mEnableManualReleaseCaptureResult = r130;
        this.mRetryCnt = r100.readInt();
        this.mRetryStartPreviewCnt = r100.readInt();
        if (r100.readByte() == 0) goto L89;
        boolean r131 = true;
    L90:
        this.mEnableRecordStream = r131;
        if (r100.readByte() == 0) goto L93;
        boolean r132 = true;
    L94:
        this.mEnableRecord60Fps = r132;
        this.mRecordStreamFolderPath = r100.readString();
        this.mCamera2RetryCnt = r100.readInt();
        if (r100.readByte() == 0) goto L97;
        boolean r133 = true;
    L98:
        this.mEnableHDR10BitRecord = r133;
        this.mDynamicRangeProfile = r100.readLong();
        this.mExtParameters = r100.readBundle();
        int r134 = r100.readInt();
        if (r134 == (-1)) goto L102;
        r102 = CAMERA_CAPTURE_FLASH_STRATEGY.values()[r134];
    L102:
        this.mCaptureFlashStrategy = r102;
        if (r100.readByte() == 0) goto L105;
        boolean r135 = true;
    L106:
        this.mCameraPreviewIndependent = r135;
        if (r100.readByte() == 0) goto L109;
        boolean r136 = true;
    L110:
        this.mEnablePreviewingFallback = r136;
        if (r100.readByte() == 0) goto L113;
        boolean r137 = true;
    L114:
        this.mEnableRefactorFocusAndMeter = r137;
        if (r100.readByte() == 0) goto L117;
        boolean r138 = true;
    L118:
        this.mEnableGyroFocusAndMeter = r138;
        if (r100.readByte() == 0) goto L121;
        boolean r139 = true;
    L122:
        this.mbEnableCamera2ZSL = r139;
        if (r100.readByte() == 0) goto L125;
        boolean r140 = true;
    L126:
        this.mPreferOpenCameraByCameraId = r140;
        if (r100.readByte() == 0) goto L129;
        boolean r141 = true;
    L130:
        this.mEnableForceRestartWhenCameraError = r141;
        if (r100.readByte() == 0) goto L133;
        r101 = true;
    L133:
        this.mBindSurfaceLifecycleToCamera = r101;
        this.mCameraCaptureYuvStrategy = CAMERA_CAPTURE_YUV_STRATEGY.values()[r100.readInt()];
        this.mMaxWidthTakePictureSizeAccuracy = r100.readFloat();
        this.mDefaultZoomRatio = r100.readFloat();
        this.mDefaultZoomUsingZoomV2 = r100.readBoolean();
        this.mPreviewSizeStrategy = PREVIEW_SIZE_STRATEGY.values()[r100.readInt()];
        this.mCameraAntiShakeMode = r100.readInt();
        this.customCameraTag = r100.readValue(Object.class.getClassLoader());
        return;
    L129:
        r141 = false;
        goto L130
    L125:
        r140 = false;
        goto L126
    L121:
        r139 = false;
        goto L122
    L117:
        r138 = false;
        goto L118
    L113:
        r137 = false;
        goto L114
    L109:
        r136 = false;
        goto L110
    L105:
        r135 = false;
        goto L106
    L97:
        r133 = false;
        goto L98
    L93:
        r132 = false;
        goto L94
    L89:
        r131 = false;
        goto L90
    L85:
        r130 = false;
        goto L86
    L81:
        r129 = false;
        goto L82
    L77:
        r128 = false;
        goto L78
    L73:
        r127 = CAMERA_MODE_TYPE.values()[r126];
        goto L74
    L69:
        r125 = false;
        goto L70
    L65:
        r124 = CAMERA_OUTPUT_MODE.values()[r123];
        goto L66
    L61:
        r122 = false;
        goto L62
    L57:
        r121 = false;
        goto L58
    L53:
        r120 = false;
        goto L54
    L49:
        r119 = false;
        goto L50
    L45:
        r118 = false;
        goto L46
    L41:
        r117 = false;
        goto L42
    L37:
        r116 = false;
        goto L38
    L33:
        r115 = CAMERA_FRAMERATE_STRATEGY.values()[r114];
        goto L34
    L29:
        r113 = false;
        goto L30
    L25:
        r112 = CAMERA_FACING_ID.values()[r111];
        goto L26
    L21:
        r110 = false;
        goto L22
    L17:
        r109 = false;
        goto L18
    L13:
        r108 = CAMERA_TYPE.values()[r107];
        goto L14
    L9:
        r106 = CAMERA_TYPE.values()[r105];
        goto L10
    L5:
        r104 = CAMERA_HW_LEVEL.values()[r103];
        goto L6
    }

    public static /* synthetic */ Bundle access$800(VECameraSettings r100) {
        return r100.mExtParameters;
    }

    public static CAMERA_TYPE cameraTypeConverter(int r100) {
        if (r100 == 9) goto L6;
        return CAMERA_TYPE.TYPE2;
    L6:
        return CAMERA_TYPE.TYPE_OGXM_V2;
    }

    public void enableManualReleaseCaptureResult(boolean r100) {
        this.mEnableManualReleaseCaptureResult = r100;
    }

    public void setCameraAntiShake(boolean r100) {
        this.mCameraAntiShake = r100;
    }

    public void setCameraAntiShakeMode(int r100) {
        this.mCameraAntiShakeMode = r100;
    }

    public void setCameraFacing(CAMERA_FACING_ID r100) {
        this.mCameraFacing = r100;
    }

    public void setCameraType(CAMERA_TYPE r100) {
        this.mCameraType = r100;
    }

    public void setConfigCameraType(CAMERA_TYPE r100) {
        this.mConfigCameraType = r100;
    }

    public void setCustomCameraTag(Object r100) {
        this.customCameraTag = r100;
    }

    public void setEnableFallback(boolean r100) {
        this.mEnableFallback = r100;
    }

    public void setEnableRecord60Fps(boolean r100) {
        this.mEnableRecord60Fps = r100;
    }

    public void setEnableRecordStream(boolean r100) {
        this.mEnableRecordStream = r100;
    }

    public void setEnableStopRepeatingBeforeCapture(boolean r100) {
        if (r100 == false) goto L5;
        this.mEnableStopRepeatingBeforeCapture = VEConfigCenter.getInstance().getValue("ve_enable_stop_cam_repeating_before_capture", false).booleanValue();
        return;
    L5:
        this.mEnableStopRepeatingBeforeCapture = false;
    }

    public void setEnableZsl(boolean r100) {
        this.mEnableZsl = r100;
    }

    public void setFps(int r100) {
        this.mFps = r100;
    }

    public void setFpsRange(int[] r100) {
        this.mFpsRange = r100;
    }

    public void setHwLevel(CAMERA_HW_LEVEL r100) {
        this.mHwLevel = r100;
    }

    public void setOptionFlag(byte r100) {
        this.mOptionFlags = r100;
    }

    public void setOutPutMode(CAMERA_OUTPUT_MODE r100) {
        this.mOutputMode = r100;
    }

    public void setRecordStreamFolderPath(String r100) {
        this.mRecordStreamFolderPath = r100;
    }

    public void setSceneMode(String r100) {
        this.mSceneMode = r100;
    }

    public /* synthetic */ VECameraSettings(a r100) {
        this();
    }

    public static /* synthetic */ boolean access$1002(VECameraSettings r100, boolean r101) {
        r100.mEnableSurfaceSharing = r101;
        return r101;
    }

    public static /* synthetic */ String access$102(VECameraSettings r100, String r101) {
        r100.mStrCameraHardwareID = r101;
        return r101;
    }

    public static /* synthetic */ float access$1102(VECameraSettings r100, float r101) {
        r100.mMaxWidthTakePictureSizeAccuracy = r101;
        return r101;
    }

    public static /* synthetic */ int access$1202(VECameraSettings r100, int r101) {
        r100.mRetryCnt = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1302(VECameraSettings r100, boolean r101) {
        r100.mEnableFallback = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1402(VECameraSettings r100, boolean r101) {
        r100.mEnableZsl = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1502(VECameraSettings r100, boolean r101) {
        r100.mUseSyncModeOnCamera2 = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1602(VECameraSettings r100, boolean r101) {
        r100.mEnableRefactorFocusAndMeter = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1702(VECameraSettings r100, boolean r101) {
        r100.mEnableGyroFocusAndMeter = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1802(VECameraSettings r100, boolean r101) {
        r100.mEnableForceRestartWhenCameraError = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1902(VECameraSettings r100, boolean r101) {
        r100.mBindSurfaceLifecycleToCamera = r101;
        return r101;
    }

    public static /* synthetic */ CAMERA_CAPTURE_YUV_STRATEGY access$2002(VECameraSettings r100, CAMERA_CAPTURE_YUV_STRATEGY r101) {
        r100.mCameraCaptureYuvStrategy = r101;
        return r101;
    }

    public static /* synthetic */ CAMERA_FACING_ID access$202(VECameraSettings r100, CAMERA_FACING_ID r101) {
        r100.mCameraFacing = r101;
        return r101;
    }

    public static /* synthetic */ int access$2102(VECameraSettings r100, int r101) {
        r100.mFpsMaxLimit = r101;
        return r101;
    }

    public static /* synthetic */ float access$2202(VECameraSettings r100, float r101) {
        r100.mCameraZoomLimitFactor = r101;
        return r101;
    }

    public static /* synthetic */ VESize access$2302(VECameraSettings r100, VESize r101) {
        r100.mPreviewSize = r101;
        return r101;
    }

    public static /* synthetic */ int access$2402(VECameraSettings r100, int r101) {
        r100.mFps = r101;
        return r101;
    }

    public static /* synthetic */ CAMERA_HW_LEVEL access$2502(VECameraSettings r100, CAMERA_HW_LEVEL r101) {
        r100.mHwLevel = r101;
        return r101;
    }

    public static /* synthetic */ int[] access$2602(VECameraSettings r100, int[] r101) {
        r100.mFpsRange = r101;
        return r101;
    }

    public static /* synthetic */ CAMERA_FRAMERATE_STRATEGY access$2702(VECameraSettings r100, CAMERA_FRAMERATE_STRATEGY r101) {
        r100.mCameraFrameRateStrategy = r101;
        return r101;
    }

    public static /* synthetic */ String access$2802(VECameraSettings r100, String r101) {
        r100.mSceneMode = r101;
        return r101;
    }

    public static /* synthetic */ byte access$2902(VECameraSettings r100, byte r101) {
        r100.mOptionFlags = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3002(VECameraSettings r100, boolean r101) {
        r100.mEnableRecordStream = r101;
        return r101;
    }

    public static /* synthetic */ CAMERA_TYPE access$302(VECameraSettings r100, CAMERA_TYPE r101) {
        r100.mCameraType = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3102(VECameraSettings r100, boolean r101) {
        r100.mEnableRecord60Fps = r101;
        return r101;
    }

    public static /* synthetic */ String access$3202(VECameraSettings r100, String r101) {
        r100.mRecordStreamFolderPath = r101;
        return r101;
    }

    public static /* synthetic */ int access$3302(VECameraSettings r100, int r101) {
        r100.mRetryStartPreviewCnt = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3402(VECameraSettings r100, boolean r101) {
        r100.mbEnablePreviewMetadataCallback = r101;
        return r101;
    }

    public static /* synthetic */ int access$3502(VECameraSettings r100, int r101) {
        r100.mCamera2RetryCnt = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3602(VECameraSettings r100, boolean r101) {
        r100.mEnableHDR10BitRecord = r101;
        return r101;
    }

    public static /* synthetic */ long access$3702(VECameraSettings r100, long r101) {
        r100.mDynamicRangeProfile = r101;
        return r101;
    }

    public static /* synthetic */ VESize access$3802(VECameraSettings r100, VESize r101) {
        r100.mCaptureSize = r101;
        return r101;
    }

    public static /* synthetic */ int access$3902(VECameraSettings r100, int r101) {
        r100.mMaxWidth = r101;
        return r101;
    }

    public static /* synthetic */ CAMERA_OUTPUT_MODE access$4002(VECameraSettings r100, CAMERA_OUTPUT_MODE r101) {
        r100.mOutputMode = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$402(VECameraSettings r100, boolean r101) {
        r100.mIsUseNewCameraTypeStrategy = r101;
        return r101;
    }

    public static /* synthetic */ CAMERA_MODE_TYPE access$4102(VECameraSettings r100, CAMERA_MODE_TYPE r101) {
        r100.mCameraMode = r101;
        return r101;
    }

    public static /* synthetic */ CAMERA_CAPTURE_FLASH_STRATEGY access$4202(VECameraSettings r100, CAMERA_CAPTURE_FLASH_STRATEGY r101) {
        r100.mCaptureFlashStrategy = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$4302(VECameraSettings r100, boolean r101) {
        r100.mCameraPreviewIndependent = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$4402(VECameraSettings r100, boolean r101) {
        r100.mPreferOpenCameraByCameraId = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$4502(VECameraSettings r100, boolean r101) {
        r100.mEnablePreviewingFallback = r101;
        return r101;
    }

    public static /* synthetic */ CAMERA_TYPE access$4602(VECameraSettings r100, CAMERA_TYPE r101) {
        r100.mDefaultCameraTypeInNewCameraStrategy = r101;
        return r101;
    }

    public static /* synthetic */ PREVIEW_SIZE_STRATEGY access$4702(VECameraSettings r100, PREVIEW_SIZE_STRATEGY r101) {
        r100.mPreviewSizeStrategy = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$4802(VECameraSettings r100, boolean r101) {
        r100.mEnableZslStrategy = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$4902(VECameraSettings r100, boolean r101) {
        r100.mbEnableCamera2ZSL = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$5002(VECameraSettings r100, boolean r101) {
        r100.mbEnableTakePicture4VideoMode = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$502(VECameraSettings r100, boolean r101) {
        r100.mbDontUseVendorCamera = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$5102(VECameraSettings r100, boolean r101) {
        r100.mbEnableDynamicSwitch = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$602(VECameraSettings r100, boolean r101) {
        r100.mCameraAntiShake = r101;
        return r101;
    }

    public static /* synthetic */ int access$702(VECameraSettings r100, int r101) {
        r100.mCameraAntiShakeMode = r101;
        return r101;
    }

    public static /* synthetic */ Bundle access$802(VECameraSettings r100, Bundle r101) {
        r100.mExtParameters = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$902(VECameraSettings r100, boolean r101) {
        r100.mUseMaxWidthTakePicture = r101;
        return r101;
    }

    public static CAMERA_TYPE getCameraTypeFromConfigCenter(CAMERA_TYPE r100, boolean r101) {
        VEConfigCenter.ValuePkt r102 = VEConfigCenter.getInstance().getValue("ve_camera_type");
        if (r102 != null) goto L5;
    L23:
        int r103 = -1;
    L24:
        VELogUtil.i(TAG, "getCameraTypeFromConfigCenter, cameraType = " + r103 + ", realCameraType = " + r100);
        return r100;
    L5:
        if (r102.getValue() == null) goto L23;
        if ((r102.getValue() instanceof Integer) == false) goto L23;
        r103 = ((Integer) r102.getValue()).intValue();
        if (r103 == 0) goto L13;
        if (r101 == true) goto L13;
        r100 = cameraTypeConverter(r103);
    L13:
        VEConfigCenter.ValuePkt r104 = VEConfigCenter.getInstance().getValue("ve_is_in_camera2_blocklist");
        if (r104 == null) goto L24;
        if (r104.getValue() == null) goto L24;
        if ((r104.getValue() instanceof Boolean) == false) goto L24;
        if (((Boolean) r104.getValue()).booleanValue() == false) goto L22;
        r100 = CAMERA_TYPE.TYPE1;
        goto L24
    L22:
        r100 = CAMERA_TYPE.TYPE2;
        goto L24
    }

    public void setPreviewSize(int r100, int r101) {
        this.mPreviewSize = new VESize(r100, r101);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeIntArray(this.CameraHWLevelTE2Android);
        r100.writeIntArray(this.CameraHWLevelAndroid2TE);
        r100.writeInt(this.mFps);
        r100.writeParcelable(this.mPreviewSize, r101);
        r100.writeIntArray(this.mFpsRange);
        CAMERA_HW_LEVEL r102 = this.mHwLevel;
        int r103 = -1;
        if (r102 != null) goto L5;
        int r104 = -1;
    L6:
        r100.writeInt(r104);
        CAMERA_TYPE r105 = this.mCameraType;
        if (r105 != null) goto L9;
        int r106 = -1;
    L10:
        r100.writeInt(r106);
        CAMERA_TYPE r107 = this.mConfigCameraType;
        if (r107 != null) goto L13;
        int r108 = -1;
    L14:
        r100.writeInt(r108);
        r100.writeByte(this.mIsUseNewCameraTypeStrategy ? 1 : 0);
        r100.writeByte(this.mbDontUseVendorCamera ? 1 : 0);
        CAMERA_FACING_ID r109 = this.mCameraFacing;
        if (r109 != null) goto L17;
        int r110 = -1;
    L18:
        r100.writeInt(r110);
        r100.writeString(this.mStrCameraHardwareID);
        r100.writeString(this.mSceneMode);
        r100.writeByte(this.mCameraAntiShake ? 1 : 0);
        CAMERA_FRAMERATE_STRATEGY r111 = this.mCameraFrameRateStrategy;
        if (r111 != null) goto L21;
        int r112 = -1;
    L22:
        r100.writeInt(r112);
        r100.writeByte(this.mEnableWideFOV ? 1 : 0);
        r100.writeByte(this.mIsUseHint ? 1 : 0);
        r100.writeByte(this.mEnableSurfaceSharing ? 1 : 0);
        r100.writeByte(this.mIsCameraOpenCloseSync ? 1 : 0);
        r100.writeByte(this.mIsForceCloseCamera ? 1 : 0);
        r100.writeByte(this.mEnableVBoost ? 1 : 0);
        r100.writeInt(this.mVBoostTimeoutMS);
        r100.writeInt(this.mFocusTimeoutMS);
        r100.writeByte(this.mUseMaxWidthTakePicture ? 1 : 0);
        r100.writeInt(this.mMaxWidth);
        r100.writeByte(this.mOptionFlags);
        r100.writeParcelable(this.mCaptureSize, r101);
        CAMERA_OUTPUT_MODE r113 = this.mOutputMode;
        if (r113 != null) goto L25;
        int r114 = -1;
    L26:
        r100.writeInt(r114);
        r100.writeByte(this.mEnableFallback ? 1 : 0);
        CAMERA_MODE_TYPE r115 = this.mCameraMode;
        if (r115 != null) goto L29;
        int r116 = -1;
    L30:
        r100.writeInt(r116);
        r100.writeByte(this.mUseSyncModeOnCamera2 ? 1 : 0);
        r100.writeFloat(this.mCameraZoomLimitFactor);
        r100.writeByte(this.mEnableZsl ? 1 : 0);
        r100.writeByte(this.mEnableManualReleaseCaptureResult ? 1 : 0);
        r100.writeInt(this.mRetryCnt);
        r100.writeInt(this.mRetryStartPreviewCnt);
        r100.writeByte(this.mEnableRecordStream ? 1 : 0);
        r100.writeByte(this.mEnableRecord60Fps ? 1 : 0);
        r100.writeString(this.mRecordStreamFolderPath);
        r100.writeInt(this.mCamera2RetryCnt);
        r100.writeByte(this.mEnableHDR10BitRecord ? 1 : 0);
        r100.writeLong(this.mDynamicRangeProfile);
        r100.writeBundle(this.mExtParameters);
        CAMERA_CAPTURE_FLASH_STRATEGY r117 = this.mCaptureFlashStrategy;
        if (r117 == null) goto L34;
        r103 = r117.ordinal();
    L34:
        r100.writeInt(r103);
        r100.writeByte(this.mCameraPreviewIndependent ? 1 : 0);
        r100.writeByte(this.mEnablePreviewingFallback ? 1 : 0);
        r100.writeByte(this.mEnableRefactorFocusAndMeter ? 1 : 0);
        r100.writeByte(this.mEnableGyroFocusAndMeter ? 1 : 0);
        r100.writeByte(this.mbEnableCamera2ZSL ? 1 : 0);
        r100.writeByte(this.mPreferOpenCameraByCameraId ? 1 : 0);
        r100.writeByte(this.mEnableForceRestartWhenCameraError ? 1 : 0);
        r100.writeByte(this.mBindSurfaceLifecycleToCamera ? 1 : 0);
        r100.writeInt(this.mCameraCaptureYuvStrategy.ordinal());
        r100.writeFloat(this.mMaxWidthTakePictureSizeAccuracy);
        r100.writeFloat(this.mDefaultZoomRatio);
        r100.writeBoolean(this.mDefaultZoomUsingZoomV2);
        r100.writeInt(this.mPreviewSizeStrategy.ordinal());
        r100.writeInt(this.mCameraAntiShakeMode);
        r100.writeValue(this.customCameraTag);
        return;
    L29:
        r116 = r115.ordinal();
        goto L30
    L25:
        r114 = r113.ordinal();
        goto L26
    L21:
        r112 = r111.ordinal();
        goto L22
    L17:
        r110 = r109.ordinal();
        goto L18
    L13:
        r108 = r107.ordinal();
        goto L14
    L9:
        r106 = r105.ordinal();
        goto L10
    L5:
        r104 = r102.ordinal();
        goto L6
    }
}
