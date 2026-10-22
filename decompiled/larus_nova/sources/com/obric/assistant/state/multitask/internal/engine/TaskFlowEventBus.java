package com.obric.assistant.state.multitask.internal.engine;

import jha.g;
import jha.q;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.e;

/* JADX INFO: loaded from: classes4.dex */
public final class TaskFlowEventBus {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableSharedFlow<Pair<g<?>, q<?>>> f393308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a1 f393309b;

    public TaskFlowEventBus() {
        MutableSharedFlow<Pair<g<?>, q<?>>> r100 = SharedFlowKt.MutableSharedFlow$default(0, 32, BufferOverflow.SUSPEND, 1, null);
        this.f393308a = r100;
        this.f393309b = e.a(r100);
    }

    public final Object a(g<?> r100, q<?> r101, Long r102, Continuation<? super Unit> r103) {
        if ((r103 instanceof TaskFlowEventBus$emitEvent$1) == false) goto L7;
        TaskFlowEventBus$emitEvent$1 r104 = (TaskFlowEventBus$emitEvent$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        r102 = (Long) r104.L$2;
        r101 = (q) r104.L$1;
        g r109 = (g) r104.L$0;
        ResultKt.throwOnFailure(r106);
    L17:
        com.obric.assistant.state.multitask.b.a r110 = com.obric.assistant.state.multitask.b.f393276a;
        a r111 = new a("emitEvent", "success", r102, r101);
        r110.getClass();
        com.obric.assistant.state.multitask.b.a.a(r111);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        MutableSharedFlow<Pair<g<?>, q<?>>> r112 = this.f393308a;
        Pair<g<?>, q<?>> r113 = TuplesKt.to(r100, r101);
        r104.L$0 = r100;
        r104.L$1 = r101;
        r104.L$2 = r102;
        r104.label = 1;
        if (r112.emit(r113, r104) != r107) goto L17;
        return r107;
    L7:
        r104 = new TaskFlowEventBus$emitEvent$1(this, r103);
        goto L8
    }
}
