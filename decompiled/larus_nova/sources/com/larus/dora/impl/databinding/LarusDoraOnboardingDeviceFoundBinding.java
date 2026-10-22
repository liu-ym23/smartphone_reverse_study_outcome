package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.larus.dora.impl.view.DoraMovieView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraOnboardingDeviceFoundBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f332787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f332788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f332789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayoutCompat f332790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DoraMovieView f332791e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f332792f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332787a;
    }

    public LarusDoraOnboardingDeviceFoundBinding(FrameLayout r100, ImageView r101, AppCompatTextView r102, LinearLayoutCompat r103, DoraMovieView r104, FrameLayout r105) {
        this.f332787a = r100;
        this.f332788b = r101;
        this.f332789c = r102;
        this.f332790d = r103;
        this.f332791e = r104;
        this.f332792f = r105;
    }
}
