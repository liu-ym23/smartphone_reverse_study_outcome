package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class t extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "UPDATE CacheStatus SET obj_token =?, doc_cache_status =? WHERE obj_token =?";
    }

    public t(BearDatabase r100) {
        super(r100);
    }
}
