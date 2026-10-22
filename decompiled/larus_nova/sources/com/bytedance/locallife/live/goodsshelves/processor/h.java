package com.bytedance.locallife.live.goodsshelves.processor;

import android.graphics.Typeface;
import com.bytedance.locallife.live.goodsshelves.bean.i0;
import com.bytedance.locallife.live.goodsshelves.bean.t;
import com.bytedance.locallife.live.goodsshelves.bean.x;
import com.bytedance.locallife.live.util.j0;
import com.bytedance.locallife.live.util.s;
import ev6.e0;
import ev6.g0;
import ev6.h0;
import ev6.n;
import ev6.o;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class h implements a<o> {
    public h() {
    }

    @Override // com.bytedance.locallife.live.goodsshelves.processor.a
    public final b a(i0 r110, Map r111) {
        Intrinsics.checkNotNullParameter(r110, "businessData");
        o r100 = new o(0);
        com.bytedance.locallife.live.goodsshelves.bean.g r101 = r110.b();
        com.bytedance.locallife.live.goodsshelves.bean.o r102 = r110.e();
        if (r102 == null) goto L9;
        t r103 = r102.b();
        if (r103 == null) goto L9;
        Float r104 = r103.d();
        if (r104 == null) goto L9;
        float r105 = r104.floatValue();
    L10:
        if (r102 == null) goto L16;
        t r106 = r102.b();
        if (r106 == null) goto L16;
        List<String> r107 = r106.c();
        if (r107 == null) goto L16;
        String r108 = (String) CollectionsKt.getOrNull(r107, 0);
    L17:
        n r109 = new n(0);
        r109.f474391c = Float.valueOf(r105);
        r109.f474390b = Float.valueOf(r105);
        r109.f474389a = r108;
        r100.f474400b = r109;
        if (r102 == null) goto L24;
        t r112 = r102.a();
        if (r112 == null) goto L24;
        List<String> r113 = r112.c();
        if (r113 == null) goto L24;
        String r114 = (String) CollectionsKt.getOrNull(r113, 0);
    L26:
        if (s.d(r114) == false) goto L28;
        n r115 = new n(0);
        r115.f474391c = Float.valueOf(r105);
        r115.f474390b = Float.valueOf(r105);
        r115.f474389a = r114;
        r100.f474401c = r115;
    L28:
        if (r102 == null) goto L32;
        Boolean r116 = r102.g();
        if (r116 == null) goto L32;
        boolean r117 = r116.booleanValue();
    L34:
        if (r117 == false) goto L41;
        if (r102 == null) goto L39;
        x r118 = r102.d();
        if (r118 == null) goto L39;
        String r119 = r118.e();
    L40:
        g0 r120 = new g0(0);
        r120.f474317a = true;
        r120.f474318b = r119;
        r100.f474404f = r120;
    L39:
        r119 = null;
    L41:
        if (r102 == null) goto L43;
        Integer r121 = r102.f();
    L44:
        if (r102 == null) goto L50;
        t r122 = r102.e();
        if (r122 == null) goto L50;
        List<String> r123 = r122.c();
        if (r123 == null) goto L50;
        String r124 = (String) CollectionsKt.getOrNull(r123, 0);
    L51:
        String r125 = "#ffffff";
        if (r121 != null) goto L55;
    L67:
        h0 r126 = new h0(0);
        r126.f474325a = s.d(r124);
        r126.f474326b = 1;
        r126.f474327c = r124;
        r126.f474329e = Float.valueOf(r105);
        r126.f474328d = Float.valueOf(r105);
        r100.f474402d = r126;
        e0 r127 = new e0(0);
        if (r102 == null) goto L72;
        x r128 = r102.c();
        if (r128 == null) goto L72;
        String r129 = r128.e();
    L73:
        r127.f474304a = r129;
        r127.f474305b = Integer.valueOf(com.bytedance.locallife.live.util.b.a("#00000099"));
        if (r102 == null) goto L81;
        x r130 = r102.c();
        if (r130 == null) goto L81;
        String r131 = r130.c();
        if (r131 == null) goto L81;
        r125 = r131;
    L81:
        r127.f474306c = Integer.valueOf(com.bytedance.locallife.live.util.b.a(r125));
        r127.f474307d = Typeface.create("sans-serif-medium", 0);
        if (r121 != null) goto L84;
        float r132 = 8;
        float r133 = 6;
        float[] r134 = {j0.b(r132), j0.b(r132), 0.0f, 0.0f, j0.b(r133), j0.b(r133), 0.0f, 0.0f};
    L85:
        r127.f474308e = r134;
        r100.f474403e = r127;
    L86:
        if (r101 == null) goto L90;
        Boolean r135 = r101.e();
        if (r135 == null) goto L90;
        boolean r136 = r135.booleanValue();
    L91:
        r100.f474405g = Boolean.valueOf(r136);
        o.a r137 = new o.a(0);
        r137.f474406a = Float.valueOf(r105);
        r137.f474407b = Float.valueOf(r105);
        r100.f474399a = r137;
        return r100;
    L90:
        r136 = false;
        goto L91
    L84:
        float r138 = 8;
        r134 = new float[]{j0.b(r138), j0.b(r138), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    L72:
        r129 = null;
        goto L73
    L55:
        if (r121.intValue() != 11) goto L67;
        h0 r139 = new h0(0);
        r139.f474325a = s.d(r124);
        r139.f474326b = 2;
        r139.f474327c = r124;
        r139.f474329e = Float.valueOf(r105);
        r139.f474328d = Float.valueOf(r105);
        r100.f474402d = r139;
        e0 r140 = new e0(0);
        x r141 = r102.c();
        if (r141 == null) goto L59;
        String r142 = r141.e();
    L60:
        r140.f474304a = r142;
        r140.f474305b = 0;
        x r143 = r102.c();
        if (r143 == null) goto L66;
        String r144 = r143.c();
        if (r144 == null) goto L66;
        r125 = r144;
    L66:
        r140.f474306c = Integer.valueOf(com.bytedance.locallife.live.util.b.a(r125));
        r140.f474307d = Typeface.create("sans-serif-medium", 2);
        float r145 = 8;
        r140.f474308e = new float[]{j0.b(r145), j0.b(r145), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        r100.f474403e = r140;
        goto L86
    L59:
        r142 = null;
    L50:
        r124 = null;
        goto L51
    L43:
        r121 = null;
    L32:
        r117 = false;
    L24:
        r114 = null;
    L16:
        r108 = null;
    L9:
        r105 = 118.0f;
        goto L10
    }
}
