package com.larus.dora.impl.feedback;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "newState", "Lcom/larus/dora/impl/feedback/LogState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.feedback.DoraFeedbackLog$setupStateLogging$1", f = "DoraGFeedbackViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraFeedbackLog$setupStateLogging$1 extends SuspendLambda implements Function2<LogState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public DoraFeedbackLog$setupStateLogging$1(Continuation<? super DoraFeedbackLog$setupStateLogging$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        DoraFeedbackLog$setupStateLogging$1 r102 = new DoraFeedbackLog$setupStateLogging$1(r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(LogState r100, Continuation<? super Unit> r101) {
        return ((DoraFeedbackLog$setupStateLogging$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(LogState r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        pk4.j.a("DoraGFeedbackViewModel", "DoraFeedbackLog state changed to: " + ((LogState) this.L$0));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
