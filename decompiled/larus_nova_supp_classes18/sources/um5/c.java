package um5;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements Runnable {
    public final /* synthetic */ b a;
    public final /* synthetic */ String b;

    public c(b r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        tt5.a.d(this.a.d, "onFailed " + this.b);
        this.a.b();
        a r0 = this.a.m;
        if (r0 == null) goto L6;
        r0.onFail(this.b);
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
