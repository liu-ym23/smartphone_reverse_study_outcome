package com.larus.camera.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusItemPreviewGifBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f321490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f321491b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f321490a;
    }

    public LarusItemPreviewGifBinding(ConstraintLayout r100, SimpleDraweeView r101) {
        this.f321490a = r100;
        this.f321491b = r101;
    }
}
