package yq5;

import androidx.room.SharedSQLiteStatement;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x extends SharedSQLiteStatement {
    public final String createQuery() {
        return "DELETE FROM t_wiki_route_table WHERE obj_token = ?";
    }

    public x(WikiDatabase r1) {
        super(r1);
    }
}
