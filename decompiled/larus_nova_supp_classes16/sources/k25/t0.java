package k25;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.document.offline.offlinestorage.OfflineDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class t0 extends EntityDeletionOrUpdateAdapter<m0> {
    public final String createQuery() {
        return "UPDATE OR ABORT `ResourceData` SET `id` = ?,`reskey` = ?,`resvalue` = ?,`resvalue_filepath` = ?,`update_time` = ?,`access_time` = ?,`isNeedSync` = ?,`config` = ?,`type` = ?,`token` = ?,`obj_token` = ?,`userToken` = ?,`tenantID` = ?,`url` = ?,`subblock_preload_status` = ?,`page` = ?,`total_page` = ?,`batch_num` = ?,`load_from` = ?,`category` = ? WHERE `id` = ?";
    }

    public t0(OfflineDatabase r1) {
        super(r1);
    }

    public final void bind(SupportSQLiteStatement r5, Object r6) {
        m0 r7 = (m0) r6;
        r5.bindLong(1, r7.a);
        String r0 = r7.b;
        if (r0 != null) goto L5;
        r5.bindNull(2);
    L6:
        String r1 = r7.c;
        if (r1 != null) goto L9;
        r5.bindNull(3);
    L10:
        String r2 = r7.d;
        if (r2 != null) goto L13;
        r5.bindNull(4);
    L14:
        Long r3 = r7.e;
        if (r3 != null) goto L17;
        r5.bindNull(5);
    L18:
        Long r4 = r7.f;
        if (r4 != null) goto L21;
        r5.bindNull(6);
    L22:
        r5.bindLong(7, r7.g ? 1 : 0);
        String r8 = r7.h;
        if (r8 != null) goto L25;
        r5.bindNull(8);
    L27:
        if (r7.getType() != null) goto L29;
        r5.bindNull(9);
    L30:
        String r9 = r7.j;
        if (r9 != null) goto L33;
        r5.bindNull(10);
    L34:
        String r10 = r7.k;
        if (r10 != null) goto L37;
        r5.bindNull(11);
    L38:
        String r11 = r7.l;
        if (r11 != null) goto L41;
        r5.bindNull(12);
    L42:
        String r12 = r7.m;
        if (r12 != null) goto L45;
        r5.bindNull(13);
    L46:
        String r13 = r7.n;
        if (r13 != null) goto L49;
        r5.bindNull(14);
    L50:
        r5.bindLong(15, r7.o);
        r5.bindLong(16, r7.p);
        r5.bindLong(17, r7.q);
        String r14 = r7.r;
        if (r14 != null) goto L53;
        r5.bindNull(18);
    L54:
        String r16 = r7.s;
        if (r16 != null) goto L57;
        r5.bindNull(19);
    L58:
        String r17 = r7.t;
        if (r17 != null) goto L61;
        r5.bindNull(20);
    L62:
        r5.bindLong(21, r7.a);
        return;
    L61:
        r5.bindString(20, r17);
        goto L62
    L57:
        r5.bindString(19, r16);
        goto L58
    L53:
        r5.bindString(18, r14);
        goto L54
    L49:
        r5.bindString(14, r13);
        goto L50
    L45:
        r5.bindString(13, r12);
        goto L46
    L41:
        r5.bindString(12, r11);
        goto L42
    L37:
        r5.bindString(11, r10);
        goto L38
    L33:
        r5.bindString(10, r9);
        goto L34
    L29:
        r5.bindString(9, r7.getType());
        goto L30
    L25:
        r5.bindString(8, r8);
        goto L27
    L21:
        r5.bindLong(6, r4.longValue());
        goto L22
    L17:
        r5.bindLong(5, r3.longValue());
        goto L18
    L13:
        r5.bindString(4, r2);
        goto L14
    L9:
        r5.bindString(3, r1);
        goto L10
    L5:
        r5.bindString(2, r0);
        goto L6
    }
}
