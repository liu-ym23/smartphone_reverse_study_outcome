package j25;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.document.offline.offlinestorage.OfflineDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM file_model WHERE token= ? AND net_url = ?";
    }

    public n(OfflineDatabase r1) {
        super(r1);
    }
}
