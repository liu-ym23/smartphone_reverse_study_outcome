package com.larus.kmp.voice_setting.voice.screen.doubletab;

import com.larus.disk.api.CacheHandlerBiz;
import com.larus.im.FlowRuntime;
import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.kmp.voice_setting.voice.editvoice.VoicePitchAndRateManager;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes30.dex */
public final class VoiceDoubleTabPitchRateController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i4 f354114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<CoroutineScope> f354115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<String> f354116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<SpeakerVoice> f354117d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f354118e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f354119f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<String, Unit> f354120g;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v4 */
    public static l4 e(SpeakerVoice r110) {
        Intrinsics.checkNotNullParameter(r110, "voice");
        VoicePitchAndRateManager r100 = VoicePitchAndRateManager.f353241a;
        com.larus.kmp.voice_setting.voice.editvoice.f r101 = 0;
        Float r102 = null;
        List r103 = CollectionsKt.listOf(new MixVoice(r110, 0, false, r101, 14, null));
        Intrinsics.checkNotNullParameter(r103, "voiceList");
        if (VoicePitchAndRateManager.a(r103, "peekCachedVoicePitchAndRate") == false) goto L52;
        com.larus.kmp.voice_setting.voice.editvoice.i r104 = VoicePitchAndRateManager.d(r100, r103);
        com.larus.kmp.voice_setting.voice.editvoice.l r105 = com.larus.kmp.voice_setting.voice.editvoice.l.f353268a;
        String r106 = r104.f353265b;
        r105.getClass();
        if (r106 != null) goto L7;
    L10:
        boolean r107 = true;
    L11:
        if (r107 == false) goto L57;
    L26:
        com.larus.kmp.voice_setting.voice.editvoice.f r108 = null;
    L36:
        com.larus.kmp.voice_setting.voice.editvoice.h r109 = r104.f353266c;
        gd9.h r111 = FlowRuntime.b().e();
        StringBuilder r112 = new StringBuilder("[peekCachedVoicePitchAndRate] voiceId is ");
        if (r109 == null) goto L39;
        String r113 = r109.f353260a;
    L40:
        r112.append(r113);
        r112.append(", botId is ");
        r112.append(VoicePitchAndRateManager.f353242b);
        r112.append(", voiceName is ");
        if (r109 == null) goto L43;
        String r114 = r109.f353261b;
    L44:
        r112.append(r114);
        r112.append(", pitchAndRate is ");
        r112.append(r108);
        r112.append(", pitchF64 ");
        if (r108 == null) goto L47;
        Float r115 = Float.valueOf(r108.f353255a);
    L48:
        r112.append(r115);
        r112.append(", speechRateF64 ");
        if (r108 == null) goto L51;
        r102 = Float.valueOf(r108.f353256b);
    L51:
        r112.append(r102);
        r111.i("VoicePitchAndRateManager", r112.toString());
        r101 = r108;
        goto L52
    L47:
        r115 = null;
        goto L48
    L43:
        r114 = null;
        goto L44
    L39:
        r113 = null;
        goto L40
    L57:
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L27
        String r117 = com.larus.kmp.voice_setting.voice.editvoice.l.a().a(r106, "", CacheHandlerBiz.BIZ_VOICE_PITCH_RATE);     // Catch: Throwable -> L27
        if (r117 == null) goto L26;
        if (r117.length() <= 0) goto L18;
        boolean r118 = true;
    L19:
        if (r118 == true) goto L22;
        r117 = null;
    L22:
        if (r117 == null) goto L26;
        Object r119 = Result.m9449constructorimpl(com.larus.kmp.voice_setting.voice.editvoice.g.a(r117));     // Catch: Throwable -> L27
    L29:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);
        if (r120 == null) goto L33;
        com.larus.kmp.voice_setting.voice.editvoice.l.f353268a.getClass();
        ((gd9.h) com.larus.kmp.voice_setting.voice.editvoice.l.f353269b.getValue()).e("VoicePitchAndRateRepo", "[peek] key(" + r106 + ") failed: " + r120.getMessage());
    L33:
        if (Result.m9455isFailureimpl(r119) == false) goto L35;
        r119 = null;
    L35:
        r108 = (com.larus.kmp.voice_setting.voice.editvoice.f) r119;
        goto L36
    L18:
        r118 = false;
    L27:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L29
    L7:
        if (r106.length() == 0) goto L10;
        r107 = false;
    L52:
        if (r101 == 0) goto L56;
        return new l4(r101, true, "repo");
    L56:
        return new l4(c8.a(r110), false, "voice");
    }

    public final boolean a(String r100, String r101) {
        if (r100 == null) goto L34;
        String r102 = null;
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L34;
        String r103 = this.f354114a.f354371e;
        if (r103 != null) goto L13;
    L19:
        SpeakerVoice r104 = this.f354114a.f354372f;
        if (r104 == null) goto L27;
        r103 = r104.getId();
        if (r103 == null) goto L27;
        if ((!StringsKt.isBlank(r103)) == false) goto L27;
    L18:
        r102 = r103;
    L27:
        if (Intrinsics.areEqual(r102, r100) == false) goto L29;
        return true;
    L29:
        Function1<String, Unit> r105 = this.f354120g;
        StringBuilder r106 = new StringBuilder("[pitchRate:skipTargetMismatch] reason=");
        r106.append(r101);
        r106.append(" target=");
        r106.append(r100);
        r106.append(" selected=");
        if (r102 != null) goto L32;
        r102 = "";
    L32:
        r106.append(r102);
        r105.invoke(r106.toString());
        return false;
    L13:
        if ((!StringsKt.isBlank(r103)) == true) goto L16;
        r103 = null;
    L16:
        if (r103 != null) goto L18;
    L34:
        return true;
    }

    public final Object f(SpeakerVoice r110, Continuation<? super com.larus.kmp.voice_setting.voice.editvoice.f> r111) {
        if ((r111 instanceof VoiceDoubleTabPitchRateController$resolvePitchAndRateForVoice$1) == false) goto L7;
        VoiceDoubleTabPitchRateController$resolvePitchAndRateForVoice$1 r100 = (VoiceDoubleTabPitchRateController$resolvePitchAndRateForVoice$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        r110 = (SpeakerVoice) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L17:
        com.larus.kmp.voice_setting.voice.editvoice.f r113 = (com.larus.kmp.voice_setting.voice.editvoice.f) r112;
        if (r113 == null) goto L20;
        return r113;
    L20:
        return c8.a(r110);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        VoicePitchAndRateManager r114 = VoicePitchAndRateManager.f353241a;
        List<MixVoice> r104 = CollectionsKt.listOf(new MixVoice(r110, 0, false, null, 14, null));
        r100.L$0 = r110;
        r100.label = 1;
        r112 = r114.b(r104, r100);
        if (r112 != r102) goto L17;
        return r102;
    L7:
        r100 = new VoiceDoubleTabPitchRateController$resolvePitchAndRateForVoice$1(this, r111);
        goto L8
    }

    public final void b(com.larus.kmp.voice_setting.voice.component.v4 r110, SpeakerVoice r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "args");
        Intrinsics.checkNotNullParameter(r112, "reason");
        if (r111 != null) goto L6;
        this.f354114a.f354374h = true;
        this.f354120g.invoke("[pitchRate:load:skipNoVoice] reason=" + r112);
        return;
    L6:
        this.f354114a.f354374h = false;
        BuildersKt.launch$default(this.f354115b.invoke(), null, null, new VoiceDoubleTabPitchRateController$loadPitchAndRateForSelectedVoice$2(this, r111, r110, r112, null), 3, null);
    }

    public final void d(List<MixVoice> r100, com.larus.kmp.voice_setting.voice.editvoice.f r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "voiceList");
        Intrinsics.checkNotNullParameter(r101, "pitchAndRate");
        Intrinsics.checkNotNullParameter(r102, "reason");
        if (r100.size() == 1) goto L6;
        this.f354120g.invoke("[pitchRate:remember:skipMulti] reason=" + r102 + " size=" + r100.size() + " pitch=" + r101.f353255a + ", rate=" + r101.f353256b);
        return;
    L6:
        MixVoice r103 = (MixVoice) CollectionsKt.firstOrNull(r100);
        String r104 = null;
        if (r103 == null) goto L9;
        SpeakerVoice r105 = r103.getVoiceItem();
    L10:
        Function1<String, Unit> r106 = this.f354120g;
        StringBuilder r107 = new StringBuilder("[pitchRate:remember] reason=");
        r107.append(r102);
        r107.append(" voiceId=");
        if (r105 == null) goto L13;
        String r108 = r105.getId();
    L14:
        String r109 = "";
        if (r108 != null) goto L17;
        r108 = "";
    L17:
        r107.append(r108);
        r107.append(", voiceName=");
        if (r105 == null) goto L20;
        r104 = r105.getName();
    L20:
        if (r104 == null) goto L23;
        r109 = r104;
    L23:
        r107.append(r109);
        r107.append(", pitch=");
        r107.append(r101.f353255a);
        r107.append(", rate=");
        r107.append(r101.f353256b);
        r106.invoke(r107.toString());
        VoicePitchAndRateManager.f353241a.e(r100, r101);
        return;
    L13:
        r108 = null;
        goto L14
    L9:
        r105 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(com.larus.kmp.voice_setting.voice.component.v4 r100, com.larus.kmp.voice_setting.voice.editvoice.f r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "args");
        Intrinsics.checkNotNullParameter(r101, "pitchAndRate");
        Intrinsics.checkNotNullParameter(r102, "reason");
        Object r104 = null;
        if (Intrinsics.areEqual(this.f354114a.f354367a, r100) == true) goto L10;
        Function1<String, Unit> r105 = this.f354120g;
        StringBuilder r106 = new StringBuilder("[pitchRate:remember:skipStale] reason=");
        r106.append(r102);
        r106.append(" argsHash=");
        r106.append(r100.hashCode());
        r106.append(" currentArgsHash=");
        com.larus.kmp.voice_setting.voice.component.v4 r107 = this.f354114a.f354367a;
        if (r107 == null) goto L7;
        r104 = Integer.valueOf(r107.hashCode());
    L7:
        r106.append(r104);
        r105.invoke(r106.toString());
        return;
    L10:
        if (a(r103, "remember:".concat(r102)) == true) goto L12;
        return;
    L12:
        i4 r108 = this.f354114a;
        String r109 = "";
        if (r108.f354374h == true) goto L20;
        Function1<String, Unit> r110 = this.f354120g;
        StringBuilder r111 = new StringBuilder("[pitchRate:remember:skipLoading] reason=");
        r111.append(r102);
        r111.append(" selected=");
        String r112 = this.f354114a.f354371e;
        if (r112 == null) goto L18;
        r109 = r112;
    L18:
        r111.append(r109);
        r111.append(" pitch=");
        r111.append(r101.f353255a);
        r111.append(", rate=");
        r111.append(r101.f353256b);
        r110.invoke(r111.toString());
        return;
    L20:
        SpeakerVoice r113 = r108.f354372f;
        SpeakerVoice r114 = r113;
        if (r113 != null) goto L28;
        MixVoice r115 = (MixVoice) CollectionsKt.firstOrNull(r108.f354382p);
        if (r115 == null) goto L25;
        r104 = r115.getVoiceItem();
    L25:
        if (r104 != null) goto L27;
        r114 = this.f354117d.invoke();
        goto L28
    L27:
        r114 = r104;
    L28:
        if (r114 != 0) goto L35;
        Function1<String, Unit> r116 = this.f354120g;
        StringBuilder r117 = new StringBuilder("[pitchRate:remember:skipNoVoice] reason=");
        r117.append(r102);
        r117.append(" selected=");
        String r118 = this.f354114a.f354371e;
        if (r118 == null) goto L33;
        r109 = r118;
    L33:
        r117.append(r109);
        r116.invoke(r117.toString());
        return;
    L35:
        d(i7.c(this.f354114a.f354383q.a(), this.f354114a.f354382p, r114, this.f354116c.invoke(), true), r101, r102);
    }

    public VoiceDoubleTabPitchRateController(i4 r100, com.larus.kmp.voice_setting.voice.component.s1 r101, b6 r102, Function0 r103, y5 r104, Function0 r105, c6 r106) {
        Intrinsics.checkNotNullParameter(r100, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        Intrinsics.checkNotNullParameter(r101, "lifecycleScope");
        Intrinsics.checkNotNullParameter(r102, "selectedTabKey");
        Intrinsics.checkNotNullParameter(r103, "resolveSelectedVoice");
        Intrinsics.checkNotNullParameter(r104, "clearPreviewCache");
        Intrinsics.checkNotNullParameter(r105, "publish");
        Intrinsics.checkNotNullParameter(r106, "logInfo");
        this.f354114a = r100;
        this.f354115b = r101;
        this.f354116c = r102;
        this.f354117d = r103;
        this.f354118e = r104;
        this.f354119f = r105;
        this.f354120g = r106;
    }
}
