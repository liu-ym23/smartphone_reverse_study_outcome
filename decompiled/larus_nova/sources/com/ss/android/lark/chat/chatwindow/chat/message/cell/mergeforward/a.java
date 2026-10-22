package com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {
    public static final int a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
    L6:
        if (r102 != null) goto L10;
        return 0;
    L10:
        return r102.bottomMargin;
    L5:
        r102 = null;
        goto L6
    }

    public static final boolean b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof AutoWrapLayout.LayoutParams) == false) goto L5;
        AutoWrapLayout.LayoutParams r102 = (AutoWrapLayout.LayoutParams) r101;
    L6:
        if (r102 != null) goto L10;
        return false;
    L10:
        return r102.f412619b;
    L5:
        r102 = null;
        goto L6
    }

    public static final int c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
    L6:
        if (r102 != null) goto L10;
        return 0;
    L10:
        return r102.leftMargin;
    L5:
        r102 = null;
        goto L6
    }

    public static final int d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
    L6:
        if (r102 != null) goto L10;
        return 0;
    L10:
        return r102.rightMargin;
    L5:
        r102 = null;
        goto L6
    }

    public static final int e(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
    L6:
        if (r102 != null) goto L10;
        return 0;
    L10:
        return r102.topMargin;
    L5:
        r102 = null;
        goto L6
    }
}
