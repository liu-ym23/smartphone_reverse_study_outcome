package ho;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.bytedance.android.ec.window.base.db.WindowDatabase;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public final class h implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f486191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f486192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f486193c;

    public h(WindowDatabase r100) {
        this.f486191a = r100;
        this.f486192b = new f(r100);
        this.f486193c = new g(r100);
    }

    public final List<io.c> a(String r110, String r111, String r112) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM window_exit_interceptor WHERE user_id = ? and sec_author_id = ?  and component_name = ?", 3);
        if (r110 != null) goto L5;
        r100.bindNull(1);
    L7:
        if (r111 != null) goto L9;
        r100.bindNull(2);
    L10:
        if (r112 != null) goto L12;
        r100.bindNull(3);
    L13:
        this.f486191a.assertNotSuspendingTransaction();
        Cursor r113 = DBUtil.query(this.f486191a, r100, false);
        int r114 = CursorUtil.getColumnIndexOrThrow(r113, "user_id");     // Catch: Throwable -> L21
        int r115 = CursorUtil.getColumnIndexOrThrow(r113, "sec_author_id");     // Catch: Throwable -> L21
        int r101 = CursorUtil.getColumnIndexOrThrow(r113, "component_name");     // Catch: Throwable -> L21
        int r102 = CursorUtil.getColumnIndexOrThrow(r113, "show_time");     // Catch: Throwable -> L21
        ArrayList r103 = new ArrayList(r113.getCount());     // Catch: Throwable -> L21
    L16:
        if (r113.moveToNext() == false) goto L19;
        r103.add(new io.c(r113.getString(r114), r113.getString(r115), r113.getString(r101), r113.getLong(r102)));     // Catch: Throwable -> L21
        goto L16
    L19:
        r113.close();
        r100.release();
        return r103;
    L21:
        th = move-exception;
        r113.close();
        r100.release();
        throw th;
    L12:
        r100.bindString(3, r112);
        goto L13
    L9:
        r100.bindString(2, r111);
        goto L10
    L5:
        r100.bindString(1, r110);
        goto L7
    }
}
