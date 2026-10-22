package qy1;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f535176a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f535177b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f535178c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f535179d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f535180e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f535181f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f535182g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f535183h = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GROUP_COMPONENT_USE_WRDS", "getLIVE_GROUP_COMPONENT_USE_WRDS()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GROUP_REFRESH_LAYOUT_WHEN_ORIENTATION_CHANGE", "getLIVE_GROUP_REFRESH_LAYOUT_WHEN_ORIENTATION_CHANGE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GROUP_VIEW_TOP_MARGIN_OPTIMIZE", "getLIVE_GROUP_VIEW_TOP_MARGIN_OPTIMIZE()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GROUP_LIVE_COMPONENT_USE_ANNIEX", "getLIVE_GROUP_LIVE_COMPONENT_USE_ANNIEX()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_GROUP_LIVE_FE_FOLD_OPT", "getLIVE_GROUP_LIVE_FE_FOLD_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "GROUP_LIVE_CONTAINER_RTS", "getGROUP_LIVE_CONTAINER_RTS()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "GROUP_LIVE_STREAM_MESSAGE", "getGROUP_LIVE_STREAM_MESSAGE()Z", 1))};
        f535176a = r100;
        Boolean r101 = Boolean.TRUE;
        Class r110 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_group_component_use_wrds", r101, r110, false);
        f535177b = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[0]);
        Boolean r111 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_group_refresh_layout_when_orientation_change", r111, r110, false);
        f535178c = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_group_view_top_margin_optimize", r101, r110, false);
        f535179d = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_group_live_component_use_anniex", r101, r110, false);
        f535180e = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("group_live_fe_fold_opt", r111, r110, false);
        f535181f = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("group_live_container_rts", r111, r110, false);
        f535182g = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("group_live_stream_message", r111, r110, false);
        f535183h = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[6]);
    }

    public static final boolean a() {
        return ((Boolean) f535182g.getValue(null, f535176a[5])).booleanValue();
    }
}
