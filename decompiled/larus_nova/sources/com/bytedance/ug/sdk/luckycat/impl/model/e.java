package com.bytedance.ug.sdk.luckycat.impl.model;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static void a(JSONObject r100) {
        m r101 = m.a.f271349a;     // Catch: JSONException -> L10
        String r102 = r101.i();     // Catch: JSONException -> L10
        if (TextUtils.isEmpty(r102) == true) goto L5;
        r100.put("ug_did", r102);     // Catch: JSONException -> L10
    L5:
        int r103 = r101.g();     // Catch: JSONException -> L10
        if (TextUtils.isEmpty(String.valueOf(r103)) == true) goto L8;
        r100.put("ug_aid", String.valueOf(r103));     // Catch: JSONException -> L10
    L8:
        r100.put("tag", "ug_sdk_luckycat");     // Catch: JSONException -> L10
        r100.put("ug_v_code", String.valueOf(890100));     // Catch: JSONException -> L10
        r100.put("ug_v_name", "8.75.0-rc.12-db");     // Catch: JSONException -> L10
        r100.put("ug_os_api", String.valueOf(Build.VERSION.SDK_INT));     // Catch: JSONException -> L10
        r100.put("ug_platform", "android");     // Catch: JSONException -> L10
        return;
    L10:
        e = move-exception;
        e.toString();
    }

    public static void b(int r100) {
        JSONObject r101 = new JSONObject();
        a(r101);
        f.b("ug_sdk_luckycat_big_red_packet_show", r100, null, r101, null, null);
    }

    public static void c(int r100) {
        JSONObject r101 = new JSONObject();
        a(r101);
        f.b("ug_sdk_luckycat_init", r100, null, r101, null, null);
        if (m.a.f271349a.f271344l == false) goto L6;
        f.b("sdk_monitor_inner_ug_sdk_luckycat_init", r100, null, r101, null, null);
        return;
    }
}
