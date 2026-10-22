package com.larus.canvas.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutCanvasGenerateTopProviderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f323785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f323786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f323787c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f323785a;
    }

    public LarusLayoutCanvasGenerateTopProviderBinding(FrameLayout r100, ImageView r101, TextView r102) {
        this.f323785a = r100;
        this.f323786b = r101;
        this.f323787c = r102;
    }
}
