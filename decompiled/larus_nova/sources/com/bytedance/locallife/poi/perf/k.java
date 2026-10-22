package com.bytedance.locallife.poi.perf;

import android.app.Activity;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.forest.model.o;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.forest.w;
import com.bytedance.ies.bullet.preloadv2.PreloadV2;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class k implements a {
    public k() {
    }

    @Override // com.bytedance.locallife.poi.perf.a
    public final void handle(Map<String, ? extends Object> r110) {
        Object r100 = r110.get("items");
        if ((r100 instanceof List) == false) goto L5;
        List r101 = (List) r100;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        Iterator r102 = r101.iterator();
        boolean r103 = false;
    L10:
        if (r102.hasNext() == false) goto L62;
        Object r104 = r102.next();
        if ((r104 instanceof Map) == false) goto L10;
        Map r105 = (Map) r104;
        Object r106 = r105.get("bid");
        if ((r106 instanceof String) == false) goto L17;
        String r107 = (String) r106;
    L18:
        if (r107 != null) goto L20;
        r107 = "default_bid";
    L20:
        Object r108 = r105.get("schema");
        if ((r108 instanceof String) == false) goto L23;
        String r109 = (String) r108;
    L24:
        if (r109 == null) goto L10;
        Object r111 = r105.get("type");
        if ((r111 instanceof String) == false) goto L29;
        String r112 = (String) r111;
    L31:
        if (r112 != null) goto L33;
        r112 = "ResourceLoader";
    L33:
        Object r113 = r105.get("decode");
        if ((r113 instanceof Boolean) == false) goto L36;
        Boolean r114 = (Boolean) r113;
    L37:
        if (r114 == null) goto L39;
        boolean r115 = r114.booleanValue();
    L40:
        Object r116 = r105.get("codecache");
        if ((r116 instanceof Boolean) == false) goto L43;
        Boolean r117 = (Boolean) r116;
    L44:
        if (r117 == null) goto L46;
        boolean r118 = r117.booleanValue();
    L47:
        if (r103 == true) goto L53;
        Activity r119 = HostServiceUtilsKt.E().getCurrentActivity();
        if (r119 == null) goto L50;
        com.bytedance.android.anniex.assemble.a.f40251a.c(r119);
        r103 = true;
        goto L53
    L50:
        return;
    L53:
        if (Intrinsics.areEqual(r112, "ResourceLoader") == false) goto L56;
        boolean r120 = PreloadV2.f247628a;
        PreloadV2.g(r109, r107, r115, r118);
        goto L10
    L56:
        if (Intrinsics.areEqual(r112, "Forest") == false) goto L10;
        String r121 = UUID.randomUUID().toString();
        com.bytedance.ies.bullet.forest.f<String, o> r122 = ForestLoader.f246728a;
        if (ForestLoader.n(null, r109, false, r121, PreloadType.LYNX, "PoiCommonPerf", null, true, new w(r109, 2), 1153) != 0) goto L10;
        goto L10
    L46:
        r118 = false;
        goto L47
    L43:
        r117 = null;
        goto L44
    L39:
        r115 = false;
        goto L40
    L36:
        r114 = null;
        goto L37
    L29:
        r112 = null;
        goto L31
    L23:
        r109 = null;
        goto L24
    L17:
        r107 = null;
        goto L18
    L62:
        return;
    L5:
        r101 = null;
        goto L6
    }
}
