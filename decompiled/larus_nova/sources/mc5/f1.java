package mc5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class f1 extends EntityInsertionAdapter<c> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `FilterCache` (`list_type`,`filter_type`,`file_type`,`strategy`,`is_asc`,`obj_token`,`file_path`,`token`,`extra`,`space_id`,`add_time_manualoffline`,`is_need_wifi_download`,`open_time_recent`,`my_edit_time_recent`,`activity_time_recent`,`has_perm_folder`,`show_external_hint_folder`,`node_type_folder`,`shortcut_name_folder`,`shortcut_owner_cn_name`,`shortcut_owner_en_name`,`shortcut_obj_biz_type`,`shortcut_obj_node_token`,`is_hidden_share`,`share_time_share`,`sharer_en_name`,`sharer_cn_name`,`star_time_star`,`shortcut_thumbnail_url`,`shortcut_thumbnail_secret`,`shortcut_thumbnail_nonce`,`shortcut_thumbnail_type`,`shortcut_thumbnail`,`id`,`icon`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public f1(BearDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, c r101) {
        c r102 = r101;
        r100.bindLong(1, r102.f512944a);
        r100.bindLong(2, r102.f512945b);
        String r103 = r102.f512946c;
        if (r103 != null) goto L5;
        r100.bindNull(3);
    L6:
        r100.bindLong(4, r102.f512947d);
        r100.bindLong(5, r102.f512948e ? 1 : 0);
        String r104 = r102.f512949f;
        if (r104 != null) goto L9;
        r100.bindNull(6);
    L10:
        String r105 = r102.f512950g;
        if (r105 != null) goto L13;
        r100.bindNull(7);
    L14:
        String r106 = r102.f512951h;
        if (r106 != null) goto L17;
        r100.bindNull(8);
    L18:
        String r107 = r102.f512952i;
        if (r107 != null) goto L21;
        r100.bindNull(9);
    L22:
        String r108 = r102.f512953j;
        if (r108 != null) goto L25;
        r100.bindNull(10);
    L26:
        String r109 = r102.f512954k;
        if (r109 != null) goto L29;
        r100.bindNull(11);
    L30:
        r100.bindLong(12, r102.f512955l ? 1 : 0);
        String r110 = r102.f512956m;
        if (r110 != null) goto L33;
        r100.bindNull(13);
    L34:
        String r111 = r102.f512957n;
        if (r111 != null) goto L37;
        r100.bindNull(14);
    L38:
        String r112 = r102.f512958o;
        if (r112 != null) goto L41;
        r100.bindNull(15);
    L42:
        r100.bindLong(16, r102.f512959p ? 1 : 0);
        r100.bindLong(17, r102.f512960q ? 1 : 0);
        r100.bindLong(18, r102.f512961r);
        String r113 = r102.f512962s;
        if (r113 != null) goto L45;
        r100.bindNull(19);
    L46:
        String r114 = r102.f512963t;
        if (r114 != null) goto L49;
        r100.bindNull(20);
    L50:
        String r115 = r102.f512964u;
        if (r115 != null) goto L53;
        r100.bindNull(21);
    L54:
        r100.bindLong(22, r102.f512965v);
        String r116 = r102.f512966w;
        if (r116 != null) goto L57;
        r100.bindNull(23);
    L58:
        r100.bindLong(24, r102.f512967x ? 1 : 0);
        String r117 = r102.f512968y;
        if (r117 != null) goto L61;
        r100.bindNull(25);
    L62:
        String r118 = r102.f512969z;
        if (r118 != null) goto L65;
        r100.bindNull(26);
    L66:
        String r119 = r102.A;
        if (r119 != null) goto L69;
        r100.bindNull(27);
    L70:
        String r120 = r102.B;
        if (r120 != null) goto L73;
        r100.bindNull(28);
    L74:
        String r121 = r102.C;
        if (r121 != null) goto L77;
        r100.bindNull(29);
    L78:
        String r122 = r102.D;
        if (r122 != null) goto L81;
        r100.bindNull(30);
    L82:
        String r123 = r102.E;
        if (r123 != null) goto L85;
        r100.bindNull(31);
    L86:
        r100.bindLong(32, r102.F);
        String r124 = r102.G;
        if (r124 != null) goto L89;
        r100.bindNull(33);
    L90:
        r100.bindLong(34, r102.H);
        String r125 = r102.I;
        if (r125 != null) goto L93;
        r100.bindNull(35);
        return;
    L93:
        r100.bindString(35, r125);
        return;
    L89:
        r100.bindString(33, r124);
        goto L90
    L85:
        r100.bindString(31, r123);
        goto L86
    L81:
        r100.bindString(30, r122);
        goto L82
    L77:
        r100.bindString(29, r121);
        goto L78
    L73:
        r100.bindString(28, r120);
        goto L74
    L69:
        r100.bindString(27, r119);
        goto L70
    L65:
        r100.bindString(26, r118);
        goto L66
    L61:
        r100.bindString(25, r117);
        goto L62
    L57:
        r100.bindString(23, r116);
        goto L58
    L53:
        r100.bindString(21, r115);
        goto L54
    L49:
        r100.bindString(20, r114);
        goto L50
    L45:
        r100.bindString(19, r113);
        goto L46
    L41:
        r100.bindString(15, r112);
        goto L42
    L37:
        r100.bindString(14, r111);
        goto L38
    L33:
        r100.bindString(13, r110);
        goto L34
    L29:
        r100.bindString(11, r109);
        goto L30
    L25:
        r100.bindString(10, r108);
        goto L26
    L21:
        r100.bindString(9, r107);
        goto L22
    L17:
        r100.bindString(8, r106);
        goto L18
    L13:
        r100.bindString(7, r105);
        goto L14
    L9:
        r100.bindString(6, r104);
        goto L10
    L5:
        r100.bindString(3, r103);
        goto L6
    }
}
