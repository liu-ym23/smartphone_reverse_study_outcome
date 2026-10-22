package com.bytedance.component.lyric;

import android.graphics.Paint;
import android.text.TextUtils;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import jg4.j;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements jg4.b {
    public b() {
    }

    @Override // jg4.b
    public final void b(j r110, long r210) {
        Intrinsics.checkNotNullParameter(r110, "request");
        CopyOnWriteArrayList<com.bytedance.component.lyric.model.b> r100 = r110.f498989e;
        if ((!r100.isEmpty()) == true) goto L6;
        r100 = null;
    L6:
        if (r100 != null) goto L8;
        return;
    L8:
        jg4.a r101 = r110.f498990f;
        if (r101 != null) goto L11;
        return;
    L11:
        r101.f498981d = r210;
        Intrinsics.checkNotNullParameter(r100, "lyricsLineInfos");
        int r102 = r100.size();
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
    L12:
        if (r104 >= r102) goto L40;
        if (r100.get(r104).f203028a != 0) goto L39;
        if (r210 < r100.get(0).f203029b) goto L17;
        if (r210 >= r100.get(r104).f203029b) goto L28;
        if (r104 <= 0) goto L28;
        int r106 = r104 - 1;
        com.bytedance.component.lyric.model.b r107 = (com.bytedance.component.lyric.model.b) kg4.a.c(r100, r106);
        if (r107 != null) goto L24;
    L41:
        r101.f498980c = r104;
        com.bytedance.component.lyric.model.b r108 = (com.bytedance.component.lyric.model.b) kg4.a.c(r100, r104);
        if (r108 == null) goto L44;
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r101.f498982e = r108;
    L44:
        if (r104 >= 0) goto L46;
        return;
    L46:
        if (r104 >= r100.size()) goto L93;
        LyricsDisplayConfig r109 = r110.f498997m;
        Map<String, Float> r111 = r110.f498991g;
        com.bytedance.component.lyric.model.b r112 = r100.get(r104);
        Intrinsics.checkNotNullParameter(r101, "drawNode");
        Intrinsics.checkNotNullParameter(r109, "config");
        Intrinsics.checkNotNullParameter(r111, "cacheTextMap");
        Intrinsics.checkNotNullParameter(r112, "lyricsLineInfo");
        String r113 = "";
        if (r210 >= r112.f203029b) goto L50;
    L72:
        r101.f498983f = 0.0f;
        r101.f498979b = 0.0f;
        if (TextUtils.isEmpty(r112.f203031d) == false) goto L75;
        r101.f498978a = 0.0f;
        return;
    L75:
        Paint r114 = r109.f203017l;
        String r115 = r112.f203031d;
        if (r115 != null) goto L78;
        String r116 = "";
    L79:
        r101.f498978a = d(r111, r114, r116);
        return;
    L78:
        r116 = r115;
        goto L79
    L50:
        if (TextUtils.isEmpty(r112.f203031d) == true) goto L72;
        Paint r117 = r109.f203017l;
        String r118 = r112.f203031d;
        if (r118 != null) goto L55;
        r118 = "";
    L55:
        float r119 = d(r111, r117, r118);
        long r120 = r210 - ((long) r112.f203029b);
        StringBuilder r121 = new StringBuilder();
        int[] r122 = r112.f203034g;
        if (r122 == null) goto L70;
        int r123 = r122.length;
        long r124 = 0;
    L58:
        if (r103 >= r123) goto L70;
        String r125 = r113;
        long r126 = r122[r103];
        r124 = r124 + r126;
        String[] r127 = r112.f203033f;
        if (r127 == null) goto L63;
        String r128 = r127[r103];
        if (r128 == null) goto L63;
    L65:
        if (r120 < r124) goto L66;
        r121.append(r128);
        r103 = r103 + 1;
        r113 = r125;
        goto L58
    L66:
        if (r103 <= 0) goto L68;
        r120 = r120 - (r124 - r126);
    L68:
        float r129 = (d(r111, r109.f203017l, r128) / r122[r103]) * r120;
    L71:
        float r130 = r129 + d(r111, r109.f203017l, r121.toString());
        r101.f498983f = r130 / r119;
        r101.f498979b = r130;
        r101.f498978a = r119;
        return;
    L63:
        r128 = r125;
    L70:
        r129 = 0.0f;
        goto L71
    L93:
        return;
    L24:
        if (r107.f203028a != 0) goto L41;
        r104 = r106;
    L28:
        if (r104 != (r100.size() - 1)) goto L33;
        if (r210 < r100.get(r104).f203029b) goto L33;
        r104 = r100.size() - 1;
    L33:
        if (r104 >= r100.size()) goto L39;
        if (r210 <= r100.get(r104).f203029b) goto L39;
        if (r210 >= r100.get(r104).f203030c) goto L39;
        r105 = r104;
        goto L39
    L17:
        r104 = 0;
    L39:
        r104 = r104 + 1;
        goto L12
    L40:
        r104 = r105;
        goto L41
    }

    @Override // jg4.b
    public final void c(j r110, LyricsDisplayConfig r111) {
        Intrinsics.checkNotNullParameter(r110, "request");
        Intrinsics.checkNotNullParameter(r111, "config");
        List<com.bytedance.component.lyric.model.b> r100 = r110.f498987c;
        if (r100 != null) goto L5;
    L22:
        kg4.a.b("生成drawnode，" + r110.f498989e.size());
        return;
    L5:
        if ((!r100.isEmpty()) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L22;
        Iterator<com.bytedance.component.lyric.model.b> r101 = r100.iterator();
    L11:
        if (r101.hasNext() == false) goto L19;
        com.bytedance.component.lyric.model.b r102 = r101.next();
        if (TextUtils.isEmpty(r102.f203031d) == true) goto L11;
        CopyOnWriteArrayList<com.bytedance.component.lyric.model.b> r103 = r110.f498989e;
        Paint r104 = r111.f203016k;
        float r105 = r111.f203009d;
        int r106 = r110.f498988d;
        if (r103 == null) goto L17;
        Integer r107 = Integer.valueOf(r103.size());
    L18:
        a(r103, r102, r104, r105, r106, r107.intValue());
        goto L11
    L17:
        r107 = null;
        goto L18
    L19:
        com.bytedance.component.lyric.model.b r112 = (com.bytedance.component.lyric.model.b) CollectionsKt.firstOrNull(r110.f498989e);
        if (r112 == null) goto L22;
        r110.f498990f = new jg4.a(r112, r110.f498988d);
        goto L22
    }

    public static float d(Map r100, Paint r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "cacheTextMap");
        Intrinsics.checkNotNullParameter(r101, "paint");
        Intrinsics.checkNotNullParameter(r102, "content");
        LinkedHashMap r103 = (LinkedHashMap) r100;
        Float r104 = (Float) r103.get(r102);
        if (r104 != null) goto L7;
        float r105 = r101.measureText(r102);
        r103.put(r102, Float.valueOf(r105));
        return r105;
    L7:
        return r104.floatValue();
    }

    @Override // jg4.b
    public final void a(CopyOnWriteArrayList<com.bytedance.component.lyric.model.b> r110, com.bytedance.component.lyric.model.b r210, Paint r211, float r212, int r213, int r214) {
        Intrinsics.checkNotNullParameter(r110, "lyricsLineInfos");
        Intrinsics.checkNotNullParameter(r210, "lyricsLineInfo");
        Intrinsics.checkNotNullParameter(r211, "toolPaint");
        String r100 = r210.f203031d;
        int r101 = r110.size();
        if (r211.measureText(r100) > r212) goto L9;
        if (r214 >= (r101 + 1)) goto L91;
        r110.add(r210);
        return;
    L91:
        return;
    L9:
        if (r213 != 2) goto L26;
        com.bytedance.component.lyric.model.b r102 = new com.bytedance.component.lyric.model.b();
        com.bytedance.component.lyric.model.b r103 = new com.bytedance.component.lyric.model.b();
        StringBuilder r104 = new StringBuilder();
        StringBuilder r105 = new StringBuilder();
        StringBuilder r111 = new StringBuilder();
        String r112 = r210.f203031d;
        if (r112 == null) goto L74;
        int r113 = r112.length();
        int r106 = 0;
    L13:
        if (r106 >= r113) goto L19;
        char r114 = r112.charAt(r106);
        r104.append(r114);
        if (r211.measureText(r104.toString()) <= r212) goto L17;
        r111.append(r114);
    L18:
        r106 = r106 + 1;
        goto L13
    L17:
        r105.append(r114);
        goto L18
    L19:
        r102.f203029b = r210.f203029b;
        r102.f203031d = r105.toString();
        int r107 = r101 + 1;
        if (r214 >= r107) goto L22;
        r110.add(r102);
    L22:
        r103.f203029b = r210.f203029b + 4000;
        r103.f203031d = r111.toString();
        if (r214 >= (r107 + 1)) goto L92;
        r110.add(r103);
        return;
    L92:
        return;
    L74:
        return;
    L26:
        if (r213 != 3) goto L94;
        com.bytedance.component.lyric.model.b r108 = new com.bytedance.component.lyric.model.b();
        com.bytedance.component.lyric.model.b r109 = new com.bytedance.component.lyric.model.b();
        StringBuilder r115 = new StringBuilder();
        String[] r116 = r210.f203033f;
        if (r116 == null) goto L95;
        ArrayList r117 = new ArrayList();
        ArrayList r118 = new ArrayList();
        ArrayList r119 = new ArrayList();
        StringBuilder r120 = new StringBuilder();
        StringBuilder r121 = new StringBuilder();
        ArrayList r122 = new ArrayList();
        int r123 = r210.f203029b;
        int r124 = r116.length;
        int r125 = 0;
        int r126 = r123;
    L30:
        if (r125 >= r124) goto L44;
        int r215 = r124;
        String r127 = r116[r125];
        r115.append(r127);
        String[] r128 = r116;
        if (r211.measureText(r115.toString()) <= r212) goto L38;
        r119.add(r127);
        r121.append(r127);
        int[] r129 = r210.f203034g;
        if (r129 == null) goto L43;
        if (r125 >= r129.length) goto L43;
        r122.add(Integer.valueOf(r129[r125]));
    L43:
        r125 = r125 + 1;
        r124 = r215;
        r116 = r128;
        goto L30
    L38:
        r117.add(r127);
        r120.append(r127);
        int[] r130 = r210.f203034g;
        if (r130 == null) goto L43;
        if (r125 >= r130.length) goto L43;
        r118.add(Integer.valueOf(r130[r125]));
        r126 = r126 + r130[r125];
        goto L43
    L44:
        r108.f203029b = r210.f203029b;
        Object[] r131 = r117.toArray(new String[0]);
        if (r131 == null) goto L73;
        r108.f203033f = (String[]) r131;
        r108.f203034g = new int[r118.size()];
        int r132 = r118.size();
        int r133 = 0;
    L47:
        if (r133 >= r132) goto L52;
        int[] r134 = r108.f203034g;
        if (r134 == null) goto L51;
        r134[r133] = ((Number) ListProtector.get(r118, r133)).intValue();
    L51:
        r133 = r133 + 1;
        goto L47
    L52:
        String r135 = r120.toString();
        if (r135 == null) goto L71;
        r108.f203031d = StringsKt.trim(r135).toString();
        int r136 = r101 + 1;
        if (r214 >= r136) goto L57;
        r110.add(r108);
    L57:
        r109.f203029b = r126;
        Object[] r137 = r119.toArray(new String[0]);
        if (r137 == null) goto L69;
        r109.f203033f = (String[]) r137;
        r109.f203034g = new int[r122.size()];
        int r138 = r122.size();
        int r139 = 0;
    L60:
        if (r139 >= r138) goto L65;
        int[] r140 = r109.f203034g;
        if (r140 == null) goto L64;
        r140[r139] = ((Number) ListProtector.get(r122, r139)).intValue();
    L64:
        r139 = r139 + 1;
        goto L60
    L65:
        r109.f203031d = r121.toString();
        if (r214 >= (r136 + 1)) goto L96;
        r110.add(r109);
        return;
    L96:
        return;
    L69:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L71:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L73:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L95:
        return;
    }
}
