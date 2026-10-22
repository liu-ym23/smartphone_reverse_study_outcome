package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraOnboardingV2WelcomeBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f332847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f332848b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332847a;
    }

    public LarusDoraOnboardingV2WelcomeBinding(ConstraintLayout r100, ImageView r101, DoraTextView r102) {
        this.f332847a = r100;
        this.f332848b = r101;
    }
}
