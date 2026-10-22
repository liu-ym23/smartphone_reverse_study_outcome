package com.larus.im.internal.core.job;

import com.larus.im.bean.job.AIJobRequestState;
import com.larus.im.service.AIJobObserver;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.job.AIJobDispatcher$notifyRequestStates$1", f = "AIJobDispatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AIJobDispatcher$notifyRequestStates$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<AIJobRequestState> $states;
    int label;

    public AIJobDispatcher$notifyRequestStates$1(List<AIJobRequestState> r100, Continuation<? super AIJobDispatcher$notifyRequestStates$1> r101) {
        this.$states = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AIJobDispatcher$notifyRequestStates$1(this.$states, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AIJobDispatcher$notifyRequestStates$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r100);
        Iterator<T> r101 = this.$states.iterator();
    L6:
        if (r101.hasNext() == false) goto L12;
        AIJobRequestState r102 = (AIJobRequestState) r101.next();
        Iterator<T> r103 = b.f347659a.iterator();
    L9:
        if (r103.hasNext() == false) goto L6;
        ((AIJobObserver) r103.next()).onRequestStateChanged(r102);
        goto L9
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
