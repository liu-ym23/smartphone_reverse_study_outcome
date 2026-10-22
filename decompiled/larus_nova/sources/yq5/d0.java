package yq5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class d0 extends EntityInsertionAdapter<d> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `t_wiki_space` (`space_id`,`space_name`,`description`,`space_icon`,`tenant_id`,`cover_origin`,`cover_thumbnail`,`cover_key`,`cover_is_graph_dark`,`cover_color_value`,`root_token`,`space_type`,`wiki_scope`,`is_star`,`browse_time`,`owner_perm_type`,`open_sharing`,`tag_type`,`tag_value`,`icon_info`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public d0(WikiDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, d r101) {
        d r102 = r101;
        String r103 = r102.f568801a;
        if (r103 != null) goto L5;
        r100.bindNull(1);
    L6:
        String r104 = r102.f568802b;
        if (r104 != null) goto L9;
        r100.bindNull(2);
    L10:
        String r105 = r102.f568803c;
        if (r105 != null) goto L13;
        r100.bindNull(3);
    L14:
        String r106 = r102.f568804d;
        if (r106 != null) goto L17;
        r100.bindNull(4);
    L18:
        String r107 = r102.f568805e;
        if (r107 != null) goto L21;
        r100.bindNull(5);
    L22:
        String r108 = r102.f568806f;
        if (r108 != null) goto L25;
        r100.bindNull(6);
    L26:
        String r109 = r102.f568807g;
        if (r109 != null) goto L29;
        r100.bindNull(7);
    L30:
        String r110 = r102.f568808h;
        if (r110 != null) goto L33;
        r100.bindNull(8);
    L34:
        r100.bindLong(9, r102.f568809i ? 1 : 0);
        String r111 = r102.f568810j;
        if (r111 != null) goto L37;
        r100.bindNull(10);
    L38:
        String r112 = r102.f568811k;
        if (r112 != null) goto L41;
        r100.bindNull(11);
    L42:
        r100.bindLong(12, r102.f568812l);
        r100.bindLong(13, r102.f568813m);
        r100.bindLong(14, r102.f568814n ? 1 : 0);
        String r113 = r102.f568815o;
        if (r113 != null) goto L45;
        r100.bindNull(15);
    L46:
        r100.bindLong(16, r102.f568816p);
        r100.bindLong(17, r102.f568817q);
        r100.bindLong(18, r102.f568818r);
        String r114 = r102.f568819s;
        if (r114 != null) goto L49;
        r100.bindNull(19);
    L50:
        String r115 = r102.f568820t;
        if (r115 != null) goto L53;
        r100.bindNull(20);
        return;
    L53:
        r100.bindString(20, r115);
        return;
    L49:
        r100.bindString(19, r114);
        goto L50
    L45:
        r100.bindString(15, r113);
        goto L46
    L41:
        r100.bindString(11, r112);
        goto L42
    L37:
        r100.bindString(10, r111);
        goto L38
    L33:
        r100.bindString(8, r110);
        goto L34
    L29:
        r100.bindString(7, r109);
        goto L30
    L25:
        r100.bindString(6, r108);
        goto L26
    L21:
        r100.bindString(5, r107);
        goto L22
    L17:
        r100.bindString(4, r106);
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
