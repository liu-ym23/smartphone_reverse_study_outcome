package com.bytedance.salamander.bridge.common;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final JavaOnlyArray a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "sourceArray");
        JavaOnlyArray r101 = new JavaOnlyArray();
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L32;
        Object r104 = ListProtector.get(r100, r103);
        if ((r104 instanceof Map) == false) goto L9;
        r101.pushMap(d((Map) r104));     // Catch: Exception -> L33
    L31:
        r103 = r103 + 1;
        goto L3
    L9:
        if ((r104 instanceof List) == false) goto L13;
        r101.pushArray(a((List) r104));     // Catch: Exception -> L33
        goto L31
    L13:
        if ((r104 instanceof Boolean) == false) goto L16;
        r101.pushBoolean(((Boolean) r104).booleanValue());
        goto L31
    L16:
        if ((r104 instanceof Integer) == false) goto L19;
        r101.pushInt(((Number) r104).intValue());
        goto L31
    L19:
        if ((r104 instanceof Long) == false) goto L22;
        r101.pushLong(((Number) r104).longValue());
        goto L31
    L22:
        if ((r104 instanceof Float) == false) goto L25;
        r101.pushDouble(((Number) r104).floatValue());
        goto L31
    L25:
        if ((r104 instanceof Double) == false) goto L28;
        r101.pushDouble(((Number) r104).doubleValue());
        goto L31
    L28:
        if ((r104 instanceof String) == false) goto L30;
        r101.pushString((String) r104);
        goto L31
    L30:
        r101.pushString(r104.toString());
        goto L31
    L32:
        return r101;
    }

    @JvmStatic
    public static final JavaOnlyArray b(JSONArray r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonArray");
        JavaOnlyArray r101 = new JavaOnlyArray();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L30;
        Object r104 = r100.get(r103);
        if ((r104 instanceof JSONObject) == false) goto L8;
        r101.pushMap(c((JSONObject) r104));
    L29:
        r103 = r103 + 1;
        goto L3
    L8:
        if ((r104 instanceof JSONArray) == false) goto L11;
        r101.pushArray(b((JSONArray) r104));
        goto L29
    L11:
        if ((r104 instanceof Boolean) == false) goto L14;
        r101.pushBoolean(((Boolean) r104).booleanValue());
        goto L29
    L14:
        if ((r104 instanceof Integer) == false) goto L17;
        r101.pushInt(((Number) r104).intValue());
        goto L29
    L17:
        if ((r104 instanceof Long) == false) goto L20;
        r101.pushLong(((Number) r104).longValue());
        goto L29
    L20:
        if ((r104 instanceof Float) == false) goto L23;
        r101.pushDouble(((Number) r104).floatValue());
        goto L29
    L23:
        if ((r104 instanceof Double) == false) goto L26;
        r101.pushDouble(((Number) r104).doubleValue());
        goto L29
    L26:
        if ((r104 instanceof String) == false) goto L28;
        r101.pushString((String) r104);
        goto L29
    L28:
        r101.pushString(r104.toString());
        goto L29
    L30:
        return r101;
    }

    @JvmStatic
    public static final JavaOnlyMap c(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        JavaOnlyMap r101 = new JavaOnlyMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L33;
        String r103 = r102.next();
        Object r104 = r100.get(r103);
        if ((r104 instanceof JSONObject) == true) goto L7;
        if (Intrinsics.areEqual(r104, JSONObject.NULL) == true) goto L10;
        if ((r104 instanceof JSONArray) == true) goto L13;
        if ((r104 instanceof Boolean) == true) goto L16;
        if ((r104 instanceof Integer) == true) goto L19;
        if ((r104 instanceof Long) == true) goto L22;
        if ((r104 instanceof Float) == true) goto L25;
        if ((r104 instanceof Double) == true) goto L28;
        if ((r104 instanceof String) == true) goto L31;
        r101.putString(r103, r104.toString());
        goto L4
    L31:
        r101.putString(r103, (String) r104);
        goto L4
    L28:
        r101.putDouble(r103, ((Number) r104).doubleValue());
        goto L4
    L25:
        r101.putDouble(r103, ((Number) r104).floatValue());
        goto L4
    L22:
        r101.putLong(r103, ((Number) r104).longValue());
        goto L4
    L19:
        r101.putInt(r103, ((Number) r104).intValue());
        goto L4
    L16:
        r101.putBoolean(r103, ((Boolean) r104).booleanValue());
        goto L4
    L13:
        r101.putArray(r103, b((JSONArray) r104));
        goto L4
    L10:
        r101.putMap(r103, null);
        goto L4
    L7:
        r101.putMap(r103, c((JSONObject) r104));
        goto L4
    L33:
        return r101;
    }

    @JvmStatic
    public static final JavaOnlyMap d(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        JavaOnlyMap r101 = new JavaOnlyMap();
        Iterator r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L44;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = (String) r103.getKey();
        Object r105 = r103.getValue();
        if ((r105 instanceof Map) == false) goto L11;
        r101.putMap(r104, d((Map) r105));     // Catch: Exception -> L9
        goto L4
    L11:
        if ((r105 instanceof List) == true) goto L12;
        if ((r105 instanceof Boolean) == true) goto L16;
        if ((r105 instanceof Integer) == true) goto L19;
        if ((r105 instanceof Long) == true) goto L22;
        if ((r105 instanceof Float) == true) goto L25;
        if ((r105 instanceof Double) == true) goto L28;
        if ((r105 instanceof String) == true) goto L31;
        if ((r105 instanceof JSONObject) == true) goto L34;
        if ((r105 instanceof JSONArray) == true) goto L37;
        if (r105 == null) goto L43;
        if (Intrinsics.areEqual(r105, JSONObject.NULL) == true) goto L43;
        r101.putString(r104, r105.toString());
    L43:
        r101.putNull(r104);
        goto L4
    L37:
        r101.putArray(r104, b((JSONArray) r105));
        goto L4
    L34:
        r101.putMap(r104, c((JSONObject) r105));
        goto L4
    L31:
        r101.putString(r104, (String) r105);
        goto L4
    L28:
        r101.putDouble(r104, ((Number) r105).doubleValue());
        goto L4
    L25:
        r101.putDouble(r104, ((Number) r105).floatValue());
        goto L4
    L22:
        r101.putLong(r104, ((Number) r105).longValue());
        goto L4
    L19:
        r101.putInt(r104, ((Number) r105).intValue());
        goto L4
    L16:
        r101.putBoolean(r104, ((Boolean) r105).booleanValue());
        goto L4
    L12:
        r101.putArray(r104, a((List) r105));     // Catch: Exception -> L9
        goto L4
    L44:
        return r101;
    }
}
