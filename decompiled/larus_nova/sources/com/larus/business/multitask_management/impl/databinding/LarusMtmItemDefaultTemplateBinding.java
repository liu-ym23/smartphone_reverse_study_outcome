package com.larus.business.multitask_management.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.CircleProgressBar;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusMtmItemDefaultTemplateBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f320829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f320830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CircleProgressBar f320831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f320832d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f320833e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f320834f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f320829a;
    }

    public LarusMtmItemDefaultTemplateBinding(ConstraintLayout r100, TextView r101, CircleProgressBar r102, ImageView r103, FrameLayout r104, TextView r105) {
        this.f320829a = r100;
        this.f320830b = r101;
        this.f320831c = r102;
        this.f320832d = r103;
        this.f320833e = r104;
        this.f320834f = r105;
    }
}
