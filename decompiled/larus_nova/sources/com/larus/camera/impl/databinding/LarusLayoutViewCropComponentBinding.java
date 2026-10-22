package com.larus.camera.impl.databinding;

import android.view.View;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.crop.ImageCropView;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusLayoutViewCropComponentBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f321515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Button f321516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageCropView f321517c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f321515a;
    }

    public LarusLayoutViewCropComponentBinding(ConstraintLayout r100, Button r101, ImageCropView r102) {
        this.f321515a = r100;
        this.f321516b = r101;
        this.f321517c = r102;
    }
}
