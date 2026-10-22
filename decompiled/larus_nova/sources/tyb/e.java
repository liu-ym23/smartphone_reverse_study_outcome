package tyb;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes37.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.b f548037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f548038b;

    public e(a.b r100, long r101) {
        this.f548037a = r100;
        this.f548038b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.b(a.f548019a, this.f548037a, this.f548038b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
