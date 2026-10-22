package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class h0 extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM ListTypes WHERE list_type = ? AND obj_token NOT LIKE ? || '%'  AND obj_token NOT IN (SELECT obj_token FROM DocMetaInfo WHERE is_offline_create = 1)";
    }

    public h0(BearDatabase r100) {
        super(r100);
    }
}
