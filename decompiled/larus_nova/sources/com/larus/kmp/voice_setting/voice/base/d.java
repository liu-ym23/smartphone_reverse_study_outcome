package com.larus.kmp.voice_setting.voice.base;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.im.FlowRuntime;
import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.kmp.voice_setting.voice.bean.RequestType;
import com.larus.kmp.voice_setting.voice.track.VoiceSettingLegacyTraceEvent;
import com.larus.kmp.voice_setting.voice.track.VoiceSettingLegacyTraceKey;
import com.larus.kmp.voice_setting.voice.track.VoiceSettingLegacyTraceValue;
import gd9.a0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mh9.i;
import mh9.s;
import mh9.u;
import mh9.x;
import ouc.d0;
import ouc.e0;
import ouc.j;
import ouc.k;

/* JADX INFO: loaded from: classes30.dex */
public final class d implements p2a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f351783a = null;

    static {
        f351783a = new d();
    }

    public d() {
    }

    public static a0 c() {
        return FlowRuntime.b().d();
    }

    public static String b(VoiceSettingLegacyTraceEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        switch(i.a.f514003a[r100.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            default: goto L5;
        };
    L6:
        return "change_voice";
    L7:
        return "record_own_voice_complete";
    L8:
        return "click_delete_own_voice";
    L9:
        return "click_change_own_voice_name";
    L10:
        return "click_voice_setting";
    L11:
        return "complete_change_own_voice_name";
    L12:
        return "complete_delete_own_voice";
    L13:
        return "recommend_request_load_time";
    L14:
        return "hit_preload_recommend_voice";
    L15:
        return "recommend_voice_tti";
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public static String d(SpeakerVoice r100) {
        if (r100.getPrivateStatus() != 1) goto L6;
        return i.a(VoiceSettingLegacyTraceValue.STRING_1);
    L6:
        return i.a(VoiceSettingLegacyTraceValue.STRING_0);
    }

    public static String e(VoiceSettingLegacyTraceKey r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        switch(i.a.f514004b[r100.ordinal()]) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            case 11: goto L10;
            case 12: goto L9;
            case 13: goto L8;
            case 14: goto L7;
            case 15: goto L6;
            default: goto L5;
        };
    L6:
        return "if_auto";
    L7:
        return "to_tts_speaker";
    L8:
        return "voice_type";
    L9:
        return "bot_id";
    L10:
        return "enter_method";
    L11:
        return "voice_id";
    L12:
        return "current_page";
    L13:
        return "preload";
    L14:
        return "success";
    L15:
        return "request_type";
    L16:
        return "is_hit";
    L17:
        return "is_main_bot";
    L18:
        return com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_TYPE;
    L19:
        return "time";
    L20:
        return "enter_from";
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public static void f(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        String r102 = b(VoiceSettingLegacyTraceEvent.HIT_PRELOAD_RECOMMEND_VOICE);
        e0 r103 = new e0();
        j.c(r103, e(VoiceSettingLegacyTraceKey.ENTER_FROM), r100);
        j.b(r103, e(VoiceSettingLegacyTraceKey.IS_HIT), Integer.valueOf(r101));
        u.a(r102, r103.a());
    }

    public static void g(SpeakerVoice r100, boolean r101, boolean r102, boolean r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r104 = r100.getId();
        if (r103 == false) goto L7;
        String r105 = i.a(VoiceSettingLegacyTraceValue.STRING_1);
    L8:
        if (r102 == false) goto L10;
        String r106 = i.a(VoiceSettingLegacyTraceValue.STRING_1);
    L11:
        String r107 = d(r100);
        if (r101 == false) goto L14;
        String r108 = i.a(VoiceSettingLegacyTraceValue.STRING_1);
    L15:
        String r109 = r100.getStyleId();
        String r110 = r100.getName();
        d0 r111 = new d0(new LinkedHashMap());
        Intrinsics.checkNotNullParameter(r111, "params");
        x.i("edit_own_voice_complete", r111, CollectionsKt.listOfNotNull(new Pair[]{x.j("is_default_avatar", r105), x.j("is_default_name", r106), x.j("is_public", r107), x.j("succuess", r108), x.j("voice_id", r104), x.j("speaker_id", r109), x.j("speaker_name", r110)}));
        return;
    L14:
        r108 = i.a(VoiceSettingLegacyTraceValue.STRING_0);
        goto L15
    L10:
        r106 = i.a(VoiceSettingLegacyTraceValue.STRING_0);
        goto L11
    L7:
        r105 = i.a(VoiceSettingLegacyTraceValue.STRING_0);
        goto L8
    }

    public static void h(long r100, RequestType r101, int r102, boolean r103, boolean r110) {
        Intrinsics.checkNotNullParameter(r101, "requestType");
        Intrinsics.checkNotNullParameter("2", "recommendType");
        a0 r104 = c();
        String r105 = b(VoiceSettingLegacyTraceEvent.RECOMMEND_REQUEST_LOAD_TIME);
        e0 r106 = new e0();
        j.b(r106, e(VoiceSettingLegacyTraceKey.TIME), Long.valueOf(r100));
        j.c(r106, e(VoiceSettingLegacyTraceKey.REQUEST_TYPE), r101.getType());
        j.b(r106, e(VoiceSettingLegacyTraceKey.SUCCESS), Integer.valueOf(r102));
        String r107 = e(VoiceSettingLegacyTraceKey.PRELOAD);
        if (r103 == false) goto L5;
        String r108 = i.a(VoiceSettingLegacyTraceValue.STRING_1);
    L6:
        j.c(r106, r107, r108);
        j.c(r106, e(VoiceSettingLegacyTraceKey.RECOMMEND_TYPE), "2");
        j.b(r106, e(VoiceSettingLegacyTraceKey.IS_MAIN_BOT), Integer.valueOf(r110 ? 1 : 0));
        Unit r109 = Unit.INSTANCE;
        r104.a(r105, r106.a());
        return;
    L5:
        r108 = i.a(VoiceSettingLegacyTraceValue.STRING_0);
        goto L6
    }

    public static void i(SpeakerVoice r110, s r111, String r112, String r113, String r210, String r211, Boolean r212, int r213) {
        if ((r213 & 2) == 0) goto L5;
        s r100 = null;
    L7:
        if ((r213 & 4) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r213 & 8) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r213 & 32) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r213 & 64) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r213 & 128) == 0) goto L25;
        Boolean r105 = null;
    L26:
        if (r110 == null) goto L52;
        String r106 = d(r110);
        String r107 = r110.getId();
        if (Intrinsics.areEqual(r102, i.a(VoiceSettingLegacyTraceValue.TTS_DISABLED)) == false) goto L31;
        String r108 = i.a(VoiceSettingLegacyTraceValue.PREVIOUS_PAGE_CHAT);
    L33:
        if (r110.isUgcVoice() == false) goto L35;
        String r114 = i.a(VoiceSettingLegacyTraceValue.VOICE_TYPE_SELF_CREATE);
    L36:
        String r115 = "";
        if (r100 == null) goto L40;
        String r116 = r100.f514019a;
        if (r116 == null) goto L40;
    L41:
        if (r100 == null) goto L46;
        String r109 = r100.f514020b;
        if (r109 == null) goto L46;
        r115 = r109;
    L46:
        String r117 = r110.getName();
        String r118 = r110.getStyleId();
        String r119 = r110.getStyleId();
        d0 r120 = new d0(new LinkedHashMap());
        Intrinsics.checkNotNullParameter(r120, "params");
        Pair[] r121 = new Pair[15];
        r121[0] = x.j("click_from", r101);
        r121[1] = x.j("current_page", "bot_voice_change");
        r121[2] = x.j("is_public", r106);
        r121[3] = x.j("previous_page", r108);
        r121[4] = x.j("recommend_from", r116);
        r121[5] = x.j("req_id", r115);
        r121[6] = x.j("voice_id", r107);
        r121[7] = x.j("speaker_id", r118);
        r121[8] = x.j("speaker_name", r117);
        r121[9] = x.j("voice_type", r114);
        r121[10] = x.j("enter_method", r102);
        r121[11] = x.j("scene", r103);
        r121[12] = x.j("to_tts_speaker", r119);
        r121[13] = x.j("bot_id", r104);
        if (r105 == null) goto L49;
        Pair r122 = TuplesKt.to("is_best_match", k.b(Integer.valueOf(r105.booleanValue() ? 1 : 0)));
    L50:
        r121[14] = r122;
        x.i("voice_cell_show", r120, CollectionsKt.listOfNotNull(r121));
        return;
    L49:
        r122 = null;
    L40:
        r116 = "";
        goto L41
    L35:
        r114 = i.a(VoiceSettingLegacyTraceValue.VOICE_TYPE_DEFAULT);
        goto L36
    L31:
        r108 = null;
        goto L33
    L52:
        return;
    L25:
        r105 = r212;
        goto L26
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    @Override // p2a.d
    public final void a(SpeakerVoice r210, String r211, boolean r212, String r213, String r214, String r215, String r216, String r217, String r310, String r311, Float r312, Float r313, Integer r314, String r315, String r316, String r317, String r318, String r319, String r410, String r411, String r412, d0 r413) {
        Intrinsics.checkNotNullParameter(r413, "params");
        a0 r110 = c();
        String r111 = b(VoiceSettingLegacyTraceEvent.CHANGE_VOICE);
        e0 r112 = new e0();
        Iterator<Map.Entry<String, ouc.i>> r113 = r413.entrySet().iterator();
    L4:
        if (r113.hasNext() == false) goto L6;
        Map.Entry<String, ouc.i> r114 = r113.next();
        a0 r218 = r110;
        r112.b(r114.getKey(), r114.getValue());
        r110 = r218;
        goto L4
    L6:
        a0 r219 = r110;
        if (r211 == null) goto L9;
        j.c(r112, e(VoiceSettingLegacyTraceKey.BOT_ID), r211);
    L9:
        if (r213 == null) goto L12;
        j.c(r112, e(VoiceSettingLegacyTraceKey.ENTER_FROM), r213);
    L12:
        if (r210 == null) goto L30;
        String r100 = e(VoiceSettingLegacyTraceKey.VOICE_TYPE);
        if (r210.isUgcVoice() == false) goto L16;
        String r115 = i.a(VoiceSettingLegacyTraceValue.TRACE_SELF_CREATE);
    L17:
        j.c(r112, r100, r115);
        j.c(r112, e(VoiceSettingLegacyTraceKey.VOICE_ID), r210.getId());
        j.c(r112, e(VoiceSettingLegacyTraceKey.TO_TTS_SPEAKER), r210.getStyleId());
        j.c(r112, "is_public", d(r210));
        if (r210.getBestMatch() == false) goto L20;
        String r101 = "1";
    L21:
        j.c(r112, "is_best_match", r101);
        List<MixVoice> r102 = r210.getMixVoiceList();
        if (r102 == null) goto L24;
        int r103 = r102.size();
    L26:
        if (r103 <= 1) goto L28;
        String r104 = "mixed voice";
    L29:
        j.c(r112, "speaker_name", r104);
        j.c(r112, "speaker_id", r210.getStyleId());
        j.c(r112, "speaker_name", r210.getName());
        goto L30
    L28:
        r104 = r210.getName();
        goto L29
    L24:
        r103 = 0;
        goto L26
    L20:
        r101 = "0";
        goto L21
    L16:
        r115 = i.a(VoiceSettingLegacyTraceValue.TRACE_DEFAULT);
    L30:
        j.b(r112, e(VoiceSettingLegacyTraceKey.IF_AUTO), Integer.valueOf(r212 ? 1 : 0));
        if (r217 == null) goto L33;
        j.c(r112, "recommend_from", r217);
    L33:
        if (r310 == null) goto L35;
        j.c(r112, "req_id", r310);
    L35:
        if (r317 == null) goto L37;
        j.c(r112, BdpAppEventConstant.PARAMS_CLICK_POSITION, r317);
    L37:
        if (r319 == null) goto L39;
        j.c(r112, com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r319);
    L39:
        if (r318 == null) goto L41;
        j.c(r112, "enter_method", r318);
    L41:
        if (r311 == null) goto L43;
        j.c(r112, "voice_remix_id", r311);
    L43:
        if (r314 == null) goto L45;
        j.b(r112, "voice_origin_cnt", Integer.valueOf(r314.intValue()));
    L45:
        if (r315 == null) goto L47;
        j.c(r112, "if_voice_ratio_default", r315);
    L47:
        if (r316 == null) goto L49;
        j.c(r112, "is_best_match", r316);
    L49:
        if (r312 == null) goto L51;
        j.b(r112, "voice_pitch", Float.valueOf(r312.floatValue()));
    L51:
        if (r313 == null) goto L53;
        j.b(r112, "voice_speed", Float.valueOf(r313.floatValue()));
    L53:
        if (r216 == null) goto L55;
        j.c(r112, "click_from", r216);
    L55:
        if (r214 == null) goto L57;
        j.c(r112, "current_page", r214);
    L57:
        if (r215 == null) goto L60;
        j.c(r112, "previous_page", r215);
    L60:
        if (r410 == null) goto L63;
        j.c(r112, "scene", r410);
    L63:
        if (r411 == null) goto L66;
        j.c(r112, "from_voice_id", r411);
    L66:
        if (r412 == null) goto L68;
        j.c(r112, "Success", r412);
    L68:
        Unit r105 = Unit.INSTANCE;
        r219.a(r111, r112.a());
    }
}
