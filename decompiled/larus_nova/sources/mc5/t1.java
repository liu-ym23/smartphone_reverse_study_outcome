package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class t1 extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM DocMetaInfo WHERE obj_token NOT LIKE ? || '%' AND obj_token NOT IN(SELECT obj_token FROM ListTypes)";
    }

    public t1(BearDatabase r100) {
        super(r100);
    }
}
