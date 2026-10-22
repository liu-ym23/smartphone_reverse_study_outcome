package yq5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class i extends EntityInsertionAdapter<a> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `t_wiki_relation_info` (`space_id`,`space_name`,`space_icon`,`tenant_id`,`description`,`is_star`,`space_type`,`wiki_scope`,`open_sharing`,`owner_perm_type`,`create_uid`,`cover_origin`,`cover_thumbnail`,`cover_key`,`cover_is_graph_dark`,`cover_color_value`,`view_wiki_collaborator`,`view_wiki_info`,`star_wiki`,`view_wiki_general_info`,`can_edit_first_level`,`wiki_homepage_obj_token`,`wiki_homepage_obj_type`,`wiki_homepage_wiki_token`,`wiki_homepage_url`,`wiki_homepage_title`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public i(WikiDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, a r101) {
        a r102 = r101;
        String r103 = r102.f568752a;
        if (r103 != null) goto L5;
        r100.bindNull(1);
    L6:
        String r104 = r102.f568753b;
        if (r104 != null) goto L9;
        r100.bindNull(2);
    L10:
        String r105 = r102.f568754c;
        if (r105 != null) goto L13;
        r100.bindNull(3);
    L14:
        String r106 = r102.f568755d;
        if (r106 != null) goto L17;
        r100.bindNull(4);
    L18:
        String r107 = r102.f568756e;
        if (r107 != null) goto L21;
        r100.bindNull(5);
    L22:
        r100.bindLong(6, r102.f568757f ? 1 : 0);
        r100.bindLong(7, r102.f568758g);
        r100.bindLong(8, r102.f568759h);
        r100.bindLong(9, r102.f568760i);
        r100.bindLong(10, r102.f568761j);
        String r108 = r102.f568762k;
        if (r108 != null) goto L25;
        r100.bindNull(11);
    L26:
        String r109 = r102.f568763l;
        if (r109 != null) goto L29;
        r100.bindNull(12);
    L30:
        String r110 = r102.f568764m;
        if (r110 != null) goto L33;
        r100.bindNull(13);
    L34:
        String r111 = r102.f568765n;
        if (r111 != null) goto L37;
        r100.bindNull(14);
    L38:
        r100.bindLong(15, r102.f568766o ? 1 : 0);
        String r112 = r102.f568767p;
        if (r112 != null) goto L41;
        r100.bindNull(16);
    L42:
        r100.bindLong(17, r102.f568768q ? 1 : 0);
        r100.bindLong(18, r102.f568769r ? 1 : 0);
        r100.bindLong(19, r102.f568770s ? 1 : 0);
        r100.bindLong(20, r102.f568771t ? 1 : 0);
        r100.bindLong(21, r102.f568772u ? 1 : 0);
        String r113 = r102.f568773v;
        if (r113 != null) goto L45;
        r100.bindNull(22);
    L46:
        r100.bindLong(23, r102.f568774w);
        String r114 = r102.f568775x;
        if (r114 != null) goto L49;
        r100.bindNull(24);
    L50:
        String r115 = r102.f568776y;
        if (r115 != null) goto L53;
        r100.bindNull(25);
    L54:
        String r116 = r102.f568777z;
        if (r116 != null) goto L57;
        r100.bindNull(26);
        return;
    L57:
        r100.bindString(26, r116);
        return;
    L53:
        r100.bindString(25, r115);
        goto L54
    L49:
        r100.bindString(24, r114);
        goto L50
    L45:
        r100.bindString(22, r113);
        goto L46
    L41:
        r100.bindString(16, r112);
        goto L42
    L37:
        r100.bindString(14, r111);
        goto L38
    L33:
        r100.bindString(13, r110);
        goto L34
    L29:
        r100.bindString(12, r109);
        goto L30
    L25:
        r100.bindString(11, r108);
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
