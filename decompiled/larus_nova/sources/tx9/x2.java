package tx9;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class x2 {
    public static void g(String r100, Long r101, Long r102, Long r103, by7.e r104) {
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r105, "params");
        if (r100 != null) goto L20;
    L7:
        if (r101 == null) goto L9;
        r105.put("if_name_changed", r101.longValue());     // Catch: JSONException -> L5
    L9:
        if (r102 == null) goto L11;
        r105.put("if_name_id_changed", r102.longValue());     // Catch: JSONException -> L5
    L11:
        if (r103 == null) goto L15;
        r105.put("if_photo_changed", r103.longValue());     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("ProfileEventHelper", "error in ProfileEventHelper profileSettingComplete " + e.getLocalizedMessage());
    L15:
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a("profile_setting_complete");
        if (r104 == null) goto L18;
        r107.f21464b = r104;
    L18:
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L20:
        r105.put("enter_from", r100);     // Catch: JSONException -> L5
        goto L7
    }

    public static final void b(String r100, String r101, String r102, int r103, int r104, String r105, String r110) {
        com.larus.platform.service.o r106 = com.larus.platform.service.o.f365780a;
        JSONObject r107 = new JSONObject();
        if (com.larus.utils.o0.d("creation_detail") == false) goto L6;
        r107.put("current_page", "creation_detail");
    L6:
        if (com.larus.utils.o0.d(r100) == false) goto L9;
        r107.put("previous_page", r100);
    L9:
        if (com.larus.utils.o0.d("creation_detail") == false) goto L11;
        r107.put("status", r101);
    L11:
        r107.put("is_creation", 1);
        if (com.larus.utils.o0.d(r102) == false) goto L14;
        r107.put("creation_public_status", r102);
    L14:
        r107.put("position", r103);
        r107.put("index", r104);
        if (com.larus.utils.o0.d(r105) == false) goto L17;
        r107.put("content_type", r105);
    L17:
        r107.put("creation_id", r110);
        Unit r108 = Unit.INSTANCE;
        r106.reportEvent("slide", r107);
    }

    public static /* synthetic */ void f(String r100, String r110, String r111, String r112, String r113, String r114, String r115, Long r116) {
        e(r100, r110, r111, r112, r113, r114, r115, null, r116);
    }

    public static final void e(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r110, Long r111) {
        com.larus.platform.service.o r107 = com.larus.platform.service.o.f365780a;
        JSONObject r108 = new JSONObject();
        r108.putOpt("enter_method", r100);
        r108.putOpt("recommend_from", r102);
        r108.putOpt("tab_type", r103);
        r108.putOpt(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r104);
        r108.putOpt("tab_id", r105);
        r108.putOpt("current_page", r106);
        r108.putOpt("template_page_type", r110);
        r108.putOpt("leave_method", r101);
        r108.putOpt("duration", r111);
        Unit r109 = Unit.INSTANCE;
        r107.reportEvent("leave_ai_generate_page", r108);
    }

    public static final void c(String r100, int r101, String r102, String r103, String r104, int r105, int r110, String r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, "slideStatus");
        Intrinsics.checkNotNullParameter(r104, "creationId");
        com.larus.platform.service.o r106 = com.larus.platform.service.o.f365780a;
        JSONObject r107 = new JSONObject();
        if (r113 != null) goto L5;
    L12:
        r113 = "click";
    L14:
        if (r101 == (-1)) goto L17;
        r113 = "slide";
    L17:
        r107.put("enter_method", r113);
        if (r101 == (-1)) goto L20;
        r107.put("slide_status", r100);
    L20:
        r107.put("enter_from", r102);
        r107.put("video_id", r103);
        r107.put("creation_id", r104);
        r107.put("position", r105);
        r107.put("index", r110);
        r107.put("current_page", "creation_detail");
        r107.put("previous_page", r112);
        r107.put("is_template", "1");
        r107.put("is_creation", "1");
        if (com.larus.utils.o0.d(r111) == false) goto L23;
        r107.put("creation_public_status", r111);
    L23:
        Unit r108 = Unit.INSTANCE;
        r106.reportEvent("enter_music_detail", r107);
        return;
    L5:
        if (r113.length() <= 0) goto L7;
        boolean r109 = true;
    L8:
        if (r109 == true) goto L11;
        r113 = null;
    L11:
        if (r113 != null) goto L14;
    L7:
        r109 = false;
        goto L8
    }

    public static final void d(String r100, int r101, String r102, String r103, int r104, int r105, String r110, String r111, boolean r112, boolean r113, String r114, String r115) {
        Intrinsics.checkNotNullParameter(r100, "slideStatus");
        Intrinsics.checkNotNullParameter(r103, "creationId");
        com.larus.platform.service.o r106 = com.larus.platform.service.o.f365780a;
        JSONObject r107 = new JSONObject();
        if (r114 != null) goto L5;
    L12:
        r114 = "click";
    L14:
        if (r101 == (-1)) goto L17;
        r114 = "slide";
    L17:
        r107.put("enter_method", r114);
        if (r101 == (-1)) goto L20;
        r107.put("slide_status", r100);
    L20:
        r107.put("enter_from", r102);
        r107.putOpt("conversation_id", r115);
        r107.put("creation_id", r103);
        r107.put("position", r104);
        r107.put("index", r105);
        r107.put("current_page", "creation_detail");
        r107.put("previous_page", r110);
        r107.put("is_template", "1");
        r107.put("is_creation", "1");
        r107.put("is_replica_gen", r112 ? 1 : 0);
        if (com.larus.utils.o0.d(r111) == false) goto L23;
        r107.put("creation_public_status", r111);
    L23:
        r107.putOpt("is_image_edit", Integer.valueOf(r113 ? 1 : 0));
        Unit r108 = Unit.INSTANCE;
        r106.reportEvent("enter_picture_detail", r107);
        return;
    L5:
        if (r114.length() <= 0) goto L7;
        boolean r109 = true;
    L8:
        if (r109 == true) goto L11;
        r114 = null;
    L11:
        if (r114 != null) goto L14;
    L7:
        r109 = false;
        goto L8
    }

    public static void a(String r210, String r211, String r212, String r213, String r214, Integer r215, Integer r216, String r217, String r310, String r311, String r312, String r313, String r314, String r315, Integer r316, String r317, String r318, String r319, String r410, Long r411, int r412) {
        if ((r412 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r412 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r412 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r412 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r412 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r412 & 32) == 0) goto L25;
        Integer r105 = null;
    L27:
        if ((r412 & 64) == 0) goto L29;
        Integer r106 = null;
    L31:
        if ((r412 & 128) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r412 & 256) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r412 & 512) == 0) goto L41;
        String r111 = null;
    L43:
        if ((r412 & 1024) == 0) goto L45;
        String r112 = null;
    L47:
        if ((r412 & 2048) == 0) goto L49;
        String r113 = null;
    L51:
        if ((r412 & 4096) == 0) goto L53;
        String r114 = null;
    L55:
        if ((r412 & 8192) == 0) goto L57;
        String r115 = null;
    L59:
        if ((r412 & 16384) == 0) goto L61;
        Integer r108 = null;
    L63:
        if ((r412 & 32768) == 0) goto L65;
        String r116 = null;
    L67:
        if ((r412 & 65536) == 0) goto L69;
        String r117 = null;
    L71:
        if ((r412 & 131072) == 0) goto L73;
        String r109 = null;
    L74:
        String r118 = r114;
        if ((r412 & 262144) == 0) goto L77;
        String r119 = null;
    L79:
        if ((r412 & 524288) == 0) goto L81;
        Long r120 = 0L;
    L82:
        String r218 = r107;
        com.larus.platform.service.o r121 = com.larus.platform.service.o.f365780a;
        JSONObject r122 = new JSONObject();
        r122.putOpt("bot_id", r113);
        r122.putOpt("ai_generate_tab_id", r110);
        r122.putOpt("ai_generate_tab_name", r112);
        r122.putOpt("ai_generate_tab_type", r111);
        r122.putOpt("leave_method", r109);
        r122.putOpt("duration", r120);
        r122.putOpt("enter_method", r119);
        r122.put("recommend_from", r100);
        r122.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r101);
        r122.put("template_type", r102);
        r122.put("template_source", r103);
        r122.put("current_page", r115);
        r122.put("creator_id", r104);
        r122.put("position", r105);
        r122.put("page_index", r106);
        r122.put("template_rec_req_id", r218);
        r122.put("previous_page", r118);
        r122.put("use_template_uv", r108);
        r122.put("chat_type", r116);
        r122.put("conversation_id", r117);
        Unit r123 = Unit.INSTANCE;
        r121.reportEvent("click_close_template_detail", r122);
        return;
    L81:
        r120 = r411;
        goto L82
    L77:
        r119 = r410;
        goto L79
    L73:
        r109 = r319;
        goto L74
    L69:
        r117 = r318;
        goto L71
    L65:
        r116 = r317;
        goto L67
    L61:
        r108 = r316;
        goto L63
    L57:
        r115 = r315;
        goto L59
    L53:
        r114 = r314;
        goto L55
    L49:
        r113 = r313;
        goto L51
    L45:
        r112 = r312;
        goto L47
    L41:
        r111 = r311;
        goto L43
    L37:
        r110 = r310;
        goto L39
    L33:
        r107 = r217;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
