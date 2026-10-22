package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class m0 extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "UPDATE DocMetaInfo SET name= ? WHERE wiki_real_token= ?";
    }

    public m0(BearDatabase r100) {
        super(r100);
    }
}
