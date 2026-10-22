package com.bytedance.android.shopping.store.utils;

import com.bytedance.android.shopping.store.hybrid.StoreTabConfig;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m {
    public static final ConcurrentHashMap<String, StoreTabConfig> a = null;
    public static final AtomicInteger b = null;

    static {
        a = new ConcurrentHashMap();
        b = new AtomicInteger(0);
    }

    public static StoreTabConfig a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "key");
        return a.get(r1);
    }

    public static String b(StoreTabConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "tabConfig");
        String r0 = String.valueOf(b.getAndIncrement());
        a.put(r0, r2);
        return r0;
    }
}
