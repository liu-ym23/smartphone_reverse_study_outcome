package com.larus.business.banner.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.banner.BannerViewPager;
import com.larus.nova.R;
import com.zhpan.bannerview.indicator.DrawableIndicator;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusItemBannerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f319934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BannerViewPager f319935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DrawableIndicator f319936c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f319934a;
    }

    public static LarusItemBannerBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_item_banner, r101, false);
        int r103 = R.id.banner_view_pager;
        BannerViewPager r104 = (BannerViewPager) ViewBindings.findChildViewById(r102, R.id.banner_view_pager);
        if (r104 == null) goto L9;
        r103 = R.id.indicator_view;
        DrawableIndicator r105 = (DrawableIndicator) ViewBindings.findChildViewById(r102, R.id.indicator_view);
        if (r105 == null) goto L9;
        return new LarusItemBannerBinding((ConstraintLayout) r102, r104, r105);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    public LarusItemBannerBinding(ConstraintLayout r100, BannerViewPager r101, DrawableIndicator r102) {
        this.f319934a = r100;
        this.f319935b = r101;
        this.f319936c = r102;
    }
}
