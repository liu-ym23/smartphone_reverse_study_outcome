package yq5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m extends SharedSQLiteStatement {
    public final String createQuery() {
        return "UPDATE t_wiki_relation set title = ? AND icon_entity = ? WHERE (space_id = ? AND wiki_token =?)";
    }

    public m(WikiDatabase r1) {
        super(r1);
    }
}
