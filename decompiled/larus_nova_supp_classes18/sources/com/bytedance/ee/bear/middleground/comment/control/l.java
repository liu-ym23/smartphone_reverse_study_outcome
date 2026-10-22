package com.bytedance.ee.bear.middleground.comment.control;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l<T, R> implements Function {
    public static final l<T, R> a = null;

    static {
        a = new l();
    }

    public l() {
    }

    public final Object apply(Object r3) {
        Intrinsics.checkNotNullParameter((String) r3, "it");
        return (com.bytedance.ee.bear.contract.x) org.koin.java.a.c(com.bytedance.ee.bear.contract.x.class, null, null, 6);
    }
}
