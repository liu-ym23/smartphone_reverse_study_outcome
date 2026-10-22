package ww7;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes23.dex */
public final class s0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f561707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u0 f561708b;

    @Override // java.lang.Runnable
    public final void run() {
        Object r100 = this.f561708b.f561718c;     // Catch: Throwable -> L12
        monitor-enter(r100);     // Catch: Throwable -> L12
        Object r101 = this.f561708b.f561717b;     // Catch: Throwable -> L9
        if (r101 == null) goto L7;
        this.f561707a.d();     // Catch: Throwable -> L9
        ((w0) r101).f561722a.countDown();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
    L15:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L21;
        throw th;
    }

    public s0(u0 r100, e r101) {
        this.f561708b = r100;
        this.f561707a = r101;
    }
}
