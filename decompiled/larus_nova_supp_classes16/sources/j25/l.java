package j25;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.document.offline.offlinestorage.OfflineDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM file_model WHERE token= ?";
    }

    public l(OfflineDatabase r1) {
        super(r1);
    }
}
