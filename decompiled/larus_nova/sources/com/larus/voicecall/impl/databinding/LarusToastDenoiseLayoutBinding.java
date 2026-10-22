package com.larus.voicecall.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes32.dex */
public final class LarusToastDenoiseLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f378317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f378318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatButton f378319c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f378317a;
    }

    public LarusToastDenoiseLayoutBinding(FrameLayout r100, ImageView r101, AppCompatButton r102) {
        this.f378317a = r100;
        this.f378318b = r101;
        this.f378319c = r102;
    }
}
