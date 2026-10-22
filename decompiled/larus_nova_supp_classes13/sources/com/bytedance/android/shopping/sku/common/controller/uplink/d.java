package com.bytedance.android.shopping.sku.common.controller.uplink;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public a a;
    public final Map<String, Boolean> b;
    public final AtomicLong c;
    public long d;
    public com.bytedance.android.shopping.sku.inner.repo.a e;

    public final b a() {
        Iterator r0 = ((LinkedHashMap) this.b).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) r0.next();
        if (((Boolean) r1.getValue()).booleanValue() == false) goto L4;
        return new b(true, (String) r1.getKey());
    L10:
        return new b(false, "");
    }

    public final void b() {
        Iterator r0 = ((LinkedHashMap) this.b).keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = (String) r0.next();
        this.b.put(r1, Boolean.FALSE);
        goto L4
    }

    public d() {
        this.a = new a(CollectionsKt.emptyList(), CollectionsKt.emptyList());
        this.b = new LinkedHashMap();
        this.c = new AtomicLong(0);
    }
}
