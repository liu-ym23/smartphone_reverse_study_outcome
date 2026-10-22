package com.bytedance.locallife.dito.core.viewmodel;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<T, R> f258069a = null;

    static {
        f258069a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        lp6.a r101 = (lp6.a) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.f510230a;
    }
}
