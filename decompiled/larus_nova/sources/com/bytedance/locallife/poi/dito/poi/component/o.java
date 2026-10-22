package com.bytedance.locallife.poi.dito.poi.component;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes21.dex */
public final class o implements com.bytedance.locallife.biz.widget.a {
    public o() {
    }

    @Override // com.bytedance.locallife.biz.widget.a
    public final Map<String, Object> getGlobalProps() {
        int r100 = com.bytedance.locallife.poi.newdetail.h.f263265d;
        if (r100 <= 0) goto L7;
        int r101 = com.bytedance.locallife.dito.utils.e.d(Integer.valueOf(r100));
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("screenWidth", Integer.valueOf(r101)), TuplesKt.to("contentWidth", Integer.valueOf(r101)), TuplesKt.to("cubeScreenWidth", Integer.valueOf(r101)), TuplesKt.to("padAndFoldPercent", Integer.valueOf(MathKt.roundToInt((((double) r101) / ((double) gm4.a.c(null).f485914a)) * ((double) 100))))});
    L7:
        return MapsKt.emptyMap();
    }

    @Override // com.bytedance.locallife.biz.widget.a
    public final Map<String, Object> a() {
        return MapsKt.emptyMap();
    }
}
