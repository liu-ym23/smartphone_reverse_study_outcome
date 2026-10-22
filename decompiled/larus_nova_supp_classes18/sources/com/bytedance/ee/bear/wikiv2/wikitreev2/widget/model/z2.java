package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class z2<T, R> implements Function {
    public final /* synthetic */ String a;

    public z2(String r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        up5.b r3 = (up5.b) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        if (r3.b() == false) goto L7;
        a3 r4 = a3.a;
        String r0 = this.a;
        r4.getClass();
        return a3.b(r0);
    L7:
        return Flowable.just(r3);
    }
}
