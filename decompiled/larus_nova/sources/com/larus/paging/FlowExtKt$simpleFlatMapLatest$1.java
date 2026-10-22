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
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u008a@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.larus.paging.FlowExtKt$simpleFlatMapLatest$1", f = "FlowExt.kt", i = {}, l = {96, 222}, m = "invokeSuspend", n = {}, s = {})
public final class FlowExtKt$simpleFlatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<Object>, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Object, Continuation<? super Flow<Object>>, Object> $transform;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowExtKt$simpleFlatMapLatest$1(Function2<Object, ? super Continuation<? super Flow<Object>>, ? extends Object> r100, Continuation<? super FlowExtKt$simpleFlatMapLatest$1> r101) {
        this.$transform = r100;
        super(3, r101);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<Object> r100, Object r101, Continuation<? super Unit> r102) {
        return invoke2(r100, r101, r102);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<Object> r100, Object r101, Continuation<? super Unit> r102) {
        FlowExtKt$simpleFlatMapLatest$1 r103 = new FlowExtKt$simpleFlatMapLatest$1(this.$transform, r102);
        r103.L$0 = r100;
        r103.L$1 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        ResultKt.throwOnFailure(r100);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        FlowCollector r103 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r100);
    L13:
        this.L$0 = null;
        this.label = 2;
        if (((Flow) r100).collect(r103, this) != r101) goto L17;
        return r101;
    L10:
        ResultKt.throwOnFailure(r100);
        r103 = (FlowCollector) this.L$0;
        Object r104 = this.L$1;
        Function2<Object, Continuation<? super Flow<Object>>, Object> r105 = this.$transform;
        this.L$0 = r103;
        this.label = 1;
        r100 = r105.invoke(r104, this);
        if (r100 != r101) goto L13;
        return r101;
    }

    public final Object invokeSuspend$$forInline(Object r100) {
        FlowCollector r101 = (FlowCollector) this.L$0;
        Object r102 = this.L$1;
        Flow r103 = (Flow) this.$transform.invoke(r102, this);
        InlineMarker.mark(0);
        r103.collect(r101, this);
        InlineMarker.mark(2);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
