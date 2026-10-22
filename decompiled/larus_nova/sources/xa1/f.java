package xa1;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f563042a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f563043b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f563044c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f563045d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f563046e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f563047f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f563048g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f563049h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f563050i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReadOnlyProperty f563051j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ReadOnlyProperty f563052k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ReadOnlyProperty f563053l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ReadOnlyProperty f563054m = null;

    public static final boolean a() {
        return ((Boolean) f563053l.getValue(null, f563042a[10])).booleanValue();
    }

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(f.class, "showLinkCrossRoomResetStacktrace", "getShowLinkCrossRoomResetStacktrace()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "liveTurnOnOptEnable", "getLiveTurnOnOptEnable()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "multiChannelOptEnable", "getMultiChannelOptEnable()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "liveMonitorLiveCoreResolutionEnable", "getLiveMonitorLiveCoreResolutionEnable()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "livePkMonitorRtcResolutionEnable", "getLivePkMonitorRtcResolutionEnable()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "resetLiveCoreParamsLeaveChannel", "getResetLiveCoreParamsLeaveChannel()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "enableRtcChorusOptimic", "getEnableRtcChorusOptimic()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "liveLinkSdkEnableSwitch", "getLiveLinkSdkEnableSwitch()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "liveLinkSdkMultiSupportedScenes", "getLiveLinkSdkMultiSupportedScenes()[Ljava/lang/Integer;", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "multiLinkAudienceRtcRenderYuvOpt", "getMultiLinkAudienceRtcRenderYuvOpt()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "liveRevKibanaLogDebug", "getLiveRevKibanaLogDebug()Z", 1)), Reflection.property0(new PropertyReference0Impl(f.class, "liveRevPkTalkVolumeEnable", "getLiveRevPkTalkVolumeEnable()Z", 1))};
        f563042a = r100;
        Boolean r110 = Boolean.TRUE;
        Class r111 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("show_link_cross_room_reset_stacktrace", r110, r111, false);
        f563043b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_turn_on_opt_enable", r110, r111, false);
        f563044c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_interact_forward_stream_opt_enable", r110, r111, false);
        f563045d = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_monitor_livecore_resolution_enable", r110, r111, false);
        f563046e = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_monitor_rtc_resolution_enable", r110, r111, false);
        f563047f = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_core_reset_params_leave_channel", r110, r111, false);
        f563048g = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("enable_rtc_chorus_optimic", r110, r111, false);
        f563049h = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_sdk_enable_switch", r110, r111, false);
        f563050i = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_sdk_multi_supported_scenes", new Integer[0], yo3.a.f568664a, false);
        f563051j = UltraSettingsManager.a().a(r109.f271017a, r109.f271018b, r109.getType(), r109.f271020d, r100[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r112 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_link_audience_rtc_render_yuv_opt", Boolean.FALSE, r111, false);
        f563052k = UltraSettingsManager.a().a(r112.f271017a, r112.f271018b, r112.getType(), r112.f271020d, r100[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r113 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_rev_kibana_log_debug", r110, r111, false);
        f563053l = UltraSettingsManager.a().a(r113.f271017a, r113.f271018b, r113.getType(), r113.f271020d, r100[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r114 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_rev_pk_talk_volume_enable", r110, r111, false);
        f563054m = UltraSettingsManager.a().a(r114.f271017a, r114.f271018b, r114.getType(), r114.f271020d, r100[11]);
    }
}
