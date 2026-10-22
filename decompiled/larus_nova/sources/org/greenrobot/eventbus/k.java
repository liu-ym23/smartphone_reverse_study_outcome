package org.greenrobot.eventbus;

/* JADX INFO: loaded from: classes42.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f525812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f525813b;

    public k() {
    }

    public final synchronized j b() {
        monitor-enter(this);
        j r100 = this.f525812a;     // Catch: Throwable -> L10
        if (r100 == null) goto L8;
        j r101 = r100.f525811c;     // Catch: Throwable -> L10
        this.f525812a = r101;     // Catch: Throwable -> L10
        if (r101 != null) goto L8;
        this.f525813b = null;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r100;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized j c() throws InterruptedException {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f525812a != null) goto L6;
        wait(1000);     // Catch: Throwable -> L9
    L6:
        j r100 = b();     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
    }

    public final synchronized void a(j r100) {
        monitor-enter(this);
        j r101 = this.f525813b;     // Catch: Throwable -> L14
        if (r101 == null) goto L7;
        r101.f525811c = r100;     // Catch: Throwable -> L14
        this.f525813b = r100;     // Catch: Throwable -> L14
    L9:
        notifyAll();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L7:
        if (this.f525812a != null) goto L13;
        this.f525813b = r100;     // Catch: Throwable -> L14
        this.f525812a = r100;     // Catch: Throwable -> L14
        goto L9
    L13:
        throw new IllegalStateException("Head present, but no tail");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }
}
