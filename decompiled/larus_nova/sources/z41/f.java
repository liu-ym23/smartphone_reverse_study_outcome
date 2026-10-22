package z41;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f569910a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f569911b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f569912c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f569913d = null;

    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(f.class, "revLinkUselessLog", "getRevLinkUselessLog()Z", 0))};
        f569910a = r100;
        f r101 = new f();
        f569913d = r101;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("revlink_useless_log", Boolean.FALSE, Boolean.TYPE, false);
        ReadOnlyProperty r103 = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[0]);
        f569911b = r103;
        f569912c = ((Boolean) r103.getValue(r101, r100[0])).booleanValue();
    }

    public f() {
    }
}
