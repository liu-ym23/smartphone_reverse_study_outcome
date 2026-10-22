package com.bytedance.android.shopping.mall.feed;

import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class s0<T> implements Consumer {
    public final /* synthetic */ ECMallFeedComponent.d a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public s0(ECMallFeedComponent.d r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r3) {
        Unit r4 = (Unit) r3;
        ECMallFeedComponent r5 = this.a.a;
        String r0 = "async save " + this.b + " response success, cacheKey = " + this.c;
        Lazy r1 = ECMallFeedComponent.p0;
        r5.getClass();
        ECMallFeedComponent.o(r0);
    }
}
