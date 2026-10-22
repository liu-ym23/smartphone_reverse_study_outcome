package com.larus.showcase.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusFragmentCaseListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f369260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f369261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LarusPageCaseErrorBinding f369262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f369263d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LarusPageCaseLoadingSkeletonBinding f369264e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f369265f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConstraintLayout f369266g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f369260a;
    }

    public LarusFragmentCaseListBinding(ConstraintLayout r100, ImageView r101, LarusPageCaseErrorBinding r102, RecyclerView r103, LarusPageCaseLoadingSkeletonBinding r104, AppCompatTextView r105, ConstraintLayout r106) {
        this.f369260a = r100;
        this.f369261b = r101;
        this.f369262c = r102;
        this.f369263d = r103;
        this.f369264e = r104;
        this.f369265f = r105;
        this.f369266g = r106;
    }
}
