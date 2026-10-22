package ph;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f529228a = null;

    static {
        f529228a = new c();
    }

    public c() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        d.a(false);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L9;
        return;
    L9:
        throw th;
    }
}
