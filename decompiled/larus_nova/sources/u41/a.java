package u41;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f548645a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f548646b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f548647c = null;

    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(a.class, "livePkApiTokenEnable", "getLivePkApiTokenEnable()Z", 0))};
        f548645a = r100;
        f548647c = new a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_api_token_enable", Boolean.TRUE, Boolean.TYPE, false);
        f548646b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
    }

    public a() {
    }

    public final boolean a() {
        return ((Boolean) f548646b.getValue(this, f548645a[0])).booleanValue();
    }
}
