package w35;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements Runnable {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
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
        if (this.a.isAttachedToWindow() == false) goto L11;
        a.c r0 = this.a.J;     // Catch: Throwable -> L8
        if (r0 == null) goto L15;
        r0.a();     // Catch: Throwable -> L8
        return;
    L15:
        return;
    }
}
