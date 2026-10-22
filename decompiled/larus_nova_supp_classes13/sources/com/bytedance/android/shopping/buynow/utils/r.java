package com.bytedance.android.shopping.buynow.utils;

import android.content.Context;
import android.view.Window;
import android.view.accessibility.AccessibilityManager;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean c(Context r2) {
        if (r2 == null) goto L14;
        Object r3 = r2.getSystemService("accessibility");
        if (r3 == null) goto L13;
        AccessibilityManager r4 = (AccessibilityManager) r3;
        if (r4.isEnabled() == true) goto L9;
        return false;
    L9:
        if (r4.isTouchExplorationEnabled() == false) goto L16;
        return true;
    L16:
        return false;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
    L14:
        return false;
    }

    public static Window a(Context r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        boolean r0 = r2 instanceof com.bytedance.android.shopping.buynow.container.o;
        Object r4 = r2;
        if (r0 == true) goto L5;
        r4 = null;
    L5:
        com.bytedance.android.shopping.buynow.container.o r5 = (com.bytedance.android.shopping.buynow.container.o) r4;
        if (r5 != null) goto L11;
        Fragment r6 = r3.getParentFragment();
        if ((r6 instanceof com.bytedance.android.shopping.buynow.container.o) == true) goto L10;
        r6 = null;
    L10:
        r5 = (com.bytedance.android.shopping.buynow.container.o) r6;
    L11:
        if (r5 != null) goto L13;
        return null;
    L13:
        return r5.Ou();
    }

    public static Window b(Context r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        boolean r0 = r2 instanceof com.bytedance.android.shopping.buynow.container.o;
        Object r4 = r2;
        if (r0 == true) goto L5;
        r4 = null;
    L5:
        com.bytedance.android.shopping.buynow.container.o r5 = (com.bytedance.android.shopping.buynow.container.o) r4;
        if (r5 != null) goto L11;
        Fragment r6 = r3.getParentFragment();
        if ((r6 instanceof com.bytedance.android.shopping.buynow.container.o) == true) goto L10;
        r6 = null;
    L10:
        r5 = (com.bytedance.android.shopping.buynow.container.o) r6;
    L11:
        if (r5 != null) goto L13;
        return null;
    L13:
        return r5.TR();
    }
}
