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
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002H\u008a@"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/larus/paging/PageEvent;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.larus.paging.MulticastedPagingData$accumulated$1", f = "CachedPagingData.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
final class MulticastedPagingData$accumulated$1 extends SuspendLambda implements Function2<FlowCollector<? super PageEvent<Object>>, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ w<Object> this$0;

    public MulticastedPagingData$accumulated$1(w<Object> r100, Continuation<? super MulticastedPagingData$accumulated$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MulticastedPagingData$accumulated$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super PageEvent<Object>> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super PageEvent<Object>> r100, Continuation<? super Unit> r101) {
        return ((MulticastedPagingData$accumulated$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 != 0) goto L5;
        ResultKt.throwOnFailure(r100);
        this.this$0.getClass();
    L11:
        return Unit.INSTANCE;
    L5:
        if (r101 != 1) goto L8;
        ResultKt.throwOnFailure(r100);
        goto L11
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
