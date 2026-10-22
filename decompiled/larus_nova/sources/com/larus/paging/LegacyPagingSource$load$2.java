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

/* JADX INFO: Add missing generic type declarations: [Value, Key] */
/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/larus/paging/PagingSource$b$c;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.larus.paging.LegacyPagingSource$load$2", f = "LegacyPagingSource.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
public final class LegacyPagingSource$load$2<Key, Value> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PagingSource.b.c<Key, Value>>, Object> {
    final /* synthetic */ DataSource.e<Key> $dataSourceParams;
    final /* synthetic */ PagingSource.a<Key> $params;
    int label;
    final /* synthetic */ LegacyPagingSource<Key, Value> this$0;

    public LegacyPagingSource$load$2(LegacyPagingSource<Key, Value> r100, DataSource.e<Key> r101, PagingSource.a<Key> r102, Continuation<? super LegacyPagingSource$load$2> r103) {
        this.this$0 = r100;
        this.$dataSourceParams = r101;
        this.$params = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new LegacyPagingSource$load$2(this.this$0, this.$dataSourceParams, this.$params, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Object r101) {
        return invoke(r100, (Continuation) r101);
    }

    public final Object invoke(CoroutineScope r100, Continuation<? super PagingSource.b.c<Key, Value>> r101) {
        return ((LegacyPagingSource$load$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L9;
        if (r101 != 1) goto L8;
        ResultKt.throwOnFailure(r100);
        ((DataSource.a) r100).getClass();
        throw null;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        this.this$0.getClass();
        this.label = 1;
        throw null;
    }
}
