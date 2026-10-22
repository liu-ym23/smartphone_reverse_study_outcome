package om3;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g implements Runnable {
    public final /* synthetic */ e a;

    public g(e r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e r0 = this.a;     // Catch: Throwable -> L4
        int r1 = r0.a;     // Catch: Throwable -> L4
        r0.a(false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
