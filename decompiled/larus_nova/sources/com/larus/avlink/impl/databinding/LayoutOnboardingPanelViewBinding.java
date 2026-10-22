package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes25.dex */
public final class LayoutOnboardingPanelViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f293321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f293322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f293323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f293324d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f293325e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f293321a;
    }

    public LayoutOnboardingPanelViewBinding(ConstraintLayout r100, TextView r101, ImageView r102, TextView r103, TextView r104) {
        this.f293321a = r100;
        this.f293322b = r101;
        this.f293323c = r102;
        this.f293324d = r103;
        this.f293325e = r104;
    }
}
