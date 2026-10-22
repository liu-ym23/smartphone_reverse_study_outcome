package com.larus.home.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.RedDotTextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusItemSideBarComponentBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f344282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f344283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f344284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f344285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RedDotTextView f344286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f344287f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f344288g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f344289h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f344290i;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f344282a;
    }

    public static LarusItemSideBarComponentBinding a(LayoutInflater r110, ViewGroup r111) {
        View r112 = r110.inflate(R.layout.larus_item_side_bar_component, r111, false);
        ConstraintLayout r100 = (ConstraintLayout) r112;
        int r113 = R.id.icon_container;
        FrameLayout r101 = (FrameLayout) ViewBindings.findChildViewById(r112, R.id.icon_container);
        if (r101 == null) goto L19;
        r113 = R.id.iv_item_icon;
        SimpleDraweeView r102 = (SimpleDraweeView) ViewBindings.findChildViewById(r112, R.id.iv_item_icon);
        if (r102 == null) goto L19;
        r113 = R.id.message_red_dot;
        RedDotTextView r103 = (RedDotTextView) ViewBindings.findChildViewById(r112, R.id.message_red_dot);
        if (r103 == null) goto L19;
        r113 = R.id.right_icon_container;
        LinearLayout r104 = (LinearLayout) ViewBindings.findChildViewById(r112, R.id.right_icon_container);
        if (r104 == null) goto L19;
        r113 = R.id.tv_item_count;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r112, R.id.tv_item_count);
        if (r105 == null) goto L19;
        r113 = R.id.tv_item_hint;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r112, R.id.tv_item_hint);
        if (r106 == null) goto L19;
        r113 = R.id.tv_tag_new;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r112, R.id.tv_tag_new);
        if (r107 == null) goto L19;
        return new LarusItemSideBarComponentBinding(r100, r100, r101, r102, r103, r104, r105, r106, r107);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r112.getResources().getResourceName(r113)));
    }

    public LarusItemSideBarComponentBinding(ConstraintLayout r100, ConstraintLayout r101, FrameLayout r102, SimpleDraweeView r103, RedDotTextView r104, LinearLayout r105, TextView r106, TextView r107, TextView r108) {
        this.f344282a = r100;
        this.f344283b = r101;
        this.f344284c = r102;
        this.f344285d = r103;
        this.f344286e = r104;
        this.f344287f = r105;
        this.f344288g = r106;
        this.f344289h = r107;
        this.f344290i = r108;
    }
}
