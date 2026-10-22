package j7c;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f497662a;

    public c(b r100) {
        this.f497662a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a r100 = this.f497662a.f497658b;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.onLoadMore();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
