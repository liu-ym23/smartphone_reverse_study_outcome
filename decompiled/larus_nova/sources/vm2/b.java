package vm2;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f555742a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f555743b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f555744c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f555745d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f555746e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f555747f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f555748g = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(b.class, "LOCAL_TEST_USE_ONLINE_GECKO", "getLOCAL_TEST_USE_ONLINE_GECKO()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "PK_TRACE_LOG_ENABLE", "getPK_TRACE_LOG_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_MONITOR_RTC_RESOLUTIO_REDUNDANCY_THRESHOLD", "getLIVE_MONITOR_RTC_RESOLUTIO_REDUNDANCY_THRESHOLD()F", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "MULTI_ANCHOR_CROSS_CHANNEL_CHECK_ENABLE", "getMULTI_ANCHOR_CROSS_CHANNEL_CHECK_ENABLE()I", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "MULTI_ANCHOR_CHANNEL_TIMER", "getMULTI_ANCHOR_CHANNEL_TIMER()I", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_PROCESS_YUV_OPT_ENABLE", "getLIVE_PROCESS_YUV_OPT_ENABLE()Z", 1))};
        f555742a = r100;
        Boolean r101 = Boolean.FALSE;
        Class r110 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("local_test_use_online_gecko", r101, r110, false);
        f555743b = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_trance_log_enable", r101, r110, false);
        f555744c = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_monitor_rtc_resolutio_redundancy_threshold", Float.valueOf(0.1f), Float.TYPE, false);
        f555745d = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[2]);
        Class r105 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_cross_channel_check_enable", 0, r105, false);
        f555746e = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_cross_channel_backup_timer_duration", 0, r105, false);
        f555747f = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_process_yuv_opt_enable", Boolean.TRUE, r110, false);
        f555748g = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[5]);
    }
}
