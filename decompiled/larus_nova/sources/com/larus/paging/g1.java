package com.larus.paging;

import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class g1<Key, ValueFrom, ValueTo> extends DataSource<Key, ValueTo> {
    @Override // com.larus.paging.DataSource
    public final boolean a() {
        throw null;
    }

    public static void b(g1 r100, Continuation r101) {
        if ((r101 instanceof WrapperDataSource$load$1) == false) goto L7;
        WrapperDataSource$load$1 r102 = (WrapperDataSource$load$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L15;
        if (r105 != 1) goto L12;
        g1 r106 = (g1) r102.L$0;
        ResultKt.throwOnFailure(r104);
        DataSource.a r107 = (DataSource.a) r104;
        int r108 = DataSource.a.f363646a;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "result");
        Intrinsics.checkNotNullParameter(null, "function");
        r107.getClass();
        Intrinsics.checkNotNullParameter(null, "function");
        Intrinsics.checkNotNullParameter(null, "source");
        throw null;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
        r100.getClass();
        r102.L$0 = r100;
        r102.label = 1;
        throw null;
    L7:
        r102 = new WrapperDataSource$load$1(r100, r101);
        goto L8
    }
}
