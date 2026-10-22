package qu0;

import com.bytedance.android.live.revenue.common.p;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f534834a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f534835b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f534836c = null;

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(b.class, "config", "getConfig()Lcom/bytedance/android/live/profit/livepet/config/LivePetConfig;", 0))};
        f534834a = r100;
        f534836c = new b();
        Class<?> r101 = ((JsonAdapter) a.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r102 = vh7.b.f554981a;
        Constructor r103 = r102.get(r101);
        if (r103 != null) goto L12;
        r103 = r101.getConstructor(new Class[0]);
        if (r103 == null) goto L11;
        Constructor<? extends SerializableObjectJsonAdapterBase> r104 = r102.putIfAbsent(r101, (Constructor<? extends SerializableObjectJsonAdapterBase>) r103);
        if (r104 == null) goto L12;
        r103 = r104;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r105 = ((SerializableObjectJsonAdapterBase) r103.newInstance(new Object[0])).createInstance();
        if (r105 == null) goto L17;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pet_config", (a) r105, a.class, false);
        f534835b = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[0]);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.profit.livepet.config.LivePetConfig");
    }

    public b() {
    }

    public final a a() {
        return (a) f534835b.getValue(this, f534834a[0]);
    }

    public final a.c b(long r100) {
        JsonObject r101 = a().D5().get("default");
        a.c r102 = null;
        if (r101 == null) goto L5;
        a.c r103 = new a.c(r101);
    L6:
        JsonObject r104 = a().D5().get(String.valueOf(r100));
        if (r104 == null) goto L9;
        r102 = new a.c(r104);
    L9:
        if (r102 != null) goto L11;
        return r103;
    L11:
        if (r103 != null) goto L14;
        return r102;
    L14:
        return new a.c(c(r103, r102));
    L5:
        r103 = null;
        goto L6
    }

    public static JsonObject c(p r100, p r101) {
        JsonObject r102 = r100.f90911a;
        JsonObject r103 = r101.f90911a;
        JsonObject r104 = r102.deepCopy();
        Iterator<T> r105 = r103.entrySet().iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        Map.Entry r106 = (Map.Entry) r105.next();
        r104.add((String) r106.getKey(), (JsonElement) r106.getValue());
        goto L4
    L6:
        return r104;
    }
}
