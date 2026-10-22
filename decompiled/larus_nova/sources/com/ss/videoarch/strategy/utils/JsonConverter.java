package com.ss.videoarch.strategy.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class JsonConverter {
    public JsonConverter() {
    }

    public static Object convertJsonValue(Object r100) throws JSONException {
        if ((r100 instanceof JSONObject) == false) goto L7;
        return toMap((JSONObject) r100);
    L7:
        if ((r100 instanceof JSONArray) == false) goto L11;
        return toArrayList((JSONArray) r100);
    L11:
        if (r100 != JSONObject.NULL) goto L14;
        return null;
    L14:
        return r100;
    }

    public static ArrayList<Object> toArrayList(JSONArray r100) throws JSONException {
        ArrayList<Object> r101 = new ArrayList();
        int r102 = 0;
    L4:
        if (r102 >= r100.length()) goto L6;
        r101.add(convertJsonValue(r100.get(r102)));
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public static Map<String, Object> toMap(JSONObject r100) throws JSONException {
        HashMap r101 = new HashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = r102.next();
        r101.put(r103, convertJsonValue(r100.get(r103)));
        goto L4
    L6:
        return r101;
    }
}
