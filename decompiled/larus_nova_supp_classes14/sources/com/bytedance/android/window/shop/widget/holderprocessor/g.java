package com.bytedance.android.window.shop.widget.holderprocessor;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ f a;

    public g(f r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Long r2 = (Long) r1;
        this.a.e.invoke();
    }
}
