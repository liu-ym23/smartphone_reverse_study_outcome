package l79;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.larus.drive.biz.impl.database.DriveDatabase;

/* JADX INFO: loaded from: classes27.dex */
public final class d extends EntityInsertionAdapter<a> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `drive_list_mine` (`file_token`,`drive_token`,`order_index`,`file_name`,`file_url`,`open_time`,`edit_time`,`icon_info`,`file_type`,`is_owner`,`drive_obj_type`,`extra`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public d(DriveDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, a r101) {
        a r102 = r101;
        String r103 = r102.f507825a;
        if (r103 != null) goto L5;
        r100.bindNull(1);
    L6:
        String r104 = r102.f507826b;
        if (r104 != null) goto L9;
        r100.bindNull(2);
    L10:
        r100.bindLong(3, r102.f507827c);
        String r105 = r102.f507828d;
        if (r105 != null) goto L13;
        r100.bindNull(4);
    L14:
        String r106 = r102.f507829e;
        if (r106 != null) goto L17;
        r100.bindNull(5);
    L18:
        r100.bindLong(6, r102.f507830f);
        r100.bindLong(7, r102.f507831g);
        String r107 = r102.f507832h;
        if (r107 != null) goto L21;
        r100.bindNull(8);
    L22:
        String r108 = r102.f507833i;
        if (r108 != null) goto L25;
        r100.bindNull(9);
    L26:
        r100.bindLong(10, r102.f507834j);
        r100.bindLong(11, r102.f507835k);
        String r109 = r102.f507836l;
        if (r109 != null) goto L29;
        r100.bindNull(12);
        return;
    L29:
        r100.bindString(12, r109);
        return;
    L25:
        r100.bindString(9, r108);
        goto L26
    L21:
        r100.bindString(8, r107);
        goto L22
    L17:
        r100.bindString(5, r106);
        goto L18
    L13:
        r100.bindString(4, r105);
        goto L14
    L9:
        r100.bindString(2, r104);
        goto L10
    L5:
        r100.bindString(1, r103);
        goto L6
    }
}
