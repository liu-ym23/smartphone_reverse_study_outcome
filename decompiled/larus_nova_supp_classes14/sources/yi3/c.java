package yi3;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements Runnable {
    public final /* synthetic */ b.i a;

    public c(b.i r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.r0(this.a.a).b();     // Catch: Throwable -> L4
        this.a.a.T().getSkipHeaderCollapseAnimOnce().setValue(Boolean.FALSE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
