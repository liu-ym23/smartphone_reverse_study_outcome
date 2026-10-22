package com.larus.browsertakeover.transport;

/* JADX INFO: loaded from: classes26.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f319682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f319683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f319684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f319685d;

    public final synchronized e0 a() {
        monitor-enter(this);
        e0 r100 = new e0(this.f319682a, this.f319683b, this.f319684c, this.f319685d);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public d0() {
    }

    public final synchronized e0 b(int r110) {
        monitor-enter(this);
        if (r110 > 0) goto L18;
    L15:
        monitor-exit(this);
        return null;
    L18:
        int r100 = this.f319682a;     // Catch: Throwable -> L12
        if (r100 >= 512) goto L15;
        long r101 = r110;
        long r102 = this.f319683b;     // Catch: Throwable -> L12
        if (r101 > (8388608 - r102)) goto L15;
        int r103 = r100 + 1;     // Catch: Throwable -> L12
        this.f319682a = r103;     // Catch: Throwable -> L12
        this.f319683b = r102 + r101;     // Catch: Throwable -> L12
        this.f319684c = Math.max(this.f319684c, r103);     // Catch: Throwable -> L12
        long r104 = Math.max(this.f319685d, this.f319683b);     // Catch: Throwable -> L12
        this.f319685d = r104;     // Catch: Throwable -> L12
        e0 r111 = new e0(this.f319682a, this.f319683b, this.f319684c, r104);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r111;
    L12:
        th = move-exception;
        throw th;
    }
}
