package g43;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.c f479983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d.b f479984b;

    public f(d.c r100, d.b r101) {
        this.f479983a = r100;
        this.f479984b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f479983a.f479980b.removeCallbacks(this.f479984b);     // Catch: Throwable -> L4
        this.f479984b.f479977a = true;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
