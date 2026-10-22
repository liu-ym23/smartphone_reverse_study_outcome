package com.bytedance.android.livesdk.link.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b6 {
    public static final List<p> a(a6 r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$linkUsersEx");
        List<com.bytedance.android.livesdk.link.model.bridge.k> r4 = r3.getLinkUsers();
        if (r4 == null) goto L8;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r5 = r4;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L11;
        r0.add((p) ((com.bytedance.android.livesdk.link.model.bridge.k) r6.next()).castTo(p.class));
        goto L6
    L11:
        return r0;
    L8:
        return null;
    }
}
