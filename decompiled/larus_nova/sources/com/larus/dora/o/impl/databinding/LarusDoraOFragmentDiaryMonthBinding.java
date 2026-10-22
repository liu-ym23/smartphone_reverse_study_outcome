package com.larus.dora.o.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraOFragmentDiaryMonthBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f338432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f338433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OFloatingTitleBar f338434c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f338432a;
    }

    public LarusDoraOFragmentDiaryMonthBinding(ConstraintLayout r100, FrameLayout r101, OFloatingTitleBar r102) {
        this.f338432a = r100;
        this.f338433b = r101;
        this.f338434c = r102;
    }
}
