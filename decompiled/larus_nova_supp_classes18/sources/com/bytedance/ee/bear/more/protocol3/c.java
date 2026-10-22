package com.bytedance.ee.bear.more.protocol3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public final List<b> a;
    public final Map<String, b> b;

    public final i a() {
        List<b> r0 = this.a;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        b r3 = (b) r2.next();
        k r4 = r3.buildUI();
        if (r4 == null) goto L8;
        this.b.put(r4.a, r3);
    L8:
        if (r4 == null) goto L4;
        r1.add(r4);
        goto L4
    L11:
        return new i(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(List<? extends b> r2) {
        Intrinsics.checkNotNullParameter(r2, "items");
        this.a = r2;
        this.b = new LinkedHashMap();
    }

    public static void b(List r2, Function1 r3) {
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L16;
        b r0 = (b) r4.next();
        r3.invoke(r0);
        if ((r0 instanceof g) == false) goto L4;
        c r1 = ((g) r0).b();
        if (r1 == null) goto L10;
        List<b> r5 = r1.a;
    L11:
        if (r5 == null) goto L4;
        Iterator<b> r6 = r5.iterator();
    L14:
        if (r6.hasNext() == false) goto L4;
        r3.invoke(r6.next());
        goto L14
    L10:
        r5 = null;
        goto L11
    }
}
