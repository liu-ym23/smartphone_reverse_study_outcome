package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class p extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM DocMetaInfo WHERE obj_token =?";
    }

    public p(BearDatabase r100) {
        super(r100);
    }
}
