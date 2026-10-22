package com.larus.doc.sdk.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDocToolbarItemLayoutBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final ImageView toolbarItemIcon;
    public final LottieAnimationView toolbarItemLottie;
    public final TextView toolbarItemText;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LarusDocToolbarItemLayoutBinding bind(View r100) {
        int r101 = R.id.toolbar_item_icon;
        ImageView r102 = (ImageView) ViewBindings.findChildViewById(r100, R.id.toolbar_item_icon);
        if (r102 == null) goto L11;
        r101 = R.id.toolbar_item_lottie;
        LottieAnimationView r103 = (LottieAnimationView) ViewBindings.findChildViewById(r100, R.id.toolbar_item_lottie);
        if (r103 == null) goto L11;
        r101 = R.id.toolbar_item_text;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r100, R.id.toolbar_item_text);
        if (r104 == null) goto L11;
        return new LarusDocToolbarItemLayoutBinding((LinearLayout) r100, r102, r103, r104);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public static LarusDocToolbarItemLayoutBinding inflate(LayoutInflater r100) {
        return inflate(r100, null, false);
    }

    public static LarusDocToolbarItemLayoutBinding inflate(LayoutInflater r100, ViewGroup r101, boolean r102) {
        View r103 = r100.inflate(R.layout.larus_doc_toolbar_item_layout, r101, false);
        if (r102 == false) goto L6;
        r101.addView(r103);
    L6:
        return bind(r103);
    }

    private LarusDocToolbarItemLayoutBinding(LinearLayout r100, ImageView r101, LottieAnimationView r102, TextView r103) {
        this.rootView = r100;
        this.toolbarItemIcon = r101;
        this.toolbarItemLottie = r102;
        this.toolbarItemText = r103;
    }
}
