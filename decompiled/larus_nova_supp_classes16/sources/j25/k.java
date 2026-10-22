package j25;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.document.offline.offlinestorage.OfflineDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k extends EntityDeletionOrUpdateAdapter<q> {
    public final String createQuery() {
        return "UPDATE OR ABORT `file_model` SET `name` = ?,`token` = ?,`doc_url` = ?,`path` = ?,`uri` = ?,`local_url` = ?,`net_url` = ?,`file_modified_time` = ?,`new_upload_key` = ?,`upload_key` = ? WHERE `name` = ? AND `token` = ?";
    }

    public k(OfflineDatabase r1) {
        super(r1);
    }

    public final void bind(SupportSQLiteStatement r5, Object r6) {
        q r7 = (q) r6;
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
        Long r10 = r7.h;
        if (r10 != null) goto L33;
        r5.bindNull(8);
    L34:
        String r11 = r7.i;
        if (r11 != null) goto L37;
        r5.bindNull(9);
    L38:
        String r12 = r7.j;
        if (r12 != null) goto L41;
        r5.bindNull(10);
    L42:
        String r13 = r7.a;
        if (r13 != null) goto L45;
        r5.bindNull(11);
    L46:
        String r14 = r7.b;
        if (r14 != null) goto L49;
        r5.bindNull(12);
        return;
    L49:
        r5.bindString(12, r14);
        return;
    L45:
        r5.bindString(11, r13);
        goto L46
    L41:
        r5.bindString(10, r12);
        goto L42
    L37:
        r5.bindString(9, r11);
        goto L38
    L33:
        r5.bindLong(8, r10.longValue());
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
