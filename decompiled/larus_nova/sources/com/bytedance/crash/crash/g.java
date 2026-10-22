package com.bytedance.crash.crash;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class g {
    public static void a(String r100, String r101, JSONObject r102) {
        if (TextUtils.isEmpty(r100) == true) goto L8;
        return;
    L8:
        r102.put("err_empty_".concat(r101), 1);     // Catch: JSONException -> L7
        return;
    }

    public static void b(Object r100, String r101, JSONObject r102) {
        if (r100 == null) goto L7;
        return;
    L7:
        r102.put("err_null_".concat(r101), 1);     // Catch: JSONException -> L6
        return;
    }
}
