package com.larus.paging;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"T1", "T2", "R", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.larus.paging.FlowExtKt$combineWithoutBatching$2$1$1", f = "FlowExt.kt", i = {}, l = {222}, m = "invokeSuspend", n = {}, s = {})
public final class FlowExtKt$combineWithoutBatching$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ b1<Object> $$this$simpleChannelFlow;
    final /* synthetic */ Flow<Object> $flow;
    final /* synthetic */ AtomicInteger $incompleteFlows;
    final /* synthetic */ int $index;
    final /* synthetic */ UnbatchedFlowCombiner<Object, Object> $unbatchedFlowCombiner;
    int label;

    public FlowExtKt$combineWithoutBatching$2$1$1(Flow<? extends Object> r100, AtomicInteger r101, b1<Object> r102, UnbatchedFlowCombiner<Object, Object> r103, int r104, Continuation<? super FlowExtKt$combineWithoutBatching$2$1$1> r105) {
        this.$flow = r100;
        this.$incompleteFlows = r101;
        this.$$this$simpleChannelFlow = r102;
        this.$unbatchedFlowCombiner = r103;
        this.$index = r104;
        super(2, r105);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new FlowExtKt$combineWithoutBatching$2$1$1(this.$flow, this.$incompleteFlows, this.$$this$simpleChannelFlow, this.$unbatchedFlowCombiner, this.$index, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((FlowExtKt$combineWithoutBatching$2$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L9;
        if (r102 != 1) goto L8;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L18
    L13:
        if (this.$incompleteFlows.decrementAndGet() != 0) goto L17;
        SendChannel.a.a(this.$$this$simpleChannelFlow);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        Flow<Object> r103 = this.$flow;     // Catch: Throwable -> L18
        FlowExtKt$combineWithoutBatching$2$1$1$invokeSuspend$$inlined$collect$1 r104 = new FlowExtKt$combineWithoutBatching$2$1$1$invokeSuspend$$inlined$collect$1(this.$unbatchedFlowCombiner, this.$index);     // Catch: Throwable -> L18
        this.label = 1;     // Catch: Throwable -> L18
        if (r103.collect(r104, this) != r101) goto L13;
        return r101;
    L18:
        th = move-exception;
        if (this.$incompleteFlows.decrementAndGet() != 0) goto L22;
        SendChannel.a.a(this.$$this$simpleChannelFlow);
    L22:
        throw th;
    }
}
