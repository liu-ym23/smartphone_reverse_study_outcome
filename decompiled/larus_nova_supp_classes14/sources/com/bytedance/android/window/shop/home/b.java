package com.bytedance.android.window.shop.home;

import com.bytedance.android.ec.window.base.shopping.paging.WindowLoadStatus;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        this.a.g.getLoadStatus().setValue(WindowLoadStatus.InitializeError);
    }
}
