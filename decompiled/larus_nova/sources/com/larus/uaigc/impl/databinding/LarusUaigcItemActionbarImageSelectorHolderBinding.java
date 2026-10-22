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
public final class LarusUaigcItemActionbarImageSelectorHolderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f373259a;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f373259a;
    }

    public LarusUaigcItemActionbarImageSelectorHolderBinding(FrameLayout r100) {
        this.f373259a = r100;
    }

    public static LarusUaigcItemActionbarImageSelectorHolderBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_uaigc_item_actionbar_image_selector_holder, r101, false);
        int r103 = R.id.icon_img_selected_check;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r102, R.id.icon_img_selected_check)) == null) goto L11;
        r103 = R.id.image_template_cover;
        if (((SimpleDraweeView) ViewBindings.findChildViewById(r102, R.id.image_template_cover)) == null) goto L11;
        r103 = R.id.tv_item_name;
        if (((TextView) ViewBindings.findChildViewById(r102, R.id.tv_item_name)) == null) goto L11;
        return new LarusUaigcItemActionbarImageSelectorHolderBinding((FrameLayout) r102);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
