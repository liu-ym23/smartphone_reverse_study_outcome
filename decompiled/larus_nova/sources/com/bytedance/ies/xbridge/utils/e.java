package com.bytedance.ies.xbridge.utils;

import com.bytedance.ies.xbridge.model.idl.IDLXDynamic;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f249556a = 0;

    static {
    }

    public static List a(JSONArray r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        ArrayList r101 = new ArrayList();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L27;
        Object r104 = r100.opt(r103);
        if ((r104 instanceof Long) == false) goto L8;
        r101.add(Long.valueOf(r100.optLong(r103)));
    L26:
        r103 = r103 + 1;
        goto L3
    L8:
        if ((r104 instanceof Double) == false) goto L11;
        r101.add(Double.valueOf(r100.optDouble(r103)));
        goto L26
    L11:
        if ((r104 instanceof Integer) == false) goto L14;
        r101.add(Integer.valueOf(JSONArrayProtectorUtils.getInt(r100, r103)));
        goto L26
    L14:
        if ((r104 instanceof String) == false) goto L17;
        r101.add(r100.optString(r103));
        goto L26
    L17:
        if ((r104 instanceof JSONObject) == false) goto L20;
        r101.add(b(r100.optJSONObject(r103)));
        goto L26
    L20:
        if ((r104 instanceof JSONArray) == false) goto L23;
        r101.add(a(r100.optJSONArray(r103)));
        goto L26
    L23:
        if ((r104 instanceof Boolean) == false) goto L25;
        r101.add(Boolean.valueOf(r100.optBoolean(r103)));
        goto L26
    L25:
        r101.add(null);
        goto L26
    L27:
        return r101;
    }

    public static Map b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L27;
        String r103 = r102.next();
        Object r104 = r100.opt(r103);
        if ((r104 instanceof Long) == true) goto L7;
        if ((r104 instanceof Double) == true) goto L10;
        if ((r104 instanceof Integer) == true) goto L13;
        if ((r104 instanceof String) == true) goto L16;
        if ((r104 instanceof JSONObject) == true) goto L19;
        if ((r104 instanceof JSONArray) == true) goto L22;
        if ((r104 instanceof Boolean) == true) goto L25;
        r101.put(r103, null);
        goto L4
    L25:
        r101.put(r103, Boolean.valueOf(r100.optBoolean(r103)));
        goto L4
    L22:
        r101.put(r103, a(r100.optJSONArray(r103)));
        goto L4
    L19:
        r101.put(r103, b(r100.optJSONObject(r103)));
        goto L4
    L16:
        r101.put(r103, r100.optString(r103));
        goto L4
    L13:
        r101.put(r103, Integer.valueOf(r100.optInt(r103)));
        goto L4
    L10:
        r101.put(r103, Double.valueOf(r100.optDouble(r103)));
        goto L4
    L7:
        r101.put(r103, Long.valueOf(r100.optLong(r103)));
        goto L4
    L27:
        return r101;
    }

    public static JSONArray c(List r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        JSONArray r101 = new JSONArray();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L41;
        Object r103 = r102.next();
        if ((r103 instanceof Float) == true) goto L8;
        if ((r103 instanceof Long) == true) goto L11;
        if ((r103 instanceof Integer) == true) goto L14;
        if ((r103 instanceof Double) == true) goto L17;
        if ((r103 instanceof String) == true) goto L20;
        if ((r103 instanceof Boolean) == true) goto L23;
        if ((r103 instanceof Map) == false) goto L30;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");     // Catch: Exception -> L28 Throwable -> L37
        r101.put(d((Map) r103));     // Catch: Exception -> L28 Throwable -> L37
        goto L4
    L30:
        if ((r103 instanceof List) == true) goto L31;
        if ((r103 instanceof IDLXDynamic) == false) goto L4;
        r101.put(h66.a.a((IDLXDynamic) r103));     // Catch: Throwable -> L37
        goto L4
    L31:
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");     // Catch: Exception -> L28 Throwable -> L37
        r101.put(c((List) r103));     // Catch: Exception -> L28 Throwable -> L37
        goto L4
    L23:
        r101.put(((Boolean) r103).booleanValue());     // Catch: Throwable -> L37
        goto L4
    L20:
        r101.put(r103);     // Catch: Throwable -> L37
        goto L4
    L17:
        r101.put(((Number) r103).doubleValue());     // Catch: Throwable -> L37
        goto L4
    L14:
        r101.put(((Number) r103).intValue());     // Catch: Throwable -> L37
        goto L4
    L11:
        r101.put(((Number) r103).longValue());     // Catch: Throwable -> L37
        goto L4
    L8:
        r101.put(((Number) r103).floatValue());     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        int r104 = i.f249562a;
        Intrinsics.checkNotNullParameter("listToJSON error:" + th.getMessage() + ",entry:" + r103, "msg");
        Map<Class<? extends c>, c> r105 = k.f249565a;
        Intrinsics.checkNotNullParameter(d.class, "service");
        d r106 = (d) ((c) ((LinkedHashMap) k.f249565a).get(d.class));
        if (r106 == null) goto L4;
        r106.a();
        goto L4
    L41:
        return r101;
    }

    public static JSONObject d(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        JSONObject r101 = new JSONObject();
        Iterator r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L41;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = (String) r103.getKey();     // Catch: Throwable -> L37
        Object r105 = r103.getValue();     // Catch: Throwable -> L37
        if ((r105 instanceof Long) == true) goto L8;
        if ((r105 instanceof Float) == true) goto L11;
        if ((r105 instanceof Integer) == true) goto L14;
        if ((r105 instanceof Double) == true) goto L17;
        if ((r105 instanceof String) == true) goto L20;
        if ((r105 instanceof Boolean) == true) goto L23;
        if ((r105 instanceof Map) == false) goto L30;
        r101.put(r104, d((Map) r105));     // Catch: Exception -> L28 Throwable -> L37
        goto L4
    L30:
        if ((r105 instanceof List) == true) goto L31;
        if ((r105 instanceof IDLXDynamic) == false) goto L4;
        r101.put(r104, h66.a.a((IDLXDynamic) r105));     // Catch: Throwable -> L37
        goto L4
    L31:
        r101.put(r104, c((List) r105));     // Catch: Exception -> L28 Throwable -> L37
        goto L4
    L23:
        r101.put(r104, ((Boolean) r105).booleanValue());     // Catch: Throwable -> L37
        goto L4
    L20:
        r101.put(r104, r105);     // Catch: Throwable -> L37
        goto L4
    L17:
        r101.put(r104, ((Number) r105).doubleValue());     // Catch: Throwable -> L37
        goto L4
    L14:
        r101.put(r104, ((Number) r105).intValue());     // Catch: Throwable -> L37
        goto L4
    L11:
        r101.put(r104, ((Number) r105).floatValue());     // Catch: Throwable -> L37
        goto L4
    L8:
        r101.put(r104, ((Number) r105).longValue());     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        int r106 = i.f249562a;
        Intrinsics.checkNotNullParameter("mapToJSON error:" + th.getMessage() + ",entry:" + r103, "msg");
        Map<Class<? extends c>, c> r107 = k.f249565a;
        Intrinsics.checkNotNullParameter(d.class, "service");
        d r108 = (d) ((c) ((LinkedHashMap) k.f249565a).get(d.class));
        if (r108 == null) goto L4;
        r108.a();
        goto L4
    L41:
        return r101;
    }
}
