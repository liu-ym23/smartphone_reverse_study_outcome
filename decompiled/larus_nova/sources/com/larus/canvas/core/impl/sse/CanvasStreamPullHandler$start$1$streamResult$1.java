package com.larus.canvas.core.impl.sse;

import cy8.u;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "event", "Lcom/larus/canvas/core/api/model/CanvasSSEEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.core.impl.sse.CanvasStreamPullHandler$start$1$streamResult$1", f = "CanvasStreamPullHandler.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
public final class CanvasStreamPullHandler$start$1$streamResult$1 extends SuspendLambda implements Function2<u, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowCollector<u> $$this$flow;
    final /* synthetic */ Ref.ObjectRef<Long> $sequenceId;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public CanvasStreamPullHandler$start$1$streamResult$1(Ref.ObjectRef<Long> r100, FlowCollector<? super u> r101, Continuation<? super CanvasStreamPullHandler$start$1$streamResult$1> r102) {
        this.$sequenceId = r100;
        this.$$this$flow = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        CanvasStreamPullHandler$start$1$streamResult$1 r102 = new CanvasStreamPullHandler$start$1$streamResult$1(this.$sequenceId, this.$$this$flow, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(u r100, Continuation<? super Unit> r101) {
        return ((CanvasStreamPullHandler$start$1$streamResult$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(u r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        u r103 = (u) this.L$0;
        if ((r103 instanceof u.a) == false) goto L14;
        Ref.ObjectRef<Long> r104 = this.$sequenceId;
        Long r105 = ((u.a) r103).f465913a.f465813b;
        T r106 = r105;
        if (r105 != null) goto L13;
        r106 = r104.element;
    L13:
        r104.element = r106;
    L14:
        FlowCollector<u> r107 = this.$$this$flow;
        this.label = 1;
        if (r107.emit(r103, this) != r101) goto L18;
        return r101;
    }
}
