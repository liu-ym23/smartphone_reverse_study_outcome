package um5;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f550688a;

    public d(b r100) {
        this.f550688a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a r100 = this.f550688a.f550677m;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.b();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
