package com.bytedance.android.shopping.store.home.preload.data;

import com.bytedance.android.shopping.store.home.entity.ECStoreHomeTabResponseTabkit;
import io.reactivex.functions.Consumer;
import kotlin.Triple;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ ECStoreTabKitAPIDataCacheManager a;
    public final /* synthetic */ String b;
    public final /* synthetic */ fl.b c;

    public e(ECStoreTabKitAPIDataCacheManager r1, String r2, fl.b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r7) {
        ECStoreHomeTabResponseTabkit r8 = (ECStoreHomeTabResponseTabkit) r7;
        if (r8.getStatusCode() != 0) goto L6;
        this.a.c.put(this.b, new Triple(new ECStoreHomeTabResponseTabkit[]{r8}, Long.valueOf(System.currentTimeMillis()), this.c));
        return;
    }
}
