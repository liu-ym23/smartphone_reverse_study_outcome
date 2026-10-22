package dk5;

import com.bytedance.ee.bear.notification.bean.Notification;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Notification f469015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f469016b;

    public final void a() {
        ck5.i r100 = this.f469016b.f469004b;
        Notification r101 = this.f469015a;
        r100.getClass();
        tt5.a.b("NotificationDatabaseMan", "insertNotification, notification = " + r101);     // Catch: Exception -> L9
        Notification[] r102 = {r101};     // Catch: Exception -> L9
        ck5.h r103 = (ck5.h) r100.a().c();     // Catch: Exception -> L9
        r103.f24037a.assertNotSuspendingTransaction();     // Catch: Exception -> L9
        r103.f24037a.beginTransaction();     // Catch: Exception -> L9
        r103.f24038b.insertAndReturnIdsArray(r102);     // Catch: Throwable -> L6
        r103.f24037a.setTransactionSuccessful();     // Catch: Throwable -> L6
        r103.f24037a.endTransaction();     // Catch: Exception -> L9
        return;
    L6:
        th = move-exception;
        r103.f24037a.endTransaction();     // Catch: Exception -> L9
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

    public j(e r100, Notification r101) {
        this.f469016b = r100;
        this.f469015a = r101;
    }
}
