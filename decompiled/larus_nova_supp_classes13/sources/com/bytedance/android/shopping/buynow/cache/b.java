package com.bytedance.android.shopping.buynow.cache;

import com.bytedance.android.ec.core.utils.b2;
import com.bytedance.retrofit2.SsResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ nl.b a;
    public final /* synthetic */ boolean b;

    public b(nl.b r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        final SsResponse r3 = (SsResponse) r2;
        b2.b(new WithCacheKt$putCache$1$1(this, r3));
    }
}
