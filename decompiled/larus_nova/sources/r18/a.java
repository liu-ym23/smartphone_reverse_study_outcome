package r18;

import com.alibaba.fastjson.JSONArray;
import java.math.BigDecimal;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class a {
    public static JSONObject a(com.alibaba.fastjson.JSONObject r100) {
        if (r100 == null) goto L4;
        JSONObject r101 = new JSONObject();
        Iterator<String> r102 = r100.keySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L14;
        String r103 = r102.next();
        r101.put(r103, b(r100.get(r103)));     // Catch: Exception -> L11
    L11:
        e = move-exception;
        throw new RuntimeException("Error converting key: " + r103, e);
    L14:
        return r101;
    L4:
        return new JSONObject();
    }

    public static Object b(Object r100) {
        if (r100 != null) goto L6;
        return JSONObject.NULL;
    L6:
        if ((r100 instanceof com.alibaba.fastjson.JSONObject) == false) goto L10;
        return a((com.alibaba.fastjson.JSONObject) r100);
    L10:
        if ((r100 instanceof JSONArray) == false) goto L17;
        org.json.JSONArray r101 = new org.json.JSONArray();
        Iterator<Object> r102 = ((JSONArray) r100).iterator();
    L13:
        if (r102.hasNext() == false) goto L15;
        r101.put(b(r102.next()));
        goto L13
    L15:
        return r101;
    L17:
        if ((r100 instanceof BigDecimal) == false) goto L21;
        return r100.toString();
    L21:
        if ((r100 instanceof String) == false) goto L23;
        return r100;
    L23:
        if ((r100 instanceof Number) == false) goto L25;
        return r100;
    L25:
        if ((r100 instanceof Boolean) == false) goto L28;
        return r100;
    L28:
        return r100.toString();
    }
}
