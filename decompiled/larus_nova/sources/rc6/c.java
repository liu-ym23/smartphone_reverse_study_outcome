package rc6;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f537152a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f537153b = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(c.class, "LIVE_GIFT_USE_KMP_GIFT_DIALOG", "getLIVE_GIFT_USE_KMP_GIFT_DIALOG()Z", 1))};
        f537152a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_use_kmp_gift_dialog", Boolean.FALSE, Boolean.TYPE, false);
        f537153b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
    }
}
