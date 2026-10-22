package go7;

import android.os.Build;
import android.text.TextUtils;
import oo7.c;
import oo7.k;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f481934a;

    public static void a(JSONObject r100) {
        eo7.a r101 = eo7.a.b.f473353a;     // Catch: JSONException -> L17
        jn7.a r102 = r101.f473332f;     // Catch: JSONException -> L17
        String r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.getDeviceId();     // Catch: JSONException -> L17
    L7:
        if (TextUtils.isEmpty(r104) == true) goto L9;
        r100.put("ug_share_did", r104);     // Catch: JSONException -> L17
    L9:
        jn7.a r105 = r101.f473332f;     // Catch: JSONException -> L17
        if (r105 == null) goto L13;
        r103 = r105.getAppId();     // Catch: JSONException -> L17
    L13:
        if (TextUtils.isEmpty(r103) == true) goto L15;
        r100.put("ug_share_aid", r103);     // Catch: JSONException -> L17
    L15:
        r100.put("tag", "ug_sdk_share");     // Catch: JSONException -> L17
        r100.put("ug_share_v_code", String.valueOf(241059));     // Catch: JSONException -> L17
        r100.put("ug_share_v_name", "2.4.1-rc.59");     // Catch: JSONException -> L17
        r100.put("ug_share_os_api", String.valueOf(Build.VERSION.SDK_INT));     // Catch: JSONException -> L17
        r100.put("ug_share_platform", "android");     // Catch: JSONException -> L17
        r100.put("params_for_special", "performance");     // Catch: JSONException -> L17
        return;
    L5:
        r104 = null;
    L17:
        e = move-exception;
        k.b(e.toString());
    }

    public static void b(int r100, long r101) {
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L4
        a(r102);     // Catch: JSONException -> L4
        r102.put("total_duration", r101);     // Catch: JSONException -> L4
        r102.put("status", r100);     // Catch: JSONException -> L4
        c.a("ug_sdk_share_channel_clicked_failed", r102);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void f(int r100, long r101) {
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L4
        a(r102);     // Catch: JSONException -> L4
        r102.put("status", r100);     // Catch: JSONException -> L4
        r102.put("total_duration", r101);     // Catch: JSONException -> L4
        c.a("ug_sdk_share_init", r102);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void c(long r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L4
        r103.put("total_duration", r100);     // Catch: JSONException -> L4
        r103.put("status", 1);     // Catch: JSONException -> L4
        r103.put("failed_reason", r102);     // Catch: JSONException -> L4
        r103.put("panel_id", r101);     // Catch: JSONException -> L4
        a(r103);     // Catch: JSONException -> L4
        c.a("ug_sdk_share_panel_show_performance", r103);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void d(int r100, String r101, long r102) {
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L4
        a(r103);     // Catch: JSONException -> L4
        r103.put("status", r100);     // Catch: JSONException -> L4
        r103.put("url", r101);     // Catch: JSONException -> L4
        r103.put("total_duration", r102);     // Catch: JSONException -> L4
        c.a("ug_sdk_share_file_download", r103);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void e(int r100, String r101, long r102) {
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L4
        a(r103);     // Catch: JSONException -> L4
        r103.put("url", r101);     // Catch: JSONException -> L4
        r103.put("status", r100);     // Catch: JSONException -> L4
        r103.put("total_duration", r102);     // Catch: JSONException -> L4
        c.a("ug_sdk_share_image_download", r103);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void g(int r100, String r101, long r102) {
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L4
        a(r103);     // Catch: JSONException -> L4
        r103.put("url", r101);     // Catch: JSONException -> L4
        r103.put("status", r100);     // Catch: JSONException -> L4
        r103.put("total_duration", r102);     // Catch: JSONException -> L4
        c.a("ug_sdk_share_video_download", r103);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
