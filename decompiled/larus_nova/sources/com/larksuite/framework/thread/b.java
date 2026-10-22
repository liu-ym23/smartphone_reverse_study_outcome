package com.larksuite.framework.thread;

import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes24.dex */
public final class b extends p {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f285730j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f285731k = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f285732h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f285733i;

    static {
        int r100 = Runtime.getRuntime().availableProcessors();
        f285730j = r100;
        f285731k = r100 + 3;
    }

    public b(String r100, int r110, int r111, BlockingQueue<Runnable> r112, n r113) {
        super(r100, r110, r111, 30, r112, r113);
        this.f285732h = 2000;
        this.f285733i = 1000;
        this.f285798b = this.f285797a + "-CPUExecutor";
        this.f285732h = 2000;
        this.f285733i = 1000;
    }
}
