package tx9;

import android.text.TextUtils;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.sdk.bridge.annotation.BridgePrivilege;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.livetutor.impl.home.viewmodel.LiveTutorHomeVM;
import com.larus.utils.logger.FLogger;
import com.obric.trace.ObricActionBarTrackType;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class o3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f547886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList<by7.a> f547887b = null;

    static {
        f547887b = new ArrayList();
    }

    public static void b(String r100) {
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter(r101, "params");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Result.m9449constructorimpl(r101.put("current_page", r100));     // Catch: Throwable -> L5
    L7:
        TrackParams r103 = new TrackParams().merge(r101);
        by7.a r104 = new by7.a("search_create_bot_show");
        r104.f21463a.merge(r103);
        r104.b();
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static void d(String r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        Intrinsics.checkNotNullParameter(r103, "params");
        if (r100 != null) goto L15;
    L7:
        if (r101 == null) goto L9;
        r103.put("current_page", r101);     // Catch: JSONException -> L5
    L9:
        if (r102 == null) goto L13;
        r103.put("schema_name", r102);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("ShowEventHelper", "error in ShowEventHelper mobShowCreatePanelCell " + e.getLocalizedMessage());
    L13:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("show_create_panel_cell");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L15:
        r103.put("position", r100);     // Catch: JSONException -> L5
        goto L7
    }

    public static void h(String r100, String r101, String r102, Boolean r103, Boolean r104, Integer r105, String r106, int r107) {
        JSONObject r108 = null;
        if ((r107 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r107 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r107 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r107 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r107 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r107 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r107 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r107 & 128) == 0) goto L26;
        JSONObject r109 = new JSONObject();
    L27:
        Intrinsics.checkNotNullParameter(r109, "params");
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L54
        if (r100 == null) goto L31;
        r109.put("button_name", r100);     // Catch: Throwable -> L54
    L31:
        if (r101 == null) goto L33;
        r109.put("creation_id", r101);     // Catch: Throwable -> L54
    L33:
        if (r102 == null) goto L35;
        r109.put("create_way", r102);     // Catch: Throwable -> L54
    L35:
        String r111 = "1";
        if (r103 != null) goto L38;
    L42:
        if (r104 != null) goto L44;
    L48:
        if (r105 == null) goto L50;
        r109.put("polish_cnt", String.valueOf(r105.intValue()));     // Catch: Throwable -> L54
    L50:
        if (r106 == null) goto L52;
        r108 = r109.put("current_page", r106);     // Catch: Throwable -> L54
    L52:
        Result.m9449constructorimpl(r108);     // Catch: Throwable -> L54
    L56:
        TrackParams r112 = new TrackParams().merge(r109);
        by7.a r113 = new by7.a("sp_polish_show");
        r113.f21463a.merge(r112);
        r113.b();
        return;
    L44:
        if (r104.booleanValue() == true) goto L47;
        r111 = "0";
    L47:
        r109.put("if_polish", r111);     // Catch: Throwable -> L54
        goto L48
    L38:
        if (r103.booleanValue() == false) goto L40;
        Object r114 = "1";
    L41:
        r109.put("if_auto_filled", r114);     // Catch: Throwable -> L54
        goto L42
    L40:
        r114 = "0";
    L54:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L56
    L26:
        r109 = null;
        goto L27
    }

    public static void a(String r100, String r101, String r102, String r103, String r104, String r105, String r106, by7.e r107, int r110) {
        if ((r110 & 2) == 0) goto L6;
        r100 = null;
    L6:
        if ((r110 & 4) == 0) goto L9;
        r101 = null;
    L9:
        if ((r110 & 8) == 0) goto L12;
        r102 = null;
    L12:
        if ((r110 & 16) == 0) goto L15;
        r103 = null;
    L15:
        if ((r110 & 32) == 0) goto L18;
        r104 = null;
    L18:
        if ((r110 & 64) == 0) goto L21;
        r105 = null;
    L21:
        if ((r110 & 128) == 0) goto L24;
        r106 = null;
    L24:
        if ((r110 & 256) == 0) goto L26;
        JSONObject r108 = new JSONObject();
    L28:
        if ((r110 & 512) == 0) goto L30;
        r107 = null;
    L30:
        Intrinsics.checkNotNullParameter(r108, "params");
        if (r100 != null) goto L54;
    L35:
        if (r102 == null) goto L37;
        r108.put("previous_page", r102);     // Catch: JSONException -> L33
    L37:
        if (r101 == null) goto L39;
        r108.put("creation_id", r101);     // Catch: JSONException -> L33
    L39:
        if (r103 == null) goto L41;
        r108.put("create_way", r103);     // Catch: JSONException -> L33
    L41:
        if (r104 == null) goto L43;
        r108.put("type", r104);     // Catch: JSONException -> L33
    L43:
        if (r105 == null) goto L45;
        r108.put("from_activity_name", r105);     // Catch: JSONException -> L33
    L45:
        if (r106 == null) goto L49;
        r108.put("from_activity_module", r106);     // Catch: JSONException -> L33
    L33:
        e = move-exception;
        FLogger.f375446a.e("ShowEventHelper", "error in ShowEventHelper createBotBlockWindowShow " + e.getLocalizedMessage());
    L49:
        TrackParams r109 = new TrackParams().merge(r108);
        by7.a r111 = new by7.a("create_bot_block_window_show");
        if (r107 == null) goto L52;
        r111.f21464b = r107;
    L52:
        r111.f21463a.merge(r109);
        r111.b();
        return;
    L54:
        r108.put("enter_method", r100);     // Catch: JSONException -> L33
        goto L35
    L26:
        r108 = null;
        goto L28
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    public static void e(Long r110, String r111, Long r210, String r211, String r212, String r213, String r214, String r215, String r216, Long r217, Long r218, String r219, String r310, String r311, String r312, int r313) {
        if ((r313 & 2) == 0) goto L5;
        Long r100 = null;
    L7:
        if ((r313 & 4) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r313 & 8) == 0) goto L13;
        Long r102 = null;
    L15:
        if ((r313 & 16) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r313 & 128) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r313 & 256) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r313 & 512) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r313 & 1024) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r313 & 2048) == 0) goto L37;
        String r112 = null;
    L39:
        if ((r313 & 4096) == 0) goto L41;
        Long r113 = null;
    L43:
        if ((r313 & 8192) == 0) goto L45;
        Long r114 = null;
    L47:
        if ((r313 & 16384) == 0) goto L49;
        String r115 = null;
    L51:
        if ((32768 & r313) == 0) goto L53;
        String r116 = null;
    L55:
        if ((65536 & r313) == 0) goto L57;
        String r117 = null;
    L59:
        if ((r313 & 131072) == 0) goto L61;
        String r108 = null;
    L63:
        if ((r313 & 262144) == 0) goto L65;
        JSONObject r118 = new JSONObject();
    L66:
        Intrinsics.checkNotNullParameter(r118, "params");
        String r119 = r108;
        if (r100 != null) goto L69;
        String r220 = "ShowEventHelper";
    L74:
        if (r101 == null) goto L78;
        r118.put("chat_type", r101);     // Catch: JSONException -> L76
    L78:
        if (r102 == null) goto L80;
        r118.put("conversation_id", r102.longValue());     // Catch: JSONException -> L76
    L80:
        if (r103 == null) goto L82;
        r118.put("current_page", r103);     // Catch: JSONException -> L76
    L82:
        if (r104 == null) goto L84;
        r118.put(MusicAppletPage.KEY_MESSAGE_ID, r104);     // Catch: JSONException -> L76
    L84:
        if (r105 == null) goto L86;
        r118.put("onboarding_content_source", r105);     // Catch: JSONException -> L76
    L86:
        if (r106 == null) goto L88;
        r118.put("onboarding_question", r106);     // Catch: JSONException -> L76
    L88:
        if (r107 == null) goto L90;
        r118.put("onboarding_type", r107);     // Catch: JSONException -> L76
    L90:
        if (r112 == null) goto L92;
        r118.put("previous_page", r112);     // Catch: JSONException -> L76
    L92:
        if (r113 == null) goto L94;
        r118.put("prompt_cnt", r113.longValue());     // Catch: JSONException -> L76
    L94:
        if (r114 == null) goto L96;
        r118.put("show_rank", r114.longValue());     // Catch: JSONException -> L76
    L96:
        if (r115 == null) goto L98;
        r118.put("show_way", r115);     // Catch: JSONException -> L76
    L98:
        if (r116 == null) goto L100;
        r118.put("use_nickname", r116);     // Catch: JSONException -> L76
    L100:
        if (r119 == null) goto L102;
        r118.put("prompt_type", r119);     // Catch: JSONException -> L76
    L102:
        if (r117 == 0) goto L106;
        r118.put("reco_request_id", r117);     // Catch: JSONException -> L76
    L76:
        e = move-exception;
        String r109 = r220;
        FLogger.f375446a.e(r109, "error in ShowEventHelper showOnboardingCard " + e.getLocalizedMessage());
    L107:
        TrackParams r120 = new TrackParams().merge(r118);
        by7.a r121 = new by7.a("show_onboarding_card");
        r121.f21463a.merge(r120);
        r121.b();
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L110
        com.larus.platform.service.g.f365738a.monitorEventForSlardar("show_onboarding_card", r118, null, null);     // Catch: Throwable -> L110
        Object r123 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L110
    L112:
        Throwable r124 = Result.m9452exceptionOrNullimpl(r123);
        if (r124 == null) goto L121;
        FLogger.f375446a.e(r109, "slardar report error, showOnboardingCard " + r124.getLocalizedMessage());
        return;
    L121:
        return;
    L110:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L106:
        r109 = r220;
        goto L107
    L69:
        r220 = "ShowEventHelper";
        r118.put("bot_id", r100.longValue());     // Catch: JSONException -> L76
        goto L74
    L65:
        r118 = null;
        goto L66
    L61:
        r108 = r312;
        goto L63
    L57:
        r117 = r311;
        goto L59
    L53:
        r116 = r310;
        goto L55
    L49:
        r115 = r219;
        goto L51
    L45:
        r114 = r218;
        goto L47
    L41:
        r113 = r217;
        goto L43
    L37:
        r112 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public static void c(String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, String r318, String r319, String r410, Integer r411, JSONObject r412, by7.e r413, int r414) {
        if ((r414 & 2) == 0) goto L5;
        Object r100 = null;
    L7:
        if ((r414 & 4) == 0) goto L9;
        Object r101 = null;
    L11:
        if ((r414 & 8) == 0) goto L13;
        Object r102 = null;
    L15:
        if ((r414 & 16) == 0) goto L17;
        Object r103 = null;
    L19:
        if ((r414 & 32) == 0) goto L21;
        Object r104 = null;
    L23:
        if ((r414 & 64) == 0) goto L25;
        Object r105 = null;
    L27:
        if ((r414 & 128) == 0) goto L29;
        Object r106 = null;
    L31:
        if ((r414 & 256) == 0) goto L33;
        Object r107 = null;
    L35:
        if ((r414 & 512) == 0) goto L37;
        Object r110 = null;
    L39:
        if ((r414 & 1024) == 0) goto L41;
        Object r111 = null;
    L43:
        if ((r414 & 2048) == 0) goto L45;
        Object r112 = null;
    L47:
        if ((r414 & 8192) == 0) goto L49;
        Object r113 = null;
    L51:
        if ((r414 & 16384) == 0) goto L53;
        Object r114 = null;
    L55:
        if ((32768 & r414) == 0) goto L57;
        Object r115 = null;
    L59:
        if ((r414 & 65536) == 0) goto L61;
        Object r108 = null;
    L63:
        if ((r414 & 131072) == 0) goto L65;
        Object r116 = null;
    L67:
        if ((r414 & 262144) == 0) goto L69;
        Object r117 = null;
    L71:
        if ((r414 & 524288) == 0) goto L73;
        Object r217 = null;
    L75:
        if ((r414 & 1048576) == 0) goto L77;
        Integer r118 = null;
    L79:
        if ((r414 & 2097152) == 0) goto L81;
        JSONObject r109 = new JSONObject();
    L83:
        if ((r414 & 4194304) == 0) goto L85;
        by7.e r218 = null;
    L86:
        Intrinsics.checkNotNullParameter(r109, "params");
        Object r219 = r115;
        if (r100 != null) goto L142;
    L91:
        if (r101 == null) goto L93;
        r109.put("chat_type", r101);     // Catch: JSONException -> L89
    L93:
        if (r102 == null) goto L95;
        r109.put("current_page", r102);     // Catch: JSONException -> L89
    L95:
        if (r103 == null) goto L97;
        r109.put("enter_method", r103);     // Catch: JSONException -> L89
    L97:
        if (r104 == null) goto L99;
        r109.put("is_immersive_background", r104);     // Catch: JSONException -> L89
    L99:
        if (r105 == null) goto L101;
        r109.put("previous_page", r105);     // Catch: JSONException -> L89
    L101:
        if (r106 == null) goto L103;
        r109.put("query", r106);     // Catch: JSONException -> L89
    L103:
        if (r107 == null) goto L105;
        r109.put("query_id", r107);     // Catch: JSONException -> L89
    L105:
        if (r110 == null) goto L107;
        r109.put("rank", r110);     // Catch: JSONException -> L89
    L107:
        if (r111 == null) goto L109;
        r109.put("recommend_from", r111);     // Catch: JSONException -> L89
    L109:
        if (r112 == null) goto L111;
        r109.put("req_id", r112);     // Catch: JSONException -> L89
    L111:
        if (r113 == null) goto L113;
        r109.put("search_id", r113);     // Catch: JSONException -> L89
    L113:
        if (r114 == null) goto L115;
        r109.put("search_request_id", r114);     // Catch: JSONException -> L89
    L115:
        if (r219 == null) goto L117;
        r109.put("search_result_id", r219);     // Catch: JSONException -> L89
    L117:
        if (r108 == 0) goto L119;
        r109.put("user_id", r108);     // Catch: JSONException -> L89
    L119:
        Object r119 = r116;
        if (r119 == null) goto L122;
        r109.put("group_type", r119);     // Catch: JSONException -> L89
    L122:
        Object r120 = r117;
        if (r120 == null) goto L125;
        r109.put("item_id", r120);     // Catch: JSONException -> L89
    L125:
        Object r121 = r217;
        if (r121 == null) goto L128;
        r109.put("is_call_bot", r121);     // Catch: JSONException -> L89
    L128:
        if (r118 == null) goto L132;
        r109.put("bot_type", r118.intValue());     // Catch: JSONException -> L89
    L89:
        e = move-exception;
        FLogger.f375446a.e("ShowEventHelper", "error in ShowEventHelper showBotChat " + e.getLocalizedMessage());
    L132:
        TrackParams r122 = new TrackParams().merge(r109);
        by7.a r123 = new by7.a("show_bot_chat");
        by7.e r124 = r218;
        if (r124 == null) goto L136;
        r123.f21464b = r124;
    L136:
        if (f547886a == false) goto L140;
        FLogger r125 = FLogger.f375446a;
        StringBuilder r126 = new StringBuilder("addShowBotEventWhenReturnToMain ");
        ArrayList<by7.a> r127 = f547887b;
        r126.append(r127.size());
        r125.i("ShowEventHelper", r126.toString());
        if (r127.size() >= 100) goto L144;
        r123.f21463a.merge(r122);
        r127.add(r123);
        return;
    L144:
        return;
    L140:
        r123.f21463a.merge(r122);
        r123.b();
        return;
    L142:
        r109.put("bot_id", r100);     // Catch: JSONException -> L89
        goto L91
    L85:
        r218 = r413;
        goto L86
    L81:
        r109 = r412;
        goto L83
    L77:
        r118 = r411;
        goto L79
    L73:
        r217 = r410;
        goto L75
    L69:
        r117 = r319;
        goto L71
    L65:
        r116 = r318;
        goto L67
    L61:
        r108 = r317;
        goto L63
    L57:
        r115 = r316;
        goto L59
    L53:
        r114 = r315;
        goto L55
    L49:
        r113 = r314;
        goto L51
    L45:
        r112 = r313;
        goto L47
    L41:
        r111 = r312;
        goto L43
    L37:
        r110 = r311;
        goto L39
    L33:
        r107 = r310;
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

    public static void g(Long r110, String r111, Long r112, String r113, String r210, String r211, String r212, Long r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, String r318, String r319, String r410, Boolean r411) {
        JSONObject r114 = new JSONObject();
        Intrinsics.checkNotNullParameter(r114, "params");
        if (r315 != null) goto L69;
    L7:
        if (r317 == null) goto L9;
        r114.put(LiveTutorHomeVM.ACTION_BAR_ITEM_ID, r317);     // Catch: JSONException -> L5
    L9:
        if (r316 == null) goto L11;
        r114.put(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID, r316);     // Catch: JSONException -> L5
    L11:
        if (r318 == null) goto L13;
        r114.put("action_bar_key", r318);     // Catch: JSONException -> L5
    L13:
        if (r110 == null) goto L15;
        r114.put("bot_id", r110.longValue());     // Catch: JSONException -> L5
    L15:
        if (r111 == null) goto L17;
        r114.put("chat_type", r111);     // Catch: JSONException -> L5
    L17:
        if (r112 == null) goto L19;
        r114.put("conversation_id", r112.longValue());     // Catch: JSONException -> L5
    L19:
        if (r113 == null) goto L21;
        r114.put("current_page", r113);     // Catch: JSONException -> L5
    L21:
        r114.put("enter_chat_method", r210);     // Catch: JSONException -> L5
        r114.put("group_type", BridgePrivilege.PRIVATE);     // Catch: JSONException -> L5
        if (r211 == null) goto L24;
        r114.put(MusicAppletPage.KEY_MESSAGE_ID, r211);     // Catch: JSONException -> L5
    L24:
        if (r212 == null) goto L26;
        r114.put("previous_page", r212);     // Catch: JSONException -> L5
    L26:
        if (r213 == null) goto L28;
        r114.put("prompt_position", r213.longValue());     // Catch: JSONException -> L5
    L28:
        if (r214 == null) goto L31;
        r114.put("suggested_type", r214);     // Catch: JSONException -> L5
    L31:
        if (TextUtils.isEmpty(r215) == true) goto L34;
        r114.put("request_id", r215);     // Catch: JSONException -> L5
    L34:
        if (TextUtils.isEmpty(r216) == true) goto L37;
        r114.put("rs_request_id", r216);     // Catch: JSONException -> L5
    L37:
        if (TextUtils.isEmpty(r217) == true) goto L40;
        r114.put("recommend_botid", r217);     // Catch: JSONException -> L5
    L40:
        if (TextUtils.isEmpty(r218) == true) goto L43;
        r114.put("recommend_bot_1sttype", r218);     // Catch: JSONException -> L5
    L43:
        if (TextUtils.isEmpty(r219) == true) goto L46;
        r114.put("recommend_bot_2ndtype", r219);     // Catch: JSONException -> L5
    L46:
        if (TextUtils.isEmpty(r310) == true) goto L48;
        r114.put("recommend_bot_3rdtype", r310);     // Catch: JSONException -> L5
    L48:
        if (r311 == null) goto L50;
        r114.put("show_from", r311);     // Catch: JSONException -> L5
    L50:
        if (r312 == null) goto L52;
        r114.put("action_name", r312);     // Catch: JSONException -> L5
    L52:
        r114.put("section_id", r313);     // Catch: JSONException -> L5
        if (r314 == null) goto L55;
        r114.put("item_id", r314);     // Catch: JSONException -> L5
    L55:
        if (r319 == null) goto L58;
        r114.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, r319);     // Catch: JSONException -> L5
    L58:
        if (r410 == null) goto L61;
        r114.put("agent_id", r410);     // Catch: JSONException -> L5
    L61:
        if (Intrinsics.areEqual(r411, Boolean.TRUE) == false) goto L63;
        String r100 = "1";
    L64:
        r114.put("is_stream", r100);     // Catch: JSONException -> L5
    L67:
        TrackParams r101 = new TrackParams().merge(r114);
        by7.a r102 = new by7.a("show_suggested_prompt_single_question");
        r102.f21463a.merge(r101);
        r102.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("ShowEventHelper", "error in ShowEventHelper showSuggestedPromptSingleQuestion " + e.getLocalizedMessage());
        goto L67
    L63:
        r100 = "0";
        goto L64
    L69:
        r114.put("suggest_action_type", r315);     // Catch: JSONException -> L5
        goto L7
    }

    public static void f(Long r310, String r311, Long r312, String r313, String r314, String r315, String r316, String r317, String r318, String r410, Long r411, Long r412, String r413, String r414, String r415, String r416, Integer r417, String r418, String r419, String r510, String r511, Integer r512, String r513, String r514, String r515, String r516, String r517, String r518, int r519, String r610, String r611, JSONObject r612, int r613, int r614) {
        if ((r613 & 2) == 0) goto L5;
        Long r100 = null;
    L7:
        if ((r613 & 4) == 0) goto L9;
        Object r101 = null;
    L11:
        if ((r613 & 8) == 0) goto L13;
        Long r102 = null;
    L15:
        if ((r613 & 16) == 0) goto L17;
        Object r103 = null;
    L19:
        if ((r613 & 128) == 0) goto L21;
        Object r104 = null;
    L23:
        if ((r613 & 256) == 0) goto L25;
        Object r105 = null;
    L27:
        if ((r613 & 512) == 0) goto L29;
        Object r106 = null;
    L31:
        if ((r613 & 1024) == 0) goto L33;
        Object r107 = null;
    L35:
        if ((r613 & 2048) == 0) goto L37;
        Object r110 = null;
    L39:
        if ((r613 & 4096) == 0) goto L41;
        Object r111 = null;
    L43:
        if ((r613 & 16384) == 0) goto L45;
        Long r112 = null;
    L47:
        if ((32768 & r613) == 0) goto L49;
        Long r113 = null;
    L51:
        if ((65536 & r613) == 0) goto L53;
        Object r114 = null;
    L55:
        if ((131072 & r613) == 0) goto L57;
        Object r115 = null;
    L59:
        if ((r613 & 262144) == 0) goto L61;
        Object r108 = null;
    L63:
        if ((r613 & 524288) == 0) goto L65;
        Object r116 = null;
    L67:
        if ((r613 & 1048576) == 0) goto L69;
        Integer r117 = null;
    L71:
        if ((r613 & 2097152) == 0) goto L73;
        Object r210 = null;
    L75:
        if ((r613 & 8388608) == 0) goto L77;
        Object r211 = null;
    L79:
        if ((r613 & 16777216) == 0) goto L81;
        Object r212 = null;
    L83:
        if ((r613 & 33554432) == 0) goto L85;
        Object r213 = null;
    L87:
        if ((r613 & 67108864) == 0) goto L89;
        Integer r118 = null;
    L90:
        Object r319 = r108;
        if ((r613 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L93;
        Object r109 = null;
    L94:
        Object r320 = r109;
        if ((r613 & 268435456) == 0) goto L97;
        Object r119 = null;
    L99:
        if ((r613 & 536870912) == 0) goto L101;
        Object r214 = null;
    L103:
        if ((r613 & 1073741824) == 0) goto L105;
        Object r215 = null;
    L107:
        if ((r613 & Integer.MIN_VALUE) == 0) goto L109;
        Object r120 = null;
    L111:
        if ((r614 & 1) == 0) goto L113;
        Object r216 = null;
    L115:
        if ((r614 & 2) == 0) goto L117;
        int r217 = 0;
    L119:
        if ((r614 & 4) == 0) goto L121;
        Object r218 = null;
    L123:
        if ((r614 & 8) == 0) goto L125;
        Object r321 = null;
    L127:
        if ((r614 & 16) == 0) goto L129;
        JSONObject r121 = new JSONObject();
    L130:
        Object r322 = r120;
        Intrinsics.checkNotNullParameter(r121, "params");
        if (r110 != null) goto L209;
    L135:
        if (r100 == null) goto L138;
        r121.put("bot_id", r100.longValue());     // Catch: JSONException -> L133
    L138:
        if (r101 == null) goto L140;
        r121.put("chat_type", r101);     // Catch: JSONException -> L133
    L140:
        if (r102 == null) goto L142;
        r121.put("conversation_id", r102.longValue());     // Catch: JSONException -> L133
    L142:
        if (r103 == null) goto L144;
        r121.put("current_page", r103);     // Catch: JSONException -> L133
    L144:
        if (r104 == null) goto L146;
        r121.put(MusicAppletPage.KEY_MESSAGE_ID, r104);     // Catch: JSONException -> L133
    L146:
        if (r105 == null) goto L148;
        r121.put("onboarding_content_source", r105);     // Catch: JSONException -> L133
    L148:
        if (r106 == null) goto L150;
        r121.put("onboarding_question", r106);     // Catch: JSONException -> L133
    L150:
        if (r107 == null) goto L152;
        r121.put("onboarding_type", r107);     // Catch: JSONException -> L133
    L152:
        if (r111 == null) goto L154;
        r121.put("previous_page", r111);     // Catch: JSONException -> L133
    L154:
        if (r112 == null) goto L156;
        r121.put("prompt_position", r112.longValue());     // Catch: JSONException -> L133
    L156:
        if (r113 == null) goto L158;
        r121.put("prompt_position_row", r113.longValue());     // Catch: JSONException -> L133
    L158:
        if (r114 == 0) goto L160;
        r121.put("prompt_type", r114);     // Catch: JSONException -> L133
    L160:
        if (r115 == 0) goto L162;
        r121.put("prompt_subtype", r115);     // Catch: JSONException -> L133
    L162:
        if (r119 == 0) goto L164;
        r121.put("prompt_from", r119);     // Catch: JSONException -> L133
    L164:
        if (r320 == null) goto L166;
        r121.put("scheme", r320);     // Catch: JSONException -> L133
    L166:
        if (r319 == null) goto L168;
        r121.put("url", r319);     // Catch: JSONException -> L133
    L168:
        Object r122 = r116;
        if (r122 == null) goto L171;
        r121.put("title", r122);     // Catch: JSONException -> L133
    L171:
        if (r117 == null) goto L173;
        r121.put("is_new_fuction", r117.intValue());     // Catch: JSONException -> L133
    L173:
        Object r123 = r210;
        if (r123 == null) goto L176;
        r121.put("reco_request_id", r123);     // Catch: JSONException -> L133
    L176:
        Object r124 = r211;
        if (r124 == null) goto L179;
        r121.put("item_id", r124);     // Catch: JSONException -> L133
    L179:
        Object r125 = r214;
        if (r125 == null) goto L182;
        r121.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r125);     // Catch: JSONException -> L133
    L182:
        Object r126 = r212;
        if (r126 == null) goto L185;
        r121.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, r126);     // Catch: JSONException -> L133
    L185:
        Object r127 = r213;
        if (r127 == null) goto L188;
        r121.put("section_id", r127);     // Catch: JSONException -> L133
    L188:
        Object r128 = r215;
        if (r128 == null) goto L191;
        r121.put("visual_size", r128);     // Catch: JSONException -> L133
    L191:
        if (r322 == null) goto L193;
        r121.put(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID, r322);     // Catch: JSONException -> L133
    L193:
        Object r129 = r216;
        if (r129 == null) goto L196;
        r121.put("tag_code", r129);     // Catch: JSONException -> L133
    L196:
        if (r118 == null) goto L198;
        r121.put("type", r118.intValue());     // Catch: JSONException -> L133
    L198:
        Object r130 = r218;
        if (r130 == null) goto L201;
        r121.put("template_version", r130);     // Catch: JSONException -> L133
    L201:
        Object r131 = r321;
        if (r131 == null) goto L204;
        r121.put("lottery_status", r131);     // Catch: JSONException -> L133
    L204:
        r121.put("is_from_api", r217);     // Catch: JSONException -> L133
    L207:
        TrackParams r132 = new TrackParams().merge(r121);
        by7.a r133 = new by7.a("show_onboarding_card_single_question");
        r133.f21463a.merge(r132);
        r133.b();
        return;
    L133:
        e = move-exception;
        FLogger.f375446a.e("ShowEventHelper", "error in ShowEventHelper showOnboardingCardSingleQuestion " + e.getLocalizedMessage());
        goto L207
    L209:
        r121.put("onboarding_action_type", r110);     // Catch: JSONException -> L133
        goto L135
    L129:
        r121 = r612;
        goto L130
    L125:
        r321 = r611;
        goto L127
    L121:
        r218 = r610;
        goto L123
    L117:
        r217 = r519;
        goto L119
    L113:
        r216 = r518;
        goto L115
    L109:
        r120 = r517;
        goto L111
    L105:
        r215 = r516;
        goto L107
    L101:
        r214 = r515;
        goto L103
    L97:
        r119 = r514;
        goto L99
    L93:
        r109 = r513;
        goto L94
    L89:
        r118 = r512;
        goto L90
    L85:
        r213 = r511;
        goto L87
    L81:
        r212 = r510;
        goto L83
    L77:
        r211 = r419;
        goto L79
    L73:
        r210 = r418;
        goto L75
    L69:
        r117 = r417;
        goto L71
    L65:
        r116 = r416;
        goto L67
    L61:
        r108 = r415;
        goto L63
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
}
