package com.bytedance.locallife.poi.perf;

import com.bytedance.android.locallife.core.service.LifeServiceManager;
import com.bytedance.common.utility.DigestUtils;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements a {
    public d() {
    }

    @Override // com.bytedance.locallife.poi.perf.a
    public final void handle(Map<String, ? extends Object> r100) {
        Object r101 = r100.get("fonts");
        if ((r101 instanceof List) == false) goto L5;
        List r102 = (List) r101;
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        ConcurrentHashMap<Class<?>, Object> r103 = LifeServiceManager.f162660a;
        final ep6.b r104 = (ep6.b) LifeServiceManager.b(ep6.b.class);
        if (r104 != null) goto L11;
        return;
    L11:
        Iterator r105 = r102.iterator();
    L13:
        if (r105.hasNext() == false) goto L35;
        Object r106 = r105.next();
        if ((r106 instanceof Map) == false) goto L17;
        Map r107 = (Map) r106;
    L18:
        if (r107 == null) goto L13;
        Object r108 = r107.get("name");
        if ((r108 instanceof String) == false) goto L23;
        final String r109 = (String) r108;
    L24:
        if (r109 == null) goto L13;
        Object r110 = r107.get("url");
        if ((r110 instanceof String) == false) goto L29;
        String r111 = (String) r110;
    L30:
        if (r111 == null) goto L13;
        String r112 = DigestUtils.md5Hex(r111);
        if (r104.containsTypeface(r109) == true) goto L13;
        HostServiceUtilsKt.S().g(r112, r111, new FontPrefetchAction$downloadAndCacheFont$1(this, r104, r109));
        goto L13
    L29:
        r111 = null;
        goto L30
    L23:
        r109 = null;
        goto L24
    L17:
        r107 = null;
        goto L18
    L35:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
