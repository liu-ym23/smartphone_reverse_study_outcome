package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class r3 {
    public static void b(String r100, String r101, Integer r102, String r103, String r104, String r110, Integer r111) {
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r104, "presentationId");
        Intrinsics.checkNotNullParameter(r110, "resourceId");
        Intrinsics.checkNotNullParameter(r105, "params");
        r105.put("current_page", "aippt_permission_setting");     // Catch: JSONException -> L23
        Intrinsics.checkNotNullParameter("aippt_permission_setting", "<set-?>");     // Catch: JSONException -> L23
        a1.f547843a = "aippt_permission_setting";     // Catch: JSONException -> L23
        r105.put("previous_page", "aippt_new_detail");     // Catch: JSONException -> L23
        Intrinsics.checkNotNullParameter("aippt_new_detail", "<set-?>");     // Catch: JSONException -> L23
        a1.f547844b = "aippt_new_detail";     // Catch: JSONException -> L23
        if (r101 == null) goto L6;
        r105.put("artifact_meta_id", r101);     // Catch: JSONException -> L23
    L6:
        if (r102 == null) goto L9;
        r105.put("artifact_type", r102.toString());     // Catch: JSONException -> L23
    L9:
        if (com.larus.utils.o0.d(r103) == false) goto L12;
        r105.put("aippt_task_id", r103);     // Catch: JSONException -> L23
    L12:
        if (com.larus.utils.o0.d(r104) == false) goto L15;
        r105.put("presentation_id", r104);     // Catch: JSONException -> L23
    L15:
        if (com.larus.utils.o0.d(r110) == false) goto L17;
        r105.put("resource_id", r110);     // Catch: JSONException -> L23
    L17:
        if (r111 == null) goto L20;
        r105.put("resource_type", r111.toString());     // Catch: JSONException -> L23
    L20:
        if (com.larus.utils.o0.d(r100) == false) goto L25;
        r105.put("click_from", r100);     // Catch: JSONException -> L23
    L25:
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a("aippt_permission_setting_click");
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L23:
        e = move-exception;
        FLogger.f375446a.e("SlidesShareTraceHelper", "error in SlidesShareTraceHelper enterPage " + e.getLocalizedMessage());
        goto L25
    }

    public static void a(String r110, String r111, String r112, String r113, Integer r210, String r211, String r212, String r213, Integer r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, JSONObject r313) {
        Intrinsics.checkNotNullParameter(r212, "presentationId");
        Intrinsics.checkNotNullParameter(r213, "resourceId");
        Intrinsics.checkNotNullParameter(r215, "canvasType");
        Intrinsics.checkNotNullParameter(r216, "contentSecType");
        Intrinsics.checkNotNullParameter(r217, "userType");
        Intrinsics.checkNotNullParameter(r218, "messageId");
        Intrinsics.checkNotNullParameter(r219, "conversationId");
        Intrinsics.checkNotNullParameter(r310, "botId");
        Intrinsics.checkNotNullParameter(r311, "sectionId");
        Intrinsics.checkNotNullParameter(r313, "params");
        if (r110 != null) goto L54;
    L7:
        if (r111 == null) goto L9;
        r313.put("previous_page", r111);     // Catch: JSONException -> L5
        Intrinsics.checkNotNullParameter(r111, "<set-?>");     // Catch: JSONException -> L5
        a1.f547844b = r111;     // Catch: JSONException -> L5
    L9:
        if (r112 == null) goto L11;
        r313.put("artifact_meta_id", r112);     // Catch: JSONException -> L5
    L11:
        if (r113 == null) goto L13;
        r313.put("slides_cs_version_id", r113);     // Catch: JSONException -> L5
    L13:
        if (r210 == null) goto L16;
        r313.put("artifact_type", r210.toString());     // Catch: JSONException -> L5
    L16:
        if (com.larus.utils.o0.d(r211) == false) goto L19;
        r313.put("aippt_task_id", r211);     // Catch: JSONException -> L5
    L19:
        if (com.larus.utils.o0.d(r212) == false) goto L22;
        r313.put("presentation_id", r212);     // Catch: JSONException -> L5
    L22:
        if (com.larus.utils.o0.d(r213) == false) goto L24;
        r313.put("resource_id", r213);     // Catch: JSONException -> L5
    L24:
        if (r214 == null) goto L27;
        r313.put("resource_type", r214.toString());     // Catch: JSONException -> L5
    L27:
        if (com.larus.utils.o0.d(r215) == false) goto L30;
        r313.put("canvas_type", r215);     // Catch: JSONException -> L5
    L30:
        if (com.larus.utils.o0.d(r216) == false) goto L33;
        r313.put("content_sec_type", r216);     // Catch: JSONException -> L5
    L33:
        if (com.larus.utils.o0.d(r217) == false) goto L36;
        r313.put("user_type", r217);     // Catch: JSONException -> L5
    L36:
        if (com.larus.utils.o0.d(r218) == false) goto L39;
        r313.put(MusicAppletPage.KEY_MESSAGE_ID, r218);     // Catch: JSONException -> L5
    L39:
        if (com.larus.utils.o0.d(r219) == false) goto L42;
        r313.put("conversation_id", r219);     // Catch: JSONException -> L5
    L42:
        if (com.larus.utils.o0.d(r310) == false) goto L45;
        r313.put("bot_id", r310);     // Catch: JSONException -> L5
    L45:
        if (com.larus.utils.o0.d(r311) == false) goto L48;
        r313.put("section_id", r311);     // Catch: JSONException -> L5
    L48:
        if (com.larus.utils.o0.d(r312) == false) goto L52;
        r313.put("artifact_create_method", r312);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("SlidesShareTraceHelper", "error in SlidesShareTraceHelper enterPage " + e.getLocalizedMessage());
    L52:
        TrackParams r100 = new TrackParams().merge(r313);
        by7.a r101 = new by7.a("aippt_download");
        r101.f21463a.merge(r100);
        r101.b();
        return;
    L54:
        r313.put("current_page", r110);     // Catch: JSONException -> L5
        Intrinsics.checkNotNullParameter(r110, "<set-?>");     // Catch: JSONException -> L5
        a1.f547843a = r110;     // Catch: JSONException -> L5
        goto L7
    }
}
