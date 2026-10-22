package com.larus.home.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.home.impl.main.side_bar.layout.drawer_impl.DrawerSideBarLayout;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusPageMainSideBarBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DrawerSideBarLayout f344376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f344377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f344378c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f344376a;
    }

    public LarusPageMainSideBarBinding(DrawerSideBarLayout r100, FrameLayout r101, FrameLayout r102, DrawerSideBarLayout r103) {
        this.f344376a = r100;
        this.f344377b = r101;
        this.f344378c = r102;
    }
}
