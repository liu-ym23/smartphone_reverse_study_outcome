package com.bytedance.ee.bear.document.export.net.exportV2;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b<T, R> implements Function {
    public static final b<T, R> a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final Object apply(Object r4) {
        Flowable r5 = (Flowable) r4;
        Intrinsics.checkNotNullParameter(r5, "objectFlowable");
        return r5.delay(3, TimeUnit.SECONDS);
    }
}
