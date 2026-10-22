package com.larus.im.internal.core.job;

import com.larus.im.bean.job.AIJobRequestState;
import com.larus.im.service.AIJobObserver;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.job.AIJobDispatcher$registerObserver$1", f = "AIJobDispatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AIJobDispatcher$registerObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AIJobObserver $observer;
    final /* synthetic */ Long $registrationId;
    final /* synthetic */ List<AIJobRequestState> $states;
    int label;

    public AIJobDispatcher$registerObserver$1(List<AIJobRequestState> r100, AIJobObserver r101, Long r102, Continuation<? super AIJobDispatcher$registerObserver$1> r103) {
        this.$states = r100;
        this.$observer = r101;
        this.$registrationId = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AIJobDispatcher$registerObserver$1(this.$states, this.$observer, this.$registrationId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AIJobDispatcher$registerObserver$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r100);
        Object r101 = b.f347660b;
        AIJobObserver r102 = this.$observer;
        Long r103 = this.$registrationId;
        monitor-enter(r101);
        boolean r104 = Intrinsics.areEqual(((LinkedHashMap) b.f347661c).get(r102), r103);     // Catch: Throwable -> L15
        monitor-exit(r101);
        if (r104 == false) goto L14;
        List<AIJobRequestState> r105 = this.$states;
        AIJobObserver r106 = this.$observer;
        Iterator<T> r107 = r105.iterator();
    L11:
        if (r107.hasNext() == false) goto L14;
        r106.onRequestStateChanged((AIJobRequestState) r107.next());
    L14:
        return Unit.INSTANCE;
    L15:
        th = move-exception;
        throw th;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
