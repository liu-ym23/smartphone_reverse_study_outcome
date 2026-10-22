package tj3;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.bytedance.android.shopping.store.repository.searchhistorydb.StoreSearchHistoryDatabase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sj3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f implements b {
    public final RoomDatabase a;
    public final c b;
    public final a c;
    public final d d;
    public final e e;

    public f(StoreSearchHistoryDatabase r2) {
        this.c = new a();
        this.a = r2;
        this.b = new c(this, r2);
        this.d = new d(r2);
        this.e = new e(this, r2);
    }

    public final List<h> a(String r19, String r20) {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM store_search_history WHERE user_id = ? and store_id = ? order by time_stamp", 2);
        if (r19 != null) goto L5;
        r3.bindNull(1);
    L6:
        if (r20 != null) goto L8;
        r3.bindNull(2);
    L9:
        this.a.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.a, r3, false);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "id");     // Catch: Throwable -> L25
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "user_id");     // Catch: Throwable -> L25
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "store_id");     // Catch: Throwable -> L25
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "key_word");     // Catch: Throwable -> L25
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "time_stamp");     // Catch: Throwable -> L25
        ArrayList r8 = new ArrayList(r2.getCount());     // Catch: Throwable -> L25
    L11:
        if (r2.moveToNext() == false) goto L23;
        long r11 = r2.getLong(r0);     // Catch: Throwable -> L25
        String r13 = r2.getString(r4);     // Catch: Throwable -> L25
        String r14 = r2.getString(r5);     // Catch: Throwable -> L25
        String r15 = r2.getString(r6);     // Catch: Throwable -> L25
        if (r2.isNull(r7) == false) goto L16;
        Long r9 = null;
    L17:
        this.c.getClass();     // Catch: Throwable -> L25
        if (r9 == null) goto L20;
        Date r16 = new Date(r9.longValue());     // Catch: Throwable -> L25
    L21:
        r8.add(new h(r11, r13, r14, r15, r16));     // Catch: Throwable -> L25
        r0 = r0;
        goto L11
    L20:
        r16 = null;
        goto L21
    L16:
        r9 = Long.valueOf(r2.getLong(r7));     // Catch: Throwable -> L25
        goto L17
    L23:
        r2.close();
        r3.release();
        return r8;
    L25:
        th = move-exception;
        r2.close();
        r3.release();
        throw th;
    L8:
        r3.bindString(2, r20);
        goto L9
    L5:
        r3.bindString(1, r19);
        goto L6
    }
}
