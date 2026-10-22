package ho;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: classes44.dex */
public final class n implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f486196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f486197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f486198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f486199d;

    public class a extends EntityInsertionAdapter<io.e> {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "INSERT OR REPLACE INTO `window_lynx_common`(`user_id`,`scene_id`,`business`,`count`,`timestamp`,`data`,`reserved_string`,`reserved_long`) VALUES (?,?,?,?,?,?,?,?)";
        }

        public a(RoomDatabase r100) {
            super(r100);
        }

        @Override // androidx.room.EntityInsertionAdapter
        public final void bind(SupportSQLiteStatement r100, io.e r101) {
            io.e r102 = r101;
            String r103 = r102.f490664a;
            if (r103 != null) goto L5;
            r100.bindNull(1);
        L6:
            String r104 = r102.f490665b;
            if (r104 != null) goto L9;
            r100.bindNull(2);
        L10:
            String r105 = r102.f490666c;
            if (r105 != null) goto L13;
            r100.bindNull(3);
        L14:
            r100.bindLong(4, r102.f490667d);
            r100.bindLong(5, r102.f490668e);
            String r106 = r102.f490669f;
            if (r106 != null) goto L17;
            r100.bindNull(6);
        L18:
            String r107 = r102.f490670g;
            if (r107 != null) goto L21;
            r100.bindNull(7);
        L22:
            r100.bindLong(8, r102.f490671h);
            return;
        L21:
            r100.bindString(7, r107);
            goto L22
        L17:
            r100.bindString(6, r106);
            goto L18
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

    public class b extends EntityDeletionOrUpdateAdapter<io.e> {
        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "DELETE FROM `window_lynx_common` WHERE `user_id` = ? AND `scene_id` = ? AND `business` = ?";
        }

        public b(RoomDatabase r100) {
            super(r100);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        public final void bind(SupportSQLiteStatement r100, io.e r101) {
            io.e r102 = r101;
            String r103 = r102.f490664a;
            if (r103 != null) goto L5;
            r100.bindNull(1);
        L6:
            String r104 = r102.f490665b;
            if (r104 != null) goto L9;
            r100.bindNull(2);
        L10:
            String r105 = r102.f490666c;
            if (r105 != null) goto L13;
            r100.bindNull(3);
            return;
        L13:
            r100.bindString(3, r105);
            return;
        L9:
            r100.bindString(2, r104);
            goto L10
        L5:
            r100.bindString(1, r103);
            goto L6
        }
    }

    public class c extends EntityDeletionOrUpdateAdapter<io.e> {
        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "UPDATE OR ABORT `window_lynx_common` SET `user_id` = ?,`scene_id` = ?,`business` = ?,`count` = ?,`timestamp` = ?,`data` = ?,`reserved_string` = ?,`reserved_long` = ? WHERE `user_id` = ? AND `scene_id` = ? AND `business` = ?";
        }

        public c(RoomDatabase r100) {
            super(r100);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        public final void bind(SupportSQLiteStatement r100, io.e r101) {
            io.e r102 = r101;
            String r103 = r102.f490664a;
            if (r103 != null) goto L5;
            r100.bindNull(1);
        L6:
            String r104 = r102.f490665b;
            if (r104 != null) goto L9;
            r100.bindNull(2);
        L10:
            String r105 = r102.f490666c;
            if (r105 != null) goto L13;
            r100.bindNull(3);
        L14:
            r100.bindLong(4, r102.f490667d);
            r100.bindLong(5, r102.f490668e);
            String r106 = r102.f490669f;
            if (r106 != null) goto L17;
            r100.bindNull(6);
        L18:
            String r107 = r102.f490670g;
            if (r107 != null) goto L21;
            r100.bindNull(7);
        L22:
            r100.bindLong(8, r102.f490671h);
            String r108 = r102.f490664a;
            if (r108 != null) goto L25;
            r100.bindNull(9);
        L26:
            String r109 = r102.f490665b;
            if (r109 != null) goto L29;
            r100.bindNull(10);
        L30:
            String r110 = r102.f490666c;
            if (r110 != null) goto L33;
            r100.bindNull(11);
            return;
        L33:
            r100.bindString(11, r110);
            return;
        L29:
            r100.bindString(10, r109);
            goto L30
        L25:
            r100.bindString(9, r108);
            goto L26
        L21:
            r100.bindString(7, r107);
            goto L22
        L17:
            r100.bindString(6, r106);
            goto L18
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

    public n(RoomDatabase r100) {
        this.f486196a = r100;
        this.f486197b = new a(r100);
        this.f486198c = new b(r100);
        this.f486199d = new c(r100);
    }
}
