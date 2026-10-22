package yq5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM t_wiki_relation_info WHERE space_id = ?";
    }

    public p(WikiDatabase r1) {
        super(r1);
    }
}
