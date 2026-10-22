package i84;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class r<T> {
    public volatile T a;
    public final AtomicBoolean b;

    public abstract T a(Object... r1);

    public r() {
        this.b = new AtomicBoolean(false);
    }

    public final T b(Object... r2) {
        if (this.b.get() == true) goto L18;
        if (this.a != null) goto L18;
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (this.b.get() == false) goto L10;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
        goto L18
    L10:
        if (this.a != null) goto L12;
        this.a = a(r2);     // Catch: Throwable -> L14
        this.b.set(true);     // Catch: Throwable -> L14
    L18:
        return this.a;
    }
}
