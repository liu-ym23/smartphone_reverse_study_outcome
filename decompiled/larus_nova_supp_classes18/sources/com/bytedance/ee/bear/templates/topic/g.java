package com.bytedance.ee.bear.templates.topic;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g<T, R> implements Function {
    public static final g<T, R> a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public final Object apply(Object r2) {
        Intrinsics.checkNotNullParameter((Throwable) r2, "it");
        return new TopicDataResult();
    }
}
