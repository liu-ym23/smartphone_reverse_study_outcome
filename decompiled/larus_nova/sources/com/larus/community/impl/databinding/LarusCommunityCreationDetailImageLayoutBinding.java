package com.larus.community.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.community.impl.detail.image.CreationZoomableDraweeView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusCommunityCreationDetailImageLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f329043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f329044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CreationZoomableDraweeView f329045c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f329043a;
    }

    public LarusCommunityCreationDetailImageLayoutBinding(View r100, ConstraintLayout r101, CreationZoomableDraweeView r102) {
        this.f329043a = r100;
        this.f329044b = r101;
        this.f329045c = r102;
    }
}
