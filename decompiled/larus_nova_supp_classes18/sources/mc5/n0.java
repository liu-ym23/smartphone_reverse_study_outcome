package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n0 extends SharedSQLiteStatement {
    public final String createQuery() {
        return "UPDATE ListTypes SET token =?, extra =? WHERE obj_token =?";
    }

    public n0(BearDatabase r1) {
        super(r1);
    }
}
