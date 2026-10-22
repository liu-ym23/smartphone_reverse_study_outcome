package com.larus.bot.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.nova.R;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutBotEditBgImageBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f317845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f317846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f317847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f317848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RoundFrameLayout f317849e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LottieAdapterView f317850f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f317851g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f317845a;
    }

    public static LarusLayoutBotEditBgImageBinding a(LayoutInflater r100, ViewGroup r110) {
        View r101 = r100.inflate(R.layout.larus_layout_bot_edit_bg_image, r110, false);
        int r111 = R.id.avatar;
        SimpleDraweeView r102 = (SimpleDraweeView) ViewBindings.findChildViewById(r101, R.id.avatar);
        if (r102 == null) goto L17;
        r111 = R.id.avatar_parent;
        FrameLayout r103 = (FrameLayout) ViewBindings.findChildViewById(r101, R.id.avatar_parent);
        if (r103 == null) goto L17;
        r111 = R.id.bottom_btn;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r101, R.id.bottom_btn);
        if (r104 == null) goto L17;
        r111 = R.id.center_icon;
        RoundFrameLayout r105 = (RoundFrameLayout) ViewBindings.findChildViewById(r101, R.id.center_icon);
        if (r105 == null) goto L17;
        r111 = R.id.gen_anim;
        LottieAdapterView r106 = (LottieAdapterView) ViewBindings.findChildViewById(r101, R.id.gen_anim);
        if (r106 == null) goto L17;
        r111 = R.id.iv_center_icon;
        ImageView r107 = (ImageView) ViewBindings.findChildViewById(r101, R.id.iv_center_icon);
        if (r107 == null) goto L17;
        return new LarusLayoutBotEditBgImageBinding((LinearLayout) r101, r102, r103, r104, r105, r106, r107);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r111)));
    }

    public LarusLayoutBotEditBgImageBinding(LinearLayout r100, SimpleDraweeView r101, FrameLayout r102, TextView r103, RoundFrameLayout r104, LottieAdapterView r105, ImageView r106) {
        this.f317845a = r100;
        this.f317846b = r101;
        this.f317847c = r102;
        this.f317848d = r103;
        this.f317849e = r104;
        this.f317850f = r105;
        this.f317851g = r106;
    }
}
