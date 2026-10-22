package com.bytedance.ies.xbridge.platform.web;

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
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f249528a = 0;

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
        JSONArray r101 = new JSONArray();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L38;
        Object r103 = r102.next();
        if ((r103 instanceof Float) == true) goto L7;
        if ((r103 instanceof Long) == true) goto L10;
        if ((r103 instanceof Integer) == true) goto L13;
        if ((r103 instanceof Double) == true) goto L16;
        if ((r103 instanceof String) == true) goto L19;
        if ((r103 instanceof Boolean) == true) goto L22;
        if ((r103 instanceof Map) == false) goto L29;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");     // Catch: Exception -> L27
        r101.put(d((Map) r103));     // Catch: Exception -> L27
        goto L4
    L29:
        if ((r103 instanceof List) == true) goto L30;
        if ((r103 instanceof JSONObject) == false) goto L35;
        boolean r104 = true;
    L36:
        if (r104 == false) goto L4;
        r101.put(r103);
        goto L4
    L35:
        r104 = r103 instanceof JSONArray;
        goto L36
    L30:
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");     // Catch: Exception -> L27
        r101.put(c((List) r103));     // Catch: Exception -> L27
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
    L38:
        return r101;
    }

    public static JSONObject d(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        JSONObject r101 = new JSONObject();
        Iterator r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L38;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = (String) r103.getKey();
        Object r105 = r103.getValue();
        if ((r105 instanceof Long) == true) goto L7;
        if ((r105 instanceof Float) == true) goto L10;
        if ((r105 instanceof Integer) == true) goto L13;
        if ((r105 instanceof Double) == true) goto L16;
        if ((r105 instanceof String) == true) goto L19;
        if ((r105 instanceof Boolean) == true) goto L22;
        if ((r105 instanceof Map) == false) goto L29;
        r101.put(r104, d((Map) r105));     // Catch: Exception -> L27
        goto L4
    L29:
        if ((r105 instanceof List) == true) goto L30;
        if ((r105 instanceof JSONObject) == false) goto L35;
        boolean r106 = true;
    L36:
        if (r106 == false) goto L4;
        r101.put(r104, r105);
        goto L4
    L35:
        r106 = r105 instanceof JSONArray;
        goto L36
    L30:
        r101.put(r104, c((List) r105));     // Catch: Exception -> L27
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
    L38:
        return r101;
    }
}
