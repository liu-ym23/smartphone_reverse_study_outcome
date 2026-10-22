package my5;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f516384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f516385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f516386c;

    @Override // java.lang.Runnable
    public final void run() {
        a r100 = this.f516386c;     // Catch: Throwable -> L4
        String r101 = this.f516384a;     // Catch: Throwable -> L4
        int r102 = this.f516385b;     // Catch: Throwable -> L4
        r100.getClass();     // Catch: Throwable -> L4
        a.q(r101, r102);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(a r100, String r101) {
        this.f516386c = r100;
        this.f516384a = r101;
        this.f516385b = -3;
    }
}
