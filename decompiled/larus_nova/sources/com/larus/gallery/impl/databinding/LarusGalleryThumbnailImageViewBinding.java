package com.larus.gallery.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.gallery.tracker.GalleryRoundedFrameLayout;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusGalleryThumbnailImageViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GalleryRoundedFrameLayout f343970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f343971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f343972c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f343970a;
    }

    public LarusGalleryThumbnailImageViewBinding(GalleryRoundedFrameLayout r100, ImageView r101, SimpleDraweeView r102) {
        this.f343970a = r100;
        this.f343971b = r101;
        this.f343972c = r102;
    }
}
