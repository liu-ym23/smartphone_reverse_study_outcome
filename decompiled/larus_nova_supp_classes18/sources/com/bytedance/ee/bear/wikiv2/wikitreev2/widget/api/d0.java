package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class d0 {
    public final /* synthetic */ GetChildPuller a;

    public /* synthetic */ d0(GetChildPuller r1) {
        this.a = r1;
    }

    public final Flowable a(Object r3) {
        final GetChildPuller.Params r4 = (GetChildPuller.Params) r3;
        return this.a.c(r4).map(new e0(r4));
    }
}
