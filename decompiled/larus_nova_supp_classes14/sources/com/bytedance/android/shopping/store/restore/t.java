package com.bytedance.android.shopping.store.restore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t {
    public static final ej3.f a(ej3.f r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$detachCallbacks");
        ej3.f r0 = new ej3.f();
        List<com.bytedance.android.ec.store.repository.vo.r> r1 = r6.a;
        List<com.bytedance.android.ec.store.repository.dto.c> r3 = null;
        if (r1 == null) goto L8;
        List<com.bytedance.android.ec.store.repository.vo.r> r2 = r1;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r5 = r2.iterator();
    L6:
        if (r5.hasNext() == false) goto L9;
        r4.add(((com.bytedance.android.ec.store.repository.vo.r) r5.next()).b());
    L9:
        r0.a = r4;
        List<com.bytedance.android.ec.store.repository.vo.r> r7 = r6.b;
        if (r7 == null) goto L15;
        List<com.bytedance.android.ec.store.repository.vo.r> r8 = r7;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r10 = r8.iterator();
    L13:
        if (r10.hasNext() == false) goto L16;
        r9.add(((com.bytedance.android.ec.store.repository.vo.r) r10.next()).b());
    L16:
        r0.b = r9;
        r0.c = r6.c;
        List<com.bytedance.android.ec.store.repository.dto.c> r11 = r6.d;
        if (r11 == null) goto L19;
        r3 = CollectionsKt.toList(r11);
    L19:
        r0.d = r3;
        r0.e = r6.e;
        r0.f = r6.f;
        return r0;
    L15:
        r9 = null;
        goto L16
    L8:
        r4 = null;
        goto L9
    }
}
