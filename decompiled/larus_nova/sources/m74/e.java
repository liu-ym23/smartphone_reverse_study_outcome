package m74;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile T f512350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f512351b;

    public abstract T a(Object... r100);

    public e() {
        this.f512351b = new AtomicBoolean(false);
    }

    public final T b(Object... r100) {
        if (this.f512351b.get() == true) goto L18;
        if (this.f512350a != null) goto L18;
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (this.f512351b.get() == false) goto L10;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
        goto L18
    L10:
        if (this.f512350a != null) goto L12;
        this.f512350a = a(r100);     // Catch: Throwable -> L14
        this.f512351b.set(true);     // Catch: Throwable -> L14
    L18:
        return this.f512350a;
    }
}
