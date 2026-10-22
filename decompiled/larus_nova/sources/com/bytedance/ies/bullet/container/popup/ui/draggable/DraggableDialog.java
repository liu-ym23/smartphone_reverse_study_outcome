package com.bytedance.ies.bullet.container.popup.ui.draggable;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.ies.bullet.service.popup.ui.AbsPopupDialog;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes19.dex */
public class DraggableDialog extends AbsPopupDialog {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BottomSheetBehavior<FrameLayout> f246388g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f246389h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f246390i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f246391j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f246392k;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DraggableDialog f246393a;

        public a(DraggableDialog r100) {
            this.f246393a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            DraggableDialog r101 = this.f246393a;
            if (r101.f246389h == true) goto L5;
            return;
        L5:
            if (r101.isShowing() == false) goto L14;
            DraggableDialog r102 = this.f246393a;
            if (r102.f246391j == true) goto L10;
            TypedArray r103 = r102.getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
            r102.f246390i = r103.getBoolean(0, true);
            r103.recycle();
            r102.f246391j = true;
        L10:
            if (r102.f246390i == false) goto L15;
            this.f246393a.cancel();
            return;
        L15:
            return;
        }
    }

    public class b extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DraggableDialog f246394a;

        public b(DraggableDialog r100) {
            this.f246394a = r100;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            if (this.f246394a.f246389h == false) goto L5;
            r101.addAction(1048576);
            r101.setDismissable(true);
            return;
        L5:
            r101.setDismissable(false);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean performAccessibilityAction(View r100, int r101, Bundle r102) {
            if (r101 != 1048576) goto L9;
            DraggableDialog r103 = this.f246394a;
            if (r103.f246389h == false) goto L9;
            r103.cancel();
            return true;
        L9:
            return super.performAccessibilityAction(r100, r101, r102);
        }
    }

    public class c implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            return true;
        }

        public c() {
        }
    }

    public class d extends BottomSheetBehavior.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DraggableDialog f246395a;

        @Override // com.bytedance.ies.bullet.container.popup.ui.draggable.BottomSheetBehavior.b
        public final void c(View r100) {
        }

        public d(DraggableDialog r100) {
            this.f246395a = r100;
        }

        @Override // com.bytedance.ies.bullet.container.popup.ui.draggable.BottomSheetBehavior.b
        public final void d(View r100, int r101) {
            if (r101 != 5) goto L6;
            this.f246395a.cancel();
            return;
        }
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> r100 = this.f246388g;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.A != 5) goto L9;
        r100.setState(4);
        return;
    }

    public DraggableDialog(Context r100) {
        super(r100, com.larus.nova.R.style.Dialog_Immersive_NoAnim);
        this.f246389h = true;
        this.f246390i = true;
        this.f246392k = new d(this);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Boolean r101 = Boolean.FALSE;
        Function0<Boolean> r102 = this.f247982b;
        if (r102 == null) goto L5;
        r101 = r102.invoke();
    L5:
        setCanceledOnTouchOutside(r101.booleanValue());
        if (this.f247981a == false) goto L13;
        FrameLayout r103 = (FrameLayout) findViewById(com.larus.nova.R.id.bullet_popup_bottom_sheet);
        if (r103 == null) goto L13;
        int[] r104 = {(int) r103.getX(), (int) r103.getY()};
        r103.getLocationInWindow(r104);
        int r105 = r104[0];
        if (new Rect(r105, r104[1], r103.getWidth() + r105, r104[1] + r103.getHeight()).contains((int) r100.getRawX(), (int) r100.getRawY()) == true) goto L13;
        getOwnerActivity().dispatchTouchEvent(r100);
    L13:
        return super.dispatchTouchEvent(r100);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Window r101 = getWindow();
        if (r101 == null) goto L6;
        r101.clearFlags(67108864);
        r101.addFlags(Integer.MIN_VALUE);
        r101.setLayout(-1, -1);
        return;
    }

    @Override // android.app.Dialog
    public final void setCancelable(boolean r100) {
        super.setCancelable(r100);
        if (this.f246389h == r100) goto L8;
        this.f246389h = r100;
        BottomSheetBehavior<FrameLayout> r101 = this.f246388g;
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
        this.f246390i = r100;
        this.f246391j = true;
        return;
    L5:
        if (this.f246389h == true) goto L7;
        this.f246389h = true;
        goto L7
    }

    @Override // com.bytedance.ies.bullet.service.popup.ui.AbsPopupDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(View r100) {
        super.setContentView(wrapInBottomSheet(0, r100, null));
    }

    @Override // com.bytedance.ies.bullet.service.popup.ui.AbsPopupDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(int r100) {
        super.setContentView(wrapInBottomSheet(r100, null, null));
    }

    @Override // com.bytedance.ies.bullet.service.popup.ui.AbsPopupDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(View r100, ViewGroup.LayoutParams r101) {
        super.setContentView(wrapInBottomSheet(0, r100, r101));
    }

    public final View wrapInBottomSheet(int r100, View r101, ViewGroup.LayoutParams r102) {
        FrameLayout r103 = (FrameLayout) View.inflate(getContext(), com.larus.nova.R.layout.bullet_popup_dialog_bottom_sheet, null);
        CoordinatorLayout r104 = (CoordinatorLayout) r103.findViewById(com.larus.nova.R.id.bullet_popup_bottom_sheet_coordinator);
        if (r100 == 0) goto L6;
        if (r101 != null) goto L6;
        r101 = getLayoutInflater().inflate(r100, r104, false);
    L6:
        FrameLayout r105 = (FrameLayout) r104.findViewById(com.larus.nova.R.id.bullet_popup_bottom_sheet);
        BottomSheetBehavior<FrameLayout> r106 = BottomSheetBehavior.b(r105);
        this.f246388g = r106;
        r106.a(this.f246392k);
        this.f246388g.setHideable(this.f246389h);
        if (r102 != null) goto L9;
        r105.addView(r101);
    L10:
        r104.findViewById(com.larus.nova.R.id.bullet_popup_bottom_sheet_touch_outside).setOnClickListener(new a(this));
        ViewCompat.setAccessibilityDelegate(r105, new b(this));
        r105.setOnTouchListener(new c());
        return r103;
    L9:
        r105.addView(r101, r102);
        goto L10
    }
}
