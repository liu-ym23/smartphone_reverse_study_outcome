package kg9;

import android.os.Looper;

/* JADX INFO: loaded from: classes4.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f503392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f503393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f503394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f503395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f503396e;

    public final synchronized void a() {
        monitor-enter(this);
        this.f503394c = true;     // Catch: Throwable -> L7
        this.f503396e.removeMessages(1);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public abstract void b();

    public abstract void c();

    public final synchronized void d() {
        monitor-enter(this);
        this.f503394c = false;     // Catch: Throwable -> L12
        if (this.f503392a > 0) goto L9;
        b();     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L9:
        this.f503395d = 0;     // Catch: Throwable -> L12
        h r100 = this.f503396e;     // Catch: Throwable -> L12
        r100.sendMessage(r100.obtainMessage(1));     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public i(long r100) {
        this.f503392a = r100;
        this.f503393b = 1000;
        this.f503396e = new h(this, Looper.getMainLooper());
    }
}
