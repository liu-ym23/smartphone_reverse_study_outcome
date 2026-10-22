package com.bytedance.bdnavigationsdk.navigation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static List a(List r4) {
        List r0 = r4;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        ArrayList r2 = new ArrayList();
        Iterator r5 = r4.iterator();
    L14:
        if (r5.hasNext() == false) goto L25;
        com.bytedance.bdnavigationsdk.pojo.d r3 = (com.bytedance.bdnavigationsdk.pojo.d) r5.next();
        com.bytedance.bdnavigationsdk.pojo.a r6 = r3.a;
        if (r6 != null) goto L18;
    L22:
        com.bytedance.bdnavigationsdk.pojo.a r7 = r3.b;
        if (r7 == null) goto L14;
        r2.add(r7);
        goto L14
    L18:
        if (r2.isEmpty() == false) goto L20;
    L21:
        r2.add(r6);
        goto L22
    L20:
        if (Intrinsics.areEqual(CollectionsKt.last(r2), r6) == true) goto L22;
    L25:
        return r2;
    L11:
        return CollectionsKt.emptyList();
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }
}
