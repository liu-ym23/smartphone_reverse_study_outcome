package dk5;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f469011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f469012b;

    public final void a() {
        ck5.i r100 = this.f469012b.f469004b;
        r100.getClass();
        tt5.a.b("NotificationDatabaseMan", "deleteNotificationAll");     // Catch: Exception -> L5
        ((ck5.h) r100.a().c()).a();     // Catch: Exception -> L5
    L7:
        ck5.i r101 = this.f469012b.f469004b;
        List r102 = this.f469011a;
        r101.getClass();
        tt5.a.b("NotificationDatabaseMan", "insertNotificationList, list = " + r102);     // Catch: Exception -> L14
        ck5.h r103 = (ck5.h) r101.a().c();     // Catch: Exception -> L14
        r103.f24037a.assertNotSuspendingTransaction();     // Catch: Exception -> L14
        r103.f24037a.beginTransaction();     // Catch: Exception -> L14
        r103.f24038b.insertAndReturnIdsArray(r102);     // Catch: Throwable -> L11
        r103.f24037a.setTransactionSuccessful();     // Catch: Throwable -> L11
        r103.f24037a.endTransaction();     // Catch: Exception -> L14
        return;
    L11:
        th = move-exception;
        r103.f24037a.endTransaction();     // Catch: Exception -> L14
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

    public h(e r100, List r101) {
        this.f469012b = r100;
        this.f469011a = r101;
    }
}
