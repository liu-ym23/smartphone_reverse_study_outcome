package com.bytedance.android.shopping.buynow.utils;

import android.view.View;
import android.widget.HorizontalScrollView;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q {
    static {
    }

    @JvmStatic
    public static final int a(View r2, View r3) {
        if (r2 == null) goto L14;
        if (r3 != null) goto L6;
        return 0;
    L6:
        if (Intrinsics.areEqual(r2.getParent(), r3) == true) goto L8;
        int r0 = r2.getLeft();
        Object r4 = r2.getParent();
        if ((r4 instanceof View) == true) goto L13;
        r4 = null;
    L13:
        return r0 + a((View) r4, r3);
    L8:
        return r2.getLeft();
    L14:
        return 0;
    }

    @JvmStatic
    public static final int b(View r2, View r3) {
        if (r2 == null) goto L14;
        if (r3 != null) goto L6;
        return 0;
    L6:
        if (Intrinsics.areEqual(r2.getParent(), r3) == true) goto L8;
        int r0 = r2.getTop();
        Object r4 = r2.getParent();
        if ((r4 instanceof View) == true) goto L13;
        r4 = null;
    L13:
        return r0 + b((View) r4, r3);
    L8:
        return r2.getTop();
    L14:
        return 0;
    }

    @JvmStatic
    public static final void c(View r2, HorizontalScrollView r3) {
        if (r2 == null) goto L7;
        if (r3 == null) goto L8;
        r3.smoothScrollTo(a(r2, r3) - ((r3.getWidth() - r2.getWidth()) / 2), 0);
        return;
    L8:
        return;
    }
}
