package com.larus.uaigc.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusPageTemplateDetailBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f373252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f373253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f373254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f373255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RecyclerView f373256e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f373252a;
    }

    public LarusPageTemplateDetailBinding(ConstraintLayout r100, FrameLayout r101, ImageView r102, FrameLayout r103, RecyclerView r104) {
        this.f373252a = r100;
        this.f373253b = r101;
        this.f373254c = r102;
        this.f373255d = r103;
        this.f373256e = r104;
    }
}
