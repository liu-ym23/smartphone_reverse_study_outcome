package com.bytedance.android.livesdk.livecommerce.utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o0 {
    public static final int a(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$layoutMarginLeft");
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r2 = null;
    L5:
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        if (r3 != null) goto L10;
        return 0;
    L10:
        return r3.leftMargin;
    }

    public static final int b(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$layoutMarginRight");
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r2 = null;
    L5:
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        if (r3 != null) goto L10;
        return 0;
    L10:
        return r3.rightMargin;
    }

    public static final void c(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$layoutGravity");
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if ((r0 instanceof FrameLayout.LayoutParams) == false) goto L6;
        ((FrameLayout.LayoutParams) r0).gravity = r3;
        r2.setLayoutParams(r0);
        return;
    }

    public static final void d(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$layoutHeight");
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        if (r0 == null) goto L6;
        r0.height = r2;
        r1.setLayoutParams(r0);
        return;
    }

    public static final void e(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$layoutMarginLeft");
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ((ViewGroup.MarginLayoutParams) r0).leftMargin = r3;
        r2.setLayoutParams(r0);
        return;
    }

    public static final void f(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$layoutWidth");
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        if (r0 == null) goto L6;
        r0.width = r2;
        r1.setLayoutParams(r0);
        return;
    }
}
