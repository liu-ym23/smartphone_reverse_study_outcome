package tx9;

import android.text.TextUtils;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ec.base.api.ai.conversation.ConversationConstants;
import com.bytedance.android.livehostapi.business.depend.share.ShareConstants;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.bytedance.sdk.bridge.annotation.BridgePrivilege;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.bot.CommonSettingFragment;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.livetutor.impl.home.viewmodel.LiveTutorHomeVM;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.tencent.open.SocialConstants;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class c0 {
    public static void r() {
        JSONObject r100 = new JSONObject();
        Intrinsics.checkNotNullParameter("setting", "currentPage");
        Intrinsics.checkNotNullParameter(r100, "params");
        r100.put("current_page", "setting");
        TrackParams r101 = new TrackParams().merge(r100);
        by7.a r102 = new by7.a("click_model_service_auth_button");
        r102.f21463a.merge(r101);
        r102.b();
    }

    public static void A(String r100) {
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r101, "params");
        r101.put(SocialConstants.PARAM_APP_DESC, r100);
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("click_send_error_dev");
        r103.f21463a.merge(r102);
        r103.b();
    }

    public static void E(String r100) {
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter(r101, "params");
        if (r100 == null) goto L5;
        r101.put("permission_type", r100);
    L5:
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("click_system_permission");
        r103.f21463a.merge(r102);
        r103.b();
    }

    public static void k(String r100) {
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter(r101, "params");
        r101.put("current_page", "chat_list");     // Catch: JSONException -> L7
        if (r100 == null) goto L9;
        r101.put("enter_method", r100);     // Catch: JSONException -> L7
    L9:
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("click_create_group_chat");
        r103.f21463a.merge(r102);
        r103.b();
        return;
    L7:
        e = move-exception;
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper clickCreateGroupChat " + e.getLocalizedMessage());
        goto L9
    }

    public static void t(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        TrackParams r101 = new TrackParams().merge(r100);
        by7.a r102 = new by7.a("chat_list_not_bot_cell_click");
        r102.f21463a.merge(r101);
        r102.b();
    }

    public static void v(String r100) {
        JSONObject r101 = new JSONObject();
        Intrinsics.checkNotNullParameter(r101, "params");
        r101.put("to_status", r100);     // Catch: JSONException -> L5
    L7:
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a("click_personal_recommendation_switch");
        r103.f21463a.merge(r102);
        r103.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper clickPersonalRecommendationSwitch " + e.getLocalizedMessage());
        goto L7
    }

    public static void F(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "params");
        if (r100 == null) goto L5;
        r102.put("permission_type", r100);
    L5:
        r102.put("click_from", r101);
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("system_permission_confirm_popup_click");
        r104.f21463a.merge(r103);
        r104.b();
    }

    public static void a(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "params");
        r102.put("current_page", r100);     // Catch: JSONException -> L7
        if (r101 == null) goto L9;
        r102.put("enter_method", r101);     // Catch: JSONException -> L7
    L9:
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("click_add_friend");
        r104.f21463a.merge(r103);
        r104.b();
        return;
    L7:
        e = move-exception;
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper clickAddFriend " + e.getLocalizedMessage());
        goto L9
    }

    public static void b(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, "toStatus");
        Intrinsics.checkNotNullParameter(r102, "params");
        r102.put("to_status", r100);
        r102.put("click_from", r101);
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("click_model_service_auth_confirm");
        r104.f21463a.merge(r103);
        r104.b();
    }

    public static void c(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, "fromStatus");
        Intrinsics.checkNotNullParameter(r101, "toStatus");
        Intrinsics.checkNotNullParameter(r102, "params");
        r102.put("from_status", r100);
        r102.put("to_status", r101);
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("click_model_service_auth_status");
        r104.f21463a.merge(r103);
        r104.b();
    }

    public static void s(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, "permissionType");
        Intrinsics.checkNotNullParameter(r101, "toStatus");
        Intrinsics.checkNotNullParameter(r102, "params");
        r102.put("permission_type", r100);
        r102.put("to_status", r101);
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("click_model_service_permission");
        r104.f21463a.merge(r103);
        r104.b();
    }

    public static void y(String r100, TraceFragment r101) {
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "params");
        r102.put("enter_method", r100);     // Catch: JSONException -> L5
    L7:
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("click_search_button");
        if (r101 == null) goto L10;
        r104.f21464b = r101;
    L10:
        r104.f21463a.merge(r103);
        r104.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper clickSearchButton " + e.getLocalizedMessage());
        goto L7
    }

    public static void B(JSONObject r100, CommonSettingFragment r101, String r102, int r103) {
        if ((32768 & r103) == 0) goto L6;
        r100 = new JSONObject();
    L6:
        if ((65536 & r103) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 131072) == 0) goto L11;
        r102 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, "params");
        if (r102 == null) goto L15;
        r100.put("is_call_bot", r102);     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper clickShareBot " + e.getLocalizedMessage());
    L23:
        TrackParams r104 = new TrackParams().merge(r100);
        by7.a r105 = new by7.a("click_share_bot");
        if (r101 == null) goto L26;
        r105.f21464b = r101;
    L26:
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L15:
        if (com.larus.utils.o0.d(null) == false) goto L18;
        r100.put("user_case_item_id", null);     // Catch: JSONException -> L21
    L18:
        if (com.larus.utils.o0.d(null) == false) goto L23;
        r100.put("user_case_reco_request_id", null);     // Catch: JSONException -> L21
        goto L23
    }

    public static void p(String r100, String r101, String r102, String r103) {
        JSONObject r104 = new JSONObject();
        Intrinsics.checkNotNullParameter(r104, "params");
        r104.put("enter_method", r100);     // Catch: JSONException -> L8
        if (r101 == null) goto L6;
        r104.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r101);     // Catch: JSONException -> L8
    L6:
        r104.put("tab_id", r102);     // Catch: JSONException -> L8
        r104.put("tab_type", r103);     // Catch: JSONException -> L8
    L10:
        TrackParams r105 = new TrackParams().merge(r104);
        by7.a r106 = new by7.a("click_discover_page_tab");
        r106.f21463a.merge(r105);
        r106.b();
        return;
    L8:
        e = move-exception;
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper clickDiscoverPageTab " + e.getLocalizedMessage());
        goto L10
    }

    public static void w(String r100, JSONObject r101, by7.e r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = new JSONObject();
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        Intrinsics.checkNotNullParameter(r101, "params");
        if (r100 != null) goto L22;
    L17:
        TrackParams r104 = new TrackParams().merge(r101);
        by7.a r105 = new by7.a("click_plus");
        if (r102 == null) goto L20;
        r105.f21464b = r102;
    L20:
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L22:
        r101.put("to_status", r100);     // Catch: JSONException -> L15
    L15:
        e = move-exception;
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper clickPlus " + e.getLocalizedMessage());
        goto L17
    }

    public static void q(String r100, String r101, String r102, String r103, String r104) {
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r105, "params");
        if (r100 != null) goto L18;
    L7:
        if (r101 == null) goto L9;
        r105.put("conversation_id", r101);     // Catch: JSONException -> L5
    L9:
        if (r102 == null) goto L11;
        r105.put("current_page", r102);     // Catch: JSONException -> L5
    L11:
        if (r103 == null) goto L13;
        r105.put("previous_page", r103);     // Catch: JSONException -> L5
    L13:
        r105.put("button_name", r104);     // Catch: JSONException -> L5
    L16:
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a("click_memory_welcome_window");
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper mobClickMemoryWelcomeWindow " + e.getLocalizedMessage());
        goto L16
    L18:
        r105.put("bot_id", r100);     // Catch: JSONException -> L5
        goto L7
    }

    public static void z(String r100, String r101, String r102, String r103, int r104) {
        JSONObject r105 = null;
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r104 & 16) == 0) goto L17;
        r105 = new JSONObject();
    L17:
        Intrinsics.checkNotNullParameter(r105, "params");
        if (r100 != null) goto L32;
    L22:
        if (r101 == null) goto L24;
        r105.put("url", r101);     // Catch: JSONException -> L20
    L24:
        if (r102 == null) goto L26;
        r105.put("card_source", r102);     // Catch: JSONException -> L20
    L26:
        if (r103 == null) goto L30;
        r105.put("baike_id", r103);     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper clickSearchCard " + e.getLocalizedMessage());
    L30:
        TrackParams r106 = new TrackParams().merge(r105);
        by7.a r107 = new by7.a("click_search_card");
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L32:
        r105.put("message_type", r100);     // Catch: JSONException -> L20
        goto L22
    }

    public static void d(String r100, String r101, String r102, JSONObject r103, by7.e r104, int r105) {
        if ((r105 & 128) == 0) goto L6;
        r100 = null;
    L6:
        if ((r105 & 256) == 0) goto L9;
        r101 = null;
    L9:
        if ((r105 & 16384) == 0) goto L12;
        r102 = null;
    L12:
        if ((32768 & r105) == 0) goto L15;
        r103 = new JSONObject();
    L15:
        if ((r105 & 65536) == 0) goto L17;
        r104 = null;
    L17:
        Intrinsics.checkNotNullParameter(r103, "params");
        if (r100 != null) goto L33;
    L22:
        if (r101 == null) goto L24;
        r103.put("req_id", r101);     // Catch: JSONException -> L20
    L24:
        if (r102 == null) goto L28;
        r103.put("is_call_bot", r102);     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper clickBotCreatorInfo " + e.getLocalizedMessage());
    L28:
        TrackParams r106 = new TrackParams().merge(r103);
        by7.a r107 = new by7.a("click_bot_creator_info");
        if (r104 == null) goto L31;
        r107.f21464b = r104;
    L31:
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L33:
        r103.put("recommend_from", r100);     // Catch: JSONException -> L20
        goto L22
    }

    public static void f(String r100, String r101, String r102, String r103, by7.e r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r101 = null;
    L9:
        if ((r105 & 16) == 0) goto L12;
        r102 = null;
    L12:
        if ((r105 & 32) == 0) goto L15;
        r103 = null;
    L15:
        if ((r105 & 64) == 0) goto L17;
        JSONObject r106 = new JSONObject();
    L19:
        if ((r105 & 128) == 0) goto L21;
        r104 = null;
    L21:
        Intrinsics.checkNotNullParameter(r106, "params");
        if (r100 != null) goto L39;
    L26:
        if (r101 == null) goto L28;
        r106.put("enter_from", r101);     // Catch: JSONException -> L24
    L28:
        if (r103 == null) goto L30;
        r106.put("click_from", r103);     // Catch: JSONException -> L24
    L30:
        if (r102 == null) goto L34;
        r106.put("create_way", r102);     // Catch: JSONException -> L24
    L24:
        e = move-exception;
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper clickChangeVoice " + e.getLocalizedMessage());
    L34:
        TrackParams r107 = new TrackParams().merge(r106);
        by7.a r108 = new by7.a("click_change_voice");
        if (r104 == null) goto L37;
        r108.f21464b = r104;
    L37:
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L39:
        r106.put("bot_id", r100);     // Catch: JSONException -> L24
        goto L26
    L17:
        r106 = null;
        goto L19
    }

    public static void o(String r100, String r101, String r102, Boolean r103, String r104, int r105) {
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
        if (r100 != null) goto L41;
    L25:
        if (r101 == null) goto L27;
        r106.put("click_from", r101);     // Catch: JSONException -> L23
    L27:
        if (r102 == null) goto L29;
        r106.put("current_page", r102);     // Catch: JSONException -> L23
    L29:
        if (r103 != null) goto L31;
    L35:
        if (r104 == null) goto L39;
        r106.put(ShareConstants.KEY_PANEL_TYPE, r104);     // Catch: JSONException -> L23
    L23:
        e = move-exception;
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper mobClickCreatePanel " + e.getLocalizedMessage());
    L39:
        TrackParams r107 = new TrackParams().merge(r106);
        by7.a r108 = new by7.a("click_create_panel");
        r108.f21463a.merge(r107);
        r108.b();
        return;
    L31:
        if (r103.booleanValue() == false) goto L33;
        String r109 = "1";
    L34:
        r106.put("is_function_available", r109);     // Catch: JSONException -> L23
        goto L35
    L33:
        r109 = "0";
        goto L34
    L41:
        r106.put(BdpAppEventConstant.PARAMS_CLICK_POSITION, r100);     // Catch: JSONException -> L23
        goto L25
    }

    public static final void m(String r100, String r101, String r102, String r103, String r104, JSONObject r105, by7.e r106) {
        Intrinsics.checkNotNullParameter(r105, "params");
        if (r100 != null) goto L23;
    L7:
        if (r101 == null) goto L9;
        r105.put("current_page", r101);     // Catch: JSONException -> L5
    L9:
        if (r102 == null) goto L11;
        r105.put("enter_from", r102);     // Catch: JSONException -> L5
    L11:
        if (r103 == null) goto L13;
        r105.put("previous_page", r103);     // Catch: JSONException -> L5
    L13:
        if (r104 == null) goto L15;
        r105.put("enter_method", r104);     // Catch: JSONException -> L5
    L15:
        String r107 = b4.f547846a;     // Catch: JSONException -> L5
        String r108 = UUID.randomUUID().toString();     // Catch: JSONException -> L5
        b4.f547846a = r108;     // Catch: JSONException -> L5
        r105.put("voice_create_id", r108);     // Catch: JSONException -> L5
    L18:
        TrackParams r109 = new TrackParams().merge(r105);
        by7.a r110 = new by7.a("click_create_own_voice_button");
        if (r106 == null) goto L21;
        r110.f21464b = r106;
    L21:
        r110.f21463a.merge(r109);
        r110.b();
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper clickCreateOwnVoiceButton " + e.getLocalizedMessage());
        goto L18
    L23:
        r105.put("click_from", r100);     // Catch: JSONException -> L5
        goto L7
    }

    public static void J(String r100, String r101, String r102, Boolean r103, Boolean r104, Integer r105, String r106, int r107) {
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
        by7.a r113 = new by7.a("sp_polish_click");
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

    public static void K(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r110) {
        JSONObject r107 = new JSONObject();
        Intrinsics.checkNotNullParameter(r107, "params");
        if (r100 != null) goto L21;
    L7:
        r107.put("chat_type", r101);     // Catch: JSONException -> L5
        r107.put("current_page", r102);     // Catch: JSONException -> L5
        r107.put("click_from", DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON);     // Catch: JSONException -> L5
        if (r103 == null) goto L10;
        r107.put("conversation_id", r103);     // Catch: JSONException -> L5
    L10:
        r107.put("success", r104);     // Catch: JSONException -> L5
        if (r105 == null) goto L13;
        r107.put("from_activity_name", r105);     // Catch: JSONException -> L5
    L13:
        if (r106 == null) goto L15;
        r107.put("from_activity_module", r106);     // Catch: JSONException -> L5
    L15:
        if (r110 == null) goto L19;
        r107.put("previous_page", r110);     // Catch: JSONException -> L5
    L5:
        e = move-exception;
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper mobSubscribe " + e.getLocalizedMessage());
    L19:
        TrackParams r108 = new TrackParams().merge(r107);
        by7.a r109 = new by7.a("subscribe");
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L21:
        r107.put("bot_id", r100);     // Catch: JSONException -> L5
        goto L7
    }

    public static /* synthetic */ void n(String r100, String r101, String r102, String r103, String r104, JSONObject r105, CommonSettingFragment r106, int r107) {
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
        r105 = new JSONObject();
    L21:
        if ((r107 & 64) == 0) goto L23;
        r106 = null;
    L23:
        m(r100, r101, r102, r103, r104, r105, r106);
    }

    public static void h(String r100, String r101, String r102, String r103, String r104, String r105, JSONObject r106, TraceFragment r107, int r110) {
        if ((r110 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r110 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r110 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r110 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r110 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r110 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r110 & 64) == 0) goto L24;
        r106 = new JSONObject();
    L24:
        if ((r110 & 128) == 0) goto L26;
        r107 = null;
    L26:
        Intrinsics.checkNotNullParameter(r106, "params");
        if (r100 != null) goto L48;
    L31:
        if (r101 == null) goto L33;
        r106.put("current_page", r101);     // Catch: JSONException -> L29
    L33:
        if (r102 == null) goto L35;
        r106.put("group_type", r102);     // Catch: JSONException -> L29
    L35:
        if (r103 == null) goto L37;
        r106.put("is_immersive_background", r103);     // Catch: JSONException -> L29
    L37:
        if (r104 == null) goto L39;
        r106.put("recommend_from", r104);     // Catch: JSONException -> L29
    L39:
        if (r105 == null) goto L43;
        r106.put("req_id", r105);     // Catch: JSONException -> L29
    L29:
        e = move-exception;
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper clickClearMessageConfirm " + e.getLocalizedMessage());
    L43:
        TrackParams r108 = new TrackParams().merge(r106);
        by7.a r109 = new by7.a("click_clear_message_confirm");
        if (r107 == null) goto L46;
        r109.f21464b = r107;
    L46:
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L48:
        r106.put("bot_id", r100);     // Catch: JSONException -> L29
        goto L31
    }

    public static void I(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, by7.e r110, int r111) {
        if ((r111 & 2) == 0) goto L6;
        r100 = null;
    L6:
        if ((r111 & 4) == 0) goto L9;
        r101 = null;
    L9:
        if ((r111 & 8) == 0) goto L12;
        r102 = null;
    L12:
        if ((r111 & 16) == 0) goto L15;
        r103 = null;
    L15:
        if ((r111 & 32) == 0) goto L18;
        r104 = null;
    L18:
        if ((r111 & 64) == 0) goto L21;
        r105 = null;
    L21:
        if ((r111 & 128) == 0) goto L24;
        r106 = null;
    L24:
        if ((r111 & 256) == 0) goto L27;
        r107 = null;
    L27:
        if ((r111 & 512) == 0) goto L29;
        JSONObject r108 = new JSONObject();
    L31:
        if ((r111 & 1024) == 0) goto L33;
        r110 = null;
    L33:
        Intrinsics.checkNotNullParameter(r108, "params");
        if (r100 != null) goto L59;
    L38:
        if (r102 == null) goto L40;
        r108.put("previous_page", r102);     // Catch: JSONException -> L36
    L40:
        if (r101 == null) goto L42;
        r108.put("creation_id", r101);     // Catch: JSONException -> L36
    L42:
        if (r103 == null) goto L44;
        r108.put("create_way", r103);     // Catch: JSONException -> L36
    L44:
        if (r105 == null) goto L46;
        r108.put("type", r105);     // Catch: JSONException -> L36
    L46:
        if (r104 == null) goto L48;
        r108.put("click_from", r104);     // Catch: JSONException -> L36
    L48:
        if (r106 == null) goto L50;
        r108.put("from_activity_name", r106);     // Catch: JSONException -> L36
    L50:
        if (r107 == null) goto L54;
        r108.put("from_activity_module", r107);     // Catch: JSONException -> L36
    L36:
        e = move-exception;
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper createBotBlockWindowClick " + e.getLocalizedMessage());
    L54:
        TrackParams r109 = new TrackParams().merge(r108);
        by7.a r112 = new by7.a("create_bot_block_window_click");
        if (r110 == null) goto L57;
        r112.f21464b = r110;
    L57:
        r112.f21463a.merge(r109);
        r112.b();
        return;
    L59:
        r108.put("enter_method", r100);     // Catch: JSONException -> L36
        goto L38
    L29:
        r108 = null;
        goto L31
    }

    public static void l(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, by7.e r110, int r111) {
        if ((r111 & 2) == 0) goto L6;
        r100 = null;
    L6:
        if ((r111 & 4) == 0) goto L9;
        r101 = null;
    L9:
        if ((r111 & 8) == 0) goto L12;
        r102 = null;
    L12:
        if ((r111 & 16) == 0) goto L15;
        r103 = null;
    L15:
        if ((r111 & 32) == 0) goto L18;
        r104 = null;
    L18:
        if ((r111 & 64) == 0) goto L21;
        r105 = null;
    L21:
        if ((r111 & 128) == 0) goto L24;
        r106 = null;
    L24:
        if ((r111 & 256) == 0) goto L27;
        r107 = null;
    L27:
        if ((r111 & 512) == 0) goto L29;
        JSONObject r108 = new JSONObject();
    L31:
        if ((r111 & 1024) == 0) goto L33;
        r110 = null;
    L33:
        Intrinsics.checkNotNullParameter(r108, "params");
        if (r100 != null) goto L59;
    L38:
        if (r102 == null) goto L40;
        r108.put("enter_from", r102);     // Catch: JSONException -> L36
    L40:
        if (r103 == null) goto L42;
        r108.put("enter_method", r103);     // Catch: JSONException -> L36
    L42:
        if (r104 == null) goto L44;
        r108.put("create_way", r104);     // Catch: JSONException -> L36
    L44:
        if (r105 == null) goto L46;
        r108.put("creation_id", r105);     // Catch: JSONException -> L36
    L46:
        if (r101 == null) goto L48;
        r108.put("previous_page", r101);     // Catch: JSONException -> L36
    L48:
        if (r106 == null) goto L50;
        r108.put("from_activity_name", r106);     // Catch: JSONException -> L36
    L50:
        if (r107 == null) goto L54;
        r108.put("from_activity_module", r107);     // Catch: JSONException -> L36
    L36:
        e = move-exception;
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper clickCreateNewBot " + e.getLocalizedMessage());
    L54:
        TrackParams r109 = new TrackParams().merge(r108);
        by7.a r112 = new by7.a("click_create_new_bot");
        if (r110 == null) goto L57;
        r112.f21464b = r110;
    L57:
        r112.f21463a.merge(r109);
        r112.b();
        return;
    L59:
        r108.put("current_page", r100);     // Catch: JSONException -> L36
        goto L38
    L29:
        r108 = null;
        goto L31
    }

    public static void e(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111, String r112, JSONObject r113, by7.e r114, int r115) {
        if ((r115 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r115 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r115 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r115 & 16) == 0) goto L15;
        r103 = null;
    L15:
        if ((r115 & 32) == 0) goto L18;
        r104 = null;
    L18:
        if ((r115 & 64) == 0) goto L21;
        r105 = null;
    L21:
        if ((r115 & 128) == 0) goto L24;
        r106 = null;
    L24:
        if ((r115 & 2048) == 0) goto L27;
        r107 = null;
    L27:
        if ((r115 & 4096) == 0) goto L30;
        r110 = "0";
    L30:
        if ((32768 & r115) == 0) goto L33;
        r111 = null;
    L33:
        if ((65536 & r115) == 0) goto L36;
        r112 = null;
    L36:
        if ((131072 & r115) == 0) goto L39;
        r113 = new JSONObject();
    L39:
        if ((r115 & 262144) == 0) goto L41;
        r114 = null;
    L41:
        Intrinsics.checkNotNullParameter(r110, "isContinuousSpeak");
        Intrinsics.checkNotNullParameter(r113, "params");
        if (r100 != null) goto L72;
    L46:
        if (r101 == null) goto L48;
        r113.put("conversation_id", r101);     // Catch: JSONException -> L44
    L48:
        if (r102 == null) goto L50;
        r113.put("current_page", r102);     // Catch: JSONException -> L44
    L50:
        if (r105 == null) goto L52;
        r113.put("chat_type", r105);     // Catch: JSONException -> L44
    L52:
        if (r103 == null) goto L54;
        r113.put("enter_from", r103);     // Catch: JSONException -> L44
    L54:
        if (r104 == null) goto L56;
        r113.put("enter_method", r104);     // Catch: JSONException -> L44
    L56:
        if (r106 == null) goto L58;
        r113.put("red_dot", r106);     // Catch: JSONException -> L44
    L58:
        if (r107 == null) goto L60;
        r113.put("is_immersive_background", r107);     // Catch: JSONException -> L44
    L60:
        if (r111 == null) goto L62;
        r113.put("mic_status", r111);     // Catch: JSONException -> L44
    L62:
        if (r112 == null) goto L64;
        r113.put("camera_status", r112);     // Catch: JSONException -> L44
    L64:
        r113.put("is_continuous_speak", r110);     // Catch: JSONException -> L44
    L67:
        TrackParams r108 = new TrackParams().merge(r113);
        by7.a r109 = new by7.a("click_call");
        if (r114 == null) goto L70;
        r109.f21464b = r114;
    L70:
        r109.f21463a.merge(r108);
        r109.b();
        return;
    L44:
        e = move-exception;
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper clickCall " + e.getLocalizedMessage());
        goto L67
    L72:
        r113.put("bot_id", r100);     // Catch: JSONException -> L44
        goto L46
    }

    public static void G(String r210, String r211, String r212, Long r213, Long r214, String r215, String r216, String r217, Boolean r218, String r219, String r310, Boolean r311, Boolean r312, by7.e r313, int r314) {
        if ((r314 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r314 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r314 & 8) == 0) goto L17;
        Long r103 = null;
    L19:
        if ((r314 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r314 & 128) == 0) goto L25;
        Long r105 = null;
    L27:
        if ((r314 & 256) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r314 & 1024) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r314 & 2048) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r314 & 4096) == 0) goto L41;
        Boolean r111 = null;
    L43:
        if ((r314 & 8192) == 0) goto L45;
        String r112 = null;
    L47:
        if ((r314 & 16384) == 0) goto L49;
        String r113 = null;
    L51:
        if ((32768 & r314) == 0) goto L53;
        String r114 = null;
    L55:
        if ((65536 & r314) == 0) goto L57;
        Boolean r115 = null;
    L59:
        if ((r314 & 131072) == 0) goto L61;
        Boolean r116 = null;
    L63:
        if ((r314 & 262144) == 0) goto L65;
        JSONObject r108 = new JSONObject();
    L67:
        if ((r314 & 524288) == 0) goto L69;
        by7.e r117 = null;
    L70:
        Intrinsics.checkNotNullParameter(r108, "params");
        if (r100 != null) goto L123;
    L75:
        if (r101 == null) goto L77;
        r108.put("chat_type", r101);     // Catch: JSONException -> L73
    L77:
        if (r102 == null) goto L79;
        r108.put("click_from", r102);     // Catch: JSONException -> L73
    L79:
        if (r103 == null) goto L81;
        r108.put("conversation_id", r103.longValue());     // Catch: JSONException -> L73
    L81:
        if (r104 == null) goto L83;
        r108.put("current_page", r104);     // Catch: JSONException -> L73
    L83:
        if (r105 == null) goto L85;
        r108.put("is_onboarding", r105.longValue());     // Catch: JSONException -> L73
    L85:
        if (r106 == null) goto L87;
        r108.put(MusicAppletPage.KEY_MESSAGE_ID, r106);     // Catch: JSONException -> L73
    L87:
        if (r107 == null) goto L89;
        r108.put("to_status", r107);     // Catch: JSONException -> L73
    L89:
        if (r110 == null) goto L91;
        r108.put("is_tts_open", r110);     // Catch: JSONException -> L73
    L91:
        String r109 = "1";
        if (r111 != null) goto L94;
    L98:
        if (r112 == null) goto L100;
        r108.put("tts_switch_enter_method", r112);     // Catch: JSONException -> L73
    L100:
        if (r113 == null) goto L102;
        r108.put("user_type", r113);     // Catch: JSONException -> L73
    L102:
        if (r114 == null) goto L104;
        r108.put("click_module", r114);     // Catch: JSONException -> L73
    L104:
        if (r115 != null) goto L106;
    L110:
        if (r116 != null) goto L112;
    L118:
        TrackParams r118 = new TrackParams().merge(r108);
        by7.a r119 = new by7.a("click_tts_play_button");
        by7.e r120 = r117;
        if (r120 == null) goto L121;
        r119.f21464b = r120;
    L121:
        r119.f21463a.merge(r118);
        r119.b();
        return;
    L112:
        if (r116.booleanValue() == true) goto L115;
        r109 = "0";
    L115:
        r108.put("is_simultaneous_interpretation", r109);     // Catch: JSONException -> L73
    L73:
        e = move-exception;
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper clickTtsPlayButton " + e.getLocalizedMessage());
        goto L118
    L106:
        if (r115.booleanValue() == false) goto L108;
        Object r121 = "1";
    L109:
        r108.put("is_thinking_generating", r121);     // Catch: JSONException -> L73
        goto L110
    L108:
        r121 = "0";
        goto L109
    L94:
        if (r111.booleanValue() == false) goto L96;
        Object r122 = "1";
    L97:
        r108.put("is_message_generating", r122);     // Catch: JSONException -> L73
        goto L98
    L96:
        r122 = "0";
        goto L97
    L123:
        r108.put("bot_id", r100);     // Catch: JSONException -> L73
        goto L75
    L69:
        r117 = r313;
        goto L70
    L65:
        r108 = null;
        goto L67
    L61:
        r116 = r312;
        goto L63
    L57:
        r115 = r311;
        goto L59
    L53:
        r114 = r310;
        goto L55
    L49:
        r113 = "bot";
        goto L51
    L45:
        r112 = r219;
        goto L47
    L41:
        r111 = r218;
        goto L43
    L37:
        r110 = r217;
        goto L39
    L33:
        r107 = r216;
        goto L35
    L29:
        r106 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = "chat";
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

    public static void g(String r110, String r210, String r211, JSONObject r212, by7.e r213, String r214, String r215, Integer r216, String r217, String r218, String r219, String r310, String r311, Boolean r312, String r313, String r314, String r315, int r316) {
        if ((r316 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r316 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r316 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r316 & 8) == 0) goto L17;
        JSONObject r103 = new JSONObject();
    L19:
        if ((r316 & 16) == 0) goto L21;
        by7.e r104 = null;
    L23:
        if ((r316 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r316 & 128) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r316 & 256) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r316 & 512) == 0) goto L37;
        Integer r111 = null;
    L39:
        if ((r316 & 1024) == 0) goto L41;
        String r112 = null;
    L43:
        if ((r316 & 2048) == 0) goto L45;
        String r113 = null;
    L47:
        if ((r316 & 4096) == 0) goto L49;
        String r114 = null;
    L51:
        if ((r316 & 8192) == 0) goto L53;
        String r115 = null;
    L55:
        if ((r316 & 16384) == 0) goto L57;
        String r116 = null;
    L59:
        if ((r316 & 32768) == 0) goto L61;
        Boolean r117 = null;
    L63:
        if ((r316 & 65536) == 0) goto L65;
        String r108 = null;
    L67:
        if ((r316 & 131072) == 0) goto L69;
        String r109 = "text";
    L71:
        if ((r316 & 262144) == 0) goto L73;
        String r220 = null;
    L74:
        Intrinsics.checkNotNullParameter(r103, "params");
        if (r109 != null) goto L120;
    L79:
        if (r100 == null) goto L81;
        r103.put("bot_id", r100);     // Catch: JSONException -> L77
    L81:
        if (r101 == null) goto L83;
        r103.put("conversation_id", r101);     // Catch: JSONException -> L77
    L83:
        if (r102 == null) goto L85;
        r103.put(MusicAppletPage.KEY_MESSAGE_ID, r102);     // Catch: JSONException -> L77
    L85:
        if (r105 == null) goto L87;
        r103.put("current_page", r105);     // Catch: JSONException -> L77
    L87:
        if (r111 == null) goto L89;
        r103.put("is_onboarding", r111.intValue());     // Catch: JSONException -> L77
    L89:
        if (r112 == null) goto L91;
        r103.put("click_from", r112);     // Catch: JSONException -> L77
    L91:
        if (r107 == null) goto L93;
        r103.put("chat_type", r107);     // Catch: JSONException -> L77
    L93:
        if (r106 == null) goto L95;
        r103.put("group_type", r106);     // Catch: JSONException -> L77
    L95:
        if (r113 == null) goto L97;
        r103.put("user_type", r113);     // Catch: JSONException -> L77
    L97:
        if (r114 == null) goto L99;
        r103.put("scene", r114);     // Catch: JSONException -> L77
    L99:
        if (r115 == null) goto L101;
        r103.put("click_module", r115);     // Catch: JSONException -> L77
    L101:
        if (r116 == null) goto L103;
        r103.put("agent_id", r116);     // Catch: JSONException -> L77
    L103:
        if (r117 != null) goto L105;
    L109:
        if (r108 == null) goto L111;
        r103.put("edu_skill", r108);     // Catch: JSONException -> L77
    L111:
        if (r220 == null) goto L115;
        r103.put("select_range", r220);     // Catch: JSONException -> L77
    L77:
        e = move-exception;
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper clickCiteButton " + e.getLocalizedMessage());
    L115:
        TrackParams r118 = new TrackParams().merge(r103);
        by7.a r119 = new by7.a("click_cite_button");
        if (r104 == 0) goto L118;
        r119.f21464b = r104;
    L118:
        r119.f21463a.merge(r118);
        r119.b();
        return;
    L105:
        if (r117.booleanValue() == false) goto L107;
        String r120 = "1";
    L108:
        r103.put("is_thinking_generating", r120);     // Catch: JSONException -> L77
        goto L109
    L107:
        r120 = "0";
        goto L108
    L120:
        r103.put("content_type", r109);     // Catch: JSONException -> L77
        goto L79
    L73:
        r220 = r315;
        goto L74
    L69:
        r109 = r314;
        goto L71
    L65:
        r108 = r313;
        goto L67
    L61:
        r117 = r312;
        goto L63
    L57:
        r116 = r311;
        goto L59
    L53:
        r115 = r310;
        goto L55
    L49:
        r114 = r219;
        goto L51
    L45:
        r113 = r218;
        goto L47
    L41:
        r112 = r217;
        goto L43
    L37:
        r111 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = BridgePrivilege.PRIVATE;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public static void x(String r110, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, Boolean r219, String r310, String r311, String r312, String r313, JSONObject r314, by7.e r315, int r316) {
        if ((r316 & 1) == 0) goto L5;
        Object r100 = null;
    L7:
        if ((r316 & 2) == 0) goto L9;
        Object r101 = null;
    L11:
        if ((r316 & 4) == 0) goto L13;
        Object r102 = null;
    L15:
        if ((r316 & 8) == 0) goto L17;
        Object r103 = null;
    L19:
        if ((r316 & 16) == 0) goto L21;
        Object r104 = null;
    L23:
        if ((r316 & 64) == 0) goto L25;
        Object r105 = null;
    L27:
        if ((r316 & 128) == 0) goto L29;
        Object r106 = null;
    L31:
        if ((r316 & 4096) == 0) goto L33;
        Object r107 = null;
    L35:
        if ((524288 & r316) == 0) goto L37;
        Object r111 = null;
    L39:
        if ((1048576 & r316) == 0) goto L41;
        Object r112 = null;
    L43:
        if ((2097152 & r316) == 0) goto L45;
        Boolean r113 = null;
    L47:
        if ((4194304 & r316) == 0) goto L49;
        Object r114 = null;
    L51:
        if ((8388608 & r316) == 0) goto L53;
        Object r115 = null;
    L55:
        if ((16777216 & r316) == 0) goto L57;
        Object r116 = null;
    L59:
        if ((r316 & 33554432) == 0) goto L61;
        Object r108 = null;
    L63:
        if ((r316 & 67108864) == 0) goto L65;
        JSONObject r117 = new JSONObject();
    L67:
        if ((r316 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L69;
        by7.e r118 = null;
    L70:
        Intrinsics.checkNotNullParameter(r117, "params");
        r117.putOpt("creation_task_id", r108);     // Catch: JSONException -> L101
        if (r113 == null) goto L74;
        String r109 = l3.f(r113);     // Catch: JSONException -> L101
    L75:
        r117.putOpt("is_deep_thinking", r109);     // Catch: JSONException -> L101
        r117.putOpt("ai_create_show_mode", r114);     // Catch: JSONException -> L101
        if (r100 == null) goto L78;
        r117.put("bot_id", r100);     // Catch: JSONException -> L101
    L78:
        if (r101 == null) goto L80;
        r117.put("chat_type", r101);     // Catch: JSONException -> L101
    L80:
        if (r102 == null) goto L82;
        r117.put("click_from", r102);     // Catch: JSONException -> L101
    L82:
        if (r103 == null) goto L84;
        r117.put("conversation_id", r103);     // Catch: JSONException -> L101
    L84:
        if (r104 == null) goto L86;
        r117.put("current_page", r104);     // Catch: JSONException -> L101
    L86:
        if (r105 == null) goto L88;
        r117.put(MusicAppletPage.KEY_MESSAGE_ID, r105);     // Catch: JSONException -> L101
    L88:
        if (r106 == null) goto L90;
        r117.put("message_type", r106);     // Catch: JSONException -> L101
    L90:
        if (r107 == null) goto L92;
        r117.put("recommend_from", r107);     // Catch: JSONException -> L101
    L92:
        if (r112 == null) goto L94;
        r117.put("is_call_bot", r112);     // Catch: JSONException -> L101
    L94:
        if (r111 == null) goto L96;
        r117.put("message_is_interrupted", r111);     // Catch: JSONException -> L101
    L96:
        if (r115 == null) goto L98;
        r117.put("user_case_item_id", r115);     // Catch: JSONException -> L101
    L98:
        if (r116 == 0) goto L103;
        r117.put("user_case_reco_request_id", r116);     // Catch: JSONException -> L101
    L103:
        TrackParams r119 = new TrackParams().merge(r117);
        by7.a r120 = new by7.a("click_regenerate");
        by7.e r121 = r118;
        if (r121 == null) goto L106;
        r120.f21464b = r121;
    L106:
        r120.f21463a.merge(r119);
        r120.b();
        return;
    L74:
        r109 = null;
    L101:
        e = move-exception;
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper clickRegenerate " + e.getLocalizedMessage());
        goto L103
    L69:
        r118 = r315;
        goto L70
    L65:
        r117 = r314;
        goto L67
    L61:
        r108 = r313;
        goto L63
    L57:
        r116 = r312;
        goto L59
    L53:
        r115 = r311;
        goto L55
    L49:
        r114 = r310;
        goto L51
    L45:
        r113 = r219;
        goto L47
    L41:
        r112 = r218;
        goto L43
    L37:
        r111 = r217;
        goto L39
    L33:
        r107 = r216;
        goto L35
    L29:
        r106 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public static final void C(String r110, String r111, String r112, String r113, String r210, Long r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, String r314, JSONObject r315, by7.e r316) {
        Intrinsics.checkNotNullParameter(r315, "params");
        if (r217 != null) goto L47;
    L5:
        if (r310 == null) goto L7;
        r315.put("task_id", r310);     // Catch: JSONException -> L33
    L7:
        r315.put("soft_link_type", r216);     // Catch: JSONException -> L33
        if (r312 == null) goto L10;
        r315.put(PickerReporterConstants.KEY.ENTITY_ID, r312);     // Catch: JSONException -> L33
    L10:
        if (r311 == null) goto L12;
        r315.put(ConversationConstants.KEY_BCM_ID, r311);     // Catch: JSONException -> L33
    L12:
        if (r110 == null) goto L14;
        r315.put("bot_id", r110);     // Catch: JSONException -> L33
    L14:
        if (r111 == null) goto L16;
        r315.put("conversation_id", r111);     // Catch: JSONException -> L33
    L16:
        r315.put("current_page", r112);     // Catch: JSONException -> L33
        r315.put("is_onboarding", r113);     // Catch: JSONException -> L33
        if (r210 == null) goto L19;
        r315.put(MusicAppletPage.KEY_MESSAGE_ID, r210);     // Catch: JSONException -> L33
    L19:
        if (r211 == null) goto L21;
        r315.put("position", r211.longValue());     // Catch: JSONException -> L33
    L21:
        if (r212 == null) goto L23;
        r315.put("text", r212);     // Catch: JSONException -> L33
    L23:
        if (r213 == null) goto L25;
        r315.put("url", r213);     // Catch: JSONException -> L33
    L25:
        if (r314 == null) goto L27;
        r315.put("doc_id", r314);     // Catch: JSONException -> L33
    L27:
        if (r214 == null) goto L29;
        r315.put("baike_id", r214);     // Catch: JSONException -> L33
    L29:
        if (r215 == null) goto L31;
        r315.put("link_type", r215);     // Catch: JSONException -> L33
    L31:
        if (r313 == null) goto L35;
        r315.put("agent_id", r313);     // Catch: JSONException -> L33
    L35:
        if (r218 == null) goto L38;
        r315.put("msg_candidate_source", r218);     // Catch: JSONException -> L33
    L38:
        if (r219 == null) goto L42;
        r315.put("msg_group_id", r219);     // Catch: JSONException -> L33
    L33:
        e = move-exception;
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper clickSpecialSoftLink " + e.getLocalizedMessage());
    L42:
        TrackParams r100 = new TrackParams().merge(r315);
        by7.a r101 = new by7.a("click_special_soft_link");
        if (r316 == null) goto L45;
        r101.f21464b = r316;
    L45:
        r101.f21463a.merge(r100);
        r101.b();
        return;
    L47:
        r315.put("source_type", r217);     // Catch: JSONException -> L33
        goto L5
    }

    public static void H(String r210, String r211, String r212, Integer r213, String r214, String r215, String r216, String r310, String r311, String r312, String r313, String r314, String r315, int r316, String r317, String r318, Integer r319, String r410, Integer r411, String r412, String r413, String r414, String r415, int r416) {
        if ((r416 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r416 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r416 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r416 & 8) == 0) goto L17;
        Integer r103 = null;
    L19:
        if ((r416 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r416 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r416 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r416 & 128) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r416 & 256) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r416 & 512) == 0) goto L41;
        String r111 = null;
    L43:
        if ((r416 & 1024) == 0) goto L45;
        String r112 = null;
    L47:
        if ((r416 & 2048) == 0) goto L49;
        String r113 = null;
    L51:
        if ((r416 & 4096) == 0) goto L53;
        String r114 = null;
    L54:
        boolean r115 = false;
        if ((r416 & 8192) == 0) goto L57;
        int r116 = 0;
    L59:
        if ((r416 & 16384) == 0) goto L61;
        String r108 = null;
    L63:
        if ((r416 & 32768) == 0) goto L65;
        String r109 = null;
    L67:
        if ((r416 & 65536) == 0) goto L69;
        Integer r117 = null;
    L71:
        if ((r416 & 131072) == 0) goto L73;
        String r118 = null;
    L75:
        if ((r416 & 262144) == 0) goto L77;
        Integer r217 = null;
    L78:
        String r218 = r102;
        if ((r416 & 524288) == 0) goto L81;
        String r119 = null;
    L83:
        if ((r416 & 1048576) == 0) goto L85;
        String r120 = null;
    L86:
        String r219 = r120;
        if ((r416 & 2097152) == 0) goto L89;
        String r121 = null;
    L90:
        String r220 = r119;
        if ((r416 & 4194304) == 0) goto L93;
        String r122 = null;
    L95:
        if ((r416 & 8388608) == 0) goto L97;
        JSONObject r123 = new JSONObject();
    L98:
        Intrinsics.checkNotNullParameter(r123, "params");
        if (r112 != null) goto L153;
    L103:
        if (r121 == null) goto L105;
        r123.put("spring_guide_card_id", r121);     // Catch: JSONException -> L101
    L105:
        if (r100 == null) goto L107;
        r123.put("bot_id", r100);     // Catch: JSONException -> L101
    L107:
        if (r122 == null) goto L109;
        r123.put("album_status", r122);     // Catch: JSONException -> L101
    L109:
        if (r101 == null) goto L111;
        r123.put("click_from", r101);     // Catch: JSONException -> L101
    L111:
        if (r103 == null) goto L113;
        r123.put("is_ocr", r103.intValue());     // Catch: JSONException -> L101
    L113:
        if (r104 == null) goto L115;
        r123.put("chat_type", r104);     // Catch: JSONException -> L101
    L115:
        if (r105 == null) goto L117;
        r123.put("current_page", r105);     // Catch: JSONException -> L101
    L117:
        if (r107 == null) goto L119;
        r123.put(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID, r107);     // Catch: JSONException -> L101
    L119:
        if (r110 == null) goto L121;
        r123.put("action_bar_template_type", r110);     // Catch: JSONException -> L101
    L121:
        if (r113 != null) goto L123;
    L124:
        r115 = true;
    L126:
        if (r115 == false) goto L128;
        r123.put("cited_from_user_type", "no_cite");     // Catch: JSONException -> L101
    L129:
        if (r114 == null) goto L131;
        r123.put("cited_message_id", r114);     // Catch: JSONException -> L101
    L131:
        if (r108 == null) goto L133;
        r123.put("presentation_id", r108);     // Catch: JSONException -> L101
    L133:
        if (r109 == null) goto L135;
        r123.put("resource_id", r109);     // Catch: JSONException -> L101
    L135:
        if (r117 == null) goto L137;
        r123.put("resource_type", r117.intValue());     // Catch: JSONException -> L101
    L137:
        if (r118 == 0) goto L139;
        r123.put("artifact_meta_id", r118);     // Catch: JSONException -> L101
    L139:
        if (r217 == null) goto L141;
        r123.put("artifact_type", r217.intValue());     // Catch: JSONException -> L101
    L141:
        if (r220 == null) goto L143;
        r123.put("aippt_task_id", r220);     // Catch: JSONException -> L101
    L143:
        if (r219 == null) goto L145;
        r123.put("canvas_type", r219);     // Catch: JSONException -> L101
    L145:
        r123.put("is_ai_doc", r116);     // Catch: JSONException -> L101
        if (r218 == null) goto L148;
        r123.put("enter_method", r218);     // Catch: JSONException -> L101
    L148:
        r123.putOpt(LiveTutorHomeVM.ACTION_BAR_ITEM_ID, r111);     // Catch: JSONException -> L101
        r123.putOpt("previous_page", r106);     // Catch: JSONException -> L101
    L151:
        TrackParams r124 = new TrackParams().merge(r123);
        by7.a r125 = new by7.a("click_upload_entrance");
        r125.f21463a.merge(r124);
        r125.b();
        return;
    L101:
        e = move-exception;
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper clickUploadEntrance " + e.getLocalizedMessage());
        goto L151
    L128:
        r123.put("cited_from_user_type", r113);     // Catch: JSONException -> L101
        goto L129
    L123:
        if (r113.length() != 0) goto L126;
    L153:
        r123.put("action_bar_key", r112);     // Catch: JSONException -> L101
        goto L103
    L97:
        r123 = null;
        goto L98
    L93:
        r122 = r415;
        goto L95
    L89:
        r121 = r414;
        goto L90
    L85:
        r120 = r413;
        goto L86
    L81:
        r119 = r412;
        goto L83
    L77:
        r217 = r411;
        goto L78
    L73:
        r118 = r410;
        goto L75
    L69:
        r117 = r319;
        goto L71
    L65:
        r109 = r318;
        goto L67
    L61:
        r108 = r317;
        goto L63
    L57:
        r116 = r316;
        goto L59
    L53:
        r114 = r315;
        goto L54
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

    public static void D(String r110, String r111, Long r112, Long r113, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, String r318, String r319, String r410, Boolean r411) {
        JSONObject r114 = new JSONObject();
        Intrinsics.checkNotNullParameter(r114, "params");
        if (r315 != null) goto L71;
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
        r114.put("bot_id", r110);     // Catch: JSONException -> L5
    L15:
        if (r111 == null) goto L17;
        r114.put("chat_type", r111);     // Catch: JSONException -> L5
    L17:
        if (r112 == null) goto L19;
        r114.put(BdpAppEventConstant.PARAMS_CLICK_POSITION, r112.longValue());     // Catch: JSONException -> L5
    L19:
        if (r113 == null) goto L21;
        r114.put("conversation_id", r113.longValue());     // Catch: JSONException -> L5
    L21:
        if (r210 == null) goto L23;
        r114.put("current_page", r210);     // Catch: JSONException -> L5
    L23:
        r114.put("enter_chat_method", r211);     // Catch: JSONException -> L5
        r114.put("group_type", BridgePrivilege.PRIVATE);     // Catch: JSONException -> L5
        if (r212 == null) goto L26;
        r114.put(MusicAppletPage.KEY_MESSAGE_ID, r212);     // Catch: JSONException -> L5
    L26:
        if (r213 == null) goto L28;
        r114.put("previous_page", r213);     // Catch: JSONException -> L5
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
        if (r314 == null) goto L56;
        r114.put("item_id", r314);     // Catch: JSONException -> L5
    L56:
        if (r319 == null) goto L58;
        r114.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, r319);     // Catch: JSONException -> L5
    L5:
        JSONException e100 = e;
        JSONObject r100 = r114;
    L68:
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper clickSuggestedPrompt " + e100.getLocalizedMessage());
    L69:
        TrackParams r101 = new TrackParams().merge(r100);
        by7.a r102 = new by7.a("click_suggested_prompt");
        r102.f21463a.merge(r101);
        r102.b();
        return;
    L58:
        r100 = r114;
        if (r410 == null) goto L62;
        r100.put("agent_id", r410);     // Catch: JSONException -> L67
    L67:
        e100 = e;
    L62:
        if (Intrinsics.areEqual(r411, Boolean.TRUE) == false) goto L64;
        String r103 = "1";
    L65:
        r100.put("is_stream", r103);     // Catch: JSONException -> L67
        goto L69
    L64:
        r103 = "0";
        goto L65
    L71:
        r114.put("suggest_action_type", r315);     // Catch: JSONException -> L5
        goto L7
    }

    public static void i(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, Boolean r118, Integer r119, Boolean r210, String r211, String r212, String r213, String r214, String r215, Boolean r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, Boolean r314, TraceFragment r315) {
        JSONObject r100 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, "params");
        r100.put("enter_method", r110);     // Catch: JSONException -> L56
        r100.put("if_auto_filled", r111);     // Catch: JSONException -> L56
        r100.put("if_has_voice", r112);     // Catch: JSONException -> L56
        r100.put("if_system_prompt_added", r113);     // Catch: JSONException -> L56
        if (r114 == null) goto L6;
        r100.put("previous_page", r114);     // Catch: JSONException -> L56
    L6:
        r100.put("profile_photo_type", r115);     // Catch: JSONException -> L56
        r100.put("create_way", r116);     // Catch: JSONException -> L56
        if (r117 == null) goto L9;
        r100.put("creation_id", r117);     // Catch: JSONException -> L56
    L9:
        String r101 = "1";
        if (r118 != null) goto L12;
    L16:
        if (r119 == null) goto L18;
        r100.put("sp_cnt", r119.intValue());     // Catch: JSONException -> L56
    L18:
        if (r210 != null) goto L20;
    L24:
        if (r211 == null) goto L26;
        r100.put("voice_id", r211);     // Catch: JSONException -> L56
    L26:
        if (r212 == null) goto L28;
        r100.put("voice_type", r212);     // Catch: JSONException -> L56
    L28:
        r100.put("image_type", r213);     // Catch: JSONException -> L56
        if (r216 != null) goto L31;
    L35:
        if (r214 == null) goto L37;
        r100.put("speaker_id", r214);     // Catch: JSONException -> L56
    L37:
        if (r215 == null) goto L40;
        r100.put("speaker_name", r215);     // Catch: JSONException -> L56
    L40:
        if (com.larus.utils.o0.d(r311) == false) goto L43;
        r100.put("suggested_prompt_add_type", r311);     // Catch: JSONException -> L56
    L43:
        if (com.larus.utils.o0.d(r312) == false) goto L46;
        r100.put("bio_add_type", r312);     // Catch: JSONException -> L56
    L46:
        if (com.larus.utils.o0.d(r313) == false) goto L48;
        r100.put("onboarding_add_type", r313);     // Catch: JSONException -> L56
    L48:
        if (r314 != null) goto L50;
    L54:
        r100.putOpt("name_add_type", r217).putOpt("sp_add_type", r218).putOpt("profile_photo_add_type", r219).putOpt("voice_add_type", r310);     // Catch: JSONException -> L56
    L58:
        TrackParams r102 = new TrackParams().merge(r100);
        by7.a r103 = new by7.a("click_create_bot_auto_fill");
        if (r315 == null) goto L61;
        r103.f21464b = r315;
    L61:
        r103.f21463a.merge(r102);
        r103.b();
        return;
    L50:
        if (r314.booleanValue() == true) goto L53;
        r101 = "0";
    L53:
        r100.put("if_has_bio", r101);     // Catch: JSONException -> L56
        goto L54
    L31:
        if (r216.booleanValue() == false) goto L33;
        Object r104 = "1";
    L34:
        r100.put("background_status", r104);     // Catch: JSONException -> L56
        goto L35
    L33:
        r104 = "0";
        goto L34
    L20:
        if (r210.booleanValue() == false) goto L22;
        Object r105 = "1";
    L23:
        r100.put("sp_status", r105);     // Catch: JSONException -> L56
        goto L24
    L22:
        r105 = "0";
        goto L23
    L12:
        if (r118.booleanValue() == false) goto L14;
        Object r106 = "1";
    L15:
        r100.put("if_has_onboarding", r106);     // Catch: JSONException -> L56
        goto L16
    L14:
        r106 = "0";
    L56:
        e = move-exception;
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper clickCreateBotAutoFill " + e.getLocalizedMessage());
        goto L58
    }

    public static void u(String r310, String r311, Long r312, Long r313, Long r314, String r315, String r410, String r411, String r412, String r413, String r414, String r415, String r416, String r417, String r418, String r419, Integer r510, String r511, String r512, String r513, String r514, JSONObject r515, Integer r516, by7.e r517, String r518, String r519, String r610, String r611, String r612, String r613, String r614, String r615, String r616, String r617, int r618, int r619) {
        if ((r618 & 2) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r618 & 4) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r618 & 8) == 0) goto L13;
        Long r102 = null;
    L15:
        if ((r618 & 16) == 0) goto L17;
        Long r103 = null;
    L19:
        if ((r618 & 32) == 0) goto L21;
        Long r104 = null;
    L23:
        if ((r618 & 64) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r618 & 512) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r618 & 1024) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r618 & 2048) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r618 & 4096) == 0) goto L41;
        String r111 = null;
    L43:
        if ((r618 & 8192) == 0) goto L45;
        String r112 = null;
    L47:
        if ((32768 & r618) == 0) goto L49;
        String r113 = null;
    L51:
        if ((65536 & r618) == 0) goto L53;
        String r114 = null;
    L55:
        if ((131072 & r618) == 0) goto L57;
        String r115 = null;
    L59:
        if ((r618 & 262144) == 0) goto L61;
        String r108 = null;
    L63:
        if ((r618 & 524288) == 0) goto L65;
        String r116 = null;
    L67:
        if ((r618 & 1048576) == 0) goto L69;
        Integer r117 = null;
    L71:
        if ((r618 & 2097152) == 0) goto L73;
        String r210 = null;
    L75:
        if ((r618 & 4194304) == 0) goto L77;
        String r211 = null;
    L79:
        if ((r618 & 8388608) == 0) goto L81;
        String r212 = null;
    L83:
        if ((r618 & 16777216) == 0) goto L85;
        String r213 = null;
    L87:
        if ((r618 & 33554432) == 0) goto L89;
        JSONObject r109 = new JSONObject();
    L91:
        if ((r618 & 67108864) == 0) goto L93;
        Integer r118 = null;
    L95:
        if ((r618 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L97;
        by7.e r214 = null;
    L99:
        if ((r618 & 268435456) == 0) goto L101;
        String r215 = null;
    L103:
        if ((r618 & 536870912) == 0) goto L105;
        String r216 = null;
    L107:
        if ((r618 & 1073741824) == 0) goto L109;
        String r217 = null;
    L111:
        if ((r618 & Integer.MIN_VALUE) == 0) goto L113;
        String r119 = null;
    L115:
        if ((r619 & 1) == 0) goto L117;
        String r218 = null;
    L119:
        if ((r619 & 2) == 0) goto L121;
        String r316 = null;
    L123:
        if ((r619 & 4) == 0) goto L125;
        String r317 = null;
    L127:
        if ((r619 & 8) == 0) goto L129;
        String r318 = null;
    L130:
        String r319 = r119;
        if ((r619 & 16) == 0) goto L133;
        String r120 = null;
    L135:
        if ((r619 & 32) == 0) goto L137;
        String r320 = null;
    L138:
        Intrinsics.checkNotNullParameter(r109, "params");
        if (r120 != null) goto L225;
    L143:
        if (r100 == null) goto L145;
        r109.put("bot_id", r100);     // Catch: JSONException -> L141
    L145:
        if (r101 == null) goto L147;
        r109.put("chat_type", r101);     // Catch: JSONException -> L141
    L147:
        if (r102 == null) goto L149;
        r109.put(BdpAppEventConstant.PARAMS_CLICK_POSITION, r102.longValue());     // Catch: JSONException -> L141
    L149:
        if (r103 == null) goto L151;
        r109.put("click_position_row", r103.longValue());     // Catch: JSONException -> L141
    L151:
        if (r104 == null) goto L153;
        r109.put("conversation_id", r104.longValue());     // Catch: JSONException -> L141
    L153:
        if (r105 == null) goto L155;
        r109.put("current_page", r105);     // Catch: JSONException -> L141
    L155:
        if (r106 == null) goto L157;
        r109.put(MusicAppletPage.KEY_MESSAGE_ID, r106);     // Catch: JSONException -> L141
    L157:
        if (r107 == null) goto L159;
        r109.put("onboarding_content_source", r107);     // Catch: JSONException -> L141
    L159:
        if (r110 == null) goto L161;
        r109.put("onboarding_question", r110);     // Catch: JSONException -> L141
    L161:
        if (r111 == null) goto L163;
        r109.put("onboarding_type", r111);     // Catch: JSONException -> L141
    L163:
        if (r112 == null) goto L165;
        r109.put("previous_page", r112);     // Catch: JSONException -> L141
    L165:
        if (r113 == null) goto L167;
        r109.put("show_way", r113);     // Catch: JSONException -> L141
    L167:
        if (r114 == null) goto L169;
        r109.put("prompt_type", r114);     // Catch: JSONException -> L141
    L169:
        if (r115 == 0) goto L171;
        r109.put("prompt_subtype", r115);     // Catch: JSONException -> L141
    L171:
        if (r108 == 0) goto L173;
        r109.put("url", r108);     // Catch: JSONException -> L141
    L173:
        String r121 = r116;
        if (r121 == null) goto L176;
        r109.put("title", r121);     // Catch: JSONException -> L141
    L176:
        if (r117 == null) goto L178;
        r109.put("is_new_fuction", r117.intValue());     // Catch: JSONException -> L141
    L178:
        String r122 = r210;
        if (r122 == null) goto L181;
        r109.put("reco_request_id", r122);     // Catch: JSONException -> L141
    L181:
        String r123 = r211;
        if (r123 == null) goto L184;
        r109.put("item_id", r123);     // Catch: JSONException -> L141
    L184:
        String r124 = r217;
        if (r124 == null) goto L187;
        r109.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r124);     // Catch: JSONException -> L141
    L187:
        String r125 = r212;
        if (r125 == null) goto L190;
        r109.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, r125);     // Catch: JSONException -> L141
    L190:
        String r126 = r213;
        if (r126 == null) goto L193;
        r109.put("section_id", r126);     // Catch: JSONException -> L141
    L193:
        if (r118 == null) goto L195;
        r109.put("type", r118.intValue());     // Catch: JSONException -> L141
    L195:
        String r127 = r216;
        if (r127 == null) goto L198;
        r109.put("prompt_from", r127);     // Catch: JSONException -> L141
    L198:
        if (r319 == null) goto L200;
        r109.put(ObricActionBarTrackType.KEY_ACTION_BAR_TEMPLATE_ID, r319);     // Catch: JSONException -> L141
    L200:
        String r128 = r218;
        if (r128 == null) goto L203;
        r109.put("visual_size", r128);     // Catch: JSONException -> L141
    L203:
        String r129 = r316;
        if (r129 == null) goto L206;
        r109.put("click_type", r129);     // Catch: JSONException -> L141
    L206:
        String r130 = r317;
        if (r130 == null) goto L209;
        r109.put("tag_code", r130);     // Catch: JSONException -> L141
    L209:
        String r131 = r215;
        if (r131 == null) goto L212;
        r109.put("scheme", r131);     // Catch: JSONException -> L141
    L212:
        String r132 = r320;
        if (r132 == null) goto L215;
        r109.put("template_version", r132);     // Catch: JSONException -> L141
    L215:
        String r133 = r318;
        if (r133 == null) goto L220;
        r109.put("lottery_status", r133);     // Catch: JSONException -> L141
    L141:
        e = move-exception;
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper clickOnboardingCard " + e.getLocalizedMessage());
    L220:
        TrackParams r134 = new TrackParams().merge(r109);
        by7.a r135 = new by7.a("click_onboarding_card");
        by7.e r136 = r214;
        if (r136 == null) goto L223;
        r135.f21464b = r136;
    L223:
        r135.f21463a.merge(r134);
        r135.b();
        return;
    L225:
        r109.put("onboarding_action_type", r120);     // Catch: JSONException -> L141
        goto L143
    L137:
        r320 = r617;
        goto L138
    L133:
        r120 = r616;
        goto L135
    L129:
        r318 = r615;
        goto L130
    L125:
        r317 = r614;
        goto L127
    L121:
        r316 = r613;
        goto L123
    L117:
        r218 = r612;
        goto L119
    L113:
        r119 = r611;
        goto L115
    L109:
        r217 = r610;
        goto L111
    L105:
        r216 = r519;
        goto L107
    L101:
        r215 = r518;
        goto L103
    L97:
        r214 = r517;
        goto L99
    L93:
        r118 = r516;
        goto L95
    L89:
        r109 = r515;
        goto L91
    L85:
        r213 = r514;
        goto L87
    L81:
        r212 = r513;
        goto L83
    L77:
        r211 = r512;
        goto L79
    L73:
        r210 = r511;
        goto L75
    L69:
        r117 = r510;
        goto L71
    L65:
        r116 = r419;
        goto L67
    L61:
        r108 = r418;
        goto L63
    L57:
        r115 = r417;
        goto L59
    L53:
        r114 = r416;
        goto L55
    L49:
        r113 = r415;
        goto L51
    L45:
        r112 = r414;
        goto L47
    L41:
        r111 = r413;
        goto L43
    L37:
        r110 = r412;
        goto L39
    L33:
        r107 = r411;
        goto L35
    L29:
        r106 = r410;
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

    public static void j(String r310, String r311, String r312, String r313, String r314, String r315, Boolean r410, Boolean r411, Boolean r412, Integer r413, Boolean r414, Boolean r415, Boolean r416, Boolean r417, String r418, String r419, Boolean r510, Boolean r511, String r512, String r513, String r514, String r515, String r516, String r517, String r518, String r519, String r610, String r611, String r612, Boolean r613, Integer r614, String r615, String r616, Boolean r617, Boolean r618, JSONObject r619, by7.e r710, int r711, int r712) {
        if ((r711 & 2) == 0) goto L5;
        Object r100 = null;
    L7:
        if ((r711 & 4) == 0) goto L9;
        Object r101 = null;
    L11:
        if ((r711 & 8) == 0) goto L13;
        Object r102 = null;
    L15:
        if ((r711 & 16) == 0) goto L17;
        Object r103 = null;
    L19:
        if ((r711 & 32) == 0) goto L21;
        Object r104 = null;
    L23:
        if ((r711 & 64) == 0) goto L25;
        Object r105 = null;
    L27:
        if ((r711 & 128) == 0) goto L29;
        Boolean r106 = null;
    L31:
        if ((r711 & 256) == 0) goto L33;
        Boolean r107 = null;
    L35:
        if ((r711 & 512) == 0) goto L37;
        Boolean r110 = null;
    L39:
        if ((r711 & 1024) == 0) goto L41;
        Integer r111 = null;
    L43:
        if ((r711 & 2048) == 0) goto L45;
        Boolean r112 = null;
    L47:
        if ((r711 & 4096) == 0) goto L49;
        Boolean r113 = null;
    L51:
        if ((r711 & 8192) == 0) goto L53;
        Boolean r114 = null;
    L55:
        if ((r711 & 16384) == 0) goto L57;
        Boolean r115 = null;
    L59:
        if ((r711 & 32768) == 0) goto L61;
        Object r108 = null;
    L62:
        Boolean r316 = r107;
        if ((r711 & 65536) == 0) goto L65;
        Object r109 = null;
    L67:
        if ((r711 & 131072) == 0) goto L69;
        Boolean r116 = null;
    L71:
        if ((r711 & 262144) == 0) goto L73;
        Boolean r117 = null;
    L75:
        if ((r711 & 524288) == 0) goto L77;
        Object r210 = null;
    L79:
        if ((r711 & 1048576) == 0) goto L81;
        Object r211 = null;
    L83:
        if ((r711 & 2097152) == 0) goto L85;
        Object r212 = null;
    L87:
        if ((r711 & 4194304) == 0) goto L89;
        Object r213 = null;
    L91:
        if ((r711 & 8388608) == 0) goto L93;
        Object r214 = null;
    L95:
        if ((r711 & 16777216) == 0) goto L97;
        Object r215 = null;
    L99:
        if ((r711 & 33554432) == 0) goto L101;
        Object r216 = null;
    L103:
        if ((r711 & 67108864) == 0) goto L105;
        Object r217 = null;
    L107:
        if ((r711 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L109;
        String r317 = null;
    L111:
        if ((r711 & 268435456) == 0) goto L113;
        String r318 = null;
    L115:
        if ((r711 & 536870912) == 0) goto L117;
        String r319 = null;
    L119:
        if ((r711 & 1073741824) == 0) goto L121;
        Boolean r118 = null;
    L123:
        if ((r711 & Integer.MIN_VALUE) == 0) goto L125;
        Integer r119 = null;
    L127:
        if ((r712 & 1) == 0) goto L129;
        Object r218 = null;
    L131:
        if ((r712 & 2) == 0) goto L133;
        Object r320 = null;
    L135:
        if ((r712 & 4) == 0) goto L137;
        Boolean r219 = null;
    L139:
        if ((r712 & 8) == 0) goto L141;
        Boolean r321 = null;
    L143:
        if ((r712 & 16) == 0) goto L145;
        JSONObject r120 = new JSONObject();
    L147:
        if ((r712 & 32) == 0) goto L149;
        by7.e r322 = null;
    L150:
        Intrinsics.checkNotNullParameter(r120, "params");
        if (r100 != null) goto L284;
    L155:
        if (r102 == null) goto L157;
        r120.put("previous_page", r102);     // Catch: JSONException -> L153
    L157:
        if (r101 == null) goto L159;
        r120.put("creation_id", r101);     // Catch: JSONException -> L153
    L159:
        if (r103 == null) goto L161;
        r120.put("create_way", r103);     // Catch: JSONException -> L153
    L161:
        if (r104 == null) goto L163;
        r120.put("from_activity_name", r104);     // Catch: JSONException -> L153
    L163:
        if (r105 == null) goto L165;
        r120.put("from_activity_module", r105);     // Catch: JSONException -> L153
    L165:
        String r121 = "0";
        if (r106 != null) goto L168;
    L172:
        if (r110 != null) goto L174;
    L178:
        if (r111 == null) goto L180;
        r120.put("sp_cnt", r111.intValue());     // Catch: JSONException -> L153
    L180:
        if (r112 != null) goto L182;
    L186:
        if (r113 != null) goto L188;
    L192:
        if (r114 != null) goto L194;
    L198:
        if (r115 != null) goto L200;
    L204:
        if (r108 == null) goto L206;
        r120.put("profile_photo_type", r108);     // Catch: JSONException -> L153
    L206:
        if (r109 == 0) goto L208;
        r120.put("image_type", r109);     // Catch: JSONException -> L153
    L208:
        if (r116 != null) goto L210;
    L214:
        if (r117 != null) goto L216;
    L220:
        Object r122 = r210;
        if (r122 == null) goto L223;
        r120.put("voice_id", r122);     // Catch: JSONException -> L153
    L223:
        Object r123 = r211;
        if (r123 == null) goto L226;
        r120.put("voice_type", r123);     // Catch: JSONException -> L153
    L226:
        Object r124 = r212;
        if (r124 == null) goto L229;
        r120.put("speaker_id", r124);     // Catch: JSONException -> L153
    L229:
        Object r125 = r213;
        if (r125 == null) goto L233;
        r120.put("speaker_name", r125);     // Catch: JSONException -> L153
    L233:
        if (com.larus.utils.o0.d(r317) == false) goto L236;
        r120.put("suggested_prompt_add_type", r317);     // Catch: JSONException -> L153
    L236:
        if (com.larus.utils.o0.d(r318) == false) goto L239;
        r120.put("bio_add_type", r318);     // Catch: JSONException -> L153
    L239:
        if (com.larus.utils.o0.d(r319) == false) goto L241;
        r120.put("onboarding_add_type", r319);     // Catch: JSONException -> L153
    L241:
        if (r316 != null) goto L243;
    L247:
        if (r118 != null) goto L249;
    L253:
        if (r119 == 0) goto L255;
        r120.put("polish_cnt", String.valueOf(r119.intValue()));     // Catch: JSONException -> L153
    L255:
        Object r126 = r218;
        if (r126 == null) goto L258;
        r120.put("polish_status", r126);     // Catch: JSONException -> L153
    L258:
        Object r127 = r320;
        if (r127 == null) goto L261;
        r120.put("private_status", r127);     // Catch: JSONException -> L153
    L261:
        if (r219 == null) goto L269;
        boolean r128 = r219.booleanValue();     // Catch: JSONException -> L153
        if (Intrinsics.areEqual(r126, "1") == false) goto L269;
        if (r128 == false) goto L267;
        Object r129 = "1";
    L268:
        r120.put("if_polish_use_internet", r129);     // Catch: JSONException -> L153
        goto L269
    L267:
        r129 = "0";
    L269:
        if (r321 == null) goto L276;
        boolean r130 = r321.booleanValue();     // Catch: JSONException -> L153
        if (Intrinsics.areEqual(r106, Boolean.TRUE) == false) goto L276;
        if (r130 == false) goto L275;
        r121 = "1";
    L275:
        r120.put("if_auto_fill_use_internet", r121);     // Catch: JSONException -> L153
    L276:
        r120.putOpt("name_add_type", r214).putOpt("sp_add_type", r215).putOpt("profile_photo_add_type", r216).putOpt("voice_add_type", r217);     // Catch: JSONException -> L153
    L279:
        TrackParams r131 = new TrackParams().merge(r120);
        by7.a r132 = new by7.a("click_create_bot_complete");
        by7.e r133 = r322;
        if (r133 == null) goto L282;
        r132.f21464b = r133;
    L282:
        r132.f21463a.merge(r131);
        r132.b();
        return;
    L153:
        e = move-exception;
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper clickCreateBotAutoFill " + e.getLocalizedMessage());
        goto L279
    L249:
        if (r118.booleanValue() == false) goto L251;
        Object r134 = "1";
    L252:
        r120.put("if_polish", r134);     // Catch: JSONException -> L153
        goto L253
    L251:
        r134 = "0";
        goto L252
    L243:
        if (r316.booleanValue() == false) goto L245;
        Object r135 = "1";
    L246:
        r120.put("if_has_bio", r135);     // Catch: JSONException -> L153
        goto L247
    L245:
        r135 = "0";
        goto L246
    L216:
        if (r117.booleanValue() == false) goto L218;
        Object r136 = "1";
    L219:
        r120.put("if_system_prompt_added", r136);     // Catch: JSONException -> L153
        goto L220
    L218:
        r136 = "0";
        goto L219
    L210:
        if (r116.booleanValue() == false) goto L212;
        Object r137 = "1";
    L213:
        r120.put("background_status", r137);     // Catch: JSONException -> L153
        goto L214
    L212:
        r137 = "0";
        goto L213
    L200:
        if (r115.booleanValue() == false) goto L202;
        Object r138 = "1";
    L203:
        r120.put(DocCallbackImpl.KEY_IS_EDITED, r138);     // Catch: JSONException -> L153
        goto L204
    L202:
        r138 = "0";
        goto L203
    L194:
        if (r114.booleanValue() == false) goto L196;
        Object r139 = "1";
    L197:
        r120.put("if_allow_search", r139);     // Catch: JSONException -> L153
        goto L198
    L196:
        r139 = "0";
        goto L197
    L188:
        if (r113.booleanValue() == false) goto L190;
        Object r140 = "1";
    L191:
        r120.put("if_generate_picture", r140);     // Catch: JSONException -> L153
        goto L192
    L190:
        r140 = "0";
        goto L191
    L182:
        if (r112.booleanValue() == false) goto L184;
        Object r141 = "1";
    L185:
        r120.put("sp_status", r141);     // Catch: JSONException -> L153
        goto L186
    L184:
        r141 = "0";
        goto L185
    L174:
        if (r110.booleanValue() == false) goto L176;
        Object r142 = "1";
    L177:
        r120.put("if_has_onboarding", r142);     // Catch: JSONException -> L153
        goto L178
    L176:
        r142 = "0";
        goto L177
    L168:
        if (r106.booleanValue() == false) goto L170;
        Object r143 = "1";
    L171:
        r120.put("if_auto_filled", r143);     // Catch: JSONException -> L153
        goto L172
    L170:
        r143 = "0";
        goto L171
    L284:
        r120.put("enter_method", r100);     // Catch: JSONException -> L153
        goto L155
    L149:
        r322 = r710;
        goto L150
    L145:
        r120 = r619;
        goto L147
    L141:
        r321 = r618;
        goto L143
    L137:
        r219 = r617;
        goto L139
    L133:
        r320 = r616;
        goto L135
    L129:
        r218 = r615;
        goto L131
    L125:
        r119 = r614;
        goto L127
    L121:
        r118 = r613;
        goto L123
    L117:
        r319 = r612;
        goto L119
    L113:
        r318 = r611;
        goto L115
    L109:
        r317 = r610;
        goto L111
    L105:
        r217 = r519;
        goto L107
    L101:
        r216 = r518;
        goto L103
    L97:
        r215 = r517;
        goto L99
    L93:
        r214 = r516;
        goto L95
    L89:
        r213 = r515;
        goto L91
    L85:
        r212 = r514;
        goto L87
    L81:
        r211 = r513;
        goto L83
    L77:
        r210 = r512;
        goto L79
    L73:
        r117 = r511;
        goto L75
    L69:
        r116 = r510;
        goto L71
    L65:
        r109 = r419;
        goto L67
    L61:
        r108 = r418;
        goto L62
    L57:
        r115 = r417;
        goto L59
    L53:
        r114 = r416;
        goto L55
    L49:
        r113 = r415;
        goto L51
    L45:
        r112 = r414;
        goto L47
    L41:
        r111 = r413;
        goto L43
    L37:
        r110 = r412;
        goto L39
    L33:
        r107 = r411;
        goto L35
    L29:
        r106 = r410;
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
