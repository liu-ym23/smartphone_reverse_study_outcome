package com.bytedance.flow_audio.impl.business.asr.core;

import com.bytedance.flow_audio.api.service.common.IKMPLoggerService;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes19.dex */
public final class FlowAsrEventProcessor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f243814f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f243815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f243816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f243817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zw5.a f243818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2<Throwable, Continuation<? super Unit>, Object> f243819e;

    public static final class a {
    }

    static {
        f243814f = zw5.b.a("FlowAsrEventProcessor");
    }

    public static String c(d r100) {
        if ((r100 instanceof d.s) == false) goto L6;
        return "UserCancel(reason=" + ((d.s) r100).f243922a + ')';
    L6:
        if ((r100 instanceof d.g) == false) goto L9;
        return "AudioRecordFailed(" + ((d.g) r100).f243908a.getType() + ')';
    L9:
        if ((r100 instanceof d.j) == false) goto L12;
        return "AudioUplinkFailed(" + ((d.j) r100).f243911a.getType() + ')';
    L12:
        if ((r100 instanceof d.c) == false) goto L15;
        return "AsrResponseReceived";
    L15:
        if ((r100 instanceof d.b) == false) goto L18;
        return "AsrEnded(eventTaskId=" + ((d.b) r100).f243903a.f21351a + ')';
    L18:
        if ((r100 instanceof d.a) == false) goto L21;
        return "AsrEndForceDelayFinished(eventTaskId=" + ((d.a) r100).f243902a.f21351a + ')';
    L21:
        if ((r100 instanceof d.e) == false) goto L24;
        return "AssistantFailed(" + ((d.e) r100).f243906a.getType() + ')';
    L24:
        if (Intrinsics.areEqual(r100, d.C3492d.f243905a) == false) goto L27;
        return "AssistantCanceled";
    L27:
        if ((r100 instanceof d.l) == true) goto L65;
        boolean r101 = false;
        if ((r100 instanceof d.r) == false) goto L36;
        StringBuilder r102 = new StringBuilder("RetryDecisionResolved(canRetry=");
        if (((d.r) r100).f243921b == null) goto L34;
        r101 = true;
    L34:
        r102.append(r101);
        r102.append(')');
        return r102.toString();
    L36:
        if ((r100 instanceof d.q) == false) goto L42;
        StringBuilder r103 = new StringBuilder("RetryAttemptFinished(success=");
        if (((d.q) r100).f243919b != null) goto L40;
        r101 = true;
    L40:
        r103.append(r101);
        r103.append(')');
        return r103.toString();
    L42:
        if ((r100 instanceof d.m) == false) goto L45;
        return "FinalFailureResolved(" + ((d.m) r100).f243914a.getType() + ')';
    L45:
        if ((r100 instanceof d.o) == false) goto L48;
        return "FinalResultBuilt(len=" + ((d.o) r100).f243916a.f496224a.length() + ')';
    L48:
        if ((r100 instanceof d.n) == false) goto L51;
        return "FinalResultAccepted(len=" + ((d.n) r100).f243915a.f496224a.length() + ')';
    L51:
        if ((r100 instanceof d.p) == true) goto L71;
        String r104 = Reflection.getOrCreateKotlinClass(r100.getClass()).getSimpleName();
        if (r104 != null) goto L72;
        return "UnknownEvent";
    L72:
        return r104;
    L71:
        return "FinalResultRejected(" + ((d.p) r100).f243917a.getType() + ')';
    L65:
        return "FailureReady(" + ((d.l) r100).f243913a.getType() + ')';
    }

    public final Object a(d r100, Continuation<? super Unit> r110) {
        if ((r110 instanceof FlowAsrEventProcessor$process$1) == false) goto L7;
        FlowAsrEventProcessor$process$1 r101 = (FlowAsrEventProcessor$process$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        ResultKt.throwOnFailure(r111);
    L32:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r100 = (d) r101.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L24
    L22:
        Object r112 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r112);
        if (r105 == null) goto L32;
        IKMPLoggerService r106 = lp7.a.f510233a;
        lp7.a.b(f243814f, this.f243818d.a("process event failed event=" + c(r100) + ' ' + zw5.b.c(r105)));
        Function2<Throwable, Continuation<? super Unit>, Object> r107 = this.f243819e;
        r101.L$0 = r112;
        r101.label = 2;
        if (r107.invoke(r105, r101) != r103) goto L32;
        return r103;
    L18:
        ResultKt.throwOnFailure(r111);
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L24
        r101.L$0 = r100;     // Catch: Throwable -> L24
        r101.label = 1;     // Catch: Throwable -> L24
        if (b(r100, r101) != r103) goto L22;
        return r103;
    L24:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r101 = new FlowAsrEventProcessor$process$1(this, r110);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00e1 -> B:38:0x00ea). Please report as a decompilation issue!!! */
    public final Object b(d r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof FlowAsrEventProcessor$processInternal$1) == false) goto L7;
        FlowAsrEventProcessor$processInternal$1 r100 = (FlowAsrEventProcessor$processInternal$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        String r104 = " state=";
        if (r103 == 0) goto L20;
        if (r103 == 1) goto L19;
        if (r103 == 2) goto L18;
        if (r103 == 3) goto L17;
        if (r103 != 4) goto L16;
        ResultKt.throwOnFailure(r112);
    L57:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r112);
    L50:
        return Unit.INSTANCE;
    L18:
        boolean r113 = r100.Z$0;
        Iterator<com.bytedance.flow_audio.impl.business.asr.core.a> r105 = (Iterator) r100.L$2;
        e r106 = (e) r100.L$1;
        d r107 = (d) r100.L$0;
        ResultKt.throwOnFailure(r112);
        d r108 = r107;
        String r109 = " state=";
        e r114 = r106;
        Iterator<com.bytedance.flow_audio.impl.business.asr.core.a> r115 = r105;
        Object r116 = r102;
        FlowAsrEventProcessor$processInternal$1 r117 = r100;
        FlowAsrEventProcessor r118 = this;
    L38:
        b r119 = (b) r112;
        if (Intrinsics.areEqual(r119, b.d.f243882a) == false) goto L41;
        FlowAsrEventProcessor r120 = r118;
        r100 = r117;
        r102 = r116;
        Iterator<com.bytedance.flow_audio.impl.business.asr.core.a> r121 = r115;
        e r122 = r114;
        r104 = r109;
        d r123 = r108;
    L33:
        if (r121.hasNext() == false) goto L61;
        com.bytedance.flow_audio.impl.business.asr.core.a r124 = r121.next();
        c r125 = r120.f243817c;
        r100.L$0 = r123;
        r100.L$1 = r122;
        r100.L$2 = r121;
        r100.Z$0 = r113;
        r100.label = 2;
        Object r126 = r125.a(r124, r100);
        if (r126 != r102) goto L37;
        return r102;
    L37:
        FlowAsrEventProcessor$processInternal$1 r127 = r100;
        r118 = r120;
        r112 = r126;
        r108 = r123;
        r109 = r104;
        r114 = r122;
        r115 = r121;
        r116 = r102;
        r117 = r127;
        goto L38
    L61:
        if (r113 == false) goto L64;
        IKMPLoggerService r128 = lp7.a.f510233a;
        lp7.a.c(f243814f, r120.f243818d.a("process event end event=" + c(r123) + " effects=" + r122.f243927a.size() + r104 + r120.f243815a.snapshot().f243883a));
    L64:
        return Unit.INSTANCE;
    L41:
        if (Intrinsics.areEqual(r119, b.c.f243881a) == false) goto L45;
        return Unit.INSTANCE;
    L45:
        if ((r119 instanceof b.C3491b) == false) goto L52;
        d.m r129 = new d.m(((b.C3491b) r119).f243880a);
        r117.L$0 = null;
        r117.L$1 = null;
        r117.L$2 = null;
        r117.label = 3;
        if (r118.b(r129, r117) != r116) goto L50;
        return r116;
    L52:
        if ((r119 instanceof b.a) == false) goto L59;
        d r130 = ((b.a) r119).f243879a;
        r117.L$0 = null;
        r117.L$1 = null;
        r117.L$2 = null;
        r117.label = 4;
        if (r118.b(r130, r117) != r116) goto L57;
        return r116;
    L59:
        throw new NoWhenBranchMatchedException();
    L19:
        boolean r131 = r100.Z$0;
        d r132 = (d) r100.L$0;
        ResultKt.throwOnFailure(r112);
        boolean r133 = r131;
        r110 = r132;
    L31:
        e r134 = (e) r112;
        r123 = r110;
        r113 = r133;
        r121 = r134.f243927a.iterator();
        r122 = r134;
        r120 = this;
        goto L33
    L20:
        ResultKt.throwOnFailure(r112);
        b0 r135 = this.f243815a.snapshot();
        if ((r110 instanceof d.f) == false) goto L23;
    L25:
        r133 = false;
    L26:
        if (r133 == false) goto L28;
        IKMPLoggerService r136 = lp7.a.f510233a;
        lp7.a.c(f243814f, this.f243818d.a("process event begin event=" + c(r110) + " state=" + r135.f243883a));
    L28:
        g r137 = this.f243816b;
        r100.L$0 = r110;
        r100.Z$0 = r133;
        r100.label = 1;
        r112 = r137.a(r110, r135);
        if (r112 != r102) goto L31;
        return r102;
    L23:
        if ((r110 instanceof d.c) == true) goto L25;
        r133 = true;
    L7:
        r100 = new FlowAsrEventProcessor$processInternal$1(this, r111);
        goto L8
    }

    public FlowAsrEventProcessor(c0 r100, h r101, FlowAsrEffectRunnerImpl r102, zw5.a r103, Function2 r104) {
        Intrinsics.checkNotNullParameter(r100, "stateProvider");
        Intrinsics.checkNotNullParameter(r101, "reducer");
        Intrinsics.checkNotNullParameter(r102, "effectRunner");
        Intrinsics.checkNotNullParameter(r103, "logContext");
        Intrinsics.checkNotNullParameter(r104, "onProcessorFailure");
        this.f243815a = r100;
        this.f243816b = r101;
        this.f243817c = r102;
        this.f243818d = r103;
        this.f243819e = r104;
    }
}
