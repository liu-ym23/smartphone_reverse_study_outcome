package com.bytedance.android.shopping.store.slicecard.view;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i {
    public final List<g> a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof i) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((i) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<g> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "TrustItem(richTexts=" + this.a + ")";
    }

    public final boolean a() {
        List<g> r0 = this.a;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L18;
        if (((g) r1.next()).b() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return false;
    }

    public i(List<g> r2) {
        Intrinsics.checkNotNullParameter(r2, "richTexts");
        this.a = r2;
    }
}
