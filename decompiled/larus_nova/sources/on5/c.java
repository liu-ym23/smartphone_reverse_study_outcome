package on5;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f524370a = null;

    static {
        f524370a = new c();
    }

    public c() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        b.f524356b.setValue(Boolean.FALSE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
