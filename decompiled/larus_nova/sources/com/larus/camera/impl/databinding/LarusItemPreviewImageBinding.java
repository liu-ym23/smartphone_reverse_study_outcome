package com.larus.camera.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusItemPreviewImageBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f321492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f321493b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f321492a;
    }

    public LarusItemPreviewImageBinding(ConstraintLayout r100, ImageView r101) {
        this.f321492a = r100;
        this.f321493b = r101;
    }
}
