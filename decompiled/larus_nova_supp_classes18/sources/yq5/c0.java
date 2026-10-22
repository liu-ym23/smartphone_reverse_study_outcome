package yq5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c0 extends EntityInsertionAdapter<e> {
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `t_wiki_space_list_ref` (`space_id`,`space_list_type`,`space_type_id`,`space_class_id`) VALUES (?,?,?,?)";
    }

    public c0(WikiDatabase r1) {
        super(r1);
    }

    public final void bind(SupportSQLiteStatement r4, Object r5) {
        e r6 = (e) r5;
        String r0 = r6.a;
        if (r0 != null) goto L5;
        r4.bindNull(1);
    L6:
        r4.bindLong(2, r6.b);
        String r1 = r6.c;
        if (r1 != null) goto L9;
        r4.bindNull(3);
    L10:
        String r7 = r6.d;
        if (r7 != null) goto L13;
        r4.bindNull(4);
        return;
    L13:
        r4.bindString(4, r7);
        return;
    L9:
        r4.bindString(3, r1);
        goto L10
    L5:
        r4.bindString(1, r0);
        goto L6
    }
}
