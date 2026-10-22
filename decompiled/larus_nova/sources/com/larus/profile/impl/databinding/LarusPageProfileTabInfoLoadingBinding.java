package com.larus.profile.impl.databinding;

import android.view.View;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusPageProfileTabInfoLoadingBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f366516a;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f366516a;
    }

    public LarusPageProfileTabInfoLoadingBinding(ConstraintLayout r100) {
        this.f366516a = r100;
    }

    public static LarusPageProfileTabInfoLoadingBinding a(View r100) {
        if (((ProgressBar) ViewBindings.findChildViewById(r100, R.id.loading)) == null) goto L7;
        return new LarusPageProfileTabInfoLoadingBinding((ConstraintLayout) r100);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(R.id.loading)));
    }
}
