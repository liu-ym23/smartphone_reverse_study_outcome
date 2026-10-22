package com.larus.discover.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDiscoverMainLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f330497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TabLayout f330498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewPager2 f330499c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f330497a;
    }

    public LarusDiscoverMainLayoutBinding(FrameLayout r100, TabLayout r101, ViewPager2 r102) {
        this.f330497a = r100;
        this.f330498b = r101;
        this.f330499c = r102;
    }
}
