package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraDeviceBatteryLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayoutCompat f332361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayoutCompat f332362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LottieAdapterView f332363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f332364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f332365e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332361a;
    }

    public static LarusDoraDeviceBatteryLayoutBinding a(View r100) {
        LinearLayoutCompat r101 = (LinearLayoutCompat) r100;
        int r102 = R.id.dora_onboarding_battery_progress;
        LottieAdapterView r103 = (LottieAdapterView) ViewBindings.findChildViewById(r100, R.id.dora_onboarding_battery_progress);
        if (r103 == null) goto L11;
        r102 = R.id.dora_onboarding_battery_progress_none;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(r100, R.id.dora_onboarding_battery_progress_none);
        if (r104 == null) goto L11;
        r102 = R.id.dora_onboarding_battery_text;
        AppCompatTextView r105 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.dora_onboarding_battery_text);
        if (r105 == null) goto L11;
        return new LarusDoraDeviceBatteryLayoutBinding(r101, r101, r103, r104, r105);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r102)));
    }

    public LarusDoraDeviceBatteryLayoutBinding(LinearLayoutCompat r100, LinearLayoutCompat r101, LottieAdapterView r102, ImageView r103, AppCompatTextView r104) {
        this.f332361a = r100;
        this.f332362b = r101;
        this.f332363c = r102;
        this.f332364d = r103;
        this.f332365e = r104;
    }
}
