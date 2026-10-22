package com.bytedance.ee.bear.list.cache.migration;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.HashMap;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Migration40_41 extends Migration {
    public Migration40_41() {
        super(40, 41);
    }

    public final void a(Cursor r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.isClosed() == true) goto L8;
        r2.close();
        return;
    }

    public final void b(SupportSQLiteDatabase r58) {
        HashMap r1 = new HashMap();
        Cursor r2 = r58.query("select * from ManualOfflineDoc");
        String r8 = "thumbnail_secret";
        String r10 = "create_tenant_id";
        String r11 = "extra";
        String r12 = "create_time";
        String r0 = "edit_time";
        String r7 = ResourceData.KEY_URL;
        HashMap r16 = r1;
        String r3 = ResourceData.KEY_TYPE;
        String r17 = "document_icon_type";
        String r4 = "name";
        String r18 = "document_icon_key";
        String r5 = "thumbnail";
        String r19 = "thumbnail_type";
        String r6 = ResourceData.KEY_OBJ_TOKEN;
        String r21 = "thumbnail_nonce";
        if (r2 != null) goto L5;
    L30:
        String r24 = "name";
        String r9 = "thumbnail";
        String r13 = "extra";
        String r14 = ResourceData.KEY_TYPE;
        String r15 = ResourceData.KEY_URL;
        String r20 = "create_time";
        HashMap r22 = r16;
        String r110 = "thumbnail_secret";
        SupportSQLiteDatabase r23 = r58;
        String r25 = "edit_time";
    L31:
        a(r2);
        r23.execSQL("DROP TABLE IF EXISTS `ManualOfflineDoc`");
        Cursor r26 = r23.query("select * from OfflineOperateDoc");
        String r27 = "thumbnail_url";
        String r28 = "edit_uid";
        if (r26 != null) goto L34;
    L52:
        String r29 = "create_tenant_id";
        String r36 = r15;
        String r111 = r24;
        HashMap r210 = r22;
        String r30 = r25;
        SupportSQLiteDatabase r112 = r23;
    L53:
        a(r26);
        r112.execSQL("DROP TABLE IF EXISTS `OfflineOperateDoc`");
        Cursor r31 = r112.query("select * from PinedDoc");
        if (r31 != null) goto L56;
    L77:
        String r38 = r30;
        Cursor r45 = r31;
        String r32 = r13;
        String r43 = r20;
        String r33 = "edit_uid";
        String r34 = r17;
        String r35 = r18;
        String r51 = r21;
        String r37 = r29;
        String r113 = r9;
        String r211 = r110;
    L78:
        r112.execSQL("DROP TABLE IF EXISTS `PinedDoc`");
        a(r45);
        Cursor r39 = r112.query("select * from RecentDoc");
        if (r39 != null) goto L81;
    L102:
        Cursor r56 = r39;
        SupportSQLiteDatabase r40 = r112;
    L103:
        r40.execSQL("DROP TABLE IF EXISTS `RecentDoc`");
        a(r56);
        Cursor r41 = r40.query("select * from StatusDoc");
        if (r41 != null) goto L106;
    L114:
        r40.execSQL("DROP TABLE IF EXISTS `StatusDoc`");
        a(r41);
        r40.execSQL("DROP TABLE IF EXISTS `MineDoc`");
        r40.execSQL("DROP TABLE IF EXISTS `PersonalDoc`");
        r40.execSQL("DROP TABLE IF EXISTS `ShareDoc`");
        r40.execSQL("DROP TABLE IF EXISTS `StarDoc`");
        r40.execSQL("DROP TABLE IF EXISTS `TrashDoc`");
        r40.execSQL("DROP TABLE IF EXISTS `RecentPull`");
        return;
    L106:
        if (r41.moveToFirst() == false) goto L114;
    L107:
        String r42 = r41.getString(r41.getColumnIndex("doc_token"));
        int r44 = r41.getInt(r41.getColumnIndex("doc_cache_status"));
        ContentValues r46 = new ContentValues();
        r46.put(r6, r42);
        r46.put("doc_cache_status", Integer.valueOf(r44));
        String r114 = r6;
        if (r58.update("DocMetaInfo", 5, r46, "obj_token=?", new String[]{r42}) > 0) goto L111;
        r40.insert("DocMetaInfo", 4, r46);
    L111:
        if (r41.moveToNext() == false) goto L114;
        r6 = r114;
        goto L107
    L81:
        if (r39.moveToFirst() == false) goto L102;
    L82:
        String r47 = r39.getString(r39.getColumnIndex(r6));
        r39.getString(r39.getColumnIndex("userid"));
        r39.getString(r39.getColumnIndex("filepath"));
        String r48 = r39.getString(r39.getColumnIndex(r111));
        String r115 = r39.getString(r39.getColumnIndex(r14));
        String r212 = r14;
        String r49 = r39.getString(r39.getColumnIndex("owner_id"));
        String r50 = r39.getString(r39.getColumnIndex(r37));
        String r213 = r37;
        String r52 = r39.getString(r39.getColumnIndex("creator_cn_name"));
        String r53 = r39.getString(r39.getColumnIndex("creator_en_name"));
        String r54 = r39.getString(r39.getColumnIndex(r33));
        String r214 = r33;
        String r55 = r39.getString(r39.getColumnIndex(r38));
        String r57 = r39.getString(r39.getColumnIndex(r36));
        String r59 = r39.getString(r39.getColumnIndex("fake_token"));
        if (r39.getInt(r39.getColumnIndex("is_external")) != 1) goto L85;
        boolean r60 = true;
    L86:
        boolean r310 = r60;
        if (r39.getInt(r39.getColumnIndex("is_star")) != 1) goto L89;
        boolean r61 = true;
    L90:
        boolean r311 = r61;
        if (r39.getInt(r39.getColumnIndex("is_pine")) != 1) goto L93;
        boolean r62 = true;
    L94:
        String r63 = r39.getString(r39.getColumnIndex("open_time"));
        String r64 = r39.getString(r39.getColumnIndex("subtype"));
        String r65 = r39.getString(r39.getColumnIndex(r32));
        String r410 = r32;
        String r66 = r39.getString(r39.getColumnIndex("icon_url"));
        String r67 = r39.getString(r39.getColumnIndex("icon_key"));
        String r68 = r39.getString(r39.getColumnIndex("icon_nonce"));
        int r69 = r39.getInt(r39.getColumnIndex("icon_encrypted_type"));
        String r70 = r39.getString(r39.getColumnIndex(r113));
        String r411 = r113;
        String r116 = r39.getString(r39.getColumnIndex(r43));
        String r71 = r39.getString(r39.getColumnIndex("my_edit_time"));
        String r72 = r39.getString(r39.getColumnIndex("activity_time"));
        if (r39.getInt(r39.getColumnIndex("copiable")) != 1) goto L97;
        boolean r215 = true;
    L98:
        String r73 = r39.getString(r39.getColumnIndex(r27));
        String r74 = r211;
        String r216 = r27;
        String r117 = r39.getString(r39.getColumnIndex(r74));
        String r75 = r51;
        String r118 = r39.getString(r39.getColumnIndex(r75));
        String r76 = r19;
        int r119 = r39.getInt(r39.getColumnIndex(r76));
        String r77 = r39.getString(r39.getColumnIndex(r35));
        int r78 = r39.getInt(r39.getColumnIndex(r34));
        String r510 = r34;
        String r79 = r39.getString(r39.getColumnIndex("document_icon_fsunit"));
        r56 = r39;
        ContentValues r80 = new ContentValues();
        r80.put(r6, r47);
        r80.put(r111, r48);
        r80.put(r212, r115);
        r80.put("owner_id", r49);
        r80.put(r213, r50);
        r80.put("creator_cn_name", r52);
        r80.put("creator_en_name", r53);
        r80.put(r214, r54);
        r80.put(r38, r55);
        r80.put(r36, r57);
        r80.put("fake_token", r59);
        r80.put("is_stared", Boolean.valueOf(r311));
        r80.put("is_pined", Boolean.valueOf(r62));
        r80.put("extra_icon_url", r66);
        r80.put("extra_icon_key", r67);
        r80.put("extra_icon_nonce", r68);
        r80.put("extra_icon_encrypted_type", Integer.valueOf(r69));
        r80.put(r411, r70);
        r80.put("extra_copiable", Boolean.valueOf(r215));
        r80.put("extra_is_external", Boolean.valueOf(r310));
        r80.put("extra_sub_type", r64);
        r80.put(r43, r116);
        r80.put(r216, r73);
        r27 = r216;
        r80.put(r74, r117);
        r211 = r74;
        r80.put(r75, r118);
        r80.put(r76, Integer.valueOf(r119));
        r51 = r75;
        r80.put("size", (String) r210.get(r47));
        r80.put(r411, r70);
        r80.put(r35, r77);
        r80.put(r510, Integer.valueOf(r78));
        r80.put("document_icon_fsunit", r79);
        r40 = r58;
        r40.insert("DocMetaInfo", 5, r80);
        ContentValues r81 = new ContentValues();
        r81.put(r6, r47);
        r81.put("list_type", 1);
        r81.put(r410, r65);
        r81.put("open_time_recent", r63);
        r81.put("my_edit_time_recent", r71);
        r81.put("activity_time_recent", r72);
        r40.insert("ListTypes", 5, r81);
        if (r56.moveToNext() == false) goto L103;
        r37 = r213;
        r19 = r76;
        r33 = r214;
        r39 = r56;
        r113 = r411;
        r32 = r410;
        r34 = r510;
        r14 = r212;
        goto L82
    L97:
        r215 = false;
        goto L98
    L93:
        r62 = false;
        goto L94
    L89:
        r61 = false;
        goto L90
    L85:
        r60 = false;
        goto L86
    L56:
        if (r31.moveToFirst() == false) goto L77;
    L57:
        String r82 = r31.getString(r31.getColumnIndex(r6));
        r31.getString(r31.getColumnIndex("user_id"));
        String r83 = r31.getString(r31.getColumnIndex(r111));
        String r120 = r31.getString(r31.getColumnIndex(r14));
        if (r31.getInt(r31.getColumnIndex("is_pined")) != 1) goto L60;
        boolean r84 = true;
    L61:
        String r121 = r31.getString(r31.getColumnIndex(r28));
        boolean r217 = r84;
        String r85 = r31.getString(r31.getColumnIndex(r30));
        String r86 = r31.getString(r31.getColumnIndex("owner_id"));
        r38 = r30;
        String r87 = r31.getString(r31.getColumnIndex("creator_en_name"));
        String r218 = r28;
        String r88 = r31.getString(r31.getColumnIndex("creator_cn_name"));
        String r122 = r31.getString(r31.getColumnIndex(r20));
        r43 = r20;
        String r89 = r31.getString(r31.getColumnIndex("tenant_id"));
        String r123 = r31.getString(r31.getColumnIndex("space_id"));
        String r124 = r31.getString(r31.getColumnIndex("share_root"));
        if (r31.getInt(r31.getColumnIndex("is_stared")) != 1) goto L64;
        boolean r125 = true;
    L65:
        boolean r312 = r125;
        if (r31.getInt(r31.getColumnIndex("is_external")) != 1) goto L68;
        boolean r313 = true;
    L69:
        String r90 = r31.getString(r31.getColumnIndex(r9));
        String r412 = r9;
        String r126 = r31.getString(r31.getColumnIndex(r36));
        String r91 = r31.getString(r31.getColumnIndex("subtype"));
        String r92 = r31.getString(r31.getColumnIndex(r13));
        String r413 = r13;
        if (r31.getInt(r31.getColumnIndex("copiable")) != 1) goto L72;
        boolean r93 = true;
    L73:
        int r94 = r31.getInt(r31.getColumnIndex("share_version"));
        String r95 = r27;
        boolean r219 = r93;
        String r96 = r31.getString(r31.getColumnIndex(r95));
        String r97 = r110;
        String r98 = r31.getString(r31.getColumnIndex(r97));
        String r99 = r21;
        String r100 = r31.getString(r31.getColumnIndex(r99));
        r51 = r99;
        String r101 = r19;
        int r102 = r31.getInt(r31.getColumnIndex(r101));
        String r103 = r18;
        String r104 = r31.getString(r31.getColumnIndex(r103));
        String r105 = r17;
        int r106 = r31.getInt(r31.getColumnIndex(r105));
        String r107 = r31.getString(r31.getColumnIndex("document_icon_fsunit"));
        r45 = r31;
        ContentValues r108 = new ContentValues();
        r108.put(r6, r82);
        r108.put(r111, r83);
        r108.put(r14, r120);
        r108.put("owner_id", r86);
        r37 = r29;
        r108.put(r37, r89);
        r108.put("creator_cn_name", r88);
        r108.put("creator_en_name", r87);
        r33 = r218;
        r108.put(r33, r121);
        r108.put(r38, r85);
        r108.put(r36, r126);
        r108.put("is_stared", Boolean.valueOf(r312));
        r108.put("is_pined", Boolean.valueOf(r217));
        r113 = r412;
        r108.put(r113, r90);
        r108.put("extra_copiable", Boolean.valueOf(r219));
        r108.put("extra_is_external", Boolean.valueOf(r313));
        r108.put("extra_sub_type", r91);
        r108.put(r43, r122);
        r108.put(r95, r96);
        r27 = r95;
        r108.put(r97, r98);
        r211 = r97;
        r108.put(r51, r100);
        r108.put(r101, Integer.valueOf(r102));
        r19 = r101;
        r108.put("size", (String) r210.get(r82));
        r108.put(r113, r90);
        r35 = r103;
        r108.put(r35, r104);
        r34 = r105;
        r108.put(r34, Integer.valueOf(r106));
        r108.put("document_icon_fsunit", r107);
        r108.put("share_version", Integer.valueOf(r94));
        r108.put("extra_is_share_root", r124);
        r112 = r58;
        r112.insert("DocMetaInfo", 5, r108);
        ContentValues r109 = new ContentValues();
        r109.put(r6, r82);
        r109.put("list_type", 5);
        r32 = r413;
        r109.put(r32, r92);
        r109.put("space_id", r123);
        r112.insert("ListTypes", 5, r109);
        if (r45.moveToNext() == false) goto L78;
        r29 = r37;
        r13 = r32;
        r17 = r34;
        r18 = r35;
        r9 = r113;
        r110 = r211;
        r30 = r38;
        r20 = r43;
        r31 = r45;
        r21 = r51;
        r28 = r33;
        goto L57
    L72:
        r93 = false;
        goto L73
    L68:
        r313 = false;
        goto L69
    L64:
        r125 = false;
        goto L65
    L60:
        r84 = false;
        goto L61
    L34:
        if (r26.moveToFirst() == false) goto L52;
    L36:
        String r127 = r26.getString(r26.getColumnIndex("fakeToken"));
        if (r26.getInt(r26.getColumnIndex("needSync")) != 1) goto L39;
        boolean r128 = true;
    L40:
        String r129 = r26.getString(r26.getColumnIndex("filepath"));
        r111 = r24;
        r210 = r22;
        String r130 = r26.getString(r26.getColumnIndex(r111));
        boolean r220 = r128;
        String r131 = r26.getString(r26.getColumnIndex(ResourceData.KEY_TOKEN));
        String r132 = r26.getString(r26.getColumnIndex(r14));
        String r133 = r26.getString(r26.getColumnIndex("owner_id"));
        String r134 = r26.getString(r26.getColumnIndex(r10));
        String r135 = r26.getString(r26.getColumnIndex(r20));
        String r136 = r26.getString(r26.getColumnIndex("creator_cn_name"));
        String r414 = r20;
        String r137 = r26.getString(r26.getColumnIndex("creator_en_name"));
        String r138 = r26.getString(r26.getColumnIndex("edit_uid"));
        String r139 = r26.getString(r26.getColumnIndex(r25));
        String r314 = r25;
        String r140 = r26.getString(r26.getColumnIndex(r6));
        String r141 = r26.getString(r26.getColumnIndex(r15));
        String r142 = r26.getString(r26.getColumnIndex("subtype"));
        String r315 = r15;
        if (r26.getInt(r26.getColumnIndex("offline_create")) != 1) goto L43;
        boolean r143 = true;
    L44:
        String r144 = r26.getString(r26.getColumnIndex(r13));
        if (TextUtils.isEmpty(r140) == false) goto L48;
        r140 = r127;
    L48:
        ContentValues r145 = new ContentValues();
        r145.put(r6, r140);
        r145.put(r111, r130);
        r145.put(r14, r132);
        r145.put("owner_id", r133);
        r145.put(r10, r134);
        r145.put("creator_cn_name", r136);
        r145.put("creator_en_name", r137);
        r145.put("edit_uid", r138);
        r30 = r314;
        r145.put(r30, r139);
        r145.put(r315, r141);
        r29 = r10;
        r145.put("fake_token", r127);
        r145.put("is_offline_create", Boolean.valueOf(r143));
        r145.put("extra_sub_type", r142);
        r145.put("need_sync", Boolean.valueOf(r220));
        r20 = r414;
        r145.put(r20, r135);
        r145.put("size", (String) r210.get(r140));
        r112 = r58;
        r36 = r315;
        r112.insert("DocMetaInfo", 5, r145);
        ContentValues r146 = new ContentValues();
        r146.put(r6, r140);
        r146.put("list_type", 9);
        r146.put(ResourceData.KEY_TOKEN, r131);
        r146.put(r13, r144);
        r146.put("file_path", r129);
        r112.insert("ListTypes", 5, r146);
        if (r26.moveToNext() == false) goto L50;
        r25 = r30;
        r22 = r210;
        r10 = r29;
        r15 = r36;
        r26 = r26;
        r24 = r111;
        goto L36
    L50:
        r26 = r26;
        goto L53
    L43:
        r143 = false;
        goto L44
    L39:
        r128 = false;
        goto L40
    L5:
        if (r2.moveToFirst() == false) goto L30;
    L6:
        String r147 = r2.getString(r2.getColumnIndex(r6));
        String r221 = r6;
        String r148 = r2.getString(r2.getColumnIndex(r4));
        r24 = r4;
        String r149 = r2.getString(r2.getColumnIndex("size"));
        String r150 = r2.getString(r2.getColumnIndex(r3));
        String r222 = r3;
        String r151 = r2.getString(r2.getColumnIndex("subType"));
        String r152 = r2.getString(r2.getColumnIndex("icon_url"));
        String r153 = r2.getString(r2.getColumnIndex("icon_key"));
        String r154 = r2.getString(r2.getColumnIndex("icon_nonce"));
        int r155 = r2.getInt(r2.getColumnIndex("icon_encrypted_type"));
        if (r2.getInt(r2.getColumnIndex("is_external")) != 1) goto L9;
        boolean r156 = true;
    L10:
        String r157 = r2.getString(r2.getColumnIndex(r7));
        boolean r316 = r156;
        String r158 = r2.getString(r2.getColumnIndex("add_time"));
        String r159 = r2.getString(r2.getColumnIndex(r0));
        String r317 = r7;
        if (r2.getInt(r2.getColumnIndex("copiable")) != 1) goto L13;
        boolean r160 = true;
    L14:
        String r161 = r2.getString(r2.getColumnIndex("owner_id"));
        boolean r318 = r160;
        String r162 = r2.getString(r2.getColumnIndex("create_tenant_id"));
        String r319 = r0;
        String r163 = r2.getString(r2.getColumnIndex("creator_cn_name"));
        String r164 = r2.getString(r2.getColumnIndex("creator_en_name"));
        String r165 = r2.getString(r2.getColumnIndex("open_time"));
        String r166 = r2.getString(r2.getColumnIndex(r12));
        String r167 = r2.getString(r2.getColumnIndex("fake_token"));
        String r415 = r12;
        if (r2.getInt(r2.getColumnIndex("is_star")) != 1) goto L17;
        boolean r168 = true;
    L18:
        boolean r416 = r168;
        if (r2.getInt(r2.getColumnIndex("is_top")) != 1) goto L21;
        boolean r169 = true;
    L22:
        String r170 = r2.getString(r2.getColumnIndex(r11));
        String r417 = r11;
        String r171 = r2.getString(r2.getColumnIndex(r5));
        String r418 = r5;
        if (r2.getInt(r2.getColumnIndex("is_need_wifi_download")) != 1) goto L25;
        boolean r172 = true;
    L26:
        String r173 = r2.getString(r2.getColumnIndex("thumbnail_url"));
        boolean r419 = r172;
        String r174 = r2.getString(r2.getColumnIndex(r8));
        String r175 = r21;
        String r223 = r8;
        String r176 = r2.getString(r2.getColumnIndex(r175));
        String r177 = r19;
        int r178 = r2.getInt(r2.getColumnIndex(r177));
        String r179 = r18;
        String r180 = r2.getString(r2.getColumnIndex(r179));
        String r181 = r17;
        int r182 = r2.getInt(r2.getColumnIndex(r181));
        String r183 = r2.getString(r2.getColumnIndex("document_icon_fsunit"));
        Cursor r511 = r2;
        ContentValues r184 = new ContentValues();
        r184.put(r221, r147);
        r184.put(r24, r148);
        r14 = r222;
        r184.put(r14, r150);
        r184.put("owner_id", r161);
        r184.put("create_tenant_id", r162);
        r184.put("creator_cn_name", r163);
        r184.put("creator_en_name", r164);
        r184.put(r319, r159);
        r184.put(r317, r157);
        r184.put("fake_token", r167);
        r184.put("is_stared", Boolean.valueOf(r416));
        r184.put("is_pined", Boolean.valueOf(r169));
        r184.put("extra_icon_url", r152);
        r184.put("extra_icon_key", r153);
        r184.put("extra_icon_nonce", r154);
        r184.put("extra_icon_encrypted_type", Integer.valueOf(r155));
        r9 = r418;
        r184.put(r9, r171);
        r184.put("extra_copiable", Boolean.valueOf(r318));
        r184.put("extra_is_external", Boolean.valueOf(r316));
        r184.put("extra_sub_type", r151);
        r20 = r415;
        r184.put(r20, r166);
        r184.put("thumbnail_url", r173);
        r184.put(r223, r174);
        r184.put(r175, r176);
        r184.put(r177, Integer.valueOf(r178));
        r19 = r177;
        r184.put("size", r149);
        r22 = r16;
        r22.put(r147, r149);
        r184.put(r9, r171);
        r184.put(r179, r180);
        r184.put(r181, Integer.valueOf(r182));
        r17 = r181;
        r184.put("document_icon_fsunit", r183);
        r23 = r58;
        r21 = r175;
        r18 = r179;
        r15 = r317;
        r23.insert("DocMetaInfo", 5, r184);
        ContentValues r185 = new ContentValues();
        r6 = r221;
        r185.put(r6, r147);
        r185.put("list_type", 7);
        r13 = r417;
        r185.put(r13, r170);
        r110 = r223;
        r185.put("add_time_manualoffline", r158);
        r185.put("open_time_recent", r165);
        r185.put("is_need_wifi_download", Boolean.valueOf(r419));
        r23.insert("ListTypes", 5, r185);
        if (r511.moveToNext() == false) goto L28;
        r12 = r20;
        r7 = r15;
        r8 = r110;
        r4 = r24;
        r2 = r511;
        r16 = r22;
        r3 = r14;
        r11 = r13;
        r5 = r9;
        r0 = r319;
        goto L6
    L28:
        r25 = r319;
        r2 = r511;
        goto L31
    L25:
        r172 = false;
        goto L26
    L21:
        r169 = false;
        goto L22
    L17:
        r168 = false;
        goto L18
    L13:
        r160 = false;
        goto L14
    L9:
        r156 = false;
        goto L10
    }

    public final void migrate(SupportSQLiteDatabase r3) {
        r3.execSQL("DROP TABLE IF EXISTS `ListTypes`");
        r3.execSQL("DROP TABLE IF EXISTS `DocMetaInfo`");
        r3.execSQL("CREATE TABLE IF NOT EXISTS `DocMetaInfo` (`obj_token` TEXT NOT NULL PRIMARY KEY, `name` TEXT, `type` TEXT, `owner_id` TEXT, `create_tenant_id` TEXT,`creator_cn_name` TEXT,`creator_en_name` TEXT,`edit_uid` TEXT,`edit_time` TEXT,`url` TEXT,`fake_token` TEXT,`is_stared` INTEGER NOT NULL DEFAULT 0,`is_pined` INTEGER NOT NULL DEFAULT 0,`extra_icon_url` TEXT,`extra_icon_key` TEXT,`extra_icon_nonce` TEXT,`extra_icon_encrypted_type` INTEGER NOT NULL DEFAULT 0,`extra_copiable` INTEGER NOT NULL DEFAULT 0,`extra_is_share_root` INTEGER NOT NULL DEFAULT 0,`extra_is_external` INTEGER NOT NULL DEFAULT 0,`extra_sub_type` TEXT,`is_visited` INTEGER NOT NULL DEFAULT 0,`create_time` TEXT,`thumbnail` TEXT,`thumbnail_url` TEXT,`thumbnail_secret` TEXT,`thumbnail_nonce` TEXT,`thumbnail_type` INTEGER NOT NULL DEFAULT 0,`permission` INTEGER NOT NULL DEFAULT 0,`share_time` TEXT,`share_version` INTEGER NOT NULL DEFAULT 0,`is_hidden` INTEGER NOT NULL DEFAULT 0,`need_sync` INTEGER NOT NULL DEFAULT 0,`size` TEXT,`document_icon_key` TEXT,`document_icon_type` INTEGER NOT NULL DEFAULT -1,`document_icon_fsunit` TEXT,`doc_cache_status` INTEGER NOT NULL DEFAULT 0,`is_offline_create` INTEGER NOT NULL DEFAULT 0)");
        r3.execSQL("CREATE INDEX IF NOT EXISTS index_obj_token ON DocMetaInfo(`obj_token`)");
        r3.execSQL("CREATE TABLE IF NOT EXISTS `ListTypes` (`obj_token` TEXT NOT NULL, `list_type` INTEGER NOT NULL DEFAULT 0, `file_path` TEXT NOT NULL DEFAULT '',`token` TEXT, `extra` TEXT, `space_id` TEXT,`add_time_manualoffline` TEXT,`is_need_wifi_download` INTEGER NOT NULL DEFAULT 0,`open_time_recent` TEXT,`my_edit_time_recent` TEXT,`activity_time_recent` TEXT,FOREIGN KEY(`obj_token`) REFERENCES DocMetaInfo(`obj_token`) ON UPDATE CASCADE,PRIMARY KEY(`obj_token`, `list_type`, `file_path`))");
        b(r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        a.f("Migration40_41", e, false);
    }
}
