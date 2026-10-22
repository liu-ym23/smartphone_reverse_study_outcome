package com.bytedance.android.shopping.store.hybridproduct;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class x<T> implements Consumer {
    public static final x a = null;

    static {
        a = new x();
    }

    public x() {
    }

    public final void accept(Object r3) {
        dm.a.b r0 = dm.a.a("product_list_presenter");
        r0.b("renderResultAsync error", (Throwable) r3);
    }
}
