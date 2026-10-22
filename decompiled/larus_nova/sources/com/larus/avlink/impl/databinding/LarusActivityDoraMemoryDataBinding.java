package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.larus.bmhome.view.NovaTitleBarEx;

/* JADX INFO: loaded from: classes25.dex */
public final class LarusActivityDoraMemoryDataBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f293152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TabLayout f293153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NovaTitleBarEx f293154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewPager2 f293155d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f293152a;
    }

    public LarusActivityDoraMemoryDataBinding(LinearLayout r100, TabLayout r101, NovaTitleBarEx r102, ViewPager2 r103) {
        this.f293152a = r100;
        this.f293153b = r101;
        this.f293154c = r102;
        this.f293155d = r103;
    }
}
