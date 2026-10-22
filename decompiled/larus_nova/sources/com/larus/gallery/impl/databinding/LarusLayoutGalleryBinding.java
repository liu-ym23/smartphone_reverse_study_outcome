package com.larus.gallery.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.gallery.tracker.GalleryThumbnailView;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusLayoutGalleryBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f343980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f343981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f343982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f343983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f343984e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final GalleryThumbnailView f343985f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final FrameLayout f343986g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f343980a;
    }

    public LarusLayoutGalleryBinding(ConstraintLayout r100, FrameLayout r101, SimpleDraweeView r102, FrameLayout r103, FrameLayout r104, GalleryThumbnailView r105, FrameLayout r106) {
        this.f343980a = r100;
        this.f343981b = r101;
        this.f343982c = r102;
        this.f343983d = r103;
        this.f343984e = r104;
        this.f343985f = r105;
        this.f343986g = r106;
    }
}
