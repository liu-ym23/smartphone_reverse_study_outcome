package com.larus.common_res.common_ui.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusLayoutBottomSheetHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f326749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f326750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f326751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f326752d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f326749a;
    }

    public static LarusLayoutBottomSheetHeaderBinding a(View r100) {
        int r101 = R.id.bottom_sheet_close;
        AppCompatImageView r102 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.bottom_sheet_close);
        if (r102 == null) goto L11;
        r101 = R.id.bottom_sheet_handle;
        View r103 = ViewBindings.findChildViewById(r100, R.id.bottom_sheet_handle);
        if (r103 == null) goto L11;
        r101 = R.id.bottom_sheet_title;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r100, R.id.bottom_sheet_title);
        if (r104 == null) goto L11;
        return new LarusLayoutBottomSheetHeaderBinding((ConstraintLayout) r100, r102, r103, r104);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public LarusLayoutBottomSheetHeaderBinding(ConstraintLayout r100, AppCompatImageView r101, View r102, TextView r103) {
        this.f326749a = r100;
        this.f326750b = r101;
        this.f326751c = r102;
        this.f326752d = r103;
    }
}
