package com.bytedance.android.shopping.sku.common.utils;

import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuCommonOnceInTimeHelper {
    public Disposable a;
    public final com.bytedance.android.ec.core.async.b b;
    public final long c;

    public final void a(final Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "task");
        Disposable r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        e.a r1 = e.a;
        this.a = e.a(this.b, this.c, new SkuCommonOnceInTimeHelper$doOnceByAbortPrevious$1(r5), SkuCommonOnceInTimeHelper$doOnceByAbortPrevious$2.INSTANCE);
    }

    public SkuCommonOnceInTimeHelper(com.bytedance.android.ec.core.async.b r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "disposableScope");
        this.b = r2;
        this.c = r3;
    }
}
