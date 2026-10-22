package com.xiaomi.push;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes41.dex */
public class bb<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f463172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f463173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f463174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f463175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f463176e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f463177f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f463178g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f463179h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f463180i;

    public long c() {
        long r100 = this.f463177f;
        if (r100 <= 0) goto L8;
        long r101 = this.f463176e;
        if (r101 <= 0) goto L8;
        return r100 / r101;
    L8:
        return 0;
    }

    public long d() {
        long r100 = this.f463179h;
        long r101 = this.f463178g;
        if (r100 > r101) goto L5;
        return 0;
    L5:
        return r100 - r101;
    }

    public long a() {
        return this.f463174c;
    }

    public long b() {
        return this.f463175d;
    }

    public T a(Callable<T> r100) {
        long r101 = this.f463173b;
        long r102 = this.f463180i;
        if (r101 <= r102) goto L9;
        long r103 = (r101 / r102) * this.f463172a;
        this.f463173b = 0;
        if (r103 <= 0) goto L9;
        Thread.sleep(r103);     // Catch: Exception -> L8
    L9:
        long r104 = System.nanoTime();
        if (this.f463178g > 0) goto L28;
        this.f463178g = r104;
    L28:
        T r105 = r100.call();     // Catch: Exception -> L14
    L16:
        long r106 = System.nanoTime() - r104;
        this.f463179h = System.nanoTime();
        this.f463176e++;
        if (this.f463174c >= r106) goto L20;
        this.f463174c = r106;
    L20:
        if (r106 <= 0) goto L26;
        this.f463177f += r106;
        long r107 = this.f463175d;
        if (r107 != 0) goto L24;
    L25:
        this.f463175d = r106;
        goto L26
    L24:
        if (r107 > r106) goto L25;
    L26:
        this.f463173b += Math.max(r106, 0);
        return r105;
    L14:
        e = move-exception;
        e.printStackTrace();
        r105 = null;
        goto L16
    }

    public bb(long r100, long r101) {
        this.f463180i = r100 * 1000000;
        this.f463172a = r101;
    }
}
