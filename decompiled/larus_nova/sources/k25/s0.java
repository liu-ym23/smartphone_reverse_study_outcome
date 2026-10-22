package k25;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.document.offline.offlinestorage.OfflineDatabase;

/* JADX INFO: loaded from: classes16.dex */
public final class s0 extends EntityInsertionAdapter<m0> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `ResourceData` (`id`,`reskey`,`resvalue`,`resvalue_filepath`,`update_time`,`access_time`,`isNeedSync`,`config`,`type`,`token`,`obj_token`,`userToken`,`tenantID`,`url`,`subblock_preload_status`,`page`,`total_page`,`batch_num`,`load_from`,`category`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public s0(OfflineDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, m0 r101) {
        m0 r102 = r101;
        r100.bindLong(1, r102.f501540a);
        String r103 = r102.f501541b;
        if (r103 != null) goto L5;
        r100.bindNull(2);
    L6:
        String r104 = r102.f501542c;
        if (r104 != null) goto L9;
        r100.bindNull(3);
    L10:
        String r105 = r102.f501543d;
        if (r105 != null) goto L13;
        r100.bindNull(4);
    L14:
        Long r106 = r102.f501544e;
        if (r106 != null) goto L17;
        r100.bindNull(5);
    L18:
        Long r107 = r102.f501545f;
        if (r107 != null) goto L21;
        r100.bindNull(6);
    L22:
        r100.bindLong(7, r102.f501546g ? 1 : 0);
        String r108 = r102.f501547h;
        if (r108 != null) goto L25;
        r100.bindNull(8);
    L27:
        if (r102.getType() != null) goto L29;
        r100.bindNull(9);
    L30:
        String r109 = r102.f501549j;
        if (r109 != null) goto L33;
        r100.bindNull(10);
    L34:
        String r110 = r102.f501550k;
        if (r110 != null) goto L37;
        r100.bindNull(11);
    L38:
        String r111 = r102.f501551l;
        if (r111 != null) goto L41;
        r100.bindNull(12);
    L42:
        String r112 = r102.f501552m;
        if (r112 != null) goto L45;
        r100.bindNull(13);
    L46:
        String r113 = r102.f501553n;
        if (r113 != null) goto L49;
        r100.bindNull(14);
    L50:
        r100.bindLong(15, r102.f501554o);
        r100.bindLong(16, r102.f501555p);
        r100.bindLong(17, r102.f501556q);
        String r114 = r102.f501557r;
        if (r114 != null) goto L53;
        r100.bindNull(18);
    L54:
        String r115 = r102.f501558s;
        if (r115 != null) goto L57;
        r100.bindNull(19);
    L58:
        String r116 = r102.f501559t;
        if (r116 != null) goto L61;
        r100.bindNull(20);
        return;
    L61:
        r100.bindString(20, r116);
        return;
    L57:
        r100.bindString(19, r115);
        goto L58
    L53:
        r100.bindString(18, r114);
        goto L54
    L49:
        r100.bindString(14, r113);
        goto L50
    L45:
        r100.bindString(13, r112);
        goto L46
    L41:
        r100.bindString(12, r111);
        goto L42
    L37:
        r100.bindString(11, r110);
        goto L38
    L33:
        r100.bindString(10, r109);
        goto L34
    L29:
        r100.bindString(9, r102.getType());
        goto L30
    L25:
        r100.bindString(8, r108);
        goto L27
    L21:
        r100.bindLong(6, r107.longValue());
        goto L22
    L17:
        r100.bindLong(5, r106.longValue());
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
