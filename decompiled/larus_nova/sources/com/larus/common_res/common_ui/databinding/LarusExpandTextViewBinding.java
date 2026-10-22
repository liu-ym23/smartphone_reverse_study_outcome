package com.larus.common_res.common_ui.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusExpandTextViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f326706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f326707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f326708c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f326706a;
    }

    public LarusExpandTextViewBinding(ConstraintLayout r100, TextView r101, TextView r102) {
        this.f326706a = r100;
        this.f326707b = r101;
        this.f326708c = r102;
    }
}
