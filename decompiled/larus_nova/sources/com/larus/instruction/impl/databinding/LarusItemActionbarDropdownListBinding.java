package com.larus.instruction.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusItemActionbarDropdownListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f351547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f351548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f351549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f351550d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f351547a;
    }

    public static LarusItemActionbarDropdownListBinding a(View r100) {
        int r101 = R.id.icon_arrow;
        AppCompatImageView r102 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.icon_arrow);
        if (r102 == null) goto L11;
        r101 = R.id.tv_drop_down_label;
        AppCompatTextView r103 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.tv_drop_down_label);
        if (r103 == null) goto L11;
        r101 = R.id.tv_selected_option;
        AppCompatTextView r104 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.tv_selected_option);
        if (r104 == null) goto L11;
        return new LarusItemActionbarDropdownListBinding((ConstraintLayout) r100, r102, r103, r104);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public static LarusItemActionbarDropdownListBinding b(LayoutInflater r100, ViewGroup r101, boolean r102) {
        View r103 = r100.inflate(R.layout.larus_item_actionbar_dropdown_list, r101, false);
        if (r102 == false) goto L6;
        r101.addView(r103);
    L6:
        return a(r103);
    }

    public LarusItemActionbarDropdownListBinding(ConstraintLayout r100, AppCompatImageView r101, AppCompatTextView r102, AppCompatTextView r103) {
        this.f351547a = r100;
        this.f351548b = r101;
        this.f351549c = r102;
        this.f351550d = r103;
    }
}
