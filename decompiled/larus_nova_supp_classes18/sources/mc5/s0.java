package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s0 extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM ListTypes WHERE list_type = ? AND is_hidden_share = ? AND obj_token IN(SELECT DocMetaInfo.obj_token FROM DocMetaInfo WHERE type = ?)";
    }

    public s0(BearDatabase r1) {
        super(r1);
    }
}
