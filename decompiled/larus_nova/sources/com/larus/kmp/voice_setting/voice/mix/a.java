package com.larus.kmp.voice_setting.voice.mix;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.im.FlowRuntime;
import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.kmp.voice_setting.voice.track.VoiceSettingLegacyTraceValue;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a implements v2a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f353751a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static mh9.a f353752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f353753c;

    public a() {
    }

    static {
        f353751a = new a();
        f353752b = new mh9.a(0);
        f353753c = "";
    }

    public final void h() {
        mh9.a r100 = f353752b;
        long r101 = c();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.f513982c != null) goto L5;
        r100 = mh9.a.a(r100, Long.valueOf(r101));
    L5:
        f353752b = r100;
    }

    public static long c() {
        return FlowRuntime.b().a().currentTimeMillis();
    }

    public static String b(SpeakerVoice r100) {
        if (r100.getPrivateStatus() != 1) goto L6;
        return mh9.i.a(VoiceSettingLegacyTraceValue.STRING_1);
    L6:
        return mh9.i.a(VoiceSettingLegacyTraceValue.STRING_0);
    }

    public static String i(SpeakerVoice r100) {
        if (r100.isUgcVoice() == false) goto L6;
        return mh9.i.a(VoiceSettingLegacyTraceValue.VOICE_TYPE_SELF_CREATE);
    L6:
        return mh9.i.a(VoiceSettingLegacyTraceValue.VOICE_TYPE_DEFAULT);
    }

    public final void g(boolean r100, String r101) {
        String r102 = f353753c;
        String r103 = f353752b.f513980a;
        Integer r104 = Integer.valueOf(r100 ? 1 : 0);
        ouc.d0 r105 = new ouc.d0(new LinkedHashMap());
        Intrinsics.checkNotNullParameter(r105, "params");
        mh9.x.i("voice_mix_bar_show", r105, CollectionsKt.listOfNotNull(new Pair[]{mh9.x.j("bot_id", r102), mh9.x.j("voice_remix_id", r103), mh9.x.j("current_page", "bot_voice_change"), mh9.x.b("is_fold", r104), mh9.x.j("unfold_method", r101)}));
    }

    public static void d(w2a.f r110, String r111, SpeakerVoice r112, int r113) {
        String r100 = null;
        if ((r113 & 1) == 0) goto L5;
        w2a.f r101 = null;
    L7:
        if ((r113 & 4) == 0) goto L9;
        SpeakerVoice r102 = null;
    L10:
        String r103 = f353753c;
        if (r101 == null) goto L13;
        Float r104 = Float.valueOf(r101.f558070d / 10.0f);
    L14:
        if (r101 == null) goto L16;
        Float r105 = Float.valueOf(r101.f558071e / 10.0f);
    L17:
        if (r101 == null) goto L21;
        List<MixVoice> r106 = r101.f558067a;
        if (r106 == null) goto L26;
        String r107 = gh9.b.a(r106);
    L27:
        if (r101 == null) goto L29;
        List<MixVoice> r108 = r101.f558067a;
    L30:
        String r109 = gh9.b.b(r108);
        if (r101 == null) goto L37;
        List<MixVoice> r114 = r101.f558067a;
        if (r114 == null) goto L35;
        int r115 = r114.size();
    L36:
        Integer r116 = Integer.valueOf(r115);
    L38:
        if (r102 == null) goto L40;
        String r117 = r102.getId();
    L41:
        if (r102 == null) goto L43;
        String r118 = b(r102);
    L44:
        if (r102 == null) goto L46;
        String r119 = i(r102);
    L47:
        String r120 = f353752b.f513980a;
        if (r102 == null) goto L50;
        String r121 = r102.getName();
    L51:
        if (r102 == null) goto L53;
        r100 = r102.getStyleId();
    L53:
        ouc.d0 r122 = new ouc.d0(new LinkedHashMap());
        Intrinsics.checkNotNullParameter(r122, "params");
        mh9.x.i("voice_audition", r122, CollectionsKt.listOfNotNull(new Pair[]{mh9.x.j("voice_id", r117), mh9.x.j("bot_id", r103), mh9.x.j("click_from", r111), mh9.x.a("voice_pitch", r104), mh9.x.a("voice_speed", r105), mh9.x.b("voice_origin_cnt", r116), mh9.x.j("if_voice_ratio_default", r109), mh9.x.j("voice_remix_id", r120), mh9.x.j("is_best_match", r107), mh9.x.j("is_public", r118), mh9.x.j("voice_type", r119), mh9.x.j("speaker_id", r100), mh9.x.j("speaker_name", r121)}));
        return;
    L50:
        r121 = null;
        goto L51
    L46:
        r119 = null;
        goto L47
    L43:
        r118 = null;
        goto L44
    L40:
        r117 = null;
        goto L41
    L35:
        r115 = 0;
        goto L36
    L37:
        r116 = null;
        goto L38
    L29:
        r108 = null;
    L26:
        r107 = null;
        goto L27
    L21:
        if (r102 == null) goto L26;
        if (r102.getBestMatch() == false) goto L25;
        r107 = "1";
        goto L27
    L25:
        r107 = "0";
        goto L27
    L16:
        r105 = null;
        goto L17
    L13:
        r104 = null;
        goto L14
    L9:
        r102 = r112;
        goto L10
    L5:
        r101 = r110;
        goto L7
    }

    public final void e(String r110, String r111, String r112, SpeakerVoice r113) {
        String r100 = f353753c;
        String r101 = b(r113);
        String r102 = r113.getId();
        String r103 = i(r113);
        if (r113.getBestMatch() == false) goto L5;
        String r104 = "1";
    L6:
        String r105 = f353752b.f513980a;
        String r106 = r113.getStyleId();
        String r114 = r113.getName();
        ouc.d0 r107 = new ouc.d0(new LinkedHashMap());
        Intrinsics.checkNotNullParameter(r107, "params");
        mh9.x.i("voice_cell_function_click", r107, CollectionsKt.listOfNotNull(new Pair[]{mh9.x.j("voice_id", r102), mh9.x.j("bot_id", r100), mh9.x.j("voice_remix_id", r105), mh9.x.j("current_page", "bot_voice_change"), mh9.x.j("click_from", r110), mh9.x.j(BdpAppEventConstant.PARAMS_CLICK_POSITION, r111), mh9.x.j("current_tab", r112), mh9.x.j("is_best_match", r104), mh9.x.j("is_public", r101), mh9.x.j("voice_type", r103), mh9.x.j("speaker_id", r106), mh9.x.j("speaker_name", r114)}));
        return;
    L5:
        r104 = "0";
        goto L6
    }

    public static void f(boolean r100, String r101, String r102, String r103, String r104) {
        String r105 = f353753c;
        String r106 = f353752b.f513980a;
        Integer r107 = Integer.valueOf(r100 ? 1 : 0);
        ouc.d0 r108 = new ouc.d0(new LinkedHashMap());
        Intrinsics.checkNotNullParameter(r108, "params");
        mh9.x.i("voice_mix_bar_click", r108, CollectionsKt.listOfNotNull(new Pair[]{mh9.x.j("bot_id", r105), mh9.x.j("voice_remix_id", r106), mh9.x.j("voice_id", r101), mh9.x.b("is_fold", r107), mh9.x.j("click_from", r102), mh9.x.j("speaker_id", r103), mh9.x.j("speaker_name", r104)}));
    }

    @Override // v2a.b
    public final void a(w2a.f r210, String r211, String r212, String r213, SpeakerVoice r310, String r311) {
        Intrinsics.checkNotNullParameter(r211, "previousPage");
        Intrinsics.checkNotNullParameter(r213, "scene");
        if (r210 != null) goto L5;
        return;
    L5:
        List<MixVoice> r100 = r210.f558067a;
        if (r100 != null) goto L8;
    L10:
        if (r100 == null) goto L14;
        MixVoice r101 = (MixVoice) CollectionsKt.firstOrNull(r100);
        if (r101 == null) goto L14;
        SpeakerVoice r102 = r101.getVoiceItem();
    L15:
        com.larus.kmp.voice_setting.voice.base.d r103 = com.larus.kmp.voice_setting.voice.base.d.f351783a;
        String r104 = f353753c;
        String r110 = f353752b.f513980a;
        float r111 = r210.f558070d / 10.0f;
        float r112 = r210.f558071e / 10.0f;
        List<MixVoice> r105 = r210.f558067a;
        if (r105 == null) goto L18;
        int r113 = r105.size();
    L19:
        String r114 = gh9.b.b(r210.f558067a);
        String r115 = gh9.b.a(r210.f558067a);
        Integer r106 = r210.f558075i;
        if (r106 == null) goto L22;
        String r107 = String.valueOf(r106.intValue() + 1);
    L23:
        p2a.d.a.a(r103, r102, r104, false, null, r211, r311, null, null, r110, Float.valueOf(r111), Float.valueOf(r112), Integer.valueOf(r113), r114, r115, r107, null, null, r213, r212, null, null, 3342732);
        return;
    L22:
        r107 = null;
        goto L23
    L18:
        r113 = 0;
    L14:
        r102 = null;
        goto L15
    L8:
        if (r100.size() <= 1) goto L10;
        r102 = r310;
        goto L15
    }
}
