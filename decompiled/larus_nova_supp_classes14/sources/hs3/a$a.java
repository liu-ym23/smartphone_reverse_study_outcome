package hs3;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class a$a implements Runnable {
    public final /* synthetic */ c a;
    public final /* synthetic */ a b;

    @Override // java.lang.Runnable
    public final void run() {
        this.b.d(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a$a(a r1, c r2) {
        this.b = r1;
        this.a = r2;
    }
}
