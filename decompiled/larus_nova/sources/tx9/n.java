package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class n {
    public static void h(String r100) {
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter(r101, "params");
        r101.put("edit_way", "new_guidance_to_edit_notification");     // Catch: JSONException -> L5
        r101.put("click_from", r100);     // Catch: JSONException -> L5
    L7:
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("create_bot_guidance_click");
        r103.f21463a.merge(r102);
        r103.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("BotCreateEventHelper", "error in BotCreateEventHelper create_bot_guidance_click " + e.getLocalizedMessage());
        goto L7
    }

    public static void b(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "params");
        if (r100 != null) goto L13;
    L7:
        if (r101 == null) goto L11;
        r102.put("create_way", r101);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("BotCreateEventHelper", "error in BotCreateEventHelper bot_image_ai_choose_page_download_board_show " + e.getLocalizedMessage());
    L11:
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("bot_image_ai_choose_page_download_board_show");
        r104.f21463a.merge(r103);
        r104.b();
        return;
    L13:
        r102.put("creation_id", r100);     // Catch: JSONException -> L5
        goto L7
    }

    public static void a(String r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r103, "params");
        if (r100 != null) goto L14;
    L7:
        r103.put("click_from", r101);     // Catch: JSONException -> L5
        if (r102 == null) goto L12;
        r103.put("create_way", r102);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("BotCreateEventHelper", "error in BotCreateEventHelper bot_image_ai_choose_page_download_board_click " + e.getLocalizedMessage());
    L12:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("bot_image_ai_choose_page_download_board_click");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L14:
        r103.put("creation_id", r100);     // Catch: JSONException -> L5
        goto L7
    }

    public static void d(String r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r103, "params");
        if (r100 != null) goto L15;
    L7:
        if (r101 == null) goto L9;
        r103.put("create_way", r101);     // Catch: JSONException -> L5
    L9:
        if (r102 == null) goto L13;
        r103.put("enter_method", r102);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("BotCreateEventHelper", "error in BotCreateEventHelper bot_image_upload_adjust_page_enter " + e.getLocalizedMessage());
    L13:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("bot_image_upload_adjust_page_enter");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L15:
        r103.put("creation_id", r100);     // Catch: JSONException -> L5
        goto L7
    }

    public static void f(String r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r103, "params");
        if (r100 != null) goto L14;
    L7:
        r103.put("click_from", r101);     // Catch: JSONException -> L5
        if (r102 == null) goto L12;
        r103.put("create_way", r102);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("BotCreateEventHelper", "error in BotCreateEventHelper create_bot_add_image_method_sheet_click " + e.getLocalizedMessage());
    L12:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("create_bot_add_image_method_sheet_click");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L14:
        r103.put("creation_id", r100);     // Catch: JSONException -> L5
        goto L7
    }

    public static void c(String r100, String r101, String r102, TraceFragment r103) {
        JSONObject r104 = new JSONObject();
        Intrinsics.checkNotNullParameter(r104, "params");
        if (r100 != null) goto L18;
    L7:
        if (r101 == null) goto L9;
        r104.put("create_way", r101);     // Catch: JSONException -> L5
    L9:
        if (r102 == null) goto L13;
        r104.put("enter_method", r102);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("BotCreateEventHelper", "error in BotCreateEventHelper bot_image_upload_adjust_page_confirm " + e.getLocalizedMessage());
    L13:
        TrackParams r105 = new TrackParams().merge(r104);
        by7.a r106 = new by7.a("bot_image_upload_adjust_page_confirm");
        if (r103 == null) goto L16;
        r106.f21464b = r103;
    L16:
        r106.f21463a.merge(r105);
        r106.b();
        return;
    L18:
        r104.put("creation_id", r100);     // Catch: JSONException -> L5
        goto L7
    }

    public static void e(String r100, String r101, String r102, TraceFragment r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        JSONObject r105 = new JSONObject();
    L16:
        if ((r104 & 16) == 0) goto L18;
        r103 = null;
    L18:
        Intrinsics.checkNotNullParameter(r105, "params");
        if (r100 != null) goto L34;
    L23:
        if (r101 == null) goto L25;
        r105.put("click_from", r101);     // Catch: JSONException -> L21
    L25:
        if (r102 == null) goto L29;
        r105.put("create_way", r102);     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        FLogger.f375446a.e("BotCreateEventHelper", "error in BotCreateEventHelper create_bot_add_bot_image_entrance_click " + e.getLocalizedMessage());
    L29:
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a("create_bot_add_bot_image_entrance_click");
        if (r103 == null) goto L32;
        r107.f21464b = r103;
    L32:
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L34:
        r105.put("creation_id", r100);     // Catch: JSONException -> L21
        goto L23
    L14:
        r105 = null;
        goto L16
    }

    public static void g(String r100, String r101, String r102, TraceFragment r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        JSONObject r105 = new JSONObject();
    L16:
        if ((r104 & 16) == 0) goto L18;
        r103 = null;
    L18:
        Intrinsics.checkNotNullParameter(r105, "params");
        if (r100 != null) goto L34;
    L23:
        if (r101 == null) goto L25;
        r105.put("click_from", r101);     // Catch: JSONException -> L21
    L25:
        if (r102 == null) goto L29;
        r105.put("create_way", r102);     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        FLogger.f375446a.e("BotCreateEventHelper", "error in BotCreateEventHelper create_bot_add_image_method_sheet_show " + e.getLocalizedMessage());
    L29:
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a("create_bot_add_image_method_sheet_show");
        if (r103 == null) goto L32;
        r107.f21464b = r103;
    L32:
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L34:
        r105.put("creation_id", r100);     // Catch: JSONException -> L21
        goto L23
    L14:
        r105 = null;
        goto L16
    }
}
