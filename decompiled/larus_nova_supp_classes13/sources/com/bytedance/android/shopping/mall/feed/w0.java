package com.bytedance.android.shopping.mall.feed;

import io.reactivex.functions.Consumer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class w0<T> implements Consumer {
    public final /* synthetic */ ECMallFeedComponent a;
    public final /* synthetic */ String b;

    public w0(ECMallFeedComponent r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        Pair r4 = (Pair) r3;
        ECMallFeedComponent r0 = this.a;
        if (r0.y == false) goto L5;
        ECMallFeedComponent.o("async read homepage cached api response success after sync read");
        return;
    L5:
        if (r4 == null) goto L7;
        com.bytedance.android.shopping.api.mall.idl.b r5 = (com.bytedance.android.shopping.api.mall.idl.b) r4.getSecond();
    L8:
        r0.K = r5;
        this.a.y = true;
        ECMallFeedComponent.o("async read homepage cached api response success at " + System.currentTimeMillis() + ", cacheKey = " + this.b);
        return;
    L7:
        r5 = null;
        goto L8
    }
}
