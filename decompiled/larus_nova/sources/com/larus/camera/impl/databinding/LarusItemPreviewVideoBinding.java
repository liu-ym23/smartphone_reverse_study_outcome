package com.larus.camera.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.camera.impl.ui.component.result.video.ResultVideoView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusItemPreviewVideoBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f321496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f321497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ResultVideoView f321498c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f321496a;
    }

    public LarusItemPreviewVideoBinding(ConstraintLayout r100, ImageView r101, ResultVideoView r102) {
        this.f321496a = r100;
        this.f321497b = r101;
        this.f321498c = r102;
    }
}
