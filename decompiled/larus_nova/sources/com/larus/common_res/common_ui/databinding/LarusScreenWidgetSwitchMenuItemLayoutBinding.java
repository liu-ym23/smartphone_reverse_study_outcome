package com.larus.common_res.common_ui.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusScreenWidgetSwitchMenuItemLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f326793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SwitchCompat f326794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f326795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f326796d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f326793a;
    }

    public static LarusScreenWidgetSwitchMenuItemLayoutBinding a(View r100) {
        int r101 = R.id.menu_switch;
        SwitchCompat r102 = (SwitchCompat) ViewBindings.findChildViewById(r100, R.id.menu_switch);
        if (r102 == null) goto L11;
        r101 = R.id.menu_text;
        AppCompatTextView r103 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.menu_text);
        if (r103 == null) goto L11;
        r101 = R.id.menu_url_icon;
        SimpleDraweeView r104 = (SimpleDraweeView) ViewBindings.findChildViewById(r100, R.id.menu_url_icon);
        if (r104 == null) goto L11;
        return new LarusScreenWidgetSwitchMenuItemLayoutBinding((FrameLayout) r100, r102, r103, r104);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public LarusScreenWidgetSwitchMenuItemLayoutBinding(FrameLayout r100, SwitchCompat r101, AppCompatTextView r102, SimpleDraweeView r103) {
        this.f326793a = r100;
        this.f326794b = r101;
        this.f326795c = r102;
        this.f326796d = r103;
    }
}
