package xa1;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f563036a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f563037b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f563038c = null;

    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(c.class, "liveStreamEnableSeiSign", "getLiveStreamEnableSeiSign()Z", 0))};
        f563036a = r100;
        f563038c = new c();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_stream_enable_sei_sign", Boolean.FALSE, Boolean.TYPE, false);
        f563037b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
    }

    public c() {
    }
}
