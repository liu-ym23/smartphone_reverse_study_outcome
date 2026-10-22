package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e3 extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM WikiSpace";
    }

    public e3(BearDatabase r1) {
        super(r1);
    }
}
