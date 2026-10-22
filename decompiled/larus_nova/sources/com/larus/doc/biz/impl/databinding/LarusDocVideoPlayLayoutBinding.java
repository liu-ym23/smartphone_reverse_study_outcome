package com.larus.doc.biz.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.doc.impl.video.widget.VideoPlayView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDocVideoPlayLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f330942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f330943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f330944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RelativeLayout f330945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f330946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final VideoPlayView f330947f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f330942a;
    }

    public LarusDocVideoPlayLayoutBinding(ConstraintLayout r100, ImageView r101, FrameLayout r102, RelativeLayout r103, ImageView r104, VideoPlayView r105) {
        this.f330942a = r100;
        this.f330943b = r101;
        this.f330944c = r102;
        this.f330945d = r103;
        this.f330946e = r104;
        this.f330947f = r105;
    }
}
