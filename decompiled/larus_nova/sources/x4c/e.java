package x4c;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.ss.android.lark.security.compliance.infra.storage.lru.CacheDatabase;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f562488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f562489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f562490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f562491d;

    public e(CacheDatabase r100) {
        this.f562488a = r100;
        this.f562489b = new b(r100);
        this.f562490c = new c(r100);
        this.f562491d = new d(r100);
    }

    public final f a(String r110) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM lru_cache WHERE `key` = ?", 1);
        if (r110 != null) goto L5;
        r100.bindNull(1);
    L6:
        this.f562488a.assertNotSuspendingTransaction();
        f r101 = null;
        Cursor r111 = DBUtil.query(this.f562488a, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r111, "id");     // Catch: Throwable -> L12
        int r103 = CursorUtil.getColumnIndexOrThrow(r111, "key");     // Catch: Throwable -> L12
        int r104 = CursorUtil.getColumnIndexOrThrow(r111, "value");     // Catch: Throwable -> L12
        int r105 = CursorUtil.getColumnIndexOrThrow(r111, "lastAccessTime");     // Catch: Throwable -> L12
        if (r111.moveToFirst() == false) goto L10;
        r101 = new f(r111.getInt(r102), r111.getString(r103), r111.getString(r104), r111.getLong(r105));     // Catch: Throwable -> L12
    L10:
        r111.close();
        r100.release();
        return r101;
    L12:
        th = move-exception;
        r111.close();
        r100.release();
        throw th;
    L5:
        r100.bindString(1, r110);
        goto L6
    }

    public final void b(f r100) {
        this.f562488a.assertNotSuspendingTransaction();
        this.f562488a.beginTransaction();
        this.f562491d.handle(r100);     // Catch: Throwable -> L6
        this.f562488a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f562488a.endTransaction();
        return;
    L6:
        th = move-exception;
        this.f562488a.endTransaction();
        throw th;
    }
}
