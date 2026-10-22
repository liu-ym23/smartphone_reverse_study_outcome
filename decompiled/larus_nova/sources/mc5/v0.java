package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class v0 extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM ListTypes WHERE list_type = ? AND obj_token IN(SELECT DocMetaInfo.obj_token FROM DocMetaInfo WHERE type != ?)";
    }

    public v0(BearDatabase r100) {
        super(r100);
    }
}
