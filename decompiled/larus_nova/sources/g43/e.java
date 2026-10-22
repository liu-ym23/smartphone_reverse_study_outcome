package g43;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.c f479981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d.b f479982b;

    public e(d.c r100, d.b r101) {
        this.f479981a = r100;
        this.f479982b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f479981a.f479980b.removeCallbacks(this.f479982b);     // Catch: Throwable -> L4
        this.f479982b.f479977a = true;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
