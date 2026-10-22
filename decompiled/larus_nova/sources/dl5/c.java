package dl5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.operation.database.OperationDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends EntityInsertionAdapter<a> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR IGNORE INTO `OperationData` (`_id`,`module_type`,`module_token`,`operator_id`,`operation_name`,`operation_scene`,`operation_time`,`extra`,`uuid`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
    }

    public c(OperationDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, a r101) {
        a r102 = r101;
        r100.bindLong(1, r102.f469115a);
        r100.bindLong(2, r102.f469116b);
        String r103 = r102.f469117c;
        if (r103 != null) goto L5;
        r100.bindNull(3);
    L6:
        String r104 = r102.f469118d;
        if (r104 != null) goto L9;
        r100.bindNull(4);
    L10:
        String r105 = r102.f469119e;
        if (r105 != null) goto L13;
        r100.bindNull(5);
    L14:
        r100.bindLong(6, r102.f469120f);
        Long r106 = r102.f469121g;
        if (r106 != null) goto L17;
        r100.bindNull(7);
    L18:
        String r107 = r102.f469122h;
        if (r107 != null) goto L21;
        r100.bindNull(8);
    L22:
        String r108 = r102.f469123i;
        if (r108 != null) goto L25;
        r100.bindNull(9);
        return;
    L25:
        r100.bindString(9, r108);
        return;
    L21:
        r100.bindString(8, r107);
        goto L22
    L17:
        r100.bindLong(7, r106.longValue());
        goto L18
    L13:
        r100.bindString(5, r105);
        goto L14
    L9:
        r100.bindString(4, r104);
        goto L10
    L5:
        r100.bindString(3, r103);
        goto L6
    }
}
