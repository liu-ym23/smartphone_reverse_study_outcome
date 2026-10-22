package com.bytedance.ug.sdk.luckycat.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static JSONObject a(JSONObject r100) {
        if (r100 != null) goto L8;
        return null;
    L8:
        return new JSONObject(r100.toString());
    L7:
        return r100;
    }

    public static JSONObject b(JSONObject... r100) {
        JSONObject r101 = new JSONObject();
        int r102 = r100.length;     // Catch: JSONException -> L14
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L16;
        JSONObject r104 = r100[r103];     // Catch: JSONException -> L14
        if (r104 == null) goto L13;
        Iterator<String> r105 = r104.keys();     // Catch: JSONException -> L14
    L10:
        if (r105.hasNext() == false) goto L13;
        String r106 = r105.next();     // Catch: JSONException -> L14
        r101.put(r106, r104.get(r106));     // Catch: JSONException -> L14
    L13:
        r103 = r103 + 1;
    L16:
        return r101;
    L14:
        e = move-exception;
        e.getMessage();
        goto L16
    }

    public static List<Object> c(JSONArray r100) throws JSONException {
        ArrayList r101 = new ArrayList();
        int r102 = 0;
    L4:
        if (r102 >= r100.length()) goto L12;
        Object r103 = r100.get(r102);
        if ((r103 instanceof JSONArray) == false) goto L9;
        r103 = c((JSONArray) r103);
    L11:
        r101.add(r103);
        r102 = r102 + 1;
        goto L4
    L9:
        if ((r103 instanceof JSONObject) == false) goto L11;
        r103 = d((JSONObject) r103);
        goto L11
    L12:
        return r101;
    }

    public static Map<String, String> d(JSONObject r100) {
        HashMap r101 = new HashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L14;
        String r103 = r102.next();     // Catch: JSONException -> L13
        Object r104 = r100.get(r103);     // Catch: JSONException -> L13
        if ((r104 instanceof JSONArray) == false) goto L9;
        r104 = c((JSONArray) r104);     // Catch: JSONException -> L13
    L11:
        r101.put(r103, r104.toString());     // Catch: JSONException -> L13
        goto L4
    L9:
        if ((r104 instanceof JSONObject) == false) goto L11;
        r104 = d((JSONObject) r104);     // Catch: JSONException -> L13
        goto L11
    L14:
        return r101;
    }
}
