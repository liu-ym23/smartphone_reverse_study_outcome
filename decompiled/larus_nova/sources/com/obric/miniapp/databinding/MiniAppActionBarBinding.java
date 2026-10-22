package com.obric.miniapp.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes33.dex */
public final class MiniAppActionBarBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f397606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f397607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f397608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f397609d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f397606a;
    }

    public MiniAppActionBarBinding(ConstraintLayout r100, ConstraintLayout r101, ConstraintLayout r102, ImageView r103, ImageView r104, View r105) {
        this.f397606a = r100;
        this.f397607b = r103;
        this.f397608c = r104;
        this.f397609d = r105;
    }
}
