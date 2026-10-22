package ls1;

import com.amap.api.col.s.ce;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\bZ\u0018\u00002\u00020\u0001:\u00019B\t¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\"\u0010\u001d\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010'\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u000b\u001a\u0004\b(\u0010\r\"\u0004\b)\u0010\u000fR\u0016\u0010*\u001a\u0004\u0018\u00010\u00118\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\"\u0010,\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u000b\u001a\u0004\b-\u0010\r\"\u0004\b.\u0010\u000fR\u001a\u00100\u001a\u00020/8\u0006X\u0087D¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001a\u00104\u001a\u00020/8\u0006X\u0087D¢\u0006\f\n\u0004\b4\u00101\u001a\u0004\b5\u00103R\u001a\u00106\u001a\u00020/8\u0006X\u0087D¢\u0006\f\n\u0004\b6\u00101\u001a\u0004\b7\u00103R\u001a\u00108\u001a\u00020/8\u0006X\u0087D¢\u0006\f\n\u0004\b8\u00101\u001a\u0004\b9\u00103R\u001a\u0010:\u001a\u00020/8\u0006X\u0087D¢\u0006\f\n\u0004\b:\u00101\u001a\u0004\b;\u00103R\u001a\u0010<\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b<\u0010\u000b\u001a\u0004\b=\u0010\rR\"\u0010?\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010>8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\"\u0010C\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010>8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010@\u001a\u0004\bD\u0010BR\u001a\u0010E\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\bE\u0010\u0004\u001a\u0004\bF\u0010\u0006R\"\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010>8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bG\u0010@\u001a\u0004\bH\u0010BR\u001a\u0010I\u001a\u00020 8\u0006X\u0087D¢\u0006\f\n\u0004\bI\u0010\"\u001a\u0004\bJ\u0010$R\u001a\u0010K\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\bK\u0010\u0004\u001a\u0004\bL\u0010\u0006R\u001a\u0010M\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\bM\u0010\u0004\u001a\u0004\bN\u0010\u0006R\"\u0010O\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010>8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bO\u0010@\u001a\u0004\bP\u0010BR\"\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010>8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bQ\u0010@\u001a\u0004\bR\u0010BR\u001a\u0010S\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\bS\u0010\u0004\u001a\u0004\bT\u0010\u0006R\"\u0010U\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bU\u0010\u000b\u001a\u0004\bV\u0010\r\"\u0004\bW\u0010\u000fR\"\u0010X\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bX\u0010\u0004\u001a\u0004\bY\u0010\u0006\"\u0004\bZ\u0010\bR\"\u0010[\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b[\u0010\u000b\u001a\u0004\b\\\u0010\r\"\u0004\b]\u0010\u000fR$\u0010^\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b^\u0010+\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\"\u0010c\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bc\u0010\u000b\u001a\u0004\bd\u0010\r\"\u0004\be\u0010\u000fR\"\u0010f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bf\u0010\u000b\u001a\u0004\bg\u0010\r\"\u0004\bh\u0010\u000fR\"\u0010i\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bi\u0010\u0004\u001a\u0004\bj\u0010\u0006\"\u0004\bk\u0010\bR\u001e\u0010l\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010>8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bl\u0010@R\u0016\u0010m\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bm\u0010\u0004R\u001a\u0010n\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\bn\u0010\u0004\u001a\u0004\bo\u0010\u0006R\u001a\u0010p\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\bp\u0010\u0004\u001a\u0004\bq\u0010\u0006R\u001a\u0010r\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\br\u0010\u0004\u001a\u0004\bs\u0010\u0006R\u001a\u0010t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\bt\u0010\u0004\u001a\u0004\bu\u0010\u0006R\u001a\u0010v\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\bv\u0010\u000b\u001a\u0004\bw\u0010\rR\u001a\u0010x\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\bx\u0010\u000b\u001a\u0004\by\u0010\rR\u001a\u0010z\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\bz\u0010\u000b\u001a\u0004\b{\u0010\rR\u001a\u0010|\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b|\u0010\u000b\u001a\u0004\b}\u0010\rR\u001a\u0010~\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b~\u0010\u0004\u001a\u0004\b\u007f\u0010\u0006R\u001d\u0010\u0080\u0001\u001a\u00020\t8\u0006X\u0087D¢\u0006\u000e\n\u0005\b\u0080\u0001\u0010\u000b\u001a\u0005\b\u0081\u0001\u0010\rR\u001d\u0010\u0082\u0001\u001a\u00020\u00028\u0006X\u0087D¢\u0006\u000e\n\u0005\b\u0082\u0001\u0010\u0004\u001a\u0005\b\u0083\u0001\u0010\u0006R\u001d\u0010\u0084\u0001\u001a\u00020/8\u0006X\u0087D¢\u0006\u000e\n\u0005\b\u0084\u0001\u00101\u001a\u0005\b\u0085\u0001\u00103R\u001d\u0010\u0086\u0001\u001a\u00020\u00028\u0006X\u0087D¢\u0006\u000e\n\u0005\b\u0086\u0001\u0010\u0004\u001a\u0005\b\u0087\u0001\u0010\u0006R\u001d\u0010\u0088\u0001\u001a\u00020\t8\u0006X\u0087D¢\u0006\u000e\n\u0005\b\u0088\u0001\u0010\u000b\u001a\u0005\b\u0089\u0001\u0010\rR\u001d\u0010\u008a\u0001\u001a\u00020\t8\u0006X\u0087D¢\u0006\u000e\n\u0005\b\u008a\u0001\u0010\u000b\u001a\u0005\b\u008b\u0001\u0010\rR\u001d\u0010\u008c\u0001\u001a\u00020\u00028\u0006X\u0087D¢\u0006\u000e\n\u0005\b\u008c\u0001\u0010\u0004\u001a\u0005\b\u008d\u0001\u0010\u0006R\u001d\u0010\u008e\u0001\u001a\u00020\u00028\u0006X\u0087D¢\u0006\u000e\n\u0005\b\u008e\u0001\u0010\u0004\u001a\u0005\b\u008f\u0001\u0010\u0006R\u001d\u0010\u0090\u0001\u001a\u00020\t8\u0006X\u0087D¢\u0006\u000e\n\u0005\b\u0090\u0001\u0010\u000b\u001a\u0005\b\u0091\u0001\u0010\rR\u001d\u0010\u0092\u0001\u001a\u00020\u00028\u0006X\u0087D¢\u0006\u000e\n\u0005\b\u0092\u0001\u0010\u0004\u001a\u0005\b\u0093\u0001\u0010\u0006R\u001d\u0010\u0094\u0001\u001a\u00020 8\u0006X\u0087D¢\u0006\u000e\n\u0005\b\u0094\u0001\u0010\"\u001a\u0005\b\u0095\u0001\u0010$¨\u0006\u0098\u0001"}, d2 = {"Lls1/c;", "", "", "enableFeature", "I", "getEnableFeature", "()I", "setEnableFeature", "(I)V", "", "enableDynamicSkip", "Z", "getEnableDynamicSkip", "()Z", "setEnableDynamicSkip", "(Z)V", "", "", "", "devicePerfThresholds", "Ljava/util/Map;", "getDevicePerfThresholds", "()Ljava/util/Map;", "startLiveCountThreshold", "getStartLiveCountThreshold", "setStartLiveCountThreshold", "pluginInitTime", "getPluginInitTime", "setPluginInitTime", "predictEnableWhenAiReady", "getPredictEnableWhenAiReady", "setPredictEnableWhenAiReady", "", "predictDelayWhenAiReady", "J", "getPredictDelayWhenAiReady", "()J", "setPredictDelayWhenAiReady", "(J)V", "performanceLimitEnable", "getPerformanceLimitEnable", "setPerformanceLimitEnable", "asrExtraName", "Ljava/lang/String;", "allEnable", "getAllEnable", "setAllEnable", "", "cpuRateThrehold", FaceService.girlLabel, "b", "()F", "gpuRateThrehold", "c", "memoryAvaiableThrehold", "d", "batteryThrehold", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "netQualityThrehold", "e", "isOnlyWifi", ce.f26391f, "", "uidList", "Ljava/util/List;", "getUidList", "()Ljava/util/List;", "uidBlackList", "getUidBlackList", "startLiveDurationThreshold", "getStartLiveDurationThreshold", "liveModeList", "getLiveModeList", "modelUptadeInterval", "getModelUptadeInterval", "minAsrPluginVersion", "getMinAsrPluginVersion", "maxAsrPluginVersion", "getMaxAsrPluginVersion", "asrPluginVersionList", "getAsrPluginVersionList", "asrPluginVersionBlackList", "getAsrPluginVersionBlackList", "minAsrModelVersion", "getMinAsrModelVersion", "showToastEnable", "getShowToastEnable", "setShowToastEnable", "startLiveCountRecordDays", "f", "setStartLiveCountRecordDays", "startLiveCountLimitEnable", "getStartLiveCountLimitEnable", "setStartLiveCountLimitEnable", "labVersion", "getLabVersion", "()Ljava/lang/String;", "setLabVersion", "(Ljava/lang/String;)V", "deleteOldModelEnable", "getDeleteOldModelEnable", "setDeleteOldModelEnable", "deleteModelEnable", "getDeleteModelEnable", "setDeleteModelEnable", "modelCheckMaxCount", "getModelCheckMaxCount", "setModelCheckMaxCount", "asrReportParamsWhenStartRoom", "modelCheckTime", "audioSliceDuration", "getAudioSliceDuration", "audioOverlapDuration", "getAudioOverlapDuration", "audioSliceDurationStream", "getAudioSliceDurationStream", "sliceStrategy", "getSliceStrategy", "enginePauseEnable", "getEnginePauseEnable", "preloadAsrSoEnable", "getPreloadAsrSoEnable", "audioSliceIndexCheckEnable", "getAudioSliceIndexCheckEnable", "audioSliceIndexCheckFailedTrackingEnable", "getAudioSliceIndexCheckFailedTrackingEnable", "audioSliceIndexCheckDiffThreshold", "getAudioSliceIndexCheckDiffThreshold", "enableTimeStampAligned", "getEnableTimeStampAligned", "timeAlignmentType", "getTimeAlignmentType", "timeAlignmentThreshold", "getTimeAlignmentThreshold", "timeAlignmentOffsetThreshold", "getTimeAlignmentOffsetThreshold", "engineTraceEnable", "getEngineTraceEnable", "engineReSampleEnable", "getEngineReSampleEnable", "engineOriginalSampleRate", "getEngineOriginalSampleRate", "engineReSampleRate", "getEngineReSampleRate", "engineOutputVolumeEnable", "getEngineOutputVolumeEnable", "engineOriginalChannelNum", "getEngineOriginalChannelNum", "asrSeiInterval", "getAsrSeiInterval", "<init>", "()V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("all_enable")
    private boolean allEnable;

    @SerializedName("room_extra_name")
    private final String asrExtraName;

    @SerializedName("asr_plugin_version_black_list")
    private final List<Integer> asrPluginVersionBlackList;

    @SerializedName("asr_plugin_version_list")
    private final List<Integer> asrPluginVersionList;

    @SerializedName("asr_report_params_when_start_room")
    private List<String> asrReportParamsWhenStartRoom;

    @SerializedName("asr_sei_interval")
    private final long asrSeiInterval;

    @SerializedName("audio_overlap_duration")
    private final int audioOverlapDuration;

    @SerializedName("audio_slice_duration")
    private final int audioSliceDuration;

    @SerializedName("audio_slice_duration_stream")
    private final int audioSliceDurationStream;

    @SerializedName("audio_slice_index_check_diff_threshold")
    private final int audioSliceIndexCheckDiffThreshold;

    @SerializedName("audio_slice_index_check_enable")
    private final boolean audioSliceIndexCheckEnable;

    @SerializedName("audio_slice_index_check_failed_tracking_enable")
    private final boolean audioSliceIndexCheckFailedTrackingEnable;

    @SerializedName("battery_threhold")
    private final float batteryThrehold;

    @SerializedName("cpu_rate_threshold")
    private final float cpuRateThrehold;

    @SerializedName("delete_model_enable")
    private boolean deleteModelEnable;

    @SerializedName("delete_old_model_enable")
    private boolean deleteOldModelEnable;

    @SerializedName("device_performance_thresholds")
    private final Map<String, Double> devicePerfThresholds;

    @SerializedName("enable_dynamic_skip_task")
    private boolean enableDynamicSkip;

    @SerializedName("enable_feature")
    private int enableFeature;

    @SerializedName("audio_slice_timestamp_aligned")
    private final boolean enableTimeStampAligned;

    @SerializedName("asr_engine_original_channel_num")
    private final int engineOriginalChannelNum;

    @SerializedName("asr_engine_original_sample_rate")
    private final int engineOriginalSampleRate;

    @SerializedName("asr_engine_output_volume_enable")
    private final boolean engineOutputVolumeEnable;

    @SerializedName("asr_engine_pause")
    private final boolean enginePauseEnable;

    @SerializedName("asr_engine_resample_enable")
    private final boolean engineReSampleEnable;

    @SerializedName("asr_engine_resample_rate")
    private final int engineReSampleRate;

    @SerializedName("asr_engine_trace_enable")
    private final boolean engineTraceEnable;

    @SerializedName("gpu_rate_threshold")
    private final float gpuRateThrehold;

    @SerializedName("wifi_only")
    private final boolean isOnlyWifi;

    @SerializedName("lab_version")
    private String labVersion;

    @SerializedName("live_mode_list")
    private final List<String> liveModeList;

    @SerializedName("max_asr_plugin_version")
    private final int maxAsrPluginVersion;

    @SerializedName("memory_avaiable_threshold")
    private final float memoryAvaiableThrehold;

    @SerializedName("min_asr_model_version")
    private final int minAsrModelVersion;

    @SerializedName("min_asr_plugin_version")
    private final int minAsrPluginVersion;

    @SerializedName("model_check_max_count")
    private int modelCheckMaxCount;

    @SerializedName("model_check_time")
    private int modelCheckTime;

    @SerializedName("model_cache_update_timer")
    private final long modelUptadeInterval;

    @SerializedName("net_quality_threhold")
    private final float netQualityThrehold;

    @SerializedName("performance_limit_enable")
    private boolean performanceLimitEnable;

    @SerializedName("plugin_init_time")
    private int pluginInitTime;

    @SerializedName("predict_delay_seconds_when_ai_ready")
    private long predictDelayWhenAiReady;

    @SerializedName("predict_enable_when_ai_ready")
    private boolean predictEnableWhenAiReady;

    @SerializedName("asr_so_preload")
    private final boolean preloadAsrSoEnable;

    @SerializedName("show_toast_enable")
    private boolean showToastEnable;

    @SerializedName("audio_slice_strategy")
    private final int sliceStrategy;

    @SerializedName("start_live_count_limit_enable")
    private boolean startLiveCountLimitEnable;

    @SerializedName("start_live_count_record_days")
    private int startLiveCountRecordDays;

    @SerializedName("recent_start_live_count_threshold")
    private int startLiveCountThreshold;

    @SerializedName("recent_start_live_duration_threshold")
    private final int startLiveDurationThreshold;

    @SerializedName("audio_slice_timestamp_offset_threshold")
    private final int timeAlignmentOffsetThreshold;

    @SerializedName("audio_slice_timestamp_aligned_threshold")
    private final float timeAlignmentThreshold;

    @SerializedName("audio_slice_timestamp_alignment_type")
    private final int timeAlignmentType;

    @SerializedName("uid_black_list")
    private final List<Long> uidBlackList;

    @SerializedName("use_id_list")
    private final List<Long> uidList;

    public static final class a {
    }

    static {
    }

    public c() {
        this.devicePerfThresholds = new HashMap();
        this.predictEnableWhenAiReady = true;
        this.predictDelayWhenAiReady = 3000;
        this.allEnable = true;
        this.cpuRateThrehold = -1.0f;
        this.gpuRateThrehold = -1.0f;
        this.uidList = new ArrayList();
        this.uidBlackList = new ArrayList();
        this.liveModeList = new ArrayList();
        this.maxAsrPluginVersion = Integer.MAX_VALUE;
        this.startLiveCountRecordDays = 30;
        this.deleteOldModelEnable = true;
        this.modelCheckMaxCount = 2;
        this.audioSliceDuration = 20000;
        this.audioOverlapDuration = 2000;
        this.audioSliceDurationStream = 1000;
        this.sliceStrategy = 1;
        this.enginePauseEnable = true;
        this.preloadAsrSoEnable = true;
        this.audioSliceIndexCheckEnable = true;
        this.audioSliceIndexCheckDiffThreshold = 5;
        this.enableTimeStampAligned = true;
        this.timeAlignmentThreshold = 0.9f;
        this.timeAlignmentOffsetThreshold = 2000;
        this.engineOriginalSampleRate = 16000;
        this.engineReSampleRate = 16000;
        this.engineOutputVolumeEnable = true;
        this.engineOriginalChannelNum = 1;
        this.asrSeiInterval = 1000;
    }

    public final float a() {
        return this.batteryThrehold;
    }

    public final float b() {
        return this.cpuRateThrehold;
    }

    public final float c() {
        return this.gpuRateThrehold;
    }

    public final float d() {
        return this.memoryAvaiableThrehold;
    }

    public final float e() {
        return this.netQualityThrehold;
    }

    public final int f() {
        return this.startLiveCountRecordDays;
    }

    public final boolean g() {
        return this.isOnlyWifi;
    }
}
