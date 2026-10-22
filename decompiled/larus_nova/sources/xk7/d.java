package xk7;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f564219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f564220b;

    public d(e r100, String r101) {
        this.f564219a = r100;
        this.f564220b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e r100 = this.f564219a;     // Catch: Throwable -> L4
        String r101 = this.f564220b;     // Catch: Throwable -> L4
        r100.f564232l = null;     // Catch: Throwable -> L4
        r100.a(r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
