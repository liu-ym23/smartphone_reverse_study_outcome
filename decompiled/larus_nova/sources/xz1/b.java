package xz1;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f565504a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f565505b = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(b.class, "giftExtraFrequencyCheck", "getGiftExtraFrequencyCheck()Z", 1))};
        f565504a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("gift_extra_frequency_check", Boolean.FALSE, Boolean.TYPE, false);
        f565505b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
    }

    public static final boolean a() {
        return ((Boolean) f565505b.getValue(null, f565504a[0])).booleanValue();
    }
}
