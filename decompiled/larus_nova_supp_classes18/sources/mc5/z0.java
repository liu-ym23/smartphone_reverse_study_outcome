package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class z0 extends SharedSQLiteStatement {
    public final String createQuery() {
        return "UPDATE CacheStatus SET doc_cache_status = ?";
    }

    public z0(BearDatabase r1) {
        super(r1);
    }
}
