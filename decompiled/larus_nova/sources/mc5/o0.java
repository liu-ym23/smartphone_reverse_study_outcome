package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class o0 extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "UPDATE ListTypes SET shortcut_name_folder= ? WHERE token= ?";
    }

    public o0(BearDatabase r100) {
        super(r100);
    }
}
