package tx4;

import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import jx4.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements Runnable {
    public final /* synthetic */ a.InterfaceC0301a a;

    public c(a.InterfaceC0301a r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.InterfaceC0301a r0 = this.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        UDToast.show(((t.a) r0).a.J, "failed!");     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
