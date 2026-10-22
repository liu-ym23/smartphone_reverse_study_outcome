package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class t0 extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "UPDATE DocMetaInfo SET is_visited= ? WHERE obj_token= ?";
    }

    public t0(BearDatabase r100) {
        super(r100);
    }
}
