package com.bytedance.ee.bear.share.newshare;

import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y {
    public static void a(final String r2, final String r3) {
        Flowable.just("").subscribeOn(fo5.d.b()).map(new q()).map(new r(r2, r3)).subscribe(new s(), new t());
    }
}
