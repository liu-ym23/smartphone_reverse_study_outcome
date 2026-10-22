package com.obric.oui.panel;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public class BottomSheetDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BottomSheetBehavior<FrameLayout> f402036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f402037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f402038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f402039d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f402040e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f402041f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f402042g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<BottomSheetBehavior.d> f402043h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e f402044i;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomSheetDialog f402045a;

        public a(BottomSheetDialog r100) {
            this.f402045a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            BottomSheetDialog r101 = this.f402045a;
            if (r101.f402039d == true) goto L5;
            return;
        L5:
            if (r101.isShowing() == false) goto L14;
            BottomSheetDialog r102 = this.f402045a;
            if (r102.f402041f == true) goto L10;
            TypedArray r103 = r102.getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
            r102.f402040e = r103.getBoolean(0, true);
            r103.recycle();
            r102.f402041f = true;
        L10:
            if (r102.f402040e == false) goto L15;
            this.f402045a.cancel();
            return;
        L15:
            return;
        }
    }

    public class b extends View.AccessibilityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomSheetDialog f402046a;

        public class a extends AccessibilityDelegateCompat {
            public a() {
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
                super.onInitializeAccessibilityNodeInfo(r100, r101);
                r101.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, "关闭面板"));
            }
        }

        public b(BottomSheetDialog r100) {
            this.f402046a = r100;
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void onPopulateAccessibilityEvent(View r100, AccessibilityEvent r101) {
            super.onPopulateAccessibilityEvent(r100, r101);
            int r102 = Build.VERSION.SDK_INT;
            if (r102 < 24) goto L10;
            if (this.f402046a.f402039d == false) goto L7;
            int r103 = 1;
        L8:
            r100.setImportantForAccessibility(r103);
            goto L10
        L7:
            r103 = 2;
        L10:
            if (r102 < 28) goto L12;
            r100.setScreenReaderFocusable(this.f402046a.f402039d);
        L12:
            r100.setContentDescription("关闭");
            ViewCompat.setAccessibilityDelegate(r100, new a());
        }
    }

    public class c extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomSheetDialog f402047a;

        public c(BottomSheetDialog r100) {
            this.f402047a = r100;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            if (this.f402047a.f402039d == false) goto L5;
            r101.addAction(1048576);
            r101.setDismissable(true);
            return;
        L5:
            r101.setDismissable(false);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean performAccessibilityAction(View r100, int r101, Bundle r102) {
            if (r101 != 1048576) goto L9;
            BottomSheetDialog r103 = this.f402047a;
            if (r103.f402039d == false) goto L9;
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

    public class e extends BottomSheetBehavior.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomSheetDialog f402048a;

        public e(OBasePanelDialog r100) {
            this.f402048a = r100;
        }

        @Override // com.obric.oui.panel.BottomSheetBehavior.d
        public final void a(View r100, float r101) {
            Iterator r102 = ((ArrayList) this.f402048a.f402043h).iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            ((BottomSheetBehavior.d) r102.next()).a(r100, r101);
            goto L4
        }

        @Override // com.obric.oui.panel.BottomSheetBehavior.d
        public final void b(View r100, int r101) {
            Iterator r102 = ((ArrayList) this.f402048a.f402043h).iterator();
        L4:
            if (r102.hasNext() == false) goto L7;
            ((BottomSheetBehavior.d) r102.next()).b(r100, r101);
            goto L4
        L7:
            if (r101 != 5) goto L11;
            this.f402048a.cancel();
            return;
        }
    }

    public final void I0() {
        if (this.f402037b != null) goto L19;
        FrameLayout r100 = (FrameLayout) View.inflate(getContext(), com.larus.nova.R.layout.o_bottom_sheet_dialog, null);
        this.f402037b = r100;
        CoordinatorLayout r101 = (CoordinatorLayout) r100.findViewById(com.larus.nova.R.id.coordinator);
        FrameLayout r102 = (FrameLayout) this.f402037b.findViewById(com.larus.nova.R.id.design_bottom_sheet);
        this.f402038c = r102;
        if (Build.VERSION.SDK_INT < 28) goto L7;
        r102.setAccessibilityPaneTitle("");
    L7:
        ViewGroup.LayoutParams r103 = this.f402038c.getLayoutParams();
        if ((r103 instanceof CoordinatorLayout.LayoutParams) == false) goto L18;
        CoordinatorLayout.Behavior r104 = ((CoordinatorLayout.LayoutParams) r103).getBehavior();
        if ((r104 instanceof BottomSheetBehavior) == false) goto L16;
        BottomSheetBehavior<FrameLayout> r105 = (BottomSheetBehavior) r104;
        this.f402036a = r105;
        e r106 = this.f402044i;
        r105.f402022y.clear();
        if (r106 == null) goto L14;
        r105.f402022y.add(r106);
    L14:
        BottomSheetBehavior<FrameLayout> r107 = this.f402036a;
        r107.f402009l = this.f402039d;
        return;
    L16:
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    L18:
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    public final BottomSheetBehavior<FrameLayout> J0() {
        if (this.f402036a != null) goto L6;
        I0();
    L6:
        return this.f402036a;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        J0();
        super.cancel();
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> r100 = this.f402036a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f402012o == 5) goto L7;
        return;
    L7:
        if (this.f402042g == false) goto L9;
        r100.setState(4);
        return;
    L9:
        r100.setState(3);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle r100) {
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
        if (this.f402039d == r100) goto L8;
        this.f402039d = r100;
        BottomSheetBehavior<FrameLayout> r101 = this.f402036a;
        if (r101 == null) goto L9;
        r101.f402009l = r100;
        return;
    L9:
        return;
    }

    @Override // android.app.Dialog
    public final void setCanceledOnTouchOutside(boolean r100) {
        super.setCanceledOnTouchOutside(r100);
        if (r100 == true) goto L5;
    L7:
        this.f402040e = r100;
        this.f402041f = true;
        return;
    L5:
        if (this.f402039d == true) goto L7;
        this.f402039d = true;
        goto L7
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View r100) {
        super.setContentView(wrapInBottomSheet(0, r100, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(int r100) {
        super.setContentView(wrapInBottomSheet(r100, null, null));
    }

    public BottomSheetDialog(Context r100, int r101) {
        super(r100, getThemeResId(r100, r101));
        this.f402039d = true;
        this.f402040e = true;
        this.f402042g = false;
        this.f402043h = new ArrayList();
        this.f402044i = new e((OBasePanelDialog) this);
        supportRequestWindowFeature(1);
    }

    public static int getThemeResId(Context r100, int r101) {
        if (r101 != 0) goto L8;
        TypedValue r102 = new TypedValue();
        if (r100.getTheme().resolveAttribute(com.larus.nova.R.attr.bottomSheetDialogTheme, r102, true) == true) goto L9;
        return com.larus.nova.R.style.Theme_Design_Light_BottomSheetDialog;
    L9:
        return r102.resourceId;
    L8:
        return r101;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View r100, ViewGroup.LayoutParams r101) {
        super.setContentView(wrapInBottomSheet(0, r100, r101));
    }

    public final View wrapInBottomSheet(int r100, View r101, ViewGroup.LayoutParams r102) {
        I0();
        CoordinatorLayout r103 = (CoordinatorLayout) this.f402037b.findViewById(com.larus.nova.R.id.coordinator);
        if (r100 == 0) goto L6;
        if (r101 != null) goto L6;
        r101 = getLayoutInflater().inflate(r100, r103, false);
    L6:
        this.f402038c.removeAllViews();
        if (this.f402042g == false) goto L10;
        if (r102 != null) goto L10;
        r102 = new FrameLayout.LayoutParams(-1, -1);
    L10:
        if (r102 != null) goto L12;
        this.f402038c.addView(r101);
    L13:
        r103.findViewById(com.larus.nova.R.id.touch_outside).setOnClickListener(new a(this));
        r103.findViewById(com.larus.nova.R.id.touch_outside).setAccessibilityDelegate(new b(this));
        ViewCompat.setAccessibilityDelegate(this.f402038c, new c(this));
        this.f402038c.setOnTouchListener(new d());
        return this.f402037b;
    L12:
        this.f402038c.addView(r101, r102);
        goto L13
    }
}
