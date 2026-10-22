package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class h {
    public static void a(View r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "action");
        r100.setOnClickListener(new f(500, r101));
    }

    public static void b(View r100, Integer r101, Integer r102, int r103) {
        ViewGroup.MarginLayoutParams r104 = null;
        if ((r103 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewGroup.LayoutParams r105 = r100.getLayoutParams();
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        r104 = (ViewGroup.MarginLayoutParams) r105;
    L11:
        if (r104 == null) goto L28;
        boolean r106 = true;
        if (r101 == null) goto L18;
        int r107 = r101.intValue();
        if (r104.getMarginStart() == r107) goto L18;
        r104.setMarginStart(r107);
        boolean r108 = true;
    L19:
        if (r102 == null) goto L23;
        int r109 = r102.intValue();
        if (r104.topMargin == r109) goto L23;
        r104.topMargin = r109;
    L24:
        if (r106 == false) goto L27;
        r100.setLayoutParams(r104);
        return;
    L27:
        return;
    L23:
        r106 = r108;
    L18:
        r108 = false;
        goto L19
    }
}
