package com.bytedance.ee.bear.bitable.common.widgets.item;

import com.baidu.platform.comapi.map.MapController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f210019a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, k> f210020b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<String, j<?>> f210021c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap<String, Class<?>> f210022d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashMap<String, l> f210023e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final HashMap<String, Class<?>> f210024f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final HashMap<String, m> f210025g = null;

    static {
        f210019a = new GsonBuilder().create();
        f210020b = new HashMap();
        f210021c = new HashMap();
        f210022d = new HashMap();
        f210023e = new HashMap();
        f210024f = new HashMap();
        f210025g = new HashMap();
    }

    public static Object a(String r100, JsonElement r101) {
        if (r101 != null) goto L43;
    L9:
        JsonElement r102 = null;
    L10:
        Class<?> r103 = f210022d.get(r100);     // Catch: Exception -> L7
        boolean r104 = true;
        if (r102 != null) goto L13;
    L15:
        boolean r105 = false;
    L16:
        if (r105 == false) goto L20;
        if (r102 == null) goto L44;
        Object r106 = f210019a.fromJson(r102, r103);     // Catch: Exception -> L7
    L45:
        return r106;
    L44:
        return null;
    L20:
        if (r102 != null) goto L22;
    L24:
        boolean r107 = false;
    L25:
        if (r107 == false) goto L46;
        if (r102 == null) goto L32;
        JsonPrimitive r108 = r102.getAsJsonPrimitive();     // Catch: Exception -> L7
        if (r108 == null) goto L32;
        if (r108.isString() != true) goto L32;
    L33:
        if (r104 == false) goto L47;
        if (r102 == null) goto L48;
        JsonPrimitive r109 = r102.getAsJsonPrimitive();     // Catch: Exception -> L7
        if (r109 == null) goto L49;
        String r110 = r109.getAsString();     // Catch: Exception -> L7
        if (r110 == null) goto L50;
        r106 = f210019a.fromJson(r110, r103);     // Catch: Exception -> L7
        goto L45
    L50:
        return null;
    L49:
        return null;
    L48:
        return null;
    L47:
        return null;
    L32:
        r104 = false;
        goto L33
    L46:
        return null;
    L22:
        if (r102.isJsonPrimitive() != true) goto L24;
        r107 = true;
        goto L25
    L13:
        if (r102.isJsonObject() != true) goto L15;
        r105 = true;
        goto L16
    L43:
        JsonObject r111 = r101.getAsJsonObject();     // Catch: Exception -> L7
        if (r111 == null) goto L9;
        r102 = r111.get("extra");     // Catch: Exception -> L7
    L7:
        e = move-exception;
        tt5.a.e("CommonListExtendViewMan", "getExtendContentModel error: " + r100, e, false);
        return null;
    }

    public static void b(String r100, l r101, Class r102, m r103) {
        Intrinsics.checkNotNullParameter(r100, "extendKey");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r102, "clz");
        f210023e.put(r100, r101);
        f210024f.put(r100, r102);
        if (r103 == null) goto L6;
        f210025g.put(r100, r103);
        return;
    }
}
