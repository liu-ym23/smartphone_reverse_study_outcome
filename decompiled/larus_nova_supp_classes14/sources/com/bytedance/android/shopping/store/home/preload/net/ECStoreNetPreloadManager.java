package com.bytedance.android.shopping.store.home.preload.net;

import com.bytedance.android.ec.store.utils.taskmanager.ECTaskManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECStoreNetPreloadManager {
    public static final Lazy b = null;
    public long a;

    public static final class a {
    }

    public ECStoreNetPreloadManager() {
    }

    static {
        b = LazyKt.lazy(LazyThreadSafetyMode.NONE, ECStoreNetPreloadManager$Companion$instance$2.INSTANCE);
    }

    public static void a() {
        Lazy r0 = ECTaskManager.b;
        ECTaskManager r1 = ECTaskManager.a.a();
        ECStoreNetPreloadManager$preloadPicDomain$1 r2 = ECStoreNetPreloadManager$preloadPicDomain$1.INSTANCE;
        r1.getClass();
        ECTaskManager.b(r2);
    }
}
