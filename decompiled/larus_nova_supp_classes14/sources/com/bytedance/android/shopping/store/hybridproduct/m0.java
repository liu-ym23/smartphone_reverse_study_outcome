package com.bytedance.android.shopping.store.hybridproduct;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m0 {
    public static final IntRange a = null;
    public static final a b = null;
    public static final a c = null;

    public static final class a {
        public final ConcurrentHashMap<Integer, Integer> a;
        public final ConcurrentHashMap<Integer, Integer> b;
        public final ConcurrentHashMap<Integer, Integer> c;
        public final AtomicInteger d;

        public a(int r2) {
            new ConcurrentHashMap();
            this.a = new ConcurrentHashMap();
            this.b = new ConcurrentHashMap();
            this.c = new ConcurrentHashMap();
            this.d = new AtomicInteger(r2);
        }
    }

    static {
        a = RangesKt.until(50001, 100000);
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        new AtomicInteger(0);
        b = new a(0);
        c = new a(50001);
    }
}
