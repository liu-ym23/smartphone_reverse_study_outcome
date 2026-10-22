package tyb;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f548028a = null;

    static {
        f548028a = new b();
    }

    public b() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.f548019a.getClass();     // Catch: Throwable -> L4
        a.f();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
