package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.content.Context;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.larus.nova.R;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.audio.voiceinput.VoiceInputSpeechScene;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f430596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f430597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f430598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.audio.voiceinput.p f430599d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f430600e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final s f430601f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f430602g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f430603h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f430604i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function1<Context, CharSequence> f430605j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f430606k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final t f430607l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Float f430608m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.d f430609n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f430610o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Map<String, String> f430611p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Function0<Boolean> f430612q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final VoiceInputSpeechScene f430613r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final a0 f430614s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f430615t;

    public w() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (this.f430596a == r101.f430596a) goto L12;
        return false;
    L12:
        if (this.f430597b == r101.f430597b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f430598c, r101.f430598c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f430599d, r101.f430599d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f430600e, r101.f430600e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f430601f, r101.f430601f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f430602g, r101.f430602g) == true) goto L30;
        return false;
    L30:
        if (this.f430603h == r101.f430603h) goto L33;
        return false;
    L33:
        if (this.f430604i == r101.f430604i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f430605j, r101.f430605j) == true) goto L39;
        return false;
    L39:
        if (this.f430606k == r101.f430606k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f430607l, r101.f430607l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f430608m, r101.f430608m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f430609n, r101.f430609n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f430610o, r101.f430610o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f430611p, r101.f430611p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f430612q, r101.f430612q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f430613r, r101.f430613r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f430614s, r101.f430614s) == true) goto L66;
        return false;
    L66:
        if (this.f430615t == r101.f430615t) goto L68;
        return false;
    L68:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f430596a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f430597b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (((((((((r102 + r103) * 31) + this.f430598c.hashCode()) * 31) + this.f430599d.hashCode()) * 31) + this.f430600e.hashCode()) * 31) + this.f430601f.hashCode()) * 31;
        String r105 = this.f430602g;
        int r106 = 0;
        if (r105 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (((r104 + r107) * 31) + this.f430603h) * 31;
        if (this.f430604i == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (r108 + r109) * 31;
        Function1<Context, CharSequence> r111 = this.f430605j;
        if (r111 != null) goto L21;
        int r112 = 0;
    L22:
        int r113 = (r110 + r112) * 31;
        if (this.f430606k == false) goto L25;
        int r114 = 1231;
    L26:
        int r115 = (((r113 + r114) * 31) + this.f430607l.hashCode()) * 31;
        Float r116 = this.f430608m;
        if (r116 != null) goto L29;
        int r117 = 0;
    L30:
        int r118 = (r115 + r117) * 31;
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.d r119 = this.f430609n;
        if (r119 != null) goto L33;
        int r120 = 0;
    L34:
        int r121 = (((((r118 + r120) * 31) + this.f430610o.hashCode()) * 31) + this.f430611p.hashCode()) * 31;
        Function0<Boolean> r122 = this.f430612q;
        if (r122 != null) goto L37;
        int r123 = 0;
    L38:
        int r124 = (r121 + r123) * 31;
        VoiceInputSpeechScene r125 = this.f430613r;
        if (r125 == null) goto L42;
        r106 = r125.hashCode();
    L42:
        int r126 = (((r124 + r106) * 31) + this.f430614s.hashCode()) * 31;
        if (this.f430615t == true) goto L47;
        r100 = 1237;
    L47:
        return r126 + r100;
    L37:
        r123 = r122.hashCode();
        goto L38
    L33:
        r120 = r119.hashCode();
        goto L34
    L29:
        r117 = r116.hashCode();
        goto L30
    L25:
        r114 = 1237;
        goto L26
    L21:
        r112 = r111.hashCode();
        goto L22
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = r105.hashCode();
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ImmersiveVoiceInputConfig(isEnableVoiceInputSdk=" + this.f430596a + ", isAsrNerEnable=" + this.f430597b + ", appLocale=" + this.f430598c + ", voiceInputModeWithScene=" + this.f430599d + ", psdaToken=" + this.f430600e + ", resultConsumer=" + this.f430601f + ", chatId=" + this.f430602g + ", keyboardEntranceLayoutId=" + this.f430603h + ", autoSendOnRecognizeFinish=" + this.f430604i + ", onlyAsrRecognizingTipsProvider=" + this.f430605j + ", hidePopupOnReleaseKeepSession=" + this.f430606k + ", buttonConfig=" + this.f430607l + ", customOvalHeightDp=" + this.f430608m + ", popupContainerProvider=" + this.f430609n + ", hitPointPageScene=" + this.f430610o + ", extraAnalyticParams=" + this.f430611p + ", canFindContainerFromActivity=" + this.f430612q + ", speechScene=" + this.f430613r + ", keyboardMenuConfig=" + this.f430614s + ", markdownEnable=" + this.f430615t + ')';
    }

    public w(boolean r110, String r111, com.ss.android.lark.audio.voiceinput.p r112, String r210, s r211, com.bytedance.ee.bear.middleground.comment.audio.voiceinput.b r212, Map r213, Function0 r214, VoiceInputSpeechScene r215, a0 r216, boolean r217, int r218) {
        if ((r218 & 16) == 0) goto L5;
        String r100 = "LARK-PSDA-messenger_record_audio";
    L7:
        if ((r218 & 128) == 0) goto L9;
        int r101 = R.layout.layout_immersive_voice_keyboard;
    L11:
        if ((r218 & 2048) == 0) goto L13;
        t r102 = new t(((VoiceTextSetting) SettingManager.getInstance().get(VoiceTextSetting.class)).chatPageVoiceButtonText);
    L15:
        if ((r218 & 8192) == 0) goto L17;
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.b r113 = null;
    L19:
        if ((r218 & 16384) == 0) goto L21;
        String r114 = PullConfiguration.PROCESS_NAME_MAIN;
    L23:
        if ((32768 & r218) == 0) goto L25;
        Map r115 = new LinkedHashMap();
    L27:
        if ((65536 & r218) == 0) goto L29;
        Function0 r116 = null;
    L31:
        if ((131072 & r218) == 0) goto L33;
        VoiceInputSpeechScene r117 = null;
    L35:
        if ((262144 & r218) == 0) goto L37;
        a0 r118 = new a0(3);
    L39:
        if ((r218 & 524288) == 0) goto L41;
        boolean r103 = false;
    L42:
        Intrinsics.checkNotNullParameter(r111, "appLocale");
        Intrinsics.checkNotNullParameter(r112, "voiceInputModeWithScene");
        Intrinsics.checkNotNullParameter(r100, "psdaToken");
        Intrinsics.checkNotNullParameter(r211, "resultConsumer");
        Intrinsics.checkNotNullParameter(r102, "buttonConfig");
        Intrinsics.checkNotNullParameter(r114, "hitPointPageScene");
        Intrinsics.checkNotNullParameter(r115, "extraAnalyticParams");
        Intrinsics.checkNotNullParameter(r118, "keyboardMenuConfig");
        this.f430596a = true;
        this.f430597b = r110;
        this.f430598c = r111;
        this.f430599d = r112;
        this.f430600e = r100;
        this.f430601f = r211;
        this.f430602g = null;
        this.f430603h = r101;
        this.f430604i = false;
        this.f430605j = null;
        this.f430606k = false;
        this.f430607l = r102;
        this.f430608m = null;
        this.f430609n = r113;
        this.f430610o = r114;
        this.f430611p = r115;
        this.f430612q = r116;
        this.f430613r = r117;
        this.f430614s = r118;
        this.f430615t = r103;
        return;
    L41:
        r103 = r217;
        goto L42
    L37:
        r118 = r216;
        goto L39
    L33:
        r117 = r215;
        goto L35
    L29:
        r116 = r214;
        goto L31
    L25:
        r115 = r213;
        goto L27
    L21:
        r114 = null;
        goto L23
    L17:
        r113 = r212;
        goto L19
    L13:
        r102 = null;
        goto L15
    L9:
        r101 = 0;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
