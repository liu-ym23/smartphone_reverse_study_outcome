package j28;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes24.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f497022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f497023b;

    @Override // java.lang.Runnable
    public final void run() {
        this.f497023b.f497026c.f488059c.execute(this.f497022a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(d r100, b r101) {
        this.f497023b = r100;
        this.f497022a = r101;
    }
}
