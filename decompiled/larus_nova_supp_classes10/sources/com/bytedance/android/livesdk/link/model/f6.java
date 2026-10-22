package com.bytedance.android.livesdk.link.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f6 {
    public static final List<p> a(e6 r3) {
        if (r3 == null) goto L9;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r4 = r3.getInviteeFollowUsers();
        if (r4 == null) goto L9;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r5 = r4;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L12;
        r0.add((p) ((com.bytedance.android.livesdk.link.model.bridge.k) r6.next()).castTo(p.class));
        goto L7
    L12:
        return r0;
    L9:
        return null;
    }

    public static final List<p> b(e6 r3) {
        List<com.bytedance.android.livesdk.link.model.bridge.k> r4 = r3.getInviterUsers();
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
