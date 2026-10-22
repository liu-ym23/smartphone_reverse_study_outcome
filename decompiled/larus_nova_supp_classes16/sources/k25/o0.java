package k25;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.document.offline.offlinestorage.OfflineDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class o0 extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM ResourceData";
    }

    public o0(OfflineDatabase r1) {
        super(r1);
    }
}
