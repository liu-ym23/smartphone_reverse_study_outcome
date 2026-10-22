package com.bytedance.android.shopping.store.home.preload.data;

import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.entity.ECShopHeadInfoBlock;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeTabResponseTabkit;
import com.bytedance.android.shopping.store.hybrid.entity.ECStorePreloadInfoResponse;
import io.reactivex.internal.observers.h;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECStoreDataFutureManager {
    public static final Lazy g = null;
    public final ti3.c a;
    public ECStoreParam b;
    public h<ECShopHeadInfoBlock> c;
    public h<ECStorePreloadInfoResponse> d;
    public h<ECStoreHomeTabResponseTabkit> e;
    public h<com.bytedance.android.chunkstreamprediction.network.b<ECStoreHomeTabResponseTabkit>> f;

    public static final class a {
        public static ECStoreDataFutureManager a() {
            return (ECStoreDataFutureManager) ECStoreDataFutureManager.g.getValue();
        }
    }

    static {
        g = LazyKt.lazy(LazyThreadSafetyMode.NONE, ECStoreDataFutureManager$Companion$instance$2.INSTANCE);
    }

    public ECStoreDataFutureManager() {
        this.a = new ti3.c();
    }

    public final boolean a(ECStoreParam r2) {
        Intrinsics.checkNotNullParameter(r2, "storeParam");
        String r3 = r2.getSecShopId();
        ECStoreParam r0 = this.b;
        if (r0 == null) goto L5;
        String r1 = r0.getSecShopId();
    L7:
        if (Intrinsics.areEqual(r3, r1) == false) goto L14;
        h<ECShopHeadInfoBlock> r4 = this.c;
        if (r4 == null) goto L14;
        if (r4 == null) goto L14;
        if (r4.isCancelled() == true) goto L14;
        return true;
    L14:
        return false;
    L5:
        r1 = null;
        goto L7
    }
}
