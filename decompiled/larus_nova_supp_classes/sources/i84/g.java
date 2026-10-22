package i84;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class g<T> {
    public volatile g84.b a;

    public g() {
    }

    public abstract g84.b a(Object... r1);

    public final T b(Object... r2) {
        if (this.a != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.a != null) goto L8;
        this.a = a(r2);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return (T) this.a;
    }
}
