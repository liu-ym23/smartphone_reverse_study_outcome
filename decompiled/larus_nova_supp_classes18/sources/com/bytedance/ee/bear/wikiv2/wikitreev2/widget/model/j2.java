package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j2<T, R> implements Function {
    public static final j2<T, R> a = null;

    static {
        a = new j2();
    }

    public j2() {
    }

    public final Object apply(Object r2) {
        Boolean r3 = (Boolean) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return new ar5.b.a(r3.booleanValue());
    }
}
