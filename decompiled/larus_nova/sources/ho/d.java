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
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f486189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f486190b;

    public d(WindowDatabase r100) {
        this.f486189a = r100;
        this.f486190b = new b(r100);
        new c(r100);
    }

    public final List<io.b> a(String r110) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM window_dynamic_layout WHERE layout_name = ?", 1);
        if (r110 != null) goto L5;
        r100.bindNull(1);
    L6:
        this.f486189a.assertNotSuspendingTransaction();
        Cursor r111 = DBUtil.query(this.f486189a, r100, false);
        int r101 = CursorUtil.getColumnIndexOrThrow(r111, "layout_name");     // Catch: Throwable -> L14
        int r102 = CursorUtil.getColumnIndexOrThrow(r111, "version");     // Catch: Throwable -> L14
        int r103 = CursorUtil.getColumnIndexOrThrow(r111, "layout");     // Catch: Throwable -> L14
        ArrayList r104 = new ArrayList(r111.getCount());     // Catch: Throwable -> L14
    L9:
        if (r111.moveToNext() == false) goto L12;
        r104.add(new io.b(r111.getString(r101), r111.getString(r102), r111.getString(r103)));     // Catch: Throwable -> L14
        goto L9
    L12:
        r111.close();
        r100.release();
        return r104;
    L14:
        th = move-exception;
        r111.close();
        r100.release();
        throw th;
    L5:
        r100.bindString(1, r110);
        goto L6
    }
}
