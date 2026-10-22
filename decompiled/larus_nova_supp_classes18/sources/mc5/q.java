package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM ListTypes WHERE obj_token =? AND node_type_folder !=?";
    }

    public q(BearDatabase r1) {
        super(r1);
    }
}
