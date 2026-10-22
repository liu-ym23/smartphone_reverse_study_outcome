package com.bytedance.android.window.shop.home.tab.tabplugin;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f {
    public final Set<e> a;

    public final void b() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).b();
        goto L4
    L6:
        this.a.clear();
    }

    public f() {
        this.a = new LinkedHashSet();
    }

    public final void a(e... r4) {
        Intrinsics.checkNotNullParameter(r4, "plugins");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r4[r1].a();
        r1 = r1 + 1;
        goto L3
    L5:
        CollectionsKt.addAll(this.a, r4);
    }
}
