package tx4;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.InterfaceC7790a f547821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f547822b;

    public d(a.InterfaceC7790a r100, int r101) {
        this.f547821a = r100;
        this.f547822b = r101;
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
        if (this.f547821a == null) goto L9;
        tt5.a.h("GeneralDebugInfo", "roaster downloading, progress = " + this.f547822b);     // Catch: Throwable -> L6
        return;
    }
}
