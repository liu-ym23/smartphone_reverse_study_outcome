package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.ShadowLayout;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraItemNewcomerGuideBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f332717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f332718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f332719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ShadowLayout f332720d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332717a;
    }

    public LarusDoraItemNewcomerGuideBinding(ConstraintLayout r100, TextView r101, ConstraintLayout r102, ShadowLayout r103) {
        this.f332717a = r100;
        this.f332718b = r101;
        this.f332719c = r102;
        this.f332720d = r103;
    }
}
