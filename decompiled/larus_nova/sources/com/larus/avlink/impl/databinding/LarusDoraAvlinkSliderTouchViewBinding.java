package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes25.dex */
public final class LarusDoraAvlinkSliderTouchViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f293193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f293194b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f293193a;
    }

    public LarusDoraAvlinkSliderTouchViewBinding(ConstraintLayout r100, ImageView r101) {
        this.f293193a = r100;
        this.f293194b = r101;
    }
}
