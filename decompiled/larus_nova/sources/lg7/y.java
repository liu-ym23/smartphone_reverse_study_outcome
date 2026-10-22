package lg7;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.sync.v2.presistence.AppDatabase;

/* JADX INFO: loaded from: classes22.dex */
public final class y extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM t_report_synclog WHERE sync_id = ? AND cursor > 0 AND cursor <=?";
    }

    public y(AppDatabase r100) {
        super(r100);
    }
}
