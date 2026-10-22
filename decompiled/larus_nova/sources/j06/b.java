package j06;

/* JADX INFO: loaded from: classes19.dex */
public class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f496811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile T f496812b;

    public T b() {
        throw null;
    }

    public final T a() {
        if (this.f496812b != null) goto L20;
        if (this.f496811a == true) goto L24;
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L9:
        if (this.f496811a == false) goto L13;
        T r100 = this.f496812b;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
    L21:
        return r100;
    L13:
        this.f496812b = b();     // Catch: Throwable -> L16
        this.f496811a = true;     // Catch: Throwable -> L16
        r100 = this.f496812b;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        goto L21
    L24:
        return this.f496812b;
    L20:
        return this.f496812b;
    }

    public b() {
        this.f496811a = false;
    }
}
