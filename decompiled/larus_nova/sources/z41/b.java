package z41;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f569894a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f569895b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a51.a f569896c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f569897d = null;

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(b.class, "measureOptConfig", "getMeasureOptConfig()Lcom/bytedance/android/live/revlink/impl/settings/opt/model/PkMeasureOptConfig;", 0))};
        f569894a = r100;
        b r101 = new b();
        f569897d = r101;
        Class<?> r102 = ((JsonAdapter) a51.a.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r103 = vh7.b.f554981a;
        Constructor r104 = r103.get(r102);
        if (r104 != null) goto L12;
        r104 = r102.getConstructor(new Class[0]);
        if (r104 == null) goto L11;
        Constructor<? extends SerializableObjectJsonAdapterBase> r105 = r103.putIfAbsent(r102, (Constructor<? extends SerializableObjectJsonAdapterBase>) r104);
        if (r105 == null) goto L12;
        r104 = r105;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r106 = ((SerializableObjectJsonAdapterBase) r104.newInstance(new Object[0])).createInstance();
        if (r106 == null) goto L17;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_measure_opt_config", (a51.a) r106, a51.a.class, false);
        ReadOnlyProperty r108 = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[0]);
        f569895b = r108;
        f569896c = (a51.a) r108.getValue(r101, r100[0]);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.settings.opt.model.PkMeasureOptConfig");
    }

    public b() {
    }
}
