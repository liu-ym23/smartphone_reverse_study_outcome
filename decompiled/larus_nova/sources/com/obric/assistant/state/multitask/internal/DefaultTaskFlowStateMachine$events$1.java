package com.obric.assistant.state.multitask.internal;

import androidx.exifinterface.media.ExifInterface;
import jha.q;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [S] */
/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "", ExifInterface.LATITUDE_SOUTH, "Lcom/obric/assistant/state/multitask/core/TaskState;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/obric/assistant/state/multitask/core/TaskStateEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.multitask.internal.DefaultTaskFlowStateMachine$events$1", f = "DefaultTaskFlowStateMachine.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
public final class DefaultTaskFlowStateMachine$events$1<S> extends SuspendLambda implements Function2<FlowCollector<? super q<S>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DefaultTaskFlowStateMachine<S> this$0;

    public DefaultTaskFlowStateMachine$events$1(DefaultTaskFlowStateMachine<S> r100, Continuation<? super DefaultTaskFlowStateMachine$events$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        DefaultTaskFlowStateMachine$events$1 r102 = new DefaultTaskFlowStateMachine$events$1(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Continuation<? super Unit> r101) {
        return invoke((FlowCollector) r100, r101);
    }

    public final Object invoke(FlowCollector<? super q<S>> r100, Continuation<? super Unit> r101) {
        return ((DefaultTaskFlowStateMachine$events$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        FlowCollector r103 = (FlowCollector) this.L$0;
        Object r104 = this.this$0.f393301b;
        this.label = 1;
        if (r103.emit(r104, this) != r101) goto L12;
        return r101;
    }
}
