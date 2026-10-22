package lg7;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.sync.v2.presistence.AppDatabase;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM t_snapshot WHERE sync_id = ?";
    }

    public q(AppDatabase r100) {
        super(r100);
    }
}
