package fi7;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        throw null;     // Catch: Throwable -> L4
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(b r100, String r101) {
    }
}
