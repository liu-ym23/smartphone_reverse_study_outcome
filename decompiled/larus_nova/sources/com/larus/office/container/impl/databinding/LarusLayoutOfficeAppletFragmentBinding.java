package com.larus.office.container.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.office.base.view.DocLoadAndErrorLayout;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusLayoutOfficeAppletFragmentBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f362140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f362141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DocLoadAndErrorLayout f362142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f362143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f362144e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f362140a;
    }

    public LarusLayoutOfficeAppletFragmentBinding(ConstraintLayout r100, FrameLayout r101, DocLoadAndErrorLayout r102, ConstraintLayout r103, FrameLayout r104) {
        this.f362140a = r100;
        this.f362141b = r101;
        this.f362142c = r102;
        this.f362143d = r103;
        this.f362144e = r104;
    }
}
