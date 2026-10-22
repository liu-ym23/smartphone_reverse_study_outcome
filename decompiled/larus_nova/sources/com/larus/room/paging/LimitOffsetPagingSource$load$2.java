package com.larus.room.paging;

import com.larus.paging.PagingSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@"}, d2 = {"", "Value", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/larus/paging/PagingSource$b;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.larus.room.paging.LimitOffsetPagingSource$load$2", f = "LimitOffsetPagingSource.kt", i = {}, l = {76, 79}, m = "invokeSuspend", n = {}, s = {})
final class LimitOffsetPagingSource$load$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PagingSource.b<Integer, Object>>, Object> {
    final /* synthetic */ PagingSource.a<Integer> $params;
    int label;
    final /* synthetic */ a<Object> this$0;

    public LimitOffsetPagingSource$load$2(a<Object> r100, PagingSource.a<Integer> r101, Continuation<? super LimitOffsetPagingSource$load$2> r102) {
        this.$params = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new LimitOffsetPagingSource$load$2(null, this.$params, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super PagingSource.b<Integer, Object>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super PagingSource.b<Integer, Object>> r101) {
        return ((LimitOffsetPagingSource$load$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 != 0) goto L5;
        ResultKt.throwOnFailure(r100);
        throw null;
    L5:
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
        return (PagingSource.b) r100;
    L7:
        if (r101 != 2) goto L9;
        ResultKt.throwOnFailure(r100);
        PagingSource.b r102 = (PagingSource.b) r100;
        throw null;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
