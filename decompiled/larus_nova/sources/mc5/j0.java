package mc5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;

/* JADX INFO: loaded from: classes18.dex */
public final class j0 extends EntityInsertionAdapter<b> {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR IGNORE INTO `DocMetaInfo` (`obj_token`,`name`,`type`,`owner_id`,`create_tenant_id`,`creator_cn_name`,`creator_en_name`,`edit_uid`,`edit_time`,`url`,`fake_token`,`is_stared`,`is_pined`,`is_subscribed`,`extra_icon_url`,`extra_icon_key`,`extra_icon_nonce`,`extra_icon_encrypted_type`,`extra_copiable`,`extra_is_share_root`,`extra_is_external`,`extra_sub_type`,`obj_sub_type`,`is_visited`,`create_time`,`thumbnail_url`,`thumbnail_secret`,`thumbnail_nonce`,`thumbnail_type`,`permission`,`share_time`,`share_version`,`is_hidden`,`need_sync`,`size`,`thumbnail`,`document_icon_key`,`document_icon_type`,`document_icon_fsunit`,`app_id`,`doc_cache_status`,`is_offline_create`,`wiki_real_type`,`wiki_real_token`,`wiki_version`,`owner_type`,`is_share_folder`,`security_name`,`security_level`,`is_secret_key_delete`,`template_type`,`is_insert`,`organization_tag_value`,`wiki_extra`,`icon`,`file_risk_tag`,`is_wiki_home_page`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public j0(BearDatabase r100) {
        super(r100);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, b r101) {
        b r102 = r101;
        String r103 = r102.f512887a;
        if (r103 != null) goto L5;
        r100.bindNull(1);
    L6:
        String r104 = r102.f512889b;
        if (r104 != null) goto L9;
        r100.bindNull(2);
    L11:
        if (r102.getType() != null) goto L13;
        r100.bindNull(3);
    L14:
        String r105 = r102.f512893d;
        if (r105 != null) goto L17;
        r100.bindNull(4);
    L18:
        String r106 = r102.f512895e;
        if (r106 != null) goto L21;
        r100.bindNull(5);
    L22:
        String r107 = r102.f512897f;
        if (r107 != null) goto L25;
        r100.bindNull(6);
    L26:
        String r108 = r102.f512899g;
        if (r108 != null) goto L29;
        r100.bindNull(7);
    L30:
        String r109 = r102.f512900h;
        if (r109 != null) goto L33;
        r100.bindNull(8);
    L34:
        String r110 = r102.f512901i;
        if (r110 != null) goto L37;
        r100.bindNull(9);
    L38:
        String r111 = r102.f512902j;
        if (r111 != null) goto L41;
        r100.bindNull(10);
    L42:
        String r112 = r102.f512903k;
        if (r112 != null) goto L45;
        r100.bindNull(11);
    L46:
        r100.bindLong(12, r102.f512904l ? 1 : 0);
        r100.bindLong(13, r102.f512905m ? 1 : 0);
        r100.bindLong(14, r102.f512906n ? 1 : 0);
        String r113 = r102.f512907o;
        if (r113 != null) goto L49;
        r100.bindNull(15);
    L50:
        String r114 = r102.f512908p;
        if (r114 != null) goto L53;
        r100.bindNull(16);
    L54:
        String r115 = r102.f512909q;
        if (r115 != null) goto L57;
        r100.bindNull(17);
    L58:
        r100.bindLong(18, r102.f512910r);
        r100.bindLong(19, r102.f512911s ? 1 : 0);
        r100.bindLong(20, r102.f512912t ? 1 : 0);
        r100.bindLong(21, r102.f512913u ? 1 : 0);
        String r116 = r102.f512914v;
        if (r116 != null) goto L61;
        r100.bindNull(22);
    L62:
        r100.bindLong(23, r102.f512915w);
        r100.bindLong(24, r102.f512916x ? 1 : 0);
        String r117 = r102.f512917y;
        if (r117 != null) goto L65;
        r100.bindNull(25);
    L66:
        String r118 = r102.f512918z;
        if (r118 != null) goto L69;
        r100.bindNull(26);
    L70:
        String r119 = r102.A;
        if (r119 != null) goto L73;
        r100.bindNull(27);
    L74:
        String r120 = r102.B;
        if (r120 != null) goto L77;
        r100.bindNull(28);
    L78:
        r100.bindLong(29, r102.C);
        r100.bindLong(30, r102.D);
        String r121 = r102.E;
        if (r121 != null) goto L81;
        r100.bindNull(31);
    L82:
        r100.bindLong(32, r102.F);
        r100.bindLong(33, r102.G ? 1 : 0);
        r100.bindLong(34, r102.H ? 1 : 0);
        String r122 = r102.I;
        if (r122 != null) goto L85;
        r100.bindNull(35);
    L86:
        String r123 = r102.f512886J;
        if (r123 != null) goto L89;
        r100.bindNull(36);
    L90:
        String r124 = r102.K;
        if (r124 != null) goto L93;
        r100.bindNull(37);
    L94:
        r100.bindLong(38, r102.L);
        String r125 = r102.M;
        if (r125 != null) goto L97;
        r100.bindNull(39);
    L98:
        String r126 = r102.N;
        if (r126 != null) goto L101;
        r100.bindNull(40);
    L102:
        r100.bindLong(41, r102.O);
        r100.bindLong(42, r102.P ? 1 : 0);
        r100.bindLong(43, r102.Q);
        String r127 = r102.R;
        if (r127 != null) goto L105;
        r100.bindNull(44);
    L106:
        String r128 = r102.S;
        if (r128 != null) goto L109;
        r100.bindNull(45);
    L110:
        r100.bindLong(46, r102.T);
        r100.bindLong(47, r102.U ? 1 : 0);
        String r129 = r102.V;
        if (r129 != null) goto L113;
        r100.bindNull(48);
    L114:
        r100.bindLong(49, r102.W);
        r100.bindLong(50, r102.X ? 1 : 0);
        r100.bindLong(51, r102.Y);
        r100.bindLong(52, r102.Z ? 1 : 0);
        String r130 = r102.f512888a0;
        if (r130 != null) goto L117;
        r100.bindNull(53);
    L118:
        String r131 = r102.f512890b0;
        if (r131 != null) goto L121;
        r100.bindNull(54);
    L122:
        String r132 = r102.f512892c0;
        if (r132 != null) goto L125;
        r100.bindNull(55);
    L126:
        r100.bindLong(56, r102.f512894d0 ? 1 : 0);
        r100.bindLong(57, r102.f512896e0 ? 1 : 0);
        return;
    L125:
        r100.bindString(55, r132);
        goto L126
    L121:
        r100.bindString(54, r131);
        goto L122
    L117:
        r100.bindString(53, r130);
        goto L118
    L113:
        r100.bindString(48, r129);
        goto L114
    L109:
        r100.bindString(45, r128);
        goto L110
    L105:
        r100.bindString(44, r127);
        goto L106
    L101:
        r100.bindString(40, r126);
        goto L102
    L97:
        r100.bindString(39, r125);
        goto L98
    L93:
        r100.bindString(37, r124);
        goto L94
    L89:
        r100.bindString(36, r123);
        goto L90
    L85:
        r100.bindString(35, r122);
        goto L86
    L81:
        r100.bindString(31, r121);
        goto L82
    L77:
        r100.bindString(28, r120);
        goto L78
    L73:
        r100.bindString(27, r119);
        goto L74
    L69:
        r100.bindString(26, r118);
        goto L70
    L65:
        r100.bindString(25, r117);
        goto L66
    L61:
        r100.bindString(22, r116);
        goto L62
    L57:
        r100.bindString(17, r115);
        goto L58
    L53:
        r100.bindString(16, r114);
        goto L54
    L49:
        r100.bindString(15, r113);
        goto L50
    L45:
        r100.bindString(11, r112);
        goto L46
    L41:
        r100.bindString(10, r111);
        goto L42
    L37:
        r100.bindString(9, r110);
        goto L38
    L33:
        r100.bindString(8, r109);
        goto L34
    L29:
        r100.bindString(7, r108);
        goto L30
    L25:
        r100.bindString(6, r107);
        goto L26
    L21:
        r100.bindString(5, r106);
        goto L22
    L17:
        r100.bindString(4, r105);
        goto L18
    L13:
        r100.bindString(3, r102.getType());
        goto L14
    L9:
        r100.bindString(2, r104);
        goto L11
    L5:
        r100.bindString(1, r103);
        goto L6
    }
}
