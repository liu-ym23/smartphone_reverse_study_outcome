package ea9;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes29.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f471724a;

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    L14:
        return;
    L3:
        if (this.f471724a.f471695o == false) goto L10;
        this.f471724a.l(false);     // Catch: Throwable -> L7
        this.f471724a.f471705y.postDelayed(this, 10000);     // Catch: Throwable -> L7
        return;
    }

    public g(e r100) {
        this.f471724a = r100;
    }
}
