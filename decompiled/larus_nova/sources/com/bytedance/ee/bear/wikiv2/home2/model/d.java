package com.bytedance.ee.bear.wikiv2.home2.model;

import io.reactivex.functions.Function;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d<T, R> f240926a = null;

    static {
        f240926a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((Throwable) r100, "it");
        return CollectionsKt.emptyList();
    }
}
