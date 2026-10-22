package com.larus.home.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusItemSideBarSkeletonHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f344334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f344335b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f344334a;
    }

    public LarusItemSideBarSkeletonHeaderBinding(ConstraintLayout r100, TextView r101) {
        this.f344334a = r100;
        this.f344335b = r101;
    }
}
