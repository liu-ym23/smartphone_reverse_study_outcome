package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q0<T> implements Consumer {
    public final /* synthetic */ WikiSpaceMoreProvider a;

    public q0(WikiSpaceMoreProvider r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        tt5.a.d("WikiSpaceMoreProvider", "loadSpaceInfoFromNetwork fail: " + ((Throwable) r3));
        this.a.g();
    }
}
