package tx9;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import com.obric.trace.ObricActionBarTrackType;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class u3 {
    public static void c(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "params");
        r102.putOpt("content_type", r100);     // Catch: JSONException -> L5
        r102.putOpt("content", r101);     // Catch: JSONException -> L5
    L7:
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("ai_creation_toast_show");
        r104.f21463a.merge(r103);
        r104.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("TemplateEventHelper", "error in TemplateEventHelper mobAICreationToastShow " + e.getLocalizedMessage());
        goto L7
    }

    public static void f(String r100, String r101, String r102, String r103) {
        JSONObject r104 = new JSONObject();
        Intrinsics.checkNotNullParameter(r104, "params");
        r104.putOpt("action_type", r100);     // Catch: JSONException -> L5
        r104.putOpt("template_sub_type", r101);     // Catch: JSONException -> L5
        r104.putOpt("template_type", r102);     // Catch: JSONException -> L5
        r104.putOpt("recommend_from", r103);     // Catch: JSONException -> L5
    L7:
        TrackParams r105 = new TrackParams().merge(r104);
        by7.a r106 = new by7.a("edit_image_reference");
        r106.f21463a.merge(r105);
        r106.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("TemplateEventHelper", "error in TemplateEventHelper mobEditImageReference " + e.getLocalizedMessage());
        goto L7
    }

    public static void o(String r100, Boolean r101, Integer r102, String r103, String r104, String r105, String r106, String r107, String r110) {
        JSONObject r108 = new JSONObject();
        Intrinsics.checkNotNullParameter(r108, "params");
        r108.putOpt("recommend_from", r100);     // Catch: JSONException -> L5
        r108.putOpt("is_image_reference_public", l3.f(r101));     // Catch: JSONException -> L5
        r108.putOpt("image_reference_cnt", r102);     // Catch: JSONException -> L5
        r108.putOpt("creator_id", r103);     // Catch: JSONException -> L5
        r108.putOpt(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r104);     // Catch: JSONException -> L5
        r108.putOpt("show_from", r105);     // Catch: JSONException -> L5
        r108.putOpt("template_sub_type", r106);     // Catch: JSONException -> L5
        r108.putOpt("template_type", r107);     // Catch: JSONException -> L5
        r108.putOpt("template_use_tag", r110);     // Catch: JSONException -> L5
    L7:
        TrackParams r109 = new TrackParams().merge(r108);
        by7.a r111 = new by7.a("use_template_menu_show");
        r111.f21463a.merge(r109);
        r111.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("TemplateEventHelper", "error in TemplateEventHelper use_template_menu_show " + e.getLocalizedMessage());
        goto L7
    }

    public static void m(String r100, Boolean r101, Integer r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111, JSONObject r112, int r113) {
        if ((r113 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r113 & 2) == 0) goto L9;
        r101 = Boolean.FALSE;
    L9:
        if ((r113 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r113 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r113 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r113 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r113 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r113 & 128) == 0) goto L27;
        r107 = null;
    L27:
        if ((r113 & 256) == 0) goto L30;
        r110 = null;
    L30:
        if ((r113 & 512) == 0) goto L33;
        r111 = null;
    L33:
        if ((r113 & 1024) == 0) goto L35;
        r112 = new JSONObject();
    L35:
        Intrinsics.checkNotNullParameter(r112, "params");
        r112.putOpt("recommend_from", r100);     // Catch: JSONException -> L38
        r112.putOpt("is_image_reference_public", l3.f(r101));     // Catch: JSONException -> L38
        r112.putOpt("image_reference_cnt", r102);     // Catch: JSONException -> L38
        r112.putOpt("creator_id", r103);     // Catch: JSONException -> L38
        r112.putOpt(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r104);     // Catch: JSONException -> L38
        r112.putOpt("show_from", r105);     // Catch: JSONException -> L38
        r112.putOpt("template_sub_type", r106);     // Catch: JSONException -> L38
        r112.putOpt("template_type", r107);     // Catch: JSONException -> L38
        r112.putOpt("template_use_tag", r110);     // Catch: JSONException -> L38
        r112.putOpt(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r111);     // Catch: JSONException -> L38
    L40:
        TrackParams r108 = new TrackParams().merge(r112);
        by7.a r109 = new by7.a("use_template_menu_click");
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L38:
        e = move-exception;
        FLogger.f375446a.e("TemplateEventHelper", "error in TemplateEventHelper use_template_menu_click " + e.getLocalizedMessage());
        goto L40
    }

    public static void n(String r100, Boolean r101, Integer r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111, JSONObject r112, int r113) {
        if ((r113 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r113 & 2) == 0) goto L9;
        r101 = Boolean.FALSE;
    L9:
        if ((r113 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r113 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r113 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r113 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r113 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r113 & 128) == 0) goto L27;
        r107 = null;
    L27:
        if ((r113 & 256) == 0) goto L30;
        r110 = null;
    L30:
        if ((r113 & 512) == 0) goto L33;
        r111 = null;
    L33:
        if ((r113 & 1024) == 0) goto L35;
        r112 = new JSONObject();
    L35:
        Intrinsics.checkNotNullParameter(r112, "params");
        r112.putOpt("recommend_from", r100);     // Catch: JSONException -> L38
        r112.putOpt("is_image_reference_public", l3.f(r101));     // Catch: JSONException -> L38
        r112.putOpt("image_reference_cnt", r102);     // Catch: JSONException -> L38
        r112.putOpt("creator_id", r103);     // Catch: JSONException -> L38
        r112.putOpt(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r104);     // Catch: JSONException -> L38
        r112.putOpt("show_from", r105);     // Catch: JSONException -> L38
        r112.putOpt("template_sub_type", r106);     // Catch: JSONException -> L38
        r112.putOpt("template_type", r107);     // Catch: JSONException -> L38
        r112.putOpt("template_use_tag", r110);     // Catch: JSONException -> L38
        r112.putOpt(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r111);     // Catch: JSONException -> L38
    L40:
        TrackParams r108 = new TrackParams().merge(r112);
        by7.a r109 = new by7.a("use_template_menu_element_show");
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L38:
        e = move-exception;
        FLogger.f375446a.e("TemplateEventHelper", "error in TemplateEventHelper use_template_menu_element_show " + e.getLocalizedMessage());
        goto L40
    }

    public static void d(String r100, String r101, String r102, String r103, Integer r104, Integer r105, String r106, String r107, String r110, String r111, String r112, String r113, String r114) {
        JSONObject r108 = new JSONObject();
        Intrinsics.checkNotNullParameter(r108, "params");
        r108.putOpt("bot_id", r114);     // Catch: JSONException -> L25
        r108.putOpt("ai_generate_tab_id", r111);     // Catch: JSONException -> L25
        r108.putOpt("ai_generate_tab_name", r113);     // Catch: JSONException -> L25
        r108.putOpt("ai_generate_tab_type", r112);     // Catch: JSONException -> L25
        if (r103 == null) goto L6;
        r108.put("creator_id", r103);     // Catch: JSONException -> L25
    L6:
        if (r105 == null) goto L8;
        r108.put("page_index", r105.intValue());     // Catch: JSONException -> L25
    L8:
        if (r104 == null) goto L10;
        r108.put("position", r104.intValue());     // Catch: JSONException -> L25
    L10:
        if (r107 == null) goto L12;
        r108.put("template_rec_req_id", r107);     // Catch: JSONException -> L25
    L12:
        if (r110 == null) goto L14;
        r108.put("recommend_from", r110);     // Catch: JSONException -> L25
    L14:
        r108.put("click_method", r106);     // Catch: JSONException -> L25
        if (r100 == null) goto L17;
        r108.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r100);     // Catch: JSONException -> L25
    L17:
        r108.put("template_type", r101);     // Catch: JSONException -> L25
        if (r102.length() != 0) goto L20;
        boolean r109 = true;
    L21:
        if (r109 == false) goto L23;
        r102 = "default";
    L23:
        r108.put("template_source", r102);     // Catch: JSONException -> L25
    L27:
        TrackParams r115 = new TrackParams().merge(r108);
        by7.a r116 = new by7.a("click_template_download");
        r116.f21463a.merge(r115);
        r116.b();
        return;
    L20:
        r109 = false;
    L25:
        e = move-exception;
        FLogger.f375446a.e("TemplateEventHelper", "error in TemplateEventHelper use template " + e.getLocalizedMessage());
        goto L27
    }

    public static void i(String r110, String r111, String r112, Integer r113, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218) {
        JSONObject r114 = new JSONObject();
        Intrinsics.checkNotNullParameter(r114, "params");
        b("session_click", r110, r111, r112, r113, r210, r211, r218, r212, r213, r214, r215, r216, r217, r114, null);
    }

    public static void j(String r110, String r111, String r112, Integer r113, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218) {
        JSONObject r114 = new JSONObject();
        Intrinsics.checkNotNullParameter(r114, "params");
        b("session_slide", r110, r111, r112, r113, r210, r211, r218, r212, r213, r214, r215, r216, r217, r114, null);
    }

    public static void h(String r110, String r111, String r112, Integer r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, Long r219, String r310) {
        JSONObject r113 = new JSONObject();
        Intrinsics.checkNotNullParameter(r113, "params");
        a("feed_staytime", r110, r111, r112, r210, r211, r212, r310, r213, r214, r215, r216, r217, r218, r219, r113, null);
    }

    public static /* synthetic */ void b(String r110, String r111, String r112, String r210, Integer r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, JSONObject r311, by7.e r312) {
        a(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, null, r311, r312);
    }

    public static final void a(String r110, String r111, String r112, String r113, Integer r114, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, Long r219, JSONObject r310, by7.e r311) {
        List r100 = CollectionsKt.mutableListOf(new Pair[]{TuplesKt.to("bot_id", r111), TuplesKt.to("current_page", r112), TuplesKt.to("enter_method", r113), TuplesKt.to("page_index", r114), TuplesKt.to("previous_page", r210), TuplesKt.to("recommend_from", r211), TuplesKt.to("click_from", r212)});
        List r101 = r100;
        CollectionsKt.addAll(r101, CollectionsKt.listOf(new Pair[]{TuplesKt.to(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r213), TuplesKt.to("template_rec_extra", r214), TuplesKt.to("template_rec_req_id", r215), TuplesKt.to("template_source", r216), TuplesKt.to("template_sub_type", r217), TuplesKt.to("template_type", r218)}));
        if (Intrinsics.areEqual(r110, "feed_staytime") == false) goto L6;
        r101.add(TuplesKt.to("duration", r219));
    L6:
        if (Intrinsics.areEqual(r110, "feed_staytime") == false) goto L33;
        if (r219 == null) goto L33;
        if (r219.longValue() > 500) goto L33;
        FLogger.f375446a.d("TemplateEventHelper", "skip " + r110 + ", duration must be greater than 500ms");
        return;
    L33:
        Iterator r102 = r100.iterator();     // Catch: JSONException -> L30
    L13:
        if (r102.hasNext() == false) goto L25;
        Pair r103 = (Pair) r102.next();     // Catch: JSONException -> L30
        String r104 = (String) r103.component1();     // Catch: JSONException -> L30
        Object r105 = r103.component2();     // Catch: JSONException -> L30
        if (r105 == null) goto L23;
        if ((r105 instanceof String) == false) goto L22;
        if (StringsKt.isBlank((CharSequence) r105) == true) goto L23;
    L22:
        r310.put(r104, r105);     // Catch: JSONException -> L30
    L23:
        r310.remove(r104);     // Catch: JSONException -> L30
        goto L13
    L25:
        by7.a r106 = new by7.a(r110);
        if (r311 == null) goto L28;
        r106.f21464b = r311;
    L28:
        r106.f21463a.merge(new TrackParams().merge(r310));
        r106.b();
        return;
    L30:
        e = move-exception;
        FLogger.f375446a.e("TemplateEventHelper", "error in TemplateEventHelper " + r110 + ' ' + e.getLocalizedMessage());
    }

    public static void e(String r210, String r211, String r212, String r213, Long r214, Integer r215, Integer r216, String r217, String r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, String r318, String r319, String r410, String r411, Integer r412, String r413, String r414, int r415) {
        if ((r415 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r415 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r415 & 4) == 0) goto L13;
        String r102 = "default";
    L15:
        if ((r415 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r415 & 16) == 0) goto L21;
        Long r104 = null;
    L23:
        if ((r415 & 32) == 0) goto L25;
        Integer r105 = null;
    L27:
        if ((r415 & 64) == 0) goto L29;
        Integer r106 = null;
    L31:
        if ((r415 & 128) == 0) goto L33;
        String r110 = null;
    L35:
        if ((r415 & 256) == 0) goto L37;
        String r111 = null;
    L39:
        if ((r415 & 512) == 0) goto L41;
        String r112 = null;
    L43:
        if ((r415 & 1024) == 0) goto L45;
        String r113 = null;
    L47:
        if ((r415 & 2048) == 0) goto L49;
        String r114 = null;
    L51:
        if ((r415 & 4096) == 0) goto L53;
        String r115 = null;
    L55:
        if ((r415 & 8192) == 0) goto L57;
        String r107 = null;
    L59:
        if ((r415 & 16384) == 0) goto L61;
        String r108 = null;
    L62:
        String r218 = r102;
        if ((r415 & 32768) == 0) goto L65;
        String r109 = null;
    L67:
        if ((r415 & 65536) == 0) goto L69;
        String r116 = null;
    L71:
        if ((r415 & 131072) == 0) goto L73;
        String r117 = null;
    L75:
        if ((r415 & 262144) == 0) goto L77;
        String r219 = null;
    L79:
        if ((r415 & 524288) == 0) goto L81;
        String r220 = null;
    L82:
        String r221 = r117;
        if ((r415 & 1048576) == 0) goto L85;
        Integer r118 = null;
    L87:
        if ((r415 & 2097152) == 0) goto L89;
        JSONObject r119 = new JSONObject();
    L90:
        String r222 = r109;
        if ((r415 & 8388608) == 0) goto L93;
        String r120 = null;
    L95:
        if ((r415 & 16777216) == 0) goto L97;
        String r121 = null;
    L98:
        Intrinsics.checkNotNullParameter(r119, "params");
        r119.put("template_sub_type", r121);     // Catch: JSONException -> L144
        r119.putOpt("enter_method", r120);     // Catch: JSONException -> L144
        r119.putOpt("bot_id", r107);     // Catch: JSONException -> L144
        r119.putOpt("ai_generate_tab_id", r113);     // Catch: JSONException -> L144
        r119.putOpt("ai_generate_tab_name", r115);     // Catch: JSONException -> L144
        r119.putOpt("ai_generate_tab_type", r114);     // Catch: JSONException -> L144
        r119.putOpt(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID, r118);     // Catch: JSONException -> L144
        if (r103 == null) goto L102;
        r119.put("creator_id", r103);     // Catch: JSONException -> L144
    L102:
        if (r104 == null) goto L104;
        r119.put("use_template_uv", r104.longValue());     // Catch: JSONException -> L144
    L104:
        if (r106 == null) goto L106;
        r119.put("page_index", r106.intValue());     // Catch: JSONException -> L144
    L106:
        if (r105 == null) goto L108;
        r119.put("position", r105.intValue());     // Catch: JSONException -> L144
    L108:
        if (r111 == null) goto L110;
        r119.put("template_rec_req_id", r111);     // Catch: JSONException -> L144
    L110:
        if (r112 == null) goto L112;
        r119.put("recommend_from", r112);     // Catch: JSONException -> L144
    L112:
        if (r110 == null) goto L114;
        r119.put("click_method", r110);     // Catch: JSONException -> L144
    L114:
        if (r100 == 0) goto L116;
        r119.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r100);     // Catch: JSONException -> L144
    L116:
        if (r222 == null) goto L118;
        r119.put("previous_page", r222);     // Catch: JSONException -> L144
    L118:
        if (r108 == 0) goto L120;
        r119.put("current_page", r108);     // Catch: JSONException -> L144
    L120:
        if (r221 == null) goto L122;
        r119.put("chat_type", r221);     // Catch: JSONException -> L144
    L122:
        if (r101 == 0) goto L124;
        r119.put("template_type", r101);     // Catch: JSONException -> L144
    L124:
        String r122 = r116;
        if (r122 == null) goto L128;
        r119.put("conversation_id", r122);     // Catch: JSONException -> L144
    L128:
        if (r218 != null) goto L130;
    L133:
        boolean r123 = true;
    L134:
        if (r123 == false) goto L136;
        String r124 = "default";
    L137:
        r119.put("template_source", r124);     // Catch: JSONException -> L144
        String r125 = r220;
        if (r125 == null) goto L140;
        r119.put("template_rec_extra", r125);     // Catch: JSONException -> L144
    L140:
        String r126 = r219;
        if (r126 == null) goto L146;
        r119.put("click_from", r126);     // Catch: JSONException -> L144
    L146:
        TrackParams r127 = new TrackParams().merge(r119);
        by7.a r128 = new by7.a("click_template_share");
        r128.f21463a.merge(r127);
        r128.b();
        return;
    L136:
        r124 = r218;
        goto L137
    L130:
        if (r218.length() == 0) goto L133;
        r123 = false;
    L144:
        e = move-exception;
        FLogger.f375446a.e("TemplateEventHelper", "error in TemplateEventHelper use template " + e.getLocalizedMessage());
        goto L146
    L97:
        r121 = r414;
        goto L98
    L93:
        r120 = r413;
        goto L95
    L89:
        r119 = null;
        goto L90
    L85:
        r118 = r412;
        goto L87
    L81:
        r220 = r411;
        goto L82
    L77:
        r219 = r410;
        goto L79
    L73:
        r117 = r319;
        goto L75
    L69:
        r116 = r318;
        goto L71
    L65:
        r109 = r317;
        goto L67
    L61:
        r108 = r316;
        goto L62
    L57:
        r107 = r315;
        goto L59
    L53:
        r115 = r314;
        goto L55
    L49:
        r114 = r313;
        goto L51
    L45:
        r113 = r312;
        goto L47
    L41:
        r112 = r311;
        goto L43
    L37:
        r111 = r310;
        goto L39
    L33:
        r110 = r217;
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

    public static void k(String r310, String r311, String r312, String r313, String r314, String r315, Long r316, String r317, String r318, String r319, String r410, String r411, Integer r412, String r413, Integer r414, String r415, String r416, String r417, String r418, String r419, String r510, String r511, String r512, boolean r513, Integer r514, String r515, String r516, String r517, String r518, String r519, int r610) {
        if ((r610 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r610 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r610 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r610 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r610 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r610 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r610 & 64) == 0) goto L29;
        Long r106 = null;
    L31:
        if ((r610 & 128) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r610 & 256) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r610 & 512) == 0) goto L41;
        String r111 = null;
    L43:
        if ((r610 & 1024) == 0) goto L45;
        String r112 = null;
    L47:
        if ((r610 & 2048) == 0) goto L49;
        String r113 = null;
    L51:
        if ((r610 & 4096) == 0) goto L53;
        Integer r114 = null;
    L55:
        if ((r610 & 8192) == 0) goto L57;
        String r115 = null;
    L59:
        if ((r610 & 16384) == 0) goto L61;
        Integer r108 = null;
    L62:
        String r320 = r113;
        if ((r610 & 32768) == 0) goto L65;
        String r116 = null;
    L66:
        String r321 = r112;
        if ((r610 & 65536) == 0) goto L69;
        String r117 = null;
    L70:
        String r322 = r102;
        if ((r610 & 131072) == 0) goto L73;
        String r109 = null;
    L75:
        if ((r610 & 262144) == 0) goto L77;
        String r118 = null;
    L79:
        if ((r610 & 524288) == 0) goto L81;
        String r119 = null;
    L83:
        if ((r610 & 1048576) == 0) goto L85;
        String r210 = null;
    L87:
        if ((r610 & 2097152) == 0) goto L89;
        String r211 = null;
    L90:
        String r323 = r115;
        if ((r610 & 4194304) == 0) goto L93;
        String r120 = null;
    L95:
        if ((r610 & 8388608) == 0) goto L97;
        boolean r121 = false;
    L99:
        if ((r610 & 16777216) == 0) goto L101;
        Integer r212 = null;
    L103:
        if ((r610 & 33554432) == 0) goto L105;
        String r213 = null;
    L107:
        if ((r610 & 67108864) == 0) goto L109;
        String r122 = null;
    L111:
        if ((r610 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        String r214 = null;
    L115:
        if ((r610 & 268435456) == 0) goto L117;
        String r215 = null;
    L119:
        if ((r610 & 536870912) == 0) goto L121;
        String r216 = null;
    L123:
        if ((r610 & 1073741824) == 0) goto L125;
        JSONObject r123 = new JSONObject();
    L126:
        String r124 = r100;
        Intrinsics.checkNotNullParameter(r123, "params");
        r123.putOpt("template_sub_type", r103);     // Catch: JSONException -> L187
        r123.putOpt("template_use_tag", r122);     // Catch: JSONException -> L187
        r123.putOpt("template_sub_type", r120);     // Catch: JSONException -> L187
        if (r121 == false) goto L130;
        int r125 = 1;
    L131:
        r123.putOpt("is_image_reference_public", Integer.valueOf(r125));     // Catch: JSONException -> L187
        r123.putOpt(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID, r108);     // Catch: JSONException -> L187
        r123.putOpt("ai_generate_tab_id", r116);     // Catch: JSONException -> L187
        r123.putOpt("ai_generate_tab_name", r109);     // Catch: JSONException -> L187
        r123.putOpt("ai_generate_tab_type", r117);     // Catch: JSONException -> L187
        if (r212 == null) goto L134;
        int r126 = r212.intValue();     // Catch: JSONException -> L187
    L135:
        r123.put("image_reference_cnt", r126);     // Catch: JSONException -> L187
        if (r114 == null) goto L138;
        r123.put("page_index", r114.intValue());     // Catch: JSONException -> L187
    L138:
        if (r104 == null) goto L140;
        r123.put("creator_id", r104);     // Catch: JSONException -> L187
    L140:
        if (r105 == null) goto L142;
        r123.put("template_source", r105);     // Catch: JSONException -> L187
    L142:
        if (r106 == null) goto L144;
        r123.put("use_template_uv", r106.longValue());     // Catch: JSONException -> L187
    L144:
        if (r107 == null) goto L146;
        r123.put("template_rec_req_id", r107);     // Catch: JSONException -> L187
    L146:
        if (r110 == null) goto L148;
        r123.put("recommend_from", r110);     // Catch: JSONException -> L187
    L148:
        if (r124 == null) goto L150;
        r123.put("bot_id", r124);     // Catch: JSONException -> L187
    L150:
        if (r111 == 0) goto L152;
        r123.put("show_from", r111);     // Catch: JSONException -> L187
    L152:
        if (r101 == 0) goto L154;
        r123.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r101);     // Catch: JSONException -> L187
    L154:
        if (r323 == null) goto L156;
        r123.put("chat_type", r323);     // Catch: JSONException -> L187
    L156:
        if (r322 == null) goto L158;
        r123.put("template_type", r322);     // Catch: JSONException -> L187
    L158:
        if (r321 == null) goto L160;
        r123.put("current_page", r321);     // Catch: JSONException -> L187
    L160:
        if (r320 == null) goto L162;
        r123.put("position", r320);     // Catch: JSONException -> L187
    L162:
        String r127 = r118;
        if (r127 == null) goto L165;
        r123.put("previous_page", r127);     // Catch: JSONException -> L187
    L165:
        String r128 = r119;
        if (r128 == null) goto L168;
        r123.put("enter_method", r128);     // Catch: JSONException -> L187
    L168:
        String r129 = r210;
        if (r129 == null) goto L171;
        r123.put("conversation_id", r129);     // Catch: JSONException -> L187
    L171:
        String r130 = r211;
        if (r130 == null) goto L174;
        r123.put("template_rec_extra", r130);     // Catch: JSONException -> L187
    L174:
        String r131 = r213;
        if (r131 == null) goto L177;
        r123.put("current_page_key", r131);     // Catch: JSONException -> L187
    L177:
        String r132 = r214;
        if (r132 == null) goto L180;
        r123.put("prompt_type", r132);     // Catch: JSONException -> L187
    L180:
        String r133 = r215;
        if (r133 == null) goto L183;
        r123.put("prompt_from", r133);     // Catch: JSONException -> L187
    L183:
        String r134 = r216;
        if (r134 == null) goto L189;
        r123.put("visual_size", r134);     // Catch: JSONException -> L187
    L189:
        TrackParams r135 = new TrackParams().merge(r123);
        by7.a r136 = new by7.a("template_show");
        r136.f21463a.merge(r135);
        r136.b();
        return;
    L134:
        r126 = 0;
        goto L135
    L130:
        r125 = 0;
    L187:
        e = move-exception;
        FLogger.f375446a.e("TemplateEventHelper", "error in TemplateEventHelper template show " + e.getLocalizedMessage());
        goto L189
    L125:
        r123 = null;
        goto L126
    L121:
        r216 = r519;
        goto L123
    L117:
        r215 = r518;
        goto L119
    L113:
        r214 = r517;
        goto L115
    L109:
        r122 = r516;
        goto L111
    L105:
        r213 = r515;
        goto L107
    L101:
        r212 = r514;
        goto L103
    L97:
        r121 = r513;
        goto L99
    L93:
        r120 = r512;
        goto L95
    L89:
        r211 = r511;
        goto L90
    L85:
        r210 = r510;
        goto L87
    L81:
        r119 = r419;
        goto L83
    L77:
        r118 = r418;
        goto L79
    L73:
        r109 = r417;
        goto L75
    L69:
        r117 = r416;
        goto L70
    L65:
        r116 = r415;
        goto L66
    L61:
        r108 = r414;
        goto L62
    L57:
        r115 = r413;
        goto L59
    L53:
        r114 = r412;
        goto L55
    L49:
        r113 = r411;
        goto L51
    L45:
        r112 = r410;
        goto L47
    L41:
        r111 = r319;
        goto L43
    L37:
        r110 = r318;
        goto L39
    L33:
        r107 = r317;
        goto L35
    L29:
        r106 = r316;
        goto L31
    L25:
        r105 = r315;
        goto L27
    L21:
        r104 = r314;
        goto L23
    L17:
        r103 = r313;
        goto L19
    L13:
        r102 = r312;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }

    public static void g(String r310, String r311, String r312, String r313, String r314, String r315, Long r316, Integer r317, String r318, String r410, String r411, Integer r412, String r413, Integer r414, String r415, String r416, String r417, String r418, String r419, String r510, Boolean r511, String r512, String r513, Boolean r514, Integer r515, Boolean r516, String r517, String r518, String r519, String r610, String r611, String r612, int r613, int r614) {
        if ((r613 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r613 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r613 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r613 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r613 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r613 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r613 & 64) == 0) goto L29;
        Long r106 = null;
    L31:
        if ((r613 & 128) == 0) goto L33;
        Integer r107 = null;
    L35:
        if ((r613 & 256) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r613 & 512) == 0) goto L41;
        String r111 = null;
    L43:
        if ((r613 & 1024) == 0) goto L45;
        String r112 = null;
    L47:
        if ((r613 & 4096) == 0) goto L49;
        Integer r113 = null;
    L51:
        if ((r613 & 8192) == 0) goto L53;
        String r114 = null;
    L55:
        if ((r613 & 16384) == 0) goto L57;
        Integer r115 = null;
    L59:
        if ((r613 & 32768) == 0) goto L61;
        String r108 = null;
    L62:
        Integer r319 = r113;
        if ((r613 & 65536) == 0) goto L65;
        String r116 = null;
    L66:
        String r320 = r102;
        if ((r613 & 131072) == 0) goto L69;
        String r109 = null;
    L71:
        if ((r613 & 262144) == 0) goto L73;
        String r117 = null;
    L75:
        if ((r613 & 524288) == 0) goto L77;
        String r118 = null;
    L79:
        if ((r613 & 1048576) == 0) goto L81;
        String r210 = null;
    L83:
        if ((r613 & 2097152) == 0) goto L85;
        Boolean r119 = null;
    L87:
        if ((r613 & 4194304) == 0) goto L89;
        String r211 = null;
    L90:
        String r321 = r114;
        if ((r613 & 8388608) == 0) goto L93;
        String r120 = null;
    L95:
        if ((r613 & 16777216) == 0) goto L97;
        Boolean r121 = Boolean.FALSE;
    L99:
        if ((r613 & 33554432) == 0) goto L101;
        Integer r212 = null;
    L103:
        if ((r613 & 67108864) == 0) goto L105;
        Boolean r122 = Boolean.FALSE;
    L106:
        String r322 = r112;
        if ((r613 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L109;
        String r123 = null;
    L111:
        if ((r613 & 268435456) == 0) goto L113;
        String r213 = null;
    L115:
        if ((r613 & 536870912) == 0) goto L117;
        String r214 = null;
    L119:
        if ((r613 & 1073741824) == 0) goto L121;
        String r215 = null;
    L123:
        if ((r613 & Integer.MIN_VALUE) == 0) goto L125;
        String r124 = null;
    L127:
        if ((r614 & 1) == 0) goto L129;
        String r216 = null;
    L131:
        if ((r614 & 2) == 0) goto L133;
        JSONObject r125 = new JSONObject();
    L134:
        String r323 = r124;
        Integer r324 = r107;
        Intrinsics.checkNotNullParameter(r125, "params");
        r125.putOpt("template_sub_type", r103);     // Catch: JSONException -> L201
        r125.putOpt("template_use_tag", r123);     // Catch: JSONException -> L201
        r125.putOpt("template_sub_type", r120);     // Catch: JSONException -> L201
        Boolean r126 = Boolean.TRUE;     // Catch: JSONException -> L201
        int r127 = 0;
        int r128 = 1;
        if (Intrinsics.areEqual(r121, r126) == false) goto L138;
        int r129 = 1;
    L139:
        r125.putOpt("is_image_reference_public", Integer.valueOf(r129));     // Catch: JSONException -> L201
        if (Intrinsics.areEqual(r122, r126) == true) goto L143;
        r128 = 0;
    L143:
        r125.putOpt("is_has_caption", Integer.valueOf(r128));     // Catch: JSONException -> L201
        r125.putOpt("ai_generate_tab_id", r108);     // Catch: JSONException -> L201
        r125.putOpt("ai_generate_tab_name", r109);     // Catch: JSONException -> L201
        r125.putOpt("ai_generate_tab_type", r116);     // Catch: JSONException -> L201
        r125.putOpt(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID, r115);     // Catch: JSONException -> L201
        if (r111 == null) goto L146;
        r125.put("enter_method", r111);     // Catch: JSONException -> L201
    L146:
        if (r104 == null) goto L148;
        r125.put("creator_id", r104);     // Catch: JSONException -> L201
    L148:
        if (r105 == null) goto L150;
        r125.put("template_source", r105);     // Catch: JSONException -> L201
    L150:
        if (r106 == null) goto L152;
        r125.put("use_template_uv", r106.longValue());     // Catch: JSONException -> L201
    L152:
        if (r324 == null) goto L154;
        r125.put("page_index", r324.intValue());     // Catch: JSONException -> L201
    L154:
        if (r110 == 0) goto L156;
        r125.put("template_rec_req_id", r110);     // Catch: JSONException -> L201
    L156:
        if (r322 == null) goto L158;
        r125.put("recommend_from", r322);     // Catch: JSONException -> L201
    L158:
        if (r100 == 0) goto L160;
        r125.put("bot_id", r100);     // Catch: JSONException -> L201
    L160:
        if (r101 == 0) goto L162;
        r125.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r101);     // Catch: JSONException -> L201
    L162:
        if (r321 == null) goto L164;
        r125.put("chat_type", r321);     // Catch: JSONException -> L201
    L164:
        if (r320 == null) goto L166;
        r125.put("template_type", r320);     // Catch: JSONException -> L201
    L166:
        if (r319 == null) goto L168;
        r125.put("position", r319.intValue());     // Catch: JSONException -> L201
    L168:
        String r130 = r118;
        if (r130 == null) goto L171;
        r125.put("previous_page", r130);     // Catch: JSONException -> L201
    L171:
        String r131 = r117;
        if (r131 == null) goto L174;
        r125.put("current_page", r131);     // Catch: JSONException -> L201
    L174:
        String r132 = r210;
        if (r132 == null) goto L177;
        r125.put("conversation_id", r132);     // Catch: JSONException -> L201
    L177:
        String r133 = r213;
        if (r133 == null) goto L180;
        r125.put("prompt_type", r133);     // Catch: JSONException -> L201
    L180:
        String r134 = r214;
        if (r134 == null) goto L183;
        r125.put("prompt_from", r134);     // Catch: JSONException -> L201
    L183:
        String r135 = r215;
        if (r135 == null) goto L187;
        r125.put("visual_size", r135);     // Catch: JSONException -> L201
    L187:
        if (r212 == null) goto L189;
        r127 = r212.intValue();     // Catch: JSONException -> L201
    L189:
        r125.putOpt("image_reference_cnt", Integer.valueOf(r127));     // Catch: JSONException -> L201
        if (r119 == null) goto L192;
        r125.put("success", r119.booleanValue() ? 1 : 0);     // Catch: JSONException -> L201
    L192:
        String r136 = r211;
        if (r136 == null) goto L195;
        r125.put("template_rec_extra", r136);     // Catch: JSONException -> L201
    L195:
        if (r323 == null) goto L197;
        r125.put("anchor_creation_id", r323);     // Catch: JSONException -> L201
    L197:
        String r137 = r216;
        if (r137 == null) goto L203;
        r125.put("douyin_gid", r137);     // Catch: JSONException -> L201
    L203:
        TrackParams r138 = new TrackParams().merge(r125);
        by7.a r139 = new by7.a("enter_template_detail");
        r139.f21463a.merge(r138);
        r139.b();
        return;
    L138:
        r129 = 0;
    L201:
        e = move-exception;
        FLogger.f375446a.e("TemplateEventHelper", "error in TemplateEventHelper template show " + e.getLocalizedMessage());
        goto L203
    L133:
        r125 = null;
        goto L134
    L129:
        r216 = r612;
        goto L131
    L125:
        r124 = r611;
        goto L127
    L121:
        r215 = r610;
        goto L123
    L117:
        r214 = r519;
        goto L119
    L113:
        r213 = r518;
        goto L115
    L109:
        r123 = r517;
        goto L111
    L105:
        r122 = r516;
        goto L106
    L101:
        r212 = r515;
        goto L103
    L97:
        r121 = r514;
        goto L99
    L93:
        r120 = r513;
        goto L95
    L89:
        r211 = r512;
        goto L90
    L85:
        r119 = r511;
        goto L87
    L81:
        r210 = r510;
        goto L83
    L77:
        r118 = r419;
        goto L79
    L73:
        r117 = r418;
        goto L75
    L69:
        r109 = r417;
        goto L71
    L65:
        r116 = r416;
        goto L66
    L61:
        r108 = r415;
        goto L62
    L57:
        r115 = r414;
        goto L59
    L53:
        r114 = r413;
        goto L55
    L49:
        r113 = r412;
        goto L51
    L45:
        r112 = r411;
        goto L47
    L41:
        r111 = r410;
        goto L43
    L37:
        r110 = r318;
        goto L39
    L33:
        r107 = r317;
        goto L35
    L29:
        r106 = r316;
        goto L31
    L25:
        r105 = r315;
        goto L27
    L21:
        r104 = r314;
        goto L23
    L17:
        r103 = r313;
        goto L19
    L13:
        r102 = r312;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }

    public static void l(String r310, String r311, String r312, String r313, String r314, String r410, String r411, String r412, Integer r413, Integer r414, String r415, Integer r416, String r417, String r418, String r419, String r510, String r511, String r512, Long r513, String r514, String r515, String r516, Boolean r517, Integer r518, Boolean r519, String r610, String r611, String r612, String r613, Boolean r614, String r615, String r616, String r617, String r618, String r619, int r710, int r711) {
        if ((r710 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r710 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r710 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r710 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r710 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r710 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r710 & 64) == 0) goto L29;
        String r106 = "default";
    L31:
        if ((r710 & 128) == 0) goto L33;
        JSONObject r110 = new JSONObject();
    L35:
        if ((r710 & 512) == 0) goto L37;
        String r111 = null;
    L39:
        if ((r710 & 1024) == 0) goto L41;
        Integer r112 = null;
    L43:
        if ((r710 & 2048) == 0) goto L45;
        Integer r113 = null;
    L47:
        if ((r710 & 4096) == 0) goto L49;
        String r114 = null;
    L51:
        if ((r710 & 8192) == 0) goto L53;
        Integer r115 = null;
    L55:
        if ((r710 & 16384) == 0) goto L57;
        String r107 = null;
    L59:
        if ((r710 & 32768) == 0) goto L61;
        String r108 = null;
    L62:
        String r315 = r106;
        if ((r710 & 65536) == 0) goto L65;
        String r109 = null;
    L66:
        String r316 = r104;
        if ((r710 & 131072) == 0) goto L69;
        String r116 = null;
    L71:
        if ((r710 & 262144) == 0) goto L73;
        String r117 = null;
    L75:
        if ((r710 & 524288) == 0) goto L77;
        String r118 = null;
    L79:
        if ((r710 & 1048576) == 0) goto L81;
        Long r119 = null;
    L83:
        if ((r710 & 2097152) == 0) goto L85;
        String r210 = null;
    L87:
        if ((r710 & 4194304) == 0) goto L89;
        String r211 = null;
    L90:
        String r317 = r103;
        if ((r710 & 8388608) == 0) goto L93;
        String r120 = null;
    L95:
        if ((r710 & 16777216) == 0) goto L97;
        Boolean r121 = Boolean.FALSE;
    L99:
        if ((r710 & 33554432) == 0) goto L101;
        Integer r212 = null;
    L103:
        if ((r710 & 67108864) == 0) goto L105;
        Boolean r122 = Boolean.FALSE;
    L107:
        if ((r710 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L109;
        String r123 = null;
    L111:
        if ((r710 & 268435456) == 0) goto L113;
        String r213 = null;
    L114:
        String r318 = r116;
        if ((r710 & 536870912) == 0) goto L117;
        String r124 = null;
    L119:
        if ((r710 & 1073741824) == 0) goto L121;
        String r214 = null;
    L123:
        if ((r710 & Integer.MIN_VALUE) == 0) goto L125;
        Boolean r125 = Boolean.FALSE;
    L127:
        if ((r711 & 1) == 0) goto L129;
        String r215 = null;
    L131:
        if ((r711 & 2) == 0) goto L133;
        String r319 = null;
    L135:
        if ((r711 & 4) == 0) goto L137;
        String r320 = null;
    L139:
        if ((r711 & 8) == 0) goto L141;
        String r321 = null;
    L143:
        if ((r711 & 16) == 0) goto L145;
        String r322 = null;
    L146:
        Integer r420 = r112;
        Intrinsics.checkNotNullParameter(r110, "params");
        r110.putOpt("template_sub_type", r105);     // Catch: JSONException -> L229
        Boolean r126 = Boolean.TRUE;     // Catch: JSONException -> L229
        boolean r127 = false;
        if (Intrinsics.areEqual(r125, r126) == false) goto L150;
        int r128 = 1;
    L151:
        r110.putOpt("is_has_replica", Integer.valueOf(r128));     // Catch: JSONException -> L229
        if (r214 != null) goto L154;
        r214 = "use_prompt";
    L154:
        r110.putOpt(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r214);     // Catch: JSONException -> L229
        r110.putOpt("template_use_tag", r124);     // Catch: JSONException -> L229
        r110.putOpt("enter_method", r123);     // Catch: JSONException -> L229
        r110.putOpt("template_sub_type", r120);     // Catch: JSONException -> L229
        if (Intrinsics.areEqual(r121, r126) == false) goto L157;
        int r129 = 1;
    L158:
        r110.putOpt("is_image_reference_public", Integer.valueOf(r129));     // Catch: JSONException -> L229
        if (Intrinsics.areEqual(r122, r126) == false) goto L161;
        int r130 = 1;
    L162:
        r110.putOpt("is_has_caption", Integer.valueOf(r130));     // Catch: JSONException -> L229
        r110.putOpt("ai_generate_tab_id", r107);     // Catch: JSONException -> L229
        r110.putOpt("ai_generate_tab_name", r109);     // Catch: JSONException -> L229
        r110.putOpt("ai_generate_tab_type", r108);     // Catch: JSONException -> L229
        if (r111 == null) goto L165;
        r110.put("creator_id", r111);     // Catch: JSONException -> L229
    L165:
        r110.putOpt(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID, r115);     // Catch: JSONException -> L229
        if (r113 == null) goto L168;
        r110.put("page_index", r113.intValue());     // Catch: JSONException -> L229
    L168:
        if (r420 == null) goto L170;
        r110.put("position", r420.intValue());     // Catch: JSONException -> L229
    L170:
        if (r114 == 0) goto L172;
        r110.put("template_rec_req_id", r114);     // Catch: JSONException -> L229
    L172:
        if (r318 == null) goto L174;
        r110.put("recommend_from", r318);     // Catch: JSONException -> L229
    L174:
        if (r212 == null) goto L176;
        int r131 = r212.intValue();     // Catch: JSONException -> L229
    L177:
        r110.put("image_reference_cnt", r131);     // Catch: JSONException -> L229
        if (r100 == 0) goto L180;
        r110.put("bot_id", r100);     // Catch: JSONException -> L229
    L180:
        if (r102 == 0) goto L182;
        r110.put("enter_from", r102);     // Catch: JSONException -> L229
    L182:
        if (r101 == 0) goto L184;
        r110.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r101);     // Catch: JSONException -> L229
    L184:
        if (r317 == null) goto L186;
        r110.put("chat_type", r317);     // Catch: JSONException -> L229
    L186:
        if (r316 == null) goto L188;
        r110.put("template_type", r316);     // Catch: JSONException -> L229
    L188:
        String r132 = r117;
        if (r132 == null) goto L191;
        r110.put("current_page", r132);     // Catch: JSONException -> L229
    L191:
        String r133 = r118;
        if (r133 == null) goto L194;
        r110.put("previous_page", r133);     // Catch: JSONException -> L229
    L194:
        if (r119 == null) goto L196;
        r110.put("use_template_uv", r119.longValue());     // Catch: JSONException -> L229
    L196:
        String r134 = r210;
        if (r134 == null) goto L200;
        r110.put("conversation_id", r134);     // Catch: JSONException -> L229
    L200:
        if (r315 != null) goto L202;
    L203:
        r127 = true;
    L204:
        if (r127 == false) goto L206;
        String r135 = "default";
    L207:
        r110.put("template_source", r135);     // Catch: JSONException -> L229
        String r136 = r211;
        if (r136 == null) goto L210;
        r110.put("template_rec_extra", r136);     // Catch: JSONException -> L229
    L210:
        String r137 = r213;
        if (r137 == null) goto L213;
        r110.put("current_page_key", r137);     // Catch: JSONException -> L229
    L213:
        String r138 = r215;
        if (r138 == null) goto L216;
        r110.put("prompt_type", r138);     // Catch: JSONException -> L229
    L216:
        String r139 = r319;
        if (r139 == null) goto L219;
        r110.put("prompt_from", r139);     // Catch: JSONException -> L229
    L219:
        String r140 = r320;
        if (r140 == null) goto L222;
        r110.put("visual_size", r140);     // Catch: JSONException -> L229
    L222:
        String r141 = r321;
        if (r141 == null) goto L225;
        r110.put("anchor_creation_id", r141);     // Catch: JSONException -> L229
    L225:
        String r142 = r322;
        if (r142 == null) goto L231;
        r110.put("douyin_gid", r142);     // Catch: JSONException -> L229
    L231:
        TrackParams r143 = new TrackParams().merge(r110);
        by7.a r144 = new by7.a("use_template");
        r144.f21463a.merge(r143);
        r144.b();
        return;
    L206:
        r135 = r315;
        goto L207
    L202:
        if (r315.length() != 0) goto L204;
    L176:
        r131 = 0;
        goto L177
    L161:
        r130 = 0;
        goto L162
    L157:
        r129 = 0;
        goto L158
    L150:
        r128 = 0;
    L229:
        e = move-exception;
        FLogger.f375446a.e("TemplateEventHelper", "error in TemplateEventHelper use template " + e.getLocalizedMessage());
        goto L231
    L145:
        r322 = r619;
        goto L146
    L141:
        r321 = r618;
        goto L143
    L137:
        r320 = r617;
        goto L139
    L133:
        r319 = r616;
        goto L135
    L129:
        r215 = r615;
        goto L131
    L125:
        r125 = r614;
        goto L127
    L121:
        r214 = r613;
        goto L123
    L117:
        r124 = r612;
        goto L119
    L113:
        r213 = r611;
        goto L114
    L109:
        r123 = r610;
        goto L111
    L105:
        r122 = r519;
        goto L107
    L101:
        r212 = r518;
        goto L103
    L97:
        r121 = r517;
        goto L99
    L93:
        r120 = r516;
        goto L95
    L89:
        r211 = r515;
        goto L90
    L85:
        r210 = r514;
        goto L87
    L81:
        r119 = r513;
        goto L83
    L77:
        r118 = r512;
        goto L79
    L73:
        r117 = r511;
        goto L75
    L69:
        r116 = r510;
        goto L71
    L65:
        r109 = r419;
        goto L66
    L61:
        r108 = r418;
        goto L62
    L57:
        r107 = r417;
        goto L59
    L53:
        r115 = r416;
        goto L55
    L49:
        r114 = r415;
        goto L51
    L45:
        r113 = r414;
        goto L47
    L41:
        r112 = r413;
        goto L43
    L37:
        r111 = r412;
        goto L39
    L33:
        r110 = null;
        goto L35
    L29:
        r106 = r411;
        goto L31
    L25:
        r105 = r410;
        goto L27
    L21:
        r104 = r314;
        goto L23
    L17:
        r103 = r313;
        goto L19
    L13:
        r102 = r312;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }
}
