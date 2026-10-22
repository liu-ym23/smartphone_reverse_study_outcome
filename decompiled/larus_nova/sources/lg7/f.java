package lg7;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.sync.v2.presistence.AppDatabase;

/* JADX INFO: loaded from: classes22.dex */
public final class f extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "UPDATE t_sync_cursor SET recv_cursor = 0 WHERE sync_id=?";
    }

    public f(AppDatabase r100) {
        super(r100);
    }
}
