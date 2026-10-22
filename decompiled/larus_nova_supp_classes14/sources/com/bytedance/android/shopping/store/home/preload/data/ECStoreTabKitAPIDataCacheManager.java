package com.bytedance.android.shopping.store.home.preload.data;

import android.util.LruCache;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.home.entity.ECShopHeadInfoBlock;
import com.bytedance.android.shopping.store.home.entity.ECStoreHomeTabResponseTabkit;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Triple;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECStoreTabKitAPIDataCacheManager {
    public static final Lazy d = null;
    public final ti3.c a;
    public final LruCache<String, Triple<ECShopHeadInfoBlock, Long, fl.b>> b;
    public final LruCache<String, Triple<ECStoreHomeTabResponseTabkit[], Long, fl.b>> c;

    public static final class a {
    }

    static {
        d = LazyKt.lazy(LazyThreadSafetyMode.NONE, ECStoreTabKitAPIDataCacheManager$Companion$instance$2.INSTANCE);
    }

    public ECStoreTabKitAPIDataCacheManager() {
        this.a = new ti3.c();
        this.b = new LruCache(10);
        this.c = new LruCache(10);
    }

    public static boolean a(long r3, fl.b r5) {
        if ((r3 + ((long) (k.g(r5.a, 0) * ECDraweeView.SQUARE))) >= System.currentTimeMillis()) goto L6;
        return true;
    L6:
        return false;
    }
}
