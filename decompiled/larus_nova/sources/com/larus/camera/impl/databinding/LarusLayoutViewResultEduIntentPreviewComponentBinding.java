package com.larus.camera.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.camera.impl.ui.component.result.edu.EduResultTabView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutViewResultEduIntentPreviewComponentBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f321533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f321534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EduResultTabView f321535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f321536d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f321533a;
    }

    public LarusLayoutViewResultEduIntentPreviewComponentBinding(ConstraintLayout r100, FrameLayout r101, EduResultTabView r102, TextView r103) {
        this.f321533a = r100;
        this.f321534b = r101;
        this.f321535c = r102;
        this.f321536d = r103;
    }
}
