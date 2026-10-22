package yq5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class c0 extends EntityInsertionAdapter<e> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `t_wiki_space_list_ref` (`space_id`,`space_list_type`,`space_type_id`,`space_class_id`) VALUES (?,?,?,?)";
    }

    public c0(WikiDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, e r101) {
        e r102 = r101;
        String r103 = r102.f568821a;
        if (r103 != null) goto L5;
        r100.bindNull(1);
    L6:
        r100.bindLong(2, r102.f568822b);
        String r104 = r102.f568823c;
        if (r104 != null) goto L9;
        r100.bindNull(3);
    L10:
        String r105 = r102.f568824d;
        if (r105 != null) goto L13;
        r100.bindNull(4);
        return;
    L13:
        r100.bindString(4, r105);
        return;
    L9:
        r100.bindString(3, r104);
        goto L10
    L5:
        r100.bindString(1, r103);
        goto L6
    }
}
