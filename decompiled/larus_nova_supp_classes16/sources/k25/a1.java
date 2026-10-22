package k25;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.document.offline.offlinestorage.OfflineDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a1 extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM ResourceData WHERE total_page > 1 AND (category IS NULL OR (category IS NOT NULL AND access_time<= ?))";
    }

    public a1(OfflineDatabase r1) {
        super(r1);
    }
}
