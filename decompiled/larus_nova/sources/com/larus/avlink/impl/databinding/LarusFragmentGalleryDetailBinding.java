package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes25.dex */
public final class LarusFragmentGalleryDetailBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f293210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f293211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f293212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f293213d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f293210a;
    }

    public LarusFragmentGalleryDetailBinding(ConstraintLayout r100, RecyclerView r101, ConstraintLayout r102, TextView r103, ConstraintLayout r104) {
        this.f293210a = r100;
        this.f293211b = r101;
        this.f293212c = r102;
        this.f293213d = r104;
    }
}
