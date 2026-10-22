package com.larus.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u008a@"}, d2 = {"T1", "T2", "R", "t1", "t2", "Lcom/larus/paging/CombineSource;", "updateFrom", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.larus.paging.FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1", f = "FlowExt.kt", i = {}, l = {139, 139}, m = "invokeSuspend", n = {}, s = {})
public final class FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1 extends SuspendLambda implements Function4<Object, Object, CombineSource, Continuation<? super Unit>, Object> {
    final /* synthetic */ b1<Object> $$this$simpleChannelFlow;
    final /* synthetic */ Function4<Object, Object, CombineSource, Continuation<Object>, Object> $transform;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1(b1<Object> r100, Function4<Object, Object, ? super CombineSource, ? super Continuation<Object>, ? extends Object> r101, Continuation<? super FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1> r102) {
        this.$$this$simpleChannelFlow = r100;
        this.$transform = r101;
        super(4, r102);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Object r100, Object r101, CombineSource r102, Continuation<? super Unit> r103) {
        FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1 r104 = new FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1(this.$$this$simpleChannelFlow, this.$transform, r103);
        r104.L$0 = r100;
        r104.L$1 = r101;
        r104.L$2 = r102;
        return r104.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101, CombineSource r102, Continuation<? super Unit> r103) {
        return invoke2(r100, r101, r102, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        ResultKt.throwOnFailure(r100);
    L18:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        b1<Object> r103 = (b1) this.L$0;
        ResultKt.throwOnFailure(r100);
    L14:
        this.L$0 = null;
        this.label = 2;
        if (r103.send(r100, this) != r101) goto L18;
        return r101;
    L10:
        ResultKt.throwOnFailure(r100);
        Object r104 = this.L$0;
        Object r105 = this.L$1;
        CombineSource r106 = (CombineSource) this.L$2;
        b1<Object> r107 = this.$$this$simpleChannelFlow;
        Function4<Object, Object, CombineSource, Continuation<Object>, Object> r108 = this.$transform;
        this.L$0 = r107;
        this.L$1 = null;
        this.label = 1;
        r100 = r108.invoke(r104, r105, r106, this);
        if (r100 != r101) goto L13;
        return r101;
    L13:
        r103 = r107;
        goto L14
    }

    public final Object invokeSuspend$$forInline(Object r100) {
        Object r101 = this.L$0;
        Object r102 = this.L$1;
        CombineSource r103 = (CombineSource) this.L$2;
        b1<Object> r104 = this.$$this$simpleChannelFlow;
        Object r105 = this.$transform.invoke(r101, r102, r103, this);
        InlineMarker.mark(0);
        r104.send(r105, this);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
