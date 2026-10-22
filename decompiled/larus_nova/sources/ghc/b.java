package ghc;

/* JADX INFO: loaded from: classes5.dex */
public class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f481326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f481327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f481328c;

    public T b() {
        throw null;
    }

    public final T a() {
        T r100 = this.f481328c;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (this.f481327b == true) goto L23;
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L10:
        if (this.f481327b == false) goto L14;
        T r101 = this.f481328c;     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
    L20:
        return r101;
    L14:
        this.f481328c = b();     // Catch: Throwable -> L17
        this.f481327b = true;     // Catch: Throwable -> L17
        r101 = this.f481328c;     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        goto L20
    L23:
        return this.f481328c;
    }

    public b() {
        this.f481326a = false;
        this.f481327b = false;
    }
}
