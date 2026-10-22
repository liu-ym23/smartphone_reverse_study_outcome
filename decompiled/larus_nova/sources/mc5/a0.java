package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class a0 extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "UPDATE DocMetaInfo SET is_pined = ? WHERE obj_token = ?";
    }

    public a0(BearDatabase r100) {
        super(r100);
    }
}
