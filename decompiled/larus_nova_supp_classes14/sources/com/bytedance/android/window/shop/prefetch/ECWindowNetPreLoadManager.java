package com.bytedance.android.window.shop.prefetch;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowNetPreLoadManager {
    public static final Lazy b = null;
    public long a;

    public static final class a {
    }

    public ECWindowNetPreLoadManager() {
    }

    static {
        b = LazyKt.lazy(LazyThreadSafetyMode.NONE, ECWindowNetPreLoadManager$Companion$instance$2.INSTANCE);
    }
}
