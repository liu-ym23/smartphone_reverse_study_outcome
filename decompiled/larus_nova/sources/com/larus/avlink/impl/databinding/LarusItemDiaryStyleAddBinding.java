package com.larus.avlink.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes25.dex */
public final class LarusItemDiaryStyleAddBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f293222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f293223b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f293222a;
    }

    public LarusItemDiaryStyleAddBinding(ConstraintLayout r100, TextView r101) {
        this.f293222a = r100;
        this.f293223b = r101;
    }
}
