package lg7;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.sync.model.DataType;
import com.bytedance.sync.v2.presistence.AppDatabase;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends EntityInsertionAdapter<mg7.b> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `t_snapshot`(`sync_id`,`business`,`uid`,`did`,`cursor`,`data`,`notified`,`bucket`,`data_type`,`publish_ts`,`receive_ts`,`consume_type`,`patch_cnt`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public n(AppDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, mg7.b r101) {
        mg7.b r102 = r101;
        String r103 = r102.f513744a;
        if (r103 != null) goto L5;
        r100.bindNull(1);
    L6:
        r100.bindLong(2, r102.f513745b);
        String r104 = r102.f513746c;
        if (r104 != null) goto L9;
        r100.bindNull(3);
    L10:
        String r105 = r102.f513747d;
        if (r105 != null) goto L13;
        r100.bindNull(4);
    L14:
        r100.bindLong(5, r102.f513748e);
        byte[] r106 = r102.f513749f;
        if (r106 != null) goto L17;
        r100.bindNull(6);
    L18:
        r100.bindLong(7, r102.f513750g);
        r100.bindLong(8, kg7.a.a(r102.f513751h));
        DataType r107 = r102.f513752i;
        if (r107 != null) goto L21;
        int r108 = DataType.ORIGIN.getValue();
    L22:
        r100.bindLong(9, r108);
        r100.bindLong(10, r102.f513753j);
        r100.bindLong(11, r102.f513754k);
        r100.bindLong(12, r102.f513755l.getValue());
        r100.bindLong(13, r102.f513756m);
        return;
    L21:
        r108 = r107.getValue();
        goto L22
    L17:
        r100.bindBlob(6, r106);
        goto L18
    L13:
        r100.bindString(4, r105);
        goto L14
    L9:
        r100.bindString(3, r104);
        goto L10
    L5:
        r100.bindString(1, r103);
        goto L6
    }
}
