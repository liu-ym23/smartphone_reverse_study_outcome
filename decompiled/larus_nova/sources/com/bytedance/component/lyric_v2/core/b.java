package com.bytedance.component.lyric_v2.core;

import com.bytedance.component.lyric_v2.util.LyricType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.bduploader.UploadKeys;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import ng4.d;
import ng4.h;
import ng4.i;
import ng4.l;
import pg4.c;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f203058a;

    public b(h r100) {
        this.f203058a = r100;
    }

    @Override // ng4.d
    public final void a(l r310, c r311) {
        c r100 = r311;
        Intrinsics.checkNotNullParameter(r310, "request");
        Intrinsics.checkNotNullParameter(r100, "config");
        r100.C.b(r100);
        List<pg4.d> r101 = r310.f519069a;
        if (r101 == null) goto L161;
        int r102 = 1;
        if ((!r101.isEmpty()) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L162;
        LyricType r103 = r310.f519070b;
        ArrayList r104 = new ArrayList();
        Iterator<pg4.d> r105 = r101.iterator();
    L11:
        if (r105.hasNext() == false) goto L118;
        pg4.d r106 = r105.next();
        String r107 = r106.f529201g;
        if (r107 != null) goto L15;
    L18:
        boolean r108 = true;
    L19:
        if (r108 == true) goto L116;
        i r109 = r100.C;
        float r110 = r100.A;
        String r111 = r106.f529201g;
        if (r111 == null) goto L116;
        if (c(new LinkedHashMap(), r109, r111) > r110) goto L26;
        r104.add(r106);
        goto L116
    L26:
        int r112 = a.f203057a[r103.ordinal()];
        if (r112 != r102) goto L29;
        String r113 = r106.f529201g;
        if (r113 == null) goto L116;
        String r114 = StringsKt.trim(r113).toString();
        if (r114 == null) goto L116;
        if (r114.length() != 0) goto L77;
        boolean r115 = true;
    L78:
        if (r115 == true) goto L116;
        int r116 = r114.length();
        int r117 = 0;
        int r118 = 0;
        float r119 = 0.0f;
    L81:
        if (r118 >= r116) goto L86;
        int r120 = r118 + 1;
        r119 = r119 + c(new LinkedHashMap(), r109, r114.substring(r118, r120));
        if (r119 > r110) goto L86;
        r117 = r120;
        r118 = r117;
    L86:
        if (r117 > 0) goto L88;
    L115:
        r104.add(r106);
        goto L116
    L88:
        if (r117 >= r114.length()) goto L115;
        String r121 = r114.substring(0, r117);
        if (r121 == null) goto L114;
        String r122 = StringsKt.trim(r121).toString();
        String r123 = r114.substring(r117);
        if (r123 == null) goto L112;
        String r124 = StringsKt.trim(r123).toString();
        if (r122.length() != 0) goto L97;
        boolean r125 = true;
    L98:
        if (r125 == false) goto L100;
    L110:
        r104.add(r106);
        goto L116
    L100:
        if (r124.length() != 0) goto L102;
        boolean r126 = true;
    L103:
        if (r126 == true) goto L110;
        int r127 = r106.f529198d - r106.f529197c;
        float r128 = r122.length() / r114.length();
        if (r127 > 0) goto L108;
        int r129 = 0;
    L109:
        pg4.d r130 = pg4.d.a(r106, null, 0, r106.f529197c + r129, null, null, r122, r106.f529204j, false, r106.f529206l, r106.f529207m, r106.f529208n, UploadKeys.KeyIsEnd2EndEncryptionOption);
        pg4.d r131 = pg4.d.a(r106, null, r106.f529197c + r129, r106.f529198d, null, null, r124, false, r106.f529205k, r106.f529206l, r106.f529207m, r106.f529208n, UploadKeys.KeyIsSkipMeta);
        r104.add(r130);
        r104.add(r131);
        goto L116
    L108:
        r129 = (int) (r127 * r128);
        goto L109
    L102:
        r126 = false;
        goto L103
    L97:
        r125 = false;
        goto L98
    L112:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L114:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L77:
        r115 = false;
        goto L78
    L29:
        if (r112 == 2) goto L31;
        r104.add(r106);
        goto L116
    L31:
        List<String> r132 = r106.f529200f;
        if (r132 == null) goto L116;
        List<Integer> r133 = r106.f529196b;
        if (r133 == null) goto L116;
        if (r132.size() == r133.size()) goto L43;
        h r134 = this.f203058a;
        if (r134 == null) goto L42;
        Object[] r135 = new Object[3];
        r135[0] = "wrapKrcLine: 字词数量与间隔数量不匹配";
        r135[r102] = Integer.valueOf(r132.size());
        r135[2] = Integer.valueOf(r133.size());
        r134.b(r135);
    L42:
        r104.add(r106);
        goto L116
    L43:
        StringBuilder r136 = new StringBuilder();
        int r137 = r132.size();
        int r138 = 0;
        float r139 = 0.0f;
        int r140 = 0;
    L44:
        if (r138 >= r137) goto L49;
        String r141 = (String) ListProtector.get(r132, r138);
        r139 = r139 + c(new LinkedHashMap(), r109, r141);
        if (r139 > r110) goto L47;
        r136.append(r141);
        r140 = r138 + 1;
        r138 = r140;
        goto L44
    L47:
        Pair r142 = new Pair(Integer.valueOf(r140), r136.toString());
    L50:
        int r143 = ((Number) r142.component1()).intValue();
        String r144 = (String) r142.component2();
        if (r143 > 0) goto L53;
    L65:
        h r145 = this.f203058a;
        if (r145 == null) goto L68;
        r145.b(new Object[]{"wrapKrcLine: 最佳拆分点无效", Integer.valueOf(r143), Integer.valueOf(r132.size())});
    L68:
        r104.add(r106);
        goto L116
    L53:
        if (r143 >= r132.size()) goto L65;
        List<String> r146 = r132.subList(0, r143);
        List<String> r210 = r132.subList(r143, r132.size());
        List<Integer> r147 = r133.subList(0, r143);
        List<Integer> r148 = r133.subList(r143, r133.size());
        if (r146.isEmpty() == false) goto L58;
    L61:
        h r149 = this.f203058a;
        if (r149 == null) goto L64;
        r149.b(new Object[]{"wrapKrcLine: 拆分后的行空", Boolean.valueOf(r146.isEmpty()), Boolean.valueOf(r210.isEmpty())});
    L64:
        r104.add(r106);
        goto L116
    L58:
        if (r210.isEmpty() == true) goto L61;
        int r150 = CollectionsKt.sumOfInt(r147) + r106.f529197c;
        pg4.d r151 = pg4.d.a(r106, r147, 0, r150, Integer.valueOf(r150), r146, r144, r106.f529204j, false, r106.f529206l, r106.f529207m, r106.f529208n, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSIONS);
        pg4.d r152 = pg4.d.a(r106, r148, r150, r106.f529198d, r106.f529199e, r210, CollectionsKt.joinToString$default(r210, "", null, null, 0, null, null, 62, null), false, r106.f529205k, r106.f529206l, r106.f529207m, r106.f529208n, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DEMUXER_STALL_500);
        r104.add(r151);
        r104.add(r152);
        goto L116
    L49:
        r142 = new Pair(Integer.valueOf(r140), r136.toString());
    L116:
        r100 = r311;
        r102 = 1;
        goto L11
    L15:
        if (r107.length() == 0) goto L18;
        r108 = false;
        goto L19
    L118:
        if (r104.isEmpty() == true) goto L129;
        pg4.d r153 = (pg4.d) CollectionsKt.first(r104);
        int r154 = r153.f529197c;
        if (r154 <= 0) goto L123;
        int r155 = 1;
        r153.f529204j = true;
        r153.f529206l = 0;
        r153.f529207m = r154;
        r153.f529208n = r154;
    L124:
        int r156 = r104.size() - r155;
        int r157 = 0;
    L125:
        if (r157 >= r156) goto L129;
        pg4.d r158 = (pg4.d) ListProtector.get(r104, r157);
        r157 = r157 + 1;
        pg4.d r159 = (pg4.d) ListProtector.get(r104, r157);
        int r160 = r159.f529197c;
        int r161 = r158.f529198d;
        int r162 = r160 - r161;
        if (r162 <= 0) goto L125;
        r158.f529205k = true;
        r158.f529207m = r160;
        r159.f529204j = true;
        r159.f529206l = r161;
        r159.f529207m = r160;
        r159.f529208n = r162;
        goto L125
    L123:
        r155 = 1;
    L129:
        ((ArrayList) r310.f519071c).clear();
        ((ArrayList) r310.f519071c).addAll(r104);
        pg4.d r163 = (pg4.d) CollectionsKt.firstOrNull(r310.f519071c);
        if (r163 == null) goto L163;
        r310.f519072d = new ng4.c(r163, r310.f519070b);
        return;
    L163:
        return;
    L162:
        return;
    }

    public static float c(Map r100, i r101, String r102) {
        if (r102 != null) goto L4;
    L7:
        boolean r103 = true;
    L8:
        if (r103 == false) goto L11;
        return 0.0f;
    L11:
        LinkedHashMap r104 = (LinkedHashMap) r100;
        Object r105 = r104.get(r102);
        if (r105 != null) goto L15;
        r105 = Float.valueOf(r101.c(r102));
        r104.put(r102, r105);
    L15:
        return ((Number) r105).floatValue();
    L4:
        if (r102.length() == 0) goto L7;
        r103 = false;
        goto L8
    }

    @Override // ng4.d
    public final void b(l r110, int r111, i r112) {
        Intrinsics.checkNotNullParameter(r110, "request");
        Intrinsics.checkNotNullParameter(r112, "painter");
        ArrayList r100 = (ArrayList) r110.f519071c;
        boolean r101 = true;
        pg4.d r102 = null;
        if ((!r100.isEmpty()) == true) goto L6;
        r100 = null;
    L6:
        if (r100 != null) goto L8;
        return;
    L8:
        ng4.c r103 = r110.f519072d;
        if (r103 != null) goto L11;
        return;
    L11:
        r103.f519065d = r111;
        int r104 = -1;
        int r105 = 0;
        if (r100.isEmpty() == true) goto L46;
        pg4.d r106 = (pg4.d) CollectionsKt.first(r100);
        if (r106.f529204j == true) goto L17;
    L19:
        int r107 = r100.size() - 1;
        int r113 = 0;
    L20:
        if (r113 > r107) goto L28;
        int r114 = (r113 + r107) / 2;
        pg4.d r115 = (pg4.d) ListProtector.get(r100, r114);
        if (r111 < r115.f529197c) goto L23;
        if (r111 <= r115.f529198d) goto L27;
        r113 = r114 + 1;
        goto L20
    L27:
        r104 = r114;
        goto L46
    L23:
        r107 = r114 - 1;
        goto L20
    L28:
        if (r113 == 0) goto L46;
        if (r113 < r100.size()) goto L33;
        r104 = (-1) + r100.size();
        goto L46
    L33:
        r104 = r113 - 1;
        pg4.d r108 = (pg4.d) ListProtector.get(r100, r104);
        pg4.d r116 = (pg4.d) ListProtector.get(r100, r113);
        if (r111 > r108.f529198d) goto L36;
    L38:
        boolean r109 = false;
    L39:
        if (r109 == true) goto L41;
    L43:
        r101 = false;
    L44:
        if (r101 == false) goto L46;
        r104 = r113;
        goto L46
    L41:
        if ((r116.f529197c - r111) > 1000) goto L43;
    L36:
        if (r111 >= r116.f529197c) goto L38;
        r109 = true;
        goto L39
    L17:
        if (r111 >= r106.f529197c) goto L19;
        r104 = 0;
    L46:
        r103.f519064c = r104;
        if (r104 < 0) goto L49;
        r102 = (pg4.d) CollectionsKt.getOrNull(r100, r104);
    L49:
        r103.f519066e = r102;
        int r117 = r100.size();
        if (r104 < 0) goto L97;
        if (r117 <= r104) goto L97;
        c r118 = r110.f519077i;
        Map<String, Float> r119 = r110.f519073e;
        pg4.d r120 = (pg4.d) ListProtector.get(r100, r104);
        Intrinsics.checkNotNullParameter(r103, "drawNode");
        Intrinsics.checkNotNullParameter(r118, "config");
        Intrinsics.checkNotNullParameter(r119, "textWidthCache");
        Intrinsics.checkNotNullParameter(r120, "lyricLine");
        String r121 = r120.f529201g;
        if (r121 == null) goto L113;
        float r122 = c(r119, r118.C, r121);
        if (r120.f529204j == false) goto L63;
        int r123 = r120.f529197c;
        if (r111 >= r123) goto L63;
        if ((r123 - r111) > 1000) goto L63;
        r103.f519067f = 0.0f;
        r103.f519063b = 0.0f;
        r103.f519062a = r122;
        return;
    L63:
        int r124 = r120.f529197c;
        if (r111 >= r124) goto L66;
        r103.f519067f = 0.0f;
        r103.f519063b = 0.0f;
        r103.f519062a = r122;
        return;
    L66:
        int r125 = r120.f529198d;
        if (r111 < r125) goto L69;
        r103.f519067f = 1.0f;
        r103.f519063b = r122;
        r103.f519062a = r122;
        return;
    L69:
        int r126 = r125 - r124;
        if (r126 > 0) goto L72;
        r103.f519067f = 1.0f;
        r103.f519063b = r122;
        r103.f519062a = r122;
        return;
    L72:
        float r127 = (r111 - r124) / r126;
        float r128 = r122 * r127;
        if (r120.f529195a != LyricType.KRC) goto L96;
        List<String> r129 = r120.f529200f;
        if (r129 == null) goto L96;
        if (r120.f529196b == null) goto L96;
        Intrinsics.checkNotNull(r129);
        List<Integer> r130 = r120.f529196b;
        Intrinsics.checkNotNull(r130);
        int r131 = r120.f529197c;
        i r132 = r118.C;
        int r133 = r129.size();
        int r134 = 0;
        float r135 = 0.0f;
        float r136 = 0.0f;
    L79:
        if (r134 >= r133) goto L94;
        String r137 = (String) ListProtector.get(r129, r134);
        if (r134 >= 0) goto L83;
    L85:
        Object r138 = Integer.valueOf(r105);
    L86:
        int r139 = ((Number) r138).intValue();
        float r140 = c(r119, r132, r137);
        r135 = r135 + r140;
        int r141 = r131 + r139;
        if (r111 < r141) goto L88;
        r136 = r136 + r140;
        r134 = r134 + 1;
        r131 = r141;
        r105 = 0;
        goto L79
    L88:
        int r142 = r111 - r131;
        if (r139 > 0) goto L91;
        float r143 = 1.0f;
    L92:
        float r144 = r136 + (r140 * r143);
        Pair r145 = new Pair(Float.valueOf(r144 / RangesKt.coerceAtLeast(r135, 1.0f)), Float.valueOf(r144));
    L95:
        r127 = ((Number) r145.component1()).floatValue();
        r128 = ((Number) r145.component2()).floatValue();
        goto L96
    L91:
        r143 = r142 / r139;
        goto L92
    L83:
        if (r134 > CollectionsKt.getLastIndex(r130)) goto L85;
        r138 = ListProtector.get(r130, r134);
        goto L86
    L94:
        r145 = new Pair(Float.valueOf(1.0f), Float.valueOf(r135));
    L96:
        r103.f519067f = RangesKt.coerceIn(r127, 0.0f, 1.0f);
        r103.f519063b = RangesKt.coerceIn(r128, 0.0f, r122);
        r103.f519062a = r122;
        return;
    L113:
        return;
    L97:
        r103.f519067f = 0.0f;
        r103.f519063b = 0.0f;
        r103.f519062a = 0.0f;
    }
}
