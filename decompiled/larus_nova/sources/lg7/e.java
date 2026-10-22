package lg7;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.sync.v2.presistence.AppDatabase;

/* JADX INFO: loaded from: classes22.dex */
public final class e extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "UPDATE t_sync_cursor SET report_cursor = ? WHERE sync_id = ? ";
    }

    public e(AppDatabase r100) {
        super(r100);
    }
}
