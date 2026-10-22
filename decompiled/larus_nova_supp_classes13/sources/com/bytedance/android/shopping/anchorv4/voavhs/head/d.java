package com.bytedance.android.shopping.anchorv4.voavhs.head;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public static final List<c> a(List<b> r2) {
        Intrinsics.checkNotNullParameter(r2, "headNodeGroupList");
        ArrayList r0 = new ArrayList();
        Iterator<b> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r0.addAll(r3.next().c);
        goto L4
    L6:
        return r0;
    }
}
