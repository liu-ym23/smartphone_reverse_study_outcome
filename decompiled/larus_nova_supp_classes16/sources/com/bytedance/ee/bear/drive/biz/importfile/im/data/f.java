package com.bytedance.ee.bear.drive.biz.importfile.im.data;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f<T, R> implements Function {
    public static final f<T, R> a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final Object apply(Object r4) {
        Flowable r5 = (Flowable) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        return r5.delay(3, TimeUnit.SECONDS);
    }
}
