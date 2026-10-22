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
public final class h implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f514407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f514408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f514409c;

    public h(StoreDatabase r100) {
        this.f514407a = r100;
        this.f514408b = new f(r100);
        this.f514409c = new g(r100);
    }

    public final List<nm.b> a(String r210, String r211, String r212) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM store_float_layout WHERE component_name = ? and user_id = ? and time = ?", 3);
        if (r210 != null) goto L5;
        r100.bindNull(1);
    L7:
        if (r211 != null) goto L9;
        r100.bindNull(2);
    L10:
        if (r212 != null) goto L12;
        r100.bindNull(3);
    L13:
        this.f514407a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f514407a, r100, false);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "id");     // Catch: Throwable -> L21
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, "component_name");     // Catch: Throwable -> L21
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, "user_id");     // Catch: Throwable -> L21
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "scope_key");     // Catch: Throwable -> L21
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "action");     // Catch: Throwable -> L21
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "time");     // Catch: Throwable -> L21
        int r108 = CursorUtil.getColumnIndexOrThrow(r101, "count");     // Catch: Throwable -> L21
        ArrayList r110 = new ArrayList(r101.getCount());     // Catch: Throwable -> L21
    L16:
        if (r101.moveToNext() == false) goto L19;
        r110.add(new nm.b(r101.getLong(r102), r101.getString(r103), r101.getString(r104), r101.getString(r105), r101.getInt(r106), r101.getString(r107), r101.getInt(r108)));     // Catch: Throwable -> L21
        goto L16
    L19:
        r101.close();
        r100.release();
        return r110;
    L21:
        th = move-exception;
        r101.close();
        r100.release();
        throw th;
    L12:
        r100.bindString(3, r212);
        goto L13
    L9:
        r100.bindString(2, r211);
        goto L10
    L5:
        r100.bindString(1, r210);
        goto L7
    }
}
