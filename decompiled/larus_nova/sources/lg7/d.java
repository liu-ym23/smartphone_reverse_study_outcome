package lg7;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.sync.v2.presistence.AppDatabase;

/* JADX INFO: loaded from: classes22.dex */
public final class d extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "UPDATE t_sync_cursor SET report_cursor = ?,did=?,uid=?,bucket=? WHERE sync_id = ? ";
    }

    public d(AppDatabase r100) {
        super(r100);
    }
}
