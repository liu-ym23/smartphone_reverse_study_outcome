package com.larus.community.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.community.impl.widget.CreationLoadingAndRetryView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusCommunityTemplateCreationFragmentLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f329149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f329150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CreationLoadingAndRetryView f329151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f329152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f329153e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConstraintLayout f329154f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AppCompatImageView f329155g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f329156h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ViewPager2 f329157i;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f329149a;
    }

    public LarusCommunityTemplateCreationFragmentLayoutBinding(ConstraintLayout r100, View r101, CreationLoadingAndRetryView r102, SimpleDraweeView r103, FrameLayout r104, ConstraintLayout r105, AppCompatImageView r106, TextView r107, ViewPager2 r108) {
        this.f329149a = r100;
        this.f329150b = r101;
        this.f329151c = r102;
        this.f329152d = r103;
        this.f329153e = r104;
        this.f329154f = r105;
        this.f329155g = r106;
        this.f329156h = r107;
        this.f329157i = r108;
    }
}
