package r00;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Throwable f535403a;

    public c(Throwable r100) {
        this.f535403a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    L3:
        throw new Exception(this.f535403a);     // Catch: Throwable -> L4
    }
}
