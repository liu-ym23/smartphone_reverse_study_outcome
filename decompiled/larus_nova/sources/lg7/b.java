package lg7;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.sync.v2.presistence.AppDatabase;

/* JADX INFO: loaded from: classes22.dex */
public final class b extends EntityInsertionAdapter<mg7.a> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `t_business`(`id`,`consume_type`,`bucket`) VALUES (?,?,?)";
    }

    public b(AppDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, mg7.a r101) {
        mg7.a r102 = r101;
        r100.bindLong(1, r102.f513741a);
        r100.bindLong(2, r102.f513742b.getValue());
        r100.bindLong(3, kg7.a.a(r102.f513743c));
    }
}
