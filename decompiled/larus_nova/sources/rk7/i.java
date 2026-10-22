package rk7;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ xk7.e f538342a;

    public i(xk7.e r100) {
        this.f538342a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j.f538344b.b(this.f538342a);     // Catch: Throwable -> L4
        g.a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
