package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d0 extends SharedSQLiteStatement {
    public final String createQuery() {
        return "UPDATE DocMetaInfo SET size = ? WHERE obj_token = ?";
    }

    public d0(BearDatabase r1) {
        super(r1);
    }
}
