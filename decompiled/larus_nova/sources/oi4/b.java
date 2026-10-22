package oi4;

import ki4.u;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f523390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f523391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f523392c;

    @Override // ki4.u
    public final synchronized int nextIndex() {
        monitor-enter(this);
        int r100 = this.f523390a;     // Catch: Throwable -> L7
        int r101 = this.f523391b;     // Catch: Throwable -> L7
        int r102 = this.f523392c;     // Catch: Throwable -> L7
        this.f523392c = r102 + 1;     // Catch: Throwable -> L7
        int r103 = r100 + (r101 * r102);
        monitor-exit(this);
        return r103;
    L7:
        th = move-exception;
        throw th;
    }

    public b() {
        this.f523390a = 500;
        this.f523391b = 500;
    }
}
