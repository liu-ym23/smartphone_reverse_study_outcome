package es3;

import com.larus.apm.impl.protector.RunnableProtector;
import et3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements Runnable {
    public final /* synthetic */ h a;
    public final /* synthetic */ e b;

    @Override // java.lang.Runnable
    public final void run() {
        this.b.b.add(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(e r1, h r2) {
        this.b = r1;
        this.a = r2;
    }
}
