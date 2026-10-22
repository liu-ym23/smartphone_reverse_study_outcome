package com.bytedance.android.shopping.buynow.eventcenter.handle;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b0<T> implements Consumer {
    public final /* synthetic */ z a;

    public b0(z r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        this.a.h.setSubmitStatusFlag(true);
    }
}
