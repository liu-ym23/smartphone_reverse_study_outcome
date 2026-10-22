package vm2;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes11.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f556336a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f556337b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f556338c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f556339d = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(l.class, "LIVE_STREAM_ENABLE_SEI_SIGN", "getLIVE_STREAM_ENABLE_SEI_SIGN()Z", 1)), Reflection.property0(new PropertyReference0Impl(l.class, "LIVE_MULTI_LINK_LINK_DEBUG_LOG_ENABLE", "getLIVE_MULTI_LINK_LINK_DEBUG_LOG_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(l.class, "DISABLE_LYNX_DEBUG_INFO", "getDISABLE_LYNX_DEBUG_INFO()Z", 1))};
        f556336a = r100;
        Boolean r101 = Boolean.TRUE;
        Class r102 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_stream_enable_sei_sign", r101, r102, false);
        f556337b = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[0]);
        Boolean r104 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_link_link_debug_log_enable", r104, r102, false);
        f556338c = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("disable_lynx_debug_info", r104, r102, false);
        f556339d = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[2]);
    }

    public static final boolean a() {
        return ((Boolean) f556338c.getValue(null, f556336a[1])).booleanValue();
    }
}
