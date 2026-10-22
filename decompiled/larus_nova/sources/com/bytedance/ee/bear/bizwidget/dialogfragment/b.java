package com.bytedance.ee.bear.bizwidget.dialogfragment;

import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class b {
    public static final View a(Dialog r100) {
        if ((r100 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r101 = (BottomSheetDialog) r100;
    L6:
        if (r101 != null) goto L9;
        return null;
    L9:
        return r101.getDelegate().findViewById(R.id.design_bottom_sheet);
    L5:
        r101 = null;
        goto L6
    }

    public static final BottomSheetBehavior<View> b(Dialog r100) {
        View r101 = a(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if ((r102 instanceof CoordinatorLayout.LayoutParams) == false) goto L8;
        CoordinatorLayout.LayoutParams r103 = (CoordinatorLayout.LayoutParams) r102;
    L9:
        if (r103 != null) goto L11;
        return null;
    L11:
        CoordinatorLayout.Behavior r104 = r103.getBehavior();
        if ((r104 instanceof BottomSheetBehavior) == false) goto L14;
        BottomSheetBehavior<View> r105 = (BottomSheetBehavior) r104;
    L15:
        if (r105 != null) goto L17;
        return null;
    L17:
        return r105;
    L14:
        r105 = null;
        goto L15
    L8:
        r103 = null;
        goto L9
    }

    public static final BottomSheetBehavior<FrameLayout> c(Dialog r100) {
        View r101 = a(r100);
        if ((r101 instanceof FrameLayout) == false) goto L5;
        FrameLayout r102 = (FrameLayout) r101;
    L6:
        if (r102 != null) goto L8;
        return null;
    L8:
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if ((r103 instanceof CoordinatorLayout.LayoutParams) == false) goto L11;
        CoordinatorLayout.LayoutParams r104 = (CoordinatorLayout.LayoutParams) r103;
    L12:
        if (r104 != null) goto L14;
        return null;
    L14:
        CoordinatorLayout.Behavior r105 = r104.getBehavior();
        if ((r105 instanceof BottomSheetBehavior) == false) goto L17;
        BottomSheetBehavior<FrameLayout> r106 = (BottomSheetBehavior) r105;
    L18:
        if (r106 != null) goto L20;
        return null;
    L20:
        return r106;
    L17:
        r106 = null;
        goto L18
    L11:
        r104 = null;
        goto L12
    L5:
        r102 = null;
        goto L6
    }
}
