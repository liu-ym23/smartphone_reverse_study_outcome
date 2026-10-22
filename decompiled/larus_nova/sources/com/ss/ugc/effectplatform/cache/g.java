package com.ss.ugc.effectplatform.cache;

import com.ss.ugc.effectplatform.EffectConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EffectConfig f457335a;

    public g(EffectConfig r100) {
        this.f457335a = r100;
    }

    public static final void a(g r110, String r210) {
        r110.getClass();
        l.a r100 = l.f457359c;
        Object r101 = r110.f457335a.G;
        r100.getClass();
        if (l.a.a(r101) == null) goto L25;
        Pair r102 = l.a();
        klc.a r103 = r110.f457335a.f457176v.f1239a;
        int r104 = 4;
        float r105 = 1024.0f;
        if (r103 == null) goto L7;
        r103.monitorStatusRate("ep_effect_storage_info", 0, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("count", Integer.valueOf(((Number) r102.getFirst()).intValue())), TuplesKt.to("lru_max_size", Integer.valueOf((int) (r110.f457335a.L / 1024.0f))), TuplesKt.to("size", Float.valueOf(((Number) r102.getSecond()).floatValue() / 1024.0f)), TuplesKt.to("source", r210)}));
    L7:
        LinkedHashMap r106 = new LinkedHashMap();
        Iterator r107 = new ArrayList().iterator();
    L9:
        if (r107.hasNext() == false) goto L15;
        k r111 = (k) r107.next();
        Object r112 = r106.get(r111.f457348d);
        if (r112 != null) goto L14;
        r112 = TuplesKt.to(0, 0L);
    L14:
        Pair r113 = (Pair) r112;
        r106.put(r111.f457348d, TuplesKt.to(Integer.valueOf(((Number) r113.getFirst()).intValue() + 1), Long.valueOf(((Number) r113.getSecond()).longValue() + r111.f457354j)));
        goto L9
    L15:
        List r108 = CollectionsKt.sortedWith(r106.keySet(), new f(r106));
        Iterator r109 = r108.subList(0, Math.min(10, r108.size())).iterator();
    L17:
        if (r109.hasNext() == false) goto L32;
        String r114 = (String) r109.next();
        Pair r115 = (Pair) r106.get(r114);
        if (r115 == null) goto L24;
        klc.a r116 = r110.f457335a.f457176v.f1239a;
        if (r116 == null) goto L24;
        int r117 = ((Number) r115.getFirst()).intValue();
        float r118 = ((Number) r115.getSecond()).floatValue() / r105;
        Pair[] r119 = new Pair[r104];
        r119[0] = TuplesKt.to("panel", r114);
        r119[1] = TuplesKt.to("count", Integer.valueOf(r117));
        r119[2] = TuplesKt.to("size", Float.valueOf(r118));
        r119[3] = TuplesKt.to("source", r210);
        r116.monitorStatusRate("ep_effect_storage_panel_info", 0, MapsKt.mutableMapOf(r119));
    L24:
        r104 = 4;
        r105 = 1024.0f;
        goto L17
    L32:
        return;
    }
}
