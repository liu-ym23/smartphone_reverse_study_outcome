package k25;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.document.offline.offlinestorage.OfflineDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class v0 extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM ResourceData WHERE obj_token= ?";
    }

    public v0(OfflineDatabase r1) {
        super(r1);
    }
}
