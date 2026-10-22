package com.bytedance.ug.sdk.luckycat.utils;

import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.bytedance.ug.sdk.luckycat.impl.utils.s;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a {
    public static void a(String r100, String r101) {
        if (m.a.f271349a.f271344l == true) goto L6;
        return;
    L6:
        if (r100.contains("?") == false) goto L24;
        r100 = r100.substring(0, r100.indexOf("?"));
    L24:
        JSONObject r102 = new JSONObject(r101);     // Catch: JSONException -> L21
        if (s.a(r102) == true) goto L12;
        cj7.a.a("net_get", r102.optInt("err_no"), "url: " + r100 + " err_tips: " + r102.optString("err_tips"));     // Catch: JSONException -> L21
    L12:
        if (r102.optJSONObject("data") != null) goto L14;
        cj7.a.a("net_get", 100001, "url: " + r100 + " >>> data empty");     // Catch: JSONException -> L21
        return;
    L14:
        if (cj7.a.f23985b == false) goto L25;
        ro7.a r103 = so7.a.b();     // Catch: JSONException -> L21
        if (r103 == null) goto L26;
        r103.b();     // Catch: JSONException -> L21
        return;
    L26:
        return;
    L25:
        return;
    L21:
        e = move-exception;
        e.printStackTrace();
        cj7.a.a("net_get", 100002, "url: " + r100 + " >>> data empty");
    }
}
