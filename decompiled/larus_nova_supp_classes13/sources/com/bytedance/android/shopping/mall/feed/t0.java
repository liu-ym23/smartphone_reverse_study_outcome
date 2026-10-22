package com.bytedance.android.shopping.mall.feed;

import io.reactivex.functions.Consumer;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class t0<T> implements Consumer {
    public final /* synthetic */ ECMallFeedComponent.d a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public t0(ECMallFeedComponent.d r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r3) {
        if ((((Throwable) r3) instanceof NullPointerException) == true) goto L6;
        ECMallFeedComponent r4 = this.a.a;
        String r0 = "async save " + this.b + " response failed, cacheKey = " + this.c;
        Lazy r1 = ECMallFeedComponent.p0;
        r4.getClass();
        ECMallFeedComponent.o(r0);
        return;
    }
}
