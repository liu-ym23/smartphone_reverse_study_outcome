package ts4;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f547392a;

    public c(a r100, int r101) {
        this.f547392a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a r100 = this.f547392a;     // Catch: Throwable -> L6
        if (r100.f547378d == false) goto L9;
        r100.b();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
