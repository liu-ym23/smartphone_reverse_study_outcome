package ea9;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes29.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f471725a;

    public final void a() {
    L24:
    L15:
        th = move-exception;
        this.f471725a.S.set(false);
        if (this.f471725a.f471695o == true) goto L19;
    L23:
        throw th;
    L19:
        if (this.f471725a.R.get() == false) goto L23;
        if (this.f471725a.S.compareAndSet(false, true) == false) goto L23;
        this.f471725a.f471705y.post(this);
        goto L23
    L4:
        if (this.f471725a.f471695o == false) goto L7;
        this.f471725a.R.set(false);     // Catch: Throwable -> L15
        e r100 = this.f471725a;     // Catch: Throwable -> L15
        e.a(r100, r100.Q);     // Catch: Throwable -> L15
        if (this.f471725a.R.get() == true) goto L24;
    L7:
        this.f471725a.S.set(false);
        if (this.f471725a.f471695o == true) goto L10;
        return;
    L10:
        if (this.f471725a.R.get() == true) goto L12;
        return;
    L12:
        if (this.f471725a.S.compareAndSet(false, true) == false) goto L31;
        this.f471725a.f471705y.post(this);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public h(e r100) {
        this.f471725a = r100;
    }
}
