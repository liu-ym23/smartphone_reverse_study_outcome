package com.bytedance.android.window.shop.home.viewmodel;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final AtomicLong a = null;

    public a() {
    }

    static {
        a = new AtomicLong(Long.MIN_VALUE);
    }

    public static String a() {
        Intrinsics.checkNotNullParameter("window", "prefix");
        return "window_" + a.getAndIncrement();
    }
}
