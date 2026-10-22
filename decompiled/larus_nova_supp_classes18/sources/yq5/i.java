package yq5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i extends EntityInsertionAdapter<a> {
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `t_wiki_relation_info` (`space_id`,`space_name`,`space_icon`,`tenant_id`,`description`,`is_star`,`space_type`,`wiki_scope`,`open_sharing`,`owner_perm_type`,`create_uid`,`cover_origin`,`cover_thumbnail`,`cover_key`,`cover_is_graph_dark`,`cover_color_value`,`view_wiki_collaborator`,`view_wiki_info`,`star_wiki`,`view_wiki_general_info`,`can_edit_first_level`,`wiki_homepage_obj_token`,`wiki_homepage_obj_type`,`wiki_homepage_wiki_token`,`wiki_homepage_url`,`wiki_homepage_title`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public i(WikiDatabase r1) {
        super(r1);
    }

    public final void bind(SupportSQLiteStatement r5, Object r6) {
        a r7 = (a) r6;
        String r0 = r7.a;
        if (r0 != null) goto L5;
        r5.bindNull(1);
    L6:
        String r1 = r7.b;
        if (r1 != null) goto L9;
        r5.bindNull(2);
    L10:
        String r2 = r7.c;
        if (r2 != null) goto L13;
        r5.bindNull(3);
    L14:
        String r3 = r7.d;
        if (r3 != null) goto L17;
        r5.bindNull(4);
    L18:
        String r4 = r7.e;
        if (r4 != null) goto L21;
        r5.bindNull(5);
    L22:
        r5.bindLong(6, r7.f ? 1 : 0);
        r5.bindLong(7, r7.g);
        r5.bindLong(8, r7.h);
        r5.bindLong(9, r7.i);
        r5.bindLong(10, r7.j);
        String r8 = r7.k;
        if (r8 != null) goto L25;
        r5.bindNull(11);
    L26:
        String r9 = r7.l;
        if (r9 != null) goto L29;
        r5.bindNull(12);
    L30:
        String r10 = r7.m;
        if (r10 != null) goto L33;
        r5.bindNull(13);
    L34:
        String r11 = r7.n;
        if (r11 != null) goto L37;
        r5.bindNull(14);
    L38:
        r5.bindLong(15, r7.o ? 1 : 0);
        String r12 = r7.p;
        if (r12 != null) goto L41;
        r5.bindNull(16);
    L42:
        r5.bindLong(17, r7.q ? 1 : 0);
        r5.bindLong(18, r7.r ? 1 : 0);
        r5.bindLong(19, r7.s ? 1 : 0);
        r5.bindLong(20, r7.t ? 1 : 0);
        r5.bindLong(21, r7.u ? 1 : 0);
        String r13 = r7.v;
        if (r13 != null) goto L45;
        r5.bindNull(22);
    L46:
        r5.bindLong(23, r7.w);
        String r14 = r7.x;
        if (r14 != null) goto L49;
        r5.bindNull(24);
    L50:
        String r15 = r7.y;
        if (r15 != null) goto L53;
        r5.bindNull(25);
    L54:
        String r16 = r7.z;
        if (r16 != null) goto L57;
        r5.bindNull(26);
        return;
    L57:
        r5.bindString(26, r16);
        return;
    L53:
        r5.bindString(25, r15);
        goto L54
    L49:
        r5.bindString(24, r14);
        goto L50
    L45:
        r5.bindString(22, r13);
        goto L46
    L41:
        r5.bindString(16, r12);
        goto L42
    L37:
        r5.bindString(14, r11);
        goto L38
    L33:
        r5.bindString(13, r10);
        goto L34
    L29:
        r5.bindString(12, r9);
        goto L30
    L25:
        r5.bindString(11, r8);
        goto L26
    L21:
        r5.bindString(5, r4);
        goto L22
    L17:
        r5.bindString(4, r3);
        goto L18
    L13:
        r5.bindString(3, r2);
        goto L14
    L9:
        r5.bindString(2, r1);
        goto L10
    L5:
        r5.bindString(1, r0);
        goto L6
    }
}
