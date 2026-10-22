package pl.droidsonroids.gif;

/* JADX INFO: loaded from: classes41.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f529706a;

    public b() {
    }

    public final synchronized void a() throws InterruptedException {
        monitor-enter(this);
    L12:
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f529706a == true) goto L7;
        wait();     // Catch: Throwable -> L9
        goto L12
    L7:
        monitor-exit(this);
    }

    public final synchronized void b() {
        monitor-enter(this);
        this.f529706a = false;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void c() {
        monitor-enter(this);
        boolean r100 = this.f529706a;     // Catch: Throwable -> L8
        this.f529706a = true;     // Catch: Throwable -> L8
        if (r100 == true) goto L6;
        notify();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
