package rm3;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements Runnable {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a r0 = this.a;     // Catch: Throwable -> L7
        r0.getClass();     // Catch: Throwable -> L7
        if (r0.c.isShowing() == false) goto L10;
        a.a(r0.c);     // Catch: Throwable -> L7 Exception -> L12
        goto L18
    L17:
        return;
    L10:
        return;
    L18:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
