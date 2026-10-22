package com.bytedance.ug.sdk.luckycat.impl.model;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.bytedance.ug.sdk.luckycat.impl.manager.y;
import com.bytedance.ug.sdk.luckycat.impl.utils.n;
import com.bytedance.ug.sdk.luckycat.utils.i;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class d {
    public static void b(boolean r100, String r101) {
        String r102 = i.d(r101);     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r102) == false) goto L5;
        return;
    L5:
        String r103 = UriProtector.parse(r102).getPath();     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r103) == false) goto L8;
        return;
    L8:
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L13
        String r105 = "luckycat";
        if (r100 == false) goto L11;
        r105 = "ug";
    L11:
        r104.put("container_name", r105);     // Catch: Throwable -> L13
        r104.put("path", r103);     // Catch: Throwable -> L13
        r104.put("params_for_special", "luckydog_sdk");     // Catch: Throwable -> L13
        a("luckydog_load_lynx_container", r104, true);     // Catch: Throwable -> L13
        return;
    }

    public static void d(int r100, JSONObject r101) {
        if (r101 == null) goto L10;
    L4:
        r101.put("luckycat_sdk_is_succ", "fail");     // Catch: JSONException -> L6
        r101.put("luckycat_sdk_error_code", r100);     // Catch: JSONException -> L6
    L8:
        a("ug_sdk_luckycat_exciting_video_ad_result", r101, true);
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    L10:
        r101 = new JSONObject();     // Catch: JSONException -> L6
        goto L4
    }

    public static void e(int r100, String r101) {
        JSONObject r102 = new JSONObject();
    L9:
        e = move-exception;
        e.printStackTrace();
    L11:
        a("ug_sdk_luckycat_big_red_packet_request", r102, true);
        return;
    L4:
        if (m.a.f271349a.r() == false) goto L6;
        int r103 = 1;
    L7:
        r102.put("is_login", r103);     // Catch: JSONException -> L9
        r102.put("is_succ", "fail");     // Catch: JSONException -> L9
        r102.put("error_code", r100);     // Catch: JSONException -> L9
        r102.put("error_msg", r101);     // Catch: JSONException -> L9
        r102.put("from", "init");     // Catch: JSONException -> L9
        goto L11
    L6:
        r103 = 0;
        goto L7
    }

    public static void f(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put("from", r100);     // Catch: JSONException -> L5
        r102.put("error", r101);     // Catch: JSONException -> L5
        r102.put("red_packet_position", r100);     // Catch: JSONException -> L5
    L7:
        a("ug_sdk_luckycat_big_red_packet_show_error", r102, true);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void a(String r100, JSONObject r101, boolean r102) {
        zl7.h r103 = (zl7.h) hn7.d.b(zl7.h.class);
        if (r103 != null) goto L5;
    L6:
        com.bytedance.ug.sdk.luckycat.api.depend.f r104 = m.a.f271349a.f271338f;
        if (r104 == null) goto L51;
        if (r101 != null) goto L10;
        JSONObject r105 = new JSONObject();
    L11:
        if (r102 == true) goto L49;
    L13:
        zl7.i r106 = (zl7.i) hn7.d.b(zl7.i.class);     // Catch: JSONException -> L31
        if (r106 == null) goto L17;
        r105.put("static_settings_version", r106.v());     // Catch: JSONException -> L31
        r105.put("dynamic_settings_version", r106.Y());     // Catch: JSONException -> L31
        r105.put("poll_settings_version", r106.q());     // Catch: JSONException -> L31
    L17:
        if (com.bytedance.ug.sdk.luckycat.impl.manager.b.a().contains(r100) == true) goto L19;
    L33:
        cn7.d r107 = (cn7.d) r104;
        int r108 = rk7.b.f538321a;
        if (rk7.b.d(r100, r105) == true) goto L51;
        ik7.d r109 = r107.f24555a;
        if (r109 == null) goto L51;
        r109.onAppLogEvent(r100, r105);
        goto L51
    L19:
        String r110 = "1";
        if (n.a() == false) goto L22;
        Object r111 = "1";
    L23:
        r105.put("first_open_app", r111);     // Catch: JSONException -> L31
        Set<String> r112 = to7.a.f546943k;     // Catch: JSONException -> L31
        boolean r113 = true;
        if (to7.a.d.f546961a.f546947d == 1) goto L27;
        r113 = false;
    L27:
        if (r113 == false) goto L29;
        r110 = "0";
    L29:
        r105.put("startup_type", r110);     // Catch: JSONException -> L31
        r105.put("device_score", com.bytedance.ug.sdk.luckycat.impl.utils.f.a());     // Catch: JSONException -> L31
        r105.put("network_quality_info", TTNetInit.getEffectiveConnectionType());     // Catch: JSONException -> L31
        r105.put("lucky_session_id", y.a());     // Catch: JSONException -> L31
        r105.put("lucky_session_id_time", y.b());     // Catch: JSONException -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
        goto L33
    L22:
        r111 = "0";
        goto L23
    L49:
        r105.put("params_for_special", "luckydog_sdk");     // Catch: JSONException -> L31
        goto L13
    L10:
        r105 = r101;
    L51:
    L46:
        th = move-exception;
        th.getMessage();
        return;
    L40:
        if (m.a.f271349a.f271344l == false) goto L54;
        if (r100 == null) goto L55;
        r101.toString();     // Catch: Throwable -> L46
        return;
    L55:
        return;
    L54:
        return;
    L5:
        if (r103.K(r100) == true) goto L6;
    }

    public static void c(String r100, boolean r101, String r102) {
        if (TextUtils.isEmpty(r100) == false) goto L11;
        return;
    L11:
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L10
        r103.put("package_name", r100);     // Catch: Throwable -> L10
        r103.put("is_installed", r101);     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(r102) == false) goto L8;
        r102 = "unknown";
    L8:
        r103.put("reason", r102);     // Catch: Throwable -> L10
        a("ug_sdk_luckycat_app_install_status", r103, true);     // Catch: Throwable -> L10
        return;
    }
}
