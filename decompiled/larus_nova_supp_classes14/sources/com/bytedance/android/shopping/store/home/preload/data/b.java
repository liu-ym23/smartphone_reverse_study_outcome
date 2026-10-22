package com.bytedance.android.shopping.store.home.preload.data;

import com.bytedance.android.shopping.store.home.entity.ECShopHeadInfoBlock;
import io.reactivex.functions.Consumer;
import kotlin.Triple;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ ECStoreTabKitAPIDataCacheManager a;
    public final /* synthetic */ String b;
    public final /* synthetic */ fl.b c;

    public b(ECStoreTabKitAPIDataCacheManager r1, String r2, fl.b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r6) {
        ECShopHeadInfoBlock r7 = (ECShopHeadInfoBlock) r6;
        if (r7.getStatusCode() != 0) goto L6;
        this.a.b.put(this.b, new Triple(r7, Long.valueOf(System.currentTimeMillis()), this.c));
        return;
    }
}
