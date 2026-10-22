package k25;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.document.offline.offlinestorage.OfflineDatabase;

/* JADX INFO: loaded from: classes16.dex */
public final class a1 extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM ResourceData WHERE total_page > 1 AND (category IS NULL OR (category IS NOT NULL AND access_time<= ?))";
    }

    public a1(OfflineDatabase r100) {
        super(r100);
    }
}
