package ws3;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class g$a implements Runnable {
    public final /* synthetic */ g a;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.n();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public g$a(g r1) {
        this.a = r1;
    }
}
