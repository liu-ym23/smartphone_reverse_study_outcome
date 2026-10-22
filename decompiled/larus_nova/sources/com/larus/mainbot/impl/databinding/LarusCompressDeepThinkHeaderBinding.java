package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.standarduikit.floatingthink.view.DeepThinkShimmerLinearLayout;
import com.larus.common_ui.view.ActivityIndicatorView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusCompressDeepThinkHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f358552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DeepThinkShimmerLinearLayout f358553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f358554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f358555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ActivityIndicatorView f358556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConstraintLayout f358557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f358558g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FrameLayout f358559h;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358552a;
    }

    public LarusCompressDeepThinkHeaderBinding(ConstraintLayout r100, DeepThinkShimmerLinearLayout r101, AppCompatImageView r102, SimpleDraweeView r103, ActivityIndicatorView r104, ConstraintLayout r105, TextView r106, FrameLayout r107) {
        this.f358552a = r100;
        this.f358553b = r101;
        this.f358554c = r102;
        this.f358555d = r103;
        this.f358556e = r104;
        this.f358557f = r105;
        this.f358558g = r106;
        this.f358559h = r107;
    }
}
