package u41;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f548648a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f548649b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f548650c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f548651d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f548652e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f548653f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f548654g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f548655h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f548656i = null;

    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(b.class, "multiLoadRevInP0", "getMultiLoadRevInP0()I", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "multiRevenueLinkWrdsBackup", "getMultiRevenueLinkWrdsBackup()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "multiRevenueLinkEnterCheckThreshold", "getMultiRevenueLinkEnterCheckThreshold()J", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "multiRevenueSuperPreload", "getMultiRevenueSuperPreload()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "multiRevenueDoubleEnterRoomCall", "getMultiRevenueDoubleEnterRoomCall()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "multiRevenuePreloadDataThreshold", "getMultiRevenuePreloadDataThreshold()J", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "multiInteractModeChangeSetting", "getMultiInteractModeChangeSetting()Z", 0))};
        f548648a = r100;
        f548656i = new b();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_load_rev_in_p0", 0, Integer.TYPE, false);
        f548649b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        Boolean r102 = Boolean.FALSE;
        Class r110 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_revenue_link_wrds_back_up", r102, r110, false);
        f548650c = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[1]);
        Class r111 = Long.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_revenue_link_enter_check_threshold", 500L, r111, false);
        f548651d = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_revenue_super_preload", r102, r110, false);
        f548652e = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[3]);
        Boolean r106 = Boolean.TRUE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_revenue_double_enter_room_call", r106, r110, false);
        f548653f = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_revenue_preload_data_threshold", 3000L, r111, false);
        f548654g = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_interact_mode_change_settings", r106, r110, false);
        f548655h = UltraSettingsManager.a().a(r109.f271017a, r109.f271018b, r109.getType(), r109.f271020d, r100[6]);
    }

    public b() {
    }

    public final boolean a() {
        return ((Boolean) f548655h.getValue(this, f548648a[6])).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) f548652e.getValue(this, f548648a[3])).booleanValue();
    }
}
