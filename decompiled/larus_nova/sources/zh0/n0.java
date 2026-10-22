package zh0;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes46.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f572149a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f572150b = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(n0.class, "IGNORE_AUTO_SWITCH_BG_PLAY_MODE", "getIGNORE_AUTO_SWITCH_BG_PLAY_MODE()Ljava/util/List;", 1))};
        f572149a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_ignore_auto_switch_bg_play_mode", CollectionsKt.listOf(43), oo3.a.f524583a, false);
        f572150b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
    }
}
