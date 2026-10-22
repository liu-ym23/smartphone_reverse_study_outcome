package com.bytedance.android.shopping.store.home.preload.data;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECStoreDataManager {
    public static final Lazy c = null;
    public final Lazy a;
    public final Lazy b;

    public static final class a {
        public static ECStoreDataManager a() {
            return (ECStoreDataManager) ECStoreDataManager.c.getValue();
        }
    }

    public final ECStoreTabKitAPIDataCacheManager a() {
        return (ECStoreTabKitAPIDataCacheManager) this.a.getValue();
    }

    public final ECStoreDataFutureManager b() {
        return (ECStoreDataFutureManager) this.b.getValue();
    }

    static {
        c = LazyKt.lazy(LazyThreadSafetyMode.NONE, ECStoreDataManager$Companion$instance$2.INSTANCE);
    }

    public ECStoreDataManager() {
        this.a = LazyKt.lazy(ECStoreDataManager$cacheManager$2.INSTANCE);
        this.b = LazyKt.lazy(ECStoreDataManager$futureManager$2.INSTANCE);
    }
}
