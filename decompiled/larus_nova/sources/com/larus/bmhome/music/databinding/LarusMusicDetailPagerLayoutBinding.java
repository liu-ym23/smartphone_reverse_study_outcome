package com.larus.bmhome.music.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.common_ui.view.DotsIndicator;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusMusicDetailPagerLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f312757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DotsIndicator f312758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewPager2 f312759c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f312757a;
    }

    public LarusMusicDetailPagerLayoutBinding(ConstraintLayout r100, DotsIndicator r101, ViewPager2 r102) {
        this.f312757a = r100;
        this.f312758b = r101;
        this.f312759c = r102;
    }
}
