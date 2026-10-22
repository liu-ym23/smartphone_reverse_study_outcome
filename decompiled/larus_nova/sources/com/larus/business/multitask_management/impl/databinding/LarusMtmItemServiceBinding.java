package com.larus.business.multitask_management.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusMtmItemServiceBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f320835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f320836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f320837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f320838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f320839e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f320835a;
    }

    public static LarusMtmItemServiceBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_mtm_item_service, r101, false);
        int r103 = R.id.mtm_service_close;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(r102, R.id.mtm_service_close);
        if (r104 == null) goto L15;
        r103 = R.id.mtm_service_icon;
        SimpleDraweeView r105 = (SimpleDraweeView) ViewBindings.findChildViewById(r102, R.id.mtm_service_icon);
        if (r105 == null) goto L15;
        r103 = R.id.mtm_service_item;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r102, R.id.mtm_service_item)) == null) goto L15;
        r103 = R.id.mtm_service_item_fold_stack_bg;
        View r106 = ViewBindings.findChildViewById(r102, R.id.mtm_service_item_fold_stack_bg);
        if (r106 == null) goto L15;
        r103 = R.id.mtm_service_title;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r102, R.id.mtm_service_title);
        if (r107 == null) goto L15;
        return new LarusMtmItemServiceBinding((FrameLayout) r102, r104, r105, r106, r107);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    public LarusMtmItemServiceBinding(FrameLayout r100, ImageView r101, SimpleDraweeView r102, View r103, TextView r104) {
        this.f320835a = r100;
        this.f320836b = r101;
        this.f320837c = r102;
        this.f320838d = r103;
        this.f320839e = r104;
    }
}
