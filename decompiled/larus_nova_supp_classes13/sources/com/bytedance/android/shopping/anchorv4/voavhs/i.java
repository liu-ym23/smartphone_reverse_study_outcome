package com.bytedance.android.shopping.anchorv4.voavhs;

import androidx.recyclerview.widget.RecyclerView;
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
public final class i implements com.bytedance.android.ecom.arch.slice.d {
    public final LinkedHashMap<String, Function0<List<com.bytedance.android.ecom.arch.slice.g>>> a;
    public final RecyclerView b;

    public final List<com.bytedance.android.ecom.arch.slice.g> F() {
        Collection<Function0<List<com.bytedance.android.ecom.arch.slice.g>>> r0 = this.a.values();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        CollectionsKt.addAll(r1, (List) ((Function0) r2.next()).invoke());
        goto L4
    L7:
        if (r1.isEmpty() == false) goto L12;
        com.bytedance.android.ecom.arch.slice.adapter.d r3 = a();
        if (r3 != null) goto L20;
        return null;
    L20:
        return r3.Z1();
    L12:
        com.bytedance.android.ecom.arch.slice.adapter.d r4 = a();
        if (r4 == null) goto L16;
        List r5 = r4.Z1();
        if (r5 == null) goto L16;
    L17:
        ArrayList r6 = new ArrayList(r1.size() + r5.size());
        r6.addAll(r1);
        r6.addAll(r5);
        return r6;
    L16:
        r5 = CollectionsKt.emptyList();
        goto L17
    }

    public final com.bytedance.android.ecom.arch.slice.adapter.d a() {
        RecyclerView r0 = this.b;
        RecyclerView.Adapter r1 = null;
        if (r0 == null) goto L5;
        RecyclerView.Adapter r2 = r0.getAdapter();
    L7:
        if ((r2 instanceof com.bytedance.android.ecom.arch.slice.adapter.d) == false) goto L11;
        r1 = r2;
    L11:
        return (com.bytedance.android.ecom.arch.slice.adapter.d) r1;
    L5:
        r2 = null;
        goto L7
    }

    public i(RecyclerView r1) {
        this.b = r1;
        this.a = new LinkedHashMap();
    }

    public final void G(String r2, Function0<? extends List<? extends com.bytedance.android.ecom.arch.slice.g>> r3) {
        Intrinsics.checkNotNullParameter(r2, "componentKey");
        Intrinsics.checkNotNullParameter(r3, "provider");
        this.a.put(r2, r3);
    }

    public final boolean m(boolean r2, Function1<? super com.bytedance.android.ecom.arch.slice.g, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r3, "filter");
        com.bytedance.android.ecom.arch.slice.adapter.d r0 = a();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.m(r2, r3) != true) goto L7;
        return true;
    }
}
