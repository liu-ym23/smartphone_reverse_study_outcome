package com.bytedance.ee.bear.document.offline.sync;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j<T, R> implements Function {
    public static final j<T, R> a = null;

    static {
        a = new j();
    }

    public j() {
    }

    public final Object apply(Object r2) {
        z05.g r3 = (z05.g) r2;
        Intrinsics.checkNotNullParameter(r3, "obj");
        return r3.a;
    }
}
