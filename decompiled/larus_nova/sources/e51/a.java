package e51;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f471037a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f471038b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f471039c = null;

    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(a.class, "liveFlexActivityEntrance", "getLiveFlexActivityEntrance()I", 0))};
        f471037a = r100;
        f471039c = new a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_flex_activity_entrance", 1, Integer.TYPE, true);
        f471038b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
    }

    public a() {
    }

    public final int a() {
        return ((Number) f471038b.getValue(this, f471037a[0])).intValue();
    }
}
