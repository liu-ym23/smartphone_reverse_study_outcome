package r00;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f535413a;

    public e(d r100) {
        this.f535413a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b r100 = this.f535413a.d();     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        this.f535413a.f535404a.remove(r100);     // Catch: Throwable -> L6
        this.f535413a.e(r100.f535401a);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
