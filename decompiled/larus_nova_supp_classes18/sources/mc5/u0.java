package mc5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u0 extends EntityInsertionAdapter<v1> {
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `ListTypes` (`obj_token`,`list_type`,`token`,`extra`,`space_id`,`file_path`,`add_time_manualoffline`,`is_need_wifi_download`,`open_time_recent`,`my_edit_time_recent`,`activity_time_recent`,`has_perm_folder`,`show_external_hint_folder`,`node_type_folder`,`shortcut_name_folder`,`shortcut_owner_cn_name`,`shortcut_owner_en_name`,`shortcut_obj_biz_type`,`shortcut_obj_node_token`,`shortcut_obj_delete_flag`,`is_hidden_share`,`share_time_share`,`sharer_en_name`,`sharer_cn_name`,`star_time_star`,`shortcut_thumbnail_url`,`shortcut_thumbnail_secret`,`shortcut_thumbnail_nonce`,`shortcut_thumbnail_type`,`shortcut_thumbnail`,`subordinate_id`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public u0(BearDatabase r1) {
        super(r1);
    }

    public final void bind(SupportSQLiteStatement r5, Object r6) {
        v1 r7 = (v1) r6;
        String r0 = r7.a;
        if (r0 != null) goto L5;
        r5.bindNull(1);
    L6:
        r5.bindLong(2, r7.b);
        String r1 = r7.c;
        if (r1 != null) goto L9;
        r5.bindNull(3);
    L10:
        String r2 = r7.d;
        if (r2 != null) goto L13;
        r5.bindNull(4);
    L14:
        String r3 = r7.e;
        if (r3 != null) goto L17;
        r5.bindNull(5);
    L18:
        String r4 = r7.f;
        if (r4 != null) goto L21;
        r5.bindNull(6);
    L22:
        String r8 = r7.g;
        if (r8 != null) goto L25;
        r5.bindNull(7);
    L26:
        r5.bindLong(8, r7.h ? 1 : 0);
        String r9 = r7.i;
        if (r9 != null) goto L29;
        r5.bindNull(9);
    L30:
        String r10 = r7.j;
        if (r10 != null) goto L33;
        r5.bindNull(10);
    L34:
        String r11 = r7.k;
        if (r11 != null) goto L37;
        r5.bindNull(11);
    L38:
        r5.bindLong(12, r7.l ? 1 : 0);
        r5.bindLong(13, r7.m ? 1 : 0);
        r5.bindLong(14, r7.n);
        String r12 = r7.o;
        if (r12 != null) goto L41;
        r5.bindNull(15);
    L42:
        String r13 = r7.p;
        if (r13 != null) goto L45;
        r5.bindNull(16);
    L46:
        String r14 = r7.q;
        if (r14 != null) goto L49;
        r5.bindNull(17);
    L50:
        r5.bindLong(18, r7.r);
        String r15 = r7.s;
        if (r15 != null) goto L53;
        r5.bindNull(19);
    L54:
        r5.bindLong(20, r7.t);
        r5.bindLong(21, r7.u ? 1 : 0);
        String r16 = r7.v;
        if (r16 != null) goto L57;
        r5.bindNull(22);
    L58:
        String r17 = r7.w;
        if (r17 != null) goto L61;
        r5.bindNull(23);
    L62:
        String r18 = r7.x;
        if (r18 != null) goto L65;
        r5.bindNull(24);
    L66:
        String r19 = r7.y;
        if (r19 != null) goto L69;
        r5.bindNull(25);
    L70:
        String r20 = r7.z;
        if (r20 != null) goto L73;
        r5.bindNull(26);
    L74:
        String r21 = r7.A;
        if (r21 != null) goto L77;
        r5.bindNull(27);
    L78:
        String r22 = r7.B;
        if (r22 != null) goto L81;
        r5.bindNull(28);
    L82:
        r5.bindLong(29, r7.C);
        String r23 = r7.D;
        if (r23 != null) goto L85;
        r5.bindNull(30);
    L86:
        String r24 = r7.E;
        if (r24 != null) goto L89;
        r5.bindNull(31);
        return;
    L89:
        r5.bindString(31, r24);
        return;
    L85:
        r5.bindString(30, r23);
        goto L86
    L81:
        r5.bindString(28, r22);
        goto L82
    L77:
        r5.bindString(27, r21);
        goto L78
    L73:
        r5.bindString(26, r20);
        goto L74
    L69:
        r5.bindString(25, r19);
        goto L70
    L65:
        r5.bindString(24, r18);
        goto L66
    L61:
        r5.bindString(23, r17);
        goto L62
    L57:
        r5.bindString(22, r16);
        goto L58
    L53:
        r5.bindString(19, r15);
        goto L54
    L49:
        r5.bindString(17, r14);
        goto L50
    L45:
        r5.bindString(16, r13);
        goto L46
    L41:
        r5.bindString(15, r12);
        goto L42
    L37:
        r5.bindString(11, r11);
        goto L38
    L33:
        r5.bindString(10, r10);
        goto L34
    L29:
        r5.bindString(9, r9);
        goto L30
    L25:
        r5.bindString(7, r8);
        goto L26
    L21:
        r5.bindString(6, r4);
        goto L22
    L17:
        r5.bindString(5, r3);
        goto L18
    L13:
        r5.bindString(4, r2);
        goto L14
    L9:
        r5.bindString(3, r1);
        goto L10
    L5:
        r5.bindString(1, r0);
        goto L6
    }
}
