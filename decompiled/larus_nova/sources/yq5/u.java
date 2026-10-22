package yq5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class u extends EntityInsertionAdapter<z> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `t_wiki_route_table` (`id`,`wiki_token`,`obj_token`,`obj_type`,`in_space`,`access_time`,`log_id`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
    }

    public u(WikiDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, z r101) {
        z r102 = r101;
        r100.bindLong(1, r102.f568851a);
        String r103 = r102.f568852b;
        if (r103 != null) goto L5;
        r100.bindNull(2);
    L6:
        String r104 = r102.f568853c;
        if (r104 != null) goto L9;
        r100.bindNull(3);
    L10:
        r100.bindLong(4, r102.f568854d);
        r100.bindLong(5, r102.f568855e ? 1 : 0);
        r100.bindLong(6, r102.f568856f);
        String r105 = r102.f568857g;
        if (r105 != null) goto L13;
        r100.bindNull(7);
        return;
    L13:
        r100.bindString(7, r105);
        return;
    L9:
        r100.bindString(3, r104);
        goto L10
    L5:
        r100.bindString(2, r103);
        goto L6
    }
}
