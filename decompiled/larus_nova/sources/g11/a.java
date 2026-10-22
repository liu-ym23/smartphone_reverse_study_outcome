package g11;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import java.util.ArrayList;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f479567a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f479568b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f479569c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f479570d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f479571e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f479572f = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(a.class, "multiAnchorCrossChannelCheckEnable", "getMultiAnchorCrossChannelCheckEnable()I", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "multiAnchorChannelTimer", "getMultiAnchorChannelTimer()I", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "pkTraceLogEnable", "getPkTraceLogEnable()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "linkMediaInfoChangeEnable", "getLinkMediaInfoChangeEnable()Z", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "interactFullLinkPointBlackList", "getInteractFullLinkPointBlackList()Ljava/util/ArrayList;", 1))};
        f479567a = r100;
        Class r101 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_cross_channel_check_enable", 0, r101, false);
        f479568b = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_cross_channel_backup_timer_duration", 8, r101, false);
        f479569c = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[1]);
        Boolean r104 = Boolean.FALSE;
        Class r105 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_trance_log_enable", r104, r105, false);
        f479570d = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_media_info_change_callback_enable", Boolean.TRUE, r105, false);
        f479571e = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("interact_fulllink_point_blacklist", new ArrayList(), xo3.a.f564668a, false);
        f479572f = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[4]);
    }

    public static final boolean a() {
        return ((Boolean) f479570d.getValue(null, f479567a[2])).booleanValue();
    }
}
