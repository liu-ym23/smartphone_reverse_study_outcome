package g51;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f480016a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f480017b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f480018c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f480019d = null;

    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(a.class, "multiAnchorEnterMessagePostUiThread", "getMultiAnchorEnterMessagePostUiThread()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveMultiAnchorRandomTeamLayoutEnable", "getLiveMultiAnchorRandomTeamLayoutEnable()Z", 0))};
        f480016a = r100;
        f480019d = new a();
        Boolean r101 = Boolean.TRUE;
        Class r102 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_enter_message_post_ui_thread", r101, r102, false);
        f480017b = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multilinker_random_team_layout_opt_enable", r101, r102, false);
        f480018c = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[1]);
    }

    public a() {
    }
}
