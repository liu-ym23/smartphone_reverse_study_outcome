package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes25.dex */
public final class LayoutBottomControlViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f293277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Group f293278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f293279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f293280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f293281e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f293282f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f293277a;
    }

    public LayoutBottomControlViewBinding(ConstraintLayout r100, Group r101, ImageView r102, ImageView r103, ConstraintLayout r104, ConstraintLayout r105, TextView r106, TextView r107, TextView r108) {
        this.f293277a = r100;
        this.f293278b = r101;
        this.f293279c = r103;
        this.f293280d = r105;
        this.f293281e = r106;
        this.f293282f = r107;
    }
}
