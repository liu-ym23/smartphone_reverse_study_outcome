package com.larus.avlink.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes25.dex */
public final class LarusPageAlbumListEmptyBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f293259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f293260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f293261c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f293259a;
    }

    public LarusPageAlbumListEmptyBinding(ConstraintLayout r100, AppCompatImageView r101, AppCompatTextView r102) {
        this.f293259a = r100;
        this.f293260b = r101;
        this.f293261c = r102;
    }
}
