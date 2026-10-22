package com.bytedance.flow_audio.impl.business.tts;

import com.bytedance.flow_audio.api.business.tts.error.FlowAudioAssistantError;
import com.bytedance.flow_audio.api.service.common.IKMPLoggerService;
import com.bytedance.flow_audio.api.tracer.FlowTtsTraceHelper;
import com.bytedance.flow_audio.api.tracer.TtsTracer;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: classes19.dex */
public final class FlowTtsSession implements ow5.a, dx5.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f244061q = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final qw5.a f244062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final rw5.e f244063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f244064d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ow5.b f244065e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f244066f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f244067g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f244068h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Job f244069i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CoroutineScope f244070j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f244071k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f244072l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f244073m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Channel<c> f244074n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Channel<d> f244075o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final dx5.d f244076p;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.flow_audio.impl.business.tts.FlowTtsSession$start$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.flow_audio.impl.business.tts.FlowTtsSession$start$1", f = "FlowTtsSession.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FlowTtsSession this$0;

        public AnonymousClass1(FlowTtsSession r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            FlowTtsSession r101 = this.this$0;
            int r102 = FlowTtsSession.f244061q;
            r101.p3(null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public final void start() {
        n3("start: sessionId=" + this.f244064d);
        BuildersKt.launch$default(this.f244070j, null, null, new AnonymousClass1(this, null), 3, null);
        TtsTracer r100 = FlowTtsTraceHelper.INSTANCE.getTracerByTaskId(this.f244064d);
        if (r100 == null) goto L6;
        r100.startCallSami();
        return;
    }

    public final void stop() {
        if (this.f244068h == false) goto L10;
        n3("tts stop voice synthesize session sessionId=" + this.f244064d);
        Job r100 = this.f244069i;
        if (r100 == null) goto L8;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L8:
        this.f244068h = false;
        BuildersKt.launch$default(this.f244070j, null, null, new FlowTtsSession$ttsStop$1(r100, this, null), 3, null);
        return;
    }

    @Override // ow5.a
    public final String getSessionId() {
        return this.f244064d;
    }

    public final void n3(String r100) {
        pd6.b r101 = pd6.c.f528682a;
        IKMPLoggerService r102 = (IKMPLoggerService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKMPLoggerService.class));
        if (r102 == null) goto L6;
        r102.m1(r100, "kmp_FlowTtsSession");
        return;
    }

    public final void o3(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        n3("start: text=" + r100 + " sessionId=" + this.f244064d);
        BuildersKt.launch$default(this.f244070j, null, null, new FlowTtsSession$startText$1(this, r100, null), 3, null);
        TtsTracer r101 = FlowTtsTraceHelper.INSTANCE.getTracerByTaskId(this.f244064d);
        if (r101 == null) goto L6;
        r101.startCallSami();
        return;
    }

    public final void p3(String r100) {
        if (this.f244068h == false) goto L5;
        return;
    L5:
        n3("start tts voice synthesize session sessionId=" + this.f244064d + " config=" + this.f244062b);
        this.f244068h = true;
        this.f244069i = BuildersKt.launch$default(this.f244070j, null, null, new FlowTtsSession$startTts$job$1(this, r100, null), 3, null);
    }

    @Override // dx5.a
    public final void u(dx5.d r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        H2(r100, null);
    }

    public FlowTtsSession(qw5.a r100, com.bytedance.manager.c r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "audioPlayer");
        this.f244062b = r100;
        this.f244063c = r101;
        String r102 = r100.f534993a;
        this.f244064d = r102;
        this.f244066f = new Object();
        Map<String, String> r103 = r100.getContext();
        if (r103 == null) goto L5;
        String r104 = r103.get("use_lock");
    L6:
        this.f244067g = Intrinsics.areEqual(r104, "true");
        this.f244070j = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
        this.f244074n = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.f244075o = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        dx5.d r105 = new dx5.d(r100);
        this.f244076p = r105;
        Intrinsics.checkNotNullParameter(this, "listener");
        ReentrantLock r106 = r105.f470425f;
        r106.lock();
        r105.f470424e.add(this);     // Catch: Throwable -> L10
        r106.unlock();
        n3("create: sessionId=" + r102);
        return;
    L10:
        th = move-exception;
        r106.unlock();
        throw th;
    L5:
        r104 = null;
        goto L6
    }

    public static final void l3(FlowTtsSession r100, String r101) {
        r100.getClass();
        pd6.b r102 = pd6.c.f528682a;
        IKMPLoggerService r103 = (IKMPLoggerService) pd6.c.a(Reflection.getOrCreateKotlinClass(IKMPLoggerService.class));
        if (r103 == null) goto L6;
        r103.logError(r101, "kmp_FlowTtsSession");
        return;
    }

    @Override // dx5.a
    public final void H2(dx5.d r100, FlowAudioAssistantError r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        StringBuilder r102 = new StringBuilder("tts stopped sessionId=");
        r102.append(this.f244064d);
        r102.append(" error=");
        if (r101 == null) goto L5;
        String r103 = r101.f243689a;
    L6:
        r102.append(r103);
        n3(r102.toString());
        if (this.f244067g == false) goto L18;
        Object r104 = this.f244066f;
        monitor-enter(r104);
        ow5.b r105 = this.f244065e;     // Catch: Throwable -> L15
        if (r105 == null) goto L13;
        r105.A(this, r101);     // Catch: Throwable -> L15
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L13:
        monitor-exit(r104);
    L21:
        if (r101 == null) goto L23;
        this.f244074n.mo10962trySendJP2dKIU(new c.a(new Exception(r101.f243689a), TtsResultFailureSource.NATIVE_TERMINAL_CALLBACK));
    L24:
        SendChannel.a.a(this.f244074n);
        dx5.d r107 = this.f244076p;
        int r108 = dx5.d.f470419i;
        r107.b(true);
        return;
    L23:
        this.f244074n.mo10962trySendJP2dKIU(c.b.f244091a);
    L15:
        th = move-exception;
        throw th;
    L18:
        ow5.b r109 = this.f244065e;
        if (r109 == null) goto L21;
        r109.A(this, r101);
        goto L21
    L5:
        r103 = null;
        goto L6
    }

    @Override // dx5.a
    public final void h3(dx5.d r100, bx5.a r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "didReceiveASREvent");
    }

    @Override // dx5.a
    public final void k0(dx5.d r100, Unit r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "didStart");
        n3("event: didStart sessionId=" + this.f244064d);
    }

    @Override // dx5.a
    public final void z0(dx5.d r100, bx5.c r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "didReceiveTTSEvent");
        if (Intrinsics.areEqual(r101, bx5.c.b.f21360a) == false) goto L6;
        this.f244075o.mo10962trySendJP2dKIU(new d(this.f244064d, new rw5.d(String.valueOf(this.f244071k), new byte[0], false)));
        n3("event: chat index=" + (this.f244071k - 1) + " sessionId=" + this.f244064d);
        return;
    L6:
        if ((r101 instanceof bx5.c.d) == false) goto L25;
        this.f244075o.mo10962trySendJP2dKIU(new d(this.f244064d, new rw5.d(String.valueOf(this.f244071k), new byte[0], false)));
        this.f244071k++;
        n3("event: sentenceBegin index=" + (this.f244071k - 1) + " sessionId=" + this.f244064d);
        nw5.e r102 = ((bx5.c.d) r101).f21362a.f465733a;
        if (r102 != null) goto L10;
        return;
    L10:
        if (this.f244067g == false) goto L21;
        Object r103 = this.f244066f;
        monitor-enter(r103);
        ow5.b r104 = this.f244065e;     // Catch: Throwable -> L18
        if (r104 == null) goto L16;
        r104.i2(this, r102);     // Catch: Throwable -> L18
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L18
    L16:
        monitor-exit(r103);
        return;
    L18:
        th = move-exception;
        throw th;
    L21:
        ow5.b r106 = this.f244065e;
        if (r106 == null) goto L81;
        r106.i2(this, r102);
        return;
    L81:
        return;
    L25:
        if ((r101 instanceof bx5.c.e) == false) goto L44;
        n3("event: sentenceEnd sessionId=" + this.f244064d);
        nw5.b r107 = ((bx5.c.e) r101).f21363a;
        if (r107 != null) goto L29;
        return;
    L29:
        if (this.f244067g == false) goto L40;
        Object r108 = this.f244066f;
        monitor-enter(r108);
        ow5.b r109 = this.f244065e;     // Catch: Throwable -> L37
        if (r109 == null) goto L35;
        r109.w2(this, r107);     // Catch: Throwable -> L37
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L37
    L35:
        monitor-exit(r108);
        return;
    L37:
        th = move-exception;
        throw th;
    L40:
        ow5.b r111 = this.f244065e;
        if (r111 == null) goto L84;
        r111.w2(this, r107);
        return;
    L84:
        return;
    L44:
        if ((r101 instanceof bx5.c.a) == false) goto L53;
        boolean r112 = this.f244072l;
        boolean r113 = !r112;
        if (r112 == true) goto L48;
        this.f244072l = true;
    L48:
        byte[] r114 = ((bx5.c.a) r101).f21359a.f465735c;
        if (r114 != null) goto L51;
        return;
    L51:
        this.f244075o.mo10962trySendJP2dKIU(new d(this.f244064d, new rw5.d(String.valueOf(this.f244071k), r114, r113)));
        this.f244071k++;
        n3("event: audio chunkSize=" + r114.length + " index=" + (this.f244071k - 1) + " sessionId=" + this.f244064d);
        return;
    L53:
        if ((r101 instanceof bx5.c.C0373c) == false) goto L72;
        if (this.f244067g == false) goto L66;
        Object r115 = this.f244066f;
        monitor-enter(r115);
        ow5.b r116 = this.f244065e;     // Catch: Throwable -> L63
        if (r116 == null) goto L61;
        r116.q2(this);     // Catch: Throwable -> L63
        Unit r117 = Unit.INSTANCE;     // Catch: Throwable -> L63
    L61:
        monitor-exit(r115);
    L69:
        SendChannel.a.a(this.f244075o);
        this.f244074n.mo10962trySendJP2dKIU(c.b.f244091a);
        SendChannel.a.a(this.f244074n);
        n3("event: end sessionId=" + this.f244064d);
        return;
    L63:
        th = move-exception;
        throw th;
    L66:
        ow5.b r118 = this.f244065e;
        if (r118 == null) goto L69;
        r118.q2(this);
        goto L69
    L72:
        throw new NoWhenBranchMatchedException();
    }

    public static final Object m3(FlowTtsSession r100, String r101, Continuation r110) {
        r100.getClass();
        if ((r110 instanceof FlowTtsSession$ttsStart$1) == false) goto L7;
        FlowTtsSession$ttsStart$1 r102 = (FlowTtsSession$ttsStart$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L19;
        if (r105 == 1) goto L16;
        if (r105 != 2) goto L15;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L45
    L27:
        r100.n3("finish wait player playing audio sessionId=" + r100.f244064d);     // Catch: Throwable -> L45
        if (r100.f244067g == false) goto L40;
        Object r106 = r100.f244066f;
        monitor-enter(r106);
        ow5.b r112 = r100.f244065e;     // Catch: Throwable -> L37
        if (r112 == null) goto L35;
        r112.S1(r100);     // Catch: Throwable -> L37
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L37
    L35:
        monitor-exit(r106);
    L43:
        r100.f244063c.stop();
        r100.n3("stop voice synthesize task sessionId=" + r100.f244064d);
        return Unit.INSTANCE;
    L37:
        th = move-exception;
        throw th;
    L40:
        ow5.b r107 = r100.f244065e;
        if (r107 == null) goto L43;
        r107.S1(r100);
        goto L43
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        FlowAudioAsyncWaitGroup r108 = (FlowAudioAsyncWaitGroup) r102.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L45
    L24:
        r100.n3("begin wait player playing audio sessionId=" + r100.f244064d);     // Catch: Throwable -> L45
        r102.L$0 = null;     // Catch: Throwable -> L45
        r102.label = 2;     // Catch: Throwable -> L45
        if (r108.a(r102) != r104) goto L27;
        return r104;
    L19:
        ResultKt.throwOnFailure(r111);
        r100.n3("start voice synthesize sessionId=" + r100.f244064d);
        FlowAudioAsyncWaitGroup r114 = new FlowAudioAsyncWaitGroup();
        kotlinx.coroutines.flow.c r109 = kotlinx.coroutines.flow.e.g(new FlowTtsSession$synthesize$1(r100, r101, null));     // Catch: Throwable -> L45
        b r115 = new b(r100, r114);     // Catch: Throwable -> L45
        r102.L$0 = r114;     // Catch: Throwable -> L45
        r102.label = 1;     // Catch: Throwable -> L45
        if (r109.collect(r115, r102) == r104) goto L69;
        r108 = r114;
        goto L24
    L69:
        return r104;
    L45:
        th = move-exception;
        if (r100.f244067g == true) goto L49;
        ow5.b r116 = r100.f244065e;
        if (r116 == null) goto L61;
        r116.S1(r100);
    L61:
        r100.f244063c.stop();
        r100.n3("stop voice synthesize task sessionId=" + r100.f244064d);
        throw th;
    L49:
        monitor-enter(r100.f244066f);
        ow5.b r117 = r100.f244065e;     // Catch: Throwable -> L55
        if (r117 == null) goto L61;
        r117.S1(r100);     // Catch: Throwable -> L55
        Unit r118 = Unit.INSTANCE;     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        throw th;
    L7:
        r102 = new FlowTtsSession$ttsStart$1(r100, r110);
        goto L8
    }
}
