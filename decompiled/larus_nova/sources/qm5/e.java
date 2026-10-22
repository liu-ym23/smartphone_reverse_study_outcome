package qm5;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f533892a = null;

    static {
        f533892a = new e();
    }

    public e() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        d.f533878b.setValue(Boolean.FALSE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
