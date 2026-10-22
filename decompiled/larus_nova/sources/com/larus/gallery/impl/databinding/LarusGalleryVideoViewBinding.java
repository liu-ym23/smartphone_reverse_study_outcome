package com.larus.gallery.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.video.progress.PlayerProgressView;
import com.larus.gallery.adapter.ui.GalleryVideoView;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusGalleryVideoViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f343973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GalleryVideoView f343974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f343975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f343976d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f343977e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PlayerProgressView f343978f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RelativeLayout f343979g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f343973a;
    }

    public LarusGalleryVideoViewBinding(ConstraintLayout r100, GalleryVideoView r101, ImageView r102, ImageView r103, ConstraintLayout r104, PlayerProgressView r105, RelativeLayout r106) {
        this.f343973a = r100;
        this.f343974b = r101;
        this.f343975c = r102;
        this.f343976d = r103;
        this.f343977e = r104;
        this.f343978f = r105;
        this.f343979g = r106;
    }
}
