package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes25.dex */
public final class LayoutTranslateResultItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f293367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f293368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f293369c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f293367a;
    }

    public LayoutTranslateResultItemBinding(ConstraintLayout r100, TextView r101, TextView r102) {
        this.f293367a = r100;
        this.f293368b = r101;
        this.f293369c = r102;
    }
}
