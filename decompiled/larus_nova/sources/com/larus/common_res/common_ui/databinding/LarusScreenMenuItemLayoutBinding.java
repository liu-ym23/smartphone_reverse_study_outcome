package com.larus.common_res.common_ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusScreenMenuItemLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f326772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f326773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f326774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f326775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LottieAdapterView f326776e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f326777f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SimpleDraweeView f326778g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SimpleDraweeView f326779h;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f326772a;
    }

    public static LarusScreenMenuItemLayoutBinding a(LayoutInflater r100, ViewGroup r110) {
        r100.inflate(R.layout.larus_screen_menu_item_layout, r110);
        int r101 = R.id.holder;
        View r102 = ViewBindings.findChildViewById(r110, R.id.holder);
        if (r102 == null) goto L19;
        r101 = R.id.menu_icon;
        AppCompatImageView r103 = (AppCompatImageView) ViewBindings.findChildViewById(r110, R.id.menu_icon);
        if (r103 == null) goto L19;
        r101 = R.id.menu_icon_container;
        FrameLayout r104 = (FrameLayout) ViewBindings.findChildViewById(r110, R.id.menu_icon_container);
        if (r104 == null) goto L19;
        r101 = R.id.menu_lottie_icon;
        LottieAdapterView r105 = (LottieAdapterView) ViewBindings.findChildViewById(r110, R.id.menu_lottie_icon);
        if (r105 == null) goto L19;
        r101 = R.id.menu_text;
        AppCompatTextView r106 = (AppCompatTextView) ViewBindings.findChildViewById(r110, R.id.menu_text);
        if (r106 == null) goto L19;
        r101 = R.id.menu_url_icon;
        SimpleDraweeView r107 = (SimpleDraweeView) ViewBindings.findChildViewById(r110, R.id.menu_url_icon);
        if (r107 == null) goto L19;
        r101 = R.id.text_icon;
        SimpleDraweeView r108 = (SimpleDraweeView) ViewBindings.findChildViewById(r110, R.id.text_icon);
        if (r108 == null) goto L19;
        return new LarusScreenMenuItemLayoutBinding(r110, r102, r103, r104, r105, r106, r107, r108);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r110.getResources().getResourceName(r101)));
    }

    public LarusScreenMenuItemLayoutBinding(View r100, View r101, AppCompatImageView r102, FrameLayout r103, LottieAdapterView r104, AppCompatTextView r105, SimpleDraweeView r106, SimpleDraweeView r107) {
        this.f326772a = r100;
        this.f326773b = r101;
        this.f326774c = r102;
        this.f326775d = r103;
        this.f326776e = r104;
        this.f326777f = r105;
        this.f326778g = r106;
        this.f326779h = r107;
    }
}
