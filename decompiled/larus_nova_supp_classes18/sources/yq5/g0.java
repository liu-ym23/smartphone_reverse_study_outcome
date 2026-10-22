package yq5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g0 extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM t_wiki_space_list_ref WHERE space_list_type=? AND space_id = ?";
    }

    public g0(WikiDatabase r1) {
        super(r1);
    }
}
