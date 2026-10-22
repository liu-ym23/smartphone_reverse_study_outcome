package com.bytedance.common.push;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class BaseJson {
    public BaseJson() {
    }

    public void add(JSONObject r100, JSONObject r101) {
        if (r100 == null) goto L13;
        if (r101 == null) goto L20;
        Iterator<String> r102 = r101.keys();
    L7:
        if (r102.hasNext() == false) goto L21;
        String r103 = r102.next();
        r100.put(r103, r101.get(r103));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.printStackTrace();
        goto L7
    L21:
        return;
    L20:
        return;
    }

    public void add(JSONObject r100, String r101, float r102) {
        r100.put(r101, r102);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void add(JSONObject r100, String r101, double r102) {
        r100.put(r101, r102);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void add(JSONObject r100, String r101, long r102) {
        r100.put(r101, r102);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void add(JSONObject r100, String r101, String r102) {
        r100.put(r101, r102);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void add(JSONObject r100, String r101, JSONArray r102) {
        r100.put(r101, r102);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void add(JSONObject r100, String r101, JSONObject r102) {
        r100.put(r101, r102);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void add(JSONObject r100, String r101, boolean r102) {
        r100.put(r101, r102);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
