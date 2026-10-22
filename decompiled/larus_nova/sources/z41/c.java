package z41;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f569898a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f569899b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a51.b f569900c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f569901d = null;

    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(c.class, "layoutOptConfig", "getLayoutOptConfig()Lcom/bytedance/android/live/revlink/impl/settings/opt/model/RevLinkAnimOptConfig;", 0))};
        f569898a = r100;
        c r101 = new c();
        f569901d = r101;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("revlink_anim_opt_config", new a51.b(), a51.b.class, false);
        ReadOnlyProperty r103 = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[0]);
        f569899b = r103;
        f569900c = (a51.b) r103.getValue(r101, r100[0]);
    }

    public c() {
    }
}
