package com.bytedance.android.shopping.store.home.view;

import android.view.View;
import android.view.ViewParent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class x {
    public final View a;

    public x(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.a = r2;
    }

    public static TopSheetLayout a(View r2) {
        Object r0 = null;
        if (r2 != null) goto L5;
        return null;
    L5:
        if ((r2 instanceof TopSheetLayout) == true) goto L7;
        ViewParent r3 = r2.getParent();
        if ((r3 instanceof View) == false) goto L13;
        r0 = r3;
    L13:
        return a((View) r0);
    L7:
        return (TopSheetLayout) r2;
    }
}
