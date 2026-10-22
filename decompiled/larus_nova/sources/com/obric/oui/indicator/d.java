package com.obric.oui.indicator;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MarginLayoutParamsCompat;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class d {
    public static final void a(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        ViewGroup.LayoutParams r103 = null;
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r102;
    L6:
        if (r104 == null) goto L9;
        r104.setMarginStart(r101);
        r104.setMarginEnd(r101);
        r100.requestLayout();
        r103 = r104;
    L9:
        r100.setLayoutParams(r103);
        return;
    L5:
        r104 = null;
        goto L6
    }

    public static final void b(RadiusLayout r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        ViewGroup.LayoutParams r103 = null;
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r102;
    L6:
        if (r104 == null) goto L25;
        ViewGroup.LayoutParams r105 = r100.getLayoutParams();
        int r106 = 0;
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        int r107 = MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) r105);
    L12:
        ViewGroup.LayoutParams r108 = r100.getLayoutParams();
        if ((r108 instanceof ViewGroup.MarginLayoutParams) == false) goto L16;
        r103 = r108;
    L16:
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r103;
        if (r109 == null) goto L19;
        int r110 = r109.topMargin;
    L20:
        ViewGroup.LayoutParams r111 = r100.getLayoutParams();
        if ((r111 instanceof ViewGroup.MarginLayoutParams) == false) goto L23;
        r106 = MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) r111);
    L23:
        r104.setMargins(r107, r110, r106, r101);
        r100.requestLayout();
        return;
    L19:
        r110 = 0;
        goto L20
    L11:
        r107 = 0;
        goto L12
    L25:
        return;
    L5:
        r104 = null;
        goto L6
    }

    public static final void c(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.getLayoutParams().width = r101;
        r100.requestLayout();
    }
}
