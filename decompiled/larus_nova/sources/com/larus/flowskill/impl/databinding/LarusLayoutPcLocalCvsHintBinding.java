package com.larus.flowskill.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusLayoutPcLocalCvsHintBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f343573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f343574b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f343573a;
    }

    public LarusLayoutPcLocalCvsHintBinding(ConstraintLayout r100, TextView r101) {
        this.f343573a = r100;
        this.f343574b = r101;
    }
}
