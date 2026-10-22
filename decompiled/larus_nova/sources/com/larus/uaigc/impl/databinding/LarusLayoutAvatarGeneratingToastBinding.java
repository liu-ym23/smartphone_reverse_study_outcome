package com.larus.uaigc.impl.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusLayoutAvatarGeneratingToastBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoundLinearLayout f373209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LottieAdapterView f373210b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f373209a;
    }

    public LarusLayoutAvatarGeneratingToastBinding(RoundLinearLayout r100, LottieAdapterView r101) {
        this.f373209a = r100;
        this.f373210b = r101;
    }
}
