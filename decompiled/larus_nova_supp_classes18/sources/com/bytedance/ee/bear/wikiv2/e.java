package com.bytedance.ee.bear.wikiv2;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ WikiFragment a;

    public e(WikiFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        WikiFragment r0 = this.a;
        int r1 = WikiFragment.l;
        r0.Z90().c(0);
        ((wwc.c) r3).request(Long.MAX_VALUE);
    }
}
