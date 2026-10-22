package dv7;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes23.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f470176a;

    @Override // java.lang.Runnable
    public final void run() {
        Object r100 = this.f470176a.f470174b;     // Catch: Throwable -> L12
        monitor-enter(r100);     // Catch: Throwable -> L12
        b r101 = this.f470176a.f470175c;     // Catch: Throwable -> L9
        if (r101 == null) goto L7;
        r101.onCanceled();     // Catch: Throwable -> L9
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

    public i(h r100) {
        this.f470176a = r100;
    }
}
