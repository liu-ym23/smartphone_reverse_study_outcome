package com.larus.flowskill.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusItemTaskProjectBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f343566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f343567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f343568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f343569d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f343570e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f343571f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AppCompatImageView f343572g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f343566a;
    }

    public static LarusItemTaskProjectBinding a(View r110) {
        int r100 = R.id.item_content;
        ConstraintLayout r101 = (ConstraintLayout) ViewBindings.findChildViewById(r110, R.id.item_content);
        if (r101 == null) goto L17;
        r100 = R.id.item_divider;
        View r102 = ViewBindings.findChildViewById(r110, R.id.item_divider);
        if (r102 == null) goto L17;
        r100 = R.id.item_pc_icon;
        AppCompatImageView r103 = (AppCompatImageView) ViewBindings.findChildViewById(r110, R.id.item_pc_icon);
        if (r103 == null) goto L17;
        r100 = R.id.item_project_icon;
        AppCompatImageView r104 = (AppCompatImageView) ViewBindings.findChildViewById(r110, R.id.item_project_icon);
        if (r104 == null) goto L17;
        r100 = R.id.item_project_name;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r110, R.id.item_project_name);
        if (r105 == null) goto L17;
        r100 = R.id.item_selected_icon;
        AppCompatImageView r106 = (AppCompatImageView) ViewBindings.findChildViewById(r110, R.id.item_selected_icon);
        if (r106 == null) goto L17;
        return new LarusItemTaskProjectBinding((ConstraintLayout) r110, r101, r102, r103, r104, r105, r106);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r110.getResources().getResourceName(r100)));
    }

    public LarusItemTaskProjectBinding(ConstraintLayout r100, ConstraintLayout r101, View r102, AppCompatImageView r103, AppCompatImageView r104, TextView r105, AppCompatImageView r106) {
        this.f343566a = r100;
        this.f343567b = r101;
        this.f343568c = r102;
        this.f343569d = r103;
        this.f343570e = r104;
        this.f343571f = r105;
        this.f343572g = r106;
    }
}
