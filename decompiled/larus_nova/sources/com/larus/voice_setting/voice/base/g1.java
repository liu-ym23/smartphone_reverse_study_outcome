package com.larus.voice_setting.voice.base;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ixigua.lib.track.TrackParams;
import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.model.RecommendFrom;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.bean.RequestType;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import tx9.b4;
import tx9.q1;

/* JADX INFO: loaded from: classes32.dex */
public final class g1 implements p2a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g1 f376420a = null;

    static {
        f376420a = new g1();
    }

    public g1() {
    }

    public static void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        com.larus.platform.service.o r101 = com.larus.platform.service.o.f365780a;
        JSONObject r102 = new JSONObject();
        r102.put("enter_from", r100);
        r102.put("current_page", r100);
        Unit r103 = Unit.INSTANCE;
        r101.reportEvent("click_delete_own_voice", r102);
    }

    public static void b(String r100, SpeakerVoice r101) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        if (r101 != null) goto L5;
        return;
    L5:
        com.larus.platform.service.o r102 = com.larus.platform.service.o.f365780a;
        JSONObject r103 = new JSONObject();
        r103.put("enter_from", r100);
        r103.put("voice_id", r101.getId());
        r103.put("speaker_id", r101.getStyleId());
        r103.put("speaker_name", r101.getName());
        Unit r104 = Unit.INSTANCE;
        r102.reportEvent("click_change_own_voice_name", r103);
    }

    public static void f(SpeakerVoice r210, RecommendFrom r211, Integer r212) {
        if (r210 != null) goto L6;
        return;
    L6:
        if (r210.getBestMatch() == false) goto L8;
        String r100 = "1";
    L10:
        if (r210.getPrivateStatus() != 1) goto L12;
        String r101 = "1";
    L13:
        String r102 = r210.getId();
        if (r210.isUgcVoice() == false) goto L16;
        String r103 = "self_create";
    L17:
        String r110 = r103;
        if (r211 == null) goto L23;
        String r104 = r211.f365482a;
        if (r104 == null) goto L23;
        String r105 = r104;
    L24:
        if (r211 == null) goto L29;
        String r106 = r211.f365483b;
        if (r106 == null) goto L29;
        String r107 = r106;
    L30:
        String r111 = r210.getName();
        q1.a(r212, r100, r101, r105, r107, r102, r110, null, null, null, r210.getStyleId(), r111, null, null, null, null, null, null, null, 2093952);
        return;
    L29:
        r107 = "";
    L23:
        r105 = "";
        goto L24
    L16:
        r103 = "default";
        goto L17
    L12:
        r101 = "0";
        goto L13
    L8:
        r100 = "0";
        goto L10
    }

    public static void e(SpeakerVoice r100, boolean r101, boolean r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r104 = r100.getId();
        String r105 = "1";
        if (r103 == false) goto L7;
        Object r106 = "1";
    L8:
        if (r102 == false) goto L10;
        Object r107 = "1";
    L12:
        if (r100.getPrivateStatus() != 1) goto L14;
        Object r108 = "1";
    L15:
        if (r101 == true) goto L18;
        r105 = "0";
    L18:
        String r109 = r100.getStyleId();
        String r110 = r100.getName();
        JSONObject r111 = new JSONObject();
        Intrinsics.checkNotNullParameter(r111, "params");
        r111.put("is_default_avatar", r106);     // Catch: JSONException -> L27
        r111.put("is_default_name", r107);     // Catch: JSONException -> L27
        r111.put("is_public", r108);     // Catch: JSONException -> L27
        r111.put("success", r105);     // Catch: JSONException -> L27
        if (r104 == null) goto L22;
        r111.put("voice_id", r104);     // Catch: JSONException -> L27
    L22:
        if (r109 == null) goto L24;
        r111.put("speaker_id", r109);     // Catch: JSONException -> L27
    L24:
        if (r110 == null) goto L29;
        r111.put("speaker_name", r110);     // Catch: JSONException -> L27
    L29:
        TrackParams r112 = new TrackParams().merge(r111);
        by7.a r113 = new by7.a("edit_own_voice_complete");
        r113.f21463a.merge(r112);
        r113.b();
        return;
    L27:
        e = move-exception;
        FLogger.f375446a.e("EditEventHelper", "error in EditEventHelper editOwnVoiceComplete " + e.getLocalizedMessage());
        goto L29
    L14:
        r108 = "0";
        goto L15
    L10:
        r107 = "0";
        goto L12
    L7:
        r106 = "0";
        goto L8
    }

    public static void h(SpeakerVoice r100, String r101, String r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r101, "enterFrom");
        Intrinsics.checkNotNullParameter(r103, "params");
        if (r100 != null) goto L5;
        return;
    L5:
        r103.put("enter_from", r101);
        r103.put("voice_id", r100.getId());
        if (r100.getPrivateStatus() != 1) goto L8;
        String r104 = "1";
    L9:
        r103.put("is_public", r104);
        r103.put("speaker_id", r100.getStyleId());
        r103.put("speaker_name", r100.getName());
        r103.put("voice_create_id", b4.f547846a);
        r103.put("enter_method", r102);
        com.larus.platform.service.o.f365780a.reportEvent("record_own_voice_complete", r103);
        com.larus.platform.service.g.f365738a.monitorEventForSlardar("record_own_voice_complete", r103, null, null);
        return;
    L8:
        r104 = "0";
        goto L9
    }

    public static void c(String r100, TraceFragment r101, String r102, JSONObject r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "node");
        Intrinsics.checkNotNullParameter(r102, "previousPage");
        Intrinsics.checkNotNullParameter(r110, "params");
        tx9.c0.m("bot_setting", "bot_voice_change", r100, r102, r111, r110, r101);
    }

    public static void g(long r100, RequestType r101, int r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r101, "requestType");
        Intrinsics.checkNotNullParameter("2", "recommendType");
        com.larus.platform.service.o r105 = com.larus.platform.service.o.f365780a;
        JSONObject r106 = new JSONObject();
        r106.put("time", r100);
        r106.put("request_type", r101.getType());
        r106.put("success", r102);
        if (r103 == false) goto L5;
        String r107 = "1";
    L6:
        r106.put("preload", r107);
        r106.put(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_TYPE, "2");
        r106.put("is_main_bot", r104 ? 1 : 0);
        Unit r108 = Unit.INSTANCE;
        r105.reportEvent("recommend_request_load_time", r106);
        return;
    L5:
        r107 = "0";
        goto L6
    }

    public static void i(SpeakerVoice r110, RecommendFrom r111, String r112, String r113, by7.e r210, String r211, String r212, Boolean r213) {
        if (r110 != null) goto L6;
        return;
    L6:
        if (r110.getPrivateStatus() != 1) goto L8;
        String r100 = "1";
    L9:
        String r101 = r110.getId();
        if (Intrinsics.areEqual(r113, "tts_disabled") == false) goto L12;
        String r102 = "chat";
    L14:
        if (r110.isUgcVoice() == false) goto L16;
        String r103 = "self_create";
    L17:
        String r114 = "";
        if (r111 == null) goto L21;
        String r115 = r111.f365482a;
        if (r115 == null) goto L21;
    L22:
        if (r111 == null) goto L27;
        String r104 = r111.f365483b;
        if (r104 == null) goto L27;
        r114 = r104;
    L27:
        String r105 = r110.getName();
        String r116 = r110.getStyleId();
        String r117 = r110.getStyleId();
        JSONObject r118 = new JSONObject();
        Intrinsics.checkNotNullParameter(r118, "params");
        if (r112 != null) goto L59;
    L30:
        r118.put("is_public", r100);     // Catch: JSONException -> L52
        if (r102 == null) goto L33;
        r118.put("previous_page", r102);     // Catch: JSONException -> L52
    L33:
        r118.put("recommend_from", r115);     // Catch: JSONException -> L52
        r118.put("req_id", r114);     // Catch: JSONException -> L52
        if (r101 == null) goto L36;
        r118.put("voice_id", r101);     // Catch: JSONException -> L52
    L36:
        r118.put("voice_type", r103);     // Catch: JSONException -> L52
        if (r113 == null) goto L39;
        r118.put("enter_method", r113);     // Catch: JSONException -> L52
    L39:
        if (r116 == null) goto L41;
        r118.put("speaker_id", r116);     // Catch: JSONException -> L52
    L41:
        if (r105 == null) goto L43;
        r118.put("speaker_name", r105);     // Catch: JSONException -> L52
    L43:
        if (r211 == null) goto L45;
        r118.put("scene", r211);     // Catch: JSONException -> L52
    L45:
        if (r117 == null) goto L47;
        r118.put("to_tts_speaker", r117);     // Catch: JSONException -> L52
    L47:
        if (r212 == null) goto L49;
        r118.put("bot_id", r212);     // Catch: JSONException -> L52
    L49:
        if (r213 == null) goto L54;
        r118.put("is_best_match", r213.booleanValue() ? 1 : 0);     // Catch: JSONException -> L52
    L52:
        e = move-exception;
        FLogger.f375446a.e("VoiceEventHelper", "error in VoiceEventHelper voiceCellShow " + e.getLocalizedMessage());
    L54:
        TrackParams r106 = new TrackParams().merge(r118);
        by7.a r107 = new by7.a("voice_cell_show");
        if (r210 == null) goto L57;
        r107.f21464b = r210;
    L57:
        r107.f21463a.merge(r106);
        r107.b();
        return;
    L59:
        r118.put("click_from", r112);     // Catch: JSONException -> L52
    L21:
        r115 = "";
        goto L22
    L16:
        r103 = "default";
        goto L17
    L12:
        r102 = null;
        goto L14
    L8:
        r100 = "0";
        goto L9
    }

    @Override // p2a.d
    public final void a(SpeakerVoice r110, String r210, boolean r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, Float r219, Float r310, Integer r311, String r312, String r313, String r314, String r315, String r316, String r317, String r318, String r319, ouc.d0 r410) {
        Intrinsics.checkNotNullParameter(r410, "params");
        JSONObject r111 = new JSONObject(r410.toString());
        com.larus.platform.service.o r100 = com.larus.platform.service.o.f365780a;
        if (r210 == null) goto L5;
        r111.put("bot_id", r210);
    L5:
        if (r212 == null) goto L8;
        r111.put("enter_from", r212);
    L8:
        if (r110 != null) goto L10;
    L30:
        r111.put("if_auto", r211 ? 1 : 0);
        if (r216 == null) goto L33;
        r111.put("recommend_from", r216);
    L33:
        if (r217 == null) goto L35;
        r111.put("req_id", r217);
    L35:
        if (r314 == null) goto L37;
        r111.put(BdpAppEventConstant.PARAMS_CLICK_POSITION, r314);
    L37:
        if (r316 == null) goto L39;
        r111.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r316);
    L39:
        if (r315 == null) goto L41;
        r111.put("enter_method", r315);
    L41:
        if (r218 == null) goto L43;
        r111.put("voice_remix_id", r218);
    L43:
        if (r311 == null) goto L45;
        r111.put("voice_origin_cnt", r311.intValue());
    L45:
        if (r312 == null) goto L47;
        r111.put("if_voice_ratio_default", r312);
    L47:
        if (r313 == null) goto L49;
        r111.put("is_best_match", r313);
    L49:
        if (r219 == null) goto L51;
        r111.put("voice_pitch", r219);
    L51:
        if (r310 == null) goto L53;
        r111.put("voice_speed", r310);
    L53:
        if (r215 == null) goto L56;
        r111.put("click_from", r215);
    L56:
        if (r213 == null) goto L59;
        r111.put("current_page", r213);
    L59:
        if (r214 == null) goto L62;
        r111.put("previous_page", r214);
    L62:
        if (r317 == null) goto L65;
        r111.put("scene", r317);
    L65:
        if (r318 == null) goto L68;
        r111.put("from_voice_id", r318);
    L68:
        if (r319 == null) goto L70;
        r111.put("success", r319);
    L70:
        Unit r101 = Unit.INSTANCE;
        r100.reportEvent("change_voice", r111);
        return;
    L10:
        if (r110.isUgcVoice() == false) goto L12;
        String r102 = "self_create";
    L13:
        r111.put("voice_type", r102);
        r111.put("voice_id", r110.getId());
        r111.put("to_tts_speaker", r110.getStyleId());
        if (r110.getPrivateStatus() != 1) goto L16;
        Object r103 = "1";
    L17:
        r111.put("is_public", r103);
        if (r110.getBestMatch() == false) goto L20;
        Object r104 = "1";
    L21:
        r111.put("is_best_match", r104);
        List<MixVoice> r105 = r110.getMixVoiceList();
        if (r105 == null) goto L24;
        int r106 = r105.size();
    L26:
        if (r106 <= 1) goto L28;
        String r107 = "mixed voice";
    L29:
        r111.put("speaker_name", r107);
        r111.put("speaker_id", r110.getStyleId());
        r111.put("speaker_name", r110.getName());
        goto L30
    L28:
        r107 = r110.getName();
        goto L29
    L24:
        r106 = 0;
        goto L26
    L20:
        r104 = "0";
        goto L21
    L16:
        r103 = "0";
        goto L17
    L12:
        r102 = "default";
        goto L13
    }
}
