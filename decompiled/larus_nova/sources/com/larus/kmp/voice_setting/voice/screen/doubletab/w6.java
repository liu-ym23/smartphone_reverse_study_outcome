package com.larus.kmp.voice_setting.voice.screen.doubletab;

import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.kmp.voice_setting.platform.VoiceStringKey;
import com.larus.kmp.voice_setting.voice.mix.VoiceMixPlayVisualState;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes30.dex */
public final class w6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i4 f354758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<m6> f354759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<CoroutineScope> f354760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Boolean> f354761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<SpeakerVoice> f354762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<String> f354763f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<VoiceStringKey, Unit> f354764g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Unit> f354765h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<String, Unit> f354766i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Job f354767j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final e7 f354768k;

    public final void a() {
        Job r100 = this.f354767j;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f354767j = null;
        this.f354768k.b();
    }

    public final void b() {
        e7 r100 = this.f354768k;
        r100.getClass();
        r100.f354289l = CollectionsKt.emptyList();
        r100.f354290m = null;
        r100.f354291n = null;
    }

    public final List<MixVoice> d() {
        if (this.f354761d.invoke().booleanValue() == true) goto L5;
    L7:
        SpeakerVoice r100 = this.f354758a.f354372f;
        if (r100 != null) goto L13;
        r100 = this.f354762e.invoke();
        if (r100 != null) goto L13;
        return CollectionsKt.emptyList();
    L13:
        List<MixVoice> r101 = CollectionsKt.listOf(new MixVoice(r100, 100, false, this.f354763f.invoke(), 4, null));
    L15:
        return o4.a(r101);
    L5:
        if ((!this.f354758a.f354382p.isEmpty()) == false) goto L7;
        r101 = this.f354758a.f354382p;
        goto L15
    }

    public final void c(String r100, Long r101) {
        if (r101 == null) goto L15;
        long r102 = this.f354758a.f354379m;
        if (r101.longValue() == r102) goto L15;
        Function1<String, Unit> r103 = this.f354766i;
        StringBuilder r104 = new StringBuilder("[previewState] clear stale token=");
        r104.append(r101);
        r104.append(" current=");
        r104.append(this.f354758a.f354379m);
        r104.append(" voiceId=");
        String r105 = "";
        if (r100 != null) goto L8;
        r100 = "";
    L8:
        r104.append(r100);
        r104.append(" active=");
        String r106 = this.f354758a.f354375i;
        if (r106 == null) goto L12;
        r105 = r106;
    L12:
        r104.append(r105);
        r103.invoke(r104.toString());
        return;
    L15:
        if (Intrinsics.areEqual(this.f354758a.f354375i, r100) == false) goto L18;
        i4 r107 = this.f354758a;
        String r108 = r107.f354375i;
        r107.b();
        i4 r109 = this.f354758a;
        boolean r110 = ih9.f.a().f489920d;
        s4.c(r109, "previewState:clear", this.f354765h, this.f354766i, s4.b(this.f354758a, r108, null), r110, 16);
        return;
    }

    public final void e(SpeakerVoice r100, com.larus.kmp.voice_setting.voice.editvoice.f r110, String r111, long r112) {
        Intrinsics.checkNotNullParameter(r100, "voice");
        Intrinsics.checkNotNullParameter(r110, "pitchAndRate");
        this.f354768k.c(this.f354759b.invoke(), r100, r110, r111, r112);
    }

    public static void f(w6 r100, String r110, VoiceMixPlayVisualState r111, Long r112, VoiceDoubleTabPreviewIndicatorScope r113, VoiceDoubleTabPreviewSource r114, int r115) {
        if ((r115 & 4) == 0) goto L6;
        r112 = null;
    L6:
        if ((r115 & 8) == 0) goto L9;
        r113 = null;
    L9:
        if ((r115 & 16) == 0) goto L11;
        r114 = null;
    L11:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r111, "state");
        String r116 = "";
        if (r112 != null) goto L14;
    L19:
        i4 r101 = r100.f354758a;
        String r102 = r101.f354375i;
        if (r112 != null) goto L22;
        r101.f354379m++;
    L22:
        r101.f354375i = r110;
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r101.f354376j = r111;
        if (r113 == null) goto L25;
        i4 r103 = r100.f354758a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        r103.f354377k = r113;
    L25:
        if (r114 == null) goto L27;
        i4 r117 = r100.f354758a;
        r117.getClass();
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r117.f354378l = r114;
    L27:
        Function1<String, Unit> r118 = r100.f354766i;
        StringBuilder r119 = new StringBuilder("[previewState] update voiceId=");
        if (r110 != null) goto L30;
        String r120 = "";
    L31:
        r119.append(r120);
        r119.append(", state=");
        r119.append(r111);
        r119.append(", scope=");
        r119.append(r100.f354758a.f354377k);
        r119.append(", source=");
        r119.append(r100.f354758a.f354378l);
        r119.append(", token=");
        r119.append(r100.f354758a.f354379m);
        r119.append(", selectedVoiceId=");
        String r121 = r100.f354758a.f354371e;
        if (r121 == null) goto L35;
        r116 = r121;
    L35:
        r119.append(r116);
        r118.invoke(r119.toString());
        s4.c(r100.f354758a, "previewState:" + r111, r100.f354765h, r100.f354766i, s4.b(r100.f354758a, r102, r110), ih9.f.a().f489920d, 16);
        return;
    L30:
        r120 = r110;
        goto L31
    L14:
        if (r112.longValue() == r100.f354758a.f354379m) goto L19;
        Function1<String, Unit> r122 = r100.f354766i;
        StringBuilder r123 = new StringBuilder("[previewState] skip stale token=");
        r123.append(r112);
        r123.append(" current=");
        r123.append(r100.f354758a.f354379m);
        r123.append(" voiceId=");
        if (r110 != null) goto L18;
        r110 = "";
    L18:
        r123.append(r110);
        r123.append(" state=");
        r123.append(r111);
        r122.invoke(r123.toString());
    }

    /* JADX WARN: Type inference failed for: r13v0, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.v6] */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.q6] */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.r6] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.s6] */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.t6] */
    /* JADX WARN: Type inference failed for: r8v10, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.u6] */
    public w6(i4 r110, com.larus.kmp.voice_setting.voice.component.o r111, p5 r112, com.larus.kmp.voice_setting.voice.component.s1 r113, Function0 r114, Function0 r210, t5 r211, u5 r212, Function0 r213, v5 r214) {
        Intrinsics.checkNotNullParameter(r110, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        Intrinsics.checkNotNullParameter(r111, "repoPort");
        Intrinsics.checkNotNullParameter(r112, "platform");
        Intrinsics.checkNotNullParameter(r113, "lifecycleScope");
        Intrinsics.checkNotNullParameter(r114, "isMixStyleEnabled");
        Intrinsics.checkNotNullParameter(r210, "resolveSelectedVoice");
        Intrinsics.checkNotNullParameter(r211, "selectedTabKey");
        Intrinsics.checkNotNullParameter(r212, "showToast");
        Intrinsics.checkNotNullParameter(r213, "publish");
        Intrinsics.checkNotNullParameter(r214, "logInfo");
        this.f354758a = r110;
        this.f354759b = r112;
        this.f354760c = r113;
        this.f354761d = r114;
        this.f354762e = r210;
        this.f354763f = r211;
        this.f354764g = r212;
        this.f354765h = r213;
        this.f354766i = r214;
        this.f354768k = new e7(r111, new q6(this), new r6(this), new s6(this), new VoiceDoubleTabPreviewController$playback$4(this), new t6(this), new u6(this), new v6(this), r212, r214);
    }
}
