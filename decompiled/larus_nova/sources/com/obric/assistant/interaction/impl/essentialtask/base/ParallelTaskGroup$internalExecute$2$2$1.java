package com.obric.assistant.interaction.impl.essentialtask.base;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.interaction.impl.essentialtask.base.ParallelTaskGroup$internalExecute$2$2$1", f = "ParallelTaskGroup.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
public final class ParallelTaskGroup$internalExecute$2$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ EssentialTask $subTask;
    int label;

    public ParallelTaskGroup$internalExecute$2$2$1(EssentialTask r100, Continuation<? super ParallelTaskGroup$internalExecute$2$2$1> r101) {
        this.$subTask = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ParallelTaskGroup$internalExecute$2$2$1(this.$subTask, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ParallelTaskGroup$internalExecute$2$2$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        if (((ExecuteResult) r100).isSuccess() == true) goto L14;
        FLogger.f375446a.w("EssentialTaskParallelTaskGroup", "task " + this.$subTask + " execute failed. cancel all other task");
        throw new CancellationException();
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        EssentialTask r103 = this.$subTask;
        this.label = 1;
        r100 = r103.execute(this);
        if (r100 != r101) goto L12;
        return r101;
    }
}
