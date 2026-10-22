package com.bytedance.android.shopping.sku.common.utils;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ Function0 a;

    public g(Function0 r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Throwable r2 = (Throwable) r1;
        this.a.invoke();
    }
}
