package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.onboarding.g.DoraGOnboardingShimmerTextView;
import com.larus.dora.impl.view.DoraMovieView;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraOnboardingDialogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f332793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DoraGOnboardingShimmerTextView f332794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f332795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f332796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f332797e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayoutCompat f332798f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DoraMovieView f332799g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FrameLayout f332800h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SimpleDraweeView f332801i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DoraTextView f332802j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final DoraTextView f332803k;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332793a;
    }

    public LarusDoraOnboardingDialogBinding(FrameLayout r100, DoraGOnboardingShimmerTextView r101, AppCompatTextView r102, ImageView r103, AppCompatTextView r104, LinearLayoutCompat r105, DoraMovieView r106, FrameLayout r107, SimpleDraweeView r108, DoraTextView r110, DoraTextView r111) {
        this.f332793a = r100;
        this.f332794b = r101;
        this.f332795c = r102;
        this.f332796d = r103;
        this.f332797e = r104;
        this.f332798f = r105;
        this.f332799g = r106;
        this.f332800h = r107;
        this.f332801i = r108;
        this.f332802j = r110;
        this.f332803k = r111;
    }
}
