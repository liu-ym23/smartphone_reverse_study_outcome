package com.larus.kmp.voice_setting.voice.screen.doubletab;

import com.larus.im.bean.bot.AudioPreview;
import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.kmp.voice_setting.platform.VoiceStringKey;
import com.larus.kmp.voice_setting.voice.mix.VoiceMixPlayVisualState;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes30.dex */
public final class e7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h7 f354278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<com.larus.kmp.voice_setting.voice.component.v4> f354279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<p6> f354280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<com.larus.kmp.voice_setting.voice.editvoice.f> f354281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<List<MixVoice>> f354282e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Long> f354283f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function3<String, VoiceMixPlayVisualState, Long, Unit> f354284g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function2<String, Long, Unit> f354285h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<VoiceStringKey, Unit> f354286i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function1<String, Unit> f354287j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Job f354288k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<MixVoice> f354289l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.larus.kmp.voice_setting.voice.editvoice.f f354290m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public gh9.a f354291n;

    public final void b() {
        Job r100 = this.f354288k;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f354288k = null;
    }

    public static final Object a(e7 r210, List r211, com.larus.kmp.voice_setting.voice.editvoice.f r212, Continuation r213) {
        List r100 = r211;
        com.larus.kmp.voice_setting.voice.editvoice.f r101 = r212;
        r210.getClass();
        if ((r213 instanceof VoiceDoubleTabPreviewPlaybackCoordinator$generatePreviewVoice$1) == false) goto L7;
        VoiceDoubleTabPreviewPlaybackCoordinator$generatePreviewVoice$1 r102 = (VoiceDoubleTabPreviewPlaybackCoordinator$generatePreviewVoice$1) r213;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        String r110 = "";
        String r111 = null;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        com.larus.kmp.voice_setting.voice.editvoice.f r107 = (com.larus.kmp.voice_setting.voice.editvoice.f) r102.L$1;
        List r108 = (List) r102.L$0;
        ResultKt.throwOnFailure(r104);
        r101 = r107;
        r100 = r108;
    L89:
        gh9.a r109 = (gh9.a) r104;
        if (r109 == null) goto L92;
        r210.f354289l = o4.a(r100);
        r210.f354290m = r101;
        r210.f354291n = r109;
    L92:
        Function1<String, Unit> r112 = r210.f354287j;
        StringBuilder r113 = new StringBuilder("[previewGenerate] result mixed=");
        if (r109 == null) goto L95;
        Boolean r114 = Boxing.boxBoolean(r109.f481316e);
    L96:
        r113.append(r114);
        r113.append(" style=");
        if (r109 == null) goto L99;
        String r115 = r109.f481312a;
    L100:
        if (r115 != null) goto L102;
        r115 = "";
    L102:
        r113.append(r115);
        r113.append(" hasUrl=");
        if (r109 == null) goto L105;
        String r116 = r109.f481314c;
    L106:
        if (r116 != null) goto L108;
    L111:
        boolean r117 = true;
        boolean r118 = true;
    L112:
        r113.append(r117 ^ r118);
        r113.append(" md5=");
        if (r109 == null) goto L115;
        r111 = r109.f481315d;
    L115:
        if (r111 == null) goto L118;
        r110 = r111;
    L118:
        r113.append(r110);
        r112.invoke(r113.toString());
        return r109;
    L108:
        if (StringsKt.isBlank(r116) == true) goto L111;
        r117 = true;
        r118 = false;
        goto L112
    L105:
        r116 = null;
        goto L106
    L99:
        r115 = null;
        goto L100
    L95:
        r114 = null;
        goto L96
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        if (r211.isEmpty() == true) goto L120;
        r210.f354287j.invoke("[previewGenerate] start size=" + r211.size() + " voices=" + o4.b(r211) + " pitch=" + r101.f353255a + " rate=" + r101.f353256b);
        if (r211.size() != 1) goto L55;
        MixVoice r119 = (MixVoice) CollectionsKt.firstOrNull(r211);
        if (r119 == null) goto L120;
        SpeakerVoice r120 = r119.getVoiceItem();
        if (r120 == null) goto L120;
        Function1<String, Unit> r121 = r210.f354287j;
        StringBuilder r122 = new StringBuilder("[previewGenerate] single voiceId=");
        String r123 = r120.getId();
        if (r123 != null) goto L27;
        r123 = "";
    L27:
        r122.append(r123);
        r122.append(" style=");
        String r124 = r120.getStyleId();
        if (r124 != null) goto L30;
        r124 = "";
    L30:
        r122.append(r124);
        r122.append(" hasUrl=");
        AudioPreview r125 = r120.getPreview();
        if (r125 == null) goto L33;
        String r126 = r125.getPreviewAudio();
    L34:
        if (r126 != null) goto L36;
    L39:
        boolean r127 = true;
    L40:
        r122.append(!r127);
        r121.invoke(r122.toString());
        String r128 = r120.getStyleId();
        AudioPreview r129 = r120.getPreview();
        if (r129 == null) goto L43;
        String r130 = r129.getPreviewText();
    L44:
        AudioPreview r131 = r120.getPreview();
        if (r131 == null) goto L47;
        String r132 = r131.getPreviewAudio();
    L48:
        AudioPreview r133 = r120.getPreview();
        if (r133 == null) goto L51;
        r111 = r133.getMd5();
    L51:
        if (r111 != null) goto L53;
        String r134 = "";
    L121:
        return new gh9.a(r128, r130, r132, r134, false);
    L53:
        r134 = r111;
        goto L121
    L47:
        r132 = null;
        goto L48
    L43:
        r130 = null;
        goto L44
    L36:
        if (StringsKt.isBlank(r126) == true) goto L39;
        r127 = false;
        goto L40
    L33:
        r126 = null;
        goto L34
    L55:
        gh9.a r135 = r210.f354291n;
        if (r135 != null) goto L58;
    L73:
        p6 r136 = r210.f354280c.invoke();
        if (r136 == null) goto L77;
        String r137 = r136.f354573d;
        if (r137 == null) goto L77;
    L83:
        com.larus.kmp.voice_setting.voice.editvoice.b r138 = com.larus.kmp.voice_setting.voice.editvoice.c.a(r100, r101, r137);
        if (r138 != null) goto L86;
        r210.f354287j.invoke("[previewGenerate] null request size=" + r211.size());
        goto L120
    L86:
        r210.f354287j.invoke("[previewGenerate] request language=" + r138.f353246c + " pitch=" + r138.f353244a + " rate=" + r138.f353245b + " voices=" + CollectionsKt.joinToString$default(r138.f353247d, null, null, null, 0, null, new x6(), 31, null));
        CoroutineDispatcher r139 = Dispatchers.getIO();
        VoiceDoubleTabPreviewPlaybackCoordinator$generatePreviewVoice$preview$1 r140 = new VoiceDoubleTabPreviewPlaybackCoordinator$generatePreviewVoice$preview$1(r210, r138, null);
        r102.L$0 = r100;
        r102.L$1 = r101;
        r102.label = 1;
        r104 = BuildersKt.withContext(r139, r140, r102);
        if (r104 != r105) goto L89;
        return r105;
    L77:
        com.larus.kmp.voice_setting.voice.component.v4 r141 = r210.f354279b.invoke();
        if (r141 == null) goto L80;
        r137 = r141.f352583d;
    L81:
        if (r137 != null) goto L83;
        r137 = "";
        goto L83
    L80:
        r137 = null;
        goto L81
    L58:
        if (Intrinsics.areEqual(r210.f354290m, r101) == false) goto L73;
        if (o4.c(r210.f354289l, r100) == false) goto L73;
        Function1<String, Unit> r142 = r210.f354287j;
        StringBuilder r143 = new StringBuilder("[previewGenerate] cacheHit style=");
        String r144 = r135.f481312a;
        if (r144 == null) goto L65;
        r110 = r144;
    L65:
        r143.append(r110);
        r143.append(" hasUrl=");
        String r145 = r135.f481314c;
        if (r145 != null) goto L68;
    L71:
        boolean r146 = true;
    L72:
        r143.append(!r146);
        r142.invoke(r143.toString());
        return r135;
    L68:
        if (StringsKt.isBlank(r145) == true) goto L71;
        r146 = false;
    L120:
        return null;
    L7:
        r102 = new VoiceDoubleTabPreviewPlaybackCoordinator$generatePreviewVoice$1(r210, r213);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.b7] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.kmp.voice_setting.voice.screen.doubletab.c7] */
    public final void c(m6 r100, final SpeakerVoice r110, com.larus.kmp.voice_setting.voice.editvoice.f r111, String r112, final long r113) {
        Intrinsics.checkNotNullParameter(r100, "platform");
        Intrinsics.checkNotNullParameter(r110, "voice");
        Intrinsics.checkNotNullParameter(r111, "pitchAndRate");
        r100.stopAudio();
        r100.d(r110, r111, r112, new b7(this, r110, r113), new c7(this, r110, r113), new d7(this, r110, r113));
    }

    public e7(com.larus.kmp.voice_setting.voice.component.o r100, q6 r101, r6 r102, s6 r103, Function0 r104, t6 r105, u6 r106, v6 r107, u5 r110, v5 r111) {
        Intrinsics.checkNotNullParameter(r100, "repoPort");
        Intrinsics.checkNotNullParameter(r101, "currentArgs");
        Intrinsics.checkNotNullParameter(r102, "currentSnapshot");
        Intrinsics.checkNotNullParameter(r103, "currentPitchAndRate");
        Intrinsics.checkNotNullParameter(r104, "currentDisplayVoiceListForPreview");
        Intrinsics.checkNotNullParameter(r105, "currentPreviewToken");
        Intrinsics.checkNotNullParameter(r106, "updatePreviewState");
        Intrinsics.checkNotNullParameter(r107, "clearPreviewState");
        Intrinsics.checkNotNullParameter(r110, "showToast");
        Intrinsics.checkNotNullParameter(r111, "logInfo");
        this.f354278a = r100;
        this.f354279b = r101;
        this.f354280c = r102;
        this.f354281d = r103;
        this.f354282e = r104;
        this.f354283f = r105;
        this.f354284g = r106;
        this.f354285h = r107;
        this.f354286i = r110;
        this.f354287j = r111;
        this.f354289l = CollectionsKt.emptyList();
    }
}
