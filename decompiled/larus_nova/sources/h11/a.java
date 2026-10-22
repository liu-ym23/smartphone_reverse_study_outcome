package h11;

import com.bytedance.android.livesdk.config.v01;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import vh7.b;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f483513a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f483514b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f483515c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f483516d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f483517e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f483518f = null;

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(a.class, "liveLinkMicApiFetchUseUplink", "getLiveLinkMicApiFetchUseUplink()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "checkLinkerInterval", "getCheckLinkerInterval()I", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "checkLinkerEnable", "getCheckLinkerEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "linkRevConnectConfig", "getLinkRevConnectConfig()Lcom/bytedance/android/livesdk/config/LinkRevConnectConfig;", 0))};
        f483513a = r100;
        f483518f = new a();
        Boolean r101 = Boolean.FALSE;
        Class r102 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_linkmic_api_fetch_use_uplink", r101, r102, false);
        f483514b = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_check_linker_interval", 20, Integer.TYPE, false);
        f483515c = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_check_linker_enable", Boolean.TRUE, r102, false);
        f483516d = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[2]);
        Class<?> r106 = ((JsonAdapter) v01.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r107 = b.f554981a;
        Constructor r108 = r107.get(r106);
        if (r108 != null) goto L12;
        r108 = r106.getConstructor(new Class[0]);
        if (r108 == null) goto L11;
        Constructor<? extends SerializableObjectJsonAdapterBase> r109 = r107.putIfAbsent(r106, (Constructor<? extends SerializableObjectJsonAdapterBase>) r108);
        if (r109 == null) goto L12;
        r108 = r109;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r110 = ((SerializableObjectJsonAdapterBase) r108.newInstance(new Object[0])).createInstance();
        if (r110 == null) goto L17;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r111 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("link_rev_connect_config", (v01) r110, v01.class, true);
        f483517e = UltraSettingsManager.a().a(r111.f271017a, r111.f271018b, r111.getType(), r111.f271020d, r100[3]);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.config.LinkRevConnectConfig");
    }

    public a() {
    }

    public final v01 a() {
        return (v01) f483517e.getValue(this, f483513a[3]);
    }
}
