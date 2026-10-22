package com.larus.av_call.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.av_call.view.SceneModeButton;
import com.larus.common_ui.view.NoSpaceTextView;
import com.larus.common_ui.widget.roundlayout.CustomRoundImageView;
import com.larus.nova.R;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: classes24.dex */
public final class LarusLayoutRealtimeCallTopBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f290552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NoSpaceTextView f290553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f290554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SceneModeButton f290555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CustomRoundImageView f290556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LottieAdapterView f290557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AppCompatImageView f290558g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AppCompatImageView f290559h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f290560i;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f290552a;
    }

    public static LarusLayoutRealtimeCallTopBinding a(View r110) {
        int r100 = R.id.flashlightIcon;
        if (((ImageView) ViewBindings.findChildViewById(r110, R.id.flashlightIcon)) == null) goto L23;
        r100 = R.id.realtime_call_name;
        NoSpaceTextView r101 = (NoSpaceTextView) ViewBindings.findChildViewById(r110, R.id.realtime_call_name);
        if (r101 == null) goto L23;
        r100 = R.id.realtime_call_name_container;
        FrameLayout r102 = (FrameLayout) ViewBindings.findChildViewById(r110, R.id.realtime_call_name_container);
        if (r102 == null) goto L23;
        r100 = R.id.realtime_call_scene_button_top;
        SceneModeButton r103 = (SceneModeButton) ViewBindings.findChildViewById(r110, R.id.realtime_call_scene_button_top);
        if (r103 == null) goto L23;
        r100 = R.id.realtime_call_subtitle_button;
        CustomRoundImageView r104 = (CustomRoundImageView) ViewBindings.findChildViewById(r110, R.id.realtime_call_subtitle_button);
        if (r104 == null) goto L23;
        r100 = R.id.realtime_call_top_status_anim;
        LottieAdapterView r105 = (LottieAdapterView) ViewBindings.findChildViewById(r110, R.id.realtime_call_top_status_anim);
        if (r105 == null) goto L23;
        r100 = R.id.realtime_more;
        AppCompatImageView r106 = (AppCompatImageView) ViewBindings.findChildViewById(r110, R.id.realtime_more);
        if (r106 == null) goto L23;
        r100 = R.id.realtime_take_photo_on_left;
        AppCompatImageView r111 = (AppCompatImageView) ViewBindings.findChildViewById(r110, R.id.realtime_take_photo_on_left);
        if (r111 == null) goto L23;
        r100 = R.id.switchCamera;
        ImageView r112 = (ImageView) ViewBindings.findChildViewById(r110, R.id.switchCamera);
        if (r112 == null) goto L23;
        return new LarusLayoutRealtimeCallTopBinding(r110, r101, r102, r103, r104, r105, r106, r111, r112);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r110.getResources().getResourceName(r100)));
    }

    public LarusLayoutRealtimeCallTopBinding(View r100, NoSpaceTextView r101, FrameLayout r102, SceneModeButton r103, CustomRoundImageView r104, LottieAdapterView r105, AppCompatImageView r106, AppCompatImageView r107, ImageView r108) {
        this.f290552a = r100;
        this.f290553b = r101;
        this.f290554c = r102;
        this.f290555d = r103;
        this.f290556e = r104;
        this.f290557f = r105;
        this.f290558g = r106;
        this.f290559h = r107;
        this.f290560i = r108;
    }
}
