package mc5;

import android.database.Cursor;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j1 implements Callable<List<u1>> {
    public final /* synthetic */ RoomSQLiteQuery a;
    public final /* synthetic */ d1 b;

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public List<u1> call2() throws Exception {
        Cursor r2 = DBUtil.query(this.b.a, this.a, false, null);
        int r3 = CursorUtil.getColumnIndexOrThrow(r2, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L78
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "list_type");     // Catch: Throwable -> L78
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, ResourceData.KEY_TOKEN);     // Catch: Throwable -> L78
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "extra");     // Catch: Throwable -> L78
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "space_id");     // Catch: Throwable -> L78
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "file_path");     // Catch: Throwable -> L78
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "add_time_manualoffline");     // Catch: Throwable -> L78
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "is_need_wifi_download");     // Catch: Throwable -> L78
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "open_time_recent");     // Catch: Throwable -> L78
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "my_edit_time_recent");     // Catch: Throwable -> L78
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "activity_time_recent");     // Catch: Throwable -> L78
        int r15 = CursorUtil.getColumnIndexOrThrow(r2, "has_perm_folder");     // Catch: Throwable -> L78
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "show_external_hint_folder");     // Catch: Throwable -> L78
        int r16 = CursorUtil.getColumnIndexOrThrow(r2, "node_type_folder");     // Catch: Throwable -> L78
        int r17 = CursorUtil.getColumnIndexOrThrow(r2, "shortcut_name_folder");     // Catch: Throwable -> L78
        int r18 = CursorUtil.getColumnIndexOrThrow(r2, "shortcut_owner_cn_name");     // Catch: Throwable -> L78
        int r19 = CursorUtil.getColumnIndexOrThrow(r2, "shortcut_owner_en_name");     // Catch: Throwable -> L78
        int r20 = CursorUtil.getColumnIndexOrThrow(r2, "shortcut_obj_biz_type");     // Catch: Throwable -> L78
        int r21 = CursorUtil.getColumnIndexOrThrow(r2, "shortcut_obj_node_token");     // Catch: Throwable -> L78
        int r22 = CursorUtil.getColumnIndexOrThrow(r2, "shortcut_obj_delete_flag");     // Catch: Throwable -> L78
        int r23 = CursorUtil.getColumnIndexOrThrow(r2, "is_hidden_share");     // Catch: Throwable -> L78
        int r24 = CursorUtil.getColumnIndexOrThrow(r2, "share_time_share");     // Catch: Throwable -> L78
        int r25 = CursorUtil.getColumnIndexOrThrow(r2, "sharer_en_name");     // Catch: Throwable -> L78
        int r26 = CursorUtil.getColumnIndexOrThrow(r2, "sharer_cn_name");     // Catch: Throwable -> L78
        int r27 = CursorUtil.getColumnIndexOrThrow(r2, "star_time_star");     // Catch: Throwable -> L78
        int r28 = CursorUtil.getColumnIndexOrThrow(r2, "shortcut_thumbnail_url");     // Catch: Throwable -> L78
        int r29 = CursorUtil.getColumnIndexOrThrow(r2, "shortcut_thumbnail_secret");     // Catch: Throwable -> L78
        int r30 = CursorUtil.getColumnIndexOrThrow(r2, "shortcut_thumbnail_nonce");     // Catch: Throwable -> L78
        int r31 = CursorUtil.getColumnIndexOrThrow(r2, "shortcut_thumbnail_type");     // Catch: Throwable -> L78
        int r32 = CursorUtil.getColumnIndexOrThrow(r2, "shortcut_thumbnail");     // Catch: Throwable -> L78
        int r1 = CursorUtil.getColumnIndexOrThrow(r2, "subordinate_id");     // Catch: Throwable -> L78
        int r33 = CursorUtil.getColumnIndexOrThrow(r2, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L78
        int r34 = CursorUtil.getColumnIndexOrThrow(r2, "name");     // Catch: Throwable -> L78
        int r35 = CursorUtil.getColumnIndexOrThrow(r2, ResourceData.KEY_TYPE);     // Catch: Throwable -> L78
        int r36 = CursorUtil.getColumnIndexOrThrow(r2, "owner_id");     // Catch: Throwable -> L78
        int r37 = CursorUtil.getColumnIndexOrThrow(r2, "create_tenant_id");     // Catch: Throwable -> L78
        int r38 = CursorUtil.getColumnIndexOrThrow(r2, "creator_cn_name");     // Catch: Throwable -> L78
        int r39 = CursorUtil.getColumnIndexOrThrow(r2, "creator_en_name");     // Catch: Throwable -> L78
        int r40 = CursorUtil.getColumnIndexOrThrow(r2, "edit_uid");     // Catch: Throwable -> L78
        int r41 = CursorUtil.getColumnIndexOrThrow(r2, "edit_time");     // Catch: Throwable -> L78
        int r42 = CursorUtil.getColumnIndexOrThrow(r2, ResourceData.KEY_URL);     // Catch: Throwable -> L78
        int r43 = CursorUtil.getColumnIndexOrThrow(r2, "fake_token");     // Catch: Throwable -> L78
        int r44 = CursorUtil.getColumnIndexOrThrow(r2, "is_stared");     // Catch: Throwable -> L78
        int r45 = CursorUtil.getColumnIndexOrThrow(r2, "is_pined");     // Catch: Throwable -> L78
        int r46 = CursorUtil.getColumnIndexOrThrow(r2, "is_subscribed");     // Catch: Throwable -> L78
        int r47 = CursorUtil.getColumnIndexOrThrow(r2, "extra_icon_url");     // Catch: Throwable -> L78
        int r48 = CursorUtil.getColumnIndexOrThrow(r2, "extra_icon_key");     // Catch: Throwable -> L78
        int r49 = CursorUtil.getColumnIndexOrThrow(r2, "extra_icon_nonce");     // Catch: Throwable -> L78
        int r50 = CursorUtil.getColumnIndexOrThrow(r2, "extra_icon_encrypted_type");     // Catch: Throwable -> L78
        int r51 = CursorUtil.getColumnIndexOrThrow(r2, "extra_copiable");     // Catch: Throwable -> L78
        int r52 = CursorUtil.getColumnIndexOrThrow(r2, "extra_is_share_root");     // Catch: Throwable -> L78
        int r53 = CursorUtil.getColumnIndexOrThrow(r2, "extra_is_external");     // Catch: Throwable -> L78
        int r54 = CursorUtil.getColumnIndexOrThrow(r2, "extra_sub_type");     // Catch: Throwable -> L78
        int r55 = CursorUtil.getColumnIndexOrThrow(r2, "obj_sub_type");     // Catch: Throwable -> L78
        int r56 = CursorUtil.getColumnIndexOrThrow(r2, "is_visited");     // Catch: Throwable -> L78
        int r57 = CursorUtil.getColumnIndexOrThrow(r2, "create_time");     // Catch: Throwable -> L78
        int r58 = CursorUtil.getColumnIndexOrThrow(r2, "thumbnail_url");     // Catch: Throwable -> L78
        int r59 = CursorUtil.getColumnIndexOrThrow(r2, "thumbnail_secret");     // Catch: Throwable -> L78
        int r60 = CursorUtil.getColumnIndexOrThrow(r2, "thumbnail_nonce");     // Catch: Throwable -> L78
        int r61 = CursorUtil.getColumnIndexOrThrow(r2, "thumbnail_type");     // Catch: Throwable -> L78
        int r62 = CursorUtil.getColumnIndexOrThrow(r2, "permission");     // Catch: Throwable -> L78
        int r63 = CursorUtil.getColumnIndexOrThrow(r2, "share_version");     // Catch: Throwable -> L78
        int r64 = CursorUtil.getColumnIndexOrThrow(r2, "need_sync");     // Catch: Throwable -> L78
        int r65 = CursorUtil.getColumnIndexOrThrow(r2, "size");     // Catch: Throwable -> L78
        int r66 = CursorUtil.getColumnIndexOrThrow(r2, "thumbnail");     // Catch: Throwable -> L78
        int r67 = CursorUtil.getColumnIndexOrThrow(r2, "document_icon_key");     // Catch: Throwable -> L78
        int r68 = CursorUtil.getColumnIndexOrThrow(r2, "document_icon_type");     // Catch: Throwable -> L78
        int r69 = CursorUtil.getColumnIndexOrThrow(r2, "document_icon_fsunit");     // Catch: Throwable -> L78
        int r70 = CursorUtil.getColumnIndexOrThrow(r2, "app_id");     // Catch: Throwable -> L78
        int r71 = CursorUtil.getColumnIndexOrThrow(r2, "doc_cache_status");     // Catch: Throwable -> L78
        int r72 = CursorUtil.getColumnIndexOrThrow(r2, "is_offline_create");     // Catch: Throwable -> L78
        int r73 = CursorUtil.getColumnIndexOrThrow(r2, "wiki_real_type");     // Catch: Throwable -> L78
        int r74 = CursorUtil.getColumnIndexOrThrow(r2, "wiki_real_token");     // Catch: Throwable -> L78
        int r75 = CursorUtil.getColumnIndexOrThrow(r2, "wiki_version");     // Catch: Throwable -> L78
        int r76 = CursorUtil.getColumnIndexOrThrow(r2, "owner_type");     // Catch: Throwable -> L78
        int r77 = CursorUtil.getColumnIndexOrThrow(r2, "is_share_folder");     // Catch: Throwable -> L78
        int r78 = CursorUtil.getColumnIndexOrThrow(r2, "security_name");     // Catch: Throwable -> L78
        int r79 = CursorUtil.getColumnIndexOrThrow(r2, "security_level");     // Catch: Throwable -> L78
        int r80 = CursorUtil.getColumnIndexOrThrow(r2, "is_secret_key_delete");     // Catch: Throwable -> L78
        int r81 = CursorUtil.getColumnIndexOrThrow(r2, "template_type");     // Catch: Throwable -> L78
        int r82 = CursorUtil.getColumnIndexOrThrow(r2, "is_insert");     // Catch: Throwable -> L78
        int r83 = CursorUtil.getColumnIndexOrThrow(r2, "organization_tag_value");     // Catch: Throwable -> L78
        int r84 = CursorUtil.getColumnIndexOrThrow(r2, "wiki_extra");     // Catch: Throwable -> L78
        int r85 = CursorUtil.getColumnIndexOrThrow(r2, "icon");     // Catch: Throwable -> L78
        int r86 = CursorUtil.getColumnIndexOrThrow(r2, "file_risk_tag");     // Catch: Throwable -> L78
        int r87 = CursorUtil.getColumnIndexOrThrow(r2, "is_wiki_home_page");     // Catch: Throwable -> L78
        int r88 = r1;
        ArrayList r0 = new ArrayList(r2.getCount());     // Catch: Throwable -> L78
    L5:
        if (r2.moveToNext() == false) goto L76;
        u1 r89 = new u1();     // Catch: Throwable -> L78
        ArrayList r810 = r0;
        r89.a = r2.getString(r3);     // Catch: Throwable -> L78
        r2.getInt(r4);     // Catch: Throwable -> L78
        r89.X = r2.getString(r6);     // Catch: Throwable -> L78
        r89.Y = r2.getString(r7);     // Catch: Throwable -> L78
        r89.Z = r2.getString(r8);     // Catch: Throwable -> L78
        r89.a0 = r2.getString(r9);     // Catch: Throwable -> L78
        r89.b0 = r2.getString(r10);     // Catch: Throwable -> L78
        if (r2.getInt(r11) == 0) goto L9;
        boolean r90 = true;
    L10:
        r89.c0 = r90;     // Catch: Throwable -> L78
        r89.d0 = r2.getString(r12);     // Catch: Throwable -> L78
        r89.e0 = r2.getString(r13);     // Catch: Throwable -> L78
        r89.f0 = r2.getString(r14);     // Catch: Throwable -> L78
        if (r2.getInt(r15) == 0) goto L13;
        boolean r91 = true;
    L14:
        r89.g0 = r91;     // Catch: Throwable -> L78
        if (r2.getInt(r5) == 0) goto L17;
        boolean r92 = true;
    L18:
        r89.h0 = r92;     // Catch: Throwable -> L78
        int r93 = r16;
        int r110 = r3;
        r89.i0 = r2.getInt(r93);     // Catch: Throwable -> L78
        int r94 = r17;
        r89.j0 = r2.getString(r94);     // Catch: Throwable -> L78
        int r95 = r18;
        r89.k0 = r2.getString(r95);     // Catch: Throwable -> L78
        int r96 = r19;
        r89.l0 = r2.getString(r96);     // Catch: Throwable -> L78
        int r97 = r20;
        r89.m0 = r2.getInt(r97);     // Catch: Throwable -> L78
        int r98 = r21;
        r89.n0 = r2.getString(r98);     // Catch: Throwable -> L78
        int r99 = r22;
        r89.o0 = r2.getInt(r99);     // Catch: Throwable -> L78
        int r100 = r23;
        if (r2.getInt(r100) == 0) goto L21;
        boolean r101 = true;
    L22:
        r89.p0 = r101;     // Catch: Throwable -> L78
        int r102 = r24;
        r89.q0 = r2.getString(r102);     // Catch: Throwable -> L78
        int r103 = r25;
        r89.r0 = r2.getString(r103);     // Catch: Throwable -> L78
        int r104 = r26;
        r89.s0 = r2.getString(r104);     // Catch: Throwable -> L78
        int r105 = r27;
        r89.t0 = r2.getString(r105);     // Catch: Throwable -> L78
        int r106 = r28;
        r89.v0 = r2.getString(r106);     // Catch: Throwable -> L78
        int r107 = r29;
        r89.w0 = r2.getString(r107);     // Catch: Throwable -> L78
        int r108 = r30;
        r89.x0 = r2.getString(r108);     // Catch: Throwable -> L78
        int r109 = r31;
        r89.y0 = r2.getInt(r109);     // Catch: Throwable -> L78
        int r111 = r32;
        r89.z0 = r2.getString(r111);     // Catch: Throwable -> L78
        int r112 = r88;
        r2.getString(r112);     // Catch: Throwable -> L78
        int r113 = r33;
        r89.a = r2.getString(r113);     // Catch: Throwable -> L78
        int r114 = r34;
        r89.b = r2.getString(r114);     // Catch: Throwable -> L78
        int r115 = r35;
        r89.c = r2.getString(r115);     // Catch: Throwable -> L78
        int r116 = r36;
        r89.d = r2.getString(r116);     // Catch: Throwable -> L78
        int r117 = r37;
        r89.e = r2.getString(r117);     // Catch: Throwable -> L78
        int r118 = r38;
        r89.f = r2.getString(r118);     // Catch: Throwable -> L78
        int r119 = r39;
        r2.getString(r119);     // Catch: Throwable -> L78
        r39 = r119;
        int r120 = r40;
        r89.g = r2.getString(r120);     // Catch: Throwable -> L78
        int r121 = r41;
        r89.h = r2.getString(r121);     // Catch: Throwable -> L78
        int r122 = r42;
        r89.i = r2.getString(r122);     // Catch: Throwable -> L78
        int r123 = r43;
        r89.j = r2.getString(r123);     // Catch: Throwable -> L78
        r44 = r44;
        if (r2.getInt(r44) == 0) goto L25;
        boolean r124 = true;
    L26:
        r89.k = r124;     // Catch: Throwable -> L78
        r45 = r45;
        if (r2.getInt(r45) == 0) goto L29;
        boolean r125 = true;
    L30:
        r89.l = r125;     // Catch: Throwable -> L78
        r46 = r46;
        if (r2.getInt(r46) == 0) goto L33;
        boolean r126 = true;
    L34:
        r89.m = r126;     // Catch: Throwable -> L78
        int r127 = r47;
        r89.n = r2.getString(r127);     // Catch: Throwable -> L78
        int r128 = r48;
        r89.o = r2.getString(r128);     // Catch: Throwable -> L78
        int r129 = r49;
        r89.p = r2.getString(r129);     // Catch: Throwable -> L78
        int r130 = r50;
        r89.q = r2.getInt(r130);     // Catch: Throwable -> L78
        r51 = r51;
        if (r2.getInt(r51) == 0) goto L37;
        boolean r131 = true;
    L38:
        r89.r = r131;     // Catch: Throwable -> L78
        r52 = r52;
        if (r2.getInt(r52) == 0) goto L41;
        boolean r132 = true;
    L42:
        r89.s = r132;     // Catch: Throwable -> L78
        r53 = r53;
        if (r2.getInt(r53) == 0) goto L45;
        boolean r133 = true;
    L46:
        r89.t = r133;     // Catch: Throwable -> L78
        int r134 = r54;
        r89.u = r2.getString(r134);     // Catch: Throwable -> L78
        int r910 = r5;
        int r135 = r55;
        int r510 = r4;
        r89.v = r2.getLong(r135);     // Catch: Throwable -> L78
        int r136 = r56;
        if (r2.getInt(r136) == 0) goto L49;
        boolean r137 = true;
    L50:
        r89.w = r137;     // Catch: Throwable -> L78
        int r138 = r57;
        r89.x = r2.getString(r138);     // Catch: Throwable -> L78
        int r139 = r58;
        r89.y = r2.getString(r139);     // Catch: Throwable -> L78
        r58 = r139;
        int r140 = r59;
        r89.z = r2.getString(r140);     // Catch: Throwable -> L78
        r59 = r140;
        int r141 = r60;
        r89.A = r2.getString(r141);     // Catch: Throwable -> L78
        r60 = r141;
        int r142 = r61;
        r89.B = r2.getInt(r142);     // Catch: Throwable -> L78
        r61 = r142;
        int r143 = r62;
        r89.C = r2.getInt(r143);     // Catch: Throwable -> L78
        r62 = r143;
        int r144 = r63;
        r89.D = r2.getInt(r144);     // Catch: Throwable -> L78
        int r145 = r64;
        r2.getInt(r145);     // Catch: Throwable -> L78
        r64 = r145;
        r63 = r144;
        int r146 = r65;
        r89.E = r2.getString(r146);     // Catch: Throwable -> L78
        r65 = r146;
        int r147 = r66;
        r89.F = r2.getString(r147);     // Catch: Throwable -> L78
        r66 = r147;
        int r148 = r67;
        r89.G = r2.getString(r148);     // Catch: Throwable -> L78
        r67 = r148;
        int r149 = r68;
        r89.H = r2.getInt(r149);     // Catch: Throwable -> L78
        r68 = r149;
        int r150 = r69;
        r89.I = r2.getString(r150);     // Catch: Throwable -> L78
        r69 = r150;
        int r151 = r70;
        r89.J = r2.getString(r151);     // Catch: Throwable -> L78
        r70 = r151;
        r71 = r71;
        r89.K = r2.getInt(r71);     // Catch: Throwable -> L78
        int r152 = r72;
        if (r2.getInt(r152) == 0) goto L53;
        boolean r153 = true;
    L54:
        r89.L = r153;     // Catch: Throwable -> L78
        r72 = r152;
        int r154 = r73;
        r89.M = r2.getInt(r154);     // Catch: Throwable -> L78
        r73 = r154;
        int r155 = r74;
        r89.N = r2.getString(r155);     // Catch: Throwable -> L78
        r74 = r155;
        int r156 = r75;
        r89.O = r2.getString(r156);     // Catch: Throwable -> L78
        r75 = r156;
        int r157 = r76;
        r89.Q = r2.getInt(r157);     // Catch: Throwable -> L78
        int r158 = r77;
        r77 = r158;
        if (r2.getInt(r158) == 0) goto L57;
        boolean r159 = true;
    L58:
        r89.R = r159;     // Catch: Throwable -> L78
        r76 = r157;
        int r160 = r78;
        r89.S = r2.getString(r160);     // Catch: Throwable -> L78
        r78 = r160;
        int r161 = r79;
        r89.T = r2.getInt(r161);     // Catch: Throwable -> L78
        int r162 = r80;
        r80 = r162;
        if (r2.getInt(r162) == 0) goto L61;
        boolean r163 = true;
    L62:
        r89.U = r163;     // Catch: Throwable -> L78
        r79 = r161;
        r81 = r81;
        r89.V = r2.getInt(r81);     // Catch: Throwable -> L78
        int r164 = r82;
        if (r2.getInt(r164) == 0) goto L65;
        boolean r165 = true;
    L66:
        r89.W = r165;     // Catch: Throwable -> L78
        r82 = r164;
        int r166 = r83;
        r89.u0 = r2.getString(r166);     // Catch: Throwable -> L78
        r83 = r166;
        int r167 = r84;
        r89.P = r2.getString(r167);     // Catch: Throwable -> L78
        r84 = r167;
        r85 = r85;
        r89.A0 = r2.getString(r85);     // Catch: Throwable -> L78
        int r168 = r86;
        if (r2.getInt(r168) == 0) goto L69;
        boolean r169 = true;
    L70:
        r89.B0 = r169;     // Catch: Throwable -> L78
        int r170 = r87;
        r87 = r170;
        if (r2.getInt(r170) == 0) goto L73;
        boolean r171 = true;
    L74:
        r89.C0 = r171;     // Catch: Throwable -> L78
        r0 = r810;
        r0.add(r89);     // Catch: Throwable -> L78
        r86 = r168;
        r3 = r110;
        r16 = r93;
        r17 = r94;
        r18 = r95;
        r19 = r96;
        r20 = r97;
        r21 = r98;
        r22 = r99;
        r23 = r100;
        r24 = r102;
        r25 = r103;
        r26 = r104;
        r27 = r105;
        r28 = r106;
        r29 = r107;
        r30 = r108;
        r31 = r109;
        r32 = r111;
        r88 = r112;
        r33 = r113;
        r34 = r114;
        r35 = r115;
        r36 = r116;
        r37 = r117;
        r38 = r118;
        r40 = r120;
        r41 = r121;
        r42 = r122;
        r43 = r123;
        r47 = r127;
        r48 = r128;
        r49 = r129;
        r50 = r130;
        r54 = r134;
        r56 = r136;
        r4 = r510;
        r55 = r135;
        r57 = r138;
        r5 = r910;
        goto L5
    L73:
        r171 = false;
        goto L74
    L69:
        r169 = false;
        goto L70
    L65:
        r165 = false;
        goto L66
    L61:
        r163 = false;
        goto L62
    L57:
        r159 = false;
        goto L58
    L53:
        r153 = false;
        goto L54
    L49:
        r137 = false;
        goto L50
    L45:
        r133 = false;
        goto L46
    L41:
        r132 = false;
        goto L42
    L37:
        r131 = false;
        goto L38
    L33:
        r126 = false;
        goto L34
    L29:
        r125 = false;
        goto L30
    L25:
        r124 = false;
        goto L26
    L21:
        r101 = false;
        goto L22
    L17:
        r92 = false;
        goto L18
    L13:
        r91 = false;
        goto L14
    L9:
        r90 = false;
        goto L10
    L76:
        r2.close();
        return r0;
    L78:
        th = move-exception;
        r2.close();
        throw th;
    }

    public final void finalize() {
        this.a.release();
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ List<u1> call() throws Exception {
        return call2();
    }

    public j1(d1 r1, RoomSQLiteQuery r2) {
        this.b = r1;
        this.a = r2;
    }
}
