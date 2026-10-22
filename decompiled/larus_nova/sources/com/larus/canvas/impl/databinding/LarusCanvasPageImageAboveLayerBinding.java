package com.larus.canvas.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusCanvasPageImageAboveLayerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f323750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f323751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ProgressBar f323752c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f323750a;
    }

    public LarusCanvasPageImageAboveLayerBinding(ConstraintLayout r100, LinearLayout r101, ProgressBar r102) {
        this.f323750a = r100;
        this.f323751b = r101;
        this.f323752c = r102;
    }
}
