package com.bytedance.android.shopping.prepurchase.business.pdp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/business/pdp/view/PdpCoordinateLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "Landroidx/core/view/NestedScrollingParent3;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PdpCoordinateLayout extends CoordinatorLayout {
    public PdpCoordinateLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PdpCoordinateLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public PdpCoordinateLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ PdpCoordinateLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final boolean onStartNestedScroll(View r2, View r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "child");
        Intrinsics.checkNotNullParameter(r3, "target");
        if (r4 != 1) goto L7;
        return false;
    L7:
        return super.onStartNestedScroll(r2, r3, r4, r5);
    }

    public final void onNestedScroll(View r2, int r3, int r4, int r5, int r6, int r7, int[] r8) {
        Intrinsics.checkNotNullParameter(r2, "target");
        Intrinsics.checkNotNullParameter(r8, "consumed");
        onNestedScroll(r2, r3, r4, r5, r6, r7);
    }
}
