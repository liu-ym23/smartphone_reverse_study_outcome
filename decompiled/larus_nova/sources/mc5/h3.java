package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class h3 extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "UPDATE WikiSpace SET is_star= ? WHERE obj_token= ?";
    }

    public h3(BearDatabase r100) {
        super(r100);
    }
}
