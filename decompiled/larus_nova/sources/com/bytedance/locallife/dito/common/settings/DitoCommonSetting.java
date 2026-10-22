package com.bytedance.locallife.dito.common.settings;

import com.bytedance.locallife.dito.common.plugin.v;
import com.bytedance.locallife.dito.data.h;
import com.bytedance.locallife.dito.data.w;
import com.bytedance.locallife.dito.host.settings.DitoSettings;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b#\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b_\u0010`R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R*\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R*\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR0\u0010!\u001a\u0018\u0012\u0004\u0012\u00020\u0011\u0012\f\u0012\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010\u0016R\u001a\u0010#\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b#\u0010\t\u001a\u0004\b$\u0010\u000bR\u001a\u0010&\u001a\u00020%8\u0006X\u0087D¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020%8\u0006X\u0087D¢\u0006\f\n\u0004\b*\u0010'\u001a\u0004\b+\u0010)R\u001a\u0010,\u001a\u00020%8\u0006X\u0087D¢\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b-\u0010)R\u001a\u0010.\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b.\u0010\u0004\u001a\u0004\b/\u0010\u0006R\u001a\u00100\u001a\u00020%8\u0006X\u0087D¢\u0006\f\n\u0004\b0\u0010'\u001a\u0004\b1\u0010)R\u001a\u00102\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b2\u0010\t\u001a\u0004\b3\u0010\u000bR\u001a\u00104\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b4\u0010\t\u001a\u0004\b5\u0010\u000bR\u001a\u00106\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b6\u0010\t\u001a\u0004\b7\u0010\u000bR\u001a\u00108\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b8\u0010\t\u001a\u0004\b9\u0010\u000bR\u001a\u0010:\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b:\u0010\t\u001a\u0004\b;\u0010\u000bR\u001a\u0010<\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b<\u0010\t\u001a\u0004\b=\u0010\u000bR*\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010>\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b?\u0010\u0014\u001a\u0004\b@\u0010\u0016R\u001a\u0010A\u001a\u00020\u001a8\u0006X\u0087D¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001a\u0010E\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\bE\u0010\t\u001a\u0004\bF\u0010\u000bR\u001a\u0010G\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\bG\u0010\t\u001a\u0004\bH\u0010\u000bR\"\u0010I\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bI\u0010\t\u001a\u0004\bJ\u0010\u000b\"\u0004\bK\u0010LR\"\u0010M\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bM\u0010\t\u001a\u0004\bN\u0010\u000b\"\u0004\bO\u0010LR\"\u0010P\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bP\u0010\t\u001a\u0004\bQ\u0010\u000b\"\u0004\bR\u0010LR\"\u0010S\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bS\u0010B\u001a\u0004\bT\u0010D\"\u0004\bU\u0010VR\u001a\u0010W\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\bW\u0010\t\u001a\u0004\bX\u0010\u000bR\u001a\u0010Y\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\bY\u0010\t\u001a\u0004\bZ\u0010\u000bR\u001a\u0010[\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b[\u0010\t\u001a\u0004\b\\\u0010\u000bR\u001a\u0010]\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b]\u0010\t\u001a\u0004\b^\u0010\u000b¨\u0006a"}, d2 = {"Lcom/bytedance/locallife/dito/common/settings/DitoCommonSetting;", "Lcom/bytedance/locallife/dito/host/settings/DitoSettings;", "", "ditoChunkDowngradeThreshold", "I", "getDitoChunkDowngradeThreshold", "()I", "", "ditoChunkInterceptorCheckState", "Z", "getDitoChunkInterceptorCheckState", "()Z", "ditoOnlineLogOpen", "getDitoOnlineLogOpen", "ditoOnlineLogLevel", "getDitoOnlineLogLevel", "", "", "Lcom/bytedance/locallife/dito/data/w;", "ditoPageRecoveryConfig", "Ljava/util/Map;", "getDitoPageRecoveryConfig", "()Ljava/util/Map;", "Lcom/bytedance/locallife/dito/data/h;", "ditoRecoveryConfig", "getDitoRecoveryConfig", "", "ditoImmediateRecoveryConfigTimeout", "Ljava/lang/Long;", "getDitoImmediateRecoveryConfigTimeout", "()Ljava/lang/Long;", "", "Lcom/bytedance/locallife/dito/common/plugin/v;", "ditoLynxPrefetchConfig", "getDitoLynxPrefetchConfig", "ditoComponentStatsSwitch", "getDitoComponentStatsSwitch", "", "ditoComponentStatsTeaRate", "D", "getDitoComponentStatsTeaRate", "()D", "ditoParseStatsTeaRate", "getDitoParseStatsTeaRate", "ditoLynxDecodeStateTeaRate", "getDitoLynxDecodeStateTeaRate", "ditoReportEventToTeaRate", "getDitoReportEventToTeaRate", "ditoPerformanceChainTeaRate", "getDitoPerformanceChainTeaRate", "ditoDecorationEnable", "getDitoDecorationEnable", "ditoFixGroupMarginError", "getDitoFixGroupMarginError", "ditoFixStickSpaceView", "getDitoFixStickSpaceView", "ditoReportDitoEventToSlardar", "getDitoReportDitoEventToSlardar", "ditoFixUpdateDataIllegalState", "getDitoFixUpdateDataIllegalState", "useLynxSelfCheckCompleteShow", "getUseLynxSelfCheckCompleteShow", "", "nestedScrollV2EnableByScene", "getNestedScrollV2EnableByScene", "destroyHeadlessLynxTimeout", "J", "getDestroyHeadlessLynxTimeout", "()J", "adapterScrollingViewInSubStick", "getAdapterScrollingViewInSubStick", "fixLynxLayoutCallApiError", "getFixLynxLayoutCallApiError", "enableBtmParamsToLynxData", "getEnableBtmParamsToLynxData", "setEnableBtmParamsToLynxData", "(Z)V", "enableBtmComponentSizeCheck", "getEnableBtmComponentSizeCheck", "setEnableBtmComponentSizeCheck", "disableFmpViewDiff", "getDisableFmpViewDiff", "setDisableFmpViewDiff", "btmComponentMaxWatchLayoutTs", "getBtmComponentMaxWatchLayoutTs", "setBtmComponentMaxWatchLayoutTs", "(J)V", "disableAppendParamsOfFmp", "getDisableAppendParamsOfFmp", "sendDitoBodyScrollDy", "getSendDitoBodyScrollDy", "enableTurboMainLynxViewHolder", "getEnableTurboMainLynxViewHolder", "disableTurboObserveBreakInfo", "getDisableTurboObserveBreakInfo", "<init>", "()V", "dito-common-saas_release"}, k = 1, mv = {1, 4, 3})
public final class DitoCommonSetting extends DitoSettings {

    @SerializedName("dito_adapter_scrolling_view_in_sub_stick")
    private final boolean adapterScrollingViewInSubStick;

    @SerializedName("btm_component_max_watch_layout_ts")
    private long btmComponentMaxWatchLayoutTs;

    @SerializedName("dito_destroy_headless_lynx_timeout")
    private final long destroyHeadlessLynxTimeout;

    @SerializedName("dito_disable_append_params_fmp")
    private final boolean disableAppendParamsOfFmp;

    @SerializedName("disable_fmp_view_diff")
    private boolean disableFmpViewDiff;

    @SerializedName("disable_turbo_observe_break_info")
    private final boolean disableTurboObserveBreakInfo;

    @SerializedName("dito_chunk_downgrade_threshold")
    private final int ditoChunkDowngradeThreshold;

    @SerializedName("dito_chunk_interceptor_check_state")
    private final boolean ditoChunkInterceptorCheckState;

    @SerializedName("dito_component_stats_switch")
    private final boolean ditoComponentStatsSwitch;

    @SerializedName("dito_component_stats_tea_rate")
    private final double ditoComponentStatsTeaRate;

    @SerializedName("dito_decoration_enable")
    private final boolean ditoDecorationEnable;

    @SerializedName("dito_fix_group_margin_error")
    private final boolean ditoFixGroupMarginError;

    @SerializedName("dito_fix_stick_space_view")
    private final boolean ditoFixStickSpaceView;

    @SerializedName("dito_fix_update_data_illegal_state")
    private final boolean ditoFixUpdateDataIllegalState;

    @SerializedName("dito_immediate_recovery_config_timeout")
    private final Long ditoImmediateRecoveryConfigTimeout;

    @SerializedName("dito_lynx_decode_stats_tea_rate")
    private final double ditoLynxDecodeStateTeaRate;

    @SerializedName("dito_lynx_prefetch_config")
    private final Map<String, List<v>> ditoLynxPrefetchConfig;

    @SerializedName("dito_online_log_level")
    private final int ditoOnlineLogLevel;

    @SerializedName("dito_online_log_open")
    private final boolean ditoOnlineLogOpen;

    @SerializedName("dito_page_recovery_config")
    private final Map<String, w> ditoPageRecoveryConfig;

    @SerializedName("dito_page_parse_stats_tea_rate")
    private final double ditoParseStatsTeaRate;

    @SerializedName("dito_performance_chain_tea_rate")
    private final double ditoPerformanceChainTeaRate;

    @SerializedName("dito_recovery_config")
    private final Map<String, h> ditoRecoveryConfig;

    @SerializedName("dito_report_dito_event_to_slardar")
    private final boolean ditoReportDitoEventToSlardar;

    @SerializedName("dito_report_event_tea_rate")
    private final int ditoReportEventToTeaRate;

    @SerializedName("enable_btm_component_size_check")
    private boolean enableBtmComponentSizeCheck;

    @SerializedName("enable_btm_params_to_lynx_data")
    private boolean enableBtmParamsToLynxData;

    @SerializedName("enable_turbo_main_lynx_view_holder")
    private final boolean enableTurboMainLynxViewHolder;

    @SerializedName("fix_lynx_layout_call_api_error")
    private final boolean fixLynxLayoutCallApiError;

    @SerializedName("dito_nested_scroll_v2_enable_by_scene")
    private final Map<String, Object> nestedScrollV2EnableByScene;

    @SerializedName("send_dito_body_scroll_dy")
    private final boolean sendDitoBodyScrollDy;

    @SerializedName("dito_use_lynx_self_complete_show")
    private final boolean useLynxSelfCheckCompleteShow;

    public DitoCommonSetting() {
        this.ditoChunkDowngradeThreshold = 5;
        this.ditoOnlineLogOpen = true;
        this.ditoOnlineLogLevel = 5;
        this.ditoComponentStatsSwitch = true;
        this.ditoParseStatsTeaRate = 0.001d;
        this.ditoLynxDecodeStateTeaRate = 0.001d;
        this.ditoDecorationEnable = true;
        this.ditoFixGroupMarginError = true;
        this.ditoFixStickSpaceView = true;
        this.ditoReportDitoEventToSlardar = true;
        this.ditoFixUpdateDataIllegalState = true;
        this.useLynxSelfCheckCompleteShow = true;
        this.nestedScrollV2EnableByScene = new LinkedHashMap();
        this.destroyHeadlessLynxTimeout = 3000;
        this.adapterScrollingViewInSubStick = true;
        this.fixLynxLayoutCallApiError = true;
        this.enableBtmParamsToLynxData = true;
        this.enableBtmComponentSizeCheck = true;
        this.btmComponentMaxWatchLayoutTs = ((long) 5) * 1000;
        this.sendDitoBodyScrollDy = true;
        this.enableTurboMainLynxViewHolder = true;
    }

    public final boolean getAdapterScrollingViewInSubStick() {
        return this.adapterScrollingViewInSubStick;
    }

    public final long getBtmComponentMaxWatchLayoutTs() {
        return this.btmComponentMaxWatchLayoutTs;
    }

    public final long getDestroyHeadlessLynxTimeout() {
        return this.destroyHeadlessLynxTimeout;
    }

    public final boolean getDisableAppendParamsOfFmp() {
        return this.disableAppendParamsOfFmp;
    }

    public final boolean getDisableFmpViewDiff() {
        return this.disableFmpViewDiff;
    }

    public final boolean getDisableTurboObserveBreakInfo() {
        return this.disableTurboObserveBreakInfo;
    }

    public final int getDitoChunkDowngradeThreshold() {
        return this.ditoChunkDowngradeThreshold;
    }

    public final boolean getDitoChunkInterceptorCheckState() {
        return this.ditoChunkInterceptorCheckState;
    }

    public final boolean getDitoComponentStatsSwitch() {
        return this.ditoComponentStatsSwitch;
    }

    public final double getDitoComponentStatsTeaRate() {
        return this.ditoComponentStatsTeaRate;
    }

    public final boolean getDitoDecorationEnable() {
        return this.ditoDecorationEnable;
    }

    public final boolean getDitoFixGroupMarginError() {
        return this.ditoFixGroupMarginError;
    }

    public final boolean getDitoFixStickSpaceView() {
        return this.ditoFixStickSpaceView;
    }

    public final boolean getDitoFixUpdateDataIllegalState() {
        return this.ditoFixUpdateDataIllegalState;
    }

    public final Long getDitoImmediateRecoveryConfigTimeout() {
        return this.ditoImmediateRecoveryConfigTimeout;
    }

    public final double getDitoLynxDecodeStateTeaRate() {
        return this.ditoLynxDecodeStateTeaRate;
    }

    public final Map<String, List<v>> getDitoLynxPrefetchConfig() {
        return this.ditoLynxPrefetchConfig;
    }

    public final int getDitoOnlineLogLevel() {
        return this.ditoOnlineLogLevel;
    }

    public final boolean getDitoOnlineLogOpen() {
        return this.ditoOnlineLogOpen;
    }

    public final Map<String, w> getDitoPageRecoveryConfig() {
        return this.ditoPageRecoveryConfig;
    }

    public final double getDitoParseStatsTeaRate() {
        return this.ditoParseStatsTeaRate;
    }

    public final double getDitoPerformanceChainTeaRate() {
        return this.ditoPerformanceChainTeaRate;
    }

    public final Map<String, h> getDitoRecoveryConfig() {
        return this.ditoRecoveryConfig;
    }

    public final boolean getDitoReportDitoEventToSlardar() {
        return this.ditoReportDitoEventToSlardar;
    }

    public final int getDitoReportEventToTeaRate() {
        return this.ditoReportEventToTeaRate;
    }

    public final boolean getEnableBtmComponentSizeCheck() {
        return this.enableBtmComponentSizeCheck;
    }

    public final boolean getEnableBtmParamsToLynxData() {
        return this.enableBtmParamsToLynxData;
    }

    public final boolean getEnableTurboMainLynxViewHolder() {
        return this.enableTurboMainLynxViewHolder;
    }

    public final boolean getFixLynxLayoutCallApiError() {
        return this.fixLynxLayoutCallApiError;
    }

    public final Map<String, Object> getNestedScrollV2EnableByScene() {
        return this.nestedScrollV2EnableByScene;
    }

    public final boolean getSendDitoBodyScrollDy() {
        return this.sendDitoBodyScrollDy;
    }

    public final boolean getUseLynxSelfCheckCompleteShow() {
        return this.useLynxSelfCheckCompleteShow;
    }

    public final void setBtmComponentMaxWatchLayoutTs(long r100) {
        this.btmComponentMaxWatchLayoutTs = r100;
    }

    public final void setDisableFmpViewDiff(boolean r100) {
        this.disableFmpViewDiff = r100;
    }

    public final void setEnableBtmComponentSizeCheck(boolean r100) {
        this.enableBtmComponentSizeCheck = r100;
    }

    public final void setEnableBtmParamsToLynxData(boolean r100) {
        this.enableBtmParamsToLynxData = r100;
    }
}
