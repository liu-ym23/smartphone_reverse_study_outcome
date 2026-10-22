package com.bytedance.android.shopping.store.home.presenter;

import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s1<T, R> implements Function {
    public static final s1 a = null;

    static {
        a = new s1();
    }

    public s1() {
    }

    public final Object apply(Object r2) {
        Intrinsics.checkNotNullParameter((Long) r2, "it");
        com.bytedance.android.shopping.store.utils.j.a();
        return Unit.INSTANCE;
    }
}
