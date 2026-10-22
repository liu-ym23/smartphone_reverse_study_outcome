package com.xiaomi.push;

/* JADX INFO: loaded from: classes41.dex */
public class bc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f463181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f463182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f463183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f463184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f463185e;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m8848a() {
        this.f463183c++;
    }

    public bc() {
        this.f463185e = System.currentTimeMillis();
    }

    public long b() {
        return this.f463182b;
    }

    public long c() {
        return this.f463183c;
    }

    public long d() {
        return this.f463184d;
    }

    public int a() {
        return com.xiaomi.push.service.ag.a() ? 1 : 0;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m8847a() {
        return this.f463181a;
    }

    public void a(long r100) {
        this.f463181a = r100;
    }

    public void b(long r100) {
        this.f463182b += r100;
    }

    public void c(long r100) {
        this.f463184d += r100;
    }
}
