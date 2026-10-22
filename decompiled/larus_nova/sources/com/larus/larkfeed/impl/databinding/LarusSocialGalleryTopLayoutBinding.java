package com.larus.larkfeed.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusSocialGalleryTopLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f355158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f355159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f355160c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f355158a;
    }

    public LarusSocialGalleryTopLayoutBinding(ConstraintLayout r100, ImageView r101, ImageView r102, ImageView r103) {
        this.f355158a = r100;
        this.f355159b = r102;
        this.f355160c = r103;
    }
}
