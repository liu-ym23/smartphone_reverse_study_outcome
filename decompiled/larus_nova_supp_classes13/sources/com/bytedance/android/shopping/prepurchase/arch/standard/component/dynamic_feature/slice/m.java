package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m implements com.bytedance.android.ecom.arch.slice.d {
    public final List<WeakReference<com.bytedance.android.ecom.arch.slice.slices.b<List<com.bytedance.android.ecom.arch.slice.g>>>> a;
    public final LinkedHashMap<String, Function0<List<com.bytedance.android.ecom.arch.slice.g>>> b;

    public final boolean m(boolean r1, Function1<? super com.bytedance.android.ecom.arch.slice.g, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "filter");
        return false;
    }

    public final List<com.bytedance.android.ecom.arch.slice.g> F() {
        Collection<Function0<List<com.bytedance.android.ecom.arch.slice.g>>> r0 = this.b.values();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        CollectionsKt.addAll(r1, (List) ((Function0) r2.next()).invoke());
        goto L4
    L6:
        List<WeakReference<com.bytedance.android.ecom.arch.slice.slices.b<List<com.bytedance.android.ecom.arch.slice.g>>>> r3 = this.a;
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L8:
        if (r5.hasNext() == false) goto L16;
        com.bytedance.android.ecom.arch.slice.slices.b r6 = (com.bytedance.android.ecom.arch.slice.slices.b) ((WeakReference) r5.next()).get();
        if (r6 == null) goto L13;
        List r7 = (List) r6.provide();
        if (r7 == null) goto L13;
    L14:
        CollectionsKt.addAll(r4, r7);
    L13:
        r7 = CollectionsKt.emptyList();
        goto L14
    L16:
        if (r1.isEmpty() == true) goto L24;
        ArrayList r8 = new ArrayList(r1.size() + r4.size());
        r8.addAll(r1);
        r8.addAll(r4);
        return r8;
    L24:
        return r4;
    }

    public m() {
        this.a = new ArrayList();
        this.b = new LinkedHashMap();
    }

    public final void G(String r2, Function0<? extends List<? extends com.bytedance.android.ecom.arch.slice.g>> r3) {
        Intrinsics.checkNotNullParameter(r2, "componentKey");
        Intrinsics.checkNotNullParameter(r3, "provider");
        this.b.put(r2, r3);
    }
}
