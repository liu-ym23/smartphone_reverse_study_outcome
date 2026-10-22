package com.bytedance.ee.bear.watermark;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements Consumer<Throwable> {
    public final /* synthetic */ h a;

    public g(l.a r1) {
        this.a = r1;
    }

    public final void accept(Object r1) throws Exception {
        Throwable r2 = (Throwable) r1;
        this.a.onError();
    }
}
