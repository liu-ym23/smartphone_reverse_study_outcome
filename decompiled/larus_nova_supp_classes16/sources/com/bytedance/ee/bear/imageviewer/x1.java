package com.bytedance.ee.bear.imageviewer;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class x1 implements Consumer {
    public final /* synthetic */ c3.f a;

    public /* synthetic */ x1(c3.f r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        this.a.onFailed((Throwable) r2);
    }
}
