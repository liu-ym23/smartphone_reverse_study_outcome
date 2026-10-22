package dk5;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ e b;

    public final void a() {
        ck5.i r0 = this.b.b;
        String r1 = this.a;
        r0.getClass();
        tt5.a.b("NotificationDatabaseMan", "updateCloseState, nid = " + r1);     // Catch: Exception -> L5
        ((ck5.h) r0.a().c()).d(r1);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
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

    public k(e r1, String r2) {
        this.b = r1;
        this.a = r2;
    }
}
