package com.larksuite.framework.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes24.dex */
public final class i extends p {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f285766l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static i f285767m;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f285768h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f285769i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f285770j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicInteger f285771k;

    static {
        f285766l = Runtime.getRuntime().availableProcessors();
        f285767m = null;
    }

    public final void h(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = this.f285771k.incrementAndGet();
    L5:
        int r102 = getCorePoolSize();
        int r103 = getMaximumPoolSize();
        int r104 = r102 * 2;
        if (r101 > (r104 + 1)) goto L8;
    L11:
        if (r102 > 1) goto L13;
        return;
    L13:
        if (r101 > (r104 - 1)) goto L17;
        setMaximumPoolSize(r103 - 1);
        setCorePoolSize(r102 - 1);
        return;
    L17:
        return;
    L8:
        if (r102 >= f285766l) goto L11;
        setCorePoolSize(r102 + 1);
        setMaximumPoolSize(r103 + 1);
        return;
    L4:
        r101 = this.f285771k.decrementAndGet();
        goto L5
    }

    public i(String r100, BlockingQueue<Runnable> r110, n r111) {
        super(r100, 1, 2, 30, r110, r111);
        this.f285768h = 1000;
        this.f285769i = 5000;
        this.f285770j = 5000;
        this.f285771k = new AtomicInteger(0);
        this.f285798b = this.f285797a + "-SerialExecutor";
    }
}
