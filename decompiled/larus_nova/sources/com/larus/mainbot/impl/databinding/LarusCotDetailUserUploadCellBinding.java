package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusCotDetailUserUploadCellBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f358562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f358563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f358564c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358562a;
    }

    public LarusCotDetailUserUploadCellBinding(ConstraintLayout r100, TextView r101, FrameLayout r102) {
        this.f358562a = r100;
        this.f358563b = r101;
        this.f358564c = r102;
    }
}
