package vic;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes40.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f555394a;

    @Override // java.lang.Runnable
    public final void run() {
        a.b(this.f555394a, false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(a r100) {
        this.f555394a = r100;
    }
}
