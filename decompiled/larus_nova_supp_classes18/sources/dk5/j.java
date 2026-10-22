package dk5;

import com.bytedance.ee.bear.notification.bean.Notification;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements Runnable {
    public final /* synthetic */ Notification a;
    public final /* synthetic */ e b;

    public final void a() {
        ck5.i r0 = this.b.b;
        Notification r1 = this.a;
        r0.getClass();
        tt5.a.b("NotificationDatabaseMan", "insertNotification, notification = " + r1);     // Catch: Exception -> L9
        Notification[] r2 = {r1};     // Catch: Exception -> L9
        ck5.h r3 = (ck5.h) r0.a().c();     // Catch: Exception -> L9
        r3.a.assertNotSuspendingTransaction();     // Catch: Exception -> L9
        r3.a.beginTransaction();     // Catch: Exception -> L9
        r3.b.insertAndReturnIdsArray(r2);     // Catch: Throwable -> L6
        r3.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        r3.a.endTransaction();     // Catch: Exception -> L9
        return;
    L6:
        th = move-exception;
        r3.a.endTransaction();     // Catch: Exception -> L9
        throw th;     // Catch: Exception -> L9
    L9:
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

    public j(e r1, Notification r2) {
        this.b = r1;
        this.a = r2;
    }
}
