package com.bytedance.android.shopping.api.mall.common.feed.jsb;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallPreloadResourceHelper {
    public static final Function6<? super String, ? super String, ? super String, ? super Integer, ? super Integer, ? super Function1<? super ConcurrentHashMap<String, Object>, Unit>, Unit> a = null;
    public static final AtomicInteger b = null;
    public static final AtomicInteger c = null;
    public static final AtomicReference<String> d = null;
    public static final ConcurrentHashMap<String, Object> e = null;
    public static final ConcurrentHashMap<String, Object> f = null;
    public static final ConcurrentLinkedQueue<ConcurrentHashMap<String, Object>> g = null;

    static {
        a = ECMallPreloadResourceHelper$preLoadImageResource$1.INSTANCE;
        b = new AtomicInteger(0);
        c = new AtomicInteger(1);
        d = new AtomicReference("success: all preload success");
        e = new ConcurrentHashMap();
        f = new ConcurrentHashMap();
        g = new ConcurrentLinkedQueue();
    }
}
