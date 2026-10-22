package com.bytedance.applog.priority.original;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class y {
    public final ScheduledExecutorService a;
    public final Runnable b;
    public ScheduledFuture<?> c;

    public void a(long r12) {
        ScheduledFuture<?> r0 = this.c;
        if (r0 == null) goto L5;
        r0.cancel(false);
    L5:
        ScheduledFuture<?> r1 = null;
        this.c = null;
        if (r12 > 0) goto L8;
        return;
    L8:
        if (r12 >= Long.MAX_VALUE) goto L17;
        Runnable r5 = this.b;
        if (r5 == null) goto L18;
        ScheduledExecutorService r4 = this.a;
        if (r4 == null) goto L14;
        r1 = r4.scheduleWithFixedDelay(r5, 0, r12, TimeUnit.SECONDS);
    L14:
        this.c = r1;
        return;
    L18:
        return;
    }

    public y(ScheduledExecutorService r1, Runnable r2, long r3) {
        this.a = r1;
        this.b = r2;
        a(r3);
    }
}
