package com.larus.profile.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusFragmentMineCollectListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f366445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LarusPageCollectListEmptyBinding f366446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LarusPageCollectErrorBinding f366447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f366448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LarusPageCollectLoadingSkeletonBinding f366449e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f366450f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f366445a;
    }

    public LarusFragmentMineCollectListBinding(ConstraintLayout r100, LarusPageCollectListEmptyBinding r101, LarusPageCollectErrorBinding r102, RecyclerView r103, LarusPageCollectLoadingSkeletonBinding r104, View r105) {
        this.f366445a = r100;
        this.f366446b = r101;
        this.f366447c = r102;
        this.f366448d = r103;
        this.f366449e = r104;
        this.f366450f = r105;
    }
}
