package com.bytedance.ee.bear.drive.loader.impl;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import uu5.i;
import w55.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e<T, R> implements Function {
    public static final e<T, R> a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final Object apply(Object r3) {
        i r4 = (i) r3;
        Intrinsics.checkNotNullParameter(r4, "option");
        if (j.a(r4) == false) goto L6;
        return j.b().map(new d(r4));
    L6:
        return Flowable.just(r4);
    }
}
