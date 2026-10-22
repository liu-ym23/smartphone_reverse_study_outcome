package com.larus.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/larus/paging/PagingSource;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.larus.paging.SuspendingPagingSourceFactory$create$2", f = "SuspendingPagingSourceFactory.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SuspendingPagingSourceFactory$create$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PagingSource<Object, Object>>, Object> {
    int label;
    final /* synthetic */ c1<Object, Object> this$0;

    public SuspendingPagingSourceFactory$create$2(c1<Object, Object> r100, Continuation<? super SuspendingPagingSourceFactory$create$2> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SuspendingPagingSourceFactory$create$2(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super PagingSource<Object, Object>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super PagingSource<Object, Object>> r101) {
        return ((SuspendingPagingSourceFactory$create$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L5;
        ResultKt.throwOnFailure(r100);
        this.this$0.getClass();
        throw null;
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
