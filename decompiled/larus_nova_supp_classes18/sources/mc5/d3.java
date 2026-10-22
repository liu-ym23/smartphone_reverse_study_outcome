package mc5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d3 extends EntityInsertionAdapter<b3> {
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `WikiSpace` (`space_id`,`user_id`,`space_name`,`space_icon`,`attr`,`description`,`is_star`,`browse_time`,`wiki_token`,`obj_type`,`obj_token`,`origin`,`thumbnail`,`cover_key`,`is_graph_dark`,`color_value`,`wiki_scope`,`space_type`,`open_sharing`,`tag_type`,`tag_value`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public d3(BearDatabase r1) {
        super(r1);
    }

    public final void bind(SupportSQLiteStatement r5, Object r6) {
        b3 r7 = (b3) r6;
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
        r5.bindLong(5, r7.e);
        String r4 = r7.f;
        if (r4 != null) goto L21;
        r5.bindNull(6);
    L22:
        r5.bindLong(7, r7.g ? 1 : 0);
        String r8 = r7.h;
        if (r8 != null) goto L25;
        r5.bindNull(8);
    L26:
        String r9 = r7.i;
        if (r9 != null) goto L29;
        r5.bindNull(9);
    L30:
        r5.bindLong(10, r7.j);
        String r10 = r7.k;
        if (r10 != null) goto L33;
        r5.bindNull(11);
    L34:
        String r11 = r7.l;
        if (r11 != null) goto L37;
        r5.bindNull(12);
    L38:
        String r12 = r7.m;
        if (r12 != null) goto L41;
        r5.bindNull(13);
    L42:
        String r13 = r7.n;
        if (r13 != null) goto L45;
        r5.bindNull(14);
    L46:
        r5.bindLong(15, r7.o ? 1 : 0);
        String r14 = r7.p;
        if (r14 != null) goto L49;
        r5.bindNull(16);
    L50:
        r5.bindLong(17, r7.q);
        r5.bindLong(18, r7.r);
        r5.bindLong(19, r7.s);
        r5.bindLong(20, r7.t);
        String r15 = r7.u;
        if (r15 != null) goto L53;
        r5.bindNull(21);
        return;
    L53:
        r5.bindString(21, r15);
        return;
    L49:
        r5.bindString(16, r14);
        goto L50
    L45:
        r5.bindString(14, r13);
        goto L46
    L41:
        r5.bindString(13, r12);
        goto L42
    L37:
        r5.bindString(12, r11);
        goto L38
    L33:
        r5.bindString(11, r10);
        goto L34
    L29:
        r5.bindString(9, r9);
        goto L30
    L25:
        r5.bindString(8, r8);
        goto L26
    L21:
        r5.bindString(6, r4);
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
