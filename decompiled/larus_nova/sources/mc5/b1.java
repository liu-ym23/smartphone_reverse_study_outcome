package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class b1 extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "UPDATE ListTypes SET shortcut_obj_delete_flag = ? WHERE obj_token =? AND node_type_folder =?";
    }

    public b1(BearDatabase r100) {
        super(r100);
    }
}
