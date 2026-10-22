package com.larksuite.component.universe_design.tab.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes24.dex */
public final class UdTabItemLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f285302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f285303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f285304c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f285302a;
    }

    public UdTabItemLayoutBinding(View r100, ImageView r101, FrameLayout r102) {
        this.f285302a = r100;
        this.f285303b = r101;
        this.f285304c = r102;
    }
}
