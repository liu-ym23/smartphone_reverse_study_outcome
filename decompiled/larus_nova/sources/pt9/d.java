package pt9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\bE\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u009b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010R\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u0010:J\u0010\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ¢\u0002\u0010W\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010XJ\u0013\u0010Y\u001a\u00020\u00032\b\u0010Z\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010[\u001a\u00020\\HÖ\u0001J\t\u0010]\u001a\u00020^HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b$\u0010\u001e\"\u0004\b%\u0010 R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b&\u0010\u001e\"\u0004\b'\u0010 R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 R\"\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b*\u0010\u001e\"\u0004\b+\u0010 R\"\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b,\u0010\u001e\"\u0004\b-\u0010 R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b.\u0010\u001eR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b/\u0010\u001eR\u001a\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b0\u0010\u001eR\u001a\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b1\u0010\u001eR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b2\u0010\u001eR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b3\u0010\u001eR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b4\u0010\u001eR\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b5\u0010\u001eR\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b6\u0010\u001eR\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b7\u0010\u001eR\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b8\u0010\u001eR\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010;\u001a\u0004\b9\u0010:R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b<\u0010\u001eR\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b=\u0010\u001eR\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b>\u0010\u001eR\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b?\u0010\u001e¨\u0006_"}, d2 = {"Lcom/larus/settings/opt/launch/AppLaunchOptV3;", "", "enable", "", "asyncInitMSSDKAfterFeed", "asyncPreInstallReport", "asyncStartPushAfterFeed", "asyncInitLocationAfterFeed", "asyncInitMiddleTabAfterFeed", "asyncInitShareAfterFeed", "asyncInitZLinkAfterFeed", "asyncReportDoraState", "asyncInitDoraManagerAfterFeed", "asyncInitAppletAfterFeed", "asyncInitTimon", "optScheduler", "optGLES", "boostRenderThread", "boostCpuAndGpuThread", "canBindBigCore", "enableFetchOpt", "fetchCovDelayDuration", "", "optNitaPreload", "enableResourcePreheating", "enableFirstFeedDelayLoad", "optPreloadPipeline", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getEnable", "()Ljava/lang/Boolean;", "setEnable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getAsyncInitMSSDKAfterFeed", "setAsyncInitMSSDKAfterFeed", "getAsyncPreInstallReport", "setAsyncPreInstallReport", "getAsyncStartPushAfterFeed", "setAsyncStartPushAfterFeed", "getAsyncInitLocationAfterFeed", "setAsyncInitLocationAfterFeed", "getAsyncInitMiddleTabAfterFeed", "setAsyncInitMiddleTabAfterFeed", "getAsyncInitShareAfterFeed", "setAsyncInitShareAfterFeed", "getAsyncInitZLinkAfterFeed", "getAsyncReportDoraState", "getAsyncInitDoraManagerAfterFeed", "getAsyncInitAppletAfterFeed", "getAsyncInitTimon", "getOptScheduler", "getOptGLES", "getBoostRenderThread", "getBoostCpuAndGpuThread", "getCanBindBigCore", "getEnableFetchOpt", "getFetchCovDelayDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getOptNitaPreload", "getEnableResourcePreheating", "getEnableFirstFeedDelayLoad", "getOptPreloadPipeline", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/larus/settings/opt/launch/AppLaunchOptV3;", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    @SerializedName("async_init_applet_after_feed")
    private final Boolean asyncInitAppletAfterFeed;

    @SerializedName("async_init_dora_manager_after_feed")
    private final Boolean asyncInitDoraManagerAfterFeed;

    @SerializedName("async_init_location_after_feed")
    private Boolean asyncInitLocationAfterFeed;

    @SerializedName("async_init_mssdk_after_feed")
    private Boolean asyncInitMSSDKAfterFeed;

    @SerializedName("async_init_middle_tab_after_feed")
    private Boolean asyncInitMiddleTabAfterFeed;

    @SerializedName("async_init_share_after_feed")
    private Boolean asyncInitShareAfterFeed;

    @SerializedName("async_init_Timon")
    private final Boolean asyncInitTimon;

    @SerializedName("async_init_zlink_after_feed")
    private final Boolean asyncInitZLinkAfterFeed;

    @SerializedName("async_pre_install_report")
    private Boolean asyncPreInstallReport;

    @SerializedName("async_report_dora_state")
    private final Boolean asyncReportDoraState;

    @SerializedName("async_start_push_after_feed")
    private Boolean asyncStartPushAfterFeed;

    @SerializedName("opt_cpu_and_gpu_thread")
    private final Boolean boostCpuAndGpuThread;

    @SerializedName("opt_render_thread")
    private final Boolean boostRenderThread;

    @SerializedName("can_bind_big_core")
    private final Boolean canBindBigCore;

    @SerializedName("enable")
    private Boolean enable;

    @SerializedName("enable_fetch_opt")
    private final Boolean enableFetchOpt;

    @SerializedName("enable_first_feed_delay_load")
    private final Boolean enableFirstFeedDelayLoad;

    @SerializedName("enable_resource_preheating")
    private final Boolean enableResourcePreheating;

    @SerializedName("fetch_cov_delay_duration")
    private final Long fetchCovDelayDuration;

    @SerializedName("opt_gles")
    private final Boolean optGLES;

    @SerializedName("opt_nita_preload")
    private final Boolean optNitaPreload;

    @SerializedName("opt_preload_pipeline")
    private final Boolean optPreloadPipeline;

    @SerializedName("opt_scheduler")
    private final Boolean optScheduler;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.enable, r101.enable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.asyncInitMSSDKAfterFeed, r101.asyncInitMSSDKAfterFeed) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.asyncPreInstallReport, r101.asyncPreInstallReport) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.asyncStartPushAfterFeed, r101.asyncStartPushAfterFeed) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.asyncInitLocationAfterFeed, r101.asyncInitLocationAfterFeed) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.asyncInitMiddleTabAfterFeed, r101.asyncInitMiddleTabAfterFeed) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.asyncInitShareAfterFeed, r101.asyncInitShareAfterFeed) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.asyncInitZLinkAfterFeed, r101.asyncInitZLinkAfterFeed) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.asyncReportDoraState, r101.asyncReportDoraState) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.asyncInitDoraManagerAfterFeed, r101.asyncInitDoraManagerAfterFeed) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.asyncInitAppletAfterFeed, r101.asyncInitAppletAfterFeed) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.asyncInitTimon, r101.asyncInitTimon) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.optScheduler, r101.optScheduler) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.optGLES, r101.optGLES) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.boostRenderThread, r101.boostRenderThread) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.boostCpuAndGpuThread, r101.boostCpuAndGpuThread) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.canBindBigCore, r101.canBindBigCore) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.enableFetchOpt, r101.enableFetchOpt) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.fetchCovDelayDuration, r101.fetchCovDelayDuration) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.optNitaPreload, r101.optNitaPreload) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.enableResourcePreheating, r101.enableResourcePreheating) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.enableFirstFeedDelayLoad, r101.enableFirstFeedDelayLoad) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.optPreloadPipeline, r101.optPreloadPipeline) == true) goto L77;
        return false;
    L77:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.enable;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.asyncInitMSSDKAfterFeed;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.asyncPreInstallReport;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.asyncStartPushAfterFeed;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.asyncInitLocationAfterFeed;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.asyncInitMiddleTabAfterFeed;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.asyncInitShareAfterFeed;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.asyncInitZLinkAfterFeed;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.asyncReportDoraState;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.asyncInitDoraManagerAfterFeed;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Boolean r131 = this.asyncInitAppletAfterFeed;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Boolean r134 = this.asyncInitTimon;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Boolean r137 = this.optScheduler;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        Boolean r140 = this.optGLES;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        Boolean r143 = this.boostRenderThread;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        Boolean r146 = this.boostCpuAndGpuThread;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        Boolean r149 = this.canBindBigCore;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        Boolean r152 = this.enableFetchOpt;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        Long r155 = this.fetchCovDelayDuration;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        Boolean r158 = this.optNitaPreload;
        if (r158 != null) goto L81;
        int r159 = 0;
    L82:
        int r160 = (r157 + r159) * 31;
        Boolean r161 = this.enableResourcePreheating;
        if (r161 != null) goto L85;
        int r162 = 0;
    L86:
        int r163 = (r160 + r162) * 31;
        Boolean r164 = this.enableFirstFeedDelayLoad;
        if (r164 != null) goto L89;
        int r165 = 0;
    L90:
        int r166 = (r163 + r165) * 31;
        Boolean r167 = this.optPreloadPipeline;
        if (r167 == null) goto L95;
        r101 = r167.hashCode();
    L95:
        return r166 + r101;
    L89:
        r165 = r164.hashCode();
        goto L90
    L85:
        r162 = r161.hashCode();
        goto L86
    L81:
        r159 = r158.hashCode();
        goto L82
    L77:
        r156 = r155.hashCode();
        goto L78
    L73:
        r153 = r152.hashCode();
        goto L74
    L69:
        r150 = r149.hashCode();
        goto L70
    L65:
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AppLaunchOptV3(enable=" + this.enable + ", asyncInitMSSDKAfterFeed=" + this.asyncInitMSSDKAfterFeed + ", asyncPreInstallReport=" + this.asyncPreInstallReport + ", asyncStartPushAfterFeed=" + this.asyncStartPushAfterFeed + ", asyncInitLocationAfterFeed=" + this.asyncInitLocationAfterFeed + ", asyncInitMiddleTabAfterFeed=" + this.asyncInitMiddleTabAfterFeed + ", asyncInitShareAfterFeed=" + this.asyncInitShareAfterFeed + ", asyncInitZLinkAfterFeed=" + this.asyncInitZLinkAfterFeed + ", asyncReportDoraState=" + this.asyncReportDoraState + ", asyncInitDoraManagerAfterFeed=" + this.asyncInitDoraManagerAfterFeed + ", asyncInitAppletAfterFeed=" + this.asyncInitAppletAfterFeed + ", asyncInitTimon=" + this.asyncInitTimon + ", optScheduler=" + this.optScheduler + ", optGLES=" + this.optGLES + ", boostRenderThread=" + this.boostRenderThread + ", boostCpuAndGpuThread=" + this.boostCpuAndGpuThread + ", canBindBigCore=" + this.canBindBigCore + ", enableFetchOpt=" + this.enableFetchOpt + ", fetchCovDelayDuration=" + this.fetchCovDelayDuration + ", optNitaPreload=" + this.optNitaPreload + ", enableResourcePreheating=" + this.enableResourcePreheating + ", enableFirstFeedDelayLoad=" + this.enableFirstFeedDelayLoad + ", optPreloadPipeline=" + this.optPreloadPipeline + ')';
    }

    public d() {
        Boolean r100 = Boolean.TRUE;
        Boolean r101 = Boolean.FALSE;
        this.enable = r100;
        this.asyncInitMSSDKAfterFeed = r101;
        this.asyncPreInstallReport = r100;
        this.asyncStartPushAfterFeed = r100;
        this.asyncInitLocationAfterFeed = r100;
        this.asyncInitMiddleTabAfterFeed = r100;
        this.asyncInitShareAfterFeed = r100;
        this.asyncInitZLinkAfterFeed = r100;
        this.asyncReportDoraState = r100;
        this.asyncInitDoraManagerAfterFeed = r100;
        this.asyncInitAppletAfterFeed = r100;
        this.asyncInitTimon = r100;
        this.optScheduler = r100;
        this.optGLES = r101;
        this.boostRenderThread = r100;
        this.boostCpuAndGpuThread = r100;
        this.canBindBigCore = r100;
        this.enableFetchOpt = r100;
        this.fetchCovDelayDuration = 1000L;
        this.optNitaPreload = r100;
        this.enableResourcePreheating = r100;
        this.enableFirstFeedDelayLoad = r101;
        this.optPreloadPipeline = r100;
    }
}
