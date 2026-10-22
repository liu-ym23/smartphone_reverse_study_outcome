package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/business/pdp/components/ToggleBottomSheetBehavior;", "Landroid/view/View;", "V", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToggleBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> {
    public boolean a;
    public boolean b;

    public ToggleBottomSheetBehavior() {
    }

    public final boolean onTouchEvent(CoordinatorLayout r3, V r4, MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        Intrinsics.checkNotNullParameter(r4, "child");
        Intrinsics.checkNotNullParameter(r5, "event");
        if (r5.getActionMasked() != 0) goto L5;
        this.a = false;
        this.b = false;
    L5:
        boolean r6 = super.onTouchEvent(r3, r4, r5);
        int r7 = r5.getActionMasked();
        if (r7 == 1) goto L11;
        if (r7 == 3) goto L11;
    L16:
        return r6;
    L11:
        if (this.a == false) goto L13;
    L15:
        this.a = false;
        this.b = true;
        setState(5);
        goto L16
    L13:
        if (this.b == true) goto L15;
        goto L15
    }

    public final void onStopNestedScroll(CoordinatorLayout r2, V r3, View r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r3, "child");
        Intrinsics.checkNotNullParameter(r4, "target");
        super.onStopNestedScroll(r2, r3, r4, r5);
        if (this.a == false) goto L5;
    L7:
        this.a = false;
        this.b = true;
        setState(5);
        return;
    L5:
        if (this.b == true) goto L7;
    }
}
