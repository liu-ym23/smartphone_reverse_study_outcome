package com.larus.paging;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.larus.paging.FlowExtKt$simpleScan$1", f = "FlowExt.kt", i = {0, 0}, l = {52, 222}, m = "invokeSuspend", n = {"$this$flow", "accumulator"}, s = {"L$0", "L$1"})
final class FlowExtKt$simpleScan$1 extends SuspendLambda implements Function2<FlowCollector<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $initial;
    final /* synthetic */ Function3<Object, Object, Continuation<Object>, Object> $operation;
    final /* synthetic */ Flow<Object> $this_simpleScan;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowExtKt$simpleScan$1(Object r100, Flow<Object> r101, Function3<Object, Object, ? super Continuation<Object>, ? extends Object> r102, Continuation<? super FlowExtKt$simpleScan$1> r103) {
        this.$initial = r100;
        this.$this_simpleScan = r101;
        this.$operation = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        FlowExtKt$simpleScan$1 r102 = new FlowExtKt$simpleScan$1(this.$initial, this.$this_simpleScan, this.$operation, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<Object> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<Object> r100, Continuation<? super Unit> r101) {
        return ((FlowExtKt$simpleScan$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [T, java.lang.Object] */
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
        Ref.ObjectRef r103 = (Ref.ObjectRef) this.L$1;
        FlowCollector r104 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r100);
    L14:
        Flow<Object> r105 = this.$this_simpleScan;
        FlowExtKt$simpleScan$1$invokeSuspend$$inlined$collect$1 r106 = new FlowExtKt$simpleScan$1$invokeSuspend$$inlined$collect$1(r103, this.$operation, r104);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (r105.collect(r106, this) != r101) goto L18;
        return r101;
    L10:
        ResultKt.throwOnFailure(r100);
        FlowCollector r107 = (FlowCollector) this.L$0;
        r103 = new Ref.ObjectRef();
        ?? r108 = this.$initial;
        r103.element = r108;
        this.L$0 = r107;
        this.L$1 = r103;
        this.label = 1;
        if (r107.emit(r108, this) != r101) goto L13;
        return r101;
    L13:
        r104 = r107;
        goto L14
    }
}
