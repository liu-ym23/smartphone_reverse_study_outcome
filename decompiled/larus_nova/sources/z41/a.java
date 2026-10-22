package z41;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f569888a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f569889b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f569890c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f569891d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f569892e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f569893f = null;

    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(a.class, "printRequestLayout", "getPrintRequestLayout()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "printPkMeasureDuration", "getPrintPkMeasureDuration()Z", 0))};
        f569888a = r100;
        a r101 = new a();
        f569893f = r101;
        Boolean r102 = Boolean.FALSE;
        Class r103 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_measure_debug_print_request_layout", r102, r103, false);
        ReadOnlyProperty r105 = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[0]);
        f569889b = r105;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_measure_debug_print_duration", r102, r103, false);
        ReadOnlyProperty r107 = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[1]);
        f569890c = r107;
        f569891d = ((Boolean) r105.getValue(r101, r100[0])).booleanValue();
        f569892e = ((Boolean) r107.getValue(r101, r100[1])).booleanValue();
    }

    public a() {
    }
}
