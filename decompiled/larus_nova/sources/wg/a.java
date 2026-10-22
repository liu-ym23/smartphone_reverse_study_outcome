package wg;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.k1;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes43.dex */
public final class a {
    public static final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$detachParent");
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup r102 = (ViewGroup) r101;
        if (r102 == null) goto L9;
        r102.removeView(r100);
        return;
    }

    public static final float b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getVisibleAreaRatioInScreen");
        if (r100.getHeight() != 0) goto L5;
    L12:
        return 0.0f;
    L5:
        if (r100.getWidth() == 0) goto L12;
        int[] r101 = c(r100);
        int[] r102 = new int[2];
        Context r103 = k1.c();
        if (r103 == null) goto L10;
        Resources r104 = r103.getResources();
        DisplayMetrics r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics());
        r102 = new int[]{r105.widthPixels, r105.heightPixels};
    L10:
        int r106 = r101[0];
        int r107 = r101[1];
        int r108 = r102[0];
        int r109 = r102[1];
        int r110 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r106, 0), r108);
        return RangesKt.coerceAtMost(RangesKt.coerceAtLeast((((RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r107 + r100.getHeight(), 0), r109) - RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r107, 0), r109)) * 1.0f) * (RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r106 + r100.getWidth(), 0), r108) - r110)) / RangesKt.coerceAtLeast(r100.getHeight() * r100.getWidth(), 1), 0.0f), 1.0f);
    }

    public static final int[] c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$locationInScreen");
        int[] r101 = new int[2];
        r100.getLocationOnScreen(r101);
        return r101;
    }

    public static final void d(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setHeight");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L5;
        r102.height = r101;
    L5:
        r100.setLayoutParams(r102);
    }

    public static final void g(TextView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setTextSizeDp");
        r100.setTextSize(1, r101);
    }

    public static final void h(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setVisible");
        if (r101 == false) goto L5;
        int r102 = 0;
    L6:
        r100.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public static final void i(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setWidth");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L5;
        r102.width = r101;
    L5:
        r100.setLayoutParams(r102);
    }

    public static /* synthetic */ void f(View r100, int r101, int r102, int r103, int r110) {
        e(r100, r101, r102, r103, r110, false);
    }

    public static final void e(View r100, int r101, int r102, int r103, int r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "$this$setMargins");
        if ((r100.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
        ViewGroup.LayoutParams r106 = r100.getLayoutParams();
        if (r106 == null) goto L11;
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
        r107.setMargins(r101, r102, r103, r104);
        if (r105 == false) goto L9;
        r107.setMarginEnd(r103);
        r107.setMarginStart(r101);
    L9:
        r100.setLayoutParams(r107);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
}
