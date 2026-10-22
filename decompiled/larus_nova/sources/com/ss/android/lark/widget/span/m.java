package com.ss.android.lark.widget.span;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.TextView;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.widget.light.LKUILightTextView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes38.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageSpan f448707a;

    public final Drawable b() {
        Drawable r100 = this.f448707a.getDrawable();
        if ((r100 instanceof s) == false) goto L5;
        r100 = ((s) r100).f448770a;
    L5:
        Drawable.ConstantState r101 = r100.getConstantState();
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.newDrawable();
    }

    public m(ImageSpan r100) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        this.f448707a = r100;
    }

    public final Rect a(View r110) {
        Intrinsics.checkNotNullParameter(r110, "parentTextView");
        if ((r110 instanceof TextView) == false) goto L6;
        Layout r100 = ((TextView) r110).getLayout();
    L8:
        Intrinsics.checkNotNull(r100);
        CharSequence r101 = r100.getText();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.text.Spanned");
        Spanned r102 = (Spanned) r101;
        int r103 = r102.getSpanStart(this.f448707a);
        int r104 = r102.getSpanEnd(this.f448707a);
        float r105 = r100.getPrimaryHorizontal(r103);
        float r106 = r100.getPrimaryHorizontal(r104);
        Drawable r107 = this.f448707a.getDrawable();
        int r108 = r100.getLineForOffset(r103);
        Rect r109 = new Rect();
        r100.getLineBounds(r108, r109);
        int r111 = r109.height() - r107.getIntrinsicHeight();
        int r112 = this.f448707a.getVerticalAlignment();
        if (r112 == 1) goto L13;
        if (r112 != 2) goto L14;
        r111 = (r109.height() - r107.getIntrinsicHeight()) / 2;
    L14:
        int[] r113 = new int[2];
        r110.getLocationOnScreen(r113);
        int r114 = (r113[1] - r110.getScrollY()) + r110.getPaddingTop();
        r109.top += r111 + r114;
        r109.bottom += r114;
        int r115 = r109.left + MathKt.roundToInt(((r113[0] + r105) + r110.getPaddingLeft()) - r110.getScrollX());
        r109.left = r115;
        r109.right = MathKt.roundToInt((r115 + r106) - r105);
        return r109;
    L13:
        r111 = r111 - r100.getLineDescent(r108);
        goto L14
    L6:
        if ((r110 instanceof LKUILightTextView) == false) goto L17;
        r100 = ((LKUILightTextView) r110).getLayout();
        goto L8
    L17:
        return new Rect();
    }
}
