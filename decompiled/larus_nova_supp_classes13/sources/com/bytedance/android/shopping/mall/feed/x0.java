package com.bytedance.android.shopping.mall.feed;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class x0<T> implements Consumer {
    public final /* synthetic */ ECMallFeedComponent a;
    public final /* synthetic */ String b;

    public x0(ECMallFeedComponent r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        if (this.a.y == false) goto L6;
        ECMallFeedComponent.o("async read homepage cached api response failed after sync read");
        return;
    L6:
        if ((r4 instanceof NullPointerException) == true) goto L8;
        ECMallFeedComponent.o("async read homepage cached api response failed at " + System.currentTimeMillis() + ", cacheKey = " + this.b);
    L8:
        this.a.y = true;
    }
}
