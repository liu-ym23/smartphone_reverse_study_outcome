package k25;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.document.offline.offlinestorage.OfflineDatabase;

/* JADX INFO: loaded from: classes16.dex */
public final class u0 extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM ResourceData WHERE obj_token = ? AND category = ? AND id NOT IN (SELECT id FROM ResourceData WHERE obj_token = ? AND category = ? ORDER BY access_time DESC LIMIT ?)";
    }

    public u0(OfflineDatabase r100) {
        super(r100);
    }
}
