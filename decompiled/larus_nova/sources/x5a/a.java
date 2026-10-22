package x5a;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.lynx.component.svg.a f562552a;

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    L14:
        return;
    L3:
        if (this.f562552a.f380992v == true) goto L10;
        this.f562552a.f380987q = null;     // Catch: Throwable -> L7
        this.f562552a.e(0);     // Catch: Throwable -> L7
        this.f562552a.f380986p = false;     // Catch: Throwable -> L7
        return;
    }

    public a(com.lynx.component.svg.a r100) {
        this.f562552a = r100;
    }
}
