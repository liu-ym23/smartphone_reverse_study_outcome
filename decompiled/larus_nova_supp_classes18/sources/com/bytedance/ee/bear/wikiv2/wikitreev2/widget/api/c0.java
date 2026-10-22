package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class c0 {
    public final /* synthetic */ GetRootPermPuller a;

    public /* synthetic */ c0(GetRootPermPuller r1) {
        this.a = r1;
    }

    public final Flowable a(Object r3) {
        final GetRootPermPuller.Params r4 = (GetRootPermPuller.Params) r3;
        return this.a.c(r4).map(new j0(r4));
    }
}
