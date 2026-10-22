package p41;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f527645a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f527646b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f527647c = null;

    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(b.class, "liveLinkRevGameSetting", "getLiveLinkRevGameSetting()Lcom/bytedance/android/live/revlink/impl/settings/LiveLinkRevGameSetting;", 0))};
        f527645a = r100;
        f527647c = new b();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_rev_link_game", new a(), a.class, false);
        f527646b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
    }

    public b() {
    }
}
