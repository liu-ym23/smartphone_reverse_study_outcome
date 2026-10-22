package xg4;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.b f563652a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f563652a.f563651f.decrementAndGet();     // Catch: Throwable -> L4
        this.f563652a.f();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public e(d.b r100) {
        this.f563652a = r100;
    }
}
