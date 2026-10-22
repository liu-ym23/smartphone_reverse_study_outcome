package vi0;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e.a f555009a;

    public d(e.a r100) {
        this.f555009a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.a r100 = this.f555009a.f555011a.f555010a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.a();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
