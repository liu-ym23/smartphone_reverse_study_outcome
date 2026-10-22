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
public final class LarusLayoutActionBarEditorWidgetButtonRouterBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f351561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f351562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f351563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f351564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f351565e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f351561a;
    }

    public static LarusLayoutActionBarEditorWidgetButtonRouterBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_layout_action_bar_editor_widget_button_router, r101, false);
        r101.addView(r102);
        int r103 = R.id.icon_arrow;
        AppCompatImageView r104 = (AppCompatImageView) ViewBindings.findChildViewById(r102, R.id.icon_arrow);
        if (r104 == null) goto L11;
        ConstraintLayout r105 = (ConstraintLayout) r102;
        r103 = R.id.tv_button_router_name;
        AppCompatTextView r106 = (AppCompatTextView) ViewBindings.findChildViewById(r102, R.id.tv_button_router_name);
        if (r106 == null) goto L11;
        r103 = R.id.tv_button_router_option;
        AppCompatTextView r107 = (AppCompatTextView) ViewBindings.findChildViewById(r102, R.id.tv_button_router_option);
        if (r107 == null) goto L11;
        return new LarusLayoutActionBarEditorWidgetButtonRouterBinding(r105, r104, r105, r106, r107);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    public LarusLayoutActionBarEditorWidgetButtonRouterBinding(ConstraintLayout r100, AppCompatImageView r101, ConstraintLayout r102, AppCompatTextView r103, AppCompatTextView r104) {
        this.f351561a = r100;
        this.f351562b = r101;
        this.f351563c = r102;
        this.f351564d = r103;
        this.f351565e = r104;
    }
}
