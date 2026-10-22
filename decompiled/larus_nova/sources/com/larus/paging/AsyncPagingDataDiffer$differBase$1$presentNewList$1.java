package com.larus.paging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.larus.paging.AsyncPagingDataDiffer$differBase$1", f = "AsyncPagingDataDiffer.kt", i = {0, 0, 0, 0, 0}, l = {98}, m = "presentNewList", n = {"this", "previousList", "newList", "onListPresentable", "lastAccessedIndex"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
final class AsyncPagingDataDiffer$differBase$1$presentNewList$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ c this$0;

    public AsyncPagingDataDiffer$differBase$1$presentNewList$1(c r100, Continuation<? super AsyncPagingDataDiffer$differBase$1$presentNewList$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, null, 0, null, this);
    }
}
