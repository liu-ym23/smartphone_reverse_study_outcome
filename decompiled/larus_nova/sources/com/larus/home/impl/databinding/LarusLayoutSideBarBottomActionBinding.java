package com.larus.home.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.RedDotTextView;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusLayoutSideBarBottomActionBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f344336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f344337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f344338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RedDotTextView f344339d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f344336a;
    }

    public LarusLayoutSideBarBottomActionBinding(FrameLayout r100, SimpleDraweeView r101, FrameLayout r102, RedDotTextView r103) {
        this.f344336a = r100;
        this.f344337b = r101;
        this.f344338c = r102;
        this.f344339d = r103;
    }
}
