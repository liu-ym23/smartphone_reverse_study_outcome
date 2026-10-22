package com.obric.miniapp.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;

/* JADX INFO: loaded from: classes33.dex */
public final class MiniAppActivityUserGuideBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f397610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f397611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f397612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RoundLinearLayout f397613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f397614e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f397610a;
    }

    public MiniAppActivityUserGuideBinding(ConstraintLayout r100, LinearLayout r101, LinearLayout r102, RoundLinearLayout r103, FrameLayout r104) {
        this.f397610a = r100;
        this.f397611b = r101;
        this.f397612c = r102;
        this.f397613d = r103;
        this.f397614e = r104;
    }
}
