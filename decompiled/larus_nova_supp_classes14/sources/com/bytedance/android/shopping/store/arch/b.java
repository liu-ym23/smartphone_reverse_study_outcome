package com.bytedance.android.shopping.store.arch;

import com.bytedance.android.ec.hybrid.list.entity.i;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import uj3.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static i a(ECStoreTabAreaVO r5) {
        List<j> r6 = r5.b;
        Object r0 = null;
        if (r6 == null) goto L18;
        Iterator<T> r7 = r6.iterator();
        j r1 = null;
    L6:
        if (r7.hasNext() == false) goto L19;
        j r2 = (j) r7.next();
        if (r2.i() == true) goto L9;
        List<j> r3 = r2.b;
        if (r3 == null) goto L6;
        Iterator<T> r4 = r3.iterator();
    L14:
        if (r4.hasNext() == false) goto L6;
        j r8 = (j) r4.next();
        if (r8.i() == false) goto L14;
        r1 = r8;
        goto L14
    L9:
        r1 = r2;
    L19:
        if (r1 == null) goto L47;
        k r9 = r1.I;
        if (r9 == null) goto L48;
        ArrayList r10 = r9.c;
        if (r10 == null) goto L49;
        Iterator r11 = r10.iterator();
    L26:
        if (r11.hasNext() == false) goto L31;
        Object r12 = r11.next();
        if (Intrinsics.areEqual(((i) r12).a, "__PRODUCTS_SECTION__") == false) goto L26;
        r0 = r12;
    L31:
        return (i) r0;
    L49:
        return null;
    L48:
        return null;
    L47:
        return null;
    L18:
        r1 = null;
        goto L19
    }
}
