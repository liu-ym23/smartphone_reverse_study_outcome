package r37;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class a<R, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile T f535877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f535878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f535879c;

    public a() {
    }

    public T b() {
        throw null;
    }

    public final Object a() {
        if (this.f535877a == null) goto L8;
        T r100 = this.f535877a;
        if (r100 != null) goto L30;
        Intrinsics.throwNpe();
        return r100;
    L30:
        return r100;
    L8:
        if (this.f535879c == true) goto L29;
        if (this.f535878b == true) goto L29;
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L14:
        if (this.f535879c == false) goto L18;
        T r101 = this.f535877a;     // Catch: Throwable -> L21
        monitor-exit(this);
    L26:
        return r101;
    L18:
        this.f535877a = b();     // Catch: Throwable -> L21
        this.f535879c = true;     // Catch: Throwable -> L21
        r101 = this.f535877a;     // Catch: Throwable -> L21
        monitor-exit(this);
    L29:
        return this.f535877a;
    }
}
