package com.monitor.cloudmessage.utils;

import com.byted.cast.linkcommon.cybergarage.soap.SOAP;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class b {
    public static JSONObject a(Map<String, List<String>> r100) {
        JSONObject r101 = new JSONObject();
        if (r100 != null) goto L15;
    L14:
        return r101;
    L15:
        Iterator<Map.Entry<String, List<String>>> r102 = r100.entrySet().iterator();     // Catch: JSONException -> L12
    L5:
        if (r102.hasNext() == false) goto L14;
        Map.Entry<String, List<String>> r103 = r102.next();     // Catch: JSONException -> L12
        if (r103.getKey() == null) goto L9;
        r101.put(r103.getKey().toString(), r103.getValue());     // Catch: JSONException -> L12
        goto L5
    L9:
        r101.put(SOAP.RESPONSE, r103.getValue());     // Catch: JSONException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public static String b(HashMap<String, String> r100) {
        JSONObject r101 = new JSONObject();
        if (r100 == null) goto L12;
        Iterator<String> r102 = r100.keySet().iterator();     // Catch: JSONException -> L9
    L6:
        if (r102.hasNext() == false) goto L12;
        String r103 = r102.next();     // Catch: JSONException -> L9
        r101.put(r103, r100.get(r103));     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L12:
        return r101.toString();
    }
}
