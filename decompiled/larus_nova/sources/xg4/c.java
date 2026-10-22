package xg4;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.a f563639a;

    @Override // java.lang.Runnable
    public final void run() {
        d.a r100 = this.f563639a;     // Catch: Throwable -> L4
        r100.f563648i = true;     // Catch: Throwable -> L4
        r100.f563645f.incrementAndGet();     // Catch: Throwable -> L4
        r100.f();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(d.a r100) {
        this.f563639a = r100;
    }
}
