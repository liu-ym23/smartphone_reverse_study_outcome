package i84;

/* JADX INFO: loaded from: classes.dex */
public abstract class g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile g84.b f488619a;

    public g() {
    }

    public abstract g84.b a(Object... r100);

    public final T b(Object... r100) {
        if (this.f488619a != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f488619a != null) goto L8;
        this.f488619a = a(r100);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return (T) this.f488619a;
    }
}
