package com.bytedance.ee.bear.bizwidget.dialogfragment;

import android.app.Dialog;
import android.view.View;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static final View a(Dialog r2) {
        if ((r2 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r3 = (BottomSheetDialog) r2;
    L6:
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getDelegate().findViewById(2131368870);
    L5:
        r3 = null;
        goto L6
    }

    public static final BottomSheetBehavior<View> b(Dialog r2) {
        View r3 = a(r2);
        if (r3 != null) goto L5;
        return null;
    L5:
        CoordinatorLayout.LayoutParams r4 = r3.getLayoutParams();
        if ((r4 instanceof CoordinatorLayout.LayoutParams) == false) goto L8;
        CoordinatorLayout.LayoutParams r5 = r4;
    L9:
        if (r5 != null) goto L11;
        return null;
    L11:
        BottomSheetBehavior<View> r6 = r5.getBehavior();
        if ((r6 instanceof BottomSheetBehavior) == false) goto L14;
        BottomSheetBehavior<View> r7 = r6;
    L15:
        if (r7 != null) goto L17;
        return null;
    L17:
        return r7;
    L14:
        r7 = null;
        goto L15
    L8:
        r5 = null;
        goto L9
    }

    public static final BottomSheetBehavior<FrameLayout> c(Dialog r2) {
        View r3 = a(r2);
        if ((r3 instanceof FrameLayout) == false) goto L5;
        FrameLayout r4 = (FrameLayout) r3;
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        CoordinatorLayout.LayoutParams r5 = r4.getLayoutParams();
        if ((r5 instanceof CoordinatorLayout.LayoutParams) == false) goto L11;
        CoordinatorLayout.LayoutParams r6 = r5;
    L12:
        if (r6 != null) goto L14;
        return null;
    L14:
        BottomSheetBehavior<FrameLayout> r7 = r6.getBehavior();
        if ((r7 instanceof BottomSheetBehavior) == false) goto L17;
        BottomSheetBehavior<FrameLayout> r8 = r7;
    L18:
        if (r8 != null) goto L20;
        return null;
    L20:
        return r8;
    L17:
        r8 = null;
        goto L18
    L11:
        r6 = null;
        goto L12
    L5:
        r4 = null;
        goto L6
    }
}
