package yy4;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f569472a;

    public c(b r100) {
        this.f569472a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b r100 = this.f569472a;     // Catch: Throwable -> L4
        r100.f569456e.observeForever(r100.f569457f);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
