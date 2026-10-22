package com.larus.paging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
final /* synthetic */ class Pager$flow$1 extends FunctionReferenceImpl implements Function1<Continuation<? super PagingSource<Object, Object>>, Object>, SuspendFunction {
    public Pager$flow$1(Object r100) {
        super(1, r100, c1.class, "create", "create(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super PagingSource<Object, Object>> r100) {
        c1 r101 = (c1) this.receiver;
        r101.getClass();
        return BuildersKt.withContext(null, new SuspendingPagingSourceFactory$create$2(r101, null), r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super PagingSource<Object, Object>> r100) {
        return invoke2(r100);
    }
}
