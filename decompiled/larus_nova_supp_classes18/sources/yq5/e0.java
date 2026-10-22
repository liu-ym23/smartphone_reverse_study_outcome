package yq5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e0 extends SharedSQLiteStatement {
    public final String createQuery() {
        return "UPDATE t_wiki_space SET is_star= ? WHERE space_id= ?";
    }

    public e0(WikiDatabase r1) {
        super(r1);
    }
}
