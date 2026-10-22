package yn;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f568463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f568464b;

    public e(d r100, boolean r101) {
        this.f568463a = r100;
        this.f568464b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d.i(this.f568463a, this.f568464b, 2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
