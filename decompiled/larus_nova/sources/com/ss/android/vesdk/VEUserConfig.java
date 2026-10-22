package com.ss.android.vesdk;

import com.ss.android.ttvecamera.TECameraConfigKey;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes40.dex */
public class VEUserConfig {
    private Map<ConfigID, VEUserConfigItem<?>> configItems;

    public static final enum ConfigID extends Enum<ConfigID> {
        private static final /* synthetic */ ConfigID[] $VALUES = null;
        public static final ConfigID ConfigID_AudioHwEncoder = null;
        public static final ConfigID ConfigID_CompileProbeEnableByte264 = null;
        public static final ConfigID ConfigID_CompileRemuxBitrateJson = null;
        public static final ConfigID ConfigID_CompileReport = null;
        public static final ConfigID ConfigID_CropEncodeOperatingRate = null;
        public static final ConfigID ConfigID_CrossplatGLBaseFBO = null;
        public static final ConfigID ConfigID_DelayTimeThreshold = null;
        public static final ConfigID ConfigID_EnableAGFXContext = null;
        public static final ConfigID ConfigID_EnableAGFXMetal = null;
        public static final ConfigID ConfigID_EnableAdaptiveEncodeLevel = null;
        public static final ConfigID ConfigID_EnableApplHdrSupport = null;
        public static final ConfigID ConfigID_EnableAudioDisplayCallBack = null;
        public static final ConfigID ConfigID_EnableBufferEncodeOperatingRate = null;
        public static final ConfigID ConfigID_EnableByte264 = null;
        public static final ConfigID ConfigID_EnableCompileParamDump = null;
        public static final ConfigID ConfigID_EnableCrossplatInputCompile = null;
        public static final ConfigID ConfigID_EnableCrossplatLogicUnify = null;
        public static final ConfigID ConfigID_EnableDisplayP3Render = null;
        public static final ConfigID ConfigID_EnableEditorFpsLog = null;
        public static final ConfigID ConfigID_EnableGlobalEffect = null;
        public static final ConfigID ConfigID_EnableHWPlaybackDropFrame = null;
        public static final ConfigID ConfigID_EnableHdrToneMapping = null;
        public static final ConfigID ConfigID_EnableHdrVsOptimization = null;
        public static final ConfigID ConfigID_EnableHighSpeedChange = null;
        public static final ConfigID ConfigID_EnableImportParallelCompile = null;
        public static final ConfigID ConfigID_EnableLimitMinEncodeFps = null;
        public static final ConfigID ConfigID_EnableMultiThreadDecode = null;
        public static final ConfigID ConfigID_EnablePBO = null;
        public static final ConfigID ConfigID_EnableRemuxInfoColorSpace = null;
        public static final ConfigID ConfigID_EnableRenderlib = null;
        public static final ConfigID ConfigID_EnableSeekAndPreloadOpt = null;
        public static final ConfigID ConfigID_EnableSeekNoiseOpt = null;
        public static final ConfigID ConfigID_EnableSkipUnitPassthrough = null;
        public static final ConfigID ConfigID_EnableStickerAmazing = null;
        public static final ConfigID ConfigID_EnableTransitionKeyframe = null;
        public static final ConfigID ConfigID_EnableVideoOutputCallback = null;
        public static final ConfigID ConfigID_Enable_DecodeAVSync = null;
        public static final ConfigID ConfigID_Enable_UnifyGraphState = null;
        public static final ConfigID ConfigID_EnableiOSEditFirstFrameOpt = null;
        public static final ConfigID ConfigID_EnbaleInfoStickerTrans = null;
        public static final ConfigID ConfigID_EncoderInitialQP = null;
        public static final ConfigID ConfigID_EncoderQPRange = null;
        public static final ConfigID ConfigID_EncoderQPRangeForRecorder = null;
        public static final ConfigID ConfigID_FixAudioDriveEOS = null;
        public static final ConfigID ConfigID_ForceDetectFace = null;
        public static final ConfigID ConfigID_ForceDisableGlobalEffect = null;
        public static final ConfigID ConfigID_ForceDropFrameWithoutAudio = null;
        public static final ConfigID ConfigID_GlobalEffectMode = null;
        public static final ConfigID ConfigID_GraphRefactor = null;
        public static final ConfigID ConfigID_LoadImageOptimize = null;
        public static final ConfigID ConfigID_MaxAudioReaderCount = null;
        public static final ConfigID ConfigID_MaxCacheFrameCount = null;
        public static final ConfigID ConfigID_MaxDropFrameCount = null;
        public static final ConfigID ConfigID_MaxHwReaderCount = null;
        public static final ConfigID ConfigID_MaxImageTextureBufferCount = null;
        public static final ConfigID ConfigID_MaxImageTextureBufferHeight = null;
        public static final ConfigID ConfigID_MaxImageTextureBufferWidth = null;
        public static final ConfigID ConfigID_MaxPreloadReaderCount = null;
        public static final ConfigID ConfigID_MaxSoftwareFreeReaderCount = null;
        public static final ConfigID ConfigID_MaxSoftwareVideoReaderCount = null;
        public static final ConfigID ConfigID_MaxTexturePoolCount = null;
        public static final ConfigID ConfigID_NewAudioMixer = null;
        public static final ConfigID ConfigID_OpenSeekTimeOpt = null;
        public static final ConfigID ConfigID_OutResolutionBase4 = null;
        public static final ConfigID ConfigID_PinRefactor = null;
        public static final ConfigID ConfigID_PreLoadNextClip = null;
        public static final ConfigID ConfigID_RenderlibFBOOpt = null;
        public static final ConfigID ConfigID_ReportFrequency = null;
        public static final ConfigID ConfigID_SetDropFramePara = null;
        public static final ConfigID ConfigID_SetStickerResolutionWithHeight = null;
        public static final ConfigID ConfigID_StickerPinPreviewMode = null;
        public static final ConfigID ConfigID_TexturePoolCleanCount = null;
        public static final ConfigID ConfigID_UseAudioSDKApiV2 = null;
        public static final ConfigID ConfigID_UseEffectTransiton = null;
        public static final ConfigID ConfigID_UseImageAllocator = null;
        public static final ConfigID ConfigID_UseMultiThreadPool = null;
        public static final ConfigID ConfigID_UseNewEngineEffectOpt = null;
        public static final ConfigID ConfigID_UseRefaCanvasWrap = null;
        public static final ConfigID ConfigID_VeContentAdaptiveCodingMode = null;
        public static final ConfigID ConfigID_VeFFmpegCodecMemReuse = null;
        public static final ConfigID ConfigID_VeabtestEnableFeaturePcmFmtf32 = null;
        public static final ConfigID ConfigID_VeabtestEnablecrossplatcanvasdownscaleopt = null;
        public static final ConfigID ConfigID_VeabtestEnablecrossplatcanvasopt = null;
        public static final ConfigID ConfigID_VeabtestEnabledownsamplingopt = null;
        public static final ConfigID ConfigID_VeabtestEnablepreviewqualityopt = null;
        public static final ConfigID ConfigID_VeabtestEnableupsamplingopt = null;
        public static final ConfigID ConfigID_enableFeatureAudioEncodeSetCutOff = null;
        public static final ConfigID ConfigID_encodeColorSpaceBt601 = null;
        public static final ConfigID configID_CompileProbeCrf = null;
        public static final ConfigID configID_CompileProbeIntervalFrame = null;
        public static final ConfigID configID_CompileProbeSleepTime = null;
        private String value;

        private static /* synthetic */ ConfigID[] $values() {
            return new ConfigID[]{ConfigID_UseImageAllocator, ConfigID_PreLoadNextClip, ConfigID_EnableHighSpeedChange, ConfigID_EnableEditorFpsLog, ConfigID_EnableVideoOutputCallback, ConfigID_MaxAudioReaderCount, ConfigID_MaxSoftwareVideoReaderCount, ConfigID_MaxSoftwareFreeReaderCount, ConfigID_MaxPreloadReaderCount, ConfigID_MaxHwReaderCount, ConfigID_MaxImageTextureBufferCount, ConfigID_SetDropFramePara, ConfigID_DelayTimeThreshold, ConfigID_MaxDropFrameCount, ConfigID_MaxTexturePoolCount, ConfigID_TexturePoolCleanCount, ConfigID_UseMultiThreadPool, ConfigID_MaxImageTextureBufferWidth, ConfigID_MaxImageTextureBufferHeight, ConfigID_MaxCacheFrameCount, ConfigID_UseEffectTransiton, ConfigID_UseRefaCanvasWrap, ConfigID_EnbaleInfoStickerTrans, ConfigID_OpenSeekTimeOpt, ConfigID_UseNewEngineEffectOpt, ConfigID_OutResolutionBase4, ConfigID_ForceDropFrameWithoutAudio, ConfigID_UseAudioSDKApiV2, ConfigID_CrossplatGLBaseFBO, ConfigID_EnableRenderlib, ConfigID_RenderlibFBOOpt, ConfigID_EnableAGFXContext, ConfigID_EnableAGFXMetal, ConfigID_LoadImageOptimize, ConfigID_GraphRefactor, ConfigID_CompileProbeEnableByte264, configID_CompileProbeCrf, configID_CompileProbeIntervalFrame, configID_CompileProbeSleepTime, ConfigID_EnableByte264, ConfigID_NewAudioMixer, ConfigID_AudioHwEncoder, ConfigID_SetStickerResolutionWithHeight, ConfigID_EnableMultiThreadDecode, ConfigID_EnableHWPlaybackDropFrame, ConfigID_EnableSeekAndPreloadOpt, ConfigID_EnableHdrVsOptimization, ConfigID_EnableApplHdrSupport, ConfigID_PinRefactor, ConfigID_EnablePBO, ConfigID_EnableHdrToneMapping, ConfigID_EnableDisplayP3Render, ConfigID_EnableAudioDisplayCallBack, ConfigID_EnableTransitionKeyframe, ConfigID_EnableCrossplatInputCompile, ConfigID_EnableRemuxInfoColorSpace, ConfigID_CompileReport, ConfigID_ReportFrequency, ConfigID_EnableiOSEditFirstFrameOpt, ConfigID_EnableSkipUnitPassthrough, ConfigID_ForceDetectFace, ConfigID_EnableStickerAmazing, ConfigID_EnableGlobalEffect, ConfigID_ForceDisableGlobalEffect, ConfigID_EnableAdaptiveEncodeLevel, ConfigID_EnableLimitMinEncodeFps, ConfigID_EncoderQPRange, ConfigID_EncoderQPRangeForRecorder, ConfigID_EncoderInitialQP, ConfigID_CompileRemuxBitrateJson, ConfigID_EnableImportParallelCompile, ConfigID_EnableBufferEncodeOperatingRate, ConfigID_CropEncodeOperatingRate, ConfigID_StickerPinPreviewMode, ConfigID_VeabtestEnableupsamplingopt, ConfigID_VeabtestEnabledownsamplingopt, ConfigID_VeabtestEnablepreviewqualityopt, ConfigID_VeabtestEnablecrossplatcanvasopt, ConfigID_VeabtestEnablecrossplatcanvasdownscaleopt, ConfigID_VeContentAdaptiveCodingMode, ConfigID_VeFFmpegCodecMemReuse, ConfigID_GlobalEffectMode, ConfigID_VeabtestEnableFeaturePcmFmtf32, ConfigID_enableFeatureAudioEncodeSetCutOff, ConfigID_EnableCompileParamDump, ConfigID_encodeColorSpaceBt601, ConfigID_EnableSeekNoiseOpt, ConfigID_Enable_UnifyGraphState, ConfigID_Enable_DecodeAVSync, ConfigID_EnableCrossplatLogicUnify, ConfigID_FixAudioDriveEOS};
        }

        static {
            ConfigID_UseImageAllocator = new ConfigID("ConfigID_UseImageAllocator", 0, "ve_enable_use_image_allocator");
            ConfigID_PreLoadNextClip = new ConfigID("ConfigID_PreLoadNextClip", 1, "PreLoadNextClip");
            ConfigID_EnableHighSpeedChange = new ConfigID("ConfigID_EnableHighSpeedChange", 2, "vesdk_high_speed_change_opt");
            ConfigID_EnableEditorFpsLog = new ConfigID("ConfigID_EnableEditorFpsLog", 3, "EnableEditorFpsLog");
            ConfigID_EnableVideoOutputCallback = new ConfigID("ConfigID_EnableVideoOutputCallback", 4, "EnableVideoOutputCallback");
            ConfigID_MaxAudioReaderCount = new ConfigID("ConfigID_MaxAudioReaderCount", 5, "MaxAudioReaderCount");
            ConfigID_MaxSoftwareVideoReaderCount = new ConfigID("ConfigID_MaxSoftwareVideoReaderCount", 6, "MaxSoftwareVideoReaderCount");
            ConfigID_MaxSoftwareFreeReaderCount = new ConfigID("ConfigID_MaxSoftwareFreeReaderCount", 7, "MaxSoftwareFreeReaderCount");
            ConfigID_MaxPreloadReaderCount = new ConfigID("ConfigID_MaxPreloadReaderCount", 8, "veabtest_crossplat_maxPreloadReaderCnt");
            ConfigID_MaxHwReaderCount = new ConfigID("ConfigID_MaxHwReaderCount", 9, "MaxHwReaderCount");
            ConfigID_MaxImageTextureBufferCount = new ConfigID("ConfigID_MaxImageTextureBufferCount", 10, "ve_enable_max_imagetexture_buffer_count");
            ConfigID_SetDropFramePara = new ConfigID("ConfigID_SetDropFramePara", 11, "SetDropFramePara");
            ConfigID_DelayTimeThreshold = new ConfigID("ConfigID_DelayTimeThreshold", 12, "DelayTimeThreshold");
            ConfigID_MaxDropFrameCount = new ConfigID("ConfigID_MaxDropFrameCount", 13, "MaxDropFrameCount");
            ConfigID_MaxTexturePoolCount = new ConfigID("ConfigID_MaxTexturePoolCount", 14, "MaxTexturePoolCount");
            ConfigID_TexturePoolCleanCount = new ConfigID("ConfigID_TexturePoolCleanCount", 15, "TexturePoolCleanCount");
            ConfigID_UseMultiThreadPool = new ConfigID("ConfigID_UseMultiThreadPool", 16, "UseMultiThreadPool");
            ConfigID_MaxImageTextureBufferWidth = new ConfigID("ConfigID_MaxImageTextureBufferWidth", 17, "MaxImageTextureBufferWidth");
            ConfigID_MaxImageTextureBufferHeight = new ConfigID("ConfigID_MaxImageTextureBufferHeight", 18, "MaxImageTextureBufferHeight");
            ConfigID_MaxCacheFrameCount = new ConfigID("ConfigID_MaxCacheFrameCount", 19, "vesdk_max_cache_count");
            ConfigID_UseEffectTransiton = new ConfigID("ConfigID_UseEffectTransiton", 20, "UseEffectTransiton");
            ConfigID_UseRefaCanvasWrap = new ConfigID("ConfigID_UseRefaCanvasWrap", 21, "UseRefaCanvasWrap");
            ConfigID_EnbaleInfoStickerTrans = new ConfigID("ConfigID_EnbaleInfoStickerTrans", 22, "EnbaleInfoStickerTrans");
            ConfigID_OpenSeekTimeOpt = new ConfigID("ConfigID_OpenSeekTimeOpt", 23, "OpenSeekTimeOpt");
            ConfigID_UseNewEngineEffectOpt = new ConfigID("ConfigID_UseNewEngineEffectOpt", 24, "UseNewEngineEffectOpt");
            ConfigID_OutResolutionBase4 = new ConfigID("ConfigID_OutResolutionBase4", 25, "ve_enable_render_encode_resolution_align4");
            ConfigID_ForceDropFrameWithoutAudio = new ConfigID("ConfigID_ForceDropFrameWithoutAudio", 26, "ForceDropFrameWithoutAudio");
            ConfigID_UseAudioSDKApiV2 = new ConfigID("ConfigID_UseAudioSDKApiV2", 27, "aeabtest_v2api");
            ConfigID_CrossplatGLBaseFBO = new ConfigID("ConfigID_CrossplatGLBaseFBO", 28, "crossplat_glbase_fbo");
            ConfigID_EnableRenderlib = new ConfigID("ConfigID_EnableRenderlib", 29, "enable_render_lib");
            ConfigID_RenderlibFBOOpt = new ConfigID("ConfigID_RenderlibFBOOpt", 30, "renderlib_fbo_opt");
            ConfigID_EnableAGFXContext = new ConfigID("ConfigID_EnableAGFXContext", 31, "EnableAGFXContext");
            ConfigID_EnableAGFXMetal = new ConfigID("ConfigID_EnableAGFXMetal", 32, "vesdk_use_agfxmetal");
            ConfigID_LoadImageOptimize = new ConfigID("ConfigID_LoadImageOptimize", 33, "LoadImageOptimize");
            ConfigID_GraphRefactor = new ConfigID("ConfigID_GraphRefactor", 34, "s_bGraphRefactor");
            ConfigID_CompileProbeEnableByte264 = new ConfigID("ConfigID_CompileProbeEnableByte264", 35, "compile_probe_use_byte264");
            configID_CompileProbeCrf = new ConfigID("configID_CompileProbeCrf", 36, "compile_probe_crf");
            configID_CompileProbeIntervalFrame = new ConfigID("configID_CompileProbeIntervalFrame", 37, "compile_probe_interval_frame");
            configID_CompileProbeSleepTime = new ConfigID("configID_CompileProbeSleepTime", 38, "compile_probe_sleep_time");
            ConfigID_EnableByte264 = new ConfigID("ConfigID_EnableByte264", 39, "use_byte264");
            ConfigID_NewAudioMixer = new ConfigID("ConfigID_NewAudioMixer", 40, "vesdk_audiomix_replace");
            ConfigID_AudioHwEncoder = new ConfigID("ConfigID_AudioHwEncoder", 41, "vesdk_audio_hw_encoder");
            ConfigID_SetStickerResolutionWithHeight = new ConfigID("ConfigID_SetStickerResolutionWithHeight", 42, "SetStickerResolutionWithHeight");
            ConfigID_EnableMultiThreadDecode = new ConfigID("ConfigID_EnableMultiThreadDecode", 43, "EnableMultiThreadDecode");
            ConfigID_EnableHWPlaybackDropFrame = new ConfigID("ConfigID_EnableHWPlaybackDropFrame", 44, "ve_enable_hwdecode_playback_dropframe_opt");
            ConfigID_EnableSeekAndPreloadOpt = new ConfigID("ConfigID_EnableSeekAndPreloadOpt", 45, "EnableSeekAndPreloadOpt");
            ConfigID_EnableHdrVsOptimization = new ConfigID("ConfigID_EnableHdrVsOptimization", 46, "veabtest_hdr_vs_optimization");
            ConfigID_EnableApplHdrSupport = new ConfigID("ConfigID_EnableApplHdrSupport", 47, "vesdk_enable_apple_hdr_support");
            ConfigID_PinRefactor = new ConfigID("ConfigID_PinRefactor", 48, "ve_enable_pin_refactor");
            ConfigID_EnablePBO = new ConfigID("ConfigID_EnablePBO", 49, "EnablePBO");
            ConfigID_EnableHdrToneMapping = new ConfigID("ConfigID_EnableHdrToneMapping", 50, "EnableHdrToneMapping");
            ConfigID_EnableDisplayP3Render = new ConfigID("ConfigID_EnableDisplayP3Render", 51, "EnableDisplayP3Render");
            ConfigID_EnableAudioDisplayCallBack = new ConfigID("ConfigID_EnableAudioDisplayCallBack", 52, "EnableAudioDisplayCallBack");
            ConfigID_EnableTransitionKeyframe = new ConfigID("ConfigID_EnableTransitionKeyframe", 53, "EnableTransitionKeyframe");
            ConfigID_EnableCrossplatInputCompile = new ConfigID("ConfigID_EnableCrossplatInputCompile", 54, "EnableCrossplatInputCompile");
            ConfigID_EnableRemuxInfoColorSpace = new ConfigID("ConfigID_EnableRemuxInfoColorSpace", 55, "enable_remux_color_info");
            ConfigID_CompileReport = new ConfigID("ConfigID_CompileReport", 56, "ve_compile_report");
            ConfigID_ReportFrequency = new ConfigID("ConfigID_ReportFrequency", 57, "ve_report_frequency");
            ConfigID_EnableiOSEditFirstFrameOpt = new ConfigID("ConfigID_EnableiOSEditFirstFrameOpt", 58, "veabtest_crossplatEditFirstFrameOptimize");
            ConfigID_EnableSkipUnitPassthrough = new ConfigID("ConfigID_EnableSkipUnitPassthrough", 59, "EnableSkipUnitPassthrough");
            ConfigID_ForceDetectFace = new ConfigID("ConfigID_ForceDetectFace", 60, TECameraConfigKey.KEY_ENABLE_FACE_DETECTION);
            ConfigID_EnableStickerAmazing = new ConfigID("ConfigID_EnableStickerAmazing", 61, "EnableStickerAmazing");
            ConfigID_EnableGlobalEffect = new ConfigID("ConfigID_EnableGlobalEffect", 62, "EnableGlobalEffect");
            ConfigID_ForceDisableGlobalEffect = new ConfigID("ConfigID_ForceDisableGlobalEffect", 63, "ForceDisableGlobalEffect");
            ConfigID_EnableAdaptiveEncodeLevel = new ConfigID("ConfigID_EnableAdaptiveEncodeLevel", 64, "ve_enable_adaptive_encode_level");
            ConfigID_EnableLimitMinEncodeFps = new ConfigID("ConfigID_EnableLimitMinEncodeFps", 65, "ve_enable_limit_min_encode_fps");
            ConfigID_EncoderQPRange = new ConfigID("ConfigID_EncoderQPRange", 66, "ve_encoder_qp_range");
            ConfigID_EncoderQPRangeForRecorder = new ConfigID("ConfigID_EncoderQPRangeForRecorder", 67, "ve_encoder_qp_range_for_recorder");
            ConfigID_EncoderInitialQP = new ConfigID("ConfigID_EncoderInitialQP", 68, "ve_encoder_initial_qp");
            ConfigID_CompileRemuxBitrateJson = new ConfigID("ConfigID_CompileRemuxBitrateJson", 69, "ve_compile_remux_bitrate_json");
            ConfigID_EnableImportParallelCompile = new ConfigID("ConfigID_EnableImportParallelCompile", 70, "veEnableImportParallelCompile");
            ConfigID_EnableBufferEncodeOperatingRate = new ConfigID("ConfigID_EnableBufferEncodeOperatingRate", 71, "ve_enable_encode_buffer_operating_rate");
            ConfigID_CropEncodeOperatingRate = new ConfigID("ConfigID_CropEncodeOperatingRate", 72, "ve_crop_encode_operating_rate");
            ConfigID_StickerPinPreviewMode = new ConfigID("ConfigID_StickerPinPreviewMode", 73, "StickerPinPreviewMode");
            ConfigID_VeabtestEnableupsamplingopt = new ConfigID("ConfigID_VeabtestEnableupsamplingopt", 74, "veabtest_enableUpSamplingOpt");
            ConfigID_VeabtestEnabledownsamplingopt = new ConfigID("ConfigID_VeabtestEnabledownsamplingopt", 75, "veabtest_enableDownSamplingOpt");
            ConfigID_VeabtestEnablepreviewqualityopt = new ConfigID("ConfigID_VeabtestEnablepreviewqualityopt", 76, "veabtest_enablePreviewQualityOpt");
            ConfigID_VeabtestEnablecrossplatcanvasopt = new ConfigID("ConfigID_VeabtestEnablecrossplatcanvasopt", 77, "veabtest_enableCrossplatCanvasOpt");
            ConfigID_VeabtestEnablecrossplatcanvasdownscaleopt = new ConfigID("ConfigID_VeabtestEnablecrossplatcanvasdownscaleopt", 78, "veabtest_enableCrossplatCanvasDownscaleOpt");
            ConfigID_VeContentAdaptiveCodingMode = new ConfigID("ConfigID_VeContentAdaptiveCodingMode", 79, "ve_content_adaptive_coding_mode");
            ConfigID_VeFFmpegCodecMemReuse = new ConfigID("ConfigID_VeFFmpegCodecMemReuse", 80, "ve_ffmpeg_codec_mem_reuse");
            ConfigID_GlobalEffectMode = new ConfigID("ConfigID_GlobalEffectMode", 81, "GlobalEffectMode");
            ConfigID_VeabtestEnableFeaturePcmFmtf32 = new ConfigID("ConfigID_VeabtestEnableFeaturePcmFmtf32", 82, "veabtest_enableFeaturePcmf32");
            ConfigID_enableFeatureAudioEncodeSetCutOff = new ConfigID("ConfigID_enableFeatureAudioEncodeSetCutOff", 83, "veabtest_enableFeatureAudioEncodeSetCutOff");
            ConfigID_EnableCompileParamDump = new ConfigID("ConfigID_EnableCompileParamDump", 84, "ve_enable_compile_param_dump");
            ConfigID_encodeColorSpaceBt601 = new ConfigID("ConfigID_encodeColorSpaceBt601", 85, "ve_encode_color_space_bt601");
            ConfigID_EnableSeekNoiseOpt = new ConfigID("ConfigID_EnableSeekNoiseOpt", 86, "veabtest_enable_seek_noise_opt");
            ConfigID_Enable_UnifyGraphState = new ConfigID("ConfigID_Enable_UnifyGraphState", 87, "veabtest_enable_unifygraphstate");
            ConfigID_Enable_DecodeAVSync = new ConfigID("ConfigID_Enable_DecodeAVSync", 88, "veabtest_decode_av_sync");
            ConfigID_EnableCrossplatLogicUnify = new ConfigID("ConfigID_EnableCrossplatLogicUnify", 89, "ve_enable_crossplat_logic_unify");
            ConfigID_FixAudioDriveEOS = new ConfigID("ConfigID_FixAudioDriveEOS", 90, "veabtest_fixAudioDriveEOS");
            $VALUES = $values();
        }

        public static ConfigID[] values() {
            return (ConfigID[]) $VALUES.clone();
        }

        public String value() {
            return this.value;
        }

        public static ConfigID valueOf(String r100) {
            return (ConfigID) r27.a.a(ConfigID.class, r100);
        }

        private ConfigID(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum DataType extends Enum<DataType> {
        public static final DataType BOOLEAN = null;
        public static final DataType INTEGER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DataType[] f455719a = null;
        private int value;

        static {
            DataType r100 = new DataType("BOOLEAN", 0, 0);
            BOOLEAN = r100;
            DataType r101 = new DataType("INTEGER", 1, 1);
            INTEGER = r101;
            f455719a = new DataType[]{r100, r101};
        }

        public static DataType[] values() {
            return (DataType[]) f455719a.clone();
        }

        public int value() {
            return this.value;
        }

        public static DataType valueOf(String r100) {
            return (DataType) r27.a.a(DataType.class, r100);
        }

        public DataType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static class VEUserConfigItem<T> {
        private DataType dataType;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public ConfigID f455720id;
        private T value;

        public String toString() {
            return "VEUserConfigItem{dataType=" + this.dataType + ", value=" + this.value + ", id=" + this.f455720id + '}';
        }

        public DataType getDataType() {
            return this.dataType;
        }

        public T getValue() {
            return this.value;
        }

        public VEUserConfigItem(ConfigID r100, T r101) throws IllegalArgumentException {
            if ((r101 instanceof Boolean) == false) goto L6;
            this.dataType = DataType.BOOLEAN;
        L8:
            this.f455720id = r100;
            this.value = r101;
            return;
        L6:
            if ((r101 instanceof Integer) == false) goto L11;
            this.dataType = DataType.INTEGER;
            goto L8
        L11:
            throw new IllegalArgumentException("illegal value type");
        }
    }

    public ConfigID[] getConfigIDs() {
        Set<ConfigID> r100 = this.configItems.keySet();
        ConfigID[] r101 = new ConfigID[r100.size()];
        r100.toArray(r101);
        return r101;
    }

    public VEUserConfigItem<?>[] getConfigItems() {
        Collection<VEUserConfigItem<?>> r100 = this.configItems.values();
        VEUserConfigItem<?>[] r101 = new VEUserConfigItem[r100.size()];
        r100.toArray(r101);
        return r101;
    }

    public VEUserConfig() {
        this.configItems = new HashMap();
    }

    public VEUserConfig addConfig(VEUserConfigItem<?> r100) {
        this.configItems.put(r100.f455720id, r100);
        return this;
    }

    public VEUserConfigItem<?> getConfigItem(ConfigID r100) {
        return this.configItems.get(r100);
    }
}
