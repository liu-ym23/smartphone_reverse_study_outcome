package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p0 extends SharedSQLiteStatement {
    public final String createQuery() {
        return "UPDATE DocMetaInfo SET name= ?, icon= ?, edit_time =? WHERE obj_token= ?";
    }

    public p0(BearDatabase r1) {
        super(r1);
    }
}
