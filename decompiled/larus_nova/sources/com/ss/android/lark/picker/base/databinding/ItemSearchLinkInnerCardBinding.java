package com.ss.android.lark.picker.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes37.dex */
public final class ItemSearchLinkInnerCardBinding implements ViewBinding {
    public final ConstraintLayout innerLinkLayout;
    public final ImageView linkIcon;
    public final TextView linkTitle;
    public final TextView linkUrl;
    private final ConstraintLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemSearchLinkInnerCardBinding bind(View r100) {
        ConstraintLayout r101 = (ConstraintLayout) r100;
        int r102 = R.id.link_icon;
        ImageView r103 = (ImageView) ViewBindings.findChildViewById(r100, R.id.link_icon);
        if (r103 == null) goto L11;
        r102 = R.id.link_title;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r100, R.id.link_title);
        if (r104 == null) goto L11;
        r102 = R.id.link_url;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r100, R.id.link_url);
        if (r105 == null) goto L11;
        return new ItemSearchLinkInnerCardBinding(r101, r101, r103, r104, r105);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r102)));
    }

    public static ItemSearchLinkInnerCardBinding inflate(LayoutInflater r100) {
        return inflate(r100, null, false);
    }

    public static ItemSearchLinkInnerCardBinding inflate(LayoutInflater r100, ViewGroup r101, boolean r102) {
        View r103 = r100.inflate(R.layout.item_search_link_inner_card, r101, false);
        if (r102 == false) goto L6;
        r101.addView(r103);
    L6:
        return bind(r103);
    }

    private ItemSearchLinkInnerCardBinding(ConstraintLayout r100, ConstraintLayout r101, ImageView r102, TextView r103, TextView r104) {
        this.rootView = r100;
        this.innerLinkLayout = r101;
        this.linkIcon = r102;
        this.linkTitle = r103;
        this.linkUrl = r104;
    }
}
