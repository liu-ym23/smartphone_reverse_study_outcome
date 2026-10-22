package com.larus.gallery.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.gallery.adapter.ui.GalleryImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusGalleryImageViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f343966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProgressBar f343967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GalleryImageView f343968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RelativeLayout f343969d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f343966a;
    }

    public static LarusGalleryImageViewBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_gallery_image_view, r101, false);
        int r103 = R.id.big_image_blank_icon;
        if (((ImageView) ViewBindings.findChildViewById(r102, R.id.big_image_blank_icon)) == null) goto L13;
        r103 = R.id.big_image_loading;
        ProgressBar r104 = (ProgressBar) ViewBindings.findChildViewById(r102, R.id.big_image_loading);
        if (r104 == null) goto L13;
        r103 = R.id.big_image_photo_view;
        GalleryImageView r105 = (GalleryImageView) ViewBindings.findChildViewById(r102, R.id.big_image_photo_view);
        if (r105 == null) goto L13;
        r103 = R.id.big_image_retry_view;
        RelativeLayout r106 = (RelativeLayout) ViewBindings.findChildViewById(r102, R.id.big_image_retry_view);
        if (r106 == null) goto L13;
        return new LarusGalleryImageViewBinding((FrameLayout) r102, r104, r105, r106);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    public LarusGalleryImageViewBinding(FrameLayout r100, ProgressBar r101, GalleryImageView r102, RelativeLayout r103) {
        this.f343966a = r100;
        this.f343967b = r101;
        this.f343968c = r102;
        this.f343969d = r103;
    }
}
