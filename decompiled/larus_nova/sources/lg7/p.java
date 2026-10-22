package lg7;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.sync.v2.presistence.AppDatabase;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM t_synclog WHERE sync_id = ?";
    }

    public p(AppDatabase r100) {
        super(r100);
    }
}
