package com.larus.camera.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.markableview.MarkableImageView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusItemPreviewMarkableImageBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f321494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MarkableImageView f321495b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f321494a;
    }

    public LarusItemPreviewMarkableImageBinding(ConstraintLayout r100, MarkableImageView r101) {
        this.f321494a = r100;
        this.f321495b = r101;
    }
}
