package com.larus.common_res.common_ui.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusScreenWidgetMenuItemLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f326790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f326791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f326792c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f326790a;
    }

    public static LarusScreenWidgetMenuItemLayoutBinding a(View r100) {
        int r101 = R.id.menu_text;
        AppCompatTextView r102 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.menu_text);
        if (r102 == null) goto L11;
        r101 = R.id.menu_url_icon;
        SimpleDraweeView r103 = (SimpleDraweeView) ViewBindings.findChildViewById(r100, R.id.menu_url_icon);
        if (r103 == null) goto L11;
        r101 = R.id.widget_constraint_layout;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r100, R.id.widget_constraint_layout)) == null) goto L11;
        return new LarusScreenWidgetMenuItemLayoutBinding(r100, r102, r103);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public LarusScreenWidgetMenuItemLayoutBinding(View r100, AppCompatTextView r101, SimpleDraweeView r102) {
        this.f326790a = r100;
        this.f326791b = r101;
        this.f326792c = r102;
    }
}
