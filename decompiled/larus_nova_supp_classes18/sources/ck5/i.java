package ck5;

import android.content.Context;
import com.bytedance.ee.bear.notification.db.NotificationDatabase;
import com.bytedance.ee.util.db.DBController;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i {
    public static volatile i a;

    public final synchronized NotificationDatabase a() {
        monitor-enter(this);
        NotificationDatabase r0 = (NotificationDatabase) DBController.a().r1("notification.db");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public i(Context r3) {
        DBController.a r1 = new DBController.a(r3);     // Catch: Exception -> L5
        r1.a = "notification.db";     // Catch: Exception -> L5
        r1.b = NotificationDatabase.class;     // Catch: Exception -> L5
        DBController.a().W3("notification.db", r1);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }
}
