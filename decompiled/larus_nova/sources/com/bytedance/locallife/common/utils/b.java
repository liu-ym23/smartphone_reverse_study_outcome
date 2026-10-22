package com.bytedance.locallife.common.utils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f257134a = 0;

    static {
    }

    public static JSONArray a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        JSONArray r101 = new JSONArray();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L34;
        Object r103 = r102.next();
        if ((r103 instanceof Float) == true) goto L7;
        if ((r103 instanceof Long) == true) goto L10;
        if ((r103 instanceof Integer) == true) goto L13;
        if ((r103 instanceof Double) == true) goto L16;
        if ((r103 instanceof String) == true) goto L19;
        if ((r103 instanceof Boolean) == true) goto L22;
        if ((r103 instanceof Map) == false) goto L29;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");     // Catch: Exception -> L27
        r101.put(b((Map) r103));     // Catch: Exception -> L27
        goto L4
    L29:
        if ((r103 instanceof List) == true) goto L30;
        if (r103 != null) goto L4;
        r101.put(JSONObject.NULL);
        goto L4
    L30:
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");     // Catch: Exception -> L27
        r101.put(a((List) r103));     // Catch: Exception -> L27
        goto L4
    L22:
        r101.put(((Boolean) r103).booleanValue());
        goto L4
    L19:
        r101.put(r103);
        goto L4
    L16:
        r101.put(((Number) r103).doubleValue());
        goto L4
    L13:
        r101.put(((Number) r103).intValue());
        goto L4
    L10:
        r101.put(((Number) r103).longValue());
        goto L4
    L7:
        r101.put(((Number) r103).floatValue());
        goto L4
    L34:
        return r101;
    }

    public static JSONObject b(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        JSONObject r101 = new JSONObject();
        Iterator r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L40;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = (String) r103.getKey();
        Object r105 = r103.getValue();
        if ((r105 instanceof Long) == true) goto L7;
        if ((r105 instanceof Float) == true) goto L10;
        if ((r105 instanceof Integer) == true) goto L13;
        if ((r105 instanceof Double) == true) goto L16;
        if ((r105 instanceof String) == true) goto L19;
        if ((r105 instanceof Boolean) == true) goto L22;
        if ((r105 instanceof JSONObject) == true) goto L25;
        if ((r105 instanceof JSONArray) == true) goto L28;
        if ((r105 instanceof Map) == false) goto L35;
        r101.put(r104, b((Map) r105));     // Catch: Exception -> L33
        goto L4
    L35:
        if ((r105 instanceof List) == true) goto L36;
        if (r105 != null) goto L4;
        r101.put(r104, JSONObject.NULL);
        goto L4
    L36:
        r101.put(r104, a((List) r105));     // Catch: Exception -> L33
        goto L4
    L28:
        r101.put(r104, r105);
        goto L4
    L25:
        r101.put(r104, r105);
        goto L4
    L22:
        r101.put(r104, ((Boolean) r105).booleanValue());
        goto L4
    L19:
        r101.put(r104, r105);
        goto L4
    L16:
        r101.put(r104, ((Number) r105).doubleValue());
        goto L4
    L13:
        r101.put(r104, ((Number) r105).intValue());
        goto L4
    L10:
        r101.put(r104, ((Number) r105).floatValue());
        goto L4
    L7:
        r101.put(r104, ((Number) r105).longValue());
        goto L4
    L40:
        return r101;
    }
}
