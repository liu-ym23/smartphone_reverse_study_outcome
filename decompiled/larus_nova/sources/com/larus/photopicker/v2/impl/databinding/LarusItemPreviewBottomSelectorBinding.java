package com.larus.photopicker.v2.impl.databinding;

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

/* JADX INFO: loaded from: classes31.dex */
public final class LarusItemPreviewBottomSelectorBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f364424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f364425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f364426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f364427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SimpleDraweeView f364428e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f364424a;
    }

    public static LarusItemPreviewBottomSelectorBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_item_preview_bottom_selector, r101, false);
        int r103 = R.id.item_preview_selector_border;
        View r104 = ViewBindings.findChildViewById(r102, R.id.item_preview_selector_border);
        if (r104 == null) goto L15;
        r103 = R.id.item_preview_selector_delete;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r102, R.id.item_preview_selector_delete)) == null) goto L15;
        r103 = R.id.item_preview_selector_delete_layout;
        View r105 = ViewBindings.findChildViewById(r102, R.id.item_preview_selector_delete_layout);
        if (r105 == null) goto L15;
        r103 = R.id.item_preview_selector_duration;
        AppCompatTextView r106 = (AppCompatTextView) ViewBindings.findChildViewById(r102, R.id.item_preview_selector_duration);
        if (r106 == null) goto L15;
        r103 = R.id.item_preview_selector_view;
        SimpleDraweeView r107 = (SimpleDraweeView) ViewBindings.findChildViewById(r102, R.id.item_preview_selector_view);
        if (r107 == null) goto L15;
        return new LarusItemPreviewBottomSelectorBinding((FrameLayout) r102, r104, r105, r106, r107);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    public LarusItemPreviewBottomSelectorBinding(FrameLayout r100, View r101, View r102, AppCompatTextView r103, SimpleDraweeView r104) {
        this.f364424a = r100;
        this.f364425b = r101;
        this.f364426c = r102;
        this.f364427d = r103;
        this.f364428e = r104;
    }
}
