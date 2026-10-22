package yq5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM t_wiki_relation";
    }

    public n(WikiDatabase r1) {
        super(r1);
    }
}
