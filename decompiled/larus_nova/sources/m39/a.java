package m39;

import com.ixigua.lib.track.TrackParams;
import com.larus.doc.api.IDocService;
import com.larus.utils.logger.FLogger;
import com.obric.sva.sdk.data.ISmModel;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import tx9.u0;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f511797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f511798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Integer f511799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f511800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f511801e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f511802f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f511803g;

    public a() {
    }

    static {
        f511800d = "";
    }

    public static /* synthetic */ void b(String r100, String r101, JSONObject r102) {
        a(r100, "", r101, r102);
    }

    public static /* synthetic */ void d(String r100, String r101, JSONObject r102) {
        c(r100, "", r101, r102);
    }

    public static void e(String r100, String r101, String r110) {
        if (Intrinsics.areEqual(f511797a, f511803g) == false) goto L5;
        return;
    L5:
        String r102 = f511801e;
        if (r102 != null) goto L8;
    L42:
        String r103 = null;
    L43:
        if (r103 == null) goto L69;
        String r104 = f511797a;
        f511803g = r104;
        String r105 = f511801e;
        Integer r106 = f511799c;
        String r107 = f511798b;
        Integer r108 = Integer.valueOf(IDocService.f330931a.K9());
        JSONObject r109 = new JSONObject();
        Intrinsics.checkNotNullParameter(r109, "params");
        if (r105 != null) goto L67;
    L47:
        r109.put("create_way", r103);     // Catch: JSONException -> L63
        if (r108 == null) goto L50;
        r109.put("is_deep_thinking_switch_on", r108.intValue());     // Catch: JSONException -> L63
    L50:
        if (r104 == null) goto L52;
        r109.put("page_token", r104);     // Catch: JSONException -> L63
    L52:
        if (r107 == null) goto L54;
        r109.put("artifact_meta_id", r107);     // Catch: JSONException -> L63
    L54:
        if (r106 == null) goto L56;
        r109.put("resource_type", r106.intValue());     // Catch: JSONException -> L63
    L56:
        if (r100 == null) goto L58;
        r109.put("previous_page", r100);     // Catch: JSONException -> L63
    L58:
        if (r101 == null) goto L60;
        r109.put("current_page", r101);     // Catch: JSONException -> L63
    L60:
        if (r110 == null) goto L65;
        r109.put("meeting_record_message_create_platform", r110);     // Catch: JSONException -> L63
    L63:
        e = move-exception;
        FLogger.f375446a.e("DocumentEventHelper", "error in DocumentEventHelper mobCreateAiDoc: " + e.getLocalizedMessage());
    L65:
        TrackParams r111 = new TrackParams().merge(r109);
        by7.a r112 = new by7.a("create_ai_doc");
        r112.f21463a.merge(r111);
        r112.b();
        return;
    L67:
        r109.put("click_from", r105);     // Catch: JSONException -> L63
        goto L47
    L69:
        return;
    L8:
        switch(r102.hashCode()) {
            case -2076524031: goto L39;
            case -1248423846: goto L36;
            case -793435082: goto L32;
            case -730520822: goto L29;
            case -476376399: goto L26;
            case 463237240: goto L23;
            case 759707860: goto L20;
            case 808416715: goto L17;
            case 991866259: goto L14;
            case 1673246730: goto L11;
            default: goto L42;
        };
    L11:
        if (r102.equals("click_answer_action_button_create") == false) goto L42;
    L30:
        r103 = "chat_response";
        goto L43
    L14:
        if (r102.equals("long_press_message_create") == true) goto L30;
    L17:
        if (r102.equals("send_message_create") == false) goto L42;
    L34:
        r103 = "send_message";
        goto L43
    L20:
        if (r102.equals("answer_manual_create") == true) goto L34;
    L23:
        if (r102.equals("ai_doc_card_download_button") == true) goto L34;
    L26:
        if (r102.equals("ai_doc_list_blank_file_create") == false) goto L42;
    L41:
        r103 = "blank_file";
        goto L43
    L29:
        if (r102.equals("long_press_meeting_record_create_button") == false) goto L42;
    L32:
        if (r102.equals("ai_doc_card_edit_button") == true) goto L34;
    L36:
        if (r102.equals("ai_space_create_blank_doc") == true) goto L41;
    L39:
        if (r102.equals("ai_doc_list_speak_input_create") == true) goto L41;
        goto L41
    }

    public static void a(String r110, String r111, String r112, JSONObject r113) {
        Intrinsics.checkNotNullParameter(r113, "extParams");
        u0.h(false, "ai_doc_detail", f511799c, "ai_doc", f511797a, f511798b, r110, r111, r112, r113, ISmModel.VERSION_0600);
    }

    public static void c(String r110, String r111, String r112, JSONObject r113) {
        Intrinsics.checkNotNullParameter(r113, "params");
        u0.h(true, "ai_doc_detail", f511799c, "ai_doc", f511797a, f511798b, r110, r111, r112, r113, ISmModel.VERSION_0600);
    }
}
