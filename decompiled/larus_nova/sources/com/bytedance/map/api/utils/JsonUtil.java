package com.bytedance.map.api.utils;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public class JsonUtil {
    private JsonUtil() {
    }

    public static void safePutBoolean(JSONObject r100, String r101, boolean r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        r100.put(r101, r102);     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void safePutDouble(JSONObject r100, String r101, double r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        r100.put(r101, r102);     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void safePutFloat(JSONObject r100, String r101, float r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L12;
        return;
    L12:
        r100.put(r101, r102);     // Catch: JSONException -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
    }

    public static void safePutInt(JSONObject r100, String r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        r100.put(r101, r102);     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void safePutLong(JSONObject r100, String r101, long r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        r100.put(r101, r102);     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void safePutString(JSONObject r100, String r101, String r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        r100.put(r101, r102);     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
