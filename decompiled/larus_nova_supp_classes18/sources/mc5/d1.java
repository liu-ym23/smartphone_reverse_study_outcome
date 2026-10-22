package mc5;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.list.cache.BearDatabase;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d1 implements n {
    public final h0 A;
    public final k0 B;
    public final l0 C;
    public final m0 D;
    public final n0 E;
    public final o0 F;
    public final p0 G;
    public final q0 H;
    public final r0 I;
    public final s0 J;
    public final t0 K;
    public final v0 L;
    public final w0 M;
    public final x0 N;
    public final y0 O;
    public final a1 P;
    public final b1 Q;
    public final c1 R;
    public final RoomDatabase a;
    public final y b;
    public final j0 c;
    public final u0 d;
    public final f1 e;
    public final p1 f;
    public final q1 g;
    public final r1 h;
    public final s1 i;
    public final t1 j;
    public final o k;
    public final p l;
    public final q m;
    public final r n;
    public final s o;
    public final t p;
    public final u q;
    public final w r;
    public final z s;
    public final a0 t;
    public final b0 u;
    public final c0 v;
    public final d0 w;
    public final e0 x;
    public final f0 y;
    public final g0 z;

    public class a implements Callable<List<u1>> {
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

        public a(d1 r1, RoomSQLiteQuery r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b implements Callable<List<u1>> {
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

        public b(d1 r1, RoomSQLiteQuery r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public final LiveData A() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ListTypes AS LT LEFT OUTER JOIN DocMetaInfo AS DMI ON LT.obj_token = DMI.obj_token WHERE LT.list_type = ? AND LT.file_path= ? ORDER BY CAST(DMI.edit_time AS INTEGER) DESC, LT.obj_token ASC LIMIT ?", 3);
        r0.bindLong(1, 3);
        r0.bindString(2, "");
        r0.bindLong(3, 20);
        return this.a.getInvalidationTracker().createLiveData(new String[]{"ListTypes", "DocMetaInfo"}, false, new i1(this, r0));
    }

    public final List<mc5.a> C() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM CacheStatus WHERE download_type != 0", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.a, r0, false, null);
        int r2 = CursorUtil.getColumnIndexOrThrow(r1, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L10
        int r3 = CursorUtil.getColumnIndexOrThrow(r1, "doc_cache_status");     // Catch: Throwable -> L10
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "status_manualoffline");     // Catch: Throwable -> L10
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "obj_type");     // Catch: Throwable -> L10
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "download_type");     // Catch: Throwable -> L10
        ArrayList r7 = new ArrayList(r1.getCount());     // Catch: Throwable -> L10
    L5:
        if (r1.moveToNext() == false) goto L8;
        mc5.a r8 = new mc5.a();     // Catch: Throwable -> L10
        r8.a = r1.getString(r2);     // Catch: Throwable -> L10
        r8.b = r1.getInt(r3);     // Catch: Throwable -> L10
        r8.c = r1.getInt(r4);     // Catch: Throwable -> L10
        r8.d = r1.getInt(r5);     // Catch: Throwable -> L10
        r8.e = r1.getInt(r6);     // Catch: Throwable -> L10
        r7.add(r8);     // Catch: Throwable -> L10
        goto L5
    L8:
        r1.close();
        r0.release();
        return r7;
    L10:
        th = move-exception;
        r1.close();
        r0.release();
        throw th;
    }

    public final List<mc5.a> D() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM CacheStatus WHERE status_manualoffline != 0", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.a, r0, false, null);
        int r2 = CursorUtil.getColumnIndexOrThrow(r1, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L10
        int r3 = CursorUtil.getColumnIndexOrThrow(r1, "doc_cache_status");     // Catch: Throwable -> L10
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "status_manualoffline");     // Catch: Throwable -> L10
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "obj_type");     // Catch: Throwable -> L10
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "download_type");     // Catch: Throwable -> L10
        ArrayList r7 = new ArrayList(r1.getCount());     // Catch: Throwable -> L10
    L5:
        if (r1.moveToNext() == false) goto L8;
        mc5.a r8 = new mc5.a();     // Catch: Throwable -> L10
        r8.a = r1.getString(r2);     // Catch: Throwable -> L10
        r8.b = r1.getInt(r3);     // Catch: Throwable -> L10
        r8.c = r1.getInt(r4);     // Catch: Throwable -> L10
        r8.d = r1.getInt(r5);     // Catch: Throwable -> L10
        r8.e = r1.getInt(r6);     // Catch: Throwable -> L10
        r7.add(r8);     // Catch: Throwable -> L10
        goto L5
    L8:
        r1.close();
        r0.release();
        return r7;
    L10:
        th = move-exception;
        r1.close();
        r0.release();
        throw th;
    }

    public final List H() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT obj_token FROM CacheStatus WHERE doc_cache_status =?", 1);
        r0.bindLong(1, 2);
        this.a.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.a, r0, false, null);
        ArrayList r3 = new ArrayList(r1.getCount());     // Catch: Throwable -> L10
    L5:
        if (r1.moveToNext() == false) goto L8;
        r3.add(r1.getString(0));     // Catch: Throwable -> L10
        goto L5
    L8:
        r1.close();
        r0.release();
        return r3;
    L10:
        th = move-exception;
        r1.close();
        r0.release();
        throw th;
    }

    public final List K() {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM TtsPlaybackBean ORDER BY create_time_ms DESC LIMIT ? OFFSET ?", 2);
        r3.bindLong(1, Integer.MAX_VALUE);
        r3.bindLong(2, 0);
        this.a.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.a, r3, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L14
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "obj_type");     // Catch: Throwable -> L14
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "title");     // Catch: Throwable -> L14
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "owner_name");     // Catch: Throwable -> L14
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "icon_info");     // Catch: Throwable -> L14
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "create_time_ms");     // Catch: Throwable -> L14
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "update_time_ms");     // Catch: Throwable -> L14
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "last_play_time_ms");     // Catch: Throwable -> L14
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "duration_ms");     // Catch: Throwable -> L14
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "progress_ms");     // Catch: Throwable -> L14
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "speed");     // Catch: Throwable -> L14
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "tone_id");     // Catch: Throwable -> L14
        int r15 = CursorUtil.getColumnIndexOrThrow(r2, "tone_name");     // Catch: Throwable -> L14
        RoomSQLiteQuery r16 = r3;
        ArrayList r1 = new ArrayList(r2.getCount());     // Catch: Throwable -> L12
    L7:
        if (r2.moveToNext() == false) goto L10;
        so5.a r17 = new so5.a();     // Catch: Throwable -> L12
        ArrayList r18 = r1;
        r17.a = r2.getString(r0);     // Catch: Throwable -> L12
        r17.b = r2.getInt(r4);     // Catch: Throwable -> L12
        r17.c = r2.getString(r5);     // Catch: Throwable -> L12
        r17.d = r2.getString(r6);     // Catch: Throwable -> L12
        r17.e = r2.getString(r7);     // Catch: Throwable -> L12
        int r19 = r0;
        r17.f = r2.getLong(r8);     // Catch: Throwable -> L12
        r17.g = r2.getLong(r9);     // Catch: Throwable -> L12
        r17.h = r2.getLong(r10);     // Catch: Throwable -> L12
        r17.i = r2.getLong(r11);     // Catch: Throwable -> L12
        r17.j = r2.getLong(r12);     // Catch: Throwable -> L12
        r17.k = r2.getFloat(r13);     // Catch: Throwable -> L12
        r17.l = r2.getString(r14);     // Catch: Throwable -> L12
        r17.m = r2.getString(r15);     // Catch: Throwable -> L12
        r18.add(r17);     // Catch: Throwable -> L12
        r1 = r18;
        r0 = r19;
        goto L7
    L10:
        ArrayList r20 = r1;
        r2.close();
        r16.release();
        return r20;
    L12:
        th = th;
    L16:
        r2.close();
        r16.release();
        throw th;
    L14:
        th = th;
        r16 = r3;
        goto L16
    }

    public final void L() {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.O.acquire();
        r0.bindLong(1, 1);
        this.a.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        this.O.release(r0);
        return;
    L6:
        th = move-exception;
        this.a.endTransaction();
        this.O.release(r0);
        throw th;
    }

    public final int k() {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.j.acquire();
        r0.bindString(1, "fake_");
        this.a.beginTransaction();
        int r1 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        this.j.release(r0);
        return r1;
    L6:
        th = move-exception;
        this.a.endTransaction();
        this.j.release(r0);
        throw th;
    }

    public final int l() {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.B.acquire();
        r0.bindLong(1, 1);
        r0.bindLong(2, 7);
        r0.bindLong(3, 9);
        r0.bindString(4, "fake_");
        this.a.beginTransaction();
        int r1 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        this.B.release(r0);
        return r1;
    L6:
        th = move-exception;
        this.a.endTransaction();
        this.B.release(r0);
        throw th;
    }

    public final List p() {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM ListTypes AS LT LEFT OUTER JOIN DocMetaInfo AS DMI ON LT.obj_token = DMI.obj_token WHERE LT.list_type = ? ", 1);
        r2.bindLong(1, 9);
        this.a.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.a, r2, false, null);
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L82
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "list_type");     // Catch: Throwable -> L82
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, ResourceData.KEY_TOKEN);     // Catch: Throwable -> L82
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, "extra");     // Catch: Throwable -> L82
        int r10 = CursorUtil.getColumnIndexOrThrow(r4, "space_id");     // Catch: Throwable -> L82
        int r11 = CursorUtil.getColumnIndexOrThrow(r4, "file_path");     // Catch: Throwable -> L82
        int r12 = CursorUtil.getColumnIndexOrThrow(r4, "add_time_manualoffline");     // Catch: Throwable -> L82
        int r13 = CursorUtil.getColumnIndexOrThrow(r4, "is_need_wifi_download");     // Catch: Throwable -> L82
        int r14 = CursorUtil.getColumnIndexOrThrow(r4, "open_time_recent");     // Catch: Throwable -> L82
        int r15 = CursorUtil.getColumnIndexOrThrow(r4, "my_edit_time_recent");     // Catch: Throwable -> L82
        int r3 = CursorUtil.getColumnIndexOrThrow(r4, "activity_time_recent");     // Catch: Throwable -> L82
        int r5 = CursorUtil.getColumnIndexOrThrow(r4, "has_perm_folder");     // Catch: Throwable -> L82
        int r1 = CursorUtil.getColumnIndexOrThrow(r4, "show_external_hint_folder");     // Catch: Throwable -> L82
        RoomSQLiteQuery r16 = r2;
        int r17 = CursorUtil.getColumnIndexOrThrow(r4, "node_type_folder");     // Catch: Throwable -> L80
        int r18 = CursorUtil.getColumnIndexOrThrow(r4, "shortcut_name_folder");     // Catch: Throwable -> L80
        int r19 = CursorUtil.getColumnIndexOrThrow(r4, "shortcut_owner_cn_name");     // Catch: Throwable -> L80
        int r20 = CursorUtil.getColumnIndexOrThrow(r4, "shortcut_owner_en_name");     // Catch: Throwable -> L80
        int r21 = CursorUtil.getColumnIndexOrThrow(r4, "shortcut_obj_biz_type");     // Catch: Throwable -> L80
        int r22 = CursorUtil.getColumnIndexOrThrow(r4, "shortcut_obj_node_token");     // Catch: Throwable -> L80
        int r23 = CursorUtil.getColumnIndexOrThrow(r4, "shortcut_obj_delete_flag");     // Catch: Throwable -> L80
        int r24 = CursorUtil.getColumnIndexOrThrow(r4, "is_hidden_share");     // Catch: Throwable -> L80
        int r25 = CursorUtil.getColumnIndexOrThrow(r4, "share_time_share");     // Catch: Throwable -> L80
        int r26 = CursorUtil.getColumnIndexOrThrow(r4, "sharer_en_name");     // Catch: Throwable -> L80
        int r27 = CursorUtil.getColumnIndexOrThrow(r4, "sharer_cn_name");     // Catch: Throwable -> L80
        int r28 = CursorUtil.getColumnIndexOrThrow(r4, "star_time_star");     // Catch: Throwable -> L80
        int r29 = CursorUtil.getColumnIndexOrThrow(r4, "shortcut_thumbnail_url");     // Catch: Throwable -> L80
        int r30 = CursorUtil.getColumnIndexOrThrow(r4, "shortcut_thumbnail_secret");     // Catch: Throwable -> L80
        int r31 = CursorUtil.getColumnIndexOrThrow(r4, "shortcut_thumbnail_nonce");     // Catch: Throwable -> L80
        int r32 = CursorUtil.getColumnIndexOrThrow(r4, "shortcut_thumbnail_type");     // Catch: Throwable -> L80
        int r33 = CursorUtil.getColumnIndexOrThrow(r4, "shortcut_thumbnail");     // Catch: Throwable -> L80
        int r34 = CursorUtil.getColumnIndexOrThrow(r4, "subordinate_id");     // Catch: Throwable -> L80
        int r35 = CursorUtil.getColumnIndexOrThrow(r4, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L80
        int r36 = CursorUtil.getColumnIndexOrThrow(r4, "name");     // Catch: Throwable -> L80
        int r37 = CursorUtil.getColumnIndexOrThrow(r4, ResourceData.KEY_TYPE);     // Catch: Throwable -> L80
        int r38 = CursorUtil.getColumnIndexOrThrow(r4, "owner_id");     // Catch: Throwable -> L80
        int r39 = CursorUtil.getColumnIndexOrThrow(r4, "create_tenant_id");     // Catch: Throwable -> L80
        int r310 = CursorUtil.getColumnIndexOrThrow(r4, "creator_cn_name");     // Catch: Throwable -> L80
        int r40 = CursorUtil.getColumnIndexOrThrow(r4, "creator_en_name");     // Catch: Throwable -> L80
        int r41 = CursorUtil.getColumnIndexOrThrow(r4, "edit_uid");     // Catch: Throwable -> L80
        int r42 = CursorUtil.getColumnIndexOrThrow(r4, "edit_time");     // Catch: Throwable -> L80
        int r43 = CursorUtil.getColumnIndexOrThrow(r4, ResourceData.KEY_URL);     // Catch: Throwable -> L80
        int r44 = CursorUtil.getColumnIndexOrThrow(r4, "fake_token");     // Catch: Throwable -> L80
        int r45 = CursorUtil.getColumnIndexOrThrow(r4, "is_stared");     // Catch: Throwable -> L80
        int r46 = CursorUtil.getColumnIndexOrThrow(r4, "is_pined");     // Catch: Throwable -> L80
        int r47 = CursorUtil.getColumnIndexOrThrow(r4, "is_subscribed");     // Catch: Throwable -> L80
        int r48 = CursorUtil.getColumnIndexOrThrow(r4, "extra_icon_url");     // Catch: Throwable -> L80
        int r49 = CursorUtil.getColumnIndexOrThrow(r4, "extra_icon_key");     // Catch: Throwable -> L80
        int r50 = CursorUtil.getColumnIndexOrThrow(r4, "extra_icon_nonce");     // Catch: Throwable -> L80
        int r51 = CursorUtil.getColumnIndexOrThrow(r4, "extra_icon_encrypted_type");     // Catch: Throwable -> L80
        int r52 = CursorUtil.getColumnIndexOrThrow(r4, "extra_copiable");     // Catch: Throwable -> L80
        int r53 = CursorUtil.getColumnIndexOrThrow(r4, "extra_is_share_root");     // Catch: Throwable -> L80
        int r54 = CursorUtil.getColumnIndexOrThrow(r4, "extra_is_external");     // Catch: Throwable -> L80
        int r55 = CursorUtil.getColumnIndexOrThrow(r4, "extra_sub_type");     // Catch: Throwable -> L80
        int r56 = CursorUtil.getColumnIndexOrThrow(r4, "obj_sub_type");     // Catch: Throwable -> L80
        int r57 = CursorUtil.getColumnIndexOrThrow(r4, "is_visited");     // Catch: Throwable -> L80
        int r58 = CursorUtil.getColumnIndexOrThrow(r4, "create_time");     // Catch: Throwable -> L80
        int r59 = CursorUtil.getColumnIndexOrThrow(r4, "thumbnail_url");     // Catch: Throwable -> L80
        int r60 = CursorUtil.getColumnIndexOrThrow(r4, "thumbnail_secret");     // Catch: Throwable -> L80
        int r61 = CursorUtil.getColumnIndexOrThrow(r4, "thumbnail_nonce");     // Catch: Throwable -> L80
        int r62 = CursorUtil.getColumnIndexOrThrow(r4, "thumbnail_type");     // Catch: Throwable -> L80
        int r63 = CursorUtil.getColumnIndexOrThrow(r4, "permission");     // Catch: Throwable -> L80
        int r64 = CursorUtil.getColumnIndexOrThrow(r4, "share_version");     // Catch: Throwable -> L80
        int r65 = CursorUtil.getColumnIndexOrThrow(r4, "need_sync");     // Catch: Throwable -> L80
        int r66 = CursorUtil.getColumnIndexOrThrow(r4, "size");     // Catch: Throwable -> L80
        int r67 = CursorUtil.getColumnIndexOrThrow(r4, "thumbnail");     // Catch: Throwable -> L80
        int r68 = CursorUtil.getColumnIndexOrThrow(r4, "document_icon_key");     // Catch: Throwable -> L80
        int r69 = CursorUtil.getColumnIndexOrThrow(r4, "document_icon_type");     // Catch: Throwable -> L80
        int r70 = CursorUtil.getColumnIndexOrThrow(r4, "document_icon_fsunit");     // Catch: Throwable -> L80
        int r71 = CursorUtil.getColumnIndexOrThrow(r4, "app_id");     // Catch: Throwable -> L80
        int r72 = CursorUtil.getColumnIndexOrThrow(r4, "doc_cache_status");     // Catch: Throwable -> L80
        int r73 = CursorUtil.getColumnIndexOrThrow(r4, "is_offline_create");     // Catch: Throwable -> L80
        int r74 = CursorUtil.getColumnIndexOrThrow(r4, "wiki_real_type");     // Catch: Throwable -> L80
        int r75 = CursorUtil.getColumnIndexOrThrow(r4, "wiki_real_token");     // Catch: Throwable -> L80
        int r76 = CursorUtil.getColumnIndexOrThrow(r4, "wiki_version");     // Catch: Throwable -> L80
        int r77 = CursorUtil.getColumnIndexOrThrow(r4, "owner_type");     // Catch: Throwable -> L80
        int r78 = CursorUtil.getColumnIndexOrThrow(r4, "is_share_folder");     // Catch: Throwable -> L80
        int r79 = CursorUtil.getColumnIndexOrThrow(r4, "security_name");     // Catch: Throwable -> L80
        int r80 = CursorUtil.getColumnIndexOrThrow(r4, "security_level");     // Catch: Throwable -> L80
        int r81 = CursorUtil.getColumnIndexOrThrow(r4, "is_secret_key_delete");     // Catch: Throwable -> L80
        int r82 = CursorUtil.getColumnIndexOrThrow(r4, "template_type");     // Catch: Throwable -> L80
        int r83 = CursorUtil.getColumnIndexOrThrow(r4, "is_insert");     // Catch: Throwable -> L80
        int r84 = CursorUtil.getColumnIndexOrThrow(r4, "organization_tag_value");     // Catch: Throwable -> L80
        int r85 = CursorUtil.getColumnIndexOrThrow(r4, "wiki_extra");     // Catch: Throwable -> L80
        int r86 = CursorUtil.getColumnIndexOrThrow(r4, "icon");     // Catch: Throwable -> L80
        int r87 = CursorUtil.getColumnIndexOrThrow(r4, "file_risk_tag");     // Catch: Throwable -> L80
        int r88 = CursorUtil.getColumnIndexOrThrow(r4, "is_wiki_home_page");     // Catch: Throwable -> L80
        int r89 = r34;
        ArrayList r0 = new ArrayList(r4.getCount());     // Catch: Throwable -> L80
    L7:
        if (r4.moveToNext() == false) goto L78;
        u1 r90 = new u1();     // Catch: Throwable -> L80
        ArrayList r91 = r0;
        r90.a = r4.getString(r6);     // Catch: Throwable -> L80
        r4.getInt(r7);     // Catch: Throwable -> L80
        r90.X = r4.getString(r8);     // Catch: Throwable -> L80
        r90.Y = r4.getString(r9);     // Catch: Throwable -> L80
        r90.Z = r4.getString(r10);     // Catch: Throwable -> L80
        r90.a0 = r4.getString(r11);     // Catch: Throwable -> L80
        r90.b0 = r4.getString(r12);     // Catch: Throwable -> L80
        if (r4.getInt(r13) == 0) goto L11;
        boolean r92 = true;
    L12:
        r90.c0 = r92;     // Catch: Throwable -> L80
        r90.d0 = r4.getString(r14);     // Catch: Throwable -> L80
        r90.e0 = r4.getString(r15);     // Catch: Throwable -> L80
        r90.f0 = r4.getString(r3);     // Catch: Throwable -> L80
        if (r4.getInt(r5) == 0) goto L15;
        boolean r93 = true;
    L16:
        r90.g0 = r93;     // Catch: Throwable -> L80
        if (r4.getInt(r1) == 0) goto L19;
        boolean r94 = true;
    L20:
        r90.h0 = r94;     // Catch: Throwable -> L80
        int r95 = r17;
        int r110 = r1;
        r90.i0 = r4.getInt(r95);     // Catch: Throwable -> L80
        int r96 = r18;
        r90.j0 = r4.getString(r96);     // Catch: Throwable -> L80
        int r97 = r19;
        r90.k0 = r4.getString(r97);     // Catch: Throwable -> L80
        int r98 = r20;
        r90.l0 = r4.getString(r98);     // Catch: Throwable -> L80
        int r99 = r21;
        r90.m0 = r4.getInt(r99);     // Catch: Throwable -> L80
        int r100 = r22;
        r90.n0 = r4.getString(r100);     // Catch: Throwable -> L80
        int r101 = r23;
        r90.o0 = r4.getInt(r101);     // Catch: Throwable -> L80
        int r102 = r24;
        if (r4.getInt(r102) == 0) goto L23;
        boolean r103 = true;
    L24:
        r90.p0 = r103;     // Catch: Throwable -> L80
        int r104 = r25;
        r90.q0 = r4.getString(r104);     // Catch: Throwable -> L80
        int r105 = r26;
        r90.r0 = r4.getString(r105);     // Catch: Throwable -> L80
        int r106 = r27;
        r90.s0 = r4.getString(r106);     // Catch: Throwable -> L80
        int r107 = r28;
        r90.t0 = r4.getString(r107);     // Catch: Throwable -> L80
        int r108 = r29;
        r90.v0 = r4.getString(r108);     // Catch: Throwable -> L80
        int r109 = r30;
        r90.w0 = r4.getString(r109);     // Catch: Throwable -> L80
        int r111 = r31;
        r90.x0 = r4.getString(r111);     // Catch: Throwable -> L80
        int r112 = r32;
        r90.y0 = r4.getInt(r112);     // Catch: Throwable -> L80
        int r113 = r33;
        r90.z0 = r4.getString(r113);     // Catch: Throwable -> L80
        int r114 = r89;
        r4.getString(r114);     // Catch: Throwable -> L80
        int r115 = r35;
        r90.a = r4.getString(r115);     // Catch: Throwable -> L80
        int r116 = r36;
        r90.b = r4.getString(r116);     // Catch: Throwable -> L80
        int r117 = r37;
        r90.c = r4.getString(r117);     // Catch: Throwable -> L80
        int r118 = r38;
        r90.d = r4.getString(r118);     // Catch: Throwable -> L80
        int r119 = r39;
        r90.e = r4.getString(r119);     // Catch: Throwable -> L80
        int r120 = r310;
        r90.f = r4.getString(r120);     // Catch: Throwable -> L80
        int r121 = r40;
        r4.getString(r121);     // Catch: Throwable -> L80
        r40 = r121;
        int r122 = r41;
        r90.g = r4.getString(r122);     // Catch: Throwable -> L80
        int r123 = r42;
        r90.h = r4.getString(r123);     // Catch: Throwable -> L80
        int r124 = r43;
        r90.i = r4.getString(r124);     // Catch: Throwable -> L80
        int r125 = r44;
        r90.j = r4.getString(r125);     // Catch: Throwable -> L80
        r45 = r45;
        if (r4.getInt(r45) == 0) goto L27;
        boolean r126 = true;
    L28:
        r90.k = r126;     // Catch: Throwable -> L80
        r46 = r46;
        if (r4.getInt(r46) == 0) goto L31;
        boolean r127 = true;
    L32:
        r90.l = r127;     // Catch: Throwable -> L80
        r47 = r47;
        if (r4.getInt(r47) == 0) goto L35;
        boolean r128 = true;
    L36:
        r90.m = r128;     // Catch: Throwable -> L80
        int r129 = r48;
        r90.n = r4.getString(r129);     // Catch: Throwable -> L80
        int r130 = r49;
        r90.o = r4.getString(r130);     // Catch: Throwable -> L80
        int r131 = r50;
        r90.p = r4.getString(r131);     // Catch: Throwable -> L80
        int r132 = r51;
        r90.q = r4.getInt(r132);     // Catch: Throwable -> L80
        r52 = r52;
        if (r4.getInt(r52) == 0) goto L39;
        boolean r133 = true;
    L40:
        r90.r = r133;     // Catch: Throwable -> L80
        r53 = r53;
        if (r4.getInt(r53) == 0) goto L43;
        boolean r134 = true;
    L44:
        r90.s = r134;     // Catch: Throwable -> L80
        r54 = r54;
        if (r4.getInt(r54) == 0) goto L47;
        boolean r135 = true;
    L48:
        r90.t = r135;     // Catch: Throwable -> L80
        int r136 = r55;
        r90.u = r4.getString(r136);     // Catch: Throwable -> L80
        int r910 = r5;
        int r137 = r56;
        int r510 = r6;
        r90.v = r4.getLong(r137);     // Catch: Throwable -> L80
        int r138 = r57;
        if (r4.getInt(r138) == 0) goto L51;
        boolean r139 = true;
    L52:
        r90.w = r139;     // Catch: Throwable -> L80
        int r140 = r58;
        r90.x = r4.getString(r140);     // Catch: Throwable -> L80
        int r141 = r59;
        r90.y = r4.getString(r141);     // Catch: Throwable -> L80
        r59 = r141;
        int r142 = r60;
        r90.z = r4.getString(r142);     // Catch: Throwable -> L80
        r60 = r142;
        int r143 = r61;
        r90.A = r4.getString(r143);     // Catch: Throwable -> L80
        r61 = r143;
        int r144 = r62;
        r90.B = r4.getInt(r144);     // Catch: Throwable -> L80
        r62 = r144;
        int r145 = r63;
        r90.C = r4.getInt(r145);     // Catch: Throwable -> L80
        r63 = r145;
        int r146 = r64;
        r90.D = r4.getInt(r146);     // Catch: Throwable -> L80
        int r147 = r65;
        r4.getInt(r147);     // Catch: Throwable -> L80
        r65 = r147;
        r64 = r146;
        int r148 = r66;
        r90.E = r4.getString(r148);     // Catch: Throwable -> L80
        r66 = r148;
        int r149 = r67;
        r90.F = r4.getString(r149);     // Catch: Throwable -> L80
        r67 = r149;
        int r150 = r68;
        r90.G = r4.getString(r150);     // Catch: Throwable -> L80
        r68 = r150;
        int r151 = r69;
        r90.H = r4.getInt(r151);     // Catch: Throwable -> L80
        r69 = r151;
        int r152 = r70;
        r90.I = r4.getString(r152);     // Catch: Throwable -> L80
        r70 = r152;
        int r153 = r71;
        r90.J = r4.getString(r153);     // Catch: Throwable -> L80
        r71 = r153;
        r72 = r72;
        r90.K = r4.getInt(r72);     // Catch: Throwable -> L80
        int r154 = r73;
        if (r4.getInt(r154) == 0) goto L55;
        boolean r155 = true;
    L56:
        r90.L = r155;     // Catch: Throwable -> L80
        r73 = r154;
        int r156 = r74;
        r90.M = r4.getInt(r156);     // Catch: Throwable -> L80
        r74 = r156;
        int r157 = r75;
        r90.N = r4.getString(r157);     // Catch: Throwable -> L80
        r75 = r157;
        int r158 = r76;
        r90.O = r4.getString(r158);     // Catch: Throwable -> L80
        r76 = r158;
        int r159 = r77;
        r90.Q = r4.getInt(r159);     // Catch: Throwable -> L80
        int r160 = r78;
        r78 = r160;
        if (r4.getInt(r160) == 0) goto L59;
        boolean r161 = true;
    L60:
        r90.R = r161;     // Catch: Throwable -> L80
        r77 = r159;
        int r162 = r79;
        r90.S = r4.getString(r162);     // Catch: Throwable -> L80
        r79 = r162;
        int r163 = r80;
        r90.T = r4.getInt(r163);     // Catch: Throwable -> L80
        int r164 = r81;
        r81 = r164;
        if (r4.getInt(r164) == 0) goto L63;
        boolean r165 = true;
    L64:
        r90.U = r165;     // Catch: Throwable -> L80
        r80 = r163;
        r82 = r82;
        r90.V = r4.getInt(r82);     // Catch: Throwable -> L80
        int r166 = r83;
        if (r4.getInt(r166) == 0) goto L67;
        boolean r167 = true;
    L68:
        r90.W = r167;     // Catch: Throwable -> L80
        r83 = r166;
        int r168 = r84;
        r90.u0 = r4.getString(r168);     // Catch: Throwable -> L80
        r84 = r168;
        int r169 = r85;
        r90.P = r4.getString(r169);     // Catch: Throwable -> L80
        r85 = r169;
        r86 = r86;
        r90.A0 = r4.getString(r86);     // Catch: Throwable -> L80
        int r170 = r87;
        if (r4.getInt(r170) == 0) goto L71;
        boolean r171 = true;
    L72:
        r90.B0 = r171;     // Catch: Throwable -> L80
        int r172 = r88;
        r88 = r172;
        if (r4.getInt(r172) == 0) goto L75;
        boolean r173 = true;
    L76:
        r90.C0 = r173;     // Catch: Throwable -> L80
        r0 = r91;
        r0.add(r90);     // Catch: Throwable -> L80
        r87 = r170;
        r1 = r110;
        r17 = r95;
        r18 = r96;
        r19 = r97;
        r20 = r98;
        r21 = r99;
        r22 = r100;
        r23 = r101;
        r24 = r102;
        r25 = r104;
        r26 = r105;
        r27 = r106;
        r28 = r107;
        r29 = r108;
        r30 = r109;
        r31 = r111;
        r32 = r112;
        r33 = r113;
        r89 = r114;
        r35 = r115;
        r36 = r116;
        r37 = r117;
        r38 = r118;
        r39 = r119;
        r310 = r120;
        r41 = r122;
        r42 = r123;
        r43 = r124;
        r44 = r125;
        r48 = r129;
        r49 = r130;
        r50 = r131;
        r51 = r132;
        r55 = r136;
        r57 = r138;
        r5 = r910;
        r58 = r140;
        r6 = r510;
        r56 = r137;
        goto L7
    L75:
        r173 = false;
        goto L76
    L71:
        r171 = false;
        goto L72
    L67:
        r167 = false;
        goto L68
    L63:
        r165 = false;
        goto L64
    L59:
        r161 = false;
        goto L60
    L55:
        r155 = false;
        goto L56
    L51:
        r139 = false;
        goto L52
    L47:
        r135 = false;
        goto L48
    L43:
        r134 = false;
        goto L44
    L39:
        r133 = false;
        goto L40
    L35:
        r128 = false;
        goto L36
    L31:
        r127 = false;
        goto L32
    L27:
        r126 = false;
        goto L28
    L23:
        r103 = false;
        goto L24
    L19:
        r94 = false;
        goto L20
    L15:
        r93 = false;
        goto L16
    L11:
        r92 = false;
        goto L12
    L78:
        r4.close();
        r16.release();
        return r0;
    L80:
        th = th;
    L84:
        r4.close();
        r16.release();
        throw th;
    L82:
        th = th;
        r16 = r2;
        goto L84
    }

    public final List q() {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM ListTypes AS LT LEFT OUTER JOIN DocMetaInfo AS DMI ON LT.obj_token = DMI.obj_token LEFT OUTER JOIN CacheStatus AS CS ON LT.obj_token = CS.obj_token WHERE LT.list_type = ? ", 1);
        r3.bindLong(1, 7);
        this.a.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.a, r3, false, null);
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L82
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "list_type");     // Catch: Throwable -> L82
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, ResourceData.KEY_TOKEN);     // Catch: Throwable -> L82
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "extra");     // Catch: Throwable -> L82
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "space_id");     // Catch: Throwable -> L82
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "file_path");     // Catch: Throwable -> L82
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "add_time_manualoffline");     // Catch: Throwable -> L82
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "is_need_wifi_download");     // Catch: Throwable -> L82
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, "open_time_recent");     // Catch: Throwable -> L82
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "my_edit_time_recent");     // Catch: Throwable -> L82
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "activity_time_recent");     // Catch: Throwable -> L82
        int r1 = CursorUtil.getColumnIndexOrThrow(r5, "has_perm_folder");     // Catch: Throwable -> L82
        RoomSQLiteQuery r16 = r3;
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, "show_external_hint_folder");     // Catch: Throwable -> L80
        int r18 = CursorUtil.getColumnIndexOrThrow(r5, "node_type_folder");     // Catch: Throwable -> L80
        int r19 = CursorUtil.getColumnIndexOrThrow(r5, "shortcut_name_folder");     // Catch: Throwable -> L80
        int r20 = CursorUtil.getColumnIndexOrThrow(r5, "shortcut_owner_cn_name");     // Catch: Throwable -> L80
        int r21 = CursorUtil.getColumnIndexOrThrow(r5, "shortcut_owner_en_name");     // Catch: Throwable -> L80
        int r22 = CursorUtil.getColumnIndexOrThrow(r5, "shortcut_obj_biz_type");     // Catch: Throwable -> L80
        int r23 = CursorUtil.getColumnIndexOrThrow(r5, "shortcut_obj_node_token");     // Catch: Throwable -> L80
        int r24 = CursorUtil.getColumnIndexOrThrow(r5, "shortcut_obj_delete_flag");     // Catch: Throwable -> L80
        int r25 = CursorUtil.getColumnIndexOrThrow(r5, "is_hidden_share");     // Catch: Throwable -> L80
        int r26 = CursorUtil.getColumnIndexOrThrow(r5, "share_time_share");     // Catch: Throwable -> L80
        int r27 = CursorUtil.getColumnIndexOrThrow(r5, "sharer_en_name");     // Catch: Throwable -> L80
        int r28 = CursorUtil.getColumnIndexOrThrow(r5, "sharer_cn_name");     // Catch: Throwable -> L80
        int r29 = CursorUtil.getColumnIndexOrThrow(r5, "star_time_star");     // Catch: Throwable -> L80
        int r30 = CursorUtil.getColumnIndexOrThrow(r5, "shortcut_thumbnail_url");     // Catch: Throwable -> L80
        int r31 = CursorUtil.getColumnIndexOrThrow(r5, "shortcut_thumbnail_secret");     // Catch: Throwable -> L80
        int r32 = CursorUtil.getColumnIndexOrThrow(r5, "shortcut_thumbnail_nonce");     // Catch: Throwable -> L80
        int r33 = CursorUtil.getColumnIndexOrThrow(r5, "shortcut_thumbnail_type");     // Catch: Throwable -> L80
        int r34 = CursorUtil.getColumnIndexOrThrow(r5, "shortcut_thumbnail");     // Catch: Throwable -> L80
        int r35 = CursorUtil.getColumnIndexOrThrow(r5, "subordinate_id");     // Catch: Throwable -> L80
        int r36 = CursorUtil.getColumnIndexOrThrow(r5, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L80
        int r37 = CursorUtil.getColumnIndexOrThrow(r5, "name");     // Catch: Throwable -> L80
        int r38 = CursorUtil.getColumnIndexOrThrow(r5, ResourceData.KEY_TYPE);     // Catch: Throwable -> L80
        int r39 = CursorUtil.getColumnIndexOrThrow(r5, "owner_id");     // Catch: Throwable -> L80
        int r40 = CursorUtil.getColumnIndexOrThrow(r5, "create_tenant_id");     // Catch: Throwable -> L80
        int r41 = CursorUtil.getColumnIndexOrThrow(r5, "creator_cn_name");     // Catch: Throwable -> L80
        int r42 = CursorUtil.getColumnIndexOrThrow(r5, "creator_en_name");     // Catch: Throwable -> L80
        int r43 = CursorUtil.getColumnIndexOrThrow(r5, "edit_uid");     // Catch: Throwable -> L80
        int r44 = CursorUtil.getColumnIndexOrThrow(r5, "edit_time");     // Catch: Throwable -> L80
        int r45 = CursorUtil.getColumnIndexOrThrow(r5, ResourceData.KEY_URL);     // Catch: Throwable -> L80
        int r46 = CursorUtil.getColumnIndexOrThrow(r5, "fake_token");     // Catch: Throwable -> L80
        int r47 = CursorUtil.getColumnIndexOrThrow(r5, "is_stared");     // Catch: Throwable -> L80
        int r48 = CursorUtil.getColumnIndexOrThrow(r5, "is_pined");     // Catch: Throwable -> L80
        int r49 = CursorUtil.getColumnIndexOrThrow(r5, "is_subscribed");     // Catch: Throwable -> L80
        int r50 = CursorUtil.getColumnIndexOrThrow(r5, "extra_icon_url");     // Catch: Throwable -> L80
        int r51 = CursorUtil.getColumnIndexOrThrow(r5, "extra_icon_key");     // Catch: Throwable -> L80
        int r52 = CursorUtil.getColumnIndexOrThrow(r5, "extra_icon_nonce");     // Catch: Throwable -> L80
        int r53 = CursorUtil.getColumnIndexOrThrow(r5, "extra_icon_encrypted_type");     // Catch: Throwable -> L80
        int r54 = CursorUtil.getColumnIndexOrThrow(r5, "extra_copiable");     // Catch: Throwable -> L80
        int r55 = CursorUtil.getColumnIndexOrThrow(r5, "extra_is_share_root");     // Catch: Throwable -> L80
        int r56 = CursorUtil.getColumnIndexOrThrow(r5, "extra_is_external");     // Catch: Throwable -> L80
        int r57 = CursorUtil.getColumnIndexOrThrow(r5, "extra_sub_type");     // Catch: Throwable -> L80
        int r58 = CursorUtil.getColumnIndexOrThrow(r5, "obj_sub_type");     // Catch: Throwable -> L80
        int r59 = CursorUtil.getColumnIndexOrThrow(r5, "is_visited");     // Catch: Throwable -> L80
        int r60 = CursorUtil.getColumnIndexOrThrow(r5, "create_time");     // Catch: Throwable -> L80
        int r61 = CursorUtil.getColumnIndexOrThrow(r5, "thumbnail_url");     // Catch: Throwable -> L80
        int r62 = CursorUtil.getColumnIndexOrThrow(r5, "thumbnail_secret");     // Catch: Throwable -> L80
        int r63 = CursorUtil.getColumnIndexOrThrow(r5, "thumbnail_nonce");     // Catch: Throwable -> L80
        int r64 = CursorUtil.getColumnIndexOrThrow(r5, "thumbnail_type");     // Catch: Throwable -> L80
        int r65 = CursorUtil.getColumnIndexOrThrow(r5, "permission");     // Catch: Throwable -> L80
        int r66 = CursorUtil.getColumnIndexOrThrow(r5, "share_version");     // Catch: Throwable -> L80
        int r67 = CursorUtil.getColumnIndexOrThrow(r5, "need_sync");     // Catch: Throwable -> L80
        int r68 = CursorUtil.getColumnIndexOrThrow(r5, "size");     // Catch: Throwable -> L80
        int r69 = CursorUtil.getColumnIndexOrThrow(r5, "thumbnail");     // Catch: Throwable -> L80
        int r70 = CursorUtil.getColumnIndexOrThrow(r5, "document_icon_key");     // Catch: Throwable -> L80
        int r71 = CursorUtil.getColumnIndexOrThrow(r5, "document_icon_type");     // Catch: Throwable -> L80
        int r72 = CursorUtil.getColumnIndexOrThrow(r5, "document_icon_fsunit");     // Catch: Throwable -> L80
        int r73 = CursorUtil.getColumnIndexOrThrow(r5, "app_id");     // Catch: Throwable -> L80
        int r74 = CursorUtil.getColumnIndexOrThrow(r5, "doc_cache_status");     // Catch: Throwable -> L80
        int r75 = CursorUtil.getColumnIndexOrThrow(r5, "is_offline_create");     // Catch: Throwable -> L80
        int r76 = CursorUtil.getColumnIndexOrThrow(r5, "wiki_real_type");     // Catch: Throwable -> L80
        int r77 = CursorUtil.getColumnIndexOrThrow(r5, "wiki_real_token");     // Catch: Throwable -> L80
        int r78 = CursorUtil.getColumnIndexOrThrow(r5, "wiki_version");     // Catch: Throwable -> L80
        int r79 = CursorUtil.getColumnIndexOrThrow(r5, "owner_type");     // Catch: Throwable -> L80
        int r80 = CursorUtil.getColumnIndexOrThrow(r5, "is_share_folder");     // Catch: Throwable -> L80
        int r81 = CursorUtil.getColumnIndexOrThrow(r5, "security_name");     // Catch: Throwable -> L80
        int r82 = CursorUtil.getColumnIndexOrThrow(r5, "security_level");     // Catch: Throwable -> L80
        int r83 = CursorUtil.getColumnIndexOrThrow(r5, "is_secret_key_delete");     // Catch: Throwable -> L80
        int r84 = CursorUtil.getColumnIndexOrThrow(r5, "template_type");     // Catch: Throwable -> L80
        int r85 = CursorUtil.getColumnIndexOrThrow(r5, "is_insert");     // Catch: Throwable -> L80
        int r86 = CursorUtil.getColumnIndexOrThrow(r5, "organization_tag_value");     // Catch: Throwable -> L80
        int r87 = CursorUtil.getColumnIndexOrThrow(r5, "wiki_extra");     // Catch: Throwable -> L80
        int r88 = CursorUtil.getColumnIndexOrThrow(r5, "icon");     // Catch: Throwable -> L80
        int r89 = CursorUtil.getColumnIndexOrThrow(r5, "file_risk_tag");     // Catch: Throwable -> L80
        int r90 = CursorUtil.getColumnIndexOrThrow(r5, "is_wiki_home_page");     // Catch: Throwable -> L80
        int r2 = CursorUtil.getColumnIndexOrThrow(r5, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L80
        int r91 = CursorUtil.getColumnIndexOrThrow(r5, "doc_cache_status");     // Catch: Throwable -> L80
        int r92 = r2;
        ArrayList r0 = new ArrayList(r5.getCount());     // Catch: Throwable -> L80
    L7:
        if (r5.moveToNext() == false) goto L78;
        u1 r93 = new u1();     // Catch: Throwable -> L80
        ArrayList r94 = r0;
        r93.a = r5.getString(r7);     // Catch: Throwable -> L80
        r5.getInt(r8);     // Catch: Throwable -> L80
        r93.X = r5.getString(r9);     // Catch: Throwable -> L80
        r93.Y = r5.getString(r10);     // Catch: Throwable -> L80
        r93.Z = r5.getString(r11);     // Catch: Throwable -> L80
        r93.a0 = r5.getString(r12);     // Catch: Throwable -> L80
        r93.b0 = r5.getString(r13);     // Catch: Throwable -> L80
        if (r5.getInt(r14) == 0) goto L11;
        boolean r95 = true;
    L12:
        r93.c0 = r95;     // Catch: Throwable -> L80
        r93.d0 = r5.getString(r15);     // Catch: Throwable -> L80
        r93.e0 = r5.getString(r4);     // Catch: Throwable -> L80
        r93.f0 = r5.getString(r6);     // Catch: Throwable -> L80
        if (r5.getInt(r1) == 0) goto L15;
        boolean r96 = true;
    L16:
        r93.g0 = r96;     // Catch: Throwable -> L80
        r17 = r17;
        if (r5.getInt(r17) == 0) goto L19;
        boolean r97 = true;
    L20:
        r93.h0 = r97;     // Catch: Throwable -> L80
        int r98 = r18;
        int r110 = r1;
        r93.i0 = r5.getInt(r98);     // Catch: Throwable -> L80
        int r99 = r19;
        r93.j0 = r5.getString(r99);     // Catch: Throwable -> L80
        int r100 = r20;
        r93.k0 = r5.getString(r100);     // Catch: Throwable -> L80
        int r101 = r21;
        r93.l0 = r5.getString(r101);     // Catch: Throwable -> L80
        int r102 = r22;
        r93.m0 = r5.getInt(r102);     // Catch: Throwable -> L80
        int r103 = r23;
        r93.n0 = r5.getString(r103);     // Catch: Throwable -> L80
        int r104 = r24;
        r93.o0 = r5.getInt(r104);     // Catch: Throwable -> L80
        int r105 = r25;
        if (r5.getInt(r105) == 0) goto L23;
        boolean r106 = true;
    L24:
        r93.p0 = r106;     // Catch: Throwable -> L80
        int r107 = r26;
        r93.q0 = r5.getString(r107);     // Catch: Throwable -> L80
        int r108 = r27;
        r93.r0 = r5.getString(r108);     // Catch: Throwable -> L80
        int r109 = r28;
        r93.s0 = r5.getString(r109);     // Catch: Throwable -> L80
        int r111 = r29;
        r93.t0 = r5.getString(r111);     // Catch: Throwable -> L80
        int r112 = r30;
        r93.v0 = r5.getString(r112);     // Catch: Throwable -> L80
        int r113 = r31;
        r93.w0 = r5.getString(r113);     // Catch: Throwable -> L80
        int r114 = r32;
        r93.x0 = r5.getString(r114);     // Catch: Throwable -> L80
        int r115 = r33;
        r93.y0 = r5.getInt(r115);     // Catch: Throwable -> L80
        int r116 = r34;
        r93.z0 = r5.getString(r116);     // Catch: Throwable -> L80
        int r117 = r35;
        r5.getString(r117);     // Catch: Throwable -> L80
        int r118 = r36;
        r93.a = r5.getString(r118);     // Catch: Throwable -> L80
        int r119 = r37;
        r93.b = r5.getString(r119);     // Catch: Throwable -> L80
        int r120 = r38;
        r93.c = r5.getString(r120);     // Catch: Throwable -> L80
        int r121 = r39;
        r93.d = r5.getString(r121);     // Catch: Throwable -> L80
        int r122 = r40;
        r93.e = r5.getString(r122);     // Catch: Throwable -> L80
        int r123 = r41;
        r93.f = r5.getString(r123);     // Catch: Throwable -> L80
        int r124 = r42;
        r5.getString(r124);     // Catch: Throwable -> L80
        r42 = r124;
        int r125 = r43;
        r93.g = r5.getString(r125);     // Catch: Throwable -> L80
        int r126 = r44;
        r93.h = r5.getString(r126);     // Catch: Throwable -> L80
        int r127 = r45;
        r93.i = r5.getString(r127);     // Catch: Throwable -> L80
        int r128 = r46;
        r93.j = r5.getString(r128);     // Catch: Throwable -> L80
        r47 = r47;
        if (r5.getInt(r47) == 0) goto L27;
        boolean r129 = true;
    L28:
        r93.k = r129;     // Catch: Throwable -> L80
        r48 = r48;
        if (r5.getInt(r48) == 0) goto L31;
        boolean r130 = true;
    L32:
        r93.l = r130;     // Catch: Throwable -> L80
        r49 = r49;
        if (r5.getInt(r49) == 0) goto L35;
        boolean r131 = true;
    L36:
        r93.m = r131;     // Catch: Throwable -> L80
        int r132 = r50;
        r93.n = r5.getString(r132);     // Catch: Throwable -> L80
        int r133 = r51;
        r93.o = r5.getString(r133);     // Catch: Throwable -> L80
        int r134 = r52;
        r93.p = r5.getString(r134);     // Catch: Throwable -> L80
        int r135 = r53;
        r93.q = r5.getInt(r135);     // Catch: Throwable -> L80
        r54 = r54;
        if (r5.getInt(r54) == 0) goto L39;
        boolean r136 = true;
    L40:
        r93.r = r136;     // Catch: Throwable -> L80
        r55 = r55;
        if (r5.getInt(r55) == 0) goto L43;
        boolean r137 = true;
    L44:
        r93.s = r137;     // Catch: Throwable -> L80
        r56 = r56;
        if (r5.getInt(r56) == 0) goto L47;
        boolean r138 = true;
    L48:
        r93.t = r138;     // Catch: Throwable -> L80
        int r139 = r57;
        r93.u = r5.getString(r139);     // Catch: Throwable -> L80
        int r910 = r6;
        int r140 = r58;
        int r510 = r7;
        r93.v = r5.getLong(r140);     // Catch: Throwable -> L80
        int r141 = r59;
        if (r5.getInt(r141) == 0) goto L51;
        boolean r142 = true;
    L52:
        r93.w = r142;     // Catch: Throwable -> L80
        int r143 = r60;
        r93.x = r5.getString(r143);     // Catch: Throwable -> L80
        int r144 = r61;
        r93.y = r5.getString(r144);     // Catch: Throwable -> L80
        r61 = r144;
        int r145 = r62;
        r93.z = r5.getString(r145);     // Catch: Throwable -> L80
        r62 = r145;
        int r146 = r63;
        r93.A = r5.getString(r146);     // Catch: Throwable -> L80
        r63 = r146;
        int r147 = r64;
        r93.B = r5.getInt(r147);     // Catch: Throwable -> L80
        r64 = r147;
        int r148 = r65;
        r93.C = r5.getInt(r148);     // Catch: Throwable -> L80
        r65 = r148;
        int r149 = r66;
        r93.D = r5.getInt(r149);     // Catch: Throwable -> L80
        int r150 = r67;
        r5.getInt(r150);     // Catch: Throwable -> L80
        r67 = r150;
        r66 = r149;
        int r151 = r68;
        r93.E = r5.getString(r151);     // Catch: Throwable -> L80
        r68 = r151;
        int r152 = r69;
        r93.F = r5.getString(r152);     // Catch: Throwable -> L80
        r69 = r152;
        int r153 = r70;
        r93.G = r5.getString(r153);     // Catch: Throwable -> L80
        r70 = r153;
        int r154 = r71;
        r93.H = r5.getInt(r154);     // Catch: Throwable -> L80
        r71 = r154;
        int r155 = r72;
        r93.I = r5.getString(r155);     // Catch: Throwable -> L80
        r72 = r155;
        int r156 = r73;
        r93.J = r5.getString(r156);     // Catch: Throwable -> L80
        r73 = r156;
        r74 = r74;
        r93.K = r5.getInt(r74);     // Catch: Throwable -> L80
        int r157 = r75;
        if (r5.getInt(r157) == 0) goto L55;
        boolean r158 = true;
    L56:
        r93.L = r158;     // Catch: Throwable -> L80
        r75 = r157;
        int r159 = r76;
        r93.M = r5.getInt(r159);     // Catch: Throwable -> L80
        r76 = r159;
        int r160 = r77;
        r93.N = r5.getString(r160);     // Catch: Throwable -> L80
        r77 = r160;
        int r161 = r78;
        r93.O = r5.getString(r161);     // Catch: Throwable -> L80
        r78 = r161;
        int r162 = r79;
        r93.Q = r5.getInt(r162);     // Catch: Throwable -> L80
        int r163 = r80;
        r80 = r163;
        if (r5.getInt(r163) == 0) goto L59;
        boolean r164 = true;
    L60:
        r93.R = r164;     // Catch: Throwable -> L80
        r79 = r162;
        int r165 = r81;
        r93.S = r5.getString(r165);     // Catch: Throwable -> L80
        r81 = r165;
        int r166 = r82;
        r93.T = r5.getInt(r166);     // Catch: Throwable -> L80
        int r167 = r83;
        r83 = r167;
        if (r5.getInt(r167) == 0) goto L63;
        boolean r168 = true;
    L64:
        r93.U = r168;     // Catch: Throwable -> L80
        r82 = r166;
        r84 = r84;
        r93.V = r5.getInt(r84);     // Catch: Throwable -> L80
        int r169 = r85;
        if (r5.getInt(r169) == 0) goto L67;
        boolean r170 = true;
    L68:
        r93.W = r170;     // Catch: Throwable -> L80
        r85 = r169;
        int r171 = r86;
        r93.u0 = r5.getString(r171);     // Catch: Throwable -> L80
        r86 = r171;
        int r172 = r87;
        r93.P = r5.getString(r172);     // Catch: Throwable -> L80
        r87 = r172;
        r88 = r88;
        r93.A0 = r5.getString(r88);     // Catch: Throwable -> L80
        int r173 = r89;
        if (r5.getInt(r173) == 0) goto L71;
        boolean r174 = true;
    L72:
        r93.B0 = r174;     // Catch: Throwable -> L80
        if (r5.getInt(r90) == 0) goto L75;
        boolean r175 = true;
    L76:
        r93.C0 = r175;     // Catch: Throwable -> L80
        r89 = r173;
        int r176 = r92;
        r93.a = r5.getString(r176);     // Catch: Throwable -> L80
        r92 = r176;
        int r177 = r91;
        r93.K = r5.getInt(r177);     // Catch: Throwable -> L80
        r0 = r94;
        r0.add(r93);     // Catch: Throwable -> L80
        r91 = r177;
        r1 = r110;
        r18 = r98;
        r19 = r99;
        r20 = r100;
        r21 = r101;
        r22 = r102;
        r23 = r103;
        r24 = r104;
        r25 = r105;
        r26 = r107;
        r27 = r108;
        r28 = r109;
        r29 = r111;
        r30 = r112;
        r31 = r113;
        r32 = r114;
        r33 = r115;
        r34 = r116;
        r35 = r117;
        r36 = r118;
        r37 = r119;
        r38 = r120;
        r39 = r121;
        r40 = r122;
        r41 = r123;
        r43 = r125;
        r44 = r126;
        r45 = r127;
        r46 = r128;
        r50 = r132;
        r51 = r133;
        r52 = r134;
        r53 = r135;
        r57 = r139;
        r59 = r141;
        r6 = r910;
        r60 = r143;
        r7 = r510;
        r58 = r140;
        goto L7
    L75:
        r175 = false;
        goto L76
    L71:
        r174 = false;
        goto L72
    L67:
        r170 = false;
        goto L68
    L63:
        r168 = false;
        goto L64
    L59:
        r164 = false;
        goto L60
    L55:
        r158 = false;
        goto L56
    L51:
        r142 = false;
        goto L52
    L47:
        r138 = false;
        goto L48
    L43:
        r137 = false;
        goto L44
    L39:
        r136 = false;
        goto L40
    L35:
        r131 = false;
        goto L36
    L31:
        r130 = false;
        goto L32
    L27:
        r129 = false;
        goto L28
    L23:
        r106 = false;
        goto L24
    L19:
        r97 = false;
        goto L20
    L15:
        r96 = false;
        goto L16
    L11:
        r95 = false;
        goto L12
    L78:
        r5.close();
        r16.release();
        return r0;
    L80:
        th = th;
    L84:
        r5.close();
        r16.release();
        throw th;
    L82:
        th = th;
        r16 = r3;
        goto L84
    }

    public final List r() {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT LT.obj_token AS obj_token, CS.doc_cache_status AS doc_cache_status,name, type, owner_id, create_tenant_id, creator_cn_name, creator_en_name, edit_uid, edit_time, url, fake_token, is_stared, is_pined, is_subscribed, extra_icon_url, extra_icon_key, extra_icon_nonce, extra_icon_encrypted_type, extra_copiable, extra_is_share_root, extra_is_external, extra_sub_type, obj_sub_type, is_visited, create_time, thumbnail_url,thumbnail_secret,thumbnail_nonce,thumbnail_type,permission,share_version,need_sync,size,thumbnail,document_icon_key,document_icon_type,document_icon_fsunit,app_id,is_offline_create,wiki_real_type,wiki_real_token,wiki_version,wiki_extra,owner_type,is_share_folder,security_name,security_level,is_secret_key_delete,template_type,is_insert,list_type,token,extra,space_id,file_path,add_time_manualoffline,is_need_wifi_download,open_time_recent,my_edit_time_recent,activity_time_recent,has_perm_folder,show_external_hint_folder,node_type_folder,shortcut_name_folder,shortcut_owner_cn_name,shortcut_owner_en_name,shortcut_obj_biz_type,shortcut_obj_node_token,shortcut_obj_delete_flag,is_hidden_share,share_time_share,sharer_en_name,sharer_cn_name,star_time_star,organization_tag_value,shortcut_thumbnail_url,shortcut_thumbnail_secret,shortcut_thumbnail_nonce,shortcut_thumbnail_type,shortcut_thumbnail,subordinate_id,icon,file_risk_tag,is_wiki_home_page FROM ListTypes AS LT LEFT OUTER JOIN CacheStatus AS CS ON LT.obj_token = CS.obj_token LEFT OUTER JOIN DocMetaInfo AS DMI ON LT.obj_token = DMI.obj_token WHERE LT.list_type = ? ", 1);
        r3.bindLong(1, 7);
        this.a.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.a, r3, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L82
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "doc_cache_status");     // Catch: Throwable -> L82
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "name");     // Catch: Throwable -> L82
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, ResourceData.KEY_TYPE);     // Catch: Throwable -> L82
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "owner_id");     // Catch: Throwable -> L82
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "create_tenant_id");     // Catch: Throwable -> L82
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "creator_cn_name");     // Catch: Throwable -> L82
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "creator_en_name");     // Catch: Throwable -> L82
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "edit_uid");     // Catch: Throwable -> L82
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "edit_time");     // Catch: Throwable -> L82
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, ResourceData.KEY_URL);     // Catch: Throwable -> L82
        int r2 = CursorUtil.getColumnIndexOrThrow(r5, "fake_token");     // Catch: Throwable -> L82
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "is_stared");     // Catch: Throwable -> L82
        int r1 = CursorUtil.getColumnIndexOrThrow(r5, "is_pined");     // Catch: Throwable -> L82
        RoomSQLiteQuery r16 = r3;
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, "is_subscribed");     // Catch: Throwable -> L80
        int r18 = CursorUtil.getColumnIndexOrThrow(r5, "extra_icon_url");     // Catch: Throwable -> L80
        int r19 = CursorUtil.getColumnIndexOrThrow(r5, "extra_icon_key");     // Catch: Throwable -> L80
        int r20 = CursorUtil.getColumnIndexOrThrow(r5, "extra_icon_nonce");     // Catch: Throwable -> L80
        int r21 = CursorUtil.getColumnIndexOrThrow(r5, "extra_icon_encrypted_type");     // Catch: Throwable -> L80
        int r22 = CursorUtil.getColumnIndexOrThrow(r5, "extra_copiable");     // Catch: Throwable -> L80
        int r23 = CursorUtil.getColumnIndexOrThrow(r5, "extra_is_share_root");     // Catch: Throwable -> L80
        int r24 = CursorUtil.getColumnIndexOrThrow(r5, "extra_is_external");     // Catch: Throwable -> L80
        int r25 = CursorUtil.getColumnIndexOrThrow(r5, "extra_sub_type");     // Catch: Throwable -> L80
        int r26 = CursorUtil.getColumnIndexOrThrow(r5, "obj_sub_type");     // Catch: Throwable -> L80
        int r27 = CursorUtil.getColumnIndexOrThrow(r5, "is_visited");     // Catch: Throwable -> L80
        int r28 = CursorUtil.getColumnIndexOrThrow(r5, "create_time");     // Catch: Throwable -> L80
        int r29 = CursorUtil.getColumnIndexOrThrow(r5, "thumbnail_url");     // Catch: Throwable -> L80
        int r30 = CursorUtil.getColumnIndexOrThrow(r5, "thumbnail_secret");     // Catch: Throwable -> L80
        int r31 = CursorUtil.getColumnIndexOrThrow(r5, "thumbnail_nonce");     // Catch: Throwable -> L80
        int r32 = CursorUtil.getColumnIndexOrThrow(r5, "thumbnail_type");     // Catch: Throwable -> L80
        int r33 = CursorUtil.getColumnIndexOrThrow(r5, "permission");     // Catch: Throwable -> L80
        int r34 = CursorUtil.getColumnIndexOrThrow(r5, "share_version");     // Catch: Throwable -> L80
        int r35 = CursorUtil.getColumnIndexOrThrow(r5, "need_sync");     // Catch: Throwable -> L80
        int r36 = CursorUtil.getColumnIndexOrThrow(r5, "size");     // Catch: Throwable -> L80
        int r37 = CursorUtil.getColumnIndexOrThrow(r5, "thumbnail");     // Catch: Throwable -> L80
        int r38 = CursorUtil.getColumnIndexOrThrow(r5, "document_icon_key");     // Catch: Throwable -> L80
        int r39 = CursorUtil.getColumnIndexOrThrow(r5, "document_icon_type");     // Catch: Throwable -> L80
        int r40 = CursorUtil.getColumnIndexOrThrow(r5, "document_icon_fsunit");     // Catch: Throwable -> L80
        int r41 = CursorUtil.getColumnIndexOrThrow(r5, "app_id");     // Catch: Throwable -> L80
        int r42 = CursorUtil.getColumnIndexOrThrow(r5, "is_offline_create");     // Catch: Throwable -> L80
        int r43 = CursorUtil.getColumnIndexOrThrow(r5, "wiki_real_type");     // Catch: Throwable -> L80
        int r44 = CursorUtil.getColumnIndexOrThrow(r5, "wiki_real_token");     // Catch: Throwable -> L80
        int r45 = CursorUtil.getColumnIndexOrThrow(r5, "wiki_version");     // Catch: Throwable -> L80
        int r46 = CursorUtil.getColumnIndexOrThrow(r5, "wiki_extra");     // Catch: Throwable -> L80
        int r47 = CursorUtil.getColumnIndexOrThrow(r5, "owner_type");     // Catch: Throwable -> L80
        int r48 = CursorUtil.getColumnIndexOrThrow(r5, "is_share_folder");     // Catch: Throwable -> L80
        int r49 = CursorUtil.getColumnIndexOrThrow(r5, "security_name");     // Catch: Throwable -> L80
        int r50 = CursorUtil.getColumnIndexOrThrow(r5, "security_level");     // Catch: Throwable -> L80
        int r51 = CursorUtil.getColumnIndexOrThrow(r5, "is_secret_key_delete");     // Catch: Throwable -> L80
        int r52 = CursorUtil.getColumnIndexOrThrow(r5, "template_type");     // Catch: Throwable -> L80
        int r53 = CursorUtil.getColumnIndexOrThrow(r5, "is_insert");     // Catch: Throwable -> L80
        int r54 = CursorUtil.getColumnIndexOrThrow(r5, "list_type");     // Catch: Throwable -> L80
        int r55 = CursorUtil.getColumnIndexOrThrow(r5, ResourceData.KEY_TOKEN);     // Catch: Throwable -> L80
        int r56 = CursorUtil.getColumnIndexOrThrow(r5, "extra");     // Catch: Throwable -> L80
        int r57 = CursorUtil.getColumnIndexOrThrow(r5, "space_id");     // Catch: Throwable -> L80
        int r58 = CursorUtil.getColumnIndexOrThrow(r5, "file_path");     // Catch: Throwable -> L80
        int r59 = CursorUtil.getColumnIndexOrThrow(r5, "add_time_manualoffline");     // Catch: Throwable -> L80
        int r60 = CursorUtil.getColumnIndexOrThrow(r5, "is_need_wifi_download");     // Catch: Throwable -> L80
        int r61 = CursorUtil.getColumnIndexOrThrow(r5, "open_time_recent");     // Catch: Throwable -> L80
        int r62 = CursorUtil.getColumnIndexOrThrow(r5, "my_edit_time_recent");     // Catch: Throwable -> L80
        int r63 = CursorUtil.getColumnIndexOrThrow(r5, "activity_time_recent");     // Catch: Throwable -> L80
        int r64 = CursorUtil.getColumnIndexOrThrow(r5, "has_perm_folder");     // Catch: Throwable -> L80
        int r65 = CursorUtil.getColumnIndexOrThrow(r5, "show_external_hint_folder");     // Catch: Throwable -> L80
        int r66 = CursorUtil.getColumnIndexOrThrow(r5, "node_type_folder");     // Catch: Throwable -> L80
        int r67 = CursorUtil.getColumnIndexOrThrow(r5, "shortcut_name_folder");     // Catch: Throwable -> L80
        int r68 = CursorUtil.getColumnIndexOrThrow(r5, "shortcut_owner_cn_name");     // Catch: Throwable -> L80
        int r69 = CursorUtil.getColumnIndexOrThrow(r5, "shortcut_owner_en_name");     // Catch: Throwable -> L80
        int r70 = CursorUtil.getColumnIndexOrThrow(r5, "shortcut_obj_biz_type");     // Catch: Throwable -> L80
        int r71 = CursorUtil.getColumnIndexOrThrow(r5, "shortcut_obj_node_token");     // Catch: Throwable -> L80
        int r72 = CursorUtil.getColumnIndexOrThrow(r5, "shortcut_obj_delete_flag");     // Catch: Throwable -> L80
        int r73 = CursorUtil.getColumnIndexOrThrow(r5, "is_hidden_share");     // Catch: Throwable -> L80
        int r74 = CursorUtil.getColumnIndexOrThrow(r5, "share_time_share");     // Catch: Throwable -> L80
        int r75 = CursorUtil.getColumnIndexOrThrow(r5, "sharer_en_name");     // Catch: Throwable -> L80
        int r76 = CursorUtil.getColumnIndexOrThrow(r5, "sharer_cn_name");     // Catch: Throwable -> L80
        int r77 = CursorUtil.getColumnIndexOrThrow(r5, "star_time_star");     // Catch: Throwable -> L80
        int r78 = CursorUtil.getColumnIndexOrThrow(r5, "organization_tag_value");     // Catch: Throwable -> L80
        int r79 = CursorUtil.getColumnIndexOrThrow(r5, "shortcut_thumbnail_url");     // Catch: Throwable -> L80
        int r80 = CursorUtil.getColumnIndexOrThrow(r5, "shortcut_thumbnail_secret");     // Catch: Throwable -> L80
        int r81 = CursorUtil.getColumnIndexOrThrow(r5, "shortcut_thumbnail_nonce");     // Catch: Throwable -> L80
        int r82 = CursorUtil.getColumnIndexOrThrow(r5, "shortcut_thumbnail_type");     // Catch: Throwable -> L80
        int r83 = CursorUtil.getColumnIndexOrThrow(r5, "shortcut_thumbnail");     // Catch: Throwable -> L80
        int r84 = CursorUtil.getColumnIndexOrThrow(r5, "subordinate_id");     // Catch: Throwable -> L80
        int r85 = CursorUtil.getColumnIndexOrThrow(r5, "icon");     // Catch: Throwable -> L80
        int r86 = CursorUtil.getColumnIndexOrThrow(r5, "file_risk_tag");     // Catch: Throwable -> L80
        int r87 = CursorUtil.getColumnIndexOrThrow(r5, "is_wiki_home_page");     // Catch: Throwable -> L80
        int r88 = r1;
        ArrayList r89 = new ArrayList(r5.getCount());     // Catch: Throwable -> L80
    L7:
        if (r5.moveToNext() == false) goto L78;
        u1 r90 = new u1();     // Catch: Throwable -> L80
        ArrayList r810 = r89;
        r90.a = r5.getString(r0);     // Catch: Throwable -> L80
        r90.K = r5.getInt(r6);     // Catch: Throwable -> L80
        r90.b = r5.getString(r7);     // Catch: Throwable -> L80
        r90.c = r5.getString(r8);     // Catch: Throwable -> L80
        r90.d = r5.getString(r9);     // Catch: Throwable -> L80
        r90.e = r5.getString(r10);     // Catch: Throwable -> L80
        r90.f = r5.getString(r11);     // Catch: Throwable -> L80
        r5.getString(r12);     // Catch: Throwable -> L80
        r90.g = r5.getString(r13);     // Catch: Throwable -> L80
        r90.h = r5.getString(r14);     // Catch: Throwable -> L80
        r90.i = r5.getString(r15);     // Catch: Throwable -> L80
        r90.j = r5.getString(r2);     // Catch: Throwable -> L80
        if (r5.getInt(r4) == 0) goto L11;
        boolean r91 = true;
    L12:
        r90.k = r91;     // Catch: Throwable -> L80
        int r92 = r88;
        if (r5.getInt(r92) == 0) goto L15;
        boolean r93 = true;
    L16:
        r90.l = r93;     // Catch: Throwable -> L80
        r17 = r17;
        if (r5.getInt(r17) == 0) goto L19;
        boolean r94 = true;
    L20:
        r90.m = r94;     // Catch: Throwable -> L80
        int r95 = r18;
        int r110 = r2;
        r90.n = r5.getString(r95);     // Catch: Throwable -> L80
        int r96 = r19;
        r90.o = r5.getString(r96);     // Catch: Throwable -> L80
        int r97 = r20;
        r90.p = r5.getString(r97);     // Catch: Throwable -> L80
        int r98 = r21;
        r90.q = r5.getInt(r98);     // Catch: Throwable -> L80
        r22 = r22;
        if (r5.getInt(r22) == 0) goto L23;
        boolean r99 = true;
    L24:
        r90.r = r99;     // Catch: Throwable -> L80
        r23 = r23;
        if (r5.getInt(r23) == 0) goto L27;
        boolean r100 = true;
    L28:
        r90.s = r100;     // Catch: Throwable -> L80
        r24 = r24;
        if (r5.getInt(r24) == 0) goto L31;
        boolean r101 = true;
    L32:
        r90.t = r101;     // Catch: Throwable -> L80
        int r102 = r25;
        r90.u = r5.getString(r102);     // Catch: Throwable -> L80
        int r103 = r26;
        int r210 = r4;
        r90.v = r5.getLong(r103);     // Catch: Throwable -> L80
        int r104 = r27;
        if (r5.getInt(r104) == 0) goto L35;
        boolean r105 = true;
    L36:
        r90.w = r105;     // Catch: Throwable -> L80
        int r106 = r28;
        r90.x = r5.getString(r106);     // Catch: Throwable -> L80
        int r107 = r29;
        r90.y = r5.getString(r107);     // Catch: Throwable -> L80
        r29 = r107;
        int r108 = r30;
        r90.z = r5.getString(r108);     // Catch: Throwable -> L80
        r30 = r108;
        int r109 = r31;
        r90.A = r5.getString(r109);     // Catch: Throwable -> L80
        r31 = r109;
        int r111 = r32;
        r90.B = r5.getInt(r111);     // Catch: Throwable -> L80
        r32 = r111;
        int r112 = r33;
        r90.C = r5.getInt(r112);     // Catch: Throwable -> L80
        r33 = r112;
        int r113 = r34;
        r90.D = r5.getInt(r113);     // Catch: Throwable -> L80
        int r114 = r35;
        r5.getInt(r114);     // Catch: Throwable -> L80
        r35 = r114;
        r34 = r113;
        int r115 = r36;
        r90.E = r5.getString(r115);     // Catch: Throwable -> L80
        r36 = r115;
        int r116 = r37;
        r90.F = r5.getString(r116);     // Catch: Throwable -> L80
        r37 = r116;
        int r117 = r38;
        r90.G = r5.getString(r117);     // Catch: Throwable -> L80
        r38 = r117;
        int r118 = r39;
        r90.H = r5.getInt(r118);     // Catch: Throwable -> L80
        r39 = r118;
        int r119 = r40;
        r90.I = r5.getString(r119);     // Catch: Throwable -> L80
        r40 = r119;
        int r120 = r41;
        r90.J = r5.getString(r120);     // Catch: Throwable -> L80
        int r121 = r42;
        r42 = r121;
        if (r5.getInt(r121) == 0) goto L39;
        boolean r122 = true;
    L40:
        r90.L = r122;     // Catch: Throwable -> L80
        r41 = r120;
        int r123 = r43;
        r90.M = r5.getInt(r123);     // Catch: Throwable -> L80
        r43 = r123;
        int r124 = r44;
        r90.N = r5.getString(r124);     // Catch: Throwable -> L80
        r44 = r124;
        int r125 = r45;
        r90.O = r5.getString(r125);     // Catch: Throwable -> L80
        r45 = r125;
        int r126 = r46;
        r90.P = r5.getString(r126);     // Catch: Throwable -> L80
        r46 = r126;
        r47 = r47;
        r90.Q = r5.getInt(r47);     // Catch: Throwable -> L80
        int r127 = r48;
        if (r5.getInt(r127) == 0) goto L43;
        boolean r128 = true;
    L44:
        r90.R = r128;     // Catch: Throwable -> L80
        r48 = r127;
        int r129 = r49;
        r90.S = r5.getString(r129);     // Catch: Throwable -> L80
        r49 = r129;
        int r130 = r50;
        r90.T = r5.getInt(r130);     // Catch: Throwable -> L80
        int r131 = r51;
        r51 = r131;
        if (r5.getInt(r131) == 0) goto L47;
        boolean r132 = true;
    L48:
        r90.U = r132;     // Catch: Throwable -> L80
        r50 = r130;
        r52 = r52;
        r90.V = r5.getInt(r52);     // Catch: Throwable -> L80
        int r133 = r53;
        if (r5.getInt(r133) == 0) goto L51;
        boolean r134 = true;
    L52:
        r90.W = r134;     // Catch: Throwable -> L80
        int r135 = r54;
        r5.getInt(r135);     // Catch: Throwable -> L80
        r54 = r135;
        r53 = r133;
        int r136 = r55;
        r90.X = r5.getString(r136);     // Catch: Throwable -> L80
        r55 = r136;
        int r137 = r56;
        r90.Y = r5.getString(r137);     // Catch: Throwable -> L80
        r56 = r137;
        int r138 = r57;
        r90.Z = r5.getString(r138);     // Catch: Throwable -> L80
        r57 = r138;
        int r139 = r58;
        r90.a0 = r5.getString(r139);     // Catch: Throwable -> L80
        r58 = r139;
        r59 = r59;
        r90.b0 = r5.getString(r59);     // Catch: Throwable -> L80
        int r140 = r60;
        if (r5.getInt(r140) == 0) goto L55;
        boolean r141 = true;
    L56:
        r90.c0 = r141;     // Catch: Throwable -> L80
        r60 = r140;
        int r142 = r61;
        r90.d0 = r5.getString(r142);     // Catch: Throwable -> L80
        r61 = r142;
        int r143 = r62;
        r90.e0 = r5.getString(r143);     // Catch: Throwable -> L80
        r62 = r143;
        r63 = r63;
        r90.f0 = r5.getString(r63);     // Catch: Throwable -> L80
        int r144 = r64;
        if (r5.getInt(r144) == 0) goto L59;
        boolean r145 = true;
    L60:
        r90.g0 = r145;     // Catch: Throwable -> L80
        int r146 = r65;
        r65 = r146;
        if (r5.getInt(r146) == 0) goto L63;
        boolean r147 = true;
    L64:
        r90.h0 = r147;     // Catch: Throwable -> L80
        r64 = r144;
        int r148 = r66;
        r90.i0 = r5.getInt(r148);     // Catch: Throwable -> L80
        r66 = r148;
        int r149 = r67;
        r90.j0 = r5.getString(r149);     // Catch: Throwable -> L80
        r67 = r149;
        int r150 = r68;
        r90.k0 = r5.getString(r150);     // Catch: Throwable -> L80
        r68 = r150;
        int r151 = r69;
        r90.l0 = r5.getString(r151);     // Catch: Throwable -> L80
        r69 = r151;
        int r152 = r70;
        r90.m0 = r5.getInt(r152);     // Catch: Throwable -> L80
        r70 = r152;
        int r153 = r71;
        r90.n0 = r5.getString(r153);     // Catch: Throwable -> L80
        r71 = r153;
        r72 = r72;
        r90.o0 = r5.getInt(r72);     // Catch: Throwable -> L80
        int r154 = r73;
        if (r5.getInt(r154) == 0) goto L67;
        boolean r155 = true;
    L68:
        r90.p0 = r155;     // Catch: Throwable -> L80
        r73 = r154;
        int r156 = r74;
        r90.q0 = r5.getString(r156);     // Catch: Throwable -> L80
        r74 = r156;
        int r157 = r75;
        r90.r0 = r5.getString(r157);     // Catch: Throwable -> L80
        r75 = r157;
        int r158 = r76;
        r90.s0 = r5.getString(r158);     // Catch: Throwable -> L80
        r76 = r158;
        int r159 = r77;
        r90.t0 = r5.getString(r159);     // Catch: Throwable -> L80
        r77 = r159;
        int r160 = r78;
        r90.u0 = r5.getString(r160);     // Catch: Throwable -> L80
        r78 = r160;
        int r161 = r79;
        r90.v0 = r5.getString(r161);     // Catch: Throwable -> L80
        r79 = r161;
        int r162 = r80;
        r90.w0 = r5.getString(r162);     // Catch: Throwable -> L80
        r80 = r162;
        int r163 = r81;
        r90.x0 = r5.getString(r163);     // Catch: Throwable -> L80
        r81 = r163;
        int r164 = r82;
        r90.y0 = r5.getInt(r164);     // Catch: Throwable -> L80
        r82 = r164;
        int r165 = r83;
        r90.z0 = r5.getString(r165);     // Catch: Throwable -> L80
        int r166 = r84;
        r5.getString(r166);     // Catch: Throwable -> L80
        r84 = r166;
        r83 = r165;
        r85 = r85;
        r90.A0 = r5.getString(r85);     // Catch: Throwable -> L80
        int r167 = r86;
        if (r5.getInt(r167) == 0) goto L71;
        boolean r168 = true;
    L72:
        r90.B0 = r168;     // Catch: Throwable -> L80
        int r169 = r87;
        r87 = r169;
        if (r5.getInt(r169) == 0) goto L75;
        boolean r170 = true;
    L76:
        r90.C0 = r170;     // Catch: Throwable -> L80
        r810.add(r90);     // Catch: Throwable -> L80
        r86 = r167;
        r2 = r110;
        r18 = r95;
        r19 = r96;
        r20 = r97;
        r21 = r98;
        r25 = r102;
        r27 = r104;
        r89 = r810;
        r0 = r0;
        r88 = r92;
        r28 = r106;
        r4 = r210;
        r26 = r103;
        goto L7
    L75:
        r170 = false;
        goto L76
    L71:
        r168 = false;
        goto L72
    L67:
        r155 = false;
        goto L68
    L63:
        r147 = false;
        goto L64
    L59:
        r145 = false;
        goto L60
    L55:
        r141 = false;
        goto L56
    L51:
        r134 = false;
        goto L52
    L47:
        r132 = false;
        goto L48
    L43:
        r128 = false;
        goto L44
    L39:
        r122 = false;
        goto L40
    L35:
        r105 = false;
        goto L36
    L31:
        r101 = false;
        goto L32
    L27:
        r100 = false;
        goto L28
    L23:
        r99 = false;
        goto L24
    L19:
        r94 = false;
        goto L20
    L15:
        r93 = false;
        goto L16
    L11:
        r91 = false;
        goto L12
    L78:
        ArrayList r171 = r89;
        r5.close();
        r16.release();
        return r171;
    L80:
        th = th;
    L84:
        r5.close();
        r16.release();
        throw th;
    L82:
        th = th;
        r16 = r3;
        goto L84
    }

    public d1(BearDatabase r2) {
        this.a = r2;
        this.b = new y(r2);
        this.c = new j0(r2);
        this.d = new u0(r2);
        this.e = new f1(r2);
        this.f = new p1(r2);
        this.g = new q1(r2);
        this.h = new r1(r2);
        this.i = new s1(r2);
        this.j = new t1(r2);
        this.k = new o(r2);
        this.l = new p(r2);
        this.m = new q(r2);
        this.n = new r(r2);
        this.o = new s(r2);
        this.p = new t(r2);
        this.q = new u(r2);
        new v(r2);
        this.r = new w(r2);
        new x(r2);
        this.s = new z(r2);
        this.t = new a0(r2);
        this.u = new b0(r2);
        this.v = new c0(r2);
        this.w = new d0(r2);
        this.x = new e0(r2);
        this.y = new f0(r2);
        this.z = new g0(r2);
        this.A = new h0(r2);
        new i0(r2);
        this.B = new k0(r2);
        this.C = new l0(r2);
        this.D = new m0(r2);
        this.E = new n0(r2);
        this.F = new o0(r2);
        this.G = new p0(r2);
        this.H = new q0(r2);
        this.I = new r0(r2);
        this.J = new s0(r2);
        this.K = new t0(r2);
        this.L = new v0(r2);
        this.M = new w0(r2);
        this.N = new x0(r2);
        this.O = new y0(r2);
        new z0(r2);
        this.P = new a1(r2);
        this.Q = new b1(r2);
        this.R = new c1(r2);
    }

    public final List E(int r93) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM ListTypes AS LT LEFT OUTER JOIN DocMetaInfo AS DMI ON LT.obj_token = DMI.obj_token WHERE list_type = ? AND file_path = ? AND LT.obj_token LIKE ? || '%'", 3);
        r2.bindLong(1, r93);
        r2.bindString(2, "");
        r2.bindString(3, "fake_");
        this.a.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.a, r2, false, null);
        int r4 = CursorUtil.getColumnIndexOrThrow(r3, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L82
        int r7 = CursorUtil.getColumnIndexOrThrow(r3, "list_type");     // Catch: Throwable -> L82
        int r8 = CursorUtil.getColumnIndexOrThrow(r3, ResourceData.KEY_TOKEN);     // Catch: Throwable -> L82
        int r9 = CursorUtil.getColumnIndexOrThrow(r3, "extra");     // Catch: Throwable -> L82
        int r10 = CursorUtil.getColumnIndexOrThrow(r3, "space_id");     // Catch: Throwable -> L82
        int r11 = CursorUtil.getColumnIndexOrThrow(r3, "file_path");     // Catch: Throwable -> L82
        int r12 = CursorUtil.getColumnIndexOrThrow(r3, "add_time_manualoffline");     // Catch: Throwable -> L82
        int r13 = CursorUtil.getColumnIndexOrThrow(r3, "is_need_wifi_download");     // Catch: Throwable -> L82
        int r14 = CursorUtil.getColumnIndexOrThrow(r3, "open_time_recent");     // Catch: Throwable -> L82
        int r15 = CursorUtil.getColumnIndexOrThrow(r3, "my_edit_time_recent");     // Catch: Throwable -> L82
        int r5 = CursorUtil.getColumnIndexOrThrow(r3, "activity_time_recent");     // Catch: Throwable -> L82
        int r6 = CursorUtil.getColumnIndexOrThrow(r3, "has_perm_folder");     // Catch: Throwable -> L82
        int r1 = CursorUtil.getColumnIndexOrThrow(r3, "show_external_hint_folder");     // Catch: Throwable -> L82
        RoomSQLiteQuery r16 = r2;
        int r17 = CursorUtil.getColumnIndexOrThrow(r3, "node_type_folder");     // Catch: Throwable -> L80
        int r18 = CursorUtil.getColumnIndexOrThrow(r3, "shortcut_name_folder");     // Catch: Throwable -> L80
        int r19 = CursorUtil.getColumnIndexOrThrow(r3, "shortcut_owner_cn_name");     // Catch: Throwable -> L80
        int r20 = CursorUtil.getColumnIndexOrThrow(r3, "shortcut_owner_en_name");     // Catch: Throwable -> L80
        int r21 = CursorUtil.getColumnIndexOrThrow(r3, "shortcut_obj_biz_type");     // Catch: Throwable -> L80
        int r22 = CursorUtil.getColumnIndexOrThrow(r3, "shortcut_obj_node_token");     // Catch: Throwable -> L80
        int r23 = CursorUtil.getColumnIndexOrThrow(r3, "shortcut_obj_delete_flag");     // Catch: Throwable -> L80
        int r24 = CursorUtil.getColumnIndexOrThrow(r3, "is_hidden_share");     // Catch: Throwable -> L80
        int r25 = CursorUtil.getColumnIndexOrThrow(r3, "share_time_share");     // Catch: Throwable -> L80
        int r26 = CursorUtil.getColumnIndexOrThrow(r3, "sharer_en_name");     // Catch: Throwable -> L80
        int r27 = CursorUtil.getColumnIndexOrThrow(r3, "sharer_cn_name");     // Catch: Throwable -> L80
        int r28 = CursorUtil.getColumnIndexOrThrow(r3, "star_time_star");     // Catch: Throwable -> L80
        int r29 = CursorUtil.getColumnIndexOrThrow(r3, "shortcut_thumbnail_url");     // Catch: Throwable -> L80
        int r30 = CursorUtil.getColumnIndexOrThrow(r3, "shortcut_thumbnail_secret");     // Catch: Throwable -> L80
        int r31 = CursorUtil.getColumnIndexOrThrow(r3, "shortcut_thumbnail_nonce");     // Catch: Throwable -> L80
        int r32 = CursorUtil.getColumnIndexOrThrow(r3, "shortcut_thumbnail_type");     // Catch: Throwable -> L80
        int r33 = CursorUtil.getColumnIndexOrThrow(r3, "shortcut_thumbnail");     // Catch: Throwable -> L80
        int r34 = CursorUtil.getColumnIndexOrThrow(r3, "subordinate_id");     // Catch: Throwable -> L80
        int r35 = CursorUtil.getColumnIndexOrThrow(r3, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L80
        int r36 = CursorUtil.getColumnIndexOrThrow(r3, "name");     // Catch: Throwable -> L80
        int r37 = CursorUtil.getColumnIndexOrThrow(r3, ResourceData.KEY_TYPE);     // Catch: Throwable -> L80
        int r38 = CursorUtil.getColumnIndexOrThrow(r3, "owner_id");     // Catch: Throwable -> L80
        int r39 = CursorUtil.getColumnIndexOrThrow(r3, "create_tenant_id");     // Catch: Throwable -> L80
        int r310 = CursorUtil.getColumnIndexOrThrow(r3, "creator_cn_name");     // Catch: Throwable -> L80
        int r40 = CursorUtil.getColumnIndexOrThrow(r3, "creator_en_name");     // Catch: Throwable -> L80
        int r41 = CursorUtil.getColumnIndexOrThrow(r3, "edit_uid");     // Catch: Throwable -> L80
        int r42 = CursorUtil.getColumnIndexOrThrow(r3, "edit_time");     // Catch: Throwable -> L80
        int r43 = CursorUtil.getColumnIndexOrThrow(r3, ResourceData.KEY_URL);     // Catch: Throwable -> L80
        int r44 = CursorUtil.getColumnIndexOrThrow(r3, "fake_token");     // Catch: Throwable -> L80
        int r45 = CursorUtil.getColumnIndexOrThrow(r3, "is_stared");     // Catch: Throwable -> L80
        int r46 = CursorUtil.getColumnIndexOrThrow(r3, "is_pined");     // Catch: Throwable -> L80
        int r47 = CursorUtil.getColumnIndexOrThrow(r3, "is_subscribed");     // Catch: Throwable -> L80
        int r48 = CursorUtil.getColumnIndexOrThrow(r3, "extra_icon_url");     // Catch: Throwable -> L80
        int r49 = CursorUtil.getColumnIndexOrThrow(r3, "extra_icon_key");     // Catch: Throwable -> L80
        int r50 = CursorUtil.getColumnIndexOrThrow(r3, "extra_icon_nonce");     // Catch: Throwable -> L80
        int r51 = CursorUtil.getColumnIndexOrThrow(r3, "extra_icon_encrypted_type");     // Catch: Throwable -> L80
        int r52 = CursorUtil.getColumnIndexOrThrow(r3, "extra_copiable");     // Catch: Throwable -> L80
        int r53 = CursorUtil.getColumnIndexOrThrow(r3, "extra_is_share_root");     // Catch: Throwable -> L80
        int r54 = CursorUtil.getColumnIndexOrThrow(r3, "extra_is_external");     // Catch: Throwable -> L80
        int r55 = CursorUtil.getColumnIndexOrThrow(r3, "extra_sub_type");     // Catch: Throwable -> L80
        int r56 = CursorUtil.getColumnIndexOrThrow(r3, "obj_sub_type");     // Catch: Throwable -> L80
        int r57 = CursorUtil.getColumnIndexOrThrow(r3, "is_visited");     // Catch: Throwable -> L80
        int r58 = CursorUtil.getColumnIndexOrThrow(r3, "create_time");     // Catch: Throwable -> L80
        int r59 = CursorUtil.getColumnIndexOrThrow(r3, "thumbnail_url");     // Catch: Throwable -> L80
        int r60 = CursorUtil.getColumnIndexOrThrow(r3, "thumbnail_secret");     // Catch: Throwable -> L80
        int r61 = CursorUtil.getColumnIndexOrThrow(r3, "thumbnail_nonce");     // Catch: Throwable -> L80
        int r62 = CursorUtil.getColumnIndexOrThrow(r3, "thumbnail_type");     // Catch: Throwable -> L80
        int r63 = CursorUtil.getColumnIndexOrThrow(r3, "permission");     // Catch: Throwable -> L80
        int r64 = CursorUtil.getColumnIndexOrThrow(r3, "share_version");     // Catch: Throwable -> L80
        int r65 = CursorUtil.getColumnIndexOrThrow(r3, "need_sync");     // Catch: Throwable -> L80
        int r66 = CursorUtil.getColumnIndexOrThrow(r3, "size");     // Catch: Throwable -> L80
        int r67 = CursorUtil.getColumnIndexOrThrow(r3, "thumbnail");     // Catch: Throwable -> L80
        int r68 = CursorUtil.getColumnIndexOrThrow(r3, "document_icon_key");     // Catch: Throwable -> L80
        int r69 = CursorUtil.getColumnIndexOrThrow(r3, "document_icon_type");     // Catch: Throwable -> L80
        int r70 = CursorUtil.getColumnIndexOrThrow(r3, "document_icon_fsunit");     // Catch: Throwable -> L80
        int r71 = CursorUtil.getColumnIndexOrThrow(r3, "app_id");     // Catch: Throwable -> L80
        int r72 = CursorUtil.getColumnIndexOrThrow(r3, "doc_cache_status");     // Catch: Throwable -> L80
        int r73 = CursorUtil.getColumnIndexOrThrow(r3, "is_offline_create");     // Catch: Throwable -> L80
        int r74 = CursorUtil.getColumnIndexOrThrow(r3, "wiki_real_type");     // Catch: Throwable -> L80
        int r75 = CursorUtil.getColumnIndexOrThrow(r3, "wiki_real_token");     // Catch: Throwable -> L80
        int r76 = CursorUtil.getColumnIndexOrThrow(r3, "wiki_version");     // Catch: Throwable -> L80
        int r77 = CursorUtil.getColumnIndexOrThrow(r3, "owner_type");     // Catch: Throwable -> L80
        int r78 = CursorUtil.getColumnIndexOrThrow(r3, "is_share_folder");     // Catch: Throwable -> L80
        int r79 = CursorUtil.getColumnIndexOrThrow(r3, "security_name");     // Catch: Throwable -> L80
        int r80 = CursorUtil.getColumnIndexOrThrow(r3, "security_level");     // Catch: Throwable -> L80
        int r81 = CursorUtil.getColumnIndexOrThrow(r3, "is_secret_key_delete");     // Catch: Throwable -> L80
        int r82 = CursorUtil.getColumnIndexOrThrow(r3, "template_type");     // Catch: Throwable -> L80
        int r83 = CursorUtil.getColumnIndexOrThrow(r3, "is_insert");     // Catch: Throwable -> L80
        int r84 = CursorUtil.getColumnIndexOrThrow(r3, "organization_tag_value");     // Catch: Throwable -> L80
        int r85 = CursorUtil.getColumnIndexOrThrow(r3, "wiki_extra");     // Catch: Throwable -> L80
        int r86 = CursorUtil.getColumnIndexOrThrow(r3, "icon");     // Catch: Throwable -> L80
        int r87 = CursorUtil.getColumnIndexOrThrow(r3, "file_risk_tag");     // Catch: Throwable -> L80
        int r88 = CursorUtil.getColumnIndexOrThrow(r3, "is_wiki_home_page");     // Catch: Throwable -> L80
        int r89 = r34;
        ArrayList r0 = new ArrayList(r3.getCount());     // Catch: Throwable -> L80
    L7:
        if (r3.moveToNext() == false) goto L78;
        u1 r90 = new u1();     // Catch: Throwable -> L80
        ArrayList r91 = r0;
        r90.a = r3.getString(r4);     // Catch: Throwable -> L80
        r3.getInt(r7);     // Catch: Throwable -> L80
        r90.X = r3.getString(r8);     // Catch: Throwable -> L80
        r90.Y = r3.getString(r9);     // Catch: Throwable -> L80
        r90.Z = r3.getString(r10);     // Catch: Throwable -> L80
        r90.a0 = r3.getString(r11);     // Catch: Throwable -> L80
        r90.b0 = r3.getString(r12);     // Catch: Throwable -> L80
        if (r3.getInt(r13) == 0) goto L11;
        boolean r92 = true;
    L12:
        r90.c0 = r92;     // Catch: Throwable -> L80
        r90.d0 = r3.getString(r14);     // Catch: Throwable -> L80
        r90.e0 = r3.getString(r15);     // Catch: Throwable -> L80
        r90.f0 = r3.getString(r5);     // Catch: Throwable -> L80
        if (r3.getInt(r6) == 0) goto L15;
        boolean r94 = true;
    L16:
        r90.g0 = r94;     // Catch: Throwable -> L80
        if (r3.getInt(r1) == 0) goto L19;
        boolean r95 = true;
    L20:
        r90.h0 = r95;     // Catch: Throwable -> L80
        int r96 = r17;
        int r110 = r1;
        r90.i0 = r3.getInt(r96);     // Catch: Throwable -> L80
        int r97 = r18;
        r90.j0 = r3.getString(r97);     // Catch: Throwable -> L80
        int r98 = r19;
        r90.k0 = r3.getString(r98);     // Catch: Throwable -> L80
        int r99 = r20;
        r90.l0 = r3.getString(r99);     // Catch: Throwable -> L80
        int r100 = r21;
        r90.m0 = r3.getInt(r100);     // Catch: Throwable -> L80
        int r101 = r22;
        r90.n0 = r3.getString(r101);     // Catch: Throwable -> L80
        int r102 = r23;
        r90.o0 = r3.getInt(r102);     // Catch: Throwable -> L80
        int r103 = r24;
        if (r3.getInt(r103) == 0) goto L23;
        boolean r104 = true;
    L24:
        r90.p0 = r104;     // Catch: Throwable -> L80
        int r105 = r25;
        r90.q0 = r3.getString(r105);     // Catch: Throwable -> L80
        int r106 = r26;
        r90.r0 = r3.getString(r106);     // Catch: Throwable -> L80
        int r107 = r27;
        r90.s0 = r3.getString(r107);     // Catch: Throwable -> L80
        int r108 = r28;
        r90.t0 = r3.getString(r108);     // Catch: Throwable -> L80
        int r109 = r29;
        r90.v0 = r3.getString(r109);     // Catch: Throwable -> L80
        int r111 = r30;
        r90.w0 = r3.getString(r111);     // Catch: Throwable -> L80
        int r112 = r31;
        r90.x0 = r3.getString(r112);     // Catch: Throwable -> L80
        int r113 = r32;
        r90.y0 = r3.getInt(r113);     // Catch: Throwable -> L80
        int r114 = r33;
        r90.z0 = r3.getString(r114);     // Catch: Throwable -> L80
        int r115 = r89;
        r3.getString(r115);     // Catch: Throwable -> L80
        int r116 = r35;
        r90.a = r3.getString(r116);     // Catch: Throwable -> L80
        int r117 = r36;
        r90.b = r3.getString(r117);     // Catch: Throwable -> L80
        int r118 = r37;
        r90.c = r3.getString(r118);     // Catch: Throwable -> L80
        int r119 = r38;
        r90.d = r3.getString(r119);     // Catch: Throwable -> L80
        int r120 = r39;
        r90.e = r3.getString(r120);     // Catch: Throwable -> L80
        int r121 = r310;
        r90.f = r3.getString(r121);     // Catch: Throwable -> L80
        int r122 = r40;
        r3.getString(r122);     // Catch: Throwable -> L80
        r40 = r122;
        int r123 = r41;
        r90.g = r3.getString(r123);     // Catch: Throwable -> L80
        int r124 = r42;
        r90.h = r3.getString(r124);     // Catch: Throwable -> L80
        int r125 = r43;
        r90.i = r3.getString(r125);     // Catch: Throwable -> L80
        int r126 = r44;
        r90.j = r3.getString(r126);     // Catch: Throwable -> L80
        r45 = r45;
        if (r3.getInt(r45) == 0) goto L27;
        boolean r127 = true;
    L28:
        r90.k = r127;     // Catch: Throwable -> L80
        r46 = r46;
        if (r3.getInt(r46) == 0) goto L31;
        boolean r128 = true;
    L32:
        r90.l = r128;     // Catch: Throwable -> L80
        r47 = r47;
        if (r3.getInt(r47) == 0) goto L35;
        boolean r129 = true;
    L36:
        r90.m = r129;     // Catch: Throwable -> L80
        int r130 = r48;
        r90.n = r3.getString(r130);     // Catch: Throwable -> L80
        int r131 = r49;
        r90.o = r3.getString(r131);     // Catch: Throwable -> L80
        int r132 = r50;
        r90.p = r3.getString(r132);     // Catch: Throwable -> L80
        int r133 = r51;
        r90.q = r3.getInt(r133);     // Catch: Throwable -> L80
        r52 = r52;
        if (r3.getInt(r52) == 0) goto L39;
        boolean r134 = true;
    L40:
        r90.r = r134;     // Catch: Throwable -> L80
        r53 = r53;
        if (r3.getInt(r53) == 0) goto L43;
        boolean r135 = true;
    L44:
        r90.s = r135;     // Catch: Throwable -> L80
        r54 = r54;
        if (r3.getInt(r54) == 0) goto L47;
        boolean r136 = true;
    L48:
        r90.t = r136;     // Catch: Throwable -> L80
        int r137 = r55;
        r90.u = r3.getString(r137);     // Catch: Throwable -> L80
        int r910 = r5;
        int r138 = r56;
        int r510 = r4;
        r90.v = r3.getLong(r138);     // Catch: Throwable -> L80
        int r139 = r57;
        if (r3.getInt(r139) == 0) goto L51;
        boolean r140 = true;
    L52:
        r90.w = r140;     // Catch: Throwable -> L80
        int r141 = r58;
        r90.x = r3.getString(r141);     // Catch: Throwable -> L80
        int r142 = r59;
        r90.y = r3.getString(r142);     // Catch: Throwable -> L80
        r59 = r142;
        int r143 = r60;
        r90.z = r3.getString(r143);     // Catch: Throwable -> L80
        r60 = r143;
        int r144 = r61;
        r90.A = r3.getString(r144);     // Catch: Throwable -> L80
        r61 = r144;
        int r145 = r62;
        r90.B = r3.getInt(r145);     // Catch: Throwable -> L80
        r62 = r145;
        int r146 = r63;
        r90.C = r3.getInt(r146);     // Catch: Throwable -> L80
        r63 = r146;
        int r147 = r64;
        r90.D = r3.getInt(r147);     // Catch: Throwable -> L80
        int r148 = r65;
        r3.getInt(r148);     // Catch: Throwable -> L80
        r65 = r148;
        r64 = r147;
        int r149 = r66;
        r90.E = r3.getString(r149);     // Catch: Throwable -> L80
        r66 = r149;
        int r150 = r67;
        r90.F = r3.getString(r150);     // Catch: Throwable -> L80
        r67 = r150;
        int r151 = r68;
        r90.G = r3.getString(r151);     // Catch: Throwable -> L80
        r68 = r151;
        int r152 = r69;
        r90.H = r3.getInt(r152);     // Catch: Throwable -> L80
        r69 = r152;
        int r153 = r70;
        r90.I = r3.getString(r153);     // Catch: Throwable -> L80
        r70 = r153;
        int r154 = r71;
        r90.J = r3.getString(r154);     // Catch: Throwable -> L80
        r71 = r154;
        r72 = r72;
        r90.K = r3.getInt(r72);     // Catch: Throwable -> L80
        int r155 = r73;
        if (r3.getInt(r155) == 0) goto L55;
        boolean r156 = true;
    L56:
        r90.L = r156;     // Catch: Throwable -> L80
        r73 = r155;
        int r157 = r74;
        r90.M = r3.getInt(r157);     // Catch: Throwable -> L80
        r74 = r157;
        int r158 = r75;
        r90.N = r3.getString(r158);     // Catch: Throwable -> L80
        r75 = r158;
        int r159 = r76;
        r90.O = r3.getString(r159);     // Catch: Throwable -> L80
        r76 = r159;
        int r160 = r77;
        r90.Q = r3.getInt(r160);     // Catch: Throwable -> L80
        int r161 = r78;
        r78 = r161;
        if (r3.getInt(r161) == 0) goto L59;
        boolean r162 = true;
    L60:
        r90.R = r162;     // Catch: Throwable -> L80
        r77 = r160;
        int r163 = r79;
        r90.S = r3.getString(r163);     // Catch: Throwable -> L80
        r79 = r163;
        int r164 = r80;
        r90.T = r3.getInt(r164);     // Catch: Throwable -> L80
        int r165 = r81;
        r81 = r165;
        if (r3.getInt(r165) == 0) goto L63;
        boolean r166 = true;
    L64:
        r90.U = r166;     // Catch: Throwable -> L80
        r80 = r164;
        r82 = r82;
        r90.V = r3.getInt(r82);     // Catch: Throwable -> L80
        int r167 = r83;
        if (r3.getInt(r167) == 0) goto L67;
        boolean r168 = true;
    L68:
        r90.W = r168;     // Catch: Throwable -> L80
        r83 = r167;
        int r169 = r84;
        r90.u0 = r3.getString(r169);     // Catch: Throwable -> L80
        r84 = r169;
        int r170 = r85;
        r90.P = r3.getString(r170);     // Catch: Throwable -> L80
        r85 = r170;
        r86 = r86;
        r90.A0 = r3.getString(r86);     // Catch: Throwable -> L80
        int r171 = r87;
        if (r3.getInt(r171) == 0) goto L71;
        boolean r172 = true;
    L72:
        r90.B0 = r172;     // Catch: Throwable -> L80
        int r173 = r88;
        r88 = r173;
        if (r3.getInt(r173) == 0) goto L75;
        boolean r174 = true;
    L76:
        r90.C0 = r174;     // Catch: Throwable -> L80
        r0 = r91;
        r0.add(r90);     // Catch: Throwable -> L80
        r87 = r171;
        r1 = r110;
        r17 = r96;
        r18 = r97;
        r19 = r98;
        r20 = r99;
        r21 = r100;
        r22 = r101;
        r23 = r102;
        r24 = r103;
        r25 = r105;
        r26 = r106;
        r27 = r107;
        r28 = r108;
        r29 = r109;
        r30 = r111;
        r31 = r112;
        r32 = r113;
        r33 = r114;
        r89 = r115;
        r35 = r116;
        r36 = r117;
        r37 = r118;
        r38 = r119;
        r39 = r120;
        r310 = r121;
        r41 = r123;
        r42 = r124;
        r43 = r125;
        r44 = r126;
        r48 = r130;
        r49 = r131;
        r50 = r132;
        r51 = r133;
        r55 = r137;
        r57 = r139;
        r4 = r510;
        r56 = r138;
        r58 = r141;
        r5 = r910;
        goto L7
    L75:
        r174 = false;
        goto L76
    L71:
        r172 = false;
        goto L72
    L67:
        r168 = false;
        goto L68
    L63:
        r166 = false;
        goto L64
    L59:
        r162 = false;
        goto L60
    L55:
        r156 = false;
        goto L56
    L51:
        r140 = false;
        goto L52
    L47:
        r136 = false;
        goto L48
    L43:
        r135 = false;
        goto L44
    L39:
        r134 = false;
        goto L40
    L35:
        r129 = false;
        goto L36
    L31:
        r128 = false;
        goto L32
    L27:
        r127 = false;
        goto L28
    L23:
        r104 = false;
        goto L24
    L19:
        r95 = false;
        goto L20
    L15:
        r94 = false;
        goto L16
    L11:
        r92 = false;
        goto L12
    L78:
        r3.close();
        r16.release();
        return r0;
    L80:
        th = th;
    L84:
        r3.close();
        r16.release();
        throw th;
    L82:
        th = th;
        r16 = r2;
        goto L84
    }

    public final List<String> F(long r4) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT LT.obj_token FROM ListTypes AS LT LEFT OUTER JOIN DocMetaInfo AS DMI ON LT.obj_token = DMI.obj_token WHERE LT.list_type = 1 AND LT.open_time_recent > ?", 1);
        r0.bindLong(1, r4);
        this.a.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.a, r0, false, null);
        ArrayList r6 = new ArrayList(r5.getCount());     // Catch: Throwable -> L10
    L5:
        if (r5.moveToNext() == false) goto L8;
        r6.add(r5.getString(0));     // Catch: Throwable -> L10
        goto L5
    L8:
        r5.close();
        r0.release();
        return r6;
    L10:
        th = move-exception;
        r5.close();
        r0.release();
        throw th;
    }

    public final String G(String r5) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT obj_token FROM DocMetaInfo WHERE wiki_real_token =?", 1);
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.a.assertNotSuspendingTransaction();
        String r2 = null;
        Cursor r6 = DBUtil.query(this.a, r0, false, null);
    L12:
        th = move-exception;
        r6.close();
        r0.release();
        throw th;
    L8:
        if (r6.moveToFirst() == false) goto L10;
        r2 = r6.getString(0);     // Catch: Throwable -> L12
    L10:
        r6.close();
        r0.release();
        return r2;
    L5:
        r0.bindString(1, r5);
        goto L6
    }

    public final mc5.a I(String r9) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM CacheStatus WHERE obj_token = ?", 1);
        if (r9 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.a.assertNotSuspendingTransaction();
        mc5.a r2 = null;
        Cursor r10 = DBUtil.query(this.a, r0, false, null);
        int r1 = CursorUtil.getColumnIndexOrThrow(r10, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L12
        int r3 = CursorUtil.getColumnIndexOrThrow(r10, "doc_cache_status");     // Catch: Throwable -> L12
        int r4 = CursorUtil.getColumnIndexOrThrow(r10, "status_manualoffline");     // Catch: Throwable -> L12
        int r5 = CursorUtil.getColumnIndexOrThrow(r10, "obj_type");     // Catch: Throwable -> L12
        int r6 = CursorUtil.getColumnIndexOrThrow(r10, "download_type");     // Catch: Throwable -> L12
        if (r10.moveToFirst() == false) goto L10;
        r2 = new mc5.a();     // Catch: Throwable -> L12
        r2.a = r10.getString(r1);     // Catch: Throwable -> L12
        r2.b = r10.getInt(r3);     // Catch: Throwable -> L12
        r2.c = r10.getInt(r4);     // Catch: Throwable -> L12
        r2.d = r10.getInt(r5);     // Catch: Throwable -> L12
        r2.e = r10.getInt(r6);     // Catch: Throwable -> L12
    L10:
        r10.close();
        r0.release();
        return r2;
    L12:
        th = move-exception;
        r10.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r9);
        goto L6
    }

    public final so5.a J(String r18) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM TtsPlaybackBean WHERE obj_token = ?", 1);
        if (r18 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.a.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.a, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r3, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L14
        int r5 = CursorUtil.getColumnIndexOrThrow(r3, "obj_type");     // Catch: Throwable -> L14
        int r6 = CursorUtil.getColumnIndexOrThrow(r3, "title");     // Catch: Throwable -> L14
        int r7 = CursorUtil.getColumnIndexOrThrow(r3, "owner_name");     // Catch: Throwable -> L14
        int r8 = CursorUtil.getColumnIndexOrThrow(r3, "icon_info");     // Catch: Throwable -> L14
        int r9 = CursorUtil.getColumnIndexOrThrow(r3, "create_time_ms");     // Catch: Throwable -> L14
        int r10 = CursorUtil.getColumnIndexOrThrow(r3, "update_time_ms");     // Catch: Throwable -> L14
        int r11 = CursorUtil.getColumnIndexOrThrow(r3, "last_play_time_ms");     // Catch: Throwable -> L14
        int r12 = CursorUtil.getColumnIndexOrThrow(r3, "duration_ms");     // Catch: Throwable -> L14
        int r13 = CursorUtil.getColumnIndexOrThrow(r3, "progress_ms");     // Catch: Throwable -> L14
        int r14 = CursorUtil.getColumnIndexOrThrow(r3, "speed");     // Catch: Throwable -> L14
        int r15 = CursorUtil.getColumnIndexOrThrow(r3, "tone_id");     // Catch: Throwable -> L14
        int r4 = CursorUtil.getColumnIndexOrThrow(r3, "tone_name");     // Catch: Throwable -> L14
        if (r3.moveToFirst() == false) goto L11;
        so5.a r1 = new so5.a();     // Catch: Throwable -> L14
        r1.a = r3.getString(r0);     // Catch: Throwable -> L14
        r1.b = r3.getInt(r5);     // Catch: Throwable -> L14
        r1.c = r3.getString(r6);     // Catch: Throwable -> L14
        r1.d = r3.getString(r7);     // Catch: Throwable -> L14
        r1.e = r3.getString(r8);     // Catch: Throwable -> L14
        r1.f = r3.getLong(r9);     // Catch: Throwable -> L14
        r1.g = r3.getLong(r10);     // Catch: Throwable -> L14
        r1.h = r3.getLong(r11);     // Catch: Throwable -> L14
        r1.i = r3.getLong(r12);     // Catch: Throwable -> L14
        r1.j = r3.getLong(r13);     // Catch: Throwable -> L14
        r1.k = r3.getFloat(r14);     // Catch: Throwable -> L14
        r1.l = r3.getString(r15);     // Catch: Throwable -> L14
        r1.m = r3.getString(r4);     // Catch: Throwable -> L14
        so5.a r16 = r1;
    L12:
        r3.close();
        r2.release();
        return r16;
    L11:
        r16 = null;
    L14:
        th = move-exception;
        r3.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r18);
        goto L6
    }

    public final void W(String r5) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.N.acquire();
        r0.bindLong(1, 0);
        if (r5 != null) goto L5;
        r0.bindNull(2);
    L6:
        this.a.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.a.endTransaction();
        this.N.release(r0);
        return;
    L10:
        th = move-exception;
        this.a.endTransaction();
        this.N.release(r0);
        throw th;
    L5:
        r0.bindString(2, r5);
        goto L6
    }

    public final int a(String r3) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.P.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.a.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.a.endTransaction();
        this.P.release(r0);
        return r4;
    L10:
        th = move-exception;
        this.a.endTransaction();
        this.P.release(r0);
        throw th;
    L5:
        r0.bindString(1, r3);
        goto L6
    }

    public final int d(String r3) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.o.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.a.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.a.endTransaction();
        this.o.release(r0);
        return r4;
    L10:
        th = move-exception;
        this.a.endTransaction();
        this.o.release(r0);
        throw th;
    L5:
        r0.bindString(1, r3);
        goto L6
    }

    public final int e0(String r5) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.K.acquire();
        r0.bindLong(1, 1);
        if (r5 != null) goto L5;
        r0.bindNull(2);
    L6:
        this.a.beginTransaction();
        int r6 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.a.endTransaction();
        this.K.release(r0);
        return r6;
    L10:
        th = move-exception;
        this.a.endTransaction();
        this.K.release(r0);
        throw th;
    L5:
        r0.bindString(2, r5);
        goto L6
    }

    public final int g(int r5) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.z.acquire();
        r0.bindLong(1, r5);
        this.a.beginTransaction();
        int r6 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        this.z.release(r0);
        return r6;
    L6:
        th = move-exception;
        this.a.endTransaction();
        this.z.release(r0);
        throw th;
    }

    public final int h(String r4) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.H.acquire();
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, 3);
        this.a.beginTransaction();
        int r5 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.a.endTransaction();
        this.H.release(r0);
        return r5;
    L10:
        th = move-exception;
        this.a.endTransaction();
        this.H.release(r0);
        throw th;
    L5:
        r0.bindString(1, r4);
        goto L6
    }

    public final void j(int r5) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.L.acquire();
        r0.bindLong(1, 4);
        r0.bindLong(2, r5);
        this.a.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        this.L.release(r0);
        return;
    L6:
        th = move-exception;
        this.a.endTransaction();
        this.L.release(r0);
        throw th;
    }

    public final int m(String r3) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.R.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.a.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.a.endTransaction();
        this.R.release(r0);
        return r4;
    L10:
        th = move-exception;
        this.a.endTransaction();
        this.R.release(r0);
        throw th;
    L5:
        r0.bindString(1, r3);
        goto L6
    }

    public final LiveData<List<u1>> n(int r5) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ListTypes AS LT LEFT OUTER JOIN DocMetaInfo AS DMI ON LT.obj_token = DMI.obj_token WHERE LT.list_type = ?", 1);
        r0.bindLong(1, r5);
        return this.a.getInvalidationTracker().createLiveData(new String[]{"ListTypes", "DocMetaInfo"}, false, new a(this, r0));
    }

    public final long s(mc5.a r3) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        long r0 = this.f.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    }

    public final long t(v1 r3) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        long r0 = this.d.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    }

    public final long[] u(List<v1> r2) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        long[] r3 = this.d.insertAndReturnIdsArray(r2);     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    }

    public final long[] v(List<c> r2) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        long[] r3 = this.e.insertAndReturnIdsArray(r2);     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    }

    public final List<mc5.a> w(String r10) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM CacheStatus WHERE obj_token = ?", 1);
        if (r10 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.a.assertNotSuspendingTransaction();
        Cursor r11 = DBUtil.query(this.a, r0, false, null);
        int r1 = CursorUtil.getColumnIndexOrThrow(r11, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L14
        int r2 = CursorUtil.getColumnIndexOrThrow(r11, "doc_cache_status");     // Catch: Throwable -> L14
        int r3 = CursorUtil.getColumnIndexOrThrow(r11, "status_manualoffline");     // Catch: Throwable -> L14
        int r4 = CursorUtil.getColumnIndexOrThrow(r11, "obj_type");     // Catch: Throwable -> L14
        int r5 = CursorUtil.getColumnIndexOrThrow(r11, "download_type");     // Catch: Throwable -> L14
        ArrayList r6 = new ArrayList(r11.getCount());     // Catch: Throwable -> L14
    L9:
        if (r11.moveToNext() == false) goto L12;
        mc5.a r7 = new mc5.a();     // Catch: Throwable -> L14
        r7.a = r11.getString(r1);     // Catch: Throwable -> L14
        r7.b = r11.getInt(r2);     // Catch: Throwable -> L14
        r7.c = r11.getInt(r3);     // Catch: Throwable -> L14
        r7.d = r11.getInt(r4);     // Catch: Throwable -> L14
        r7.e = r11.getInt(r5);     // Catch: Throwable -> L14
        r6.add(r7);     // Catch: Throwable -> L14
        goto L9
    L12:
        r11.close();
        r0.release();
        return r6;
    L14:
        th = move-exception;
        r11.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r10);
        goto L6
    }

    public final mc5.b y(String r61) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM DocMetaInfo WHERE obj_token =?", 1);
        if (r61 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.a.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.a, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L78
        int r7 = CursorUtil.getColumnIndexOrThrow(r6, "name");     // Catch: Throwable -> L78
        int r8 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_TYPE);     // Catch: Throwable -> L78
        int r9 = CursorUtil.getColumnIndexOrThrow(r6, "owner_id");     // Catch: Throwable -> L78
        int r10 = CursorUtil.getColumnIndexOrThrow(r6, "create_tenant_id");     // Catch: Throwable -> L78
        int r11 = CursorUtil.getColumnIndexOrThrow(r6, "creator_cn_name");     // Catch: Throwable -> L78
        int r12 = CursorUtil.getColumnIndexOrThrow(r6, "creator_en_name");     // Catch: Throwable -> L78
        int r13 = CursorUtil.getColumnIndexOrThrow(r6, "edit_uid");     // Catch: Throwable -> L78
        int r14 = CursorUtil.getColumnIndexOrThrow(r6, "edit_time");     // Catch: Throwable -> L78
        int r15 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_URL);     // Catch: Throwable -> L78
        int r3 = CursorUtil.getColumnIndexOrThrow(r6, "fake_token");     // Catch: Throwable -> L78
        int r4 = CursorUtil.getColumnIndexOrThrow(r6, "is_stared");     // Catch: Throwable -> L78
        int r5 = CursorUtil.getColumnIndexOrThrow(r6, "is_pined");     // Catch: Throwable -> L78
        int r1 = CursorUtil.getColumnIndexOrThrow(r6, "is_subscribed");     // Catch: Throwable -> L78
        RoomSQLiteQuery r16 = r2;
        int r17 = CursorUtil.getColumnIndexOrThrow(r6, "extra_icon_url");     // Catch: Throwable -> L76
        int r18 = CursorUtil.getColumnIndexOrThrow(r6, "extra_icon_key");     // Catch: Throwable -> L76
        int r19 = CursorUtil.getColumnIndexOrThrow(r6, "extra_icon_nonce");     // Catch: Throwable -> L76
        int r20 = CursorUtil.getColumnIndexOrThrow(r6, "extra_icon_encrypted_type");     // Catch: Throwable -> L76
        int r21 = CursorUtil.getColumnIndexOrThrow(r6, "extra_copiable");     // Catch: Throwable -> L76
        int r22 = CursorUtil.getColumnIndexOrThrow(r6, "extra_is_share_root");     // Catch: Throwable -> L76
        int r23 = CursorUtil.getColumnIndexOrThrow(r6, "extra_is_external");     // Catch: Throwable -> L76
        int r24 = CursorUtil.getColumnIndexOrThrow(r6, "extra_sub_type");     // Catch: Throwable -> L76
        int r25 = CursorUtil.getColumnIndexOrThrow(r6, "obj_sub_type");     // Catch: Throwable -> L76
        int r26 = CursorUtil.getColumnIndexOrThrow(r6, "is_visited");     // Catch: Throwable -> L76
        int r27 = CursorUtil.getColumnIndexOrThrow(r6, "create_time");     // Catch: Throwable -> L76
        int r28 = CursorUtil.getColumnIndexOrThrow(r6, "thumbnail_url");     // Catch: Throwable -> L76
        int r29 = CursorUtil.getColumnIndexOrThrow(r6, "thumbnail_secret");     // Catch: Throwable -> L76
        int r30 = CursorUtil.getColumnIndexOrThrow(r6, "thumbnail_nonce");     // Catch: Throwable -> L76
        int r31 = CursorUtil.getColumnIndexOrThrow(r6, "thumbnail_type");     // Catch: Throwable -> L76
        int r32 = CursorUtil.getColumnIndexOrThrow(r6, "permission");     // Catch: Throwable -> L76
        int r33 = CursorUtil.getColumnIndexOrThrow(r6, "share_time");     // Catch: Throwable -> L76
        int r34 = CursorUtil.getColumnIndexOrThrow(r6, "share_version");     // Catch: Throwable -> L76
        int r35 = CursorUtil.getColumnIndexOrThrow(r6, "is_hidden");     // Catch: Throwable -> L76
        int r36 = CursorUtil.getColumnIndexOrThrow(r6, "need_sync");     // Catch: Throwable -> L76
        int r37 = CursorUtil.getColumnIndexOrThrow(r6, "size");     // Catch: Throwable -> L76
        int r38 = CursorUtil.getColumnIndexOrThrow(r6, "thumbnail");     // Catch: Throwable -> L76
        int r39 = CursorUtil.getColumnIndexOrThrow(r6, "document_icon_key");     // Catch: Throwable -> L76
        int r40 = CursorUtil.getColumnIndexOrThrow(r6, "document_icon_type");     // Catch: Throwable -> L76
        int r41 = CursorUtil.getColumnIndexOrThrow(r6, "document_icon_fsunit");     // Catch: Throwable -> L76
        int r42 = CursorUtil.getColumnIndexOrThrow(r6, "app_id");     // Catch: Throwable -> L76
        int r43 = CursorUtil.getColumnIndexOrThrow(r6, "doc_cache_status");     // Catch: Throwable -> L76
        int r44 = CursorUtil.getColumnIndexOrThrow(r6, "is_offline_create");     // Catch: Throwable -> L76
        int r45 = CursorUtil.getColumnIndexOrThrow(r6, "wiki_real_type");     // Catch: Throwable -> L76
        int r46 = CursorUtil.getColumnIndexOrThrow(r6, "wiki_real_token");     // Catch: Throwable -> L76
        int r47 = CursorUtil.getColumnIndexOrThrow(r6, "wiki_version");     // Catch: Throwable -> L76
        int r48 = CursorUtil.getColumnIndexOrThrow(r6, "owner_type");     // Catch: Throwable -> L76
        int r49 = CursorUtil.getColumnIndexOrThrow(r6, "is_share_folder");     // Catch: Throwable -> L76
        int r50 = CursorUtil.getColumnIndexOrThrow(r6, "security_name");     // Catch: Throwable -> L76
        int r51 = CursorUtil.getColumnIndexOrThrow(r6, "security_level");     // Catch: Throwable -> L76
        int r52 = CursorUtil.getColumnIndexOrThrow(r6, "is_secret_key_delete");     // Catch: Throwable -> L76
        int r53 = CursorUtil.getColumnIndexOrThrow(r6, "template_type");     // Catch: Throwable -> L76
        int r54 = CursorUtil.getColumnIndexOrThrow(r6, "is_insert");     // Catch: Throwable -> L76
        int r55 = CursorUtil.getColumnIndexOrThrow(r6, "organization_tag_value");     // Catch: Throwable -> L76
        int r56 = CursorUtil.getColumnIndexOrThrow(r6, "wiki_extra");     // Catch: Throwable -> L76
        int r57 = CursorUtil.getColumnIndexOrThrow(r6, "icon");     // Catch: Throwable -> L76
        int r58 = CursorUtil.getColumnIndexOrThrow(r6, "file_risk_tag");     // Catch: Throwable -> L76
        int r59 = CursorUtil.getColumnIndexOrThrow(r6, "is_wiki_home_page");     // Catch: Throwable -> L76
        if (r6.moveToFirst() == false) goto L73;
        mc5.b r60 = new mc5.b();     // Catch: Throwable -> L76
        r60.a = r6.getString(r0);     // Catch: Throwable -> L76
        r60.b = r6.getString(r7);     // Catch: Throwable -> L76
        r60.c = r6.getString(r8);     // Catch: Throwable -> L76
        r60.d = r6.getString(r9);     // Catch: Throwable -> L76
        r60.e = r6.getString(r10);     // Catch: Throwable -> L76
        r60.f = r6.getString(r11);     // Catch: Throwable -> L76
        r60.g = r6.getString(r12);     // Catch: Throwable -> L76
        r60.h = r6.getString(r13);     // Catch: Throwable -> L76
        r60.i = r6.getString(r14);     // Catch: Throwable -> L76
        r60.j = r6.getString(r15);     // Catch: Throwable -> L76
        r60.k = r6.getString(r3);     // Catch: Throwable -> L76
        if (r6.getInt(r4) == 0) goto L14;
        boolean r62 = true;
    L15:
        r60.l = r62;     // Catch: Throwable -> L76
        if (r6.getInt(r5) == 0) goto L18;
        boolean r63 = true;
    L19:
        r60.m = r63;     // Catch: Throwable -> L76
        if (r6.getInt(r1) == 0) goto L22;
        boolean r64 = true;
    L23:
        r60.n = r64;     // Catch: Throwable -> L76
        r60.o = r6.getString(r17);     // Catch: Throwable -> L76
        r60.p = r6.getString(r18);     // Catch: Throwable -> L76
        r60.q = r6.getString(r19);     // Catch: Throwable -> L76
        r60.r = r6.getInt(r20);     // Catch: Throwable -> L76
        if (r6.getInt(r21) == 0) goto L26;
        boolean r65 = true;
    L27:
        r60.s = r65;     // Catch: Throwable -> L76
        if (r6.getInt(r22) == 0) goto L30;
        boolean r66 = true;
    L31:
        r60.t = r66;     // Catch: Throwable -> L76
        if (r6.getInt(r23) == 0) goto L34;
        boolean r67 = true;
    L35:
        r60.u = r67;     // Catch: Throwable -> L76
        r60.v = r6.getString(r24);     // Catch: Throwable -> L76
        r60.w = r6.getLong(r25);     // Catch: Throwable -> L76
        if (r6.getInt(r26) == 0) goto L38;
        boolean r68 = true;
    L39:
        r60.x = r68;     // Catch: Throwable -> L76
        r60.y = r6.getString(r27);     // Catch: Throwable -> L76
        r60.z = r6.getString(r28);     // Catch: Throwable -> L76
        r60.A = r6.getString(r29);     // Catch: Throwable -> L76
        r60.B = r6.getString(r30);     // Catch: Throwable -> L76
        r60.C = r6.getInt(r31);     // Catch: Throwable -> L76
        r60.D = r6.getInt(r32);     // Catch: Throwable -> L76
        r60.E = r6.getString(r33);     // Catch: Throwable -> L76
        r60.F = r6.getInt(r34);     // Catch: Throwable -> L76
        if (r6.getInt(r35) == 0) goto L42;
        boolean r69 = true;
    L43:
        r60.G = r69;     // Catch: Throwable -> L76
        if (r6.getInt(r36) == 0) goto L46;
        boolean r70 = true;
    L47:
        r60.H = r70;     // Catch: Throwable -> L76
        r60.I = r6.getString(r37);     // Catch: Throwable -> L76
        r60.J = r6.getString(r38);     // Catch: Throwable -> L76
        r60.K = r6.getString(r39);     // Catch: Throwable -> L76
        r60.L = r6.getInt(r40);     // Catch: Throwable -> L76
        r60.M = r6.getString(r41);     // Catch: Throwable -> L76
        r60.N = r6.getString(r42);     // Catch: Throwable -> L76
        r60.O = r6.getInt(r43);     // Catch: Throwable -> L76
        if (r6.getInt(r44) == 0) goto L50;
        boolean r71 = true;
    L51:
        r60.P = r71;     // Catch: Throwable -> L76
        r60.Q = r6.getInt(r45);     // Catch: Throwable -> L76
        r60.R = r6.getString(r46);     // Catch: Throwable -> L76
        r60.S = r6.getString(r47);     // Catch: Throwable -> L76
        r60.T = r6.getInt(r48);     // Catch: Throwable -> L76
        if (r6.getInt(r49) == 0) goto L54;
        boolean r72 = true;
    L55:
        r60.U = r72;     // Catch: Throwable -> L76
        r60.V = r6.getString(r50);     // Catch: Throwable -> L76
        r60.W = r6.getInt(r51);     // Catch: Throwable -> L76
        if (r6.getInt(r52) == 0) goto L58;
        boolean r73 = true;
    L59:
        r60.X = r73;     // Catch: Throwable -> L76
        r60.Y = r6.getInt(r53);     // Catch: Throwable -> L76
        if (r6.getInt(r54) == 0) goto L62;
        boolean r74 = true;
    L63:
        r60.Z = r74;     // Catch: Throwable -> L76
        r60.a0 = r6.getString(r55);     // Catch: Throwable -> L76
        r60.b0 = r6.getString(r56);     // Catch: Throwable -> L76
        r60.c0 = r6.getString(r57);     // Catch: Throwable -> L76
        if (r6.getInt(r58) == 0) goto L66;
        boolean r75 = true;
    L67:
        r60.d0 = r75;     // Catch: Throwable -> L76
        if (r6.getInt(r59) == 0) goto L70;
        boolean r76 = true;
    L71:
        r60.e0 = r76;     // Catch: Throwable -> L76
        mc5.b r77 = r60;
    L74:
        r6.close();
        r16.release();
        return r77;
    L70:
        r76 = false;
        goto L71
    L66:
        r75 = false;
        goto L67
    L62:
        r74 = false;
        goto L63
    L58:
        r73 = false;
        goto L59
    L54:
        r72 = false;
        goto L55
    L50:
        r71 = false;
        goto L51
    L46:
        r70 = false;
        goto L47
    L42:
        r69 = false;
        goto L43
    L38:
        r68 = false;
        goto L39
    L34:
        r67 = false;
        goto L35
    L30:
        r66 = false;
        goto L31
    L26:
        r65 = false;
        goto L27
    L22:
        r64 = false;
        goto L23
    L18:
        r63 = false;
        goto L19
    L14:
        r62 = false;
        goto L15
    L73:
        r77 = null;
    L76:
        th = th;
    L80:
        r6.close();
        r16.release();
        throw th;
    L78:
        th = th;
        r16 = r2;
        goto L80
    L5:
        r2.bindString(1, r61);
        goto L6
    }

    public final LiveData B(String r6, String r7) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ListTypes AS LT LEFT OUTER JOIN DocMetaInfo AS DMI ON LT.obj_token = DMI.obj_token WHERE LT.list_type = ? AND LT.file_path= ? and DMI.type = ?", 3);
        r0.bindLong(1, 3);
        if (r6 != null) goto L5;
        r0.bindNull(2);
    L6:
        if (r7 != null) goto L8;
        r0.bindNull(3);
    L10:
        return this.a.getInvalidationTracker().createLiveData(new String[]{"ListTypes", "DocMetaInfo"}, false, new g1(this, r0));
    L8:
        r0.bindString(3, r7);
        goto L10
    L5:
        r0.bindString(2, r6);
        goto L6
    }

    public final int M(List<String> r5, int r6) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("UPDATE CacheStatus SET doc_cache_status = ");
        r0.append("?");
        r0.append(" WHERE obj_token IN(");
        StringUtil.appendPlaceholders(r0, r5.size());
        r0.append(")");
        SupportSQLiteStatement r1 = this.a.compileStatement(r0.toString());
        r1.bindLong(1, r6);
        Iterator<String> r7 = r5.iterator();
        int r8 = 2;
    L4:
        if (r7.hasNext() == false) goto L10;
        String r2 = r7.next();
        if (r2 != null) goto L8;
        r1.bindNull(r8);
    L9:
        r8 = r8 + 1;
        goto L4
    L8:
        r1.bindString(r8, r2);
        goto L9
    L10:
        this.a.beginTransaction();
        int r9 = r1.executeUpdateDelete();     // Catch: Throwable -> L14
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.a.endTransaction();
        return r9;
    L14:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    }

    public final int N(String r4, String r5) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.p.acquire();
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, 2);
        if (r4 != null) goto L9;
        r0.bindNull(3);
    L10:
        this.a.beginTransaction();
        int r6 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.a.endTransaction();
        this.p.release(r0);
        return r6;
    L14:
        th = move-exception;
        this.a.endTransaction();
        this.p.release(r0);
        throw th;
    L9:
        r0.bindString(3, r4);
        goto L10
    L5:
        r0.bindString(1, r5);
        goto L6
    }

    public final int Q(String r4, boolean r5) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.t.acquire();
        r0.bindLong(1, r5 ? 1 : 0);
        if (r4 != null) goto L5;
        r0.bindNull(2);
    L6:
        this.a.beginTransaction();
        int r6 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.a.endTransaction();
        this.t.release(r0);
        return r6;
    L10:
        th = move-exception;
        this.a.endTransaction();
        this.t.release(r0);
        throw th;
    L5:
        r0.bindString(2, r4);
        goto L6
    }

    public final int S(String r3, String r4) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.w.acquire();
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r3 != null) goto L9;
        r0.bindNull(2);
    L10:
        this.a.beginTransaction();
        int r5 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.a.endTransaction();
        this.w.release(r0);
        return r5;
    L14:
        th = move-exception;
        this.a.endTransaction();
        this.w.release(r0);
        throw th;
    L9:
        r0.bindString(2, r3);
        goto L10
    L5:
        r0.bindString(1, r4);
        goto L7
    }

    public final int T(String r4, boolean r5) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.u.acquire();
        r0.bindLong(1, r5 ? 1 : 0);
        if (r4 != null) goto L5;
        r0.bindNull(2);
    L6:
        this.a.beginTransaction();
        int r6 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.a.endTransaction();
        this.u.release(r0);
        return r6;
    L10:
        th = move-exception;
        this.a.endTransaction();
        this.u.release(r0);
        throw th;
    L5:
        r0.bindString(2, r4);
        goto L6
    }

    public final int U(String r4, boolean r5) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.v.acquire();
        r0.bindLong(1, r5 ? 1 : 0);
        if (r4 != null) goto L5;
        r0.bindNull(2);
    L6:
        this.a.beginTransaction();
        int r6 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.a.endTransaction();
        this.v.release(r0);
        return r6;
    L10:
        th = move-exception;
        this.a.endTransaction();
        this.v.release(r0);
        throw th;
    L5:
        r0.bindString(2, r4);
        goto L6
    }

    public final int V(String r5, String r6) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.s.acquire();
        r0.bindLong(1, 0);
        if (r5 != null) goto L5;
        r0.bindNull(2);
    L6:
        r0.bindLong(3, 3);
        if (r6 != null) goto L9;
        r0.bindNull(4);
    L10:
        this.a.beginTransaction();
        int r7 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.a.endTransaction();
        this.s.release(r0);
        return r7;
    L14:
        th = move-exception;
        this.a.endTransaction();
        this.s.release(r0);
        throw th;
    L9:
        r0.bindString(4, r6);
        goto L10
    L5:
        r0.bindString(2, r5);
        goto L6
    }

    public final int Z(String r5, int r6) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.y.acquire();
        r0.bindLong(1, r6);
        if (r5 != null) goto L5;
        r0.bindNull(2);
    L6:
        this.a.beginTransaction();
        int r7 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.a.endTransaction();
        this.y.release(r0);
        return r7;
    L10:
        th = move-exception;
        this.a.endTransaction();
        this.y.release(r0);
        throw th;
    L5:
        r0.bindString(2, r5);
        goto L6
    }

    public final int b(int r4, String r5) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.n.acquire();
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r4);
        this.a.beginTransaction();
        int r6 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.a.endTransaction();
        this.n.release(r0);
        return r6;
    L10:
        th = move-exception;
        this.a.endTransaction();
        this.n.release(r0);
        throw th;
    L5:
        r0.bindString(1, r5);
        goto L6
    }

    public final int b0(String r3, String r4) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.F.acquire();
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r3 != null) goto L9;
        r0.bindNull(2);
    L10:
        this.a.beginTransaction();
        int r5 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.a.endTransaction();
        this.F.release(r0);
        return r5;
    L14:
        th = move-exception;
        this.a.endTransaction();
        this.F.release(r0);
        throw th;
    L9:
        r0.bindString(2, r3);
        goto L10
    L5:
        r0.bindString(1, r4);
        goto L7
    }

    public final int c(int r6, List<String> r7) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("DELETE FROM ListTypes WHERE obj_token IN(");
        ArrayList r8 = (ArrayList) r7;
        int r1 = r8.size();
        StringUtil.appendPlaceholders(r0, r1);
        r0.append(") AND list_type = ");
        r0.append("?");
        SupportSQLiteStatement r2 = this.a.compileStatement(r0.toString());
        Iterator r9 = r8.iterator();
        int r3 = 1;
    L4:
        if (r9.hasNext() == false) goto L10;
        String r4 = (String) r9.next();
        if (r4 != null) goto L8;
        r2.bindNull(r3);
    L9:
        r3 = r3 + 1;
        goto L4
    L8:
        r2.bindString(r3, r4);
        goto L9
    L10:
        r2.bindLong(r1 + 1, r6);
        this.a.beginTransaction();
        int r10 = r2.executeUpdateDelete();     // Catch: Throwable -> L14
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.a.endTransaction();
        return r10;
    L14:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    }

    public final int c0(String r3, String r4) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.C.acquire();
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r3 != null) goto L9;
        r0.bindNull(2);
    L10:
        this.a.beginTransaction();
        int r5 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.a.endTransaction();
        this.C.release(r0);
        return r5;
    L14:
        th = move-exception;
        this.a.endTransaction();
        this.C.release(r0);
        throw th;
    L9:
        r0.bindString(2, r3);
        goto L10
    L5:
        r0.bindString(1, r4);
        goto L7
    }

    public final int f(int r5, boolean r6) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.J.acquire();
        r0.bindLong(1, 12);
        r0.bindLong(2, r6 ? 1 : 0);
        r0.bindLong(3, r5);
        this.a.beginTransaction();
        int r7 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        this.J.release(r0);
        return r7;
    L6:
        th = move-exception;
        this.a.endTransaction();
        this.J.release(r0);
        throw th;
    }

    public final int g0(String r3, String r4) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.D.acquire();
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r3 != null) goto L9;
        r0.bindNull(2);
    L10:
        this.a.beginTransaction();
        int r5 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.a.endTransaction();
        this.D.release(r0);
        return r5;
    L14:
        th = move-exception;
        this.a.endTransaction();
        this.D.release(r0);
        throw th;
    L9:
        r0.bindString(2, r3);
        goto L10
    L5:
        r0.bindString(1, r4);
        goto L7
    }

    public final int h0(String r4, String r5) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.E.acquire();
        r0.bindString(1, "");
        if (r5 != null) goto L5;
        r0.bindNull(2);
    L7:
        if (r4 != null) goto L9;
        r0.bindNull(3);
    L10:
        this.a.beginTransaction();
        int r6 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.a.endTransaction();
        this.E.release(r0);
        return r6;
    L14:
        th = move-exception;
        this.a.endTransaction();
        this.E.release(r0);
        throw th;
    L9:
        r0.bindString(3, r4);
        goto L10
    L5:
        r0.bindString(2, r5);
        goto L7
    }

    public final int i(int r5, int r6) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.M.acquire();
        r0.bindLong(1, r5);
        r0.bindLong(2, r6);
        this.a.beginTransaction();
        int r7 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        this.M.release(r0);
        return r7;
    L6:
        th = move-exception;
        this.a.endTransaction();
        this.M.release(r0);
        throw th;
    }

    public final u1 x(String r90, int r91) {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM ListTypes AS LT LEFT OUTER JOIN DocMetaInfo AS DMI ON LT.obj_token = DMI.obj_token WHERE LT.obj_token = ? AND LT.list_type = ?", 2);
        if (r90 != null) goto L5;
        r3.bindNull(1);
    L6:
        r3.bindLong(2, r91);
        this.a.assertNotSuspendingTransaction();
        Cursor r7 = DBUtil.query(this.a, r3, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r7, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L86
        int r8 = CursorUtil.getColumnIndexOrThrow(r7, "list_type");     // Catch: Throwable -> L86
        int r9 = CursorUtil.getColumnIndexOrThrow(r7, ResourceData.KEY_TOKEN);     // Catch: Throwable -> L86
        int r10 = CursorUtil.getColumnIndexOrThrow(r7, "extra");     // Catch: Throwable -> L86
        int r11 = CursorUtil.getColumnIndexOrThrow(r7, "space_id");     // Catch: Throwable -> L86
        int r12 = CursorUtil.getColumnIndexOrThrow(r7, "file_path");     // Catch: Throwable -> L86
        int r13 = CursorUtil.getColumnIndexOrThrow(r7, "add_time_manualoffline");     // Catch: Throwable -> L86
        int r14 = CursorUtil.getColumnIndexOrThrow(r7, "is_need_wifi_download");     // Catch: Throwable -> L86
        int r15 = CursorUtil.getColumnIndexOrThrow(r7, "open_time_recent");     // Catch: Throwable -> L86
        int r4 = CursorUtil.getColumnIndexOrThrow(r7, "my_edit_time_recent");     // Catch: Throwable -> L86
        int r5 = CursorUtil.getColumnIndexOrThrow(r7, "activity_time_recent");     // Catch: Throwable -> L86
        int r6 = CursorUtil.getColumnIndexOrThrow(r7, "has_perm_folder");     // Catch: Throwable -> L86
        int r1 = CursorUtil.getColumnIndexOrThrow(r7, "show_external_hint_folder");     // Catch: Throwable -> L86
        RoomSQLiteQuery r16 = r3;
        int r17 = CursorUtil.getColumnIndexOrThrow(r7, "node_type_folder");     // Catch: Throwable -> L84
        int r18 = CursorUtil.getColumnIndexOrThrow(r7, "shortcut_name_folder");     // Catch: Throwable -> L84
        int r19 = CursorUtil.getColumnIndexOrThrow(r7, "shortcut_owner_cn_name");     // Catch: Throwable -> L84
        int r20 = CursorUtil.getColumnIndexOrThrow(r7, "shortcut_owner_en_name");     // Catch: Throwable -> L84
        int r21 = CursorUtil.getColumnIndexOrThrow(r7, "shortcut_obj_biz_type");     // Catch: Throwable -> L84
        int r22 = CursorUtil.getColumnIndexOrThrow(r7, "shortcut_obj_node_token");     // Catch: Throwable -> L84
        int r23 = CursorUtil.getColumnIndexOrThrow(r7, "shortcut_obj_delete_flag");     // Catch: Throwable -> L84
        int r24 = CursorUtil.getColumnIndexOrThrow(r7, "is_hidden_share");     // Catch: Throwable -> L84
        int r25 = CursorUtil.getColumnIndexOrThrow(r7, "share_time_share");     // Catch: Throwable -> L84
        int r26 = CursorUtil.getColumnIndexOrThrow(r7, "sharer_en_name");     // Catch: Throwable -> L84
        int r27 = CursorUtil.getColumnIndexOrThrow(r7, "sharer_cn_name");     // Catch: Throwable -> L84
        int r28 = CursorUtil.getColumnIndexOrThrow(r7, "star_time_star");     // Catch: Throwable -> L84
        int r29 = CursorUtil.getColumnIndexOrThrow(r7, "shortcut_thumbnail_url");     // Catch: Throwable -> L84
        int r30 = CursorUtil.getColumnIndexOrThrow(r7, "shortcut_thumbnail_secret");     // Catch: Throwable -> L84
        int r31 = CursorUtil.getColumnIndexOrThrow(r7, "shortcut_thumbnail_nonce");     // Catch: Throwable -> L84
        int r32 = CursorUtil.getColumnIndexOrThrow(r7, "shortcut_thumbnail_type");     // Catch: Throwable -> L84
        int r33 = CursorUtil.getColumnIndexOrThrow(r7, "shortcut_thumbnail");     // Catch: Throwable -> L84
        int r34 = CursorUtil.getColumnIndexOrThrow(r7, "subordinate_id");     // Catch: Throwable -> L84
        int r2 = CursorUtil.getColumnIndexOrThrow(r7, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L84
        int r35 = CursorUtil.getColumnIndexOrThrow(r7, "name");     // Catch: Throwable -> L84
        int r36 = CursorUtil.getColumnIndexOrThrow(r7, ResourceData.KEY_TYPE);     // Catch: Throwable -> L84
        int r37 = CursorUtil.getColumnIndexOrThrow(r7, "owner_id");     // Catch: Throwable -> L84
        int r38 = CursorUtil.getColumnIndexOrThrow(r7, "create_tenant_id");     // Catch: Throwable -> L84
        int r39 = CursorUtil.getColumnIndexOrThrow(r7, "creator_cn_name");     // Catch: Throwable -> L84
        int r40 = CursorUtil.getColumnIndexOrThrow(r7, "creator_en_name");     // Catch: Throwable -> L84
        int r41 = CursorUtil.getColumnIndexOrThrow(r7, "edit_uid");     // Catch: Throwable -> L84
        int r42 = CursorUtil.getColumnIndexOrThrow(r7, "edit_time");     // Catch: Throwable -> L84
        int r43 = CursorUtil.getColumnIndexOrThrow(r7, ResourceData.KEY_URL);     // Catch: Throwable -> L84
        int r44 = CursorUtil.getColumnIndexOrThrow(r7, "fake_token");     // Catch: Throwable -> L84
        int r45 = CursorUtil.getColumnIndexOrThrow(r7, "is_stared");     // Catch: Throwable -> L84
        int r46 = CursorUtil.getColumnIndexOrThrow(r7, "is_pined");     // Catch: Throwable -> L84
        int r47 = CursorUtil.getColumnIndexOrThrow(r7, "is_subscribed");     // Catch: Throwable -> L84
        int r48 = CursorUtil.getColumnIndexOrThrow(r7, "extra_icon_url");     // Catch: Throwable -> L84
        int r49 = CursorUtil.getColumnIndexOrThrow(r7, "extra_icon_key");     // Catch: Throwable -> L84
        int r50 = CursorUtil.getColumnIndexOrThrow(r7, "extra_icon_nonce");     // Catch: Throwable -> L84
        int r51 = CursorUtil.getColumnIndexOrThrow(r7, "extra_icon_encrypted_type");     // Catch: Throwable -> L84
        int r52 = CursorUtil.getColumnIndexOrThrow(r7, "extra_copiable");     // Catch: Throwable -> L84
        int r53 = CursorUtil.getColumnIndexOrThrow(r7, "extra_is_share_root");     // Catch: Throwable -> L84
        int r54 = CursorUtil.getColumnIndexOrThrow(r7, "extra_is_external");     // Catch: Throwable -> L84
        int r55 = CursorUtil.getColumnIndexOrThrow(r7, "extra_sub_type");     // Catch: Throwable -> L84
        int r56 = CursorUtil.getColumnIndexOrThrow(r7, "obj_sub_type");     // Catch: Throwable -> L84
        int r57 = CursorUtil.getColumnIndexOrThrow(r7, "is_visited");     // Catch: Throwable -> L84
        int r58 = CursorUtil.getColumnIndexOrThrow(r7, "create_time");     // Catch: Throwable -> L84
        int r59 = CursorUtil.getColumnIndexOrThrow(r7, "thumbnail_url");     // Catch: Throwable -> L84
        int r60 = CursorUtil.getColumnIndexOrThrow(r7, "thumbnail_secret");     // Catch: Throwable -> L84
        int r61 = CursorUtil.getColumnIndexOrThrow(r7, "thumbnail_nonce");     // Catch: Throwable -> L84
        int r62 = CursorUtil.getColumnIndexOrThrow(r7, "thumbnail_type");     // Catch: Throwable -> L84
        int r63 = CursorUtil.getColumnIndexOrThrow(r7, "permission");     // Catch: Throwable -> L84
        int r64 = CursorUtil.getColumnIndexOrThrow(r7, "share_version");     // Catch: Throwable -> L84
        int r65 = CursorUtil.getColumnIndexOrThrow(r7, "need_sync");     // Catch: Throwable -> L84
        int r66 = CursorUtil.getColumnIndexOrThrow(r7, "size");     // Catch: Throwable -> L84
        int r67 = CursorUtil.getColumnIndexOrThrow(r7, "thumbnail");     // Catch: Throwable -> L84
        int r68 = CursorUtil.getColumnIndexOrThrow(r7, "document_icon_key");     // Catch: Throwable -> L84
        int r69 = CursorUtil.getColumnIndexOrThrow(r7, "document_icon_type");     // Catch: Throwable -> L84
        int r70 = CursorUtil.getColumnIndexOrThrow(r7, "document_icon_fsunit");     // Catch: Throwable -> L84
        int r71 = CursorUtil.getColumnIndexOrThrow(r7, "app_id");     // Catch: Throwable -> L84
        int r72 = CursorUtil.getColumnIndexOrThrow(r7, "doc_cache_status");     // Catch: Throwable -> L84
        int r73 = CursorUtil.getColumnIndexOrThrow(r7, "is_offline_create");     // Catch: Throwable -> L84
        int r74 = CursorUtil.getColumnIndexOrThrow(r7, "wiki_real_type");     // Catch: Throwable -> L84
        int r75 = CursorUtil.getColumnIndexOrThrow(r7, "wiki_real_token");     // Catch: Throwable -> L84
        int r76 = CursorUtil.getColumnIndexOrThrow(r7, "wiki_version");     // Catch: Throwable -> L84
        int r77 = CursorUtil.getColumnIndexOrThrow(r7, "owner_type");     // Catch: Throwable -> L84
        int r78 = CursorUtil.getColumnIndexOrThrow(r7, "is_share_folder");     // Catch: Throwable -> L84
        int r79 = CursorUtil.getColumnIndexOrThrow(r7, "security_name");     // Catch: Throwable -> L84
        int r80 = CursorUtil.getColumnIndexOrThrow(r7, "security_level");     // Catch: Throwable -> L84
        int r81 = CursorUtil.getColumnIndexOrThrow(r7, "is_secret_key_delete");     // Catch: Throwable -> L84
        int r82 = CursorUtil.getColumnIndexOrThrow(r7, "template_type");     // Catch: Throwable -> L84
        int r83 = CursorUtil.getColumnIndexOrThrow(r7, "is_insert");     // Catch: Throwable -> L84
        int r84 = CursorUtil.getColumnIndexOrThrow(r7, "organization_tag_value");     // Catch: Throwable -> L84
        int r85 = CursorUtil.getColumnIndexOrThrow(r7, "wiki_extra");     // Catch: Throwable -> L84
        int r86 = CursorUtil.getColumnIndexOrThrow(r7, "icon");     // Catch: Throwable -> L84
        int r87 = CursorUtil.getColumnIndexOrThrow(r7, "file_risk_tag");     // Catch: Throwable -> L84
        int r88 = CursorUtil.getColumnIndexOrThrow(r7, "is_wiki_home_page");     // Catch: Throwable -> L84
        if (r7.moveToFirst() == false) goto L81;
        u1 r89 = new u1();     // Catch: Throwable -> L84
        r89.a = r7.getString(r0);     // Catch: Throwable -> L84
        r7.getInt(r8);     // Catch: Throwable -> L84
        r89.X = r7.getString(r9);     // Catch: Throwable -> L84
        r89.Y = r7.getString(r10);     // Catch: Throwable -> L84
        r89.Z = r7.getString(r11);     // Catch: Throwable -> L84
        r89.a0 = r7.getString(r12);     // Catch: Throwable -> L84
        r89.b0 = r7.getString(r13);     // Catch: Throwable -> L84
        if (r7.getInt(r14) == 0) goto L14;
        boolean r92 = true;
    L15:
        r89.c0 = r92;     // Catch: Throwable -> L84
        r89.d0 = r7.getString(r15);     // Catch: Throwable -> L84
        r89.e0 = r7.getString(r4);     // Catch: Throwable -> L84
        r89.f0 = r7.getString(r5);     // Catch: Throwable -> L84
        if (r7.getInt(r6) == 0) goto L18;
        boolean r93 = true;
    L19:
        r89.g0 = r93;     // Catch: Throwable -> L84
        if (r7.getInt(r1) == 0) goto L22;
        boolean r94 = true;
    L23:
        r89.h0 = r94;     // Catch: Throwable -> L84
        r89.i0 = r7.getInt(r17);     // Catch: Throwable -> L84
        r89.j0 = r7.getString(r18);     // Catch: Throwable -> L84
        r89.k0 = r7.getString(r19);     // Catch: Throwable -> L84
        r89.l0 = r7.getString(r20);     // Catch: Throwable -> L84
        r89.m0 = r7.getInt(r21);     // Catch: Throwable -> L84
        r89.n0 = r7.getString(r22);     // Catch: Throwable -> L84
        r89.o0 = r7.getInt(r23);     // Catch: Throwable -> L84
        if (r7.getInt(r24) == 0) goto L26;
        boolean r95 = true;
    L27:
        r89.p0 = r95;     // Catch: Throwable -> L84
        r89.q0 = r7.getString(r25);     // Catch: Throwable -> L84
        r89.r0 = r7.getString(r26);     // Catch: Throwable -> L84
        r89.s0 = r7.getString(r27);     // Catch: Throwable -> L84
        r89.t0 = r7.getString(r28);     // Catch: Throwable -> L84
        r89.v0 = r7.getString(r29);     // Catch: Throwable -> L84
        r89.w0 = r7.getString(r30);     // Catch: Throwable -> L84
        r89.x0 = r7.getString(r31);     // Catch: Throwable -> L84
        r89.y0 = r7.getInt(r32);     // Catch: Throwable -> L84
        r89.z0 = r7.getString(r33);     // Catch: Throwable -> L84
        r7.getString(r34);     // Catch: Throwable -> L84
        r89.a = r7.getString(r2);     // Catch: Throwable -> L84
        r89.b = r7.getString(r35);     // Catch: Throwable -> L84
        r89.c = r7.getString(r36);     // Catch: Throwable -> L84
        r89.d = r7.getString(r37);     // Catch: Throwable -> L84
        r89.e = r7.getString(r38);     // Catch: Throwable -> L84
        r89.f = r7.getString(r39);     // Catch: Throwable -> L84
        r7.getString(r40);     // Catch: Throwable -> L84
        r89.g = r7.getString(r41);     // Catch: Throwable -> L84
        r89.h = r7.getString(r42);     // Catch: Throwable -> L84
        r89.i = r7.getString(r43);     // Catch: Throwable -> L84
        r89.j = r7.getString(r44);     // Catch: Throwable -> L84
        if (r7.getInt(r45) == 0) goto L30;
        boolean r96 = true;
    L31:
        r89.k = r96;     // Catch: Throwable -> L84
        if (r7.getInt(r46) == 0) goto L34;
        boolean r97 = true;
    L35:
        r89.l = r97;     // Catch: Throwable -> L84
        if (r7.getInt(r47) == 0) goto L38;
        boolean r98 = true;
    L39:
        r89.m = r98;     // Catch: Throwable -> L84
        r89.n = r7.getString(r48);     // Catch: Throwable -> L84
        r89.o = r7.getString(r49);     // Catch: Throwable -> L84
        r89.p = r7.getString(r50);     // Catch: Throwable -> L84
        r89.q = r7.getInt(r51);     // Catch: Throwable -> L84
        if (r7.getInt(r52) == 0) goto L42;
        boolean r99 = true;
    L43:
        r89.r = r99;     // Catch: Throwable -> L84
        if (r7.getInt(r53) == 0) goto L46;
        boolean r100 = true;
    L47:
        r89.s = r100;     // Catch: Throwable -> L84
        if (r7.getInt(r54) == 0) goto L50;
        boolean r101 = true;
    L51:
        r89.t = r101;     // Catch: Throwable -> L84
        r89.u = r7.getString(r55);     // Catch: Throwable -> L84
        r89.v = r7.getLong(r56);     // Catch: Throwable -> L84
        if (r7.getInt(r57) == 0) goto L54;
        boolean r102 = true;
    L55:
        r89.w = r102;     // Catch: Throwable -> L84
        r89.x = r7.getString(r58);     // Catch: Throwable -> L84
        r89.y = r7.getString(r59);     // Catch: Throwable -> L84
        r89.z = r7.getString(r60);     // Catch: Throwable -> L84
        r89.A = r7.getString(r61);     // Catch: Throwable -> L84
        r89.B = r7.getInt(r62);     // Catch: Throwable -> L84
        r89.C = r7.getInt(r63);     // Catch: Throwable -> L84
        r89.D = r7.getInt(r64);     // Catch: Throwable -> L84
        r7.getInt(r65);     // Catch: Throwable -> L84
        r89.E = r7.getString(r66);     // Catch: Throwable -> L84
        r89.F = r7.getString(r67);     // Catch: Throwable -> L84
        r89.G = r7.getString(r68);     // Catch: Throwable -> L84
        r89.H = r7.getInt(r69);     // Catch: Throwable -> L84
        r89.I = r7.getString(r70);     // Catch: Throwable -> L84
        r89.J = r7.getString(r71);     // Catch: Throwable -> L84
        r89.K = r7.getInt(r72);     // Catch: Throwable -> L84
        if (r7.getInt(r73) == 0) goto L58;
        boolean r103 = true;
    L59:
        r89.L = r103;     // Catch: Throwable -> L84
        r89.M = r7.getInt(r74);     // Catch: Throwable -> L84
        r89.N = r7.getString(r75);     // Catch: Throwable -> L84
        r89.O = r7.getString(r76);     // Catch: Throwable -> L84
        r89.Q = r7.getInt(r77);     // Catch: Throwable -> L84
        if (r7.getInt(r78) == 0) goto L62;
        boolean r104 = true;
    L63:
        r89.R = r104;     // Catch: Throwable -> L84
        r89.S = r7.getString(r79);     // Catch: Throwable -> L84
        r89.T = r7.getInt(r80);     // Catch: Throwable -> L84
        if (r7.getInt(r81) == 0) goto L66;
        boolean r105 = true;
    L67:
        r89.U = r105;     // Catch: Throwable -> L84
        r89.V = r7.getInt(r82);     // Catch: Throwable -> L84
        if (r7.getInt(r83) == 0) goto L70;
        boolean r106 = true;
    L71:
        r89.W = r106;     // Catch: Throwable -> L84
        r89.u0 = r7.getString(r84);     // Catch: Throwable -> L84
        r89.P = r7.getString(r85);     // Catch: Throwable -> L84
        r89.A0 = r7.getString(r86);     // Catch: Throwable -> L84
        if (r7.getInt(r87) == 0) goto L74;
        boolean r107 = true;
    L75:
        r89.B0 = r107;     // Catch: Throwable -> L84
        if (r7.getInt(r88) == 0) goto L78;
        boolean r108 = true;
    L79:
        r89.C0 = r108;     // Catch: Throwable -> L84
        u1 r109 = r89;
    L82:
        r7.close();
        r16.release();
        return r109;
    L78:
        r108 = false;
        goto L79
    L74:
        r107 = false;
        goto L75
    L70:
        r106 = false;
        goto L71
    L66:
        r105 = false;
        goto L67
    L62:
        r104 = false;
        goto L63
    L58:
        r103 = false;
        goto L59
    L54:
        r102 = false;
        goto L55
    L50:
        r101 = false;
        goto L51
    L46:
        r100 = false;
        goto L47
    L42:
        r99 = false;
        goto L43
    L38:
        r98 = false;
        goto L39
    L34:
        r97 = false;
        goto L35
    L30:
        r96 = false;
        goto L31
    L26:
        r95 = false;
        goto L27
    L22:
        r94 = false;
        goto L23
    L18:
        r93 = false;
        goto L19
    L14:
        r92 = false;
        goto L15
    L81:
        r109 = null;
    L84:
        th = th;
    L88:
        r7.close();
        r16.release();
        throw th;
    L86:
        th = th;
        r16 = r3;
        goto L88
    L5:
        r3.bindString(1, r90);
        goto L6
    }

    public final int P(String r3, String r4, String r5) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.q.acquire();
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r5 != null) goto L9;
        r0.bindNull(2);
    L11:
        if (r3 != null) goto L13;
        r0.bindNull(3);
    L14:
        this.a.beginTransaction();
        int r6 = r0.executeUpdateDelete();     // Catch: Throwable -> L18
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L18
        this.a.endTransaction();
        this.q.release(r0);
        return r6;
    L18:
        th = move-exception;
        this.a.endTransaction();
        this.q.release(r0);
        throw th;
    L13:
        r0.bindString(3, r3);
        goto L14
    L9:
        r0.bindString(2, r5);
        goto L11
    L5:
        r0.bindString(1, r4);
        goto L7
    }

    public final int R(String r4, String r5, int r6) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.x.acquire();
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r6);
        if (r4 != null) goto L9;
        r0.bindNull(3);
    L10:
        this.a.beginTransaction();
        int r7 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.a.endTransaction();
        this.x.release(r0);
        return r7;
    L14:
        th = move-exception;
        this.a.endTransaction();
        this.x.release(r0);
        throw th;
    L9:
        r0.bindString(3, r4);
        goto L10
    L5:
        r0.bindString(1, r5);
        goto L6
    }

    public final int X(String r4, String r5, List<Integer> r6) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("UPDATE ListTypes SET obj_token = ");
        r0.append("?");
        r0.append(" WHERE obj_token =");
        r0.append("?");
        r0.append(" AND list_type IN (");
        ArrayList r7 = (ArrayList) r6;
        StringUtil.appendPlaceholders(r0, r7.size());
        r0.append(")");
        SupportSQLiteStatement r1 = this.a.compileStatement(r0.toString());
        if (r5 != null) goto L5;
        r1.bindNull(1);
    L7:
        if (r4 != null) goto L9;
        r1.bindNull(2);
    L10:
        Iterator r8 = r7.iterator();
        int r9 = 3;
    L12:
        if (r8.hasNext() == false) goto L18;
        Integer r10 = (Integer) r8.next();
        if (r10 != null) goto L16;
        r1.bindNull(r9);
    L17:
        r9 = r9 + 1;
        goto L12
    L16:
        r1.bindLong(r9, r10.intValue());
        goto L17
    L18:
        this.a.beginTransaction();
        int r11 = r1.executeUpdateDelete();     // Catch: Throwable -> L22
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L22
        this.a.endTransaction();
        return r11;
    L22:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    L9:
        r1.bindString(2, r4);
        goto L10
    L5:
        r1.bindString(1, r5);
        goto L7
    }

    public final LiveData<List<u1>> z(int r6, int r7, boolean r8) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ListTypes AS LT LEFT OUTER JOIN DocMetaInfo AS DMI ON LT.obj_token = DMI.obj_token WHERE LT.list_type = ? AND DMI.type = ? AND LT.is_hidden_share =?", 3);
        r0.bindLong(1, r6);
        r0.bindLong(2, r7);
        r0.bindLong(3, r8 ? 1 : 0);
        return this.a.getInvalidationTracker().createLiveData(new String[]{"ListTypes", "DocMetaInfo"}, false, new b(this, r0));
    }

    public final int Y(String r4, String r5, String r6, List<Integer> r7) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("UPDATE ListTypes SET obj_token = ");
        r0.append("?");
        r0.append(", token = ");
        r0.append("?");
        r0.append(" WHERE obj_token =");
        r0.append("?");
        r0.append(" AND list_type NOT IN (");
        ArrayList r8 = (ArrayList) r7;
        StringUtil.appendPlaceholders(r0, r8.size());
        r0.append(")");
        SupportSQLiteStatement r1 = this.a.compileStatement(r0.toString());
        if (r5 != null) goto L5;
        r1.bindNull(1);
    L7:
        if (r6 != null) goto L9;
        r1.bindNull(2);
    L11:
        if (r4 != null) goto L13;
        r1.bindNull(3);
    L14:
        Iterator r9 = r8.iterator();
        int r10 = 4;
    L16:
        if (r9.hasNext() == false) goto L22;
        Integer r11 = (Integer) r9.next();
        if (r11 != null) goto L20;
        r1.bindNull(r10);
    L21:
        r10 = r10 + 1;
        goto L16
    L20:
        r1.bindLong(r10, r11.intValue());
        goto L21
    L22:
        this.a.beginTransaction();
        int r12 = r1.executeUpdateDelete();     // Catch: Throwable -> L26
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L26
        this.a.endTransaction();
        return r12;
    L26:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    L13:
        r1.bindString(3, r4);
        goto L14
    L9:
        r1.bindString(2, r6);
        goto L11
    L5:
        r1.bindString(1, r5);
        goto L7
    }

    public final int d0(String r3, String r4, String r5, String r6) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.G.acquire();
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r6 != null) goto L9;
        r0.bindNull(2);
    L11:
        if (r5 != null) goto L13;
        r0.bindNull(3);
    L15:
        if (r3 != null) goto L17;
        r0.bindNull(4);
    L18:
        this.a.beginTransaction();
        int r7 = r0.executeUpdateDelete();     // Catch: Throwable -> L22
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L22
        this.a.endTransaction();
        this.G.release(r0);
        return r7;
    L22:
        th = move-exception;
        this.a.endTransaction();
        this.G.release(r0);
        throw th;
    L17:
        r0.bindString(4, r3);
        goto L18
    L13:
        r0.bindString(3, r5);
        goto L15
    L9:
        r0.bindString(2, r6);
        goto L11
    L5:
        r0.bindString(1, r4);
        goto L7
    }

    public final int e(int r5, int r6, String r7, int r8, boolean r9, String r10) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.k.acquire();
        r0.bindLong(1, r5);
        r0.bindLong(2, r6);
        if (r7 != null) goto L5;
        r0.bindNull(3);
    L6:
        r0.bindLong(4, r8);
        r0.bindLong(5, r9 ? 1 : 0);
        if (r10 != null) goto L9;
        r0.bindNull(6);
    L10:
        this.a.beginTransaction();
        int r11 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.a.endTransaction();
        this.k.release(r0);
        return r11;
    L14:
        th = move-exception;
        this.a.endTransaction();
        this.k.release(r0);
        throw th;
    L9:
        r0.bindString(6, r10);
        goto L10
    L5:
        r0.bindString(3, r7);
        goto L6
    }

    public final List<d> o(int r91, int r92, String r93, int r94, boolean r95, String r96) {
        RoomSQLiteQuery r5 = RoomSQLiteQuery.acquire("SELECT * FROM FilterCache AS FC JOIN DocMetaInfo AS DMI ON FC.obj_token = DMI.obj_token WHERE FC.list_type =? AND FC.filter_type =? AND FC.file_type =? AND FC.strategy =? AND FC.is_asc =? AND FC.file_path =? ORDER BY FC.id", 6);
        r5.bindLong(1, r91);
        r5.bindLong(2, r92);
        if (r93 != null) goto L5;
        r5.bindNull(3);
    L6:
        r5.bindLong(4, r94);
        r5.bindLong(5, r95 ? 1 : 0);
        if (r96 != null) goto L9;
        r5.bindNull(6);
    L10:
        this.a.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.a, r5, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "list_type");     // Catch: Throwable -> L78
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "filter_type");     // Catch: Throwable -> L78
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "file_type");     // Catch: Throwable -> L78
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "strategy");     // Catch: Throwable -> L78
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "is_asc");     // Catch: Throwable -> L78
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L78
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "file_path");     // Catch: Throwable -> L78
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, ResourceData.KEY_TOKEN);     // Catch: Throwable -> L78
        int r15 = CursorUtil.getColumnIndexOrThrow(r2, "extra");     // Catch: Throwable -> L78
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "space_id");     // Catch: Throwable -> L78
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "add_time_manualoffline");     // Catch: Throwable -> L78
        int r1 = CursorUtil.getColumnIndexOrThrow(r2, "is_need_wifi_download");     // Catch: Throwable -> L78
        RoomSQLiteQuery r16 = r5;
        int r97 = CursorUtil.getColumnIndexOrThrow(r2, "open_time_recent");     // Catch: Throwable -> L76
        int r98 = CursorUtil.getColumnIndexOrThrow(r2, "my_edit_time_recent");     // Catch: Throwable -> L76
        int r99 = CursorUtil.getColumnIndexOrThrow(r2, "activity_time_recent");     // Catch: Throwable -> L76
        int r910 = CursorUtil.getColumnIndexOrThrow(r2, "has_perm_folder");     // Catch: Throwable -> L76
        int r911 = CursorUtil.getColumnIndexOrThrow(r2, "show_external_hint_folder");     // Catch: Throwable -> L76
        int r17 = CursorUtil.getColumnIndexOrThrow(r2, "node_type_folder");     // Catch: Throwable -> L76
        int r18 = CursorUtil.getColumnIndexOrThrow(r2, "shortcut_name_folder");     // Catch: Throwable -> L76
        int r19 = CursorUtil.getColumnIndexOrThrow(r2, "shortcut_owner_cn_name");     // Catch: Throwable -> L76
        int r20 = CursorUtil.getColumnIndexOrThrow(r2, "shortcut_owner_en_name");     // Catch: Throwable -> L76
        int r21 = CursorUtil.getColumnIndexOrThrow(r2, "shortcut_obj_biz_type");     // Catch: Throwable -> L76
        int r22 = CursorUtil.getColumnIndexOrThrow(r2, "shortcut_obj_node_token");     // Catch: Throwable -> L76
        int r23 = CursorUtil.getColumnIndexOrThrow(r2, "is_hidden_share");     // Catch: Throwable -> L76
        int r24 = CursorUtil.getColumnIndexOrThrow(r2, "share_time_share");     // Catch: Throwable -> L76
        int r25 = CursorUtil.getColumnIndexOrThrow(r2, "sharer_en_name");     // Catch: Throwable -> L76
        int r26 = CursorUtil.getColumnIndexOrThrow(r2, "sharer_cn_name");     // Catch: Throwable -> L76
        int r27 = CursorUtil.getColumnIndexOrThrow(r2, "star_time_star");     // Catch: Throwable -> L76
        int r28 = CursorUtil.getColumnIndexOrThrow(r2, "shortcut_thumbnail_url");     // Catch: Throwable -> L76
        int r29 = CursorUtil.getColumnIndexOrThrow(r2, "shortcut_thumbnail_secret");     // Catch: Throwable -> L76
        int r30 = CursorUtil.getColumnIndexOrThrow(r2, "shortcut_thumbnail_nonce");     // Catch: Throwable -> L76
        int r31 = CursorUtil.getColumnIndexOrThrow(r2, "shortcut_thumbnail_type");     // Catch: Throwable -> L76
        int r32 = CursorUtil.getColumnIndexOrThrow(r2, "shortcut_thumbnail");     // Catch: Throwable -> L76
        int r33 = CursorUtil.getColumnIndexOrThrow(r2, ResourceData.KEY_ID);     // Catch: Throwable -> L76
        int r34 = CursorUtil.getColumnIndexOrThrow(r2, "icon");     // Catch: Throwable -> L76
        int r35 = CursorUtil.getColumnIndexOrThrow(r2, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L76
        int r36 = CursorUtil.getColumnIndexOrThrow(r2, "name");     // Catch: Throwable -> L76
        int r37 = CursorUtil.getColumnIndexOrThrow(r2, ResourceData.KEY_TYPE);     // Catch: Throwable -> L76
        int r38 = CursorUtil.getColumnIndexOrThrow(r2, "owner_id");     // Catch: Throwable -> L76
        int r39 = CursorUtil.getColumnIndexOrThrow(r2, "create_tenant_id");     // Catch: Throwable -> L76
        int r310 = CursorUtil.getColumnIndexOrThrow(r2, "creator_cn_name");     // Catch: Throwable -> L76
        int r40 = CursorUtil.getColumnIndexOrThrow(r2, "creator_en_name");     // Catch: Throwable -> L76
        int r41 = CursorUtil.getColumnIndexOrThrow(r2, "edit_uid");     // Catch: Throwable -> L76
        int r42 = CursorUtil.getColumnIndexOrThrow(r2, "edit_time");     // Catch: Throwable -> L76
        int r43 = CursorUtil.getColumnIndexOrThrow(r2, ResourceData.KEY_URL);     // Catch: Throwable -> L76
        int r44 = CursorUtil.getColumnIndexOrThrow(r2, "fake_token");     // Catch: Throwable -> L76
        int r45 = CursorUtil.getColumnIndexOrThrow(r2, "is_stared");     // Catch: Throwable -> L76
        int r46 = CursorUtil.getColumnIndexOrThrow(r2, "is_pined");     // Catch: Throwable -> L76
        int r47 = CursorUtil.getColumnIndexOrThrow(r2, "is_subscribed");     // Catch: Throwable -> L76
        int r48 = CursorUtil.getColumnIndexOrThrow(r2, "extra_icon_url");     // Catch: Throwable -> L76
        int r49 = CursorUtil.getColumnIndexOrThrow(r2, "extra_icon_key");     // Catch: Throwable -> L76
        int r50 = CursorUtil.getColumnIndexOrThrow(r2, "extra_icon_nonce");     // Catch: Throwable -> L76
        int r51 = CursorUtil.getColumnIndexOrThrow(r2, "extra_icon_encrypted_type");     // Catch: Throwable -> L76
        int r52 = CursorUtil.getColumnIndexOrThrow(r2, "extra_copiable");     // Catch: Throwable -> L76
        int r53 = CursorUtil.getColumnIndexOrThrow(r2, "extra_is_share_root");     // Catch: Throwable -> L76
        int r54 = CursorUtil.getColumnIndexOrThrow(r2, "extra_is_external");     // Catch: Throwable -> L76
        int r55 = CursorUtil.getColumnIndexOrThrow(r2, "extra_sub_type");     // Catch: Throwable -> L76
        int r56 = CursorUtil.getColumnIndexOrThrow(r2, "obj_sub_type");     // Catch: Throwable -> L76
        int r57 = CursorUtil.getColumnIndexOrThrow(r2, "is_visited");     // Catch: Throwable -> L76
        int r58 = CursorUtil.getColumnIndexOrThrow(r2, "create_time");     // Catch: Throwable -> L76
        int r59 = CursorUtil.getColumnIndexOrThrow(r2, "thumbnail_url");     // Catch: Throwable -> L76
        int r60 = CursorUtil.getColumnIndexOrThrow(r2, "thumbnail_secret");     // Catch: Throwable -> L76
        int r61 = CursorUtil.getColumnIndexOrThrow(r2, "thumbnail_nonce");     // Catch: Throwable -> L76
        int r62 = CursorUtil.getColumnIndexOrThrow(r2, "thumbnail_type");     // Catch: Throwable -> L76
        int r63 = CursorUtil.getColumnIndexOrThrow(r2, "permission");     // Catch: Throwable -> L76
        int r64 = CursorUtil.getColumnIndexOrThrow(r2, "share_version");     // Catch: Throwable -> L76
        int r65 = CursorUtil.getColumnIndexOrThrow(r2, "need_sync");     // Catch: Throwable -> L76
        int r66 = CursorUtil.getColumnIndexOrThrow(r2, "size");     // Catch: Throwable -> L76
        int r67 = CursorUtil.getColumnIndexOrThrow(r2, "thumbnail");     // Catch: Throwable -> L76
        int r68 = CursorUtil.getColumnIndexOrThrow(r2, "document_icon_key");     // Catch: Throwable -> L76
        int r69 = CursorUtil.getColumnIndexOrThrow(r2, "document_icon_type");     // Catch: Throwable -> L76
        int r70 = CursorUtil.getColumnIndexOrThrow(r2, "document_icon_fsunit");     // Catch: Throwable -> L76
        int r71 = CursorUtil.getColumnIndexOrThrow(r2, "app_id");     // Catch: Throwable -> L76
        int r72 = CursorUtil.getColumnIndexOrThrow(r2, "doc_cache_status");     // Catch: Throwable -> L76
        int r73 = CursorUtil.getColumnIndexOrThrow(r2, "is_offline_create");     // Catch: Throwable -> L76
        int r74 = CursorUtil.getColumnIndexOrThrow(r2, "wiki_real_type");     // Catch: Throwable -> L76
        int r75 = CursorUtil.getColumnIndexOrThrow(r2, "wiki_real_token");     // Catch: Throwable -> L76
        int r76 = CursorUtil.getColumnIndexOrThrow(r2, "wiki_version");     // Catch: Throwable -> L76
        int r77 = CursorUtil.getColumnIndexOrThrow(r2, "owner_type");     // Catch: Throwable -> L76
        int r78 = CursorUtil.getColumnIndexOrThrow(r2, "is_share_folder");     // Catch: Throwable -> L76
        int r79 = CursorUtil.getColumnIndexOrThrow(r2, "security_name");     // Catch: Throwable -> L76
        int r80 = CursorUtil.getColumnIndexOrThrow(r2, "security_level");     // Catch: Throwable -> L76
        int r81 = CursorUtil.getColumnIndexOrThrow(r2, "is_secret_key_delete");     // Catch: Throwable -> L76
        int r82 = CursorUtil.getColumnIndexOrThrow(r2, "template_type");     // Catch: Throwable -> L76
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "wiki_extra");     // Catch: Throwable -> L76
        int r83 = CursorUtil.getColumnIndexOrThrow(r2, "icon");     // Catch: Throwable -> L76
        int r84 = CursorUtil.getColumnIndexOrThrow(r2, "file_risk_tag");     // Catch: Throwable -> L76
        int r85 = r4;
        ArrayList r3 = new ArrayList(r2.getCount());     // Catch: Throwable -> L76
    L15:
        if (r2.moveToNext() == false) goto L74;
        d r86 = new d();     // Catch: Throwable -> L76
        r2.getInt(r0);     // Catch: Throwable -> L76
        r2.getInt(r7);     // Catch: Throwable -> L76
        r2.getString(r8);     // Catch: Throwable -> L76
        r2.getInt(r10);     // Catch: Throwable -> L76
        r2.getInt(r11);     // Catch: Throwable -> L76
        int r87 = r0;
        r86.a = r2.getString(r12);     // Catch: Throwable -> L76
        r86.S = r2.getString(r13);     // Catch: Throwable -> L76
        r86.T = r2.getString(r14);     // Catch: Throwable -> L76
        r86.U = r2.getString(r15);     // Catch: Throwable -> L76
        r86.W = r2.getString(r6);     // Catch: Throwable -> L76
        r86.X = r2.getString(r9);     // Catch: Throwable -> L76
        if (r2.getInt(r1) == 0) goto L19;
        boolean r88 = true;
    L20:
        r86.Y = r88;     // Catch: Throwable -> L76
        int r89 = r97;
        int r912 = r1;
        r86.Z = r2.getString(r89);     // Catch: Throwable -> L76
        int r90 = r98;
        r86.a0 = r2.getString(r90);     // Catch: Throwable -> L76
        int r100 = r99;
        r86.b0 = r2.getString(r100);     // Catch: Throwable -> L76
        int r101 = r910;
        if (r2.getInt(r101) == 0) goto L23;
        boolean r102 = true;
    L24:
        r86.c0 = r102;     // Catch: Throwable -> L76
        int r103 = r911;
        r911 = r103;
        if (r2.getInt(r103) == 0) goto L27;
        boolean r104 = true;
    L28:
        r86.d0 = r104;     // Catch: Throwable -> L76
        r910 = r101;
        int r105 = r17;
        r86.e0 = r2.getInt(r105);     // Catch: Throwable -> L76
        r17 = r105;
        int r106 = r18;
        r86.f0 = r2.getString(r106);     // Catch: Throwable -> L76
        r18 = r106;
        int r107 = r19;
        r86.g0 = r2.getString(r107);     // Catch: Throwable -> L76
        r19 = r107;
        int r108 = r20;
        r86.h0 = r2.getString(r108);     // Catch: Throwable -> L76
        r20 = r108;
        int r109 = r21;
        r86.i0 = r2.getInt(r109);     // Catch: Throwable -> L76
        r21 = r109;
        int r110 = r22;
        r86.j0 = r2.getString(r110);     // Catch: Throwable -> L76
        int r111 = r23;
        r23 = r111;
        if (r2.getInt(r111) == 0) goto L31;
        boolean r112 = true;
    L32:
        r86.p0 = r112;     // Catch: Throwable -> L76
        r22 = r110;
        int r113 = r24;
        r86.l0 = r2.getString(r113);     // Catch: Throwable -> L76
        r24 = r113;
        int r114 = r25;
        r86.m0 = r2.getString(r114);     // Catch: Throwable -> L76
        r25 = r114;
        int r115 = r26;
        r86.n0 = r2.getString(r115);     // Catch: Throwable -> L76
        r26 = r115;
        int r116 = r27;
        r86.o0 = r2.getString(r116);     // Catch: Throwable -> L76
        r27 = r116;
        int r117 = r28;
        r86.r0 = r2.getString(r117);     // Catch: Throwable -> L76
        r28 = r117;
        int r118 = r29;
        r86.s0 = r2.getString(r118);     // Catch: Throwable -> L76
        r29 = r118;
        int r119 = r30;
        r86.t0 = r2.getString(r119);     // Catch: Throwable -> L76
        r30 = r119;
        int r120 = r31;
        r86.u0 = r2.getInt(r120);     // Catch: Throwable -> L76
        r31 = r120;
        int r121 = r32;
        r86.v0 = r2.getString(r121);     // Catch: Throwable -> L76
        int r122 = r33;
        r2.getInt(r122);     // Catch: Throwable -> L76
        r32 = r121;
        r86.w0 = r2.getString(r34);     // Catch: Throwable -> L76
        r33 = r122;
        int r123 = r35;
        r86.a = r2.getString(r123);     // Catch: Throwable -> L76
        r35 = r123;
        int r124 = r36;
        r86.b = r2.getString(r124);     // Catch: Throwable -> L76
        r36 = r124;
        int r125 = r37;
        r86.c = r2.getString(r125);     // Catch: Throwable -> L76
        r37 = r125;
        int r126 = r38;
        r86.d = r2.getString(r126);     // Catch: Throwable -> L76
        r38 = r126;
        int r127 = r39;
        r86.e = r2.getString(r127);     // Catch: Throwable -> L76
        r39 = r127;
        int r128 = r310;
        r86.f = r2.getString(r128);     // Catch: Throwable -> L76
        int r129 = r40;
        r2.getString(r129);     // Catch: Throwable -> L76
        r40 = r129;
        r310 = r128;
        int r130 = r41;
        r86.g = r2.getString(r130);     // Catch: Throwable -> L76
        r41 = r130;
        int r131 = r42;
        r86.h = r2.getString(r131);     // Catch: Throwable -> L76
        r42 = r131;
        int r132 = r43;
        r86.i = r2.getString(r132);     // Catch: Throwable -> L76
        r43 = r132;
        int r133 = r44;
        r86.j = r2.getString(r133);     // Catch: Throwable -> L76
        int r134 = r45;
        r45 = r134;
        if (r2.getInt(r134) == 0) goto L35;
        boolean r135 = true;
    L36:
        r86.k = r135;     // Catch: Throwable -> L76
        int r136 = r46;
        r46 = r136;
        if (r2.getInt(r136) == 0) goto L39;
        boolean r137 = true;
    L40:
        r86.l = r137;     // Catch: Throwable -> L76
        int r138 = r47;
        r47 = r138;
        if (r2.getInt(r138) == 0) goto L43;
        boolean r139 = true;
    L44:
        r86.m = r139;     // Catch: Throwable -> L76
        r44 = r133;
        int r140 = r48;
        r86.n = r2.getString(r140);     // Catch: Throwable -> L76
        r48 = r140;
        int r141 = r49;
        r86.o = r2.getString(r141);     // Catch: Throwable -> L76
        r49 = r141;
        int r142 = r50;
        r86.p = r2.getString(r142);     // Catch: Throwable -> L76
        r50 = r142;
        int r143 = r51;
        r86.q = r2.getInt(r143);     // Catch: Throwable -> L76
        int r144 = r52;
        r52 = r144;
        if (r2.getInt(r144) == 0) goto L47;
        boolean r145 = true;
    L48:
        r86.r = r145;     // Catch: Throwable -> L76
        int r146 = r53;
        r53 = r146;
        if (r2.getInt(r146) == 0) goto L51;
        boolean r147 = true;
    L52:
        r86.s = r147;     // Catch: Throwable -> L76
        int r148 = r54;
        r54 = r148;
        if (r2.getInt(r148) == 0) goto L55;
        boolean r149 = true;
    L56:
        r86.t = r149;     // Catch: Throwable -> L76
        r51 = r143;
        int r150 = r55;
        r86.u = r2.getString(r150);     // Catch: Throwable -> L76
        int r510 = r6;
        int r151 = r56;
        int r511 = r34;
        r86.v = r2.getLong(r151);     // Catch: Throwable -> L76
        int r152 = r57;
        if (r2.getInt(r152) == 0) goto L59;
        boolean r153 = true;
    L60:
        r86.w = r153;     // Catch: Throwable -> L76
        int r154 = r58;
        r86.x = r2.getString(r154);     // Catch: Throwable -> L76
        int r155 = r59;
        r86.y = r2.getString(r155);     // Catch: Throwable -> L76
        r59 = r155;
        int r156 = r60;
        r86.z = r2.getString(r156);     // Catch: Throwable -> L76
        r60 = r156;
        int r157 = r61;
        r86.A = r2.getString(r157);     // Catch: Throwable -> L76
        r61 = r157;
        int r158 = r62;
        r86.B = r2.getInt(r158);     // Catch: Throwable -> L76
        r62 = r158;
        int r159 = r63;
        r86.C = r2.getInt(r159);     // Catch: Throwable -> L76
        r63 = r159;
        int r160 = r64;
        r86.D = r2.getInt(r160);     // Catch: Throwable -> L76
        int r161 = r65;
        r2.getInt(r161);     // Catch: Throwable -> L76
        r65 = r161;
        r64 = r160;
        int r162 = r66;
        r86.E = r2.getString(r162);     // Catch: Throwable -> L76
        r66 = r162;
        int r163 = r67;
        r86.F = r2.getString(r163);     // Catch: Throwable -> L76
        r67 = r163;
        int r164 = r68;
        r86.G = r2.getString(r164);     // Catch: Throwable -> L76
        r68 = r164;
        int r165 = r69;
        r86.H = r2.getInt(r165);     // Catch: Throwable -> L76
        r69 = r165;
        int r166 = r70;
        r86.I = r2.getString(r166);     // Catch: Throwable -> L76
        r70 = r166;
        int r167 = r71;
        r86.J = r2.getString(r167);     // Catch: Throwable -> L76
        r71 = r167;
        int r168 = r72;
        r86.K = r2.getInt(r168);     // Catch: Throwable -> L76
        int r169 = r73;
        r2.getInt(r169);     // Catch: Throwable -> L76
        r72 = r168;
        r73 = r169;
        int r170 = r74;
        r86.L = r2.getInt(r170);     // Catch: Throwable -> L76
        r74 = r170;
        int r171 = r75;
        r86.M = r2.getString(r171);     // Catch: Throwable -> L76
        r75 = r171;
        int r172 = r76;
        r86.q0 = r2.getString(r172);     // Catch: Throwable -> L76
        r76 = r172;
        int r173 = r77;
        r86.N = r2.getInt(r173);     // Catch: Throwable -> L76
        int r174 = r78;
        r78 = r174;
        if (r2.getInt(r174) == 0) goto L63;
        boolean r175 = true;
    L64:
        r86.k0 = r175;     // Catch: Throwable -> L76
        r77 = r173;
        int r176 = r79;
        r86.O = r2.getString(r176);     // Catch: Throwable -> L76
        r79 = r176;
        int r177 = r80;
        r86.P = r2.getInt(r177);     // Catch: Throwable -> L76
        int r178 = r81;
        r81 = r178;
        if (r2.getInt(r178) == 0) goto L67;
        boolean r179 = true;
    L68:
        r86.Q = r179;     // Catch: Throwable -> L76
        r80 = r177;
        int r180 = r82;
        r86.R = r2.getInt(r180);     // Catch: Throwable -> L76
        r82 = r180;
        int r181 = r85;
        r86.V = r2.getString(r181);     // Catch: Throwable -> L76
        r85 = r181;
        r83 = r83;
        r86.w0 = r2.getString(r83);     // Catch: Throwable -> L76
        int r182 = r84;
        if (r2.getInt(r182) == 0) goto L71;
        boolean r183 = true;
    L72:
        r86.x0 = r183;     // Catch: Throwable -> L76
        r3.add(r86);     // Catch: Throwable -> L76
        r84 = r182;
        r0 = r87;
        r1 = r912;
        r97 = r89;
        r98 = r90;
        r99 = r100;
        r57 = r152;
        r34 = r511;
        r56 = r151;
        r58 = r154;
        r6 = r510;
        r55 = r150;
        goto L15
    L71:
        r183 = false;
        goto L72
    L67:
        r179 = false;
        goto L68
    L63:
        r175 = false;
        goto L64
    L59:
        r153 = false;
        goto L60
    L55:
        r149 = false;
        goto L56
    L51:
        r147 = false;
        goto L52
    L47:
        r145 = false;
        goto L48
    L43:
        r139 = false;
        goto L44
    L39:
        r137 = false;
        goto L40
    L35:
        r135 = false;
        goto L36
    L31:
        r112 = false;
        goto L32
    L27:
        r104 = false;
        goto L28
    L23:
        r102 = false;
        goto L24
    L19:
        r88 = false;
        goto L20
    L74:
        r2.close();
        r16.release();
        return r3;
    L76:
        th = th;
    L80:
        r2.close();
        r16.release();
        throw th;
    L78:
        th = th;
        r16 = r5;
        goto L80
    L9:
        r5.bindString(6, r96);
        goto L10
    L5:
        r5.bindString(3, r93);
        goto L6
    }

    public final int f0(String r3, String r4, String r5, String r6, String r7, int r8, String r9) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.r.acquire();
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r5 != null) goto L9;
        r0.bindNull(2);
    L11:
        if (r6 != null) goto L13;
        r0.bindNull(3);
    L15:
        if (r7 != null) goto L17;
        r0.bindNull(4);
    L18:
        r0.bindLong(5, r8);
        if (r9 != null) goto L21;
        r0.bindNull(6);
    L23:
        if (r3 != null) goto L25;
        r0.bindNull(7);
    L26:
        this.a.beginTransaction();
        int r10 = r0.executeUpdateDelete();     // Catch: Throwable -> L30
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L30
        this.a.endTransaction();
        this.r.release(r0);
        return r10;
    L30:
        th = move-exception;
        this.a.endTransaction();
        this.r.release(r0);
        throw th;
    L25:
        r0.bindString(7, r3);
        goto L26
    L21:
        r0.bindString(6, r9);
        goto L23
    L17:
        r0.bindString(4, r7);
        goto L18
    L13:
        r0.bindString(3, r6);
        goto L15
    L9:
        r0.bindString(2, r5);
        goto L11
    L5:
        r0.bindString(1, r4);
        goto L7
    }

    public final int a0(String r17, String r18, String r19, String r20, boolean r21, boolean r22, String r23, String r24, String r25, int r26, boolean r27, String r28, long r29, String r31, int r32, String r33, String r34, int r35, String r36, String r37, int r38, int r39, boolean r40, String r41, boolean r42, boolean r43) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r15 = this.i.acquire();
        if (r18 != null) goto L5;
        r15.bindNull(1);
    L7:
        if (r19 != null) goto L9;
        r15.bindNull(2);
    L11:
        if (r20 != null) goto L13;
        r15.bindNull(3);
    L14:
        r15.bindLong(4, r21 ? 1 : 0);
        r15.bindLong(5, r22 ? 1 : 0);
        if (r23 != null) goto L17;
        r15.bindNull(6);
    L19:
        if (r24 != null) goto L21;
        r15.bindNull(7);
    L23:
        if (r25 != null) goto L25;
        r15.bindNull(8);
    L26:
        r15.bindLong(9, r26);
        r15.bindLong(10, r27 ? 1 : 0);
        if (r28 != null) goto L29;
        r15.bindNull(11);
    L30:
        r15.bindLong(12, r29);
        if (r31 != null) goto L33;
        r15.bindNull(13);
    L34:
        r15.bindLong(14, r32);
        if (r33 != null) goto L37;
        r15.bindNull(15);
    L39:
        if (r34 != null) goto L41;
        r15.bindNull(16);
    L42:
        r15.bindLong(17, r35);
        if (r36 != null) goto L45;
        r15.bindNull(18);
    L47:
        if (r37 != null) goto L49;
        r15.bindNull(19);
    L50:
        r15.bindLong(20, r38);
        r15.bindLong(21, r39);
        r15.bindLong(22, r40 ? 1 : 0);
        if (r41 != null) goto L53;
        r15.bindNull(23);
    L54:
        r15.bindLong(24, r42 ? 1 : 0);
        r15.bindLong(25, r43 ? 1 : 0);
        if (r17 != null) goto L57;
        r15.bindNull(26);
    L58:
        this.a.beginTransaction();
        int r0 = r15.executeUpdateDelete();     // Catch: Throwable -> L62
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L62
        this.a.endTransaction();
        this.i.release(r15);
        return r0;
    L62:
        th = move-exception;
        this.a.endTransaction();
        this.i.release(r15);
        throw th;
    L57:
        r15.bindString(26, r17);
        goto L58
    L53:
        r15.bindString(23, r41);
        goto L54
    L49:
        r15.bindString(19, r37);
        goto L50
    L45:
        r15.bindString(18, r36);
        goto L47
    L41:
        r15.bindString(16, r34);
        goto L42
    L37:
        r15.bindString(15, r33);
        goto L39
    L33:
        r15.bindString(13, r31);
        goto L34
    L29:
        r15.bindString(11, r28);
        goto L30
    L25:
        r15.bindString(8, r25);
        goto L26
    L21:
        r15.bindString(7, r24);
        goto L23
    L17:
        r15.bindString(6, r23);
        goto L19
    L13:
        r15.bindString(3, r20);
        goto L14
    L9:
        r15.bindString(2, r19);
        goto L11
    L5:
        r15.bindString(1, r18);
        goto L7
    }

    public final int O(String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, boolean r29, boolean r30, String r31, String r32, String r33, int r34, boolean r35, boolean r36, boolean r37, String r38, long r39, boolean r41, String r42, String r43, String r44, String r45, int r46, int r47, int r48, boolean r49, String r50, String r51, int r52, String r53, String r54, int r55, String r56, String r57, boolean r58, int r59, boolean r60, String r61, int r62, boolean r63, int r64, boolean r65, boolean r66, String r67, boolean r68, boolean r69) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r1 = this.h.acquire();
        if (r18 != null) goto L5;
        r1.bindNull(1);
    L7:
        if (r19 != null) goto L9;
        r1.bindNull(2);
    L11:
        if (r20 != null) goto L13;
        r1.bindNull(3);
    L15:
        if (r21 != null) goto L17;
        r1.bindNull(4);
    L19:
        if (r22 != null) goto L21;
        r1.bindNull(5);
    L23:
        if (r23 != null) goto L25;
        r1.bindNull(6);
    L27:
        if (r24 != null) goto L29;
        r1.bindNull(7);
    L31:
        if (r25 != null) goto L33;
        r1.bindNull(8);
    L35:
        if (r26 != null) goto L37;
        r1.bindNull(9);
    L39:
        if (r27 != null) goto L41;
        r1.bindNull(10);
    L43:
        if (r28 != null) goto L45;
        r1.bindNull(11);
    L46:
        r1.bindLong(12, r29 ? 1 : 0);
        r1.bindLong(13, r30 ? 1 : 0);
        if (r31 != null) goto L49;
        r1.bindNull(14);
    L51:
        if (r32 != null) goto L53;
        r1.bindNull(15);
    L55:
        if (r33 != null) goto L57;
        r1.bindNull(16);
    L58:
        r1.bindLong(17, r34);
        r1.bindLong(18, r35 ? 1 : 0);
        r1.bindLong(19, r36 ? 1 : 0);
        r1.bindLong(20, r37 ? 1 : 0);
        if (r38 != null) goto L61;
        r1.bindNull(21);
    L62:
        r1.bindLong(22, r39);
        r1.bindLong(23, r41 ? 1 : 0);
        if (r42 != null) goto L65;
        r1.bindNull(24);
    L67:
        if (r43 != null) goto L69;
        r1.bindNull(25);
    L71:
        if (r44 != null) goto L73;
        r1.bindNull(26);
    L75:
        if (r45 != null) goto L77;
        r1.bindNull(27);
    L78:
        r1.bindLong(28, r46);
        r1.bindLong(29, r47);
        r1.bindLong(30, r48);
        r1.bindLong(31, r49 ? 1 : 0);
        if (r50 != null) goto L81;
        r1.bindNull(32);
    L83:
        if (r51 != null) goto L85;
        r1.bindNull(33);
    L86:
        r1.bindLong(34, r52);
        if (r53 != null) goto L89;
        r1.bindNull(35);
    L91:
        if (r54 != null) goto L93;
        r1.bindNull(36);
    L94:
        r1.bindLong(37, r55);
        if (r56 != null) goto L97;
        r1.bindNull(38);
    L99:
        if (r57 != null) goto L101;
        r1.bindNull(39);
    L102:
        r1.bindLong(40, r58 ? 1 : 0);
        r1.bindLong(41, r59);
        r1.bindLong(42, r66 ? 1 : 0);
        r1.bindLong(43, r60 ? 1 : 0);
        if (r61 != null) goto L105;
        r1.bindNull(44);
    L106:
        r1.bindLong(45, r62);
        r1.bindLong(46, r63 ? 1 : 0);
        r1.bindLong(47, r64);
        r1.bindLong(48, r65 ? 1 : 0);
        if (r67 != null) goto L109;
        r1.bindNull(49);
    L110:
        r1.bindLong(50, r68 ? 1 : 0);
        r1.bindLong(51, r69 ? 1 : 0);
        if (r17 != null) goto L113;
        r1.bindNull(52);
    L114:
        this.a.beginTransaction();
        int r0 = r1.executeUpdateDelete();     // Catch: Throwable -> L118
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L118
        this.a.endTransaction();
        this.h.release(r1);
        return r0;
    L118:
        th = move-exception;
        this.a.endTransaction();
        this.h.release(r1);
        throw th;
    L113:
        r1.bindString(52, r17);
        goto L114
    L109:
        r1.bindString(49, r67);
        goto L110
    L105:
        r1.bindString(44, r61);
        goto L106
    L101:
        r1.bindString(39, r57);
        goto L102
    L97:
        r1.bindString(38, r56);
        goto L99
    L93:
        r1.bindString(36, r54);
        goto L94
    L89:
        r1.bindString(35, r53);
        goto L91
    L85:
        r1.bindString(33, r51);
        goto L86
    L81:
        r1.bindString(32, r50);
        goto L83
    L77:
        r1.bindString(27, r45);
        goto L78
    L73:
        r1.bindString(26, r44);
        goto L75
    L69:
        r1.bindString(25, r43);
        goto L71
    L65:
        r1.bindString(24, r42);
        goto L67
    L61:
        r1.bindString(21, r38);
        goto L62
    L57:
        r1.bindString(16, r33);
        goto L58
    L53:
        r1.bindString(15, r32);
        goto L55
    L49:
        r1.bindString(14, r31);
        goto L51
    L45:
        r1.bindString(11, r28);
        goto L46
    L41:
        r1.bindString(10, r27);
        goto L43
    L37:
        r1.bindString(9, r26);
        goto L39
    L33:
        r1.bindString(8, r25);
        goto L35
    L29:
        r1.bindString(7, r24);
        goto L31
    L25:
        r1.bindString(6, r23);
        goto L27
    L21:
        r1.bindString(5, r22);
        goto L23
    L17:
        r1.bindString(4, r21);
        goto L19
    L13:
        r1.bindString(3, r20);
        goto L15
    L9:
        r1.bindString(2, r19);
        goto L11
    L5:
        r1.bindString(1, r18);
        goto L7
    }
}
