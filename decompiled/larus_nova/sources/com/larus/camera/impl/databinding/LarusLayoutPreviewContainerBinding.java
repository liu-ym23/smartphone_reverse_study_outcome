package com.larus.camera.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.view.markableview.MarkableImageView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutPreviewContainerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f321502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MarkableImageView f321503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f321504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f321505d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f321502a;
    }

    public LarusLayoutPreviewContainerBinding(View r100, MarkableImageView r101, SimpleDraweeView r102, FrameLayout r103) {
        this.f321502a = r100;
        this.f321503b = r101;
        this.f321504c = r102;
        this.f321505d = r103;
    }
}
