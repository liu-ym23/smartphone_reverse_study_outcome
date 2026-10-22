package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i1<T> implements Consumer {
    public final /* synthetic */ WikiTreeMoreProvider a;

    public i1(WikiTreeMoreProvider r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        this.a.s = true;
        tt5.a.d("WikiTreeMoreProvider", "bindSpaceInfo fail: " + ((Throwable) r3));
        this.a.g();
    }
}
