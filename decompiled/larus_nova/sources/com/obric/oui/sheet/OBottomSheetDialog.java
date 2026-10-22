package com.obric.oui.sheet;

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

/* JADX INFO: loaded from: classes34.dex */
public class OBottomSheetDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BottomSheetBehavior<FrameLayout> f402820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f402821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f402822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f402823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f402824e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f402825f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f402826g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f402827h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e f402828i;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OBottomSheetDialog f402829a;

        public a(OBottomSheetDialog r100) {
            this.f402829a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            OBottomSheetDialog r101 = this.f402829a;
            if (r101.f402824e == true) goto L5;
            return;
        L5:
            if (r101.isShowing() == false) goto L14;
            OBottomSheetDialog r102 = this.f402829a;
            if (r102.f402826g == true) goto L10;
            TypedArray r103 = r102.getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
            r102.f402825f = r103.getBoolean(0, true);
            r103.recycle();
            r102.f402826g = true;
        L10:
            if (r102.f402825f == false) goto L15;
            this.f402829a.cancel();
            return;
        L15:
            return;
        }
    }

    public class b extends View.AccessibilityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OBottomSheetDialog f402830a;

        public class a extends AccessibilityDelegateCompat {
            public a() {
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
                super.onInitializeAccessibilityNodeInfo(r100, r101);
                r101.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, "关闭面板"));
            }
        }

        public b(OBottomSheetDialog r100) {
            this.f402830a = r100;
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void onPopulateAccessibilityEvent(View r100, AccessibilityEvent r101) {
            super.onPopulateAccessibilityEvent(r100, r101);
            int r102 = Build.VERSION.SDK_INT;
            if (r102 < 24) goto L10;
            if (this.f402830a.f402824e == false) goto L7;
            int r103 = 1;
        L8:
            r100.setImportantForAccessibility(r103);
            goto L10
        L7:
            r103 = 2;
        L10:
            if (r102 < 28) goto L12;
            r100.setScreenReaderFocusable(this.f402830a.f402824e);
        L12:
            r100.setContentDescription("关闭");
            ViewCompat.setAccessibilityDelegate(r100, new a());
        }
    }

    public class c extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OBottomSheetDialog f402831a;

        public c(OBottomSheetDialog r100) {
            this.f402831a = r100;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            if (this.f402831a.f402824e == false) goto L5;
            r101.addAction(1048576);
            r101.setDismissable(true);
            return;
        L5:
            r101.setDismissable(false);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean performAccessibilityAction(View r100, int r101, Bundle r102) {
            if (r101 != 1048576) goto L9;
            OBottomSheetDialog r103 = this.f402831a;
            if (r103.f402824e == false) goto L9;
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
        public final /* synthetic */ OBottomSheetDialog f402832a;

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onSlide(View r100, float r101) {
        }

        public e(OBottomSheetDialog r100) {
            this.f402832a = r100;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onStateChanged(View r100, int r101) {
            if (r101 != 5) goto L6;
            this.f402832a.cancel();
            return;
        }
    }

    public final void I0() {
        if (this.f402821b != null) goto L11;
        FrameLayout r100 = (FrameLayout) View.inflate(getContext(), com.larus.nova.R.layout.design_bottom_sheet_dialog, null);
        this.f402821b = r100;
        CoordinatorLayout r101 = (CoordinatorLayout) r100.findViewById(com.larus.nova.R.id.coordinator);
        FrameLayout r102 = (FrameLayout) this.f402821b.findViewById(com.larus.nova.R.id.design_bottom_sheet);
        this.f402822c = r102;
        if (Build.VERSION.SDK_INT < 28) goto L7;
        r102.setAccessibilityPaneTitle("");
    L7:
        BottomSheetBehavior<FrameLayout> r103 = BottomSheetBehavior.from(this.f402822c);
        this.f402820a = r103;
        r103.setBottomSheetCallback(this.f402828i);
        this.f402820a.setHideable(this.f402824e);
        if (this.f402827h == false) goto L12;
        this.f402820a.setPeekHeight((int) (pla.d.i(getContext()) * 0.75f));
        return;
    L12:
        return;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        if (this.f402820a != null) goto L5;
        I0();
    L5:
        BottomSheetBehavior<FrameLayout> r100 = this.f402820a;
        if (this.f402823d == true) goto L8;
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
        BottomSheetBehavior<FrameLayout> r100 = this.f402820a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getState() != 5) goto L9;
        this.f402820a.setState(4);
        return;
    }

    public OBottomSheetDialog(Context r100) {
        super(r100, com.larus.nova.R.style.AppBottomSheetDialogTheme);
        this.f402824e = true;
        this.f402825f = true;
        this.f402827h = false;
        this.f402828i = new e(this);
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
        if (this.f402824e == r100) goto L8;
        this.f402824e = r100;
        BottomSheetBehavior<FrameLayout> r101 = this.f402820a;
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
        this.f402825f = r100;
        this.f402826g = true;
        return;
    L5:
        if (this.f402824e == true) goto L7;
        this.f402824e = true;
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
        CoordinatorLayout r103 = (CoordinatorLayout) this.f402821b.findViewById(com.larus.nova.R.id.coordinator);
        if (r100 == 0) goto L6;
        if (r101 != null) goto L6;
        r101 = getLayoutInflater().inflate(r100, r103, false);
    L6:
        this.f402822c.removeAllViews();
        if (this.f402827h == false) goto L10;
        if (r102 != null) goto L10;
        r102 = new FrameLayout.LayoutParams(-1, -1);
    L10:
        if (r102 != null) goto L12;
        this.f402822c.addView(r101);
    L13:
        r103.findViewById(com.larus.nova.R.id.touch_outside).setOnClickListener(new a(this));
        r103.findViewById(com.larus.nova.R.id.touch_outside).setAccessibilityDelegate(new b(this));
        ViewCompat.setAccessibilityDelegate(this.f402822c, new c(this));
        this.f402822c.setOnTouchListener(new d());
        return this.f402821b;
    L12:
        this.f402822c.addView(r101, r102);
        goto L13
    }
}
