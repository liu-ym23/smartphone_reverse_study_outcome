package y41;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f565925a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f565926b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f565927c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f565928d = null;

    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(b.class, "multiAnchorForwardOptEnable", "getMultiAnchorForwardOptEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "multiAnchorForwardInfoUpdateOpt", "getMultiAnchorForwardInfoUpdateOpt()Z", 0))};
        f565925a = r100;
        f565928d = new b();
        Boolean r101 = Boolean.FALSE;
        Class r102 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_forward_opt_enable", r101, r102, false);
        f565926b = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_forward_info_update_opt", Boolean.TRUE, r102, false);
        f565927c = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[1]);
    }

    public b() {
    }
}
