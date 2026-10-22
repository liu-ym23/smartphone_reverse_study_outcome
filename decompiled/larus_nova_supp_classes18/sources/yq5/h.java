package yq5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h extends EntityInsertionAdapter<b> {
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `t_wiki_relation` (`wiki_token`,`space_id`,`obj_token`,`obj_type`,`title`,`parent_wiki_token`,`sort_id`,`wiki_node_type`,`origin_wiki_token`,`origin_space_id`,`is_star`,`children`,`space_name`,`has_child`,`secret_key_delete`,`is_explorer_star`,`origin_is_external`,`entity_delete_flag`,`document_entity`,`detail_info`,`icon_entity`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public h(WikiDatabase r1) {
        super(r1);
    }

    public final void bind(SupportSQLiteStatement r5, Object r6) {
        b r7 = (b) r6;
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
        r5.bindLong(4, r7.d);
        String r3 = r7.e;
        if (r3 != null) goto L17;
        r5.bindNull(5);
    L18:
        String r4 = r7.f;
        if (r4 != null) goto L21;
        r5.bindNull(6);
    L22:
        r5.bindDouble(7, r7.g);
        r5.bindLong(8, r7.h);
        String r8 = r7.i;
        if (r8 != null) goto L25;
        r5.bindNull(9);
    L26:
        String r9 = r7.j;
        if (r9 != null) goto L29;
        r5.bindNull(10);
    L30:
        r5.bindLong(11, r7.k ? 1 : 0);
        String r10 = r7.l;
        if (r10 != null) goto L33;
        r5.bindNull(12);
    L34:
        String r11 = r7.m;
        if (r11 != null) goto L37;
        r5.bindNull(13);
    L38:
        r5.bindLong(14, r7.n ? 1 : 0);
        r5.bindLong(15, r7.o ? 1 : 0);
        r5.bindLong(16, r7.p ? 1 : 0);
        r5.bindLong(17, r7.q ? 1 : 0);
        r5.bindLong(18, r7.r);
        String r12 = r7.s;
        if (r12 != null) goto L41;
        r5.bindNull(19);
    L42:
        String r13 = r7.t;
        if (r13 != null) goto L45;
        r5.bindNull(20);
    L46:
        String r14 = r7.u;
        if (r14 != null) goto L49;
        r5.bindNull(21);
        return;
    L49:
        r5.bindString(21, r14);
        return;
    L45:
        r5.bindString(20, r13);
        goto L46
    L41:
        r5.bindString(19, r12);
        goto L42
    L37:
        r5.bindString(13, r11);
        goto L38
    L33:
        r5.bindString(12, r10);
        goto L34
    L29:
        r5.bindString(10, r9);
        goto L30
    L25:
        r5.bindString(9, r8);
        goto L26
    L21:
        r5.bindString(6, r4);
        goto L22
    L17:
        r5.bindString(5, r3);
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
