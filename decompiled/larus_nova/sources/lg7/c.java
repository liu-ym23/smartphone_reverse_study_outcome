package lg7;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.sync.v2.presistence.AppDatabase;

/* JADX INFO: loaded from: classes22.dex */
public final class c extends EntityInsertionAdapter<mg7.c> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `t_sync_cursor`(`sync_id`,`did`,`uid`,`topic_type`,`bucket`,`recv_cursor`,`report_cursor`) VALUES (?,?,?,?,?,?,?)";
    }

    public c(AppDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, mg7.c r101) {
        mg7.c r102 = r101;
        String r103 = r102.f513757a;
        if (r103 != null) goto L5;
        r100.bindNull(1);
    L6:
        String r104 = r102.f513758b;
        if (r104 != null) goto L9;
        r100.bindNull(2);
    L10:
        String r105 = r102.f513759c;
        if (r105 != null) goto L13;
        r100.bindNull(3);
    L14:
        r100.bindLong(4, kg7.g.a(r102.f513760d));
        r100.bindLong(5, kg7.a.a(r102.f513761e));
        r100.bindLong(6, r102.f513762f);
        r100.bindLong(7, r102.f513763g);
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
