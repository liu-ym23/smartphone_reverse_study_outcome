package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ScrollView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.view.DoraTextViewWithAnim;
import com.obric.oui.button.OButton;

/* JADX INFO: loaded from: classes27.dex */
public final class ObricDoraGOnboardingEnvObserveContentBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScrollView f333421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f333422b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f333421a;
    }

    public ObricDoraGOnboardingEnvObserveContentBinding(ScrollView r100, OButton r101, SimpleDraweeView r102, DoraTextViewWithAnim r103) {
        this.f333421a = r100;
        this.f333422b = r102;
    }
}
