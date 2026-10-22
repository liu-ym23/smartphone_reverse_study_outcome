package j11;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f496857a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f496858b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f496859c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f496860d = null;

    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(a.class, "linkKmpWidgetFixPure", "getLinkKmpWidgetFixPure()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "linkKmpWidgetFixLeak", "getLinkKmpWidgetFixLeak()Z", 0))};
        f496857a = r100;
        f496860d = new a();
        Boolean r101 = Boolean.FALSE;
        Class r102 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("link_kmp_widget_fix_pure", r101, r102, false);
        f496858b = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("link_kmp_widget_fix_leak", Boolean.TRUE, r102, false);
        f496859c = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[1]);
    }

    public a() {
    }
}
