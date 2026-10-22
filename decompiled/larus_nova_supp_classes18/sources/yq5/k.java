package yq5;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k extends EntityDeletionOrUpdateAdapter<b> {
    public final String createQuery() {
        return "DELETE FROM `t_wiki_relation` WHERE `wiki_token` = ? AND `space_id` = ?";
    }

    public k(WikiDatabase r1) {
        super(r1);
    }

    public final void bind(SupportSQLiteStatement r3, Object r4) {
        b r5 = (b) r4;
        String r0 = r5.a;
        if (r0 != null) goto L5;
        r3.bindNull(1);
    L6:
        String r6 = r5.b;
        if (r6 != null) goto L9;
        r3.bindNull(2);
        return;
    L9:
        r3.bindString(2, r6);
        return;
    L5:
        r3.bindString(1, r0);
        goto L6
    }
}
