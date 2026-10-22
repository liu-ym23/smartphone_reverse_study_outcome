package dp;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.bytedance.android.ec.window.base.repository.searchhistorydb.WindowSearchHistoryDatabase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f469552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f469553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f469554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f469555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f469556e;

    public f(WindowSearchHistoryDatabase r100) {
        this.f469554c = new a();
        this.f469552a = r100;
        this.f469553b = new c(this, r100);
        this.f469555d = new d(r100);
        this.f469556e = new e(this, r100);
    }

    public final List<cp.a> a(String r110, String r210) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM store_search_history WHERE user_id = ? and store_id = ? order by time_stamp", 2);
        if (r110 != null) goto L5;
        r100.bindNull(1);
    L6:
        if (r210 != null) goto L8;
        r100.bindNull(2);
    L9:
        this.f469552a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f469552a, r100, false);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "id");     // Catch: Throwable -> L25
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, "user_id");     // Catch: Throwable -> L25
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, "store_id");     // Catch: Throwable -> L25
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "key_word");     // Catch: Throwable -> L25
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "time_stamp");     // Catch: Throwable -> L25
        ArrayList r107 = new ArrayList(r101.getCount());     // Catch: Throwable -> L25
    L11:
        if (r101.moveToNext() == false) goto L23;
        long r111 = r101.getLong(r102);     // Catch: Throwable -> L25
        String r112 = r101.getString(r103);     // Catch: Throwable -> L25
        String r113 = r101.getString(r104);     // Catch: Throwable -> L25
        String r114 = r101.getString(r105);     // Catch: Throwable -> L25
        if (r101.isNull(r106) == false) goto L16;
        Long r108 = null;
    L17:
        this.f469554c.getClass();     // Catch: Throwable -> L25
        if (r108 == null) goto L20;
        Date r115 = new Date(r108.longValue());     // Catch: Throwable -> L25
    L21:
        r107.add(new cp.a(r111, r112, r113, r114, r115));     // Catch: Throwable -> L25
        r102 = r102;
        goto L11
    L20:
        r115 = null;
        goto L21
    L16:
        r108 = Long.valueOf(r101.getLong(r106));     // Catch: Throwable -> L25
        goto L17
    L23:
        r101.close();
        r100.release();
        return r107;
    L25:
        th = move-exception;
        r101.close();
        r100.release();
        throw th;
    L8:
        r100.bindString(2, r210);
        goto L9
    L5:
        r100.bindString(1, r110);
        goto L6
    }
}
