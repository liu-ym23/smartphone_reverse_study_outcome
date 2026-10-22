package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k2<T, R> implements Function {
    public final /* synthetic */ WikiTreeModel a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ ce5.a d;

    public k2(WikiTreeModel r1, String r2, String r3, ce5.a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object apply(Object r4) {
        ar5.b r5 = (ar5.b) r4;
        Intrinsics.checkNotNullParameter(r5, "result");
        if ((r5 instanceof ar5.b.C0004b) == false) goto L5;
        Flowable r6 = Flowable.just(r5);
        Intrinsics.checkNotNull(r6);
        return r6;
    L5:
        Flowable r7 = t1.k(this.a, this.b, this.c, this.d).map(j2.a);
        Intrinsics.checkNotNull(r7);
        return r7;
    }
}
