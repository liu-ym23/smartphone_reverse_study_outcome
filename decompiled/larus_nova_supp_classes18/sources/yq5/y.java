package yq5;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y extends t {
    public final RoomDatabase a;
    public final u b;
    public final v c;
    public final w d;
    public final x e;

    public y(WikiDatabase r2) {
        this.a = r2;
        this.b = new u(r2);
        this.c = new v(r2);
        this.d = new w(r2);
        this.e = new x(r2);
    }

    public final void b(String r3) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.e.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.a.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.a.endTransaction();
        this.e.release(r0);
        return;
    L10:
        th = move-exception;
        this.a.endTransaction();
        this.e.release(r0);
        throw th;
    L5:
        r0.bindString(1, r3);
        goto L6
    }

    public final void c(String r3) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.d.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.a.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.a.endTransaction();
        this.d.release(r0);
        return;
    L10:
        th = move-exception;
        this.a.endTransaction();
        this.d.release(r0);
        throw th;
    L5:
        r0.bindString(1, r3);
        goto L6
    }

    public static void a(y r1, z r2) {
        if (r2.e == false) goto L5;
        r1.c(r2.b);
    L6:
        r1.a.assertNotSuspendingTransaction();
        r1.a.beginTransaction();
        r1.b.insert(r2);     // Catch: Throwable -> L10
        r1.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        r1.a.endTransaction();
        return;
    L10:
        th = move-exception;
        r1.a.endTransaction();
        throw th;
    L5:
        r1.b(r2.c);
        goto L6
    }
}
