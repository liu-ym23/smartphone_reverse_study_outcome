package com.bytedance.android.shopping.buynow.controller;

import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ CheckPayStatusController a;

    public l(CheckPayStatusController r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        this.a.c(BuyNowCloseMethod.PAY_FAIL);
    }
}
