package aj5;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.middleground.unbundle.cache.db.BenefitDatabase;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements b {
    public final RoomDatabase a;
    public final c b;
    public final d c;

    public final List<a> a() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM BenefitData ORDER BY update_time DESC LIMIT 100", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.a, r0, false, null);
        int r2 = CursorUtil.getColumnIndexOrThrow(r1, "cache_key");     // Catch: Throwable -> L14
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "owner_id");     // Catch: Throwable -> L14
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "source_benefit");     // Catch: Throwable -> L14
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "update_time");     // Catch: Throwable -> L14
        ArrayList r7 = new ArrayList(r1.getCount());     // Catch: Throwable -> L14
    L4:
        if (r1.moveToNext() == false) goto L12;
        a r8 = new a();     // Catch: Throwable -> L14
        r8.a = r1.getString(r2);     // Catch: Throwable -> L14
        r8.b = r1.getString(r4);     // Catch: Throwable -> L14
        r8.c = r1.getString(r5);     // Catch: Throwable -> L14
        if (r1.isNull(r6) == false) goto L9;
        Long r9 = null;
    L10:
        r8.d = r9;     // Catch: Throwable -> L14
        r7.add(r8);     // Catch: Throwable -> L14
        goto L4
    L9:
        r9 = Long.valueOf(r1.getLong(r6));     // Catch: Throwable -> L14
        goto L10
    L12:
        r1.close();
        r0.release();
        return r7;
    L14:
        th = move-exception;
        r1.close();
        r0.release();
        throw th;
    }

    public final int b() {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.c.acquire();
        this.a.beginTransaction();
        int r1 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        this.c.release(r0);
        return r1;
    L6:
        th = move-exception;
        this.a.endTransaction();
        this.c.release(r0);
        throw th;
    }

    public e(BenefitDatabase r2) {
        this.a = r2;
        this.b = new c(r2);
        this.c = new d(r2);
    }
}
