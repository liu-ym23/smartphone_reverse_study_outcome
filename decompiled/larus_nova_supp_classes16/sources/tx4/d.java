package tx4;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements Runnable {
    public final /* synthetic */ a.InterfaceC0301a a;
    public final /* synthetic */ int b;

    public d(a.InterfaceC0301a r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.a == null) goto L9;
        tt5.a.h("GeneralDebugInfo", "roaster downloading, progress = " + this.b);     // Catch: Throwable -> L6
        return;
    }
}
