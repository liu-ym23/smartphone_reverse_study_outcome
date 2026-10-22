package com.bytedance.android.window.shop.eventcard.handler;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f implements a {
    public final ep3.b a;

    @Override // com.bytedance.android.window.shop.eventcard.handler.a
    public final void release() {
    }

    public f(ep3.c[] r2) {
        Intrinsics.checkNotNullParameter(r2, "providers");
        this.a = new ep3.b(ArraysKt.toList(r2));
    }

    @Override // com.bytedance.android.window.shop.eventcard.handler.a
    public final Map<String, Object> a(int r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        Object r6 = r5.get("query_keys");
        if ((r6 instanceof List) == true) goto L5;
        r6 = null;
    L5:
        List r7 = (List) r6;
        if (r7 == null) goto L8;
        List r8 = r7;
        boolean r1 = true;
        if ((r8 instanceof Collection) == true) goto L12;
    L14:
        Iterator r9 = r8.iterator();
    L16:
        if (r9.hasNext() == false) goto L20;
        if ((r9.next() instanceof String) == true) goto L16;
        r1 = false;
    L20:
        if (r1 == false) goto L22;
        ep3.b r10 = this.a;
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r11 = r7.iterator();
    L25:
        if (r11.hasNext() == false) goto L30;
        String r2 = (String) r11.next();
        Object r3 = r10.a(r2);
        if (r3 == null) goto L25;
        r0.put(r2, r3);
        goto L25
    L30:
        return r0;
    L22:
        return MapsKt.emptyMap();
    L12:
        if (r8.isEmpty() == false) goto L14;
    L8:
        return MapsKt.emptyMap();
    }
}
