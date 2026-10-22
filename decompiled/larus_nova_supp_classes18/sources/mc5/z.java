package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class z extends SharedSQLiteStatement {
    public final String createQuery() {
        return "UPDATE ListTypes SET show_external_hint_folder = ? WHERE obj_token = ? AND list_type = ? AND file_path = ?";
    }

    public z(BearDatabase r1) {
        super(r1);
    }
}
