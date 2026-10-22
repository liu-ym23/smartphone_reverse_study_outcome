package ww7;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes23.dex */
public final class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f561709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f561710b;

    @Override // java.lang.Runnable
    public final void run() {
        k0 r100 = c0.f561643e.f561647d;     // Catch: Throwable -> L4
        a r101 = this.f561709a;     // Catch: Throwable -> L4
        r100.a(new e0(r100, this.f561710b), r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public t(zw7.a.C8500a r100, boolean r101) {
        c0 r102 = c0.f561643e;
        this.f561709a = r100;
        this.f561710b = r101;
    }
}
