package com.bytedance.ee.bear.middleground.comment.control;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class l<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l<T, R> f231229a = null;

    static {
        f231229a = new l();
    }

    public l() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((String) r100, "it");
        return (com.bytedance.ee.bear.contract.x) org.koin.java.a.c(com.bytedance.ee.bear.contract.x.class, null, null, 6);
    }
}
