package il7;

import android.text.Html;
import android.text.TextUtils;
import com.bytedance.ug.sdk.luckydog.api.window.LuckyDialogConstants$PopupStatus;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public static void e(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("aar_name", r100);     // Catch: JSONException -> L5
    L7:
        com.bytedance.ug.sdk.luckydog.api.log.b.a("luckydog_plugin_aar_loaded", r101);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void a(String r100, long r101) {
        JSONObject r102 = new JSONObject();
        r102.put("function_name", r100).put("duration_ms", r101);     // Catch: JSONException -> L5
        com.bytedance.ug.sdk.luckydog.api.log.b.a("luckydog_consume_time", r102);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public static void h(int r100, String r101, long r102, long r103) {
        JSONObject r104 = new JSONObject();
        r104.put("channel", r100).put("path", r101).put("old_version", (int) r102).put("new_version", (int) r103);     // Catch: JSONException -> L5
    L7:
        com.bytedance.ug.sdk.luckydog.api.log.b.a("luckydog_settings_probe_update", r104);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void f(String r100, String r101, String r102, String r103, String r104) {
        JSONObject r105 = new JSONObject();
        r105.put("status_type", r100);     // Catch: JSONException -> L5
        r105.put("msg", r101);     // Catch: JSONException -> L5
        r105.put("token", r102);     // Catch: JSONException -> L5
        r105.put(DbJsonConstants.DBJSON_KEY_TASK_KEY, r103);     // Catch: JSONException -> L5
        r105.put("task_tag", r104);     // Catch: JSONException -> L5
    L7:
        com.bytedance.ug.sdk.luckydog.api.log.b.a("ug_sdk_luckydog_timer_link", r105);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void g(long r100, String r101, String r110, String r111, int r112) {
        JSONObject r102 = new JSONObject();
        JSONObject r103 = r102.put("pop_id", r100);     // Catch: JSONException -> L13
        String r104 = "";
    L9:
        th = move-exception;
        th.printStackTrace();     // Catch: JSONException -> L13
    L11:
        r103.put("pop_name", r104).put("pop_key", r110).put("enter_from", r111).put(MonitorConstants.EXTRA_DOWNLOAD_IS_FORCE, r112);     // Catch: JSONException -> L13
    L15:
        com.bytedance.ug.sdk.luckydog.api.log.b.a("basic_pop_receive", r102);
        if (r112 != 1) goto L18;
        boolean r105 = true;
    L19:
        ll7.d.h(r100, r101, r110, r111, r105);
        ll7.d.j(r100, LuckyDialogConstants$PopupStatus.RECEIVE.getStatus());
        return;
    L18:
        r105 = false;
        goto L19
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L11;
        r104 = Html.fromHtml(r101).toString();     // Catch: Throwable -> L9
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public static void d(String r100, String r101, String r102, String r103, String r104, String r105) {
        JSONObject r106 = new JSONObject();
        r106.put("status_type", r100);     // Catch: JSONException -> L5
        r106.put("msg", r101);     // Catch: JSONException -> L5
        r106.put("token", r102);     // Catch: JSONException -> L5
        r106.put(DbJsonConstants.DBJSON_KEY_TASK_KEY, r103);     // Catch: JSONException -> L5
        r106.put("task_tag", r104);     // Catch: JSONException -> L5
        r106.put("activity_name", r105);     // Catch: JSONException -> L5
    L7:
        com.bytedance.ug.sdk.luckydog.api.log.b.a("luckydog_counter_monitor", r106);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void b(String r100, String r101, String r102, String r103, int r104, int r105, float r106, float r110, int r111) {
        JSONObject r107 = new JSONObject();
        r107.put("activity_name", r100);     // Catch: JSONException -> L5
        r107.put(DbJsonConstants.DBJSON_KEY_TASK_KEY, r101);     // Catch: JSONException -> L5
        r107.put("task_token", r102);     // Catch: JSONException -> L5
        r107.put(DbJsonConstants.DBJSON_KEY_TASK_KEY, r101);     // Catch: JSONException -> L5
        r107.put("component_type", r103);     // Catch: JSONException -> L5
        r107.put("total_cnt", r104);     // Catch: JSONException -> L5
        r107.put("current_cnt", r105);     // Catch: JSONException -> L5
        r107.put("target_duration", r106);     // Catch: JSONException -> L5
        r107.put("current_duration", r110);     // Catch: JSONException -> L5
        r107.put("jump_result", r111);     // Catch: JSONException -> L5
    L7:
        com.bytedance.ug.sdk.luckydog.api.log.b.a("task_counter_click", r107);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void c(String r100, String r101, String r102, String r103, int r104, int r105, float r106, float r110, String r111) {
        JSONObject r107 = new JSONObject();
        r107.put("activity_name", r100);     // Catch: JSONException -> L5
        r107.put(DbJsonConstants.DBJSON_KEY_TASK_KEY, r101);     // Catch: JSONException -> L5
        r107.put("task_token", r102);     // Catch: JSONException -> L5
        r107.put(DbJsonConstants.DBJSON_KEY_TASK_KEY, r101);     // Catch: JSONException -> L5
        r107.put("component_type", r103);     // Catch: JSONException -> L5
        r107.put("total_cnt", r104);     // Catch: JSONException -> L5
        r107.put("current_cnt", r105);     // Catch: JSONException -> L5
        r107.put("target_duration", r106);     // Catch: JSONException -> L5
        r107.put("current_duration", r110);     // Catch: JSONException -> L5
        r107.put("task_status", r111);     // Catch: JSONException -> L5
    L7:
        com.bytedance.ug.sdk.luckydog.api.log.b.a("task_counter_show", r107);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }
}
