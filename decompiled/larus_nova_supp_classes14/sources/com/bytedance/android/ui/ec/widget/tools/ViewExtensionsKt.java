package com.bytedance.android.ui.ec.widget.tools;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b\u001a\u001a\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004\u001a,\u0010\n\u001a\u00020\u0001*\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¨\u0006\r"}, d2 = {"expandTouchArea", "", "Landroid/view/View;", "expectedSize", "", "expectedWidth", "expectedHeight", "forceSet", "", "expandTouchAreaForTopRightCorner", "increaseHitAreaForViews", "views", "", "ui-ec-widget_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class ViewExtensionsKt {
    public static final void expandTouchArea(View r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "$this$expandTouchArea");
        expandTouchArea$default(r7, r8, r8, false, 4, null);
    }

    public static final void expandTouchAreaForTopRightCorner(final View r2, final int r3, final int r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$expandTouchAreaForTopRightCorner");
        if (r2.getParent() == null) goto L9;
        ViewParent r0 = r2.getParent();
        if (r0 == null) goto L8;
        final ViewGroup r1 = (ViewGroup) r0;
    L10:
        if (r1 != null) goto L12;
        return;
    L12:
        r1.post(new RunnableC02051(r2, r3, r4, r1));
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L9:
        r1 = null;
        goto L10
    }

    public static final void expandTouchArea(final View r8, final int r9, final int r10, final boolean r11) {
        Intrinsics.checkNotNullParameter(r8, "$this$expandTouchArea");
        if (r8.getParent() == null) goto L9;
        ViewParent r0 = r8.getParent();
        if (r0 == null) goto L8;
        ViewGroup r1 = (ViewGroup) r0;
    L10:
        if (r1 != null) goto L12;
        return;
    L12:
        final ViewGroup r6 = r1;
        r1.post(new AnonymousClass1(r8, r9, r10, r11, r6));
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L9:
        r1 = null;
        goto L10
    }

    public static final void increaseHitAreaForViews(final View r7, final List<? extends View> r8, final int r9, final int r10) {
        Intrinsics.checkNotNullParameter(r7, "$this$increaseHitAreaForViews");
        Intrinsics.checkNotNullParameter(r8, "views");
        final TouchDelegateComposite r6 = new TouchDelegateComposite(r7, null, 2, null);
        r7.post(new RunnableC02061(r7, r8, r9, r10, r6));
    }

    public static /* synthetic */ void expandTouchArea$default(View r0, int r1, int r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        expandTouchArea(r0, r1, r2, r3);
    }

    public static /* synthetic */ void increaseHitAreaForViews$default(View r1, List r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = (int) r1.getResources().getDimension(2131166396);
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = (int) r1.getResources().getDimension(2131166396);
    L8:
        increaseHitAreaForViews(r1, r2, r3, r4);
    }
}
