package m8a;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.c f512492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f512493b;

    @Override // java.lang.Runnable
    public final void run() {
        this.f512493b.o(this.f512492a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(d r100, d.c r101) {
        this.f512493b = r100;
        this.f512492a = r101;
    }
}
