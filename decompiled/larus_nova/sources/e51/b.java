package e51;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f471040a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f471041b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f471042c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f471043d = null;

    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(b.class, "livePkSupportLinkV2", "getLivePkSupportLinkV2()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "livePkAudienceGetOppositeAnchorLinkMicId", "getLivePkAudienceGetOppositeAnchorLinkMicId()Z", 0))};
        f471040a = r100;
        f471043d = new b();
        Boolean r101 = Boolean.TRUE;
        Class r102 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_support_start_pk_with_audience", r101, r102, false);
        f471041b = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_audience_get_opposite_anchor_linkmic_id", r101, r102, false);
        f471042c = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[1]);
    }

    public b() {
    }

    public final boolean a() {
        return ((Boolean) f471041b.getValue(this, f471040a[0])).booleanValue();
    }
}
