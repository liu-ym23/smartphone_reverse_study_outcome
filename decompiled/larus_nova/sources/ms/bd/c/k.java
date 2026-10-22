package ms.bd.c;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes6.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f515176a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f515176a.getClass();     // Catch: Throwable -> L7
        if (n.b() != 0) goto L5;
        n.c(0);     // Catch: Throwable -> L7
        n.f515227e = false;     // Catch: Throwable -> L7
    L12:
        return;
    L5:
        n.f515230h.postDelayed(new j(this), 1000);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L15;
        throw th;
    }

    public k(l r100) {
        this.f515176a = r100;
    }
}
