package com.obric.memorydata.sdk.intent;

import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.app.AppEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.sdk.intent.InAppSearchIntentExecutor$doAction$result$1", f = "InAppSearchIntentExecutor.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
final class InAppSearchIntentExecutor$doAction$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super IntentResult<AppEntity[]>>, Object> {
    final /* synthetic */ CompletableDeferred<IntentResult<AppEntity[]>> $completionDeferred;
    int label;

    public InAppSearchIntentExecutor$doAction$result$1(CompletableDeferred<IntentResult<AppEntity[]>> r100, Continuation<? super InAppSearchIntentExecutor$doAction$result$1> r101) {
        this.$completionDeferred = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new InAppSearchIntentExecutor$doAction$result$1(this.$completionDeferred, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super IntentResult<AppEntity[]>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super IntentResult<AppEntity[]>> r101) {
        return ((InAppSearchIntentExecutor$doAction$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        CompletableDeferred<IntentResult<AppEntity[]>> r103 = this.$completionDeferred;
        this.label = 1;
        r100 = r103.await(this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
