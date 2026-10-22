package com.larus.bot.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bot.impl.common.view.CircularLottieView;
import com.larus.common_ui.widget.roundlayout.CircleFrameLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutBotEditAvatarBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f317834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CircularLottieView f317835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CircleFrameLayout f317836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f317837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SimpleDraweeView f317838e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f317834a;
    }

    public static LarusLayoutBotEditAvatarBinding a(LayoutInflater r100, ViewGroup r101) {
        r100.inflate(R.layout.larus_layout_bot_edit_avatar, r101);
        int r102 = R.id.avatar_circular_loading;
        CircularLottieView r103 = (CircularLottieView) ViewBindings.findChildViewById(r101, R.id.avatar_circular_loading);
        if (r103 == null) goto L13;
        r102 = R.id.header_container;
        CircleFrameLayout r104 = (CircleFrameLayout) ViewBindings.findChildViewById(r101, R.id.header_container);
        if (r104 == null) goto L13;
        r102 = R.id.iv_add_header;
        AppCompatImageView r105 = (AppCompatImageView) ViewBindings.findChildViewById(r101, R.id.iv_add_header);
        if (r105 == null) goto L13;
        r102 = R.id.iv_header;
        SimpleDraweeView r106 = (SimpleDraweeView) ViewBindings.findChildViewById(r101, R.id.iv_header);
        if (r106 == null) goto L13;
        return new LarusLayoutBotEditAvatarBinding(r101, r103, r104, r105, r106);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    }

    public LarusLayoutBotEditAvatarBinding(View r100, CircularLottieView r101, CircleFrameLayout r102, AppCompatImageView r103, SimpleDraweeView r104) {
        this.f317834a = r100;
        this.f317835b = r101;
        this.f317836c = r102;
        this.f317837d = r103;
        this.f317838e = r104;
    }
}
