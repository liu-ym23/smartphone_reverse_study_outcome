package dk5;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f469013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f469014b;

    public final void a() {
        ck5.i r100 = this.f469014b.f469004b;
        String r101 = this.f469013a;
        r100.getClass();
        tt5.a.b("NotificationDatabaseMan", "deleteNotificationByNid, nid = " + r101);     // Catch: Exception -> L5
        ((ck5.h) r100.a().c()).b(r101);     // Catch: Exception -> L5
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

    public i(e r100, String r101) {
        this.f469014b = r100;
        this.f469013a = r101;
    }
}
