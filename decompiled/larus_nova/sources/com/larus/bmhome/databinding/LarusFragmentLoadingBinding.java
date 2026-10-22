package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusFragmentLoadingBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f310905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProgressBar f310906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ProgressBar f310907c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f310905a;
    }

    public LarusFragmentLoadingBinding(FrameLayout r100, ProgressBar r101, ProgressBar r102) {
        this.f310905a = r100;
        this.f310906b = r101;
        this.f310907c = r102;
    }
}
