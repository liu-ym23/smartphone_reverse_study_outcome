package um5;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements Runnable {
    public final /* synthetic */ b a;

    public d(b r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a r0 = this.a.m;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.b();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
