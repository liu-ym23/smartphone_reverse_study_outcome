package hn7;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f486118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f486119b;

    @Override // java.lang.Runnable
    public final void run() {
        Object r100 = d.f486120a;     // Catch: Throwable -> L4
        this.f486119b.a(this.f486118a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(Class r100, a r101, b r102) {
        this.f486118a = r101;
        this.f486119b = r102;
    }
}
