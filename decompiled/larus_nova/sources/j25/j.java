package j25;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.document.offline.offlinestorage.OfflineDatabase;

/* JADX INFO: loaded from: classes16.dex */
public final class j extends EntityInsertionAdapter<q> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `file_model` (`name`,`token`,`doc_url`,`path`,`uri`,`local_url`,`net_url`,`file_modified_time`,`new_upload_key`,`upload_key`) VALUES (?,?,?,?,?,?,?,?,?,?)";
    }

    public j(OfflineDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, q r101) {
        q r102 = r101;
        String r103 = r102.f497001a;
        if (r103 != null) goto L5;
        r100.bindNull(1);
    L6:
        String r104 = r102.f497002b;
        if (r104 != null) goto L9;
        r100.bindNull(2);
    L10:
        String r105 = r102.f497003c;
        if (r105 != null) goto L13;
        r100.bindNull(3);
    L14:
        String r106 = r102.f497004d;
        if (r106 != null) goto L17;
        r100.bindNull(4);
    L18:
        String r107 = r102.f497005e;
        if (r107 != null) goto L21;
        r100.bindNull(5);
    L22:
        String r108 = r102.f497006f;
        if (r108 != null) goto L25;
        r100.bindNull(6);
    L26:
        String r109 = r102.f497007g;
        if (r109 != null) goto L29;
        r100.bindNull(7);
    L30:
        Long r110 = r102.f497008h;
        if (r110 != null) goto L33;
        r100.bindNull(8);
    L34:
        String r111 = r102.f497009i;
        if (r111 != null) goto L37;
        r100.bindNull(9);
    L38:
        String r112 = r102.f497010j;
        if (r112 != null) goto L41;
        r100.bindNull(10);
        return;
    L41:
        r100.bindString(10, r112);
        return;
    L37:
        r100.bindString(9, r111);
        goto L38
    L33:
        r100.bindLong(8, r110.longValue());
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
