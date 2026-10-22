package com.bytedance.android.shopping.prepurchase.business.pdp.services;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ VisibleLogManager a;

    public h(VisibleLogManager r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Long r2 = (Long) r1;
        VisibleLogManager.a(this.a);
    }
}
