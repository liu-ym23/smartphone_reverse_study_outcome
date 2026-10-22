package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larksuite.framework.ui.PriorityLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes37.dex */
public final class ViewShrinkUserDutyBinding implements ViewBinding {
    public final AppCompatImageView ivDivider;
    private final PriorityLayout rootView;
    public final TextView tvDuty;
    public final TextView tvSection;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public PriorityLayout getRoot() {
        return this.rootView;
    }

    public static ViewShrinkUserDutyBinding bind(View r100) {
        int r101 = R.id.iv_divider;
        AppCompatImageView r102 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.iv_divider);
        if (r102 == null) goto L11;
        r101 = R.id.tv_duty;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r100, R.id.tv_duty);
        if (r103 == null) goto L11;
        r101 = R.id.tv_section;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r100, R.id.tv_section);
        if (r104 == null) goto L11;
        return new ViewShrinkUserDutyBinding((PriorityLayout) r100, r102, r103, r104);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public static ViewShrinkUserDutyBinding inflate(LayoutInflater r100) {
        return inflate(r100, null, false);
    }

    public static ViewShrinkUserDutyBinding inflate(LayoutInflater r100, ViewGroup r101, boolean r102) {
        View r103 = r100.inflate(R.layout.view_shrink_user_duty, r101, false);
        if (r102 == false) goto L6;
        r101.addView(r103);
    L6:
        return bind(r103);
    }

    private ViewShrinkUserDutyBinding(PriorityLayout r100, AppCompatImageView r101, TextView r102, TextView r103) {
        this.rootView = r100;
        this.ivDivider = r101;
        this.tvDuty = r102;
        this.tvSection = r103;
    }
}
