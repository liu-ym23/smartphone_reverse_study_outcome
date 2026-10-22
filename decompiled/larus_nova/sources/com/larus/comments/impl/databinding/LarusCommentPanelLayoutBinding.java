package com.larus.comments.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusCommentPanelLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f325662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f325663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f325664c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f325662a;
    }

    public LarusCommentPanelLayoutBinding(ConstraintLayout r100, View r101, FrameLayout r102) {
        this.f325662a = r100;
        this.f325663b = r101;
        this.f325664c = r102;
    }
}
