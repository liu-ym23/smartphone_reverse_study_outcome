package qm5;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements Runnable {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        d.b.setValue(Boolean.FALSE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
