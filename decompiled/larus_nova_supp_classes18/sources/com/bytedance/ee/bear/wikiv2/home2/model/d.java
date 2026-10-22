package com.bytedance.ee.bear.wikiv2.home2.model;

import io.reactivex.functions.Function;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d<T, R> implements Function {
    public static final d<T, R> a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final Object apply(Object r2) {
        Intrinsics.checkNotNullParameter((Throwable) r2, "it");
        return CollectionsKt.emptyList();
    }
}
