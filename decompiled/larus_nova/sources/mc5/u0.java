package mc5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class u0 extends EntityInsertionAdapter<v1> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `ListTypes` (`obj_token`,`list_type`,`token`,`extra`,`space_id`,`file_path`,`add_time_manualoffline`,`is_need_wifi_download`,`open_time_recent`,`my_edit_time_recent`,`activity_time_recent`,`has_perm_folder`,`show_external_hint_folder`,`node_type_folder`,`shortcut_name_folder`,`shortcut_owner_cn_name`,`shortcut_owner_en_name`,`shortcut_obj_biz_type`,`shortcut_obj_node_token`,`shortcut_obj_delete_flag`,`is_hidden_share`,`share_time_share`,`sharer_en_name`,`sharer_cn_name`,`star_time_star`,`shortcut_thumbnail_url`,`shortcut_thumbnail_secret`,`shortcut_thumbnail_nonce`,`shortcut_thumbnail_type`,`shortcut_thumbnail`,`subordinate_id`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public u0(BearDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, v1 r101) {
        v1 r102 = r101;
        String r103 = r102.f513185a;
        if (r103 != null) goto L5;
        r100.bindNull(1);
    L6:
        r100.bindLong(2, r102.f513186b);
        String r104 = r102.f513187c;
        if (r104 != null) goto L9;
        r100.bindNull(3);
    L10:
        String r105 = r102.f513188d;
        if (r105 != null) goto L13;
        r100.bindNull(4);
    L14:
        String r106 = r102.f513189e;
        if (r106 != null) goto L17;
        r100.bindNull(5);
    L18:
        String r107 = r102.f513190f;
        if (r107 != null) goto L21;
        r100.bindNull(6);
    L22:
        String r108 = r102.f513191g;
        if (r108 != null) goto L25;
        r100.bindNull(7);
    L26:
        r100.bindLong(8, r102.f513192h ? 1 : 0);
        String r109 = r102.f513193i;
        if (r109 != null) goto L29;
        r100.bindNull(9);
    L30:
        String r110 = r102.f513194j;
        if (r110 != null) goto L33;
        r100.bindNull(10);
    L34:
        String r111 = r102.f513195k;
        if (r111 != null) goto L37;
        r100.bindNull(11);
    L38:
        r100.bindLong(12, r102.f513196l ? 1 : 0);
        r100.bindLong(13, r102.f513197m ? 1 : 0);
        r100.bindLong(14, r102.f513198n);
        String r112 = r102.f513199o;
        if (r112 != null) goto L41;
        r100.bindNull(15);
    L42:
        String r113 = r102.f513200p;
        if (r113 != null) goto L45;
        r100.bindNull(16);
    L46:
        String r114 = r102.f513201q;
        if (r114 != null) goto L49;
        r100.bindNull(17);
    L50:
        r100.bindLong(18, r102.f513202r);
        String r115 = r102.f513203s;
        if (r115 != null) goto L53;
        r100.bindNull(19);
    L54:
        r100.bindLong(20, r102.f513204t);
        r100.bindLong(21, r102.f513205u ? 1 : 0);
        String r116 = r102.f513206v;
        if (r116 != null) goto L57;
        r100.bindNull(22);
    L58:
        String r117 = r102.f513207w;
        if (r117 != null) goto L61;
        r100.bindNull(23);
    L62:
        String r118 = r102.f513208x;
        if (r118 != null) goto L65;
        r100.bindNull(24);
    L66:
        String r119 = r102.f513209y;
        if (r119 != null) goto L69;
        r100.bindNull(25);
    L70:
        String r120 = r102.f513210z;
        if (r120 != null) goto L73;
        r100.bindNull(26);
    L74:
        String r121 = r102.A;
        if (r121 != null) goto L77;
        r100.bindNull(27);
    L78:
        String r122 = r102.B;
        if (r122 != null) goto L81;
        r100.bindNull(28);
    L82:
        r100.bindLong(29, r102.C);
        String r123 = r102.D;
        if (r123 != null) goto L85;
        r100.bindNull(30);
    L86:
        String r124 = r102.E;
        if (r124 != null) goto L89;
        r100.bindNull(31);
        return;
    L89:
        r100.bindString(31, r124);
        return;
    L85:
        r100.bindString(30, r123);
        goto L86
    L81:
        r100.bindString(28, r122);
        goto L82
    L77:
        r100.bindString(27, r121);
        goto L78
    L73:
        r100.bindString(26, r120);
        goto L74
    L69:
        r100.bindString(25, r119);
        goto L70
    L65:
        r100.bindString(24, r118);
        goto L66
    L61:
        r100.bindString(23, r117);
        goto L62
    L57:
        r100.bindString(22, r116);
        goto L58
    L53:
        r100.bindString(19, r115);
        goto L54
    L49:
        r100.bindString(17, r114);
        goto L50
    L45:
        r100.bindString(16, r113);
        goto L46
    L41:
        r100.bindString(15, r112);
        goto L42
    L37:
        r100.bindString(11, r111);
        goto L38
    L33:
        r100.bindString(10, r110);
        goto L34
    L29:
        r100.bindString(9, r109);
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
        r100.bindString(1, r103);
        goto L6
    }
}
