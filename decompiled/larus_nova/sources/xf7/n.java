package xf7;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile T f563485a;

    public n() {
    }

    public abstract T a(Object... r100);

    public final T b(Object... r100) {
        if (this.f563485a != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f563485a != null) goto L8;
        this.f563485a = a(r100);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f563485a;
    }
}
