package yq5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class j extends EntityInsertionAdapter<b> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR IGNORE INTO `t_wiki_relation` (`wiki_token`,`space_id`,`obj_token`,`obj_type`,`title`,`parent_wiki_token`,`sort_id`,`wiki_node_type`,`origin_wiki_token`,`origin_space_id`,`is_star`,`children`,`space_name`,`has_child`,`secret_key_delete`,`is_explorer_star`,`origin_is_external`,`entity_delete_flag`,`document_entity`,`detail_info`,`icon_entity`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public j(WikiDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, b r101) {
        b r102 = r101;
        String r103 = r102.f568778a;
        if (r103 != null) goto L5;
        r100.bindNull(1);
    L6:
        String r104 = r102.f568779b;
        if (r104 != null) goto L9;
        r100.bindNull(2);
    L10:
        String r105 = r102.f568780c;
        if (r105 != null) goto L13;
        r100.bindNull(3);
    L14:
        r100.bindLong(4, r102.f568781d);
        String r106 = r102.f568782e;
        if (r106 != null) goto L17;
        r100.bindNull(5);
    L18:
        String r107 = r102.f568783f;
        if (r107 != null) goto L21;
        r100.bindNull(6);
    L22:
        r100.bindDouble(7, r102.f568784g);
        r100.bindLong(8, r102.f568785h);
        String r108 = r102.f568786i;
        if (r108 != null) goto L25;
        r100.bindNull(9);
    L26:
        String r109 = r102.f568787j;
        if (r109 != null) goto L29;
        r100.bindNull(10);
    L30:
        r100.bindLong(11, r102.f568788k ? 1 : 0);
        String r110 = r102.f568789l;
        if (r110 != null) goto L33;
        r100.bindNull(12);
    L34:
        String r111 = r102.f568790m;
        if (r111 != null) goto L37;
        r100.bindNull(13);
    L38:
        r100.bindLong(14, r102.f568791n ? 1 : 0);
        r100.bindLong(15, r102.f568792o ? 1 : 0);
        r100.bindLong(16, r102.f568793p ? 1 : 0);
        r100.bindLong(17, r102.f568794q ? 1 : 0);
        r100.bindLong(18, r102.f568795r);
        String r112 = r102.f568796s;
        if (r112 != null) goto L41;
        r100.bindNull(19);
    L42:
        String r113 = r102.f568797t;
        if (r113 != null) goto L45;
        r100.bindNull(20);
    L46:
        String r114 = r102.f568798u;
        if (r114 != null) goto L49;
        r100.bindNull(21);
        return;
    L49:
        r100.bindString(21, r114);
        return;
    L45:
        r100.bindString(20, r113);
        goto L46
    L41:
        r100.bindString(19, r112);
        goto L42
    L37:
        r100.bindString(13, r111);
        goto L38
    L33:
        r100.bindString(12, r110);
        goto L34
    L29:
        r100.bindString(10, r109);
        goto L30
    L25:
        r100.bindString(9, r108);
        goto L26
    L21:
        r100.bindString(6, r107);
        goto L22
    L17:
        r100.bindString(5, r106);
        goto L18
    L13:
        r100.bindString(3, r105);
        goto L14
    L9:
        r100.bindString(2, r104);
        goto L10
    L5:
        r100.bindString(1, r103);
        goto L6
    }
}
