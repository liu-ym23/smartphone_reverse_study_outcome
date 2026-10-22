package v;

import bolts.CancellationTokenSource;
import java.io.Closeable;

/* JADX INFO: loaded from: classes28.dex */
public final class c implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f552268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CancellationTokenSource f552269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Runnable f552270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f552271d;

    public final void a() {
        Object r100 = this.f552268a;
        monitor-enter(r100);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f552271d == true) goto L12;
        this.f552270c.run();     // Catch: Throwable -> L9
        close();     // Catch: Throwable -> L9
        monitor-exit(r100);     // Catch: Throwable -> L9
        return;
    L12:
        throw new IllegalStateException("Object already closed");     // Catch: Throwable -> L9
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Object r100 = this.f552268a;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f552271d == false) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L8:
        this.f552271d = true;     // Catch: Throwable -> L11
        this.f552269b.unregister(this);     // Catch: Throwable -> L11
        this.f552269b = null;     // Catch: Throwable -> L11
        this.f552270c = null;     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
    }

    public c(CancellationTokenSource r100, Runnable r101) {
        this.f552268a = new Object();
        this.f552269b = r100;
        this.f552270c = r101;
    }
}
