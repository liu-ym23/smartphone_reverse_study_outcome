package dk5;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements Runnable {
    public final /* synthetic */ List a;
    public final /* synthetic */ e b;

    public final void a() {
        ck5.i r1 = this.b.b;
        r1.getClass();
        tt5.a.b("NotificationDatabaseMan", "deleteNotificationAll");     // Catch: Exception -> L5
        ((ck5.h) r1.a().c()).a();     // Catch: Exception -> L5
    L7:
        ck5.i r2 = this.b.b;
        List r3 = this.a;
        r2.getClass();
        tt5.a.b("NotificationDatabaseMan", "insertNotificationList, list = " + r3);     // Catch: Exception -> L14
        ck5.h r0 = (ck5.h) r2.a().c();     // Catch: Exception -> L14
        r0.a.assertNotSuspendingTransaction();     // Catch: Exception -> L14
        r0.a.beginTransaction();     // Catch: Exception -> L14
        r0.b.insertAndReturnIdsArray(r3);     // Catch: Throwable -> L11
        r0.a.setTransactionSuccessful();     // Catch: Throwable -> L11
        r0.a.endTransaction();     // Catch: Exception -> L14
        return;
    L11:
        th = move-exception;
        r0.a.endTransaction();     // Catch: Exception -> L14
        throw th;     // Catch: Exception -> L14
    L14:
        e = move-exception;
        iu5.d.c(e);
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
        goto L7
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

    public h(e r1, List r2) {
        this.b = r1;
        this.a = r2;
    }
}
