package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class c0 extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "UPDATE DocMetaInfo SET is_subscribed = ? WHERE obj_token = ?";
    }

    public c0(BearDatabase r100) {
        super(r100);
    }
}
