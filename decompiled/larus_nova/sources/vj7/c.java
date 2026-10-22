package vj7;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f555427a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f555427a.a("countDown");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(b r100) {
        this.f555427a = r100;
    }
}
