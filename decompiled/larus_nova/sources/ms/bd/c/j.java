package ms.bd.c;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes6.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f515168a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f515168a.f515176a.getClass();     // Catch: Throwable -> L6
        if (n.b() != 0) goto L9;
        n.c(0);     // Catch: Throwable -> L6
        n.f515227e = false;     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public j(k r100) {
        this.f515168a = r100;
    }
}
