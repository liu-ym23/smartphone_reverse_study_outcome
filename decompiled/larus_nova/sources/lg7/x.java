package lg7;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.sync.v2.presistence.AppDatabase;

/* JADX INFO: loaded from: classes22.dex */
public final class x extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM t_report_synclog WHERE t_report_synclog.business not in (SELECT distinct id from t_business) ";
    }

    public x(AppDatabase r100) {
        super(r100);
    }
}
