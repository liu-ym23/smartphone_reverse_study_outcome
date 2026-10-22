package com.bytedance.android.window.shop.eventcard.handler;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements a {
    public final ConcurrentHashMap<String, Boolean> a;

    @Override // com.bytedance.android.window.shop.eventcard.handler.a
    public final void release() {
        this.a.clear();
    }

    public b() {
        this.a = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.window.shop.eventcard.handler.a
    public final Map<String, Object> a(int r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Object r5 = r4.get("blocked_events");
        if ((r5 instanceof List) == true) goto L5;
        r5 = null;
    L5:
        List r6 = (List) r5;
        if (r6 == null) goto L8;
        List r7 = r6;
        boolean r0 = true;
        if ((r7 instanceof Collection) == true) goto L12;
    L14:
        Iterator r8 = r7.iterator();
    L16:
        if (r8.hasNext() == false) goto L20;
        if ((r8.next() instanceof String) == true) goto L16;
        r0 = false;
    L20:
        if (r0 == false) goto L22;
        Iterator r9 = r7.iterator();
    L25:
        if (r9.hasNext() == false) goto L28;
        String r10 = (String) r9.next();
        this.a.put(r10, Boolean.TRUE);
        goto L25
    L28:
        return MapsKt.emptyMap();
    L22:
        return MapsKt.emptyMap();
    L12:
        if (r7.isEmpty() == false) goto L14;
    L8:
        return MapsKt.emptyMap();
    }
}
