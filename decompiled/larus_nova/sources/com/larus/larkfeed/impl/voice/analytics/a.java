package com.larus.larkfeed.impl.voice.analytics;

import com.ss.android.lark.voiceinput.api.data.model.asr.VoiceAsrState;
import gbc.f;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xac.a f355580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final uac.a f355581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineScope f355582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.larus.larkfeed.impl.voice.service.asr.c f355583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CoroutineDispatcher f355584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f355585f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Job f355586g;

    /* JADX INFO: renamed from: com.larus.larkfeed.impl.voice.analytics.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C4400a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f355587a = null;

        static {
            int[] r100 = new int[VoiceAsrState.values().length];
            r100[VoiceAsrState.Canceled.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[VoiceAsrState.Failed.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[VoiceAsrState.TimedOut.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f355587a = r100;
        }
    }

    public final void d(cbc.c r110) {
        Intrinsics.checkNotNullParameter(r110, "dataObserver");
        xac.a r100 = this.f355580a;
        r100.getClass();
        Intrinsics.checkNotNullParameter("voice_type", "key");
        if (Intrinsics.areEqual(((LinkedHashMap) r100.f563099a).get("voice_type"), "Advanced") == false) goto L5;
        return;
    L5:
        Job r101 = this.f355586g;
        if (r101 == null) goto L8;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L8:
        this.f355586g = BuildersKt.launch$default(this.f355582c, this.f355584e, null, new FlowVoiceAnalyticsTracker$bind$1(this, r110, null), 2, null);
    }

    public a(xac.a r100, uac.a r101, CoroutineScope r102) {
        com.larus.larkfeed.impl.voice.service.asr.c r103 = new com.larus.larkfeed.impl.voice.service.asr.c();
        Intrinsics.checkNotNullParameter(r100, "voiceContext");
        Intrinsics.checkNotNullParameter(r101, "asrConfig");
        Intrinsics.checkNotNullParameter(r102, "scope");
        Intrinsics.checkNotNullParameter(r103, "runtimeConfigResolver");
        this.f355580a = r100;
        this.f355581b = r101;
        this.f355582c = r102;
        this.f355583d = r103;
        this.f355584e = Dispatchers.getIO();
        this.f355585f = new ConcurrentHashMap();
    }

    public static final Object a(a r100, cbc.a r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof FlowVoiceAnalyticsTracker$observeFinalResults$1) == false) goto L7;
        FlowVoiceAnalyticsTracker$observeFinalResults$1 r103 = (FlowVoiceAnalyticsTracker$observeFinalResults$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L12;
        ResultKt.throwOnFailure(r105);
    L18:
        throw new KotlinNothingValueException();
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        i1<Map<String, zac.a>> r108 = r101.getResults();
        b r109 = new b(r100);
        r103.label = 1;
        if (r108.collect(r109, r103) != r106) goto L18;
        return r106;
    L7:
        r103 = new FlowVoiceAnalyticsTracker$observeFinalResults$1(r100, r102);
        goto L8
    }

    public static final Object b(a r100, cbc.a r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof FlowVoiceAnalyticsTracker$observeUnsuccessfulTerminals$1) == false) goto L7;
        FlowVoiceAnalyticsTracker$observeUnsuccessfulTerminals$1 r103 = (FlowVoiceAnalyticsTracker$observeUnsuccessfulTerminals$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L12;
        ResultKt.throwOnFailure(r105);
    L18:
        throw new KotlinNothingValueException();
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        i1<zac.b> r108 = r101.d();
        c r109 = new c(r100);
        r103.label = 1;
        if (r108.collect(r109, r103) != r106) goto L18;
        return r106;
    L7:
        r103 = new FlowVoiceAnalyticsTracker$observeUnsuccessfulTerminals$1(r100, r102);
        goto L8
    }

    public static final void c(a r100, String r101, boolean r102) {
        r100.getClass();
        if (r101 != null) goto L5;
    L7:
        r101 = null;
    L8:
        if (r101 == null) goto L15;
        String r103 = r100.f355585f.remove(r101);
        if (r103 == null) goto L16;
        xac.a r104 = r100.f355580a;
        int r105 = f.f480817a;
        Intrinsics.checkNotNullParameter(r104, "voiceContext");
        Intrinsics.checkNotNullParameter(r101, "sourceId");
        Intrinsics.checkNotNullParameter(r103, "language");
        int r106 = f.f480817a;
        f.b(r104, gbc.c.a.f480812a, f.a(r101, r103, r102, 8));
        return;
    L16:
        return;
    L15:
        return;
    L5:
        if ((!StringsKt.isBlank(r101)) == false) goto L7;
        goto L7
    }
}
