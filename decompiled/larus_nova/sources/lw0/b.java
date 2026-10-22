package lw0;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f510987a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f510988b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f510989c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f510990d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f510991e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f510992f = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_CASH_EXCHANGE_PROMPT_OPT_ENABLE", "getLIVE_CASH_EXCHANGE_PROMPT_OPT_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "AUTO_EXCHANGE_SWITCH_ON_SERVER", "getAUTO_EXCHANGE_SWITCH_ON_SERVER()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_CASH_EXCHANGE_ENABLE", "getLIVE_CASH_EXCHANGE_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_FLAME_EXCHANGE_ENABLE", "getLIVE_FLAME_EXCHANGE_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_XIGUA_DIAMOND_EXCHANGE_API", "getLIVE_XIGUA_DIAMOND_EXCHANGE_API()Z", 1))};
        f510987a = r100;
        Boolean r101 = Boolean.FALSE;
        Class r102 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_show_income_exchange_reminder", r101, r102, false);
        f510988b = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("auto_exchange_switch_on_server", r101, r102, false);
        f510989c = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_cash_exchange_enable", r101, r102, false);
        f510990d = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_flame_redeem_enable", r101, r102, false);
        f510991e = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_xigua_diamond_exchange_api", Boolean.TRUE, r102, false);
        f510992f = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[4]);
    }

    public static final boolean a() {
        return ((Boolean) f510989c.getValue(null, f510987a[1])).booleanValue();
    }
}
