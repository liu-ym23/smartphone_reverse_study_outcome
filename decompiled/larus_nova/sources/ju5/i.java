package ju5;

import com.bytedance.ee.util.db.DBController;
import com.bytedance.ee.util.db.KeyValueDatabase;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes19.dex */
public final class i implements Function<j, Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.util.db.b f500498a;

    public i(com.bytedance.ee.util.db.b r100) {
        this.f500498a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Long apply(j r100) throws Exception {
        j r101 = r100;
        com.bytedance.ee.util.db.b r102 = this.f500498a;
        r102.getClass();
        monitor-enter(r102);     // Catch: Exception -> L12
        KeyValueDatabase r103 = (KeyValueDatabase) DBController.a().r1("docs_keyvaule.db");     // Catch: Throwable -> L14
        monitor-exit(r102);     // Catch: Exception -> L12
        g r104 = (g) r103.c();     // Catch: Exception -> L12
        r104.f500495a.assertNotSuspendingTransaction();     // Catch: Exception -> L12
        r104.f500495a.beginTransaction();     // Catch: Exception -> L12
        long r105 = r104.f500496b.insertAndReturnId(r101);     // Catch: Throwable -> L9
        r104.f500495a.setTransactionSuccessful();     // Catch: Throwable -> L9
        r104.f500495a.endTransaction();     // Catch: Exception -> L12
    L19:
        return Long.valueOf(r105);
    L9:
        th = move-exception;
        r104.f500495a.endTransaction();     // Catch: Exception -> L12
        throw th;     // Catch: Exception -> L12
    L14:
        th = move-exception;
        throw th;     // Catch: Exception -> L12
    L12:
        e = move-exception;
        iu5.d.c(e);
        r105 = -1;
        goto L19
    }
}
