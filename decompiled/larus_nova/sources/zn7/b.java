package zn7;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f572933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f572934b;

    @Override // java.lang.Runnable
    public final void run() {
        c r100 = this.f572934b;     // Catch: Throwable -> L4
        String r101 = this.f572933a;     // Catch: Throwable -> L4
        r100.getClass();     // Catch: Throwable -> L4
        c.d(c.c(r101));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(c r100, String r101) {
        this.f572934b = r100;
        this.f572933a = r101;
    }
}
