package ho;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.android.ec.window.base.db.WindowDatabase;

/* JADX INFO: loaded from: classes44.dex */
public final class p extends EntityInsertionAdapter<io.a> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR ABORT INTO `store_float_layout`(`id`,`component_name`,`user_id`,`scope_key`,`action`,`time`,`count`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
    }

    public p(WindowDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, io.a r101) {
        io.a r102 = r101;
        r100.bindLong(1, r102.f490642a);
        String r103 = r102.f490643b;
        if (r103 != null) goto L5;
        r100.bindNull(2);
    L6:
        String r104 = r102.f490644c;
        if (r104 != null) goto L9;
        r100.bindNull(3);
    L10:
        String r105 = r102.f490645d;
        if (r105 != null) goto L13;
        r100.bindNull(4);
    L14:
        r100.bindLong(5, r102.f490646e);
        String r106 = r102.f490647f;
        if (r106 != null) goto L17;
        r100.bindNull(6);
    L18:
        r100.bindLong(7, r102.f490648g);
        return;
    L17:
        r100.bindString(6, r106);
        goto L18
    L13:
        r100.bindString(4, r105);
        goto L14
    L9:
        r100.bindString(3, r104);
        goto L10
    L5:
        r100.bindString(2, r103);
        goto L6
    }
}
