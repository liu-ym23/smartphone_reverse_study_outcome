package com.larus.dora.impl.feedback;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/larus/dora/impl/feedback/LogState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.feedback.DoraGFeedbackViewModel$submitWithGLog$terminalState$1", f = "DoraGFeedbackViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraGFeedbackViewModel$submitWithGLog$terminalState$1 extends SuspendLambda implements Function2<LogState, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public DoraGFeedbackViewModel$submitWithGLog$terminalState$1(Continuation<? super DoraGFeedbackViewModel$submitWithGLog$terminalState$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        DoraGFeedbackViewModel$submitWithGLog$terminalState$1 r102 = new DoraGFeedbackViewModel$submitWithGLog$terminalState$1(r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(LogState r100, Continuation<? super Boolean> r101) {
        return ((DoraGFeedbackViewModel$submitWithGLog$terminalState$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(LogState r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r100);
        LogState r101 = (LogState) this.L$0;
        if (r101 != LogState.READY) goto L7;
    L14:
        boolean r102 = true;
    L16:
        return Boxing.boxBoolean(r102);
    L7:
        if (r101 == LogState.P2P_CONNECTION_FAILED) goto L14;
        if (r101 == LogState.LOG_FETCH_FAILED) goto L14;
        if (r101 == LogState.LOG_UPLOAD_FAILED) goto L14;
        r102 = false;
        goto L16
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
