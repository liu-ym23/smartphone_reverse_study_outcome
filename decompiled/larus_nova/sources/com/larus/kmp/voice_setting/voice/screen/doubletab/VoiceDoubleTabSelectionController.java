package com.larus.kmp.voice_setting.voice.screen.doubletab;

import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.kmp.voice_setting.voice.mix.VoiceMixPlayVisualState;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes30.dex */
public final class VoiceDoubleTabSelectionController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i4 f354145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<m6> f354146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VoiceDoubleTabPitchRateController f354147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w6 f354148d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m4 f354149e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<String, Unit> f354150f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f354151g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<String, Unit> f354152h;

    public final boolean c() {
        return this.f354145a.f354383q.a();
    }

    public final SpeakerVoice e() {
        i4 r100 = this.f354145a;
        String r101 = r100.f354371e;
        Object r102 = null;
        if (r101 != null) goto L5;
        return null;
    L5:
        Iterator r103 = SequencesKt.mapNotNull(SequencesKt.flatMap(CollectionsKt.asSequence(r100.f354369c), new n7()), new o7()).iterator();
    L7:
        if (r103.hasNext() == false) goto L12;
        Object r104 = r103.next();
        if (Intrinsics.areEqual(((SpeakerVoice) r104).getId(), r101) == false) goto L7;
        r102 = r104;
    L12:
        return (SpeakerVoice) r102;
    }

    public final void d(SpeakerVoice r100, String r101) {
        this.f354147c.getClass();
        l4 r102 = VoiceDoubleTabPitchRateController.e(r100);
        i4 r103 = this.f354145a;
        com.larus.kmp.voice_setting.voice.editvoice.f r104 = r102.f354457a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r103.f354373g = r104;
        this.f354145a.f354374h = true;
        Function1<String, Unit> r105 = this.f354152h;
        StringBuilder r106 = new StringBuilder("[pitchRate:select:init] reason=");
        r106.append(r101);
        r106.append(" voiceId=");
        String r107 = r100.getId();
        if (r107 != null) goto L5;
        r107 = "";
    L5:
        r106.append(r107);
        r106.append(" source=");
        r106.append(r102.f354459c);
        r106.append(" cacheHit=");
        r106.append(r102.f354458b);
        r106.append(" pitch=");
        r106.append(this.f354145a.f354373g.f353255a);
        r106.append(", rate=");
        r106.append(this.f354145a.f354373g.f353256b);
        r105.invoke(r106.toString());
    }

    public final void b(com.larus.kmp.voice_setting.voice.component.v4 r110, SpeakerVoice r111, String r112, VoiceDoubleTabPreviewSource r210, String r211) {
        String r100 = this.f354145a.f354375i;
        Function1<String, Unit> r101 = this.f354152h;
        StringBuilder r102 = new StringBuilder("[mix:itemClick] reason=");
        r102.append(r211);
        r102.append(" voiceId=");
        String r103 = r111.getId();
        String r104 = "";
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r102.append(r103);
        r102.append(" tab=");
        if (r112 != null) goto L8;
        String r105 = "";
    L9:
        r102.append(r105);
        r102.append(" mixBefore=");
        r102.append(o4.b(this.f354145a.f354382p));
        r102.append(" selectedBefore=");
        String r106 = this.f354145a.f354371e;
        if (r106 != null) goto L12;
        r106 = "";
    L12:
        r102.append(r106);
        r102.append(" activeBefore=");
        if (r100 != null) goto L15;
        String r107 = "";
    L16:
        r102.append(r107);
        r102.append(" playState=");
        r102.append(this.f354145a.f354376j);
        r102.append(" source=");
        r102.append(r210);
        r101.invoke(r102.toString());
        if (r210 != VoiceDoubleTabPreviewSource.EDIT_MIX_ROW) goto L19;
        i4 r108 = this.f354145a;
        w2a.f r109 = i7.a(r108.f354382p, r108.f354373g, r108.f354385s, r110.f352585f, r108.f354386t);
        com.larus.kmp.voice_setting.voice.mix.a r113 = com.larus.kmp.voice_setting.voice.mix.a.f353751a;
        com.larus.kmp.voice_setting.voice.mix.a.f(this.f354145a.f354389w, r111.getId(), "audition", r111.getStyleId(), r111.getName());
        com.larus.kmp.voice_setting.voice.mix.a.d(r109, "voice_mix_bar", r111, 8);
    L29:
        this.f354148d.a();
        if (this.f354145a.f354376j == VoiceMixPlayVisualState.Idle) goto L32;
        this.f354146b.invoke().stopAudio();
        this.f354148d.c(r100, null);
    L32:
        w6.f(this.f354148d, r111.getId(), VoiceMixPlayVisualState.Playing, null, VoiceDoubleTabPreviewIndicatorScope.LIST_AND_MIX_ITEM, r210, 4);
        long r114 = this.f354145a.f354379m;
        w6 r115 = this.f354148d;
        VoiceDoubleTabSelectionController$auditionMixVoice$1 r116 = new VoiceDoubleTabSelectionController$auditionMixVoice$1(this, r111, r110, r114, r112, null);
        r115.getClass();
        Intrinsics.checkNotNullParameter(r116, "block");
        e7 r117 = r115.f354768k;
        CoroutineScope r118 = r115.f354760c.invoke();
        r117.getClass();
        Intrinsics.checkNotNullParameter(r118, "scope");
        Intrinsics.checkNotNullParameter(r116, "block");
        r117.b();
        r117.f354288k = BuildersKt.launch$default(r118, null, null, r116, 3, null);
        return;
    L19:
        com.larus.kmp.voice_setting.voice.mix.a r119 = com.larus.kmp.voice_setting.voice.mix.a.f353751a;
        if (Intrinsics.areEqual(r112, "recommend") == false) goto L23;
        r104 = "rec_tab";
    L28:
        com.larus.kmp.voice_setting.voice.mix.a.d(null, r104, r111, 9);
        goto L29
    L23:
        if (Intrinsics.areEqual(r112, "my") == false) goto L25;
        r104 = "my_tab";
        goto L28
    L25:
        if (r112 == null) goto L28;
        r104 = r112;
        goto L28
    L15:
        r107 = r100;
        goto L16
    L8:
        r105 = r112;
        goto L9
    }

    public final boolean a(com.larus.kmp.voice_setting.voice.component.v4 r110, SpeakerVoice r111, String r112, Integer r113, VoiceDoubleTabPreviewSource r114, String r115) {
        i4 r100 = this.f354145a;
        if (r113 == null) goto L5;
        Integer r116 = Integer.valueOf(r113.intValue() + 1);
    L6:
        r100.f354386t = r116;
        m4 r117 = this.f354149e;
        i4 r101 = this.f354145a;
        if (r101.f354388v == false) goto L9;
    L12:
        boolean r102 = true;
    L14:
        if (r117.a(r111, r112, true, r102) == true) goto L33;
        List<MixVoice> r118 = this.f354145a.f354382p;
        if ((r118 instanceof Collection) == true) goto L18;
    L20:
        Iterator r119 = ((ArrayList) r118).iterator();
    L22:
        if (r119.hasNext() == false) goto L30;
        SpeakerVoice r103 = ((MixVoice) r119.next()).getVoiceItem();
        if (r103 == null) goto L26;
        String r104 = r103.getId();
    L28:
        if (Intrinsics.areEqual(r104, r111.getId()) == false) goto L22;
        boolean r120 = false;
    L31:
        if (r120 == false) goto L33;
        return false;
    L26:
        r104 = null;
    L30:
        r120 = true;
        goto L31
    L18:
        if (((ArrayList) r118).isEmpty() == false) goto L20;
    L33:
        i4 r121 = this.f354145a;
        r121.f354372f = r111;
        r121.f354371e = r111.getId();
        d(r111, "mixVoiceReset");
        this.f354145a.a();
        b(r110, r111, r112, r114, r115);
        return true;
    L9:
        if (((ArrayList) r101.f354382p).size() >= 1) goto L12;
        r102 = false;
        goto L14
    L5:
        r116 = null;
        goto L6
    }

    public VoiceDoubleTabSelectionController(i4 r100, d6 r101, VoiceDoubleTabPitchRateController r102, w6 r103, m4 r104, Function1 r105, Function0 r106, e6 r107) {
        Intrinsics.checkNotNullParameter(r100, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        Intrinsics.checkNotNullParameter(r101, "platform");
        Intrinsics.checkNotNullParameter(r102, "pitchRateController");
        Intrinsics.checkNotNullParameter(r103, "previewController");
        Intrinsics.checkNotNullParameter(r104, "mixController");
        Intrinsics.checkNotNullParameter(r105, "requestEditAreaExpand");
        Intrinsics.checkNotNullParameter(r106, "publish");
        Intrinsics.checkNotNullParameter(r107, "logInfo");
        this.f354145a = r100;
        this.f354146b = r101;
        this.f354147c = r102;
        this.f354148d = r103;
        this.f354149e = r104;
        this.f354150f = r105;
        this.f354151g = r106;
        this.f354152h = r107;
    }
}
