package com.bytedance.android.ui.ec.widget.photodraweeview;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a%\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u000b\u001a\n\u0010\f\u001a\u00020\r*\u00020\u0006\u001a\u0012\u0010\u000e\u001a\u00020\r*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010\u001a\n\u0010\u000f\u001a\u00020\r*\u00020\u0006\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0011"}, d2 = {"dp", "", "", "getDp", "(Ljava/lang/Number;)I", "findCenterView", "Landroid/view/View;", "Landroidx/recyclerview/widget/RecyclerView;", "helper", "Landroidx/recyclerview/widget/OrientationHelper;", "ignorePos", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/OrientationHelper;Ljava/lang/Integer;)Landroid/view/View;", "gone", "", "showIf", "visible", "", "ui-ec-widget_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class ExtensionsKt {
    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_photodraweeview_ExtensionsKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static final int getDp(Number r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$dp");
        return (int) TypedValue.applyDimension(1, r2.floatValue(), INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_photodraweeview_ExtensionsKt_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()));
    }

    public static final void gone(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$gone");
        r1.setVisibility(8);
    }

    public static final void visible(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$visible");
        r1.setVisibility(0);
    }

    public static final void showIf(View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$showIf");
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public static final View findCenterView(RecyclerView r8, OrientationHelper r9, Integer r10) {
        Intrinsics.checkNotNullParameter(r8, "$this$findCenterView");
        Intrinsics.checkNotNullParameter(r9, "helper");
        RecyclerView.LayoutManager r11 = r8.getLayoutManager();
        View r0 = null;
        if (r11 == null) goto L25;
        int r1 = r11.getChildCount();
        if (r1 == 0) goto L25;
        if (r11.getClipToPadding() == false) goto L10;
        int r2 = r9.getStartAfterPadding() + (r9.getTotalSpace() / 2);
    L11:
        int r3 = Integer.MAX_VALUE;
        int r4 = 0;
    L12:
        if (r4 >= r1) goto L25;
        View r5 = r11.getChildAt(r4);
        if (r5 == null) goto L16;
        int r6 = r11.getPosition(r5);
    L17:
        if (r10 != null) goto L20;
    L21:
        int r7 = Math.abs((r9.getDecoratedStart(r5) + (r9.getDecoratedMeasurement(r5) / 2)) - r2);
        if (r7 >= r3) goto L24;
        r0 = r5;
        r3 = r7;
    L24:
        r4 = r4 + 1;
        goto L12
    L20:
        if (r6 == r10.intValue()) goto L24;
    L16:
        r6 = -1;
        goto L17
    L10:
        r2 = r9.getEnd() / 2;
    L25:
        return r0;
    }

    public static /* synthetic */ View findCenterView$default(RecyclerView r0, OrientationHelper r1, Integer r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return findCenterView(r0, r1, r2);
    }
}
