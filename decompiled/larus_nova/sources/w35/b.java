package w35;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f558153a;

    public b(a r100) {
        this.f558153a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    L16:
        return;
    L3:
        if (this.f558153a.isAttachedToWindow() == false) goto L11;
        a.c r100 = this.f558153a.f558151J;     // Catch: Throwable -> L8
        if (r100 == null) goto L15;
        r100.a();     // Catch: Throwable -> L8
        return;
    L15:
        return;
    }
}
