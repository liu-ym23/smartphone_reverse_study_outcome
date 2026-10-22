package mc5;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements e {
    public final RoomDatabase a;
    public final f b;
    public final g c;

    public final int a() {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.c.acquire();
        r0.bindLong(1, 100);
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

    public i(BearDatabase r2) {
        this.a = r2;
        this.b = new f(r2);
        this.c = new g(r2);
        new h(r2);
    }

    public final FolderSortStrategy b(String r14) {
        boolean r1 = true;
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM FolderSortStrategy WHERE obj_token= ?", 1);
        if (r14 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.a.assertNotSuspendingTransaction();
        FolderSortStrategy r3 = null;
        Cursor r15 = DBUtil.query(this.a, r0, false, null);
        int r4 = CursorUtil.getColumnIndexOrThrow(r15, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L16
        int r5 = CursorUtil.getColumnIndexOrThrow(r15, ResourceData.KEY_TYPE);     // Catch: Throwable -> L16
        int r6 = CursorUtil.getColumnIndexOrThrow(r15, "file_type");     // Catch: Throwable -> L16
        int r7 = CursorUtil.getColumnIndexOrThrow(r15, "forbidden_file_type");     // Catch: Throwable -> L16
        int r8 = CursorUtil.getColumnIndexOrThrow(r15, "strategy");     // Catch: Throwable -> L16
        int r9 = CursorUtil.getColumnIndexOrThrow(r15, "is_asc");     // Catch: Throwable -> L16
        int r10 = CursorUtil.getColumnIndexOrThrow(r15, "update_time");     // Catch: Throwable -> L16
        int r11 = CursorUtil.getColumnIndexOrThrow(r15, "user_id");     // Catch: Throwable -> L16
        if (r15.moveToFirst() == false) goto L14;
        r3 = new FolderSortStrategy();     // Catch: Throwable -> L16
        r3.a = r15.getString(r4);     // Catch: Throwable -> L16
        r3.b = r15.getInt(r5);     // Catch: Throwable -> L16
        r3.c = r15.getString(r6);     // Catch: Throwable -> L16
        r3.d = r15.getString(r7);     // Catch: Throwable -> L16
        r3.e = r15.getInt(r8);     // Catch: Throwable -> L16
        if (r15.getInt(r9) != 0) goto L13;
        r1 = false;
    L13:
        r3.f = r1;     // Catch: Throwable -> L16
        r3.g = r15.getString(r10);     // Catch: Throwable -> L16
        r3.h = r15.getString(r11);     // Catch: Throwable -> L16
    L14:
        r15.close();
        r0.release();
        return r3;
    L16:
        th = move-exception;
        r15.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r14);
        goto L6
    }
}
