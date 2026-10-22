package om3;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f524289a;

    public g(e r100) {
        this.f524289a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e r100 = this.f524289a;     // Catch: Throwable -> L4
        int r101 = r100.f524257a;     // Catch: Throwable -> L4
        r100.a(false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
