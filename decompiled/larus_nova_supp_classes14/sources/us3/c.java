package us3;

import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements Runnable {
    public final /* synthetic */ vs3.b a;
    public final /* synthetic */ e b;

    @Override // java.lang.Runnable
    public final void run() {
        e r0 = this.b;     // Catch: Throwable -> L4
        vs3.b r1 = this.a;     // Catch: Throwable -> L4
        r0.getClass();     // Catch: Throwable -> L4
        Looper.myQueue().addIdleHandler(new d(r1));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(e r1, vs3.b r2) {
        this.b = r1;
        this.a = r2;
    }
}
