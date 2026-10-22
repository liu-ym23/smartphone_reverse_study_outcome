package com.larus.kmp.voice_setting.voice.screen.doubletab;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.kmp.voice_setting.platform.VoiceStringKey;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class m4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i4 f354486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<m6> f354487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w6 f354488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<String, Unit> f354489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<String, Unit> f354490e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f354491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<String, Unit> f354492g;

    public final int c() {
        boolean r100 = false;
        if (((ArrayList) this.f354486a.f354382p).isEmpty() == false) goto L5;
        return 0;
    L5:
        List<MixVoice> r101 = this.f354486a.f354382p;
        if ((r101 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r102 = r101.iterator();
    L12:
        if (r102.hasNext() == false) goto L21;
        SpeakerVoice r103 = ((MixVoice) r102.next()).getVoiceItem();
        if (r103 != null) goto L16;
    L18:
        boolean r104 = false;
    L19:
        if (r104 == false) goto L12;
        r100 = true;
        goto L21
    L16:
        if (r103.getAllowMix() == true) goto L18;
        r104 = true;
    L21:
        if (r100 == false) goto L29;
        return 2;
    L29:
        return 1;
    L8:
        if (r101.isEmpty() == false) goto L10;
        goto L10
    }

    public final boolean b(SpeakerVoice r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = c();
        if (r101 == 0) goto L10;
        if (r101 == 1) goto L12;
        return false;
    L12:
        return r100.getAllowMix();
    L10:
        return true;
    }

    public final boolean d(SpeakerVoice r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "voice");
        Iterator r100 = ((ArrayList) this.f354486a.f354382p).iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L13;
        SpeakerVoice r102 = ((MixVoice) r100.next()).getVoiceItem();
        if (r102 == null) goto L8;
        String r103 = r102.getId();
    L10:
        if (Intrinsics.areEqual(r103, r110.getId()) == true) goto L14;
        r101 = r101 + 1;
    L14:
        String r104 = "";
        if (r101 >= 0) goto L22;
        Function1<String, Unit> r112 = this.f354492g;
        StringBuilder r105 = new StringBuilder("[removeMixVoice] skip missing voiceId=");
        String r113 = r110.getId();
        if (r113 == null) goto L20;
        r104 = r113;
    L20:
        r105.append(r104);
        r105.append(" size=");
        r105.append(((ArrayList) this.f354486a.f354382p).size());
        r112.invoke(r105.toString());
        return false;
    L22:
        if (r111 == false) goto L24;
        com.larus.kmp.voice_setting.voice.mix.a.f353751a.h();
        com.larus.kmp.voice_setting.voice.mix.a.f(this.f354486a.f354389w, r110.getId(), "delete_voice", r110.getStyleId(), r110.getName());
    L24:
        ListProtector.remove(this.f354486a.f354382p, r101);
        this.f354488c.b();
        if (Intrinsics.areEqual(this.f354486a.f354375i, r110.getId()) == false) goto L27;
    L30:
        this.f354487b.invoke().stopAudio();
        this.f354486a.b();
    L32:
        if (((ArrayList) this.f354486a.f354382p).isEmpty() == false) goto L34;
        i4 r114 = this.f354486a;
        r114.f354372f = null;
        r114.f354371e = null;
        com.larus.kmp.voice_setting.voice.editvoice.f r106 = new com.larus.kmp.voice_setting.voice.editvoice.f(0);
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r114.f354373g = r106;
        i4 r115 = this.f354486a;
        r115.f354385s = null;
        r115.f354386t = null;
        r115.f354387u = true;
        r115.f354389w = true;
    L43:
        this.f354486a.a();
        Function1<String, Unit> r116 = this.f354492g;
        StringBuilder r107 = new StringBuilder("[removeMixVoice] voiceId=");
        String r108 = r110.getId();
        if (r108 == null) goto L47;
        r104 = r108;
    L47:
        r107.append(r104);
        r107.append(" index=");
        r107.append(r101);
        r107.append(" size=");
        r107.append(((ArrayList) this.f354486a.f354382p).size());
        r116.invoke(r107.toString());
        i4 r109 = this.f354486a;
        Function0<Unit> r117 = this.f354491f;
        Function1<String, Unit> r118 = this.f354492g;
        String r119 = r110.getId();
        if (r119 != null) goto L50;
    L56:
        Set r120 = SetsKt.emptySet();
    L57:
        s4.c(r109, "removeMixVoice", r117, r118, s4.a(r109, r120, null), true, 16);
        return true;
    L50:
        if ((!StringsKt.isBlank(r119)) == true) goto L53;
        r119 = null;
    L53:
        if (r119 == null) goto L56;
        r120 = SetsKt.setOf(r119);
        if (r120 != null) goto L57;
    L34:
        i4 r121 = this.f354486a;
        MixVoice r122 = (MixVoice) CollectionsKt.firstOrNull(r121.f354382p);
        if (r122 == null) goto L37;
        SpeakerVoice r123 = r122.getVoiceItem();
    L38:
        r121.f354372f = r123;
        i4 r124 = this.f354486a;
        SpeakerVoice r125 = r124.f354372f;
        if (r125 == null) goto L41;
        String r126 = r125.getId();
    L42:
        r124.f354371e = r126;
        this.f354486a.f354387u = false;
        goto L43
    L41:
        r126 = null;
        goto L42
    L37:
        r123 = null;
        goto L38
    L27:
        if (Intrinsics.areEqual(this.f354486a.f354375i, "__mix_preview__") == false) goto L32;
        if (((ArrayList) this.f354486a.f354382p).size() > 1) goto L32;
    L8:
        r103 = null;
        goto L10
    L13:
        r101 = -1;
        goto L14
    }

    public final boolean a(SpeakerVoice r210, String r211, boolean r212, boolean r213) {
        Intrinsics.checkNotNullParameter(r210, "voice");
        String r110 = "";
        if (r212 == true) goto L62;
        if (b(r210) == true) goto L62;
        Function1<String, Unit> r100 = this.f354490e;
        MixVoice r101 = (MixVoice) CollectionsKt.firstOrNull(this.f354486a.f354382p);
        if (r101 == null) goto L9;
        SpeakerVoice r102 = r101.getVoiceItem();
    L10:
        if (r102 != null) goto L12;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == false) goto L18;
        String r104 = r102.getExtra();
    L24:
        String r105 = com.larus.kmp.voice_setting.platform.x.b(VoiceStringKey.LARUS_MODIFY_BOT_VOICE_BOT_TOAST2, new Object[0]);
        if (r104 != null) goto L27;
    L30:
        boolean r106 = true;
    L31:
        if (r106 == false) goto L123;
    L55:
        r100.invoke(r105);
        Function1<String, Unit> r107 = this.f354492g;
        StringBuilder r108 = new StringBuilder("[addMixVoice] reject allowMix voiceId=");
        String r109 = r210.getId();
        if (r109 == null) goto L59;
        r110 = r109;
    L59:
        r108.append(r110);
        r108.append(" allowMix=");
        r108.append(r210.getAllowMix());
        r108.append(" allowStatus=");
        r108.append(c());
        r107.invoke(r108.toString());
        return false;
    L123:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L39
        ouc.i r112 = (ouc.i) ouc.k.n(ouc.a.f526798d.e(r104)).get("toast_fail_text");     // Catch: Throwable -> L39
        if (r112 == null) goto L36;
        String r113 = ouc.k.g(ouc.k.o(r112));     // Catch: Throwable -> L39
    L37:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L39
    L42:
        if (Result.m9455isFailureimpl(r114) == false) goto L44;
        r114 = null;
    L44:
        String r115 = (String) r114;
        if (r115 == null) goto L55;
        if (r115.length() <= 0) goto L49;
        boolean r116 = true;
    L50:
        if (r116 == false) goto L52;
        String r117 = r115;
    L53:
        if (r117 == null) goto L55;
        r105 = r117;
        goto L55
    L52:
        r117 = null;
        goto L53
    L49:
        r116 = false;
        goto L50
    L36:
        r113 = null;
    L39:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L42
    L27:
        if (r104.length() == 0) goto L30;
        r106 = false;
        goto L31
    L18:
        if (r210.getAllowMix() == true) goto L20;
        boolean r119 = true;
    L21:
        if (r119 == false) goto L23;
        r104 = r210.getExtra();
        goto L24
    L23:
        r104 = null;
        goto L24
    L20:
        r119 = false;
        goto L21
    L12:
        if (r102.getAllowMix() == true) goto L14;
        r103 = true;
        goto L15
    L9:
        r102 = null;
    L62:
        if (r212 == false) goto L64;
    L71:
        if (r212 == false) goto L73;
        ((ArrayList) this.f354486a.f354382p).clear();
    L73:
        List<MixVoice> r120 = this.f354486a.f354382p;
        if ((r120 instanceof Collection) == true) goto L76;
    L78:
        Iterator r121 = ((ArrayList) r120).iterator();
    L80:
        if (r121.hasNext() == false) goto L88;
        SpeakerVoice r122 = ((MixVoice) r121.next()).getVoiceItem();
        if (r122 == null) goto L84;
        String r123 = r122.getId();
    L86:
        if (Intrinsics.areEqual(r123, r210.getId()) == false) goto L80;
        boolean r124 = true;
    L89:
        if (r124 == false) goto L96;
        Function1<String, Unit> r125 = this.f354492g;
        StringBuilder r126 = new StringBuilder("[addMixVoice] skip duplicate voiceId=");
        String r127 = r210.getId();
        if (r127 == null) goto L94;
        r110 = r127;
    L94:
        r126.append(r110);
        r126.append(" size=");
        r126.append(((ArrayList) this.f354486a.f354382p).size());
        r125.invoke(r126.toString());
        return false;
    L96:
        i4 r128 = this.f354486a;
        boolean r129 = r128.f354389w;
        if (r213 == false) goto L100;
        if (r129 == false) goto L100;
        boolean r130 = true;
    L101:
        boolean r131 = r130;
        ((ArrayList) r128.f354382p).add(new MixVoice(r210, 100, false, r211, 4, null));
        this.f354486a.f354387u = false;
        if (r131 == false) goto L104;
        this.f354489d.invoke("addMixVoice");
    L104:
        this.f354488c.b();
        i4 r132 = this.f354486a;
        r132.f354385s = r211;
        r132.a();
        Function1<String, Unit> r133 = this.f354492g;
        StringBuilder r134 = new StringBuilder("[addMixVoice] voiceId=");
        String r135 = r210.getId();
        if (r135 != null) goto L107;
        r135 = "";
    L107:
        r134.append(r135);
        r134.append(" tab=");
        if (r211 == null) goto L111;
        r110 = r211;
    L111:
        r134.append(r110);
        r134.append(" byReset=");
        r134.append(r212);
        r134.append(" expandAfterAdd=");
        r134.append(r213);
        r134.append(" expandRequested=");
        r134.append(r131);
        r134.append(" collapsedBefore=");
        r134.append(r129);
        r134.append(" size=");
        r134.append(((ArrayList) this.f354486a.f354382p).size());
        r133.invoke(r134.toString());
        i4 r136 = this.f354486a;
        Function0<Unit> r137 = this.f354491f;
        Function1<String, Unit> r138 = this.f354492g;
        String r139 = r210.getId();
        if (r139 != null) goto L114;
    L120:
        Set r140 = SetsKt.emptySet();
    L121:
        s4.c(r136, "addMixVoice", r137, r138, s4.a(r136, r140, r211), true, 16);
        return true;
    L114:
        if ((!StringsKt.isBlank(r139)) == false) goto L116;
        String r141 = r139;
    L117:
        if (r141 == null) goto L120;
        r140 = SetsKt.setOf(r141);
        if (r140 != null) goto L121;
    L116:
        r141 = null;
    L100:
        r130 = false;
        goto L101
    L84:
        r123 = null;
    L88:
        r124 = false;
        goto L89
    L76:
        if (((ArrayList) r120).isEmpty() == false) goto L78;
    L64:
        if (((ArrayList) this.f354486a.f354382p).size() < 3) goto L71;
        this.f354490e.invoke(com.larus.kmp.voice_setting.platform.x.b(VoiceStringKey.LARUS_MODIFY_BOT_VOICE_BOT_TOAST, new Object[0]));
        Function1<String, Unit> r142 = this.f354492g;
        StringBuilder r143 = new StringBuilder("[addMixVoice] reject max voiceId=");
        String r144 = r210.getId();
        if (r144 == null) goto L69;
        r110 = r144;
    L69:
        r143.append(r110);
        r143.append(" size=");
        r143.append(((ArrayList) this.f354486a.f354382p).size());
        r142.invoke(r143.toString());
        return false;
    }

    public m4(i4 r100, w5 r101, w6 r102, Function1 r103, Function1 r104, Function0 r105, x5 r106) {
        Intrinsics.checkNotNullParameter(r100, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        Intrinsics.checkNotNullParameter(r101, "platform");
        Intrinsics.checkNotNullParameter(r102, "previewController");
        Intrinsics.checkNotNullParameter(r103, "requestEditAreaExpand");
        Intrinsics.checkNotNullParameter(r104, "showToast");
        Intrinsics.checkNotNullParameter(r105, "publish");
        Intrinsics.checkNotNullParameter(r106, "logInfo");
        this.f354486a = r100;
        this.f354487b = r101;
        this.f354488c = r102;
        this.f354489d = r103;
        this.f354490e = r104;
        this.f354491f = r105;
        this.f354492g = r106;
    }
}
