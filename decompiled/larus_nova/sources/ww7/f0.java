package ww7;

/* JADX INFO: loaded from: classes23.dex */
public final class f0<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f561656a;

    public f0() {
        this.f561656a = new e();
    }

    public final void a(Exception r100) {
        e r101 = this.f561656a;
        Object r102 = r101.f561648a;
        monitor-enter(r102);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (r101.f561649b == true) goto L7;
        r101.f561649b = true;     // Catch: Throwable -> L9
        r101.f561651d = r100;     // Catch: Throwable -> L9
        r101.f561648a.notifyAll();     // Catch: Throwable -> L9
        r101.a();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r102);     // Catch: Throwable -> L9
    }

    public final void b(TResult r100) {
        e r101 = this.f561656a;
        Object r102 = r101.f561648a;
        monitor-enter(r102);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (r101.f561649b == true) goto L7;
        r101.f561649b = true;     // Catch: Throwable -> L9
        r101.f561650c = r100;     // Catch: Throwable -> L9
        r101.f561648a.notifyAll();     // Catch: Throwable -> L9
        r101.a();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r102);     // Catch: Throwable -> L9
    }
}
