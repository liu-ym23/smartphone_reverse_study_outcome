package com.google.common.cache;

/* JADX INFO: loaded from: classes23.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f274867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f274868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f274869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f274870d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f274871e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j f274872f;

    public static long g(long r100) {
        if (r100 >= 0) goto L7;
        return Long.MAX_VALUE;
    L7:
        return r100;
    }

    @Override // com.google.common.cache.b
    public final void b() {
        this.f274872f.increment();
    }

    @Override // com.google.common.cache.b
    public final e snapshot() {
        return new e(g(this.f274867a.sum()), g(this.f274868b.sum()), g(this.f274869c.sum()), g(this.f274870d.sum()), g(this.f274871e.sum()), g(this.f274872f.sum()));
    }

    public a() {
        this.f274867a = LongAddables.a();
        this.f274868b = LongAddables.a();
        this.f274869c = LongAddables.a();
        this.f274870d = LongAddables.a();
        this.f274871e = LongAddables.a();
        this.f274872f = LongAddables.a();
    }

    @Override // com.google.common.cache.b
    public final void a(int r100) {
        this.f274867a.add(r100);
    }

    @Override // com.google.common.cache.b
    public final void c(long r100) {
        this.f274869c.increment();
        this.f274871e.add(r100);
    }

    @Override // com.google.common.cache.b
    public final void d(int r100) {
        this.f274868b.add(r100);
    }

    @Override // com.google.common.cache.b
    public final void e(long r100) {
        this.f274870d.increment();
        this.f274871e.add(r100);
    }

    public final void f(b r100) {
        e r101 = r100.snapshot();
        this.f274867a.add(r101.f274876a);
        this.f274868b.add(r101.f274877b);
        this.f274869c.add(r101.f274878c);
        this.f274870d.add(r101.f274879d);
        this.f274871e.add(r101.f274880e);
        this.f274872f.add(r101.f274881f);
    }
}
