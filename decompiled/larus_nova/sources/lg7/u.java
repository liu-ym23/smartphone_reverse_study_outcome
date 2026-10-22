package lg7;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.sync.v2.presistence.AppDatabase;

/* JADX INFO: loaded from: classes22.dex */
public final class u extends EntityInsertionAdapter<mg7.f> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `t_report_synclog`(`id`,`sync_id`,`business`,`did`,`uid`,`bucket`,`cursor`,`data`,`md5`,`msg_id`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
    }

    public u(AppDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, mg7.f r101) {
        mg7.f r102 = r101;
        r100.bindLong(1, r102.f513796a);
        String r103 = r102.f513797b;
        if (r103 != null) goto L5;
        r100.bindNull(2);
    L6:
        r100.bindLong(3, r102.f513798c);
        String r104 = r102.f513799d;
        if (r104 != null) goto L9;
        r100.bindNull(4);
    L10:
        String r105 = r102.f513800e;
        if (r105 != null) goto L13;
        r100.bindNull(5);
    L14:
        r100.bindLong(6, kg7.a.a(r102.f513801f));
        r100.bindLong(7, r102.f513802g);
        byte[] r106 = r102.f513803h;
        if (r106 != null) goto L17;
        r100.bindNull(8);
    L18:
        String r107 = r102.f513804i;
        if (r107 != null) goto L21;
        r100.bindNull(9);
    L22:
        String r108 = r102.f513805j;
        if (r108 != null) goto L25;
        r100.bindNull(10);
        return;
    L25:
        r100.bindString(10, r108);
        return;
    L21:
        r100.bindString(9, r107);
        goto L22
    L17:
        r100.bindBlob(8, r106);
        goto L18
    L13:
        r100.bindString(5, r105);
        goto L14
    L9:
        r100.bindString(4, r104);
        goto L10
    L5:
        r100.bindString(2, r103);
        goto L6
    }
}
