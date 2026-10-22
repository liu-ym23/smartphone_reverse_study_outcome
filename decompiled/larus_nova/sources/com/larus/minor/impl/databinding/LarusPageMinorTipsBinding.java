package com.larus.minor.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusPageMinorTipsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f359212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f359213b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f359212a;
    }

    public LarusPageMinorTipsBinding(ConstraintLayout r100, TextView r101, ImageView r102, TextView r103, TextView r104, ConstraintLayout r105, TextView r106) {
        this.f359212a = r100;
        this.f359213b = r105;
    }
}
