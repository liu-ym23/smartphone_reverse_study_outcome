package com.larus.uaigc.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f373193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f373194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f373195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f373196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f373197e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f373198f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f373193a;
    }

    public static LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding a(LayoutInflater r100, ViewGroup r101) {
        if (r101 == null) goto L22;
        r100.inflate(R.layout.larus_layout_action_bar_editor_widget_drop_feature_selector, r101);
        int r102 = R.id.bottom_divider;
        View r103 = ViewBindings.findChildViewById(r101, R.id.bottom_divider);
        if (r103 == null) goto L20;
        r102 = R.id.drop_down_selector;
        if (((RecyclerView) ViewBindings.findChildViewById(r101, R.id.drop_down_selector)) == null) goto L20;
        r102 = R.id.drop_feature_selector_btn;
        ConstraintLayout r104 = (ConstraintLayout) ViewBindings.findChildViewById(r101, R.id.drop_feature_selector_btn);
        if (r104 == null) goto L20;
        r102 = R.id.drop_feature_selector_sub_title;
        AppCompatTextView r105 = (AppCompatTextView) ViewBindings.findChildViewById(r101, R.id.drop_feature_selector_sub_title);
        if (r105 == null) goto L20;
        r102 = R.id.icon_arrow;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r101, R.id.icon_arrow)) == null) goto L20;
        r102 = R.id.tv_drop_down_label;
        AppCompatTextView r106 = (AppCompatTextView) ViewBindings.findChildViewById(r101, R.id.tv_drop_down_label);
        if (r106 == null) goto L20;
        r102 = R.id.tv_selected_option;
        AppCompatTextView r107 = (AppCompatTextView) ViewBindings.findChildViewById(r101, R.id.tv_selected_option);
        if (r107 == null) goto L20;
        return new LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding(r101, r103, r104, r105, r106, r107);
    L20:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    L22:
        throw new NullPointerException("parent");
    }

    public LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding(View r100, View r101, ConstraintLayout r102, AppCompatTextView r103, AppCompatTextView r104, AppCompatTextView r105) {
        this.f373193a = r100;
        this.f373194b = r101;
        this.f373195c = r102;
        this.f373196d = r103;
        this.f373197e = r104;
        this.f373198f = r105;
    }
}
