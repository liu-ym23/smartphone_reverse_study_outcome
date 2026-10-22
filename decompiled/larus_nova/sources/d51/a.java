package d51;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f466894a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f466895b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f466896c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f466897d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f466898e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f466899f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f466900g = null;

    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(a.class, "livePkHybridUrl", "getLivePkHybridUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkTeamTaskOptUrl", "getLivePkTeamTaskOptUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveBreakThroughTopBarUrl", "getLiveBreakThroughTopBarUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkBrewHybridUrl", "getLivePkBrewHybridUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkBattlePowerUrl", "getLivePkBattlePowerUrl()Ljava/lang/String;", 0))};
        f466894a = r100;
        f466900g = new a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_hybrid_url", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/revenue_pk_hybrid_douyin/pages/hybrid/template.js", String.class, false);
        f466895b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_team_task_opt_url", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/revenue_pk_hybrid_douyin/pages/team_task/template.js", String.class, false);
        f466896c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_breakthrough_topbar_url", j51.a.a("https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/revenue_pk_hybrid_douyin/pages/break_through_bar/template.js", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/revenue_pk_hybrid_douyin/pages/break_through_bar/template.js", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/revenue_pk_hybrid_saas/pages/break_through_bar/template.js"), String.class, false);
        f466897d = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_multi_brew_hybrid_url", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/revenue_pk_panel_lynx_douyin/pages/npk_r_quick/template.js", String.class, false);
        f466898e = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_battle_power_url", j51.a.a("https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/revenue_pk_hybrid_douyin/pages/battle_power/template.js", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/revenue_pk_hybrid_douyin/pages/battle_power/template.js", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/revenue_pk_hybrid_saas/pages/battle_power/template.js"), String.class, false);
        f466899f = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[4]);
    }

    public a() {
    }

    public final String a() {
        return (String) f466897d.getValue(this, f466894a[2]);
    }
}
