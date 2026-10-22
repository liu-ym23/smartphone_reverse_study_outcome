package mc5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j0 extends EntityInsertionAdapter<b> {
    public final String createQuery() {
        return "INSERT OR IGNORE INTO `DocMetaInfo` (`obj_token`,`name`,`type`,`owner_id`,`create_tenant_id`,`creator_cn_name`,`creator_en_name`,`edit_uid`,`edit_time`,`url`,`fake_token`,`is_stared`,`is_pined`,`is_subscribed`,`extra_icon_url`,`extra_icon_key`,`extra_icon_nonce`,`extra_icon_encrypted_type`,`extra_copiable`,`extra_is_share_root`,`extra_is_external`,`extra_sub_type`,`obj_sub_type`,`is_visited`,`create_time`,`thumbnail_url`,`thumbnail_secret`,`thumbnail_nonce`,`thumbnail_type`,`permission`,`share_time`,`share_version`,`is_hidden`,`need_sync`,`size`,`thumbnail`,`document_icon_key`,`document_icon_type`,`document_icon_fsunit`,`app_id`,`doc_cache_status`,`is_offline_create`,`wiki_real_type`,`wiki_real_token`,`wiki_version`,`owner_type`,`is_share_folder`,`security_name`,`security_level`,`is_secret_key_delete`,`template_type`,`is_insert`,`organization_tag_value`,`wiki_extra`,`icon`,`file_risk_tag`,`is_wiki_home_page`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public j0(BearDatabase r1) {
        super(r1);
    }

    public final void bind(SupportSQLiteStatement r5, Object r6) {
        b r7 = (b) r6;
        String r0 = r7.a;
        if (r0 != null) goto L5;
        r5.bindNull(1);
    L6:
        String r1 = r7.b;
        if (r1 != null) goto L9;
        r5.bindNull(2);
    L11:
        if (r7.getType() != null) goto L13;
        r5.bindNull(3);
    L14:
        String r2 = r7.d;
        if (r2 != null) goto L17;
        r5.bindNull(4);
    L18:
        String r3 = r7.e;
        if (r3 != null) goto L21;
        r5.bindNull(5);
    L22:
        String r4 = r7.f;
        if (r4 != null) goto L25;
        r5.bindNull(6);
    L26:
        String r8 = r7.g;
        if (r8 != null) goto L29;
        r5.bindNull(7);
    L30:
        String r9 = r7.h;
        if (r9 != null) goto L33;
        r5.bindNull(8);
    L34:
        String r10 = r7.i;
        if (r10 != null) goto L37;
        r5.bindNull(9);
    L38:
        String r11 = r7.j;
        if (r11 != null) goto L41;
        r5.bindNull(10);
    L42:
        String r12 = r7.k;
        if (r12 != null) goto L45;
        r5.bindNull(11);
    L46:
        r5.bindLong(12, r7.l ? 1 : 0);
        r5.bindLong(13, r7.m ? 1 : 0);
        r5.bindLong(14, r7.n ? 1 : 0);
        String r13 = r7.o;
        if (r13 != null) goto L49;
        r5.bindNull(15);
    L50:
        String r14 = r7.p;
        if (r14 != null) goto L53;
        r5.bindNull(16);
    L54:
        String r15 = r7.q;
        if (r15 != null) goto L57;
        r5.bindNull(17);
    L58:
        r5.bindLong(18, r7.r);
        r5.bindLong(19, r7.s ? 1 : 0);
        r5.bindLong(20, r7.t ? 1 : 0);
        r5.bindLong(21, r7.u ? 1 : 0);
        String r16 = r7.v;
        if (r16 != null) goto L61;
        r5.bindNull(22);
    L62:
        r5.bindLong(23, r7.w);
        r5.bindLong(24, r7.x ? 1 : 0);
        String r17 = r7.y;
        if (r17 != null) goto L65;
        r5.bindNull(25);
    L66:
        String r18 = r7.z;
        if (r18 != null) goto L69;
        r5.bindNull(26);
    L70:
        String r19 = r7.A;
        if (r19 != null) goto L73;
        r5.bindNull(27);
    L74:
        String r20 = r7.B;
        if (r20 != null) goto L77;
        r5.bindNull(28);
    L78:
        r5.bindLong(29, r7.C);
        r5.bindLong(30, r7.D);
        String r21 = r7.E;
        if (r21 != null) goto L81;
        r5.bindNull(31);
    L82:
        r5.bindLong(32, r7.F);
        r5.bindLong(33, r7.G ? 1 : 0);
        r5.bindLong(34, r7.H ? 1 : 0);
        String r22 = r7.I;
        if (r22 != null) goto L85;
        r5.bindNull(35);
    L86:
        String r23 = r7.J;
        if (r23 != null) goto L89;
        r5.bindNull(36);
    L90:
        String r24 = r7.K;
        if (r24 != null) goto L93;
        r5.bindNull(37);
    L94:
        r5.bindLong(38, r7.L);
        String r25 = r7.M;
        if (r25 != null) goto L97;
        r5.bindNull(39);
    L98:
        String r26 = r7.N;
        if (r26 != null) goto L101;
        r5.bindNull(40);
    L102:
        r5.bindLong(41, r7.O);
        r5.bindLong(42, r7.P ? 1 : 0);
        r5.bindLong(43, r7.Q);
        String r27 = r7.R;
        if (r27 != null) goto L105;
        r5.bindNull(44);
    L106:
        String r28 = r7.S;
        if (r28 != null) goto L109;
        r5.bindNull(45);
    L110:
        r5.bindLong(46, r7.T);
        r5.bindLong(47, r7.U ? 1 : 0);
        String r29 = r7.V;
        if (r29 != null) goto L113;
        r5.bindNull(48);
    L114:
        r5.bindLong(49, r7.W);
        r5.bindLong(50, r7.X ? 1 : 0);
        r5.bindLong(51, r7.Y);
        r5.bindLong(52, r7.Z ? 1 : 0);
        String r30 = r7.a0;
        if (r30 != null) goto L117;
        r5.bindNull(53);
    L118:
        String r31 = r7.b0;
        if (r31 != null) goto L121;
        r5.bindNull(54);
    L122:
        String r32 = r7.c0;
        if (r32 != null) goto L125;
        r5.bindNull(55);
    L126:
        r5.bindLong(56, r7.d0 ? 1 : 0);
        r5.bindLong(57, r7.e0 ? 1 : 0);
        return;
    L125:
        r5.bindString(55, r32);
        goto L126
    L121:
        r5.bindString(54, r31);
        goto L122
    L117:
        r5.bindString(53, r30);
        goto L118
    L113:
        r5.bindString(48, r29);
        goto L114
    L109:
        r5.bindString(45, r28);
        goto L110
    L105:
        r5.bindString(44, r27);
        goto L106
    L101:
        r5.bindString(40, r26);
        goto L102
    L97:
        r5.bindString(39, r25);
        goto L98
    L93:
        r5.bindString(37, r24);
        goto L94
    L89:
        r5.bindString(36, r23);
        goto L90
    L85:
        r5.bindString(35, r22);
        goto L86
    L81:
        r5.bindString(31, r21);
        goto L82
    L77:
        r5.bindString(28, r20);
        goto L78
    L73:
        r5.bindString(27, r19);
        goto L74
    L69:
        r5.bindString(26, r18);
        goto L70
    L65:
        r5.bindString(25, r17);
        goto L66
    L61:
        r5.bindString(22, r16);
        goto L62
    L57:
        r5.bindString(17, r15);
        goto L58
    L53:
        r5.bindString(16, r14);
        goto L54
    L49:
        r5.bindString(15, r13);
        goto L50
    L45:
        r5.bindString(11, r12);
        goto L46
    L41:
        r5.bindString(10, r11);
        goto L42
    L37:
        r5.bindString(9, r10);
        goto L38
    L33:
        r5.bindString(8, r9);
        goto L34
    L29:
        r5.bindString(7, r8);
        goto L30
    L25:
        r5.bindString(6, r4);
        goto L26
    L21:
        r5.bindString(5, r3);
        goto L22
    L17:
        r5.bindString(4, r2);
        goto L18
    L13:
        r5.bindString(3, r7.getType());
        goto L14
    L9:
        r5.bindString(2, r1);
        goto L11
    L5:
        r5.bindString(1, r0);
        goto L6
    }
}
