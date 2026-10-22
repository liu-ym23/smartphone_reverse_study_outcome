package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x extends SharedSQLiteStatement {
    public final String createQuery() {
        return "UPDATE DocMetaInfo SET obj_token =?, type =?, url =?, wiki_real_token =?, wiki_real_type =?, wiki_extra =?, is_offline_create = 0 WHERE obj_token =?";
    }

    public x(BearDatabase r1) {
        super(r1);
    }
}
