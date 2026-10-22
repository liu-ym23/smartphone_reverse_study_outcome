package mc5;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.list.cache.BearDatabase;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;

/* JADX INFO: loaded from: classes18.dex */
public final class i implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f513077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f513078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f513079c;

    public final int a() {
        this.f513077a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r100 = this.f513079c.acquire();
        r100.bindLong(1, 100);
        this.f513077a.beginTransaction();
        int r101 = r100.executeUpdateDelete();     // Catch: Throwable -> L6
        this.f513077a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f513077a.endTransaction();
        this.f513079c.release(r100);
        return r101;
    L6:
        th = move-exception;
        this.f513077a.endTransaction();
        this.f513079c.release(r100);
        throw th;
    }

    public i(BearDatabase r100) {
        this.f513077a = r100;
        this.f513078b = new f(r100);
        this.f513079c = new g(r100);
        new h(r100);
    }

    public final FolderSortStrategy b(String r110) {
        boolean r100 = true;
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT * FROM FolderSortStrategy WHERE obj_token= ?", 1);
        if (r110 != null) goto L5;
        r101.bindNull(1);
    L6:
        this.f513077a.assertNotSuspendingTransaction();
        FolderSortStrategy r102 = null;
        Cursor r111 = DBUtil.query(this.f513077a, r101, false, null);
        int r103 = CursorUtil.getColumnIndexOrThrow(r111, "obj_token");     // Catch: Throwable -> L16
        int r104 = CursorUtil.getColumnIndexOrThrow(r111, "type");     // Catch: Throwable -> L16
        int r105 = CursorUtil.getColumnIndexOrThrow(r111, "file_type");     // Catch: Throwable -> L16
        int r106 = CursorUtil.getColumnIndexOrThrow(r111, "forbidden_file_type");     // Catch: Throwable -> L16
        int r107 = CursorUtil.getColumnIndexOrThrow(r111, BdpAppEventConstant.PARAMS_STRATEGY_NAME);     // Catch: Throwable -> L16
        int r108 = CursorUtil.getColumnIndexOrThrow(r111, "is_asc");     // Catch: Throwable -> L16
        int r112 = CursorUtil.getColumnIndexOrThrow(r111, "update_time");     // Catch: Throwable -> L16
        int r113 = CursorUtil.getColumnIndexOrThrow(r111, "user_id");     // Catch: Throwable -> L16
        if (r111.moveToFirst() == false) goto L14;
        r102 = new FolderSortStrategy();     // Catch: Throwable -> L16
        r102.f227680a = r111.getString(r103);     // Catch: Throwable -> L16
        r102.f227681b = r111.getInt(r104);     // Catch: Throwable -> L16
        r102.f227682c = r111.getString(r105);     // Catch: Throwable -> L16
        r102.f227683d = r111.getString(r106);     // Catch: Throwable -> L16
        r102.f227684e = r111.getInt(r107);     // Catch: Throwable -> L16
        if (r111.getInt(r108) != 0) goto L13;
        r100 = false;
    L13:
        r102.f227685f = r100;     // Catch: Throwable -> L16
        r102.f227686g = r111.getString(r112);     // Catch: Throwable -> L16
        r102.f227687h = r111.getString(r113);     // Catch: Throwable -> L16
    L14:
        r111.close();
        r101.release();
        return r102;
    L16:
        th = move-exception;
        r111.close();
        r101.release();
        throw th;
    L5:
        r101.bindString(1, r110);
        goto L6
    }
}
