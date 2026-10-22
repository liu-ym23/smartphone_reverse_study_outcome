package com.ss.android.lark.flow.chat.statistics.perf;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\r\u0012\t\u0012\u00070\u0003¢\u0006\u0002\b\u00040\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lcom/ss/android/lark/flow/chat/statistics/perf/DoubaoReplyLatencyTracker$Trace;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.statistics.perf.DoubaoReplyLatencyTracker$markAllInFlightBackground$2", f = "DoubaoReplyLatencyTracker.kt", i = {0, 1}, l = {174, 175, 176}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence"}, s = {"L$0", "L$0"})
final class DoubaoReplyLatencyTracker$markAllInFlightBackground$2 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super a.b>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public DoubaoReplyLatencyTracker$markAllInFlightBackground$2(Continuation<? super DoubaoReplyLatencyTracker$markAllInFlightBackground$2> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        DoubaoReplyLatencyTracker$markAllInFlightBackground$2 r102 = new DoubaoReplyLatencyTracker$markAllInFlightBackground$2(r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super a.b> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceScope<? super a.b> r100, Continuation<? super Unit> r101) {
        return ((DoubaoReplyLatencyTracker$markAllInFlightBackground$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L12;
        if (r102 == 1) goto L11;
        if (r102 == 2) goto L10;
        if (r102 != 3) goto L9;
        ResultKt.throwOnFailure(r100);
    L23:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        SequenceScope r103 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r100);
    L19:
        Collection<a.b> r104 = a.f423026f.values();
        this.L$0 = null;
        this.label = 3;
        if (r103.yieldAll(r104, this) != r101) goto L23;
        return r101;
    L11:
        r103 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r100);
    L16:
        Collection<a.b> r105 = a.f423025e.values();
        this.L$0 = r103;
        this.label = 2;
        if (r103.yieldAll(r105, this) != r101) goto L19;
        return r101;
    L12:
        ResultKt.throwOnFailure(r100);
        SequenceScope r106 = (SequenceScope) this.L$0;
        Collection<a.b> r107 = a.f423024d.values();
        this.L$0 = r106;
        this.label = 1;
        if (r106.yieldAll(r107, this) != r101) goto L15;
        return r101;
    L15:
        r103 = r106;
        goto L16
    }
}
