package com.ss.android.vesdk;

/* JADX INFO: loaded from: classes40.dex */
public class VEPreviewSettings {
    boolean customInitEffect;
    private int effectInitMode;
    private VERecordGraphType graphType;
    private boolean mAudioPreStartEnable;
    private boolean mBlockRenderExit;
    private boolean mCameraFrameUpdateIndependentThread;
    private VESize mCanvasSize;
    private int mCaptureRenderFinalWidth;
    private int mCaptureRenderMaxWidth;
    private boolean mCheckStatusWhenStopPreview;
    private VERecordContentType mContentType;
    boolean mDisEnableEffectWhenNoUsed;
    private boolean mDisableEffectInternalSetting;
    private VEDisplaySettings mDisplaySettings;
    private long mEffectAlgorithmRequirement;
    private boolean mEnable2DEngineEffect;
    private boolean mEnable3buffer;
    private boolean mEnableAudioDecodeTimeOpt;
    private boolean mEnableAudioRecord;
    private boolean mEnableDestroyEffectInStopPreview;
    private boolean mEnableDynamicRecordContentType;
    private boolean mEnableEGLImage;
    private boolean mEnableEffectAmazingEngine;
    private boolean mEnableEffectRT;
    public boolean mEnableHDR10BitRecordType;
    private boolean mEnableLens;
    private boolean mEnableMakeUpBackground;
    private boolean mEnableModelHotUpdate;
    private boolean mEnableNewEffectAlgorithmAsync;
    private boolean mEnablePlayAVSyncOpt;
    private boolean mEnablePreloadEffectRes;
    private boolean mEnableRenderLayer;
    private int mFirstNFrameIntervalsAverageCnt;
    private boolean mFollowShotIndependentThread;
    private boolean mForceDecodeTimeOpt;
    private boolean mForceSetFollowShotIndependentThread;
    public long mHDR10BitDynamicRangeProfile;
    private boolean mIsAsyncDetection;
    private boolean mIsNeedEffect;
    private boolean mIsSyncCapture;
    private boolean mNeedPostProcess;
    private boolean mOptFirstFrame;
    private int mOptFirstFrameBypassEffectFrameCnt;
    private boolean mRecordEffectContentHighSpeed;
    private VESize mRenderSize;
    public boolean mSwitchEffectInGLTask;
    private boolean mTitanAutoTestLogEnable;
    private boolean mVideoDecodeUseSetMultiTrackStatus;
    int maxCountOfBufCache;

    public static class Builder {
        private VEPreviewSettings mExportPreviewSettings;

        public Builder() {
            VEPreviewSettings r100 = new VEPreviewSettings();
            this.mExportPreviewSettings = r100;
            r100.maxCountOfBufCache = 3;
            VELogUtil.i("VEPreviewSettings", "AB maxCountOfBufCache: " + this.mExportPreviewSettings.maxCountOfBufCache);
        }

        public VEPreviewSettings build() {
            return this.mExportPreviewSettings;
        }

        public Builder(VEPreviewSettings r100) {
            this.mExportPreviewSettings = r100;
        }

        public Builder blockRenderExit(boolean r100) {
            VEPreviewSettings.access$1002(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder disableEffectInternalSetting(boolean r100) {
            VEPreviewSettings.access$802(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder enable2DEngineEffect(boolean r100) {
            VEPreviewSettings.access$3102(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder enable3buffer(boolean r100) {
            VEPreviewSettings.access$1102(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder enableAudioDecodeTimeOpt(boolean r100) {
            VEPreviewSettings.access$3502(this.mExportPreviewSettings, true);
            VEPreviewSettings.access$3602(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder enableAudioPreStart(boolean r100) {
            VEPreviewSettings.access$1202(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder enableAudioRecord(boolean r100) {
            VEPreviewSettings.access$102(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder enableCheckStatusWhenStopPreview(boolean r100) {
            VEPreviewSettings.access$2802(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder enableDestroyEffectInStopPreview(boolean r100) {
            VEPreviewSettings.access$1402(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder enableDynamicRecordContentType(boolean r100) {
            VEPreviewSettings.access$1902(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder enableEGLImage(boolean r100) {
            VEPreviewSettings.access$902(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder enableEffectAmazingEngine(boolean r100) {
            VEPreviewSettings.access$3002(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder enableEffectRT(boolean r100) {
            VEPreviewSettings.access$1602(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder enableFollowShotIndependentThread(boolean r100) {
            VEPreviewSettings.access$3302(this.mExportPreviewSettings, true);
            VEPreviewSettings.access$3402(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder enableHDR10BitRecordType(boolean r100) {
            this.mExportPreviewSettings.mEnableHDR10BitRecordType = r100;
            return this;
        }

        public Builder enableLens(boolean r100) {
            VEPreviewSettings.access$2902(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder enableMakeUpBackground(boolean r100) {
            VEPreviewSettings.access$1702(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder enableModelHotUpdate(boolean r100) {
            VEPreviewSettings.access$3702(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder enableNeedEffect(boolean r100) {
            VEPreviewSettings.access$3202(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder enablePlayAVSyncOpt(boolean r100) {
            VEPreviewSettings.access$4002(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder enablePreloadEffectRes(boolean r100) {
            VEPreviewSettings.access$1302(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder enableRecordEffectContentHighSpeed(boolean r100) {
            VEPreviewSettings.access$2002(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder enableReleaseGPUResource(boolean r100) {
            VEConfigCenter.getInstance().updateValue("ve_titan_release_gpu_resource", Boolean.valueOf(r100));
            return this;
        }

        public Builder enableRenderLayer(boolean r100) {
            VEPreviewSettings.access$3802(this.mExportPreviewSettings, r100);
            if (r100 == false) goto L5;
            VEPreviewSettings.access$3702(this.mExportPreviewSettings, true);
        L5:
            return this;
        }

        public Builder enableSyncCapture(boolean r100) {
            VEPreviewSettings.access$2402(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder firstNFrameIntervalsAverageCnt(int r100) {
            VEPreviewSettings.access$702(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder optFirstFrame(boolean r100) {
            VEPreviewSettings.access$602(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder setAsyncDetection(boolean r100) {
            VEPreviewSettings.access$202(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder setCameraUpdateIndependentThread(boolean r100) {
            VEPreviewSettings.access$302(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder setCaptureRenderFinalWidth(int r100) {
            VEPreviewSettings.access$2102(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder setCaptureRenderMaxWidth(int r100) {
            VEPreviewSettings.access$2302(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder setDisEnableEffectWhenNoUsed(boolean r100) {
            this.mExportPreviewSettings.mDisEnableEffectWhenNoUsed = r100;
            return this;
        }

        public Builder setDisplaySettings(VEDisplaySettings r100) {
            VEPreviewSettings.access$2702(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder setEffectAlgorithmRequirement(long r100) {
            VEPreviewSettings.access$1502(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder setEffectInitMode(int r100) {
            VEPreviewSettings.access$2202(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder setGraphMode(VERecordGraphType r100) {
            VEPreviewSettings.access$2602(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder setHDR10BitDynamicRangeProfile(long r100) {
            this.mExportPreviewSettings.mHDR10BitDynamicRangeProfile = r100;
            return this;
        }

        public Builder setMaxCountOfBufCache(int r100) {
            this.mExportPreviewSettings.maxCountOfBufCache = r100;
            return this;
        }

        public Builder setNeedPostProcess(boolean r100) {
            VEPreviewSettings.access$2502(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder setNewEffectAlgorithmAsync(boolean r100) {
            VEPreviewSettings.access$402(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder setRecordContentType(VERecordContentType r100) {
            VEPreviewSettings.access$1802(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder setRenderSize(VESize r100) {
            VEPreviewSettings.access$002(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder setTitanAutoTestLogEnbale(boolean r100) {
            VEPreviewSettings.access$502(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder setVideoDecodeUseSetMultiTrackStatus(boolean r100) {
            VEPreviewSettings.access$3902(this.mExportPreviewSettings, r100);
            return this;
        }

        public Builder switchEffectInGLTask(boolean r100) {
            this.mExportPreviewSettings.mSwitchEffectInGLTask = r100;
            return this;
        }
    }

    public static final enum VERecordContentType extends Enum<VERecordContentType> {
        public static final VERecordContentType RecordEffectContent = null;
        public static final VERecordContentType RecordFullContent = null;
        public static final VERecordContentType RecordIntermediateContent = null;
        public static final VERecordContentType RecordOriginContent = null;
        public static final VERecordContentType RecordVideoContent = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VERecordContentType[] f455634a = null;

        static {
            VERecordContentType r100 = new VERecordContentType("RecordOriginContent", 0);
            RecordOriginContent = r100;
            VERecordContentType r101 = new VERecordContentType("RecordEffectContent", 1);
            RecordEffectContent = r101;
            VERecordContentType r102 = new VERecordContentType("RecordFullContent", 2);
            RecordFullContent = r102;
            VERecordContentType r103 = new VERecordContentType("RecordIntermediateContent", 3);
            RecordIntermediateContent = r103;
            VERecordContentType r104 = new VERecordContentType("RecordVideoContent", 4);
            RecordVideoContent = r104;
            f455634a = new VERecordContentType[]{r100, r101, r102, r103, r104};
        }

        public static VERecordContentType[] values() {
            return (VERecordContentType[]) f455634a.clone();
        }

        public static VERecordContentType valueOf(String r100) {
            return (VERecordContentType) r27.a.a(VERecordContentType.class, r100);
        }

        public VERecordContentType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum VERecordGraphType extends Enum<VERecordGraphType> {
        private static final /* synthetic */ VERecordGraphType[] $VALUES = null;
        public static final VERecordGraphType AWESOME_GRAPH_TYPE = null;
        public static final VERecordGraphType LV_GRAPH_TYPE = null;
        public static final VERecordGraphType PREVIEW_EFFECT_GRAPH = null;
        public static final VERecordGraphType QR_CODE_GRAPH = null;

        private static /* synthetic */ VERecordGraphType[] $values() {
            return new VERecordGraphType[]{LV_GRAPH_TYPE, AWESOME_GRAPH_TYPE, QR_CODE_GRAPH, PREVIEW_EFFECT_GRAPH};
        }

        static {
            LV_GRAPH_TYPE = new VERecordGraphType("LV_GRAPH_TYPE", 0);
            AWESOME_GRAPH_TYPE = new VERecordGraphType("AWESOME_GRAPH_TYPE", 1);
            QR_CODE_GRAPH = new VERecordGraphType("QR_CODE_GRAPH", 2);
            PREVIEW_EFFECT_GRAPH = new VERecordGraphType("PREVIEW_EFFECT_GRAPH", 3);
            $VALUES = $values();
        }

        public static VERecordGraphType[] values() {
            return (VERecordGraphType[]) $VALUES.clone();
        }

        public static VERecordGraphType valueOf(String r100) {
            return (VERecordGraphType) r27.a.a(VERecordGraphType.class, r100);
        }

        private VERecordGraphType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public boolean getAudioDecodeTimeOpt() {
        if (this.mForceDecodeTimeOpt == false) goto L7;
        return this.mEnableAudioDecodeTimeOpt;
    L7:
        return VEConfigCenter.getInstance().getValue("ve_enanle_titan_audio_decode_time_opt", false).booleanValue();
    }

    public int getRecordContentType() {
        return this.mContentType.ordinal();
    }

    public boolean isFollowShotIndependentThread() {
        if (this.mForceSetFollowShotIndependentThread == true) goto L5;
        VEConfigCenter.ValuePkt r100 = VEConfigCenter.getInstance().getValue("ve_titan_follow_shot_independent_thread");
        if (r100 == null) goto L14;
        if (r100.getValue() == null) goto L14;
        if ((r100.getValue() instanceof Boolean) == false) goto L14;
        this.mFollowShotIndependentThread = ((Boolean) r100.getValue()).booleanValue();
    L14:
        return this.mFollowShotIndependentThread;
    L5:
        return this.mFollowShotIndependentThread;
    }

    public VEPreviewSettings() {
        this.mRenderSize = new VESize(720, 1280);
        this.mEnableAudioRecord = false;
        this.mIsAsyncDetection = false;
        this.mAudioPreStartEnable = false;
        this.mEnableNewEffectAlgorithmAsync = false;
        this.mCameraFrameUpdateIndependentThread = false;
        this.maxCountOfBufCache = 30;
        this.mDisEnableEffectWhenNoUsed = false;
        this.customInitEffect = false;
        this.mTitanAutoTestLogEnable = false;
        this.mFirstNFrameIntervalsAverageCnt = 5;
        this.mContentType = VERecordContentType.RecordFullContent;
        this.mEnableHDR10BitRecordType = false;
        this.mHDR10BitDynamicRangeProfile = 1;
        this.mEnableDynamicRecordContentType = false;
        this.mEnableLens = false;
        this.mCaptureRenderMaxWidth = Integer.MAX_VALUE;
        this.mIsSyncCapture = false;
        this.mRecordEffectContentHighSpeed = false;
        this.effectInitMode = 0;
        this.mNeedPostProcess = true;
        this.graphType = VERecordGraphType.LV_GRAPH_TYPE;
        this.mEnableEffectAmazingEngine = true;
        this.mEnable2DEngineEffect = true;
        this.mIsNeedEffect = true;
        this.mFollowShotIndependentThread = false;
        this.mForceSetFollowShotIndependentThread = false;
        this.mEnableRenderLayer = false;
        this.mEnableModelHotUpdate = false;
        this.mEnableAudioDecodeTimeOpt = false;
        this.mForceDecodeTimeOpt = false;
        this.mVideoDecodeUseSetMultiTrackStatus = true;
        this.mEnablePlayAVSyncOpt = false;
    }

    public int getHwDecodeConfig() {
        return VEConfigCenter.getInstance().getValue("ve_enable_record_hw_decode", 0);
    }

    public boolean is3bufferEnable() {
        if (VEConfigCenter.getInstance().getValue("ve_enable_three_buffer", false).booleanValue() == false) goto L6;
        this.mEnable3buffer = true;
    L6:
        return this.mEnable3buffer;
    }

    public boolean isAsyncDetection() {
        if (VEConfigCenter.getInstance().getValue("ve_async_detection", true).booleanValue() == false) goto L6;
        this.mIsAsyncDetection = true;
    L6:
        return this.mIsAsyncDetection;
    }

    public boolean isEffectInternalSettingDisabled() {
        if (VEConfigCenter.getInstance().getValue("ve_disable_effect_internal_setting", false).booleanValue() == false) goto L6;
        this.mDisableEffectInternalSetting = true;
    L6:
        return this.mDisableEffectInternalSetting;
    }

    public boolean isEnableCameraFrameUpdateIndependentThread() {
        VECameraSettings.CAMERA_OUTPUT_AND_UPDATE_STRATEGY r100 = VECameraSettings.getCameraOutputAndUpdateStrategy();
        if (VEConfigCenter.getInstance().getValue("ve_camera_frame_update_independent_thread", false).booleanValue() == false) goto L6;
        this.mCameraFrameUpdateIndependentThread = true;
    L11:
        return this.mCameraFrameUpdateIndependentThread;
    L6:
        if (r100 != VECameraSettings.CAMERA_OUTPUT_AND_UPDATE_STRATEGY.STRATEGY_TWOTHREAD_ONEOUT) goto L8;
    L9:
        this.mCameraFrameUpdateIndependentThread = true;
        goto L11
    L8:
        if (r100 != VECameraSettings.CAMERA_OUTPUT_AND_UPDATE_STRATEGY.STRATEGY_TWOTHREAD_TWOOUT) goto L11;
        goto L9
    }

    public boolean isEnableNewEffectAlgorithmAsync() {
        if (VEConfigCenter.getInstance().getValue("ve_new_effect_algorithm_async", false).booleanValue() == false) goto L6;
        this.mEnableNewEffectAlgorithmAsync = true;
    L6:
        return this.mEnableNewEffectAlgorithmAsync;
    }

    public boolean isEnablePassEffectWhenNoEffectFilter() {
        return VEConfigCenter.getInstance().getValue("ve_enable_pass_effect_when_no_effect_filter", false).booleanValue();
    }

    public boolean isEnableTitanAudioOpt() {
        return VEConfigCenter.getInstance().getValue("ve_titan_audio_opt", false).booleanValue();
    }

    public boolean isEnableTitanAutoTestLog() {
        if (VEConfigCenter.getInstance().getValue("ve_enable_titan_auto_test_log", false).booleanValue() == false) goto L6;
        this.mTitanAutoTestLogEnable = true;
    L6:
        return this.mTitanAutoTestLogEnable;
    }

    public boolean isOptFirstFrame() {
        if (VEConfigCenter.getInstance().getValue("ve_opt_first_frame", false).booleanValue() == false) goto L6;
        this.mOptFirstFrame = true;
    L6:
        return this.mOptFirstFrame;
    }

    public boolean isPreloadEffectResEnabled() {
        if (VEConfigCenter.getInstance().getValue("ve_enable_preload_effect_res", false).booleanValue() == false) goto L6;
        this.mEnablePreloadEffectRes = true;
    L6:
        return this.mEnablePreloadEffectRes;
    }

    public boolean checkStatusWhenStopPreview() {
        return this.mCheckStatusWhenStopPreview;
    }

    public VESize getCanvasSize() {
        return this.mCanvasSize;
    }

    public int getCaptureRenderFinalWidth() {
        return this.mCaptureRenderFinalWidth;
    }

    public int getCaptureRenderMaxWidth() {
        return this.mCaptureRenderMaxWidth;
    }

    public boolean getDisEnableEffectWhenNoUsed() {
        return this.mDisEnableEffectWhenNoUsed;
    }

    public VEDisplaySettings getDisplaySettings() {
        return this.mDisplaySettings;
    }

    public long getEffectAlgorithmRequirement() {
        return this.mEffectAlgorithmRequirement;
    }

    public int getEffectInitMode() {
        return this.effectInitMode;
    }

    public boolean getEnableHDR10BitRecordType() {
        return this.mEnableHDR10BitRecordType;
    }

    public boolean getEnableLens() {
        return this.mEnableLens;
    }

    public int getFirstNFrameIntervalsAverageCnt() {
        return this.mFirstNFrameIntervalsAverageCnt;
    }

    public VERecordGraphType getGraphType() {
        return this.graphType;
    }

    public long getHDR10BitDynamicRangeProfile() {
        return this.mHDR10BitDynamicRangeProfile;
    }

    public int getMaxCountOfBufCache() {
        return this.maxCountOfBufCache;
    }

    public VESize getRenderSize() {
        return this.mRenderSize;
    }

    public boolean isAudioPreStartEnable() {
        return this.mAudioPreStartEnable;
    }

    public boolean isAudioRecordEnabled() {
        return this.mEnableAudioRecord;
    }

    public boolean isBlockRenderExit() {
        return this.mBlockRenderExit;
    }

    public boolean isCustomInitEffect() {
        return this.customInitEffect;
    }

    public boolean isEGLImageEnable() {
        return this.mEnableEGLImage;
    }

    public boolean isEffectRTEnable() {
        return this.mEnableEffectRT;
    }

    public boolean isEnable2DEngineEffect() {
        return this.mEnable2DEngineEffect;
    }

    public boolean isEnableDestroyEffectInStopPreview() {
        return this.mEnableDestroyEffectInStopPreview;
    }

    public boolean isEnableDynamicRecordContentType() {
        return this.mEnableDynamicRecordContentType;
    }

    public boolean isEnableEffectAmazingEngine() {
        return this.mEnableEffectAmazingEngine;
    }

    public boolean isEnableModelHotUpdate() {
        return this.mEnableModelHotUpdate;
    }

    public boolean isEnablePlayAVSyncOpt() {
        return this.mEnablePlayAVSyncOpt;
    }

    public boolean isEnableRenderLayer() {
        return this.mEnableRenderLayer;
    }

    public boolean isMakeUpBackgroundEnable() {
        return this.mEnableMakeUpBackground;
    }

    public boolean isNeedEffect() {
        return this.mIsNeedEffect;
    }

    public boolean isRecordEffectContentHighSpeed() {
        return this.mRecordEffectContentHighSpeed;
    }

    public boolean isSwitchEffectInGLTask() {
        return this.mSwitchEffectInGLTask;
    }

    public boolean isSyncCapture() {
        return this.mIsSyncCapture;
    }

    public boolean isVideoDecodeUseSetMultiTrackStatus() {
        return this.mVideoDecodeUseSetMultiTrackStatus;
    }

    public boolean needPostProcess() {
        return this.mNeedPostProcess;
    }

    public void setCustomInitEffect(boolean r100) {
        this.customInitEffect = r100;
    }

    public void setEffectInitMode(int r100) {
        this.effectInitMode = r100;
    }

    public static /* synthetic */ VESize access$002(VEPreviewSettings r100, VESize r101) {
        r100.mRenderSize = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1002(VEPreviewSettings r100, boolean r101) {
        r100.mBlockRenderExit = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$102(VEPreviewSettings r100, boolean r101) {
        r100.mEnableAudioRecord = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1102(VEPreviewSettings r100, boolean r101) {
        r100.mEnable3buffer = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1202(VEPreviewSettings r100, boolean r101) {
        r100.mAudioPreStartEnable = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1302(VEPreviewSettings r100, boolean r101) {
        r100.mEnablePreloadEffectRes = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1402(VEPreviewSettings r100, boolean r101) {
        r100.mEnableDestroyEffectInStopPreview = r101;
        return r101;
    }

    public static /* synthetic */ long access$1502(VEPreviewSettings r100, long r101) {
        r100.mEffectAlgorithmRequirement = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1602(VEPreviewSettings r100, boolean r101) {
        r100.mEnableEffectRT = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1702(VEPreviewSettings r100, boolean r101) {
        r100.mEnableMakeUpBackground = r101;
        return r101;
    }

    public static /* synthetic */ VERecordContentType access$1802(VEPreviewSettings r100, VERecordContentType r101) {
        r100.mContentType = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1902(VEPreviewSettings r100, boolean r101) {
        r100.mEnableDynamicRecordContentType = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$2002(VEPreviewSettings r100, boolean r101) {
        r100.mRecordEffectContentHighSpeed = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$202(VEPreviewSettings r100, boolean r101) {
        r100.mIsAsyncDetection = r101;
        return r101;
    }

    public static /* synthetic */ int access$2102(VEPreviewSettings r100, int r101) {
        r100.mCaptureRenderFinalWidth = r101;
        return r101;
    }

    public static /* synthetic */ int access$2202(VEPreviewSettings r100, int r101) {
        r100.effectInitMode = r101;
        return r101;
    }

    public static /* synthetic */ int access$2302(VEPreviewSettings r100, int r101) {
        r100.mCaptureRenderMaxWidth = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$2402(VEPreviewSettings r100, boolean r101) {
        r100.mIsSyncCapture = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$2502(VEPreviewSettings r100, boolean r101) {
        r100.mNeedPostProcess = r101;
        return r101;
    }

    public static /* synthetic */ VERecordGraphType access$2602(VEPreviewSettings r100, VERecordGraphType r101) {
        r100.graphType = r101;
        return r101;
    }

    public static /* synthetic */ VEDisplaySettings access$2702(VEPreviewSettings r100, VEDisplaySettings r101) {
        r100.mDisplaySettings = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$2802(VEPreviewSettings r100, boolean r101) {
        r100.mCheckStatusWhenStopPreview = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$2902(VEPreviewSettings r100, boolean r101) {
        r100.mEnableLens = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3002(VEPreviewSettings r100, boolean r101) {
        r100.mEnableEffectAmazingEngine = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$302(VEPreviewSettings r100, boolean r101) {
        r100.mCameraFrameUpdateIndependentThread = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3102(VEPreviewSettings r100, boolean r101) {
        r100.mEnable2DEngineEffect = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3202(VEPreviewSettings r100, boolean r101) {
        r100.mIsNeedEffect = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3302(VEPreviewSettings r100, boolean r101) {
        r100.mForceSetFollowShotIndependentThread = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3402(VEPreviewSettings r100, boolean r101) {
        r100.mFollowShotIndependentThread = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3502(VEPreviewSettings r100, boolean r101) {
        r100.mForceDecodeTimeOpt = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3602(VEPreviewSettings r100, boolean r101) {
        r100.mEnableAudioDecodeTimeOpt = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3702(VEPreviewSettings r100, boolean r101) {
        r100.mEnableModelHotUpdate = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3802(VEPreviewSettings r100, boolean r101) {
        r100.mEnableRenderLayer = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$3902(VEPreviewSettings r100, boolean r101) {
        r100.mVideoDecodeUseSetMultiTrackStatus = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$4002(VEPreviewSettings r100, boolean r101) {
        r100.mEnablePlayAVSyncOpt = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$402(VEPreviewSettings r100, boolean r101) {
        r100.mEnableNewEffectAlgorithmAsync = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$502(VEPreviewSettings r100, boolean r101) {
        r100.mTitanAutoTestLogEnable = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$602(VEPreviewSettings r100, boolean r101) {
        r100.mOptFirstFrame = r101;
        return r101;
    }

    public static /* synthetic */ int access$702(VEPreviewSettings r100, int r101) {
        r100.mFirstNFrameIntervalsAverageCnt = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$802(VEPreviewSettings r100, boolean r101) {
        r100.mDisableEffectInternalSetting = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$902(VEPreviewSettings r100, boolean r101) {
        r100.mEnableEGLImage = r101;
        return r101;
    }
}
