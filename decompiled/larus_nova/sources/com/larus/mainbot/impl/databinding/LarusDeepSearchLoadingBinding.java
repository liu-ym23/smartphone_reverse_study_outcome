package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.roundlayout.RoundImageView;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusDeepSearchLoadingBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelativeLayout f358567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoundImageView f358568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LottieAdapterView f358569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f358570d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358567a;
    }

    public LarusDeepSearchLoadingBinding(RelativeLayout r100, RoundImageView r101, LottieAdapterView r102, TextView r103) {
        this.f358567a = r100;
        this.f358568b = r101;
        this.f358569c = r102;
        this.f358570d = r103;
    }
}
