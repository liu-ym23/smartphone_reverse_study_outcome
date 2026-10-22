package com.bytedance.android.shopping.store.home.preload.data;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ ECStoreTabKitAPIDataCacheManager a;
    public final /* synthetic */ String b;
    public final /* synthetic */ fl.b c;

    public d(ECStoreTabKitAPIDataCacheManager r1, String r2, fl.b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r2) {
        ((com.bytedance.android.chunkstreamprediction.network.b) r2).a(new c(this));
    }
}
