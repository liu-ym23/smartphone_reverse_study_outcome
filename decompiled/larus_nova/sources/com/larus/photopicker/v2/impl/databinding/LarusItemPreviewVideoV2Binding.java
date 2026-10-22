package com.larus.photopicker.v2.impl.databinding;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.VideoView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.photopicker.v2.impl.others.scale.ScaleGestureLayout;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusItemPreviewVideoV2Binding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScaleGestureLayout f364432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScaleGestureLayout f364433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f364434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f364435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ProgressBar f364436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final VideoView f364437f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f364432a;
    }

    public LarusItemPreviewVideoV2Binding(ScaleGestureLayout r100, ScaleGestureLayout r101, SimpleDraweeView r102, AppCompatImageView r103, ProgressBar r104, VideoView r105) {
        this.f364432a = r100;
        this.f364433b = r101;
        this.f364434c = r102;
        this.f364435d = r103;
        this.f364436e = r104;
        this.f364437f = r105;
    }
}
