package ww7;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes23.dex */
public final class o0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f561687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q0 f561688b;

    @Override // java.lang.Runnable
    public final void run() {
        Object r100 = this.f561688b.f561695c;     // Catch: Throwable -> L12
        monitor-enter(r100);     // Catch: Throwable -> L12
        b0 r101 = this.f561688b.f561694b;     // Catch: Throwable -> L9
        if (r101 == null) goto L7;
        this.f561687a.c();     // Catch: Throwable -> L9
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

    public o0(q0 r100, e r101) {
        this.f561688b = r100;
        this.f561687a = r101;
    }
}
