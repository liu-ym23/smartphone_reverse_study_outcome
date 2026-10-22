package po2;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f530043a;

    public e(a r100) {
        this.f530043a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f530043a.getClass();     // Catch: Throwable -> L4
        a.d();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
