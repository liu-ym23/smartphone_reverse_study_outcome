package yq5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d0 extends EntityInsertionAdapter<d> {
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `t_wiki_space` (`space_id`,`space_name`,`description`,`space_icon`,`tenant_id`,`cover_origin`,`cover_thumbnail`,`cover_key`,`cover_is_graph_dark`,`cover_color_value`,`root_token`,`space_type`,`wiki_scope`,`is_star`,`browse_time`,`owner_perm_type`,`open_sharing`,`tag_type`,`tag_value`,`icon_info`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public d0(WikiDatabase r1) {
        super(r1);
    }

    public final void bind(SupportSQLiteStatement r5, Object r6) {
        d r7 = (d) r6;
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
        String r8 = r7.f;
        if (r8 != null) goto L25;
        r5.bindNull(6);
    L26:
        String r9 = r7.g;
        if (r9 != null) goto L29;
        r5.bindNull(7);
    L30:
        String r10 = r7.h;
        if (r10 != null) goto L33;
        r5.bindNull(8);
    L34:
        r5.bindLong(9, r7.i ? 1 : 0);
        String r11 = r7.j;
        if (r11 != null) goto L37;
        r5.bindNull(10);
    L38:
        String r12 = r7.k;
        if (r12 != null) goto L41;
        r5.bindNull(11);
    L42:
        r5.bindLong(12, r7.l);
        r5.bindLong(13, r7.m);
        r5.bindLong(14, r7.n ? 1 : 0);
        String r13 = r7.o;
        if (r13 != null) goto L45;
        r5.bindNull(15);
    L46:
        r5.bindLong(16, r7.p);
        r5.bindLong(17, r7.q);
        r5.bindLong(18, r7.r);
        String r14 = r7.s;
        if (r14 != null) goto L49;
        r5.bindNull(19);
    L50:
        String r15 = r7.t;
        if (r15 != null) goto L53;
        r5.bindNull(20);
        return;
    L53:
        r5.bindString(20, r15);
        return;
    L49:
        r5.bindString(19, r14);
        goto L50
    L45:
        r5.bindString(15, r13);
        goto L46
    L41:
        r5.bindString(11, r12);
        goto L42
    L37:
        r5.bindString(10, r11);
        goto L38
    L33:
        r5.bindString(8, r10);
        goto L34
    L29:
        r5.bindString(7, r9);
        goto L30
    L25:
        r5.bindString(6, r8);
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
