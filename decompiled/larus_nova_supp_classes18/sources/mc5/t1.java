package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t1 extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM DocMetaInfo WHERE obj_token NOT LIKE ? || '%' AND obj_token NOT IN(SELECT obj_token FROM ListTypes)";
    }

    public t1(BearDatabase r1) {
        super(r1);
    }
}
