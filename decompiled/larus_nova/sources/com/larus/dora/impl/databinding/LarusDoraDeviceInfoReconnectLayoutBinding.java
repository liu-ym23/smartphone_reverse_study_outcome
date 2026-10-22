package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraDeviceInfoReconnectLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f332430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f332431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f332432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f332433d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332430a;
    }

    public LarusDoraDeviceInfoReconnectLayoutBinding(FrameLayout r100, LinearLayout r101, AppCompatTextView r102, ImageView r103) {
        this.f332430a = r100;
        this.f332431b = r101;
        this.f332432c = r102;
        this.f332433d = r103;
    }
}
