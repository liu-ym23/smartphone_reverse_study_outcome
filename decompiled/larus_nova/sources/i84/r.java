package i84;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public abstract class r<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile T f488638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f488639b;

    public abstract T a(Object... r100);

    public r() {
        this.f488639b = new AtomicBoolean(false);
    }

    public final T b(Object... r100) {
        if (this.f488639b.get() == true) goto L18;
        if (this.f488638a != null) goto L18;
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (this.f488639b.get() == false) goto L10;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
        goto L18
    L10:
        if (this.f488638a != null) goto L12;
        this.f488638a = a(r100);     // Catch: Throwable -> L14
        this.f488639b.set(true);     // Catch: Throwable -> L14
    L18:
        return this.f488638a;
    }
}
