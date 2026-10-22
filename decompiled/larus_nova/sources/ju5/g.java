package ju5;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.bytedance.ee.util.db.KeyValueDatabase;

/* JADX INFO: loaded from: classes19.dex */
public final class g implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f500495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f500496b;

    public g(KeyValueDatabase r100) {
        this.f500495a = r100;
        this.f500496b = new e(r100);
        new f(r100);
    }

    public final j a(String r100) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT * FROM key_value_model WHERE `key` = ?", 1);
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L6:
        this.f500495a.assertNotSuspendingTransaction();
        j r102 = null;
        Cursor r103 = DBUtil.query(this.f500495a, r101, false, null);
        int r104 = CursorUtil.getColumnIndexOrThrow(r103, "key");     // Catch: Throwable -> L12
        int r105 = CursorUtil.getColumnIndexOrThrow(r103, "value");     // Catch: Throwable -> L12
        if (r103.moveToFirst() == false) goto L10;
        r102 = new j();     // Catch: Throwable -> L12
        r102.f500499a = r103.getString(r104);     // Catch: Throwable -> L12
        r102.f500500b = r103.getString(r105);     // Catch: Throwable -> L12
    L10:
        r103.close();
        r101.release();
        return r102;
    L12:
        th = move-exception;
        r103.close();
        r101.release();
        throw th;
    L5:
        r101.bindString(1, r100);
        goto L6
    }
}
