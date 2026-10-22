package tx4;

import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import jx4.t;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.InterfaceC7790a f547820a;

    public c(a.InterfaceC7790a r100) {
        this.f547820a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.InterfaceC7790a r100 = this.f547820a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        UDToast.show(((t.a) r100).f500858a.f500833J, "failed!");     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
