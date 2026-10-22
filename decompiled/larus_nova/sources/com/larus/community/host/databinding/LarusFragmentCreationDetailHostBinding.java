package com.larus.community.host.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusFragmentCreationDetailHostBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f328765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewPager2 f328766b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f328765a;
    }

    public LarusFragmentCreationDetailHostBinding(ConstraintLayout r100, ViewPager2 r101) {
        this.f328765a = r100;
        this.f328766b = r101;
    }
}
