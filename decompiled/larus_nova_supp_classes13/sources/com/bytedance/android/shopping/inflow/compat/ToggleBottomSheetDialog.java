package com.bytedance.android.shopping.inflow.compat;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.commerce.uikit.base.ImmersiveAppCompatDialog;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class ToggleBottomSheetDialog extends ImmersiveAppCompatDialog {
    public static final /* synthetic */ int i = 0;
    public BottomSheetBehavior<FrameLayout> b;
    public boolean c;
    public boolean d;
    public boolean e;
    public final int f;
    public final Function0<Unit> g;
    public final b h;

    public class a extends AccessibilityDelegateCompat {
        public final /* synthetic */ ToggleBottomSheetDialog a;

        public a(ToggleBottomSheetDialog r1) {
            this.a = r1;
        }

        public final void onInitializeAccessibilityNodeInfo(View r1, AccessibilityNodeInfoCompat r2) {
            super.onInitializeAccessibilityNodeInfo(r1, r2);
            if (this.a.c == false) goto L5;
            r2.addAction(1048576);
            r2.setDismissable(true);
            return;
        L5:
            r2.setDismissable(false);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [android.app.Dialog, com.bytedance.android.shopping.inflow.compat.ToggleBottomSheetDialog] */
        public final boolean performAccessibilityAction(View r3, int r4, Bundle r5) {
            if (r4 != 1048576) goto L9;
            ?? r0 = this.a;
            if (r0.c == false) goto L9;
            r0.cancel();
            return true;
        L9:
            return super.performAccessibilityAction(r3, r4, r5);
        }
    }

    public class b extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ ToggleBottomSheetDialog a;

        public final void onSlide(View r1, float r2) {
        }

        public b(ToggleBottomSheetDialog r1) {
            this.a = r1;
        }

        public final void onStateChanged(View r1, int r2) {
            if (r2 != 5) goto L6;
            this.a.cancel();
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStart() {
        super/*android.app.Dialog*/.onStart();
        BottomSheetBehavior<FrameLayout> r0 = this.b;
        if (r0 == null) goto L6;
        r0.setState(4);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCancelable(boolean r2) {
        super/*android.app.Dialog*/.setCancelable(r2);
        if (this.c == r2) goto L8;
        this.c = r2;
        BottomSheetBehavior<FrameLayout> r0 = this.b;
        if (r0 == null) goto L9;
        r0.setHideable(r2);
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCanceledOnTouchOutside(boolean r3) {
        super/*android.app.Dialog*/.setCanceledOnTouchOutside(r3);
        if (r3 == true) goto L5;
    L7:
        this.d = r3;
        this.e = true;
        return;
    L5:
        if (this.c == true) goto L7;
        this.c = true;
        goto L7
    }

    public final void setContentView(View r3) {
        super.setContentView(wrapInBottomSheet(0, r3, null));
    }

    public final void setContentView(int r2) {
        super.setContentView(wrapInBottomSheet(r2, null, null));
    }

    public final void setContentView(View r2, ViewGroup.LayoutParams r3) {
        super.setContentView(wrapInBottomSheet(0, r2, r3));
    }

    public ToggleBottomSheetDialog(FragmentActivity r2, int r3, Function0 r4) {
        super(r2, 2131952019);
        this.c = true;
        this.d = true;
        this.f = 0;
        this.h = new b(this);
        this.f = r3;
        this.g = r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View wrapInBottomSheet(int r6, View r7, ViewGroup.LayoutParams r8) {
        int r0 = this.f;
        if (r0 > 0) goto L5;
        r0 = 2131560614;
    L5:
        ViewGroup r1 = (ViewGroup) th.a.c(getContext(), r0, null, false);
        CoordinatorLayout r2 = r1.findViewById(2131367947);
        if (r6 == 0) goto L9;
        if (r7 != null) goto L9;
        r7 = th.a.c(getContext(), r6, r2, false);
    L9:
        FrameLayout r9 = (FrameLayout) r2.findViewById(2131367490);
        BottomSheetBehavior<FrameLayout> r3 = BottomSheetBehavior.from(r9);
        this.b = r3;
        r3.setBottomSheetCallback(this.h);
        this.b.setHideable(this.c);
        if (r8 != null) goto L12;
        r9.addView(r7);
    L13:
        r2.findViewById(2131389274).setOnClickListener(new com.bytedance.android.shopping.inflow.compat.a(this));
        ViewCompat.setAccessibilityDelegate(r9, new a(this));
        r9.setOnTouchListener(new com.bytedance.android.shopping.inflow.compat.b());
        Window r10 = getWindow();
        if (r10 == null) goto L21;
        WindowManager.LayoutParams r11 = r10.getAttributes();
        r11.width = -1;
        r11.height = -1;
        View r12 = r10.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L20;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r4 = ThreadMethodProxy.currentThread();
        if (r4 == com.larus.home.impl.utils.c.a) goto L20;
        com.larus.home.impl.utils.c.a(r4, "getDecorView");
    L20:
        r12.setPadding(0, 0, 0, 0);
        r10.setAttributes(r11);
    L21:
        return r1;
    L12:
        r9.addView(r7, r8);
        goto L13
    }
}
