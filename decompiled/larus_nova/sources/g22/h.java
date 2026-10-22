package g22;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.android.livesdk.i18n.db.I18nDatabase;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class h implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f479685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f479686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f479687c;

    @Override // g22.e
    public final void empty() {
        this.f479685a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r100 = this.f479687c.acquire();
        this.f479685a.beginTransaction();
        r100.executeUpdateDelete();     // Catch: Throwable -> L6
        this.f479685a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f479685a.endTransaction();
        this.f479687c.release(r100);
        return;
    L6:
        th = move-exception;
        this.f479685a.endTransaction();
        this.f479687c.release(r100);
        throw th;
    }

    @Override // g22.e
    public final List<d> getAll() {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM translation", 0);
        this.f479685a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f479685a, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "key");     // Catch: Throwable -> L18
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, "value");     // Catch: Throwable -> L18
        ArrayList r104 = new ArrayList(r101.getCount());     // Catch: Throwable -> L18
    L4:
        if (r101.moveToNext() == false) goto L16;
        d r105 = new d();     // Catch: Throwable -> L18
        if (r101.isNull(r102) == false) goto L9;
        r105.f479683a = null;     // Catch: Throwable -> L18
    L11:
        if (r101.isNull(r103) == false) goto L13;
        r105.f479684b = null;     // Catch: Throwable -> L18
    L14:
        r104.add(r105);     // Catch: Throwable -> L18
        goto L4
    L13:
        r105.f479684b = r101.getString(r103);     // Catch: Throwable -> L18
        goto L14
    L9:
        r105.f479683a = r101.getString(r102);     // Catch: Throwable -> L18
        goto L11
    L16:
        r101.close();
        r100.release();
        return r104;
    L18:
        th = move-exception;
        r101.close();
        r100.release();
        throw th;
    }

    public h(I18nDatabase r100) {
        this.f479685a = r100;
        this.f479686b = new f(r100);
        this.f479687c = new g(r100);
    }

    @Override // g22.e
    public void insert(List<d> r100) {
        this.f479685a.assertNotSuspendingTransaction();
        this.f479685a.beginTransaction();
        this.f479686b.insert(r100);     // Catch: Throwable -> L6
        this.f479685a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f479685a.endTransaction();
        return;
    L6:
        th = move-exception;
        this.f479685a.endTransaction();
        throw th;
    }
}
