package com.skydoves.balloon.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.skydoves.balloon.overlay.BalloonAnchorOverlayView;

/* JADX INFO: loaded from: classes34.dex */
public final class BalloonLayoutOverlayBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BalloonAnchorOverlayView f406145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BalloonAnchorOverlayView f406146b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f406145a;
    }

    public BalloonLayoutOverlayBinding(BalloonAnchorOverlayView r100, BalloonAnchorOverlayView r101) {
        this.f406145a = r100;
        this.f406146b = r101;
    }
}
