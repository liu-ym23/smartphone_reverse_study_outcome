package com.larus.bmhome.social.page.datasource.diff;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes26.dex */
public final class AsyncPagingListDiffer$consumePendingTask$2<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AsyncPagingListDiffer<Object> f314009a;

    public AsyncPagingListDiffer$consumePendingTask$2(AsyncPagingListDiffer<Object> r100) {
        this.f314009a = r100;
    }

    public final Object a(Unit r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof AsyncPagingListDiffer$consumePendingTask$2$emit$1) == false) goto L7;
        AsyncPagingListDiffer$consumePendingTask$2$emit$1 r102 = (AsyncPagingListDiffer$consumePendingTask$2$emit$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 != 0) goto L11;
    L14:
        ResultKt.throwOnFailure(r104);
        this.f314009a.getClass();
        throw null;
    L11:
        if (r105 == 1) goto L14;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r102 = new AsyncPagingListDiffer$consumePendingTask$2$emit$1(this, r101);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
        a((Unit) r100, r101);
        throw null;
    }
}
