package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i3 extends SharedSQLiteStatement {
    public final String createQuery() {
        return "UPDATE WikiSpace SET is_star= ? WHERE space_id= ?";
    }

    public i3(BearDatabase r1) {
        super(r1);
    }
}
