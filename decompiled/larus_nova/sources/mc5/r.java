package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class r extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM ListTypes WHERE obj_token =? AND list_type = ?";
    }

    public r(BearDatabase r100) {
        super(r100);
    }
}
