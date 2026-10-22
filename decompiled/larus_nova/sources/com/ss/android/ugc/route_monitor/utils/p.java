package com.ss.android.ugc.route_monitor.utils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class p {
    public static final Object a(Object r100) {
        if ((r100 instanceof Integer) == false) goto L6;
        return Long.valueOf(((Number) r100).intValue());
    L6:
        if ((r100 instanceof Float) == true) goto L8;
        return r100;
    L8:
        return Double.valueOf(((Number) r100).floatValue());
    }

    public static final JSONArray b(List<?> r100) {
        JSONArray r101 = new JSONArray();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L32;
        Object r103 = r102.next();
        if ((r103 instanceof Float) == true) goto L7;
        if ((r103 instanceof Long) == true) goto L10;
        if ((r103 instanceof Integer) == true) goto L13;
        if ((r103 instanceof Double) == true) goto L16;
        if ((r103 instanceof String) == true) goto L19;
        if ((r103 instanceof Boolean) == true) goto L22;
        if ((r103 instanceof Map) == true) goto L25;
        if ((r103 instanceof List) == false) goto L4;
        b((List) r103);
        goto L4
    L25:
        if (r103 == null) goto L28;
        r101.put(c((Map) r103));
        goto L4
    L28:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, *>");
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
    L32:
        return r101;
    }

    public static final JSONObject c(Map<String, ?> r100) {
        JSONObject r101 = new JSONObject();
        Iterator<Map.Entry<String, ?>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L29;
        Map.Entry<String, ?> r103 = r102.next();
        String r104 = r103.getKey();
        Object r105 = r103.getValue();
        if ((r105 instanceof Long) == true) goto L7;
        if ((r105 instanceof Float) == true) goto L10;
        if ((r105 instanceof Integer) == true) goto L13;
        if ((r105 instanceof Double) == true) goto L16;
        if ((r105 instanceof String) == true) goto L19;
        if ((r105 instanceof Boolean) == true) goto L22;
        if ((r105 instanceof Map) == true) goto L25;
        if ((r105 instanceof List) == false) goto L4;
        r101.put(r104, b((List) r105));
        goto L4
    L25:
        r101.put(r104, c((Map) r105));
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
    L29:
        return r101;
    }

    public static final JSONObject d(Map<String, ?> r100) {
        JSONObject r101 = new JSONObject();
        Iterator<Map.Entry<String, ?>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L23;
        Map.Entry<String, ?> r103 = r102.next();
        String r104 = r103.getKey();
        Object r105 = r103.getValue();
        if ((r105 instanceof Long) == true) goto L7;
        if ((r105 instanceof Float) == true) goto L10;
        if ((r105 instanceof Integer) == true) goto L13;
        if ((r105 instanceof Double) == true) goto L16;
        if ((r105 instanceof String) == true) goto L19;
        if ((r105 instanceof Boolean) == false) goto L4;
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
    L23:
        return r101;
    }
}
