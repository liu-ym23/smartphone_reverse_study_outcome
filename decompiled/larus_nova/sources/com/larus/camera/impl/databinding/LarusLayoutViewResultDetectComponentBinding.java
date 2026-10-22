package com.larus.camera.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.camera.impl.ui.component.result.general.ResultDetectAnimationView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutViewResultDetectComponentBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f321531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ResultDetectAnimationView f321532b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f321531a;
    }

    public LarusLayoutViewResultDetectComponentBinding(FrameLayout r100, ResultDetectAnimationView r101) {
        this.f321531a = r100;
        this.f321532b = r101;
    }
}
