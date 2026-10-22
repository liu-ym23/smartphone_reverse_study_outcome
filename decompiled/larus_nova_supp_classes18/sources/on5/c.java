package on5;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements Runnable {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.b.setValue(Boolean.FALSE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
