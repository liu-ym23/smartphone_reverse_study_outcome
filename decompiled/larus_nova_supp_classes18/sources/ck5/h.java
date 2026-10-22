package ck5;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.notification.db.NotificationDatabase;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements b {
    public final RoomDatabase a;
    public final c b;
    public final a c;
    public final d d;
    public final e e;
    public final f f;

    public final int a() {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.d.acquire();
        this.a.beginTransaction();
        int r1 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        this.d.release(r0);
        return r1;
    L6:
        th = move-exception;
        this.a.endTransaction();
        this.d.release(r0);
        throw th;
    }

    public final List<String> c() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT id FROM Notification WHERE close = 1", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.a, r0, false, null);
        ArrayList r3 = new ArrayList(r2.getCount());     // Catch: Throwable -> L10
    L5:
        if (r2.moveToNext() == false) goto L8;
        r3.add(r2.getString(0));     // Catch: Throwable -> L10
        goto L5
    L8:
        r2.close();
        r0.release();
        return r3;
    L10:
        th = move-exception;
        r2.close();
        r0.release();
        throw th;
    }

    public h(NotificationDatabase r2) {
        this.c = new a();
        this.a = r2;
        this.b = new c(this, r2);
        this.d = new d(r2);
        this.e = new e(r2);
        this.f = new f(r2);
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

    public final int d(String r3) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.f.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.a.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.a.endTransaction();
        this.f.release(r0);
        return r4;
    L10:
        th = move-exception;
        this.a.endTransaction();
        this.f.release(r0);
        throw th;
    L5:
        r0.bindString(1, r3);
        goto L6
    }
}
