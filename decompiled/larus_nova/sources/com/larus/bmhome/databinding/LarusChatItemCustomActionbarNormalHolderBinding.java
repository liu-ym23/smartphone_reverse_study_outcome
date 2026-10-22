package com.larus.bmhome.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.nova.R;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusChatItemCustomActionbarNormalHolderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoundConstraintLayout f310794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f310795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f310796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f310797d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f310794a;
    }

    public static LarusChatItemCustomActionbarNormalHolderBinding a(View r100) {
        int r101 = R.id.barrier_end;
        if (((Barrier) ViewBindings.findChildViewById(r100, R.id.barrier_end)) == null) goto L21;
        r101 = R.id.ic_item_img;
        SimpleDraweeView r102 = (SimpleDraweeView) ViewBindings.findChildViewById(r100, R.id.ic_item_img);
        if (r102 == null) goto L21;
        r101 = R.id.ic_item_lottie;
        if (((LottieAdapterView) ViewBindings.findChildViewById(r100, R.id.ic_item_lottie)) == null) goto L21;
        r101 = R.id.iv_item_red_dot;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.iv_item_red_dot)) == null) goto L21;
        r101 = R.id.iv_left_bold;
        if (((ImageView) ViewBindings.findChildViewById(r100, R.id.iv_left_bold)) == null) goto L21;
        r101 = R.id.loading;
        if (((ProgressBar) ViewBindings.findChildViewById(r100, R.id.loading)) == null) goto L21;
        r101 = R.id.tv_item_name;
        AppCompatTextView r103 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.tv_item_name);
        if (r103 == null) goto L21;
        r101 = R.id.tv_item_update_dot;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r100, R.id.tv_item_update_dot);
        if (r104 == null) goto L21;
        return new LarusChatItemCustomActionbarNormalHolderBinding((RoundConstraintLayout) r100, r102, r103, r104);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public static LarusChatItemCustomActionbarNormalHolderBinding b(LayoutInflater r100, ViewGroup r101) {
        return a(r100.inflate(R.layout.larus_chat_item_custom_actionbar_normal_holder, r101, false));
    }

    public LarusChatItemCustomActionbarNormalHolderBinding(RoundConstraintLayout r100, SimpleDraweeView r101, AppCompatTextView r102, TextView r103) {
        this.f310794a = r100;
        this.f310795b = r101;
        this.f310796c = r102;
        this.f310797d = r103;
    }
}
