package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class h2 {
    public static void b(String r100, String r101, Long r102) {
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r103, "params");
        r103.put("enter_method", r100);     // Catch: JSONException -> L7
        r103.put("leave_method", r101);     // Catch: JSONException -> L7
        if (r102 == null) goto L9;
        r103.put("duration", r102.toString());     // Catch: JSONException -> L7
    L9:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("leave_multi_task_manage");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L7:
        e = move-exception;
        FLogger.f375446a.e("multitask-MultiTaskManagementEventHelper", "error in multitask-MultiTaskManagementEventHelper mobLeaveMultiTaskManage " + e.getLocalizedMessage());
        goto L9
    }

    public static void a(String r100, String r101, String r102, String r103, String r104, int r105) {
        JSONObject r106 = null;
        if ((r105 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r105 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r105 & 32) == 0) goto L20;
        r106 = new JSONObject();
    L20:
        Intrinsics.checkNotNullParameter(r106, "params");
        if (r100 != null) goto L37;
    L25:
        if (r101 == null) goto L27;
        r106.put("current_page", r101);     // Catch: JSONException -> L23
    L27:
        if (r102 == null) goto L29;
        r106.put("chat_type", r102);     // Catch: JSONException -> L23
    L29:
        if (r103 == null) goto L31;
        r106.put("bot_id", r103);     // Catch: JSONException -> L23
    L31:
        if (r104 == null) goto L35;
        r106.put("bot_type", r104);     // Catch: JSONException -> L23
    L23:
        e = move-exception;
        FLogger.f375446a.e("multitask-MultiTaskManagementEventHelper", "error in multitask-MultiTaskManagementEventHelper mobClickMultiTaskManage " + e.getLocalizedMessage());
    L35:
        TrackParams r107 = new TrackParams().merge(r106);
        by7.a r108 = new by7.a("click_multi_task_manage");
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L37:
        r106.put("enter_method", r100);     // Catch: JSONException -> L23
        goto L25
    }

    public static void e(String r100, String r101, String r102, String r103, String r104, Integer r105) {
        JSONObject r106 = new JSONObject();
        Intrinsics.checkNotNullParameter(r106, "params");
        if (r100 != null) goto L21;
    L7:
        if (r101 == null) goto L9;
        r106.put("enter_method", r101);     // Catch: JSONException -> L5
    L9:
        if (r102 == null) goto L11;
        r106.put("node_type", r102);     // Catch: JSONException -> L5
    L11:
        if (r103 == null) goto L13;
        r106.put("node_title", r103);     // Catch: JSONException -> L5
    L13:
        if (r104 == null) goto L15;
        r106.put("reference_id", r104);     // Catch: JSONException -> L5
    L15:
        if (r105 == null) goto L19;
        r106.put("index", r105.toString());     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("multitask-MultiTaskManagementEventHelper", "error in multitask-MultiTaskManagementEventHelper mobUnpinService " + e.getLocalizedMessage());
    L19:
        TrackParams r107 = new TrackParams().merge(r106);
        by7.a r108 = new by7.a("unpin_service");
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L21:
        r106.put("current_page", r100);     // Catch: JSONException -> L5
        goto L7
    }

    public static void d(String r100, String r101, String r102, String r103, String r104, String r105, String r106, Integer r110) {
        JSONObject r107 = new JSONObject();
        Intrinsics.checkNotNullParameter(r107, "params");
        r107.put("current_page", "multi_task_manage");     // Catch: JSONException -> L16
        if (r100 == null) goto L6;
        r107.put("task_id", r100);     // Catch: JSONException -> L16
    L6:
        if (r101 == null) goto L8;
        r107.put(DbJsonConstants.DBJSON_KEY_TASK_KEY, r101);     // Catch: JSONException -> L16
    L8:
        if (r102 == null) goto L10;
        r107.put("source_id", r102);     // Catch: JSONException -> L16
    L10:
        if (r103 == null) goto L12;
        r107.put("source_type", r103);     // Catch: JSONException -> L16
    L12:
        r107.put("task_title", r104);     // Catch: JSONException -> L16
        r107.put(AiProactiveTaskViewModel.PARAM_TASK_TYPE, r105);     // Catch: JSONException -> L16
        r107.put("reference_id", r106);     // Catch: JSONException -> L16
        if (r110 == null) goto L18;
        r107.put("index", r110.toString());     // Catch: JSONException -> L16
    L18:
        TrackParams r108 = new TrackParams().merge(r107);
        by7.a r109 = new by7.a("task_remove_confirm_show");
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L16:
        e = move-exception;
        FLogger.f375446a.e("multitask-MultiTaskManagementEventHelper", "error in multitask-MultiTaskManagementEventHelper mobTaskRemoveConfirmShow " + e.getLocalizedMessage());
        goto L18
    }

    public static void c(String r100, String r101, String r102, String r103, String r104, String r105, String r106, Integer r110, String r111) {
        JSONObject r107 = new JSONObject();
        Intrinsics.checkNotNullParameter(r107, "params");
        r107.put("current_page", "multi_task_manage");     // Catch: JSONException -> L17
        if (r100 == null) goto L6;
        r107.put("task_id", r100);     // Catch: JSONException -> L17
    L6:
        if (r101 == null) goto L8;
        r107.put(DbJsonConstants.DBJSON_KEY_TASK_KEY, r101);     // Catch: JSONException -> L17
    L8:
        if (r102 == null) goto L10;
        r107.put("source_id", r102);     // Catch: JSONException -> L17
    L10:
        if (r103 == null) goto L12;
        r107.put("source_type", r103);     // Catch: JSONException -> L17
    L12:
        r107.put("task_title", r104);     // Catch: JSONException -> L17
        r107.put(AiProactiveTaskViewModel.PARAM_TASK_TYPE, r105);     // Catch: JSONException -> L17
        r107.put("reference_id", r106);     // Catch: JSONException -> L17
        if (r110 == null) goto L15;
        r107.put("index", r110.toString());     // Catch: JSONException -> L17
    L15:
        r107.put("click_from", r111);     // Catch: JSONException -> L17
    L19:
        TrackParams r108 = new TrackParams().merge(r107);
        by7.a r109 = new by7.a("task_remove_confirm_click");
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L17:
        e = move-exception;
        FLogger.f375446a.e("multitask-MultiTaskManagementEventHelper", "error in multitask-MultiTaskManagementEventHelper mobTaskRemoveConfirmClick " + e.getLocalizedMessage());
        goto L19
    }
}
