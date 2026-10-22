package com.tencent.open.log;

/* JADX INFO: loaded from: classes31.dex */
public abstract class Tracer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile int f461772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f461773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f461774c;

    public abstract void doTrace(int r100, Thread r101, long r102, String r103, String r104, Throwable r105);

    public Tracer() {
        this(c.f461798a, true, g.f461819a);
    }

    public boolean d() {
        return this.f461773b;
    }

    public g e() {
        return this.f461774c;
    }

    public void a(int r100) {
        this.f461772a = r100;
    }

    public void a(g r100) {
        this.f461774c = r100;
    }

    public void a(boolean r100) {
        this.f461773b = r100;
    }

    public Tracer(int r100, boolean r101, g r102) {
        this.f461772a = c.f461798a;
        this.f461773b = true;
        this.f461774c = g.f461819a;
        a(r100);
        a(r101);
        a(r102);
    }

    public void a(int r100, Thread r101, long r102, String r103, String r104, Throwable r105) {
        if (d() == true) goto L5;
        return;
    L5:
        if (d.a.a(this.f461772a, r100) == false) goto L9;
        doTrace(r100, r101, r102, r103, r104, r105);
        return;
    }
}
