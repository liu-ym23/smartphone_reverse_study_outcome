package rm3;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f538538a;

    public b(a r100) {
        this.f538538a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a r100 = this.f538538a;     // Catch: Throwable -> L7
        r100.getClass();     // Catch: Throwable -> L7
        if (r100.f538536c.isShowing() == false) goto L10;
        a.a(r100.f538536c);     // Catch: Throwable -> L7 Exception -> L12
        goto L18
    L17:
        return;
    L10:
        return;
    L18:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
