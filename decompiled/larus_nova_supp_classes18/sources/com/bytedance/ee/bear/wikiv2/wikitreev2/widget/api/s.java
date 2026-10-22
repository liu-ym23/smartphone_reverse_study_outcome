package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class s {
    public final /* synthetic */ GetSpaceInfoPuller a;

    public /* synthetic */ s(GetSpaceInfoPuller r1) {
        this.a = r1;
    }

    public final Flowable a(Object r3) {
        final GetSpaceInfoPuller.Params r4 = (GetSpaceInfoPuller.Params) r3;
        return this.a.c(r4).map(new h0(r4));
    }
}
