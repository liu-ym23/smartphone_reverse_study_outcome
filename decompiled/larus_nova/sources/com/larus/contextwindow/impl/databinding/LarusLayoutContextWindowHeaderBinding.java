package com.larus.contextwindow.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusLayoutContextWindowHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f330343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f330344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f330345c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f330343a;
    }

    public LarusLayoutContextWindowHeaderBinding(ConstraintLayout r100, AppCompatImageView r101, TextView r102) {
        this.f330343a = r100;
        this.f330344b = r101;
        this.f330345c = r102;
    }
}
