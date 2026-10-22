package com.larus.dora.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.dora.impl.onboarding.g.DoraGOnboardingShimmerTextView;
import com.larus.dora.impl.view.DoraMovieView;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraGOnboardingDialogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f332616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f332617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DoraGOnboardingShimmerTextView f332618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f332619d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f332620e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AppCompatTextView f332621f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinearLayoutCompat f332622g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DoraMovieView f332623h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final FrameLayout f332624i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DoraTextView f332625j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final DoraTextView f332626k;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332616a;
    }

    public static LarusDoraGOnboardingDialogBinding a(LayoutInflater r110, ViewGroup r111) {
        View r112 = r110.inflate(R.layout.larus_dora_g_onboarding_dialog, r111, false);
        int r113 = R.id.dora_g_onboarding_dialog_layout;
        ConstraintLayout r100 = (ConstraintLayout) ViewBindings.findChildViewById(r112, R.id.dora_g_onboarding_dialog_layout);
        if (r100 == null) goto L27;
        r113 = R.id.dora_onboarding_dialog_bottom_tips;
        DoraGOnboardingShimmerTextView r101 = (DoraGOnboardingShimmerTextView) ViewBindings.findChildViewById(r112, R.id.dora_onboarding_dialog_bottom_tips);
        if (r101 == null) goto L27;
        r113 = R.id.dora_onboarding_dialog_center_tips;
        AppCompatTextView r102 = (AppCompatTextView) ViewBindings.findChildViewById(r112, R.id.dora_onboarding_dialog_center_tips);
        if (r102 == null) goto L27;
        r113 = R.id.dora_onboarding_dialog_close_btn;
        ImageView r103 = (ImageView) ViewBindings.findChildViewById(r112, R.id.dora_onboarding_dialog_close_btn);
        if (r103 == null) goto L27;
        r113 = R.id.dora_onboarding_dialog_connect_btn;
        AppCompatTextView r104 = (AppCompatTextView) ViewBindings.findChildViewById(r112, R.id.dora_onboarding_dialog_connect_btn);
        if (r104 == null) goto L27;
        r113 = R.id.dora_onboarding_dialog_connecting;
        LinearLayoutCompat r105 = (LinearLayoutCompat) ViewBindings.findChildViewById(r112, R.id.dora_onboarding_dialog_connecting);
        if (r105 == null) goto L27;
        r113 = R.id.dora_onboarding_dialog_connecting_btn;
        if (((AppCompatTextView) ViewBindings.findChildViewById(r112, R.id.dora_onboarding_dialog_connecting_btn)) == null) goto L27;
        r113 = R.id.dora_onboarding_dialog_mv;
        DoraMovieView r106 = (DoraMovieView) ViewBindings.findChildViewById(r112, R.id.dora_onboarding_dialog_mv);
        if (r106 == null) goto L27;
        r113 = R.id.dora_onboarding_dialog_mv_layout;
        FrameLayout r114 = (FrameLayout) ViewBindings.findChildViewById(r112, R.id.dora_onboarding_dialog_mv_layout);
        if (r114 == null) goto L27;
        r113 = R.id.dora_onboarding_dialog_subtitle;
        DoraTextView r115 = (DoraTextView) ViewBindings.findChildViewById(r112, R.id.dora_onboarding_dialog_subtitle);
        if (r115 == null) goto L27;
        r113 = R.id.dora_onboarding_dialog_title;
        DoraTextView r116 = (DoraTextView) ViewBindings.findChildViewById(r112, R.id.dora_onboarding_dialog_title);
        if (r116 == null) goto L27;
        return new LarusDoraGOnboardingDialogBinding((FrameLayout) r112, r100, r101, r102, r103, r104, r105, r106, r114, r115, r116);
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r112.getResources().getResourceName(r113)));
    }

    public LarusDoraGOnboardingDialogBinding(FrameLayout r100, ConstraintLayout r101, DoraGOnboardingShimmerTextView r102, AppCompatTextView r103, ImageView r104, AppCompatTextView r105, LinearLayoutCompat r106, DoraMovieView r107, FrameLayout r108, DoraTextView r110, DoraTextView r111) {
        this.f332616a = r100;
        this.f332617b = r101;
        this.f332618c = r102;
        this.f332619d = r103;
        this.f332620e = r104;
        this.f332621f = r105;
        this.f332622g = r106;
        this.f332623h = r107;
        this.f332624i = r108;
        this.f332625j = r110;
        this.f332626k = r111;
    }
}
