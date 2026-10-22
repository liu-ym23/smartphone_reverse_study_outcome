package com.xiaomi.push;

/* JADX INFO: loaded from: classes41.dex */
public class hs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final hz f464083a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final ii f941a;

    public hs() {
        this(new hv.a());
    }

    public hs(ib r100) {
        ii r101 = new ii();
        this.f941a = r101;
        this.f464083a = r100.a(r101);
    }

    public void a(hp r100, byte[] r101) {
        this.f941a.a(r101);     // Catch: Throwable -> L5
        r100.a(this.f464083a);     // Catch: Throwable -> L5
        this.f464083a.k();
        return;
    L5:
        th = move-exception;
        this.f464083a.k();
        throw th;
    }
}
