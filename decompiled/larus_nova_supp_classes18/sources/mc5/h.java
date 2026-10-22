package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM FolderSortStrategy";
    }

    public h(BearDatabase r1) {
        super(r1);
    }
}
