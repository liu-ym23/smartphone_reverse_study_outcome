package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class o extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM FilterCache WHERE list_type =? AND filter_type =? AND file_type =? AND strategy =? AND is_asc =? AND file_path =?";
    }

    public o(BearDatabase r100) {
        super(r100);
    }
}
