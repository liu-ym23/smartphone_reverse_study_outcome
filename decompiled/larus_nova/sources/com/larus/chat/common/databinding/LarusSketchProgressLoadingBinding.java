package com.larus.chat.common.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.chat.layout.holder.progressloading.ImageWebpLoadingBgView;
import com.larus.bmhome.chat.layout.holder.progressloading.RadiusCardView;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusSketchProgressLoadingBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RadiusCardView f324064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f324065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f324066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageWebpLoadingBgView f324067d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LottieAdapterView f324068e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f324064a;
    }

    public LarusSketchProgressLoadingBinding(RadiusCardView r100, TextView r101, TextView r102, ImageWebpLoadingBgView r103, LottieAdapterView r104) {
        this.f324064a = r100;
        this.f324065b = r101;
        this.f324066c = r102;
        this.f324067d = r103;
        this.f324068e = r104;
    }
}
