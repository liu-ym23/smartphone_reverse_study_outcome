package com.larus.home.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusLayoutUgEntranceFloatingViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f344340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoundLinearLayout f344341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f344342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f344343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatTextView f344344e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f344340a;
    }

    public LarusLayoutUgEntranceFloatingViewBinding(FrameLayout r100, RoundLinearLayout r101, AppCompatImageView r102, FrameLayout r103, AppCompatTextView r104) {
        this.f344340a = r100;
        this.f344341b = r101;
        this.f344342c = r102;
        this.f344343d = r103;
        this.f344344e = r104;
    }
}
