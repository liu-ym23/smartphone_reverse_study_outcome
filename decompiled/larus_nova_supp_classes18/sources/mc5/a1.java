package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a1 extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM CACHESTATUS WHERE obj_token =?";
    }

    public a1(BearDatabase r1) {
        super(r1);
    }
}
