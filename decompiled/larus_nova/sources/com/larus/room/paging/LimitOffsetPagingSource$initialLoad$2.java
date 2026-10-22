package com.larus.room.paging;

import com.larus.paging.PagingSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\u008a@"}, d2 = {"", "Value", "Lcom/larus/paging/PagingSource$b;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.larus.room.paging.LimitOffsetPagingSource$initialLoad$2", f = "LimitOffsetPagingSource.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
final class LimitOffsetPagingSource$initialLoad$2 extends SuspendLambda implements Function1<Continuation<? super PagingSource.b<Integer, Object>>, Object> {
    final /* synthetic */ PagingSource.a<Integer> $params;
    int label;
    final /* synthetic */ a<Object> this$0;

    public LimitOffsetPagingSource$initialLoad$2(a<Object> r100, PagingSource.a<Integer> r101, Continuation<? super LimitOffsetPagingSource$initialLoad$2> r102) {
        this.$params = r101;
        super(1, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new LimitOffsetPagingSource$initialLoad$2(null, this.$params, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super PagingSource.b<Integer, Object>> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super PagingSource.b<Integer, Object>> r100) {
        return ((LimitOffsetPagingSource$initialLoad$2) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 != 0) goto L5;
        ResultKt.throwOnFailure(r100);
        throw null;
    L5:
        if (r101 != 1) goto L9;
        ResultKt.throwOnFailure(r100);
        return r100;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
