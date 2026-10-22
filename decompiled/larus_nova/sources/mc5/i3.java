package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class i3 extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "UPDATE WikiSpace SET is_star= ? WHERE space_id= ?";
    }

    public i3(BearDatabase r100) {
        super(r100);
    }
}
