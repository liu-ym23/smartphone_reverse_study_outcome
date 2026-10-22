package yq5;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class k extends EntityDeletionOrUpdateAdapter<b> {
    @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM `t_wiki_relation` WHERE `wiki_token` = ? AND `space_id` = ?";
    }

    public k(WikiDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityDeletionOrUpdateAdapter
    public final void bind(SupportSQLiteStatement r100, b r101) {
        b r102 = r101;
        String r103 = r102.f568778a;
        if (r103 != null) goto L5;
        r100.bindNull(1);
    L6:
        String r104 = r102.f568779b;
        if (r104 != null) goto L9;
        r100.bindNull(2);
        return;
    L9:
        r100.bindString(2, r104);
        return;
    L5:
        r100.bindString(1, r103);
        goto L6
    }
}
