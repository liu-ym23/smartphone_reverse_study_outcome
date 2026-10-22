package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u extends SharedSQLiteStatement {
    public final String createQuery() {
        return "UPDATE DocMetaInfo SET obj_token =?, url =? WHERE obj_token =?";
    }

    public u(BearDatabase r1) {
        super(r1);
    }
}
