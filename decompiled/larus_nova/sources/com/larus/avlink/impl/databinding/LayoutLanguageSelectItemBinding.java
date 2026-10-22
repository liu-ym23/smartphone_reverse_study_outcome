package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes25.dex */
public final class LayoutLanguageSelectItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f293315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f293316b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f293315a;
    }

    public LayoutLanguageSelectItemBinding(ConstraintLayout r100, View r101, ImageView r102, TextView r103) {
        this.f293315a = r100;
        this.f293316b = r101;
    }
}
