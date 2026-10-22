package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class r0 extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM ListTypes WHERE list_type = ? AND file_path = ? AND obj_token NOT LIKE ? || '%'";
    }

    public r0(BearDatabase r100) {
        super(r100);
    }
}
