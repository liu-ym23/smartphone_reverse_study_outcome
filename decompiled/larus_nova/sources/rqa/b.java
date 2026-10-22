package rqa;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes5.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ pqa.a f538953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f538954b;

    @Override // java.lang.Runnable
    public final void run() {
        this.f538954b.e(this.f538953a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(a r100, pqa.a r101) {
        this.f538954b = r100;
        this.f538953a = r101;
    }
}
