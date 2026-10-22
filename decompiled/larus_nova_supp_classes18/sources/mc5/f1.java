package mc5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f1 extends EntityInsertionAdapter<c> {
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `FilterCache` (`list_type`,`filter_type`,`file_type`,`strategy`,`is_asc`,`obj_token`,`file_path`,`token`,`extra`,`space_id`,`add_time_manualoffline`,`is_need_wifi_download`,`open_time_recent`,`my_edit_time_recent`,`activity_time_recent`,`has_perm_folder`,`show_external_hint_folder`,`node_type_folder`,`shortcut_name_folder`,`shortcut_owner_cn_name`,`shortcut_owner_en_name`,`shortcut_obj_biz_type`,`shortcut_obj_node_token`,`is_hidden_share`,`share_time_share`,`sharer_en_name`,`sharer_cn_name`,`star_time_star`,`shortcut_thumbnail_url`,`shortcut_thumbnail_secret`,`shortcut_thumbnail_nonce`,`shortcut_thumbnail_type`,`shortcut_thumbnail`,`id`,`icon`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public f1(BearDatabase r1) {
        super(r1);
    }

    public final void bind(SupportSQLiteStatement r5, Object r6) {
        c r7 = (c) r6;
        r5.bindLong(1, r7.a);
        r5.bindLong(2, r7.b);
        String r0 = r7.c;
        if (r0 != null) goto L5;
        r5.bindNull(3);
    L6:
        r5.bindLong(4, r7.d);
        r5.bindLong(5, r7.e ? 1 : 0);
        String r1 = r7.f;
        if (r1 != null) goto L9;
        r5.bindNull(6);
    L10:
        String r2 = r7.g;
        if (r2 != null) goto L13;
        r5.bindNull(7);
    L14:
        String r3 = r7.h;
        if (r3 != null) goto L17;
        r5.bindNull(8);
    L18:
        String r4 = r7.i;
        if (r4 != null) goto L21;
        r5.bindNull(9);
    L22:
        String r8 = r7.j;
        if (r8 != null) goto L25;
        r5.bindNull(10);
    L26:
        String r9 = r7.k;
        if (r9 != null) goto L29;
        r5.bindNull(11);
    L30:
        r5.bindLong(12, r7.l ? 1 : 0);
        String r10 = r7.m;
        if (r10 != null) goto L33;
        r5.bindNull(13);
    L34:
        String r11 = r7.n;
        if (r11 != null) goto L37;
        r5.bindNull(14);
    L38:
        String r12 = r7.o;
        if (r12 != null) goto L41;
        r5.bindNull(15);
    L42:
        r5.bindLong(16, r7.p ? 1 : 0);
        r5.bindLong(17, r7.q ? 1 : 0);
        r5.bindLong(18, r7.r);
        String r13 = r7.s;
        if (r13 != null) goto L45;
        r5.bindNull(19);
    L46:
        String r14 = r7.t;
        if (r14 != null) goto L49;
        r5.bindNull(20);
    L50:
        String r15 = r7.u;
        if (r15 != null) goto L53;
        r5.bindNull(21);
    L54:
        r5.bindLong(22, r7.v);
        String r16 = r7.w;
        if (r16 != null) goto L57;
        r5.bindNull(23);
    L58:
        r5.bindLong(24, r7.x ? 1 : 0);
        String r17 = r7.y;
        if (r17 != null) goto L61;
        r5.bindNull(25);
    L62:
        String r18 = r7.z;
        if (r18 != null) goto L65;
        r5.bindNull(26);
    L66:
        String r19 = r7.A;
        if (r19 != null) goto L69;
        r5.bindNull(27);
    L70:
        String r20 = r7.B;
        if (r20 != null) goto L73;
        r5.bindNull(28);
    L74:
        String r21 = r7.C;
        if (r21 != null) goto L77;
        r5.bindNull(29);
    L78:
        String r22 = r7.D;
        if (r22 != null) goto L81;
        r5.bindNull(30);
    L82:
        String r23 = r7.E;
        if (r23 != null) goto L85;
        r5.bindNull(31);
    L86:
        r5.bindLong(32, r7.F);
        String r24 = r7.G;
        if (r24 != null) goto L89;
        r5.bindNull(33);
    L90:
        r5.bindLong(34, r7.H);
        String r25 = r7.I;
        if (r25 != null) goto L93;
        r5.bindNull(35);
        return;
    L93:
        r5.bindString(35, r25);
        return;
    L89:
        r5.bindString(33, r24);
        goto L90
    L85:
        r5.bindString(31, r23);
        goto L86
    L81:
        r5.bindString(30, r22);
        goto L82
    L77:
        r5.bindString(29, r21);
        goto L78
    L73:
        r5.bindString(28, r20);
        goto L74
    L69:
        r5.bindString(27, r19);
        goto L70
    L65:
        r5.bindString(26, r18);
        goto L66
    L61:
        r5.bindString(25, r17);
        goto L62
    L57:
        r5.bindString(23, r16);
        goto L58
    L53:
        r5.bindString(21, r15);
        goto L54
    L49:
        r5.bindString(20, r14);
        goto L50
    L45:
        r5.bindString(19, r13);
        goto L46
    L41:
        r5.bindString(15, r12);
        goto L42
    L37:
        r5.bindString(14, r11);
        goto L38
    L33:
        r5.bindString(13, r10);
        goto L34
    L29:
        r5.bindString(11, r9);
        goto L30
    L25:
        r5.bindString(10, r8);
        goto L26
    L21:
        r5.bindString(9, r4);
        goto L22
    L17:
        r5.bindString(8, r3);
        goto L18
    L13:
        r5.bindString(7, r2);
        goto L14
    L9:
        r5.bindString(6, r1);
        goto L10
    L5:
        r5.bindString(3, r0);
        goto L6
    }
}
