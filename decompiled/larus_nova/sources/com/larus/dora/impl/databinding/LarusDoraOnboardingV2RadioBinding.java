package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.dora.impl.view.DoraMovieView;
import com.larus.dora.impl.view.DoraUrlSpanTextView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraOnboardingV2RadioBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f332828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DoraMovieView f332829b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332828a;
    }

    public LarusDoraOnboardingV2RadioBinding(ConstraintLayout r100, DoraUrlSpanTextView r101, DoraMovieView r102) {
        this.f332828a = r100;
        this.f332829b = r102;
    }
}
