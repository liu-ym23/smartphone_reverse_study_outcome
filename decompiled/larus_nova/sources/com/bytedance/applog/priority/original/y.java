package com.bytedance.applog.priority.original;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes14.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f192803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Runnable f192804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ScheduledFuture<?> f192805c;

    public void a(long r110) {
        ScheduledFuture<?> r100 = this.f192805c;
        if (r100 == null) goto L5;
        r100.cancel(false);
    L5:
        ScheduledFuture<?> r101 = null;
        this.f192805c = null;
        if (r110 > 0) goto L8;
        return;
    L8:
        if (r110 >= Long.MAX_VALUE) goto L17;
        Runnable r102 = this.f192804b;
        if (r102 == null) goto L18;
        ScheduledExecutorService r103 = this.f192803a;
        if (r103 == null) goto L14;
        r101 = r103.scheduleWithFixedDelay(r102, 0, r110, TimeUnit.SECONDS);
    L14:
        this.f192805c = r101;
        return;
    L18:
        return;
    }

    public y(ScheduledExecutorService r100, Runnable r101, long r102) {
        this.f192803a = r100;
        this.f192804b = r101;
        a(r102);
    }
}
