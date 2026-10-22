package hc7;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f484550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f484551b;

    @Override // java.lang.Runnable
    public final void run() {
        this.f484551b.c(this.f484550a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(a r100, Object r101) {
        this.f484551b = r100;
        this.f484550a = r101;
    }
}
