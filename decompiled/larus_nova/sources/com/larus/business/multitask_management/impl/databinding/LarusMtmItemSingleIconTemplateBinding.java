package com.larus.business.multitask_management.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusMtmItemSingleIconTemplateBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f320840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f320841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f320842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f320843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f320844e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f320840a;
    }

    public LarusMtmItemSingleIconTemplateBinding(ConstraintLayout r100, FrameLayout r101, TextView r102, SimpleDraweeView r103, TextView r104) {
        this.f320840a = r100;
        this.f320841b = r101;
        this.f320842c = r102;
        this.f320843d = r103;
        this.f320844e = r104;
    }
}
