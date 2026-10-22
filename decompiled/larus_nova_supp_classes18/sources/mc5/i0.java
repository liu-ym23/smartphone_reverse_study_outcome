package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i0 extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM ListTypes WHERE list_type !=? AND list_type !=? AND list_type !=? AND list_type !=? AND obj_token NOT LIKE ? || '%'";
    }

    public i0(BearDatabase r1) {
        super(r1);
    }
}
