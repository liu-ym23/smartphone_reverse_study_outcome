package com.larus.avatar.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes23.dex */
public final class LarusDigitalAvatarMaterialTopViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f290768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f290769b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f290768a;
    }

    public LarusDigitalAvatarMaterialTopViewBinding(ConstraintLayout r100, ImageView r101, TextView r102) {
        this.f290768a = r100;
        this.f290769b = r102;
    }
}
