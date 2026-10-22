package com.bytedance.android.shopping.store.tabkit.container;

import android.content.Context;
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
import com.bytedance.commerce.uikit.base.ImmersiveAppCompatDialog;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class TabKitToggleBottomSheetDialog extends ImmersiveAppCompatDialog {
    public static final /* synthetic */ int f = 0;
    public boolean b;
    public boolean c;
    public boolean d;
    public final int e;

    public class a extends AccessibilityDelegateCompat {
        public final /* synthetic */ TabKitToggleBottomSheetDialog a;

        public a(TabKitToggleBottomSheetDialog r1) {
            this.a = r1;
        }

        public final void onInitializeAccessibilityNodeInfo(View r1, AccessibilityNodeInfoCompat r2) {
            super.onInitializeAccessibilityNodeInfo(r1, r2);
            if (this.a.b == false) goto L5;
            r2.addAction(1048576);
            r2.setDismissable(true);
            return;
        L5:
            r2.setDismissable(false);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [android.app.Dialog, com.bytedance.android.shopping.store.tabkit.container.TabKitToggleBottomSheetDialog] */
        public final boolean performAccessibilityAction(View r3, int r4, Bundle r5) {
            if (r4 != 1048576) goto L9;
            ?? r0 = this.a;
            if (r0.b == false) goto L9;
            r0.cancel();
            return true;
        L9:
            return super.performAccessibilityAction(r3, r4, r5);
        }
    }

    public class b extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ TabKitToggleBottomSheetDialog a;

        public final void onSlide(View r1, float r2) {
        }

        public b(TabKitToggleBottomSheetDialog r1) {
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
    }

    public static View L0(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCancelable(boolean r2) {
        super/*android.app.Dialog*/.setCancelable(r2);
        if (this.b == r2) goto L6;
        this.b = r2;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCanceledOnTouchOutside(boolean r3) {
        super/*android.app.Dialog*/.setCanceledOnTouchOutside(r3);
        if (r3 == true) goto L5;
    L7:
        this.c = r3;
        this.d = true;
        return;
    L5:
        if (this.b == true) goto L7;
        this.b = true;
        goto L7
    }

    public final void setContentView(View r3) {
        super.setContentView(wrapInBottomSheet(0, r3, null));
    }

    public final void setContentView(int r2) {
        super.setContentView(wrapInBottomSheet(r2, null, null));
    }

    public TabKitToggleBottomSheetDialog(Context r2, int r3) {
        super(r2, 2131952019);
        this.b = true;
        this.c = true;
        this.e = 0;
        new b(this);
        this.e = r3;
    }

    public final void setContentView(View r2, ViewGroup.LayoutParams r3) {
        super.setContentView(wrapInBottomSheet(0, r2, r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View wrapInBottomSheet(int r4, View r5, ViewGroup.LayoutParams r6) {
        int r7 = this.e;
        ViewGroup r8 = (ViewGroup) th.a.c(getContext(), r7, null, false);
        CoordinatorLayout r0 = r8.findViewById(2131367947);
        FrameLayout r1 = (FrameLayout) r0.findViewById(2131371216);
        if (r6 != null) goto L5;
        r1.addView(r5);
    L6:
        r0.findViewById(2131389274).setOnClickListener(new j(this));
        ViewCompat.setAccessibilityDelegate(r1, new a(this));
        r1.setOnTouchListener(new k());
        final Window r9 = getWindow();
        if (r9 == null) goto L13;
        WindowManager.LayoutParams r2 = r9.getAttributes();
        r2.width = -1;
        r2.height = -1;
        L0(r9).setPadding(0, 0, 0, 0);     // Catch: Exception -> L11
    L12:
        r9.setAttributes(r2);
    L11:
        r5.post(new l(r9));
    L13:
        return r8;
    L5:
        r1.addView(r5, r6);
        goto L6
    }
}
