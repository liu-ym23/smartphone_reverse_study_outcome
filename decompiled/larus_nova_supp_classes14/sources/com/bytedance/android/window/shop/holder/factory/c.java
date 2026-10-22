package com.bytedance.android.window.shop.holder.factory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public static final ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, Integer>> a = null;
    public static final ConcurrentHashMap<Integer, Pair<Integer, Integer>> b = null;
    public static final Pair<Integer, Integer> c = null;
    public static final IntRange d = null;
    public static final AtomicInteger e = null;

    static {
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
        c = TuplesKt.to(0, 0);
        d = RangesKt.until(200001, 300000);
        e = new AtomicInteger(200001);
    }
}
