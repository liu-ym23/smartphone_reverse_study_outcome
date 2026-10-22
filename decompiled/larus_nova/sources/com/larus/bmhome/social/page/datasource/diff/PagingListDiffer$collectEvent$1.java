package com.larus.bmhome.social.page.datasource.diff;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.page.datasource.diff.PagingListDiffer", f = "PagingListDiffer.kt", i = {0, 0}, l = {84, 86, 90, 94, 98, 102, 106, 110}, m = "collectEvent$suspendImpl", n = {"$this", "event"}, s = {"L$0", "L$1"})
public final class PagingListDiffer$collectEvent$1<DATA> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PagingListDiffer<DATA> this$0;

    public PagingListDiffer$collectEvent$1(PagingListDiffer<DATA> r100, Continuation<? super PagingListDiffer$collectEvent$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return PagingListDiffer.g(this.this$0, null, this);
    }
}
