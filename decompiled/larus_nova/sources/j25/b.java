package j25;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.document.offline.offlinestorage.OfflineDatabase;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends EntityInsertionAdapter<g> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `bitable_file_model` (`_id`,`name`,`token`,`doc_url`,`table_id`,`field_id`,`record_id`,`path`,`uri`,`mime_type`,`width`,`height`,`upload_task_key`,`upload_progress`,`attachment_token`,`is_camera_only`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public b(OfflineDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, g r101) {
        g r102 = r101;
        r100.bindLong(1, r102.f496977a);
        String r103 = r102.f496978b;
        if (r103 != null) goto L5;
        r100.bindNull(2);
    L6:
        String r104 = r102.f496979c;
        if (r104 != null) goto L9;
        r100.bindNull(3);
    L10:
        String r105 = r102.f496980d;
        if (r105 != null) goto L13;
        r100.bindNull(4);
    L14:
        String r106 = r102.f496981e;
        if (r106 != null) goto L17;
        r100.bindNull(5);
    L18:
        String r107 = r102.f496982f;
        if (r107 != null) goto L21;
        r100.bindNull(6);
    L22:
        String r108 = r102.f496983g;
        if (r108 != null) goto L25;
        r100.bindNull(7);
    L26:
        String r109 = r102.f496984h;
        if (r109 != null) goto L29;
        r100.bindNull(8);
    L30:
        String r110 = r102.f496985i;
        if (r110 != null) goto L33;
        r100.bindNull(9);
    L34:
        String r111 = r102.f496986j;
        if (r111 != null) goto L37;
        r100.bindNull(10);
    L38:
        r100.bindLong(11, r102.f496987k);
        r100.bindLong(12, r102.f496988l);
        String r112 = r102.f496989m;
        if (r112 != null) goto L41;
        r100.bindNull(13);
    L42:
        r100.bindLong(14, r102.f496990n);
        String r113 = r102.f496991o;
        if (r113 != null) goto L45;
        r100.bindNull(15);
    L46:
        r100.bindLong(16, r102.f496992p ? 1 : 0);
        return;
    L45:
        r100.bindString(15, r113);
        goto L46
    L41:
        r100.bindString(13, r112);
        goto L42
    L37:
        r100.bindString(10, r111);
        goto L38
    L33:
        r100.bindString(9, r110);
        goto L34
    L29:
        r100.bindString(8, r109);
        goto L30
    L25:
        r100.bindString(7, r108);
        goto L26
    L21:
        r100.bindString(6, r107);
        goto L22
    L17:
        r100.bindString(5, r106);
        goto L18
    L13:
        r100.bindString(4, r105);
        goto L14
    L9:
        r100.bindString(3, r104);
        goto L10
    L5:
        r100.bindString(2, r103);
        goto L6
    }
}
