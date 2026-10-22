package com.larus.uaigc.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusItemActionbarImageTemplateCoverHolderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f373164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f373165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f373166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f373167d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f373168e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f373164a;
    }

    public static LarusItemActionbarImageTemplateCoverHolderBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_item_actionbar_image_template_cover_holder, r101, false);
        FrameLayout r103 = (FrameLayout) r102;
        int r104 = R.id.image_template_cover;
        SimpleDraweeView r105 = (SimpleDraweeView) ViewBindings.findChildViewById(r102, R.id.image_template_cover);
        if (r105 == null) goto L15;
        r104 = R.id.image_template_cover_more_container;
        FrameLayout r106 = (FrameLayout) ViewBindings.findChildViewById(r102, R.id.image_template_cover_more_container);
        if (r106 == null) goto L15;
        r104 = R.id.image_template_cover_more_view;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r102, R.id.image_template_cover_more_view);
        if (r107 == null) goto L15;
        r104 = R.id.retry_icon;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r102, R.id.retry_icon)) == null) goto L15;
        r104 = R.id.template_cover_icon;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r102, R.id.template_cover_icon)) == null) goto L15;
        return new LarusItemActionbarImageTemplateCoverHolderBinding(r103, r103, r105, r106, r107);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r104)));
    }

    public LarusItemActionbarImageTemplateCoverHolderBinding(FrameLayout r100, FrameLayout r101, SimpleDraweeView r102, FrameLayout r103, TextView r104) {
        this.f373164a = r100;
        this.f373165b = r101;
        this.f373166c = r102;
        this.f373167d = r103;
        this.f373168e = r104;
    }
}
