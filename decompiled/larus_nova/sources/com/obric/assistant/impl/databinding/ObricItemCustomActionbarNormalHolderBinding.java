package com.obric.assistant.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes33.dex */
public final class ObricItemCustomActionbarNormalHolderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoundConstraintLayout f389593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f389594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f389595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f389596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f389597e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f389593a;
    }

    public static ObricItemCustomActionbarNormalHolderBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.obric_item_custom_actionbar_normal_holder, r101, false);
        int r103 = R.id.ic_item_lottie;
        if (((LottieAnimationView) ViewBindings.findChildViewById(r102, R.id.ic_item_lottie)) == null) goto L17;
        r103 = R.id.iv_item_red_dot;
        AppCompatImageView r104 = (AppCompatImageView) ViewBindings.findChildViewById(r102, R.id.iv_item_red_dot);
        if (r104 == null) goto L17;
        r103 = R.id.loading;
        if (((ProgressBar) ViewBindings.findChildViewById(r102, R.id.loading)) == null) goto L17;
        r103 = R.id.obric_ic_item_img;
        SimpleDraweeView r105 = (SimpleDraweeView) ViewBindings.findChildViewById(r102, R.id.obric_ic_item_img);
        if (r105 == null) goto L17;
        r103 = R.id.tv_item_name;
        AppCompatTextView r106 = (AppCompatTextView) ViewBindings.findChildViewById(r102, R.id.tv_item_name);
        if (r106 == null) goto L17;
        r103 = R.id.tv_item_update_dot;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r102, R.id.tv_item_update_dot);
        if (r107 == null) goto L17;
        return new ObricItemCustomActionbarNormalHolderBinding((RoundConstraintLayout) r102, r104, r105, r106, r107);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    public ObricItemCustomActionbarNormalHolderBinding(RoundConstraintLayout r100, AppCompatImageView r101, SimpleDraweeView r102, AppCompatTextView r103, TextView r104) {
        this.f389593a = r100;
        this.f389594b = r101;
        this.f389595c = r102;
        this.f389596d = r103;
        this.f389597e = r104;
    }
}
