package com.larus.profile.impl.databinding;

import android.view.View;
import android.view.ViewStub;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusProfileInfoViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f366544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewStub f366545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f366546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LarusPageProfileInfoSkeletonBinding f366547d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f366544a;
    }

    public LarusProfileInfoViewBinding(ConstraintLayout r100, ViewStub r101, RecyclerView r102, LarusPageProfileInfoSkeletonBinding r103) {
        this.f366544a = r100;
        this.f366545b = r101;
        this.f366546c = r102;
        this.f366547d = r103;
    }
}
