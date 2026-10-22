package mc5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class w extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "UPDATE DocMetaInfo SET obj_token =?, type =?, url =?, wiki_real_token =?, wiki_real_type =?, wiki_extra =? WHERE obj_token =?";
    }

    public w(BearDatabase r100) {
        super(r100);
    }
}
