package i11;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f487932a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f487933b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f487934c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f487935d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f487936e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f487937f = null;

    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(e.class, "multiAnchorCacheListOptEnable", "getMultiAnchorCacheListOptEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "multiAnchorLeaveMsgConsumeOptEnable", "getMultiAnchorLeaveMsgConsumeOptEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "multiAnchorMessageRequestEnable", "getMultiAnchorMessageRequestEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(e.class, "seiLoadForceRequestList", "getSeiLoadForceRequestList()Z", 0))};
        f487932a = r100;
        f487937f = new e();
        Boolean r101 = Boolean.TRUE;
        Class r102 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_cache_list_opt_enable", r101, r102, false);
        f487933b = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_leave_msg_opt_enable", r101, r102, false);
        f487934c = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_message_enable", r101, r102, false);
        f487935d = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("sei_load_force_request_list", r101, r102, false);
        f487936e = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[3]);
    }

    public e() {
    }
}
