package vm2;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f555739a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f555740b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f555741c = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_ROOM_MICSEAT_UNIFIED_ICON", "getLIVE_ROOM_MICSEAT_UNIFIED_ICON()Lcom/bytedance/android/livesdk/multilink/setting/model/InteractMicSeatConfig;", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_MULTI_LINK_GUEST_PLAYER_VIEW_SEI_UPDATE_TIMEOUT_SWITCH_PREVIEW_V2", "getLIVE_MULTI_LINK_GUEST_PLAYER_VIEW_SEI_UPDATE_TIMEOUT_SWITCH_PREVIEW_V2()Z", 1))};
        f555739a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_micseat_value_icon_unified", new wm2.a(), wm2.a.class, false);
        f555740b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_link_guest_player_view_sei_update_timeout_switch_preview_v2", Boolean.TRUE, Boolean.TYPE, false);
        f555741c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
    }
}
