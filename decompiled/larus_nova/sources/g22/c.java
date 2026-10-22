package g22;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f479681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f479682b;

    public class a extends EntityInsertionAdapter<g22.a> {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "INSERT OR REPLACE INTO `information` (`key`,`value`) VALUES (?,?)";
        }

        public a(RoomDatabase r100) {
            super(r100);
        }

        @Override // androidx.room.EntityInsertionAdapter
        public final void bind(SupportSQLiteStatement r100, g22.a r101) {
            g22.a r102 = r101;
            String r103 = r102.f479679a;
            if (r103 != null) goto L5;
            r100.bindNull(1);
        L6:
            String r104 = r102.f479680b;
            if (r104 != null) goto L9;
            r100.bindNull(2);
            return;
        L9:
            r100.bindString(2, r104);
            return;
        L5:
            r100.bindString(1, r103);
            goto L6
        }
    }

    public c(RoomDatabase r100) {
        this.f479681a = r100;
        this.f479682b = new a(r100);
    }

    @Override // g22.b
    public final g22.a get(String r100) {
        RoomSQLiteQuery r101 = RoomSQLiteQuery.acquire("SELECT * FROM information WHERE `key` = ?", 1);
        r101.bindString(1, r100);
        this.f479681a.assertNotSuspendingTransaction();
        g22.a r102 = null;
        Cursor r103 = DBUtil.query(this.f479681a, r101, false, null);
        int r104 = CursorUtil.getColumnIndexOrThrow(r103, "key");     // Catch: Throwable -> L16
        int r105 = CursorUtil.getColumnIndexOrThrow(r103, "value");     // Catch: Throwable -> L16
        if (r103.moveToFirst() == false) goto L14;
        g22.a r106 = new g22.a();     // Catch: Throwable -> L16
        if (r103.isNull(r104) == false) goto L8;
        r106.f479679a = null;     // Catch: Throwable -> L16
    L10:
        if (r103.isNull(r105) == false) goto L12;
        r106.f479680b = null;     // Catch: Throwable -> L16
    L13:
        r102 = r106;
        goto L14
    L12:
        r106.f479680b = r103.getString(r105);     // Catch: Throwable -> L16
        goto L13
    L8:
        r106.f479679a = r103.getString(r104);     // Catch: Throwable -> L16
    L14:
        r103.close();
        r101.release();
        return r102;
    L16:
        th = move-exception;
        r103.close();
        r101.release();
        throw th;
    }

    @Override // g22.b
    public void insert(g22.a r100) {
        this.f479681a.assertNotSuspendingTransaction();
        this.f479681a.beginTransaction();
        this.f479682b.insert(r100);     // Catch: Throwable -> L6
        this.f479681a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f479681a.endTransaction();
        return;
    L6:
        th = move-exception;
        this.f479681a.endTransaction();
        throw th;
    }
}
