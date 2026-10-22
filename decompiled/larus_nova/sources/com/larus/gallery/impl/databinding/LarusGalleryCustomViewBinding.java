package com.larus.gallery.impl.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.photoviewer.transition.TransitionLayout;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusGalleryCustomViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TransitionLayout f343964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TransitionLayout f343965b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f343964a;
    }

    public LarusGalleryCustomViewBinding(TransitionLayout r100, TransitionLayout r101) {
        this.f343964a = r100;
        this.f343965b = r101;
    }
}
