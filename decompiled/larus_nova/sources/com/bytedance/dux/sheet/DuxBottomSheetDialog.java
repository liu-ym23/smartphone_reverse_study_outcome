package com.bytedance.dux.sheet;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import em4.g;

/* JADX INFO: loaded from: classes15.dex */
public class DuxBottomSheetDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BottomSheetBehavior<FrameLayout> f205625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f205626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f205627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f205628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f205629e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f205630f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f205631g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f205632h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e f205633i;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DuxBottomSheetDialog f205634a;

        public a(DuxBottomSheetDialog r100) {
            this.f205634a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            DuxBottomSheetDialog r101 = this.f205634a;
            if (r101.f205629e == true) goto L5;
            return;
        L5:
            if (r101.isShowing() == false) goto L14;
            DuxBottomSheetDialog r102 = this.f205634a;
            if (r102.f205631g == true) goto L10;
            TypedArray r103 = r102.getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
            r102.f205630f = r103.getBoolean(0, true);
            r103.recycle();
            r102.f205631g = true;
        L10:
            if (r102.f205630f == false) goto L15;
            this.f205634a.cancel();
            return;
        L15:
            return;
        }
    }

    public class b extends View.AccessibilityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DuxBottomSheetDialog f205635a;

        public class a extends AccessibilityDelegateCompat {
            public a() {
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
                super.onInitializeAccessibilityNodeInfo(r100, r101);
                r101.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, "关闭面板"));
            }
        }

        public b(DuxBottomSheetDialog r100) {
            this.f205635a = r100;
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void onPopulateAccessibilityEvent(View r100, AccessibilityEvent r101) {
            super.onPopulateAccessibilityEvent(r100, r101);
            int r102 = Build.VERSION.SDK_INT;
            if (r102 < 24) goto L10;
            if (this.f205635a.f205629e == false) goto L7;
            int r103 = 1;
        L8:
            r100.setImportantForAccessibility(r103);
            goto L10
        L7:
            r103 = 2;
        L10:
            if (r102 < 28) goto L12;
            r100.setScreenReaderFocusable(this.f205635a.f205629e);
        L12:
            r100.setContentDescription("关闭");
            ViewCompat.setAccessibilityDelegate(r100, new a());
        }
    }

    public class c extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DuxBottomSheetDialog f205636a;

        public c(DuxBottomSheetDialog r100) {
            this.f205636a = r100;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            if (this.f205636a.f205629e == false) goto L5;
            r101.addAction(1048576);
            r101.setDismissable(true);
            return;
        L5:
            r101.setDismissable(false);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean performAccessibilityAction(View r100, int r101, Bundle r102) {
            if (r101 != 1048576) goto L9;
            DuxBottomSheetDialog r103 = this.f205636a;
            if (r103.f205629e == false) goto L9;
            r103.cancel();
            return true;
        L9:
            return super.performAccessibilityAction(r100, r101, r102);
        }
    }

    public class d implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            return true;
        }

        public d() {
        }
    }

    public class e extends BottomSheetBehavior.BottomSheetCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DuxBottomSheetDialog f205637a;

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onSlide(View r100, float r101) {
        }

        public e(DuxBottomSheetDialog r100) {
            this.f205637a = r100;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onStateChanged(View r100, int r101) {
            if (r101 != 5) goto L6;
            this.f205637a.cancel();
            return;
        }
    }

    public final void I0() {
        if (this.f205626b != null) goto L11;
        FrameLayout r100 = (FrameLayout) View.inflate(getContext(), com.larus.nova.R.layout.design_bottom_sheet_dialog, null);
        this.f205626b = r100;
        CoordinatorLayout r101 = (CoordinatorLayout) r100.findViewById(com.larus.nova.R.id.coordinator);
        FrameLayout r102 = (FrameLayout) this.f205626b.findViewById(com.larus.nova.R.id.design_bottom_sheet);
        this.f205627c = r102;
        if (Build.VERSION.SDK_INT < 28) goto L7;
        r102.setAccessibilityPaneTitle("");
    L7:
        BottomSheetBehavior<FrameLayout> r103 = BottomSheetBehavior.from(this.f205627c);
        this.f205625a = r103;
        r103.setBottomSheetCallback(this.f205633i);
        this.f205625a.setHideable(this.f205629e);
        if (this.f205632h == false) goto L12;
        this.f205625a.setPeekHeight((int) (g.d(getContext()) * 0.75f));
        return;
    L12:
        return;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        if (this.f205625a != null) goto L5;
        I0();
    L5:
        BottomSheetBehavior<FrameLayout> r100 = this.f205625a;
        if (this.f205628d == true) goto L8;
    L11:
        super.cancel();
        return;
    L8:
        if (r100.getState() == 5) goto L11;
        r100.setState(5);
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> r100 = this.f205625a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getState() != 5) goto L9;
        this.f205625a.setState(4);
        return;
    }

    public DuxBottomSheetDialog(Context r100) {
        super(r100, com.larus.nova.R.style.AppBottomSheetDialogTheme);
        this.f205629e = true;
        this.f205630f = true;
        this.f205632h = false;
        this.f205633i = new e(this);
        supportRequestWindowFeature(1);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Window r101 = getWindow();
        if (r101 == null) goto L9;
        int r102 = Build.VERSION.SDK_INT;
        r101.setStatusBarColor(0);
        r101.addFlags(Integer.MIN_VALUE);
        if (r102 >= 23) goto L7;
        r101.addFlags(67108864);
    L7:
        r101.setLayout(-1, -1);
        return;
    }

    @Override // android.app.Dialog
    public final void setCancelable(boolean r100) {
        super.setCancelable(r100);
        if (this.f205629e == r100) goto L8;
        this.f205629e = r100;
        BottomSheetBehavior<FrameLayout> r101 = this.f205625a;
        if (r101 == null) goto L9;
        r101.setHideable(r100);
        return;
    L9:
        return;
    }

    @Override // android.app.Dialog
    public final void setCanceledOnTouchOutside(boolean r100) {
        super.setCanceledOnTouchOutside(r100);
        if (r100 == true) goto L5;
    L7:
        this.f205630f = r100;
        this.f205631g = true;
        return;
    L5:
        if (this.f205629e == true) goto L7;
        this.f205629e = true;
        goto L7
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(View r100) {
        super.setContentView(wrapInBottomSheet(0, r100, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(int r100) {
        super.setContentView(wrapInBottomSheet(r100, null, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(View r100, ViewGroup.LayoutParams r101) {
        super.setContentView(wrapInBottomSheet(0, r100, r101));
    }

    public final View wrapInBottomSheet(int r100, View r101, ViewGroup.LayoutParams r102) {
        I0();
        CoordinatorLayout r103 = (CoordinatorLayout) this.f205626b.findViewById(com.larus.nova.R.id.coordinator);
        if (r100 == 0) goto L6;
        if (r101 != null) goto L6;
        r101 = getLayoutInflater().inflate(r100, r103, false);
    L6:
        this.f205627c.removeAllViews();
        if (this.f205632h == false) goto L10;
        if (r102 != null) goto L10;
        r102 = new FrameLayout.LayoutParams(-1, -1);
    L10:
        if (r102 != null) goto L12;
        this.f205627c.addView(r101);
    L13:
        r103.findViewById(com.larus.nova.R.id.touch_outside).setOnClickListener(new a(this));
        r103.findViewById(com.larus.nova.R.id.touch_outside).setAccessibilityDelegate(new b(this));
        ViewCompat.setAccessibilityDelegate(this.f205627c, new c(this));
        this.f205627c.setOnTouchListener(new d());
        return this.f205626b;
    L12:
        this.f205627c.addView(r101, r102);
        goto L13
    }
}
