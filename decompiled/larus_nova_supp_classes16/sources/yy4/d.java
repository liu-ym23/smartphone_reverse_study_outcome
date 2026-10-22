package yy4;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements Runnable {
    public final /* synthetic */ b a;

    public d(b r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.a.observeForever(this.a.g);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
