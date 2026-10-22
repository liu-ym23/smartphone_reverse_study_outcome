package com.google.android.material.bottomsheet;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes23.dex */
public class BottomSheetDialog extends AppCompatDialog {
    private BottomSheetBehavior<FrameLayout> behavior;
    private BottomSheetBehavior.BottomSheetCallback bottomSheetCallback;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;

    @Override // android.app.Dialog
    public void onStart() {
        com_google_android_material_bottomsheet_BottomSheetDialog_com_obric_assistant_interaction_impl_window_helpers_BottomSheetDialogLancet_onStart(this);
    }

    public boolean shouldWindowCloseOnTouchOutside() {
        if (this.canceledOnTouchOutsideSet == true) goto L6;
        TypedArray r100 = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
        this.canceledOnTouchOutside = r100.getBoolean(0, true);
        r100.recycle();
        this.canceledOnTouchOutsideSet = true;
    L6:
        return this.canceledOnTouchOutside;
    }

    public void com_google_android_material_bottomsheet_BottomSheetDialog__onStart$___twin___() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> r100 = this.behavior;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getState() != 5) goto L9;
        this.behavior.setState(4);
        return;
    }

    public BottomSheetDialog(Context r100) {
        this(r100, 0);
    }

    public static void com_google_android_material_bottomsheet_BottomSheetDialog_com_obric_assistant_interaction_impl_window_helpers_BottomSheetDialogLancet_onStart(BottomSheetDialog r100) {
        r100.com_google_android_material_bottomsheet_BottomSheetDialog__onStart$___twin___();
        DialogLancet.handleDialogPreAddViewOnStart(r100, "bottomSheetDialog:onStart");
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        Window r101 = getWindow();
        if (r101 == null) goto L6;
        r101.clearFlags(67108864);
        r101.addFlags(Integer.MIN_VALUE);
        r101.setLayout(-1, -1);
        return;
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean r100) {
        super.setCancelable(r100);
        if (this.cancelable == r100) goto L8;
        this.cancelable = r100;
        BottomSheetBehavior<FrameLayout> r101 = this.behavior;
        if (r101 == null) goto L9;
        r101.setHideable(r100);
        return;
    L9:
        return;
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean r100) {
        super.setCanceledOnTouchOutside(r100);
        if (r100 == true) goto L5;
    L7:
        this.canceledOnTouchOutside = r100;
        this.canceledOnTouchOutsideSet = true;
        return;
    L5:
        if (this.cancelable == true) goto L7;
        this.cancelable = true;
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
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new AnonymousClass4(this);
        supportRequestWindowFeature(1);
    }

    private static int getThemeResId(Context r100, int r101) {
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

    public BottomSheetDialog(Context r100, boolean r101, DialogInterface.OnCancelListener r102) {
        super(r100, r101, r102);
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new AnonymousClass4(this);
        supportRequestWindowFeature(1);
        this.cancelable = r101;
    }

    private View wrapInBottomSheet(int r100, View r101, ViewGroup.LayoutParams r102) {
        FrameLayout r103 = (FrameLayout) View.inflate(getContext(), com.larus.nova.R.layout.design_bottom_sheet_dialog, null);
        CoordinatorLayout r104 = (CoordinatorLayout) r103.findViewById(com.larus.nova.R.id.coordinator);
        if (r100 == 0) goto L6;
        if (r101 != null) goto L6;
        r101 = getLayoutInflater().inflate(r100, r104, false);
    L6:
        FrameLayout r105 = (FrameLayout) r104.findViewById(com.larus.nova.R.id.design_bottom_sheet);
        BottomSheetBehavior<FrameLayout> r106 = BottomSheetBehavior.from(r105);
        this.behavior = r106;
        r106.setBottomSheetCallback(this.bottomSheetCallback);
        this.behavior.setHideable(this.cancelable);
        if (r102 != null) goto L9;
        r105.addView(r101);
    L10:
        r104.findViewById(com.larus.nova.R.id.touch_outside).setOnClickListener(new AnonymousClass1(this));
        ViewCompat.setAccessibilityDelegate(r105, new AnonymousClass2(this));
        r105.setOnTouchListener(new AnonymousClass3(this));
        return r103;
    L9:
        r105.addView(r101, r102);
        goto L10
    }
}
