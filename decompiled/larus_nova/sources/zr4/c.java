package zr4;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements zr4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f573423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f573424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f573425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f573426d;

    public class a extends EntityInsertionAdapter<zr4.a> {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "INSERT OR REPLACE INTO `BitableBlockData` (`base_token`,`block_id`,`block_type`,`name`,`obj_token`,`timestamp`) VALUES (?,?,?,?,?,?)";
        }

        public a(RoomDatabase r100) {
            super(r100);
        }

        @Override // androidx.room.EntityInsertionAdapter
        public final void bind(SupportSQLiteStatement r100, zr4.a r101) {
            zr4.a r102 = r101;
            String r103 = r102.f573413a;
            if (r103 != null) goto L5;
            r100.bindNull(1);
        L6:
            String r104 = r102.f573414b;
            if (r104 != null) goto L9;
            r100.bindNull(2);
        L10:
            r100.bindLong(3, r102.f573415c);
            String r105 = r102.f573416d;
            if (r105 != null) goto L13;
            r100.bindNull(4);
        L14:
            r102.a();
            if (r102.f573417e != null) goto L17;
            r100.bindNull(5);
        L18:
            Long r106 = r102.f573418f;
            if (r106 != null) goto L21;
            r100.bindNull(6);
            return;
        L21:
            r100.bindLong(6, r106.longValue());
            return;
        L17:
            r102.a();
            r100.bindString(5, r102.f573417e);
            goto L18
        L13:
            r100.bindString(4, r105);
            goto L14
        L9:
            r100.bindString(2, r104);
            goto L10
        L5:
            r100.bindString(1, r103);
            goto L6
        }
    }

    public class b extends EntityInsertionAdapter<zr4.d> {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "INSERT OR REPLACE INTO `BitableFirstBlockData` (`base_token`,`block_id`,`view_id`,`timestamp`) VALUES (?,?,?,?)";
        }

        public b(RoomDatabase r100) {
            super(r100);
        }

        @Override // androidx.room.EntityInsertionAdapter
        public final void bind(SupportSQLiteStatement r100, zr4.d r101) {
            zr4.d r102 = r101;
            String r103 = r102.f573427a;
            if (r103 != null) goto L5;
            r100.bindNull(1);
        L6:
            String r104 = r102.f573428b;
            if (r104 != null) goto L9;
            r100.bindNull(2);
        L10:
            String r105 = r102.f573429c;
            if (r105 != null) goto L13;
            r100.bindNull(3);
        L14:
            Long r106 = r102.f573430d;
            if (r106 != null) goto L17;
            r100.bindNull(4);
            return;
        L17:
            r100.bindLong(4, r106.longValue());
            return;
        L13:
            r100.bindString(3, r105);
            goto L14
        L9:
            r100.bindString(2, r104);
            goto L10
        L5:
            r100.bindString(1, r103);
            goto L6
        }
    }

    /* JADX INFO: renamed from: zr4.c$c, reason: collision with other inner class name */
    public class C8488c extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "UPDATE BitableBlockData SET timestamp = ?  WHERE base_token=?";
        }

        public C8488c(RoomDatabase r100) {
            super(r100);
        }
    }

    public class d extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "UPDATE BitableFirstBlockData SET timestamp = ?  WHERE base_token=?";
        }

        public d(RoomDatabase r100) {
            super(r100);
        }
    }

    public class e extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "DELETE FROM BitableBlockData WHERE base_token= ?";
        }

        public e(RoomDatabase r100) {
            super(r100);
        }
    }

    public class f extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "DELETE FROM BitableFirstBlockData WHERE timestamp < ?";
        }

        public f(RoomDatabase r100) {
            super(r100);
        }
    }

    public class g extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "DELETE FROM BitableBlockData WHERE timestamp < ?";
        }

        public g(RoomDatabase r100) {
            super(r100);
        }
    }

    public c(RoomDatabase r100) {
        this.f573423a = r100;
        new a(r100);
        new b(r100);
        new C8488c(r100);
        new d(r100);
        this.f573424b = new e(r100);
        this.f573425c = new f(r100);
        this.f573426d = new g(r100);
    }

    public final int a(String r100) {
        this.f573423a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r101 = this.f573424b.acquire();
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L6:
        this.f573423a.beginTransaction();
        int r102 = r101.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f573423a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.f573423a.endTransaction();
        this.f573424b.release(r101);
        return r102;
    L10:
        th = move-exception;
        this.f573423a.endTransaction();
        this.f573424b.release(r101);
        throw th;
    L5:
        r101.bindString(1, r100);
        goto L6
    }

    public final int b(Long r100) {
        this.f573423a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r101 = this.f573426d.acquire();
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L6:
        this.f573423a.beginTransaction();
        int r102 = r101.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f573423a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.f573423a.endTransaction();
        this.f573426d.release(r101);
        return r102;
    L10:
        th = move-exception;
        this.f573423a.endTransaction();
        this.f573426d.release(r101);
        throw th;
    L5:
        r101.bindLong(1, r100.longValue());
        goto L6
    }

    public final int c(String r100) {
        this.f573423a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r101 = this.f573424b.acquire();
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L6:
        this.f573423a.beginTransaction();
        int r102 = r101.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f573423a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.f573423a.endTransaction();
        this.f573424b.release(r101);
        return r102;
    L10:
        th = move-exception;
        this.f573423a.endTransaction();
        this.f573424b.release(r101);
        throw th;
    L5:
        r101.bindString(1, r100);
        goto L6
    }

    public final int d(Long r100) {
        this.f573423a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r101 = this.f573425c.acquire();
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L6:
        this.f573423a.beginTransaction();
        int r102 = r101.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f573423a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.f573423a.endTransaction();
        this.f573425c.release(r101);
        return r102;
    L10:
        th = move-exception;
        this.f573423a.endTransaction();
        this.f573425c.release(r101);
        throw th;
    L5:
        r101.bindLong(1, r100.longValue());
        goto L6
    }
}
