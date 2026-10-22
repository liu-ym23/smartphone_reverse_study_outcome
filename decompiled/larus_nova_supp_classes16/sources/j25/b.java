package j25;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.document.offline.offlinestorage.OfflineDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends EntityInsertionAdapter<g> {
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `bitable_file_model` (`_id`,`name`,`token`,`doc_url`,`table_id`,`field_id`,`record_id`,`path`,`uri`,`mime_type`,`width`,`height`,`upload_task_key`,`upload_progress`,`attachment_token`,`is_camera_only`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public b(OfflineDatabase r1) {
        super(r1);
    }

    public final void bind(SupportSQLiteStatement r4, Object r5) {
        g r6 = (g) r5;
        r4.bindLong(1, r6.a);
        String r0 = r6.b;
        if (r0 != null) goto L5;
        r4.bindNull(2);
    L6:
        String r1 = r6.c;
        if (r1 != null) goto L9;
        r4.bindNull(3);
    L10:
        String r2 = r6.d;
        if (r2 != null) goto L13;
        r4.bindNull(4);
    L14:
        String r3 = r6.e;
        if (r3 != null) goto L17;
        r4.bindNull(5);
    L18:
        String r7 = r6.f;
        if (r7 != null) goto L21;
        r4.bindNull(6);
    L22:
        String r8 = r6.g;
        if (r8 != null) goto L25;
        r4.bindNull(7);
    L26:
        String r9 = r6.h;
        if (r9 != null) goto L29;
        r4.bindNull(8);
    L30:
        String r10 = r6.i;
        if (r10 != null) goto L33;
        r4.bindNull(9);
    L34:
        String r11 = r6.j;
        if (r11 != null) goto L37;
        r4.bindNull(10);
    L38:
        r4.bindLong(11, r6.k);
        r4.bindLong(12, r6.l);
        String r12 = r6.m;
        if (r12 != null) goto L41;
        r4.bindNull(13);
    L42:
        r4.bindLong(14, r6.n);
        String r13 = r6.o;
        if (r13 != null) goto L45;
        r4.bindNull(15);
    L46:
        r4.bindLong(16, r6.p ? 1 : 0);
        return;
    L45:
        r4.bindString(15, r13);
        goto L46
    L41:
        r4.bindString(13, r12);
        goto L42
    L37:
        r4.bindString(10, r11);
        goto L38
    L33:
        r4.bindString(9, r10);
        goto L34
    L29:
        r4.bindString(8, r9);
        goto L30
    L25:
        r4.bindString(7, r8);
        goto L26
    L21:
        r4.bindString(6, r7);
        goto L22
    L17:
        r4.bindString(5, r3);
        goto L18
    L13:
        r4.bindString(4, r2);
        goto L14
    L9:
        r4.bindString(3, r1);
        goto L10
    L5:
        r4.bindString(2, r0);
        goto L6
    }
}
