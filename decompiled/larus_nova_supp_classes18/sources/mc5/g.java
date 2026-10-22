package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM FolderSortStrategy WHERE obj_token IN(SELECT obj_token FROM FolderSortStrategy order by update_time asc limit ?)";
    }

    public g(BearDatabase r1) {
        super(r1);
    }
}
