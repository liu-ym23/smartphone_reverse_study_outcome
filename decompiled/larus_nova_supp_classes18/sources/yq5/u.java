package yq5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u extends EntityInsertionAdapter<z> {
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `t_wiki_route_table` (`id`,`wiki_token`,`obj_token`,`obj_type`,`in_space`,`access_time`,`log_id`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
    }

    public u(WikiDatabase r1) {
        super(r1);
    }

    public final void bind(SupportSQLiteStatement r5, Object r6) {
        z r7 = (z) r6;
        r5.bindLong(1, r7.a);
        String r0 = r7.b;
        if (r0 != null) goto L5;
        r5.bindNull(2);
    L6:
        String r1 = r7.c;
        if (r1 != null) goto L9;
        r5.bindNull(3);
    L10:
        r5.bindLong(4, r7.d);
        r5.bindLong(5, r7.e ? 1 : 0);
        r5.bindLong(6, r7.f);
        String r8 = r7.g;
        if (r8 != null) goto L13;
        r5.bindNull(7);
        return;
    L13:
        r5.bindString(7, r8);
        return;
    L9:
        r5.bindString(3, r1);
        goto L10
    L5:
        r5.bindString(2, r0);
        goto L6
    }
}
