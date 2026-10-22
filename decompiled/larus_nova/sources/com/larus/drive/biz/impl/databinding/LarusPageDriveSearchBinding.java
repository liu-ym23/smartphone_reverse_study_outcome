package com.larus.drive.biz.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusPageDriveSearchBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f341161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f341162b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f341161a;
    }

    public LarusPageDriveSearchBinding(ConstraintLayout r100, FrameLayout r101) {
        this.f341161a = r100;
        this.f341162b = r101;
    }
}
