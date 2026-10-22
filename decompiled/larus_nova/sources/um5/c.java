package um5;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f550686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f550687b;

    public c(b r100, String r101) {
        this.f550686a = r100;
        this.f550687b = r101;
    }

    public final void a() {
        tt5.a.d(this.f550686a.f550668d, "onFailed " + this.f550687b);
        this.f550686a.b();
        a r100 = this.f550686a.f550677m;
        if (r100 == null) goto L6;
        r100.onFail(this.f550687b);
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
}
