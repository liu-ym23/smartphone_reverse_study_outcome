package com.bytedance.ee.bear.drive.preload;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i implements Consumer<Boolean> {
    public final /* synthetic */ m.a a;

    public i(m.a r1) {
        this.a = r1;
    }

    public final void accept(Object r2) throws Exception {
        this.a.c(((Boolean) r2).booleanValue());
    }
}
