package mm;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.bytedance.android.ec.store.db.StoreDatabase;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f514404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f514405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f514406c;

    public d(StoreDatabase r100) {
        this.f514404a = r100;
        this.f514405b = new b(r100);
        this.f514406c = new c(r100);
    }

    public final List<nm.a> a(String r110, String r111, String r210) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM shop_marquee_close WHERE user_id = ? and sec_shop_id = ? and date = ?", 3);
        if (r110 != null) goto L5;
        r100.bindNull(1);
    L7:
        if (r111 != null) goto L9;
        r100.bindNull(2);
    L10:
        if (r210 != null) goto L12;
        r100.bindNull(3);
    L13:
        this.f514404a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f514404a, r100, false);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "id");     // Catch: Throwable -> L26
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, "user_id");     // Catch: Throwable -> L26
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, "sec_shop_id");     // Catch: Throwable -> L26
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "date");     // Catch: Throwable -> L26
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "close_times");     // Catch: Throwable -> L26
        ArrayList r107 = new ArrayList(r101.getCount());     // Catch: Throwable -> L26
    L15:
        if (r101.moveToNext() == false) goto L24;
        long r112 = r101.getLong(r102);     // Catch: Throwable -> L26
        String r113 = r101.getString(r103);     // Catch: Throwable -> L26
        String r114 = r101.getString(r104);     // Catch: Throwable -> L26
        String r115 = r101.getString(r105);     // Catch: Throwable -> L26
        if (r101.isNull(r106) == false) goto L21;
        Integer r108 = null;
    L22:
        r107.add(new nm.a(r112, r113, r114, r115, r108));     // Catch: Throwable -> L26
        goto L15
    L21:
        r108 = Integer.valueOf(r101.getInt(r106));     // Catch: Throwable -> L26
        goto L22
    L24:
        r101.close();
        r100.release();
        return r107;
    L26:
        th = move-exception;
        r101.close();
        r100.release();
        throw th;
    L12:
        r100.bindString(3, r210);
        goto L13
    L9:
        r100.bindString(2, r111);
        goto L10
    L5:
        r100.bindString(1, r110);
        goto L7
    }
}
