package com.obric.assistant.state.multitask.internal.engine;

import com.obric.assistant.state.multitask.core.TaskFlowCriticalResolver;
import jha.g;
import jha.q;
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
@DebugMetadata(c = "com.obric.assistant.state.multitask.internal.engine.TaskFlowPolicyEngine$executeCriticalResolvers$2$outcome$1", f = "TaskFlowPolicyEngine.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
public final class TaskFlowPolicyEngine$executeCriticalResolvers$2$outcome$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ q<?> $event;
    final /* synthetic */ g<?> $id;
    final /* synthetic */ TaskFlowCriticalResolver $resolver;
    int label;

    public TaskFlowPolicyEngine$executeCriticalResolvers$2$outcome$1(TaskFlowCriticalResolver r100, g<?> r101, q<?> r102, Continuation<? super TaskFlowPolicyEngine$executeCriticalResolvers$2$outcome$1> r103) {
        this.$resolver = r100;
        this.$id = r101;
        this.$event = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new TaskFlowPolicyEngine$executeCriticalResolvers$2$outcome$1(this.$resolver, this.$id, this.$event, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((TaskFlowPolicyEngine$executeCriticalResolvers$2$outcome$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        TaskFlowCriticalResolver r103 = this.$resolver;
        g<?> r104 = this.$id;
        q<?> r105 = this.$event;
        this.label = 1;
        if (r103.a(r104, r105) != r101) goto L12;
        return r101;
    }
}
