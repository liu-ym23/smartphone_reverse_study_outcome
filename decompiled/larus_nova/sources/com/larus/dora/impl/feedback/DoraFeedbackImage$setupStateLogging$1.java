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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "newState", "Lcom/larus/dora/impl/feedback/ImageState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.feedback.DoraFeedbackImage$setupStateLogging$1", f = "DoraGFeedbackViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraFeedbackImage$setupStateLogging$1 extends SuspendLambda implements Function2<ImageState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ g this$0;

    public DoraFeedbackImage$setupStateLogging$1(g r100, Continuation<? super DoraFeedbackImage$setupStateLogging$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        DoraFeedbackImage$setupStateLogging$1 r102 = new DoraFeedbackImage$setupStateLogging$1(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ImageState r100, Continuation<? super Unit> r101) {
        return ((DoraFeedbackImage$setupStateLogging$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ImageState r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        ImageState r101 = (ImageState) this.L$0;
        pk4.j.a("DoraGFeedbackViewModel", "Image [" + this.this$0.f335619a + "] state changed to: " + r101);
        if (r101 != ImageState.READY) goto L8;
        pk4.j.a("DoraGFeedbackViewModel", "Image [" + this.this$0.f335619a + "] processing completed. Token: " + this.this$0.f335625g);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
