package u41;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f548663a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f548664b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f548665c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f548666d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f548667e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f548668f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f548669g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f548670h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f548671i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReadOnlyProperty f548672j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ReadOnlyProperty f548673k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ReadOnlyProperty f548674l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ReadOnlyProperty f548675m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final d f548676n = null;

    public d() {
    }

    public final boolean a() {
        return ((Boolean) f548665c.getValue(this, f548663a[1])).booleanValue();
    }

    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(d.class, "livePkAudienceScoreTrack", "getLivePkAudienceScoreTrack()Z", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "multiAnchorConnectMonitor", "getMultiAnchorConnectMonitor()Z", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "multiAnchorConnectMonitorValidationDuration", "getMultiAnchorConnectMonitorValidationDuration()I", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "multiAnchorEnterDurationCheckLog", "getMultiAnchorEnterDurationCheckLog()Z", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "multiAnchorEnterDurationCheckLimit", "getMultiAnchorEnterDurationCheckLimit()I", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "multiAnchorReportReceiveAudienceStream", "getMultiAnchorReportReceiveAudienceStream()Z", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "multiPlayerTraceLogEnable", "getMultiPlayerTraceLogEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "liveRevControlWidgetAutoUnloadMonitor", "getLiveRevControlWidgetAutoUnloadMonitor()Z", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "multiPkWrdsBackUp", "getMultiPkWrdsBackUp()Z", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "livePkAudienceLoadTrack", "getLivePkAudienceLoadTrack()Z", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "multiRevenueDoubleEnterRoomCallTrace", "getMultiRevenueDoubleEnterRoomCallTrace()Z", 0)), Reflection.property1(new PropertyReference1Impl(d.class, "multiRevenuePkDoubleEnterRoomCallTrace", "getMultiRevenuePkDoubleEnterRoomCallTrace()Z", 0))};
        f548663a = r100;
        f548676n = new d();
        Boolean r110 = Boolean.FALSE;
        Class r111 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_audience_score_message_track", r110, r111, false);
        f548664b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        Boolean r112 = Boolean.TRUE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_connect_monitor", r112, r111, false);
        f548665c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        Class r113 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_connect_monitor_validation_duration", 20000, r113, false);
        f548666d = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_enter_duration_check_log", r112, r111, false);
        f548667e = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_enter_duration_check_limit", 6000, r113, false);
        f548668f = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_report_receive_audience_stream", r112, r111, false);
        f548669g = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_player_trace_log_enable", r110, r111, false);
        f548670h = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_rev_control_widget_auto_unload_monitor", r110, r111, false);
        f548671i = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_revenue_pk_wrds_back_up", r110, r111, false);
        f548672j = UltraSettingsManager.a().a(r109.f271017a, r109.f271018b, r109.getType(), r109.f271020d, r100[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r114 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_audience_load_track", r110, r111, false);
        f548673k = UltraSettingsManager.a().a(r114.f271017a, r114.f271018b, r114.getType(), r114.f271020d, r100[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r115 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_revenue_double_enter_room_call_trace", r112, r111, false);
        f548674l = UltraSettingsManager.a().a(r115.f271017a, r115.f271018b, r115.getType(), r115.f271020d, r100[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r116 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_revenue_pk_double_enter_room_call_trace", r112, r111, false);
        f548675m = UltraSettingsManager.a().a(r116.f271017a, r116.f271018b, r116.getType(), r116.f271020d, r100[11]);
    }
}
