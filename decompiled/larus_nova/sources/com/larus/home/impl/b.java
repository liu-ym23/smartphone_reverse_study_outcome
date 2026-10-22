package com.larus.home.impl;

import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes29.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f344160a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f344161b = null;

    static {
        f344160a = new AtomicBoolean(false);
        f344161b = new AtomicBoolean(false);
    }

    public static void a(String r100, boolean r101, long r102, long r103, long r104, AtomicBoolean r110, String r111) {
        if (r101 == true) goto L4;
        return;
    L4:
        long r105 = RangesKt.coerceAtMost(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r102, 0), RangesKt.coerceAtLeast(r103, 0)), r104);
        if (r105 > 0) goto L8;
        return;
    L8:
        if (r110.compareAndSet(false, true) == true) goto L11;
        FLogger.f375446a.i("AppLaunchDegradationExperiment", "skip delay because it has already been injected, type=".concat(r100));
        return;
    L11:
        long r106 = System.currentTimeMillis();
        Thread.sleep(r105);     // Catch: InterruptedException -> L15
        long r107 = System.currentTimeMillis() - r106;
        FLogger.f375446a.i("AppLaunchDegradationExperiment", "inject delay, type=" + r100 + ", scene=" + r111 + ", delayMs=" + r105 + ", actualDelayMs=" + r107);
        return;
    L15:
        e = move-exception;
        ThreadMethodProxy.currentThread().interrupt();
        FLogger.f375446a.e("AppLaunchDegradationExperiment", "inject delay interrupted, type=".concat(r100), e);
    }
}
