package com.larus.camera.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.camera.impl.ui.component.result.edu.EduResultTabView;
import com.larus.camera.impl.widget.EduPreviewLoadingView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutViewEduPreviewComponentBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f321518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f321519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EduPreviewLoadingView f321520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EduResultTabView f321521d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f321522e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f321523f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f321524g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f321518a;
    }

    public LarusLayoutViewEduPreviewComponentBinding(ConstraintLayout r100, FrameLayout r101, EduPreviewLoadingView r102, EduResultTabView r103, FrameLayout r104, TextView r105, TextView r106) {
        this.f321518a = r100;
        this.f321519b = r101;
        this.f321520c = r102;
        this.f321521d = r103;
        this.f321522e = r104;
        this.f321523f = r105;
        this.f321524g = r106;
    }
}
