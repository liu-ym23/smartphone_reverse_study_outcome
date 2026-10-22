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
public final class l implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f486194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f486195b;

    public l(WindowDatabase r100) {
        this.f486194a = r100;
        this.f486195b = new j(r100);
        new k(r100);
    }

    public final List<io.d> a(String r100, String r110) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT * FROM window_layout_type WHERE user_id = ? and sec_author_id = ?", 2);
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L6:
        if (r110 != null) goto L8;
        r101.bindNull(2);
    L9:
        this.f486194a.assertNotSuspendingTransaction();
        Cursor r102 = DBUtil.query(this.f486194a, r101, false);
        int r111 = CursorUtil.getColumnIndexOrThrow(r102, "user_id");     // Catch: Throwable -> L21
        int r103 = CursorUtil.getColumnIndexOrThrow(r102, "sec_author_id");     // Catch: Throwable -> L21
        int r104 = CursorUtil.getColumnIndexOrThrow(r102, "layout");     // Catch: Throwable -> L21
        ArrayList r105 = new ArrayList(r102.getCount());     // Catch: Throwable -> L21
    L11:
        if (r102.moveToNext() == false) goto L19;
        String r106 = r102.getString(r111);     // Catch: Throwable -> L21
        String r107 = r102.getString(r103);     // Catch: Throwable -> L21
        if (r102.isNull(r104) == false) goto L16;
        Integer r108 = null;
    L17:
        r105.add(new io.d(r106, r107, r108));     // Catch: Throwable -> L21
        goto L11
    L16:
        r108 = Integer.valueOf(r102.getInt(r104));     // Catch: Throwable -> L21
        goto L17
    L19:
        r102.close();
        r101.release();
        return r105;
    L21:
        th = move-exception;
        r102.close();
        r101.release();
        throw th;
    L8:
        r101.bindString(2, r110);
        goto L9
    L5:
        r101.bindString(1, r100);
        goto L6
    }
}
