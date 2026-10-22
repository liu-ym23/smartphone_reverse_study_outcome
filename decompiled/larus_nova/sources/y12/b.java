package y12;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f565621a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f565622b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f565623c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f565624d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f565625e = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_ENABLE_GIFT_PANEL_HEIGHT_INCREASE", "getLIVE_ENABLE_GIFT_PANEL_HEIGHT_INCREASE()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFT_DEFAULT_SELECT_SWITCH", "getLIVE_GIFT_DEFAULT_SELECT_SWITCH()Z", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFTPANEL_PROPERTY_EXPIRE_REMIND_II", "getLIVE_GIFTPANEL_PROPERTY_EXPIRE_REMIND_II()I", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "LIVE_GIFTPANEL_PROPERTY_UP_FLOW_OPEN", "getLIVE_GIFTPANEL_PROPERTY_UP_FLOW_OPEN()Z", 1))};
        f565621a = r100;
        Boolean r101 = Boolean.FALSE;
        Class r102 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_gift_panel_height_increase", r101, r102, false);
        f565622b = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[0]);
        Boolean r104 = Boolean.TRUE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_default_select_switch", r104, r102, false);
        f565623c = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_giftpanel_property_expire_remind_II", 0, Integer.TYPE, false);
        f565624d = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("LIVE_GIFTPANEL_PROPERTY_UP_FLOW_OPEN", r104, r102, false);
        f565625e = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[3]);
    }
}
