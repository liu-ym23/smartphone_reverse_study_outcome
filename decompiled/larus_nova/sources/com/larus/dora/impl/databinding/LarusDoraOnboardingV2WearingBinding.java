package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.dora.impl.view.DoraMovieView;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraOnboardingV2WearingBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f332845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DoraMovieView f332846b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332845a;
    }

    public LarusDoraOnboardingV2WearingBinding(ConstraintLayout r100, DoraMovieView r101) {
        this.f332845a = r100;
        this.f332846b = r101;
    }
}
