package com.larus.login.impl.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusRequestLoadingPageBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f357623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f357624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ProgressBar f357625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Button f357626d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f357623a;
    }

    public LarusRequestLoadingPageBinding(ConstraintLayout r100, FrameLayout r101, ProgressBar r102, Button r103) {
        this.f357623a = r100;
        this.f357624b = r101;
        this.f357625c = r102;
        this.f357626d = r103;
    }
}
