package dl5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.operation.database.OperationDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends EntityInsertionAdapter<a> {
    public final String createQuery() {
        return "INSERT OR IGNORE INTO `OperationData` (`_id`,`module_type`,`module_token`,`operator_id`,`operation_name`,`operation_scene`,`operation_time`,`extra`,`uuid`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
    }

    public c(OperationDatabase r1) {
        super(r1);
    }

    public final void bind(SupportSQLiteStatement r5, Object r6) {
        a r7 = (a) r6;
        r5.bindLong(1, r7.a);
        r5.bindLong(2, r7.b);
        String r0 = r7.c;
        if (r0 != null) goto L5;
        r5.bindNull(3);
    L6:
        String r1 = r7.d;
        if (r1 != null) goto L9;
        r5.bindNull(4);
    L10:
        String r2 = r7.e;
        if (r2 != null) goto L13;
        r5.bindNull(5);
    L14:
        r5.bindLong(6, r7.f);
        Long r3 = r7.g;
        if (r3 != null) goto L17;
        r5.bindNull(7);
    L18:
        String r4 = r7.h;
        if (r4 != null) goto L21;
        r5.bindNull(8);
    L22:
        String r8 = r7.i;
        if (r8 != null) goto L25;
        r5.bindNull(9);
        return;
    L25:
        r5.bindString(9, r8);
        return;
    L21:
        r5.bindString(8, r4);
        goto L22
    L17:
        r5.bindLong(7, r3.longValue());
        goto L18
    L13:
        r5.bindString(5, r2);
        goto L14
    L9:
        r5.bindString(4, r1);
        goto L10
    L5:
        r5.bindString(3, r0);
        goto L6
    }
}
