package rg7;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f537712a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f537713b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f537714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Function0<JsonObject> f537715d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Integer> f537716e = null;

    public static JsonObject a() {
        JsonObject r100 = com.bytedance.timonbase.config.a.a("cert_config");     // Catch: Throwable -> L12
        if (r100 == null) goto L6;
        JsonObject r101 = r100.getAsJsonObject("pasteboard");     // Catch: Throwable -> L12
    L7:
        if (r101 != null) goto L10;
        com.bytedance.timonbase.b.f("从 TMConfig 中获取配置失败");     // Catch: Throwable -> L12
        return null;
    L10:
        com.bytedance.timonbase.b.f("从 TMConfig 中获取配置成功");     // Catch: Throwable -> L12
        return r101;
    L6:
        r101 = null;
    L12:
        com.bytedance.timonbase.b.f("parse config failed");
        return null;
    }

    static {
        f537712a = new c(null);
        f537713b = new b(32, MapsKt.emptyMap(), 30000);
        f537716e = new ConcurrentHashMap();
    }

    public static c b(String r100) {
        b r101 = f537714c;
        if (r101 == null) goto L10;
        Map<String, c> r102 = r101.f537717a;
        if (r102 == null) goto L10;
        c r103 = r102.get(r100);
        if (r103 == null) goto L10;
        return r103;
    L10:
        return f537712a;
    }

    public static c c(String r100) {
        b r101 = f537714c;
        if (r101 == null) goto L7;
        Map<String, c> r102 = r101.f537717a;
        if (r102 == null) goto L7;
        return r102.get(r100);
    L7:
        return null;
    }

    public static b d(JsonObject r100) {
        if (r100 != null) goto L27;
    L24:
        return null;
    L27:
        JsonElement r101 = r100.get("unit_disable");     // Catch: Exception -> L26
        if (r101 == null) goto L7;
        int r102 = r101.getAsInt();     // Catch: Exception -> L26
    L8:
        LinkedHashMap r103 = new LinkedHashMap();     // Catch: Exception -> L26
        Iterator<T> r104 = r100.entrySet().iterator();     // Catch: Exception -> L26
    L11:
        if (r104.hasNext() == false) goto L18;
        Map.Entry r105 = (Map.Entry) r104.next();     // Catch: Exception -> L26
        if (Intrinsics.areEqual((String) r105.getKey(), "unit_disable") == true) goto L11;
        if (Intrinsics.areEqual((String) r105.getKey(), "enter_background_duration_threshold") == true) goto L11;
        r103.put(r105.getKey(), new Gson().fromJson((JsonElement) r105.getValue(), c.class));     // Catch: Exception -> L26
        goto L11
    L18:
        JsonElement r106 = r100.get("enter_background_duration_threshold");     // Catch: Exception -> L26
        if (r106 == null) goto L21;
        int r107 = r106.getAsInt();     // Catch: Exception -> L26
    L22:
        return new b(r102, r103, r107);
    L21:
        r107 = 30000;
        goto L22
    L7:
        r102 = 0;
        goto L8
    }

    public static boolean e(String r100) {
        c r101 = b(r100);
        if (r101.a() != 0) goto L5;
    L7:
        return false;
    L5:
        if (System.currentTimeMillis() <= r101.a()) goto L7;
        return true;
    }
}
